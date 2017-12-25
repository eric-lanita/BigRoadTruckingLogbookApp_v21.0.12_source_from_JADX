package com.google.android.gms.analytics;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.analytics.internal.zzak;
import com.google.android.gms.analytics.internal.zzak.zza;

public final class AnalyticsService extends Service implements zza {
    private zzak f10148a;

    private zzak m16509a() {
        if (this.f10148a == null) {
            this.f10148a = new zzak(this);
        }
        return this.f10148a;
    }

    public boolean callServiceStopSelfResult(int i) {
        return stopSelfResult(i);
    }

    public Context getContext() {
        return this;
    }

    public IBinder onBind(Intent intent) {
        return m16509a().onBind(intent);
    }

    public void onCreate() {
        super.onCreate();
        m16509a().onCreate();
    }

    public void onDestroy() {
        m16509a().onDestroy();
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return m16509a().onStartCommand(intent, i, i2);
    }
}
