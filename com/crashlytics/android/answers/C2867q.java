package com.crashlytics.android.answers;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.crashlytics.android.answers.C2853g.C2852a;
import io.fabric.sdk.android.C2822h;
import io.fabric.sdk.android.C3962a;
import io.fabric.sdk.android.C3969c;
import io.fabric.sdk.android.services.common.C4008l;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.network.C4045c;
import io.fabric.sdk.android.services.network.C4046b;
import io.fabric.sdk.android.services.p057c.C3988b;
import io.fabric.sdk.android.services.settings.C4051b;
import java.util.concurrent.ScheduledExecutorService;

class C2867q implements C2852a {
    final C2845b f9872a;
    final C3962a f9873b;
    final C2853g f9874c;
    final C2848e f9875d;
    private final long f9876e;

    public static C2867q m16108a(C2822h c2822h, Context context, IdManager idManager, String str, String str2, long j) {
        C2871u c2871u = new C2871u(context, idManager, str, str2);
        C2846c c2846c = new C2846c(context, new C3988b(c2822h));
        C4045c c4046b = new C4046b(C3969c.m20576h());
        C3962a c3962a = new C3962a(context);
        ScheduledExecutorService b = C4008l.m20782b("Answers Events Handler");
        C2853g c2853g = new C2853g(b);
        return new C2867q(new C2845b(c2822h, context, c2846c, c2871u, c4046b, b), c3962a, c2853g, C2848e.m16048a(context), j);
    }

    C2867q(C2845b c2845b, C3962a c3962a, C2853g c2853g, C2848e c2848e, long j) {
        this.f9872a = c2845b;
        this.f9873b = c3962a;
        this.f9874c = c2853g;
        this.f9875d = c2848e;
        this.f9876e = j;
    }

    public void m16114b() {
        this.f9872a.m16036b();
        this.f9873b.m20532a(new C2847d(this, this.f9874c));
        this.f9874c.m16058a((C2852a) this);
        if (m16116d()) {
            m16110a(this.f9876e);
            this.f9875d.m16049a();
        }
    }

    public void m16115c() {
        this.f9873b.m20531a();
        this.f9872a.m16031a();
    }

    public void m16113a(String str, String str2) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("onCrash called from main thread!!!");
        }
        C3969c.m20576h().mo2849a("Answers", "Logged crash");
        this.f9872a.m16039c(SessionEvent.m16016a(str, str2));
    }

    public void m16110a(long j) {
        C3969c.m20576h().mo2849a("Answers", "Logged install");
        this.f9872a.m16037b(SessionEvent.m16013a(j));
    }

    public void m16111a(Activity activity, Type type) {
        C3969c.m20576h().mo2849a("Answers", "Logged lifecycle event: " + type.name());
        this.f9872a.m16032a(SessionEvent.m16014a(type, activity));
    }

    public void mo1452a() {
        C3969c.m20576h().mo2849a("Answers", "Flush events when app is backgrounded");
        this.f9872a.m16038c();
    }

    public void m16112a(C4051b c4051b, String str) {
        this.f9874c.m16059a(c4051b.f14276h);
        this.f9872a.m16034a(c4051b, str);
    }

    boolean m16116d() {
        return !this.f9875d.m16050b();
    }
}
