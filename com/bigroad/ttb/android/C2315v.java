package com.bigroad.ttb.android;

import android.content.Context;
import android.os.Handler;
import com.bigroad.shared.MobileAppDiagnosticFlags;
import com.bigroad.shared.ap;
import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.shared.duty.C0890f.C0886a;
import com.bigroad.shared.validation.C1157a;
import com.bigroad.shared.validation.C1164d;
import com.bigroad.shared.validation.C1168m;
import com.bigroad.shared.validation.C1176p;
import com.bigroad.shared.validation.C1177q;
import com.bigroad.shared.validation.ValidationError.Category;
import com.bigroad.shared.validation.ValidationError.Severity;
import com.bigroad.shared.validation.model.DailyLog;
import com.bigroad.shared.validation.model.DailyLogHeader;
import com.bigroad.shared.validation.model.Dvir;
import com.bigroad.shared.validation.model.DvirInspection;
import com.bigroad.shared.validation.model.Event;
import com.bigroad.shared.validation.model.Event.Field;
import com.bigroad.shared.validation.p024b.C1161f.C1160a;
import com.bigroad.shared.validation.p028a.C1151b;
import com.bigroad.shared.validation.p028a.C1156e;
import com.bigroad.ttb.android.C2226q.C1221a;
import com.bigroad.ttb.android.C2474y.C1182a;
import com.bigroad.ttb.android.C2474y.C1183b;
import com.bigroad.ttb.android.TruckManager.C1203b;
import com.bigroad.ttb.android.TruckManager.ChangeListener.Priority;
import com.bigroad.ttb.android.event.EventManager;
import com.bigroad.ttb.android.event.EventManager.C1199e;
import com.bigroad.ttb.android.event.EventManager.ChangeListener;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.p029c.C1736b;
import com.bigroad.ttb.android.p029c.C1736b.C1219a;
import com.bigroad.ttb.android.p039h.C2085a;
import com.bigroad.ttb.android.p039h.C2091e;
import com.bigroad.ttb.protocol.TTProtocol;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TimeZone;
import java.util.TreeMap;

public class C2315v {
    private static C2315v f7967a;
    private final Handler f7968b = new Handler();
    private final C1736b f7969c = OurApplication.m6296r();
    private final C2226q f7970d = OurApplication.m6297s();
    private final EventManager f7971e = OurApplication.m6295q();
    private final TruckManager f7972f = OurApplication.m6294p();
    private final C2474y f7973g = OurApplication.m6285g();
    private final ap f7974h = OurApplication.m6269Z();
    private final SortedMap<Integer, C2314b> f7975i = new TreeMap();
    private final Set<C1428a> f7976j = new HashSet();
    private final C1219a f7977k = new C23081(this);
    private final C1221a f7978l = new C23092(this);
    private final ChangeListener f7979m = new C23103(this);
    private final TruckManager.ChangeListener f7980n = new C23114(this);
    private final C1182a f7981o = new C23125(this);
    private final Runnable f7982p = new C23136(this);

    public interface C1428a {
        void mo994a(C2315v c2315v);
    }

    class C23081 implements C1219a {
        final /* synthetic */ C2315v f7959a;

        C23081(C2315v c2315v) {
            this.f7959a = c2315v;
        }

        public void mo904a(C1736b c1736b) {
            this.f7959a.m11290b();
        }
    }

    class C23092 implements C1221a {
        final /* synthetic */ C2315v f7960a;

        C23092(C2315v c2315v) {
            this.f7960a = c2315v;
        }

        public void mo905a(C2226q c2226q) {
            this.f7960a.m11290b();
        }
    }

    class C23103 extends C1199e {
        final /* synthetic */ C2315v f7961a;

        C23103(C2315v c2315v) {
            this.f7961a = c2315v;
        }

        public void mo884a(EventManager eventManager, boolean z) {
            this.f7961a.m11290b();
        }
    }

    class C23114 extends C1203b {
        final /* synthetic */ C2315v f7962a;

        C23114(C2315v c2315v) {
            this.f7962a = c2315v;
        }

        public void mo893a() {
            this.f7962a.m11290b();
        }
    }

    class C23125 extends C1183b {
        final /* synthetic */ C2315v f7963a;

        C23125(C2315v c2315v) {
            this.f7963a = c2315v;
        }

        public void mo868e(C2474y c2474y) {
            this.f7963a.m11290b();
        }
    }

    class C23136 implements Runnable {
        final /* synthetic */ C2315v f7964a;

        C23136(C2315v c2315v) {
            this.f7964a = c2315v;
        }

        public void run() {
            this.f7964a.m11292c();
        }
    }

    private static class C2314b {
        private final int f7965a;
        private DailyLog f7966b = null;

        public C2314b(int i) {
            this.f7965a = i;
        }

        public DailyLog m11283a() {
            return this.f7966b;
        }

        public void m11284a(DailyLog dailyLog) {
            this.f7966b = dailyLog;
        }
    }

    public static C2315v m11286a(Context context) {
        if (f7967a == null) {
            f7967a = new C2315v();
        }
        return f7967a;
    }

    private C2315v() {
        this.f7969c.m8474a(this.f7977k);
        this.f7970d.m10974a(this.f7978l);
        this.f7971e.m10012a(this.f7979m);
        this.f7973g.m12184a(this.f7981o);
        this.f7972f.m6560a(this.f7980n, Priority.LOG_DAY_STATUS_MANAGER);
        m11290b();
        m11293d();
    }

    private void m11290b() {
        this.f7975i.clear();
        m11288a(C2091e.m10474a(), this.f7969c.m8485c());
        m11294e();
    }

