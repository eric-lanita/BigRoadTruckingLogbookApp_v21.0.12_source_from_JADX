package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.ag;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public class ContentFrameLayout extends FrameLayout {
    private TypedValue f1442a;
    private TypedValue f1443b;
    private TypedValue f1444c;
    private TypedValue f1445d;
    private TypedValue f1446e;
    private TypedValue f1447f;
    private final Rect f1448g;
    private C0602a f1449h;

    public interface C0602a {
        void mo469a();

        void mo470b();
    }

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1448g = new Rect();
    }

    public void m2845a(Rect rect) {
        fitSystemWindows(rect);
    }

    public void setAttachListener(C0602a c0602a) {
        this.f1449h = c0602a;
    }

    public void m2844a(int i, int i2, int i3, int i4) {
        this.f1448g.set(i, i2, i3, i4);
        if (ag.m1821u(this)) {
            requestLayout();
        }
    }

    protected void onMeasure(int i, int i2) {
        TypedValue typedValue;
        int dimension;
        Object obj;
        TypedValue typedValue2;
        int dimension2;
        Object obj2 = null;
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        Object obj3 = displayMetrics.widthPixels < displayMetrics.heightPixels ? 1 : null;
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE) {
            typedValue = obj3 != null ? this.f1445d : this.f1444c;
            if (!(typedValue == null || typedValue.type == 0)) {
                if (typedValue.type == 5) {
                    dimension = (int) typedValue.getDimension(displayMetrics);
                } else if (typedValue.type == 6) {
                    dimension = (int) typedValue.getFraction((float) displayMetrics.widthPixels, (float) displayMetrics.widthPixels);
                } else {
                    dimension = 0;
                }
                if (dimension > 0) {
                    i = MeasureSpec.makeMeasureSpec(Math.min(dimension - (this.f1448g.left + this.f1448g.right), MeasureSpec.getSize(i)), 1073741824);
                    obj = 1;
                    if (mode2 == Integer.MIN_VALUE) {
                        typedValue = obj3 == null ? this.f1446e : this.f1447f;
                        if (!(typedValue == null || typedValue.type == 0)) {
                            if (typedValue.type == 5) {
                                dimension = (int) typedValue.getDimension(displayMetrics);
                            } else if (typedValue.type != 6) {
                                dimension = (int) typedValue.getFraction((float) displayMetrics.heightPixels, (float) displayMetrics.heightPixels);
                            } else {
                                dimension = 0;
                            }
                            if (dimension > 0) {
                                i2 = MeasureSpec.makeMeasureSpec(Math.min(dimension - (this.f1448g.top + this.f1448g.bottom), MeasureSpec.getSize(i2)), 1073741824);
                            }
                        }
                    }
                    super.onMeasure(i, i2);
                    mode2 = getMeasuredWidth();
                    dimension = MeasureSpec.makeMeasureSpec(mode2, 1073741824);
                    if (obj == null && mode == Integer.MIN_VALUE) {
                        typedValue2 = obj3 == null ? this.f1443b : this.f1442a;
                        if (!(typedValue2 == null || typedValue2.type == 0)) {
                            dimension2 = typedValue2.type != 5 ? (int) typedValue2.getDimension(displayMetrics) : typedValue2.type != 6 ? (int) typedValue2.getFraction((float) displayMetrics.widthPixels, (float) displayMetrics.widthPixels) : 0;
                            if (dimension2 > 0) {
                                dimension2 -= this.f1448g.left + this.f1448g.right;
                            }
                            if (mode2 < dimension2) {
                                dimension2 = MeasureSpec.makeMeasureSpec(dimension2, 1073741824);
                                obj2 = 1;
                                if (obj2 == null) {
                                    super.onMeasure(dimension2, i2);
                                }
                            }
                        }
                    }
                    dimension2 = dimension;
                    if (obj2 == null) {
                        super.onMeasure(dimension2, i2);
                    }
                }
            }
        }
        obj = null;
        if (mode2 == Integer.MIN_VALUE) {
            if (obj3 == null) {
            }
            if (typedValue.type == 5) {
                dimension = (int) typedValue.getDimension(displayMetrics);
            } else if (typedValue.type != 6) {
                dimension = 0;
            } else {
                dimension = (int) typedValue.getFraction((float) displayMetrics.heightPixels, (float) displayMetrics.heightPixels);
            }
            if (dimension > 0) {
                i2 = MeasureSpec.makeMeasureSpec(Math.min(dimension - (this.f1448g.top + this.f1448g.bottom), MeasureSpec.getSize(i2)), 1073741824);
            }
        }
        super.onMeasure(i, i2);
        mode2 = getMeasuredWidth();
        dimension = MeasureSpec.makeMeasureSpec(mode2, 1073741824);
        if (obj3 == null) {
        }
        if (typedValue2.type != 5) {
            if (typedValue2.type != 6) {
            }
        }
        if (dimension2 > 0) {
            dimension2 -= this.f1448g.left + this.f1448g.right;
        }
        if (mode2 < dimension2) {
            dimension2 = MeasureSpec.makeMeasureSpec(dimension2, 1073741824);
            obj2 = 1;
            if (obj2 == null) {
                super.onMeasure(dimension2, i2);
            }
        }
        dimension2 = dimension;
        if (obj2 == null) {
            super.onMeasure(dimension2, i2);
        }
    }

    public TypedValue getMinWidthMajor() {
        if (this.f1442a == null) {
            this.f1442a = new TypedValue();
        }
        return this.f1442a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f1443b == null) {
            this.f1443b = new TypedValue();
        }
        return this.f1443b;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f1444c == null) {
            this.f1444c = new TypedValue();
        }
        return this.f1444c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f1445d == null) {
            this.f1445d = new TypedValue();
        }
        return this.f1445d;
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f1446e == null) {
            this.f1446e = new TypedValue();
        }
        return this.f1446e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f1447f == null) {
            this.f1447f = new TypedValue();
        }
        return this.f1447f;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f1449h != null) {
            this.f1449h.mo469a();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f1449h != null) {
            this.f1449h.mo470b();
        }
    }
}
