package com.bigroad.ttb.android;

import android.location.Location;
import android.os.Handler;
import com.bigroad.shared.MobileAppDiagnosticFlags;
import com.bigroad.shared.ap;
import com.bigroad.shared.aq;
import com.bigroad.shared.eobr.turbo.messages.C1051n;
import com.bigroad.ttb.android.C2474y.C1182a;
import com.bigroad.ttb.android.C2474y.C1183b;
import com.bigroad.ttb.android.location.LocationTracker;
import com.bigroad.ttb.android.location.LocationTracker.C1191c;
import com.bigroad.ttb.android.location.LocationTracker.C1192d;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.p030a.C1257b;
import com.bigroad.ttb.android.p035d.C1790a;
import com.bigroad.ttb.protocol.TTProtocol.SyncResponse;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

public class ClockMonitor {
    private static ClockMonitor f4037a;
    private final Handler f4038b;
    private final C1790a f4039c;
    private final LocationTracker f4040d;
    private final C2474y f4041e;
    private final C2154m f4042f;
    private final ap f4043g;
    private final Set<C1196a> f4044h;
    private State f4045i;
    private boolean f4046j;
    private boolean f4047k;
    private long f4048l;
    private long f4049m;
    private Location f4050n;
    private SourceType f4051o;
    private long f4052p;
    private long f4053q;
    private Map<SourceType, C1197b> f4054r;
    private final C1182a f4055s;
    private final C1191c f4056t;
    private final Runnable f4057u;

    class C11901 extends C1183b {
        final /* synthetic */ ClockMonitor f4018a;

        C11901(ClockMonitor clockMonitor) {
            this.f4018a = clockMonitor;
        }

        public void mo865b(C2474y c2474y) {
            this.f4018a.f4047k = c2474y.m12157B();
        }
    }

    class C11932 extends C1192d {
        final /* synthetic */ ClockMonitor f4019a;

        C11932(ClockMonitor clockMonitor) {
            this.f4019a = clockMonitor;
        }

        public void mo880a(Location location) {
            this.f4019a.f4050n = location;
        }
    }

    class C11943 implements Runnable {
        final /* synthetic */ ClockMonitor f4020a;

        C11943(ClockMonitor clockMonitor) {
            this.f4020a = clockMonitor;
        }

        public void run() {
            this.f4020a.m6097i();
            for (C1197b a : this.f4020a.f4054r.values()) {
                this.f4020a.m6086a(a, false);
            }
            this.f4020a.m6094f();
        }
    }

    private enum SourceType {
        SERVER(0),
        GPS(1);
        
        private int m_priority;

        private SourceType(int i) {
            this.m_priority = i;
        }

        public boolean m6076a(SourceType sourceType) {
            return this.m_priority < sourceType.m_priority;
        }
    }

    public enum State {
        SKEW_UNKNOWN,
        CONFIRMED_OKAY,
        CONFIRMED_SKEW,
        UNCONFIRMED_OKAY,
        UNCONFIRMED_SKEW
    }

    public interface C1196a {
        void mo1260a(ClockMonitor clockMonitor);
    }

    private static class C1197b {
        SourceType f4031a;
        boolean f4032b;
        long f4033c;
        long f4034d;
        long f4035e;
        long f4036f;

        public C1197b(SourceType sourceType) {
            this(sourceType, null, null, null, null);
        }

        public C1197b(SourceType sourceType, Long l, Long l2, Long l3, Long l4) {
            this.f4031a = sourceType;
            if (l == null || l2 == null || l3 == null || l4 == null) {
                this.f4032b = false;
                this.f4033c = 0;
                this.f4034d = 0;
                this.f4035e = 0;
                this.f4036f = 0;
                return;
            }
            this.f4032b = true;
            this.f4033c = l.longValue();
            this.f4034d = l2.longValue();
            this.f4035e = l3.longValue();
            this.f4036f = l4.longValue();
        }

        public String toString() {
            return "Source{type=" + this.f4031a + ",initialized=" + this.f4032b + ",expectedTime=" + this.f4033c + ",wallTime=" + this.f4034d + ",bootTime=" + this.f4035e + ",skew=" + this.f4036f + "}";
        }
    }

    public static ClockMonitor m6079a() {
        if (f4037a == null) {
            f4037a = new ClockMonitor();
        }
        return f4037a;
    }

