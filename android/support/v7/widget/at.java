package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.p002a.C0105a;
import android.util.TypedValue;

class at {
    static final int[] f2171a = new int[]{-16842910};
    static final int[] f2172b = new int[]{16842908};
    static final int[] f2173c = new int[]{16843518};
    static final int[] f2174d = new int[]{16842919};
    static final int[] f2175e = new int[]{16842912};
    static final int[] f2176f = new int[]{16842913};
    static final int[] f2177g = new int[]{-16842919, -16842908};
    static final int[] f2178h = new int[0];
    private static final ThreadLocal<TypedValue> f2179i = new ThreadLocal();
    private static final int[] f2180j = new int[1];

    public static int m3722a(Context context, int i) {
        f2180j[0] = i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, f2180j);
        try {
            int color = obtainStyledAttributes.getColor(0, 0);
            return color;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static ColorStateList m3725b(Context context, int i) {
        f2180j[0] = i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, f2180j);
        try {
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(0);
            return colorStateList;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static int m3726c(Context context, int i) {
        ColorStateList b = m3725b(context, i);
        if (b != null && b.isStateful()) {
            return b.getColorForState(f2171a, b.getDefaultColor());
        }
        TypedValue a = m3724a();
        context.getTheme().resolveAttribute(16842803, a, true);
        return m3723a(context, i, a.getFloat());
    }

    private static TypedValue m3724a() {
        TypedValue typedValue = (TypedValue) f2179i.get();
        if (typedValue != null) {
            return typedValue;
        }
        typedValue = new TypedValue();
        f2179i.set(typedValue);
        return typedValue;
    }

    static int m3723a(Context context, int i, float f) {
        int a = m3722a(context, i);
        return C0105a.m507b(a, Math.round(((float) Color.alpha(a)) * f));
    }
}
