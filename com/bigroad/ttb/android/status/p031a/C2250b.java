package com.bigroad.ttb.android.status.p031a;

import android.os.Handler;
import com.bigroad.shared.MobileAppDiagnosticFlags;
import com.bigroad.shared.ap;
import com.bigroad.ttb.android.eobr.EobrEntryManager;
import com.bigroad.ttb.android.eobr.EobrEntryManager.C1869a;
import com.bigroad.ttb.android.eobr.EobrEntryManager.C1870b;
import com.bigroad.ttb.android.eobr.EobrEntryManager.State;
import com.bigroad.ttb.android.logging.C2134e;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class C2250b {
    protected boolean f7810a;
    protected String f7811b;
    protected LinkedList<C2249a> f7812c = new LinkedList();
    private ap f7813d;
    private final Handler f7814e = new Handler();
    private long f7815f;
    private boolean f7816g;
    private boolean f7817h;
    private final Runnable f7818i = new C22431(this);
    private final C1869a f7819j = new C22482(this);

    class C22431 implements Runnable {
        final /* synthetic */ C2250b f7792a;

        C22431(C2250b c2250b) {
            this.f7792a = c2250b;
        }

        public void run() {
            if (this.f7792a.f7810a) {
                this.f7792a.m11083d(this.f7792a.f7813d.mo915c());
                this.f7792a.f7814e.postDelayed(this.f7792a.f7818i, 60000);
            }
        }
    }

    class C22482 extends C1870b {
        final /* synthetic */ C2250b f7804a;

        class C2244a implements Runnable {
            final /* synthetic */ C22482 f7793a;
            private final String f7794b;
            private final long f7795c;

            C2244a(C22482 c22482, String str, long j) {
                this.f7793a = c22482;
                this.f7794b = str;
                this.f7795c = j;
            }

            public void run() {
                this.f7793a.f7804a.m11079a(this.f7794b);
            }
        }

        class C2245b implements Runnable {
            final /* synthetic */ C22482 f7796a;
            private final long f7797b;

            C2245b(C22482 c22482, long j) {
                this.f7796a = c22482;
                this.f7797b = j;
            }

            public void run() {
                this.f7796a.f7804a.m11082c(this.f7797b);
            }
        }

        class C2246c implements Runnable {
            final /* synthetic */ C22482 f7798a;
            private final State f7799b;
            private final long f7800c;

            C2246c(C22482 c22482, State state, long j) {
                this.f7798a = c22482;
                this.f7799b = state;
                this.f7800c = j;
            }

            public void run() {
                this.f7798a.f7804a.m11078a(this.f7799b, this.f7800c);
            }
        }

        class C2247d implements Runnable {
            final /* synthetic */ C22482 f7801a;
            private final String f7802b;
            private final long f7803c;

            C2247d(C22482 c22482, String str, long j) {
                this.f7801a = c22482;
                this.f7802b = str;
                this.f7803c = j;
            }

            public void run() {
                this.f7801a.f7804a.m11080a(this.f7802b, this.f7803c);
            }
        }

        C22482(C2250b c2250b) {
            this.f7804a = c2250b;
        }

        public void mo1078a(String str) {
            this.f7804a.f7814e.post(new C2247d(this, str, this.f7804a.f7813d.mo915c()));
        }

        public void mo1079b(String str) {
            this.f7804a.f7814e.post(new C2244a(this, str, this.f7804a.f7813d.mo915c()));
        }

        public void mo1077a(State state) {
            this.f7804a.f7814e.post(new C2246c(this, state, this.f7804a.f7813d.mo915c()));
        }

        public void mo1076a(long j) {
            this.f7804a.f7814e.post(new C2245b(this, this.f7804a.f7813d.mo915c()));
        }
    }

    protected class C2249a {
        final State f7805a;
        final long f7806b;
        long f7807c;
        long f7808d;
        final /* synthetic */ C2250b f7809e;

        public C2249a(C2250b c2250b, State state, long j) {
            this.f7809e = c2250b;
            this.f7805a = state;
            this.f7806b = j;
        }

        public String m11071a(long j) {
            return "State: " + this.f7805a + " Time: " + (j - this.f7806b) + " ms Pages: " + this.f7807c + " Last Page Time: " + (this.f7807c > 0 ? (j - this.f7808d) + " ms" : "n/a");
        }
    }

    public static C2250b m11074a(EobrEntryManager eobrEntryManager, ap apVar) {
        return new C2250b(eobrEntryManager, apVar);
    }

    private C2250b(EobrEntryManager eobrEntryManager, ap apVar) {
        this.f7813d = apVar;
        eobrEntryManager.m9048a(this.f7819j);
    }

    private C2249a m11073a() {
        try {
            return (C2249a) this.f7812c.getLast();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    protected void m11077a(long j) {
        if (!this.f7816g) {
            C2134e.m10670a(MobileAppDiagnosticFlags.LOG_SLOW_UI, 5, "TT-EobrMgrMon", "Long delay to reach real time usage. " + (m11073a() != null ? m11073a().m11071a(j) : null));
            this.f7816g = true;
        }
    }

    protected void m11081b(long j) {
        if (!this.f7817h) {
            C2134e.m10670a(MobileAppDiagnosticFlags.LOG_SLOW_UI, 5, "TT-EobrMgrMon", "Page has not been requested in some time.  " + (m11073a() != null ? m11073a().m11071a(j) : null));
            this.f7817h = true;
        }
    }

    protected void m11080a(String str, long j) {
        C2134e.m10673a("TT-EobrMgrMon", "Monitoring device " + str);
        this.f7810a = true;
        this.f7811b = str;
        this.f7815f = j;
        this.f7814e.postDelayed(this.f7818i, 60000);
    }

    protected void m11079a(String str) {
        C2134e.m10673a("TT-EobrMgrMon", "No longer monitoring device " + str);
        this.f7810a = false;
        this.f7811b = null;
        this.f7814e.removeCallbacks(this.f7818i);
        this.f7816g = false;
        this.f7812c.clear();
    }

    protected void m11078a(State state, long j) {
        if (!this.f7810a) {
            return;
        }
        if (this.f7812c.isEmpty() || m11073a().f7805a != state) {
            if (m11073a() != null) {
                C2134e.m10673a("TT-EobrMgrMon", "<<< " + m11073a().m11071a(j));
            }
            this.f7812c.add(new C2249a(this, state, j));
            this.f7817h = false;
            C2134e.m10673a("TT-EobrMgrMon", ">>> " + state + " after " + (j - ((C2249a) this.f7812c.getFirst()).f7806b) + " ms");
        }
    }

    protected void m11082c(long j) {
        if (!this.f7812c.isEmpty()) {
            C2249a c2249a = (C2249a) this.f7812c.getLast();
            c2249a.f7807c++;
            ((C2249a) this.f7812c.getLast()).f7808d = j;
            this.f7817h = false;
        }
    }

    protected void m11083d(long j) {
        if (!this.f7812c.isEmpty()) {
            if (j - m11073a().f7808d >= 60000 && j - m11073a().f7806b >= 60000 && m11073a().f7805a != State.PAUSED && !this.f7817h) {
                m11081b(j);
            }
            if (!(m11073a().f7805a == State.POLL_FOR_NEW_ENTRIES || this.f7816g || j - this.f7815f < 120000)) {
                m11077a(j);
            }
            if (m11073a().f7805a != State.POLL_FOR_NEW_ENTRIES) {
                C2134e.m10673a("TT-EobrMgrMon", "Periodic: " + m11073a().m11071a(j));
            }
        }
    }
}
