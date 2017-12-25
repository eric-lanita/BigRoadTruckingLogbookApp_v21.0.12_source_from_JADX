package com.bigroad.shared.validation.p024b;

import com.bigroad.shared.validation.C1176p;
import com.bigroad.shared.validation.ValidationError.Severity;
import com.bigroad.shared.validation.model.DvirInspection;
import com.bigroad.shared.validation.model.DvirInspection.Field;
import java.util.Set;

public abstract class C1153c implements DvirInspection {
    private final C1176p<Field> f3937a = new C1176p();

    public byte[] mo844a() {
        return null;
    }

    public C1176p<Field> mo716A() {
        return this.f3937a;
    }

    public boolean mo717B() {
        return m5860a(true);
    }

    public boolean m5860a(boolean z) {
        return this.f3937a.m5962b();
    }

    public boolean mo718a(Set<Severity> set) {
        return this.f3937a.m5959a((Set) set);
    }
}
