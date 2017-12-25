package com.bigroad.ttb.android;

import android.content.Context;
import com.bigroad.ttb.android.C2474y.C1182a;
import com.bigroad.ttb.android.C2474y.C1183b;
import com.bigroad.ttb.android.logging.C2134e;
import com.crashlytics.android.C2834a;
import java.util.HashSet;
import java.util.Set;

public class AuthMonitor {
    private static AuthMonitor f4003a;
    private final C2474y f4004b = OurApplication.m6285g();
    private final Set<C1185a> f4005c = new HashSet();
    private AuthStatus f4006d;
    private final C1182a f4007e = new C11841(this);

    class C11841 extends C1183b {
        final /* synthetic */ AuthMonitor f3998a;

        C11841(AuthMonitor authMonitor) {
            this.f3998a = authMonitor;
        }

        public void mo863a(C2474y c2474y) {
            if (this.f3998a.f4004b.m12202d() < 0) {
                C2134e.m10676b("TT-AuthMonitor", "Signing out because auth token cleared");
                this.f3998a.m6022a(AuthStatus.SIGNED_OUT);
            }
        }
    }

    public enum AuthStatus {
        SIGNED_OUT,
        SELECTING_TRUCK,
        SIGNED_IN
    }

    public interface C1185a {
        void mo912a(AuthStatus authStatus);
    }

    public static AuthMonitor m6020a(Context context) {
        if (f4003a == null) {
            f4003a = new AuthMonitor();
        }
        return f4003a;
    }

    private AuthStatus m6024e() {
        return this.f4004b.m12202d() >= 0 ? AuthStatus.SIGNED_IN : AuthStatus.SIGNED_OUT;
    }

    private AuthMonitor() {
        this.f4004b.m12184a(this.f4007e);
        this.f4006d = m6024e();
    }

    public void m6027a(C1185a c1185a) {
        this.f4005c.add(c1185a);
    }

    public void m6029b(C1185a c1185a) {
        this.f4005c.remove(c1185a);
    }

    private void m6025f() {
        for (C1185a a : (C1185a[]) this.f4005c.toArray(new C1185a[this.f4005c.size()])) {
            a.mo912a(this.f4006d);
        }
    }

    private void m6022a(AuthStatus authStatus) {
        if (authStatus != this.f4006d) {
            this.f4006d = authStatus;
            m6025f();
            if (!OurApplication.m6279b().m6306a()) {
                return;
            }
            if (m6031d()) {
                C2834a.m16004e().f9785c.m16400c(this.f4004b.m12192b());
            } else {
                C2834a.m16004e().f9785c.m16400c("");
            }
        }
    }

    public void m6026a() {
        m6022a(AuthStatus.SELECTING_TRUCK);
    }

    public void m6028b() {
        if (this.f4006d == AuthStatus.SELECTING_TRUCK) {
            m6022a(AuthStatus.SIGNED_IN);
        }
    }

    public boolean m6030c() {
        return this.f4006d == AuthStatus.SIGNED_OUT;
    }

    public boolean m6031d() {
        return this.f4006d == AuthStatus.SIGNED_IN;
    }
}
