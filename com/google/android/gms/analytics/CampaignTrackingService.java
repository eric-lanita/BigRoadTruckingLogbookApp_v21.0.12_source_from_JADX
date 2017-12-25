package com.google.android.gms.analytics;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzao;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzvw;

public class CampaignTrackingService extends Service {
    private static Boolean f10163b;
    private Handler f10164a;

    private void m16512a() {
        try {
            synchronized (CampaignTrackingReceiver.f10149a) {
                zzvw com_google_android_gms_internal_zzvw = CampaignTrackingReceiver.f10150b;
                if (com_google_android_gms_internal_zzvw != null && com_google_android_gms_internal_zzvw.isHeld()) {
                    com_google_android_gms_internal_zzvw.release();
                }
            }
        } catch (SecurityException e) {
        }
    }

    private Handler m16513b() {
        Handler handler = this.f10164a;
        if (handler != null) {
            return handler;
        }
        handler = new Handler(getMainLooper());
        this.f10164a = handler;
        return handler;
    }

    public static boolean zzaw(Context context) {
        zzab.zzy(context);
        if (f10163b != null) {
            return f10163b.booleanValue();
        }
        boolean zzj = zzao.zzj(context, "com.google.android.gms.analytics.CampaignTrackingService");
        f10163b = Boolean.valueOf(zzj);
        return zzj;
    }

    protected void m16514a(final zzaf com_google_android_gms_analytics_internal_zzaf, Handler handler, final int i) {
        handler.post(new Runnable(this) {
            final /* synthetic */ CampaignTrackingService f10162c;

            public void run() {
                boolean stopSelfResult = this.f10162c.stopSelfResult(i);
                if (stopSelfResult) {
                    com_google_android_gms_analytics_internal_zzaf.zza("Install campaign broadcast processed", Boolean.valueOf(stopSelfResult));
                }
            }
        });
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        zzf.zzay(this).zzyx().zzeh("CampaignTrackingService is starting up");
    }

    public void onDestroy() {
        zzf.zzay(this).zzyx().zzeh("CampaignTrackingService is shutting down");
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, final int i2) {
        m16512a();
        zzf zzay = zzf.zzay(this);
        final zzaf zzyx = zzay.zzyx();
        String str = null;
        if (zzay.zzyy().zzabc()) {
            zzyx.zzel("Unexpected installation campaign (package side)");
        } else {
            str = intent.getStringExtra("referrer");
        }
        final Handler b = m16513b();
        if (TextUtils.isEmpty(str)) {
            if (!zzay.zzyy().zzabc()) {
                zzyx.zzek("No campaign found on com.android.vending.INSTALL_REFERRER \"referrer\" extra");
            }
            zzay.zzyz().zzg(new Runnable(this) {
                final /* synthetic */ CampaignTrackingService f10155d;

                public void run() {
                    this.f10155d.m16514a(zzyx, b, i2);
                }
            });
        } else {
            int zzabg = zzay.zzyy().zzabg();
            if (str.length() > zzabg) {
                zzyx.zzc("Campaign data exceed the maximum supported size and will be clipped. size, limit", Integer.valueOf(str.length()), Integer.valueOf(zzabg));
                str = str.substring(0, zzabg);
            }
            zzyx.zza("CampaignTrackingService called. startId, campaign", Integer.valueOf(i2), str);
            zzay.zzwd().zza(str, new Runnable(this) {
                final /* synthetic */ CampaignTrackingService f10159d;

                public void run() {
                    this.f10159d.m16514a(zzyx, b, i2);
                }
            });
        }
        return 2;
    }
}
