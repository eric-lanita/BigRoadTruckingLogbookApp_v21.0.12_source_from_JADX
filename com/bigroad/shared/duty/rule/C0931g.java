package com.bigroad.shared.duty.rule;

import com.bigroad.shared.ao;
import com.bigroad.shared.duty.C0882q;
import com.bigroad.shared.duty.C0884e;
import com.bigroad.shared.duty.C0896g;
import com.bigroad.shared.duty.C0898i;
import com.bigroad.shared.duty.C0902k;
import com.bigroad.shared.duty.C0910r;
import com.bigroad.shared.duty.C0955u;
import com.bigroad.shared.duty.DutyLimits.C0868a;
import com.bigroad.shared.validation.C1168m;
import com.bigroad.shared.validation.C1175o;
import com.bigroad.shared.validation.C1176p;
import com.bigroad.shared.validation.ValidationError;
import com.bigroad.shared.validation.ValidationError.Category;
import com.bigroad.shared.validation.ValidationError.ErrorCode;
import com.bigroad.shared.validation.ValidationMessageId;
import com.bigroad.shared.validation.model.DailyLog.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.TimeZone;

public class C0931g implements C0912j {
    private final long f2864a;
    private final long f2865b;
    private final long f2866c;
    private final long f2867d;
    private final long f2868e;
    private final long f2869f;
    private final long f2870g;
    private final long f2871h;
    private final boolean f2872i;

    class C09271 extends C0910r<C0930c> {
        final /* synthetic */ C0931g f2847a;

        C09271(C0931g c0931g) {
            this.f2847a = c0931g;
        }

        protected /* synthetic */ C0882q mo730b(List list, int i, int i2) {
            return m4669c(list, i, i2);
        }

        protected C0930c m4669c(List<C0896g> list, int i, int i2) {
            return new C0930c(this.f2847a, list, i, i2);
        }
    }

    private class C0928a {
        final /* synthetic */ C0931g f2848a;
        private final C0898i f2849b;
        private final TimeZone f2850c;
        private final List<C0930c> f2851d;
        private final boolean f2852e;
        private Map<Integer, ValidationError> f2853f;
        private List<C1168m> f2854g;
        private long f2855h = this.f2848a.f2866c;
        private long f2856i = this.f2848a.f2867d;
        private long f2857j = this.f2848a.f2864a;

        public C0928a(C0931g c0931g, C0898i c0898i, TimeZone timeZone, List<C0930c> list, boolean z) {
            this.f2848a = c0931g;
            this.f2849b = c0898i;
            this.f2850c = timeZone;
            this.f2851d = list;
            this.f2852e = z;
        }

        public void m4679a() {
            m4676h();
            m4677i();
        }

        public int m4680b() {
            int i = 0;
            int size = this.f2853f != null ? this.f2853f.size() : 0;
            if (this.f2854g != null) {
                i = this.f2854g.size();
            }
            return size + i;
        }

        public ValidationError m4678a(int i) {
            if (this.f2853f == null) {
                return null;
            }
            return (ValidationError) this.f2853f.get(Integer.valueOf(i));
        }

        public List<C1168m> m4681c() {
            return this.f2854g == null ? Collections.emptyList() : this.f2854g;
        }

        public long m4682d() {
            return this.f2856i;
        }

        public long m4683e() {
            return this.f2855h;
        }

        public long m4684f() {
            return this.f2857j;
        }

        public long m4685g() {
            return Math.min(this.f2856i, this.f2855h);
        }

