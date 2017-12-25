package com.bigroad.shared.eobr.turbo;

import com.bigroad.shared.aq;
import com.bigroad.shared.eobr.C0971c;
import com.bigroad.shared.eobr.turbo.logs.C1016p;
import com.bigroad.shared.eobr.turbo.logs.C1035q;

public class C1002b implements C0971c {
    private C1016p f3137a;
    private long f3138b;
    private long f3139c;
    private C1015l f3140d;
    private String f3141e;

    public C1002b(C1015l c1015l, C1016p c1016p, long j, long j2) {
        this(c1015l, c1016p, j, j2, null);
    }

    public C1002b(C1015l c1015l, C1016p c1016p, long j, long j2, String str) {
        this.f3140d = c1015l;
        this.f3137a = c1016p;
        this.f3138b = j;
        this.f3139c = j2;
        this.f3141e = str;
    }

    public int mo748b() {
        return (int) this.f3138b;
    }

    public long mo749d() {
        return this.f3139c;
    }

    public C1016p m5133e() {
        return this.f3137a;
    }

    public C1015l mo747c() {
        return this.f3140d;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.f3137a instanceof C1035q) {
            stringBuffer.append(this.f3137a.toString());
        } else {
            stringBuffer.append(" ");
            stringBuffer.append(m5134f());
            if (mo747c() != null) {
                stringBuffer.append(" [");
                stringBuffer.append(mo747c().m5228a());
                stringBuffer.append(",");
                stringBuffer.append(mo747c().m5230b());
                stringBuffer.append("]");
            }
            stringBuffer.append(" ");
            if (this.f3137a != null) {
                stringBuffer.append(this.f3137a.toString());
            }
        }
        if (this.f3141e != null) {
            stringBuffer.append(" ");
            stringBuffer.append(this.f3141e);
        }
        return stringBuffer.toString();
    }

    public String m5134f() {
        if (this.f3139c == 0) {
            return "????-??-?? ??:??:??";
        }
        return aq.m4233e(this.f3139c);
    }

    public boolean mo746a() {
        return false;
    }
}
