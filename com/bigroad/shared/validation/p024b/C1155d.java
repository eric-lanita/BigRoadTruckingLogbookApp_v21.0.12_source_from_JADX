package com.bigroad.shared.validation.p024b;

import com.bigroad.shared.validation.C1176p;
import com.bigroad.shared.validation.ValidationError.Severity;
import com.bigroad.shared.validation.model.Dvir;
import com.bigroad.shared.validation.model.Dvir.Field;
import com.bigroad.shared.validation.model.DvirInspection;
import java.util.Set;

public abstract class C1155d implements Dvir {
    private final C1176p<Field> f3939a = new C1176p();

    public byte[] mo851a() {
        return null;
    }

    public C1176p<Field> mo716A() {
        return this.f3939a;
    }

    public boolean mo717B() {
        return m5878a(true);
    }

    public boolean m5878a(boolean z) {
        if (this.f3939a.m5962b()) {
            return true;
        }
        if (z) {
            for (DvirInspection B : mo855e()) {
                if (B.mo717B()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean mo718a(Set<Severity> set) {
        if (this.f3939a.m5959a((Set) set)) {
            return true;
        }
        for (DvirInspection a : mo855e()) {
            if (a.mo718a(set)) {
                return true;
            }
        }
        return false;
    }
}
