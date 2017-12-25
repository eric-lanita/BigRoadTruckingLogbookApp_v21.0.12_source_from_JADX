package com.bigroad.shared.eobr.genx;

import com.google.common.base.Charsets;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class C0986i extends C0981n {
    private final Long f3102a;
    private final Long f3103b;
    private final Long f3104c;

    public C0986i(Long l, Long l2, Long l3) {
        this.f3102a = l;
        this.f3103b = l2;
        this.f3104c = l3;
    }

    public boolean m5068d() {
        return this.f3103b == null;
    }

    public boolean m5069e() {
        return this.f3103b == null && this.f3102a == null;
    }

    public Long m5070f() {
        return this.f3103b;
    }

    protected GenxDataType mo758b() {
        return GenxDataType.AT_COMMAND;
    }

    protected byte[] mo759c() {
        StringBuilder stringBuilder = new StringBuilder("DUMPQELD");
        if (this.f3104c != null) {
            stringBuilder.append(" MAXPOINTS ").append(this.f3104c);
        }
        if (this.f3102a != null) {
            stringBuilder.append(" STARTID ").append(this.f3102a);
        }
        if (this.f3103b != null) {
            stringBuilder.append(" ENDID ").append(this.f3103b);
        }
        return stringBuilder.toString().getBytes(Charsets.UTF_8);
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0986i c0986i = (C0986i) obj;
        if (Objects.equal(this.f3102a, c0986i.f3102a) && Objects.equal(this.f3103b, c0986i.f3103b) && Objects.equal(this.f3104c, c0986i.f3104c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(this.f3102a, this.f3103b, this.f3104c);
    }

    public String toString() {
        if (this.f3102a == null && this.f3103b == null && this.f3104c != null) {
            return "DUMPQELD reqeust for latest " + this.f3104c + " entries";
        }
        if (this.f3102a == null && this.f3103b != null && this.f3104c != null) {
            return "DUMPQELD reqeust for " + this.f3104c + " historical entries backwards from " + this.f3103b;
        }
        if (this.f3102a == null || this.f3103b == null || this.f3104c != null) {
            return MoreObjects.toStringHelper(C0986i.class).add("startId", this.f3102a).add("endId", this.f3103b).add("maxPoints", this.f3104c).toString();
        }
        return "DUMPQELD request for entries in the range [" + this.f3102a + ", " + this.f3103b + "]";
    }
}
