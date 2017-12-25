package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.measurement.internal.zzu;

public final class AppMeasurementReceiver extends BroadcastReceiver {
    private zzu f12118a;

    private zzu m17709a() {
        if (this.f12118a == null) {
            this.f12118a = new zzu();
        }
        return this.f12118a;
    }

    public void onReceive(Context context, Intent intent) {
        m17709a().onReceive(context, intent);
    }
}
