package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.v4.view.p010b.C0427a;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import java.util.ArrayList;

class C0532p extends Drawable implements Animatable {
    private static final Interpolator f1244b = new LinearInterpolator();
    private static final Interpolator f1245c = new C0427a();
    boolean f1246a;
    private final int[] f1247d = new int[]{-16777216};
    private final ArrayList<Animation> f1248e = new ArrayList();
    private final C0531a f1249f;
    private float f1250g;
    private Resources f1251h;
    private View f1252i;
    private Animation f1253j;
    private float f1254k;
    private double f1255l;
    private double f1256m;
    private final Callback f1257n = new C05303(this);

    class C05303 implements Callback {
        final /* synthetic */ C0532p f1219a;

        C05303(C0532p c0532p) {
            this.f1219a = c0532p;
        }

        public void invalidateDrawable(Drawable drawable) {
            this.f1219a.invalidateSelf();
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            this.f1219a.scheduleSelf(runnable, j);
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            this.f1219a.unscheduleSelf(runnable);
        }
    }

    private static class C0531a {
        private final RectF f1220a = new RectF();
        private final Paint f1221b = new Paint();
        private final Paint f1222c = new Paint();
        private final Callback f1223d;
        private float f1224e = 0.0f;
        private float f1225f = 0.0f;
        private float f1226g = 0.0f;
        private float f1227h = 5.0f;
        private float f1228i = 2.5f;
        private int[] f1229j;
        private int f1230k;
        private float f1231l;
        private float f1232m;
        private float f1233n;
        private boolean f1234o;
        private Path f1235p;
        private float f1236q;
        private double f1237r;
        private int f1238s;
        private int f1239t;
        private int f1240u;
        private final Paint f1241v = new Paint(1);
        private int f1242w;
        private int f1243x;

        public C0531a(Callback callback) {
            this.f1223d = callback;
            this.f1221b.setStrokeCap(Cap.SQUARE);
            this.f1221b.setAntiAlias(true);
            this.f1221b.setStyle(Style.STROKE);
            this.f1222c.setStyle(Style.FILL);
            this.f1222c.setAntiAlias(true);
        }

        public void m2433a(int i) {
            this.f1242w = i;
        }

        public void m2432a(float f, float f2) {
            this.f1238s = (int) f;
            this.f1239t = (int) f2;
        }

        public void m2435a(Canvas canvas, Rect rect) {
            RectF rectF = this.f1220a;
            rectF.set(rect);
            rectF.inset(this.f1228i, this.f1228i);
            float f = (this.f1224e + this.f1226g) * 360.0f;
            float f2 = ((this.f1225f + this.f1226g) * 360.0f) - f;
            this.f1221b.setColor(this.f1243x);
            canvas.drawArc(rectF, f, f2, false, this.f1221b);
            m2426a(canvas, f, f2, rect);
            if (this.f1240u < 255) {
                this.f1241v.setColor(this.f1242w);
                this.f1241v.setAlpha(255 - this.f1240u);
                canvas.drawCircle(rect.exactCenterX(), rect.exactCenterY(), (float) (rect.width() / 2), this.f1241v);
            }
        }

        private void m2426a(Canvas canvas, float f, float f2, Rect rect) {
            if (this.f1234o) {
                if (this.f1235p == null) {
                    this.f1235p = new Path();
                    this.f1235p.setFillType(FillType.EVEN_ODD);
                } else {
                    this.f1235p.reset();
                }
                float f3 = ((float) (((int) this.f1228i) / 2)) * this.f1236q;
                float cos = (float) ((this.f1237r * Math.cos(0.0d)) + ((double) rect.exactCenterX()));
                float sin = (float) ((this.f1237r * Math.sin(0.0d)) + ((double) rect.exactCenterY()));
                this.f1235p.moveTo(0.0f, 0.0f);
                this.f1235p.lineTo(((float) this.f1238s) * this.f1236q, 0.0f);
                this.f1235p.lineTo((((float) this.f1238s) * this.f1236q) / 2.0f, ((float) this.f1239t) * this.f1236q);
                this.f1235p.offset(cos - f3, sin);
                this.f1235p.close();
                this.f1222c.setColor(this.f1243x);
                canvas.rotate((f + f2) - 5.0f, rect.exactCenterX(), rect.exactCenterY());
                canvas.drawPath(this.f1235p, this.f1222c);
            }
        }

        public void m2438a(int[] iArr) {
            this.f1229j = iArr;
            m2444c(0);
        }

        public void m2441b(int i) {
            this.f1243x = i;
        }

        public void m2444c(int i) {
            this.f1230k = i;
            this.f1243x = this.f1229j[this.f1230k];
        }

        public int m2429a() {
            return this.f1229j[m2427n()];
        }

