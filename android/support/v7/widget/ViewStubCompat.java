package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.v7.p011a.C0564a.C0563k;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

public final class ViewStubCompat extends View {
    private int f2018a;
    private int f2019b;
    private WeakReference<View> f2020c;
    private LayoutInflater f2021d;
    private C0711a f2022e;

    public interface C0711a {
        void m3508a(ViewStubCompat viewStubCompat, View view);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2018a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0563k.ViewStubCompat, i, 0);
        this.f2019b = obtainStyledAttributes.getResourceId(C0563k.ViewStubCompat_android_inflatedId, -1);
        this.f2018a = obtainStyledAttributes.getResourceId(C0563k.ViewStubCompat_android_layout, 0);
        setId(obtainStyledAttributes.getResourceId(C0563k.ViewStubCompat_android_id, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    public int getInflatedId() {
        return this.f2019b;
    }

    public void setInflatedId(int i) {
        this.f2019b = i;
    }

    public int getLayoutResource() {
        return this.f2018a;
    }

    public void setLayoutResource(int i) {
        this.f2018a = i;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f2021d = layoutInflater;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f2021d;
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void draw(Canvas canvas) {
    }

    protected void dispatchDraw(Canvas canvas) {
    }

    public void setVisibility(int i) {
        if (this.f2020c != null) {
            View view = (View) this.f2020c.get();
            if (view != null) {
                view.setVisibility(i);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            m3509a();
        }
    }

    public View m3509a() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        } else if (this.f2018a != 0) {
            LayoutInflater layoutInflater;
            ViewGroup viewGroup = (ViewGroup) parent;
            if (this.f2021d != null) {
                layoutInflater = this.f2021d;
            } else {
                layoutInflater = LayoutInflater.from(getContext());
            }
            View inflate = layoutInflater.inflate(this.f2018a, viewGroup, false);
            if (this.f2019b != -1) {
                inflate.setId(this.f2019b);
            }
            int indexOfChild = viewGroup.indexOfChild(this);
            viewGroup.removeViewInLayout(this);
            LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                viewGroup.addView(inflate, indexOfChild, layoutParams);
            } else {
                viewGroup.addView(inflate, indexOfChild);
            }
            this.f2020c = new WeakReference(inflate);
            if (this.f2022e != null) {
                this.f2022e.m3508a(this, inflate);
            }
            return inflate;
        } else {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
    }

    public void setOnInflateListener(C0711a c0711a) {
        this.f2022e = c0711a;
    }
}
