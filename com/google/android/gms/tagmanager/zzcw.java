package com.google.android.gms.tagmanager;

import android.content.Context;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.internal.zzadw;
import com.google.android.gms.internal.zzadw.zze;
import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzah.zzi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class zzcw {
    private static final zzcd<com.google.android.gms.internal.zzai.zza> f12671a = new zzcd(zzdl.zzcdu(), true);
    private final com.google.android.gms.internal.zzadw.zzc f12672b;
    private final zzai f12673c;
    private final Map<String, zzal> f12674d;
    private final Map<String, zzal> f12675e;
    private final Map<String, zzal> f12676f;
    private final zzl<com.google.android.gms.internal.zzadw.zza, zzcd<com.google.android.gms.internal.zzai.zza>> f12677g;
    private final zzl<String, zzb> f12678h;
    private final Set<zze> f12679i;
    private final DataLayer f12680j;
    private final Map<String, zzc> f12681k;
    private volatile String f12682l;
    private int f12683m;

    class C34371 implements com.google.android.gms.tagmanager.zzm.zza<com.google.android.gms.internal.zzadw.zza, zzcd<com.google.android.gms.internal.zzai.zza>> {
        final /* synthetic */ zzcw f12655a;

        C34371(zzcw com_google_android_gms_tagmanager_zzcw) {
            this.f12655a = com_google_android_gms_tagmanager_zzcw;
        }

        public /* synthetic */ int sizeOf(Object obj, Object obj2) {
            return zza((com.google.android.gms.internal.zzadw.zza) obj, (zzcd) obj2);
        }

        public int zza(com.google.android.gms.internal.zzadw.zza com_google_android_gms_internal_zzadw_zza, zzcd<com.google.android.gms.internal.zzai.zza> com_google_android_gms_tagmanager_zzcd_com_google_android_gms_internal_zzai_zza) {
            return ((com.google.android.gms.internal.zzai.zza) com_google_android_gms_tagmanager_zzcd_com_google_android_gms_internal_zzai_zza.getObject()).aL();
        }
    }

    class C34382 implements com.google.android.gms.tagmanager.zzm.zza<String, zzb> {
        final /* synthetic */ zzcw f12656a;

        C34382(zzcw com_google_android_gms_tagmanager_zzcw) {
            this.f12656a = com_google_android_gms_tagmanager_zzcw;
        }

        public /* synthetic */ int sizeOf(Object obj, Object obj2) {
            return zza((String) obj, (zzb) obj2);
        }

        public int zza(String str, zzb com_google_android_gms_tagmanager_zzcw_zzb) {
            return str.length() + com_google_android_gms_tagmanager_zzcw_zzb.getSize();
        }
    }

    interface zza {
        void zza(zze com_google_android_gms_internal_zzadw_zze, Set<com.google.android.gms.internal.zzadw.zza> set, Set<com.google.android.gms.internal.zzadw.zza> set2, zzcr com_google_android_gms_tagmanager_zzcr);
    }

    class C34404 implements zza {
        final /* synthetic */ zzcw f12662a;

        C34404(zzcw com_google_android_gms_tagmanager_zzcw) {
            this.f12662a = com_google_android_gms_tagmanager_zzcw;
        }

        public void zza(zze com_google_android_gms_internal_zzadw_zze, Set<com.google.android.gms.internal.zzadw.zza> set, Set<com.google.android.gms.internal.zzadw.zza> set2, zzcr com_google_android_gms_tagmanager_zzcr) {
            set.addAll(com_google_android_gms_internal_zzadw_zze.zzcgb());
            set2.addAll(com_google_android_gms_internal_zzadw_zze.zzcgc());
            com_google_android_gms_tagmanager_zzcr.zzcbz().zzc(com_google_android_gms_internal_zzadw_zze.zzcgb(), com_google_android_gms_internal_zzadw_zze.zzchh());
            com_google_android_gms_tagmanager_zzcr.zzcca().zzc(com_google_android_gms_internal_zzadw_zze.zzcgc(), com_google_android_gms_internal_zzadw_zze.zzchi());
        }
    }

    private static class zzb {
        private zzcd<com.google.android.gms.internal.zzai.zza> f12663a;
        private com.google.android.gms.internal.zzai.zza f12664b;

        public zzb(zzcd<com.google.android.gms.internal.zzai.zza> com_google_android_gms_tagmanager_zzcd_com_google_android_gms_internal_zzai_zza, com.google.android.gms.internal.zzai.zza com_google_android_gms_internal_zzai_zza) {
            this.f12663a = com_google_android_gms_tagmanager_zzcd_com_google_android_gms_internal_zzai_zza;
            this.f12664b = com_google_android_gms_internal_zzai_zza;
        }

        public int getSize() {
            return (this.f12664b == null ? 0 : this.f12664b.aL()) + ((com.google.android.gms.internal.zzai.zza) this.f12663a.getObject()).aL();
        }

        public zzcd<com.google.android.gms.internal.zzai.zza> zzccu() {
            return this.f12663a;
        }

        public com.google.android.gms.internal.zzai.zza zzccv() {
            return this.f12664b;
        }
    }

    private static class zzc {
        private final Set<zze> f12665a = new HashSet();
        private final Map<zze, List<com.google.android.gms.internal.zzadw.zza>> f12666b = new HashMap();
        private final Map<zze, List<com.google.android.gms.internal.zzadw.zza>> f12667c = new HashMap();
        private final Map<zze, List<String>> f12668d = new HashMap();
        private final Map<zze, List<String>> f12669e = new HashMap();
        private com.google.android.gms.internal.zzadw.zza f12670f;

        public void zza(zze com_google_android_gms_internal_zzadw_zze) {
            this.f12665a.add(com_google_android_gms_internal_zzadw_zze);
        }

        public void zza(zze com_google_android_gms_internal_zzadw_zze, com.google.android.gms.internal.zzadw.zza com_google_android_gms_internal_zzadw_zza) {
            List list = (List) this.f12666b.get(com_google_android_gms_internal_zzadw_zze);
            if (list == null) {
                list = new ArrayList();
                this.f12666b.put(com_google_android_gms_internal_zzadw_zze, list);
            }
            list.add(com_google_android_gms_internal_zzadw_zza);
        }

        public void zza(zze com_google_android_gms_internal_zzadw_zze, String str) {
            List list = (List) this.f12668d.get(com_google_android_gms_internal_zzadw_zze);
            if (list == null) {
                list = new ArrayList();
                this.f12668d.put(com_google_android_gms_internal_zzadw_zze, list);
            }
            list.add(str);
        }

        public void zzb(com.google.android.gms.internal.zzadw.zza com_google_android_gms_internal_zzadw_zza) {
            this.f12670f = com_google_android_gms_internal_zzadw_zza;
        }

        public void zzb(zze com_google_android_gms_internal_zzadw_zze, com.google.android.gms.internal.zzadw.zza com_google_android_gms_internal_zzadw_zza) {
            List list = (List) this.f12667c.get(com_google_android_gms_internal_zzadw_zze);
            if (list == null) {
                list = new ArrayList();
                this.f12667c.put(com_google_android_gms_internal_zzadw_zze, list);
            }
            list.add(com_google_android_gms_internal_zzadw_zza);
        }

        public void zzb(zze com_google_android_gms_internal_zzadw_zze, String str) {
            List list = (List) this.f12669e.get(com_google_android_gms_internal_zzadw_zze);
            if (list == null) {
                list = new ArrayList();
                this.f12669e.put(com_google_android_gms_internal_zzadw_zze, list);
            }
            list.add(str);
        }

        public Set<zze> zzccw() {
            return this.f12665a;
        }

        public Map<zze, List<com.google.android.gms.internal.zzadw.zza>> zzccx() {
            return this.f12666b;
        }

        public Map<zze, List<String>> zzccy() {
            return this.f12668d;
        }

        public Map<zze, List<String>> zzccz() {
            return this.f12669e;
        }

        public Map<zze, List<com.google.android.gms.internal.zzadw.zza>> zzcda() {
            return this.f12667c;
        }

        public com.google.android.gms.internal.zzadw.zza zzcdb() {
            return this.f12670f;
        }
    }

    public zzcw(Context context, com.google.android.gms.internal.zzadw.zzc com_google_android_gms_internal_zzadw_zzc, DataLayer dataLayer, com.google.android.gms.tagmanager.zzt.zza com_google_android_gms_tagmanager_zzt_zza, com.google.android.gms.tagmanager.zzt.zza com_google_android_gms_tagmanager_zzt_zza2, zzai com_google_android_gms_tagmanager_zzai) {
        if (com_google_android_gms_internal_zzadw_zzc == null) {
            throw new NullPointerException("resource cannot be null");
        }
        this.f12672b = com_google_android_gms_internal_zzadw_zzc;
        this.f12679i = new HashSet(com_google_android_gms_internal_zzadw_zzc.zzcfv());
        this.f12680j = dataLayer;
        this.f12673c = com_google_android_gms_tagmanager_zzai;
        this.f12677g = new zzm().zza(1048576, new C34371(this));
        this.f12678h = new zzm().zza(1048576, new C34382(this));
        this.f12674d = new HashMap();
        m18170b(new zzj(context));
        m18170b(new zzt(com_google_android_gms_tagmanager_zzt_zza2));
        m18170b(new zzx(dataLayer));
        m18170b(new zzdm(context, dataLayer));
        this.f12675e = new HashMap();
        m18171c(new zzr());
        m18171c(new zzaf());
        m18171c(new zzag());
        m18171c(new zzan());
        m18171c(new zzao());
        m18171c(new zzbj());
        m18171c(new zzbk());
        m18171c(new zzcm());
        m18171c(new zzdf());
        this.f12676f = new HashMap();
        m18168a(new zzb(context));
        m18168a(new zzc(context));
        m18168a(new zze(context));
        m18168a(new zzf(context));
        m18168a(new zzg(context));
        m18168a(new zzh(context));
        m18168a(new zzi(context));
        m18168a(new zzn());
        m18168a(new zzq(this.f12672b.getVersion()));
        m18168a(new zzt(com_google_android_gms_tagmanager_zzt_zza));
        m18168a(new zzv(dataLayer));
        m18168a(new zzaa(context));
        m18168a(new zzab());
        m18168a(new zzae());
        m18168a(new zzaj(this));
        m18168a(new zzap());
        m18168a(new zzaq());
        m18168a(new zzbd(context));
        m18168a(new zzbf());
        m18168a(new zzbi());
        m18168a(new zzbp());
        m18168a(new zzbr(context));
        m18168a(new zzce());
        m18168a(new zzcg());
        m18168a(new zzcj());
        m18168a(new zzcl());
        m18168a(new zzcn(context));
        m18168a(new zzcx());
        m18168a(new zzcy());
        m18168a(new zzdh());
        m18168a(new zzdn());
        this.f12681k = new HashMap();
        for (zze com_google_android_gms_internal_zzadw_zze : this.f12679i) {
            if (com_google_android_gms_tagmanager_zzai.zzcbo()) {
                m18160a(com_google_android_gms_internal_zzadw_zze.zzche(), com_google_android_gms_internal_zzadw_zze.zzchf(), "add macro");
                m18160a(com_google_android_gms_internal_zzadw_zze.zzchj(), com_google_android_gms_internal_zzadw_zze.zzchg(), "remove macro");
                m18160a(com_google_android_gms_internal_zzadw_zze.zzcgb(), com_google_android_gms_internal_zzadw_zze.zzchh(), "add tag");
                m18160a(com_google_android_gms_internal_zzadw_zze.zzcgc(), com_google_android_gms_internal_zzadw_zze.zzchi(), "remove tag");
            }
            int i = 0;
            while (i < com_google_android_gms_internal_zzadw_zze.zzche().size()) {
                com.google.android.gms.internal.zzadw.zza com_google_android_gms_internal_zzadw_zza = (com.google.android.gms.internal.zzadw.zza) com_google_android_gms_internal_zzadw_zze.zzche().get(i);
                String str = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                if (com_google_android_gms_tagmanager_zzai.zzcbo() && i < com_google_android_gms_internal_zzadw_zze.zzchf().size()) {
                    str = (String) com_google_android_gms_internal_zzadw_zze.zzchf().get(i);
                }
                zzc a = m18157a(this.f12681k, m18158a(com_google_android_gms_internal_zzadw_zza));
                a.zza(com_google_android_gms_internal_zzadw_zze);
                a.zza(com_google_android_gms_internal_zzadw_zze, com_google_android_gms_internal_zzadw_zza);
                a.zza(com_google_android_gms_internal_zzadw_zze, str);
                i++;
            }
            i = 0;
            while (i < com_google_android_gms_internal_zzadw_zze.zzchj().size()) {
                com_google_android_gms_internal_zzadw_zza = (com.google.android.gms.internal.zzadw.zza) com_google_android_gms_internal_zzadw_zze.zzchj().get(i);
                str = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                if (com_google_android_gms_tagmanager_zzai.zzcbo() && i < com_google_android_gms_internal_zzadw_zze.zzchg().size()) {
                    str = (String) com_google_android_gms_internal_zzadw_zze.zzchg().get(i);
                }
                a = m18157a(this.f12681k, m18158a(com_google_android_gms_internal_zzadw_zza));
                a.zza(com_google_android_gms_internal_zzadw_zze);
                a.zzb(com_google_android_gms_internal_zzadw_zze, com_google_android_gms_internal_zzadw_zza);
                a.zzb(com_google_android_gms_internal_zzadw_zze, str);
                i++;
            }
        }
        for (Entry entry : this.f12672b.zzchb().entrySet()) {
            for (com.google.android.gms.internal.zzadw.zza com_google_android_gms_internal_zzadw_zza2 : (List) entry.getValue()) {
                if (!zzdl.zzk((com.google.android.gms.internal.zzai.zza) com_google_android_gms_internal_zzadw_zza2.zzcfx().get(zzag.NOT_DEFAULT_MACRO.toString())).booleanValue()) {
                    m18157a(this.f12681k, (String) entry.getKey()).zzb(com_google_android_gms_internal_zzadw_zza2);
                }
            }
        }
    }

    private zzcd<com.google.android.gms.internal.zzai.zza> m18153a(com.google.android.gms.internal.zzai.zza com_google_android_gms_internal_zzai_zza, Set<String> set, zzdo com_google_android_gms_tagmanager_zzdo) {
        if (!com_google_android_gms_internal_zzai_zza.zzxd) {
            return new zzcd(com_google_android_gms_internal_zzai_zza, true);
        }
        com.google.android.gms.internal.zzai.zza zzo;
        int i;
        zzcd a;
        String str;
        String valueOf;
        switch (com_google_android_gms_internal_zzai_zza.type) {
            case 2:
                zzo = zzadw.zzo(com_google_android_gms_internal_zzai_zza);
                zzo.zzwu = new com.google.android.gms.internal.zzai.zza[com_google_android_gms_internal_zzai_zza.zzwu.length];
                for (i = 0; i < com_google_android_gms_internal_zzai_zza.zzwu.length; i++) {
                    a = m18153a(com_google_android_gms_internal_zzai_zza.zzwu[i], (Set) set, com_google_android_gms_tagmanager_zzdo.zzzh(i));
                    if (a == f12671a) {
                        return f12671a;
                    }
                    zzo.zzwu[i] = (com.google.android.gms.internal.zzai.zza) a.getObject();
                }
                return new zzcd(zzo, false);
            case 3:
                zzo = zzadw.zzo(com_google_android_gms_internal_zzai_zza);
                if (com_google_android_gms_internal_zzai_zza.zzwv.length != com_google_android_gms_internal_zzai_zza.zzww.length) {
                    str = "Invalid serving value: ";
                    valueOf = String.valueOf(com_google_android_gms_internal_zzai_zza.toString());
                    zzbn.m18105e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                    return f12671a;
                }
                zzo.zzwv = new com.google.android.gms.internal.zzai.zza[com_google_android_gms_internal_zzai_zza.zzwv.length];
                zzo.zzww = new com.google.android.gms.internal.zzai.zza[com_google_android_gms_internal_zzai_zza.zzwv.length];
                for (i = 0; i < com_google_android_gms_internal_zzai_zza.zzwv.length; i++) {
                    a = m18153a(com_google_android_gms_internal_zzai_zza.zzwv[i], (Set) set, com_google_android_gms_tagmanager_zzdo.zzzi(i));
                    zzcd a2 = m18153a(com_google_android_gms_internal_zzai_zza.zzww[i], (Set) set, com_google_android_gms_tagmanager_zzdo.zzzj(i));
                    if (a == f12671a || a2 == f12671a) {
                        return f12671a;
                    }
                    zzo.zzwv[i] = (com.google.android.gms.internal.zzai.zza) a.getObject();
                    zzo.zzww[i] = (com.google.android.gms.internal.zzai.zza) a2.getObject();
                }
                return new zzcd(zzo, false);
            case 4:
                if (set.contains(com_google_android_gms_internal_zzai_zza.zzwx)) {
                    valueOf = String.valueOf(com_google_android_gms_internal_zzai_zza.zzwx);
                    str = String.valueOf(set.toString());
                    zzbn.m18105e(new StringBuilder((String.valueOf(valueOf).length() + 79) + String.valueOf(str).length()).append("Macro cycle detected.  Current macro reference: ").append(valueOf).append(".  Previous macro references: ").append(str).append(".").toString());
                    return f12671a;
                }
                set.add(com_google_android_gms_internal_zzai_zza.zzwx);
                zzcd<com.google.android.gms.internal.zzai.zza> a3 = zzdp.m18219a(m18154a(com_google_android_gms_internal_zzai_zza.zzwx, (Set) set, com_google_android_gms_tagmanager_zzdo.zzccc()), com_google_android_gms_internal_zzai_zza.zzxc);
                set.remove(com_google_android_gms_internal_zzai_zza.zzwx);
                return a3;
            case 7:
                zzo = zzadw.zzo(com_google_android_gms_internal_zzai_zza);
                zzo.zzxb = new com.google.android.gms.internal.zzai.zza[com_google_android_gms_internal_zzai_zza.zzxb.length];
                for (i = 0; i < com_google_android_gms_internal_zzai_zza.zzxb.length; i++) {
                    a = m18153a(com_google_android_gms_internal_zzai_zza.zzxb[i], (Set) set, com_google_android_gms_tagmanager_zzdo.zzzk(i));
                    if (a == f12671a) {
                        return f12671a;
                    }
                    zzo.zzxb[i] = (com.google.android.gms.internal.zzai.zza) a.getObject();
                }
                return new zzcd(zzo, false);
            default:
                zzbn.m18105e("Unknown type: " + com_google_android_gms_internal_zzai_zza.type);
                return f12671a;
        }
    }

    private zzcd<com.google.android.gms.internal.zzai.zza> m18154a(String str, Set<String> set, zzbq com_google_android_gms_tagmanager_zzbq) {
        this.f12683m++;
        zzb com_google_android_gms_tagmanager_zzcw_zzb = (zzb) this.f12678h.get(str);
        if (com_google_android_gms_tagmanager_zzcw_zzb == null || this.f12673c.zzcbo()) {
            zzc com_google_android_gms_tagmanager_zzcw_zzc = (zzc) this.f12681k.get(str);
            String valueOf;
            if (com_google_android_gms_tagmanager_zzcw_zzc == null) {
                valueOf = String.valueOf(m18162b());
                zzbn.m18105e(new StringBuilder((String.valueOf(valueOf).length() + 15) + String.valueOf(str).length()).append(valueOf).append("Invalid macro: ").append(str).toString());
                this.f12683m--;
                return f12671a;
            }
            com.google.android.gms.internal.zzadw.zza zzcdb;
            zzcd a = m18165a(str, com_google_android_gms_tagmanager_zzcw_zzc.zzccw(), com_google_android_gms_tagmanager_zzcw_zzc.zzccx(), com_google_android_gms_tagmanager_zzcw_zzc.zzccy(), com_google_android_gms_tagmanager_zzcw_zzc.zzcda(), com_google_android_gms_tagmanager_zzcw_zzc.zzccz(), set, com_google_android_gms_tagmanager_zzbq.zzcba());
            if (((Set) a.getObject()).isEmpty()) {
                zzcdb = com_google_android_gms_tagmanager_zzcw_zzc.zzcdb();
            } else {
                if (((Set) a.getObject()).size() > 1) {
                    valueOf = String.valueOf(m18162b());
                    zzbn.zzcx(new StringBuilder((String.valueOf(valueOf).length() + 37) + String.valueOf(str).length()).append(valueOf).append("Multiple macros active for macroName ").append(str).toString());
                }
                zzcdb = (com.google.android.gms.internal.zzadw.zza) ((Set) a.getObject()).iterator().next();
            }
            if (zzcdb == null) {
                this.f12683m--;
                return f12671a;
            }
            zzcd a2 = m18155a(this.f12676f, zzcdb, (Set) set, com_google_android_gms_tagmanager_zzbq.zzcbu());
            boolean z = a.zzccd() && a2.zzccd();
            zzcd<com.google.android.gms.internal.zzai.zza> com_google_android_gms_tagmanager_zzcd = a2 == f12671a ? f12671a : new zzcd((com.google.android.gms.internal.zzai.zza) a2.getObject(), z);
            com.google.android.gms.internal.zzai.zza zzccv = zzcdb.zzccv();
            if (com_google_android_gms_tagmanager_zzcd.zzccd()) {
                this.f12678h.zzi(str, new zzb(com_google_android_gms_tagmanager_zzcd, zzccv));
            }
            m18159a(zzccv, (Set) set);
            this.f12683m--;
            return com_google_android_gms_tagmanager_zzcd;
        }
        m18159a(com_google_android_gms_tagmanager_zzcw_zzb.zzccv(), (Set) set);
        this.f12683m--;
        return com_google_android_gms_tagmanager_zzcw_zzb.zzccu();
    }

    private zzcd<com.google.android.gms.internal.zzai.zza> m18155a(Map<String, zzal> map, com.google.android.gms.internal.zzadw.zza com_google_android_gms_internal_zzadw_zza, Set<String> set, zzco com_google_android_gms_tagmanager_zzco) {
        boolean z = true;
        com.google.android.gms.internal.zzai.zza com_google_android_gms_internal_zzai_zza = (com.google.android.gms.internal.zzai.zza) com_google_android_gms_internal_zzadw_zza.zzcfx().get(zzag.FUNCTION.toString());
        if (com_google_android_gms_internal_zzai_zza == null) {
            zzbn.m18105e("No function id in properties");
            return f12671a;
        }
        String str = com_google_android_gms_internal_zzai_zza.zzwy;
        zzal com_google_android_gms_tagmanager_zzal = (zzal) map.get(str);
        if (com_google_android_gms_tagmanager_zzal == null) {
            zzbn.m18105e(String.valueOf(str).concat(" has no backing implementation."));
            return f12671a;
        }
        zzcd<com.google.android.gms.internal.zzai.zza> com_google_android_gms_tagmanager_zzcd_com_google_android_gms_internal_zzai_zza = (zzcd) this.f12677g.get(com_google_android_gms_internal_zzadw_zza);
        if (com_google_android_gms_tagmanager_zzcd_com_google_android_gms_internal_zzai_zza != null && !this.f12673c.zzcbo()) {
            return com_google_android_gms_tagmanager_zzcd_com_google_android_gms_internal_zzai_zza;
        }
        Map hashMap = new HashMap();
        boolean z2 = true;
        for (Entry entry : com_google_android_gms_internal_zzadw_zza.zzcfx().entrySet()) {
            zzcd a = m18153a((com.google.android.gms.internal.zzai.zza) entry.getValue(), (Set) set, com_google_android_gms_tagmanager_zzco.zzoy((String) entry.getKey()).zze((com.google.android.gms.internal.zzai.zza) entry.getValue()));
            if (a == f12671a) {
                return f12671a;
            }
            boolean z3;
            if (a.zzccd()) {
                com_google_android_gms_internal_zzadw_zza.zza((String) entry.getKey(), (com.google.android.gms.internal.zzai.zza) a.getObject());
                z3 = z2;
            } else {
                z3 = false;
            }
            hashMap.put((String) entry.getKey(), (com.google.android.gms.internal.zzai.zza) a.getObject());
            z2 = z3;
        }
        if (com_google_android_gms_tagmanager_zzal.m18070a(hashMap.keySet())) {
            if (!(z2 && com_google_android_gms_tagmanager_zzal.zzcag())) {
                z = false;
            }
            com_google_android_gms_tagmanager_zzcd_com_google_android_gms_internal_zzai_zza = new zzcd(com_google_android_gms_tagmanager_zzal.zzav(hashMap), z);
            if (z) {
                this.f12677g.zzi(com_google_android_gms_internal_zzadw_zza, com_google_android_gms_tagmanager_zzcd_com_google_android_gms_internal_zzai_zza);
            }
            com_google_android_gms_tagmanager_zzco.zzd((com.google.android.gms.internal.zzai.zza) com_google_android_gms_tagmanager_zzcd_com_google_android_gms_internal_zzai_zza.getObject());
            return com_google_android_gms_tagmanager_zzcd_com_google_android_gms_internal_zzai_zza;
        }
        String valueOf = String.valueOf(com_google_android_gms_tagmanager_zzal.zzcbq());
        String valueOf2 = String.valueOf(hashMap.keySet());
        zzbn.m18105e(new StringBuilder(((String.valueOf(str).length() + 43) + String.valueOf(valueOf).length()) + String.valueOf(valueOf2).length()).append("Incorrect keys for function ").append(str).append(" required ").append(valueOf).append(" had ").append(valueOf2).toString());
        return f12671a;
    }

    private zzcd<Set<com.google.android.gms.internal.zzadw.zza>> m18156a(Set<zze> set, Set<String> set2, zza com_google_android_gms_tagmanager_zzcw_zza, zzcv com_google_android_gms_tagmanager_zzcv) {
        Set hashSet = new HashSet();
        Collection hashSet2 = new HashSet();
        boolean z = true;
        for (zze com_google_android_gms_internal_zzadw_zze : set) {
            zzcr zzccb = com_google_android_gms_tagmanager_zzcv.zzccb();
            zzcd a = m18164a(com_google_android_gms_internal_zzadw_zze, (Set) set2, zzccb);
            if (((Boolean) a.getObject()).booleanValue()) {
                com_google_android_gms_tagmanager_zzcw_zza.zza(com_google_android_gms_internal_zzadw_zze, hashSet, hashSet2, zzccb);
            }
            boolean z2 = z && a.zzccd();
            z = z2;
        }
        hashSet.removeAll(hashSet2);
        com_google_android_gms_tagmanager_zzcv.zzg(hashSet);
        return new zzcd(hashSet, z);
    }

    private static zzc m18157a(Map<String, zzc> map, String str) {
        zzc com_google_android_gms_tagmanager_zzcw_zzc = (zzc) map.get(str);
        if (com_google_android_gms_tagmanager_zzcw_zzc != null) {
            return com_google_android_gms_tagmanager_zzcw_zzc;
        }
        com_google_android_gms_tagmanager_zzcw_zzc = new zzc();
        map.put(str, com_google_android_gms_tagmanager_zzcw_zzc);
        return com_google_android_gms_tagmanager_zzcw_zzc;
    }

    private static String m18158a(com.google.android.gms.internal.zzadw.zza com_google_android_gms_internal_zzadw_zza) {
        return zzdl.zzg((com.google.android.gms.internal.zzai.zza) com_google_android_gms_internal_zzadw_zza.zzcfx().get(zzag.INSTANCE_NAME.toString()));
    }

    private void m18159a(com.google.android.gms.internal.zzai.zza com_google_android_gms_internal_zzai_zza, Set<String> set) {
        if (com_google_android_gms_internal_zzai_zza != null) {
            zzcd a = m18153a(com_google_android_gms_internal_zzai_zza, (Set) set, new zzcb());
            if (a != f12671a) {
                Object zzl = zzdl.zzl((com.google.android.gms.internal.zzai.zza) a.getObject());
                if (zzl instanceof Map) {
                    this.f12680j.push((Map) zzl);
                } else if (zzl instanceof List) {
                    for (Object zzl2 : (List) zzl2) {
                        if (zzl2 instanceof Map) {
                            this.f12680j.push((Map) zzl2);
                        } else {
                            zzbn.zzcx("pushAfterEvaluate: value not a Map");
                        }
                    }
                } else {
                    zzbn.zzcx("pushAfterEvaluate: value not a Map or List");
                }
            }
        }
    }

    private static void m18160a(List<com.google.android.gms.internal.zzadw.zza> list, List<String> list2, String str) {
        if (list.size() != list2.size()) {
            zzbn.zzcw(new StringBuilder(String.valueOf(str).length() + 102).append("Invalid resource: imbalance of rule names of functions for ").append(str).append(" operation. Using default rule name instead").toString());
        }
    }

    private static void m18161a(Map<String, zzal> map, zzal com_google_android_gms_tagmanager_zzal) {
        if (map.containsKey(com_google_android_gms_tagmanager_zzal.zzcbp())) {
            String str = "Duplicate function type name: ";
            String valueOf = String.valueOf(com_google_android_gms_tagmanager_zzal.zzcbp());
            throw new IllegalArgumentException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
        map.put(com_google_android_gms_tagmanager_zzal.zzcbp(), com_google_android_gms_tagmanager_zzal);
    }

    private String m18162b() {
        if (this.f12683m <= 1) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Integer.toString(this.f12683m));
        for (int i = 2; i < this.f12683m; i++) {
            stringBuilder.append(' ');
        }
        stringBuilder.append(": ");
        return stringBuilder.toString();
    }

    zzcd<Boolean> m18163a(com.google.android.gms.internal.zzadw.zza com_google_android_gms_internal_zzadw_zza, Set<String> set, zzco com_google_android_gms_tagmanager_zzco) {
        zzcd a = m18155a(this.f12675e, com_google_android_gms_internal_zzadw_zza, (Set) set, com_google_android_gms_tagmanager_zzco);
        Boolean zzk = zzdl.zzk((com.google.android.gms.internal.zzai.zza) a.getObject());
        com_google_android_gms_tagmanager_zzco.zzd(zzdl.zzap(zzk));
        return new zzcd(zzk, a.zzccd());
    }

    zzcd<Boolean> m18164a(zze com_google_android_gms_internal_zzadw_zze, Set<String> set, zzcr com_google_android_gms_tagmanager_zzcr) {
        boolean z = true;
        for (com.google.android.gms.internal.zzadw.zza a : com_google_android_gms_internal_zzadw_zze.zzcga()) {
            zzcd a2 = m18163a(a, (Set) set, com_google_android_gms_tagmanager_zzcr.zzcbv());
            if (((Boolean) a2.getObject()).booleanValue()) {
                com_google_android_gms_tagmanager_zzcr.zzf(zzdl.zzap(Boolean.valueOf(false)));
                return new zzcd(Boolean.valueOf(false), a2.zzccd());
            }
            boolean z2 = z && a2.zzccd();
            z = z2;
        }
        for (com.google.android.gms.internal.zzadw.zza a3 : com_google_android_gms_internal_zzadw_zze.zzcfz()) {
            a2 = m18163a(a3, (Set) set, com_google_android_gms_tagmanager_zzcr.zzcbw());
            if (((Boolean) a2.getObject()).booleanValue()) {
                z = z && a2.zzccd();
            } else {
                com_google_android_gms_tagmanager_zzcr.zzf(zzdl.zzap(Boolean.valueOf(false)));
                return new zzcd(Boolean.valueOf(false), a2.zzccd());
            }
        }
        com_google_android_gms_tagmanager_zzcr.zzf(zzdl.zzap(Boolean.valueOf(true)));
        return new zzcd(Boolean.valueOf(true), z);
    }

    zzcd<Set<com.google.android.gms.internal.zzadw.zza>> m18165a(String str, Set<zze> set, Map<zze, List<com.google.android.gms.internal.zzadw.zza>> map, Map<zze, List<String>> map2, Map<zze, List<com.google.android.gms.internal.zzadw.zza>> map3, Map<zze, List<String>> map4, Set<String> set2, zzcv com_google_android_gms_tagmanager_zzcv) {
        final Map<zze, List<com.google.android.gms.internal.zzadw.zza>> map5 = map;
        final Map<zze, List<String>> map6 = map2;
        final Map<zze, List<com.google.android.gms.internal.zzadw.zza>> map7 = map3;
        final Map<zze, List<String>> map8 = map4;
        return m18156a((Set) set, (Set) set2, new zza(this) {
            final /* synthetic */ zzcw f12661e;

            public void zza(zze com_google_android_gms_internal_zzadw_zze, Set<com.google.android.gms.internal.zzadw.zza> set, Set<com.google.android.gms.internal.zzadw.zza> set2, zzcr com_google_android_gms_tagmanager_zzcr) {
                List list = (List) map5.get(com_google_android_gms_internal_zzadw_zze);
                List list2 = (List) map6.get(com_google_android_gms_internal_zzadw_zze);
                if (list != null) {
                    set.addAll(list);
                    com_google_android_gms_tagmanager_zzcr.zzcbx().zzc(list, list2);
                }
                list = (List) map7.get(com_google_android_gms_internal_zzadw_zze);
                list2 = (List) map8.get(com_google_android_gms_internal_zzadw_zze);
                if (list != null) {
                    set2.addAll(list);
                    com_google_android_gms_tagmanager_zzcr.zzcby().zzc(list, list2);
                }
            }
        }, com_google_android_gms_tagmanager_zzcv);
    }

    zzcd<Set<com.google.android.gms.internal.zzadw.zza>> m18166a(Set<zze> set, zzcv com_google_android_gms_tagmanager_zzcv) {
        return m18156a((Set) set, new HashSet(), new C34404(this), com_google_android_gms_tagmanager_zzcv);
    }

    synchronized String m18167a() {
        return this.f12682l;
    }

    void m18168a(zzal com_google_android_gms_tagmanager_zzal) {
        m18161a(this.f12676f, com_google_android_gms_tagmanager_zzal);
    }

    synchronized void m18169a(String str) {
        this.f12682l = str;
    }

    void m18170b(zzal com_google_android_gms_tagmanager_zzal) {
        m18161a(this.f12674d, com_google_android_gms_tagmanager_zzal);
    }

    void m18171c(zzal com_google_android_gms_tagmanager_zzal) {
        m18161a(this.f12675e, com_google_android_gms_tagmanager_zzal);
    }

    public synchronized void zzaj(List<zzi> list) {
        for (zzi com_google_android_gms_internal_zzah_zzi : list) {
            if (com_google_android_gms_internal_zzah_zzi.name == null || !com_google_android_gms_internal_zzah_zzi.name.startsWith("gaExperiment:")) {
                String valueOf = String.valueOf(com_google_android_gms_internal_zzah_zzi);
                zzbn.m18106v(new StringBuilder(String.valueOf(valueOf).length() + 22).append("Ignored supplemental: ").append(valueOf).toString());
            } else {
                zzak.zza(this.f12680j, com_google_android_gms_internal_zzah_zzi);
            }
        }
    }

    public synchronized void zzog(String str) {
        m18169a(str);
        zzah zzot = this.f12673c.zzot(str);
        zzu zzcbm = zzot.zzcbm();
        for (com.google.android.gms.internal.zzadw.zza a : (Set) m18166a(this.f12679i, zzcbm.zzcba()).getObject()) {
            m18155a(this.f12674d, a, new HashSet(), zzcbm.zzcaz());
        }
        zzot.zzcbn();
        m18169a(null);
    }

    public zzcd<com.google.android.gms.internal.zzai.zza> zzpc(String str) {
        this.f12683m = 0;
        zzah zzos = this.f12673c.zzos(str);
        zzcd<com.google.android.gms.internal.zzai.zza> a = m18154a(str, new HashSet(), zzos.zzcbl());
        zzos.zzcbn();
        return a;
    }
}
