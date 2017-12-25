package com.urbanairship.push;

import android.content.Context;
import android.content.Intent;
import com.urbanairship.C3680a;
import com.urbanairship.C3783j;
import com.urbanairship.C3796l;
import com.urbanairship.util.C3954i;
import java.util.UUID;

public class C3883g extends C3680a {
    private final C3796l f13797a;
    private final Context f13798b;
    private final Object f13799c = new Object();

    public C3883g(Context context, C3796l c3796l) {
        this.f13798b = context.getApplicationContext();
        this.f13797a = c3796l;
    }

    protected void mo2777a() {
        m20138f();
        if (m20134b() != null) {
            m20140h();
        }
    }

    public String m20134b() {
        return this.f13797a.m19810a("com.urbanairship.nameduser.NAMED_USER_ID_KEY", null);
    }

    public void m20133a(String str) {
        String str2 = null;
        if (str != null) {
            str2 = str.trim();
            if (C3954i.m20512a(str2) || str2.length() > 128) {
                C3783j.m19728e("Failed to set named user ID. The named user ID must be greater than 0 and less than 129 characters.");
                return;
            }
        }
        synchronized (this.f13799c) {
            boolean equals = m20134b() == null ? str2 == null : m20134b().equals(str2);
            if (!equals || (m20134b() == null && m20136d() == null)) {
                this.f13797a.m19819b("com.urbanairship.nameduser.NAMED_USER_ID_KEY", str2);
                m20131i();
                C3783j.m19725c("NamedUser - Clear pending named user tags.");
                m20139g();
                C3783j.m19725c("NamedUser - Start service to update named user.");
                m20138f();
            } else {
                C3783j.m19725c("NamedUser - Skipping update. Named user ID trimmed already matches existing named user: " + m20134b());
            }
        }
    }

    public C3925n m20135c() {
        return new C3925n("com.urbanairship.push.ACTION_UPDATE_NAMED_USER_TAGS");
    }

    String m20136d() {
        return this.f13797a.m19810a("com.urbanairship.nameduser.CHANGE_TOKEN_KEY", null);
    }

    private void m20131i() {
        this.f13797a.m19819b("com.urbanairship.nameduser.CHANGE_TOKEN_KEY", UUID.randomUUID().toString());
    }

    synchronized void m20137e() {
        if (C3954i.m20513a(m20134b(), null)) {
            m20133a(null);
        }
    }

    void m20138f() {
        this.f13798b.startService(new Intent(this.f13798b, PushService.class).setAction("com.urbanairship.push.ACTION_UPDATE_NAMED_USER"));
    }

    void m20139g() {
        this.f13798b.startService(new Intent(this.f13798b, PushService.class).setAction("com.urbanairship.push.ACTION_CLEAR_PENDING_NAMED_USER_TAGS"));
    }

    void m20140h() {
        this.f13798b.startService(new Intent(this.f13798b, PushService.class).setAction("com.urbanairship.push.ACTION_UPDATE_NAMED_USER_TAGS"));
    }
}
