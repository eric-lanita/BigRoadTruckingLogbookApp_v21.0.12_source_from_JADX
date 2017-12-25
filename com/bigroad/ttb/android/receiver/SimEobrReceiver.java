package com.bigroad.ttb.android.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bigroad.shared.am;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.eobr.C1904g;
import com.bigroad.ttb.android.logging.C2134e;

public class SimEobrReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String a = am.m4185a(intent.getAction());
            if ("com.bigroad.ttb.android.SIM_EOBR".equals(a)) {
                C2134e.m10678c("TT-SimEobrRecvr", "Received simulated EOBR intent");
                OurApplication.m6252I().m11402a(true);
                C1904g.m9313a(context).m9317a(intent.getExtras());
                OurApplication.m6251H().m9126e();
                return;
            }
            C2134e.m10680d("TT-SimEobrRecvr", "Ignoring unexpected action: " + a);
        }
    }
}
