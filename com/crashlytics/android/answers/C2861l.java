package com.crashlytics.android.answers;

import io.fabric.sdk.android.services.concurrency.p047a.C2860a;
import java.util.Random;

class C2861l implements C2860a {
    final C2860a f9856a;
    final Random f9857b;
    final double f9858c;

    public C2861l(C2860a c2860a, double d) {
        this(c2860a, d, new Random());
    }

    public C2861l(C2860a c2860a, double d, Random random) {
        if (d < 0.0d || d > 1.0d) {
            throw new IllegalArgumentException("jitterPercent must be between 0.0 and 1.0");
        } else if (c2860a == null) {
            throw new NullPointerException("backoff must not be null");
        } else if (random == null) {
            throw new NullPointerException("random must not be null");
        } else {
            this.f9856a = c2860a;
            this.f9858c = d;
            this.f9857b = random;
        }
    }

    public long mo1448a(int i) {
        return (long) (m16084a() * ((double) this.f9856a.mo1448a(i)));
    }

    double m16084a() {
        double d = 1.0d - this.f9858c;
        return d + (((this.f9858c + 1.0d) - d) * this.f9857b.nextDouble());
    }
}
