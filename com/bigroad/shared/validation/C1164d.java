package com.bigroad.shared.validation;

import com.bigroad.shared.duty.C0898i;
import com.bigroad.shared.duty.C0956v;
import com.bigroad.shared.duty.rule.C0912j;
import com.bigroad.shared.validation.ValidationError.Category;
import com.bigroad.shared.validation.ValidationError.ErrorCode;
import com.bigroad.shared.validation.model.DailyLog;
import com.bigroad.shared.validation.model.DailyLog.Field;
import com.bigroad.shared.validation.model.Dvir;
import com.bigroad.shared.validation.model.Event;

public class C1164d {
    private C1157a f3953a;

    public C1164d(C1157a c1157a) {
        this.f3953a = c1157a;
    }

    public void m5930a(DailyLog dailyLog, long j) {
        Object obj;
        C1177q d = this.f3953a.mo1224d();
        long c = d.mo1218c();
        C1176p A = dailyLog.mo716A();
        A.m5955a();
        Object obj2 = null;
        Object obj3 = null;
        for (Event event : dailyLog.mo859c()) {
            if (!event.mo720v()) {
                obj2 = 1;
            }
            if (event.mo702m().m4395c()) {
                obj = 1;
            } else {
                obj = obj3;
            }
            if (obj2 != null && obj != null) {
                break;
            }
            obj3 = obj;
        }
        obj = obj3;
        int a = this.f3953a.mo1219a();
        obj3 = 1;
        if (!(dailyLog.mo857a() == a && dailyLog.mo858b() == null && r4 == null && dailyLog.mo860d().isEmpty())) {
            obj3 = null;
        }
        boolean f = dailyLog.mo862f();
        boolean a2 = C1178r.m5974a(this.f3953a, dailyLog.mo857a());
        if (dailyLog.mo858b() != null) {
            new C1162b(dailyLog).m5925a(dailyLog.mo858b(), this.f3953a, dailyLog.mo857a());
        } else if (!(a2 || r3 != null || r2 == null)) {
            A.m5956a(Field.NONE, new ValidationError(ErrorCode.DAILY_LOG_HEADER_MISSING, new C1175o(ValidationMessageId.LOG_MISSING_HEADER), Category.FORM_AND_MANNER));
        }
        if (f) {
            if (!(a2 || dailyLog.mo857a() == a || dailyLog.mo861e())) {
                A.m5956a(Field.NONE, new ValidationError(ErrorCode.DAILY_LOG_NOT_SUBMITTED, new C1175o(ValidationMessageId.LOG_NOT_SUBMITTED), Category.NOT_SUBMITTED));
            }
        } else if (!(a2 || dailyLog.mo857a() == a || ((r2 == null && dailyLog.mo858b() == null) || dailyLog.mo861e()))) {
            A.m5956a(Field.NONE, new ValidationError(ErrorCode.DAILY_LOG_NOT_SIGNED, new C1175o(ValidationMessageId.LOG_NOT_SIGNED), Category.MISSING_SIGNATURE));
        }
        for (Event event2 : dailyLog.mo859c()) {
            C1167g.m5934a(event2, this.f3953a, dailyLog.mo857a());
        }
        for (Dvir a3 : dailyLog.mo860d()) {
            C1166f.m5932a(a3, this.f3953a, dailyLog.mo857a());
        }
        C0898i a4 = this.f3953a.mo1220a(j);
        if (a4 != null) {
            for (C0912j a5 : new C0956v(this.f3953a.mo1221a(dailyLog.mo857a())).m4881o()) {
                a5.mo731a(a4, dailyLog.mo857a(), A);
            }
        }
        C1170i.m5942a(a4, dailyLog.mo857a(), A);
        d.m5966a(d.m5970c(c));
    }
}
