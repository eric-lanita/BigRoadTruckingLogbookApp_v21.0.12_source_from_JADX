package android.support.v4.p002a.p003a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;

class C0096j extends Drawable implements Callback, C0093i, C0004o {
    static final Mode f415a = Mode.SRC_IN;
    C0094a f416b;
    Drawable f417c;
    private int f418d;
    private Mode f419e;
    private boolean f420f;
    private boolean f421g;

    protected static abstract class C0094a extends ConstantState {
        int f411a;
        ConstantState f412b;
        ColorStateList f413c = null;
        Mode f414d = C0096j.f415a;

        public abstract Drawable newDrawable(Resources resources);

        C0094a(C0094a c0094a, Resources resources) {
            if (c0094a != null) {
                this.f411a = c0094a.f411a;
                this.f412b = c0094a.f412b;
                this.f413c = c0094a.f413c;
                this.f414d = c0094a.f414d;
            }
        }

        public Drawable newDrawable() {
            return newDrawable(null);
        }

        public int getChangingConfigurations() {
            return (this.f412b != null ? this.f412b.getChangingConfigurations() : 0) | this.f411a;
        }

        boolean m491a() {
            return this.f412b != null;
        }
    }

    private static class C0095b extends C0094a {
        C0095b(C0094a c0094a, Resources resources) {
            super(c0094a, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new C0096j(this, resources);
        }
    }

    C0096j(C0094a c0094a, Resources resources) {
        this.f416b = c0094a;
        m492a(resources);
    }

    C0096j(Drawable drawable) {
        this.f416b = mo73b();
        mo71a(drawable);
    }

    private void m492a(Resources resources) {
        if (this.f416b != null && this.f416b.f412b != null) {
            mo71a(mo72a(this.f416b.f412b, resources));
        }
    }

    protected Drawable mo72a(ConstantState constantState, Resources resources) {
        return constantState.newDrawable();
    }

    public void draw(Canvas canvas) {
        this.f417c.draw(canvas);
    }

    protected void onBoundsChange(Rect rect) {
        if (this.f417c != null) {
            this.f417c.setBounds(rect);
        }
    }

    public void setChangingConfigurations(int i) {
        this.f417c.setChangingConfigurations(i);
    }

    public int getChangingConfigurations() {
        return ((this.f416b != null ? this.f416b.getChangingConfigurations() : 0) | super.getChangingConfigurations()) | this.f417c.getChangingConfigurations();
    }

    public void setDither(boolean z) {
        this.f417c.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f417c.setFilterBitmap(z);
    }

    public void setAlpha(int i) {
        this.f417c.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f417c.setColorFilter(colorFilter);
    }

    public boolean isStateful() {
        ColorStateList colorStateList = (!mo74c() || this.f416b == null) ? null : this.f416b.f413c;
        return (colorStateList != null && colorStateList.isStateful()) || this.f417c.isStateful();
    }

    public boolean setState(int[] iArr) {
        return m493a(iArr) || this.f417c.setState(iArr);
    }

    public int[] getState() {
        return this.f417c.getState();
    }

    public Drawable getCurrent() {
        return this.f417c.getCurrent();
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f417c.setVisible(z, z2);
    }

    public int getOpacity() {
        return this.f417c.getOpacity();
    }

    public Region getTransparentRegion() {
        return this.f417c.getTransparentRegion();
    }

    public int getIntrinsicWidth() {
        return this.f417c.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.f417c.getIntrinsicHeight();
    }

    public int getMinimumWidth() {
        return this.f417c.getMinimumWidth();
    }

    public int getMinimumHeight() {
        return this.f417c.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        return this.f417c.getPadding(rect);
    }

    public ConstantState getConstantState() {
        if (this.f416b == null || !this.f416b.m491a()) {
            return null;
        }
        this.f416b.f411a = getChangingConfigurations();
        return this.f416b;
    }

    public Drawable mutate() {
        if (!this.f421g && super.mutate() == this) {
            this.f416b = mo73b();
            if (this.f417c != null) {
                this.f417c.mutate();
            }
            if (this.f416b != null) {
                this.f416b.f412b = this.f417c != null ? this.f417c.getConstantState() : null;
            }
            this.f421g = true;
        }
        return this;
    }

    C0094a mo73b() {
        return new C0095b(this.f416b, null);
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    protected boolean onLevelChange(int i) {
        return this.f417c.setLevel(i);
    }

    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f416b.f413c = colorStateList;
        m493a(getState());
    }

    public void setTintMode(Mode mode) {
        this.f416b.f414d = mode;
        m493a(getState());
    }

    private boolean m493a(int[] iArr) {
        if (!mo74c()) {
            return false;
        }
        ColorStateList colorStateList = this.f416b.f413c;
        Mode mode = this.f416b.f414d;
        if (colorStateList == null || mode == null) {
            this.f420f = false;
            clearColorFilter();
            return false;
        }
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.f420f && colorForState == this.f418d && mode == this.f419e) {
            return false;
        }
        setColorFilter(colorForState, mode);
        this.f418d = colorForState;
        this.f419e = mode;
        this.f420f = true;
        return true;
    }

    public final Drawable mo70a() {
        return this.f417c;
    }

    public final void mo71a(Drawable drawable) {
        if (this.f417c != null) {
            this.f417c.setCallback(null);
        }
        this.f417c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            drawable.setVisible(isVisible(), true);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (this.f416b != null) {
                this.f416b.f412b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    protected boolean mo74c() {
        return true;
    }
}
