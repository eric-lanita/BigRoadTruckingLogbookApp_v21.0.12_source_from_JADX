package com.google.common.base;

import com.google.errorprone.annotations.CanIgnoreReturnValue;

public abstract class Ticker {
    private static final Ticker SYSTEM_TICKER = new C35081();

    static class C35081 extends Ticker {
        C35081() {
        }

        public long read() {
            return Platform.systemNanoTime();
        }
    }

    @CanIgnoreReturnValue
    public abstract long read();

    protected Ticker() {
    }

    public static Ticker systemTicker() {
        return SYSTEM_TICKER;
    }
}
