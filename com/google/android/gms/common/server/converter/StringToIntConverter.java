package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.util.SparseArray;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse.zza;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class StringToIntConverter extends AbstractSafeParcelable implements zza<String, Integer> {
    public static final zzb CREATOR = new zzb();
    private final int f10818a;
    private final HashMap<String, Integer> f10819b;
    private final SparseArray<String> f10820c;
    private final ArrayList<Entry> f10821d;

    public static final class Entry extends AbstractSafeParcelable {
        public static final zzc CREATOR = new zzc();
        final int f10815a;
        final String f10816b;
        final int f10817c;

        Entry(int i, String str, int i2) {
            this.f10815a = i;
            this.f10816b = str;
            this.f10817c = i2;
        }

        Entry(String str, int i) {
            this.f10815a = 1;
            this.f10816b = str;
            this.f10817c = i;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzc com_google_android_gms_common_server_converter_zzc = CREATOR;
            zzc.m16955a(this, parcel, i);
        }
    }

    public StringToIntConverter() {
        this.f10818a = 1;
        this.f10819b = new HashMap();
        this.f10820c = new SparseArray();
        this.f10821d = null;
    }

    StringToIntConverter(int i, ArrayList<Entry> arrayList) {
        this.f10818a = i;
        this.f10819b = new HashMap();
        this.f10820c = new SparseArray();
        this.f10821d = null;
        m16950a(arrayList);
    }

    private void m16950a(ArrayList<Entry> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            zzi(entry.f10816b, entry.f10817c);
        }
    }

    int m16951a() {
        return this.f10818a;
    }

    ArrayList<Entry> m16952b() {
        ArrayList<Entry> arrayList = new ArrayList();
        for (String str : this.f10819b.keySet()) {
            arrayList.add(new Entry(str, ((Integer) this.f10819b.get(str)).intValue()));
        }
        return arrayList;
    }

    public /* synthetic */ Object convertBack(Object obj) {
        return zzd((Integer) obj);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb com_google_android_gms_common_server_converter_zzb = CREATOR;
        zzb.m16954a(this, parcel, i);
    }

    public int zzatt() {
        return 7;
    }

    public int zzatu() {
        return 0;
    }

    public String zzd(Integer num) {
        String str = (String) this.f10820c.get(num.intValue());
        return (str == null && this.f10819b.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    public StringToIntConverter zzi(String str, int i) {
        this.f10819b.put(str, Integer.valueOf(i));
        this.f10820c.put(i, str);
        return this;
    }
}
