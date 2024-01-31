/*
 * Copyright (C) 2022 The LineageOS Project
 *
 * SPDX-License-Identifier: Apache-2.0
 */

#include <android-base/logging.h>
#include <android-base/properties.h>

#include <libinit_utils.h>
#include <libinit_variant.h>

using android::base::GetProperty;

#define HWC_PROP "ro.boot.hwc"
#define MODEL_PROP "ro.boot.board_id"
#define SKU_PROP "ro.boot.product.hardware.sku"

void search_variant(const std::vector<variant_info_t> variants) {
    std::string hwc_value = GetProperty(HWC_PROP, "");
    std::string model_value = GetProperty(MODEL_PROP, "");
    bool devicefound = false;
    variant_info_t globalvariant;

    for (const auto& variant : variants) {
        if ((variant.hwc_value == "" || variant.hwc_value == hwc_value) &&
            (variant.model_value == "" || variant.model_value == model_value)) {
            devicefound = true;
            set_variant_props(variant);
            break;
        }
        if (variant.hwc_value == "GLOBAL")
            globalvariant = variant;
    }
    if (!devicefound && globalvariant.hwc_value == "GLOBAL")
        set_variant_props(globalvariant);
}

void set_variant_props(const variant_info_t variant) {
    set_ro_build_prop("brand", variant.brand, true);
    set_ro_build_prop("device", variant.device, true);
    set_ro_build_prop("marketname", variant.marketname, true);
    set_ro_build_prop("model", variant.model, true);
    set_ro_build_prop("name", variant.name, true);
    property_override("vendor.usb.product_string", variant.marketname, true);
    property_override("ro.product.mod_device", variant.name);

    if (access("/system/bin/recovery", F_OK) != 0) {
        set_ro_build_prop("fingerprint", variant.build_fingerprint);
        property_override("ro.bootimage.build.fingerprint", variant.build_fingerprint);
        property_override("ro.build.description", fingerprint_to_description(variant.build_fingerprint));
        property_override("bluetooth.device.default_name", variant.marketname, true);
    }

    if (variant.nfc)
        property_override(SKU_PROP, "nfc");
}
