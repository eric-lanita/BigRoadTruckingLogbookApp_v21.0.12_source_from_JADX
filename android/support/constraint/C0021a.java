package android.support.constraint;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.constraint.C0032f.C0030a;
import android.support.constraint.C0032f.C0031b;
import android.support.constraint.ConstraintLayout.C0022a;
import android.support.constraint.solver.widgets.C0044e;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.facebook.share.internal.ShareConstants;
import java.util.Arrays;

public abstract class C0021a extends View {
    protected int[] f89a;
    protected int f90b;
    protected Context f91c;
    protected C0044e f92d;
    protected boolean f93e;
    private String f94f;

    public C0021a(Context context) {
        super(context);
        this.f89a = new int[32];
        this.f90b = 0;
        this.f92d = null;
        this.f93e = false;
        this.f91c = context;
        mo26a(null);
    }

    public C0021a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f89a = new int[32];
        this.f90b = 0;
        this.f92d = null;
        this.f93e = false;
        this.f91c = context;
        mo26a(attributeSet);
    }

    public C0021a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f89a = new int[32];
        this.f90b = 0;
        this.f92d = null;
        this.f93e = false;
        this.f91c = context;
        mo26a(attributeSet);
    }

    protected void mo26a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0031b.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0031b.ConstraintLayout_Layout_constraint_referenced_ids) {
                    this.f94f = obtainStyledAttributes.getString(index);
                    setIds(this.f94f);
                }
            }
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f89a, this.f90b);
    }

    public void setReferencedIds(int[] iArr) {
        for (int tag : iArr) {
            setTag(tag, null);
        }
    }

    public void setTag(int i, Object obj) {
        if (this.f90b + 1 > this.f89a.length) {
            this.f89a = Arrays.copyOf(this.f89a, this.f89a.length * 2);
        }
        this.f89a[this.f90b] = i;
        this.f90b++;
    }

    public void onDraw(Canvas canvas) {
    }

    protected void onMeasure(int i, int i2) {
        if (this.f93e) {
            super.onMeasure(i, i2);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void m75a() {
        if (this.f92d != null) {
            LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof C0022a) {
                ((C0022a) layoutParams).al = this.f92d;
            }
        }
    }

    private void m74a(String str) {
        if (str != null && this.f91c != null) {
            int i;
            int intValue;
            Object trim = str.trim();
            try {
                i = C0030a.class.getField(trim).getInt(null);
            } catch (Exception e) {
                i = 0;
            }
            if (i == 0) {
                i = this.f91c.getResources().getIdentifier(trim, ShareConstants.WEB_DIALOG_PARAM_ID, this.f91c.getPackageName());
            }
            if (i == 0 && isInEditMode() && (getParent() instanceof ConstraintLayout)) {
                Object a = ((ConstraintLayout) getParent()).m92a(0, trim);
                if (a != null && (a instanceof Integer)) {
                    intValue = ((Integer) a).intValue();
                    if (intValue == 0) {
                        setTag(intValue, null);
                    } else {
                        Log.w("ConstraintHelper", "Could not find id of \"" + trim + "\"");
                    }
                }
            }
            intValue = i;
            if (intValue == 0) {
                Log.w("ConstraintHelper", "Could not find id of \"" + trim + "\"");
            } else {
                setTag(intValue, null);
            }
        }
    }

    private void setIds(String str) {
        if (str != null) {
            int i = 0;
            while (true) {
                int indexOf = str.indexOf(44, i);
                if (indexOf == -1) {
                    m74a(str.substring(i));
                    return;
                } else {
                    m74a(str.substring(i, indexOf));
                    i = indexOf + 1;
                }
            }
        }
    }

    public void mo27a(ConstraintLayout constraintLayout) {
        if (isInEditMode()) {
            setIds(this.f94f);
        }
        if (this.f92d != null) {
            this.f92d.mo37y();
            for (int i = 0; i < this.f90b; i++) {
                View findViewById = constraintLayout.findViewById(this.f89a[i]);
                if (findViewById != null) {
                    this.f92d.m295b(constraintLayout.m90a(findViewById));
                }
            }
        }
    }

    public void mo28b(ConstraintLayout constraintLayout) {
    }

    public void m79c(ConstraintLayout constraintLayout) {
    }
}
