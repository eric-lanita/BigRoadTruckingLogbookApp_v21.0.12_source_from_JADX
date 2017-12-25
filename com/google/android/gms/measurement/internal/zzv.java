package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.support.v4.p008d.C0270a;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.internal.zzapn;
import com.google.android.gms.internal.zzapo;
import com.google.android.gms.internal.zzug.zza;
import com.google.android.gms.internal.zzug.zzb;
import com.google.android.gms.internal.zzug.zzc;
import com.google.android.gms.measurement.AppMeasurement;
import java.io.IOException;
import java.util.Map;

public class zzv extends zzaa {
    private final Map<String, Map<String, String>> f12353a = new C0270a();
    private final Map<String, Map<String, Boolean>> f12354c = new C0270a();
    private final Map<String, Map<String, Boolean>> f12355d = new C0270a();
    private final Map<String, zzb> f12356e = new C0270a();
    private final Map<String, String> f12357f = new C0270a();

    zzv(zzx com_google_android_gms_measurement_internal_zzx) {
        super(com_google_android_gms_measurement_internal_zzx);
    }

    private zzb m17937a(String str, byte[] bArr) {
        if (bArr == null) {
            return new zzb();
        }
        zzapn zzbd = zzapn.zzbd(bArr);
        zzb com_google_android_gms_internal_zzug_zzb = new zzb();
        try {
            zzb com_google_android_gms_internal_zzug_zzb2 = (zzb) com_google_android_gms_internal_zzug_zzb.zzb(zzbd);
            zzbsd().zzbtc().zze("Parsed config. version, gmp_app_id", com_google_android_gms_internal_zzug_zzb.anc, com_google_android_gms_internal_zzug_zzb.aic);
            return com_google_android_gms_internal_zzug_zzb;
        } catch (IOException e) {
            zzbsd().zzbsx().zze("Unable to merge remote config", str, e);
            return null;
        }
    }

    private Map<String, String> m17938a(zzb com_google_android_gms_internal_zzug_zzb) {
        Map<String, String> c0270a = new C0270a();
        if (!(com_google_android_gms_internal_zzug_zzb == null || com_google_android_gms_internal_zzug_zzb.ane == null)) {
            for (zzc com_google_android_gms_internal_zzug_zzc : com_google_android_gms_internal_zzug_zzb.ane) {
                if (com_google_android_gms_internal_zzug_zzc != null) {
                    c0270a.put(com_google_android_gms_internal_zzug_zzc.zzcb, com_google_android_gms_internal_zzug_zzc.value);
                }
            }
        }
        return c0270a;
    }

    private void m17939a(String str, zzb com_google_android_gms_internal_zzug_zzb) {
        Map c0270a = new C0270a();
        Map c0270a2 = new C0270a();
        if (!(com_google_android_gms_internal_zzug_zzb == null || com_google_android_gms_internal_zzug_zzb.anf == null)) {
            for (zza com_google_android_gms_internal_zzug_zza : com_google_android_gms_internal_zzug_zzb.anf) {
                if (com_google_android_gms_internal_zzug_zza != null) {
                    String str2 = (String) AppMeasurement.zza.ahE.get(com_google_android_gms_internal_zzug_zza.name);
                    if (str2 != null) {
                        com_google_android_gms_internal_zzug_zza.name = str2;
                    }
                    c0270a.put(com_google_android_gms_internal_zzug_zza.name, com_google_android_gms_internal_zzug_zza.ana);
                    c0270a2.put(com_google_android_gms_internal_zzug_zza.name, com_google_android_gms_internal_zzug_zza.anb);
                }
            }
        }
        this.f12354c.put(str, c0270a);
        this.f12355d.put(str, c0270a2);
    }

