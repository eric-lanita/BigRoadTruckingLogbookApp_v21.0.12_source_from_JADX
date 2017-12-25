package com.bigroad.ttb.android.status.p031a;

import android.os.Handler;
import com.bigroad.shared.ap;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.status.C2264e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class C2241e {
    private final Runnable f7761a = new C22611(this);
    private final ap f7762b = OurApplication.m6269Z();
    private List<C2264e> f7763c = new ArrayList();
    private final Set<C1441a> f7764d = new HashSet();
    private final Handler f7765e = new Handler();

    public interface C1441a {
        void mo996a(C2241e c2241e);
    }

    class C22611 implements Runnable {
        final /* synthetic */ C2241e f7853a;

        C22611(C2241e c2241e) {
            this.f7853a = c2241e;
        }

        public void run() {
            this.f7853a.m11047a(true);
        }
    }

    protected abstract boolean mo1262c();

    protected abstract List<C2264e> mo1263d();

    public C2241e() {
        this.f7765e.post(this.f7761a);
    }

    public void m11052f() {
        m11047a(false);
    }

    private void m11047a(boolean z) {
        boolean c = mo1262c();
        if (c) {
            synchronized (this) {
                List d = mo1263d();
                if (d != null) {
                    this.f7763c = d;
                } else {
                    c = false;
                }
            }
        }
        if (c || z) {
            synchronized (this) {
                this.f7765e.removeCallbacks(this.f7761a);
                long c2 = this.f7762b.mo915c();
                long j = c2;
                for (C2264e c2264e : this.f7763c) {
                    long longValue;
                    long c3 = c2264e.m11110c();
                    if (c3 > c2 && (j <= c2 || c3 < j)) {
                        j = c3;
                    }
                    if (c2264e.m11111d() != null) {
                        longValue = c2264e.m11111d().longValue() + c3;
                        if (longValue > c2) {
                            if (j > c2) {
                                if (longValue < j) {
                                }
                            }
                            j = longValue;
                        }
                    }
                    longValue = j;
                    j = longValue;
                }
                if (j > c2) {
                    this.f7765e.postDelayed(this.f7761a, j - c2);
                }
            }
            m11045a();
        }
    }

    public List<C2264e> m11053g() {
        List arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.f7763c);
        }
        return arrayList;
    }

    public List<C2264e> m11054h() {
        List<C2264e> arrayList = new ArrayList();
        long c = this.f7762b.mo915c();
        for (C2264e c2264e : m11053g()) {
            if (c2264e.m11108a(c)) {
                arrayList.add(c2264e);
            }
        }
        return arrayList;
    }

    public C2264e m11055i() {
        for (C2264e c2264e : m11054h()) {
            if (c2264e.m11109b().mo1265c(OurApplication.m6279b()) != null) {
                return c2264e;
            }
        }
        return null;
    }

    public void m11048a(C1441a c1441a) {
        this.f7764d.add(c1441a);
    }

    public void m11049b(C1441a c1441a) {
        this.f7764d.remove(c1441a);
    }

    private void m11045a() {
        for (C1441a a : (C1441a[]) this.f7764d.toArray(new C1441a[this.f7764d.size()])) {
            a.mo996a(this);
        }
    }
}
