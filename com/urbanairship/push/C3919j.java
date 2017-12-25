package com.urbanairship.push;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.util.Log;
import com.urbanairship.C3680a;
import com.urbanairship.C3761b;
import com.urbanairship.C3783j;
import com.urbanairship.C3796l;
import com.urbanairship.C3860o.C3859l;
import com.urbanairship.C3929q;
import com.urbanairship.json.JsonValue;
import com.urbanairship.push.C3878c.C3877a;
import com.urbanairship.push.C3922k.C3921a;
import com.urbanairship.push.p033a.C1711e;
import com.urbanairship.push.p033a.C1712a;
import com.urbanairship.push.p033a.C3872d;
import com.urbanairship.util.C3954i;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class C3919j extends C3680a {
    private final String f13904a = "ua_";
    private final String f13905b = "device";
    private C1711e f13906c;
    private final Map<String, C3872d> f13907d = new HashMap();
    private boolean f13908e = true;
    private final C3796l f13909f;
    private final C3761b f13910g;
    private boolean f13911h;
    private final Object f13912i = new Object();

    public C3919j(Context context, C3796l c3796l, C3761b c3761b) {
        this.f13909f = c3796l;
        C1711e c1712a = new C1712a(context);
        c1712a.m8341b(c3761b.f13522v);
        if (c3761b.f13520t != 0) {
            c1712a.m8339a(c3761b.f13520t);
        }
        this.f13906c = c1712a;
        this.f13910g = c3761b;
        this.f13907d.putAll(C3874a.m20081a(context, C3859l.ua_notification_buttons));
        if (VERSION.SDK_INT >= 23) {
            this.f13907d.putAll(C3874a.m20081a(context, C3859l.ua_notification_button_overrides));
        }
    }

    protected void mo2777a() {
        if (C3783j.f13563a < 7 && !C3954i.m20512a(m20329u())) {
            Log.d(C3929q.m20381g() + " Channel ID", m20329u());
        }
        m20334z();
        m20299A();
        boolean z = m20329u() == null && this.f13910g.f13518r;
        this.f13911h = z;
        C3929q.m20382h().startService(new Intent(C3929q.m20382h(), PushService.class).setAction("com.urbanairship.push.ACTION_START_REGISTRATION"));
        if (m20329u() != null) {
            m20331w();
        }
    }

    public boolean m20308b() {
        return this.f13909f.m19815a("com.urbanairship.push.PUSH_ENABLED", true);
    }

    public void m20306a(boolean z) {
        this.f13909f.m19820b("com.urbanairship.push.USER_NOTIFICATIONS_ENABLED", z);
        m20316h();
    }

    public boolean m20310c() {
        return this.f13909f.m19815a("com.urbanairship.push.USER_NOTIFICATIONS_ENABLED", false);
    }

    public void m20301a(C1711e c1711e) {
        this.f13906c = c1711e;
    }

    public C1711e m20311d() {
        return this.f13906c;
    }

    public boolean m20313e() {
        if (m20321m()) {
            switch (C3929q.m20372a().m20399w()) {
                case 1:
                    if (C3954i.m20512a(m20319k())) {
                        return false;
                    }
                    return true;
                case 2:
                    if (C3954i.m20512a(m20332x())) {
                        return false;
                    }
                    return true;
            }
        }
        return false;
    }

    public boolean m20314f() {
        return m20308b() && m20313e() && m20310c();
    }

    C3878c m20315g() {
        C3877a a = new C3877a().m20095a(m20317i()).m20097a(m20320l(), m20318j()).m20096a(m20314f());
        boolean z = m20308b() && m20313e();
        C3877a e = a.m20100b(z).m20102d(C3929q.m20372a().m20391o().m20439b().m20478b()).m20103e(m20333y());
        switch (C3929q.m20372a().m20399w()) {
            case 1:
                e.m20099b("amazon");
                if (m20321m()) {
                    e.m20101c(m20319k());
                    break;
                }
                break;
            case 2:
                e.m20099b("android");
                if (m20321m()) {
                    e.m20101c(m20332x());
                    break;
                }
                break;
        }
        return e.m20098a();
    }

    public void m20316h() {
        Context h = C3929q.m20382h();
        Intent intent = new Intent(h, PushService.class);
        intent.setAction("com.urbanairship.push.ACTION_UPDATE_CHANNEL_REGISTRATION");
        h.startService(intent);
    }

    public void m20305a(Set<String> set) {
        if (set == null) {
            throw new IllegalArgumentException("Tags must be non-null.");
        } else if (m20298b((Set) set)) {
            m20316h();
        }
    }

    private boolean m20298b(Set<String> set) {
        boolean z;
        synchronized (this.f13912i) {
            Object a = C3926o.m20368a((Set) set);
            if (a.equals(m20318j())) {
                z = false;
            } else {
                if (a.isEmpty()) {
                    this.f13909f.m19816b("com.urbanairship.push.TAGS");
                } else {
                    this.f13909f.m19813a("com.urbanairship.push.TAGS", JsonValue.m19732a(a));
                }
                z = true;
            }
        }
        return z;
    }

    public String m20317i() {
        return this.f13909f.m19810a("com.urbanairship.push.ALIAS", null);
    }

    public Set<String> m20318j() {
        Set a;
        synchronized (this.f13912i) {
            Set hashSet = new HashSet();
            JsonValue a2 = this.f13909f.m19809a("com.urbanairship.push.TAGS");
            if (a2.m19765p()) {
                Iterator it = a2.m19752c().iterator();
                while (it.hasNext()) {
                    a2 = (JsonValue) it.next();
                    if (a2.m19758i()) {
                        hashSet.add(a2.m19747a());
                    }
                }
            }
            a = C3926o.m20368a(hashSet);
            if (hashSet.size() != a.size()) {
                m20305a(a);
            }
        }
        return a;
    }

    public String m20319k() {
        return this.f13909f.m19810a("com.urbanairship.push.ADM_REGISTRATION_ID_KEY", null);
    }

    public boolean m20320l() {
        return this.f13908e;
    }

    public boolean m20321m() {
        return this.f13909f.m19815a("com.urbanairship.push.PUSH_TOKEN_REGISTRATION_ENABLED", true);
    }

    public boolean m20322n() {
        return this.f13909f.m19815a("com.urbanairship.push.SOUND_ENABLED", true);
    }

    public boolean m20323o() {
        return this.f13909f.m19815a("com.urbanairship.push.VIBRATE_ENABLED", true);
    }

    public boolean m20324p() {
        return this.f13909f.m19815a("com.urbanairship.push.QUIET_TIME_ENABLED", false);
    }

    public boolean m20325q() {
        if (!m20324p()) {
            return false;
        }
        C3922k a = C3922k.m20345a(this.f13909f.m19810a("com.urbanairship.push.QUIET_TIME_INTERVAL", null));
        if (a == null || !a.m20346a()) {
            return false;
        }
        return true;
    }

    boolean m20326r() {
        return this.f13911h;
    }

    public Date[] m20327s() {
        C3922k a = C3922k.m20345a(this.f13909f.m19810a("com.urbanairship.push.QUIET_TIME_INTERVAL", null));
        if (a != null) {
            return a.m20347b();
        }
        return null;
    }

    public String m20328t() {
        return this.f13909f.m19810a("com.urbanairship.push.LAST_RECEIVED_METADATA", null);
    }

    void m20302a(String str) {
        this.f13909f.m19819b("com.urbanairship.push.LAST_RECEIVED_METADATA", str);
    }

    public void m20304a(Date date, Date date2) {
        this.f13909f.m19813a("com.urbanairship.push.QUIET_TIME_INTERVAL", new C3921a().m20340a(date, date2).m20341a().mo2767e());
    }

    public C3872d m20307b(String str) {
        return (C3872d) this.f13907d.get(str);
    }

    public String m20329u() {
        return this.f13909f.m19810a("com.urbanairship.push.CHANNEL_ID", null);
    }

    String m20330v() {
        return this.f13909f.m19810a("com.urbanairship.push.CHANNEL_LOCATION", null);
    }

    void m20303a(String str, String str2) {
        this.f13909f.m19819b("com.urbanairship.push.CHANNEL_ID", str);
        this.f13909f.m19819b("com.urbanairship.push.CHANNEL_LOCATION", str2);
    }

    void m20309c(String str) {
        this.f13909f.m19819b("com.urbanairship.push.ADM_REGISTRATION_ID_KEY", str);
    }

    void m20331w() {
        C3929q.m20382h().startService(new Intent(C3929q.m20382h(), PushService.class).setAction("com.urbanairship.push.ACTION_UPDATE_CHANNEL_TAG_GROUPS"));
    }

    void m20312d(String str) {
        this.f13909f.m19819b("com.urbanairship.push.GCM_INSTANCE_ID_TOKEN_KEY", str);
    }

    public String m20332x() {
        return this.f13909f.m19810a("com.urbanairship.push.GCM_INSTANCE_ID_TOKEN_KEY", null);
    }

    String m20333y() {
        return this.f13909f.m19810a("com.urbanairship.push.APID", null);
    }

    void m20334z() {
        if (!this.f13909f.m19815a("com.urbanairship.push.PUSH_ENABLED_SETTINGS_MIGRATED", false)) {
            C3783j.m19727d("Migrating push enabled preferences");
            boolean a = this.f13909f.m19815a("com.urbanairship.push.PUSH_ENABLED", false);
            C3783j.m19727d("Setting user notifications enabled to " + Boolean.toString(a));
            this.f13909f.m19820b("com.urbanairship.push.USER_NOTIFICATIONS_ENABLED", a);
            if (!a) {
                C3783j.m19727d("Push is now enabled. You can continue to toggle the opt-in state by enabling or disabling user notifications");
            }
            this.f13909f.m19820b("com.urbanairship.push.PUSH_ENABLED", true);
            this.f13909f.m19820b("com.urbanairship.push.PUSH_ENABLED_SETTINGS_MIGRATED", true);
        }
    }

    void m20299A() {
        if (this.f13909f.m19810a("com.urbanairship.push.QUIET_TIME_ENABLED", null) == null) {
            this.f13909f.m19820b("com.urbanairship.push.QUIET_TIME_ENABLED", this.f13909f.m19815a("com.urbanairship.push.QuietTime.Enabled", false));
            this.f13909f.m19816b("com.urbanairship.push.QuietTime.Enabled");
        }
        int a = this.f13909f.m19807a("com.urbanairship.push.QuietTime.START_HOUR", -1);
        int a2 = this.f13909f.m19807a("com.urbanairship.push.QuietTime.START_MINUTE", -1);
        int a3 = this.f13909f.m19807a("com.urbanairship.push.QuietTime.END_HOUR", -1);
        int a4 = this.f13909f.m19807a("com.urbanairship.push.QuietTime.END_MINUTE", -1);
        if (a != -1 && a2 != -1 && a3 != -1 && a4 != -1) {
            C3783j.m19727d("Migrating quiet time interval");
            this.f13909f.m19813a("com.urbanairship.push.QUIET_TIME_INTERVAL", new C3921a().m20339a(a).m20342b(a2).m20343c(a3).m20344d(a4).m20341a().mo2767e());
            this.f13909f.m19816b("com.urbanairship.push.QuietTime.START_HOUR");
            this.f13909f.m19816b("com.urbanairship.push.QuietTime.START_MINUTE");
            this.f13909f.m19816b("com.urbanairship.push.QuietTime.END_HOUR");
            this.f13909f.m19816b("com.urbanairship.push.QuietTime.END_MINUTE");
        }
    }
}
