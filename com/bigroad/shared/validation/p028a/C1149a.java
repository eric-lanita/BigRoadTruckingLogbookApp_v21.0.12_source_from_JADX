package com.bigroad.shared.validation.p028a;

import com.bigroad.shared.model.C1108a;
import com.bigroad.shared.validation.model.DailyLogTruck;
import com.bigroad.shared.validation.p024b.C1148b;
import com.bigroad.ttb.protocol.TTProtocol.AutoDailyLogTruck;
import com.bigroad.ttb.protocol.TTProtocol.OdometerUnit;
import java.util.ArrayList;
import java.util.List;

public class C1149a extends C1148b {
    private final C1108a f3925a;
    private final int f3926b;

    public C1149a(C1108a c1108a, int i) {
        this.f3925a = c1108a;
        this.f3926b = i;
    }

    public C1149a(AutoDailyLogTruck autoDailyLogTruck, int i) {
        this.f3925a = C1108a.m5496a(autoDailyLogTruck);
        this.f3926b = i;
    }

    public int a_() {
        return this.f3926b;
    }

    public String mo823b() {
        return this.f3925a.m5490q();
    }

    public Integer mo779f() {
        return this.f3925a.mo779f();
    }

    public Integer mo780g() {
        return this.f3925a.mo780g();
    }

    public Integer mo781i() {
        return this.f3925a.mo781i();
    }

    public OdometerUnit mo782t() {
        if (this.f3925a.m5494u()) {
            return this.f3925a.m5492s().m5472b();
        }
        return null;
    }

    public static List<DailyLogTruck> m5792a(List<C1108a> list, int i) {
        List<DailyLogTruck> arrayList = new ArrayList(list.size());
        for (C1108a c1149a : list) {
            arrayList.add(new C1149a(c1149a, i));
        }
        return arrayList;
    }
}
