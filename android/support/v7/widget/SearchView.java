package android.support.v7.widget;

import android.annotation.TargetApi;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.support.v4.widget.C0515g;
import android.support.v7.p011a.C0564a.C0553a;
import android.support.v7.p011a.C0564a.C0556d;
import android.support.v7.view.C0641c;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.actions.SearchIntents;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class SearchView extends aj implements C0641c {
    static final C0700a f1930a = new C0700a();
    private static final boolean f1931b;
    private boolean f1932A;
    private boolean f1933B;
    private int f1934C;
    private boolean f1935D;
    private CharSequence f1936E;
    private boolean f1937F;
    private int f1938G;
    private SearchableInfo f1939H;
    private Bundle f1940I;
    private Runnable f1941J;
    private final Runnable f1942K;
    private Runnable f1943L;
    private final WeakHashMap<String, ConstantState> f1944M;
    private final SearchAutoComplete f1945c;
    private final View f1946d;
    private final View f1947e;
    private final ImageView f1948f;
    private final ImageView f1949g;
    private final ImageView f1950h;
    private final ImageView f1951i;
    private final ImageView f1952j;
    private final Drawable f1953k;
    private final int f1954l;
    private final int f1955m;
    private final Intent f1956n;
    private final Intent f1957o;
    private final CharSequence f1958p;
    private C0702c f1959q;
    private C0701b f1960r;
    private OnFocusChangeListener f1961s;
    private C0703d f1962t;
    private OnClickListener f1963u;
    private boolean f1964v;
    private boolean f1965w;
    private C0515g f1966x;
    private boolean f1967y;
    private CharSequence f1968z;

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C06981();
        boolean f1919a;

        static class C06981 implements Creator<SavedState> {
            C06981() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m3420a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m3421a(i);
            }

            public SavedState m3420a(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] m3421a(int i) {
                return new SavedState[i];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f1919a = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.f1919a));
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f1919a + "}";
        }
    }

    public static class SearchAutoComplete extends C0699f {
        private int f1924a;
        private SearchView f1925b;

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, C0553a.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.f1924a = getThreshold();
        }

        void setSearchView(SearchView searchView) {
            this.f1925b = searchView;
        }

        public void setThreshold(int i) {
            super.setThreshold(i);
            this.f1924a = i;
        }

        protected void replaceText(CharSequence charSequence) {
        }

        public void performCompletion() {
        }

        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.f1925b.hasFocus() && getVisibility() == 0) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                if (SearchView.m3431a(getContext())) {
                    SearchView.f1930a.m3423a(this, true);
                }
            }
        }

        protected void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.f1925b.m3452d();
        }

        public boolean enoughToFilter() {
            return this.f1924a <= 0 || super.enoughToFilter();
        }

        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                DispatcherState keyDispatcherState;
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState == null) {
                        return true;
                    }
                    keyDispatcherState.startTracking(keyEvent, this);
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f1925b.clearFocus();
                        this.f1925b.setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }
    }

    private static class C0700a {
        private Method f1926a;
        private Method f1927b;
        private Method f1928c;
        private Method f1929d;

        C0700a() {
            try {
                this.f1926a = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f1926a.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            try {
                this.f1927b = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f1927b.setAccessible(true);
            } catch (NoSuchMethodException e2) {
            }
            try {
                this.f1928c = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
                this.f1928c.setAccessible(true);
            } catch (NoSuchMethodException e3) {
            }
            try {
                this.f1929d = InputMethodManager.class.getMethod("showSoftInputUnchecked", new Class[]{Integer.TYPE, ResultReceiver.class});
                this.f1929d.setAccessible(true);
            } catch (NoSuchMethodException e4) {
            }
        }

        void m3422a(AutoCompleteTextView autoCompleteTextView) {
            if (this.f1926a != null) {
                try {
                    this.f1926a.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception e) {
                }
            }
        }

        void m3424b(AutoCompleteTextView autoCompleteTextView) {
            if (this.f1927b != null) {
                try {
                    this.f1927b.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception e) {
                }
            }
        }

        void m3423a(AutoCompleteTextView autoCompleteTextView, boolean z) {
            if (this.f1928c != null) {
                try {
                    this.f1928c.invoke(autoCompleteTextView, new Object[]{Boolean.valueOf(z)});
                } catch (Exception e) {
                }
            }
        }
    }

    public interface C0701b {
        boolean m3425a();
    }

    public interface C0702c {
        boolean m3426a(String str);
    }

    public interface C0703d {
    }

    static {
        boolean z;
        if (VERSION.SDK_INT >= 8) {
            z = true;
        } else {
            z = false;
        }
        f1931b = z;
    }

    int getSuggestionRowLayout() {
        return this.f1954l;
    }

    int getSuggestionCommitIconResId() {
        return this.f1955m;
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f1939H = searchableInfo;
        if (this.f1939H != null) {
            if (f1931b) {
                m3441l();
            }
            m3440k();
        }
        boolean z = f1931b && m3435e();
        this.f1935D = z;
        if (this.f1935D) {
            this.f1945c.setPrivateImeOptions("nm");
        }
        m3430a(m3451c());
    }

    public void setAppSearchData(Bundle bundle) {
        this.f1940I = bundle;
    }

    public void setImeOptions(int i) {
        this.f1945c.setImeOptions(i);
    }

    public int getImeOptions() {
        return this.f1945c.getImeOptions();
    }

    public void setInputType(int i) {
        this.f1945c.setInputType(i);
    }

    public int getInputType() {
        return this.f1945c.getInputType();
    }

    public boolean requestFocus(int i, Rect rect) {
        if (this.f1933B || !isFocusable()) {
            return false;
        }
        if (m3451c()) {
            return super.requestFocus(i, rect);
        }
        boolean requestFocus = this.f1945c.requestFocus(i, rect);
        if (requestFocus) {
            m3430a(false);
        }
        return requestFocus;
    }

    public void clearFocus() {
        this.f1933B = true;
        setImeVisibility(false);
        super.clearFocus();
        this.f1945c.clearFocus();
        this.f1933B = false;
    }

    public void setOnQueryTextListener(C0702c c0702c) {
        this.f1959q = c0702c;
    }

    public void setOnCloseListener(C0701b c0701b) {
        this.f1960r = c0701b;
    }

    public void setOnQueryTextFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.f1961s = onFocusChangeListener;
    }

    public void setOnSuggestionListener(C0703d c0703d) {
        this.f1962t = c0703d;
    }

    public void setOnSearchClickListener(OnClickListener onClickListener) {
        this.f1963u = onClickListener;
    }

    public CharSequence getQuery() {
        return this.f1945c.getText();
    }

    public void m3449a(CharSequence charSequence, boolean z) {
        this.f1945c.setText(charSequence);
        if (charSequence != null) {
            this.f1945c.setSelection(this.f1945c.length());
            this.f1936E = charSequence;
        }
        if (z && !TextUtils.isEmpty(charSequence)) {
            m3442m();
        }
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f1968z = charSequence;
        m3440k();
    }

    public CharSequence getQueryHint() {
        if (this.f1968z != null) {
            return this.f1968z;
        }
        if (!f1931b || this.f1939H == null || this.f1939H.getHintId() == 0) {
            return this.f1958p;
        }
        return getContext().getText(this.f1939H.getHintId());
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.f1964v != z) {
            this.f1964v = z;
            m3430a(z);
            m3440k();
        }
    }

    public void setIconified(boolean z) {
        if (z) {
            m3444o();
        } else {
            m3445p();
        }
    }

    public boolean m3451c() {
        return this.f1965w;
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.f1967y = z;
        m3430a(m3451c());
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.f1932A = z;
        if (this.f1966x instanceof as) {
            ((as) this.f1966x).m3718a(z ? 2 : 1);
        }
    }

    public void setSuggestionsAdapter(C0515g c0515g) {
        this.f1966x = c0515g;
        this.f1945c.setAdapter(this.f1966x);
    }

    public C0515g getSuggestionsAdapter() {
        return this.f1966x;
    }

    public void setMaxWidth(int i) {
        this.f1934C = i;
        requestLayout();
    }

    public int getMaxWidth() {
        return this.f1934C;
    }

    protected void onMeasure(int i, int i2) {
        if (m3451c()) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        switch (mode) {
            case Integer.MIN_VALUE:
                if (this.f1934C <= 0) {
                    size = Math.min(getPreferredWidth(), size);
                    break;
                } else {
                    size = Math.min(this.f1934C, size);
                    break;
                }
            case 0:
                if (this.f1934C <= 0) {
                    size = getPreferredWidth();
                    break;
                } else {
                    size = this.f1934C;
                    break;
                }
            case 1073741824:
                if (this.f1934C > 0) {
                    size = Math.min(this.f1934C, size);
                    break;
                }
                break;
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), i2);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(C0556d.abc_search_view_preferred_width);
    }

    private void m3430a(boolean z) {
        boolean z2;
        boolean z3 = true;
        int i = 8;
        this.f1965w = z;
        int i2 = z ? 0 : 8;
        if (TextUtils.isEmpty(this.f1945c.getText())) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.f1948f.setVisibility(i2);
        m3433b(z2);
        View view = this.f1946d;
        if (z) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        view.setVisibility(i2);
        if (!(this.f1952j.getDrawable() == null || this.f1964v)) {
            i = 0;
        }
        this.f1952j.setVisibility(i);
        m3438h();
        if (z2) {
            z3 = false;
        }
        m3434c(z3);
        m3437g();
    }

    @TargetApi(8)
    private boolean m3435e() {
        if (this.f1939H == null || !this.f1939H.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.f1939H.getVoiceSearchLaunchWebSearch()) {
            intent = this.f1956n;
        } else if (this.f1939H.getVoiceSearchLaunchRecognizer()) {
            intent = this.f1957o;
        }
        if (intent == null || getContext().getPackageManager().resolveActivity(intent, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) == null) {
            return false;
        }
        return true;
    }

    private boolean m3436f() {
        return (this.f1967y || this.f1935D) && !m3451c();
    }

    private void m3433b(boolean z) {
        int i = 8;
        if (this.f1967y && m3436f() && hasFocus() && (z || !this.f1935D)) {
            i = 0;
        }
        this.f1949g.setVisibility(i);
    }

    private void m3437g() {
        int i = 8;
        if (m3436f() && (this.f1949g.getVisibility() == 0 || this.f1951i.getVisibility() == 0)) {
            i = 0;
        }
        this.f1947e.setVisibility(i);
    }

    private void m3438h() {
        int i = 1;
        int i2 = 0;
        int i3 = !TextUtils.isEmpty(this.f1945c.getText()) ? 1 : 0;
        if (i3 == 0 && (!this.f1964v || this.f1937F)) {
            i = 0;
        }
        ImageView imageView = this.f1950h;
        if (i == 0) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        Drawable drawable = this.f1950h.getDrawable();
        if (drawable != null) {
            drawable.setState(i3 != 0 ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
    }

    private void m3439i() {
        post(this.f1942K);
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.f1942K);
        post(this.f1943L);
        super.onDetachedFromWindow();
    }

    private void setImeVisibility(boolean z) {
        if (z) {
            post(this.f1941J);
            return;
        }
        removeCallbacks(this.f1941J);
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    void m3448a(CharSequence charSequence) {
        setQuery(charSequence);
    }

    private CharSequence m3432b(CharSequence charSequence) {
        if (!this.f1964v || this.f1953k == null) {
            return charSequence;
        }
        int textSize = (int) (((double) this.f1945c.getTextSize()) * 1.25d);
        this.f1953k.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.f1953k), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private void m3440k() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f1945c;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(m3432b(queryHint));
    }

    @TargetApi(8)
    private void m3441l() {
        int i = 1;
        this.f1945c.setThreshold(this.f1939H.getSuggestThreshold());
        this.f1945c.setImeOptions(this.f1939H.getImeOptions());
        int inputType = this.f1939H.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f1939H.getSuggestAuthority() != null) {
                inputType = (inputType | NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) | 524288;
            }
        }
        this.f1945c.setInputType(inputType);
        if (this.f1966x != null) {
            this.f1966x.mo377a(null);
        }
        if (this.f1939H.getSuggestAuthority() != null) {
            this.f1966x = new as(getContext(), this, this.f1939H, this.f1944M);
            this.f1945c.setAdapter(this.f1966x);
            as asVar = (as) this.f1966x;
            if (this.f1932A) {
                i = 2;
            }
            asVar.m3718a(i);
        }
    }

    private void m3434c(boolean z) {
        int i;
        if (this.f1935D && !m3451c() && z) {
            i = 0;
            this.f1949g.setVisibility(8);
        } else {
            i = 8;
        }
        this.f1951i.setVisibility(i);
    }

    private void m3442m() {
        CharSequence text = this.f1945c.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            if (this.f1959q == null || !this.f1959q.m3426a(text.toString())) {
                if (this.f1939H != null) {
                    m3428a(0, null, text.toString());
                }
                setImeVisibility(false);
                m3443n();
            }
        }
    }

    private void m3443n() {
        this.f1945c.dismissDropDown();
    }

    private void m3444o() {
        if (!TextUtils.isEmpty(this.f1945c.getText())) {
            this.f1945c.setText("");
            this.f1945c.requestFocus();
            setImeVisibility(true);
        } else if (!this.f1964v) {
        } else {
            if (this.f1960r == null || !this.f1960r.m3425a()) {
                clearFocus();
                m3430a(true);
            }
        }
    }

    private void m3445p() {
        m3430a(false);
        this.f1945c.requestFocus();
        setImeVisibility(true);
        if (this.f1963u != null) {
            this.f1963u.onClick(this);
        }
    }

    void m3452d() {
        m3430a(m3451c());
        m3439i();
        if (this.f1945c.hasFocus()) {
            m3446q();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        m3439i();
    }

    public void mo554b() {
        m3449a((CharSequence) "", false);
        clearFocus();
        m3430a(true);
        this.f1945c.setImeOptions(this.f1938G);
        this.f1937F = false;
    }

    public void mo553a() {
        if (!this.f1937F) {
            this.f1937F = true;
            this.f1938G = this.f1945c.getImeOptions();
            this.f1945c.setImeOptions(this.f1938G | 33554432);
            this.f1945c.setText("");
            setIconified(false);
        }
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1919a = m3451c();
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            m3430a(savedState.f1919a);
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    private void setQuery(CharSequence charSequence) {
        this.f1945c.setText(charSequence);
        this.f1945c.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    private void m3428a(int i, String str, String str2) {
        getContext().startActivity(m3427a("android.intent.action.SEARCH", null, null, str2, i, str));
    }

    private Intent m3427a(String str, Uri uri, String str2, String str3, int i, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f1936E);
        if (str3 != null) {
            intent.putExtra(SearchIntents.EXTRA_QUERY, str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        if (this.f1940I != null) {
            intent.putExtra("app_data", this.f1940I);
        }
        if (i != 0) {
            intent.putExtra("action_key", i);
            intent.putExtra("action_msg", str4);
        }
        if (f1931b) {
            intent.setComponent(this.f1939H.getSearchActivity());
        }
        return intent;
    }

    private void m3446q() {
        f1930a.m3422a(this.f1945c);
        f1930a.m3424b(this.f1945c);
    }

    static boolean m3431a(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }
}
