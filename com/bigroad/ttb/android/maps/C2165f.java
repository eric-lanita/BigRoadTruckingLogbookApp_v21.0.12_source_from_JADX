package com.bigroad.ttb.android.maps;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bigroad.ttb.android.C2162t;

public abstract class C2165f extends WebView {
    protected boolean f7537a = false;

    protected class C2163a implements C2162t {
        final /* synthetic */ C2165f f7533b;

        protected C2163a(C2165f c2165f) {
            this.f7533b = c2165f;
        }
    }

    class C21711 extends WebViewClient {
        final /* synthetic */ C2165f f7543a;

        C21711(C2165f c2165f) {
            this.f7543a = c2165f;
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Log.e("TT-OurMapView", "Error " + i + ": " + str + " on " + str2);
        }

        public void onPageFinished(WebView webView, String str) {
            if (!this.f7543a.f7537a) {
                this.f7543a.f7537a = true;
                this.f7543a.mo1256a(webView, str);
            }
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Log.d("TT-OurMapView", "Ignoring request to load: " + str);
            return true;
        }
    }

    class C21722 extends WebChromeClient {
        final /* synthetic */ C2165f f7544a;

        C21722(C2165f c2165f) {
            this.f7544a = c2165f;
        }

        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            Log.i("TT-OurMapView", "Console: " + consoleMessage.sourceId() + "@" + consoleMessage.lineNumber() + " " + consoleMessage.message());
            return true;
        }
    }

    protected abstract String getMapURL();

    protected C2162t getJavascriptInterface() {
        return new C2163a(this);
    }

    public C2165f(Context context) {
        super(context);
    }

    public C2165f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean m10763c() {
        return this.f7537a;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    protected void m10764d() {
        WebSettings settings = getSettings();
        if (settings != null) {
            settings.setJavaScriptEnabled(true);
            settings.setGeolocationEnabled(true);
            settings.setBuiltInZoomControls(false);
            settings.setSupportZoom(false);
            settings.setSupportMultipleWindows(false);
            settings.setRenderPriority(RenderPriority.HIGH);
        }
    }

    protected void mo1256a(WebView webView, String str) {
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        m10765e();
    }

    public void m10765e() {
        setLayerType(1, null);
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        setBackgroundColor(-16777216);
        m10764d();
        setWebViewClient(new C21711(this));
        setWebChromeClient(new C21722(this));
        addJavascriptInterface(getJavascriptInterface(), "android");
        loadUrl(getMapURL());
    }
}
