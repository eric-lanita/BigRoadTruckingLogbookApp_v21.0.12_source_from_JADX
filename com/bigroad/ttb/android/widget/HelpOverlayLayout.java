package com.bigroad.ttb.android.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.bigroad.ttb.android.R;

public class HelpOverlayLayout extends ViewGroup {
    Rect f8566a;
    private View[] f8567b;
    private int f8568c;
    private boolean f8569d;

    private enum ChildPosition {
        LEFT_OF_HIGHLIGHT,
        RIGHT_OF_HIGHLIGHT,
        ABOVE_HIGHLIGHT,
        BELOW_HIGHLIGHT
    }

    public static class C2429a extends LayoutParams {
        private int f8562a;
        private int f8563b;
        private int f8564c;
        private int f8565d;

        public void m11958a(int i, int i2, int i3, int i4) {
            this.f8562a = i;
            this.f8563b = i2;
            this.f8564c = i3;
            this.f8565d = i4;
        }

        public C2429a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C2429a(int i, int i2) {
            super(i, i2);
        }

        public C2429a(LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m11962a(attributeSet);
    }

    public HelpOverlayLayout(Context context) {
        super(context);
        this.f8567b = new View[4];
        this.f8568c = 0;
        this.f8569d = false;
        m11964a(context);
    }

    public HelpOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8567b = new View[4];
        this.f8568c = 0;
        this.f8569d = false;
        m11964a(context);
    }

