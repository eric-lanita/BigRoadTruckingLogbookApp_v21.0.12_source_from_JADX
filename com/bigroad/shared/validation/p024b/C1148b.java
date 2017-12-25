package com.bigroad.shared.validation.p024b;

import com.bigroad.shared.validation.C1176p;
import com.bigroad.shared.validation.ValidationError.Severity;
import com.bigroad.shared.validation.model.DailyLogTruck;
import com.bigroad.shared.validation.model.DailyLogTruck.Field;
import java.util.Set;

public abstract class C1148b implements DailyLogTruck {
    private final C1176p<Field> f3924a = new C1176p();

    public C1176p<Field> mo716A() {
        return this.f3924a;
    }

    public boolean mo717B() {
        return m5791a(true);
    }

    public boolean m5791a(boolean z) {
        return this.f3924a.m5962b();
    }

    public boolean mo718a(Set<Severity> set) {
        return this.f3924a.m5959a((Set) set);
    }
}
