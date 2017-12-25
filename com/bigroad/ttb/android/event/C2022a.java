package com.bigroad.ttb.android.event;

import com.bigroad.shared.C1130o;
import com.bigroad.shared.C1144s;
import com.bigroad.shared.C1180y;
import com.bigroad.shared.DrivingModeChangeBits;
import com.bigroad.shared.DutyStatusChangeBits;
import com.bigroad.shared.EventStatusMaskBits;
import com.bigroad.shared.EventStatusMaskBits.RecordOrigin;
import com.bigroad.shared.EventStatusMaskBits.RecordStatus;
import com.bigroad.shared.UserAuthenticationChangeBits;
import com.bigroad.shared.UserAuthenticationChangeBits.Reason;
import com.bigroad.shared.aj;
import com.bigroad.shared.am;
import com.bigroad.shared.ar;
import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.shared.eobr.EobrType;
import com.bigroad.shared.eobr.turbo.C1015l;
import com.bigroad.shared.model.CanonicalOdometerUnit;
import com.bigroad.ttb.android.C2032f;
import com.bigroad.ttb.android.TruckManager;
import com.bigroad.ttb.android.eobr.EobrDevice;
import com.bigroad.ttb.android.location.Location;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.model.C2177b;
import com.bigroad.ttb.android.util.C2297q;
import com.bigroad.ttb.android.vehicle.C2364g;
import com.bigroad.ttb.android.vehicle.C2369i;
import com.bigroad.ttb.android.vehicle.C2371k;
import com.bigroad.ttb.protocol.TTProtocol.ActiveDrivingMode;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.Event.C2647a;
import com.bigroad.ttb.protocol.TTProtocol.EventShare;
import com.bigroad.ttb.protocol.TTProtocol.EventType;
import com.bigroad.ttb.protocol.TTProtocol.OdometerOffsets;
import com.bigroad.ttb.protocol.TTProtocol.OdometerUnit;
import com.bigroad.ttb.protocol.TTProtocol.RelativeTimestamp;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import com.facebook.internal.NativeProtocol;
import com.google.protobuf.C3642c;
import java.util.ArrayList;
import java.util.List;

public abstract class C2022a {
    private static void m10090a(C2647a c2647a, EobrDevice eobrDevice) {
        if (eobrDevice != null && eobrDevice.mo1121o() == EobrType.GENX) {
            c2647a.m13867d(eobrDevice.mo1119g());
            c2647a.m13825B();
        } else if (eobrDevice != null && eobrDevice.mo1121o() == EobrType.TURBO) {
            c2647a.m13860c(C3642c.m19078a(eobrDevice.m8992d()));
            c2647a.m13833J();
        }
    }

    public static boolean m10092a(Event event, EobrDevice eobrDevice) {
        if (eobrDevice == null || event == null) {
            return false;
        }
        if (eobrDevice.mo1121o() == EobrType.GENX) {
            String g = eobrDevice.mo1119g();
            if (event.hasAssociatedGenxDevice() && am.m4189a(g, event.getAssociatedGenxDevice())) {
                return true;
            }
            return false;
        }
        C3642c a = C3642c.m19078a(eobrDevice.m8992d());
        if (event.hasAssociatedDashLink() && a.equals(event.getAssociatedDashLink())) {
            return true;
        }
        return false;
    }

    public static Event m10085a(EventType eventType, long j, C2032f c2032f) {
        return C2022a.m10084a(eventType, c2032f.mo1314v().mo914b(), c2032f.mo1295c().m12202d(), Long.valueOf(c2032f.mo1300h().m6580g()), c2032f.mo1304l().m10605e(), j, c2032f);
    }

    public static Event m10084a(EventType eventType, long j, long j2, Long l, Location location, long j3, C2032f c2032f) {
        if (DutyStatus.m4390b(eventType)) {
            j3 = DutyStatusChangeBits.m4036a(Long.valueOf(j3), eventType);
        }
        return C2022a.m10071a(c2032f, j2, j, eventType, null, null, l, null, null, location, false, null, null, null, null, Long.valueOf(j3)).m13862c();
    }

    public static Event m10096b(EventType eventType, long j, long j2, Long l, Location location, long j3, C2032f c2032f) {
        if (DutyStatus.m4390b(eventType)) {
            j3 = DutyStatusChangeBits.m4036a(Long.valueOf(j3), eventType);
        }
        C2647a a = C2022a.m10071a(c2032f, j2, j, eventType, null, null, l, null, null, location, false, null, null, null, null, Long.valueOf(j3));
        C2022a.m10091a(a, l, c2032f);
        return a.m13862c();
    }

