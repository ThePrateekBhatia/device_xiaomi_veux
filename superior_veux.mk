#
# Copyright (C) 2023 The LineageOS Project
#				2024 The SuperiorOS Project
#
# SPDX-License-Identifier: Apache-2.0
#
# Inherit from those products. Most specific first.
$(call inherit-product, $(SRC_TARGET_DIR)/product/core_64_bit.mk)
$(call inherit-product, $(SRC_TARGET_DIR)/product/full_base_telephony.mk)

TARGET_FACE_UNLOCK_SUPPORTED := true
TARGET_USES_AOSP_RECOVERY := true
TARGET_BOOT_ANIMATION_RES := 1080
TARGET_SUPPORTS_GOOGLE_RECORDER := true
TARGET_INCLUDE_LIVE_WALLPAPERS := false
TARGET_SUPPORTS_QUICK_TAP := true
TARGET_SHIPS_PREBUILT_GCAM := true
TARGET_INCLUDE_MATLOG := false
USE_MOTO_CALCULATOR := false
TARGET_SUPPORTS_BLUR := true
SUPERIOR_UDFPS_ANIMATIONS := false
USE_MOTO_CLOCK := false
SYSTEM_OPTIMIZE_JAVA := true
SYSTEMUI_OPTIMIZE_JAVA := true
BUILD_WITH_GAPPS := true
USE_DUCKDUCKGO := false
USE_ViaBrowser := false
TARGET_BUILD_VIMUSIC := false

# Inherit from veux device
$(call inherit-product, device/xiaomi/veux/device.mk)

# Inherit some common Superior OS Project
$(call inherit-product, vendor/superior/config/common.mk)

PRODUCT_NAME := superior_veux
PRODUCT_DEVICE := veux
PRODUCT_MANUFACTURER := Xiaomi
PRODUCT_BRAND := POCO
PRODUCT_MODEL := POCO X4 Pro 5G

PRODUCT_GMS_CLIENTID_BASE := android-xiaomi
