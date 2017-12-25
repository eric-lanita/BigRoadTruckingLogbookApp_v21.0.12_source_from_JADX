package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

class zzb<TResult, TContinuationResult> implements OnFailureListener, OnSuccessListener<TContinuationResult>, zzf<TResult> {
    private final Executor f12869a;
    private final Continuation<TResult, Task<TContinuationResult>> f12870b;
    private final zzh<TContinuationResult> f12871c;

    public zzb(Executor executor, Continuation<TResult, Task<TContinuationResult>> continuation, zzh<TContinuationResult> com_google_android_gms_tasks_zzh_TContinuationResult) {
        this.f12869a = executor;
        this.f12870b = continuation;
        this.f12871c = com_google_android_gms_tasks_zzh_TContinuationResult;
    }

    public void cancel() {
        throw new UnsupportedOperationException();
    }

    public void onComplete(final Task<TResult> task) {
        this.f12869a.execute(new Runnable(this) {
            final /* synthetic */ zzb f12868b;

            public void run() {
                try {
                    Task task = (Task) this.f12868b.f12870b.then(task);
                    if (task == null) {
                        this.f12868b.onFailure(new NullPointerException("Continuation returned null"));
                        return;
                    }
                    task.addOnSuccessListener(TaskExecutors.f12852a, this.f12868b);
                    task.addOnFailureListener(TaskExecutors.f12852a, this.f12868b);
                } catch (Exception e) {
                    if (e.getCause() instanceof Exception) {
                        this.f12868b.f12871c.setException((Exception) e.getCause());
                    } else {
                        this.f12868b.f12871c.setException(e);
                    }
                } catch (Exception e2) {
                    this.f12868b.f12871c.setException(e2);
                }
            }
        });
    }

    public void onFailure(Exception exception) {
        this.f12871c.setException(exception);
    }

    public void onSuccess(TContinuationResult tContinuationResult) {
        this.f12871c.setResult(tContinuationResult);
    }
}
