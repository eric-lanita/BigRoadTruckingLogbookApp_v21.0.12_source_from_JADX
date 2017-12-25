package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzai.zza;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

abstract class zzal {
    private final Set<String> f12516a;
    private final String f12517b;

    public zzal(String str, String... strArr) {
        this.f12517b = str;
        this.f12516a = new HashSet(strArr.length);
        for (Object add : strArr) {
            this.f12516a.add(add);
        }
    }

    boolean m18070a(Set<String> set) {
        return set.containsAll(this.f12516a);
    }

    public abstract zza zzav(Map<String, zza> map);

    public abstract boolean zzcag();

    public String zzcbp() {
        return this.f12517b;
    }

    public Set<String> zzcbq() {
        return this.f12516a;
    }
}
