package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

class ao extends Drawable {
    private float f2095a;
    private final Paint f2096b;
    private final RectF f2097c;
    private final Rect f2098d;
    private float f2099e;
    private boolean f2100f = false;
    private boolean f2101g = true;
    private PorterDuffColorFilter f2102h;
    private ColorStateList f2103i;
    private Mode f2104j = Mode.SRC_IN;

    public ao(int i, float f) {
        this.f2095a = f;
        this.f2096b = new Paint(5);
        this.f2096b.setColor(i);
        this.f2097c = new RectF();
        this.f2098d = new Rect();
    }

    void m3660a(float f, boolean z, boolean z2) {
        if (f != this.f2099e || this.f2100f != z || this.f2101g != z2) {
            this.f2099e = f;
            this.f2100f = z;
            this.f2101g = z2;
            m3657a(null);
            invalidateSelf();
        }
    }

    float m3658a() {
        return this.f2099e;
    }

    public void draw(Canvas canvas) {
        Object obj;
        Paint paint = this.f2096b;
        if (this.f2102h == null || paint.getColorFilter() != null) {
            obj = null;
        } else {
            paint.setColorFilter(this.f2102h);
            obj = 1;
        }
        canvas.drawRoundRect(this.f2097c, this.f2095a, this.f2095a, paint);
        if (obj != null) {
            paint.setColorFilter(null);
        }
    }

    private void m3657a(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f2097c.set((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
        this.f2098d.set(rect);
        if (this.f2100f) {
            float a = ap.m3663a(this.f2099e, this.f2095a, this.f2101g);
            this.f2098d.inset((int) Math.ceil((double) ap.m3665b(this.f2099e, this.f2095a, this.f2101g)), (int) Math.ceil((double) a));
            this.f2097c.set(this.f2098d);
        }
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        m3657a(rect);
    }

    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f2098d, this.f2095a);
    }

    void m3659a(float f) {
        if (f != this.f2095a) {
            this.f2095a = f;
            m3657a(null);
            invalidateSelf();
        }
    }

    public void setAlpha(int i) {
        this.f2096b.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f2096b.setColorFilter(colorFilter);
    }

    public int getOpacity() {
        return -3;
    }

    public float m3662b() {
        return this.f2095a;
    }

    public void m3661a(int i) {
        this.f2096b.setColor(i);
        invalidateSelf();
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f2103i = colorStateList;
        this.f2102h = m3656a(this.f2103i, this.f2104j);
        invalidateSelf();
    }

    public void setTintMode(Mode mode) {
        this.f2104j = mode;
        this.f2102h = m3656a(this.f2103i, this.f2104j);
        invalidateSelf();
    }

    protected boolean onStateChange(int[] iArr) {
        if (this.f2103i == null || this.f2104j == null) {
            return false;
        }
        this.f2102h = m3656a(this.f2103i, this.f2104j);
        return true;
    }

    public boolean isStateful() {
        return (this.f2103i != null && this.f2103i.isStateful()) || super.isStateful();
    }

    private PorterDuffColorFilter m3656a(ColorStateList colorStateList, Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }
}
