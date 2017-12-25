package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzab;
import java.util.concurrent.atomic.AtomicReference;

public class zzpm {

    public interface zzb<R> {
        void setResult(R r);

        void zzz(Status status);
    }

    public static abstract class zza<R extends Result, A extends com.google.android.gms.common.api.Api.zzb> extends zzpo<R> implements zzb<R> {
        private final zzc<A> f11470d;
        private final Api<?> f11471e;
        private AtomicReference<zzb> f11472f = new AtomicReference();

        protected zza(Api<?> api, GoogleApiClient googleApiClient) {
            super((GoogleApiClient) zzab.zzb((Object) googleApiClient, (Object) "GoogleApiClient must not be null"));
            this.f11470d = api.zzans();
            this.f11471e = api;
        }

        private void m17370a(RemoteException remoteException) {
            zzz(new Status(8, remoteException.getLocalizedMessage(), null));
        }

        protected void mo1892a() {
            zzb com_google_android_gms_internal_zzqy_zzb = (zzb) this.f11472f.getAndSet(null);
            if (com_google_android_gms_internal_zzqy_zzb != null) {
                com_google_android_gms_internal_zzqy_zzb.zzh(this);
            }
        }

        protected abstract void mo1978a(A a);

        protected void mo1893a(R r) {
        }

        public /* synthetic */ void setResult(Object obj) {
            super.zzc((Result) obj);
        }

        public void zza(zzb com_google_android_gms_internal_zzqy_zzb) {
            this.f11472f.set(com_google_android_gms_internal_zzqy_zzb);
        }

        public final zzc<A> zzans() {
            return this.f11470d;
        }

        public final Api<?> zzanz() {
            return this.f11471e;
        }

        public void zzaor() {
            setResultCallback(null);
        }

        public final void zzb(A a) {
            try {
                mo1978a((com.google.android.gms.common.api.Api.zzb) a);
            } catch (RemoteException e) {
                m17370a(e);
                throw e;
            } catch (RemoteException e2) {
                m17370a(e2);
            }
        }

        public final void zzz(Status status) {
            zzab.zzb(!status.isSuccess(), (Object) "Failed result must not be success");
            Result zzc = zzc(status);
            zzc(zzc);
            mo1893a(zzc);
        }
    }
}
