package com.bigroad.shared.eobr.genx;

import com.bigroad.shared.am;
import com.google.common.base.Charsets;

public class C0982e extends C0981n {
    private final String f3091a;

    public C0982e(String str) {
        this.f3091a = str;
    }

    protected GenxDataType mo758b() {
        return GenxDataType.AT_COMMAND;
    }

    protected byte[] mo759c() {
        if (am.m4188a(this.f3091a)) {
            return new byte[0];
        }
        return this.f3091a.getBytes(Charsets.UTF_8);
    }

    public String toString() {
        return "GenxAtRequest{" + this.f3091a + "}";
    }
}
