package com.bigroad.ttb.android.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.C0331c;
import android.support.v4.view.ViewPager.C0338i;
import android.support.v4.view.ab;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import com.bigroad.ttb.android.C2476z.C2475a;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.widget.p043a.C2443c;
import java.util.Arrays;
import java.util.Collection;

public class LauncherItemPagerLayout extends RelativeLayout {
    public int f8577a = -1;
    public int f8578b = 0;
    public int f8579c = 0;
    public int f8580d = 0;
    private ViewPager f8581e = null;
    private View f8582f = null;
    private View f8583g = null;
    private final SparseArray<C2443c> f8584h = new SparseArray();
    private final C0338i f8585i = new C24301(this);
    private final ab f8586j = new C24312(this);

    class C24301 extends C0338i {
        final /* synthetic */ LauncherItemPagerLayout f8575a;

        C24301(LauncherItemPagerLayout launcherItemPagerLayout) {
            this.f8575a = launcherItemPagerLayout;
        }

        public void mo190a(int i) {
            boolean z;
            boolean z2 = true;
            if (this.f8575a.f8586j.mo1334a() <= 0 || i <= 0) {
                z = false;
            } else {
                z = true;
            }
            if (this.f8575a.f8586j.mo1334a() <= 0 || i >= this.f8575a.f8586j.mo1334a() - 1) {
                z2 = false;
            }
            this.f8575a.m11986a(z, z2);
        }
    }

    class C24312 extends ab {
        final /* synthetic */ LauncherItemPagerLayout f8576a;

        C24312(LauncherItemPagerLayout launcherItemPagerLayout) {
            this.f8576a = launcherItemPagerLayout;
        }

        public int mo1334a() {
            return this.f8576a.f8580d;
        }

        private void m11976a(int i, TableLayout tableLayout) {
            int i2;
            int size = this.f8576a.f8584h.size();
            int[] iArr = new int[size];
            for (i2 = 0; i2 < size; i2++) {
                iArr[i2] = this.f8576a.f8584h.keyAt(i2);
            }
            Arrays.sort(iArr);
            i2 = (this.f8576a.f8578b * i) * this.f8576a.f8579c;
            int i3 = 0;
            while (i3 < this.f8576a.f8578b && i2 < size) {
                LayoutParams layoutParams;
                View tableRow = new TableRow(this.f8576a.getContext());
                int i4 = i2;
                for (int i5 = 0; i5 < this.f8576a.f8579c && i4 < size; i5++) {
                    View c = ((C2443c) this.f8576a.f8584h.get(iArr[i4])).mo1343c();
                    ViewGroup viewGroup = (ViewGroup) c.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(c);
                    }
                    layoutParams = new TableRow.LayoutParams(i5);
                    layoutParams.width = -2;
                    layoutParams.height = -1;
                    tableRow.addView(c, layoutParams);
                    i4++;
                }
                layoutParams = new TableLayout.LayoutParams(-1, -2);
                layoutParams.weight = 1.0f;
                layoutParams.gravity = 17;
                tableLayout.addView(tableRow, layoutParams);
                i3++;
                i2 = i4;
            }
        }

        public Object mo1336a(ViewGroup viewGroup, int i) {
            TableLayout tableLayout = new TableLayout(this.f8576a.getContext());
            LayoutParams c0331c = new C0331c();
            c0331c.width = -1;
            c0331c.height = -1;
            tableLayout.setLayoutParams(c0331c);
            tableLayout.setStretchAllColumns(true);
            tableLayout.setShrinkAllColumns(true);
            m11976a(i, tableLayout);
            viewGroup.addView(tableLayout);
            return tableLayout;
        }

        public void mo1337a(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        public boolean mo1338a(View view, Object obj) {
            return view == obj;
        }

        public int mo1335a(Object obj) {
            return -2;
        }
    }

    public LauncherItemPagerLayout(Context context) {
        super(context);
    }

    public LauncherItemPagerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2475a.LauncherItemPagerLayout);
        this.f8577a = obtainStyledAttributes.getInteger(0, -1);
        obtainStyledAttributes.recycle();
    }

    protected void onMeasure(int i, int i2) {
        boolean z = false;
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (mode == 0) {
            size = Integer.MAX_VALUE;
        }
        int a = C2463l.m12112a((View) this);
        mode = C2463l.m12114b(this);
        int size3 = this.f8584h.size();
        int i3 = size / mode;
        if (size3 <= 0 || i3 <= 0) {
            size = 0;
        } else {
            size = ((size3 - 1) / i3) + 1;
        }
        if (mode2 != 0) {
            size = Math.min(size, size2 / a);
        }
        if (this.f8577a > 0) {
            mode = Math.min(size, this.f8577a);
        } else {
            mode = size;
        }
        if (mode2 != 1073741824) {
            size2 = mode * a;
        }
        if (i3 == 0 || mode == 0) {
            size = 0;
        } else {
            size = size3 / (mode * i3);
            if (size3 % (mode * i3) != 0) {
                size++;
            }
        }
        if (!(size == this.f8580d && mode == this.f8578b && i3 == this.f8579c)) {
            this.f8580d = size;
            this.f8578b = mode;
            this.f8579c = i3;
            if (!(this.f8581e == null || this.f8586j == null)) {
                mode = this.f8581e.getCurrentItem();
                mode2 = this.f8586j.mo1334a();
                boolean z2 = mode2 > 0 && mode > 0;
                if (mode2 > 0 && mode < mode2 - 1) {
                    z = true;
                }
                m11986a(z2, z);
            }
            if (this.f8586j != null) {
                this.f8586j.m1615c();
            }
        }
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    public void m11985a(Activity activity) {
        int i = (int) (2.0f * getResources().getDisplayMetrics().density);
        this.f8581e = new C2470t(activity);
        this.f8581e.setAdapter(this.f8586j);
        this.f8581e.setOnPageChangeListener(this.f8585i);
        this.f8581e.setOffscreenPageLimit(2);
        View imageView = new ImageView(activity);
        imageView.setImageResource(R.drawable.launcher_arrow_left);
        imageView.setPadding(i, 0, i, 0);
        this.f8582f = imageView;
        View imageView2 = new ImageView(activity);
        imageView2.setImageResource(R.drawable.launcher_arrow_right);
        imageView2.setPadding(i, 0, i, 0);
        this.f8583g = imageView2;
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(11);
        layoutParams2.addRule(15);
        addView(this.f8581e);
        addView(imageView, layoutParams);
        addView(imageView2, layoutParams2);
    }

    public void m11986a(boolean z, boolean z2) {
        int i = 0;
        if (this.f8582f != null) {
            this.f8582f.setVisibility(z ? 0 : 4);
        }
        if (this.f8583g != null) {
            View view = this.f8583g;
            if (!z2) {
                i = 4;
            }
            view.setVisibility(i);
        }
    }

    public void setLaunchers(Collection<C2443c> collection) {
        this.f8584h.clear();
        for (C2443c c2443c : collection) {
            this.f8584h.put(c2443c.mo1342b(), c2443c);
        }
        this.f8586j.m1615c();
    }

    public void m11984a(int i) {
        C2443c c2443c = (C2443c) this.f8584h.get(i);
        if (c2443c != null) {
            c2443c.mo1341a();
        }
    }
}
