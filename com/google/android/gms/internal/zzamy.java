package com.google.android.gms.internal;

import java.util.Map.Entry;
import java.util.Set;

public final class zzamy extends zzamv {
    private final zzant<String, zzamv> f11178a = new zzant();

    public Set<Entry<String, zzamv>> entrySet() {
        return this.f11178a.entrySet();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof zzamy) && ((zzamy) obj).f11178a.equals(this.f11178a));
    }

    public boolean has(String str) {
        return this.f11178a.containsKey(str);
    }

    public int hashCode() {
        return this.f11178a.hashCode();
    }

    public void zza(String str, zzamv com_google_android_gms_internal_zzamv) {
        Object obj;
        if (com_google_android_gms_internal_zzamv == null) {
            obj = zzamx.bei;
        }
        this.f11178a.put(str, obj);
    }

    public zzamv zzto(String str) {
        return (zzamv) this.f11178a.get(str);
    }
}
