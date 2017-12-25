package com.bigroad.shared.duty;

import com.bigroad.shared.C0836a;
import com.bigroad.shared.C0906x;
import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.TimeZone;

public class C0907o extends C0836a implements C0906x {
    public static final Comparator<C0907o> f2797a = new C09051();
    private final TimeZone f2798b;
    private final int f2799c;
    private Calendar f2800d;
    private Calendar f2801e;

    static class C09051 implements Comparator<C0907o> {
        C09051() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m4578a((C0907o) obj, (C0907o) obj2);
        }

        public int m4578a(C0907o c0907o, C0907o c0907o2) {
            int a_ = c0907o.a_();
            int a_2 = c0907o2.a_();
            if (a_ == a_2) {
                return 0;
            }
            return a_ < a_2 ? -1 : 1;
        }
    }

    private void m4582d() {
        if (this.f2800d == null) {
            this.f2800d = DailyLogUtils.m4298a(this.f2799c, this.f2798b);
        }
    }

    private void m4583e() {
        if (this.f2801e == null) {
            this.f2801e = DailyLogUtils.m4304b(this.f2799c, this.f2798b);
        }
    }

    public C0907o(TimeZone timeZone, int i) {
        this.f2798b = timeZone;
        this.f2799c = i;
    }

    public C0907o(DailyLog dailyLog) {
        this(DailyLogUtils.m4305b(dailyLog), dailyLog.getLogDay());
    }

    public static C0907o m4579a(Calendar calendar) {
        return new C0907o(calendar.getTimeZone(), DailyLogUtils.m4284a(calendar));
    }

    public static C0907o m4580a(TimeZone timeZone, long j) {
        Calendar instance = Calendar.getInstance(timeZone);
        instance.setTimeInMillis(j);
        return C0907o.m4579a(instance);
    }

    public TimeZone m4585b() {
        return this.f2798b;
    }

    public int a_() {
        return this.f2799c;
    }

    public Calendar m4586c() {
        m4582d();
        return (Calendar) this.f2800d.clone();
    }

    public long mo697f() {
        m4582d();
        return this.f2800d.getTimeInMillis();
    }

    public long mo698g() {
        m4583e();
        return this.f2801e.getTimeInMillis();
    }

    public C0907o m4584a(int i) {
        return new C0907o(this.f2798b, this.f2799c + i);
    }

    public static List<C0907o> m4581a(List<DailyLog> list) {
        List<C0907o> arrayList = new ArrayList(list.size());
        for (DailyLog c0907o : list) {
            arrayList.add(new C0907o(c0907o));
        }
        return arrayList;
    }

    public String toString() {
        return "LogDay [timeZoneId=" + this.f2798b.getID() + ", logDay=" + this.f2799c + "]";
    }
}
