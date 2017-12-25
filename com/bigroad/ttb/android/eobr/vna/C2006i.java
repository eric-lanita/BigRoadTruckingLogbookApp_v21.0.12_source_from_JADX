package com.bigroad.ttb.android.eobr.vna;

import com.bigroad.shared.eobr.turbo.logs.C1036s;
import com.bigroad.ttb.android.eobr.realtime.C1939b;

public class C2006i {
    private volatile int f6927a = 0;
    private final C1939b f6928b;

    public C2006i(C1939b c1939b) {
        this.f6928b = c1939b;
    }

    public synchronized int m9930a() {
        return this.f6927a;
    }

    synchronized void m9931a(int i, long j) {
        m9928c(this.f6927a & i, j);
    }

    synchronized void m9932b(int i, long j) {
        m9928c(this.f6927a | i, j);
    }

    private void m9928c(int i, long j) {
        if (this.f6927a != i) {
            this.f6927a = i;
            m9929d(i, j);
        }
    }

    private void m9929d(int i, long j) {
        this.f6928b.mo1163a(new C1036s((int) (j / 1000), i));
    }
}
