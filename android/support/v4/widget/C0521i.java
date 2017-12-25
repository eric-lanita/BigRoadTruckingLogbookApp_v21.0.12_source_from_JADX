package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;

public final class C0521i {
    private static final C0517c f1212b;
    private Object f1213a;

    interface C0517c {
        Object mo379a(Context context);

        void mo380a(Object obj, int i, int i2);

        boolean mo381a(Object obj);

        boolean mo382a(Object obj, float f);

        boolean mo383a(Object obj, float f, float f2);

        boolean mo384a(Object obj, int i);

        boolean mo385a(Object obj, Canvas canvas);

        void mo386b(Object obj);

        boolean mo387c(Object obj);
    }

    static class C0518a implements C0517c {
        C0518a() {
        }

        public Object mo379a(Context context) {
            return null;
        }

        public void mo380a(Object obj, int i, int i2) {
        }

        public boolean mo381a(Object obj) {
            return true;
        }

        public void mo386b(Object obj) {
        }

        public boolean mo382a(Object obj, float f) {
            return false;
        }

        public boolean mo387c(Object obj) {
            return false;
        }

        public boolean mo384a(Object obj, int i) {
            return false;
        }

        public boolean mo385a(Object obj, Canvas canvas) {
            return false;
        }

        public boolean mo383a(Object obj, float f, float f2) {
            return false;
        }
    }

    static class C0519b implements C0517c {
        C0519b() {
        }

        public Object mo379a(Context context) {
            return C0522j.m2411a(context);
        }

        public void mo380a(Object obj, int i, int i2) {
            C0522j.m2412a(obj, i, i2);
        }

        public boolean mo381a(Object obj) {
            return C0522j.m2413a(obj);
        }

        public void mo386b(Object obj) {
            C0522j.m2417b(obj);
        }

        public boolean mo382a(Object obj, float f) {
            return C0522j.m2414a(obj, f);
        }

        public boolean mo387c(Object obj) {
            return C0522j.m2418c(obj);
        }

        public boolean mo384a(Object obj, int i) {
            return C0522j.m2415a(obj, i);
        }

        public boolean mo385a(Object obj, Canvas canvas) {
            return C0522j.m2416a(obj, canvas);
        }

        public boolean mo383a(Object obj, float f, float f2) {
            return C0522j.m2414a(obj, f);
        }
    }

    static class C0520d extends C0519b {
        C0520d() {
        }

        public boolean mo383a(Object obj, float f, float f2) {
            return C0523k.m2419a(obj, f, f2);
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f1212b = new C0520d();
        } else if (VERSION.SDK_INT >= 14) {
            f1212b = new C0519b();
        } else {
            f1212b = new C0518a();
        }
    }

    public C0521i(Context context) {
        this.f1213a = f1212b.mo379a(context);
    }

    public void m2403a(int i, int i2) {
        f1212b.mo380a(this.f1213a, i, i2);
    }

    public boolean m2404a() {
        return f1212b.mo381a(this.f1213a);
    }

    public void m2409b() {
        f1212b.mo386b(this.f1213a);
    }

    public boolean m2405a(float f) {
        return f1212b.mo382a(this.f1213a, f);
    }

    public boolean m2406a(float f, float f2) {
        return f1212b.mo383a(this.f1213a, f, f2);
    }

    public boolean m2410c() {
        return f1212b.mo387c(this.f1213a);
    }

    public boolean m2407a(int i) {
        return f1212b.mo384a(this.f1213a, i);
    }

    public boolean m2408a(Canvas canvas) {
        return f1212b.mo385a(this.f1213a, canvas);
    }
}
