package io.fabric.sdk.android.services.common;

class C3992b {
    public final String f14149a;
    public final boolean f14150b;

    C3992b(String str, boolean z) {
        this.f14149a = str;
        this.f14150b = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C3992b c3992b = (C3992b) obj;
        if (this.f14150b != c3992b.f14150b) {
            return false;
        }
        if (this.f14149a != null) {
            if (this.f14149a.equals(c3992b.f14149a)) {
                return true;
            }
        } else if (c3992b.f14149a == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        if (this.f14149a != null) {
            hashCode = this.f14149a.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode *= 31;
        if (this.f14150b) {
            i = 1;
        }
        return hashCode + i;
    }
}