    private void m6094f() {
        this.f4038b.postDelayed(this.f4057u, 10000);
    }

    private ClockMonitor() {
        C1197b c1197b;
        this.f4038b = new Handler();
        this.f4039c = OurApplication.m6287i();
        this.f4040d = OurApplication.m6302x();
        this.f4041e = OurApplication.m6285g();
        this.f4042f = OurApplication.m6248E();
        this.f4043g = OurApplication.m6269Z();
        this.f4044h = new HashSet();
        this.f4046j = false;
        this.f4047k = false;
        this.f4048l = 0;
        this.f4049m = 0;
        this.f4051o = null;
        this.f4052p = 0;
        this.f4053q = 0;
        this.f4055s = new C11901(this);
        this.f4056t = new C11932(this);
        this.f4057u = new C11943(this);
        this.f4045i = State.SKEW_UNKNOWN;
        this.f4048l = this.f4043g.mo913a();
        this.f4049m = this.f4043g.mo915c();
        this.f4054r = new EnumMap(SourceType.class);
        Long d = this.f4039c.m8769d("wall_skew");
        if (d == null) {
            m6096h();
        } else {
            this.f4052p = d.longValue();
            c1197b = new C1197b(SourceType.SERVER, this.f4039c.m8769d("server_time"), this.f4039c.m8769d("wall_time"), this.f4039c.m8769d("boot_time"), this.f4039c.m8769d("server_skew"));
            if (c1197b.f4032b) {
                this.f4054r.put(SourceType.SERVER, c1197b);
            } else {
                m6082a(SourceType.SERVER);
            }
            c1197b = new C1197b(SourceType.GPS, this.f4039c.m8769d("gps_time"), this.f4039c.m8769d("gps_wall_time"), this.f4039c.m8769d("gps_boot_time"), this.f4039c.m8769d("gps_skew"));
            if (c1197b.f4032b) {
                this.f4054r.put(SourceType.GPS, c1197b);
            } else {
                m6082a(SourceType.GPS);
            }
        }
        if (this.f4054r.isEmpty()) {
            this.f4052p = 0;
        }
        this.f4040d.m10599a(this.f4056t);
        this.f4041e.m12184a(this.f4055s);
        this.f4047k = this.f4041e.m12157B();
        StringBuilder append = new StringBuilder("init: ").append("wallSkew=").append(this.f4052p).append(" ");
        m6097i();
        append.append("sources={");
        for (C1197b c1197b2 : this.f4054r.values()) {
            m6086a(c1197b2, true);
            append.append(c1197b2);
        }
        append.append("}");
        C2134e.m10673a("TT-ClockMonitor", append.toString());
        m6094f();
    }

    private static void m6081a(int i, C1197b c1197b, String str) {
        C2134e.m10667a(i, "TT-ClockMonitor", "(source=" + c1197b.f4031a + ") " + str);
    }

    private static void m6085a(C1197b c1197b, String str) {
    }

    private static void m6092b(C1197b c1197b, String str) {
        m6081a(5, c1197b, str);
    }

    public void m6099a(C1196a c1196a) {
        this.f4044h.add(c1196a);
    }

    private void m6095g() {
        for (C1196a a : (C1196a[]) this.f4044h.toArray(new C1196a[this.f4044h.size()])) {
            a.mo1260a(this);
        }
    }

    public long m6102b() {
        return this.f4043g.mo913a() - this.f4053q;
    }

    public boolean m6103c() {
        return this.f4045i == State.CONFIRMED_OKAY;
    }

    public boolean m6104d() {
        return this.f4045i == State.CONFIRMED_SKEW;
    }

    public void m6100a(SyncResponse syncResponse, C1263c c1263c) {
        if (syncResponse.hasServerTime()) {
            m6083a(SourceType.SERVER, syncResponse.getServerTime(), c1263c.m6657d(), c1263c.m6658e());
        }
    }

    public void m6098a(C1051n c1051n, long j, long j2) {
        m6083a(SourceType.GPS, c1051n.f3447e, j, j2);
    }

