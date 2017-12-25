package com.urbanairship.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.MotionEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.urbanairship.C3761b;
import com.urbanairship.C3783j;
import com.urbanairship.C3860o.C3858k;
import com.urbanairship.C3929q;
import com.urbanairship.richpush.C3942c;
import com.urbanairship.richpush.C3944e;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class UAWebView extends WebView {
    private WebViewClient f14010a;
    private String f14011b;
    private C3942c f14012c;

    public UAWebView(Context context) {
        this(context, null);
    }

    public UAWebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842885);
    }

    public UAWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (!isInEditMode()) {
            m20519a(context, attributeSet, i, 0);
        }
    }

    @TargetApi(21)
    public UAWebView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        if (!isInEditMode()) {
            m20519a(context, attributeSet, i, i2);
        }
    }

    @SuppressLint({"NewApi", "SetJavaScriptEnabled"})
    private void m20519a(Context context, AttributeSet attributeSet, int i, int i2) {
        WebSettings settings = getSettings();
        if (VERSION.SDK_INT >= 7) {
            settings.setAppCacheEnabled(true);
            settings.setAppCachePath(getCachePath());
            settings.setDomStorageEnabled(true);
        }
        if (VERSION.SDK_INT >= 21 && attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C3858k.UAWebView, i, i2);
            try {
                settings.setMixedContentMode(obtainStyledAttributes.getInteger(C3858k.UAWebView_mixed_content_mode, 2));
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        settings.setAllowFileAccess(true);
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(-1);
        m20522a();
        m20524b();
    }

    protected void m20522a() {
    }

    protected void m20524b() {
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            int scrollY = getScrollY();
            int scrollX = getScrollX();
            onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void loadData(String str, String str2, String str3) {
        m20521c();
        super.loadData(str, str2, str3);
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        m20521c();
        super.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public void loadUrl(String str) {
        m20521c();
        if (str == null || !str.startsWith(C3929q.m20372a().m20388l().f13507g)) {
            super.loadUrl(str);
            return;
        }
        C3761b l;
        if (VERSION.SDK_INT >= 8) {
            l = C3929q.m20372a().m20388l();
            Map hashMap = new HashMap();
            hashMap.put("Authorization", m20518a(l.m19664a(), l.m19666b()));
            super.loadUrl(str, hashMap);
        } else {
            super.loadUrl(str);
        }
        l = C3929q.m20372a().m20388l();
        m20520a(str, l.m19664a(), l.m19666b());
    }

    public void loadUrl(String str, Map<String, String> map) {
        m20521c();
        super.loadUrl(str, map);
        if (str != null && str.startsWith(C3929q.m20372a().m20388l().f13507g)) {
            C3761b l = C3929q.m20372a().m20388l();
            m20520a(str, l.m19664a(), l.m19666b());
        }
    }

    @SuppressLint({"NewApi"})
    public void m20523a(C3942c c3942c) {
        if (c3942c == null) {
            C3783j.m19721a("Unable to load null message into UAWebView");
            return;
        }
        C3944e b = C3929q.m20372a().m20391o().m20439b();
        if (VERSION.SDK_INT >= 8) {
            Map hashMap = new HashMap();
            hashMap.put("Authorization", m20518a(b.m20478b(), b.m20480c()));
            loadUrl(c3942c.m20447b(), hashMap);
        } else {
            loadUrl(c3942c.m20447b());
        }
        this.f14012c = c3942c;
        m20520a(c3942c.m20447b(), b.m20478b(), b.m20480c());
    }

    public C3942c getCurrentMessage() {
        return this.f14012c;
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        if (!(webViewClient instanceof C3685a)) {
            C3783j.m19721a("The web view client should extend UAWebViewClient to support urban airship url overrides and triggering actions from.");
        }
        this.f14010a = webViewClient;
        super.setWebViewClient(webViewClient);
    }

    @SuppressLint({"NewApi"})
    private void m20521c() {
        this.f14012c = null;
        if (getWebViewClient() == null) {
            C3783j.m19727d("No web view client set, setting a default UAWebViewClient for landing page view.");
            setWebViewClient(new C3685a());
        }
        if (this.f14011b != null && getWebViewClient() != null && (getWebViewClient() instanceof C3685a)) {
            ((C3685a) getWebViewClient()).m19334a(this.f14011b);
            this.f14011b = null;
        }
    }

    WebViewClient getWebViewClient() {
        return this.f14010a;
    }

    private String getCachePath() {
        File file = new File(C3929q.m20382h().getCacheDir(), "urbanairship");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    private void m20520a(String str, String str2, String str3) {
        if (str != null) {
            this.f14011b = str;
            if (getWebViewClient() != null && (getWebViewClient() instanceof C3685a)) {
                ((C3685a) getWebViewClient()).m19335a(Uri.parse(str).getHost(), str2, str3);
            }
        }
    }

    private String m20518a(String str, String str2) {
        return "Basic " + Base64.encodeToString((str + ":" + str2).getBytes(), 2);
    }
}
