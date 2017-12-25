package com.google.android.gms.analytics.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.common.internal.zzab;

public class zzv extends zzd {
    private boolean f10379a;
    private boolean f10380b;
    private AlarmManager f10381c = ((AlarmManager) m16540g().getSystemService("alarm"));

    protected zzv(zzf com_google_android_gms_analytics_internal_zzf) {
        super(com_google_android_gms_analytics_internal_zzf);
    }

    private PendingIntent m16721b() {
        Intent intent = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
        intent.setComponent(new ComponentName(m16540g(), "com.google.android.gms.analytics.AnalyticsReceiver"));
        return PendingIntent.getBroadcast(m16540g(), 0, intent, 0);
    }

    protected void mo1605a() {
        try {
            this.f10381c.cancel(m16721b());
            if (m16542i().zzabl() > 0) {
                ActivityInfo receiverInfo = m16540g().getPackageManager().getReceiverInfo(new ComponentName(m16540g(), "com.google.android.gms.analytics.AnalyticsReceiver"), 2);
                if (receiverInfo != null && receiverInfo.enabled) {
                    zzeh("Receiver registered. Using alarm for local dispatch.");
                    this.f10379a = true;
                }
            }
        } catch (NameNotFoundException e) {
        }
    }

    public void cancel() {
        m16553s();
        this.f10380b = false;
        this.f10381c.cancel(m16721b());
    }

    public void schedule() {
        m16553s();
        zzab.zza(zzacm(), (Object) "Receiver not registered");
        long zzabl = m16542i().zzabl();
        if (zzabl > 0) {
            cancel();
            long elapsedRealtime = m16539f().elapsedRealtime() + zzabl;
            this.f10380b = true;
            this.f10381c.setInexactRepeating(2, elapsedRealtime, 0, m16721b());
        }
    }

    public boolean zzacm() {
        return this.f10379a;
    }

    public boolean zzfc() {
        return this.f10380b;
    }
}