    private void m11292c() {
        m11288a(DailyLogUtils.m4284a(this.f7973g.m12228r().m4879m()), this.f7969c.m8485c());
        m11294e();
        m11293d();
    }

    private void m11293d() {
        this.f7968b.postDelayed(this.f7982p, 60000);
    }

    public DailyLog m11297a(int i) {
        return m11285a(i, new C2085a());
    }

    private DailyLog m11285a(int i, C1157a c1157a) {
        C1160a c1160a = new C1160a(i);
        TTProtocol.DailyLog b = OurApplication.m6296r().m8480b(i);
        if (b != null) {
            c1160a.m5899a(new C1151b(b, OurApplication.af(), this.f7974h.mo914b()));
        }
        c1160a.m5902b(C1156e.m5880a(OurApplication.m6297s().m10973a(i)));
        c1160a.m5900a(new C0886a(OurApplication.m6295q().m10061k(), i, TimeZone.getTimeZone(c1157a.mo1221a(i).mo703a())).m4479a(this.f7974h.mo914b()));
        return c1160a.m5901a();
    }

    private void m11288a(int i, int i2) {
        C1157a c2085a = new C2085a();
        while (i <= i2) {
            C1164d c1164d = new C1164d(c2085a);
            DailyLog a = m11285a(i, c2085a);
            c1164d.m5930a(a, this.f7974h.mo914b());
            if (a.mo717B()) {
                C2314b c2314b = (C2314b) this.f7975i.get(Integer.valueOf(i));
                if (c2314b == null) {
                    c2314b = m11295i(i);
                }
                c2314b.m11284a(a);
            }
            i++;
        }
        C1177q d = c2085a.mo1224d();
        if (d.m5965a() > 750) {
            C2134e.m10670a(MobileAppDiagnosticFlags.LOG_SLOW_UI, 5, "TT-LogDayStatusManager", "Validation completed in " + d.m5965a() + "ms; gap: " + d.m5967b() + "ms;");
        }
    }

    private C2314b m11295i(int i) {
        C2314b c2314b = new C2314b(i);
        this.f7975i.put(Integer.valueOf(i), c2314b);
        return c2314b;
    }

    public Severity m11302b(int i) {
        DailyLog c = m11304c(i);
        if (c != null) {
            Severity[] values = Severity.values();
            for (int length = values.length - 1; length >= 0; length--) {
                if (c.mo718a(EnumSet.of(values[length]))) {
                    return values[length];
                }
            }
        }
        return null;
    }

    public DailyLog m11304c(int i) {
        C2314b c2314b = (C2314b) this.f7975i.get(Integer.valueOf(i));
        return c2314b == null ? null : c2314b.m11283a();
    }

    private List<C1168m> m11287a(int i, Category category) {
        DailyLog c = m11304c(i);
        if (c == null) {
            return Collections.emptyList();
        }
        return c.mo716A().m5963c(category);
    }

    public List<C1168m> m11305d(int i) {
        return m11287a(i, Category.DRIVE_TIME);
    }

    public List<C1168m> m11306e(int i) {
        return m11287a(i, Category.SENSOR_FAILURE);
    }

    public C1176p<Field> m11298a(int i, Event event) {
        DailyLog c = m11304c(i);
        if (c == null) {
            return null;
        }
        for (Event event2 : c.mo859c()) {
            if (Arrays.equals(event2.mo719s(), event.mo719s())) {
                return event2.mo716A();
            }
        }
        return null;
    }

    public C1176p<DailyLog.Field> m11307f(int i) {
        DailyLog c = m11304c(i);
        if (c == null) {
            return null;
        }
        return c.mo716A();
    }

    public C1176p<DailyLogHeader.Field> m11308g(int i) {
        DailyLog c = m11304c(i);
        if (c == null || c.mo858b() == null) {
            return null;
        }
        return c.mo858b().mo716A();
    }

    public C1176p<Dvir.Field> m11300a(TTProtocol.Dvir dvir) {
        DailyLog c = m11304c(dvir.getLogDay());
        if (c == null) {
            return null;
        }
        for (Dvir dvir2 : c.mo860d()) {
            if (Arrays.equals(dvir2.mo851a(), dvir.getId().m19091d())) {
                return dvir2.mo716A();
            }
        }
        return null;
    }

    public C1176p<DvirInspection.Field> m11299a(int i, TTProtocol.DvirInspection dvirInspection) {
        DailyLog c = m11304c(i);
        if (c == null) {
            return null;
        }
        for (Dvir e : c.mo860d()) {
            for (DvirInspection dvirInspection2 : e.mo855e()) {
                if (Arrays.equals(dvirInspection2.mo844a(), dvirInspection.getId().m19091d())) {
                    return dvirInspection2.mo716A();
                }
            }
        }
        return null;
    }

    public int m11296a() {
        int i = 0;
        for (C2314b c2314b : this.f7975i.values()) {
            int i2;
            if (c2314b.m11283a() == null || !c2314b.m11283a().mo718a(EnumSet.of(Severity.ERROR))) {
                i2 = i;
            } else {
                i2 = i + 1;
            }
            i = i2;
        }
        return i;
    }

    public boolean m11309h(int i) {
        C2314b c2314b = (C2314b) this.f7975i.get(Integer.valueOf(i));
        return (c2314b == null || c2314b.m11283a() == null || !c2314b.m11283a().mo718a(EnumSet.of(Severity.ERROR))) ? false : true;
    }

    public void m11301a(C1428a c1428a) {
        this.f7976j.add(c1428a);
    }

    public void m11303b(C1428a c1428a) {
        this.f7976j.remove(c1428a);
    }

    private void m11294e() {
        for (C1428a a : (C1428a[]) this.f7976j.toArray(new C1428a[this.f7976j.size()])) {
            a.mo994a(this);
        }
    }
}
