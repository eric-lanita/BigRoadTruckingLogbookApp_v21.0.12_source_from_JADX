package android.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

class C0776v extends C0772r {
    private static final int[] f2333b = new int[]{16843074};
    private final SeekBar f2334c;

    C0776v(SeekBar seekBar, C0765l c0765l) {
        super(seekBar, c0765l);
        this.f2334c = seekBar;
    }

    void mo676a(AttributeSet attributeSet, int i) {
        super.mo676a(attributeSet, i);
        ay a = ay.m3733a(this.f2334c.getContext(), attributeSet, f2333b, i, 0);
        Drawable b = a.m3740b(0);
        if (b != null) {
            this.f2334c.setThumb(b);
        }
        a.m3737a();
    }
}
