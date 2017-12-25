package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzao;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzvw;

public class CampaignTrackingReceiver extends BroadcastReceiver {
    static Object f10149a = new Object();
    static zzvw f10150b;
    static Boolean f10151c;

    public static boolean zzav(Context context) {
        zzab.zzy(context);
        if (f10151c != null) {
            return f10151c.booleanValue();
        }
        boolean zzb = zzao.zzb(context, "com.google.android.gms.analytics.CampaignTrackingReceiver", true);
        f10151c = Boolean.valueOf(zzb);
        return zzb;
    }

    protected Class<? extends CampaignTrackingService> mo2426a() {
        return CampaignTrackingService.class;
    }

    protected void mo2427a(Context context, String str) {
    }

    public void onReceive(Context context, Intent intent) {
        zzf zzay = zzf.zzay(context);
        zzaf zzyx = zzay.zzyx();
        if (intent == null) {
            zzyx.zzek("CampaignTrackingReceiver received null intent");
            return;
        }
        String stringExtra = intent.getStringExtra("referrer");
        String action = intent.getAction();
        zzyx.zza("CampaignTrackingReceiver received", action);
        if (!"com.android.vending.INSTALL_REFERRER".equals(action) || TextUtils.isEmpty(stringExtra)) {
            zzyx.zzek("CampaignTrackingReceiver received unexpected intent without referrer extra");
            return;
        }
        boolean zzaw = CampaignTrackingService.zzaw(context);
        if (!zzaw) {
            zzyx.zzek("CampaignTrackingService not registered or disabled. Installation tracking not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
        mo2427a(context, stringExtra);
        if (zzay.zzyy().zzabc()) {
            zzyx.zzel("Received unexpected installation campaign on package side");
            return;
        }
        Class a = mo2426a();
        zzab.zzy(a);
        Intent intent2 = new Intent(context, a);
        intent2.putExtra("referrer", stringExtra);
        synchronized (f10149a) {
            context.startService(intent2);
            if (zzaw) {
                try {
                    if (f10150b == null) {
                        f10150b = new zzvw(context, 1, "Analytics campaign WakeLock");
                        f10150b.setReferenceCounted(false);
                    }
                    f10150b.acquire(1000);
                } catch (SecurityException e) {
                    zzyx.zzek("CampaignTrackingService service at risk of not starting. For more reliable installation campaign reports, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
                }
                return;
            }
        }
    }
}
