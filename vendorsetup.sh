rm -rf hardware/qcom-caf/sm8350/display
git clone https://github.com/Evolution-X/hardware_qcom-caf_sm8350_display hardware/qcom-caf/sm8350/display
git clone --depth=1 https://gitlab.com/ThePrateekBhatia/vendor-xiaomi-veux.git vendor/xiaomi/veux
git clone --depth=1 https://github.com/ThePrateekBhatia/kernel_xiaomi_sm6375.git kernel/xiaomi/sm6375
git clone https://github.com/LineageOS/android_hardware_lineage_compat.git -b lineage-21.0 hardware/lineage/compat
echo 'Completed, now you can proceed to lunch..!'