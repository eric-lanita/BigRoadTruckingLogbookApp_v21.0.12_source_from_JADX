package com.urbanairship.analytics;

import com.urbanairship.json.C3788b;

class C3749m extends C3737i {
    private final String f13439a;

    public C3749m(String str) {
        this.f13439a = str;
    }

    public String mo2778a() {
        return "install_attribution";
    }

    protected C3788b mo2779b() {
        return C3788b.m19777a().m19774a("google_play_referrer", this.f13439a).m19776a();
    }
}
