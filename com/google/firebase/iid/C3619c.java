package com.google.firebase.iid;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.internal.ShareConstants;
import java.io.IOException;
import java.security.KeyPair;
import java.util.HashMap;
import java.util.Map;

public class C3619c {
    static Map<String, C3619c> f13122a = new HashMap();
    static String f13123f;
    private static C3623f f13124g;
    private static C3622e f13125h;
    Context f13126b;
    KeyPair f13127c;
    String f13128d = "";
    long f13129e;

    protected C3619c(Context context, String str, Bundle bundle) {
        this.f13126b = context.getApplicationContext();
        this.f13128d = str;
    }

    public static synchronized C3619c m18906a(Context context, Bundle bundle) {
        C3619c c3619c;
        synchronized (C3619c.class) {
            String string = bundle == null ? "" : bundle.getString("subtype");
            String str = string == null ? "" : string;
            Context applicationContext = context.getApplicationContext();
            if (f13124g == null) {
                f13124g = new C3623f(applicationContext);
                f13125h = new C3622e(applicationContext);
            }
            f13123f = Integer.toString(FirebaseInstanceId.m18883b(applicationContext));
            c3619c = (C3619c) f13122a.get(str);
            if (c3619c == null) {
                c3619c = new C3619c(applicationContext, str, bundle);
                f13122a.put(str, c3619c);
            }
        }
        return c3619c;
    }

    KeyPair m18907a() {
        if (this.f13127c == null) {
            this.f13127c = f13124g.m18947c(this.f13128d);
        }
        if (this.f13127c == null) {
            this.f13129e = System.currentTimeMillis();
            this.f13127c = f13124g.m18941a(this.f13128d, this.f13129e);
        }
        return this.f13127c;
    }

    public void m18908a(String str, String str2, Bundle bundle) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        f13124g.m18945b(this.f13128d, str, str2);
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("sender", str);
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("subscription", str);
        bundle.putString("delete", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        bundle.putString("X-delete", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        bundle.putString("subtype", "".equals(this.f13128d) ? str : this.f13128d);
        String str3 = "X-subtype";
        if (!"".equals(this.f13128d)) {
            str = this.f13128d;
        }
        bundle.putString(str3, str);
        f13125h.m18932b(f13125h.m18926a(bundle, m18907a()));
    }

    public String m18909b(String str, String str2, Bundle bundle) {
        Object obj = null;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        Object obj2 = 1;
        String a = m18914e() ? null : f13124g.m18940a(this.f13128d, str, str2);
        if (a == null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            if (bundle.getString("ttl") != null) {
                obj2 = null;
            }
            if (!"jwt".equals(bundle.getString(ShareConstants.MEDIA_TYPE))) {
                obj = obj2;
            }
            a = m18912c(str, str2, bundle);
            if (!(a == null || r1 == null)) {
                f13124g.m18943a(this.f13128d, str, str2, a, f13123f);
            }
        }
        return a;
    }

    public void m18910b() {
        this.f13129e = 0;
        f13124g.m18949d(this.f13128d);
        this.f13127c = null;
    }

    public C3623f m18911c() {
        return f13124g;
    }

    public String m18912c(String str, String str2, Bundle bundle) {
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("sender", str);
        String str3 = "".equals(this.f13128d) ? str : this.f13128d;
        if (!bundle.containsKey("legacy.register")) {
            bundle.putString("subscription", str);
            bundle.putString("subtype", str3);
            bundle.putString("X-subscription", str);
            bundle.putString("X-subtype", str3);
        }
        return f13125h.m18932b(f13125h.m18926a(bundle, m18907a()));
    }

    public C3622e m18913d() {
        return f13125h;
    }

    boolean m18914e() {
        String a = f13124g.m18938a("appVersion");
        if (a == null || !a.equals(f13123f)) {
            return true;
        }
        a = f13124g.m18938a("lastToken");
        if (a == null) {
            return true;
        }
        return (System.currentTimeMillis() / 1000) - Long.valueOf(Long.parseLong(a)).longValue() > 604800;
    }
}
