package com.bigroad.ttb.android.vehicle.p041b;

import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.shared.eobr.turbo.logs.C1024d;
import com.bigroad.ttb.android.C2032f;
import com.bigroad.ttb.android.C2188n;
import com.bigroad.ttb.android.vehicle.C2369i;
import com.bigroad.ttb.android.vehicle.C2370j;
import com.bigroad.ttb.android.vehicle.task.C2380a;
import com.bigroad.ttb.android.vehicle.task.C2383d;
import com.bigroad.ttb.android.vehicle.task.DrivingTask;
import com.bigroad.ttb.protocol.TTProtocol.ActiveDrivingMode;
import com.bigroad.ttb.protocol.TTProtocol.VarDutyStatusChange;

public abstract class C2344c {
    public static C2369i m11460a(C2369i c2369i, C1024d c1024d, C2370j c2370j, C2032f c2032f) {
        ActiveDrivingMode activeDrivingMode;
        boolean z;
        ActiveDrivingMode l = c2369i.m11613l();
        boolean m = c2369i.m11614m();
        boolean z2;
        if (c1024d.m5262b()) {
            if (!c2370j.m11630a(DrivingTask.class)) {
                c2370j.m11629a(new C2380a(c2032f));
            }
            VarDutyStatusChange c = c1024d.m5263c();
            if (DutyStatus.m4387b(c.getEventType())) {
                l = C2188n.m10839a(DutyStatus.m4383a(c.getEventType()), c2369i.m11613l());
            }
            z2 = m;
            activeDrivingMode = l;
            z = z2;
        } else if (c1024d.m5264d()) {
            activeDrivingMode = c1024d.m5265e().getActiveDrivingMode();
            z = true;
        } else {
            z2 = m;
            activeDrivingMode = l;
            z = z2;
        }
        if (activeDrivingMode == c2369i.m11613l() && z == c2369i.m11614m()) {
            return c2369i;
        }
        if (z) {
            C2383d.m11687a(c2369i, activeDrivingMode, c2370j, c2032f);
        }
        return C2369i.m11589a(c2369i).m11572a(activeDrivingMode).m11578a(z).m11584c();
    }
}
