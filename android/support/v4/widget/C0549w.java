package android.support.v4.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public final class C0549w {
    Object f1265a;
    C0545a f1266b;

    interface C0545a {
        Object mo396a(Context context, Interpolator interpolator);

        void mo397a(Object obj, int i, int i2, int i3, int i4);

        void mo398a(Object obj, int i, int i2, int i3, int i4, int i5);

        void mo399a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8);

        void mo400a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10);

        boolean mo401a(Object obj);

        boolean mo402a(Object obj, int i, int i2, int i3, int i4, int i5, int i6);

        int mo403b(Object obj);

        int mo404c(Object obj);

        float mo405d(Object obj);

        boolean mo406e(Object obj);

        void mo407f(Object obj);

        int mo408g(Object obj);

        int mo409h(Object obj);
    }

    static class C0546b implements C0545a {
        C0546b() {
        }

        public Object mo396a(Context context, Interpolator interpolator) {
            return interpolator != null ? new Scroller(context, interpolator) : new Scroller(context);
        }

        public boolean mo401a(Object obj) {
            return ((Scroller) obj).isFinished();
        }

        public int mo403b(Object obj) {
            return ((Scroller) obj).getCurrX();
        }

        public int mo404c(Object obj) {
            return ((Scroller) obj).getCurrY();
        }

        public float mo405d(Object obj) {
            return 0.0f;
        }

        public boolean mo406e(Object obj) {
            return ((Scroller) obj).computeScrollOffset();
        }

        public void mo397a(Object obj, int i, int i2, int i3, int i4) {
            ((Scroller) obj).startScroll(i, i2, i3, i4);
        }

        public void mo398a(Object obj, int i, int i2, int i3, int i4, int i5) {
            ((Scroller) obj).startScroll(i, i2, i3, i4, i5);
        }

        public void mo399a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            ((Scroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
        }

        public void mo400a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
            ((Scroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
        }

        public void mo407f(Object obj) {
            ((Scroller) obj).abortAnimation();
        }

        public int mo408g(Object obj) {
            return ((Scroller) obj).getFinalX();
        }

        public int mo409h(Object obj) {
            return ((Scroller) obj).getFinalY();
        }

        public boolean mo402a(Object obj, int i, int i2, int i3, int i4, int i5, int i6) {
            return false;
        }
    }

    static class C0547c implements C0545a {
        C0547c() {
        }

        public Object mo396a(Context context, Interpolator interpolator) {
            return C0550x.m2557a(context, interpolator);
        }

        public boolean mo401a(Object obj) {
            return C0550x.m2562a(obj);
        }

        public int mo403b(Object obj) {
            return C0550x.m2564b(obj);
        }

        public int mo404c(Object obj) {
            return C0550x.m2565c(obj);
        }

        public float mo405d(Object obj) {
            return 0.0f;
        }

        public boolean mo406e(Object obj) {
            return C0550x.m2566d(obj);
        }

        public void mo397a(Object obj, int i, int i2, int i3, int i4) {
            C0550x.m2558a(obj, i, i2, i3, i4);
        }

        public void mo398a(Object obj, int i, int i2, int i3, int i4, int i5) {
            C0550x.m2559a(obj, i, i2, i3, i4, i5);
        }

        public void mo399a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            C0550x.m2560a(obj, i, i2, i3, i4, i5, i6, i7, i8);
        }

        public void mo400a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
            C0550x.m2561a(obj, i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
        }

        public void mo407f(Object obj) {
            C0550x.m2567e(obj);
        }

        public int mo408g(Object obj) {
            return C0550x.m2568f(obj);
        }

        public int mo409h(Object obj) {
            return C0550x.m2569g(obj);
        }

        public boolean mo402a(Object obj, int i, int i2, int i3, int i4, int i5, int i6) {
            return C0550x.m2563a(obj, i, i2, i3, i4, i5, i6);
        }
    }

    static class C0548d extends C0547c {
        C0548d() {
        }

        public float mo405d(Object obj) {
            return C0551y.m2570a(obj);
        }
    }

    public static C0549w m2542a(Context context) {
        return C0549w.m2543a(context, null);
    }

    public static C0549w m2543a(Context context, Interpolator interpolator) {
        return new C0549w(VERSION.SDK_INT, context, interpolator);
    }

    private C0549w(int i, Context context, Interpolator interpolator) {
        if (i >= 14) {
            this.f1266b = new C0548d();
        } else if (i >= 9) {
            this.f1266b = new C0547c();
        } else {
            this.f1266b = new C0546b();
        }
        this.f1265a = this.f1266b.mo396a(context, interpolator);
    }

    public boolean m2548a() {
        return this.f1266b.mo401a(this.f1265a);
    }

    public int m2550b() {
        return this.f1266b.mo403b(this.f1265a);
    }

    public int m2551c() {
        return this.f1266b.mo404c(this.f1265a);
    }

    public int m2552d() {
        return this.f1266b.mo408g(this.f1265a);
    }

    public int m2553e() {
        return this.f1266b.mo409h(this.f1265a);
    }

    public float m2554f() {
        return this.f1266b.mo405d(this.f1265a);
    }

    public boolean m2555g() {
        return this.f1266b.mo406e(this.f1265a);
    }

    public void m2544a(int i, int i2, int i3, int i4) {
        this.f1266b.mo397a(this.f1265a, i, i2, i3, i4);
    }

    public void m2545a(int i, int i2, int i3, int i4, int i5) {
        this.f1266b.mo398a(this.f1265a, i, i2, i3, i4, i5);
    }

    public void m2546a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.f1266b.mo399a(this.f1265a, i, i2, i3, i4, i5, i6, i7, i8);
    }

    public void m2547a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.f1266b.mo400a(this.f1265a, i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    public boolean m2549a(int i, int i2, int i3, int i4, int i5, int i6) {
        return this.f1266b.mo402a(this.f1265a, i, i2, i3, i4, i5, i6);
    }

    public void m2556h() {
        this.f1266b.mo407f(this.f1265a);
    }
}
