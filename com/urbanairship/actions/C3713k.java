package com.urbanairship.actions;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.facebook.share.internal.ShareConstants;
import com.urbanairship.C3761b;
import com.urbanairship.C3783j;
import com.urbanairship.C3929q;
import com.urbanairship.richpush.C3942c;
import com.urbanairship.util.C3954i;
import com.urbanairship.util.C3955j;
import com.urbanairship.widget.UAWebView;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class C3713k extends C3690a {
    public C3701e mo2770d(C3694b c3694b) {
        final Uri e = m19400e(c3694b);
        switch (c3694b.m19358b()) {
            case 1:
                if (m19401f(c3694b)) {
                    new Handler(Looper.getMainLooper()).postAtFrontOfQueue(new Runnable(this) {
                        final /* synthetic */ C3713k f13358b;

                        public void run() {
                            UAWebView uAWebView = new UAWebView(C3929q.m20382h());
                            if (e.getScheme().equalsIgnoreCase(ShareConstants.WEB_DIALOG_PARAM_MESSAGE)) {
                                String schemeSpecificPart = e.getSchemeSpecificPart();
                                C3942c b = C3929q.m20372a().m20391o().m20438b(schemeSpecificPart);
                                if (b != null) {
                                    uAWebView.m20523a(b);
                                    return;
                                } else {
                                    C3783j.m19725c("LandingPageAction - Message " + schemeSpecificPart + " not found.");
                                    return;
                                }
                            }
                            uAWebView.loadUrl(e.toString());
                        }
                    });
                    break;
                }
                break;
            default:
                final Intent intent = new Intent("com.urbanairship.actions.SHOW_LANDING_PAGE_INTENT_ACTION", e).addFlags(805306368).setPackage(C3929q.m20374b());
                new Handler(Looper.getMainLooper()).post(new Runnable(this) {
                    final /* synthetic */ C3713k f13361c;

                    public void run() {
                        try {
                            C3929q.m20382h().startActivity(intent);
                        } catch (ActivityNotFoundException e) {
                            C3783j.m19728e("Unable to view a landing page for uri " + e + ". The landing page's" + "intent filter is missing the scheme: " + e.getScheme());
                        }
                    }
                });
                break;
        }
        return C3701e.m19372a();
    }

    public boolean mo2769b(C3694b c3694b) {
        switch (c3694b.m19358b()) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
                return m19400e(c3694b) != null;
            default:
                return false;
        }
    }

    protected Uri m19400e(C3694b c3694b) {
        Object a;
        if (c3694b.m19357a().m19318c() != null) {
            a = c3694b.m19357a().m19318c().m19782c("url").m19747a();
        } else {
            a = c3694b.m19357a().m19314a();
        }
        if (a == null) {
            return null;
        }
        Uri a2 = C3955j.m20514a(a);
        if (C3954i.m20512a(a2.toString())) {
            return null;
        }
        if ("u".equals(a2.getScheme())) {
            try {
                String encode = URLEncoder.encode(a2.getSchemeSpecificPart(), "UTF-8");
                C3761b l = C3929q.m20372a().m20388l();
                a2 = Uri.parse(l.f13507g + l.m19664a() + "/" + encode);
            } catch (UnsupportedEncodingException e) {
                C3783j.m19721a("LandingPageAction - Unable to decode " + a2.getSchemeSpecificPart());
                return null;
            }
        }
        if (C3954i.m20512a(a2.getScheme())) {
            return Uri.parse("https://" + a2);
        }
        return a2;
    }

    protected boolean m19401f(C3694b c3694b) {
        if (c3694b.m19357a().m19318c() != null) {
            return c3694b.m19357a().m19318c().m19782c("cache_on_receive").m19750a(false);
        }
        return false;
    }
}
