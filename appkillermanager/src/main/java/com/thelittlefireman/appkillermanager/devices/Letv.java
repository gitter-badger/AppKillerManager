package com.thelittlefireman.appkillermanager.devices;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import com.thelittlefireman.appkillermanager.utils.ActionsUtils;
import com.thelittlefireman.appkillermanager.utils.Manufacturer;

public class Letv implements DeviceBase {
    @Override
    public boolean isThatRom() {
        return Build.BRAND.equalsIgnoreCase(getDeviceManufacturer().toString()) ||
                Build.MANUFACTURER.equalsIgnoreCase(getDeviceManufacturer().toString()) ||
                Build.FINGERPRINT.toLowerCase().contains(getDeviceManufacturer().toString());
    }

    @Override
    public Manufacturer getDeviceManufacturer() {
        return Manufacturer.LETV;
    }

    @Override
    public Intent getActionPowerSaving(Context context) {
        Intent intent = ActionsUtils.createIntent();
        intent.setComponent(
                new ComponentName("com.letv.android.letvsafe",
                                  "com.letv.android.letvsafe.BackgroundAppManageActivity"));
        return intent;
    }

    @Override
    public Intent getActionAutoStart(Context context) {
        Intent intent = ActionsUtils.createIntent();
        intent.setComponent(
                new ComponentName("com.letv.android.letvsafe",
                                  "com.letv.android.letvsafe.AutobootManageActivity"));
        return intent;
    }

    @Override
    public Intent getActionNotification(Context context) {
        return null;
    }

    @Override
    public String getExtraDebugInformations(Context context) {
        return null;
    }

    @Override
    public int getHelpImage() {
        return 0;
    }
}
