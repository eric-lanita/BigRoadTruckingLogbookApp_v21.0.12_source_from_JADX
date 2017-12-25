package com.crashlytics.android.p044a;

import android.annotation.SuppressLint;
import android.content.Context;
import io.fabric.sdk.android.C3969c;
import io.fabric.sdk.android.services.common.C4001g;
import io.fabric.sdk.android.services.common.C4004j;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.common.IdManager.DeviceIdentifierType;
import io.fabric.sdk.android.services.network.C4045c;
import io.fabric.sdk.android.services.p057c.C3989c;
import io.fabric.sdk.android.services.settings.C4055f;
import java.util.concurrent.atomic.AtomicBoolean;

abstract class C2817a implements C2816j {
    private final AtomicBoolean f9742a;
    private final AtomicBoolean f9743b;
    private Context f9744c;
    private C2824c f9745d;
    private IdManager f9746e;
    private C4055f f9747f;
    private C2825d f9748g;
    private C3989c f9749h;
    private C4004j f9750i;
    private C4045c f9751j;
    private long f9752k;

    public C2817a() {
        this(false);
    }

    public C2817a(boolean z) {
        this.f9742a = new AtomicBoolean();
        this.f9752k = 0;
        this.f9743b = new AtomicBoolean(z);
    }

    public void mo1424a(Context context, C2824c c2824c, IdManager idManager, C4055f c4055f, C2825d c2825d, C3989c c3989c, C4004j c4004j, C4045c c4045c) {
        this.f9744c = context;
        this.f9745d = c2824c;
        this.f9746e = idManager;
        this.f9747f = c4055f;
        this.f9748g = c2825d;
        this.f9749h = c3989c;
        this.f9750i = c4004j;
        this.f9751j = c4045c;
        if (m15948b()) {
            m15949c();
        }
    }

    protected boolean m15947a() {
        this.f9743b.set(true);
        return this.f9742a.get();
    }

    boolean m15948b() {
        this.f9742a.set(true);
        return this.f9743b.get();
    }

    @SuppressLint({"CommitPrefEdits"})
    protected void m15949c() {
        synchronized (this.f9749h) {
            if (this.f9749h.mo2878a().contains("last_update_check")) {
                this.f9749h.mo2879a(this.f9749h.mo2880b().remove("last_update_check"));
            }
        }
        long a = this.f9750i.mo2882a();
        long j = ((long) this.f9747f.f14299b) * 1000;
        C3969c.m20576h().mo2849a("Beta", "Check for updates delay: " + j);
        C3969c.m20576h().mo2849a("Beta", "Check for updates last check time: " + m15950d());
        j += m15950d();
        C3969c.m20576h().mo2849a("Beta", "Check for updates current time: " + a + ", next check time: " + j);
        if (a >= j) {
            try {
                m15944e();
            } finally {
                m15945a(a);
            }
        } else {
            C3969c.m20576h().mo2849a("Beta", "Check for updates next check time was not passed");
        }
    }

    private void m15944e() {
        C3969c.m20576h().mo2849a("Beta", "Performing update check");
        new C2827e(this.f9745d, this.f9745d.m15986g(), this.f9747f.f14298a, this.f9751j, new C2829g()).m15996a(new C4001g().m20770a(this.f9744c), (String) this.f9746e.m20742i().get(DeviceIdentifierType.FONT_TOKEN), this.f9748g);
    }

    void m15945a(long j) {
        this.f9752k = j;
    }

    long m15950d() {
        return this.f9752k;
    }
}
