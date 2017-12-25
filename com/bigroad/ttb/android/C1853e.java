package com.bigroad.ttb.android;

import android.os.Handler;
import com.bigroad.shared.ap;
import com.bigroad.ttb.android.AuthMonitor.AuthStatus;
import com.bigroad.ttb.android.AuthMonitor.C1185a;
import com.bigroad.ttb.android.event.C2022a;
import com.bigroad.ttb.android.event.EventManager;
import com.bigroad.ttb.android.p035d.C1790a;

public class C1853e implements C1185a {
    private static C1853e f6309a;
    private final AuthMonitor f6310b = OurApplication.m6249F();
    private final C1790a f6311c = OurApplication.m6287i();
    private final EventManager f6312d = OurApplication.m6295q();
    private final ap f6313e = OurApplication.m6269Z();
    private final Handler f6314f = new Handler();
    private final Runnable f6315g = new C18481(this);
    private boolean f6316h = false;
    private long f6317i = this.f6313e.mo913a();
    private long f6318j = this.f6313e.mo915c();

    class C18481 implements Runnable {
        final /* synthetic */ C1853e f6290a;

        C18481(C1853e c1853e) {
            this.f6290a = c1853e;
        }

        public void run() {
            this.f6290a.m8950c();
            this.f6290a.f6314f.postDelayed(this.f6290a.f6315g, 60000);
        }
    }

    public static C1853e m8943a() {
        if (f6309a == null) {
            f6309a = new C1853e();
        }
        return f6309a;
    }

    private C1853e() {
        m8946d();
        m8950c();
        this.f6314f.postDelayed(this.f6315g, 60000);
    }

    public long m8949b() {
        Long d = this.f6311c.m8769d("app.upTimestamp");
        return d != null ? d.longValue() : this.f6313e.mo913a();
    }

    public void m8950c() {
        if (!this.f6316h) {
            this.f6311c.m8740a("app.upTimestamp", Long.valueOf(this.f6313e.mo913a()));
        }
    }

    private void m8946d() {
        if (m8949b() + 300000 >= this.f6313e.mo913a()) {
            return;
        }
        if (this.f6310b.m6031d()) {
            m8947e();
            return;
        }
        this.f6316h = true;
        this.f6310b.m6027a((C1185a) this);
    }

    private void m8947e() {
        long b = 60000 + m8949b();
        long j = this.f6317i - b;
        long j2 = 0;
        if (j > this.f6318j) {
            j2 = 0 | 1;
        }
        this.f6312d.m10050e(C2022a.m10075a(OurApplication.ac(), b, j, j2));
    }

    public void mo912a(AuthStatus authStatus) {
        if (authStatus == AuthStatus.SIGNED_IN && this.f6316h) {
            m8947e();
            this.f6316h = false;
            this.f6310b.m6029b(this);
        }
    }
}
