package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzvw;

public final class zzak {
    private static Boolean f10270d;
    private final Handler f10271a = new Handler();
    private final zza f10272b;
    private final Context f10273c;

    public interface zza {
        boolean callServiceStopSelfResult(int i);

        Context getContext();
    }

    public zzak(zza com_google_android_gms_analytics_internal_zzak_zza) {
        this.f10273c = com_google_android_gms_analytics_internal_zzak_zza.getContext();
        zzab.zzy(this.f10273c);
        this.f10272b = com_google_android_gms_analytics_internal_zzak_zza;
    }

    private void m16630a() {
        try {
            synchronized (zzaj.f10262a) {
                zzvw com_google_android_gms_internal_zzvw = zzaj.f10263b;
                if (com_google_android_gms_internal_zzvw != null && com_google_android_gms_internal_zzvw.isHeld()) {
                    com_google_android_gms_internal_zzvw.release();
                }
            }
        } catch (SecurityException e) {
        }
    }

    public static boolean zzaw(Context context) {
        zzab.zzy(context);
        if (f10270d != null) {
            return f10270d.booleanValue();
        }
        boolean zzj = zzao.zzj(context, "com.google.android.gms.analytics.AnalyticsService");
        f10270d = Boolean.valueOf(zzj);
        return zzj;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        zzf zzay = zzf.zzay(this.f10273c);
        zzaf zzyx = zzay.zzyx();
        if (zzay.zzyy().zzabc()) {
            zzyx.zzeh("Device AnalyticsService is starting up");
        } else {
            zzyx.zzeh("Local AnalyticsService is starting up");
        }
    }

    public void onDestroy() {
        zzf zzay = zzf.zzay(this.f10273c);
        zzaf zzyx = zzay.zzyx();
        if (zzay.zzyy().zzabc()) {
            zzyx.zzeh("Device AnalyticsService is shutting down");
        } else {
            zzyx.zzeh("Local AnalyticsService is shutting down");
        }
    }

    public int onStartCommand(Intent intent, int i, final int i2) {
        m16630a();
        final zzf zzay = zzf.zzay(this.f10273c);
        final zzaf zzyx = zzay.zzyx();
        if (intent == null) {
            zzyx.zzek("AnalyticsService started with null intent");
        } else {
            String action = intent.getAction();
            if (zzay.zzyy().zzabc()) {
                zzyx.zza("Device AnalyticsService called. startId, action", Integer.valueOf(i2), action);
            } else {
                zzyx.zza("Local AnalyticsService called. startId, action", Integer.valueOf(i2), action);
            }
            if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
                zzay.zzwd().zza(new zzw(this) {
                    final /* synthetic */ zzak f10269d;

                    class C31841 implements Runnable {
                        final /* synthetic */ C31851 f10265a;

                        C31841(C31851 c31851) {
                            this.f10265a = c31851;
                        }

                        public void run() {
                            if (!this.f10265a.f10269d.f10272b.callServiceStopSelfResult(i2)) {
                                return;
                            }
                            if (zzay.zzyy().zzabc()) {
                                zzyx.zzeh("Device AnalyticsService processed last dispatch request");
                            } else {
                                zzyx.zzeh("Local AnalyticsService processed last dispatch request");
                            }
                        }
                    }

                    public void zzd(Throwable th) {
                        this.f10269d.f10271a.post(new C31841(this));
                    }
                });
            }
        }
        return 2;
    }
}
