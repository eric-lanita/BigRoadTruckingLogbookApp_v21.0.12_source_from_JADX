package com.bigroad.shared;

import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.shared.duty.C0954t;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Set;

public class ak {

    public static class C0840a {
        public String f2623a;
        public String f2624b;
        public String[] f2625c;
        public String[] f2626d;
        public Set<Integer> f2627e;
    }

    public static C0840a m4181a(C0954t c0954t, Locale locale) {
        if (c0954t == null) {
            return null;
        }
        C0840a c0840a = new C0840a();
        c0840a.f2623a = m4182a(c0954t.m4854c());
        c0840a.f2624b = m4182a(c0954t.m4855d());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM d", locale);
        long[] e = c0954t.m4856e();
        c0840a.f2625c = new String[e.length];
        c0840a.f2626d = new String[e.length];
        for (int i = 0; i < e.length; i++) {
            c0840a.f2625c[i] = m4182a(e[i]);
            int a = c0954t.m4850a() - i;
            c0840a.f2626d[i] = m4183a(simpleDateFormat, DailyLogUtils.m4298a(a, c0954t.m4853b(a)));
        }
        c0840a.f2627e = c0954t.m4857f();
        return c0840a;
    }

    private static String m4182a(long j) {
        return aq.m4232d(j);
    }

    private static String m4183a(SimpleDateFormat simpleDateFormat, Calendar calendar) {
        simpleDateFormat.setTimeZone(calendar.getTimeZone());
        return simpleDateFormat.format(calendar.getTime());
    }
}
