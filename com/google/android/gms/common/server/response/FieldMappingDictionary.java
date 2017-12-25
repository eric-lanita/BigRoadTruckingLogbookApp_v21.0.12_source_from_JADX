package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FieldMappingDictionary extends AbstractSafeParcelable {
    public static final zzc CREATOR = new zzc();
    private final int f10839a;
    private final HashMap<String, Map<String, Field<?, ?>>> f10840b;
    private final ArrayList<Entry> f10841c = null;
    private final String f10842d;

    public static class Entry extends AbstractSafeParcelable {
        public static final zzd CREATOR = new zzd();
        final int f10833a;
        final String f10834b;
        final ArrayList<FieldMapPair> f10835c;

        Entry(int i, String str, ArrayList<FieldMapPair> arrayList) {
            this.f10833a = i;
            this.f10834b = str;
            this.f10835c = arrayList;
        }

        Entry(String str, Map<String, Field<?, ?>> map) {
            this.f10833a = 1;
            this.f10834b = str;
            this.f10835c = m16966a(map);
        }

        private static ArrayList<FieldMapPair> m16966a(Map<String, Field<?, ?>> map) {
            if (map == null) {
                return null;
            }
            ArrayList<FieldMapPair> arrayList = new ArrayList();
            for (String str : map.keySet()) {
                arrayList.add(new FieldMapPair(str, (Field) map.get(str)));
            }
            return arrayList;
        }

        HashMap<String, Field<?, ?>> m16967a() {
            HashMap<String, Field<?, ?>> hashMap = new HashMap();
            int size = this.f10835c.size();
            for (int i = 0; i < size; i++) {
                FieldMapPair fieldMapPair = (FieldMapPair) this.f10835c.get(i);
                hashMap.put(fieldMapPair.f10837b, fieldMapPair.f10838c);
            }
            return hashMap;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzd com_google_android_gms_common_server_response_zzd = CREATOR;
            zzd.m16983a(this, parcel, i);
        }
    }

    public static class FieldMapPair extends AbstractSafeParcelable {
        public static final zzb CREATOR = new zzb();
        final int f10836a;
        final String f10837b;
        final Field<?, ?> f10838c;

        FieldMapPair(int i, String str, Field<?, ?> field) {
            this.f10836a = i;
            this.f10837b = str;
            this.f10838c = field;
        }

        FieldMapPair(String str, Field<?, ?> field) {
            this.f10836a = 1;
            this.f10837b = str;
            this.f10838c = field;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzb com_google_android_gms_common_server_response_zzb = CREATOR;
            zzb.m16981a(this, parcel, i);
        }
    }

    FieldMappingDictionary(int i, ArrayList<Entry> arrayList, String str) {
        this.f10839a = i;
        this.f10840b = m16968a(arrayList);
        this.f10842d = (String) zzab.zzy(str);
        zzauh();
    }

    private static HashMap<String, Map<String, Field<?, ?>>> m16968a(ArrayList<Entry> arrayList) {
        HashMap<String, Map<String, Field<?, ?>>> hashMap = new HashMap();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Entry entry = (Entry) arrayList.get(i);
            hashMap.put(entry.f10834b, entry.m16967a());
        }
        return hashMap;
    }

    int m16969a() {
        return this.f10839a;
    }

    ArrayList<Entry> m16970b() {
        ArrayList<Entry> arrayList = new ArrayList();
        for (String str : this.f10840b.keySet()) {
            arrayList.add(new Entry(str, (Map) this.f10840b.get(str)));
        }
        return arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : this.f10840b.keySet()) {
            stringBuilder.append(str).append(":\n");
            Map map = (Map) this.f10840b.get(str);
            for (String str2 : map.keySet()) {
                stringBuilder.append("  ").append(str2).append(": ");
                stringBuilder.append(map.get(str2));
            }
        }
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc com_google_android_gms_common_server_response_zzc = CREATOR;
        zzc.m16982a(this, parcel, i);
    }

    public void zzauh() {
        for (String str : this.f10840b.keySet()) {
            Map map = (Map) this.f10840b.get(str);
            for (String str2 : map.keySet()) {
                ((Field) map.get(str2)).zza(this);
            }
        }
    }

    public String zzauj() {
        return this.f10842d;
    }

    public Map<String, Field<?, ?>> zzhw(String str) {
        return (Map) this.f10840b.get(str);
    }
}
