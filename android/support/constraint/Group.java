package android.support.constraint;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.constraint.ConstraintLayout.C0022a;
import android.util.AttributeSet;
import android.view.View;

public class Group extends C0021a {
    public Group(Context context) {
        super(context);
    }

    public Group(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Group(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void mo26a(AttributeSet attributeSet) {
        super.mo26a(attributeSet);
        this.e = false;
    }

    public void mo27a(ConstraintLayout constraintLayout) {
        float elevation;
        int visibility = getVisibility();
        if (VERSION.SDK_INT >= 21) {
            elevation = getElevation();
        } else {
            elevation = 0.0f;
        }
        for (int i = 0; i < this.b; i++) {
            View a = constraintLayout.m91a(this.a[i]);
            if (a != null) {
                a.setVisibility(visibility);
                if (elevation > 0.0f && VERSION.SDK_INT >= 21) {
                    a.setElevation(elevation);
                }
            }
        }
    }

    public void mo28b(ConstraintLayout constraintLayout) {
        C0022a c0022a = (C0022a) getLayoutParams();
        c0022a.al.m269g(0);
        c0022a.al.m271h(0);
    }
}
