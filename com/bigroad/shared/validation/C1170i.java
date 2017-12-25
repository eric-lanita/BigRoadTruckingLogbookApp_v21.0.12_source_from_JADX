package com.bigroad.shared.validation;

import com.bigroad.shared.ao;
import com.bigroad.shared.duty.C0896g;
import com.bigroad.shared.duty.C0898i;
import com.bigroad.shared.model.C1122f;
import com.bigroad.shared.validation.ValidationError.ErrorCode;
import com.bigroad.shared.validation.model.DailyLog.Field;
import java.util.Iterator;
import java.util.List;

public class C1170i {
    public static void m5942a(C0898i c0898i, int i, C1176p<Field> c1176p) {
        List c = c0898i.m4555c();
        if (!c.isEmpty()) {
            ao c2 = c0898i.m4554c(i);
            Iterator it = c.iterator();
            C1122f c1122f = (C1122f) it.next();
            while (c1122f.m5695b() < c2.mo697f()) {
                if (it.hasNext()) {
                    c1122f = (C1122f) it.next();
                } else {
                    return;
                }
            }
            if (c1122f.m5695b() <= c2.mo698g()) {
                Iterator it2 = c0898i.m4558e().iterator();
                C1122f c1122f2 = c1122f;
                while (it2.hasNext()) {
                    C0896g c0896g = (C0896g) it2.next();
                    if (!c0896g.mo695d(c2)) {
                        if (c0896g.mo693b(c2)) {
                            while (true) {
                                if (!c0896g.mo694c(c1122f2.m5695b()) && !c0896g.mo690a(c1122f2.m5695b())) {
                                    break;
                                }
                                if (c0896g.mo690a(c1122f2.m5695b())) {
                                    c1176p.m5957a(Field.NONE, new C1169h(c1122f2.m5695b(), ErrorCode.DRIVING_WITH_SENSOR_FAILURE, c1122f2.m5696c()));
                                }
                                if (!it.hasNext()) {
                                    break;
                                }
                                c1122f2 = (C1122f) it.next();
                            }
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
