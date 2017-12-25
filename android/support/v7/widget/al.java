package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.p002a.p003a.C0085a;
import android.support.v7.p013c.p014a.C0637a;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

public class al extends ListView {
    private static final int[] f2034g = new int[]{0};
    final Rect f2035a = new Rect();
    int f2036b = 0;
    int f2037c = 0;
    int f2038d = 0;
    int f2039e = 0;
    protected int f2040f;
    private Field f2041h;
    private C0727a f2042i;

    private static class C0727a extends C0637a {
        private boolean f2087a = true;

        public C0727a(Drawable drawable) {
            super(drawable);
        }

        void m3644a(boolean z) {
            this.f2087a = z;
        }

        public boolean setState(int[] iArr) {
            if (this.f2087a) {
                return super.setState(iArr);
            }
            return false;
        }

        public void draw(Canvas canvas) {
            if (this.f2087a) {
                super.draw(canvas);
            }
        }

        public void setHotspot(float f, float f2) {
            if (this.f2087a) {
                super.setHotspot(f, f2);
            }
        }

        public void setHotspotBounds(int i, int i2, int i3, int i4) {
            if (this.f2087a) {
                super.setHotspotBounds(i, i2, i3, i4);
            }
        }

        public boolean setVisible(boolean z, boolean z2) {
            if (this.f2087a) {
                return super.setVisible(z, z2);
            }
            return false;
        }
    }

    public al(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        try {
            this.f2041h = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f2041h.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public void setSelector(Drawable drawable) {
        this.f2042i = drawable != null ? new C0727a(drawable) : null;
        super.setSelector(this.f2042i);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f2036b = rect.left;
        this.f2037c = rect.top;
        this.f2038d = rect.right;
        this.f2039e = rect.bottom;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        setSelectorEnabled(true);
        m3602b();
    }

    protected void dispatchDraw(Canvas canvas) {
        m3600a(canvas);
        super.dispatchDraw(canvas);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.f2040f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    protected void m3602b() {
        Drawable selector = getSelector();
        if (selector != null && m3604c()) {
            selector.setState(getDrawableState());
        }
    }

    protected boolean m3604c() {
        return mo622a() && isPressed();
    }

    protected boolean mo622a() {
        return false;
    }

    protected void m3600a(Canvas canvas) {
        if (!this.f2035a.isEmpty()) {
            Drawable selector = getSelector();
            if (selector != null) {
                selector.setBounds(this.f2035a);
                selector.draw(canvas);
            }
        }
    }

    protected void m3599a(int i, View view, float f, float f2) {
        m3598a(i, view);
        Drawable selector = getSelector();
        if (selector != null && i != -1) {
            C0085a.m451a(selector, f, f2);
        }
    }

    protected void m3598a(int i, View view) {
        boolean z = true;
        Drawable selector = getSelector();
        boolean z2 = (selector == null || i == -1) ? false : true;
        if (z2) {
            selector.setVisible(false, false);
        }
        m3603b(i, view);
        if (z2) {
            Rect rect = this.f2035a;
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            if (getVisibility() != 0) {
                z = false;
            }
            selector.setVisible(z, false);
            C0085a.m451a(selector, exactCenterX, exactCenterY);
        }
    }

    protected void m3603b(int i, View view) {
        Rect rect = this.f2035a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f2036b;
        rect.top -= this.f2037c;
        rect.right += this.f2038d;
        rect.bottom += this.f2039e;
        try {
            boolean z = this.f2041h.getBoolean(this);
            if (view.isEnabled() != z) {
                this.f2041h.set(this, Boolean.valueOf(!z));
                if (i != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public int m3597a(int i, int i2, int i3, int i4, int i5) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        getListPaddingLeft();
        getListPaddingRight();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        listPaddingBottom += listPaddingTop;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int i6 = 0;
        View view = null;
        int i7 = 0;
        int count = adapter.getCount();
        int i8 = 0;
        while (i8 < count) {
            View view2;
            listPaddingTop = adapter.getItemViewType(i8);
            if (listPaddingTop != i7) {
                int i9 = listPaddingTop;
                view2 = null;
                i7 = i9;
            } else {
                view2 = view;
            }
            view = adapter.getView(i8, view2, this);
            LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            if (layoutParams.height > 0) {
                listPaddingTop = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            } else {
                listPaddingTop = MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i, listPaddingTop);
            view.forceLayout();
            if (i8 > 0) {
                listPaddingTop = listPaddingBottom + dividerHeight;
            } else {
                listPaddingTop = listPaddingBottom;
            }
            listPaddingTop += view.getMeasuredHeight();
            if (listPaddingTop < i4) {
                if (i5 >= 0 && i8 >= i5) {
                    i6 = listPaddingTop;
                }
                i8++;
                listPaddingBottom = listPaddingTop;
            } else if (i5 < 0 || i8 <= i5 || i6 <= 0 || listPaddingTop == i4) {
                return i4;
            } else {
                return i6;
            }
        }
        return listPaddingBottom;
    }

    protected void setSelectorEnabled(boolean z) {
        if (this.f2042i != null) {
            this.f2042i.m3644a(z);
        }
    }
}
