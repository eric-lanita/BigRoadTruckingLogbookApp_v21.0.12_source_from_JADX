package com.bigroad.shared.duty.rule;

import com.bigroad.shared.duty.C0896g;
import com.bigroad.shared.duty.C0896g.C0870a;
import com.bigroad.shared.duty.DutyStatus;

public class C0937n extends C0936r {
    private final boolean f2879a;

    private C0937n(boolean z) {
        super(43200000, 54000000);
        this.f2879a = z;
    }

    public static C0937n m4742a() {
        return new C0937n(false);
    }

    public static C0937n m4743b() {
        return new C0937n(true);
    }

    protected C0870a mo739c() {
        if (this.f2879a) {
            return C0896g.f2770c;
        }
        return super.mo739c();
    }

    protected DutyStatus mo740d() {
        return this.f2879a ? DutyStatus.OFF_DUTY : DutyStatus.SLEEPER;
    }
}
