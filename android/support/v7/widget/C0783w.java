package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.content.C0126a;
import android.support.v4.view.ad;
import android.support.v4.view.ag;
import android.support.v7.p011a.C0564a.C0553a;
import android.support.v7.p011a.C0564a.C0560h;
import android.support.v7.p011a.C0564a.C0563k;
import android.support.v7.view.C0642d;
import android.support.v7.widget.ak.C0651b;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

public class C0783w extends Spinner implements ad {
    private static final boolean f2348a;
    private static final boolean f2349b;
    private static final int[] f2350c = new int[]{16843505};
    private C0765l f2351d;
    private C0755g f2352e;
    private Context f2353f;
    private C0651b f2354g;
    private SpinnerAdapter f2355h;
    private boolean f2356i;
    private C0782b f2357j;
    private int f2358k;
    private final Rect f2359l;

    private static class C0778a implements ListAdapter, SpinnerAdapter {
        private SpinnerAdapter f2337a;
        private ListAdapter f2338b;

        public C0778a(SpinnerAdapter spinnerAdapter, Theme theme) {
            this.f2337a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f2338b = (ListAdapter) spinnerAdapter;
            }
            if (theme == null) {
                return;
            }
            if (C0783w.f2348a && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                    themedSpinnerAdapter.setDropDownViewTheme(theme);
                }
            } else if (spinnerAdapter instanceof au) {
                au auVar = (au) spinnerAdapter;
                if (auVar.m3727a() == null) {
                    auVar.m3728a(theme);
                }
            }
        }

        public int getCount() {
            return this.f2337a == null ? 0 : this.f2337a.getCount();
        }

        public Object getItem(int i) {
            return this.f2337a == null ? null : this.f2337a.getItem(i);
        }

        public long getItemId(int i) {
            return this.f2337a == null ? -1 : this.f2337a.getItemId(i);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            return this.f2337a == null ? null : this.f2337a.getDropDownView(i, view, viewGroup);
        }

        public boolean hasStableIds() {
            return this.f2337a != null && this.f2337a.hasStableIds();
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.f2337a != null) {
                this.f2337a.registerDataSetObserver(dataSetObserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.f2337a != null) {
                this.f2337a.unregisterDataSetObserver(dataSetObserver);
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f2338b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.f2338b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public int getViewTypeCount() {
            return 1;
        }

        public boolean isEmpty() {
            return getCount() == 0;
        }
    }

    private class C0782b extends ak {
        final /* synthetic */ C0783w f2344a;
        private CharSequence f2345c;
        private ListAdapter f2346d;
        private final Rect f2347e = new Rect();

        class C07802 implements OnGlobalLayoutListener {
            final /* synthetic */ C0782b f2341a;

            C07802(C0782b c0782b) {
                this.f2341a = c0782b;
            }

            public void onGlobalLayout() {
                if (this.f2341a.m3944b(this.f2341a.f2344a)) {
                    this.f2341a.mo679b();
                    super.mo680c();
                    return;
                }
                this.f2341a.m3639i();
            }
        }

        public C0782b(final C0783w c0783w, Context context, AttributeSet attributeSet, int i) {
            this.f2344a = c0783w;
            super(context, attributeSet, i);
            m3621a((View) c0783w);
            m3625a(true);
            m3619a(0);
            m3622a(new OnItemClickListener(this) {
                final /* synthetic */ C0782b f2340b;

                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    this.f2340b.f2344a.setSelection(i);
                    if (this.f2340b.f2344a.getOnItemClickListener() != null) {
                        this.f2340b.f2344a.performItemClick(view, i, this.f2340b.f2346d.getItemId(i));
                    }
                    this.f2340b.m3639i();
                }
            });
        }

        public void mo678a(ListAdapter listAdapter) {
            super.mo678a(listAdapter);
            this.f2346d = listAdapter;
        }

        public CharSequence mo677a() {
            return this.f2345c;
        }

        public void m3947a(CharSequence charSequence) {
            this.f2345c = charSequence;
        }

        void mo679b() {
            int i;
            int i2;
            Drawable d = m3629d();
            if (d != null) {
                d.getPadding(this.f2344a.f2359l);
                i = bb.m3805a(this.f2344a) ? this.f2344a.f2359l.right : -this.f2344a.f2359l.left;
            } else {
                Rect b = this.f2344a.f2359l;
                this.f2344a.f2359l.right = 0;
                b.left = 0;
                i = 0;
            }
            int paddingLeft = this.f2344a.getPaddingLeft();
            int paddingRight = this.f2344a.getPaddingRight();
            int width = this.f2344a.getWidth();
            if (this.f2344a.f2358k == -2) {
                int a = this.f2344a.m3951a((SpinnerAdapter) this.f2346d, m3629d());
                i2 = (this.f2344a.getContext().getResources().getDisplayMetrics().widthPixels - this.f2344a.f2359l.left) - this.f2344a.f2359l.right;
                if (a <= i2) {
                    i2 = a;
                }
                m3634f(Math.max(i2, (width - paddingLeft) - paddingRight));
            } else if (this.f2344a.f2358k == -1) {
                m3634f((width - paddingLeft) - paddingRight);
            } else {
                m3634f(this.f2344a.f2358k);
            }
            if (bb.m3805a(this.f2344a)) {
                i2 = ((width - paddingRight) - m3637h()) + i;
            } else {
                i2 = i + paddingLeft;
            }
            m3626b(i2);
        }

        public void mo680c() {
            boolean k = m3641k();
            mo679b();
            m3636g(2);
            super.mo680c();
            m3643m().setChoiceMode(1);
            m3638h(this.f2344a.getSelectedItemPosition());
            if (!k) {
                ViewTreeObserver viewTreeObserver = this.f2344a.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    final OnGlobalLayoutListener c07802 = new C07802(this);
                    viewTreeObserver.addOnGlobalLayoutListener(c07802);
                    m3624a(new OnDismissListener(this) {
                        final /* synthetic */ C0782b f2343b;

                        public void onDismiss() {
                            ViewTreeObserver viewTreeObserver = this.f2343b.f2344a.getViewTreeObserver();
                            if (viewTreeObserver != null) {
                                viewTreeObserver.removeGlobalOnLayoutListener(c07802);
                            }
                        }
                    });
                }
            }
        }

        private boolean m3944b(View view) {
            return ag.m1822v(view) && view.getGlobalVisibleRect(this.f2347e);
        }
    }

    static {
        boolean z;
        if (VERSION.SDK_INT >= 23) {
            z = true;
        } else {
            z = false;
        }
        f2348a = z;
        if (VERSION.SDK_INT >= 16) {
            z = true;
        } else {
            z = false;
        }
        f2349b = z;
    }

    public C0783w(Context context) {
        this(context, null);
    }

    public C0783w(Context context, int i) {
        this(context, null, C0553a.spinnerStyle, i);
    }

    public C0783w(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0553a.spinnerStyle);
    }

    public C0783w(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public C0783w(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
    }

    public C0783w(Context context, AttributeSet attributeSet, int i, int i2, Theme theme) {
        TypedArray obtainStyledAttributes;
        Throwable e;
        final C0782b c0782b;
        ay a;
        CharSequence[] e2;
        SpinnerAdapter arrayAdapter;
        super(context, attributeSet, i);
        this.f2359l = new Rect();
        ay a2 = ay.m3733a(context, attributeSet, C0563k.Spinner, i, 0);
        this.f2351d = C0765l.m3902a();
        this.f2352e = new C0755g(this, this.f2351d);
        if (theme != null) {
            this.f2353f = new C0642d(context, theme);
        } else {
            int g = a2.m3749g(C0563k.Spinner_popupTheme, 0);
            if (g != 0) {
                this.f2353f = new C0642d(context, g);
            } else {
                this.f2353f = !f2348a ? context : null;
            }
        }
        if (this.f2353f != null) {
            if (i2 == -1) {
                if (VERSION.SDK_INT >= 11) {
                    try {
                        obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2350c, i, 0);
                        try {
                            if (obtainStyledAttributes.hasValue(0)) {
                                i2 = obtainStyledAttributes.getInt(0, 0);
                            }
                            if (obtainStyledAttributes != null) {
                                obtainStyledAttributes.recycle();
                            }
                        } catch (Exception e3) {
                            e = e3;
                            try {
                                Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                                if (obtainStyledAttributes != null) {
                                    obtainStyledAttributes.recycle();
                                }
                                if (i2 == 1) {
                                    c0782b = new C0782b(this, this.f2353f, attributeSet, i);
                                    a = ay.m3733a(this.f2353f, attributeSet, C0563k.Spinner, i, 0);
                                    this.f2358k = a.m3747f(C0563k.Spinner_android_dropDownWidth, -2);
                                    c0782b.m3620a(a.m3736a(C0563k.Spinner_android_popupBackground));
                                    c0782b.m3947a(a2.m3744d(C0563k.Spinner_android_prompt));
                                    a.m3737a();
                                    this.f2357j = c0782b;
                                    this.f2354g = new C0651b(this, this) {
                                        final /* synthetic */ C0783w f2336b;

                                        public ak mo517a() {
                                            return c0782b;
                                        }

                                        public boolean mo518b() {
                                            if (!this.f2336b.f2357j.m3641k()) {
                                                this.f2336b.f2357j.mo680c();
                                            }
                                            return true;
                                        }
                                    };
                                }
                                e2 = a2.m3746e(C0563k.Spinner_android_entries);
                                if (e2 != null) {
                                    arrayAdapter = new ArrayAdapter(context, 17367048, e2);
                                    arrayAdapter.setDropDownViewResource(C0560h.support_simple_spinner_dropdown_item);
                                    setAdapter(arrayAdapter);
                                }
                                a2.m3737a();
                                this.f2356i = true;
                                if (this.f2355h != null) {
                                    setAdapter(this.f2355h);
                                    this.f2355h = null;
                                }
                                this.f2352e.m3878a(attributeSet, i);
                            } catch (Throwable th) {
                                e = th;
                                if (obtainStyledAttributes != null) {
                                    obtainStyledAttributes.recycle();
                                }
                                throw e;
                            }
                        }
                    } catch (Exception e4) {
                        e = e4;
                        obtainStyledAttributes = null;
                        Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                        if (obtainStyledAttributes != null) {
                            obtainStyledAttributes.recycle();
                        }
                        if (i2 == 1) {
                            c0782b = new C0782b(this, this.f2353f, attributeSet, i);
                            a = ay.m3733a(this.f2353f, attributeSet, C0563k.Spinner, i, 0);
                            this.f2358k = a.m3747f(C0563k.Spinner_android_dropDownWidth, -2);
                            c0782b.m3620a(a.m3736a(C0563k.Spinner_android_popupBackground));
                            c0782b.m3947a(a2.m3744d(C0563k.Spinner_android_prompt));
                            a.m3737a();
                            this.f2357j = c0782b;
                            this.f2354g = /* anonymous class already generated */;
                        }
                        e2 = a2.m3746e(C0563k.Spinner_android_entries);
                        if (e2 != null) {
                            arrayAdapter = new ArrayAdapter(context, 17367048, e2);
                            arrayAdapter.setDropDownViewResource(C0560h.support_simple_spinner_dropdown_item);
                            setAdapter(arrayAdapter);
                        }
                        a2.m3737a();
                        this.f2356i = true;
                        if (this.f2355h != null) {
                            setAdapter(this.f2355h);
                            this.f2355h = null;
                        }
                        this.f2352e.m3878a(attributeSet, i);
                    } catch (Throwable th2) {
                        e = th2;
                        obtainStyledAttributes = null;
                        if (obtainStyledAttributes != null) {
                            obtainStyledAttributes.recycle();
                        }
                        throw e;
                    }
                }
                i2 = 1;
            }
            if (i2 == 1) {
                c0782b = new C0782b(this, this.f2353f, attributeSet, i);
                a = ay.m3733a(this.f2353f, attributeSet, C0563k.Spinner, i, 0);
                this.f2358k = a.m3747f(C0563k.Spinner_android_dropDownWidth, -2);
                c0782b.m3620a(a.m3736a(C0563k.Spinner_android_popupBackground));
                c0782b.m3947a(a2.m3744d(C0563k.Spinner_android_prompt));
                a.m3737a();
                this.f2357j = c0782b;
                this.f2354g = /* anonymous class already generated */;
            }
        }
        e2 = a2.m3746e(C0563k.Spinner_android_entries);
        if (e2 != null) {
            arrayAdapter = new ArrayAdapter(context, 17367048, e2);
            arrayAdapter.setDropDownViewResource(C0560h.support_simple_spinner_dropdown_item);
            setAdapter(arrayAdapter);
        }
        a2.m3737a();
        this.f2356i = true;
        if (this.f2355h != null) {
            setAdapter(this.f2355h);
            this.f2355h = null;
        }
        this.f2352e.m3878a(attributeSet, i);
    }

    public Context getPopupContext() {
        if (this.f2357j != null) {
            return this.f2353f;
        }
        if (f2348a) {
            return super.getPopupContext();
        }
        return null;
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        if (this.f2357j != null) {
            this.f2357j.m3620a(drawable);
        } else if (f2349b) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(C0126a.m582a(getPopupContext(), i));
    }

    public Drawable getPopupBackground() {
        if (this.f2357j != null) {
            return this.f2357j.m3629d();
        }
        if (f2349b) {
            return super.getPopupBackground();
        }
        return null;
    }

    public void setDropDownVerticalOffset(int i) {
        if (this.f2357j != null) {
            this.f2357j.m3628c(i);
        } else if (f2349b) {
            super.setDropDownVerticalOffset(i);
        }
    }

    public int getDropDownVerticalOffset() {
        if (this.f2357j != null) {
            return this.f2357j.m3635g();
        }
        if (f2349b) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    public void setDropDownHorizontalOffset(int i) {
        if (this.f2357j != null) {
            this.f2357j.m3626b(i);
        } else if (f2349b) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    public int getDropDownHorizontalOffset() {
        if (this.f2357j != null) {
            return this.f2357j.m3633f();
        }
        if (f2349b) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    public void setDropDownWidth(int i) {
        if (this.f2357j != null) {
            this.f2358k = i;
        } else if (f2349b) {
            super.setDropDownWidth(i);
        }
    }

    public int getDropDownWidth() {
        if (this.f2357j != null) {
            return this.f2358k;
        }
        if (f2349b) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (this.f2356i) {
            super.setAdapter(spinnerAdapter);
            if (this.f2357j != null) {
                this.f2357j.mo678a(new C0778a(spinnerAdapter, (this.f2353f == null ? getContext() : this.f2353f).getTheme()));
                return;
            }
            return;
        }
        this.f2355h = spinnerAdapter;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f2357j != null && this.f2357j.m3641k()) {
            this.f2357j.m3639i();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f2354g == null || !this.f2354g.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f2357j != null && MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), m3951a(getAdapter(), getBackground())), MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    public boolean performClick() {
        if (this.f2357j == null) {
            return super.performClick();
        }
        if (!this.f2357j.m3641k()) {
            this.f2357j.mo680c();
        }
        return true;
    }

    public void setPrompt(CharSequence charSequence) {
        if (this.f2357j != null) {
            this.f2357j.m3947a(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public CharSequence getPrompt() {
        return this.f2357j != null ? this.f2357j.mo677a() : super.getPrompt();
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f2352e != null) {
            this.f2352e.m3874a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f2352e != null) {
            this.f2352e.m3877a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f2352e != null) {
            this.f2352e.m3875a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f2352e != null ? this.f2352e.m3873a() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f2352e != null) {
            this.f2352e.m3876a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f2352e != null ? this.f2352e.m3879b() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2352e != null) {
            this.f2352e.m3881c();
        }
    }

    private int m3951a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        int max2 = Math.max(0, max - (15 - (min - max)));
        View view = null;
        int i = 0;
        max = 0;
        while (max2 < min) {
            View view2;
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != max) {
                view2 = null;
            } else {
                itemViewType = max;
                view2 = view;
            }
            view = spinnerAdapter.getView(max2, view2, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i = Math.max(i, view.getMeasuredWidth());
            max2++;
            max = itemViewType;
        }
        if (drawable == null) {
            return i;
        }
        drawable.getPadding(this.f2359l);
        return (this.f2359l.left + this.f2359l.right) + i;
    }
}
