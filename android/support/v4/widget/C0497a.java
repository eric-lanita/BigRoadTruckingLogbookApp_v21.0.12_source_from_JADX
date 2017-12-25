package android.support.v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.view.C0474s;
import android.support.v4.view.ag;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.google.android.gms.maps.model.GroundOverlayOptions;

public abstract class C0497a implements OnTouchListener {
    private static final int f1149r = ViewConfiguration.getTapTimeout();
    private final C0495a f1150a = new C0495a();
    private final Interpolator f1151b = new AccelerateInterpolator();
    private final View f1152c;
    private Runnable f1153d;
    private float[] f1154e = new float[]{0.0f, 0.0f};
    private float[] f1155f = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
    private int f1156g;
    private int f1157h;
    private float[] f1158i = new float[]{0.0f, 0.0f};
    private float[] f1159j = new float[]{0.0f, 0.0f};
    private float[] f1160k = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
    private boolean f1161l;
    private boolean f1162m;
    private boolean f1163n;
    private boolean f1164o;
    private boolean f1165p;
    private boolean f1166q;

    private static class C0495a {
        private int f1137a;
        private int f1138b;
        private float f1139c;
        private float f1140d;
        private long f1141e = Long.MIN_VALUE;
        private long f1142f = 0;
        private int f1143g = 0;
        private int f1144h = 0;
        private long f1145i = -1;
        private float f1146j;
        private int f1147k;

        public void m2246a(int i) {
            this.f1137a = i;
        }

        public void m2248b(int i) {
            this.f1138b = i;
        }

        public void m2244a() {
            this.f1141e = AnimationUtils.currentAnimationTimeMillis();
            this.f1145i = -1;
            this.f1142f = this.f1141e;
            this.f1146j = 0.5f;
            this.f1143g = 0;
            this.f1144h = 0;
        }

        public void m2247b() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f1147k = C0497a.m2263b((int) (currentAnimationTimeMillis - this.f1141e), 0, this.f1138b);
            this.f1146j = m2243a(currentAnimationTimeMillis);
            this.f1145i = currentAnimationTimeMillis;
        }

        public boolean m2249c() {
            return this.f1145i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f1145i + ((long) this.f1147k);
        }

        private float m2243a(long j) {
            if (j < this.f1141e) {
                return 0.0f;
            }
            if (this.f1145i < 0 || j < this.f1145i) {
                return C0497a.m2262b(((float) (j - this.f1141e)) / ((float) this.f1137a), 0.0f, 1.0f) * 0.5f;
            }
            long j2 = j - this.f1145i;
            return (C0497a.m2262b(((float) j2) / ((float) this.f1147k), 0.0f, 1.0f) * this.f1146j) + (1.0f - this.f1146j);
        }

        private float m2242a(float f) {
            return ((-4.0f * f) * f) + (4.0f * f);
        }

        public void m2250d() {
            if (this.f1142f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float a = m2242a(m2243a(currentAnimationTimeMillis));
            long j = currentAnimationTimeMillis - this.f1142f;
            this.f1142f = currentAnimationTimeMillis;
            this.f1143g = (int) ((((float) j) * a) * this.f1139c);
            this.f1144h = (int) ((((float) j) * a) * this.f1140d);
        }

        public void m2245a(float f, float f2) {
            this.f1139c = f;
            this.f1140d = f2;
        }

        public int m2251e() {
            return (int) (this.f1139c / Math.abs(this.f1139c));
        }

        public int m2252f() {
            return (int) (this.f1140d / Math.abs(this.f1140d));
        }

        public int m2253g() {
            return this.f1143g;
        }

        public int m2254h() {
            return this.f1144h;
        }
    }

    private class C0496b implements Runnable {
        final /* synthetic */ C0497a f1148a;

        private C0496b(C0497a c0497a) {
            this.f1148a = c0497a;
        }

        public void run() {
            if (this.f1148a.f1164o) {
                if (this.f1148a.f1162m) {
                    this.f1148a.f1162m = false;
                    this.f1148a.f1150a.m2244a();
                }
                C0495a c = this.f1148a.f1150a;
                if (c.m2249c() || !this.f1148a.m2259a()) {
                    this.f1148a.f1164o = false;
                    return;
                }
                if (this.f1148a.f1163n) {
                    this.f1148a.f1163n = false;
                    this.f1148a.m2270d();
                }
                c.m2250d();
                this.f1148a.mo388a(c.m2253g(), c.m2254h());
                ag.m1787a(this.f1148a.f1152c, (Runnable) this);
            }
        }
    }

    public abstract void mo388a(int i, int i2);

    public abstract boolean mo389e(int i);

    public abstract boolean mo390f(int i);

    public C0497a(View view) {
        this.f1152c = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int i = (int) ((1575.0f * displayMetrics.density) + 0.5f);
        int i2 = (int) ((displayMetrics.density * 315.0f) + 0.5f);
        m2276a((float) i, (float) i);
        m2280b((float) i2, (float) i2);
        m2277a(1);
        m2286e(Float.MAX_VALUE, Float.MAX_VALUE);
        m2284d(0.2f, 0.2f);
        m2282c(1.0f, 1.0f);
        m2281b(f1149r);
        m2283c(500);
        m2285d(500);
    }

