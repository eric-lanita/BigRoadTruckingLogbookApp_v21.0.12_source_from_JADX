package android.support.v7.widget;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.v7.p012b.C0636a.C0632a;
import android.support.v7.p012b.C0636a.C0633b;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

class ap extends Drawable {
    static final double f2105a = Math.cos(Math.toRadians(45.0d));
    static C0713a f2106c;
    final int f2107b;
    Paint f2108d;
    Paint f2109e;
    Paint f2110f;
    final RectF f2111g;
    float f2112h;
    Path f2113i;
    float f2114j;
    float f2115k;
    float f2116l;
    float f2117m;
    private boolean f2118n = true;
    private final int f2119o;
    private final int f2120p;
    private boolean f2121q = true;
    private boolean f2122r = false;

    interface C0713a {
        void mo621a(Canvas canvas, RectF rectF, float f, Paint paint);
    }

    ap(Resources resources, int i, float f, float f2, float f3) {
        this.f2119o = resources.getColor(C0632a.cardview_shadow_start_color);
        this.f2120p = resources.getColor(C0632a.cardview_shadow_end_color);
        this.f2107b = resources.getDimensionPixelSize(C0633b.cardview_compat_inset_shadow);
        this.f2108d = new Paint(5);
        this.f2108d.setColor(i);
        this.f2109e = new Paint(5);
        this.f2109e.setStyle(Style.FILL);
        this.f2112h = (float) ((int) (0.5f + f));
        this.f2111g = new RectF();
        this.f2110f = new Paint(this.f2109e);
        this.f2110f.setAntiAlias(false);
        m3671a(f2, f3);
    }

    private int m3667d(float f) {
        int i = (int) (0.5f + f);
        if (i % 2 == 1) {
            return i - 1;
        }
        return i;
    }

    public void m3674a(boolean z) {
        this.f2121q = z;
        invalidateSelf();
    }

    public void setAlpha(int i) {
        this.f2108d.setAlpha(i);
        this.f2109e.setAlpha(i);
        this.f2110f.setAlpha(i);
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f2118n = true;
    }