        private void m4676h() {
            int size = this.f2851d.size() - 1;
            C0882q c0882q = null;
            C0930c c0930c = null;
            C0930c c0930c2 = null;
            while (size >= 0) {
                int i;
                C0882q c0882q2;
                C0930c c0930c3;
                C0930c c0930c4 = (C0930c) this.f2851d.get(size);
                if (c0930c4.mo689a() < this.f2848a.f2864a) {
                    i = size;
                    c0882q2 = c0882q;
                    c0930c3 = c0930c;
                    c0930c = c0930c2;
                } else {
                    C0882q a;
                    if (c0930c4.m4464k() == this.f2849b.m4561h()) {
                        a = this.f2849b.m4550a(this.f2849b.m4561h(), this.f2849b.m4561h());
                    } else {
                        a = this.f2849b.m4550a(c0930c4.m4464k(), c0930c2 == null ? this.f2849b.m4561h() : c0930c2.m4463j());
                    }
                    List b = m4675b(a);
                    if (b == null) {
                        if (c0930c2 == null && this.f2852e) {
                            c0930c4.m4696b();
                            m4673a(a);
                            int i2 = size;
                            c0882q2 = c0882q;
                            c0930c3 = c0930c;
                            c0930c = c0930c4;
                            i = i2;
                        } else {
                            c0930c3 = c0930c4;
                            c0930c = c0930c2;
                            i = size;
                            c0882q2 = a;
                        }
                    } else if (c0882q != null) {
                        if (c0930c2 == null) {
                            m4673a(c0882q);
                        }
                        if (c0930c != null) {
                            c0930c.m4696b();
                        }
                        i = size + 1;
                        c0882q2 = null;
                        c0930c3 = null;
                    } else {
                        m4674a(b);
                        if (c0930c2 == null) {
                            m4673a(a);
                        }
                        c0930c4.m4696b();
                        c0930c3 = c0930c;
                        c0930c = c0930c4;
                        i = size;
                        c0882q2 = null;
                    }
                }
                c0930c2 = c0930c;
                c0930c = c0930c3;
                c0882q = c0882q2;
                size = i - 1;
            }
            if (c0930c2 == null) {
                m4673a(c0882q);
            }
            ((C0930c) this.f2851d.get(0)).m4696b();
        }

        private void m4673a(C0882q c0882q) {
            this.f2855h = Math.min(this.f2848a.f2865b - c0882q.mo689a(), this.f2848a.f2866c - c0882q.m4452d());
            this.f2856i = this.f2848a.f2867d - c0882q.m4454e();
        }

        private void m4677i() {
            Iterator a = this.f2849b.m4551a(this.f2850c);
            ListIterator listIterator = this.f2851d.listIterator();
            C0884e c0884e = null;
            C0929b c0929b = new C0929b(this.f2848a);
            while (a.hasNext()) {
                c0884e = (C0884e) a.next();
                m4674a(m4670a(c0884e));
                c0929b.m4693a();
                int i = 0;
                while (listIterator.hasNext()) {
                    C0930c c0930c = (C0930c) listIterator.next();
                    if (c0930c.mo698g() >= c0884e.mo697f()) {
                        if (c0930c.mo697f() >= c0884e.mo698g()) {
                            break;
                        }
                        int i2 = (c0930c.m4695a(c0884e, c0929b) || i != 0) ? 1 : 0;
                        i = i2;
                    }
                }
                do {
                } while (((C0930c) listIterator.previous()).mo697f() > c0884e.mo698g());
                if (c0929b.m4688b() + c0884e.m4471c() < this.f2848a.f2870g) {
                    ValidationMessageId validationMessageId = ValidationMessageId.CDN_DAY_OFF_DUTY_REQUIRED;
                    if (!this.f2848a.f2872i) {
                        validationMessageId = ValidationMessageId.CDN_DAY_OFF_DUTY_REQUIRED_30_MIN;
                        if (i != 0) {
                            validationMessageId = ValidationMessageId.CDN_DAY_OFF_DUTY_REQUIRED_30_MIN_RESET;
                        }
                    }
                    Long valueOf = Long.valueOf(this.f2848a.f2870g / 3600000);
                    m4672a(c0884e.m4473b(), ErrorCode.DAY_WITHOUT_MINIMUM_REST, new C1175o(validationMessageId, new Object[]{valueOf}));
                }
            }
            if (c0884e != null) {
                long g = this.f2848a.f2868e - c0884e.m4452d();
                if (g < c0884e.m4471c()) {
                    this.f2855h = Math.min(this.f2855h, g);
                }
                g = this.f2848a.f2869f - c0884e.m4454e();
                if (g < c0884e.m4471c()) {
                    this.f2856i = Math.min(this.f2856i, g);
                }
                g = this.f2848a.f2870g - c0929b.m4688b();
                long c = c0884e.m4471c() - g;
                if (g > 0) {
                    this.f2855h = Math.min(c, this.f2855h);
                    this.f2856i = Math.min(c, this.f2856i);
                }
                c0930c = (C0930c) this.f2851d.get(this.f2851d.size() - 1);
                g = c0930c.m4464k() == this.f2849b.m4561h() ? c0930c.mo689a() : 0;
                this.f2857j = (Math.max((this.f2848a.f2870g - this.f2848a.f2864a) - c0929b.f2860c, 0) + this.f2848a.f2864a) - g;
                if (this.f2857j < c0884e.m4471c()) {
                    this.f2857j = this.f2848a.f2864a - g;
                }
                this.f2857j = Math.max(this.f2857j, 0);
            }
        }

