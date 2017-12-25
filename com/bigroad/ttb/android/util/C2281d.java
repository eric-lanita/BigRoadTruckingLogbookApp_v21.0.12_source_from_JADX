package com.bigroad.ttb.android.util;

import android.bluetooth.BluetoothDevice;
import com.bigroad.shared.am;

public abstract class C2281d {
    public static String m11194a(BluetoothDevice bluetoothDevice) {
        try {
            return am.m4185a(bluetoothDevice.getName());
        } catch (NullPointerException e) {
            return "";
        }
    }
}
