package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.app.C0569a.C0568c;
import android.support.v7.p011a.C0564a.C0553a;
import android.support.v7.view.C0640a;
import android.support.v7.widget.aj.C0691a;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ar extends HorizontalScrollView implements OnItemSelectedListener {
    private static final Interpolator f2141j = new DecelerateInterpolator();
    Runnable f2142a;
    int f2143b;
    int f2144c;
    private C0732b f2145d;
    private aj f2146e;
    private Spinner f2147f;
    private boolean f2148g;
    private int f2149h;
    private int f2150i;

    private class C0731a extends BaseAdapter {
        final /* synthetic */ ar f2133a;

        private C0731a(ar arVar) {
            this.f2133a = arVar;
        }

        public int getCount() {
            return this.f2133a.f2146e.getChildCount();
        }

        public Object getItem(int i) {
            return ((C0733c) this.f2133a.f2146e.getChildAt(i)).m3690b();
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return this.f2133a.m3692a((C0568c) getItem(i), true);
            }
            ((C0733c) view).m3689a((C0568c) getItem(i));
            return view;
        }
    }

    private class C0732b implements OnClickListener {
        final /* synthetic */ ar f2134a;

        private C0732b(ar arVar) {
            this.f2134a = arVar;
        }

        public void onClick(View view) {
            ((C0733c) view).m3690b().m2590d();
            int childCount = this.f2134a.f2146e.getChildCount();
            for (int i = 0; i < childCount; i++) {
                boolean z;
                View childAt = this.f2134a.f2146e.getChildAt(i);
                if (childAt == view) {
                    z = true;
                } else {
                    z = false;
                }
                childAt.setSelected(z);
            }
        }
    }

    private class C0733c extends aj implements OnLongClickListener {
        final /* synthetic */ ar f2135a;
        private final int[] f2136b = new int[]{16842964};
        private C0568c f2137c;
        private TextView f2138d;
        private ImageView f2139e;
        private View f2140f;

        public C0733c(ar arVar, Context context, C0568c c0568c, boolean z) {
            this.f2135a = arVar;
            super(context, null, C0553a.actionBarTabStyle);
            this.f2137c = c0568c;
            ay a = ay.m3733a(context, null, this.f2136b, C0553a.actionBarTabStyle, 0);
            if (a.m3748f(0)) {
                setBackgroundDrawable(a.m3736a(0));
            }
            a.m3737a();
            if (z) {
                setGravity(8388627);
            }
            m3688a();
        }

        public void m3689a(C0568c c0568c) {
            this.f2137c = c0568c;
            m3688a();
        }

        public void setSelected(boolean z) {
            Object obj = isSelected() != z ? 1 : null;
            super.setSelected(z);
            if (obj != null && z) {
                sendAccessibilityEvent(4);
            }
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(C0568c.class.getName());
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            if (VERSION.SDK_INT >= 14) {
                accessibilityNodeInfo.setClassName(C0568c.class.getName());
            }
        }

        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (this.f2135a.f2143b > 0 && getMeasuredWidth() > this.f2135a.f2143b) {
                super.onMeasure(MeasureSpec.makeMeasureSpec(this.f2135a.f2143b, 1073741824), i2);
            }
        }

        public void m3688a() {
            C0568c c0568c = this.f2137c;
            View c = c0568c.m2589c();
            if (c != null) {
                C0733c parent = c.getParent();
                if (parent != this) {
                    if (parent != null) {
                        parent.removeView(c);
                    }
                    addView(c);
                }
                this.f2140f = c;
                if (this.f2138d != null) {
                    this.f2138d.setVisibility(8);
                }
                if (this.f2139e != null) {
                    this.f2139e.setVisibility(8);
                    this.f2139e.setImageDrawable(null);
                    return;
                }
                return;
            }
            boolean z;
            if (this.f2140f != null) {
                removeView(this.f2140f);
                this.f2140f = null;
            }
            Drawable a = c0568c.m2587a();
            CharSequence b = c0568c.m2588b();
            if (a != null) {
                if (this.f2139e == null) {
                    View imageView = new ImageView(getContext());
                    LayoutParams c0691a = new C0691a(-2, -2);
                    c0691a.f1843h = 16;
                    imageView.setLayoutParams(c0691a);
                    addView(imageView, 0);
                    this.f2139e = imageView;
                }
                this.f2139e.setImageDrawable(a);
                this.f2139e.setVisibility(0);
            } else if (this.f2139e != null) {
                this.f2139e.setVisibility(8);
                this.f2139e.setImageDrawable(null);
            }
            if (TextUtils.isEmpty(b)) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                if (this.f2138d == null) {
                    imageView = new C0654z(getContext(), null, C0553a.actionBarTabTextStyle);
                    imageView.setEllipsize(TruncateAt.END);
                    c0691a = new C0691a(-2, -2);
                    c0691a.f1843h = 16;
                    imageView.setLayoutParams(c0691a);
                    addView(imageView);
                    this.f2138d = imageView;
                }
                this.f2138d.setText(b);
                this.f2138d.setVisibility(0);
            } else if (this.f2138d != null) {
                this.f2138d.setVisibility(8);
                this.f2138d.setText(null);
            }
            if (this.f2139e != null) {
                this.f2139e.setContentDescription(c0568c.m2591e());
            }
            if (z || TextUtils.isEmpty(c0568c.m2591e())) {
                setOnLongClickListener(null);
                setLongClickable(false);
                return;
            }
            setOnLongClickListener(this);
        }

        public boolean onLongClick(View view) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            Context context = getContext();
            int width = getWidth();
            int height = getHeight();
            int i = context.getResources().getDisplayMetrics().widthPixels;
            Toast makeText = Toast.makeText(context, this.f2137c.m2591e(), 0);
            makeText.setGravity(49, (iArr[0] + (width / 2)) - (i / 2), height);
            makeText.show();
            return true;
        }

        public C0568c m3690b() {
            return this.f2137c;
        }
    }

    public void onMeasure(int i, int i2) {
        int i3 = 1;
        int mode = MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.f2146e.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.f2143b = -1;
        } else {
            if (childCount > 2) {
                this.f2143b = (int) (((float) MeasureSpec.getSize(i)) * 0.4f);
            } else {
                this.f2143b = MeasureSpec.getSize(i) / 2;
            }
            this.f2143b = Math.min(this.f2143b, this.f2144c);
        }
        mode = MeasureSpec.makeMeasureSpec(this.f2149h, 1073741824);
        if (z || !this.f2148g) {
            i3 = 0;
        }
        if (i3 != 0) {
            this.f2146e.measure(0, mode);
            if (this.f2146e.getMeasuredWidth() > MeasureSpec.getSize(i)) {
                m3695b();
            } else {
                m3696c();
            }
        } else {
            m3696c();
        }
        i3 = getMeasuredWidth();
        super.onMeasure(i, mode);
        int measuredWidth = getMeasuredWidth();
        if (z && i3 != measuredWidth) {
            setTabSelected(this.f2150i);
        }
    }

    private boolean m3694a() {
        return this.f2147f != null && this.f2147f.getParent() == this;
    }

    public void setAllowCollapse(boolean z) {
        this.f2148g = z;
    }

    private void m3695b() {
        if (!m3694a()) {
            if (this.f2147f == null) {
                this.f2147f = m3697d();
            }
            removeView(this.f2146e);
            addView(this.f2147f, new LayoutParams(-2, -1));
            if (this.f2147f.getAdapter() == null) {
                this.f2147f.setAdapter(new C0731a());
            }
            if (this.f2142a != null) {
                removeCallbacks(this.f2142a);
                this.f2142a = null;
            }
            this.f2147f.setSelection(this.f2150i);
        }
    }

    private boolean m3696c() {
        if (m3694a()) {
            removeView(this.f2147f);
            addView(this.f2146e, new LayoutParams(-2, -1));
            setTabSelected(this.f2147f.getSelectedItemPosition());
        }
        return false;
    }

    public void setTabSelected(int i) {
        this.f2150i = i;
        int childCount = this.f2146e.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            boolean z;
            View childAt = this.f2146e.getChildAt(i2);
            if (i2 == i) {
                z = true;
            } else {
                z = false;
            }
            childAt.setSelected(z);
            if (z) {
                m3698a(i);
            }
        }
        if (this.f2147f != null && i >= 0) {
            this.f2147f.setSelection(i);
        }
    }

    public void setContentHeight(int i) {
        this.f2149h = i;
        requestLayout();
    }

    private Spinner m3697d() {
        Spinner c0783w = new C0783w(getContext(), null, C0553a.actionDropDownStyle);
        c0783w.setLayoutParams(new C0691a(-2, -1));
        c0783w.setOnItemSelectedListener(this);
        return c0783w;
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        C0640a a = C0640a.m2982a(getContext());
        setContentHeight(a.m2987e());
        this.f2144c = a.m2989g();
    }

    public void m3698a(int i) {
        final View childAt = this.f2146e.getChildAt(i);
        if (this.f2142a != null) {
            removeCallbacks(this.f2142a);
        }
        this.f2142a = new Runnable(this) {
            final /* synthetic */ ar f2132b;

            public void run() {
                this.f2132b.smoothScrollTo(childAt.getLeft() - ((this.f2132b.getWidth() - childAt.getWidth()) / 2), 0);
                this.f2132b.f2142a = null;
            }
        };
        post(this.f2142a);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f2142a != null) {
            post(this.f2142a);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f2142a != null) {
            removeCallbacks(this.f2142a);
        }
    }

    private C0733c m3692a(C0568c c0568c, boolean z) {
        C0733c c0733c = new C0733c(this, getContext(), c0568c, z);
        if (z) {
            c0733c.setBackgroundDrawable(null);
            c0733c.setLayoutParams(new AbsListView.LayoutParams(-1, this.f2149h));
        } else {
            c0733c.setFocusable(true);
            if (this.f2145d == null) {
                this.f2145d = new C0732b();
            }
            c0733c.setOnClickListener(this.f2145d);
        }
        return c0733c;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        ((C0733c) view).m3690b().m2590d();
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
