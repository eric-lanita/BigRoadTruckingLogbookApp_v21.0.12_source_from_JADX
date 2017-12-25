package com.bigroad.ttb.android.model;

import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.protocol.TTProtocol.EngineHoursSource;

public class C2175a {
    private static final EngineHoursSource[] f7559a = new EngineHoursSource[]{EngineHoursSource.EH_J1939, EngineHoursSource.EH_J1587, EngineHoursSource.EH_GENX_ECM, EngineHoursSource.EH_DASHLINK_FIRMWARE, EngineHoursSource.EH_GENX_FW};
    private final long[] f7560b;
    private final long[] f7561c;

    public static class C2174a {
        private final long[] f7557a;
        private final long[] f7558b;

        public C2174a() {
            this(null);
        }

        public C2174a(C2175a c2175a) {
            this.f7557a = new long[EngineHoursSource.values().length];
            this.f7558b = new long[EngineHoursSource.values().length];
            if (c2175a != null) {
                System.arraycopy(c2175a.f7560b, 0, this.f7557a, 0, this.f7557a.length);
                System.arraycopy(c2175a.f7561c, 0, this.f7558b, 0, this.f7558b.length);
            }
        }

        public C2174a m10792a() {
            System.arraycopy(this.f7557a, 0, this.f7558b, 0, this.f7558b.length);
            return this;
        }

        public C2174a m10793a(EngineHoursSource engineHoursSource, long j) {
            if (engineHoursSource != null && engineHoursSource != EngineHoursSource.UNKNOWN_EH_SOURCE && j > 0 && j > this.f7557a[engineHoursSource.ordinal()]) {
                this.f7557a[engineHoursSource.ordinal()] = j;
                if (this.f7558b[engineHoursSource.ordinal()] <= 0) {
                    this.f7558b[engineHoursSource.ordinal()] = j;
                }
            }
            return this;
        }

        public C2175a m10794b() {
            return new C2175a(this.f7557a, this.f7558b);
        }
    }

    private C2175a(long[] jArr, long[] jArr2) {
        this.f7560b = jArr;
        this.f7561c = jArr2;
    }

    public Long m10797a() {
        int length;
        for (EngineHoursSource engineHoursSource : f7559a) {
            if (this.f7560b[engineHoursSource.ordinal()] > 0) {
                return Long.valueOf(this.f7560b[engineHoursSource.ordinal()]);
            }
        }
        for (length = this.f7560b.length - 1; length >= 0; length--) {
            if (this.f7560b[length] > 0) {
                C2134e.m10680d("TT-EngineHours", "Value exists, but source is not in ENGINE_HOURS_SOURCE_PRIORITY.");
                return Long.valueOf(this.f7560b[length]);
            }
        }
        return null;
    }

    public Long m10798b() {
        Long l = null;
        for (EngineHoursSource ordinal : f7559a) {
            int ordinal2 = ordinal.ordinal();
            if (this.f7560b[ordinal2] > 0 && this.f7561c[ordinal2] > 0) {
                long j = this.f7560b[ordinal2] - this.f7561c[ordinal2];
                if (l == null || j > l.longValue()) {
                    l = Long.valueOf(j);
                }
            }
        }
        return l;
    }
}
