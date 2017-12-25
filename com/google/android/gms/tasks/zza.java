package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

class zza<TResult, TContinuationResult> implements zzf<TResult> {
    private final Executor f12864a;
    private final Continuation<TResult, TContinuationResult> f12865b;
    private final zzh<TContinuationResult> f12866c;

    public zza(Executor executor, Continuation<TResult, TContinuationResult> continuation, zzh<TContinuationResult> com_google_android_gms_tasks_zzh_TContinuationResult) {
        this.f12864a = executor;
        this.f12865b = continuation;
        this.f12866c = com_google_android_gms_tasks_zzh_TContinuationResult;
    }

    public void cancel() {
        throw new UnsupportedOperationException();
    }

    public void onComplete(final Task<TResult> task) {
        this.f12864a.execute(new Runnable(this) {
            final /* synthetic */ zza f12863b;

            public void run() {
                try {
                    this.f12863b.f12866c.setResult(this.f12863b.f12865b.then(task));
                } catch (Exception e) {
                    if (e.getCause() instanceof Exception) {
                        this.f12863b.f12866c.setException((Exception) e.getCause());
                    } else {
                        this.f12863b.f12866c.setException(e);
                    }
                } catch (Exception e2) {
                    this.f12863b.f12866c.setException(e2);
                }
            }
        });
    }
}
