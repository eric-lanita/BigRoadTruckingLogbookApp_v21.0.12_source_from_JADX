package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzvv;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class zzg {
    private final Account f10744a;
    private final Set<Scope> f10745b;
    private final Set<Scope> f10746c;
    private final Map<Api<?>, zza> f10747d;
    private final int f10748e;
    private final View f10749f;
    private final String f10750g;
    private final String f10751h;
    private final zzvv f10752i;
    private Integer f10753j;

    public static final class zza {
        public final Set<Scope> dT;
        public final boolean yn;

        public zza(Set<Scope> set, boolean z) {
            zzab.zzy(set);
            this.dT = Collections.unmodifiableSet(set);
            this.yn = z;
        }
    }

    public zzg(Account account, Set<Scope> set, Map<Api<?>, zza> map, int i, View view, String str, String str2, zzvv com_google_android_gms_internal_zzvv) {
        Map map2;
        this.f10744a = account;
        this.f10745b = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        if (map == null) {
            map2 = Collections.EMPTY_MAP;
        }
        this.f10747d = map2;
        this.f10749f = view;
        this.f10748e = i;
        this.f10750g = str;
        this.f10751h = str2;
        this.f10752i = com_google_android_gms_internal_zzvv;
        Set hashSet = new HashSet(this.f10745b);
        for (zza com_google_android_gms_common_internal_zzg_zza : this.f10747d.values()) {
            hashSet.addAll(com_google_android_gms_common_internal_zzg_zza.dT);
        }
        this.f10746c = Collections.unmodifiableSet(hashSet);
    }

    public static zzg zzcd(Context context) {
        return new Builder(context).zzaoh();
    }

    public Account getAccount() {
        return this.f10744a;
    }

    @Deprecated
    public String getAccountName() {
        return this.f10744a != null ? this.f10744a.name : null;
    }

    public Account zzary() {
        return this.f10744a != null ? this.f10744a : new Account("<<default account>>", "com.google");
    }

    public int zzasi() {
        return this.f10748e;
    }

    public Set<Scope> zzasj() {
        return this.f10745b;
    }

    public Set<Scope> zzask() {
        return this.f10746c;
    }

    public Map<Api<?>, zza> zzasl() {
        return this.f10747d;
    }

    public String zzasm() {
        return this.f10750g;
    }

    public String zzasn() {
        return this.f10751h;
    }

    public View zzaso() {
        return this.f10749f;
    }

    public zzvv zzasp() {
        return this.f10752i;
    }

    public Integer zzasq() {
        return this.f10753j;
    }

    public Set<Scope> zzb(Api<?> api) {
        zza com_google_android_gms_common_internal_zzg_zza = (zza) this.f10747d.get(api);
        if (com_google_android_gms_common_internal_zzg_zza == null || com_google_android_gms_common_internal_zzg_zza.dT.isEmpty()) {
            return this.f10745b;
        }
        Set<Scope> hashSet = new HashSet(this.f10745b);
        hashSet.addAll(com_google_android_gms_common_internal_zzg_zza.dT);
        return hashSet;
    }

    public void zzc(Integer num) {
        this.f10753j = num;
    }
}
