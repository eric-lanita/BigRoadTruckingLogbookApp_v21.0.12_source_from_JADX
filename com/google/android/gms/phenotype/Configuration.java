package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Configuration extends AbstractSafeParcelable implements Comparable<Configuration> {
    public static final Creator<Configuration> CREATOR = new zza();
    final int f12437a;
    public final int arh;
    public final Flag[] ari;
    public final String[] arj;
    public final Map<String, Flag> ark = new TreeMap();

    Configuration(int i, int i2, Flag[] flagArr, String[] strArr) {
        this.f12437a = i;
        this.arh = i2;
        this.ari = flagArr;
        for (Flag flag : flagArr) {
            this.ark.put(flag.name, flag);
        }
        this.arj = strArr;
        if (this.arj != null) {
            Arrays.sort(this.arj);
        }
    }

    public /* synthetic */ int compareTo(Object obj) {
        return zza((Configuration) obj);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Configuration)) {
            return false;
        }
        Configuration configuration = (Configuration) obj;
        return this.f12437a == configuration.f12437a && this.arh == configuration.arh && zzaa.equal(this.ark, configuration.ark) && Arrays.equals(this.arj, configuration.arj);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Configuration(");
        stringBuilder.append(this.f12437a);
        stringBuilder.append(", ");
        stringBuilder.append(this.arh);
        stringBuilder.append(", ");
        stringBuilder.append("(");
        for (Flag append : this.ark.values()) {
            stringBuilder.append(append);
            stringBuilder.append(", ");
        }
        stringBuilder.append(")");
        stringBuilder.append(", ");
        stringBuilder.append("(");
        if (this.arj != null) {
            for (String append2 : this.arj) {
                stringBuilder.append(append2);
                stringBuilder.append(", ");
            }
        } else {
            stringBuilder.append("null");
        }
        stringBuilder.append(")");
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.m18015a(this, parcel, i);
    }

    public int zza(Configuration configuration) {
        return this.arh - configuration.arh;
    }
}
