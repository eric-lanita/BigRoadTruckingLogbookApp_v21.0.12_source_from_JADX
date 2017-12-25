package com.bigroad.ttb.android.eobr.realtime;

import com.bigroad.shared.as;
import com.bigroad.shared.eobr.turbo.logs.MultiOdometerLogEntry;
import com.bigroad.shared.eobr.turbo.logs.MultiOdometerLogEntry.OdometerSource;
import com.bigroad.ttb.android.eobr.vna.C2005h;
import com.bigroad.ttb.android.logging.C2134e;
import com.google.common.primitives.UnsignedInteger;
import java.util.Arrays;

public class C1942c {
    private static final long f6706a = as.m4242a(1);
    private final C1941a[] f6707b = new C1941a[OdometerSource.values().length];

    protected static class C1941a {
        long f6703a;
        long f6704b;
        long f6705c;

        C1941a(long j, long j2, long j3) {
            this.f6703a = j;
            this.f6704b = j2;
            this.f6705c = j3;
        }
    }

    public C1942c() {
        for (OdometerSource ordinal : OdometerSource.values()) {
            this.f6707b[ordinal.ordinal()] = new C1941a(Long.MAX_VALUE, Long.MAX_VALUE, 0);
        }
    }

    public boolean m9560a(OdometerSource odometerSource) {
        if (C2005h.m9926a(odometerSource) && this.f6707b[odometerSource.ordinal()].f6703a != Long.MAX_VALUE) {
            return true;
        }
        return false;
    }

    public void m9558a(OdometerSource odometerSource, long j, long j2) {
        this.f6707b[odometerSource.ordinal()].f6703a = j;
        this.f6707b[odometerSource.ordinal()].f6705c = j2;
    }

    public long m9561b(OdometerSource odometerSource) {
        if (C2005h.m9926a(odometerSource)) {
            return this.f6707b[odometerSource.ordinal()].f6703a;
        }
        return Long.MAX_VALUE;
    }

    public void m9557a(long j) {
        for (OdometerSource odometerSource : OdometerSource.values()) {
            if (C2005h.m9926a(odometerSource) && this.f6707b[odometerSource.ordinal()].f6703a != Long.MAX_VALUE && j - this.f6707b[odometerSource.ordinal()].f6705c >= 60000) {
                C2134e.m10676b("TT-RealtimeOdometer", "Odometer " + odometerSource + " is stale. Removing source.");
                this.f6707b[odometerSource.ordinal()].f6703a = Long.MAX_VALUE;
                this.f6707b[odometerSource.ordinal()].f6705c = 0;
            }
        }
    }

    public boolean m9559a() {
        for (OdometerSource odometerSource : OdometerSource.values()) {
            if (C2005h.m9926a(odometerSource)) {
                C1941a c1941a = this.f6707b[odometerSource.ordinal()];
                if (c1941a.f6703a == c1941a.f6704b) {
                    continue;
                } else if (c1941a.f6703a == Long.MAX_VALUE || c1941a.f6704b == Long.MAX_VALUE) {
                    return true;
                } else {
                    if (c1941a.f6703a - c1941a.f6704b > f6706a) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public MultiOdometerLogEntry m9556a(int i) {
        OdometerSource[] odometerSourceArr = new OdometerSource[OdometerSource.values().length];
        int[] iArr = new int[OdometerSource.values().length];
        OdometerSource[] values = OdometerSource.values();
        int length = values.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4;
            OdometerSource odometerSource = values[i2];
            if (!C2005h.m9926a(odometerSource)) {
                i4 = i3;
            } else if (m9560a(odometerSource)) {
                odometerSourceArr[i3] = odometerSource;
                iArr[i3] = UnsignedInteger.m18837a(this.f6707b[odometerSource.ordinal()].f6703a).intValue();
                this.f6707b[odometerSource.ordinal()].f6704b = this.f6707b[odometerSource.ordinal()].f6703a;
                i4 = i3 + 1;
            } else {
                i4 = i3;
            }
            i2++;
            i3 = i4;
        }
        if (i3 <= 0) {
            return null;
        }
        return new MultiOdometerLogEntry(i, Arrays.copyOf(iArr, i3), (OdometerSource[]) Arrays.copyOf(odometerSourceArr, i3));
    }
}
