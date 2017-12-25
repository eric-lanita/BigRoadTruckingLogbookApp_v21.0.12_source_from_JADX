package com.bigroad.shared.model;

import com.bigroad.shared.C0855c;
import com.bigroad.shared.C1130o;
import com.bigroad.shared.aa;
import com.bigroad.shared.al;
import com.bigroad.shared.ao;
import com.bigroad.shared.duty.C0889h;
import com.bigroad.shared.duty.C0907o;
import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.EventType;
import com.bigroad.ttb.protocol.TTProtocol.RelativeLocation;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class C1112c implements C0889h {
    public static final Comparator<C1112c> f3666a = new C11091();
    private final Long f3667A;
    private final Long f3668B;
    private final Integer f3669C;
    private final List<Event> f3670D;
    private final byte[] f3671b;
    private final Long f3672c;
    private final ao f3673d;
    private final ao f3674e;
    private final Long f3675f;
    private final Long f3676g;
    private final boolean f3677h;
    private final C1126j f3678i;
    private final String f3679j;
    private final String f3680k;
    private final boolean f3681l;
    private final Long f3682m;
    private final byte[] f3683n;
    private final String f3684o;
    private final Long f3685p;
    private final Long f3686q;
    private final Integer f3687r;
    private final Long f3688s;
    private final Integer f3689t;
    private final EventType f3690u;
    private final String f3691v;
    private final String f3692w;
    private final String f3693x;
    private final String f3694y;
    private final RelativeLocation f3695z;

    static class C11091 implements Comparator<C1112c> {
        C11091() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m5516a((C1112c) obj, (C1112c) obj2);
        }

        public int m5516a(C1112c c1112c, C1112c c1112c2) {
            int c = aa.m4141c(c1112c.mo721a(), c1112c2.mo721a());
            if (c == 0) {
                return C0855c.f2653a.compare(c1112c.m5582b(), c1112c2.m5582b());
            }
            return c;
        }
    }

    public interface C1110a {
        Long mo783A();

        Integer mo784B();

        byte[] mo785a();

        Long mo786b();

        long mo787c();

        Long mo788d();

        Long mo789e();

        C1126j mo790f();

        String mo791g();

        String mo792h();

        boolean mo793i();

        Long mo794j();

        byte[] mo795k();

        String mo796l();

        Long mo797m();

        Long mo798n();

        Integer mo799o();

        String mo800p();

        String mo801q();

        String mo802r();

        String mo803s();

        RelativeLocation mo804t();

        List<Event> mo805u();

        EventType mo806v();

        C0907o mo807w();

        Long mo808x();

        Integer mo809y();

        Long mo810z();
    }

    public static class C1111b implements C1110a {
        private List<Event> f3637A = new ArrayList();
        private EventType f3638B = EventType.OFF_DUTY;
        private List<C1112c> f3639C = new ArrayList();
        private final C0907o f3640a;
        private byte[] f3641b = null;
        private Long f3642c = null;
        private long f3643d = 0;
        private Long f3644e = null;
        private Long f3645f = null;
        private C1126j f3646g = null;
        private String f3647h = null;
        private String f3648i = null;
        private boolean f3649j = false;
        private Long f3650k = null;
        private byte[] f3651l = null;
        private String f3652m = null;
        private Long f3653n = null;
        private Long f3654o = null;
        private Integer f3655p = null;
        private Long f3656q = null;
        private Integer f3657r = null;
        private String f3658s = null;
        private String f3659t = null;
        private String f3660u = null;
        private String f3661v = null;
        private RelativeLocation f3662w = null;
        private Long f3663x = null;
        private Long f3664y = null;
        private Integer f3665z = null;

        public C1111b(C0907o c0907o) {
            this.f3640a = c0907o;
        }

        public C1111b m5550a(byte[] bArr, Long l, long j, Long l2, Long l3, C1126j c1126j, String str, String str2, boolean z, Long l4, byte[] bArr2, String str3, Long l5, Long l6, Integer num, Long l7, Integer num2, EventType eventType, String str4, String str5, String str6, String str7, RelativeLocation relativeLocation, long j2, Long l8, Long l9, Integer num3) {
            m5545D();
            if (this.f3639C.isEmpty()) {
                List list = this.f3637A;
                this.f3637A = new ArrayList();
                m5546a(j);
                this.f3637A = list;
            }
            this.f3641b = bArr;
            this.f3642c = l;
            this.f3643d = j;
            this.f3644e = l2;
            this.f3645f = l3;
            this.f3646g = c1126j;
            this.f3647h = str;
            this.f3648i = str2;
            this.f3649j = z;
            this.f3650k = l4;
            this.f3651l = bArr2;
            this.f3652m = str3;
            this.f3653n = l5;
            this.f3654o = l6;
            this.f3655p = num;
            this.f3656q = l7;
            this.f3657r = num2;
            this.f3638B = eventType;
            this.f3658s = str4;
            this.f3659t = str5;
            this.f3660u = str6;
            this.f3661v = str7;
            this.f3662w = relativeLocation;
            this.f3663x = l8;
            this.f3664y = l9;
            this.f3665z = num3;
            m5546a(j2);
            return this;
        }

        public void m5551a(Event event) {
            this.f3637A.add(event);
        }

        public List<C1112c> m5549C() {
            m5545D();
            List<C1112c> list = this.f3639C;
            this.f3639C = null;
            return list;
        }

        private void m5546a(long j) {
            if (j > this.f3640a.mo697f() && this.f3643d < this.f3640a.mo698g()) {
                C1112c c1112c = new C1112c(this, j);
                this.f3637A = new ArrayList();
                this.f3639C.add(c1112c);
            }
        }

        private void m5545D() {
            if (this.f3639C == null) {
                throw new IllegalStateException("Unable to add events: builder already finished.");
            }
        }

        public byte[] mo785a() {
            return this.f3641b;
        }

        public Long mo786b() {
            return this.f3642c;
        }

        public long mo787c() {
            return this.f3643d;
        }

        public Long mo788d() {
            return this.f3644e;
        }

        public Long mo789e() {
            return this.f3645f;
        }

        public C1126j mo790f() {
            return this.f3646g;
        }

        public String mo791g() {
            return this.f3647h;
        }

        public String mo792h() {
            return this.f3648i;
        }

        public boolean mo793i() {
            return this.f3649j;
        }

        public Long mo794j() {
            return this.f3650k;
        }

        public byte[] mo795k() {
            return this.f3651l;
        }

        public String mo796l() {
            return this.f3652m;
        }

        public Long mo797m() {
            return this.f3653n;
        }

        public Long mo798n() {
            return this.f3654o;
        }

        public Integer mo799o() {
            return this.f3655p;
        }

        public String mo800p() {
            return this.f3658s;
        }

        public String mo801q() {
            return this.f3659t;
        }

        public String mo802r() {
            return this.f3660u;
        }

        public String mo803s() {
            return this.f3661v;
        }

        public RelativeLocation mo804t() {
            return this.f3662w;
        }

        public List<Event> mo805u() {
            return this.f3637A;
        }

        public C0907o mo807w() {
            return this.f3640a;
        }

        public Long mo808x() {
            return this.f3656q;
        }

        public Integer mo809y() {
            return this.f3657r;
        }

        public EventType mo806v() {
            return this.f3638B;
        }

        public Long mo810z() {
            return this.f3663x;
        }

        public Long mo783A() {
            return this.f3664y;
        }

        public Integer mo784B() {
            return this.f3665z;
        }
    }

    public C1112c(C1110a c1110a, long j) {
        this.f3671b = c1110a.mo785a();
        this.f3672c = c1110a.mo786b();
        C0907o w = c1110a.mo807w();
        this.f3673d = new al(c1110a.mo787c(), j);
        this.f3674e = new al(Math.max(c1110a.mo787c(), w.mo697f()), Math.min(j, w.mo698g()));
        this.f3675f = c1110a.mo788d();
        this.f3676g = c1110a.mo789e();
        this.f3677h = !C1112c.m5580a(this.f3674e.mo697f(), this.f3674e.mo698g(), w.m4585b());
        this.f3678i = c1110a.mo790f();
        this.f3679j = c1110a.mo791g();
        this.f3680k = c1110a.mo792h();
        this.f3681l = c1110a.mo793i();
        this.f3682m = c1110a.mo794j();
        this.f3683n = c1110a.mo795k();
        this.f3684o = c1110a.mo796l();
        this.f3685p = c1110a.mo797m();
        this.f3686q = c1110a.mo798n();
        this.f3687r = c1110a.mo799o();
        this.f3691v = c1110a.mo800p();
        this.f3692w = c1110a.mo801q();
        this.f3693x = c1110a.mo802r();
        this.f3694y = c1110a.mo803s();
        this.f3670D = c1110a.mo805u();
        this.f3688s = c1110a.mo808x();
        this.f3689t = c1110a.mo809y();
        this.f3690u = c1110a.mo806v();
        this.f3695z = c1110a.mo804t();
        this.f3667A = c1110a.mo810z();
        this.f3668B = c1110a.mo783A();
        this.f3669C = c1110a.mo784B();
    }

    public byte[] m5582b() {
        return this.f3671b;
    }

    public Long m5583c() {
        return this.f3672c;
    }

    public long mo721a() {
        return this.f3673d.mo697f();
    }

    public long m5584d() {
        return this.f3674e.mo697f();
    }

    public long m5585e() {
        return this.f3673d.mo698g();
    }

    public Long mo722k() {
        return this.f3675f;
    }

    public Long mo723l() {
        return this.f3676g;
    }

    public DutyStatus mo702m() {
        return DutyStatus.m4390b(this.f3690u) ? DutyStatus.m4385a(this.f3690u) : null;
    }

    public boolean m5586f() {
        return this.f3689t != null && this.f3689t.intValue() >= 0;
    }

    public Long m5587g() {
        return this.f3682m;
    }

    public Long m5588h() {
        return this.f3686q;
    }

    public Integer m5589i() {
        return this.f3687r;
    }

    public List<Event> m5590j() {
        return this.f3670D;
    }

    public Long m5594n() {
        return this.f3667A;
    }

    public Long m5595o() {
        return this.f3668B;
    }

    public static boolean m5580a(long j, long j2, TimeZone timeZone) {
        return timeZone.inDaylightTime(new Date(j)) == timeZone.inDaylightTime(new Date(j2));
    }

    public boolean m5596p() {
        return DutyStatus.m4390b(this.f3690u);
    }

    public static List<C1112c> m5578a(String str, int i, boolean z, List<Event> list, long j) {
        C0907o c0907o = new C0907o(TimeZone.getTimeZone(str), i);
        C1111b c1111b = new C1111b(c0907o);
        int i2 = 0;
        Event event = null;
        while (i2 < list.size()) {
            long occurredAt;
            Event event2;
            Event event3 = (Event) list.get(i2);
            long j2 = -1;
            Event event4;
            if (DutyStatus.m4387b(event3.getEventType())) {
                for (int i3 = i2 + 1; i3 < list.size(); i3++) {
                    event4 = (Event) list.get(i3);
                    if (DutyStatus.m4391c(event3) && event4.getEventType() == 29) {
                        c1111b.m5551a(event4);
                    }
                    if (DutyStatus.m4387b(event4.getEventType())) {
                        occurredAt = event4.getOccurredAt();
                        break;
                    }
                }
                occurredAt = -1;
                event2 = event3;
            } else if (event3.getEventType() == 29 && event != null && DutyStatus.m4391c(event)) {
                for (int i4 = i2 + 1; i4 < list.size(); i4++) {
                    event4 = (Event) list.get(i4);
                    if (C1130o.m5716b(event4) && (DutyStatus.m4387b(event4.getEventType()) || event4.getEventType() == 29)) {
                        j2 = event4.getOccurredAt();
                        break;
                    }
                }
                long j3 = j2;
                event2 = event;
                occurredAt = j3;
            } else {
                event2 = event;
                occurredAt = event3.getOccurredAt();
            }
            if (occurredAt < 0) {
                occurredAt = c0907o.mo698g();
                if (!z || j >= occurredAt) {
                    occurredAt = j;
                }
                occurredAt = Math.max(event3.getOccurredAt(), occurredAt);
            }
            if (C1130o.m5716b(event3)) {
                C1112c.m5579a(c1111b, event3, occurredAt);
            }
            i2++;
            event = event2;
        }
        return c1111b.m5549C();
    }

    public static void m5579a(C1111b c1111b, Event event, long j) {
        Integer valueOf;
        C1126j c1126j = null;
        if (event.hasLatitudeE6() && event.hasLongitudeE6()) {
            c1126j = new C1126j(event.getLatitudeE6(), event.getLongitudeE6(), event.hasAccuracy() ? Float.valueOf(event.getAccuracy()) : null);
        }
        byte[] d = event.getEventId().m19091d();
        Long valueOf2 = event.hasTruckId() ? Long.valueOf(event.getTruckId()) : null;
        long occurredAt = event.getOccurredAt();
        Long valueOf3 = event.hasCycleResetStartedAt() ? Long.valueOf(event.getCycleResetStartedAt()) : null;
        Long valueOf4 = event.hasCycleResetEndedAt() ? Long.valueOf(event.getCycleResetEndedAt()) : null;
        String locationName = event.getLocationName();
        String notes = event.getNotes();
        boolean immutableDutySegment = event.getImmutableDutySegment();
        Long valueOf5 = event.hasMinDuration() ? Long.valueOf(event.getMinDuration()) : null;
        byte[] d2 = event.hasAssociatedDashLink() ? event.getAssociatedDashLink().m19091d() : null;
        String associatedGenxDevice = event.hasAssociatedGenxDevice() ? event.getAssociatedGenxDevice() : null;
        Long valueOf6 = event.hasContextualData() ? Long.valueOf(event.getContextualData()) : null;
        Long valueOf7 = event.hasDistanceMeters() ? Long.valueOf(event.getDistanceMeters()) : null;
        Integer valueOf8 = event.hasOdometer() ? Integer.valueOf(event.getOdometer()) : null;
        Long valueOf9 = event.hasStatusMask() ? Long.valueOf(event.getStatusMask()) : null;
        Integer valueOf10 = event.hasSequenceId() ? Integer.valueOf(event.getSequenceId()) : null;
        EventType a = EventType.m13979a(event.getEventType());
        String trailers = event.getTrailersCount() > 0 ? event.getTrailers(0) : null;
        String trailers2 = event.getTrailersCount() > 1 ? event.getTrailers(1) : null;
        String trailers3 = event.getTrailersCount() > 2 ? event.getTrailers(2) : null;
        String shippingDoc = event.hasShippingDoc() ? event.getShippingDoc() : null;
        RelativeLocation relativeLocation = event.hasRelativeLocation() ? event.getRelativeLocation() : null;
        Long valueOf11 = event.hasEngineTotalUptime() ? Long.valueOf(event.getEngineTotalUptime()) : null;
        Long valueOf12 = event.hasEngineCycleUptime() ? Long.valueOf(event.getEngineCycleUptime()) : null;
        if (event.hasEngineCycleDistance()) {
            valueOf = Integer.valueOf(event.getEngineCycleDistance());
        } else {
            valueOf = null;
        }
        c1111b.m5550a(d, valueOf2, occurredAt, valueOf3, valueOf4, c1126j, locationName, notes, immutableDutySegment, valueOf5, d2, associatedGenxDevice, valueOf6, valueOf7, valueOf8, valueOf9, valueOf10, a, trailers, trailers2, trailers3, shippingDoc, relativeLocation, j, valueOf11, valueOf12, valueOf);
    }
}
