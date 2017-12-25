package com.google.android.gms.common.api;

import com.google.android.gms.common.api.PendingResult.zza;
import com.google.android.gms.internal.zzpo;
import java.util.ArrayList;
import java.util.List;

public final class Batch extends zzpo<BatchResult> {
    private int f10520d;
    private boolean f10521e;
    private boolean f10522f;
    private final PendingResult<?>[] f10523g;
    private final Object f10524h;

    class C32111 implements zza {
        final /* synthetic */ Batch f10502a;

        C32111(Batch batch) {
            this.f10502a = batch;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void zzv(com.google.android.gms.common.api.Status r6) {
            /*
            r5 = this;
            r0 = r5.f10502a;
            r1 = r0.f10524h;
            monitor-enter(r1);
            r0 = r5.f10502a;	 Catch:{ all -> 0x0039 }
            r0 = r0.isCanceled();	 Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x0011;
        L_0x000f:
            monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        L_0x0010:
            return;
        L_0x0011:
            r0 = r6.isCanceled();	 Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x003c;
        L_0x0017:
            r0 = r5.f10502a;	 Catch:{ all -> 0x0039 }
            r2 = 1;
            r0.f10522f = r2;	 Catch:{ all -> 0x0039 }
        L_0x001d:
            r0 = r5.f10502a;	 Catch:{ all -> 0x0039 }
            r0.f10520d = r0.f10520d - 1;	 Catch:{ all -> 0x0039 }
            r0 = r5.f10502a;	 Catch:{ all -> 0x0039 }
            r0 = r0.f10520d;	 Catch:{ all -> 0x0039 }
            if (r0 != 0) goto L_0x0037;
        L_0x002a:
            r0 = r5.f10502a;	 Catch:{ all -> 0x0039 }
            r0 = r0.f10522f;	 Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x0049;
        L_0x0032:
            r0 = r5.f10502a;	 Catch:{ all -> 0x0039 }
            super.cancel();	 Catch:{ all -> 0x0039 }
        L_0x0037:
            monitor-exit(r1);	 Catch:{ all -> 0x0039 }
            goto L_0x0010;
        L_0x0039:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0039 }
            throw r0;
        L_0x003c:
            r0 = r6.isSuccess();	 Catch:{ all -> 0x0039 }
            if (r0 != 0) goto L_0x001d;
        L_0x0042:
            r0 = r5.f10502a;	 Catch:{ all -> 0x0039 }
            r2 = 1;
            r0.f10521e = r2;	 Catch:{ all -> 0x0039 }
            goto L_0x001d;
        L_0x0049:
            r0 = r5.f10502a;	 Catch:{ all -> 0x0039 }
            r0 = r0.f10521e;	 Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x0069;
        L_0x0051:
            r0 = new com.google.android.gms.common.api.Status;	 Catch:{ all -> 0x0039 }
            r2 = 13;
            r0.<init>(r2);	 Catch:{ all -> 0x0039 }
        L_0x0058:
            r2 = r5.f10502a;	 Catch:{ all -> 0x0039 }
            r3 = new com.google.android.gms.common.api.BatchResult;	 Catch:{ all -> 0x0039 }
            r4 = r5.f10502a;	 Catch:{ all -> 0x0039 }
            r4 = r4.f10523g;	 Catch:{ all -> 0x0039 }
            r3.<init>(r0, r4);	 Catch:{ all -> 0x0039 }
            r2.zzc(r3);	 Catch:{ all -> 0x0039 }
            goto L_0x0037;
        L_0x0069:
            r0 = com.google.android.gms.common.api.Status.sq;	 Catch:{ all -> 0x0039 }
            goto L_0x0058;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.Batch.1.zzv(com.google.android.gms.common.api.Status):void");
        }
    }

    public static final class Builder {
        private List<PendingResult<?>> f10503a = new ArrayList();
        private GoogleApiClient f10504b;

        public Builder(GoogleApiClient googleApiClient) {
            this.f10504b = googleApiClient;
        }

        public <R extends Result> BatchResultToken<R> add(PendingResult<R> pendingResult) {
            BatchResultToken<R> batchResultToken = new BatchResultToken(this.f10503a.size());
            this.f10503a.add(pendingResult);
            return batchResultToken;
        }

        public Batch build() {
            return new Batch(this.f10503a, this.f10504b);
        }
    }

    private Batch(List<PendingResult<?>> list, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.f10524h = new Object();
        this.f10520d = list.size();
        this.f10523g = new PendingResult[this.f10520d];
        if (list.isEmpty()) {
            zzc(new BatchResult(Status.sq, this.f10523g));
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            PendingResult pendingResult = (PendingResult) list.get(i);
            this.f10523g[i] = pendingResult;
            pendingResult.zza(new C32111(this));
        }
    }

    public void cancel() {
        super.cancel();
        for (PendingResult cancel : this.f10523g) {
            cancel.cancel();
        }
    }

    public BatchResult createFailedResult(Status status) {
        return new BatchResult(status, this.f10523g);
    }

    public /* synthetic */ Result zzc(Status status) {
        return createFailedResult(status);
    }
}
