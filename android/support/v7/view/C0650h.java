package android.support.v7.view;

import android.support.v4.view.ax;
import android.support.v4.view.bb;
import android.support.v4.view.bc;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

public class C0650h {
    private final ArrayList<ax> f1605a = new ArrayList();
    private long f1606b = -1;
    private Interpolator f1607c;
    private bb f1608d;
    private boolean f1609e;
    private final bc f1610f = new C06491(this);

    class C06491 extends bc {
        final /* synthetic */ C0650h f1602a;
        private boolean f1603b = false;
        private int f1604c = 0;

        C06491(C0650h c0650h) {
            this.f1602a = c0650h;
        }

        public void mo326a(View view) {
            if (!this.f1603b) {
                this.f1603b = true;
                if (this.f1602a.f1608d != null) {
                    this.f1602a.f1608d.mo326a(null);
                }
            }
        }

        void m3036a() {
            this.f1604c = 0;
            this.f1603b = false;
            this.f1602a.m3042c();
        }

        public void mo327b(View view) {
            int i = this.f1604c + 1;
            this.f1604c = i;
            if (i == this.f1602a.f1605a.size()) {
                if (this.f1602a.f1608d != null) {
                    this.f1602a.f1608d.mo327b(null);
                }
                m3036a();
            }
        }
    }

    public C0650h m3044a(ax axVar) {
        if (!this.f1609e) {
            this.f1605a.add(axVar);
        }
        return this;
    }

    public C0650h m3045a(ax axVar, ax axVar2) {
        this.f1605a.add(axVar);
        axVar2.m1987b(axVar.m1980a());
        this.f1605a.add(axVar2);
        return this;
    }

    public void m3048a() {
        if (!this.f1609e) {
            Iterator it = this.f1605a.iterator();
            while (it.hasNext()) {
                ax axVar = (ax) it.next();
                if (this.f1606b >= 0) {
                    axVar.m1982a(this.f1606b);
                }
                if (this.f1607c != null) {
                    axVar.m1985a(this.f1607c);
                }
                if (this.f1608d != null) {
                    axVar.m1983a(this.f1610f);
                }
                axVar.m1989c();
            }
            this.f1609e = true;
        }
    }

    private void m3042c() {
        this.f1609e = false;
    }

    public void m3049b() {
        if (this.f1609e) {
            Iterator it = this.f1605a.iterator();
            while (it.hasNext()) {
                ((ax) it.next()).m1988b();
            }
            this.f1609e = false;
        }
    }

    public C0650h m3043a(long j) {
        if (!this.f1609e) {
            this.f1606b = j;
        }
        return this;
    }

    public C0650h m3047a(Interpolator interpolator) {
        if (!this.f1609e) {
            this.f1607c = interpolator;
        }
        return this;
    }

    public C0650h m3046a(bb bbVar) {
        if (!this.f1609e) {
            this.f1608d = bbVar;
        }
        return this;
    }
}
