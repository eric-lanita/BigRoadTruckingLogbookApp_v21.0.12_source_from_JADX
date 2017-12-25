package com.bigroad.ttb.android.notification;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import com.bigroad.shared.ap;
import com.bigroad.shared.eobr.ConnectionFlag;
import com.bigroad.shared.eobr.ConnectionSetupFlag;
import com.bigroad.ttb.android.ClockMonitor;
import com.bigroad.ttb.android.ClockMonitor.C1196a;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.C1632a;
import com.bigroad.ttb.android.p030a.C1257b;
import com.bigroad.ttb.android.service.SyncService;
import com.bigroad.ttb.android.status.C2265b;
import com.bigroad.ttb.android.status.p031a.C2241e;
import com.bigroad.ttb.android.status.p031a.C2241e.C1441a;
import com.bigroad.ttb.android.status.p031a.C2242a;
import com.bigroad.ttb.android.vehicle.C2338a;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager.C1201a;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager.ChangeListener;

class C2212e {
    private static C2212e f7654a;
    private final Context f7655b;
    private final int f7656c;
    private final ClockMonitor f7657d = OurApplication.m6262S();
    private final C2242a f7658e = OurApplication.m6253J();
    private final VehicleConnectionManager f7659f = OurApplication.m6252I();
    private final ap f7660g = OurApplication.m6269Z();
    private C2338a f7661h = C2338a.m11444a(this.f7660g);
    private boolean f7662i = false;
    private boolean f7663j = true;
    private final C1196a f7664k = new C22091(this);
    private final C1441a f7665l = new C22102(this);
    private final ChangeListener f7666m = new C22113(this);

    class C22091 implements C1196a {
        final /* synthetic */ C2212e f7651a;

        C22091(C2212e c2212e) {
            this.f7651a = c2212e;
        }

        public void mo1260a(ClockMonitor clockMonitor) {
            this.f7651a.m10912c();
        }
    }

    class C22102 implements C1441a {
        final /* synthetic */ C2212e f7652a;

        C22102(C2212e c2212e) {
            this.f7652a = c2212e;
        }

        public void mo996a(C2241e c2241e) {
            this.f7652a.m10912c();
        }
    }

    class C22113 extends C1201a {
        final /* synthetic */ C2212e f7653a;

        C22113(C2212e c2212e) {
            this.f7653a = c2212e;
        }

        public void mo888a(C2338a c2338a) {
            this.f7653a.m10912c();
        }
    }

    public static C2212e m10906a(Context context) {
        if (f7654a == null) {
            f7654a = new C2212e(context);
        }
        return f7654a;
    }

    private C2212e(Context context) {
        this.f7655b = context;
        this.f7656c = 3;
        this.f7657d.m6099a(this.f7664k);
        this.f7658e.m11048a(this.f7665l);
        this.f7659f.m11399a(this.f7666m);
        m10912c();
    }

    public void m10914a(boolean z) {
        if (z != this.f7663j) {
            this.f7663j = z;
            m10912c();
        }
    }

    private static boolean m10909a(C2338a c2338a) {
        return (c2338a.m11451a(ConnectionSetupFlag.REQUIRED) || c2338a.m11450a(ConnectionFlag.CONNECTED)) ? false : true;
    }

    private PendingIntent m10905a(int i) {
        return PendingIntent.getActivity(this.f7655b, 3, C1632a.m7978c(this.f7655b, i), 268435456);
    }

    private void m10907a(Notification notification) {
        C1257b.m6612a(notification, this.f7655b.getResources().getColor(R.color.brand));
        SyncService.m11033a(true, this.f7656c, notification);
    }

    private void m10910b() {
        int i;
        CharSequence string = this.f7655b.getString(R.string.notification_dashLinkConnectedTitle);
        String str = "";
        C2265b b = this.f7658e.m11064b();
        if (b != null) {
            str = b.m11109b().mo1266d(this.f7655b);
        }
        long a = this.f7660g.mo913a();
        PendingIntent a2 = m10905a(1);
        if (this.f7659f.m11406d().m11449a()) {
            i = R.drawable.ic_dashlink_scanning_good_notification;
        } else {
            i = R.drawable.ic_dashlink_good_notification;
        }
        if (this.f7657d.m6104d()) {
            str = this.f7655b.getString(R.string.customTitle_clockSkewed);
        }
        Builder contentIntent = new Builder(this.f7655b).setDefaults(0).setOngoing(true).setSmallIcon(i).setWhen(a).setContentTitle(string).setContentText(str).setContentIntent(a2);
        C1257b.m6611a(contentIntent, str);
        m10907a(C1257b.m6607a(contentIntent));
    }

    private void m10911b(boolean z) {
        CharSequence string;
        int i;
        int i2 = 0;
        long a = this.f7660g.mo913a();
        if (this.f7663j || this.f7662i) {
            boolean z2;
            string = this.f7655b.getString(R.string.notification_dashLinkMissingTitle);
            C2338a d = this.f7659f.m11406d();
            if (d.m11451a(ConnectionSetupFlag.BACKGROUND_SEARCH_TIMEOUT) || d.m11451a(ConnectionSetupFlag.BACKGROUND_DISCONNECT_TIMEOUT)) {
                z2 = false;
            } else {
                z2 = true;
            }
            i = this.f7662i ? z2 ? R.drawable.ic_dashlink_scanning_bad_notification : R.drawable.ic_dashlink_bad_notification : z2 ? R.drawable.ic_dashlink_scanning_warn_notification : R.drawable.ic_dashlink_warn_notification;
        } else {
            string = this.f7655b.getString(R.string.notification_dashLinkMissingButItsOkayTitle);
            i = R.drawable.ic_dashlink_good_notification;
        }
        String str = "";
        C2265b b = this.f7658e.m11064b();
        if (b != null) {
            str = b.m11109b().mo1266d(this.f7655b);
        }
        Builder contentIntent = new Builder(this.f7655b).setOngoing(true).setLights(-65536, 1000, 5000).setSmallIcon(i).setWhen(a).setContentTitle(string).setContentText(str).setContentIntent(m10905a(1));
        if (z) {
            i2 = 3;
        }
        contentIntent = contentIntent.setDefaults(i2);
        C1257b.m6611a(contentIntent, str);
        m10907a(C1257b.m6607a(contentIntent));
    }

    protected void m10913a() {
        SyncService.m11033a(false, this.f7656c, null);
    }

    private void m10912c() {
        boolean z = true;
        C2338a c2338a = this.f7661h;
        C2338a d = this.f7659f.m11406d();
        boolean a = C2212e.m10909a(c2338a);
        boolean a2 = C2212e.m10909a(d);
        boolean z2 = this.f7662i;
        boolean e = OurApplication.m6254K().m11102e();
        this.f7661h = d;
        this.f7662i = e;
        if (this.f7662i) {
            if (this.f7663j) {
                if (z2) {
                    z = false;
                }
                m10911b(z);
                return;
            }
            m10913a();
        } else if (!d.m11451a(ConnectionSetupFlag.REQUIRED)) {
            m10913a();
        } else if (d.m11450a(ConnectionFlag.CONNECTED)) {
            m10910b();
        } else {
            if (a || !a2) {
                a = false;
            } else {
                a = true;
            }
            if (!(a && this.f7663j)) {
                z = false;
            }
            m10911b(z);
        }
    }
}
