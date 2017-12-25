package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;

public final class Scope extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<Scope> CREATOR = new zze();
    final int f10554a;
    private final String f10555b;

    Scope(int i, String str) {
        zzab.zzh(str, "scopeUri must not be null or empty");
        this.f10554a = i;
        this.f10555b = str;
    }

    public Scope(String str) {
        this(1, str);
    }

    public boolean equals(Object obj) {
        return this == obj ? true : !(obj instanceof Scope) ? false : this.f10555b.equals(((Scope) obj).f10555b);
    }

    public int hashCode() {
        return this.f10555b.hashCode();
    }

    public String toString() {
        return this.f10555b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze.m16810a(this, parcel, i);
    }

    public String zzaok() {
        return this.f10555b;
    }
}
