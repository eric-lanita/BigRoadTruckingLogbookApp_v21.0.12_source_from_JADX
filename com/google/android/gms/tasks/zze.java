package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

class zze<TResult> implements zzf<TResult> {
    private final Executor f12884a;
    private final Object f12885b = new Object();
    private OnSuccessListener<? super TResult> f12886c;

    public zze(Executor executor, OnSuccessListener<? super TResult> onSuccessListener) {
        this.f12884a = executor;
        this.f12886c = onSuccessListener;
    }

    public void cancel() {
        synchronized (this.f12885b) {
            this.f12886c = null;
        }
    }

    public void onComplete(final Task<TResult> task) {
        if (task.isSuccessful()) {
            synchronized (this.f12885b) {
                if (this.f12886c == null) {
                    return;
                }
                this.f12884a.execute(new Runnable(this) {
                    final /* synthetic */ zze f12883b;

                    public void run() {
                        synchronized (this.f12883b.f12885b) {
                            if (this.f12883b.f12886c != null) {
                                this.f12883b.f12886c.onSuccess(task.getResult());
                            }
                        }
                    }
                });
            }
        }
    }
}
