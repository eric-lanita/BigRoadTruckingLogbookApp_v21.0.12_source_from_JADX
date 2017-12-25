package com.bigroad.ttb.android;

import android.app.Activity;
import android.support.v4.app.C0202r;
import android.support.v4.app.Fragment;
import com.bigroad.shared.am;
import com.bigroad.shared.eobr.ConnectionFlag;
import com.bigroad.ttb.android.C2081g.C1230a;
import com.bigroad.ttb.android.C2081g.C1231b;
import com.bigroad.ttb.android.activity.OurActivity;
import com.bigroad.ttb.android.dialog.UnassignedDrivingDialogFragment;
import com.bigroad.ttb.android.eobr.EobrDevice;
import com.bigroad.ttb.android.event.EventManager;
import com.bigroad.ttb.android.vehicle.C2338a;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager.C1201a;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager.ChangeListener;
import com.bigroad.ttb.protocol.TTProtocol.MotionType;

public class UnassignedDrivingMonitor {
    private static UnassignedDrivingMonitor f4274c;
    private C1230a f4275a = new C12511(this);
    private ChangeListener f4276b = new C12522(this);
    private C2032f f4277d;
    private C2081g f4278e;
    private EventManager f4279f;
    private VehicleConnectionManager f4280g;
    private String f4281h = null;
    private NotificationState f4282i = NotificationState.IDLE;

    class C12511 extends C1231b {
        final /* synthetic */ UnassignedDrivingMonitor f4268a;

        C12511(UnassignedDrivingMonitor unassignedDrivingMonitor) {
            this.f4268a = unassignedDrivingMonitor;
        }

        public void mo906a(C2081g c2081g) {
            this.f4268a.m6593a();
        }
    }

    class C12522 extends C1201a {
        final /* synthetic */ UnassignedDrivingMonitor f4269a;

        C12522(UnassignedDrivingMonitor unassignedDrivingMonitor) {
            this.f4269a = unassignedDrivingMonitor;
        }

        public void mo888a(C2338a c2338a) {
            this.f4269a.m6593a();
        }

        public void mo891a(MotionType motionType) {
            this.f4269a.m6593a();
        }
    }

    private enum NotificationState {
        WAITING_FOR_CURRENT,
        WAITING_FOR_NO_MOTION,
        IDLE
    }

    public static UnassignedDrivingMonitor m6592a(C2032f c2032f) {
        if (f4274c == null) {
            f4274c = new UnassignedDrivingMonitor(c2032f);
        }
        return f4274c;
    }

    private UnassignedDrivingMonitor(C2032f c2032f) {
        this.f4277d = c2032f;
        this.f4278e = this.f4277d.mo1294b();
        this.f4279f = this.f4277d.mo1301i();
        this.f4280g = this.f4277d.mo1311s();
        this.f4278e.m10446a(this.f4275a);
        this.f4280g.m11399a(this.f4276b);
    }

    private void m6593a() {
        EobrDevice j = this.f4280g.m11412j();
        if (j == null) {
            this.f4282i = NotificationState.IDLE;
            C2338a d = this.f4280g.m11406d();
            if (!d.m11449a() && !d.m11450a(ConnectionFlag.CONNECTED)) {
                this.f4281h = null;
                return;
            }
            return;
        }
        if (!am.m4189a(j.m8991c(), this.f4281h)) {
            this.f4282i = NotificationState.WAITING_FOR_CURRENT;
        }
        this.f4281h = j.m8991c();
        if (this.f4282i == NotificationState.WAITING_FOR_CURRENT && this.f4280g.m11411i()) {
            this.f4282i = NotificationState.WAITING_FOR_NO_MOTION;
        }
        if (this.f4282i == NotificationState.WAITING_FOR_NO_MOTION && !this.f4280g.m11413k()) {
            Activity c = this.f4278e.m10451c();
            if (c instanceof OurActivity) {
                OurActivity ourActivity = (OurActivity) c;
                if (this.f4279f.m10063m() > 0) {
                    C0202r supportFragmentManager = ourActivity.getSupportFragmentManager();
                    Fragment a = supportFragmentManager.mo149a(UnassignedDrivingDialogFragment.f6277a);
                    if (a instanceof UnassignedDrivingDialogFragment) {
                        ((UnassignedDrivingDialogFragment) a).dismiss();
                    }
                    new UnassignedDrivingDialogFragment().show(supportFragmentManager, UnassignedDrivingDialogFragment.f6277a);
                }
                this.f4282i = NotificationState.IDLE;
            }
        }
    }
}
