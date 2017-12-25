package com.google.android.gms.internal;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zzamq {
    private zzanq f11168a = zzanq.beK;
    private zzanf f11169b = zzanf.DEFAULT;
    private zzamo f11170c = zzamn.IDENTITY;
    private final Map<Type, zzamr<?>> f11171d = new HashMap();
    private final List<zzani> f11172e = new ArrayList();
    private final List<zzani> f11173f = new ArrayList();
    private int f11174g = 2;
    private int f11175h = 2;
    private boolean f11176i = true;

    private void m17189a(String str, int i, int i2, List<zzani> list) {
        Object com_google_android_gms_internal_zzamk;
        if (str != null && !"".equals(str.trim())) {
            com_google_android_gms_internal_zzamk = new zzamk(str);
        } else if (i != 2 && i2 != 2) {
            com_google_android_gms_internal_zzamk = new zzamk(i, i2);
        } else {
            return;
        }
        list.add(zzang.zza(zzaol.zzr(Date.class), com_google_android_gms_internal_zzamk));
        list.add(zzang.zza(zzaol.zzr(Timestamp.class), com_google_android_gms_internal_zzamk));
        list.add(zzang.zza(zzaol.zzr(java.sql.Date.class), com_google_android_gms_internal_zzamk));
    }

    public zzamq zza(Type type, Object obj) {
        boolean z = (obj instanceof zzand) || (obj instanceof zzamu) || (obj instanceof zzamr) || (obj instanceof zzanh);
        zzann.zzbo(z);
        if (obj instanceof zzamr) {
            this.f11171d.put(type, (zzamr) obj);
        }
        if ((obj instanceof zzand) || (obj instanceof zzamu)) {
            this.f11172e.add(zzang.zzb(zzaol.zzl(type), obj));
        }
        if (obj instanceof zzanh) {
            this.f11172e.add(zzaok.zza(zzaol.zzl(type), (zzanh) obj));
        }
        return this;
    }

    public zzamq zza(zzaml... com_google_android_gms_internal_zzamlArr) {
        for (zzaml zza : com_google_android_gms_internal_zzamlArr) {
            this.f11168a = this.f11168a.zza(zza, true, true);
        }
        return this;
    }

    public zzamq zzczc() {
        this.f11176i = false;
        return this;
    }

    public zzamp zzczd() {
        List arrayList = new ArrayList();
        arrayList.addAll(this.f11172e);
        Collections.reverse(arrayList);
        arrayList.addAll(this.f11173f);
        m17189a(null, this.f11174g, this.f11175h, arrayList);
        return new zzamp(this.f11168a, this.f11170c, this.f11171d, false, false, false, this.f11176i, false, false, this.f11169b, arrayList);
    }

    public zzamq zzf(int... iArr) {
        this.f11168a = this.f11168a.zzg(iArr);
        return this;
    }
}