    private void m6084a(C1197b c1197b) {
        m6085a(c1197b, "Persisting to DB.");
        Map hashMap = new HashMap();
        switch (c1197b.f4031a) {
            case SERVER:
                hashMap.put("server_time", Long.valueOf(c1197b.f4033c));
                hashMap.put("wall_time", Long.valueOf(c1197b.f4034d));
                hashMap.put("boot_time", Long.valueOf(c1197b.f4035e));
                break;
            case GPS:
                hashMap.put("gps_time", Long.valueOf(c1197b.f4033c));
                hashMap.put("gps_wall_time", Long.valueOf(c1197b.f4034d));
                hashMap.put("gps_boot_time", Long.valueOf(c1197b.f4035e));
                break;
        }
        this.f4039c.m8745a(hashMap);
    }

    private void m6083a(SourceType sourceType, long j, long j2, long j3) {
        if (j2 > 0 && j > 0) {
            C1197b c1197b = (C1197b) this.f4054r.get(sourceType);
            if (c1197b == null) {
                c1197b = new C1197b(sourceType);
                this.f4054r.put(sourceType, c1197b);
            }
            m6085a(c1197b, "handleClockSourceReportedTime: clockSourceTime=" + j + " receivedAtWallTime=" + j2 + " receivedAtBootTime=" + j3);
            c1197b.f4033c = j;
            c1197b.f4034d = j2;
            c1197b.f4035e = j3;
            c1197b.f4032b = true;
            m6084a(c1197b);
            m6097i();
            m6086a(c1197b, false);
        }
    }

    private void m6086a(C1197b c1197b, boolean z) {
        if (c1197b.f4032b) {
            StringBuilder stringBuilder = new StringBuilder("calculateSkew: " + c1197b + " ");
            long a = this.f4043g.mo913a();
            long c = this.f4043g.mo915c();
            stringBuilder.append("nowWallTime=").append(a).append(" ");
            stringBuilder.append("nowBootTime=").append(c).append(" ");
            if (c < c1197b.f4035e) {
                m6092b(c1197b, "App started post boot before boot receiver. Running manually.");
                this.f4046j = true;
                m6091b(c1197b);
                return;
            }
            c -= c1197b.f4035e;
            long j = c1197b.f4034d + c;
            long j2 = c1197b.f4034d - c1197b.f4033c;
            stringBuilder.append("timeSinceSync={").append(c).append(", nowBootTime - source.bootTime} ");
            stringBuilder.append("nowExtrapolated={").append(j).append(", source.wallTime + timeSinceSync} ");
            stringBuilder.append("clockSourceSkew={").append(j2).append(", source.wallTime - source.expectedTime} ");
            c1197b.f4036f = j2;
            switch (c1197b.f4031a) {
                case SERVER:
                    this.f4039c.m8740a("server_skew", Long.valueOf(c1197b.f4036f));
                    break;
                case GPS:
                    this.f4039c.m8740a("gps_skew", Long.valueOf(c1197b.f4036f));
                    break;
            }
            if (c1197b.f4031a == SourceType.GPS && c > 300000) {
                m6085a(c1197b, "Ignoring stale GPS time");
                return;
            } else if (this.f4051o == null || !this.f4051o.m6076a(c1197b.f4031a)) {
                this.f4051o = c1197b.f4031a;
                this.f4052p = a - j;
                this.f4053q = this.f4052p + j2;
                this.f4039c.m8740a("wall_skew", Long.valueOf(this.f4052p));
                stringBuilder.append("wallSkew={").append(this.f4052p).append(", nowWallTime - nowExtrapolated} ");
                stringBuilder.append("totalSkew={").append(this.f4053q).append(", clockSourceSkew - wallSkew} ");
                State state = this.f4045i;
                boolean a2 = this.f4042f.m10738a(this.f4053q);
                if (z) {
                    this.f4045i = a2 ? State.UNCONFIRMED_SKEW : State.UNCONFIRMED_OKAY;
                } else {
                    this.f4045i = a2 ? State.CONFIRMED_SKEW : State.CONFIRMED_OKAY;
                }
                stringBuilder.append("clockState=").append(this.f4045i).append(" ");
                stringBuilder.append("clockStateChanged=").append(state != this.f4045i).append(" ");
                if (state != this.f4045i) {
                    m6095g();
                }
                m6085a(c1197b, stringBuilder.toString());
                return;
            } else {
                m6085a(c1197b, "Ignoring lower priority source, " + this.f4051o + " is highest.");
                return;
            }
        }
        m6085a(c1197b, "not initialized.");
    }

