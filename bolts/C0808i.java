package bolts;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class C0808i<TResult> {
    public static final ExecutorService f2421a = C0794d.m3972a();
    public static final Executor f2422b = C0788a.m3967b();
    private static final Executor f2423c = C0794d.m3973b();
    private static volatile C0807b f2424d;
    private static C0808i<?> f2425m = new C0808i(null);
    private static C0808i<Boolean> f2426n = new C0808i(Boolean.valueOf(true));
    private static C0808i<Boolean> f2427o = new C0808i(Boolean.valueOf(false));
    private static C0808i<?> f2428p = new C0808i(true);
    private final Object f2429e = new Object();
    private boolean f2430f;
    private boolean f2431g;
    private TResult f2432h;
    private Exception f2433i;
    private boolean f2434j;
    private C0809k f2435k;
    private List<C0798h<TResult, Void>> f2436l = new ArrayList();

    public class C0806a extends C0805j<TResult> {
        final /* synthetic */ C0808i f2420a;

        C0806a(C0808i c0808i) {
            this.f2420a = c0808i;
        }
    }

    public interface C0807b {
        void m3991a(C0808i<?> c0808i, UnobservedTaskException unobservedTaskException);
    }

    public static C0807b m3992a() {
        return f2424d;
    }

    C0808i() {
    }

    private C0808i(TResult tResult) {
        m4008b((Object) tResult);
    }

    private C0808i(boolean z) {
        if (z) {
            m4015i();
        } else {
            m4008b(null);
        }
    }

    public static <TResult> C0806a m3996b() {
        C0808i c0808i = new C0808i();
        c0808i.getClass();
        return new C0806a(c0808i);
    }

    public boolean m4010c() {
        boolean z;
        synchronized (this.f2429e) {
            z = this.f2430f;
        }
        return z;
    }

    public boolean m4011d() {
        boolean z;
        synchronized (this.f2429e) {
            z = this.f2431g;
        }
        return z;
    }

    public boolean m4012e() {
        boolean z;
        synchronized (this.f2429e) {
            z = m4014g() != null;
        }
        return z;
    }

    public TResult m4013f() {
        TResult tResult;
        synchronized (this.f2429e) {
            tResult = this.f2432h;
        }
        return tResult;
    }

    public Exception m4014g() {
        Exception exception;
        synchronized (this.f2429e) {
            if (this.f2433i != null) {
                this.f2434j = true;
                if (this.f2435k != null) {
                    this.f2435k.m4016a();
                    this.f2435k = null;
                }
            }
            exception = this.f2433i;
        }
        return exception;
    }

    public static <TResult> C0808i<TResult> m3994a(TResult tResult) {
        if (tResult == null) {
            return f2425m;
        }
        if (tResult instanceof Boolean) {
            return ((Boolean) tResult).booleanValue() ? f2426n : f2427o;
        } else {
            C0805j c0805j = new C0805j();
            c0805j.m3988b((Object) tResult);
            return c0805j.m3984a();
        }
    }

    public static <TResult> C0808i<TResult> m3993a(Exception exception) {
        C0805j c0805j = new C0805j();
        c0805j.m3987b(exception);
        return c0805j.m3984a();
    }

    public static <TResult> C0808i<TResult> m4000h() {
        return f2428p;
    }

    public <TContinuationResult> C0808i<TContinuationResult> m4004a(C0798h<TResult, TContinuationResult> c0798h, Executor executor, C0795e c0795e) {
        final C0805j c0805j = new C0805j();
        synchronized (this.f2429e) {
            boolean c = m4010c();
            if (!c) {
                final C0798h<TResult, TContinuationResult> c0798h2 = c0798h;
                final Executor executor2 = executor;
                final C0795e c0795e2 = c0795e;
                this.f2436l.add(new C0798h<TResult, Void>(this) {
                    final /* synthetic */ C0808i f2401e;

                    public /* synthetic */ Object then(C0808i c0808i) {
                        return m3980a(c0808i);
                    }

                    public Void m3980a(C0808i<TResult> c0808i) {
                        C0808i.m3998c(c0805j, c0798h2, c0808i, executor2, c0795e2);
                        return null;
                    }
                });
            }
        }
        if (c) {
            C0808i.m3998c(c0805j, c0798h, this, executor, c0795e);
        }
        return c0805j.m3984a();
    }

    public <TContinuationResult> C0808i<TContinuationResult> m4002a(C0798h<TResult, TContinuationResult> c0798h) {
        return m4004a(c0798h, f2423c, null);
    }

    public <TContinuationResult> C0808i<TContinuationResult> m4003a(C0798h<TResult, C0808i<TContinuationResult>> c0798h, Executor executor) {
        return m4006b(c0798h, executor, null);
    }

    public <TContinuationResult> C0808i<TContinuationResult> m4006b(C0798h<TResult, C0808i<TContinuationResult>> c0798h, Executor executor, C0795e c0795e) {
        final C0805j c0805j = new C0805j();
        synchronized (this.f2429e) {
            boolean c = m4010c();
            if (!c) {
                final C0798h<TResult, C0808i<TContinuationResult>> c0798h2 = c0798h;
                final Executor executor2 = executor;
                final C0795e c0795e2 = c0795e;
                this.f2436l.add(new C0798h<TResult, Void>(this) {
                    final /* synthetic */ C0808i f2406e;

                    public /* synthetic */ Object then(C0808i c0808i) {
                        return m3981a(c0808i);
                    }

                    public Void m3981a(C0808i<TResult> c0808i) {
                        C0808i.m3999d(c0805j, c0798h2, c0808i, executor2, c0795e2);
                        return null;
                    }
                });
            }
        }
        if (c) {
            C0808i.m3999d(c0805j, c0798h, this, executor, c0795e);
        }
        return c0805j.m3984a();
    }

    public <TContinuationResult> C0808i<TContinuationResult> m4009c(final C0798h<TResult, TContinuationResult> c0798h, Executor executor, final C0795e c0795e) {
        return m4003a(new C0798h<TResult, C0808i<TContinuationResult>>(this) {
            final /* synthetic */ C0808i f2409c;

            public /* synthetic */ Object then(C0808i c0808i) {
                return m3982a(c0808i);
            }

            public C0808i<TContinuationResult> m3982a(C0808i<TResult> c0808i) {
                if (c0795e != null && c0795e.m3975a()) {
                    return C0808i.m4000h();
                }
                if (c0808i.m4012e()) {
                    return C0808i.m3993a(c0808i.m4014g());
                }
                if (c0808i.m4011d()) {
                    return C0808i.m4000h();
                }
                return c0808i.m4002a(c0798h);
            }
        }, executor);
    }

    public <TContinuationResult> C0808i<TContinuationResult> m4005b(C0798h<TResult, TContinuationResult> c0798h) {
        return m4009c(c0798h, f2423c, null);
    }

    private static <TContinuationResult, TResult> void m3998c(final C0805j<TContinuationResult> c0805j, final C0798h<TResult, TContinuationResult> c0798h, final C0808i<TResult> c0808i, Executor executor, final C0795e c0795e) {
        try {
            executor.execute(new Runnable() {
                public void run() {
                    if (c0795e == null || !c0795e.m3975a()) {
                        try {
                            c0805j.m3988b(c0798h.then(c0808i));
                            return;
                        } catch (CancellationException e) {
                            c0805j.m3990c();
                            return;
                        } catch (Exception e2) {
                            c0805j.m3987b(e2);
                            return;
                        }
                    }
                    c0805j.m3990c();
                }
            });
        } catch (Exception e) {
            c0805j.m3987b(new ExecutorException(e));
        }
    }

    private static <TContinuationResult, TResult> void m3999d(final C0805j<TContinuationResult> c0805j, final C0798h<TResult, C0808i<TContinuationResult>> c0798h, final C0808i<TResult> c0808i, Executor executor, final C0795e c0795e) {
        try {
            executor.execute(new Runnable() {

                class C08031 implements C0798h<TContinuationResult, Void> {
                    final /* synthetic */ C08045 f2414a;

                    C08031(C08045 c08045) {
                        this.f2414a = c08045;
                    }

                    public /* synthetic */ Object then(C0808i c0808i) {
                        return m3983a(c0808i);
                    }

                    public Void m3983a(C0808i<TContinuationResult> c0808i) {
                        if (c0795e != null && c0795e.m3975a()) {
                            c0805j.m3990c();
                        } else if (c0808i.m4011d()) {
                            c0805j.m3990c();
                        } else if (c0808i.m4012e()) {
                            c0805j.m3987b(c0808i.m4014g());
                        } else {
                            c0805j.m3988b(c0808i.m4013f());
                        }
                        return null;
                    }
                }

                public void run() {
                    if (c0795e == null || !c0795e.m3975a()) {
                        try {
                            C0808i c0808i = (C0808i) c0798h.then(c0808i);
                            if (c0808i == null) {
                                c0805j.m3988b(null);
                                return;
                            } else {
                                c0808i.m4002a(new C08031(this));
                                return;
                            }
                        } catch (CancellationException e) {
                            c0805j.m3990c();
                            return;
                        } catch (Exception e2) {
                            c0805j.m3987b(e2);
                            return;
                        }
                    }
                    c0805j.m3990c();
                }
            });
        } catch (Exception e) {
            c0805j.m3987b(new ExecutorException(e));
        }
    }

    private void m4001j() {
        synchronized (this.f2429e) {
            for (C0798h then : this.f2436l) {
                try {
                    then.then(this);
                } catch (RuntimeException e) {
                    throw e;
                } catch (Throwable e2) {
                    throw new RuntimeException(e2);
                }
            }
            this.f2436l = null;
        }
    }

    boolean m4015i() {
        boolean z = true;
        synchronized (this.f2429e) {
            if (this.f2430f) {
                z = false;
            } else {
                this.f2430f = true;
                this.f2431g = true;
                this.f2429e.notifyAll();
                m4001j();
            }
        }
        return z;
    }

    boolean m4008b(TResult tResult) {
        boolean z = true;
        synchronized (this.f2429e) {
            if (this.f2430f) {
                z = false;
            } else {
                this.f2430f = true;
                this.f2432h = tResult;
                this.f2429e.notifyAll();
                m4001j();
            }
        }
        return z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    boolean m4007b(java.lang.Exception r5) {
        /*
        r4 = this;
        r1 = 1;
        r0 = 0;
        r2 = r4.f2429e;
        monitor-enter(r2);
        r3 = r4.f2430f;	 Catch:{ all -> 0x002f }
        if (r3 == 0) goto L_0x000b;
    L_0x0009:
        monitor-exit(r2);	 Catch:{ all -> 0x002f }
    L_0x000a:
        return r0;
    L_0x000b:
        r0 = 1;
        r4.f2430f = r0;	 Catch:{ all -> 0x002f }
        r4.f2433i = r5;	 Catch:{ all -> 0x002f }
        r0 = 0;
        r4.f2434j = r0;	 Catch:{ all -> 0x002f }
        r0 = r4.f2429e;	 Catch:{ all -> 0x002f }
        r0.notifyAll();	 Catch:{ all -> 0x002f }
        r4.m4001j();	 Catch:{ all -> 0x002f }
        r0 = r4.f2434j;	 Catch:{ all -> 0x002f }
        if (r0 != 0) goto L_0x002c;
    L_0x001f:
        r0 = bolts.C0808i.m3992a();	 Catch:{ all -> 0x002f }
        if (r0 == 0) goto L_0x002c;
    L_0x0025:
        r0 = new bolts.k;	 Catch:{ all -> 0x002f }
        r0.<init>(r4);	 Catch:{ all -> 0x002f }
        r4.f2435k = r0;	 Catch:{ all -> 0x002f }
    L_0x002c:
        monitor-exit(r2);	 Catch:{ all -> 0x002f }
        r0 = r1;
        goto L_0x000a;
    L_0x002f:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x002f }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: bolts.i.b(java.lang.Exception):boolean");
    }
}