        private List<C1168m> m4675b(C0882q c0882q) {
            long j = 0;
            Iterator it = c0882q.iterator();
            List<C1168m> list = null;
            long j2 = 0;
            long j3 = 0;
            while (it.hasNext()) {
                C0896g c0896g = (C0896g) it.next();
                long a = c0896g.mo689a();
                long j4 = j3 + a;
                if (c0896g.m4539b()) {
                    List<C1168m> a2;
                    long j5;
                    long j6 = j2 + a;
                    if (c0896g.m4541d()) {
                        Long valueOf;
                        a += j;
                        j = j6 - this.f2848a.f2866c;
                        if (j > 0) {
                            valueOf = Long.valueOf(this.f2848a.f2866c / 3600000);
                            list = m4671a(list, Math.max(c0896g.mo697f(), c0896g.mo698g() - j), c0896g.mo698g(), ErrorCode.DRIVING_OVER_SHIFT_DUTY_LIMIT, new C1175o(ValidationMessageId.CDN_DAY_SHIFT_DUTY, new Object[]{valueOf}));
                        }
                        j = a - this.f2848a.f2867d;
                        if (j > 0) {
                            valueOf = Long.valueOf(this.f2848a.f2867d / 3600000);
                            list = m4671a(list, Math.max(c0896g.mo697f(), c0896g.mo698g() - j), c0896g.mo698g(), ErrorCode.DRIVING_OVER_SHIFT_DRIVE_LIMIT, new C1175o(ValidationMessageId.CDN_DAY_SHIFT_DRIVE, new Object[]{valueOf}));
                        }
                        j = j4 - this.f2848a.f2865b;
                        if (j > 0) {
                            valueOf = Long.valueOf(this.f2848a.f2865b / 3600000);
                            a2 = m4671a(list, Math.max(c0896g.mo697f(), c0896g.mo698g() - j), c0896g.mo698g(), ErrorCode.DRIVING_OVER_SHIFT_DURATION_LIMIT, new C1175o(ValidationMessageId.CDN_DAY_SHIFT_DRIVE_SINCE_START, new Object[]{valueOf}));
                            j5 = a;
                        } else {
                            a2 = list;
                            j5 = a;
                        }
                    } else {
                        long j7 = j;
                        a2 = list;
                        j5 = j7;
                    }
                    j3 = j4;
                    j2 = j6;
                    list = a2;
                    j = j5;
                } else {
                    j3 = j4;
                }
            }
            return list;
        }

