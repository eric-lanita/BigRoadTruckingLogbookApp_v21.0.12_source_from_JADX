package com.google.android.gms.internal;

import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult.zza;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.TransformedResult;
import java.util.concurrent.TimeUnit;

public final class zzqq<R extends Result> extends OptionalPendingResult<R> {
    private final zzpo<R> f11662a;

    public zzqq(PendingResult<R> pendingResult) {
        if (pendingResult instanceof zzpo) {
            this.f11662a = (zzpo) pendingResult;
            return;
        }
        throw new IllegalArgumentException("OptionalPendingResult can only wrap PendingResults generated by an API call.");
    }

    public R await() {
        return this.f11662a.await();
    }

    public R await(long j, TimeUnit timeUnit) {
        return this.f11662a.await(j, timeUnit);
    }

    public void cancel() {
        this.f11662a.cancel();
    }

    public R get() {
        if (isDone()) {
            return await(0, TimeUnit.MILLISECONDS);
        }
        throw new IllegalStateException("Result is not available. Check that isDone() returns true before calling get().");
    }

    public boolean isCanceled() {
        return this.f11662a.isCanceled();
    }

    public boolean isDone() {
        return this.f11662a.isReady();
    }

    public void setResultCallback(ResultCallback<? super R> resultCallback) {
        this.f11662a.setResultCallback(resultCallback);
    }

    public void setResultCallback(ResultCallback<? super R> resultCallback, long j, TimeUnit timeUnit) {
        this.f11662a.setResultCallback(resultCallback, j, timeUnit);
    }

    public <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> resultTransform) {
        return this.f11662a.then(resultTransform);
    }

    public void zza(zza com_google_android_gms_common_api_PendingResult_zza) {
        this.f11662a.zza(com_google_android_gms_common_api_PendingResult_zza);
    }

    public Integer zzaoj() {
        return this.f11662a.zzaoj();
    }
}