    private void m6091b(C1197b c1197b) {
        long a = this.f4043g.mo913a();
        long c = this.f4043g.mo915c();
        c1197b.f4033c = a - c1197b.f4036f;
        c1197b.f4034d = a;
        c1197b.f4035e = c - this.f4052p;
        m6081a(2, c1197b, "migratePostBoot: " + c1197b + " nowWallTime=" + a + " nowBootTime=" + c + " source.expectedTime={" + c1197b.f4033c + ", nowWallTime - source.skew} source.wallTime={" + c1197b.f4034d + ", nowWallTime} source.bootTime={" + c1197b.f4035e + ", nowBootTime - m_wallSkew}");
        m6084a(c1197b);
    }

    private void m6096h() {
        m6082a(null);
    }

    private void m6082a(SourceType sourceType) {
        C2134e.m10673a("TT-ClockMonitor", "Clearing synced times (null = all) for: " + sourceType);
        if (sourceType == null) {
            this.f4052p = 0;
            this.f4039c.m8756b("wall_skew");
        }
        if (sourceType == null || sourceType == SourceType.SERVER) {
            this.f4039c.m8756b("server_time");
            this.f4039c.m8756b("wall_time");
            this.f4039c.m8756b("boot_time");
            this.f4039c.m8756b("server_skew");
        }
        if (sourceType == null || sourceType == SourceType.GPS) {
            this.f4039c.m8756b("gps_time");
            this.f4039c.m8756b("gps_wall_time");
            this.f4039c.m8756b("gps_boot_time");
            this.f4039c.m8756b("gps_skew");
        }
    }

    private void m6097i() {
        if (this.f4047k) {
            long a = this.f4043g.mo913a();
            long c = this.f4043g.mo915c();
            long j = c - this.f4049m;
            long j2 = a - this.f4048l;
            if (Math.abs(j - j2) > 60000) {
                long j3;
                if (this.f4050n == null) {
                    j3 = 0;
                } else {
                    j3 = this.f4050n.getTime();
                }
                Long a2 = C1257b.m6609a(this.f4050n);
                Calendar instance = Calendar.getInstance();
                MobileAppDiagnosticFlags mobileAppDiagnosticFlags = MobileAppDiagnosticFlags.LOG_CLOCK_CHANGES;
                String str = "TT-ClockMonitor";
                String str2 = "Unexpected wall time change > 1 minute:\nCurrent State: %s\nSkew (before this change): %d\nSkew Source: %s\nNow: %d\nExpected: %d\nDifference: %d\nLast GPS time: %d recorded %dms ago.\nCurrent timezone: %s (%s)\n";
                Object[] objArr = new Object[10];
                objArr[0] = this.f4045i;
                objArr[1] = Long.valueOf(this.f4053q);
                objArr[2] = this.f4051o;
                objArr[3] = Long.valueOf(a);
                objArr[4] = Long.valueOf(this.f4048l + j);
                objArr[5] = Long.valueOf(j2 - j);
                objArr[6] = Long.valueOf(j3);
                objArr[7] = Long.valueOf(a2 == null ? 0 : c - a2.longValue());
                objArr[8] = aq.m4217a(instance, 1);
                objArr[9] = m6080a(instance);
                C2134e.m10670a(mobileAppDiagnosticFlags, 4, str, String.format(str2, objArr));
            }
            this.f4049m = c;
            this.f4048l = a;
        }
    }

    public void m6105e() {
        if (!this.f4046j) {
            for (C1197b c1197b : this.f4054r.values()) {
                if (c1197b.f4032b) {
                    m6091b(c1197b);
                }
            }
        }
    }

    public void m6101a(String str) {
        if (str != null && this.f4047k) {
            Calendar instance = Calendar.getInstance(TimeZone.getTimeZone(str));
            C2134e.m10670a(MobileAppDiagnosticFlags.LOG_CLOCK_CHANGES, 4, "TT-ClockMonitor", String.format("Timezone changed to: %s (%s)", new Object[]{str, m6080a(instance)}));
        }
        m6097i();
        for (C1197b c1197b : this.f4054r.values()) {
            if (c1197b.f4032b) {
                m6086a(c1197b, false);
            }
        }
    }

    private String m6080a(Calendar calendar) {
        return new SimpleDateFormat("Z").format(calendar.getTime());
    }
}
