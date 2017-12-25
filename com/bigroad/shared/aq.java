package com.bigroad.shared;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.C3600n;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public abstract class aq {
    public static final TimeZone f2637a = TimeZone.getTimeZone("UTC");
    public static final TimeZone f2638b = TimeZone.getTimeZone("US/Eastern");
    public static final TimeZone[] f2639c;
    public static final TimeZone[] f2640d = new TimeZone[]{((C0846a) f2643g.get("US/Eastern")).m4211c(), ((C0846a) f2643g.get("US/Central")).m4211c(), ((C0846a) f2643g.get("US/Mountain")).m4211c(), ((C0846a) f2643g.get("US/Pacific")).m4211c(), ((C0846a) f2643g.get("Canada/Newfoundland")).m4211c(), ((C0846a) f2643g.get("Canada/Atlantic")).m4211c(), ((C0846a) f2643g.get("Canada/Eastern")).m4211c(), ((C0846a) f2643g.get("Canada/Central")).m4211c(), ((C0846a) f2643g.get("Canada/Mountain")).m4211c(), ((C0846a) f2643g.get("Canada/Pacific")).m4211c(), ((C0846a) f2643g.get("US/Arizona")).m4211c(), ((C0846a) f2643g.get("US/Alaska")).m4211c(), ((C0846a) f2643g.get("US/Hawaii")).m4211c(), ((C0846a) f2643g.get("Canada/Saskatchewan")).m4211c()};
    private static final ThreadLocal<DateFormat> f2641e = new C08431();
    private static final C0846a[] f2642f = new C0846a[]{new C0846a("Canada/Newfoundland", "common.timeZoneFriendlyName.canadaNewfoundland"), new C0846a("Canada/Atlantic", "common.timeZoneFriendlyName.canadaAtlantic"), new C0846a("Canada/Eastern", "common.timeZoneFriendlyName.canadaEastern"), new C0846a("Canada/Central", "common.timeZoneFriendlyName.canadaCentral"), new C0846a("Canada/Saskatchewan", "common.timeZoneFriendlyName.canadaSaskatchewan"), new C0846a("Canada/Mountain", "common.timeZoneFriendlyName.canadaMountain"), new C0846a("Canada/Pacific", "common.timeZoneFriendlyName.canadaPacific"), new C0846a("US/Eastern", "common.timeZoneFriendlyName.usEastern"), new C0846a("US/Central", "common.timeZoneFriendlyName.usCentral"), new C0846a("US/Arizona", "common.timeZoneFriendlyName.usArizona"), new C0846a("US/Mountain", "common.timeZoneFriendlyName.usMountain"), new C0846a("US/Pacific", "common.timeZoneFriendlyName.usPacific"), new C0846a("US/Alaska", "common.timeZoneFriendlyName.usAlaska"), new C0846a("US/Hawaii", "common.timeZoneFriendlyName.usHawaii")};
    private static final Map<String, C0846a> f2643g = new HashMap();

    static class C08431 extends ThreadLocal<DateFormat> {
        C08431() {
        }

        protected /* synthetic */ Object initialValue() {
            return m4206a();
        }

        protected DateFormat m4206a() {
            DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
            simpleDateFormat.setTimeZone(aq.f2637a);
            return simpleDateFormat;
        }
    }

    static class C08442 implements Comparator<TimeZone> {
        C08442() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m4207a((TimeZone) obj, (TimeZone) obj2);
        }

        public int m4207a(TimeZone timeZone, TimeZone timeZone2) {
            int compareTo = aq.m4219a(timeZone).compareTo(aq.m4219a(timeZone2));
            if (compareTo == 0) {
                compareTo = timeZone2.getRawOffset() - timeZone.getRawOffset();
            }
            if (compareTo == 0) {
                compareTo = aq.m4225b(timeZone, timeZone2);
            }
            if (compareTo == 0) {
                return timeZone.getID().compareTo(timeZone2.getID());
            }
            return compareTo;
        }
    }

    private static final class C0846a {
        private final String f2635a;
        private final String f2636b;

        public C0846a(String str, String str2) {
            this.f2635a = str;
            this.f2636b = str2;
        }

        public String m4209a() {
            return this.f2635a;
        }

        public String m4210b() {
            return this.f2636b;
        }

        public TimeZone m4211c() {
            TimeZone timeZone = TimeZone.getTimeZone(this.f2635a);
            return timeZone.getID().equals(this.f2635a) ? timeZone : null;
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        for (C0846a c0846a : f2642f) {
            f2643g.put(c0846a.m4209a(), c0846a);
            TimeZone c = c0846a.m4211c();
            if (c != null) {
                arrayList.add(c);
            }
        }
        Collections.sort(arrayList, new C08442());
        f2639c = (TimeZone[]) arrayList.toArray(new TimeZone[arrayList.size()]);
    }

    public static long m4214a(long j) {
        return (j / 60000) * 60000;
    }

    public static long m4226b(long j) {
        return (((j + 60000) - 1) / 60000) * 60000;
    }

    public static int m4230c(long j) {
        return (int) (j / 86400000);
    }

    public static long m4213a(int i) {
        return ((long) i) * 86400000;
    }

    private static boolean m4229b(TimeZone timeZone) {
        return timeZone.getID().contains("-");
    }

    private static int m4225b(TimeZone timeZone, TimeZone timeZone2) {
        boolean b = m4229b(timeZone);
        if (b == m4229b(timeZone2)) {
            return 0;
        }
        if (b) {
            return 1;
        }
        return -1;
    }

    public static Calendar m4222a(Calendar calendar) {
        if (calendar == null) {
            return null;
        }
        return (Calendar) calendar.clone();
    }

    public static String m4232d(long j) {
        String str;
        if (j < 0) {
            j = -j;
            str = "-";
        } else {
            str = "";
        }
        long j2 = (j - (3600000 * (j / 3600000))) / 60000;
        return String.format(Locale.US, "%s%d:%02d", new Object[]{str, Long.valueOf(j / 3600000), Long.valueOf(j2)});
    }

    public static Calendar m4224a(TimeZone timeZone, long j) {
        Calendar instance = Calendar.getInstance(timeZone);
        instance.setTimeInMillis(j);
        return instance;
    }

    public static Calendar m4223a(Calendar calendar, int i, int i2) {
        calendar.set(11, i);
        calendar.set(12, i2);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar;
    }

    public static Calendar m4227b(Calendar calendar) {
        return m4223a(calendar, 0, 0);
    }

    public static Calendar m4228b(TimeZone timeZone, long j) {
        return m4227b(m4224a(timeZone, j));
    }

    public static String m4216a(String str) {
        C0846a c0846a = (C0846a) f2643g.get(str);
        return c0846a == null ? str : c0846a.m4210b();
    }

    public static String m4219a(TimeZone timeZone) {
        String id = timeZone.getID();
        int indexOf = id.indexOf(47);
        if (indexOf >= 0) {
            return id.substring(0, indexOf);
        }
        return null;
    }

    public static String m4217a(Calendar calendar, int i) {
        return m4220a(calendar.getTimeZone(), calendar.getTime(), i);
    }

    public static String m4218a(Calendar calendar, int i, Locale locale) {
        return m4221a(calendar.getTimeZone(), calendar.getTime(), i, locale);
    }

    public static String m4220a(TimeZone timeZone, Date date, int i) {
        return timeZone.getDisplayName(timeZone.inDaylightTime(date), i);
    }

    public static String m4221a(TimeZone timeZone, Date date, int i, Locale locale) {
        return timeZone.getDisplayName(timeZone.inDaylightTime(date), i, locale);
    }

    public static Calendar m4231c(Calendar calendar) {
        Calendar instance = Calendar.getInstance(f2637a);
        instance.clear();
        instance.set(calendar.get(1), calendar.get(2), calendar.get(5));
        return instance;
    }

    public static <T extends ao> T m4215a(List<T> list, final long j) {
        Optional b = C3600n.m18814b(list, new Predicate<ao>() {
            public /* synthetic */ boolean apply(Object obj) {
                return m4208a((ao) obj);
            }

            public boolean m4208a(ao aoVar) {
                return aoVar.mo690a(j);
            }
        });
        return b.isPresent() ? (ao) b.get() : null;
    }

    public static String m4233e(long j) {
        return ((DateFormat) f2641e.get()).format(Long.valueOf(j));
    }
}
