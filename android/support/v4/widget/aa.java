package android.support.v4.widget;

import android.content.Context;
import android.support.v4.view.C0474s;
import android.support.v4.view.ae;
import android.support.v4.view.ag;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.Arrays;

public class aa {
    private static final Interpolator f1168v = new C04981();
    private int f1169a;
    private int f1170b;
    private int f1171c = -1;
    private float[] f1172d;
    private float[] f1173e;
    private float[] f1174f;
    private float[] f1175g;
    private int[] f1176h;
    private int[] f1177i;
    private int[] f1178j;
    private int f1179k;
    private VelocityTracker f1180l;
    private float f1181m;
    private float f1182n;
    private int f1183o;
    private int f1184p;
    private C0549w f1185q;
    private final C0500a f1186r;
    private View f1187s;
    private boolean f1188t;
    private final ViewGroup f1189u;
    private final Runnable f1190w = new C04992(this);

    static class C04981 implements Interpolator {
        C04981() {
        }

        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    }

    class C04992 implements Runnable {
        final /* synthetic */ aa f1167a;

        C04992(aa aaVar) {
            this.f1167a = aaVar;
        }

        public void run() {
            this.f1167a.m2330b(0);
        }
    }

    public static abstract class C0500a {
        public abstract boolean mo2844b(View view, int i);

        public void mo2839a(int i) {
        }

        public void mo2842a(View view, int i, int i2, int i3, int i4) {
        }

        public void mo2841a(View view, int i) {
        }

        public void mo2840a(View view, float f, float f2) {
        }

        public void m2292a(int i, int i2) {
        }

        public boolean m2299b(int i) {
            return false;
        }

        public void m2298b(int i, int i2) {
        }

        public int m2301c(int i) {
            return i;
        }

        public int m2289a(View view) {
            return 0;
        }

        public int m2296b(View view) {
            return 0;
        }

        public int mo2838a(View view, int i, int i2) {
            return 0;
        }

        public int mo2843b(View view, int i, int i2) {
            return 0;
        }
    }

    public static aa m2306a(ViewGroup viewGroup, C0500a c0500a) {
        return new aa(viewGroup.getContext(), viewGroup, c0500a);
    }

