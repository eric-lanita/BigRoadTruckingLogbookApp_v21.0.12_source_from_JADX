package com.bigroad.shared.validation.p028a;

import com.bigroad.shared.duty.C0956v;
import com.bigroad.shared.model.C0864i;
import com.bigroad.shared.model.C1108a;
import com.bigroad.shared.validation.model.DailyLogTruck;
import com.bigroad.shared.validation.p024b.C1150a;
import com.bigroad.ttb.protocol.TTProtocol;
import com.bigroad.ttb.protocol.TTProtocol.AutoDailyLogTruck;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import com.bigroad.ttb.protocol.TTProtocol.OdometerUnit;
import com.bigroad.ttb.protocol.TTProtocol.al;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class C1151b extends C1150a {
    private final DailyLog f3928a;
    private final C0956v f3929b;
    private final List<DailyLogTruck> f3930c;
    private final List<DailyLogTruck> f3931d;
    private final List<DailyLogTruck> f3932e;
    private final List<String> f3933f;
    private final List<String> f3934g;

    public C1151b(DailyLog dailyLog, C0864i c0864i, long j) {
        this(dailyLog, C1151b.m5822a(dailyLog), C1151b.m5824b(dailyLog), C1151b.m5823a(dailyLog, c0864i, j));
    }

    public static List<DailyLogTruck> m5822a(DailyLog dailyLog) {
        if (!dailyLog.hasDailyLogTruckList()) {
            return Collections.emptyList();
        }
        List<DailyLogTruck> arrayList = new ArrayList();
        for (TTProtocol.DailyLogTruck c1152c : dailyLog.getDailyLogTruckList().getDailyLogTruckList()) {
            arrayList.add(new C1152c(c1152c, dailyLog.getLogDay()));
        }
        return arrayList;
    }

    public static List<DailyLogTruck> m5824b(DailyLog dailyLog) {
        if (dailyLog.getAutoDailyLogTruckCount() == 0) {
            return Collections.emptyList();
        }
        List<DailyLogTruck> arrayList = new ArrayList();
        for (AutoDailyLogTruck c1149a : dailyLog.getAutoDailyLogTruckList()) {
            arrayList.add(new C1149a(c1149a, dailyLog.getLogDay()));
        }
        return arrayList;
    }

    private static List<DailyLogTruck> m5823a(DailyLog dailyLog, C0864i c0864i, long j) {
        if (c0864i == null) {
            return Collections.emptyList();
        }
        return C1149a.m5792a(C1108a.m5497a(dailyLog.getLogDay(), dailyLog.getTimezoneId(), dailyLog.hasDriverApproval(), c0864i, j), dailyLog.getLogDay());
    }

    public C1151b(DailyLog dailyLog, List<DailyLogTruck> list, List<DailyLogTruck> list2, List<DailyLogTruck> list3) {
        this.f3928a = dailyLog;
        this.f3929b = new C0956v((al) dailyLog);
        this.f3930c = Collections.unmodifiableList(list);
        this.f3931d = Collections.unmodifiableList(list2);
        this.f3932e = Collections.unmodifiableList(list3);
        this.f3933f = Collections.unmodifiableList(dailyLog.getTrailersList());
        this.f3934g = Collections.unmodifiableList(dailyLog.getShipmentsList());
    }

    public String mo824a() {
        return this.f3928a.getDriverName();
    }

    public String mo837n() {
        return this.f3928a.getTrucksDeprecated();
    }

    public String mo825b() {
        return this.f3928a.getTrailersDeprecated();
    }

    public String mo826c() {
        return this.f3928a.getCarrierName();
    }

    public String mo827d() {
        return this.f3928a.getCarrierAddress();
    }

    public String mo828e() {
        return this.f3928a.getHomeTerminalAddress();
    }

    public String mo829f() {
        return this.f3928a.getShipmentsDeprecated();
    }

    public Integer mo838o() {
        return this.f3928a.hasStartOdometerDeprecated() ? Integer.valueOf(this.f3928a.getStartOdometerDeprecated()) : null;
    }

    public Integer mo839p() {
        return this.f3928a.hasEndOdometerDeprecated() ? Integer.valueOf(this.f3928a.getEndOdometerDeprecated()) : null;
    }

    public Integer mo830g() {
        return this.f3928a.hasTotalDistance() ? Integer.valueOf(this.f3928a.getTotalDistance()) : null;
    }

    public OdometerUnit mo831h() {
        if (this.f3928a.hasTotalDistanceUnit()) {
            return OdometerUnit.m14668a(this.f3928a.getTotalDistanceUnit());
        }
        return null;
    }

    public List<DailyLogTruck> mo832i() {
        return this.f3930c;
    }

    public List<DailyLogTruck> mo833j() {
        return this.f3931d;
    }

    public List<DailyLogTruck> mo834k() {
        return this.f3932e;
    }

    public List<String> mo835l() {
        return this.f3933f;
    }

    public List<String> mo836m() {
        return this.f3934g;
    }

    public boolean mo840q() {
        return this.f3929b.m4878l();
    }

    public boolean mo841r() {
        return this.f3929b.mo706e();
    }

    public boolean mo842s() {
        return this.f3928a != null && this.f3928a.hasDriverApproval();
    }

    public boolean mo843t() {
        return this.f3928a != null && this.f3928a.hasAmendedBy();
    }
}
