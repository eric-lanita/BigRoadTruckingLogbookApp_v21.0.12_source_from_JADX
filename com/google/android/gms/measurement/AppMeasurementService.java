package com.google.android.gms.measurement;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.measurement.internal.zzae;
import com.google.android.gms.measurement.internal.zzae.zza;

public final class AppMeasurementService extends Service implements zza {
    private zzae f12119a;

    private zzae m17710a() {
        if (this.f12119a == null) {
            this.f12119a = new zzae(this);
        }
        return this.f12119a;
    }

    public boolean callServiceStopSelfResult(int i) {
        return stopSelfResult(i);
    }

    public Context getContext() {
        return this;
    }

    public IBinder onBind(Intent intent) {
        return m17710a().onBind(intent);
    }

    public void onCreate() {
        super.onCreate();
        m17710a().onCreate();
    }

    public void onDestroy() {
        m17710a().onDestroy();
        super.onDestroy();
    }

    public void onRebind(Intent intent) {
        m17710a().onRebind(intent);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return m17710a().onStartCommand(intent, i, i2);
    }

    public boolean onUnbind(Intent intent) {
        return m17710a().onUnbind(intent);
    }
}
