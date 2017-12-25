package com.bigroad.shared.validation.p024b;

import com.bigroad.shared.validation.C1176p;
import com.bigroad.shared.validation.ValidationError.Severity;
import com.bigroad.shared.validation.model.Event;
import com.bigroad.shared.validation.model.Event.Field;
import java.util.Set;

public abstract class C0888e implements Event {
    private final C1176p<Field> f2760a = new C1176p();

    public byte[] mo719s() {
        return null;
    }

    public boolean mo720v() {
        return false;
    }

    public C1176p<Field> mo716A() {
        return this.f2760a;
    }

    public boolean mo717B() {
        return m4491a(true);
    }

    public boolean m4491a(boolean z) {
        return this.f2760a.m5962b();
    }

    public boolean mo718a(Set<Severity> set) {
        return this.f2760a.m5959a((Set) set);
    }
}
