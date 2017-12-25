package com.urbanairship.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.urbanairship.C1187d;
import com.urbanairship.C3783j;
import com.urbanairship.C3929q;
import com.urbanairship.util.C3954i;

public class InstallReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        C1187d.m6035c(context);
        if (C3929q.m20384j() || C3929q.m20383i()) {
            String stringExtra = intent.getStringExtra("referrer");
            if (C3954i.m20512a(stringExtra) || !"com.android.vending.INSTALL_REFERRER".equals(intent.getAction())) {
                C3783j.m19725c("InstallReceiver - missing referrer or invalid action.");
                return;
            }
            C3929q.m20372a().m20394r().m19455a(new C3749m(stringExtra));
            return;
        }
        C3783j.m19728e("InstallReceiver - unable to track install referrer, takeOff not called.");
    }
}
