package com.bigroad.ttb.android;

import android.app.Activity;
import android.app.Notification;
import android.content.Context;
import android.support.v4.app.ad.C0135q;
import android.support.v4.app.ad.C0138d;
import com.bigroad.shared.am;
import com.bigroad.shared.ap;
import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.ttb.android.AuthMonitor.AuthStatus;
import com.bigroad.ttb.android.AuthMonitor.C1185a;
import com.bigroad.ttb.android.C2222o.C1702a;
import com.bigroad.ttb.android.C2222o.C1703b;
import com.bigroad.ttb.android.C2230r.C1331a;
import com.bigroad.ttb.android.C2230r.C1332b;
import com.bigroad.ttb.android.C2474y.C1182a;
import com.bigroad.ttb.android.C2474y.C1183b;
import com.bigroad.ttb.android.activity.DashboardActivity;
import com.bigroad.ttb.android.activity.HosSummaryActivity;
import com.bigroad.ttb.android.ak.C1536a;
import com.bigroad.ttb.android.ak.C1722b;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.protocol.TTProtocol.Fleet;
import com.bigroad.ttb.protocol.TTProtocol.FleetMembership;
import com.bigroad.ttb.protocol.TTProtocol.Person;
import com.facebook.internal.ServerProtocol;
import com.urbanairship.C3929q;
import com.urbanairship.push.C3883g;
import com.urbanairship.push.PushMessage;
import com.urbanairship.push.iam.C3909c.C1707a;
import com.urbanairship.push.iam.InAppMessage;
import com.urbanairship.push.iam.InAppMessage.C3887a;
import com.urbanairship.push.iam.InAppMessageFragment;
import com.urbanairship.push.p033a.C1712a;
import java.util.HashSet;
import java.util.Set;

public class ah {
    private static ah f5905a;
    private final C2081g f5906b;
    private final AuthMonitor f5907c;
    private final C2222o f5908d;
    private final C2230r f5909e;
    private final C2474y f5910f;
    private final ap f5911g;
    private final ak f5912h;
    private final C3929q f5913i = C3929q.m20372a();
    private DutyStatus f5914j = null;
    private InAppMessage f5915k = null;
    private long f5916l = 0;
    private C1185a f5917m = new C17011(this);
    private C1702a f5918n = new C17042(this);
    private C1331a f5919o = new C17053(this);
    private C1182a f5920p = new C17064(this);
    private C1707a f5921q = new C17085(this);
    private C1536a f5922r = new C17096(this);

    class C17011 implements C1185a {
        final /* synthetic */ ah f5889a;

        C17011(ah ahVar) {
            this.f5889a = ahVar;
        }

        public void mo912a(AuthStatus authStatus) {
            switch (authStatus) {
                case SIGNED_IN:
                    this.f5889a.m8348b();
                    return;
                case SIGNED_OUT:
                    this.f5889a.m8357h();
                    return;
                default:
                    return;
            }
        }
    }

    class C17042 extends C1703b {
        final /* synthetic */ ah f5890a;

        C17042(ah ahVar) {
            this.f5890a = ahVar;
        }

        public void mo1049a(DutyStatus dutyStatus) {
            this.f5890a.f5914j = dutyStatus;
            this.f5890a.m8359a();
        }
    }

    class C17053 extends C1332b {
        final /* synthetic */ ah f5891a;

        C17053(ah ahVar) {
            this.f5891a = ahVar;
        }

        public void mo954a(C2230r c2230r) {
            this.f5891a.m8348b();
        }

        public void mo955b(C2230r c2230r) {
            this.f5891a.m8348b();
        }
    }

    class C17064 extends C1183b {
        final /* synthetic */ ah f5892a;

        C17064(ah ahVar) {
            this.f5892a = ahVar;
        }

        public void mo868e(C2474y c2474y) {
            this.f5892a.m8348b();
        }

        public void mo867d(C2474y c2474y) {
            this.f5892a.m8348b();
        }
    }

    class C17085 implements C1707a {
        final /* synthetic */ ah f5893a;

        C17085(ah ahVar) {
            this.f5893a = ahVar;
        }

        public void mo1050a(InAppMessage inAppMessage) {
            this.f5893a.m8359a();
        }

        public void mo1051a(InAppMessageFragment inAppMessageFragment, InAppMessage inAppMessage) {
            this.f5893a.f5916l = this.f5893a.f5911g.mo913a();
        }
    }

    class C17096 implements C1536a {
        final /* synthetic */ ah f5894a;

        C17096(ah ahVar) {
            this.f5894a = ahVar;
        }

        public void mo1011a(C1722b c1722b) {
            this.f5894a.m8359a();
        }
    }

    private class C1713a extends C1712a {
        final /* synthetic */ ah f5904a;

        C1713a(ah ahVar, Context context) {
            this.f5904a = ahVar;
            super(context);
        }

        public Notification mo1053a(PushMessage pushMessage, int i) {
            if (this.f5904a.f5906b.m10447a()) {
                return null;
            }
            return super.mo1053a(pushMessage, i);
        }

        protected C0138d mo1054a(PushMessage pushMessage, int i, C0135q c0135q) {
            return super.mo1054a(pushMessage, i, c0135q).m644c(1).m626a((int) R.drawable.status_notification_icon).m627a(m8332c().getResources().getColor(R.color.brand), 1000, 5000).m648d(m8332c().getResources().getColor(R.color.brand));
        }
    }

    public static ah m8346a(Context context, C2032f c2032f) {
        if (f5905a == null) {
            f5905a = new ah(context, c2032f);
        }
        return f5905a;
    }

