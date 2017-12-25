package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.C0438e;
import android.support.v4.view.C0459n;
import android.support.v4.view.C0466p;
import android.support.v4.view.C0474s;
import android.support.v4.view.ag;
import android.support.v7.app.C0569a.C0566a;
import android.support.v7.p011a.C0564a.C0553a;
import android.support.v7.p011a.C0564a.C0563k;
import android.support.v7.view.C0641c;
import android.support.v7.view.C0648g;
import android.support.v7.view.menu.C0660l;
import android.support.v7.view.menu.C0660l.C0607a;
import android.support.v7.view.menu.C0666f;
import android.support.v7.view.menu.C0666f.C0591a;
import android.support.v7.view.menu.C0669h;
import android.support.v7.view.menu.C0681p;
import android.support.v7.widget.ActionMenuView.C0694e;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup {
    private boolean f1978A;
    private final ArrayList<View> f1979B;
    private final ArrayList<View> f1980C;
    private final int[] f1981D;
    private C0710c f1982E;
    private final C0694e f1983F;
    private az f1984G;
    private C0747d f1985H;
    private C0708a f1986I;
    private C0607a f1987J;
    private C0591a f1988K;
    private boolean f1989L;
    private final Runnable f1990M;
    private final C0765l f1991N;
    View f1992a;
    private ActionMenuView f1993b;
    private TextView f1994c;
    private TextView f1995d;
    private ImageButton f1996e;
    private ImageView f1997f;
    private Drawable f1998g;
    private CharSequence f1999h;
    private ImageButton f2000i;
    private Context f2001j;
    private int f2002k;
    private int f2003l;
    private int f2004m;
    private int f2005n;
    private int f2006o;
    private int f2007p;
    private int f2008q;
    private int f2009r;
    private int f2010s;
    private final aq f2011t;
    private int f2012u;
    private CharSequence f2013v;
    private CharSequence f2014w;
    private int f2015x;
    private int f2016y;
    private boolean f2017z;

    class C07041 implements C0694e {
        final /* synthetic */ Toolbar f1969a;

        C07041(Toolbar toolbar) {
            this.f1969a = toolbar;
        }

        public boolean mo607a(MenuItem menuItem) {
            if (this.f1969a.f1982E != null) {
                return this.f1969a.f1982E.m3464a(menuItem);
            }
            return false;
        }
    }

    class C07052 implements Runnable {
        final /* synthetic */ Toolbar f1970a;

        C07052(Toolbar toolbar) {
            this.f1970a = toolbar;
        }

        public void run() {
            this.f1970a.m3500d();
        }
    }

    class C07063 implements OnClickListener {
        final /* synthetic */ Toolbar f1971a;

        C07063(Toolbar toolbar) {
            this.f1971a = toolbar;
        }

        public void onClick(View view) {
            this.f1971a.m3504h();
        }
    }

    public static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C07071();
        int f1972a;
        boolean f1973b;

        static class C07071 implements Creator<SavedState> {
            C07071() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m3454a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m3455a(i);
            }

            public SavedState m3454a(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] m3455a(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f1972a = parcel.readInt();
            this.f1973b = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1972a);
            parcel.writeInt(this.f1973b ? 1 : 0);
        }
    }

    private class C0708a implements C0660l {
        C0666f f1974a;
        C0669h f1975b;
        final /* synthetic */ Toolbar f1976c;

        private C0708a(Toolbar toolbar) {
            this.f1976c = toolbar;
        }

        public void mo541a(Context context, C0666f c0666f) {
            if (!(this.f1974a == null || this.f1975b == null)) {
                this.f1974a.mo568d(this.f1975b);
            }
            this.f1974a = c0666f;
        }

        public void mo545b(boolean z) {
            Object obj = null;
            if (this.f1975b != null) {
                if (this.f1974a != null) {
                    int size = this.f1974a.size();
                    for (int i = 0; i < size; i++) {
                        if (this.f1974a.getItem(i) == this.f1975b) {
                            obj = 1;
                            break;
                        }
                    }
                }
                if (obj == null) {
                    mo547b(this.f1974a, this.f1975b);
                }
            }
        }

        public boolean mo544a(C0681p c0681p) {
            return false;
        }

        public void mo542a(C0666f c0666f, boolean z) {
        }

        public boolean mo546b() {
            return false;
        }

        public boolean mo543a(C0666f c0666f, C0669h c0669h) {
            this.f1976c.m3487p();
            if (this.f1976c.f2000i.getParent() != this.f1976c) {
                this.f1976c.addView(this.f1976c.f2000i);
            }
            this.f1976c.f1992a = c0669h.getActionView();
            this.f1975b = c0669h;
            if (this.f1976c.f1992a.getParent() != this.f1976c) {
                LayoutParams i = this.f1976c.m3505i();
                i.a = 8388611 | (this.f1976c.f2005n & 112);
                i.f1977b = 2;
                this.f1976c.f1992a.setLayoutParams(i);
                this.f1976c.addView(this.f1976c.f1992a);
            }
            this.f1976c.m3506j();
            this.f1976c.requestLayout();
            c0669h.m3211e(true);
            if (this.f1976c.f1992a instanceof C0641c) {
                ((C0641c) this.f1976c.f1992a).mo553a();
            }
            return true;
        }

        public boolean mo547b(C0666f c0666f, C0669h c0669h) {
            if (this.f1976c.f1992a instanceof C0641c) {
                ((C0641c) this.f1976c.f1992a).mo554b();
            }
            this.f1976c.removeView(this.f1976c.f1992a);
            this.f1976c.removeView(this.f1976c.f2000i);
            this.f1976c.f1992a = null;
            this.f1976c.m3507k();
            this.f1975b = null;
            this.f1976c.requestLayout();
            c0669h.m3211e(false);
            return true;
        }
    }

    public static class C0709b extends C0566a {
        int f1977b;

        public C0709b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1977b = 0;
        }

        public C0709b(int i, int i2) {
            super(i, i2);
            this.f1977b = 0;
            this.a = 8388627;
        }

        public C0709b(C0709b c0709b) {
            super((C0566a) c0709b);
            this.f1977b = 0;
            this.f1977b = c0709b.f1977b;
        }

        public C0709b(C0566a c0566a) {
            super(c0566a);
            this.f1977b = 0;
        }

        public C0709b(MarginLayoutParams marginLayoutParams) {
            super((LayoutParams) marginLayoutParams);
            this.f1977b = 0;
            m3463a(marginLayoutParams);
        }

        public C0709b(LayoutParams layoutParams) {
            super(layoutParams);
            this.f1977b = 0;
        }

        void m3463a(MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    public interface C0710c {
        boolean m3464a(MenuItem menuItem);
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m3505i();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m3490a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return m3491a(layoutParams);
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0553a.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2011t = new aq();
        this.f2012u = 8388627;
        this.f1979B = new ArrayList();
        this.f1980C = new ArrayList();
        this.f1981D = new int[2];
        this.f1983F = new C07041(this);
        this.f1990M = new C07052(this);
        ay a = ay.m3733a(getContext(), attributeSet, C0563k.Toolbar, i, 0);
        this.f2003l = a.m3749g(C0563k.Toolbar_titleTextAppearance, 0);
        this.f2004m = a.m3749g(C0563k.Toolbar_subtitleTextAppearance, 0);
        this.f2012u = a.m3741c(C0563k.Toolbar_android_gravity, this.f2012u);
        this.f2005n = 48;
        int d = a.m3743d(C0563k.Toolbar_titleMargins, 0);
        this.f2010s = d;
        this.f2009r = d;
        this.f2008q = d;
        this.f2007p = d;
        d = a.m3743d(C0563k.Toolbar_titleMarginStart, -1);
        if (d >= 0) {
            this.f2007p = d;
        }
        d = a.m3743d(C0563k.Toolbar_titleMarginEnd, -1);
        if (d >= 0) {
            this.f2008q = d;
        }
        d = a.m3743d(C0563k.Toolbar_titleMarginTop, -1);
        if (d >= 0) {
            this.f2009r = d;
        }
        d = a.m3743d(C0563k.Toolbar_titleMarginBottom, -1);
        if (d >= 0) {
            this.f2010s = d;
        }
        this.f2006o = a.m3745e(C0563k.Toolbar_maxButtonHeight, -1);
        d = a.m3743d(C0563k.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int d2 = a.m3743d(C0563k.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        this.f2011t.m3685b(a.m3745e(C0563k.Toolbar_contentInsetLeft, 0), a.m3745e(C0563k.Toolbar_contentInsetRight, 0));
        if (!(d == Integer.MIN_VALUE && d2 == Integer.MIN_VALUE)) {
            this.f2011t.m3682a(d, d2);
        }
        this.f1998g = a.m3736a(C0563k.Toolbar_collapseIcon);
        this.f1999h = a.m3742c(C0563k.Toolbar_collapseContentDescription);
        CharSequence c = a.m3742c(C0563k.Toolbar_title);
        if (!TextUtils.isEmpty(c)) {
            setTitle(c);
        }
        c = a.m3742c(C0563k.Toolbar_subtitle);
        if (!TextUtils.isEmpty(c)) {
            setSubtitle(c);
        }
        this.f2001j = getContext();
        setPopupTheme(a.m3749g(C0563k.Toolbar_popupTheme, 0));
        Drawable a2 = a.m3736a(C0563k.Toolbar_navigationIcon);
        if (a2 != null) {
            setNavigationIcon(a2);
        }
        c = a.m3742c(C0563k.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(c)) {
            setNavigationContentDescription(c);
        }
        a2 = a.m3736a(C0563k.Toolbar_logo);
        if (a2 != null) {
            setLogo(a2);
        }
        c = a.m3742c(C0563k.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(c)) {
            setLogoDescription(c);
        }
        if (a.m3748f(C0563k.Toolbar_titleTextColor)) {
            setTitleTextColor(a.m3739b(C0563k.Toolbar_titleTextColor, -1));
        }
        if (a.m3748f(C0563k.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(a.m3739b(C0563k.Toolbar_subtitleTextColor, -1));
        }
        a.m3737a();
        this.f1991N = C0765l.m3902a();
    }

    public void setPopupTheme(int i) {
        if (this.f2002k != i) {
            this.f2002k = i;
            if (i == 0) {
                this.f2001j = getContext();
            } else {
                this.f2001j = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public int getPopupTheme() {
        return this.f2002k;
    }

    public void onRtlPropertiesChanged(int i) {
        boolean z = true;
        if (VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        aq aqVar = this.f2011t;
        if (i != 1) {
            z = false;
        }
        aqVar.m3683a(z);
    }

    public void setLogo(int i) {
        setLogo(this.f1991N.m3925a(getContext(), i));
    }

    public boolean m3496a() {
        return getVisibility() == 0 && this.f1993b != null && this.f1993b.m3360a();
    }

    public boolean m3498b() {
        return this.f1993b != null && this.f1993b.m3370g();
    }

    public boolean m3499c() {
        return this.f1993b != null && this.f1993b.m3371h();
    }

    public boolean m3500d() {
        return this.f1993b != null && this.f1993b.m3368e();
    }

    public boolean m3501e() {
        return this.f1993b != null && this.f1993b.m3369f();
    }

    public void m3494a(C0666f c0666f, C0747d c0747d) {
        if (c0666f != null || this.f1993b != null) {
            m3485n();
            C0666f d = this.f1993b.m3367d();
            if (d != c0666f) {
                if (d != null) {
                    d.m3166b(this.f1985H);
                    d.m3166b(this.f1986I);
                }
                if (this.f1986I == null) {
                    this.f1986I = new C0708a();
                }
                c0747d.m3843d(true);
                if (c0666f != null) {
                    c0666f.m3156a((C0660l) c0747d, this.f2001j);
                    c0666f.m3156a(this.f1986I, this.f2001j);
                } else {
                    c0747d.mo541a(this.f2001j, null);
                    this.f1986I.mo541a(this.f2001j, null);
                    c0747d.mo545b(true);
                    this.f1986I.mo545b(true);
                }
                this.f1993b.setPopupTheme(this.f2002k);
                this.f1993b.setPresenter(c0747d);
                this.f1985H = c0747d;
            }
        }
    }

    public void m3502f() {
        if (this.f1993b != null) {
            this.f1993b.m3372i();
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            m3483l();
            if (!m3482d(this.f1997f)) {
                m3472a(this.f1997f, true);
            }
        } else if (this.f1997f != null && m3482d(this.f1997f)) {
            removeView(this.f1997f);
            this.f1980C.remove(this.f1997f);
        }
        if (this.f1997f != null) {
            this.f1997f.setImageDrawable(drawable);
        }
    }

    public Drawable getLogo() {
        return this.f1997f != null ? this.f1997f.getDrawable() : null;
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m3483l();
        }
        if (this.f1997f != null) {
            this.f1997f.setContentDescription(charSequence);
        }
    }

    public CharSequence getLogoDescription() {
        return this.f1997f != null ? this.f1997f.getContentDescription() : null;
    }

    private void m3483l() {
        if (this.f1997f == null) {
            this.f1997f = new ImageView(getContext());
        }
    }

    public boolean m3503g() {
        return (this.f1986I == null || this.f1986I.f1975b == null) ? false : true;
    }

    public void m3504h() {
        C0669h c0669h = this.f1986I == null ? null : this.f1986I.f1975b;
        if (c0669h != null) {
            c0669h.collapseActionView();
        }
    }

    public CharSequence getTitle() {
        return this.f2013v;
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f1994c == null) {
                Context context = getContext();
                this.f1994c = new TextView(context);
                this.f1994c.setSingleLine();
                this.f1994c.setEllipsize(TruncateAt.END);
                if (this.f2003l != 0) {
                    this.f1994c.setTextAppearance(context, this.f2003l);
                }
                if (this.f2015x != 0) {
                    this.f1994c.setTextColor(this.f2015x);
                }
            }
            if (!m3482d(this.f1994c)) {
                m3472a(this.f1994c, true);
            }
        } else if (this.f1994c != null && m3482d(this.f1994c)) {
            removeView(this.f1994c);
            this.f1980C.remove(this.f1994c);
        }
        if (this.f1994c != null) {
            this.f1994c.setText(charSequence);
        }
        this.f2013v = charSequence;
    }

    public CharSequence getSubtitle() {
        return this.f2014w;
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f1995d == null) {
                Context context = getContext();
                this.f1995d = new TextView(context);
                this.f1995d.setSingleLine();
                this.f1995d.setEllipsize(TruncateAt.END);
                if (this.f2004m != 0) {
                    this.f1995d.setTextAppearance(context, this.f2004m);
                }
                if (this.f2016y != 0) {
                    this.f1995d.setTextColor(this.f2016y);
                }
            }
            if (!m3482d(this.f1995d)) {
                m3472a(this.f1995d, true);
            }
        } else if (this.f1995d != null && m3482d(this.f1995d)) {
            removeView(this.f1995d);
            this.f1980C.remove(this.f1995d);
        }
        if (this.f1995d != null) {
            this.f1995d.setText(charSequence);
        }
        this.f2014w = charSequence;
    }

    public void m3493a(Context context, int i) {
        this.f2003l = i;
        if (this.f1994c != null) {
            this.f1994c.setTextAppearance(context, i);
        }
    }

    public void m3497b(Context context, int i) {
        this.f2004m = i;
        if (this.f1995d != null) {
            this.f1995d.setTextAppearance(context, i);
        }
    }

    public void setTitleTextColor(int i) {
        this.f2015x = i;
        if (this.f1994c != null) {
            this.f1994c.setTextColor(i);
        }
    }

    public void setSubtitleTextColor(int i) {
        this.f2016y = i;
        if (this.f1995d != null) {
            this.f1995d.setTextColor(i);
        }
    }

    public CharSequence getNavigationContentDescription() {
        return this.f1996e != null ? this.f1996e.getContentDescription() : null;
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m3486o();
        }
        if (this.f1996e != null) {
            this.f1996e.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(this.f1991N.m3925a(getContext(), i));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            m3486o();
            if (!m3482d(this.f1996e)) {
                m3472a(this.f1996e, true);
            }
        } else if (this.f1996e != null && m3482d(this.f1996e)) {
            removeView(this.f1996e);
            this.f1980C.remove(this.f1996e);
        }
        if (this.f1996e != null) {
            this.f1996e.setImageDrawable(drawable);
        }
    }

    public Drawable getNavigationIcon() {
        return this.f1996e != null ? this.f1996e.getDrawable() : null;
    }

    public void setNavigationOnClickListener(OnClickListener onClickListener) {
        m3486o();
        this.f1996e.setOnClickListener(onClickListener);
    }

    public Menu getMenu() {
        m3484m();
        return this.f1993b.getMenu();
    }

    public void setOverflowIcon(Drawable drawable) {
        m3484m();
        this.f1993b.setOverflowIcon(drawable);
    }

    public Drawable getOverflowIcon() {
        m3484m();
        return this.f1993b.getOverflowIcon();
    }

    private void m3484m() {
        m3485n();
        if (this.f1993b.m3367d() == null) {
            C0666f c0666f = (C0666f) this.f1993b.getMenu();
            if (this.f1986I == null) {
                this.f1986I = new C0708a();
            }
            this.f1993b.setExpandedActionViewsExclusive(true);
            c0666f.m3156a(this.f1986I, this.f2001j);
        }
    }

    private void m3485n() {
        if (this.f1993b == null) {
            this.f1993b = new ActionMenuView(getContext());
            this.f1993b.setPopupTheme(this.f2002k);
            this.f1993b.setOnMenuItemClickListener(this.f1983F);
            this.f1993b.m3359a(this.f1987J, this.f1988K);
            LayoutParams i = m3505i();
            i.a = 8388613 | (this.f2005n & 112);
            this.f1993b.setLayoutParams(i);
            m3472a(this.f1993b, false);
        }
    }

    private MenuInflater getMenuInflater() {
        return new C0648g(getContext());
    }

    public void setOnMenuItemClickListener(C0710c c0710c) {
        this.f1982E = c0710c;
    }

    public void m3492a(int i, int i2) {
        this.f2011t.m3682a(i, i2);
    }

    public int getContentInsetStart() {
        return this.f2011t.m3686c();
    }

    public int getContentInsetEnd() {
        return this.f2011t.m3687d();
    }

    public int getContentInsetLeft() {
        return this.f2011t.m3681a();
    }

    public int getContentInsetRight() {
        return this.f2011t.m3684b();
    }

    private void m3486o() {
        if (this.f1996e == null) {
            this.f1996e = new ImageButton(getContext(), null, C0553a.toolbarNavigationButtonStyle);
            LayoutParams i = m3505i();
            i.a = 8388611 | (this.f2005n & 112);
            this.f1996e.setLayoutParams(i);
        }
    }

    private void m3487p() {
        if (this.f2000i == null) {
            this.f2000i = new ImageButton(getContext(), null, C0553a.toolbarNavigationButtonStyle);
            this.f2000i.setImageDrawable(this.f1998g);
            this.f2000i.setContentDescription(this.f1999h);
            LayoutParams i = m3505i();
            i.a = 8388611 | (this.f2005n & 112);
            i.f1977b = 2;
            this.f2000i.setLayoutParams(i);
            this.f2000i.setOnClickListener(new C07063(this));
        }
    }

    private void m3472a(View view, boolean z) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = m3505i();
        } else if (checkLayoutParams(layoutParams)) {
            C0709b c0709b = (C0709b) layoutParams;
        } else {
            layoutParams = m3491a(layoutParams);
        }
        layoutParams.f1977b = 1;
        if (!z || this.f1992a == null) {
            addView(view, layoutParams);
            return;
        }
        view.setLayoutParams(layoutParams);
        this.f1980C.add(view);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        if (!(this.f1986I == null || this.f1986I.f1975b == null)) {
            savedState.f1972a = this.f1986I.f1975b.getItemId();
        }
        savedState.f1973b = m3498b();
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            Menu d = this.f1993b != null ? this.f1993b.m3367d() : null;
            if (!(savedState.f1972a == 0 || this.f1986I == null || d == null)) {
                MenuItem findItem = d.findItem(savedState.f1972a);
                if (findItem != null) {
                    C0466p.m2112b(findItem);
                }
            }
            if (savedState.f1973b) {
                m3488q();
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    private void m3488q() {
        removeCallbacks(this.f1990M);
        post(this.f1990M);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f1990M);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = C0474s.m2141a(motionEvent);
        if (a == 0) {
            this.f2017z = false;
        }
        if (!this.f2017z) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (a == 0 && !onTouchEvent) {
                this.f2017z = true;
            }
        }
        if (a == 1 || a == 3) {
            this.f2017z = false;
        }
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int a = C0474s.m2141a(motionEvent);
        if (a == 9) {
            this.f1978A = false;
        }
        if (!this.f1978A) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (a == 9 && !onHoverEvent) {
                this.f1978A = true;
            }
        }
        if (a == 10 || a == 3) {
            this.f1978A = false;
        }
        return true;
    }

    private void m3471a(View view, int i, int i2, int i3, int i4, int i5) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height);
        int mode = MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private int m3467a(View view, int i, int i2, int i3, int i4, int[] iArr) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + max) + i2, marginLayoutParams.width), getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private boolean m3489r() {
        if (!this.f1989L) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (m3474a(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int max;
        int i5 = 0;
        int i6 = 0;
        int[] iArr = this.f1981D;
        if (bb.m3805a(this)) {
            i3 = 0;
            i4 = 1;
        } else {
            i3 = 1;
            i4 = 0;
        }
        int i7 = 0;
        if (m3474a(this.f1996e)) {
            m3471a(this.f1996e, i, 0, i2, 0, this.f2006o);
            i7 = this.f1996e.getMeasuredWidth() + m3476b(this.f1996e);
            max = Math.max(0, this.f1996e.getMeasuredHeight() + m3479c(this.f1996e));
            i6 = bb.m3803a(0, ag.m1807g(this.f1996e));
            i5 = max;
        }
        if (m3474a(this.f2000i)) {
            m3471a(this.f2000i, i, 0, i2, 0, this.f2006o);
            i7 = this.f2000i.getMeasuredWidth() + m3476b(this.f2000i);
            i5 = Math.max(i5, this.f2000i.getMeasuredHeight() + m3479c(this.f2000i));
            i6 = bb.m3803a(i6, ag.m1807g(this.f2000i));
        }
        int contentInsetStart = getContentInsetStart();
        int max2 = 0 + Math.max(contentInsetStart, i7);
        iArr[i4] = Math.max(0, contentInsetStart - i7);
        i7 = 0;
        if (m3474a(this.f1993b)) {
            m3471a(this.f1993b, i, max2, i2, 0, this.f2006o);
            i7 = this.f1993b.getMeasuredWidth() + m3476b(this.f1993b);
            i5 = Math.max(i5, this.f1993b.getMeasuredHeight() + m3479c(this.f1993b));
            i6 = bb.m3803a(i6, ag.m1807g(this.f1993b));
        }
        contentInsetStart = getContentInsetEnd();
        max2 += Math.max(contentInsetStart, i7);
        iArr[i3] = Math.max(0, contentInsetStart - i7);
        if (m3474a(this.f1992a)) {
            max2 += m3467a(this.f1992a, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.f1992a.getMeasuredHeight() + m3479c(this.f1992a));
            i6 = bb.m3803a(i6, ag.m1807g(this.f1992a));
        }
        if (m3474a(this.f1997f)) {
            max2 += m3467a(this.f1997f, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.f1997f.getMeasuredHeight() + m3479c(this.f1997f));
            i6 = bb.m3803a(i6, ag.m1807g(this.f1997f));
        }
        i4 = getChildCount();
        i3 = 0;
        int i8 = i5;
        i5 = i6;
        while (i3 < i4) {
            View childAt = getChildAt(i3);
            if (((C0709b) childAt.getLayoutParams()).f1977b != 0) {
                i7 = i5;
                contentInsetStart = i8;
            } else if (m3474a(childAt)) {
                max2 += m3467a(childAt, i, max2, i2, 0, iArr);
                max = Math.max(i8, childAt.getMeasuredHeight() + m3479c(childAt));
                i7 = bb.m3803a(i5, ag.m1807g(childAt));
                contentInsetStart = max;
            } else {
                i7 = i5;
                contentInsetStart = i8;
            }
            i3++;
            i5 = i7;
            i8 = contentInsetStart;
        }
        contentInsetStart = 0;
        i7 = 0;
        i6 = this.f2009r + this.f2010s;
        max = this.f2007p + this.f2008q;
        if (m3474a(this.f1994c)) {
            m3467a(this.f1994c, i, max2 + max, i2, i6, iArr);
            contentInsetStart = m3476b(this.f1994c) + this.f1994c.getMeasuredWidth();
            i7 = this.f1994c.getMeasuredHeight() + m3479c(this.f1994c);
            i5 = bb.m3803a(i5, ag.m1807g(this.f1994c));
        }
        if (m3474a(this.f1995d)) {
            contentInsetStart = Math.max(contentInsetStart, m3467a(this.f1995d, i, max2 + max, i2, i6 + i7, iArr));
            i7 += this.f1995d.getMeasuredHeight() + m3479c(this.f1995d);
            i5 = bb.m3803a(i5, ag.m1807g(this.f1995d));
        }
        contentInsetStart += max2;
        i7 = Math.max(i8, i7) + (getPaddingTop() + getPaddingBottom());
        contentInsetStart = ag.m1777a(Math.max(contentInsetStart + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, -16777216 & i5);
        i7 = ag.m1777a(Math.max(i7, getSuggestedMinimumHeight()), i2, i5 << 16);
        if (m3489r()) {
            i7 = 0;
        }
        setMeasuredDimension(contentInsetStart, i7);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Object obj;
        int i5;
        int i6;
        int i7;
        int measuredHeight;
        int measuredWidth;
        if (ag.m1803e(this) == 1) {
            obj = 1;
        } else {
            obj = null;
        }
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i8 = width - paddingRight;
        int[] iArr = this.f1981D;
        iArr[1] = 0;
        iArr[0] = 0;
        int i9 = ag.m1809i(this);
        if (!m3474a(this.f1996e)) {
            i5 = paddingLeft;
        } else if (obj != null) {
            i8 = m3477b(this.f1996e, i8, iArr, i9);
            i5 = paddingLeft;
        } else {
            i5 = m3468a(this.f1996e, paddingLeft, iArr, i9);
        }
        if (m3474a(this.f2000i)) {
            if (obj != null) {
                i8 = m3477b(this.f2000i, i8, iArr, i9);
            } else {
                i5 = m3468a(this.f2000i, i5, iArr, i9);
            }
        }
        if (m3474a(this.f1993b)) {
            if (obj != null) {
                i5 = m3468a(this.f1993b, i5, iArr, i9);
            } else {
                i8 = m3477b(this.f1993b, i8, iArr, i9);
            }
        }
        iArr[0] = Math.max(0, getContentInsetLeft() - i5);
        iArr[1] = Math.max(0, getContentInsetRight() - ((width - paddingRight) - i8));
        i5 = Math.max(i5, getContentInsetLeft());
        i8 = Math.min(i8, (width - paddingRight) - getContentInsetRight());
        if (m3474a(this.f1992a)) {
            if (obj != null) {
                i8 = m3477b(this.f1992a, i8, iArr, i9);
            } else {
                i5 = m3468a(this.f1992a, i5, iArr, i9);
            }
        }
        if (!m3474a(this.f1997f)) {
            i6 = i8;
            i7 = i5;
        } else if (obj != null) {
            i6 = m3477b(this.f1997f, i8, iArr, i9);
            i7 = i5;
        } else {
            i6 = i8;
            i7 = m3468a(this.f1997f, i5, iArr, i9);
        }
        boolean a = m3474a(this.f1994c);
        boolean a2 = m3474a(this.f1995d);
        i5 = 0;
        if (a) {
            C0709b c0709b = (C0709b) this.f1994c.getLayoutParams();
            i5 = 0 + (c0709b.bottomMargin + (c0709b.topMargin + this.f1994c.getMeasuredHeight()));
        }
        if (a2) {
            c0709b = (C0709b) this.f1995d.getLayoutParams();
            measuredHeight = (c0709b.bottomMargin + (c0709b.topMargin + this.f1995d.getMeasuredHeight())) + i5;
        } else {
            measuredHeight = i5;
        }
        if (a || a2) {
            int paddingTop2;
            c0709b = (C0709b) (a ? this.f1994c : this.f1995d).getLayoutParams();
            C0709b c0709b2 = (C0709b) (a2 ? this.f1995d : this.f1994c).getLayoutParams();
            Object obj2 = ((!a || this.f1994c.getMeasuredWidth() <= 0) && (!a2 || this.f1995d.getMeasuredWidth() <= 0)) ? null : 1;
            switch (this.f2012u & 112) {
                case 48:
                    paddingTop2 = (c0709b.topMargin + getPaddingTop()) + this.f2009r;
                    break;
                case 80:
                    paddingTop2 = (((height - paddingBottom) - c0709b2.bottomMargin) - this.f2010s) - measuredHeight;
                    break;
                default:
                    paddingTop2 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                    if (paddingTop2 < c0709b.topMargin + this.f2009r) {
                        i8 = c0709b.topMargin + this.f2009r;
                    } else {
                        measuredHeight = (((height - paddingBottom) - measuredHeight) - paddingTop2) - paddingTop;
                        if (measuredHeight < c0709b.bottomMargin + this.f2010s) {
                            i8 = Math.max(0, paddingTop2 - ((c0709b2.bottomMargin + this.f2010s) - measuredHeight));
                        } else {
                            i8 = paddingTop2;
                        }
                    }
                    paddingTop2 = paddingTop + i8;
                    break;
            }
            if (obj != null) {
                i8 = (obj2 != null ? this.f2007p : 0) - iArr[1];
                i5 = i6 - Math.max(0, i8);
                iArr[1] = Math.max(0, -i8);
                if (a) {
                    c0709b = (C0709b) this.f1994c.getLayoutParams();
                    measuredWidth = i5 - this.f1994c.getMeasuredWidth();
                    i6 = this.f1994c.getMeasuredHeight() + paddingTop2;
                    this.f1994c.layout(measuredWidth, paddingTop2, i5, i6);
                    paddingTop2 = i6 + c0709b.bottomMargin;
                    i6 = measuredWidth - this.f2008q;
                } else {
                    i6 = i5;
                }
                if (a2) {
                    c0709b = (C0709b) this.f1995d.getLayoutParams();
                    measuredWidth = c0709b.topMargin + paddingTop2;
                    measuredHeight = this.f1995d.getMeasuredHeight() + measuredWidth;
                    this.f1995d.layout(i5 - this.f1995d.getMeasuredWidth(), measuredWidth, i5, measuredHeight);
                    i8 = c0709b.bottomMargin + measuredHeight;
                    i8 = i5 - this.f2008q;
                } else {
                    i8 = i5;
                }
                if (obj2 != null) {
                    i8 = Math.min(i6, i8);
                } else {
                    i8 = i5;
                }
                i6 = i8;
            } else {
                i8 = (obj2 != null ? this.f2007p : 0) - iArr[0];
                i7 += Math.max(0, i8);
                iArr[0] = Math.max(0, -i8);
                if (a) {
                    c0709b = (C0709b) this.f1994c.getLayoutParams();
                    i5 = this.f1994c.getMeasuredWidth() + i7;
                    measuredWidth = this.f1994c.getMeasuredHeight() + paddingTop2;
                    this.f1994c.layout(i7, paddingTop2, i5, measuredWidth);
                    i8 = c0709b.bottomMargin + measuredWidth;
                    measuredWidth = i5 + this.f2008q;
                    i5 = i8;
                } else {
                    measuredWidth = i7;
                    i5 = paddingTop2;
                }
                if (a2) {
                    c0709b = (C0709b) this.f1995d.getLayoutParams();
                    i5 += c0709b.topMargin;
                    paddingTop2 = this.f1995d.getMeasuredWidth() + i7;
                    measuredHeight = this.f1995d.getMeasuredHeight() + i5;
                    this.f1995d.layout(i7, i5, paddingTop2, measuredHeight);
                    i8 = c0709b.bottomMargin + measuredHeight;
                    i8 = this.f2008q + paddingTop2;
                } else {
                    i8 = i7;
                }
                if (obj2 != null) {
                    i7 = Math.max(measuredWidth, i8);
                }
            }
        }
        m3473a(this.f1979B, 3);
        int size = this.f1979B.size();
        i5 = i7;
        for (measuredWidth = 0; measuredWidth < size; measuredWidth++) {
            i5 = m3468a((View) this.f1979B.get(measuredWidth), i5, iArr, i9);
        }
        m3473a(this.f1979B, 5);
        i7 = this.f1979B.size();
        for (measuredWidth = 0; measuredWidth < i7; measuredWidth++) {
            i6 = m3477b((View) this.f1979B.get(measuredWidth), i6, iArr, i9);
        }
        m3473a(this.f1979B, 1);
        measuredWidth = m3469a(this.f1979B, iArr);
        i8 = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (measuredWidth / 2);
        measuredWidth += i8;
        if (i8 < i5) {
            i8 = i5;
        } else if (measuredWidth > i6) {
            i8 -= measuredWidth - i6;
        }
        paddingLeft = this.f1979B.size();
        measuredWidth = i8;
        for (i5 = 0; i5 < paddingLeft; i5++) {
            measuredWidth = m3468a((View) this.f1979B.get(i5), measuredWidth, iArr, i9);
        }
        this.f1979B.clear();
    }

    private int m3469a(List<View> list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        int i5 = i2;
        int i6 = i;
        while (i3 < size) {
            View view = (View) list.get(i3);
            C0709b c0709b = (C0709b) view.getLayoutParams();
            i6 = c0709b.leftMargin - i6;
            i = c0709b.rightMargin - i5;
            int max = Math.max(0, i6);
            int max2 = Math.max(0, i);
            i6 = Math.max(0, -i6);
            i5 = Math.max(0, -i);
            i3++;
            i4 += (view.getMeasuredWidth() + max) + max2;
        }
        return i4;
    }

    private int m3468a(View view, int i, int[] iArr, int i2) {
        C0709b c0709b = (C0709b) view.getLayoutParams();
        int i3 = c0709b.leftMargin - iArr[0];
        int max = Math.max(0, i3) + i;
        iArr[0] = Math.max(0, -i3);
        i3 = m3466a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, i3, max + measuredWidth, view.getMeasuredHeight() + i3);
        return (c0709b.rightMargin + measuredWidth) + max;
    }

    private int m3477b(View view, int i, int[] iArr, int i2) {
        C0709b c0709b = (C0709b) view.getLayoutParams();
        int i3 = c0709b.rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        i3 = m3466a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, i3, max, view.getMeasuredHeight() + i3);
        return max - (c0709b.leftMargin + measuredWidth);
    }

    private int m3466a(View view, int i) {
        C0709b c0709b = (C0709b) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        switch (m3465a(c0709b.a)) {
            case 48:
                return getPaddingTop() - i2;
            case 80:
                return (((getHeight() - getPaddingBottom()) - measuredHeight) - c0709b.bottomMargin) - i2;
            default:
                int i3;
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                i2 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                if (i2 < c0709b.topMargin) {
                    i3 = c0709b.topMargin;
                } else {
                    measuredHeight = (((height - paddingBottom) - measuredHeight) - i2) - paddingTop;
                    i3 = measuredHeight < c0709b.bottomMargin ? Math.max(0, i2 - (c0709b.bottomMargin - measuredHeight)) : i2;
                }
                return i3 + paddingTop;
        }
    }

    private int m3465a(int i) {
        int i2 = i & 112;
        switch (i2) {
            case 16:
            case 48:
            case 80:
                return i2;
            default:
                return this.f2012u & 112;
        }
    }

    private void m3473a(List<View> list, int i) {
        int i2 = 1;
        int i3 = 0;
        if (ag.m1803e(this) != 1) {
            i2 = 0;
        }
        int childCount = getChildCount();
        int a = C0438e.m2046a(i, ag.m1803e(this));
        list.clear();
        C0709b c0709b;
        if (i2 != 0) {
            for (i3 = childCount - 1; i3 >= 0; i3--) {
                View childAt = getChildAt(i3);
                c0709b = (C0709b) childAt.getLayoutParams();
                if (c0709b.f1977b == 0 && m3474a(childAt) && m3475b(c0709b.a) == a) {
                    list.add(childAt);
                }
            }
            return;
        }
        while (i3 < childCount) {
            View childAt2 = getChildAt(i3);
            c0709b = (C0709b) childAt2.getLayoutParams();
            if (c0709b.f1977b == 0 && m3474a(childAt2) && m3475b(c0709b.a) == a) {
                list.add(childAt2);
            }
            i3++;
        }
    }

    private int m3475b(int i) {
        int e = ag.m1803e(this);
        int a = C0438e.m2046a(i, e) & 7;
        switch (a) {
            case 1:
            case 3:
            case 5:
                return a;
            default:
                return e == 1 ? 5 : 3;
        }
    }

    private boolean m3474a(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private int m3476b(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return C0459n.m2082b(marginLayoutParams) + C0459n.m2081a(marginLayoutParams);
    }

    private int m3479c(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
    }

    public C0709b m3490a(AttributeSet attributeSet) {
        return new C0709b(getContext(), attributeSet);
    }

    protected C0709b m3491a(LayoutParams layoutParams) {
        if (layoutParams instanceof C0709b) {
            return new C0709b((C0709b) layoutParams);
        }
        if (layoutParams instanceof C0566a) {
            return new C0709b((C0566a) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new C0709b((MarginLayoutParams) layoutParams);
        }
        return new C0709b(layoutParams);
    }

    protected C0709b m3505i() {
        return new C0709b(-2, -2);
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof C0709b);
    }

    public ag getWrapper() {
        if (this.f1984G == null) {
            this.f1984G = new az(this, true);
        }
        return this.f1984G;
    }

    void m3506j() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (!(((C0709b) childAt.getLayoutParams()).f1977b == 2 || childAt == this.f1993b)) {
                removeViewAt(childCount);
                this.f1980C.add(childAt);
            }
        }
    }

    void m3507k() {
        for (int size = this.f1980C.size() - 1; size >= 0; size--) {
            addView((View) this.f1980C.get(size));
        }
        this.f1980C.clear();
    }

    private boolean m3482d(View view) {
        return view.getParent() == this || this.f1980C.contains(view);
    }

    public void setCollapsible(boolean z) {
        this.f1989L = z;
        requestLayout();
    }

    public void m3495a(C0607a c0607a, C0591a c0591a) {
        this.f1987J = c0607a;
        this.f1988K = c0591a;
        if (this.f1993b != null) {
            this.f1993b.m3359a(c0607a, c0591a);
        }
    }
}
