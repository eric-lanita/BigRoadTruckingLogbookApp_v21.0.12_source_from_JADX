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

public interface C2032f {
    AlarmManager mo1292a(Context context);

    ag mo1293a();

    C2081g mo1294b();

    C2474y mo1295c();

    PowerStatus mo1296d();

    C1790a mo1297e();

    SyncManager mo1298f();

    C2230r mo1299g();

    TruckManager mo1300h();

    EventManager mo1301i();

    C1736b mo1302j();

    C2208c mo1303k();

    LocationTracker mo1304l();

    C2122b mo1305m();

    C2222o mo1306n();

    C2104l mo1307o();

    AuthMonitor mo1308p();

    BluetoothMonitor mo1309q();

    EobrManager mo1310r();

    VehicleConnectionManager mo1311s();

    ClockMonitor mo1312t();

    C1976f mo1313u();

    ap mo1314v();

    ad mo1315w();

    ak mo1316x();

    DrivingModeManager mo1317y();

    aj mo1318z();
}
