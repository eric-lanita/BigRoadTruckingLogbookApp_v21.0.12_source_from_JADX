package android.support.constraint;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.constraint.C0032f.C0031b;
import android.support.constraint.solver.widgets.C0045a;
import android.util.AttributeSet;

public class Barrier extends C0021a {
    private int f95f = 0;
    private int f96g = 0;
    private C0045a f97h;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        super.setVisibility(8);
    }

    public int getType() {
        return this.f95f;
    }

    public void setType(int i) {
        this.f95f = i;
        this.f96g = i;
        if (VERSION.SDK_INT >= 17) {
            int i2;
            if (1 == getResources().getConfiguration().getLayoutDirection()) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (i2 != 0) {
                if (this.f95f == 5) {
                    this.f96g = 1;
                } else if (this.f95f == 6) {
                    this.f96g = 0;
                }
            } else if (this.f95f == 5) {
                this.f96g = 0;
            } else if (this.f95f == 6) {
                this.f96g = 1;
            }
        } else if (this.f95f == 5) {
            this.f96g = 0;
        } else if (this.f95f == 6) {
            this.f96g = 1;
        }
        this.f97h.m297a(this.f96g);
    }

    protected void mo26a(AttributeSet attributeSet) {
        super.mo26a(attributeSet);
        this.f97h = new C0045a();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0031b.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0031b.ConstraintLayout_Layout_barrierDirection) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                }
            }
        }
        this.d = this.f97h;
        m75a();
    }
}
