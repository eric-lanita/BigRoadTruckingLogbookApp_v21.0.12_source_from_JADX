package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzab;

public class BooleanResult implements Result {
    private final Status f10528a;
    private final boolean f10529b;

    public BooleanResult(Status status, boolean z) {
        this.f10528a = (Status) zzab.zzb((Object) status, (Object) "Status must not be null");
        this.f10529b = z;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BooleanResult)) {
            return false;
        }
        BooleanResult booleanResult = (BooleanResult) obj;
        return this.f10528a.equals(booleanResult.f10528a) && this.f10529b == booleanResult.f10529b;
    }

    public Status getStatus() {
        return this.f10528a;
    }

    public boolean getValue() {
        return this.f10529b;
    }

    public final int hashCode() {
        return (this.f10529b ? 1 : 0) + ((this.f10528a.hashCode() + 527) * 31);
    }
}
