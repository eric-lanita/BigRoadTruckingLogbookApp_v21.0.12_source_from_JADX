package com.bigroad.shared.eobr.turbo.logs;

import com.bigroad.ttb.protocol.TTProtocol.MotionType;

public class C1036s extends C1017o {
    public final int f3283a;

    public C1036s(int i, int i2) {
        super(i);
        this.f3283a = i2;
    }

    public MotionType m5277b() {
        if (m5281f()) {
            return MotionType.MOVING;
        }
        return MotionType.STOPPED;
    }

    public boolean m5278c() {
        return (this.f3283a & 1) != 0;
    }

    public boolean m5279d() {
        return (this.f3283a & 4) != 0;
    }

    public boolean m5280e() {
        return (this.f3283a & 8) != 0;
    }

    public boolean m5281f() {
        return (this.f3283a & 2) != 0;
    }

    public boolean m5282g() {
        return (this.f3283a & 32) != 0;
    }

    public boolean m5283h() {
        return (this.f3283a & 16) != 0;
    }
}