    private void m17940d(String str) {
        m17715c();
        zzwu();
        zzab.zzhr(str);
        if (!this.f12356e.containsKey(str)) {
            byte[] zzlp = zzbry().zzlp(str);
            if (zzlp == null) {
                this.f12353a.put(str, null);
                this.f12354c.put(str, null);
                this.f12355d.put(str, null);
                this.f12356e.put(str, null);
                this.f12357f.put(str, null);
                return;
            }
            zzb a = m17937a(str, zzlp);
            this.f12353a.put(str, m17938a(a));
            m17939a(str, a);
            this.f12356e.put(str, a);
            this.f12357f.put(str, null);
        }
    }

    protected zzb m17941a(String str) {
        m17715c();
        zzwu();
        zzab.zzhr(str);
        m17940d(str);
        return (zzb) this.f12356e.get(str);
    }

    String m17942a(String str, String str2) {
        zzwu();
        m17940d(str);
        Map map = (Map) this.f12353a.get(str);
        return map != null ? (String) map.get(str2) : null;
    }

    protected boolean m17943a(String str, byte[] bArr, String str2) {
        m17715c();
        zzwu();
        zzab.zzhr(str);
        zzb a = m17937a(str, bArr);
        if (a == null) {
            return false;
        }
        m17939a(str, a);
        this.f12356e.put(str, a);
        this.f12357f.put(str, str2);
        this.f12353a.put(str, m17938a(a));
        zzbrt().m17823a(str, a.ang);
        try {
            a.ang = null;
            byte[] bArr2 = new byte[a.aM()];
            a.zza(zzapo.zzbe(bArr2));
            bArr = bArr2;
        } catch (IOException e) {
            zzbsd().zzbsx().zzj("Unable to serialize reduced-size config.  Storing full config instead.", e);
        }
        zzbry().zzd(str, bArr);
        return true;
    }

    protected String m17944b(String str) {
        zzwu();
        return (String) this.f12357f.get(str);
    }

    boolean m17945b(String str, String str2) {
        zzwu();
        m17940d(str);
        Map map = (Map) this.f12354c.get(str);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str2);
        return bool == null ? false : bool.booleanValue();
    }

    protected void m17946c(String str) {
        zzwu();
        this.f12357f.put(str, null);
    }

    boolean m17947c(String str, String str2) {
        zzwu();
        m17940d(str);
        Map map = (Map) this.f12355d.get(str);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str2);
        return bool == null ? false : bool.booleanValue();
    }

    protected void mo2375d() {
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public /* bridge */ /* synthetic */ void zzbrs() {
        super.zzbrs();
    }

    public /* bridge */ /* synthetic */ zzc zzbrt() {
        return super.zzbrt();
    }

    public /* bridge */ /* synthetic */ zzac zzbru() {
        return super.zzbru();
    }

    public /* bridge */ /* synthetic */ zzn zzbrv() {
        return super.zzbrv();
    }

    public /* bridge */ /* synthetic */ zzg zzbrw() {
        return super.zzbrw();
    }

    public /* bridge */ /* synthetic */ zzad zzbrx() {
        return super.zzbrx();
    }

    public /* bridge */ /* synthetic */ zze zzbry() {
        return super.zzbry();
    }

    public /* bridge */ /* synthetic */ zzal zzbrz() {
        return super.zzbrz();
    }

    public /* bridge */ /* synthetic */ zzv zzbsa() {
        return super.zzbsa();
    }

    public /* bridge */ /* synthetic */ zzaf zzbsb() {
        return super.zzbsb();
    }

    public /* bridge */ /* synthetic */ zzw zzbsc() {
        return super.zzbsc();
    }

    public /* bridge */ /* synthetic */ zzp zzbsd() {
        return super.zzbsd();
    }

    public /* bridge */ /* synthetic */ zzt zzbse() {
        return super.zzbse();
    }

    public /* bridge */ /* synthetic */ zzd zzbsf() {
        return super.zzbsf();
    }

    public /* bridge */ /* synthetic */ void zzwu() {
        super.zzwu();
    }

    public /* bridge */ /* synthetic */ void zzyv() {
        super.zzyv();
    }

    public /* bridge */ /* synthetic */ zze zzyw() {
        return super.zzyw();
    }
}