    void m3671a(float f, float f2) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f + ". Must be >= 0");
        } else if (f2 < 0.0f) {
            throw new IllegalArgumentException("Invalid max shadow size " + f2 + ". Must be >= 0");
        } else {
            float d = (float) m3667d(f);
            float d2 = (float) m3667d(f2);
            if (d > d2) {
                if (!this.f2122r) {
                    this.f2122r = true;
                }
                d = d2;
            }
            if (this.f2117m != d || this.f2115k != d2) {
                this.f2117m = d;
                this.f2115k = d2;
                this.f2116l = (float) ((int) (((d * 1.5f) + ((float) this.f2107b)) + 0.5f));
                this.f2114j = ((float) this.f2107b) + d2;
                this.f2118n = true;
                invalidateSelf();
            }
        }
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) m3663a(this.f2115k, this.f2112h, this.f2121q));
        int ceil2 = (int) Math.ceil((double) m3665b(this.f2115k, this.f2112h, this.f2121q));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    static float m3663a(float f, float f2, boolean z) {
        if (z) {
            return (float) (((double) (1.5f * f)) + ((1.0d - f2105a) * ((double) f2)));
        }
        return 1.5f * f;
    }

    static float m3665b(float f, float f2, boolean z) {
        if (z) {
            return (float) (((double) f) + ((1.0d - f2105a) * ((double) f2)));
        }
        return f;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f2108d.setColorFilter(colorFilter);
    }

    public int getOpacity() {
        return -3;
    }

    void m3670a(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Invalid radius " + f + ". Must be >= 0");
        }
        float f2 = (float) ((int) (0.5f + f));
        if (this.f2112h != f2) {
            this.f2112h = f2;
            this.f2118n = true;
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        if (this.f2118n) {
            m3666b(getBounds());
            this.f2118n = false;
        }
        canvas.translate(0.0f, this.f2117m / 2.0f);
        m3664a(canvas);
        canvas.translate(0.0f, (-this.f2117m) / 2.0f);
        f2106c.mo621a(canvas, this.f2111g, this.f2112h, this.f2108d);
    }

    private void m3664a(Canvas canvas) {
        Object obj;
        float f = (-this.f2112h) - this.f2116l;
        float f2 = (this.f2112h + ((float) this.f2107b)) + (this.f2117m / 2.0f);
        Object obj2 = this.f2111g.width() - (2.0f * f2) > 0.0f ? 1 : null;
        if (this.f2111g.height() - (2.0f * f2) > 0.0f) {
            obj = 1;
        } else {
            obj = null;
        }
        int save = canvas.save();
        canvas.translate(this.f2111g.left + f2, this.f2111g.top + f2);
        canvas.drawPath(this.f2113i, this.f2109e);
        if (obj2 != null) {
            canvas.drawRect(0.0f, f, this.f2111g.width() - (2.0f * f2), -this.f2112h, this.f2110f);
        }
        canvas.restoreToCount(save);
        save = canvas.save();
        canvas.translate(this.f2111g.right - f2, this.f2111g.bottom - f2);
        canvas.rotate(BitmapDescriptorFactory.HUE_CYAN);
        canvas.drawPath(this.f2113i, this.f2109e);
        if (obj2 != null) {
            canvas.drawRect(0.0f, f, this.f2111g.width() - (2.0f * f2), this.f2116l + (-this.f2112h), this.f2110f);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        canvas.translate(this.f2111g.left + f2, this.f2111g.bottom - f2);
        canvas.rotate(BitmapDescriptorFactory.HUE_VIOLET);
        canvas.drawPath(this.f2113i, this.f2109e);
        if (obj != null) {
            canvas.drawRect(0.0f, f, this.f2111g.height() - (2.0f * f2), -this.f2112h, this.f2110f);
        }
        canvas.restoreToCount(save2);
        save2 = canvas.save();
        canvas.translate(this.f2111g.right - f2, this.f2111g.top + f2);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f2113i, this.f2109e);
        if (obj != null) {
            canvas.drawRect(0.0f, f, this.f2111g.height() - (2.0f * f2), -this.f2112h, this.f2110f);
        }
        canvas.restoreToCount(save2);
    }

    private void m3668f() {
        RectF rectF = new RectF(-this.f2112h, -this.f2112h, this.f2112h, this.f2112h);
        RectF rectF2 = new RectF(rectF);
        rectF2.inset(-this.f2116l, -this.f2116l);
        if (this.f2113i == null) {
            this.f2113i = new Path();
        } else {
            this.f2113i.reset();
        }
        this.f2113i.setFillType(FillType.EVEN_ODD);
        this.f2113i.moveTo(-this.f2112h, 0.0f);
        this.f2113i.rLineTo(-this.f2116l, 0.0f);
        this.f2113i.arcTo(rectF2, BitmapDescriptorFactory.HUE_CYAN, 90.0f, false);
        this.f2113i.arcTo(rectF, BitmapDescriptorFactory.HUE_VIOLET, -90.0f, false);
        this.f2113i.close();
        float f = this.f2112h / (this.f2112h + this.f2116l);
        float[] fArr = new float[]{0.0f, f, 1.0f};
        f = 0.0f;
        this.f2109e.setShader(new RadialGradient(0.0f, f, this.f2112h + this.f2116l, new int[]{this.f2119o, this.f2119o, this.f2120p}, fArr, TileMode.CLAMP));
        float f2 = 0.0f;
        this.f2110f.setShader(new LinearGradient(0.0f, (-this.f2112h) + this.f2116l, f2, (-this.f2112h) - this.f2116l, new int[]{this.f2119o, this.f2119o, this.f2120p}, new float[]{0.0f, 0.5f, 1.0f}, TileMode.CLAMP));
        this.f2110f.setAntiAlias(false);
    }

    private void m3666b(Rect rect) {
        float f = this.f2115k * 1.5f;
        this.f2111g.set(((float) rect.left) + this.f2115k, ((float) rect.top) + f, ((float) rect.right) - this.f2115k, ((float) rect.bottom) - f);
        m3668f();
    }

    float m3669a() {
        return this.f2112h;
    }

    void m3673a(Rect rect) {
        getPadding(rect);
    }

    void m3676b(float f) {
        m3671a(f, this.f2115k);
    }

    void m3678c(float f) {
        m3671a(this.f2117m, f);
    }

    float m3675b() {
        return this.f2117m;
    }

    float m3677c() {
        return this.f2115k;
    }

    float m3679d() {
        return (Math.max(this.f2115k, (this.f2112h + ((float) this.f2107b)) + (this.f2115k / 2.0f)) * 2.0f) + ((this.f2115k + ((float) this.f2107b)) * 2.0f);
    }

    float m3680e() {
        return (Math.max(this.f2115k, (this.f2112h + ((float) this.f2107b)) + ((this.f2115k * 1.5f) / 2.0f)) * 2.0f) + (((this.f2115k * 1.5f) + ((float) this.f2107b)) * 2.0f);
    }

    public void m3672a(int i) {
        this.f2108d.setColor(i);
        invalidateSelf();
    }
}
