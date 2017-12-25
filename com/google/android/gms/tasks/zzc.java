package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

class zzc<TResult> implements zzf<TResult> {
    private final Executor f12874a;
    private final Object f12875b = new Object();
    private OnCompleteListener<TResult> f12876c;

    public zzc(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        this.f12874a = executor;
        this.f12876c = onCompleteListener;
    }

    public void cancel() {
        synchronized (this.f12875b) {
            this.f12876c = null;
        }
    }

    public void onComplete(final Task<TResult> task) {
        synchronized (this.f12875b) {
            if (this.f12876c == null) {
                return;
            }
            this.f12874a.execute(new Runnable(this) {
                final /* synthetic */ zzc f12873b;

                public void run() {
                    synchronized (this.f12873b.f12875b) {
                        if (this.f12873b.f12876c != null) {
                            this.f12873b.f12876c.onComplete(task);
                        }
                    }
                }
            });
        }
    }
}
