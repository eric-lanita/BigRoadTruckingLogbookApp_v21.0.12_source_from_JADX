package com.bigroad.shared;

import java.util.ArrayList;
import java.util.List;

public class ab extends al {
    private ab f2615c = null;
    private ab f2616d = null;

    private ab(ab abVar, ao aoVar) {
        super(aoVar);
        this.f2615c = abVar;
        if (this.f2615c != null) {
            this.f2615c.f2616d = this;
        }
    }

    public boolean m4145b() {
        return this.f2615c != null;
    }

    public boolean m4146c() {
        return this.f2616d != null;
    }

    public ab m4147d() {
        return this.f2615c;
    }

    public ab m4148e() {
        return this.f2616d;
    }

    public static List<ab> m4144a(List<ao> list) {
        List<ab> arrayList = new ArrayList(list.size());
        ab abVar = null;
        for (ao abVar2 : list) {
            ab abVar3 = new ab(abVar, abVar2);
            arrayList.add(abVar3);
            abVar = abVar3;
        }
        return arrayList;
    }
}
