package com.bigroad.ttb.android.util;

import com.bigroad.shared.C1129n;
import com.bigroad.shared.DutyStatusChangeBits;
import com.bigroad.shared.DutyStatusChangeBits.Reason;
import com.bigroad.shared.UserAuthenticationChangeBits;
import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.ad;
import com.bigroad.ttb.android.event.EventManager;
import com.bigroad.ttb.android.event.EventSource;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager;

public class C2287h extends C1129n {
    public static void m11213a(DutyStatus dutyStatus, Reason reason, EventSource eventSource) {
        C2287h.m11214a(dutyStatus, reason, eventSource, false);
    }

    public static void m11214a(DutyStatus dutyStatus, Reason reason, EventSource eventSource, boolean z) {
        EventManager q = OurApplication.m6295q();
        VehicleConnectionManager I = OurApplication.m6252I();
        ad ab = OurApplication.ab();
        if (I.m11411i()) {
            if (z) {
                ab.m8041b();
            }
            q.m10023a(I.m11412j(), dutyStatus, z);
            return;
        }
        q.m10019a(dutyStatus, eventSource, DutyStatusChangeBits.m4033a(reason));
        if (z) {
            ab.m8038a(OurApplication.m6281c(), UserAuthenticationChangeBits.Reason.OFF_DUTY_AND_SIGN_OUT);
        }
    }
}
