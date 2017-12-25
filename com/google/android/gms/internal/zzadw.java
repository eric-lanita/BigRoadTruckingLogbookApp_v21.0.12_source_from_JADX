package com.google.android.gms.internal;

import com.google.android.gms.internal.zzah.zzh;
import com.google.android.gms.tagmanager.zzbn;
import com.google.android.gms.tagmanager.zzdl;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class zzadw {

    public static class zza {
        private final Map<String, com.google.android.gms.internal.zzai.zza> f11093a;
        private final com.google.android.gms.internal.zzai.zza f11094b;

        private zza(Map<String, com.google.android.gms.internal.zzai.zza> map, com.google.android.gms.internal.zzai.zza com_google_android_gms_internal_zzai_zza) {
            this.f11093a = map;
            this.f11094b = com_google_android_gms_internal_zzai_zza;
        }

        public static zzb zzcgy() {
            return new zzb();
        }

        public String toString() {
            String valueOf = String.valueOf(zzcfx());
            String valueOf2 = String.valueOf(this.f11094b);
            return new StringBuilder((String.valueOf(valueOf).length() + 32) + String.valueOf(valueOf2).length()).append("Properties: ").append(valueOf).append(" pushAfterEvaluate: ").append(valueOf2).toString();
        }

        public void zza(String str, com.google.android.gms.internal.zzai.zza com_google_android_gms_internal_zzai_zza) {
            this.f11093a.put(str, com_google_android_gms_internal_zzai_zza);
        }

        public com.google.android.gms.internal.zzai.zza zzccv() {
            return this.f11094b;
        }

        public Map<String, com.google.android.gms.internal.zzai.zza> zzcfx() {
            return Collections.unmodifiableMap(this.f11093a);
        }
    }

    public static class zzb {
        private final Map<String, com.google.android.gms.internal.zzai.zza> f11095a;
        private com.google.android.gms.internal.zzai.zza f11096b;

        private zzb() {
            this.f11095a = new HashMap();
        }

        public zzb zzb(String str, com.google.android.gms.internal.zzai.zza com_google_android_gms_internal_zzai_zza) {
            this.f11095a.put(str, com_google_android_gms_internal_zzai_zza);
            return this;
        }

        public zza zzcgz() {
            return new zza(this.f11095a, this.f11096b);
        }

        public zzb zzq(com.google.android.gms.internal.zzai.zza com_google_android_gms_internal_zzai_zza) {
            this.f11096b = com_google_android_gms_internal_zzai_zza;
            return this;
        }
    }

    public static class zzc {
        private final List<zze> f11097a;
        private final Map<String, List<zza>> f11098b;
        private final String f11099c;
        private final int f11100d;

        private zzc(List<zze> list, Map<String, List<zza>> map, String str, int i) {
            this.f11097a = Collections.unmodifiableList(list);
            this.f11098b = Collections.unmodifiableMap(map);
            this.f11099c = str;
            this.f11100d = i;
        }

        public static zzd zzcha() {
            return new zzd();
        }

        public String getVersion() {
            return this.f11099c;
        }

        public String toString() {
            String valueOf = String.valueOf(zzcfv());
            String valueOf2 = String.valueOf(this.f11098b);
            return new StringBuilder((String.valueOf(valueOf).length() + 17) + String.valueOf(valueOf2).length()).append("Rules: ").append(valueOf).append("  Macros: ").append(valueOf2).toString();
        }

        public List<zze> zzcfv() {
            return this.f11097a;
        }

        public Map<String, List<zza>> zzchb() {
            return this.f11098b;
        }
    }

    public static class zzd {
        private final List<zze> f11101a;
        private final Map<String, List<zza>> f11102b;
        private String f11103c;
        private int f11104d;

        private zzd() {
            this.f11101a = new ArrayList();
            this.f11102b = new HashMap();
            this.f11103c = "";
            this.f11104d = 0;
        }

        public zzd zzb(zze com_google_android_gms_internal_zzadw_zze) {
            this.f11101a.add(com_google_android_gms_internal_zzadw_zze);
            return this;
        }

        public zzd zzc(zza com_google_android_gms_internal_zzadw_zza) {
            String zzg = zzdl.zzg((com.google.android.gms.internal.zzai.zza) com_google_android_gms_internal_zzadw_zza.zzcfx().get(zzag.INSTANCE_NAME.toString()));
            List list = (List) this.f11102b.get(zzg);
            if (list == null) {
                list = new ArrayList();
                this.f11102b.put(zzg, list);
            }
            list.add(com_google_android_gms_internal_zzadw_zza);
            return this;
        }

        public zzc zzchc() {
            return new zzc(this.f11101a, this.f11102b, this.f11103c, this.f11104d);
        }

        public zzd zzqs(String str) {
            this.f11103c = str;
            return this;
        }

        public zzd zzzt(int i) {
            this.f11104d = i;
            return this;
        }
    }

    public static class zze {
        private final List<zza> f11105a;
        private final List<zza> f11106b;
        private final List<zza> f11107c;
        private final List<zza> f11108d;
        private final List<zza> f11109e;
        private final List<zza> f11110f;
        private final List<String> f11111g;
        private final List<String> f11112h;
        private final List<String> f11113i;
        private final List<String> f11114j;

        private zze(List<zza> list, List<zza> list2, List<zza> list3, List<zza> list4, List<zza> list5, List<zza> list6, List<String> list7, List<String> list8, List<String> list9, List<String> list10) {
            this.f11105a = Collections.unmodifiableList(list);
            this.f11106b = Collections.unmodifiableList(list2);
            this.f11107c = Collections.unmodifiableList(list3);
            this.f11108d = Collections.unmodifiableList(list4);
            this.f11109e = Collections.unmodifiableList(list5);
            this.f11110f = Collections.unmodifiableList(list6);
            this.f11111g = Collections.unmodifiableList(list7);
            this.f11112h = Collections.unmodifiableList(list8);
            this.f11113i = Collections.unmodifiableList(list9);
            this.f11114j = Collections.unmodifiableList(list10);
        }

        public static zzf zzchd() {
            return new zzf();
        }

        public String toString() {
            String valueOf = String.valueOf(zzcfz());
            String valueOf2 = String.valueOf(zzcga());
            String valueOf3 = String.valueOf(zzcgb());
            String valueOf4 = String.valueOf(zzcgc());
            String valueOf5 = String.valueOf(zzche());
            String valueOf6 = String.valueOf(zzchj());
            return new StringBuilder((((((String.valueOf(valueOf).length() + 102) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()) + String.valueOf(valueOf4).length()) + String.valueOf(valueOf5).length()) + String.valueOf(valueOf6).length()).append("Positive predicates: ").append(valueOf).append("  Negative predicates: ").append(valueOf2).append("  Add tags: ").append(valueOf3).append("  Remove tags: ").append(valueOf4).append("  Add macros: ").append(valueOf5).append("  Remove macros: ").append(valueOf6).toString();
        }

        public List<zza> zzcfz() {
            return this.f11105a;
        }

        public List<zza> zzcga() {
            return this.f11106b;
        }

        public List<zza> zzcgb() {
            return this.f11107c;
        }

        public List<zza> zzcgc() {
            return this.f11108d;
        }

        public List<zza> zzche() {
            return this.f11109e;
        }

        public List<String> zzchf() {
            return this.f11111g;
        }

        public List<String> zzchg() {
            return this.f11112h;
        }

        public List<String> zzchh() {
            return this.f11113i;
        }

        public List<String> zzchi() {
            return this.f11114j;
        }

        public List<zza> zzchj() {
            return this.f11110f;
        }
    }

    public static class zzf {
        private final List<zza> f11115a;
        private final List<zza> f11116b;
        private final List<zza> f11117c;
        private final List<zza> f11118d;
        private final List<zza> f11119e;
        private final List<zza> f11120f;
        private final List<String> f11121g;
        private final List<String> f11122h;
        private final List<String> f11123i;
        private final List<String> f11124j;

        private zzf() {
            this.f11115a = new ArrayList();
            this.f11116b = new ArrayList();
            this.f11117c = new ArrayList();
            this.f11118d = new ArrayList();
            this.f11119e = new ArrayList();
            this.f11120f = new ArrayList();
            this.f11121g = new ArrayList();
            this.f11122h = new ArrayList();
            this.f11123i = new ArrayList();
            this.f11124j = new ArrayList();
        }

        public zze zzchk() {
            return new zze(this.f11115a, this.f11116b, this.f11117c, this.f11118d, this.f11119e, this.f11120f, this.f11121g, this.f11122h, this.f11123i, this.f11124j);
        }

        public zzf zzd(zza com_google_android_gms_internal_zzadw_zza) {
            this.f11115a.add(com_google_android_gms_internal_zzadw_zza);
            return this;
        }

        public zzf zze(zza com_google_android_gms_internal_zzadw_zza) {
            this.f11116b.add(com_google_android_gms_internal_zzadw_zza);
            return this;
        }

        public zzf zzf(zza com_google_android_gms_internal_zzadw_zza) {
            this.f11117c.add(com_google_android_gms_internal_zzadw_zza);
            return this;
        }

        public zzf zzg(zza com_google_android_gms_internal_zzadw_zza) {
            this.f11118d.add(com_google_android_gms_internal_zzadw_zza);
            return this;
        }

        public zzf zzh(zza com_google_android_gms_internal_zzadw_zza) {
            this.f11119e.add(com_google_android_gms_internal_zzadw_zza);
            return this;
        }

        public zzf zzi(zza com_google_android_gms_internal_zzadw_zza) {
            this.f11120f.add(com_google_android_gms_internal_zzadw_zza);
            return this;
        }

        public zzf zzqt(String str) {
            this.f11123i.add(str);
            return this;
        }

        public zzf zzqu(String str) {
            this.f11124j.add(str);
            return this;
        }

        public zzf zzqv(String str) {
            this.f11121g.add(str);
            return this;
        }

        public zzf zzqw(String str) {
            this.f11122h.add(str);
            return this;
        }
    }

    public static class zzg extends Exception {
        public zzg(String str) {
            super(str);
        }
    }

    private static zza m17148a(com.google.android.gms.internal.zzah.zzb com_google_android_gms_internal_zzah_zzb, com.google.android.gms.internal.zzah.zzf com_google_android_gms_internal_zzah_zzf, com.google.android.gms.internal.zzai.zza[] com_google_android_gms_internal_zzai_zzaArr, int i) {
        zzb zzcgy = zza.zzcgy();
        for (int valueOf : com_google_android_gms_internal_zzah_zzb.zzuq) {
            com.google.android.gms.internal.zzah.zze com_google_android_gms_internal_zzah_zze = (com.google.android.gms.internal.zzah.zze) m17152a(com_google_android_gms_internal_zzah_zzf.zzvg, Integer.valueOf(valueOf).intValue(), "properties");
            String str = (String) m17152a(com_google_android_gms_internal_zzah_zzf.zzve, com_google_android_gms_internal_zzah_zze.key, "keys");
            com.google.android.gms.internal.zzai.zza com_google_android_gms_internal_zzai_zza = (com.google.android.gms.internal.zzai.zza) m17152a(com_google_android_gms_internal_zzai_zzaArr, com_google_android_gms_internal_zzah_zze.value, "values");
            if (zzag.PUSH_AFTER_EVALUATE.toString().equals(str)) {
                zzcgy.zzq(com_google_android_gms_internal_zzai_zza);
            } else {
                zzcgy.zzb(str, com_google_android_gms_internal_zzai_zza);
            }
        }
        return zzcgy.zzcgz();
    }

    private static zze m17149a(com.google.android.gms.internal.zzah.zzg com_google_android_gms_internal_zzah_zzg, List<zza> list, List<zza> list2, List<zza> list3, com.google.android.gms.internal.zzah.zzf com_google_android_gms_internal_zzah_zzf) {
        zzf zzchd = zze.zzchd();
        for (int valueOf : com_google_android_gms_internal_zzah_zzg.zzvu) {
            zzchd.zzd((zza) list3.get(Integer.valueOf(valueOf).intValue()));
        }
        for (int valueOf2 : com_google_android_gms_internal_zzah_zzg.zzvv) {
            zzchd.zze((zza) list3.get(Integer.valueOf(valueOf2).intValue()));
        }
        for (int valueOf22 : com_google_android_gms_internal_zzah_zzg.zzvw) {
            zzchd.zzf((zza) list.get(Integer.valueOf(valueOf22).intValue()));
        }
        for (int valueOf3 : com_google_android_gms_internal_zzah_zzg.zzvy) {
            zzchd.zzqt(com_google_android_gms_internal_zzah_zzf.zzvf[Integer.valueOf(valueOf3).intValue()].string);
        }
        for (int valueOf222 : com_google_android_gms_internal_zzah_zzg.zzvx) {
            zzchd.zzg((zza) list.get(Integer.valueOf(valueOf222).intValue()));
        }
        for (int valueOf32 : com_google_android_gms_internal_zzah_zzg.zzvz) {
            zzchd.zzqu(com_google_android_gms_internal_zzah_zzf.zzvf[Integer.valueOf(valueOf32).intValue()].string);
        }
        for (int valueOf2222 : com_google_android_gms_internal_zzah_zzg.zzwa) {
            zzchd.zzh((zza) list2.get(Integer.valueOf(valueOf2222).intValue()));
        }
        for (int valueOf322 : com_google_android_gms_internal_zzah_zzg.zzwc) {
            zzchd.zzqv(com_google_android_gms_internal_zzah_zzf.zzvf[Integer.valueOf(valueOf322).intValue()].string);
        }
        for (int valueOf22222 : com_google_android_gms_internal_zzah_zzg.zzwb) {
            zzchd.zzi((zza) list2.get(Integer.valueOf(valueOf22222).intValue()));
        }
        for (int valueOf4 : com_google_android_gms_internal_zzah_zzg.zzwd) {
            zzchd.zzqw(com_google_android_gms_internal_zzah_zzf.zzvf[Integer.valueOf(valueOf4).intValue()].string);
        }
        return zzchd.zzchk();
    }

    private static zzh m17150a(com.google.android.gms.internal.zzai.zza com_google_android_gms_internal_zzai_zza) {
        if (((zzh) com_google_android_gms_internal_zzai_zza.zza(zzh.zzwe)) == null) {
            String valueOf = String.valueOf(com_google_android_gms_internal_zzai_zza);
            m17153a(new StringBuilder(String.valueOf(valueOf).length() + 54).append("Expected a ServingValue and didn't get one. Value is: ").append(valueOf).toString());
        }
        return (zzh) com_google_android_gms_internal_zzai_zza.zza(zzh.zzwe);
    }

    private static com.google.android.gms.internal.zzai.zza m17151a(int i, com.google.android.gms.internal.zzah.zzf com_google_android_gms_internal_zzah_zzf, com.google.android.gms.internal.zzai.zza[] com_google_android_gms_internal_zzai_zzaArr, Set<Integer> set) {
        int i2 = 0;
        if (set.contains(Integer.valueOf(i))) {
            String valueOf = String.valueOf(set);
            m17153a(new StringBuilder(String.valueOf(valueOf).length() + 90).append("Value cycle detected.  Current value reference: ").append(i).append(".  Previous value references: ").append(valueOf).append(".").toString());
        }
        com.google.android.gms.internal.zzai.zza com_google_android_gms_internal_zzai_zza = (com.google.android.gms.internal.zzai.zza) m17152a(com_google_android_gms_internal_zzah_zzf.zzvf, i, "values");
        if (com_google_android_gms_internal_zzai_zzaArr[i] != null) {
            return com_google_android_gms_internal_zzai_zzaArr[i];
        }
        com.google.android.gms.internal.zzai.zza com_google_android_gms_internal_zzai_zza2 = null;
        set.add(Integer.valueOf(i));
        zzh a;
        int[] iArr;
        int length;
        int i3;
        int i4;
        switch (com_google_android_gms_internal_zzai_zza.type) {
            case 1:
            case 5:
            case 6:
            case 8:
                com_google_android_gms_internal_zzai_zza2 = com_google_android_gms_internal_zzai_zza;
                break;
            case 2:
                a = m17150a(com_google_android_gms_internal_zzai_zza);
                com_google_android_gms_internal_zzai_zza2 = zzo(com_google_android_gms_internal_zzai_zza);
                com_google_android_gms_internal_zzai_zza2.zzwu = new com.google.android.gms.internal.zzai.zza[a.zzwg.length];
                iArr = a.zzwg;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    com_google_android_gms_internal_zzai_zza2.zzwu[i3] = m17151a(iArr[i2], com_google_android_gms_internal_zzah_zzf, com_google_android_gms_internal_zzai_zzaArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
            case 3:
                com_google_android_gms_internal_zzai_zza2 = zzo(com_google_android_gms_internal_zzai_zza);
                zzh a2 = m17150a(com_google_android_gms_internal_zzai_zza);
                if (a2.zzwh.length != a2.zzwi.length) {
                    i3 = a2.zzwh.length;
                    m17153a("Uneven map keys (" + i3 + ") and map values (" + a2.zzwi.length + ")");
                }
                com_google_android_gms_internal_zzai_zza2.zzwv = new com.google.android.gms.internal.zzai.zza[a2.zzwh.length];
                com_google_android_gms_internal_zzai_zza2.zzww = new com.google.android.gms.internal.zzai.zza[a2.zzwh.length];
                int[] iArr2 = a2.zzwh;
                int length2 = iArr2.length;
                i3 = 0;
                i4 = 0;
                while (i3 < length2) {
                    int i5 = i4 + 1;
                    com_google_android_gms_internal_zzai_zza2.zzwv[i4] = m17151a(iArr2[i3], com_google_android_gms_internal_zzah_zzf, com_google_android_gms_internal_zzai_zzaArr, (Set) set);
                    i3++;
                    i4 = i5;
                }
                iArr = a2.zzwi;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    com_google_android_gms_internal_zzai_zza2.zzww[i3] = m17151a(iArr[i2], com_google_android_gms_internal_zzah_zzf, com_google_android_gms_internal_zzai_zzaArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
            case 4:
                com_google_android_gms_internal_zzai_zza2 = zzo(com_google_android_gms_internal_zzai_zza);
                com_google_android_gms_internal_zzai_zza2.zzwx = zzdl.zzg(m17151a(m17150a(com_google_android_gms_internal_zzai_zza).zzwl, com_google_android_gms_internal_zzah_zzf, com_google_android_gms_internal_zzai_zzaArr, (Set) set));
                break;
            case 7:
                com_google_android_gms_internal_zzai_zza2 = zzo(com_google_android_gms_internal_zzai_zza);
                a = m17150a(com_google_android_gms_internal_zzai_zza);
                com_google_android_gms_internal_zzai_zza2.zzxb = new com.google.android.gms.internal.zzai.zza[a.zzwk.length];
                iArr = a.zzwk;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    com_google_android_gms_internal_zzai_zza2.zzxb[i3] = m17151a(iArr[i2], com_google_android_gms_internal_zzah_zzf, com_google_android_gms_internal_zzai_zzaArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
        }
        if (com_google_android_gms_internal_zzai_zza2 == null) {
            valueOf = String.valueOf(com_google_android_gms_internal_zzai_zza);
            m17153a(new StringBuilder(String.valueOf(valueOf).length() + 15).append("Invalid value: ").append(valueOf).toString());
        }
        com_google_android_gms_internal_zzai_zzaArr[i] = com_google_android_gms_internal_zzai_zza2;
        set.remove(Integer.valueOf(i));
        return com_google_android_gms_internal_zzai_zza2;
    }

    private static <T> T m17152a(T[] tArr, int i, String str) {
        if (i < 0 || i >= tArr.length) {
            m17153a(new StringBuilder(String.valueOf(str).length() + 45).append("Index out of bounds detected: ").append(i).append(" in ").append(str).toString());
        }
        return tArr[i];
    }

    private static void m17153a(String str) {
        zzbn.m18105e(str);
        throw new zzg(str);
    }

    public static zzc zzb(com.google.android.gms.internal.zzah.zzf com_google_android_gms_internal_zzah_zzf) {
        int i;
        int i2 = 0;
        com.google.android.gms.internal.zzai.zza[] com_google_android_gms_internal_zzai_zzaArr = new com.google.android.gms.internal.zzai.zza[com_google_android_gms_internal_zzah_zzf.zzvf.length];
        for (i = 0; i < com_google_android_gms_internal_zzah_zzf.zzvf.length; i++) {
            m17151a(i, com_google_android_gms_internal_zzah_zzf, com_google_android_gms_internal_zzai_zzaArr, new HashSet(0));
        }
        zzd zzcha = zzc.zzcha();
        List arrayList = new ArrayList();
        for (i = 0; i < com_google_android_gms_internal_zzah_zzf.zzvi.length; i++) {
            arrayList.add(m17148a(com_google_android_gms_internal_zzah_zzf.zzvi[i], com_google_android_gms_internal_zzah_zzf, com_google_android_gms_internal_zzai_zzaArr, i));
        }
        List arrayList2 = new ArrayList();
        for (i = 0; i < com_google_android_gms_internal_zzah_zzf.zzvj.length; i++) {
            arrayList2.add(m17148a(com_google_android_gms_internal_zzah_zzf.zzvj[i], com_google_android_gms_internal_zzah_zzf, com_google_android_gms_internal_zzai_zzaArr, i));
        }
        List arrayList3 = new ArrayList();
        for (i = 0; i < com_google_android_gms_internal_zzah_zzf.zzvh.length; i++) {
            zza a = m17148a(com_google_android_gms_internal_zzah_zzf.zzvh[i], com_google_android_gms_internal_zzah_zzf, com_google_android_gms_internal_zzai_zzaArr, i);
            zzcha.zzc(a);
            arrayList3.add(a);
        }
        com.google.android.gms.internal.zzah.zzg[] com_google_android_gms_internal_zzah_zzgArr = com_google_android_gms_internal_zzah_zzf.zzvk;
        int length = com_google_android_gms_internal_zzah_zzgArr.length;
        while (i2 < length) {
            zzcha.zzb(m17149a(com_google_android_gms_internal_zzah_zzgArr[i2], arrayList, arrayList3, arrayList2, com_google_android_gms_internal_zzah_zzf));
            i2++;
        }
        zzcha.zzqs(com_google_android_gms_internal_zzah_zzf.version);
        zzcha.zzzt(com_google_android_gms_internal_zzah_zzf.zzvs);
        return zzcha.zzchc();
    }

    public static void zzc(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static com.google.android.gms.internal.zzai.zza zzo(com.google.android.gms.internal.zzai.zza com_google_android_gms_internal_zzai_zza) {
        com.google.android.gms.internal.zzai.zza com_google_android_gms_internal_zzai_zza2 = new com.google.android.gms.internal.zzai.zza();
        com_google_android_gms_internal_zzai_zza2.type = com_google_android_gms_internal_zzai_zza.type;
        com_google_android_gms_internal_zzai_zza2.zzxc = (int[]) com_google_android_gms_internal_zzai_zza.zzxc.clone();
        if (com_google_android_gms_internal_zzai_zza.zzxd) {
            com_google_android_gms_internal_zzai_zza2.zzxd = com_google_android_gms_internal_zzai_zza.zzxd;
        }
        return com_google_android_gms_internal_zzai_zza2;
    }
}
