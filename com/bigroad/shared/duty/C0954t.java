package com.bigroad.shared.duty;

import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.shared.p021a.C0831a;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

public class C0954t {
    private final DutyCycle f2921a;
    private final int f2922b;
    private final C0907o[] f2923c;
    private final long f2924d;
    private HashSet<Integer> f2925e;
    private final boolean f2926f;
    private C0898i f2927g;
    private long f2928h;
    private long f2929i;
    private long[] f2930j;

    public C0954t(C0956v c0956v, List<Event> list, int i, List<C0907o> list2, boolean z, long j) {
        if (i < 0) {
            throw new IllegalArgumentException("currentLogDay must be a positive number.");
        }
        this.f2922b = i;
        this.f2921a = DutyCycle.m4331a(c0956v);
        int a = this.f2921a.m4332a();
        this.f2923c = C0954t.m4849a(list2, i, a, c0956v.m4868b());
        this.f2926f = z;
        this.f2927g = new C0898i(list2, list, this.f2923c[0].mo698g(), c0956v.m4868b());
        DutyLimits a2 = DutyLimits.m4362a(c0956v.m4881o(), this.f2927g);
        List i2 = a2.m4373i();
        if (i2.isEmpty()) {
            this.f2924d = -1;
        } else {
            this.f2924d = ((C0882q) i2.get(i2.size() - 1)).mo697f();
        }
        this.f2928h = 0;
        m4847a(a, j);
        m4848a(a2, a);
        this.f2929i = Math.max(0, a2.m4368d().m4402b());
    }

    private static C0907o[] m4849a(List<C0907o> list, int i, int i2, TimeZone timeZone) {
        int i3;
        C0907o[] c0907oArr = new C0907o[i2];
        int i4 = 0;
        for (C0907o c0907o : C0831a.m4105a(list)) {
            int a_ = c0907o.a_();
            if (a_ <= i) {
                while (i4 < i2) {
                    int i5 = i - i4;
                    if (i5 == a_) {
                        c0907oArr[i4] = c0907o;
                        i3 = i4 + 1;
                        break;
                    }
                    c0907oArr[i4] = new C0907o(timeZone, i5);
                    i4++;
                }
                i3 = i4;
                if (i3 >= i2) {
                    break;
                }
                i4 = i3;
            }
        }
        i3 = i4;
        while (i3 < i2) {
            c0907oArr[i3] = new C0907o(timeZone, i - i3);
            i3++;
        }
        return c0907oArr;
    }

    public int m4850a() {
        return this.f2922b;
    }

    public C0907o m4851a(int i) {
        return this.f2923c[i];
    }

    public DutyCycle m4852b() {
        return this.f2921a;
    }

    public long m4854c() {
        return this.f2928h;
    }

    public long m4855d() {
        return this.f2929i;
    }

    public long[] m4856e() {
        return this.f2930j;
    }

    public Set<Integer> m4857f() {
        return Collections.unmodifiableSet(this.f2925e);
    }

    private void m4848a(DutyLimits dutyLimits, int i) {
        List<C0882q> i2 = dutyLimits.m4373i();
        this.f2925e = new HashSet();
        for (C0882q f : i2) {
            long f2 = f.mo697f();
            for (int i3 = i - 1; i3 >= 0; i3--) {
                int i4 = this.f2922b - i3;
                TimeZone b = m4853b(i4);
                long timeInMillis = DailyLogUtils.m4298a(i4, b).getTimeInMillis();
                long timeInMillis2 = DailyLogUtils.m4304b(i4, b).getTimeInMillis();
                if (f2 >= timeInMillis && f2 < timeInMillis2) {
                    this.f2925e.add(Integer.valueOf(i4));
                    break;
                }
            }
        }
    }

    private void m4847a(int i, long j) {
        this.f2930j = new long[i];
        C0882q e = this.f2927g.m4558e();
        int i2 = i - 1;
        long j2 = -1;
        while (i2 >= 0) {
            int i3 = this.f2922b - i2;
            TimeZone b = m4853b(i3);
            if (j2 < 0) {
                j2 = DailyLogUtils.m4298a(i3, b).getTimeInMillis();
            }
            long timeInMillis = DailyLogUtils.m4304b(i3, b).getTimeInMillis();
            if (!this.f2926f) {
                timeInMillis = Math.min(timeInMillis, j);
            }
            this.f2930j[i2] = e.m4445a(j2, timeInMillis);
            if (j2 >= this.f2924d) {
                this.f2928h += this.f2930j[i2];
            } else if (j2 < this.f2924d && timeInMillis > this.f2924d) {
                this.f2928h += e.m4445a(this.f2924d, timeInMillis);
            }
            i2--;
            j2 = timeInMillis;
        }
    }

    public TimeZone m4853b(int i) {
        return m4851a(this.f2922b - i).m4585b();
    }
}
