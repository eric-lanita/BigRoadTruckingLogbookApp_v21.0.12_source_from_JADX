package com.bigroad.ttb.android.model;

import com.bigroad.shared.model.CanonicalOdometerSource;
import com.bigroad.ttb.protocol.TTProtocol.OdometerOffsets;
import com.bigroad.ttb.protocol.TTProtocol.cn;

public class C2178c {
    private final long[] f7566a = new long[CanonicalOdometerSource.f3603l];
    private final long[] f7567b = new long[CanonicalOdometerSource.f3603l];
    private final CanonicalOdometerSource f7568c;

    public C2178c(C2182e c2182e, OdometerOffsets odometerOffsets) {
        CanonicalOdometerSource canonicalOdometerSource = null;
        CanonicalOdometerSource[] values = CanonicalOdometerSource.values();
        int length = values.length;
        int i = 0;
        while (i < length) {
            CanonicalOdometerSource canonicalOdometerSource2 = values[i];
            int ordinal = canonicalOdometerSource2.ordinal();
            long[] jArr = this.f7567b;
            long[] jArr2 = this.f7566a;
            long a = c2182e.m10816a(canonicalOdometerSource2);
            jArr2[ordinal] = a;
            jArr[ordinal] = a;
            if (odometerOffsets != null) {
                if (!canonicalOdometerSource2.m5465a()) {
                    if (this.f7566a[ordinal] > 0) {
                        this.f7567b[ordinal] = this.f7566a[ordinal];
                        if (canonicalOdometerSource == null) {
                        }
                    } else {
                        this.f7567b[ordinal] = 0;
                        this.f7566a[ordinal] = 0;
                        canonicalOdometerSource2 = canonicalOdometerSource;
                    }
                    i++;
                    canonicalOdometerSource = canonicalOdometerSource2;
                } else if (CanonicalOdometerSource.m5463a(odometerOffsets, canonicalOdometerSource2)) {
                    if (this.f7566a[ordinal] > 0) {
                        this.f7567b[ordinal] = CanonicalOdometerSource.m5458a((cn) odometerOffsets, canonicalOdometerSource2, this.f7566a[ordinal]);
                    } else {
                        this.f7567b[ordinal] = 0;
                        this.f7566a[ordinal] = 0;
                    }
                    if (canonicalOdometerSource == null) {
                        i++;
                        canonicalOdometerSource = canonicalOdometerSource2;
                    }
                } else {
                    long[] jArr3 = this.f7567b;
                    this.f7566a[ordinal] = 0;
                    jArr3[ordinal] = 0;
                }
            }
            canonicalOdometerSource2 = canonicalOdometerSource;
            i++;
            canonicalOdometerSource = canonicalOdometerSource2;
        }
        this.f7568c = canonicalOdometerSource;
    }

    public static C2177b m10804a(C2182e c2182e, OdometerOffsets odometerOffsets) {
        if (c2182e == null || odometerOffsets == null) {
            return null;
        }
        return c2182e.m10818a(odometerOffsets).m10809b();
    }

    private boolean m10805d(CanonicalOdometerSource canonicalOdometerSource) {
        if (canonicalOdometerSource == null) {
            return false;
        }
        if (this.f7566a[canonicalOdometerSource.ordinal()] > 0) {
            return true;
        }
        return false;
    }

    public CanonicalOdometerSource m10807a() {
        if (this.f7568c == null) {
            for (CanonicalOdometerSource canonicalOdometerSource : CanonicalOdometerSource.values()) {
                if (m10805d(canonicalOdometerSource)) {
                    return canonicalOdometerSource;
                }
            }
            return null;
        } else if (m10805d(this.f7568c)) {
            return this.f7568c;
        } else {
            return null;
        }
    }

    public C2177b m10809b() {
        CanonicalOdometerSource a = m10807a();
        return a == null ? null : m10810c(a);
    }

    public long m10806a(CanonicalOdometerSource canonicalOdometerSource) {
        return this.f7567b[canonicalOdometerSource.ordinal()];
    }

    public long m10808b(CanonicalOdometerSource canonicalOdometerSource) {
        return this.f7566a[canonicalOdometerSource.ordinal()];
    }

    public C2177b m10810c(CanonicalOdometerSource canonicalOdometerSource) {
        return new C2177b(m10806a(canonicalOdometerSource), m10808b(canonicalOdometerSource), canonicalOdometerSource);
    }
}
