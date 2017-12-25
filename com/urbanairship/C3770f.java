package com.urbanairship;

import android.os.Handler;
import android.os.Looper;

public abstract class C3770f implements C3767e, Runnable {
    private boolean f13538a = false;
    private boolean f13539b = false;
    private boolean f13540c = false;
    private final Handler f13541d;
    private final Runnable f13542e;

    class C37681 implements Runnable {
        final /* synthetic */ C3770f f13536a;

        C37681(C3770f c3770f) {
            this.f13536a = c3770f;
        }

        public void run() {
            synchronized (this.f13536a) {
                if (this.f13536a.mo2788b()) {
                    return;
                }
                this.f13536a.mo2845d();
                this.f13536a.f13538a = true;
            }
        }
    }

    class C37692 implements Runnable {
        final /* synthetic */ C3770f f13537a;

        C37692(C3770f c3770f) {
            this.f13537a = c3770f;
        }

        public void run() {
            this.f13537a.m19682c();
        }
    }

    protected abstract void mo2845d();

    public C3770f(Looper looper) {
        if (looper != null) {
            this.f13541d = new Handler(looper);
        } else {
            Looper myLooper = Looper.myLooper();
            this.f13541d = myLooper != null ? new Handler(myLooper) : new Handler(Looper.getMainLooper());
        }
        this.f13542e = new C37681(this);
    }

    public final void mo2787a() {
        synchronized (this) {
            if (!mo2788b()) {
                this.f13540c = true;
                this.f13541d.removeCallbacks(this.f13542e);
                this.f13541d.post(new C37692(this));
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = r2.mo2788b();	 Catch:{ all -> 0x0019 }
        if (r0 != 0) goto L_0x000b;
    L_0x0007:
        r0 = r2.f13539b;	 Catch:{ all -> 0x0019 }
        if (r0 == 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r2);	 Catch:{ all -> 0x0019 }
    L_0x000c:
        return;
    L_0x000d:
        r0 = 1;
        r2.f13539b = r0;	 Catch:{ all -> 0x0019 }
        r0 = r2.f13541d;	 Catch:{ all -> 0x0019 }
        r1 = r2.f13542e;	 Catch:{ all -> 0x0019 }
        r0.post(r1);	 Catch:{ all -> 0x0019 }
        monitor-exit(r2);	 Catch:{ all -> 0x0019 }
        goto L_0x000c;
    L_0x0019:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0019 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.f.run():void");
    }

    public final boolean mo2788b() {
        boolean z;
        synchronized (this) {
            z = this.f13538a || this.f13540c;
        }
        return z;
    }

    protected void m19682c() {
    }
}
