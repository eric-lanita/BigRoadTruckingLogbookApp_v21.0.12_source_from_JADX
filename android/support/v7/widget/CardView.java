package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.p012b.C0636a.C0632a;
import android.support.v7.p012b.C0636a.C0634c;
import android.support.v7.p012b.C0636a.C0635d;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public class CardView extends FrameLayout {
    private static final int[] f1908a = new int[]{16842801};
    private static final ad f1909b;
    private boolean f1910c;
    private boolean f1911d;
    private int f1912e;
    private int f1913f;
    private final Rect f1914g = new Rect();
    private final Rect f1915h = new Rect();
    private final ab f1916i = new C06971(this);

    class C06971 implements ab {
        final /* synthetic */ CardView f1906a;
        private Drawable f1907b;

        C06971(CardView cardView) {
            this.f1906a = cardView;
        }

        public void mo601a(Drawable drawable) {
            this.f1907b = drawable;
            this.f1906a.setBackgroundDrawable(drawable);
        }

        public boolean mo602a() {
            return this.f1906a.getUseCompatPadding();
        }

        public boolean mo603b() {
            return this.f1906a.getPreventCornerOverlap();
        }

        public void mo600a(int i, int i2, int i3, int i4) {
            this.f1906a.f1915h.set(i, i2, i3, i4);
            super.setPadding(this.f1906a.f1914g.left + i, this.f1906a.f1914g.top + i2, this.f1906a.f1914g.right + i3, this.f1906a.f1914g.bottom + i4);
        }

        public void mo599a(int i, int i2) {
            if (i > this.f1906a.f1912e) {
                super.setMinimumWidth(i);
            }
            if (i2 > this.f1906a.f1913f) {
                super.setMinimumHeight(i2);
            }
        }

        public Drawable mo604c() {
            return this.f1907b;
        }

        public View mo605d() {
            return this.f1906a;
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f1909b = new aa();
        } else if (VERSION.SDK_INT >= 17) {
            f1909b = new ae();
        } else {
            f1909b = new ac();
        }
        f1909b.mo609a();
    }

    public CardView(Context context) {
        super(context);
        m3413a(context, null, 0);
    }

    public CardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3413a(context, attributeSet, 0);
    }

    public CardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3413a(context, attributeSet, i);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
    }

    public void setPaddingRelative(int i, int i2, int i3, int i4) {
    }

    public boolean getUseCompatPadding() {
        return this.f1910c;
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f1910c != z) {
            this.f1910c = z;
            f1909b.mo619g(this.f1916i);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (f1909b instanceof aa) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i);
        switch (mode) {
            case Integer.MIN_VALUE:
            case 1073741824:
                i = MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) f1909b.mo613b(this.f1916i)), MeasureSpec.getSize(i)), mode);
                break;
        }
        mode = MeasureSpec.getMode(i2);
        switch (mode) {
            case Integer.MIN_VALUE:
            case 1073741824:
                i2 = MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) f1909b.mo615c(this.f1916i)), MeasureSpec.getSize(i2)), mode);
                break;
        }
        super.onMeasure(i, i2);
    }

    private void m3413a(Context context, AttributeSet attributeSet, int i) {
        int color;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0635d.CardView, i, C0634c.CardView);
        if (obtainStyledAttributes.hasValue(C0635d.CardView_cardBackgroundColor)) {
            color = obtainStyledAttributes.getColor(C0635d.CardView_cardBackgroundColor, 0);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(f1908a);
            int color2 = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color2, fArr);
            color = fArr[2] > 0.5f ? getResources().getColor(C0632a.cardview_light_background) : getResources().getColor(C0632a.cardview_dark_background);
        }
        float dimension = obtainStyledAttributes.getDimension(C0635d.CardView_cardCornerRadius, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(C0635d.CardView_cardElevation, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(C0635d.CardView_cardMaxElevation, 0.0f);
        this.f1910c = obtainStyledAttributes.getBoolean(C0635d.CardView_cardUseCompatPadding, false);
        this.f1911d = obtainStyledAttributes.getBoolean(C0635d.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C0635d.CardView_contentPadding, 0);
        this.f1914g.left = obtainStyledAttributes.getDimensionPixelSize(C0635d.CardView_contentPaddingLeft, dimensionPixelSize);
        this.f1914g.top = obtainStyledAttributes.getDimensionPixelSize(C0635d.CardView_contentPaddingTop, dimensionPixelSize);
        this.f1914g.right = obtainStyledAttributes.getDimensionPixelSize(C0635d.CardView_contentPaddingRight, dimensionPixelSize);
        this.f1914g.bottom = obtainStyledAttributes.getDimensionPixelSize(C0635d.CardView_contentPaddingBottom, dimensionPixelSize);
        if (dimension2 > dimension3) {
            dimension3 = dimension2;
        }
        this.f1912e = obtainStyledAttributes.getDimensionPixelSize(C0635d.CardView_android_minWidth, 0);
        this.f1913f = obtainStyledAttributes.getDimensionPixelSize(C0635d.CardView_android_minHeight, 0);
        obtainStyledAttributes.recycle();
        f1909b.mo612a(this.f1916i, context, color, dimension, dimension2, dimension3);
    }

    public void setMinimumWidth(int i) {
        this.f1912e = i;
        super.setMinimumWidth(i);
    }

    public void setMinimumHeight(int i) {
        this.f1913f = i;
        super.setMinimumHeight(i);
    }

    public void setCardBackgroundColor(int i) {
        f1909b.mo611a(this.f1916i, i);
    }

    public int getContentPaddingLeft() {
        return this.f1914g.left;
    }

    public int getContentPaddingRight() {
        return this.f1914g.right;
    }

    public int getContentPaddingTop() {
        return this.f1914g.top;
    }

    public int getContentPaddingBottom() {
        return this.f1914g.bottom;
    }

    public void setRadius(float f) {
        f1909b.mo610a(this.f1916i, f);
    }

    public float getRadius() {
        return f1909b.mo617d(this.f1916i);
    }

    public void setCardElevation(float f) {
        f1909b.mo616c(this.f1916i, f);
    }

    public float getCardElevation() {
        return f1909b.mo618e(this.f1916i);
    }

    public void setMaxCardElevation(float f) {
        f1909b.mo614b(this.f1916i, f);
    }

    public float getMaxCardElevation() {
        return f1909b.mo608a(this.f1916i);
    }

    public boolean getPreventCornerOverlap() {
        return this.f1911d;
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.f1911d) {
            this.f1911d = z;
            f1909b.mo620h(this.f1916i);
        }
    }
}
