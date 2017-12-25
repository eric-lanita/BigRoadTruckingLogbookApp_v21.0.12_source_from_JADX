package com.bigroad.ttb.android.logging;

import android.os.Handler;
import android.os.Looper;
import com.bigroad.shared.RemoteLogPriority;
import com.bigroad.ttb.android.C2474y;
import com.bigroad.ttb.android.C2474y.C1183b;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.PowerStatus;
import com.bigroad.ttb.android.PowerStatus.C1216a;
import com.bigroad.ttb.android.p035d.C1790a;
import com.facebook.internal.NativeProtocol;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class C2146k implements C2127h {
    private final C1790a f7472a;
    private final Handler f7473b;
    private final Runnable f7474c;
    private RemoteLogPriority f7475d;
    private long f7476e;
    private List<C2136g> f7477f;
    private int f7478g;
    private List<List<C2136g>> f7479h;
    private volatile boolean f7480i;
    private boolean f7481j;

    class C21401 implements Runnable {
        final /* synthetic */ C2146k f7466a;

        C21401(C2146k c2146k) {
            this.f7466a = c2146k;
        }

        public void run() {
            this.f7466a.m10715f();
        }
    }

    class C21412 extends C1183b {
        final /* synthetic */ C2146k f7467a;

        C21412(C2146k c2146k) {
            this.f7467a = c2146k;
        }

        public void mo865b(C2474y c2474y) {
            this.f7467a.m10703a(c2474y.m12235y());
        }
    }

    class C21423 implements C1216a {
        final /* synthetic */ C2146k f7468a;

        C21423(C2146k c2146k) {
            this.f7468a = c2146k;
        }

        public void mo908a(PowerStatus powerStatus) {
            this.f7468a.m10702a(C2146k.m10707b(powerStatus));
        }
    }

    class C21434 implements Runnable {
        final /* synthetic */ C2146k f7469a;

        C21434(C2146k c2146k) {
            this.f7469a = c2146k;
        }

        public void run() {
            this.f7469a.m10714e();
        }
    }

    private static class C2144a implements Runnable {
        private final C2146k f7470a;

        public C2144a(C2146k c2146k) {
            this.f7470a = c2146k;
        }

        public void run() {
            for (Iterable a : this.f7470a.m10719j()) {
                OurApplication.m6289k().m6480a(a);
            }
        }
    }

    private static class C2145b {
        private static final C2146k f7471a = new C2146k();
    }

    public static C2146k m10708b() {
        return C2145b.f7471a;
    }

    private C2146k() {
        this.f7472a = OurApplication.m6287i();
        this.f7474c = new C21401(this);
        this.f7480i = false;
        this.f7481j = false;
        this.f7473b = new Handler();
        this.f7475d = OurApplication.m6285g().m12235y();
        this.f7476e = C2146k.m10707b(OurApplication.m6286h());
        this.f7479h = new ArrayList();
        m10718i();
        m10713d();
        OurApplication.m6285g().m12184a(new C21412(this));
        OurApplication.m6286h().m6311a(new C21423(this));
    }

    private static long m10707b(PowerStatus powerStatus) {
        return powerStatus.m6312a() ? 30000 : 300000;
    }

    private synchronized void m10713d() {
        Collection E = this.f7472a.m8710E();
        if (!E.isEmpty()) {
            C2134e.m10678c("TT-RemoteLogManager", "Sending " + E.size() + " RemoteLogEventRequests that were flushed to the database");
            this.f7479h.addAll(E);
            new C2144a(this).run();
            this.f7472a.m8711F();
        }
    }

    private synchronized void m10714e() {
        if (Looper.getMainLooper().equals(Looper.myLooper()) && this.f7480i && !this.f7481j) {
            this.f7481j = true;
            try {
                m10713d();
                this.f7480i = false;
                this.f7481j = false;
            } catch (Throwable th) {
                this.f7480i = false;
                this.f7481j = false;
            }
        }
    }

    private synchronized void m10709b(int i, String str, String str2) {
        m10714e();
        boolean isEmpty = this.f7477f.isEmpty();
        C2136g c2136g = new C2136g(i, str, str2);
        this.f7477f.add(c2136g);
        this.f7478g = c2136g.m10684b() + this.f7478g;
        if (this.f7478g > NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST && !this.f7481j) {
            m10715f();
        } else if (isEmpty) {
            m10716g();
        }
    }

    public synchronized void mo1242a(int i, String str, String str2) {
        if (m10711b(C2138i.m10693b(i))) {
            m10709b(i, str, str2);
        }
    }

    public synchronized void mo1243a(long j, int i, String str, String str2) {
        Long C = OurApplication.m6285g().m12158C();
        if (C != null) {
            if ((C.longValue() & j) != 0) {
                m10709b(i, str, str2);
            } else {
                mo1242a(i, str, str2);
            }
        }
    }

    public synchronized void mo1241a() {
        m10723c();
    }

    private synchronized void m10715f() {
        m10717h();
        m10714e();
        if (!this.f7477f.isEmpty()) {
            this.f7479h.add(this.f7477f);
            this.f7473b.post(new C2144a(this));
            m10718i();
        }
    }

    public void m10723c() {
        synchronized (this) {
            List arrayList = new ArrayList(this.f7477f);
            m10718i();
        }
        if (!Looper.getMainLooper().equals(Looper.myLooper())) {
            List<List> arrayList2;
            C2134e.m10678c("TT-RemoteLogManager", "Synchronous flush on non-UI thread (" + Thread.currentThread().getName() + ")");
            synchronized (this) {
                this.f7479h.add(arrayList);
                arrayList2 = new ArrayList(this.f7479h);
                this.f7479h.clear();
            }
            if (!arrayList2.isEmpty()) {
                for (List arrayList3 : arrayList2) {
                    this.f7472a.m8800m(arrayList3);
                }
                this.f7480i = true;
            }
            this.f7473b.post(new C21434(this));
        } else if (!arrayList3.isEmpty()) {
            this.f7479h.add(arrayList3);
            new C2144a(this).run();
        }
    }

    private synchronized void m10703a(RemoteLogPriority remoteLogPriority) {
        if (remoteLogPriority != this.f7475d) {
            this.f7475d = remoteLogPriority;
            m10715f();
        }
    }

    private synchronized void m10702a(long j) {
        if (this.f7476e != j) {
            this.f7476e = j;
            m10715f();
        }
    }

    private synchronized void m10716g() {
        m10717h();
        if (!this.f7477f.isEmpty()) {
            this.f7473b.postDelayed(this.f7474c, this.f7476e);
        }
    }

    private void m10717h() {
        this.f7473b.removeCallbacks(this.f7474c);
    }

    private synchronized void m10718i() {
        this.f7477f = new ArrayList();
        this.f7478g = 0;
    }

    private boolean m10711b(RemoteLogPriority remoteLogPriority) {
        return this.f7475d != null && this.f7475d.m4100a(remoteLogPriority);
    }

    private List<List<C2136g>> m10719j() {
        List arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.f7479h);
            this.f7479h.clear();
        }
        return arrayList;
    }
}
