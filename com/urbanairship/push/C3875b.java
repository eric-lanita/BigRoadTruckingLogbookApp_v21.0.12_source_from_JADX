package com.urbanairship.push;

import com.urbanairship.C3783j;
import com.urbanairship.C3929q;
import com.urbanairship.p055b.C3757b;
import com.urbanairship.p055b.C3760c;
import java.net.URL;

class C3875b {
    protected URL f13766a;
    private final C3757b f13767b;

    C3875b() {
        this(new C3757b());
    }

    C3875b(C3757b c3757b) {
        this.f13767b = c3757b;
        try {
            this.f13766a = new URL(C3929q.m20372a().m20388l().f13505e + "api/channels/");
        } catch (Throwable e) {
            this.f13766a = null;
            C3783j.m19726c("ChannelApiClient - Invalid hostURL    ", e);
        }
    }

    C3760c m20084a(C3878c c3878c) {
        String jsonValue = c3878c.mo2767e().toString();
        C3783j.m19723b("ChannelApiClient - Creating channel with payload: " + jsonValue);
        return m20083a(this.f13766a, "POST", jsonValue);
    }

    C3760c m20085a(URL url, C3878c c3878c) {
        String jsonValue = c3878c.mo2767e().toString();
        C3783j.m19723b("ChannelApiClient - Updating channel with payload: " + jsonValue);
        return m20083a(url, "PUT", jsonValue);
    }

    private C3760c m20083a(URL url, String str, String str2) {
        C3760c a = this.f13767b.m19648a(str, url).m19643a(C3929q.m20372a().m20388l().m19664a(), C3929q.m20372a().m20388l().m19666b()).m19646b(str2, "application/json").m19647c("Accept", "application/vnd.urbanairship+json; version=3;").m19645a();
        if (a == null) {
            C3783j.m19725c("ChannelApiClient - Failed to receive channel response.");
            return null;
        }
        C3783j.m19723b("ChannelApiClient - Received channel response: " + a);
        return a;
    }
}
