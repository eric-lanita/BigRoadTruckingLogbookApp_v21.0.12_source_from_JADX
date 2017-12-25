package android.support.v7.p013c.p014a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.v4.p002a.p003a.C0085a;

public class C0637a extends Drawable implements Callback {
    private Drawable f1548a;

    public C0637a(Drawable drawable) {
        m2980a(drawable);
    }

    public void draw(Canvas canvas) {
        this.f1548a.draw(canvas);
    }

    protected void onBoundsChange(Rect rect) {
        this.f1548a.setBounds(rect);
    }

    public void setChangingConfigurations(int i) {
        this.f1548a.setChangingConfigurations(i);
    }

    public int getChangingConfigurations() {
        return this.f1548a.getChangingConfigurations();
    }

    public void setDither(boolean z) {
        this.f1548a.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f1548a.setFilterBitmap(z);
    }

    public void setAlpha(int i) {
        this.f1548a.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1548a.setColorFilter(colorFilter);
    }

    public boolean isStateful() {
        return this.f1548a.isStateful();
    }

    public boolean setState(int[] iArr) {
        return this.f1548a.setState(iArr);
    }

    public int[] getState() {
        return this.f1548a.getState();
    }

    public void jumpToCurrentState() {
        C0085a.m450a(this.f1548a);
    }

    public Drawable getCurrent() {
        return this.f1548a.getCurrent();
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f1548a.setVisible(z, z2);
    }

    public int getOpacity() {
        return this.f1548a.getOpacity();
    }

    public Region getTransparentRegion() {
        return this.f1548a.getTransparentRegion();
    }

    public int getIntrinsicWidth() {
        return this.f1548a.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.f1548a.getIntrinsicHeight();
    }

    public int getMinimumWidth() {
        return this.f1548a.getMinimumWidth();
    }

    public int getMinimumHeight() {
        return this.f1548a.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        return this.f1548a.getPadding(rect);
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
        return this.f1548a.setLevel(i);
    }

    public void setAutoMirrored(boolean z) {
        C0085a.m458a(this.f1548a, z);
    }

    public boolean isAutoMirrored() {
        return C0085a.m459b(this.f1548a);
    }

    public void setTint(int i) {
        C0085a.m452a(this.f1548a, i);
    }

    public void setTintList(ColorStateList colorStateList) {
        C0085a.m454a(this.f1548a, colorStateList);
    }

    public void setTintMode(Mode mode) {
        C0085a.m457a(this.f1548a, mode);
    }

    public void setHotspot(float f, float f2) {
        C0085a.m451a(this.f1548a, f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        C0085a.m453a(this.f1548a, i, i2, i3, i4);
    }

    public Drawable m2979a() {
        return this.f1548a;
    }

    public void m2980a(Drawable drawable) {
        if (this.f1548a != null) {
            this.f1548a.setCallback(null);
        }
        this.f1548a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }
}
