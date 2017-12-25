package com.urbanairship.push.p033a;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.app.ad.C0134a;
import android.support.v4.app.ad.C0135q;
import android.support.v4.app.ad.C0136b;
import android.support.v4.app.ad.C0137c;
import android.support.v4.app.ad.C0138d;
import android.support.v4.app.ad.C0140f;
import android.support.v4.app.ad.C0141g;
import android.support.v4.app.ad.C0151r;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.WindowManager;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.urbanairship.C3783j;
import com.urbanairship.C3929q;
import com.urbanairship.json.C3788b;
import com.urbanairship.json.JsonValue;
import com.urbanairship.push.PushMessage;
import com.urbanairship.util.C3946a;
import com.urbanairship.util.C3954i;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class C1711e {
    private final Context f5897a;

    public abstract int mo1052a(PushMessage pushMessage);

    public abstract Notification mo1053a(PushMessage pushMessage, int i);

    public C1711e(Context context) {
        this.f5897a = context.getApplicationContext();
    }

    public Context m8332c() {
        return this.f5897a;
    }

    protected final C0140f m8330b(PushMessage pushMessage, int i) {
        C3872d b = C3929q.m20372a().m20390n().m20307b(pushMessage.m20052k());
        final List arrayList = new ArrayList();
        if (b != null) {
            arrayList.addAll(b.m20079a(m8332c(), pushMessage, i, pushMessage.m20051j()));
        }
        return new C0140f(this) {
            final /* synthetic */ C1711e f13765b;

            public C0138d mo121a(C0138d c0138d) {
                for (C0134a a : arrayList) {
                    c0138d.m633a(a);
                }
                return c0138d;
            }
        };
    }

    protected final C0151r m8333c(PushMessage pushMessage, int i) {
        C0151r c0151r = new C0151r();
        String n = pushMessage.m20055n();
        if (n == null) {
            return c0151r;
        }
        try {
            C3788b g = JsonValue.m19740b(n).m19756g();
            String a = g.m19782c("interactive_type").m19747a();
            n = g.m19782c("interactive_actions").toString();
            if (C3954i.m20512a(n)) {
                n = pushMessage.m20051j();
            }
            if (!C3954i.m20512a(a)) {
                C3872d b = C3929q.m20372a().m20390n().m20307b(a);
                if (b != null) {
                    c0151r.m678a(b.m20079a(m8332c(), pushMessage, i, n));
                }
            }
            n = g.m19782c("background_image").m19747a();
            if (!C3954i.m20512a(n)) {
                try {
                    c0151r.m677a(m8324a(new URL(n)));
                } catch (Throwable e) {
                    C3783j.m19726c("Wearable background url is malformed.", e);
                }
            }
            Iterator it = g.m19782c("extra_pages").m19753d().iterator();
            while (it.hasNext()) {
                JsonValue jsonValue = (JsonValue) it.next();
                if (jsonValue.m19764o()) {
                    c0151r.m676a(m8323a(jsonValue.m19756g()));
                }
            }
            return c0151r;
        } catch (Throwable e2) {
            C3783j.m19726c("Failed to parse wearable payload.", e2);
            return c0151r;
        }
    }

    protected final C0135q m8331b(PushMessage pushMessage) {
        String o = pushMessage.m20056o();
        if (o == null) {
            return null;
        }
        try {
            C3788b g = JsonValue.m19740b(o).m19756g();
            String a = g.m19782c(ShareConstants.MEDIA_TYPE).m19748a("");
            Object obj = -1;
            switch (a.hashCode()) {
                case 100344454:
                    if (a.equals("inbox")) {
                        obj = 1;
                        break;
                    }
                    break;
                case 735420684:
                    if (a.equals("big_text")) {
                        obj = null;
                        break;
                    }
                    break;
                case 1129611455:
                    if (a.equals("big_picture")) {
                        obj = 2;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                    return m8325b(g);
                case 1:
                    return m8327d(g);
                case 2:
                    return m8326c(g);
                default:
                    return null;
            }
        } catch (Throwable e) {
            C3783j.m19726c("Failed to parse notification style payload.", e);
            return null;
        }
    }

    private Notification m8323a(C3788b c3788b) {
        C0135q c0137c = new C0137c();
        CharSequence a = c3788b.m19782c(ShareConstants.WEB_DIALOG_PARAM_TITLE).m19747a();
        if (!C3954i.m20512a(a)) {
            c0137c.m620a(a);
        }
        a = c3788b.m19782c("alert").m19747a();
        if (!C3954i.m20512a(a)) {
            c0137c.m622c(a);
        }
        return new C0138d(this.f5897a).m646c(true).m635a(c0137c).m639b();
    }

    private C0135q m8325b(C3788b c3788b) {
        C0135q c0137c = new C0137c();
        CharSequence a = c3788b.m19782c(ShareConstants.WEB_DIALOG_PARAM_TITLE).m19747a();
        CharSequence a2 = c3788b.m19782c("summary").m19747a();
        CharSequence a3 = c3788b.m19782c("big_text").m19747a();
        if (!C3954i.m20512a(a3)) {
            c0137c.m622c(a3);
        }
        if (!C3954i.m20512a(a)) {
            c0137c.m620a(a);
        }
        if (!C3954i.m20512a(a2)) {
            c0137c.m621b(a2);
        }
        return c0137c;
    }

    private C0136b m8326c(C3788b c3788b) {
        C0136b c0136b = new C0136b();
        CharSequence a = c3788b.m19782c(ShareConstants.WEB_DIALOG_PARAM_TITLE).m19747a();
        CharSequence a2 = c3788b.m19782c("summary").m19747a();
        try {
            URL url = new URL(c3788b.m19782c("big_picture").m19748a(""));
            if (m8324a(url) == null) {
                C3783j.m19728e("Failed to create big picture style, unable to fetch image: " + url);
                return null;
            }
            c0136b.m617a(m8324a(url));
            if (!C3954i.m20512a(a)) {
                c0136b.m618a(a);
            }
            if (!C3954i.m20512a(a2)) {
                c0136b.m619b(a2);
            }
            return c0136b;
        } catch (Throwable e) {
            C3783j.m19726c("Malformed big picture URL.", e);
            return null;
        }
    }

    private C0141g m8327d(C3788b c3788b) {
        C0141g c0141g = new C0141g();
        CharSequence a = c3788b.m19782c(ShareConstants.WEB_DIALOG_PARAM_TITLE).m19747a();
        CharSequence a2 = c3788b.m19782c("summary").m19747a();
        Iterator it = c3788b.m19782c("lines").m19753d().iterator();
        while (it.hasNext()) {
            CharSequence a3 = ((JsonValue) it.next()).m19747a();
            if (C3954i.m20512a(a3)) {
                c0141g.m656c(a3);
            }
        }
        if (!C3954i.m20512a(a)) {
            c0141g.m654a(a);
        }
        if (!C3954i.m20512a(a2)) {
            c0141g.m655b(a2);
        }
        return c0141g;
    }

    protected final Notification m8334d(PushMessage pushMessage, int i) {
        if (!C3954i.m20512a(pushMessage.m20060s())) {
            try {
                C3788b g = JsonValue.m19740b(pushMessage.m20060s()).m19756g();
                C0138d a = new C0138d(m8332c()).m636a(g.m19782c(ShareConstants.WEB_DIALOG_PARAM_TITLE).m19748a("")).m642b(g.m19782c("alert").m19748a("")).m646c(true).m626a(i);
                if (g.m19779a("summary")) {
                    a.m645c(g.m19782c("summary").m19748a(""));
                }
                return a.m639b();
            } catch (Throwable e) {
                C3783j.m19726c("Failed to parse public notification.", e);
            }
        }
        return null;
    }

    private Bitmap m8324a(URL url) {
        if (url == null) {
            return null;
        }
        C3783j.m19727d("Fetching notification image at URL: " + url);
        WindowManager windowManager = (WindowManager) this.f5897a.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return C3946a.m20488a(this.f5897a, url, (int) (((double) Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels)) * 0.75d), (int) TypedValue.applyDimension(1, BitmapDescriptorFactory.HUE_BLUE, displayMetrics));
    }
}
