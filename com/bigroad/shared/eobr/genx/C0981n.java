package com.bigroad.shared.eobr.genx;

import com.bigroad.shared.eobr.C0972e;

public abstract class C0981n implements C0972e {
    private int f3090a = -1;

    protected abstract GenxDataType mo758b();

    protected abstract byte[] mo759c();

    public int m5037g() {
        return this.f3090a;
    }

    public int mo757a() {
        return this.f3090a;
    }

    public void m5034a(int i) {
        this.f3090a = i;
    }
}