    public HelpOverlayLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8567b = new View[4];
        this.f8568c = 0;
        this.f8569d = false;
        m11964a(context);
    }

    protected View getNoteView() {
        return findViewById(R.id.helpOverlay_note);
    }

    protected void setNoteVisibility(int i) {
        View noteView = getNoteView();
        if (noteView != null) {
            noteView.setVisibility(i);
        }
    }

    protected TriangleView getOverlayArrow() {
        return (TriangleView) findViewById(R.id.helpOverlay_arrow);
    }

    protected void setArrowVisibility(int i) {
        TriangleView overlayArrow = getOverlayArrow();
        if (overlayArrow != null) {
            overlayArrow.setVisibility(i);
        }
    }

    public boolean m11968a(Rect rect) {
        return m11969a(rect, false);
    }

    public boolean m11969a(Rect rect, boolean z) {
        if (this.f8566a == rect && this.f8569d == z) {
            return false;
        }
        if (this.f8566a != null && this.f8566a.equals(rect)) {
            return false;
        }
        this.f8566a = rect;
        if (!m11967a() && z) {
            setNoteVisibility(8);
            setArrowVisibility(8);
        } else if (m11967a() && this.f8569d) {
            setNoteVisibility(0);
            setArrowVisibility(0);
        }
        this.f8569d = z;
        return true;
    }

    public void setChildPadding(int i) {
        this.f8568c = (int) (((float) i) * getResources().getDisplayMetrics().density);
    }

    protected void m11964a(Context context) {
        for (int i = 0; i < this.f8567b.length; i++) {
            this.f8567b[i] = new View(context);
            this.f8567b[i].setBackgroundResource(R.color.overlayFadeBackground);
            addView(this.f8567b[i], new C2429a(0, 0));
        }
    }

    protected void m11965a(View view, int i, int i2) {
        view.measure(MeasureSpec.makeMeasureSpec(i, 1073741824), MeasureSpec.makeMeasureSpec(i2, 1073741824));
    }

    protected void m11963a(int i, int i2) {
        if (this.f8566a == null) {
            m11970b(i, i2);
            return;
        }
        Rect rect = this.f8566a;
        this.f8567b[0].setVisibility(0);
        this.f8567b[1].setVisibility(0);
        this.f8567b[2].setVisibility(0);
        this.f8567b[3].setVisibility(0);
        m11965a(this.f8567b[0], i, rect.top);
        ((C2429a) this.f8567b[0].getLayoutParams()).m11958a(0, 0, i, rect.top);
        m11965a(this.f8567b[1], i, i2 - rect.bottom);
        ((C2429a) this.f8567b[1].getLayoutParams()).m11958a(0, rect.bottom, i, i2);
        m11965a(this.f8567b[2], rect.left, rect.bottom - rect.top);
        ((C2429a) this.f8567b[2].getLayoutParams()).m11958a(0, rect.top, rect.left, rect.bottom);
        m11965a(this.f8567b[3], i - rect.right, rect.bottom - rect.top);
        ((C2429a) this.f8567b[3].getLayoutParams()).m11958a(rect.right, rect.top, i, rect.bottom);
    }

    protected void m11970b(int i, int i2) {
        ((C2429a) this.f8567b[0].getLayoutParams()).m11958a(0, 0, i, i2);
        this.f8567b[1].setVisibility(4);
        this.f8567b[2].setVisibility(4);
        this.f8567b[3].setVisibility(4);
    }

    protected boolean m11967a() {
        return (this.f8566a == null || this.f8566a.isEmpty()) ? false : true;
    }

    protected int m11971c(int i, int i2) {
        int i3 = 1073741824;
        if (i2 >= 0) {
            i = Math.min(i, i2);
        } else if (i2 != -1) {
            i3 = i2 == -2 ? Integer.MIN_VALUE : 0;
        }
        return MeasureSpec.makeMeasureSpec(i, i3);
    }

    protected ChildPosition m11961a(View view, Rect rect, Rect rect2) {
        ChildPosition childPosition;
        Rect rect3 = new Rect(rect);
        m11959b(rect3);
        C2429a c2429a = (C2429a) view.getLayoutParams();
        view.measure(m11971c(rect3.width(), c2429a.width), m11971c(rect3.height(), c2429a.height));
        Rect rect4 = new Rect(this.f8568c, this.f8568c, this.f8568c + view.getMeasuredWidth(), this.f8568c + view.getMeasuredHeight());
        rect4.offsetTo(rect.left, rect.top);
        if (rect.bottom < this.f8566a.top || rect.top > this.f8566a.bottom) {
            rect4.offsetTo(Math.min(Math.max(this.f8566a.centerX() - (rect4.width() / 2), rect.left), rect.right - rect4.width()), rect4.top);
            childPosition = rect.bottom < this.f8566a.top ? ChildPosition.ABOVE_HIGHLIGHT : ChildPosition.BELOW_HIGHLIGHT;
        } else {
            rect4.offsetTo(rect4.left, Math.min(Math.max(this.f8566a.centerY() - (rect4.height() / 2), rect.top), rect.bottom - rect4.height()));
            childPosition = rect.right < this.f8566a.left ? ChildPosition.LEFT_OF_HIGHLIGHT : ChildPosition.RIGHT_OF_HIGHLIGHT;
        }
        if (rect4.bottom < this.f8566a.top) {
            rect4.offsetTo(rect4.left, rect.bottom - rect4.height());
        }
        if (rect4.right < this.f8566a.left) {
            rect4.offsetTo(rect.right - rect4.width(), rect4.top);
        }
        c2429a.m11958a(rect4.left, rect4.top, rect4.right, rect4.bottom);
        if (rect2 != null) {
            rect2.set(rect4);
        }
        return childPosition;
    }

    protected void m11966a(ChildPosition childPosition, Rect rect) {
        TriangleView overlayArrow = getOverlayArrow();
        int i = (int) (4.0f * getResources().getDisplayMetrics().density);
        if (overlayArrow != null) {
            C2429a c2429a = (C2429a) overlayArrow.getLayoutParams();
            int a = c2429a.f8564c - c2429a.f8562a;
            int c = c2429a.f8565d - c2429a.f8563b;
            switch (childPosition) {
                case LEFT_OF_HIGHLIGHT:
                    c2429a.f8562a = rect.right - i;
                    c2429a.f8564c = c2429a.f8562a + a;
                    overlayArrow.setDirection(4);
                    break;
                case RIGHT_OF_HIGHLIGHT:
                    c2429a.f8562a = i + (rect.left - a);
                    c2429a.f8564c = c2429a.f8562a + a;
                    overlayArrow.setDirection(3);
                    break;
                case ABOVE_HIGHLIGHT:
                    c2429a.f8563b = rect.bottom - i;
                    c2429a.f8565d = c2429a.f8563b + c;
                    overlayArrow.setDirection(2);
                    break;
                case BELOW_HIGHLIGHT:
                    c2429a.f8563b = i + (rect.top - c);
                    c2429a.f8565d = c2429a.f8563b + c;
                    overlayArrow.setDirection(1);
                    break;
            }
            overlayArrow.invalidate();
        }
    }

    private Rect m11960d(int i, int i2) {
        Rect rect = new Rect(this.f8566a);
        rect.inset(-1, -1);
        rect.intersect(0, 0, i, i2);
        return rect;
    }

    private void m11959b(Rect rect) {
        rect.left += this.f8568c;
        rect.top += this.f8568c;
        rect.right -= this.f8568c;
        rect.bottom -= this.f8568c;
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 0;
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        int measuredHeight;
        if (!m11967a()) {
            Log.d("TT-HelpOverlayLayout", "HelpOverlayLayout used without a highlight set");
            setArrowVisibility(8);
            View noteView = getNoteView();
            if (!(noteView == null || noteView.getVisibility() == 8)) {
                C2429a c2429a = (C2429a) noteView.getLayoutParams();
                noteView.measure(m11971c(size - (this.f8568c * 2), c2429a.width), m11971c(size2 - (this.f8568c * 2), c2429a.height));
                mode2 = (size / 2) - (noteView.getMeasuredWidth() / 2);
                if (mode2 < 0) {
                    mode2 = 0;
                }
                measuredHeight = (size2 / 2) - (noteView.getMeasuredHeight() / 2);
                if (measuredHeight >= 0) {
                    i3 = measuredHeight;
                }
                m11970b(size, size2);
                c2429a.m11958a(mode2, i3, noteView.getMeasuredWidth() + mode2, noteView.getMeasuredHeight() + i3);
            }
            setMeasuredDimension(size, size2);
        } else if (mode == 0 || mode2 == 0) {
            throw new IllegalStateException("HelpOverlayLayout must have a specified height");
        } else {
            Rect rect;
            m11963a(size, size2);
            Rect d = m11960d(size, size2);
            Rect rect2 = new Rect(0, 0, d.left, size2);
            mode2 = rect2.height() * rect2.width();
            Rect rect3 = new Rect(0, d.bottom, size, size2);
            mode = rect3.width() * rect3.height();
            if (mode > mode2) {
                rect = rect3;
            } else {
                mode = mode2;
                rect = rect2;
            }
            rect2 = new Rect(d.right, 0, size, size2);
            measuredHeight = rect2.width() * rect2.height();
            if (measuredHeight > mode) {
                mode = measuredHeight;
                rect = rect2;
            }
            rect3 = new Rect(0, 0, size, d.top);
            if (rect3.width() * rect3.height() > mode) {
                rect = rect3;
            }
            View noteView2 = getNoteView();
            rect2 = new Rect();
            ChildPosition childPosition = ChildPosition.LEFT_OF_HIGHLIGHT;
            if (!(noteView2 == null || noteView2.getVisibility() == 8)) {
                childPosition = m11961a(noteView2, rect, rect2);
            }
            setArrowVisibility(0);
            View overlayArrow = getOverlayArrow();
            if (overlayArrow != null) {
                m11961a(overlayArrow, rect, null);
                m11966a(childPosition, rect2);
            }
            setMeasuredDimension(size, size2);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                C2429a c2429a = (C2429a) childAt.getLayoutParams();
                childAt.layout(c2429a.f8562a, c2429a.f8563b, c2429a.f8564c, c2429a.f8565d);
            }
        }
    }

    public C2429a m11962a(AttributeSet attributeSet) {
        return new C2429a(getContext(), attributeSet);
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new C2429a(-2, -2);
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof C2429a;
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return new C2429a(layoutParams);
    }
}
