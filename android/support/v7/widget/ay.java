package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

public class ay {
    private final Context f2189a;
    private final TypedArray f2190b;

    public static ay m3732a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new ay(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static ay m3733a(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new ay(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    private ay(Context context, TypedArray typedArray) {
        this.f2189a = context;
        this.f2190b = typedArray;
    }

    public Drawable m3736a(int i) {
        if (this.f2190b.hasValue(i)) {
            int resourceId = this.f2190b.getResourceId(i, 0);
            if (resourceId != 0) {
                return C0765l.m3902a().m3925a(this.f2189a, resourceId);
            }
        }
        return this.f2190b.getDrawable(i);
    }

    public Drawable m3740b(int i) {
        if (this.f2190b.hasValue(i)) {
            int resourceId = this.f2190b.getResourceId(i, 0);
            if (resourceId != 0) {
                return C0765l.m3902a().m3926a(this.f2189a, resourceId, true);
            }
        }
        return null;
    }

    public CharSequence m3742c(int i) {
        return this.f2190b.getText(i);
    }

    public String m3744d(int i) {
        return this.f2190b.getString(i);
    }

    public boolean m3738a(int i, boolean z) {
        return this.f2190b.getBoolean(i, z);
    }

    public int m3735a(int i, int i2) {
        return this.f2190b.getInt(i, i2);
    }

    public float m3734a(int i, float f) {
        return this.f2190b.getFloat(i, f);
    }

    public int m3739b(int i, int i2) {
        return this.f2190b.getColor(i, i2);
    }

    public int m3741c(int i, int i2) {
        return this.f2190b.getInteger(i, i2);
    }

    public int m3743d(int i, int i2) {
        return this.f2190b.getDimensionPixelOffset(i, i2);
    }

    public int m3745e(int i, int i2) {
        return this.f2190b.getDimensionPixelSize(i, i2);
    }

    public int m3747f(int i, int i2) {
        return this.f2190b.getLayoutDimension(i, i2);
    }

    public int m3749g(int i, int i2) {
        return this.f2190b.getResourceId(i, i2);
    }

    public CharSequence[] m3746e(int i) {
        return this.f2190b.getTextArray(i);
    }

    public boolean m3748f(int i) {
        return this.f2190b.hasValue(i);
    }

    public void m3737a() {
        this.f2190b.recycle();
    }
}
