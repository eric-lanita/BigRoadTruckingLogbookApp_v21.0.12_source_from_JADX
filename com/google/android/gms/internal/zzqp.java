package com.google.android.gms.internal;

import android.app.Activity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.CancellationException;

public class zzqp extends zzpn {
    private TaskCompletionSource<Void> f11661e = new TaskCompletionSource();

    private zzqp(zzqk com_google_android_gms_internal_zzqk) {
        super(com_google_android_gms_internal_zzqk);
        this.d.zza("GmsAvailabilityHelper", (zzqj) this);
    }

    public static zzqp zzu(Activity activity) {
        zzqk a = zzqj.m17359a(activity);
        zzqp com_google_android_gms_internal_zzqp = (zzqp) a.zza("GmsAvailabilityHelper", zzqp.class);
        if (com_google_android_gms_internal_zzqp == null) {
            return new zzqp(a);
        }
        if (!com_google_android_gms_internal_zzqp.f11661e.getTask().isComplete()) {
            return com_google_android_gms_internal_zzqp;
        }
        com_google_android_gms_internal_zzqp.f11661e = new TaskCompletionSource();
        return com_google_android_gms_internal_zzqp;
    }

    protected void mo1889a() {
        int isGooglePlayServicesAvailable = this.c.isGooglePlayServicesAvailable(this.d.zzaqt());
        if (isGooglePlayServicesAvailable == 0) {
            this.f11661e.setResult(null);
        } else {
            zzk(new ConnectionResult(isGooglePlayServicesAvailable, null));
        }
    }

    protected void mo1890a(ConnectionResult connectionResult, int i) {
        this.f11661e.setException(new Exception());
    }

    public Task<Void> getTask() {
        return this.f11661e.getTask();
    }

    public void onStop() {
        super.onStop();
        this.f11661e.setException(new CancellationException());
    }

    public void zzk(ConnectionResult connectionResult) {
        zzb(connectionResult, 0);
    }
}
