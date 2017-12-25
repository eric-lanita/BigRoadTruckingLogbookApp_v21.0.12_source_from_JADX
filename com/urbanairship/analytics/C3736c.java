package com.urbanairship.analytics;

import com.urbanairship.C3783j;
import com.urbanairship.C3796l;
import com.urbanairship.json.C3684c;

class C3736c {
    private final C3796l f13413a;

    C3736c(C3796l c3796l) {
        this.f13413a = c3796l;
    }

    int m19469a() {
        return this.f13413a.m19807a("com.urbanairship.analytics.MAX_TOTAL_DB_SIZE", 5242880);
    }

    void m19470a(int i) {
        this.f13413a.m19817b("com.urbanairship.analytics.MAX_TOTAL_DB_SIZE", i);
    }

    int m19473b() {
        return this.f13413a.m19807a("com.urbanairship.analytics.MAX_BATCH_SIZE", 512000);
    }

    void m19474b(int i) {
        this.f13413a.m19817b("com.urbanairship.analytics.MAX_BATCH_SIZE", i);
    }

    int m19476c() {
        return this.f13413a.m19807a("com.urbanairship.analytics.MAX_WAIT", 1209600000);
    }

    void m19477c(int i) {
        this.f13413a.m19817b("com.urbanairship.analytics.MAX_WAIT", i);
    }

    int m19478d() {
        return this.f13413a.m19807a("com.urbanairship.analytics.MIN_BATCH_INTERVAL", 60000);
    }

    void m19479d(int i) {
        this.f13413a.m19817b("com.urbanairship.analytics.MIN_BATCH_INTERVAL", i);
    }

    long m19480e() {
        return this.f13413a.m19808a("com.urbanairship.analytics.LAST_SEND", 0);
    }

    void m19471a(long j) {
        this.f13413a.m19818b("com.urbanairship.analytics.LAST_SEND", j);
    }

    long m19481f() {
        return this.f13413a.m19808a("com.urbanairship.analytics.SCHEDULED_SEND_TIME", 0);
    }

    void m19475b(long j) {
        this.f13413a.m19818b("com.urbanairship.analytics.SCHEDULED_SEND_TIME", j);
    }

    boolean m19482g() {
        return this.f13413a.m19815a("com.urbanairship.analytics.ANALYTICS_ENABLED", true);
    }

    void m19472a(C3741g c3741g) {
        if (c3741g != null) {
            this.f13413a.m19814a("com.urbanairship.analytics.ASSOCIATED_IDENTIFIERS", (C3684c) c3741g);
        } else {
            this.f13413a.m19816b("com.urbanairship.analytics.ASSOCIATED_IDENTIFIERS");
        }
    }

    boolean m19483h() {
        return this.f13413a.m19815a("com.urbanairship.analytics.ADVERTISING_ID_TRACKING", false);
    }

    C3741g m19484i() {
        try {
            return C3741g.m19506a(this.f13413a.m19810a("com.urbanairship.analytics.ASSOCIATED_IDENTIFIERS", null));
        } catch (Throwable e) {
            C3783j.m19724b("Unable to parse associated identifiers.", e);
            this.f13413a.m19816b("com.urbanairship.analytics.ASSOCIATED_IDENTIFIERS");
            return new C3741g();
        }
    }
}
