package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

class zzd<TResult> implements zzf<TResult> {
    private final Executor f12879a;
    private final Object f12880b = new Object();
    private OnFailureListener f12881c;

    public zzd(Executor executor, OnFailureListener onFailureListener) {
        this.f12879a = executor;
        this.f12881c = onFailureListener;
    }

    public void cancel() {
        synchronized (this.f12880b) {
            this.f12881c = null;
        }
    }

    public void onComplete(final Task<TResult> task) {
        if (!task.isSuccessful()) {
            synchronized (this.f12880b) {
                if (this.f12881c == null) {
                    return;
                }
                this.f12879a.execute(new Runnable(this) {
                    final /* synthetic */ zzd f12878b;

                    public void run() {
                        synchronized (this.f12878b.f12880b) {
                            if (this.f12878b.f12881c != null) {
                                this.f12878b.f12881c.onFailure(task.getException());
                            }
                        }
                    }
                });
            }
        }
    }
}
