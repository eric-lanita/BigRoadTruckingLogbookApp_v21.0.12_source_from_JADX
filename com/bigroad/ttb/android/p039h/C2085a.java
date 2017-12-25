package com.bigroad.ttb.android.p039h;

import com.bigroad.shared.am;
import com.bigroad.shared.ap;
import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.shared.duty.C0874m;
import com.bigroad.shared.duty.C0898i;
import com.bigroad.shared.duty.C0956v;
import com.bigroad.shared.gaps.C1080c;
import com.bigroad.shared.gaps.util.C1095b;
import com.bigroad.shared.validation.C1157a;
import com.bigroad.shared.validation.C1177q;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.al;
import java.util.List;

public class C2085a implements C1157a {
    private final ap f7287a;
    private final C0956v f7288b;
    private final List<Event> f7289c;
    private final C1095b f7290d;
    private final C1177q f7291e;

    class C20841 extends C1177q {
        final /* synthetic */ C2085a f7286a;

        C20841(C2085a c2085a) {
            this.f7286a = c2085a;
        }

        public long mo1218c() {
            return this.f7286a.f7287a.mo915c();
        }
    }

    public C2085a() {
        this.f7287a = OurApplication.m6269Z();
        this.f7291e = new C20841(this);
        this.f7288b = OurApplication.m6285g().m12228r();
        this.f7289c = null;
        this.f7290d = new C1095b(new C2088c());
    }

    public C2085a(C2088c c2088c) {
        this.f7287a = OurApplication.m6269Z();
        this.f7291e = new C20841(this);
        this.f7288b = OurApplication.m6285g().m12228r();
        this.f7289c = null;
        this.f7290d = new C1095b(c2088c);
    }

    public C2085a(List<Event> list) {
        this.f7287a = OurApplication.m6269Z();
        this.f7291e = new C20841(this);
        this.f7288b = OurApplication.m6285g().m12228r();
        this.f7289c = list;
        this.f7290d = new C1095b(new C2088c());
    }

    public int mo1219a() {
        return DailyLogUtils.m4284a(this.f7288b.m4879m());
    }

    public String mo1222b() {
        return am.m4185a(OurApplication.m6285g().m12224n());
    }

    public C0874m mo1221a(int i) {
        al b = OurApplication.m6296r().m8480b(i);
        if (b == null) {
            return this.f7288b;
        }
        return new C0956v(b);
    }

    public C0898i mo1220a(long j) {
        List list;
        List g = OurApplication.m6296r().m8493g();
        if (this.f7289c != null) {
            list = this.f7289c;
        } else {
            list = OurApplication.m6295q().m10025b();
        }
        return new C0898i(g, list, j, this.f7288b.m4868b());
    }

    public C1080c mo1223c() {
        return this.f7290d;
    }

    public C1177q mo1224d() {
        return this.f7291e;
    }
}