    private aa(Context context, ViewGroup viewGroup, C0500a c0500a) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (c0500a == null) {
            throw new IllegalArgumentException("Callback may not be null");
        } else {
            this.f1189u = viewGroup;
            this.f1186r = c0500a;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.f1183o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.f1170b = viewConfiguration.getScaledTouchSlop();
            this.f1181m = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.f1182n = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.f1185q = C0549w.m2543a(context, f1168v);
        }
    }

    public int m2322a() {
        return this.f1169a;
    }

    public void m2323a(View view, int i) {
        if (view.getParent() != this.f1189u) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f1189u + ")");
        }
        this.f1187s = view;
        this.f1171c = i;
        this.f1186r.mo2841a(view, i);
        m2330b(1);
    }

    public View m2329b() {
        return this.f1187s;
    }

    public int m2334c() {
        return this.f1170b;
    }

    public void m2338d() {
        this.f1171c = -1;
        m2318e();
        if (this.f1180l != null) {
            this.f1180l.recycle();
            this.f1180l = null;
        }
    }

    public boolean m2325a(int i, int i2) {
        if (this.f1188t) {
            return m2310a(i, i2, (int) ae.m1622a(this.f1180l, this.f1171c), (int) ae.m1623b(this.f1180l, this.f1171c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    private boolean m2310a(int i, int i2, int i3, int i4) {
        int left = this.f1187s.getLeft();
        int top = this.f1187s.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.f1185q.m2556h();
            m2330b(0);
            return false;
        }
        this.f1185q.m2545a(left, top, i5, i6, m2305a(this.f1187s, i5, i6, i3, i4));
        m2330b(2);
        return true;
    }

    private int m2305a(View view, int i, int i2, int i3, int i4) {
        int b = m2312b(i3, (int) this.f1182n, (int) this.f1181m);
        int b2 = m2312b(i4, (int) this.f1182n, (int) this.f1181m);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(b);
        int abs4 = Math.abs(b2);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        return (int) (((b2 != 0 ? ((float) abs4) / ((float) i5) : ((float) abs2) / ((float) i6)) * ((float) m2304a(i2, b2, this.f1186r.m2296b(view)))) + ((b != 0 ? ((float) abs3) / ((float) i5) : ((float) abs) / ((float) i6)) * ((float) m2304a(i, b, this.f1186r.m2289a(view)))));
    }

    private int m2304a(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.f1189u.getWidth();
        int i4 = width / 2;
        float a = (m2302a(Math.min(1.0f, ((float) Math.abs(i)) / ((float) width))) * ((float) i4)) + ((float) i4);
        i4 = Math.abs(i2);
        if (i4 > 0) {
            width = Math.round(Math.abs(a / ((float) i4)) * 1000.0f) * 4;
        } else {
            width = (int) (((((float) Math.abs(i)) / ((float) i3)) + 1.0f) * 256.0f);
        }
        return Math.min(width, 600);
    }

    private int m2312b(int i, int i2, int i3) {
        int abs = Math.abs(i);
        if (abs < i2) {
            return 0;
        }
        if (abs <= i3) {
            return i;
        }
        if (i <= 0) {
            return -i3;
        }
        return i3;
    }

    private float m2303a(float f, float f2, float f3) {
        float abs = Math.abs(f);
        if (abs < f2) {
            return 0.0f;
        }
        if (abs <= f3) {
            return f;
        }
        if (f <= 0.0f) {
            return -f3;
        }
        return f3;
    }

    private float m2302a(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    public boolean m2328a(boolean z) {
        if (this.f1169a == 2) {
            int i;
            boolean g = this.f1185q.m2555g();
            int b = this.f1185q.m2550b();
            int c = this.f1185q.m2551c();
            int left = b - this.f1187s.getLeft();
            int top = c - this.f1187s.getTop();
            if (left != 0) {
                ag.m1805e(this.f1187s, left);
            }
            if (top != 0) {
                ag.m1802d(this.f1187s, top);
            }
            if (!(left == 0 && top == 0)) {
                this.f1186r.mo2842a(this.f1187s, b, c, left, top);
            }
            if (g && b == this.f1185q.m2552d() && c == this.f1185q.m2553e()) {
                this.f1185q.m2556h();
                i = 0;
            } else {
                boolean z2 = g;
            }
            if (i == 0) {
                if (z) {
                    this.f1189u.post(this.f1190w);
                } else {
                    m2330b(0);
                }
            }
        }
        return this.f1169a == 2;
    }

    private void m2307a(float f, float f2) {
        this.f1188t = true;
        this.f1186r.mo2840a(this.f1187s, f, f2);
        this.f1188t = false;
        if (this.f1169a == 1) {
            m2330b(0);
        }
    }

    private void m2318e() {
        if (this.f1172d != null) {
            Arrays.fill(this.f1172d, 0.0f);
            Arrays.fill(this.f1173e, 0.0f);
            Arrays.fill(this.f1174f, 0.0f);
            Arrays.fill(this.f1175g, 0.0f);
            Arrays.fill(this.f1176h, 0);
            Arrays.fill(this.f1177i, 0);
            Arrays.fill(this.f1178j, 0);
            this.f1179k = 0;
        }
    }

    private void m2316d(int i) {
        if (this.f1172d != null) {
            this.f1172d[i] = 0.0f;
            this.f1173e[i] = 0.0f;
            this.f1174f[i] = 0.0f;
            this.f1175g[i] = 0.0f;
            this.f1176h[i] = 0;
            this.f1177i[i] = 0;
            this.f1178j[i] = 0;
            this.f1179k &= (1 << i) ^ -1;
        }
    }

    private void m2319e(int i) {
        if (this.f1172d == null || this.f1172d.length <= i) {
            Object obj = new float[(i + 1)];
            Object obj2 = new float[(i + 1)];
            Object obj3 = new float[(i + 1)];
            Object obj4 = new float[(i + 1)];
            Object obj5 = new int[(i + 1)];
            Object obj6 = new int[(i + 1)];
            Object obj7 = new int[(i + 1)];
            if (this.f1172d != null) {
                System.arraycopy(this.f1172d, 0, obj, 0, this.f1172d.length);
                System.arraycopy(this.f1173e, 0, obj2, 0, this.f1173e.length);
                System.arraycopy(this.f1174f, 0, obj3, 0, this.f1174f.length);
                System.arraycopy(this.f1175g, 0, obj4, 0, this.f1175g.length);
                System.arraycopy(this.f1176h, 0, obj5, 0, this.f1176h.length);
                System.arraycopy(this.f1177i, 0, obj6, 0, this.f1177i.length);
                System.arraycopy(this.f1178j, 0, obj7, 0, this.f1178j.length);
            }
            this.f1172d = obj;
            this.f1173e = obj2;
            this.f1174f = obj3;
            this.f1175g = obj4;
            this.f1176h = obj5;
            this.f1177i = obj6;
            this.f1178j = obj7;
        }
    }

    private void m2308a(float f, float f2, int i) {
        m2319e(i);
        float[] fArr = this.f1172d;
        this.f1174f[i] = f;
        fArr[i] = f;
        fArr = this.f1173e;
        this.f1175g[i] = f2;
        fArr[i] = f2;
        this.f1176h[i] = m2317e((int) f, (int) f2);
        this.f1179k |= 1 << i;
    }

    private void m2315c(MotionEvent motionEvent) {
        int c = C0474s.m2146c(motionEvent);
        for (int i = 0; i < c; i++) {
            int b = C0474s.m2144b(motionEvent, i);
            float c2 = C0474s.m2145c(motionEvent, i);
            float d = C0474s.m2147d(motionEvent, i);
            this.f1174f[b] = c2;
            this.f1175g[b] = d;
        }
    }

    public boolean m2324a(int i) {
        return (this.f1179k & (1 << i)) != 0;
    }

    void m2330b(int i) {
        this.f1189u.removeCallbacks(this.f1190w);
        if (this.f1169a != i) {
            this.f1169a = i;
            this.f1186r.mo2839a(i);
            if (this.f1169a == 0) {
                this.f1187s = null;
            }
        }
    }

    boolean m2333b(View view, int i) {
        if (view == this.f1187s && this.f1171c == i) {
            return true;
        }
        if (view == null || !this.f1186r.mo2844b(view, i)) {
            return false;
        }
        this.f1171c = i;
        m2323a(view, i);
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m2326a(android.view.MotionEvent r14) {
        /*
        r13 = this;
        r0 = android.support.v4.view.C0474s.m2141a(r14);
        r1 = android.support.v4.view.C0474s.m2143b(r14);
        if (r0 != 0) goto L_0x000d;
    L_0x000a:
        r13.m2338d();
    L_0x000d:
        r2 = r13.f1180l;
        if (r2 != 0) goto L_0x0017;
    L_0x0011:
        r2 = android.view.VelocityTracker.obtain();
        r13.f1180l = r2;
    L_0x0017:
        r2 = r13.f1180l;
        r2.addMovement(r14);
        switch(r0) {
            case 0: goto L_0x0026;
            case 1: goto L_0x0128;
            case 2: goto L_0x0092;
            case 3: goto L_0x0128;
            case 4: goto L_0x001f;
            case 5: goto L_0x005a;
            case 6: goto L_0x011f;
            default: goto L_0x001f;
        };
    L_0x001f:
        r0 = r13.f1169a;
        r1 = 1;
        if (r0 != r1) goto L_0x012d;
    L_0x0024:
        r0 = 1;
    L_0x0025:
        return r0;
    L_0x0026:
        r0 = r14.getX();
        r1 = r14.getY();
        r2 = 0;
        r2 = android.support.v4.view.C0474s.m2144b(r14, r2);
        r13.m2308a(r0, r1, r2);
        r0 = (int) r0;
        r1 = (int) r1;
        r0 = r13.m2337d(r0, r1);
        r1 = r13.f1187s;
        if (r0 != r1) goto L_0x0048;
    L_0x0040:
        r1 = r13.f1169a;
        r3 = 2;
        if (r1 != r3) goto L_0x0048;
    L_0x0045:
        r13.m2333b(r0, r2);
    L_0x0048:
        r0 = r13.f1176h;
        r0 = r0[r2];
        r1 = r13.f1184p;
        r1 = r1 & r0;
        if (r1 == 0) goto L_0x001f;
    L_0x0051:
        r1 = r13.f1186r;
        r3 = r13.f1184p;
        r0 = r0 & r3;
        r1.m2292a(r0, r2);
        goto L_0x001f;
    L_0x005a:
        r0 = android.support.v4.view.C0474s.m2144b(r14, r1);
        r2 = android.support.v4.view.C0474s.m2145c(r14, r1);
        r1 = android.support.v4.view.C0474s.m2147d(r14, r1);
        r13.m2308a(r2, r1, r0);
        r3 = r13.f1169a;
        if (r3 != 0) goto L_0x007f;
    L_0x006d:
        r1 = r13.f1176h;
        r1 = r1[r0];
        r2 = r13.f1184p;
        r2 = r2 & r1;
        if (r2 == 0) goto L_0x001f;
    L_0x0076:
        r2 = r13.f1186r;
        r3 = r13.f1184p;
        r1 = r1 & r3;
        r2.m2292a(r1, r0);
        goto L_0x001f;
    L_0x007f:
        r3 = r13.f1169a;
        r4 = 2;
        if (r3 != r4) goto L_0x001f;
    L_0x0084:
        r2 = (int) r2;
        r1 = (int) r1;
        r1 = r13.m2337d(r2, r1);
        r2 = r13.f1187s;
        if (r1 != r2) goto L_0x001f;
    L_0x008e:
        r13.m2333b(r1, r0);
        goto L_0x001f;
    L_0x0092:
        r0 = r13.f1172d;
        if (r0 == 0) goto L_0x001f;
    L_0x0096:
        r0 = r13.f1173e;
        if (r0 == 0) goto L_0x001f;
    L_0x009a:
        r2 = android.support.v4.view.C0474s.m2146c(r14);
        r0 = 0;
        r1 = r0;
    L_0x00a0:
        if (r1 >= r2) goto L_0x0107;
    L_0x00a2:
        r3 = android.support.v4.view.C0474s.m2144b(r14, r1);
        r0 = r13.m2321f(r3);
        if (r0 != 0) goto L_0x00b0;
    L_0x00ac:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x00a0;
    L_0x00b0:
        r0 = android.support.v4.view.C0474s.m2145c(r14, r1);
        r4 = android.support.v4.view.C0474s.m2147d(r14, r1);
        r5 = r13.f1172d;
        r5 = r5[r3];
        r5 = r0 - r5;
        r6 = r13.f1173e;
        r6 = r6[r3];
        r6 = r4 - r6;
        r0 = (int) r0;
        r4 = (int) r4;
        r4 = r13.m2337d(r0, r4);
        if (r4 == 0) goto L_0x010c;
    L_0x00cc:
        r0 = r13.m2311a(r4, r5, r6);
        if (r0 == 0) goto L_0x010c;
    L_0x00d2:
        r0 = 1;
    L_0x00d3:
        if (r0 == 0) goto L_0x010e;
    L_0x00d5:
        r7 = r4.getLeft();
        r8 = (int) r5;
        r8 = r8 + r7;
        r9 = r13.f1186r;
        r10 = (int) r5;
        r8 = r9.mo2838a(r4, r8, r10);
        r9 = r4.getTop();
        r10 = (int) r6;
        r10 = r10 + r9;
        r11 = r13.f1186r;
        r12 = (int) r6;
        r10 = r11.mo2843b(r4, r10, r12);
        r11 = r13.f1186r;
        r11 = r11.m2289a(r4);
        r12 = r13.f1186r;
        r12 = r12.m2296b(r4);
        if (r11 == 0) goto L_0x0101;
    L_0x00fd:
        if (r11 <= 0) goto L_0x010e;
    L_0x00ff:
        if (r8 != r7) goto L_0x010e;
    L_0x0101:
        if (r12 == 0) goto L_0x0107;
    L_0x0103:
        if (r12 <= 0) goto L_0x010e;
    L_0x0105:
        if (r10 != r9) goto L_0x010e;
    L_0x0107:
        r13.m2315c(r14);
        goto L_0x001f;
    L_0x010c:
        r0 = 0;
        goto L_0x00d3;
    L_0x010e:
        r13.m2313b(r5, r6, r3);
        r5 = r13.f1169a;
        r6 = 1;
        if (r5 == r6) goto L_0x0107;
    L_0x0116:
        if (r0 == 0) goto L_0x00ac;
    L_0x0118:
        r0 = r13.m2333b(r4, r3);
        if (r0 == 0) goto L_0x00ac;
    L_0x011e:
        goto L_0x0107;
    L_0x011f:
        r0 = android.support.v4.view.C0474s.m2144b(r14, r1);
        r13.m2316d(r0);
        goto L_0x001f;
    L_0x0128:
        r13.m2338d();
        goto L_0x001f;
    L_0x012d:
        r0 = 0;
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.aa.a(android.view.MotionEvent):boolean");
    }

    public void m2331b(MotionEvent motionEvent) {
        int i = 0;
        int a = C0474s.m2141a(motionEvent);
        int b = C0474s.m2143b(motionEvent);
        if (a == 0) {
            m2338d();
        }
        if (this.f1180l == null) {
            this.f1180l = VelocityTracker.obtain();
        }
        this.f1180l.addMovement(motionEvent);
        float x;
        float y;
        View d;
        int i2;
        switch (a) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                i = C0474s.m2144b(motionEvent, 0);
                d = m2337d((int) x, (int) y);
                m2308a(x, y, i);
                m2333b(d, i);
                i2 = this.f1176h[i];
                if ((this.f1184p & i2) != 0) {
                    this.f1186r.m2292a(i2 & this.f1184p, i);
                    return;
                }
                return;
            case 1:
                if (this.f1169a == 1) {
                    m2320f();
                }
                m2338d();
                return;
            case 2:
                if (this.f1169a != 1) {
                    i2 = C0474s.m2146c(motionEvent);
                    while (i < i2) {
                        a = C0474s.m2144b(motionEvent, i);
                        if (m2321f(a)) {
                            float c = C0474s.m2145c(motionEvent, i);
                            float d2 = C0474s.m2147d(motionEvent, i);
                            float f = c - this.f1172d[a];
                            float f2 = d2 - this.f1173e[a];
                            m2313b(f, f2, a);
                            if (this.f1169a != 1) {
                                d = m2337d((int) c, (int) d2);
                                if (m2311a(d, f, f2) && m2333b(d, a)) {
                                }
                            }
                            m2315c(motionEvent);
                            return;
                        }
                        i++;
                    }
                    m2315c(motionEvent);
                    return;
                } else if (m2321f(this.f1171c)) {
                    i = C0474s.m2142a(motionEvent, this.f1171c);
                    x = C0474s.m2145c(motionEvent, i);
                    i2 = (int) (x - this.f1174f[this.f1171c]);
                    i = (int) (C0474s.m2147d(motionEvent, i) - this.f1175g[this.f1171c]);
                    m2314b(this.f1187s.getLeft() + i2, this.f1187s.getTop() + i, i2, i);
                    m2315c(motionEvent);
                    return;
                } else {
                    return;
                }
            case 3:
                if (this.f1169a == 1) {
                    m2307a(0.0f, 0.0f);
                }
                m2338d();
                return;
            case 5:
                i = C0474s.m2144b(motionEvent, b);
                x = C0474s.m2145c(motionEvent, b);
                y = C0474s.m2147d(motionEvent, b);
                m2308a(x, y, i);
                if (this.f1169a == 0) {
                    m2333b(m2337d((int) x, (int) y), i);
                    i2 = this.f1176h[i];
                    if ((this.f1184p & i2) != 0) {
                        this.f1186r.m2292a(i2 & this.f1184p, i);
                        return;
                    }
                    return;
                } else if (m2336c((int) x, (int) y)) {
                    m2333b(this.f1187s, i);
                    return;
                } else {
                    return;
                }
            case 6:
                a = C0474s.m2144b(motionEvent, b);
                if (this.f1169a == 1 && a == this.f1171c) {
                    b = C0474s.m2146c(motionEvent);
                    while (i < b) {
                        int b2 = C0474s.m2144b(motionEvent, i);
                        if (b2 != this.f1171c) {
                            if (m2337d((int) C0474s.m2145c(motionEvent, i), (int) C0474s.m2147d(motionEvent, i)) == this.f1187s && m2333b(this.f1187s, b2)) {
                                i = this.f1171c;
                                if (i == -1) {
                                    m2320f();
                                }
                            }
                        }
                        i++;
                    }
                    i = -1;
                    if (i == -1) {
                        m2320f();
                    }
                }
                m2316d(a);
                return;
            default:
                return;
        }
    }

    private void m2313b(float f, float f2, int i) {
        int i2 = 1;
        if (!m2309a(f, f2, i, 1)) {
            i2 = 0;
        }
        if (m2309a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (m2309a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (m2309a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.f1177i;
            iArr[i] = iArr[i] | i2;
            this.f1186r.m2298b(i2, i);
        }
    }

    private boolean m2309a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.f1176h[i] & i2) != i2 || (this.f1184p & i2) == 0 || (this.f1178j[i] & i2) == i2 || (this.f1177i[i] & i2) == i2) {
            return false;
        }
        if (abs <= ((float) this.f1170b) && abs2 <= ((float) this.f1170b)) {
            return false;
        }
        if (abs < abs2 * 0.5f && this.f1186r.m2299b(i2)) {
            int[] iArr = this.f1178j;
            iArr[i] = iArr[i] | i2;
            return false;
        } else if ((this.f1177i[i] & i2) != 0 || abs <= ((float) this.f1170b)) {
            return false;
        } else {
            return true;
        }
    }

    private boolean m2311a(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z;
        boolean z2;
        if (this.f1186r.m2289a(view) > 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.f1186r.m2296b(view) > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z && z2) {
            if ((f * f) + (f2 * f2) <= ((float) (this.f1170b * this.f1170b))) {
                return false;
            }
            return true;
        } else if (z) {
            if (Math.abs(f) <= ((float) this.f1170b)) {
                return false;
            }
            return true;
        } else if (!z2) {
            return false;
        } else {
            if (Math.abs(f2) <= ((float) this.f1170b)) {
                return false;
            }
            return true;
        }
    }

    public boolean m2335c(int i) {
        int length = this.f1172d.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (m2332b(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public boolean m2332b(int i, int i2) {
        if (!m2324a(i2)) {
            return false;
        }
        boolean z;
        boolean z2 = (i & 1) == 1;
        if ((i & 2) == 2) {
            z = true;
        } else {
            z = false;
        }
        float f = this.f1174f[i2] - this.f1172d[i2];
        float f2 = this.f1175g[i2] - this.f1173e[i2];
        if (z2 && z) {
            if ((f * f) + (f2 * f2) <= ((float) (this.f1170b * this.f1170b))) {
                return false;
            }
            return true;
        } else if (z2) {
            if (Math.abs(f) <= ((float) this.f1170b)) {
                return false;
            }
            return true;
        } else if (!z) {
            return false;
        } else {
            if (Math.abs(f2) <= ((float) this.f1170b)) {
                return false;
            }
            return true;
        }
    }

    private void m2320f() {
        this.f1180l.computeCurrentVelocity(1000, this.f1181m);
        m2307a(m2303a(ae.m1622a(this.f1180l, this.f1171c), this.f1182n, this.f1181m), m2303a(ae.m1623b(this.f1180l, this.f1171c), this.f1182n, this.f1181m));
    }

    private void m2314b(int i, int i2, int i3, int i4) {
        int a;
        int b;
        int left = this.f1187s.getLeft();
        int top = this.f1187s.getTop();
        if (i3 != 0) {
            a = this.f1186r.mo2838a(this.f1187s, i, i3);
            ag.m1805e(this.f1187s, a - left);
        } else {
            a = i;
        }
        if (i4 != 0) {
            b = this.f1186r.mo2843b(this.f1187s, i2, i4);
            ag.m1802d(this.f1187s, b - top);
        } else {
            b = i2;
        }
        if (i3 != 0 || i4 != 0) {
            this.f1186r.mo2842a(this.f1187s, a, b, a - left, b - top);
        }
    }

    public boolean m2336c(int i, int i2) {
        return m2327a(this.f1187s, i, i2);
    }

    public boolean m2327a(View view, int i, int i2) {
        if (view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom()) {
            return true;
        }
        return false;
    }

    public View m2337d(int i, int i2) {
        for (int childCount = this.f1189u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f1189u.getChildAt(this.f1186r.m2301c(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    private int m2317e(int i, int i2) {
        int i3 = 0;
        if (i < this.f1189u.getLeft() + this.f1183o) {
            i3 = 1;
        }
        if (i2 < this.f1189u.getTop() + this.f1183o) {
            i3 |= 4;
        }
        if (i > this.f1189u.getRight() - this.f1183o) {
            i3 |= 2;
        }
        if (i2 > this.f1189u.getBottom() - this.f1183o) {
            return i3 | 8;
        }
        return i3;
    }

    private boolean m2321f(int i) {
        if (m2324a(i)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i + " because ACTION_DOWN was not received " + "for this pointer before ACTION_MOVE. It likely happened because " + " ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }
}
