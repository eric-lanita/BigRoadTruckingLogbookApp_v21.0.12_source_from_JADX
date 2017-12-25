package android.support.v7.widget;

import android.content.Context;
import android.support.v7.p011a.C0564a.C0553a;
import android.util.AttributeSet;
import android.widget.SeekBar;

public class C0775u extends SeekBar {
    private C0776v f2331a;
    private C0765l f2332b;

    public C0775u(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0553a.seekBarStyle);
    }

    public C0775u(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2332b = C0765l.m3902a();
        this.f2331a = new C0776v(this, this.f2332b);
        this.f2331a.mo676a(attributeSet, i);
    }
}
