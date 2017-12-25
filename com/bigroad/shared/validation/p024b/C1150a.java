package com.bigroad.shared.validation.p024b;

import com.bigroad.shared.p021a.C0835b;
import com.bigroad.shared.validation.C1176p;
import com.bigroad.shared.validation.ValidationError.Severity;
import com.bigroad.shared.validation.model.DailyLogHeader;
import com.bigroad.shared.validation.model.DailyLogHeader.Field;
import com.bigroad.shared.validation.model.DailyLogTruck;
import java.util.Iterator;
import java.util.Set;

public abstract class C1150a implements DailyLogHeader {
    private final C1176p<Field> f3927a = new C1176p();

    public C1176p<Field> mo716A() {
        return this.f3927a;
    }

    public boolean mo717B() {
        return m5821a(true);
    }

    public boolean m5821a(boolean z) {
        if (this.f3927a.m5962b()) {
            return true;
        }
        if (z) {
            Iterator a = C0835b.m4110a(mo832i().iterator(), mo833j().iterator());
            while (a.hasNext()) {
                if (((DailyLogTruck) a.next()).mo717B()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean mo718a(Set<Severity> set) {
        if (this.f3927a.m5959a((Set) set)) {
            return true;
        }
        Iterator a = C0835b.m4110a(mo832i().iterator(), mo833j().iterator());
        while (a.hasNext()) {
            if (((DailyLogTruck) a.next()).mo718a(set)) {
                return true;
            }
        }
        return false;
    }
}
