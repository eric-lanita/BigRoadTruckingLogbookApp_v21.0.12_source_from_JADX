package com.bigroad.ttb.android.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.logging.C2134e;

public class ConnectivityReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (action == null) {
                return;
            }
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                OurApplication.m6244A().m6109a();
            } else {
                C2134e.m10680d("TT-ConnRecvr", "Ignoring unexpected action: " + action);
            }
        }
    }
}
