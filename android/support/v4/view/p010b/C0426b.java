package android.support.v4.view.p010b;

import android.view.animation.Interpolator;

abstract class C0426b implements Interpolator {
    private final float[] f1032a;
    private final float f1033b = (1.0f / ((float) (this.f1032a.length - 1)));

    public C0426b(float[] fArr) {
        this.f1032a = fArr;
    }

    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        int min = Math.min((int) (((float) (this.f1032a.length - 1)) * f), this.f1032a.length - 2);
        float f2 = (f - (((float) min) * this.f1033b)) / this.f1033b;
        return ((this.f1032a[min + 1] - this.f1032a[min]) * f2) + this.f1032a[min];
    }
}
