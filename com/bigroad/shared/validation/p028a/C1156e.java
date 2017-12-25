package com.bigroad.shared.validation.p028a;

import com.bigroad.shared.validation.model.DvirInspection;
import com.bigroad.shared.validation.p024b.C1155d;
import com.bigroad.ttb.protocol.TTProtocol;
import com.bigroad.ttb.protocol.TTProtocol.Dvir;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class C1156e extends C1155d {
    private final Dvir f3940a;
    private final List<DvirInspection> f3941b;

    public C1156e(Dvir dvir) {
        this.f3940a = dvir;
        List arrayList = new ArrayList(dvir.getInspectionCount());
        for (TTProtocol.DvirInspection c1154d : dvir.getInspectionList()) {
            arrayList.add(new C1154d(c1154d));
        }
        this.f3941b = Collections.unmodifiableList(arrayList);
    }

    public byte[] mo851a() {
        return this.f3940a.getId().m19091d();
    }

    public int mo852b() {
        return this.f3940a.getLogDay();
    }

    public String mo853c() {
        return this.f3940a.getInspectorName();
    }

    public String mo854d() {
        return this.f3940a.getCarrierName();
    }

    public List<? extends DvirInspection> mo855e() {
        return this.f3941b;
    }

    public boolean mo856f() {
        return this.f3940a.hasDriverApproval();
    }

    public static List<C1156e> m5880a(List<Dvir> list) {
        List<C1156e> arrayList = new ArrayList(list.size());
        for (Dvir c1156e : list) {
            arrayList.add(new C1156e(c1156e));
        }
        return arrayList;
    }
}
