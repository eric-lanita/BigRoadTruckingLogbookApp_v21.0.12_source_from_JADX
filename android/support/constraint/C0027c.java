package android.support.constraint;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.constraint.C0032f.C0031b;
import android.support.constraint.ConstraintLayout.C0022a;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

public class C0027c extends ViewGroup {
    C0025b f219a;

    public static class C0026a extends C0022a {
        public float an = 1.0f;
        public boolean ao = false;
        public float ap = 0.0f;
        public float aq = 0.0f;
        public float ar = 0.0f;
        public float as = 0.0f;
        public float at = 1.0f;
        public float au = 1.0f;
        public float av = 0.0f;
        public float aw = 0.0f;
        public float ax = 0.0f;
        public float ay = 0.0f;
        public float az = 0.0f;

        public C0026a(int i, int i2) {
            super(i, i2);
        }

        public C0026a(Context context, AttributeSet attributeSet) {
            int i = 0;
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0031b.ConstraintSet);
            int indexCount = obtainStyledAttributes.getIndexCount();
            while (i < indexCount) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0031b.ConstraintSet_android_alpha) {
                    this.an = obtainStyledAttributes.getFloat(index, this.an);
                } else if (index == C0031b.ConstraintSet_android_elevation) {
                    this.ap = obtainStyledAttributes.getFloat(index, this.ap);
                    this.ao = true;
                } else if (index == C0031b.ConstraintSet_android_rotationX) {
                    this.ar = obtainStyledAttributes.getFloat(index, this.ar);
                } else if (index == C0031b.ConstraintSet_android_rotationY) {
                    this.as = obtainStyledAttributes.getFloat(index, this.as);
                } else if (index == C0031b.ConstraintSet_android_rotation) {
                    this.aq = obtainStyledAttributes.getFloat(index, this.aq);
                } else if (index == C0031b.ConstraintSet_android_scaleX) {
                    this.at = obtainStyledAttributes.getFloat(index, this.at);
                } else if (index == C0031b.ConstraintSet_android_scaleY) {
                    this.au = obtainStyledAttributes.getFloat(index, this.au);
                } else if (index == C0031b.ConstraintSet_android_transformPivotX) {
                    this.av = obtainStyledAttributes.getFloat(index, this.av);
                } else if (index == C0031b.ConstraintSet_android_transformPivotY) {
                    this.aw = obtainStyledAttributes.getFloat(index, this.aw);
                } else if (index == C0031b.ConstraintSet_android_translationX) {
                    this.ax = obtainStyledAttributes.getFloat(index, this.ax);
                } else if (index == C0031b.ConstraintSet_android_translationY) {
                    this.ay = obtainStyledAttributes.getFloat(index, this.ay);
                } else if (index == C0031b.ConstraintSet_android_translationZ) {
                    this.ax = obtainStyledAttributes.getFloat(index, this.az);
                }
                i++;
            }
        }
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m117a();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m118a(attributeSet);
    }

    public C0026a m118a(AttributeSet attributeSet) {
        return new C0026a(getContext(), attributeSet);
    }

    protected C0026a m117a() {
        return new C0026a(-2, -2);
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return new C0022a(layoutParams);
    }

    public C0025b getConstraintSet() {
        if (this.f219a == null) {
            this.f219a = new C0025b();
        }
        this.f219a.m114a(this);
        return this.f219a;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }
}
