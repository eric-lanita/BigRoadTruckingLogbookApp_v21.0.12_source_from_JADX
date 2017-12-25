package com.urbanairship.widget;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.HttpAuthHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.urbanairship.C3783j;
import com.urbanairship.C3929q;
import com.urbanairship.actions.ActionValue;
import com.urbanairship.actions.C3681c;
import com.urbanairship.actions.C3694b;
import com.urbanairship.actions.C3701e;
import com.urbanairship.actions.C3705g;
import com.urbanairship.json.JsonValue;
import com.urbanairship.p056c.C3763a;
import com.urbanairship.richpush.C3942c;
import com.urbanairship.util.C3955j;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONObject;

public class C3685a extends WebViewClient {
    private static SimpleDateFormat f13312d;
    private final Map<String, C3959a> f13313a;
    private C3681c f13314b;
    private final C3705g f13315c;

    class C39571 implements C3681c {
        final /* synthetic */ C3685a f14013a;

        C39571(C3685a c3685a) {
            this.f14013a = c3685a;
        }

        public void mo2766a(C3694b c3694b, C3701e c3701e) {
            synchronized (this) {
                if (this.f14013a.f13314b != null) {
                    this.f14013a.f13314b.mo2766a(c3694b, c3701e);
                }
            }
        }
    }

    private static class C3959a {
        final String f14018a;
        final String f14019b;

        C3959a(String str, String str2) {
            this.f14018a = str;
            this.f14019b = str2;
        }
    }

    public C3685a() {
        this(new C3705g());
    }

    C3685a(C3705g c3705g) {
        this.f13313a = new HashMap();
        this.f13315c = c3705g;
    }

    public void m19333a(WebView webView) {
        webView.getRootView().dispatchKeyEvent(new KeyEvent(0, 4));
        webView.getRootView().dispatchKeyEvent(new KeyEvent(1, 4));
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return m19329a(webView, str);
    }

    public void onLoadResource(WebView webView, String str) {
        m19329a(webView, str);
    }

    private boolean m19329a(WebView webView, String str) {
        if (webView == null || str == null) {
            return false;
        }
        Uri parse = Uri.parse(str);
        if (parse.getHost() == null || !parse.getScheme().equals("uairship") || !m19331b(webView.getUrl())) {
            return false;
        }
        C3783j.m19723b("Intercepting: " + str);
        String host = parse.getHost();
        boolean z = true;
        switch (host.hashCode()) {
            case -1507513413:
                if (host.equals("run-actions")) {
                    z = true;
                    break;
                }
                break;
            case -189575524:
                if (host.equals("run-basic-actions")) {
                    z = false;
                    break;
                }
                break;
            case 94756344:
                if (host.equals("close")) {
                    z = true;
                    break;
                }
                break;
            case 716793782:
                if (host.equals("android-run-action-cb")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                C3783j.m19727d("Running run basic actions command for URL: " + str);
                m19327a(webView, m19324a(parse, true));
                return true;
            case true:
                C3783j.m19727d("Running run actions command for URL: " + str);
                m19327a(webView, m19324a(parse, false));
                return true;
            case true:
                C3783j.m19727d("Running run actions command with callback for URL: " + str);
                List pathSegments = parse.getPathSegments();
                if (pathSegments.size() == 3) {
                    C3783j.m19727d("Action: " + ((String) pathSegments.get(0)) + ", Args: " + ((String) pathSegments.get(1)) + ", Callback: " + ((String) pathSegments.get(2)));
                    m19326a(webView, (String) pathSegments.get(0), (String) pathSegments.get(1), (String) pathSegments.get(2));
                } else {
                    C3783j.m19728e("Unable to run action, invalid number of arguments.");
                }
                return true;
            case true:
                C3783j.m19727d("Running close command for URL: " + str);
                m19333a(webView);
                return true;
            default:
                C3783j.m19721a("Unrecognized command: " + parse.getHost() + " for URL: " + str);
                return false;
        }
    }

    private void m19327a(WebView webView, Map<String, List<ActionValue>> map) {
        if (map != null) {
            Bundle bundle = new Bundle();
            C3942c c = m19332c(webView);
            if (c != null) {
                bundle.putString("com.urbanairship.RICH_PUSH_ID_METADATA", c.m20446a());
            }
            for (String str : map.keySet()) {
                for (ActionValue a : (List) map.get(str)) {
                    this.f13315c.m19391a(str).m19387a(a).m19386a(bundle).m19385a(3).m19389a(new C39571(this));
                }
            }
        }
    }

    private void m19326a(final WebView webView, final String str, String str2, final String str3) {
        try {
            ActionValue actionValue = new ActionValue(JsonValue.m19740b(str2));
            Bundle bundle = new Bundle();
            C3942c c = m19332c(webView);
            if (c != null) {
                bundle.putString("com.urbanairship.RICH_PUSH_ID_METADATA", c.m20446a());
            }
            this.f13315c.m19391a(str).m19386a(bundle).m19387a(actionValue).m19385a(3).m19389a(new C3681c(this) {
                final /* synthetic */ C3685a f14017d;

                public void mo2766a(C3694b c3694b, C3701e c3701e) {
                    String str = null;
                    switch (c3701e.m19378d()) {
                        case 2:
                            str = String.format("Action %s rejected its arguments", new Object[]{str});
                            break;
                        case 3:
                            str = String.format("Action %s not found", new Object[]{str});
                            break;
                        case 4:
                            if (c3701e.m19377c() == null) {
                                str = String.format("Action %s failed with unspecified error", new Object[]{str});
                                break;
                            }
                            str = c3701e.m19377c().getMessage();
                            break;
                    }
                    this.f14017d.m19325a(webView, str, c3701e.m19376b(), str3);
                    synchronized (this) {
                        if (this.f14017d.f13314b != null) {
                            this.f14017d.f13314b.mo2766a(c3694b, c3701e);
                        }
                    }
                }
            });
        } catch (Throwable e) {
            C3783j.m19722a("Unable to parse action argument value: " + str2, e);
            m19325a(webView, "Unable to decode arguments payload", new ActionValue(), str3);
        }
    }

    @SuppressLint({"NewAPI"})
    private void m19325a(WebView webView, String str, ActionValue actionValue, String str2) {
        String str3;
        String format = String.format("'%s'", new Object[]{str2});
        if (str == null) {
            str3 = "null";
        } else {
            str3 = String.format(Locale.US, "new Error(%s)", new Object[]{JSONObject.quote(str)});
        }
        String actionValue2 = actionValue.toString();
        str3 = String.format(Locale.US, "UAirship.finishAction(%s, %s, %s);", new Object[]{str3, actionValue2, format});
        if (VERSION.SDK_INT >= 19) {
            webView.evaluateJavascript(str3, null);
        } else {
            webView.loadUrl("javascript:" + str3);
        }
    }

    private Map<String, List<ActionValue>> m19324a(Uri uri, boolean z) {
        Map a = C3955j.m20515a(uri);
        if (a == null) {
            return null;
        }
        Map<String, List<ActionValue>> hashMap = new HashMap();
        for (String str : a.keySet()) {
            List arrayList = new ArrayList();
            if (a.get(str) == null) {
                C3783j.m19721a("No arguments to decode for actionName: " + str);
                return null;
            }
            for (String str2 : (List) a.get(str)) {
                JsonValue c;
                if (z) {
                    try {
                        c = JsonValue.m19743c(str2);
                    } catch (Throwable e) {
                        C3783j.m19722a("Invalid json. Unable to create action argument " + str + " with args: " + str2, e);
                        return null;
                    }
                }
                c = JsonValue.m19740b(str2);
                arrayList.add(new ActionValue(c));
            }
            hashMap.put(str, arrayList);
        }
        if (!hashMap.isEmpty()) {
            return hashMap;
        }
        C3783j.m19721a("Error no action names are present in the actions key set");
        return null;
    }

    public void onPageFinished(WebView webView, String str) {
        if (webView != null) {
            if (m19331b(str)) {
                C3783j.m19727d("Loading UrbanAirship Javascript interface.");
                m19330b(webView);
                return;
            }
            C3783j.m19725c("UAWebViewClient - " + str + " is not a white listed URL. Urban Airship Javascript interface will not be accessible.");
        }
    }

    private boolean m19331b(String str) {
        return C3929q.m20372a().m20396t().m19673b(str);
    }

    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        C3959a c3959a = (C3959a) this.f13313a.get(str);
        if (c3959a != null) {
            httpAuthHandler.proceed(c3959a.f14018a, c3959a.f14019b);
        }
    }

