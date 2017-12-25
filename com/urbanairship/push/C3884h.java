package com.urbanairship.push;

import com.urbanairship.C3783j;
import com.urbanairship.C3929q;
import com.urbanairship.json.C3788b;
import com.urbanairship.p055b.C3757b;
import com.urbanairship.p055b.C3760c;
import java.net.URL;

class C3884h {
    protected final String f13800a;
    private final C3757b f13801b;

    C3884h() {
        this(new C3757b());
    }

    C3884h(C3757b c3757b) {
        this.f13801b = c3757b;
        this.f13800a = C3929q.m20372a().m20388l().f13505e + "api/named_users";
    }

    C3760c m20143a(String str, String str2) {
        C3788b a = C3788b.m19777a().m19774a("channel_id", str2).m19774a("device_type", m20144a()).m19774a("named_user_id", str).m19776a();
        try {
            return m20141a(new URL(this.f13800a + "/associate"), a.toString());
        } catch (Throwable e) {
            C3783j.m19726c("Invalid hostURL", e);
            return null;
        }
    }

    C3760c m20142a(String str) {
        C3788b a = C3788b.m19777a().m19774a("channel_id", str).m19774a("device_type", m20144a()).m19776a();
        try {
            return m20141a(new URL(this.f13800a + "/disassociate"), a.toString());
        } catch (Throwable e) {
            C3783j.m19726c("Invalid hostURL", e);
            return null;
        }
    }

    private C3760c m20141a(URL url, String str) {
        C3760c a = this.f13801b.m19648a("POST", url).m19643a(C3929q.m20372a().m20388l().m19664a(), C3929q.m20372a().m20388l().m19666b()).m19646b(str, "application/json").m19647c("Accept", "application/vnd.urbanairship+json; version=3;").m19645a();
        if (a == null) {
            C3783j.m19728e("Failed to receive a response for named user.");
        } else {
            C3783j.m19725c("Received a response for named user: " + a);
        }
        return a;
    }

    String m20144a() {
        switch (C3929q.m20372a().m20399w()) {
            case 1:
                return "amazon";
            case 2:
                return "android";
            default:
                return null;
        }
    }
}