    public static void m10091a(C2647a c2647a, Long l, C2032f c2032f) {
        Long a = ar.m4234a(l);
        if (a != null) {
            c2647a.m13853b(a.longValue());
            c2647a.m13886j(EventStatusMaskBits.m4071a(c2647a.m13828E(), RecordOrigin.UNKNOWN));
            Truck a2 = c2032f.mo1300h().m6552a(a.longValue());
            if (a2 != null) {
                if (a2.getTruckLogType() == 3 || a2.getTruckLogType() == 2) {
                    c2647a.m13886j(EventStatusMaskBits.m4071a(c2647a.m13828E(), RecordOrigin.MANUAL_ENTRY));
                }
                if (a2.getTruckLogType() == 3 && c2647a.m13895p() && C1130o.m5717b(EventType.m13979a(c2647a.m13896q()))) {
                    c2647a.m13864d((int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
                }
            }
        }
    }

    public static Event m10086a(EventType eventType, String str, RecordOrigin recordOrigin, Long l, long j, String str2, C2369i c2369i, C1015l c1015l, RelativeTimestamp relativeTimestamp, OdometerOffsets odometerOffsets, Long l2, C2364g c2364g, C2032f c2032f) {
        if (l == null) {
            C2134e.m10680d("TT-EventFactory", "NULL personId passed to createEobrEvent; using current person");
            l = Long.valueOf(c2032f.mo1295c().m12202d());
        }
        if (l.longValue() == -1) {
            C2134e.m10682e("TT-EventFactory", "Attempt to create event for invalid person");
            return null;
        }
        byte[] d = c2369i.m11600b().hasDashLinkId() ? c2369i.m11600b().getDashLinkId().m19091d() : null;
        String genxSerialNumber = c2369i.m11600b().hasGenxSerialNumber() ? c2369i.m11600b().getGenxSerialNumber() : null;
        Long d2 = c2369i.m11605d();
        Truck a = C2371k.m11631a(c2032f, c2369i);
        if (d2 == null && a == null) {
            C2134e.m10680d("TT-EventFactory", "VehicleState did not contain a truck, and there's no active truck. Cannot record EOBR " + eventType + " event for person " + l + " at timestamp " + j);
            return null;
        }
        Integer c;
        Long valueOf;
        boolean z;
        if (d2 == null) {
            d2 = Long.valueOf(a.getTruckId());
        }
        if (odometerOffsets == null) {
            c = c2369i.m11602c(c2032f);
        } else {
            c = c2369i.m11595a(odometerOffsets, c2032f);
        }
        Location a2 = Location.m10553a(c2369i.m11607f());
        boolean z2 = false;
        if (DutyStatus.m4390b(eventType)) {
            try {
                DutyStatus a3 = DutyStatus.m4385a(eventType);
                z2 = a3.m4397e();
                valueOf = Long.valueOf(DutyStatusChangeBits.m4036a(l2, a3.m4392a()));
            } catch (IllegalArgumentException e) {
                valueOf = l2;
            }
        } else {
            valueOf = l2;
        }
        if (eventType == EventType.INTERMEDIATE_DRIVING) {
            z = true;
        } else {
            z = z2;
        }
        C2647a a4 = C2022a.m10071a(c2032f, l.longValue(), j, eventType, str, null, d2, c, c2369i.m11601b(c2032f), a2, z, null, d, genxSerialNumber, null, valueOf);
        Long a5 = c2369i.m11623v().m10797a();
        if (a5 != null) {
            a4.m13888k(a5.longValue());
        }
        a5 = c2369i.m11623v().m10798b();
        if (a5 != null) {
            a4.m13890l(a5.longValue());
        }
        if (c2364g != null) {
            c1015l = c2364g.mo1284a(c1015l, relativeTimestamp, j);
        }
        if (c1015l != null) {
            a4.m13884i(c1015l.m5232c());
        }
        if (!am.m4188a((CharSequence) str2)) {
            a4.m13861c(str2);
        }
        String a6 = c2032f.mo1318z().m8384a();
        if (!am.m4188a((CharSequence) a6)) {
            a4.m13872e(a6);
        }
        a6 = c2032f.mo1318z().m8387b();
        if (!am.m4188a((CharSequence) a6)) {
            a4.m13877f(a6);
        }
        a4.m13886j(EventStatusMaskBits.m4071a(a4.m13828E(), recordOrigin));
        if (C1130o.m5714a(a) && C1130o.m5717b(eventType)) {
            a4.m13864d((int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        }
        return a4.m13862c();
    }

    public static Event m10087a(EventType eventType, String str, RecordOrigin recordOrigin, Long l, long j, String str2, C2369i c2369i, Long l2, C2032f c2032f) {
        return C2022a.m10086a(eventType, str, recordOrigin, l, j, str2, c2369i, null, null, null, l2, null, c2032f);
    }

    private static C2647a m10071a(C2032f c2032f, long j, long j2, EventType eventType, String str, String str2, Long l, Integer num, Integer num2, Location location, boolean z, Long l2, byte[] bArr, String str3, List<EventShare> list, Long l3) {
        C2647a a = C2022a.m10070a(c2032f, j2, j, eventType);
        Long a2 = ar.m4234a(l);
        if (a2 != null) {
            a.m13853b(a2.longValue());
        }
        if (num != null) {
            a.m13869e(num.intValue());
            if (num2 != null) {
                a.m13874f(num.intValue() - num2.intValue());
            }
        }
        if (location != null) {
            a.m13852b(location.m10555b()).m13858c(location.m10556c());
            if (location.m10557d()) {
                a.m13841a(location.m10558e().floatValue());
            }
        }
        if (!am.m4188a((CharSequence) str)) {
            a.m13849a(str);
        }
        if (!am.m4188a((CharSequence) str2)) {
            a.m13856b(str2);
        }
        if (z) {
            a.m13850a(true);
        }
        if (l2 != null) {
            a.m13875f(l2.longValue());
        }
        if (bArr != null) {
            a.m13860c(C3642c.m19078a(bArr));
        }
        if (str3 != null) {
            a.m13867d(str3);
        }
        if (list != null) {
            a.mo1377a((Iterable) list);
        }
        if (l3 != null) {
            a.m13879g(l3.longValue());
        }
        a.m13886j(EventStatusMaskBits.m4076a(RecordStatus.ACTIVE));
        return a;
    }

    private static C2647a m10070a(C2032f c2032f, long j, long j2, EventType eventType) {
        C2647a c = Event.newBuilder().m13846a(C3642c.m19078a(aj.m4179a())).m13843a(j2).m13842a(eventType.m13980a()).m13859c(j);
        byte[] a = c2032f.mo1295c().m12191a();
        if (a != null) {
            c.m13855b(C3642c.m19078a(a));
        }
        return c;
    }

    public static Event m10078a(C2032f c2032f, Location location, String str, List<EventShare> list) {
        Truck f = c2032f.mo1300h().m6578f();
        return C2022a.m10071a(c2032f, c2032f.mo1295c().m12202d(), c2032f.mo1314v().mo914b(), EventType.CHECK_IN, null, str, ar.m4239c(f), C2022a.m10088a(c2032f, f), null, location, false, null, null, null, list, null).m13862c();
    }

    public static Event m10082a(C2032f c2032f, String str, List<EventShare> list) {
        Truck f = c2032f.mo1300h().m6578f();
        return C2022a.m10071a(c2032f, c2032f.mo1295c().m12202d(), c2032f.mo1314v().mo914b(), EventType.USER_NOTE, null, str, ar.m4239c(f), C2022a.m10088a(c2032f, f), null, c2032f.mo1304l().m10605e(), false, null, null, null, list, null).m13862c();
    }

    private static Event m10080a(C2032f c2032f, EventType eventType, Long l) {
        return C2022a.m10071a(c2032f, c2032f.mo1295c().m12202d(), c2032f.mo1314v().mo914b(), eventType, null, null, ar.m4239c(c2032f.mo1300h().m6578f()), null, null, c2032f.mo1304l().m10605e(), false, null, null, null, null, l).m13862c();
    }

    public static Event m10077a(C2032f c2032f, Reason reason) {
        return C2022a.m10080a(c2032f, EventType.USER_SIGN_IN, Long.valueOf(UserAuthenticationChangeBits.m4102a(reason)));
    }

    public static Event m10094b(C2032f c2032f, Reason reason) {
        return C2022a.m10080a(c2032f, EventType.USER_SIGN_OUT, Long.valueOf(UserAuthenticationChangeBits.m4102a(reason)));
    }

    public static Event m10073a(C2032f c2032f) {
        return C2022a.m10080a(c2032f, EventType.CHANGE_ACTIVE_TRUCK, null);
    }

    public static Event m10079a(C2032f c2032f, ActiveDrivingMode activeDrivingMode, DrivingModeChangeBits.Reason reason, EobrDevice eobrDevice) {
        C2647a newBuilder = Event.newBuilder(C2022a.m10080a(c2032f, EventType.DRIVING_MODE, Long.valueOf(DrivingModeChangeBits.m4031a(reason, activeDrivingMode))));
        C2022a.m10090a(newBuilder, eobrDevice);
        return newBuilder.m13862c();
    }

    public static Event m10074a(C2032f c2032f, long j) {
        return C2022a.m10080a(c2032f, EventType.CLOCK_SKEW, Long.valueOf(j));
    }

    public static Event m10093b(C2032f c2032f, long j) {
        return C2022a.m10080a(c2032f, EventType.DEVICE_STATUS, Long.valueOf(j));
    }

    public static Event m10076a(C2032f c2032f, long j, long j2, EobrDevice eobrDevice) {
        Truck f = c2032f.mo1300h().m6578f();
        C2032f c2032f2 = c2032f;
        long j3 = j;
        C2647a a = C2022a.m10071a(c2032f2, c2032f.mo1295c().m12202d(), j3, EventType.DASH_LINK_STATUS, null, null, ar.m4239c(f), C2022a.m10088a(c2032f, f), null, c2032f.mo1304l().m10605e(), false, null, null, null, null, Long.valueOf(j2));
        C2022a.m10090a(a, eobrDevice);
        return a.m13862c();
    }

    public static List<Event> m10089a(C2032f c2032f, int i, int i2, OdometerUnit odometerUnit, OdometerUnit odometerUnit2, byte[] bArr) {
        long d = c2032f.mo1295c().m12202d();
        long b = c2032f.mo1314v().mo914b();
        Location e = c2032f.mo1304l().m10605e();
        Long c = ar.m4239c(c2032f.mo1300h().m6578f());
        C2647a a = C2022a.m10071a(c2032f, d, b, EventType.ODOMETER_ADJUSTMENT, "ODOMETER_ADJUSTMENT_BEFORE", null, c, Integer.valueOf(i), null, e, false, null, bArr, null, null, Long.valueOf((long) odometerUnit.m14669a()));
        C2647a a2 = C2022a.m10071a(c2032f, d, b, EventType.ODOMETER_ADJUSTMENT, "ODOMETER_ADJUSTMENT_AFTER", null, c, Integer.valueOf(i2), null, e, false, null, bArr, null, null, Long.valueOf((long) odometerUnit2.m14669a()));
        List<Event> arrayList = new ArrayList(2);
        arrayList.add(a.m13856b(C1180y.m5989a(a2.m13889k())).m13862c());
        arrayList.add(a2.m13856b(C1180y.m5989a(a.m13889k())).m13862c());
        return arrayList;
    }

    public static Event m10081a(C2032f c2032f, Truck truck, byte[] bArr) {
        if (truck == null) {
            return null;
        }
        C3642c firmwareOdometerAssociatedDashLink = truck.getFirmwareOdometerAssociatedDashLink();
        if (bArr == null || (firmwareOdometerAssociatedDashLink != null && firmwareOdometerAssociatedDashLink.equals(C3642c.m19078a(bArr)))) {
            return null;
        }
        if (bArr.length != 6) {
            C2134e.m10680d("TT-EventFactory", "Firmware IDs should be exactly 6 characters (switched): " + C1180y.m5996c(bArr));
            return null;
        }
        return C2022a.m10071a(c2032f, c2032f.mo1295c().m12202d(), c2032f.mo1314v().mo914b(), EventType.ODOMETER_ADJUSTMENT, "SWITCHED_FIRMWARE_ODOMETER", null, Long.valueOf(truck.getTruckId()), C2022a.m10088a(c2032f, truck), null, c2032f.mo1304l().m10605e(), false, null, bArr, null, null, null).m13862c();
    }

    public static Event m10095b(C2032f c2032f, Truck truck, byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length != 6) {
            C2134e.m10680d("TT-EventFactory", "Firmware IDs should be exactly 6 characters (cleared): " + C1180y.m5996c(bArr));
            return null;
        }
        Long c = ar.m4239c(truck);
        return C2022a.m10071a(c2032f, c2032f.mo1295c().m12202d(), c2032f.mo1314v().mo914b(), EventType.ODOMETER_ADJUSTMENT, "CLEARED_FIRMWARE_ODOMETER", null, c, C2022a.m10088a(c2032f, truck), null, c2032f.mo1304l().m10605e(), false, null, bArr, null, null, null).m13862c();
    }

    public static Event m10075a(C2032f c2032f, long j, long j2, long j3) {
        Truck f = c2032f.mo1300h().m6578f();
        return C2022a.m10071a(c2032f, c2032f.mo1295c().m12202d(), j, EventType.APP_DOWNTIME, null, null, ar.m4239c(f), C2022a.m10088a(c2032f, f), null, c2032f.mo1304l().m10605e(), false, Long.valueOf(j2), null, null, null, Long.valueOf(j3)).m13862c();
    }

    private static Integer m10088a(C2032f c2032f, Truck truck) {
        if (truck != null) {
            C2177b l = c2032f.mo1311s().m11414l();
            if (l != null) {
                return Integer.valueOf(l.m10801a(truck));
            }
        }
        return null;
    }

    public static Event m10072a(TruckManager truckManager, Event event, Event event2) {
        if (event == null) {
            C2134e.m10680d("TT-EventFactory", "Could not extend driving event; event is null.");
            return null;
        } else if (!DutyStatus.m4391c(event)) {
            C2134e.m10680d("TT-EventFactory", "Could not extend driving event; not a driving event.");
            return null;
        } else if (event.getPersonId() != event2.getPersonId()) {
            C2134e.m10680d("TT-EventFactory", "Could not extend driving event; personId not equivalent");
            return null;
        } else if (!C1144s.m5762b(event, event2)) {
            C2134e.m10680d("TT-EventFactory", "Could not extend driving event; dash link not equal.");
            return null;
        } else if (!event.hasTruckId() || !event2.hasTruckId() || event.getTruckId() != event2.getTruckId()) {
            C2134e.m10680d("TT-EventFactory", "Could not extend driving event; associated truck differs.");
            return null;
        } else if (event2.getOccurredAt() < event.getOccurredAt()) {
            C2134e.m10680d("TT-EventFactory", "Could not extend driving event; events out of order.");
            return null;
        } else {
            Truck a = truckManager.m6552a(event.getTruckId());
            if (a == null) {
                C2134e.m10680d("TT-EventFactory", "Could not extend driving event; missing truck.");
                return null;
            }
            C2647a f = Event.newBuilder(event).m13875f(event2.getOccurredAt() - event.getOccurredAt());
            if (event.hasOdometer() && event2.hasOdometer() && event2.getOdometer() >= event.getOdometer()) {
                long round = Math.round(CanonicalOdometerUnit.m5466a(OdometerUnit.m14668a(a.getOdometerUnit())).m5469a((long) (event2.getOdometer() - event.getOdometer())));
                if (!f.m13826C() || f.m13827D() < round) {
                    f.m13882h(round);
                }
            } else {
                C2134e.m10680d("TT-EventFactory", "Could not extend driving event; odometer is missing or malformed");
            }
            return f.m13862c();
        }
    }

    public static Event m10083a(Event event, Event event2) {
        if (event.getEventType() == event2.getEventType() && event.getPersonId() == event2.getPersonId()) {
            C2647a newBuilder = Event.newBuilder(event);
            if (event2.hasLatitudeE6() && event2.hasLongitudeE6() && !newBuilder.m13898s() && !newBuilder.m13899t()) {
                newBuilder.m13852b(event2.getLatitudeE6());
                newBuilder.m13858c(event2.getLongitudeE6());
                if (event2.hasAccuracy() && !newBuilder.m13900u()) {
                    newBuilder.m13841a(event2.getAccuracy());
                }
            }
            if (event2.hasLocationName() && !newBuilder.m13902w()) {
                newBuilder.m13861c(event2.getLocationName());
            }
            if (event2.hasNotes() && !newBuilder.m13901v()) {
                newBuilder.m13856b(event2.getNotes());
            }
            return newBuilder.m13862c();
        }
        C2134e.m10680d("TT-EventFactory", "Unexpected event mismatch from handleCoalesceEvent");
        C2134e.m10678c("TT-EventFactory", "IN: " + C2297q.m11245a(event2));
        C2134e.m10678c("TT-EventFactory", "EXISTING: " + C2297q.m11245a(event));
        return null;
    }
}
