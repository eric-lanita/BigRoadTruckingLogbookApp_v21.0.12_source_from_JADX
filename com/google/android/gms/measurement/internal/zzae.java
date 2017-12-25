package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzvw;

public final class zzae {
    private static Boolean f12216d;
    private final Handler f12217a = new Handler();
    private final Context f12218b;
    private final zza f12219c;

    public interface zza {
        boolean callServiceStopSelfResult(int i);

        Context getContext();
    }

    public zzae(zza com_google_android_gms_measurement_internal_zzae_zza) {
        this.f12218b = com_google_android_gms_measurement_internal_zzae_zza.getContext();
        zzab.zzy(this.f12218b);
        this.f12219c = com_google_android_gms_measurement_internal_zzae_zza;
    }

    private void m17778a() {
        try {
            synchronized (zzu.f12350a) {
                zzvw com_google_android_gms_internal_zzvw = zzu.f12351b;
                if (com_google_android_gms_internal_zzvw != null && com_google_android_gms_internal_zzvw.isHeld()) {
                    com_google_android_gms_internal_zzvw.release();
                }
            }
        } catch (SecurityException e) {
        }
    }

    private zzp m17780b() {
        return zzx.zzdo(this.f12218b).zzbsd();
    }

    public static boolean zzaw(Context context) {
        zzab.zzy(context);
        if (f12216d != null) {
            return f12216d.booleanValue();
        }
        boolean zzj = zzal.zzj(context, "com.google.android.gms.measurement.AppMeasurementService");
        f12216d = Boolean.valueOf(zzj);
        return zzj;
    }

    public IBinder onBind(Intent intent) {
        if (intent == null) {
            m17780b().zzbsv().log("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzy(zzx.zzdo(this.f12218b));
        }
        m17780b().zzbsx().zzj("onBind received unknown action", action);
        return null;
    }

    public void onCreate() {
        zzx zzdo = zzx.zzdo(this.f12218b);
        zzp zzbsd = zzdo.zzbsd();
        if (zzdo.zzbsf().zzabc()) {
            zzbsd.zzbtc().log("Device AppMeasurementService is starting up");
        } else {
            zzbsd.zzbtc().log("Local AppMeasurementService is starting up");
        }
    }

    public void onDestroy() {
        zzx zzdo = zzx.zzdo(this.f12218b);
        zzp zzbsd = zzdo.zzbsd();
        if (zzdo.zzbsf().zzabc()) {
            zzbsd.zzbtc().log("Device AppMeasurementService is shutting down");
        } else {
            zzbsd.zzbtc().log("Local AppMeasurementService is shutting down");
        }
    }

    public void onRebind(Intent intent) {
        if (intent == null) {
            m17780b().zzbsv().log("onRebind called with null intent");
            return;
        }
        m17780b().zzbtc().zzj("onRebind called. action", intent.getAction());
    }

    public int onStartCommand(Intent intent, int i, final int i2) {
        m17778a();
        final zzx zzdo = zzx.zzdo(this.f12218b);
        final zzp zzbsd = zzdo.zzbsd();
        if (intent == null) {
            zzbsd.zzbsx().log("AppMeasurementService started with null intent");
        } else {
            String action = intent.getAction();
            if (zzdo.zzbsf().zzabc()) {
                zzbsd.zzbtc().zze("Device AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
            } else {
                zzbsd.zzbtc().zze("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
            }
            if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
                zzdo.zzbsc().zzm(new Runnable(this) {
                    final /* synthetic */ zzae f12215d;

                    class C33951 implements Runnable {
                        final /* synthetic */ C33961 f12211a;

                        C33951(C33961 c33961) {
                            this.f12211a = c33961;
                        }

                        public void run() {
                            if (!this.f12211a.f12215d.f12219c.callServiceStopSelfResult(i2)) {
                                return;
                            }
                            if (zzdo.zzbsf().zzabc()) {
                                zzbsd.zzbtc().log("Device AppMeasurementService processed last upload request");
                            } else {
                                zzbsd.zzbtc().log("Local AppMeasurementService processed last upload request");
                            }
                        }
                    }

                    public void run() {
                        zzdo.m18003m();
                        zzdo.zzbuc();
                        this.f12215d.f12217a.post(new C33951(this));
                    }
                });
            }
        }
        return 2;
    }

    public boolean onUnbind(Intent intent) {
        if (intent == null) {
            m17780b().zzbsv().log("onUnbind called with null intent");
        } else {
            m17780b().zzbtc().zzj("onUnbind called for intent. action", intent.getAction());
        }
        return true;
    }
}
