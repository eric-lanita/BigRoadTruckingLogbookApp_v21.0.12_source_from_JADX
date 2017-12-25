package android.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.support.v4.content.C0126a;
import android.support.v7.p011a.C0564a.C0563k;
import android.util.AttributeSet;
import android.widget.ImageView;

public class C0768o {
    private final ImageView f2312a;
    private final C0765l f2313b;

    public C0768o(ImageView imageView, C0765l c0765l) {
        this.f2312a = imageView;
        this.f2313b = c0765l;
    }

    public void m3930a(AttributeSet attributeSet, int i) {
        ay a = ay.m3733a(this.f2312a.getContext(), attributeSet, C0563k.AppCompatImageView, i, 0);
        try {
            Drawable b = a.m3740b(C0563k.AppCompatImageView_android_src);
            if (b != null) {
                this.f2312a.setImageDrawable(b);
            }
            int g = a.m3749g(C0563k.AppCompatImageView_srcCompat, -1);
            if (g != -1) {
                b = this.f2313b.m3925a(this.f2312a.getContext(), g);
                if (b != null) {
                    this.f2312a.setImageDrawable(b);
                }
            }
            b = this.f2312a.getDrawable();
            if (b != null) {
                ah.m3593a(b);
            }
            a.m3737a();
        } catch (Throwable th) {
            a.m3737a();
        }
    }

    public void m3929a(int i) {
        if (i != 0) {
            Drawable a = this.f2313b != null ? this.f2313b.m3925a(this.f2312a.getContext(), i) : C0126a.m582a(this.f2312a.getContext(), i);
            if (a != null) {
                ah.m3593a(a);
            }
            this.f2312a.setImageDrawable(a);
            return;
        }
        this.f2312a.setImageDrawable(null);
    }
}
