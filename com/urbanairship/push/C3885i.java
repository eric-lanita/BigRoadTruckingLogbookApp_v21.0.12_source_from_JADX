package com.urbanairship.push;

import android.content.Context;
import android.content.Intent;
import com.urbanairship.BaseIntentService.C3676a;
import com.urbanairship.C3783j;
import com.urbanairship.C3796l;
import com.urbanairship.C3929q;
import com.urbanairship.p055b.C3760c;
import com.urbanairship.util.C3952g;
import com.urbanairship.util.C3954i;

class C3885i extends C3676a {
    private final C3884h f13802a;
    private final C3883g f13803b;
    private final C3919j f13804c;

    public C3885i(Context context, C3796l c3796l) {
        this(context, c3796l, new C3884h(), C3929q.m20372a().m20390n(), C3929q.m20372a().m20389m());
    }

    public C3885i(Context context, C3796l c3796l, C3884h c3884h, C3919j c3919j, C3883g c3883g) {
        super(context, c3796l);
        this.f13802a = c3884h;
        this.f13803b = c3883g;
        this.f13804c = c3919j;
    }

    protected void mo2820a(Intent intent) {
        if (intent.getAction().equals("com.urbanairship.push.ACTION_UPDATE_NAMED_USER")) {
            String b = this.f13803b.m20134b();
            String d = this.f13803b.m20136d();
            String a = m19272b().m19810a("com.urbanairship.nameduser.LAST_UPDATED_TOKEN_KEY", null);
            String u = this.f13804c.m20329u();
            if (d != null || a != null) {
                if (d != null && d.equals(a)) {
                    C3783j.m19725c("NamedUserServiceDelegate - Named user already updated. Skipping.");
                } else if (C3954i.m20512a(u)) {
                    C3783j.m19727d("The channel ID does not exist. Will retry when channel ID is available.");
                } else {
                    C3760c a2;
                    if (b == null) {
                        a2 = this.f13802a.m20142a(u);
                    } else {
                        a2 = this.f13802a.m20143a(b, u);
                    }
                    if (a2 == null || C3952g.m20509b(a2.m19659a())) {
                        C3783j.m19727d("Update named user failed, will retry.");
                        m19274d(intent);
                    } else if (C3952g.m20508a(a2.m19659a())) {
                        C3783j.m19727d("Update named user succeeded with status: " + a2.m19659a());
                        m19272b().m19819b("com.urbanairship.nameduser.LAST_UPDATED_TOKEN_KEY", d);
                        this.f13803b.m20140h();
                    } else if (a2.m19659a() == 403) {
                        C3783j.m19727d("Update named user failed with status: " + a2.m19659a() + " This action is not allowed when the app is in server-only mode.");
                    } else {
                        C3783j.m19727d("Update named user failed with status: " + a2.m19659a());
                    }
                }
            }
        }
    }
}