        private int m2427n() {
            return (this.f1230k + 1) % this.f1229j.length;
        }

        public void m2439b() {
            m2444c(m2427n());
        }

        public void m2436a(ColorFilter colorFilter) {
            this.f1221b.setColorFilter(colorFilter);
            m2428o();
        }

        public void m2447d(int i) {
            this.f1240u = i;
        }

        public int m2442c() {
            return this.f1240u;
        }

        public void m2431a(float f) {
            this.f1227h = f;
            this.f1221b.setStrokeWidth(f);
            m2428o();
        }

        public float m2445d() {
            return this.f1227h;
        }

        public void m2440b(float f) {
            this.f1224e = f;
            m2428o();
        }

        public float m2448e() {
            return this.f1224e;
        }

        public float m2450f() {
            return this.f1231l;
        }

        public float m2451g() {
            return this.f1232m;
        }

        public int m2452h() {
            return this.f1229j[this.f1230k];
        }

        public void m2443c(float f) {
            this.f1225f = f;
            m2428o();
        }

        public float m2453i() {
            return this.f1225f;
        }

        public void m2446d(float f) {
            this.f1226g = f;
            m2428o();
        }

        public void m2434a(int i, int i2) {
            float min = (float) Math.min(i, i2);
            if (this.f1237r <= 0.0d || min < 0.0f) {
                min = (float) Math.ceil((double) (this.f1227h / 2.0f));
            } else {
                min = (float) (((double) (min / 2.0f)) - this.f1237r);
            }
            this.f1228i = min;
        }

        public void m2430a(double d) {
            this.f1237r = d;
        }

        public double m2454j() {
            return this.f1237r;
        }

        public void m2437a(boolean z) {
            if (this.f1234o != z) {
                this.f1234o = z;
                m2428o();
            }
        }

        public void m2449e(float f) {
            if (f != this.f1236q) {
                this.f1236q = f;
                m2428o();
            }
        }

        public float m2455k() {
            return this.f1233n;
        }

        public void m2456l() {
            this.f1231l = this.f1224e;
            this.f1232m = this.f1225f;
            this.f1233n = this.f1226g;
        }

        public void m2457m() {
            this.f1231l = 0.0f;
            this.f1232m = 0.0f;
            this.f1233n = 0.0f;
            m2440b(0.0f);
            m2443c(0.0f);
            m2446d(0.0f);
        }

        private void m2428o() {
            this.f1223d.invalidateDrawable(null);
        }
    }

    public C0532p(Context context, View view) {
        this.f1252i = view;
        this.f1251h = context.getResources();
        this.f1249f = new C0531a(this.f1257n);
        this.f1249f.m2438a(this.f1247d);
        m2472a(1);
        m2467b();
    }

    private void m2464a(double d, double d2, double d3, double d4, float f, float f2) {
        C0531a c0531a = this.f1249f;
        float f3 = this.f1251h.getDisplayMetrics().density;
        this.f1255l = ((double) f3) * d;
        this.f1256m = ((double) f3) * d2;
        c0531a.m2431a(((float) d4) * f3);
        c0531a.m2430a(((double) f3) * d3);
        c0531a.m2444c(0);
        c0531a.m2432a(f * f3, f3 * f2);
        c0531a.m2434a((int) this.f1255l, (int) this.f1256m);
    }

    public void m2472a(int i) {
        if (i == 0) {
            m2464a(56.0d, 56.0d, 12.5d, 3.0d, 12.0f, 6.0f);
        } else {
            m2464a(40.0d, 40.0d, 8.75d, 2.5d, 10.0f, 5.0f);
        }
    }

    public void m2473a(boolean z) {
        this.f1249f.m2437a(z);
    }

    public void m2470a(float f) {
        this.f1249f.m2449e(f);
    }

    public void m2471a(float f, float f2) {
        this.f1249f.m2440b(f);
        this.f1249f.m2443c(f2);
    }

    public void m2475b(float f) {
        this.f1249f.m2446d(f);
    }

    public void m2476b(int i) {
        this.f1249f.m2433a(i);
    }

    public void m2474a(int... iArr) {
        this.f1249f.m2438a(iArr);
        this.f1249f.m2444c(0);
    }

    public int getIntrinsicHeight() {
        return (int) this.f1256m;
    }

    public int getIntrinsicWidth() {
        return (int) this.f1255l;
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int save = canvas.save();
        canvas.rotate(this.f1250g, bounds.exactCenterX(), bounds.exactCenterY());
        this.f1249f.m2435a(canvas, bounds);
        canvas.restoreToCount(save);
    }

    public void setAlpha(int i) {
        this.f1249f.m2447d(i);
    }

