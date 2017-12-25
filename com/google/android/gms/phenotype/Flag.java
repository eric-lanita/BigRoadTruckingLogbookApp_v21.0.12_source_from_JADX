package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Comparator;

public class Flag extends AbstractSafeParcelable implements Comparable<Flag> {
    public static final Creator<Flag> CREATOR = new zzb();
    public static final zza arp = new zza();
    private static final Charset f12438g = Charset.forName("UTF-8");
    final int f12439a;
    public final int arn;
    public final int aro;
    final long f12440b;
    final boolean f12441c;
    final double f12442d;
    final String f12443e;
    final byte[] f12444f;
    public final String name;

    public static class zza implements Comparator<Flag> {
        public /* synthetic */ int compare(Object obj, Object obj2) {
            return zza((Flag) obj, (Flag) obj2);
        }

        public int zza(Flag flag, Flag flag2) {
            return flag.aro == flag2.aro ? flag.name.compareTo(flag2.name) : flag.aro - flag2.aro;
        }
    }

    Flag(int i, String str, long j, boolean z, double d, String str2, byte[] bArr, int i2, int i3) {
        this.f12439a = i;
        this.name = str;
        this.f12440b = j;
        this.f12441c = z;
        this.f12442d = d;
        this.f12443e = str2;
        this.f12444f = bArr;
        this.arn = i2;
        this.aro = i3;
    }

    private static int m18010a(byte b, byte b2) {
        return b - b2;
    }

    private static int m18011a(int i, int i2) {
        return i < i2 ? -1 : i == i2 ? 0 : 1;
    }

    private static int m18012a(long j, long j2) {
        return j < j2 ? -1 : j == j2 ? 0 : 1;
    }

    private static int m18013a(String str, String str2) {
        return str == str2 ? 0 : str == null ? -1 : str2 == null ? 1 : str.compareTo(str2);
    }

    private static int m18014a(boolean z, boolean z2) {
        return z == z2 ? 0 : z ? 1 : -1;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return zza((Flag) obj);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Flag)) {
            return false;
        }
        Flag flag = (Flag) obj;
        if (this.f12439a != flag.f12439a || !zzaa.equal(this.name, flag.name) || this.arn != flag.arn || this.aro != flag.aro) {
            return false;
        }
        switch (this.arn) {
            case 1:
                return this.f12440b == flag.f12440b;
            case 2:
                return this.f12441c == flag.f12441c;
            case 3:
                return this.f12442d == flag.f12442d;
            case 4:
                return zzaa.equal(this.f12443e, flag.f12443e);
            case 5:
                return Arrays.equals(this.f12444f, flag.f12444f);
            default:
                throw new AssertionError("Invalid enum value: " + this.arn);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Flag(");
        stringBuilder.append(this.f12439a);
        stringBuilder.append(", ");
        stringBuilder.append(this.name);
        stringBuilder.append(", ");
        switch (this.arn) {
            case 1:
                stringBuilder.append(this.f12440b);
                break;
            case 2:
                stringBuilder.append(this.f12441c);
                break;
            case 3:
                stringBuilder.append(this.f12442d);
                break;
            case 4:
                stringBuilder.append("'");
                stringBuilder.append(this.f12443e);
                stringBuilder.append("'");
                break;
            case 5:
                if (this.f12444f != null) {
                    stringBuilder.append("'");
                    stringBuilder.append(new String(this.f12444f, f12438g));
                    stringBuilder.append("'");
                    break;
                }
                stringBuilder.append("null");
                break;
            default:
                throw new AssertionError("Invalid enum value: " + this.arn);
        }
        stringBuilder.append(", ");
        stringBuilder.append(this.arn);
        stringBuilder.append(", ");
        stringBuilder.append(this.aro);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.m18016a(this, parcel, i);
    }

    public int zza(Flag flag) {
        int i = 0;
        int compareTo = this.name.compareTo(flag.name);
        if (compareTo != 0) {
            return compareTo;
        }
        compareTo = m18011a(this.arn, flag.arn);
        if (compareTo != 0) {
            return compareTo;
        }
        switch (this.arn) {
            case 1:
                return m18012a(this.f12440b, flag.f12440b);
            case 2:
                return m18014a(this.f12441c, flag.f12441c);
            case 3:
                return Double.compare(this.f12442d, flag.f12442d);
            case 4:
                return m18013a(this.f12443e, flag.f12443e);
            case 5:
                if (this.f12444f == flag.f12444f) {
                    return 0;
                }
                if (this.f12444f == null) {
                    return -1;
                }
                if (flag.f12444f == null) {
                    return 1;
                }
                while (i < Math.min(this.f12444f.length, flag.f12444f.length)) {
                    compareTo = m18010a(this.f12444f[i], flag.f12444f[i]);
                    if (compareTo != 0) {
                        return compareTo;
                    }
                    i++;
                }
                return m18011a(this.f12444f.length, flag.f12444f.length);
            default:
                throw new AssertionError("Invalid enum value: " + this.arn);
        }
    }
}
