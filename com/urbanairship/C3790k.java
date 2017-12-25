package com.urbanairship;

public class C3790k<T> implements C3767e {
    private boolean f13572a;
    private C3789a<T> f13573b;
    private T f13574c;

    public interface C3789a<T> {
        void mo2791a(T t);
    }

    public C3790k(C3789a<T> c3789a) {
        this.f13573b = c3789a;
    }

    public void mo2787a() {
        synchronized (this) {
            if (m19791d()) {
                return;
            }
            mo2792c();
            this.f13572a = true;
        }
    }

    protected void mo2792c() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m19788a(T r2) {
        /*
        r1 = this;
        monitor-enter(r1);
        r0 = r1.mo2788b();	 Catch:{ all -> 0x0016 }
        if (r0 == 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r1);	 Catch:{ all -> 0x0016 }
    L_0x0008:
        return;
    L_0x0009:
        r1.f13574c = r2;	 Catch:{ all -> 0x0016 }
        r0 = r1.f13573b;	 Catch:{ all -> 0x0016 }
        if (r0 == 0) goto L_0x0014;
    L_0x000f:
        r0 = r1.f13573b;	 Catch:{ all -> 0x0016 }
        r0.mo2791a(r2);	 Catch:{ all -> 0x0016 }
    L_0x0014:
        monitor-exit(r1);	 Catch:{ all -> 0x0016 }
        goto L_0x0008;
    L_0x0016:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0016 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.k.a(java.lang.Object):void");
    }

    public boolean m19791d() {
        boolean z;
        synchronized (this) {
            z = this.f13572a;
        }
        return z;
    }

    public boolean mo2788b() {
        boolean z;
        synchronized (this) {
            z = this.f13572a || this.f13574c != null;
        }
        return z;
    }
}