        private List<C1168m> m4670a(C0884e c0884e) {
            long j = 0;
            Iterator it = c0884e.iterator();
            List<C1168m> list = null;
            long j2 = 0;
            while (it.hasNext()) {
                C0896g c0896g = (C0896g) it.next();
                if (c0896g.m4539b()) {
                    List<C1168m> a;
                    long j3;
                    long a2 = c0896g.mo689a();
                    long j4 = j2 + a2;
                    if (c0896g.m4541d()) {
                        Long valueOf;
                        long j5 = j + a2;
                        j = j4 - this.f2848a.f2868e;
                        if (j > 0) {
                            valueOf = Long.valueOf(this.f2848a.f2868e / 3600000);
                            list = m4671a(list, Math.max(c0896g.mo697f(), c0896g.mo698g() - j), c0896g.mo698g(), ErrorCode.DRIVING_OVER_DAILY_DUTY_LIMIT, new C1175o(ValidationMessageId.CDN_DAY_SHIFT_DUTY_TODAY, new Object[]{valueOf}));
                        }
                        j = j5 - this.f2848a.f2869f;
                        if (j > 0) {
                            valueOf = Long.valueOf(this.f2848a.f2869f / 3600000);
                            a = m4671a(list, Math.max(c0896g.mo697f(), c0896g.mo698g() - j), c0896g.mo698g(), ErrorCode.DRIVING_OVER_DAILY_DRIVE_LIMIT, new C1175o(ValidationMessageId.CDN_DAY_SHIFT_DRIVE_TODAY, new Object[]{valueOf}));
                            j3 = j5;
                        } else {
                            a = list;
                            j3 = j5;
                        }
                    } else {
                        long j6 = j;
                        a = list;
                        j3 = j6;
                    }
                    j2 = j4;
                    list = a;
                    j = j3;
                }
            }
            return list;
        }

        private List<C1168m> m4671a(List<C1168m> list, long j, long j2, ErrorCode errorCode, C1175o c1175o) {
            if (list == null) {
                list = new ArrayList();
            }
            list.add(new C1168m(j, j2, errorCode, c1175o));
            return list;
        }

        private void m4674a(List<C1168m> list) {
            if (list != null && !list.isEmpty()) {
                if (this.f2854g == null) {
                    this.f2854g = new ArrayList();
                }
                this.f2854g.addAll(list);
            }
        }

        private void m4672a(int i, ErrorCode errorCode, C1175o c1175o) {
            if (this.f2853f == null) {
                this.f2853f = new HashMap();
            }
            if (this.f2853f.put(Integer.valueOf(i), new ValidationError(errorCode, c1175o, Category.DRIVE_TIME)) != null) {
                throw new IllegalStateException("More than one violation set for day " + i);
            }
        }
    }

    private class C0929b {
        final /* synthetic */ C0931g f2858a;
        private long f2859b;
        private long f2860c;

        public C0929b(C0931g c0931g) {
            this.f2858a = c0931g;
            m4693a();
        }

        public void m4693a() {
            this.f2859b = 0;
            this.f2860c = 0;
        }

        public long m4692a(long j, C0929b c0929b) {
            long min = Math.min(this.f2858a.f2864a - this.f2859b, Math.min(c0929b.f2859b, j));
            c0929b.f2859b -= min;
            this.f2859b += min;
            return min;
        }

        public long m4694b(long j, C0929b c0929b) {
            long min = Math.min(this.f2858a.f2870g - m4688b(), Math.min(c0929b.f2860c, j));
            c0929b.f2860c -= min;
            this.f2860c += min;
            return min;
        }

        public long m4691a(long j) {
            long min = Math.min(this.f2859b, j);
            this.f2859b -= min;
            min = j - min;
            long min2 = Math.min(this.f2860c, min);
            this.f2860c -= min2;
            return min - min2;
        }

        private long m4688b() {
            return this.f2859b + this.f2860c;
        }
    }

    private class C0930c extends C0882q {
        final /* synthetic */ C0931g f2861b;
        private boolean f2862c;
        private C0929b f2863d = new C0929b(this.f2861b);

        public C0930c(C0931g c0931g, List<C0896g> list, int i, int i2) {
            this.f2861b = c0931g;
            super(list, i, i2);
            m4698l();
        }

        public void m4696b() {
            this.f2862c = true;
            this.f2863d.f2859b = this.f2861b.f2864a;
            this.f2863d.f2860c = mo689a() - this.f2861b.f2864a;
        }

        public boolean m4697c() {
            return this.f2862c;
        }

