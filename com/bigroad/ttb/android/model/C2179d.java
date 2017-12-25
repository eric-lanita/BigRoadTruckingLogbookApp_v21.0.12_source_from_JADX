package com.bigroad.ttb.android.model;

import com.bigroad.shared.model.CanonicalOdometerSource;

public class C2179d {
    private final long f7569a;
    private final CanonicalOdometerSource f7570b;

    public C2179d(long j, CanonicalOdometerSource canonicalOdometerSource) {
        this.f7569a = j;
        this.f7570b = canonicalOdometerSource;
    }

    public long m10811a() {
        return this.f7569a;
    }

    public CanonicalOdometerSource m10812b() {
        return this.f7570b;
    }

    public String toString() {
        return "RawOdometerReading [m_distance=" + this.f7569a + "]";
    }
}
