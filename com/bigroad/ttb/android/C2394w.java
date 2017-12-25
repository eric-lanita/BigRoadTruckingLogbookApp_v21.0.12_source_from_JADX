package com.bigroad.ttb.android;

import android.app.AlarmManager;
import android.content.Context;
import com.bigroad.shared.ap;
import com.bigroad.ttb.android.eobr.EobrManager;
import com.bigroad.ttb.android.eobr.turbo.C1976f;
import com.bigroad.ttb.android.event.EventManager;
import com.bigroad.ttb.android.location.C2122b;
import com.bigroad.ttb.android.location.LocationTracker;
import com.bigroad.ttb.android.notification.C2208c;
import com.bigroad.ttb.android.p029c.C1736b;
import com.bigroad.ttb.android.p035d.C1790a;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager;

public class C2394w implements C2032f {
    public ag mo1293a() {
        return OurApplication.m6282d();
    }

    public C2081g mo1294b() {
        return OurApplication.m6284f();
    }

    public C2474y mo1295c() {
        return OurApplication.m6285g();
    }

    public PowerStatus mo1296d() {
        return OurApplication.m6286h();
    }

    public C1790a mo1297e() {
        return OurApplication.m6287i();
    }

    public SyncManager mo1298f() {
        return OurApplication.m6289k();
    }

    public C2230r mo1299g() {
        return OurApplication.m6292n();
    }

    public TruckManager mo1300h() {
        return OurApplication.m6294p();
    }

    public EventManager mo1301i() {
        return OurApplication.m6295q();
    }

    public C1736b mo1302j() {
        return OurApplication.m6296r();
    }

    public C2208c mo1303k() {
        return OurApplication.m6300v();
    }

    public LocationTracker mo1304l() {
        return OurApplication.m6302x();
    }

    public C2122b mo1305m() {
        return OurApplication.m6303y();
    }

    public C2222o mo1306n() {
        return OurApplication.m6304z();
    }

    public C2104l mo1307o() {
        return OurApplication.m6245B();
    }

    public AuthMonitor mo1308p() {
        return OurApplication.m6249F();
    }

    public BluetoothMonitor mo1309q() {
        return OurApplication.m6250G();
    }

    public EobrManager mo1310r() {
        return OurApplication.m6251H();
    }

    public VehicleConnectionManager mo1311s() {
        return OurApplication.m6252I();
    }

    public ClockMonitor mo1312t() {
        return OurApplication.m6262S();
    }

    public C1976f mo1313u() {
        return OurApplication.m6264U();
    }

    public ap mo1314v() {
        return OurApplication.m6269Z();
    }

    public ad mo1315w() {
        return OurApplication.ab();
    }

    public ak mo1316x() {
        return OurApplication.ag();
    }

    public DrivingModeManager mo1317y() {
        return OurApplication.ah();
    }

    public aj mo1318z() {
        return OurApplication.ai();
    }

    public AlarmManager mo1292a(Context context) {
        return (AlarmManager) context.getSystemService("alarm");
    }
}