        public void m4698l() {
            this.f2862c = false;
            this.f2863d.f2859b = 0;
            this.f2863d.f2860c = mo689a();
        }

        public boolean m4695a(C0884e c0884e, C0929b c0929b) {
            boolean z = false;
            if (mo689a() >= this.f2861b.f2871h) {
                long min = Math.min(c0884e.mo698g(), mo698g()) - Math.max(c0884e.mo697f(), mo697f());
                if (m4697c()) {
                    long a = c0929b.m4692a(min, this.f2863d);
                    if (a != min) {
                        z = true;
                    }
                    min -= a;
                }
                this.f2863d.m4691a(min - c0929b.m4694b(min, this.f2863d));
            }
            return z;
        }
    }

    public C0931g(boolean z) {
        this.f2872i = z;
        if (z) {
            this.f2864a = 28800000;
            this.f2865b = 72000000;
            this.f2866c = 64800000;
            this.f2867d = 54000000;
            this.f2868e = 86400000;
            this.f2869f = 86400000;
            this.f2870g = 28800000;
            this.f2871h = 60000;
            return;
        }
        this.f2864a = 28800000;
        this.f2865b = 57600000;
        this.f2866c = 50400000;
        this.f2867d = 46800000;
        this.f2868e = 50400000;
        this.f2869f = 46800000;
        this.f2870g = 36000000;
        this.f2871h = 1800000;
    }

    private C0928a m4700a(C0898i c0898i, TimeZone timeZone) {
        boolean z;
        List<C0930c> a = ((C09271) c0898i.m4558e().m4450a(C0896g.f2771d, new C09271(this))).m4593a();
        for (C0930c a2 : a) {
            if (a2.mo689a() >= this.f2864a) {
                z = true;
                break;
            }
        }
        z = false;
        if (z) {
            C0928a c0928a = new C0928a(this, c0898i, timeZone, a, true);
            c0928a.m4679a();
            for (C0930c l : a) {
                l.m4698l();
            }
            C0928a c0928a2 = new C0928a(this, c0898i, timeZone, a, false);
            c0928a2.m4679a();
            if (c0928a.m4680b() == c0928a2.m4680b()) {
                long g = c0928a.m4685g();
                long g2 = c0928a2.m4685g();
                if (g > g2) {
                    return c0928a;
                }
                if (g < g2) {
                    return c0928a2;
                }
                g = c0928a.m4683e();
                g2 = c0928a2.m4683e();
                if (g > g2) {
                    return c0928a;
                }
                if (g < g2) {
                    return c0928a2;
                }
                if (c0928a.m4684f() > c0928a2.m4684f()) {
                    return c0928a2;
                }
                return c0928a;
            } else if (c0928a.m4680b() > c0928a2.m4680b()) {
                return c0928a2;
            } else {
                return c0928a;
            }
        }
        throw new IllegalArgumentException("Malformed DutyStatusHistory. Cannot find valid rest period for history period: " + c0898i.m4558e());
    }

    public void mo732a(C0898i c0898i, C0868a c0868a) {
        C0928a a = m4700a(c0898i, c0898i.m4557d());
        c0868a.m4356c(new C0902k(a.m4682d(), Math.min(this.f2867d, this.f2869f)));
        c0868a.m4350a(new C0902k(a.m4683e(), Math.min(this.f2866c, this.f2868e)));
        c0868a.m4355b(new C0955u(a.m4684f(), this.f2864a));
        c0868a.m4348a(60000);
    }

    public void mo731a(C0898i c0898i, int i, C1176p<Field> c1176p) {
        ao c = c0898i.m4554c(i);
        C0928a a = m4700a(c0898i, c.m4585b());
        ValidationError a2 = a.m4678a(i);
        if (a2 != null) {
            c1176p.m5956a(Field.NONE, a2);
        }
        for (C1168m a3 : a.m4681c()) {
            C1168m a32 = a32.m5941a(c);
            if (a32 != null) {
                c1176p.m5957a(Field.NONE, a32);
            }
        }
    }
}
