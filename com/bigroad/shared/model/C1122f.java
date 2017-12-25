package com.bigroad.shared.model;

import com.bigroad.shared.C0855c;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import java.util.Comparator;

public class C1122f {
    public static final Comparator<C1122f> f3760a = new C11191();
    private final byte[] f3761b;
    private final Long f3762c;
    private final long f3763d;
    private final CanonicalMalfunctionType f3764e;
    private final long f3765f;
    private final C1126j f3766g;

    static class C11191 implements Comparator<C1122f> {
        C11191() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m5681a((C1122f) obj, (C1122f) obj2);
        }

        public int m5681a(C1122f c1122f, C1122f c1122f2) {
            int signum = Long.signum(c1122f.m5695b() - c1122f2.m5695b());
            if (signum == 0) {
                return C0855c.f2653a.compare(c1122f.m5694a(), c1122f2.m5694a());
            }
            return signum;
        }
    }

    public interface C1120b {
        byte[] mo811a();

        Long mo812b();

        long mo813c();

        CanonicalMalfunctionType mo814d();

        long mo815e();

        C1126j mo816f();
    }

    public static class C1121a implements C1120b {
        private byte[] f3754a;
        private Long f3755b;
        private long f3756c;
        private CanonicalMalfunctionType f3757d;
        private long f3758e;
        private C1126j f3759f;

        public C1121a(Event event) {
            this.f3754a = event.getEventId().m19091d();
            this.f3755b = Long.valueOf(event.getTruckId());
            this.f3756c = event.getOccurredAt();
            this.f3757d = CanonicalMalfunctionType.m5454b(event.getEventType(), event.getEventSubtype());
            this.f3758e = event.hasContextualData() ? event.getContextualData() : 0;
            if (event.hasLatitudeE6() && event.hasLongitudeE6()) {
                Float valueOf;
                int latitudeE6 = event.getLatitudeE6();
                int longitudeE6 = event.getLongitudeE6();
                if (event.hasAccuracy()) {
                    valueOf = Float.valueOf(event.getAccuracy());
                } else {
                    valueOf = null;
                }
                this.f3759f = new C1126j(latitudeE6, longitudeE6, valueOf);
                return;
            }
            this.f3759f = null;
        }

        public byte[] mo811a() {
            return this.f3754a;
        }

        public Long mo812b() {
            return this.f3755b;
        }

        public long mo813c() {
            return this.f3756c;
        }

        public CanonicalMalfunctionType mo814d() {
            return this.f3757d;
        }

        public long mo815e() {
            return this.f3758e;
        }

        public C1126j mo816f() {
            return this.f3759f;
        }
    }

    public C1122f(Event event) {
        this(new C1121a(event));
    }

    public C1122f(C1120b c1120b) {
        this.f3761b = c1120b.mo811a();
        this.f3762c = c1120b.mo812b();
        this.f3763d = c1120b.mo813c();
        this.f3764e = c1120b.mo814d();
        this.f3765f = c1120b.mo815e();
        this.f3766g = c1120b.mo816f();
    }

    public byte[] m5694a() {
        return this.f3761b;
    }

    public long m5695b() {
        return this.f3763d;
    }

    public CanonicalMalfunctionType m5696c() {
        return this.f3764e;
    }
}
