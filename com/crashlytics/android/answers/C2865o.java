package com.crashlytics.android.answers;

import android.content.Context;
import io.fabric.sdk.android.services.common.C4004j;
import io.fabric.sdk.android.services.p046b.C2864b;
import io.fabric.sdk.android.services.p046b.C3983c;
import io.fabric.sdk.android.services.settings.C4051b;
import java.util.UUID;

class C2865o extends C2864b<SessionEvent> {
    private C4051b f9870g;

    C2865o(Context context, C2870t c2870t, C4004j c4004j, C3983c c3983c) {
        super(context, c2870t, c4004j, c3983c, 100);
    }

    protected String mo1449a() {
        return "sa" + "_" + UUID.randomUUID().toString() + "_" + this.c.mo2882a() + ".tap";
    }

    protected int mo1450b() {
        return this.f9870g == null ? super.mo1450b() : this.f9870g.f14273e;
    }

    protected int mo1451c() {
        return this.f9870g == null ? super.mo1451c() : this.f9870g.f14271c;
    }

    void m16104a(C4051b c4051b) {
        this.f9870g = c4051b;
    }
}
