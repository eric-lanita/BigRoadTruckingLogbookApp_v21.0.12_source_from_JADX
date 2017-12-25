package com.bigroad.ttb.android.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.v7.widget.C0654z;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.TypedValue;

public class AutoResizeTextView extends C0654z {
    private final RectF f8299a;
    private final C2400a f8300b;
    private float f8301c;
    private float f8302d;
    private float f8303e;
    private float f8304f;
    private int f8305g;
    private int f8306h;
    private TextPaint f8307i;
    private boolean f8308j;

    private interface C2400a {
        int mo1319a(int i, RectF rectF);
    }

    class C24011 implements C2400a {
        final RectF f8297a = new RectF();
        final /* synthetic */ AutoResizeTextView f8298b;

        C24011(AutoResizeTextView autoResizeTextView) {
            this.f8298b = autoResizeTextView;
        }

        @TargetApi(16)
        public int mo1319a(int i, RectF rectF) {
            String charSequence;
            int i2;
            this.f8298b.f8307i.setTextSize((float) i);
            TransformationMethod transformationMethod = this.f8298b.getTransformationMethod();
            if (transformationMethod != null) {
                charSequence = transformationMethod.getTransformation(this.f8298b.getText(), this.f8298b).toString();
            } else {
                charSequence = this.f8298b.getText().toString();
            }
            if (this.f8298b.getMaxLines() == 1) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (i2 != 0) {
                this.f8297a.bottom = this.f8298b.f8307i.getFontSpacing();
                this.f8297a.right = this.f8298b.f8307i.measureText(charSequence);
            } else {
                StaticLayout staticLayout = new StaticLayout(charSequence, this.f8298b.f8307i, this.f8298b.f8305g, Alignment.ALIGN_NORMAL, this.f8298b.f8302d, this.f8298b.f8303e, true);
                if (this.f8298b.getMaxLines() != -1 && staticLayout.getLineCount() > this.f8298b.getMaxLines()) {
                    return 1;
                }
                this.f8297a.bottom = (float) staticLayout.getHeight();
                int lineCount = staticLayout.getLineCount();
                int i3 = -1;
                for (int i4 = 0; i4 < lineCount; i4++) {
                    int lineEnd = staticLayout.getLineEnd(i4);
                    if (i4 < lineCount - 1 && lineEnd > 0 && !this.f8298b.m11763a(charSequence.charAt(lineEnd - 1), charSequence.charAt(lineEnd))) {
                        return 1;
                    }
                    if (((float) i3) < staticLayout.getLineRight(i4) - staticLayout.getLineLeft(i4)) {
                        i3 = ((int) staticLayout.getLineRight(i4)) - ((int) staticLayout.getLineLeft(i4));
                    }
                }
                this.f8297a.right = (float) i3;
            }
            this.f8297a.offsetTo(0.0f, 0.0f);
            if (rectF.contains(this.f8297a)) {
                return -1;
            }
            return 1;
        }
    }

    public AutoResizeTextView(Context context) {
        this(context, null, 16842884);
    }

    public AutoResizeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public AutoResizeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8299a = new RectF();
        this.f8302d = 1.0f;
        this.f8303e = 0.0f;
        this.f8308j = false;
        this.f8304f = TypedValue.applyDimension(2, 12.0f, getResources().getDisplayMetrics());
        this.f8301c = getTextSize();
        this.f8307i = new TextPaint(getPaint());
        if (this.f8306h == 0) {
            this.f8306h = -1;
        }
        this.f8300b = new C24011(this);
        this.f8308j = true;
    }

    public boolean m11763a(char c, char c2) {
        return c == ' ' || c == '-';
    }

    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        m11758a();
    }

    public void setTypeface(Typeface typeface) {
        super.setTypeface(typeface);
        m11758a();
    }

    public void setTextSize(float f) {
        this.f8301c = f;
        m11758a();
    }

    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.f8306h = i;
        m11758a();
    }

    public int getMaxLines() {
        return this.f8306h;
    }

    public void setSingleLine() {
        super.setSingleLine();
        this.f8306h = 1;
        m11758a();
    }

    public void setSingleLine(boolean z) {
        super.setSingleLine(z);
        if (z) {
            this.f8306h = 1;
        } else {
            this.f8306h = -1;
        }
        m11758a();
    }

    public void setLines(int i) {
        super.setLines(i);
        this.f8306h = i;
        m11758a();
    }

    public void setTextSize(int i, float f) {
        Resources system;
        Context context = getContext();
        if (context == null) {
            system = Resources.getSystem();
        } else {
            system = context.getResources();
        }
        this.f8301c = TypedValue.applyDimension(i, f, system.getDisplayMetrics());
        m11758a();
    }

    public void setLineSpacing(float f, float f2) {
        super.setLineSpacing(f, f2);
        this.f8302d = f2;
        this.f8303e = f;
    }

    public void setMinTextSize(float f) {
        this.f8304f = f;
        m11758a();
    }

    private void m11758a() {
        if (this.f8308j) {
            int i = (int) this.f8304f;
            int measuredHeight = (getMeasuredHeight() - getCompoundPaddingBottom()) - getCompoundPaddingTop();
            this.f8305g = (getMeasuredWidth() - getCompoundPaddingLeft()) - getCompoundPaddingRight();
            if (this.f8305g > 0) {
                this.f8307i = new TextPaint(getPaint());
                this.f8299a.right = (float) this.f8305g;
                this.f8299a.bottom = (float) measuredHeight;
                m11759a(i);
            }
        }
    }

    private void m11759a(int i) {
        super.setTextSize(0, (float) m11756a(i, (int) this.f8301c, this.f8300b, this.f8299a));
    }

    private int m11756a(int i, int i2, C2400a c2400a, RectF rectF) {
        int i3 = i2 - 1;
        int i4 = i;
        int i5 = i;
        while (i4 <= i3) {
            i5 = (i4 + i3) >>> 1;
            int a = c2400a.mo1319a(i5, rectF);
            if (a < 0) {
                i5++;
            } else if (a <= 0) {
                return i5;
            } else {
                i3 = i5 - 1;
                i5 = i4;
                i4 = i3;
            }
            int i6 = i5;
            i5 = i4;
            i4 = i6;
        }
        return i5;
    }

    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        m11758a();
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            m11758a();
        }
    }
}