    void m19335a(String str, String str2, String str3) {
        this.f13313a.put(str, new C3959a(str2, str3));
    }

    void m19334a(String str) {
        this.f13313a.remove(str);
    }

    @SuppressLint({"NewAPI"})
    private void m19330b(WebView webView) {
        String a;
        long f;
        C3942c c = m19332c(webView);
        if (f13312d == null) {
            f13312d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.US);
            f13312d.setTimeZone(TimeZone.getTimeZone("UTC"));
        }
        StringBuilder append = new StringBuilder().append("var _UAirship = {};");
        StringBuilder append2 = append.append(m19323a("getDeviceModel", Build.MODEL));
        String str = "getMessageId";
        if (c != null) {
            a = c.m20446a();
        } else {
            a = null;
        }
        append2 = append2.append(m19323a(str, a));
        str = "getMessageTitle";
        if (c != null) {
            a = c.m20448c();
        } else {
            a = null;
        }
        append2 = append2.append(m19323a(str, a));
        str = "getMessageSentDate";
        if (c != null) {
            a = f13312d.format(c.m20450e());
        } else {
            a = null;
        }
        StringBuilder append3 = append2.append(m19323a(str, a));
        str = "getMessageSentDateMS";
        if (c != null) {
            f = c.m20451f();
        } else {
            f = -1;
        }
        append3.append(m19322a(str, f)).append(m19323a("getUserId", C3929q.m20372a().m20391o().m20439b().m20478b())).append(m19323a("getChannelId", C3929q.m20372a().m20390n().m20329u())).append(m19323a("getNamedUser", C3929q.m20372a().m20389m().m20134b()));
        append.append(C3763a.m19668a());
        a = append.toString();
        if (VERSION.SDK_INT >= 19) {
            webView.evaluateJavascript(a, null);
        } else {
            webView.loadUrl("javascript:" + a);
        }
    }

    private String m19323a(String str, String str2) {
        String quote = str2 == null ? "null" : JSONObject.quote(str2);
        return String.format(Locale.US, "_UAirship.%s = function(){return %s;};", new Object[]{str, quote});
    }

    private String m19322a(String str, long j) {
        return String.format(Locale.US, "_UAirship.%s = function(){return %d;};", new Object[]{str, Long.valueOf(j)});
    }

    private C3942c m19332c(WebView webView) {
        if (webView instanceof UAWebView) {
            return ((UAWebView) webView).getCurrentMessage();
        }
        return null;
    }
}