    public C0497a m2278a(boolean z) {
        if (this.f1165p && !z) {
            m2268c();
        }
        this.f1165p = z;
        return this;
    }

    public C0497a m2276a(float f, float f2) {
        this.f1160k[0] = f / 1000.0f;
        this.f1160k[1] = f2 / 1000.0f;
        return this;
    }

    public C0497a m2280b(float f, float f2) {
        this.f1159j[0] = f / 1000.0f;
        this.f1159j[1] = f2 / 1000.0f;
        return this;
    }

    public C0497a m2282c(float f, float f2) {
        this.f1158i[0] = f / 1000.0f;
        this.f1158i[1] = f2 / 1000.0f;
        return this;
    }

    public C0497a m2277a(int i) {
        this.f1156g = i;
        return this;
    }

    public C0497a m2284d(float f, float f2) {
        this.f1154e[0] = f;
        this.f1154e[1] = f2;
        return this;
    }

    public C0497a m2286e(float f, float f2) {
        this.f1155f[0] = f;
        this.f1155f[1] = f2;
        return this;
    }

    public C0497a m2281b(int i) {
        this.f1157h = i;
        return this;
    }

    public C0497a m2283c(int i) {
        this.f1150a.m2246a(i);
        return this;
    }

    public C0497a m2285d(int i) {
        this.f1150a.m2248b(i);
        return this;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z = true;
        if (!this.f1165p) {
            return false;
        }
        switch (C0474s.m2141a(motionEvent)) {
            case 0:
                this.f1163n = true;
                this.f1161l = false;
                break;
            case 1:
            case 3:
                m2268c();
                break;
            case 2:
                break;
        }
        this.f1150a.m2245a(m2257a(0, motionEvent.getX(), (float) view.getWidth(), (float) this.f1152c.getWidth()), m2257a(1, motionEvent.getY(), (float) view.getHeight(), (float) this.f1152c.getHeight()));
        if (!this.f1164o && m2259a()) {
            m2264b();
        }
        if (!(this.f1166q && this.f1164o)) {
            z = false;
        }
        return z;
    }

    private boolean m2259a() {
        C0495a c0495a = this.f1150a;
        int f = c0495a.m2252f();
        int e = c0495a.m2251e();
        return (f != 0 && mo390f(f)) || (e != 0 && mo389e(e));
    }

    private void m2264b() {
        if (this.f1153d == null) {
            this.f1153d = new C0496b();
        }
        this.f1164o = true;
        this.f1162m = true;
        if (this.f1161l || this.f1157h <= 0) {
            this.f1153d.run();
        } else {
            ag.m1788a(this.f1152c, this.f1153d, (long) this.f1157h);
        }
        this.f1161l = true;
    }

    private void m2268c() {
        if (this.f1162m) {
            this.f1164o = false;
        } else {
            this.f1150a.m2247b();
        }
    }

    private float m2257a(int i, float f, float f2, float f3) {
        float a = m2256a(this.f1154e[i], f2, this.f1155f[i], f);
        if (a == 0.0f) {
            return 0.0f;
        }
        float f4 = this.f1158i[i];
        float f5 = this.f1159j[i];
        float f6 = this.f1160k[i];
        f4 *= f3;
        if (a > 0.0f) {
            return C0497a.m2262b(a * f4, f5, f6);
        }
        return -C0497a.m2262b((-a) * f4, f5, f6);
    }

    private float m2256a(float f, float f2, float f3, float f4) {
        float f5;
        float b = C0497a.m2262b(f * f2, 0.0f, f3);
        b = m2273f(f2 - f4, b) - m2273f(f4, b);
        if (b < 0.0f) {
            f5 = -this.f1151b.getInterpolation(-b);
        } else if (b <= 0.0f) {
            return 0.0f;
        } else {
            f5 = this.f1151b.getInterpolation(b);
        }
        return C0497a.m2262b(f5, (float) GroundOverlayOptions.NO_DIMENSION, 1.0f);
    }

    private float m2273f(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        switch (this.f1156g) {
            case 0:
            case 1:
                if (f >= f2) {
                    return 0.0f;
                }
                if (f >= 0.0f) {
                    return 1.0f - (f / f2);
                }
                if (this.f1164o && this.f1156g == 1) {
                    return 1.0f;
                }
                return 0.0f;
            case 2:
                if (f < 0.0f) {
                    return f / (-f2);
                }
                return 0.0f;
            default:
                return 0.0f;
        }
    }

    private static int m2263b(int i, int i2, int i3) {
        if (i > i3) {
            return i3;
        }
        if (i < i2) {
            return i2;
        }
        return i;
    }

    private static float m2262b(float f, float f2, float f3) {
        if (f > f3) {
            return f3;
        }
        if (f < f2) {
            return f2;
        }
        return f;
    }

    private void m2270d() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f1152c.onTouchEvent(obtain);
        obtain.recycle();
    }
}
