package com.bigroad.shared.duty;

import com.bigroad.shared.aq;
import com.bigroad.shared.dailylog.DailyLogUtils;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class C0884e extends C0883p {
    private final TimeZone f2752b;

    public static C0884e m4472a(List<C0896g> list, int i, Calendar calendar) {
        Calendar calendar2 = (Calendar) calendar.clone();
        calendar2.add(5, 1);
        long timeInMillis = calendar2.getTimeInMillis();
        return new C0884e(calendar.getTimeZone(), list, i, calendar.getTimeInMillis(), C0883p.m4465a((List) list, i, timeInMillis), timeInMillis);
    }

    private C0884e(TimeZone timeZone, List<C0896g> list, int i, long j, int i2, long j2) {
        super(list, i, j, i2, j2);
        this.f2752b = timeZone;
    }

    public int m4473b() {
        return DailyLogUtils.m4284a(aq.m4224a(this.f2752b, mo697f()));
    }
}
