package com.crashlytics.android.answers;

import io.fabric.sdk.android.C3969c;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

class C2853g {
    final AtomicReference<ScheduledFuture<?>> f9838a = new AtomicReference();
    boolean f9839b = true;
    private final ScheduledExecutorService f9840c;
    private final List<C2852a> f9841d = new ArrayList();
    private volatile boolean f9842e = true;

    class C28511 implements Runnable {
        final /* synthetic */ C2853g f9837a;

        C28511(C2853g c2853g) {
            this.f9837a = c2853g;
        }

        public void run() {
            this.f9837a.f9838a.set(null);
            this.f9837a.m16056c();
        }
    }

    public interface C2852a {
        void mo1452a();
    }

    public C2853g(ScheduledExecutorService scheduledExecutorService) {
        this.f9840c = scheduledExecutorService;
    }

    public void m16059a(boolean z) {
        this.f9842e = z;
    }

    private void m16056c() {
        for (C2852a a : this.f9841d) {
            a.mo1452a();
        }
    }

    public void m16058a(C2852a c2852a) {
        this.f9841d.add(c2852a);
    }

    public void m16057a() {
        this.f9839b = false;
        ScheduledFuture scheduledFuture = (ScheduledFuture) this.f9838a.getAndSet(null);
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
    }

    public void m16060b() {
        if (this.f9842e && !this.f9839b) {
            this.f9839b = true;
            try {
                this.f9838a.compareAndSet(null, this.f9840c.schedule(new C28511(this), 5000, TimeUnit.MILLISECONDS));
            } catch (Throwable e) {
                C3969c.m20576h().mo2850a("Answers", "Failed to schedule background detector", e);
            }
        }
    }
}
