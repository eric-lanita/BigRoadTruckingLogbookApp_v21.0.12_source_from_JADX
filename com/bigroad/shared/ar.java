package com.bigroad.shared;

import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.shared.model.C1108a;
import com.bigroad.shared.model.C1118e;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog.C2582a;
import com.bigroad.ttb.protocol.TTProtocol.DailyLogTruck.C2602a;
import com.bigroad.ttb.protocol.TTProtocol.OdometerUnit;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import java.util.Collections;
import java.util.List;

public class ar {
    public static String m4235a(Truck truck) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(truck.getTruckNumber());
        if (!am.m4188a(truck.getTruckLicense())) {
            stringBuilder.append(" (Lic. ");
            stringBuilder.append(truck.getTruckLicense());
            stringBuilder.append(")");
        }
        return stringBuilder.toString();
    }

    public static boolean m4238b(Truck truck) {
        return (truck.hasIsHidden() && truck.getIsHidden()) ? false : true;
    }

    public static void m4237a(C2602a c2602a) {
        if (c2602a.m13329e() && c2602a.m13336l()) {
            int m = c2602a.m13337m() - c2602a.m13335k();
            if (m > 0) {
                c2602a.m13324c(m);
            } else {
                c2602a.m13338n();
            }
        }
    }

    public static void m4236a(C2582a c2582a) {
        List emptyList = Collections.emptyList();
        if (c2582a.m13023A() && c2582a.m13024B().getDailyLogTruckCount() > 0) {
            emptyList = C1118e.m5677a(c2582a.m13024B().getDailyLogTruckList());
        }
        DailyLogUtils.m4300a(DailyLogUtils.m4290a(c2582a.m13026D() ? OdometerUnit.m14668a(c2582a.m13027E()) : null, emptyList, C1108a.m5498a(c2582a.m13033K()), Collections.emptyList()), c2582a);
    }

    public static Long m4239c(Truck truck) {
        return truck == null ? null : m4234a(Long.valueOf(truck.getTruckId()));
    }

    public static Long m4234a(Long l) {
        return (l == null || l.longValue() == -2) ? null : l;
    }
}