    private ah(Context context, C2032f c2032f) {
        this.f5906b = c2032f.mo1294b();
        this.f5907c = c2032f.mo1308p();
        this.f5908d = c2032f.mo1306n();
        this.f5909e = c2032f.mo1299g();
        this.f5910f = c2032f.mo1295c();
        this.f5911g = c2032f.mo1314v();
        this.f5912h = c2032f.mo1316x();
        this.f5913i.m20390n().m20306a(true);
        this.f5913i.m20390n().m20301a(new C1713a(this, context));
        this.f5913i.m20393q().m20261a(this.f5921q);
        this.f5913i.m20393q().m20262a(false);
        C2134e.m10678c("TT-UrbanAirshipManager", "Channel ID: " + this.f5913i.m20390n().m20329u());
        this.f5907c.m6027a(this.f5917m);
        this.f5908d.m10957a(this.f5918n);
        this.f5909e.m11009a(this.f5919o);
        this.f5910f.m12184a(this.f5920p);
        this.f5912h.m8424a(this.f5922r);
        m8348b();
    }

    private void m8348b() {
        if (this.f5907c.m6031d()) {
            m8351c();
            m8353d();
            m8354e();
            m8355f();
            m8356g();
        }
    }

    private void m8351c() {
        Person l = this.f5910f.m12222l();
        if (l != null) {
            this.f5913i.m20389m().m20133a(l.getEmailAddress());
            C2134e.m10676b("TT-UrbanAirshipManager", "Updated named user: " + this.f5913i.m20389m().m20134b());
        }
    }

    private void m8353d() {
        String str;
        if (this.f5909e.m11013b() == null) {
            str = "free";
        } else if (this.f5910f.m12219i()) {
            str = "trial";
        } else {
            str = "non-free-non-trial";
        }
        this.f5913i.m20389m().m20135c().m20362a("subscription-state", str).m20364a();
        C2134e.m10676b("TT-UrbanAirshipManager", "Updated subscription tags: " + str);
    }

    private void m8354e() {
        Fleet b = this.f5909e.m11013b();
        if (b != null) {
            if (!am.m4188a(b.getCountry())) {
                this.f5913i.m20389m().m20135c().m20362a("country", b.getCountry()).m20364a();
                C2134e.m10676b("TT-UrbanAirshipManager", "Updated country tags: " + b.getCountry());
            }
            if (!am.m4188a(b.getState())) {
                this.f5913i.m20389m().m20135c().m20362a(ServerProtocol.DIALOG_PARAM_STATE, b.getState()).m20364a();
                C2134e.m10676b("TT-UrbanAirshipManager", "Updated state tags: " + b.getState());
            }
        }
    }

    private void m8355f() {
        FleetMembership u = this.f5910f.m12231u();
        if (u != null) {
            Set hashSet = new HashSet();
            if (u.getIsDriver()) {
                hashSet.add("driver");
            }
            if (u.getIsDispatcher()) {
                hashSet.add("dispatcher");
            }
            if (u.getIsAdmin()) {
                hashSet.add("admin");
            }
            if (u.getIsSafetyManager()) {
                hashSet.add("safety-manager");
            }
            if (!hashSet.isEmpty()) {
                this.f5913i.m20389m().m20135c().m20363a("fleet-role", hashSet).m20364a();
                C2134e.m10676b("TT-UrbanAirshipManager", "Updated roles: " + am.m4187a(", ", hashSet));
            }
        }
    }

    private void m8356g() {
        Person l = this.f5910f.m12222l();
        if (l != null && l.hasMarketingPersona()) {
            String str = null;
            switch (l.getMarketingPersona()) {
                case DRIVER:
                    str = "driver";
                    break;
                case OWNER_OPERATOR:
                    str = "owner-operator";
                    break;
                case DISPATCHER:
                    str = "dispatcher";
                    break;
                case SAFETY_MANAGER:
                    str = "safety-manager";
                    break;
                case FLEET_OWNER_EXECUTIVE:
                    str = "fleet-owner-or-executive";
                    break;
                case FLEET_MANAGER:
                    str = "fleet-manager";
                    break;
                case DRIVER_TRAINER:
                    str = "driver-trainer";
                    break;
                case LAW_ENFORCEMENT:
                    str = "law-enforcement";
                    break;
                case OTHER_NON_DRIVER:
                    str = "other-non-driver";
                    break;
            }
            if (str != null) {
                this.f5913i.m20389m().m20135c().m20362a("persona", str).m20364a();
                C2134e.m10676b("TT-UrbanAirshipManager", "Updated persona: " + str);
            }
        }
    }

    private void m8357h() {
        C3883g m = this.f5913i.m20389m();
        if (m != null) {
            m.m20133a(null);
        }
    }

    private boolean m8358i() {
        return this.f5915k != null && this.f5915k.m20192h() != null && this.f5916l > 0 && this.f5911g.mo913a() - this.f5916l < this.f5915k.m20192h().longValue();
    }

    public void m8359a() {
        if (!m8358i()) {
            if ((this.f5914j == null || !this.f5914j.m4397e()) && !this.f5912h.m8421a().m8398a()) {
                this.f5916l = 0;
                this.f5915k = this.f5913i.m20393q().m20270d();
                if (this.f5915k != null) {
                    Activity c = this.f5906b.m10451c();
                    if ((c instanceof HosSummaryActivity) || (c instanceof DashboardActivity)) {
                        this.f5913i.m20393q().m20263a(c);
                        return;
                    }
                    this.f5915k = new C3887a(this.f5915k).m20168b(Long.valueOf(15000)).m20166a();
                    this.f5913i.m20393q().m20260a(this.f5915k);
                }
            }
        }
    }
}
