package com.bigroad.shared.model;

import com.bigroad.ttb.protocol.TTProtocol.DailyLogTruck;
import com.bigroad.ttb.protocol.TTProtocol.OdometerUnit;
import com.bigroad.ttb.protocol.TTProtocol.TruckLogType;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import java.util.List;

public class C1118e extends C1107b {
    public static final Function<DailyLogTruck, C1118e> f3750a = new C11171();
    private final Integer f3751b;
    private final Integer f3752c;
    private final Integer f3753d;

    static class C11171 implements Function<DailyLogTruck, C1118e> {
        C11171() {
        }

        public /* synthetic */ Object apply(Object obj) {
            return m5675a((DailyLogTruck) obj);
        }

        public C1118e m5675a(DailyLogTruck dailyLogTruck) {
            return C1118e.m5676a(dailyLogTruck);
        }
    }

    public C1118e(String str, String str2, Integer num, Integer num2, Integer num3, CanonicalOdometerUnit canonicalOdometerUnit) {
        super(TruckLogType.ELECTRONIC, str, str2, canonicalOdometerUnit);
        this.f3751b = num;
        this.f3752c = num2;
        this.f3753d = num3;
    }

    public Integer mo779f() {
        return this.f3751b;
    }

    public Integer mo780g() {
        return this.f3752c;
    }

    public Integer mo781i() {
        return this.f3753d;
    }

    public static C1118e m5676a(DailyLogTruck dailyLogTruck) {
        String truckLicense;
        Integer valueOf;
        Integer valueOf2;
        Integer valueOf3;
        CanonicalOdometerUnit canonicalOdometerUnit = null;
        String truckNumber = dailyLogTruck.getTruckNumber();
        if (dailyLogTruck.hasTruckLicense()) {
            truckLicense = dailyLogTruck.getTruckLicense();
        } else {
            truckLicense = null;
        }
        if (dailyLogTruck.hasStartOdometer()) {
            valueOf = Integer.valueOf(dailyLogTruck.getStartOdometer());
        } else {
            valueOf = null;
        }
        if (dailyLogTruck.hasEndOdometer()) {
            valueOf2 = Integer.valueOf(dailyLogTruck.getEndOdometer());
        } else {
            valueOf2 = null;
        }
        if (dailyLogTruck.hasDistance()) {
            valueOf3 = Integer.valueOf(dailyLogTruck.getDistance());
        } else {
            valueOf3 = null;
        }
        if (dailyLogTruck.hasOdometerUnit()) {
            canonicalOdometerUnit = CanonicalOdometerUnit.m5466a(OdometerUnit.m14668a(dailyLogTruck.getOdometerUnit()));
        }
        return new C1118e(truckNumber, truckLicense, valueOf, valueOf2, valueOf3, canonicalOdometerUnit);
    }

    public static List<C1118e> m5677a(List<DailyLogTruck> list) {
        return Lists.m18641a((List) list, f3750a);
    }
}
