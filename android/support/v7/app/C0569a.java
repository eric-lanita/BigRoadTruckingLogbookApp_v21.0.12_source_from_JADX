package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.p011a.C0564a.C0563k;
import android.support.v7.view.C0628b;
import android.support.v7.view.C0628b.C0610a;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public abstract class C0569a {

    public static class C0566a extends MarginLayoutParams {
        public int f1271a;

        public C0566a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1271a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0563k.ActionBarLayout);
            this.f1271a = obtainStyledAttributes.getInt(C0563k.ActionBarLayout_android_layout_gravity, 0);
            obtainStyledAttributes.recycle();
        }

        public C0566a(int i, int i2) {
            super(i, i2);
            this.f1271a = 0;
            this.f1271a = 8388627;
        }

        public C0566a(C0566a c0566a) {
            super(c0566a);
            this.f1271a = 0;
            this.f1271a = c0566a.f1271a;
        }

        public C0566a(LayoutParams layoutParams) {
            super(layoutParams);
            this.f1271a = 0;
        }
    }

    public interface C0567b {
        void m2586a(boolean z);
    }

    public static abstract class C0568c {
        public abstract Drawable m2587a();

        public abstract CharSequence m2588b();

        public abstract View m2589c();

        public abstract void m2590d();

        public abstract CharSequence m2591e();
    }

    public abstract int mo477a();

    public abstract void mo481a(boolean z);

    public abstract boolean mo484b();

    public void mo483b(boolean z) {
    }

    public Context mo485c() {
        return null;
    }

    public void mo510c(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
        }
    }

    public int mo511d() {
        return 0;
    }

    public void mo478a(float f) {
        if (f != 0.0f) {
            throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
        }
    }

    public void mo486d(boolean z) {
    }

    public void mo487e(boolean z) {
    }

    public void mo479a(Configuration configuration) {
    }

    public void mo489f(boolean z) {
    }

    public C0628b mo508a(C0610a c0610a) {
        return null;
    }

    public boolean mo488e() {
        return false;
    }

    public boolean mo482a(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean mo490f() {
        return false;
    }

    public void mo480a(CharSequence charSequence) {
    }

    boolean mo491g() {
        return false;
    }

    void mo492h() {
    }
}
