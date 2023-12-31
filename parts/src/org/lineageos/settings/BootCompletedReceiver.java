/*
 * Copyright (C) 2015 The CyanogenMod Project
 *               2017-2020 The LineageOS Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.lineageos.settings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

<<<<<<< HEAD
=======
import org.lineageos.settings.camera.NfcCameraService;
import org.lineageos.settings.display.ColorService;
import org.lineageos.settings.dolby.DolbyUtils;
import org.lineageos.settings.doze.AodBrightnessService;
import org.lineageos.settings.doze.DozeUtils;
import org.lineageos.settings.doze.PocketService;
import org.lineageos.settings.gestures.GestureUtils;
import org.lineageos.settings.refreshrate.RefreshUtils;
>>>>>>> f24c282 (marble: Import dolby audio)
import org.lineageos.settings.thermal.ThermalUtils;

public class BootCompletedReceiver extends BroadcastReceiver {
    private static final boolean DEBUG = false;
    private static final String TAG = "XiaomiParts";

    @Override
    public void onReceive(final Context context, Intent intent) {
        if (!intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {
            return;
        }
<<<<<<< HEAD
        if (DEBUG) Log.d(TAG, "Received boot completed intent");
=======
    }

    private static void onLockedBootCompleted(Context context) {
        // Services that don't require reading from data.
        ColorService.startService(context);
        AodBrightnessService.startService(context);
        PocketService.startService(context);
        NfcCameraService.startService(context);
        HighTouchPollingService.startService(context);
        TouchOrientationService.startService(context);
        overrideHdrTypes(context);
    }

    private static void onBootCompleted(Context context) {
        // Data is now accessible (user has just unlocked).
        DolbyUtils.getInstance(context).onBootCompleted();
        DozeUtils.checkDozeService(context);
        RefreshUtils.initialize(context);
>>>>>>> f24c282 (marble: Import dolby audio)
        ThermalUtils.startService(context);
    }
}
