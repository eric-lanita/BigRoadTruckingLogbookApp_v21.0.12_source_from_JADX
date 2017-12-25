package com.bigroad.ttb.android.model;

import com.bigroad.shared.model.CanonicalOdometerSource;
import com.bigroad.ttb.protocol.TTProtocol.OdometerOffsets;
import com.bigroad.ttb.protocol.TTProtocol.OdometerOffsets.C2710a;
import java.util.Arrays;

public class C2182e {
    private final long[] f7572a;

    public static class C2181a {
        private long[] f7571a;

        public C2181a() {
            this.f7571a = new long[CanonicalOdometerSource.f3603l];
        }

        public C2181a(C2182e c2182e) {
            this.f7571a = Arrays.copyOf(c2182e.f7572a, CanonicalOdometerSource.f3603l);
        }

        public C2181a(long[] jArr) {
            this.f7571a = jArr;
        }

        public C2181a m10813a(CanonicalOdometerSource canonicalOdometerSource, long j) {
            this.f7571a[canonicalOdometerSource.ordinal()] = j;
            return this;
        }

        public C2182e m10814a() {
            return new C2182e(this.f7571a);
        }
    }

    private C2182e(long[] jArr) {
        this.f7572a = Arrays.copyOf(jArr, CanonicalOdometerSource.f3603l);
    }

    public long m10816a(CanonicalOdometerSource canonicalOdometerSource) {
        return this.f7572a[canonicalOdometerSource.ordinal()];
    }

    public Long m10820a(C2182e c2182e) {
        if (c2182e == null) {
            return null;
        }
        for (CanonicalOdometerSource canonicalOdometerSource : CanonicalOdometerSource.values()) {
            Long valueOf = Long.valueOf(m10816a(canonicalOdometerSource));
            Long valueOf2 = Long.valueOf(c2182e.m10816a(canonicalOdometerSource));
            if (valueOf.longValue() > 0 && valueOf2.longValue() > 0) {
                return Long.valueOf(valueOf.longValue() - valueOf2.longValue());
            }
        }
        return null;
    }

    public C2179d m10822b(CanonicalOdometerSource canonicalOdometerSource) {
        long a = m10816a(canonicalOdometerSource);
        if (a > 0) {
            return new C2179d(a, canonicalOdometerSource);
        }
        return null;
    }

    public CanonicalOdometerSource m10817a() {
        for (int i = 0; i < CanonicalOdometerSource.f3603l; i++) {
            if (this.f7572a[i] > 0) {
                return CanonicalOdometerSource.values()[i];
            }
        }
        return null;
    }

    public C2179d m10821b() {
        CanonicalOdometerSource a = m10817a();
        return a == null ? null : m10822b(a);
    }

    public C2178c m10818a(OdometerOffsets odometerOffsets) {
        return new C2178c(this, odometerOffsets);
    }

    public OdometerOffsets m10819a(long j) {
        C2710a newBuilder = OdometerOffsets.newBuilder();
        for (CanonicalOdometerSource canonicalOdometerSource : CanonicalOdometerSource.values()) {
            int ordinal = canonicalOdometerSource.ordinal();
            if (this.f7572a[ordinal] > 0) {
                CanonicalOdometerSource.m5461a(newBuilder, canonicalOdometerSource, j, this.f7572a[ordinal]);
            }
        }
        return newBuilder.m14593c();
    }
}
