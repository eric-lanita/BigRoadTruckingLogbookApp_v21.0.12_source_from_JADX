package com.urbanairship.richpush;

import android.content.Context;
import android.content.Intent;
import com.facebook.AccessToken;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.urbanairship.BaseIntentService.C3676a;
import com.urbanairship.C3783j;
import com.urbanairship.C3796l;
import com.urbanairship.C3929q;
import com.urbanairship.json.C3788b;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonValue;
import com.urbanairship.p055b.C3757b;
import com.urbanairship.p055b.C3760c;
import com.urbanairship.util.C3954i;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class C3945f extends C3676a {
    private final C3929q f14001a;
    private final C3944e f14002b;
    private final C3757b f14003c;

    C3945f(Context context, C3796l c3796l) {
        this(context, c3796l, new C3757b(), C3929q.m20372a());
    }

    C3945f(Context context, C3796l c3796l, C3757b c3757b, C3929q c3929q) {
        super(context, c3796l);
        this.f14003c = c3757b;
        this.f14001a = c3929q;
        this.f14002b = c3929q.m20391o().m20439b();
    }

    protected void mo2820a(Intent intent) {
        if ("com.urbanairship.richpush.USER_UPDATE".equals(intent.getAction())) {
            boolean d;
            if (intent.getBooleanExtra("com.urbanairship.richpush.EXTRA_FORCEFULLY", false)) {
                long a = m19272b().m19808a("com.urbanairship.user.LAST_UPDATE_TIME", 0);
                long currentTimeMillis = System.currentTimeMillis();
                if (a <= currentTimeMillis && a + 86400000 >= currentTimeMillis) {
                    return;
                }
            }
            if (C3944e.m20471a()) {
                d = m20484d();
            } else {
                d = m20483c();
            }
            RichPushUpdateService.m20409a(intent, d);
        }
    }

    private boolean m20483c() {
        String str = null;
        String u = this.f14001a.m20390n().m20329u();
        if (C3954i.m20512a(u)) {
            C3783j.m19725c("UserServiceDelegate - No Channel. User will be created after channel registrations finishes.");
            return false;
        }
        URL a = RichPushUpdateService.m20408a("api/user/", new Object[0]);
        if (a == null) {
            return false;
        }
        u = m20481a(u);
        C3783j.m19723b("UserServiceDelegate - Creating Rich Push user with payload: " + u);
        C3760c a2 = this.f14003c.m19648a("POST", a).m19643a(this.f14001a.m20388l().m19664a(), this.f14001a.m20388l().m19666b()).m19646b(u, "application/json").m19647c("Accept", "application/vnd.urbanairship+json; version=3;").m19645a();
        if (a2 == null || a2.m19659a() != 201) {
            C3783j.m19723b("UserServiceDelegate - Rich Push user creation failed: " + a2);
            return false;
        }
        try {
            C3788b f = JsonValue.m19740b(a2.m19661b()).m19755f();
            if (f != null) {
                u = f.m19780b(AccessToken.USER_ID_KEY).m19747a();
                str = f.m19780b("password").m19747a();
            } else {
                u = null;
            }
            if (C3954i.m20512a(u) || C3954i.m20512a(str)) {
                C3783j.m19728e("UserServiceDelegate - Rich Push user creation failed: " + a2);
                return false;
            }
            C3783j.m19727d("Created Rich Push user: " + u);
            m19272b().m19818b("com.urbanairship.user.LAST_UPDATE_TIME", System.currentTimeMillis());
            m19272b().m19816b("com.urbanairship.user.LAST_MESSAGE_REFRESH_TIME");
            this.f14002b.m20476a(u, str);
            return true;
        } catch (JsonException e) {
            C3783j.m19728e("UserServiceDelegate - Unable to parse Rich Push user response: " + a2);
            return false;
        }
    }

    private boolean m20484d() {
        String u = this.f14001a.m20390n().m20329u();
        if (C3954i.m20512a(u)) {
            C3783j.m19725c("UserServiceDelegate - No Channel. Skipping Rich Push user update.");
            return false;
        }
        URL a = RichPushUpdateService.m20408a("api/user/%s/", this.f14002b.m20478b());
        if (a == null) {
            return false;
        }
        u = m20482b(u);
        C3783j.m19723b("UserServiceDelegate - Updating user with payload: " + u);
        C3760c a2 = this.f14003c.m19648a("POST", a).m19643a(this.f14002b.m20478b(), this.f14002b.m20480c()).m19646b(u, "application/json").m19647c("Accept", "application/vnd.urbanairship+json; version=3;").m19645a();
        C3783j.m19723b("UserServiceDelegate - Update Rich Push user response: " + a2);
        if (a2 == null || a2.m19659a() != 200) {
            m19272b().m19817b("com.urbanairship.user.LAST_UPDATE_TIME", 0);
            return false;
        }
        C3783j.m19727d("Rich Push user updated.");
        m19272b().m19818b("com.urbanairship.user.LAST_UPDATE_TIME", System.currentTimeMillis());
        return true;
    }

    private String m20481a(String str) {
        Object hashMap = new HashMap();
        hashMap.put(m20485e(), Arrays.asList(new String[]{str}));
        return JsonValue.m19732a(hashMap).toString();
    }

    private String m20482b(String str) {
        Map hashMap = new HashMap();
        hashMap.put(ProductAction.ACTION_ADD, Arrays.asList(new String[]{str}));
        Object hashMap2 = new HashMap();
        hashMap2.put(m20485e(), hashMap);
        return JsonValue.m19732a(hashMap2).toString();
    }

    private String m20485e() {
        switch (this.f14001a.m20399w()) {
            case 1:
                return "amazon_channels";
            default:
                return "android_channels";
        }
    }
}
