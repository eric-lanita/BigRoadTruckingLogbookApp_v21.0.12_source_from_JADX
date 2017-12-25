package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.internal.zzab;

public final class zzqn<L> {
    private final zza f11658a;
    private volatile L f11659b;

    public interface zzb<L> {
        void zzapj();

        void zzt(L l);
    }

    private final class zza extends Handler {
        final /* synthetic */ zzqn f11657a;

        public zza(zzqn com_google_android_gms_internal_zzqn, Looper looper) {
            this.f11657a = com_google_android_gms_internal_zzqn;
            super(looper);
        }

        public void handleMessage(Message message) {
            boolean z = true;
            if (message.what != 1) {
                z = false;
            }
            zzab.zzbo(z);
            this.f11657a.m17508a((zzb) message.obj);
        }
    }

    zzqn(Looper looper, L l) {
        this.f11658a = new zza(this, looper);
        this.f11659b = zzab.zzb((Object) l, (Object) "Listener must not be null");
    }

    void m17508a(zzb<? super L> com_google_android_gms_internal_zzqn_zzb__super_L) {
        Object obj = this.f11659b;
        if (obj == null) {
            com_google_android_gms_internal_zzqn_zzb__super_L.zzapj();
            return;
        }
        try {
            com_google_android_gms_internal_zzqn_zzb__super_L.zzt(obj);
        } catch (RuntimeException e) {
            com_google_android_gms_internal_zzqn_zzb__super_L.zzapj();
            throw e;
        }
    }

    public void clear() {
        this.f11659b = null;
    }

    public void zza(zzb<? super L> com_google_android_gms_internal_zzqn_zzb__super_L) {
        zzab.zzb((Object) com_google_android_gms_internal_zzqn_zzb__super_L, (Object) "Notifier must not be null");
        this.f11658a.sendMessage(this.f11658a.obtainMessage(1, com_google_android_gms_internal_zzqn_zzb__super_L));
    }
}
