package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@KeepName
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    public static final Creator<DataHolder> CREATOR = new zze();
    private static final zza f10590k = new C32121(new String[0], null);
    Bundle f10591a;
    int[] f10592b;
    int f10593c;
    boolean f10594d;
    private final int f10595e;
    private final String[] f10596f;
    private final CursorWindow[] f10597g;
    private final int f10598h;
    private final Bundle f10599i;
    private boolean f10600j;

    public static class zza {
        private final String[] f10584a;
        private final ArrayList<HashMap<String, Object>> f10585b;
        private final String f10586c;
        private final HashMap<Object, Integer> f10587d;
        private boolean f10588e;
        private String f10589f;

        private zza(String[] strArr, String str) {
            this.f10584a = (String[]) zzab.zzy(strArr);
            this.f10585b = new ArrayList();
            this.f10586c = str;
            this.f10587d = new HashMap();
            this.f10588e = false;
            this.f10589f = null;
        }

        private int m16814a(HashMap<String, Object> hashMap) {
            if (this.f10586c == null) {
                return -1;
            }
            Object obj = hashMap.get(this.f10586c);
            if (obj == null) {
                return -1;
            }
            Integer num = (Integer) this.f10587d.get(obj);
            if (num != null) {
                return num.intValue();
            }
            this.f10587d.put(obj, Integer.valueOf(this.f10585b.size()));
            return -1;
        }

        public zza zza(ContentValues contentValues) {
            com.google.android.gms.common.internal.zzb.zzu(contentValues);
            HashMap hashMap = new HashMap(contentValues.size());
            for (Entry entry : contentValues.valueSet()) {
                hashMap.put((String) entry.getKey(), entry.getValue());
            }
            return zza(hashMap);
        }

        public zza zza(HashMap<String, Object> hashMap) {
            com.google.android.gms.common.internal.zzb.zzu(hashMap);
            int a = m16814a((HashMap) hashMap);
            if (a == -1) {
                this.f10585b.add(hashMap);
            } else {
                this.f10585b.remove(a);
                this.f10585b.add(a, hashMap);
            }
            this.f10588e = false;
            return this;
        }

        public DataHolder zzfu(int i) {
            return new DataHolder(this, i, null);
        }
    }

    class C32121 extends zza {
        C32121(String[] strArr, String str) {
            super(strArr, str);
        }

        public zza zza(ContentValues contentValues) {
            throw new UnsupportedOperationException("Cannot add data to empty builder");
        }

        public zza zza(HashMap<String, Object> hashMap) {
            throw new UnsupportedOperationException("Cannot add data to empty builder");
        }
    }

    public static class zzb extends RuntimeException {
        public zzb(String str) {
            super(str);
        }
    }

    DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.f10594d = false;
        this.f10600j = true;
        this.f10595e = i;
        this.f10596f = strArr;
        this.f10597g = cursorWindowArr;
        this.f10598h = i2;
        this.f10599i = bundle;
    }

    private DataHolder(zza com_google_android_gms_common_data_DataHolder_zza, int i, Bundle bundle) {
        this(com_google_android_gms_common_data_DataHolder_zza.f10584a, m16818a(com_google_android_gms_common_data_DataHolder_zza, -1), i, bundle);
    }

    public DataHolder(String[] strArr, CursorWindow[] cursorWindowArr, int i, Bundle bundle) {
        this.f10594d = false;
        this.f10600j = true;
        this.f10595e = 1;
        this.f10596f = (String[]) zzab.zzy(strArr);
        this.f10597g = (CursorWindow[]) zzab.zzy(cursorWindowArr);
        this.f10598h = i;
        this.f10599i = bundle;
        zzarh();
    }

    private void m16817a(String str, int i) {
        if (this.f10591a == null || !this.f10591a.containsKey(str)) {
            String str2 = "No such column: ";
            String valueOf = String.valueOf(str);
            throw new IllegalArgumentException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        } else if (isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        } else if (i < 0 || i >= this.f10593c) {
            throw new CursorIndexOutOfBoundsException(i, this.f10593c);
        }
    }

    private static CursorWindow[] m16818a(zza com_google_android_gms_common_data_DataHolder_zza, int i) {
        int i2 = 0;
        if (com_google_android_gms_common_data_DataHolder_zza.f10584a.length == 0) {
            return new CursorWindow[0];
        }
        List b = (i < 0 || i >= com_google_android_gms_common_data_DataHolder_zza.f10585b.size()) ? com_google_android_gms_common_data_DataHolder_zza.f10585b : com_google_android_gms_common_data_DataHolder_zza.f10585b.subList(0, i);
        int size = b.size();
        CursorWindow cursorWindow = new CursorWindow(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cursorWindow);
        cursorWindow.setNumColumns(com_google_android_gms_common_data_DataHolder_zza.f10584a.length);
        int i3 = 0;
        int i4 = 0;
        while (i3 < size) {
            try {
                int i5;
                int i6;
                CursorWindow cursorWindow2;
                if (!cursorWindow.allocRow()) {
                    Log.d("DataHolder", "Allocating additional cursor window for large data set (row " + i3 + ")");
                    cursorWindow = new CursorWindow(false);
                    cursorWindow.setStartPosition(i3);
                    cursorWindow.setNumColumns(com_google_android_gms_common_data_DataHolder_zza.f10584a.length);
                    arrayList.add(cursorWindow);
                    if (!cursorWindow.allocRow()) {
                        Log.e("DataHolder", "Unable to allocate row to hold data.");
                        arrayList.remove(cursorWindow);
                        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
                    }
                }
                Map map = (Map) b.get(i3);
                boolean z = true;
                for (int i7 = 0; i7 < com_google_android_gms_common_data_DataHolder_zza.f10584a.length && z; i7++) {
                    String str = com_google_android_gms_common_data_DataHolder_zza.f10584a[i7];
                    Object obj = map.get(str);
                    if (obj == null) {
                        z = cursorWindow.putNull(i3, i7);
                    } else if (obj instanceof String) {
                        z = cursorWindow.putString((String) obj, i3, i7);
                    } else if (obj instanceof Long) {
                        z = cursorWindow.putLong(((Long) obj).longValue(), i3, i7);
                    } else if (obj instanceof Integer) {
                        z = cursorWindow.putLong((long) ((Integer) obj).intValue(), i3, i7);
                    } else if (obj instanceof Boolean) {
                        z = cursorWindow.putLong(((Boolean) obj).booleanValue() ? 1 : 0, i3, i7);
                    } else if (obj instanceof byte[]) {
                        z = cursorWindow.putBlob((byte[]) obj, i3, i7);
                    } else if (obj instanceof Double) {
                        z = cursorWindow.putDouble(((Double) obj).doubleValue(), i3, i7);
                    } else if (obj instanceof Float) {
                        z = cursorWindow.putDouble((double) ((Float) obj).floatValue(), i3, i7);
                    } else {
                        String valueOf = String.valueOf(obj);
                        throw new IllegalArgumentException(new StringBuilder((String.valueOf(str).length() + 32) + String.valueOf(valueOf).length()).append("Unsupported object for column ").append(str).append(": ").append(valueOf).toString());
                    }
                }
                if (z) {
                    i5 = i3;
                    i6 = 0;
                    cursorWindow2 = cursorWindow;
                } else if (i4 != 0) {
                    throw new zzb("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
                } else {
                    Log.d("DataHolder", "Couldn't populate window data for row " + i3 + " - allocating new window.");
                    cursorWindow.freeLastRow();
                    CursorWindow cursorWindow3 = new CursorWindow(false);
                    cursorWindow3.setStartPosition(i3);
                    cursorWindow3.setNumColumns(com_google_android_gms_common_data_DataHolder_zza.f10584a.length);
                    arrayList.add(cursorWindow3);
                    i5 = i3 - 1;
                    cursorWindow2 = cursorWindow3;
                    i6 = 1;
                }
                i4 = i6;
                cursorWindow = cursorWindow2;
                i3 = i5 + 1;
            } catch (RuntimeException e) {
                RuntimeException runtimeException = e;
                int size2 = arrayList.size();
                while (i2 < size2) {
                    ((CursorWindow) arrayList.get(i2)).close();
                    i2++;
                }
                throw runtimeException;
            }
        }
        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
    }

    public static DataHolder zza(int i, Bundle bundle) {
        return new DataHolder(f10590k, i, bundle);
    }

    public static zza zzb(String[] strArr) {
        return new zza(strArr, null);
    }

    public static DataHolder zzft(int i) {
        return zza(i, null);
    }

    int m16819a() {
        return this.f10595e;
    }

    String[] m16820b() {
        return this.f10596f;
    }

    CursorWindow[] m16821c() {
        return this.f10597g;
    }

    public void close() {
        synchronized (this) {
            if (!this.f10594d) {
                this.f10594d = true;
                for (CursorWindow close : this.f10597g) {
                    close.close();
                }
            }
        }
    }

    protected void finalize() {
        try {
            if (this.f10600j && this.f10597g.length > 0 && !isClosed()) {
                close();
                String valueOf = String.valueOf(toString());
                Log.e("DataBuffer", new StringBuilder(String.valueOf(valueOf).length() + 178).append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ").append(valueOf).append(")").toString());
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    public int getCount() {
        return this.f10593c;
    }

    public int getStatusCode() {
        return this.f10598h;
    }

    public boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.f10594d;
        }
        return z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze.m16824a(this, parcel, i);
    }

    public void zza(String str, int i, int i2, CharArrayBuffer charArrayBuffer) {
        m16817a(str, i);
        this.f10597g[i2].copyStringToBuffer(i, this.f10591a.getInt(str), charArrayBuffer);
    }

    public Bundle zzarc() {
        return this.f10599i;
    }

    public void zzarh() {
        int i;
        int i2 = 0;
        this.f10591a = new Bundle();
        for (i = 0; i < this.f10596f.length; i++) {
            this.f10591a.putInt(this.f10596f[i], i);
        }
        this.f10592b = new int[this.f10597g.length];
        i = 0;
        while (i2 < this.f10597g.length) {
            this.f10592b[i2] = i;
            i += this.f10597g[i2].getNumRows() - (i - this.f10597g[i2].getStartPosition());
            i2++;
        }
        this.f10593c = i;
    }

    public long zzb(String str, int i, int i2) {
        m16817a(str, i);
        return this.f10597g[i2].getLong(i, this.f10591a.getInt(str));
    }

    public int zzc(String str, int i, int i2) {
        m16817a(str, i);
        return this.f10597g[i2].getInt(i, this.f10591a.getInt(str));
    }

    public String zzd(String str, int i, int i2) {
        m16817a(str, i);
        return this.f10597g[i2].getString(i, this.f10591a.getInt(str));
    }

    public boolean zze(String str, int i, int i2) {
        m16817a(str, i);
        return Long.valueOf(this.f10597g[i2].getLong(i, this.f10591a.getInt(str))).longValue() == 1;
    }

    public float zzf(String str, int i, int i2) {
        m16817a(str, i);
        return this.f10597g[i2].getFloat(i, this.f10591a.getInt(str));
    }

    public int zzfs(int i) {
        int i2 = 0;
        boolean z = i >= 0 && i < this.f10593c;
        zzab.zzbn(z);
        while (i2 < this.f10592b.length) {
            if (i < this.f10592b[i2]) {
                i2--;
                break;
            }
            i2++;
        }
        return i2 == this.f10592b.length ? i2 - 1 : i2;
    }

    public byte[] zzg(String str, int i, int i2) {
        m16817a(str, i);
        return this.f10597g[i2].getBlob(i, this.f10591a.getInt(str));
    }

    public Uri zzh(String str, int i, int i2) {
        String zzd = zzd(str, i, i2);
        return zzd == null ? null : Uri.parse(zzd);
    }

    public boolean zzhe(String str) {
        return this.f10591a.containsKey(str);
    }

    public boolean zzi(String str, int i, int i2) {
        m16817a(str, i);
        return this.f10597g[i2].isNull(i, this.f10591a.getInt(str));
    }
}