    public int getAlpha() {
        return this.f1249f.m2442c();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1249f.m2436a(colorFilter);
    }

    void m2477c(float f) {
        this.f1250g = f;
        invalidateSelf();
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isRunning() {
        ArrayList arrayList = this.f1248e;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Animation animation = (Animation) arrayList.get(i);
            if (animation.hasStarted() && !animation.hasEnded()) {
                return true;
            }
        }
        return false;
    }

    public void start() {
        this.f1253j.reset();
        this.f1249f.m2456l();
        if (this.f1249f.m2453i() != this.f1249f.m2448e()) {
            this.f1246a = true;
            this.f1253j.setDuration(666);
            this.f1252i.startAnimation(this.f1253j);
            return;
        }
        this.f1249f.m2444c(0);
        this.f1249f.m2457m();
        this.f1253j.setDuration(1332);
        this.f1252i.startAnimation(this.f1253j);
    }

    public void stop() {
        this.f1252i.clearAnimation();
        m2477c(0.0f);
        this.f1249f.m2437a(false);
        this.f1249f.m2444c(0);
        this.f1249f.m2457m();
    }

    private float m2458a(C0531a c0531a) {
        return (float) Math.toRadians(((double) c0531a.m2445d()) / (6.283185307179586d * c0531a.m2454j()));
    }

    private int m2462a(float f, int i, int i2) {
        int intValue = Integer.valueOf(i).intValue();
        int i3 = (intValue >> 24) & 255;
        int i4 = (intValue >> 16) & 255;
        int i5 = (intValue >> 8) & 255;
        intValue &= 255;
        int intValue2 = Integer.valueOf(i2).intValue();
        return (intValue + ((int) (((float) ((intValue2 & 255) - intValue)) * f))) | ((((i3 + ((int) (((float) (((intValue2 >> 24) & 255) - i3)) * f))) << 24) | ((i4 + ((int) (((float) (((intValue2 >> 16) & 255) - i4)) * f))) << 16)) | ((((int) (((float) (((intValue2 >> 8) & 255) - i5)) * f)) + i5) << 8));
    }

    private void m2465a(float f, C0531a c0531a) {
        if (f > 0.75f) {
            c0531a.m2441b(m2462a((f - 0.75f) / 0.25f, c0531a.m2452h(), c0531a.m2429a()));
        }
    }

    private void m2468b(float f, C0531a c0531a) {
        m2465a(f, c0531a);
        float floor = (float) (Math.floor((double) (c0531a.m2455k() / 0.8f)) + 1.0d);
        float a = m2458a(c0531a);
        c0531a.m2440b((((c0531a.m2451g() - a) - c0531a.m2450f()) * f) + c0531a.m2450f());
        c0531a.m2443c(c0531a.m2451g());
        c0531a.m2446d(((floor - c0531a.m2455k()) * f) + c0531a.m2455k());
    }

    private void m2467b() {
        final C0531a c0531a = this.f1249f;
        Animation c05281 = new Animation(this) {
            final /* synthetic */ C0532p f1216b;

            public void applyTransformation(float f, Transformation transformation) {
                if (this.f1216b.f1246a) {
                    this.f1216b.m2468b(f, c0531a);
                    return;
                }
                float a = this.f1216b.m2458a(c0531a);
                float g = c0531a.m2451g();
                float f2 = c0531a.m2450f();
                float k = c0531a.m2455k();
                this.f1216b.m2465a(f, c0531a);
                if (f <= 0.5f) {
                    float f3 = 0.8f - a;
                    c0531a.m2440b(f2 + (C0532p.f1245c.getInterpolation(f / 0.5f) * f3));
                }
                if (f > 0.5f) {
                    c0531a.m2443c(((0.8f - a) * C0532p.f1245c.getInterpolation((f - 0.5f) / 0.5f)) + g);
                }
                c0531a.m2446d((0.25f * f) + k);
                this.f1216b.m2477c((216.0f * f) + (1080.0f * (this.f1216b.f1254k / 5.0f)));
            }
        };
        c05281.setRepeatCount(-1);
        c05281.setRepeatMode(1);
        c05281.setInterpolator(f1244b);
        c05281.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ C0532p f1218b;

            public void onAnimationStart(Animation animation) {
                this.f1218b.f1254k = 0.0f;
            }

            public void onAnimationEnd(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
                c0531a.m2456l();
                c0531a.m2439b();
                c0531a.m2440b(c0531a.m2453i());
                if (this.f1218b.f1246a) {
                    this.f1218b.f1246a = false;
                    animation.setDuration(1332);
                    c0531a.m2437a(false);
                    return;
                }
                this.f1218b.f1254k = (this.f1218b.f1254k + 1.0f) % 5.0f;
            }
        });
        this.f1253j = c05281;
    }
}
