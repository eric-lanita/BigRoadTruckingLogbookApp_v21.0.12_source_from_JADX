package com.bigroad.ttb.android.receiver;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.logging.C2134e;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BluetoothReceiver extends BroadcastReceiver {
    private static final Set<String> f7728a = new HashSet(Arrays.asList(new String[]{"android.bluetooth.device.action.FOUND", "android.bluetooth.device.action.BOND_STATE_CHANGED", "android.bluetooth.device.action.CLASS_CHANGED", "android.bluetooth.device.action.NAME_CHANGED"}));

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (action == null) {
                return;
            }
            if (action.equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                OurApplication.m6250G().m6058a();
            } else if (action.equals("android.bluetooth.adapter.action.DISCOVERY_STARTED")) {
                OurApplication.m6250G().m6061b();
            } else if (action.equals("android.bluetooth.adapter.action.DISCOVERY_FINISHED")) {
                OurApplication.m6250G().m6062c();
            } else if (f7728a.contains(action)) {
                OurApplication.m6250G().m6059a((BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE"), intent.getShortExtra("android.bluetooth.device.extra.RSSI", Short.MIN_VALUE));
            } else {
                C2134e.m10680d("TT-BtRecvr", "Ignoring unexpected action: " + action);
            }
        }
    }
}
