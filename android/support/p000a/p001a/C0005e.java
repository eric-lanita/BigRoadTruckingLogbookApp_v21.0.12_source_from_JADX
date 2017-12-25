package android.support.p000a.p001a;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.support.v4.p002a.p003a.C0004o;
import android.support.v4.p002a.p003a.C0085a;
import android.util.AttributeSet;

@TargetApi(21)
abstract class C0005e extends Drawable implements C0004o {
    Drawable f12a;

    C0005e() {
    }

    static TypedArray m0b(Resources resources, Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public void setColorFilter(int i, Mode mode) {
        if (this.f12a != null) {
            this.f12a.setColorFilter(i, mode);
        } else {
            super.setColorFilter(i, mode);
        }
    }

    public ColorFilter getColorFilter() {
        if (this.f12a != null) {
            return C0085a.m462e(this.f12a);
        }
        return null;
    }

    protected boolean onLevelChange(int i) {
        if (this.f12a != null) {
            return this.f12a.setLevel(i);
        }
        return super.onLevelChange(i);
    }

    protected void onBoundsChange(Rect rect) {
        if (this.f12a != null) {
            this.f12a.setBounds(rect);
        } else {
            super.onBoundsChange(rect);
        }
    }

    public void setHotspot(float f, float f2) {
        if (this.f12a != null) {
            C0085a.m451a(this.f12a, f, f2);
        }
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        if (this.f12a != null) {
            C0085a.m453a(this.f12a, i, i2, i3, i4);
        }
    }

    public void setFilterBitmap(boolean z) {
        if (this.f12a != null) {
            this.f12a.setFilterBitmap(z);
        }
    }

    public void jumpToCurrentState() {
        if (this.f12a != null) {
            C0085a.m450a(this.f12a);
        }
    }

    public void setAutoMirrored(boolean z) {
        if (this.f12a != null) {
            C0085a.m458a(this.f12a, z);
        }
    }

    public boolean isAutoMirrored() {
        if (this.f12a != null) {
            C0085a.m459b(this.f12a);
        }
        return false;
    }

    public void applyTheme(Theme theme) {
        if (this.f12a != null) {
            C0085a.m455a(this.f12a, theme);
        }
    }

    public int getLayoutDirection() {
        if (this.f12a != null) {
            C0085a.m464g(this.f12a);
        }
        return 0;
    }

    public void clearColorFilter() {
        if (this.f12a != null) {
            this.f12a.clearColorFilter();
        } else {
            super.clearColorFilter();
        }
    }

    public Drawable getCurrent() {
        if (this.f12a != null) {
            return this.f12a.getCurrent();
        }
        return super.getCurrent();
    }

    public int getMinimumWidth() {
        if (this.f12a != null) {
            return this.f12a.getMinimumWidth();
        }
        return super.getMinimumWidth();
    }

    public int getMinimumHeight() {
        if (this.f12a != null) {
            return this.f12a.getMinimumHeight();
        }
        return super.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        if (this.f12a != null) {
            return this.f12a.getPadding(rect);
        }
        return super.getPadding(rect);
    }

    public int[] getState() {
        if (this.f12a != null) {
            return this.f12a.getState();
        }
        return super.getState();
    }

    public Region getTransparentRegion() {
        if (this.f12a != null) {
            return this.f12a.getTransparentRegion();
        }
        return super.getTransparentRegion();
    }

    public void setChangingConfigurations(int i) {
        if (this.f12a != null) {
            this.f12a.setChangingConfigurations(i);
        } else {
            super.setChangingConfigurations(i);
        }
    }

    public boolean setState(int[] iArr) {
        if (this.f12a != null) {
            return this.f12a.setState(iArr);
        }
        return super.setState(iArr);
    }
}
