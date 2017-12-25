package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzab;
import java.util.concurrent.TimeUnit;

public final class BatchResult implements Result {
    private final Status f10525a;
    private final PendingResult<?>[] f10526b;

    BatchResult(Status status, PendingResult<?>[] pendingResultArr) {
        this.f10525a = status;
        this.f10526b = pendingResultArr;
    }

    public Status getStatus() {
        return this.f10525a;
    }

    public <R extends Result> R take(BatchResultToken<R> batchResultToken) {
        zzab.zzb(batchResultToken.f10527a < this.f10526b.length, (Object) "The result token does not belong to this batch");
        return this.f10526b[batchResultToken.f10527a].await(0, TimeUnit.MILLISECONDS);
    }
}
