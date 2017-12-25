package com.bigroad.ttb.android;

import android.app.Activity;
import android.content.Context;
import com.bigroad.shared.am;
import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.ttb.android.C2474y.C1183b;
import com.bigroad.ttb.android.adapter.DutyStatusAdapter.DutyStatusChoice;
import com.bigroad.ttb.android.logging.C2126a;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders.EventBuilder;
import com.google.android.gms.analytics.Tracker;

public class ag {
    private static ag f5886a = null;
    private final GoogleAnalytics f5887b;
    private final Tracker f5888c = this.f5887b.newTracker((int) R.xml.analytics);

    class C17001 extends C1183b {
        final /* synthetic */ ag f5885a;

        C17001(ag agVar) {
            this.f5885a = agVar;
        }

        public void mo865b(C2474y c2474y) {
            this.f5885a.f5887b.setDryRun(c2474y.m12156A());
        }
    }

    public static synchronized ag m8285a(Context context) {
        ag agVar;
        synchronized (ag.class) {
            if (f5886a == null) {
                f5886a = new ag(context);
            }
            agVar = f5886a;
        }
        return agVar;
    }

    private ag(Context context) {
        this.f5887b = GoogleAnalytics.getInstance(context);
        this.f5887b.setLogger(new C2126a());
        this.f5887b.setDryRun(OurApplication.m6285g().m12156A());
        OurApplication.m6285g().m12184a(new C17001(this));
    }

    private void m8289a(String str, String str2, String str3, Long l) {
        EventBuilder eventBuilder = new EventBuilder(str, str2);
        if (!am.m4188a((CharSequence) str3)) {
            eventBuilder.setLabel(str3);
        }
        if (l != null) {
            eventBuilder.setValue(l.longValue());
        }
        this.f5888c.send(eventBuilder.build());
    }

    private void m8288a(String str, String str2, String str3) {
        m8289a(str, str2, str3, null);
    }

    private void m8287a(String str, String str2) {
        m8289a(str, str2, null, null);
    }

    public void m8296a(String str) {
        m8288a("Launcher", "Launch app", str);
    }

    public void m8290a() {
        m8287a("Check-in", "Send check-in");
    }

    public void m8297b() {
        m8287a("Share Log", "Share log");
    }

    public void m8300c() {
        m8288a("Share Log", "Print log", "ATTEMPT");
    }

    public void m8302d() {
        m8288a("Share Log", "Fax log", "ATTEMPT");
    }

    public void m8299b(String str) {
        m8288a("Share Log", "Print log", str);
    }

    public void m8291a(int i) {
        m8289a("Documents", "Share document", null, Long.valueOf((long) i));
    }

    public void m8303e() {
        m8287a("Share BigRoad", "Share SMS");
    }

    public void m8304f() {
        m8287a("Share BigRoad", "Share email");
    }

    public void m8305g() {
        m8287a("Share BigRoad", "Share Twitter");
    }

    public void m8306h() {
        m8287a("Share BigRoad", "Like BigRoad");
    }

    public void m8294a(DutyStatus dutyStatus, String str) {
        String str2;
        if (dutyStatus == null) {
            str2 = "null";
        } else {
            str2 = dutyStatus.toString();
        }
        m8288a("Duty Status", "Change-" + str, str2);
    }

    public void m8295a(DutyStatusChoice dutyStatusChoice, String str) {
        m8288a("Duty Status", "Change-" + str, dutyStatusChoice.toString());
    }

    public void m8293a(DutyStatus dutyStatus) {
        m8288a("Duty Status", "Canceled automatic", dutyStatus.toString());
    }

    public void m8301c(String str) {
        m8288a("Map", "Set map mode", str);
    }

    public void m8307i() {
        m8287a("Learn More", "Learn more - help bubble");
    }

    public void m8308j() {
        m8287a("Learn More", "Learn more - DashLink screen");
    }

    public void m8309k() {
        m8287a("Learn More", "CTA icon");
    }

    public void m8292a(Activity activity) {
        this.f5887b.reportActivityStart(activity);
    }

    public void m8298b(Activity activity) {
        this.f5887b.reportActivityStop(activity);
    }
}
