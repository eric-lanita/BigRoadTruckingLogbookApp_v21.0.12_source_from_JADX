package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.zzab;

class zzr extends BroadcastReceiver {
    static final String f12316a = zzr.class.getName();
    private final zzx f12317b;
    private boolean f12318c;
    private boolean f12319d;

    zzr(zzx com_google_android_gms_measurement_internal_zzx) {
        zzab.zzy(com_google_android_gms_measurement_internal_zzx);
        this.f12317b = com_google_android_gms_measurement_internal_zzx;
    }

    private Context m17910a() {
        return this.f12317b.getContext();
    }

    private zzp m17912b() {
        return this.f12317b.zzbsd();
    }

    public boolean isRegistered() {
        this.f12317b.zzwu();
        return this.f12318c;
    }

    public void onReceive(Context context, Intent intent) {
        this.f12317b.m17976a();
        String action = intent.getAction();
        m17912b().zzbtc().zzj("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            final boolean zzadj = this.f12317b.zzbts().zzadj();
            if (this.f12319d != zzadj) {
                this.f12319d = zzadj;
                this.f12317b.zzbsc().zzm(new Runnable(this) {
                    final /* synthetic */ zzr f12315b;

                    public void run() {
                        this.f12315b.f12317b.zzas(zzadj);
                    }
                });
                return;
            }
            return;
        }
        m17912b().zzbsx().zzj("NetworkBroadcastReceiver received unknown action", action);
    }

    public void unregister() {
        this.f12317b.m17976a();
        this.f12317b.zzwu();
        if (isRegistered()) {
            m17912b().zzbtc().log("Unregistering connectivity change receiver");
            this.f12318c = false;
            this.f12319d = false;
            try {
                m17910a().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                m17912b().zzbsv().zzj("Failed to unregister the network broadcast receiver", e);
            }
        }
    }

    public void zzadg() {
        this.f12317b.m17976a();
        this.f12317b.zzwu();
        if (!this.f12318c) {
            m17910a().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f12319d = this.f12317b.zzbts().zzadj();
            m17912b().zzbtc().zzj("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.f12319d));
            this.f12318c = true;
        }
    }
}
