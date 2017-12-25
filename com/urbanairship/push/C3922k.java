package com.urbanairship.push;

import com.urbanairship.C3783j;
import com.urbanairship.json.C3684c;
import com.urbanairship.json.C3788b;
import com.urbanairship.json.JsonValue;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

class C3922k implements C3684c {
    private final int f13917a;
    private final int f13918b;
    private final int f13919c;
    private final int f13920d;

    public static class C3921a {
        private int f13913a = -1;
        private int f13914b = -1;
        private int f13915c = -1;
        private int f13916d = -1;

        public C3921a m20340a(Date date, Date date2) {
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            this.f13913a = instance.get(11);
            this.f13914b = instance.get(12);
            instance = Calendar.getInstance();
            instance.setTime(date2);
            this.f13915c = instance.get(11);
            this.f13916d = instance.get(12);
            return this;
        }

        public C3921a m20339a(int i) {
            this.f13913a = i;
            return this;
        }

        public C3921a m20342b(int i) {
            this.f13914b = i;
            return this;
        }

        public C3921a m20343c(int i) {
            this.f13915c = i;
            return this;
        }

        public C3921a m20344d(int i) {
            this.f13916d = i;
            return this;
        }

        public C3922k m20341a() {
            return new C3922k();
        }
    }

    private C3922k(C3921a c3921a) {
        this.f13917a = c3921a.f13913a;
        this.f13918b = c3921a.f13914b;
        this.f13919c = c3921a.f13915c;
        this.f13920d = c3921a.f13916d;
    }

    public boolean m20346a() {
        boolean z = true;
        Date[] b = m20347b();
        if (b == null) {
            return false;
        }
        Calendar instance = Calendar.getInstance();
        Calendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(b[0]);
        Calendar gregorianCalendar2 = new GregorianCalendar();
        gregorianCalendar2.setTime(b[1]);
        if (!(instance.after(gregorianCalendar) && instance.before(gregorianCalendar2))) {
            z = false;
        }
        return z;
    }

    public Date[] m20347b() {
        if (this.f13917a == -1 || this.f13918b == -1 || this.f13919c == -1 || this.f13920d == -1) {
            return null;
        }
        Calendar instance = Calendar.getInstance();
        instance.set(11, this.f13917a);
        instance.set(12, this.f13918b);
        instance.set(13, 0);
        Calendar instance2 = Calendar.getInstance();
        instance2.set(11, this.f13919c);
        instance2.set(12, this.f13920d);
        instance2.set(13, 0);
        if (instance.after(Calendar.getInstance()) && instance2.before(instance)) {
            instance.add(6, -1);
        }
        if (this.f13919c < this.f13917a) {
            instance2.add(5, 1);
        }
        Date time = instance.getTime();
        Date time2 = instance2.getTime();
        return new Date[]{time, time2};
    }

    public String toString() {
        return "QuietTimeInterval{startHour=" + this.f13917a + ", startMin=" + this.f13918b + ", endHour=" + this.f13919c + ", endMin=" + this.f13920d + '}';
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C3922k c3922k = (C3922k) obj;
        if (this.f13917a != c3922k.f13917a || this.f13918b != c3922k.f13918b || this.f13919c != c3922k.f13919c) {
            return false;
        }
        if (this.f13920d != c3922k.f13920d) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (((((this.f13917a * 31) + this.f13918b) * 31) + this.f13919c) * 31) + this.f13920d;
    }

    public JsonValue mo2767e() {
        Object hashMap = new HashMap();
        hashMap.put("start_hour", Integer.valueOf(this.f13917a));
        hashMap.put("start_min", Integer.valueOf(this.f13918b));
        hashMap.put("end_hour", Integer.valueOf(this.f13919c));
        hashMap.put("end_min", Integer.valueOf(this.f13920d));
        try {
            return JsonValue.m19739b(hashMap);
        } catch (Throwable e) {
            C3783j.m19726c("QuietTimeInterval - Failed to create quiet time interval as json", e);
            return JsonValue.f13565a;
        }
    }

    public static C3922k m20345a(String str) {
        try {
            C3788b f = JsonValue.m19740b(str).m19755f();
            if (f == null || f.m19783c()) {
                return null;
            }
            return new C3921a().m20339a(f.m19780b("start_hour").m19745a(-1)).m20342b(f.m19780b("start_min").m19745a(-1)).m20343c(f.m19780b("end_hour").m19745a(-1)).m20344d(f.m19780b("end_min").m19745a(-1)).m20341a();
        } catch (Throwable e) {
            C3783j.m19726c("QuietTimeInterval - Failed to create quiet time interval from json", e);
            return null;
        }
    }
}
