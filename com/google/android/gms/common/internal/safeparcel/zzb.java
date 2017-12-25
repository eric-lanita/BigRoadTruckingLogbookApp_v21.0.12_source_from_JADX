package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class zzb {
    private static int m16869a(Parcel parcel, int i) {
        parcel.writeInt(-65536 | i);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void m16870a(Parcel parcel, int i, int i2) {
        if (i2 >= 65535) {
            parcel.writeInt(-65536 | i);
            parcel.writeInt(i2);
            return;
        }
        parcel.writeInt((i2 << 16) | i);
    }

    private static <T extends Parcelable> void m16871a(Parcel parcel, T t, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    private static void m16872b(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        int i2 = dataPosition - i;
        parcel.setDataPosition(i - 4);
        parcel.writeInt(i2);
        parcel.setDataPosition(dataPosition);
    }

    public static void zza(Parcel parcel, int i, byte b) {
        m16870a(parcel, i, 4);
        parcel.writeInt(b);
    }

    public static void zza(Parcel parcel, int i, double d) {
        m16870a(parcel, i, 8);
        parcel.writeDouble(d);
    }

    public static void zza(Parcel parcel, int i, float f) {
        m16870a(parcel, i, 4);
        parcel.writeFloat(f);
    }

    public static void zza(Parcel parcel, int i, long j) {
        m16870a(parcel, i, 8);
        parcel.writeLong(j);
    }

    public static void zza(Parcel parcel, int i, Bundle bundle, boolean z) {
        if (bundle != null) {
            int a = m16869a(parcel, i);
            parcel.writeBundle(bundle);
            m16872b(parcel, a);
        } else if (z) {
            m16870a(parcel, i, 0);
        }
    }

    public static void zza(Parcel parcel, int i, IBinder iBinder, boolean z) {
        if (iBinder != null) {
            int a = m16869a(parcel, i);
            parcel.writeStrongBinder(iBinder);
            m16872b(parcel, a);
        } else if (z) {
            m16870a(parcel, i, 0);
        }
    }

    public static void zza(Parcel parcel, int i, Parcel parcel2, boolean z) {
        if (parcel2 != null) {
            int a = m16869a(parcel, i);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            m16872b(parcel, a);
        } else if (z) {
            m16870a(parcel, i, 0);
        }
    }

    public static void zza(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable != null) {
            int a = m16869a(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            m16872b(parcel, a);
        } else if (z) {
            m16870a(parcel, i, 0);
        }
    }

    public static void zza(Parcel parcel, int i, Boolean bool, boolean z) {
        int i2 = 0;
        if (bool != null) {
            m16870a(parcel, i, 4);
            if (bool.booleanValue()) {
                i2 = 1;
            }
            parcel.writeInt(i2);
        } else if (z) {
            m16870a(parcel, i, 0);
        }
    }

    public static void zza(Parcel parcel, int i, Double d, boolean z) {
        if (d != null) {
            m16870a(parcel, i, 8);
            parcel.writeDouble(d.doubleValue());
        } else if (z) {
            m16870a(parcel, i, 0);
        }
    }

    public static void zza(Parcel parcel, int i, Float f, boolean z) {
        if (f != null) {
            m16870a(parcel, i, 4);
            parcel.writeFloat(f.floatValue());
        } else if (z) {
            m16870a(parcel, i, 0);
        }
    }

    public static void zza(Parcel parcel, int i, Integer num, boolean z) {
        if (num != null) {
            m16870a(parcel, i, 4);
            parcel.writeInt(num.intValue());
        } else if (z) {
            m16870a(parcel, i, 0);
        }
    }

    public static void zza(Parcel parcel, int i, Long l, boolean z) {
        if (l != null) {
            m16870a(parcel, i, 8);
            parcel.writeLong(l.longValue());
        } else if (z) {
            m16870a(parcel, i, 0);
        }
    }

    public static void zza(Parcel parcel, int i, String str, boolean z) {
        if (str != null) {
            int a = m16869a(parcel, i);
            parcel.writeString(str);
            m16872b(parcel, a);
        } else if (z) {
            m16870a(parcel, i, 0);
        }
    }

    public static void zza(Parcel parcel, int i, List<Integer> list, boolean z) {
        if (list != null) {
            int a = m16869a(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(((Integer) list.get(i2)).intValue());
            }
            m16872b(parcel, a);
        } else if (z) {
            m16870a(parcel, i, 0);
        }
    }

    public static void zza(Parcel parcel, int i, short s) {
        m16870a(parcel, i, 4);
        parcel.writeInt(s);
    }

    public static void zza(Parcel parcel, int i, boolean z) {
        m16870a(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    public static void zza(Parcel parcel, int i, byte[] bArr, boolean z) {
        if (bArr != null) {
            int a = m16869a(parcel, i);
            parcel.writeByteArray(bArr);
            m16872b(parcel, a);
        } else if (z) {
            m16870a(parcel, i, 0);
        }
    }

    public static void zza(Parcel parcel, int i, float[] fArr, boolean z) {
        if (fArr != null) {
            int a = m16869a(parcel, i);
            parcel.writeFloatArray(fArr);
            m16872b(parcel, a);
        } else if (z) {
            m16870a(parcel, i, 0);
        }
    }

    public static void zza(Parcel parcel, int i, int[] iArr, boolean z) {
        if (iArr != null) {
            int a = m16869a(parcel, i);
            parcel.writeIntArray(iArr);
            m16872b(parcel, a);
        } else if (z) {
            m16870a(parcel, i, 0);
        }
    }

    public static void zza(Parcel parcel, int i, long[] jArr, boolean z) {
        if (jArr != null) {
            int a = m16869a(parcel, i);
            parcel.writeLongArray(jArr);
            m16872b(parcel, a);
        } else if (z) {
            m16870a(parcel, i, 0);
        }
    }

    public static <T extends Parcelable> void zza(Parcel parcel, int i, T[] tArr, int i2, boolean z) {
        if (tArr != null) {
            int a = m16869a(parcel, i);
            parcel.writeInt(r3);
            for (Parcelable parcelable : tArr) {
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    m16871a(parcel, parcelable, i2);
                }
            }
            m16872b(parcel, a);
        } else if (z) {
            m16870a(parcel, i, 0);
        }
    }

    public static void zza(Parcel parcel, int i, String[] strArr, boolean z) {
        if (strArr != null) {
            int a = m16869a(parcel, i);
            parcel.writeStringArray(strArr);
            m16872b(parcel, a);
        } else if (z) {
            m16870a(parcel, i, 0);
        }
    }

    public static void zza(Parcel parcel, int i, boolean[] zArr, boolean z) {
        if (zArr != null) {
            int a = m16869a(parcel, i);
            parcel.writeBooleanArray(zArr);
            m16872b(parcel, a);
        } else if (z) {
            m16870a(parcel, i, 0);
        }
    }

    public static void zza(Parcel parcel, int i, byte[][] bArr, boolean z) {
        int i2 = 0;
        if (bArr != null) {
            int a = m16869a(parcel, i);
            int length = bArr.length;
            parcel.writeInt(length);
            while (i2 < length) {
                parcel.writeByteArray(bArr[i2]);
                i2++;
            }
            m16872b(parcel, a);
        } else if (z) {
            m16870a(parcel, i, 0);
        }
    }

    public static void zzaj(Parcel parcel, int i) {
        m16872b(parcel, i);
    }

    public static void zzb(Parcel parcel, int i, List<String> list, boolean z) {
        if (list != null) {
            int a = m16869a(parcel, i);
            parcel.writeStringList(list);
            m16872b(parcel, a);
        } else if (z) {
            m16870a(parcel, i, 0);
        }
    }

    public static void zzc(Parcel parcel, int i, int i2) {
        m16870a(parcel, i, 4);
        parcel.writeInt(i2);
    }

    public static <T extends Parcelable> void zzc(Parcel parcel, int i, List<T> list, boolean z) {
        if (list != null) {
            int a = m16869a(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                Parcelable parcelable = (Parcelable) list.get(i2);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    m16871a(parcel, parcelable, 0);
                }
            }
            m16872b(parcel, a);
        } else if (z) {
            m16870a(parcel, i, 0);
        }
    }

    public static int zzcn(Parcel parcel) {
        return m16869a(parcel, 20293);
    }

    public static void zzd(Parcel parcel, int i, List list, boolean z) {
        if (list != null) {
            int a = m16869a(parcel, i);
            parcel.writeList(list);
            m16872b(parcel, a);
        } else if (z) {
            m16870a(parcel, i, 0);
        }
    }
}
