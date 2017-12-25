package com.bigroad.ttb.android.p029c;

import com.bigroad.shared.am;
import com.bigroad.shared.ar;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.TruckManager;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog.C2582a;
import com.bigroad.ttb.protocol.TTProtocol.DailyLogTruck;
import com.bigroad.ttb.protocol.TTProtocol.DailyLogTruck.C2602a;
import com.bigroad.ttb.protocol.TTProtocol.DailyLogTruckList;
import com.bigroad.ttb.protocol.TTProtocol.DvirInspection;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import java.util.ArrayList;

class C1730a {
    public static DailyLog m8452a(DailyLog dailyLog, DvirInspection dvirInspection) {
        if (dailyLog == null) {
            return null;
        }
        TruckManager p = OurApplication.m6294p();
        Truck c = p.m6572c(dvirInspection.getVehicleNumber());
        if (c == null) {
            p.m6553a(dvirInspection.getVehicleNumber(), dvirInspection.getVehicleLicense());
        }
        Iterable arrayList = new ArrayList(dailyLog.getDailyLogTruckList().getDailyLogTruckList());
        int i = -1;
        Object obj = null;
        int size = arrayList.size() - 1;
        while (size >= 0) {
            DailyLogTruck dailyLogTruck = (DailyLogTruck) arrayList.get(size);
            if (am.m4189a(dvirInspection.getVehicleNumber(), dailyLogTruck.getTruckNumber())) {
                obj = 1;
                if (!dvirInspection.hasOdometer()) {
                    break;
                } else if ((!dailyLogTruck.hasStartOdometer() || dailyLogTruck.getStartOdometer() != dvirInspection.getOdometer()) && (!dailyLogTruck.hasEndOdometer() || dailyLogTruck.getEndOdometer() != dvirInspection.getOdometer())) {
                    if (!(dailyLogTruck.hasStartOdometer() || dailyLogTruck.hasEndOdometer()) || (!dailyLogTruck.hasEndOdometer() && dailyLogTruck.hasStartOdometer() && dailyLogTruck.getStartOdometer() < dvirInspection.getOdometer())) {
                        i = size;
                        break;
                    }
                } else {
                    return null;
                }
            }
            size--;
            obj = obj;
        }
        C2602a newBuilder;
        if (i >= 0) {
            newBuilder = DailyLogTruck.newBuilder((DailyLogTruck) arrayList.get(i));
            if (!newBuilder.m13329e() && !newBuilder.m13336l()) {
                newBuilder.m13316a(dvirInspection.getOdometer());
            } else if (!newBuilder.m13336l()) {
                newBuilder.m13321b(dvirInspection.getOdometer());
                ar.m4237a(newBuilder);
                arrayList.set(i, newBuilder.m13325c());
            }
        } else if (obj != null) {
            return null;
        } else {
            newBuilder = DailyLogTruck.newBuilder().m13319a(dvirInspection.getVehicleNumber());
            if (dvirInspection.hasOdometer()) {
                newBuilder.m13316a(dvirInspection.getOdometer());
            }
            if (dvirInspection.hasVehicleLicense()) {
                newBuilder.m13322b(dvirInspection.getVehicleLicense());
            }
            if (c != null && c.hasOdometerUnit()) {
                newBuilder.m13327d(c.getOdometerUnit());
            }
            arrayList.add(newBuilder.m13325c());
        }
        C2582a a = DailyLog.newBuilder(dailyLog).m13025C().m13047a(DailyLogTruckList.newBuilder().mo1377a(arrayList));
        ar.m4236a(a);
        return a.m13069c();
    }
}
