package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class zzams extends zzamv implements Iterable<zzamv> {
    private final List<zzamv> f11177a = new ArrayList();

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof zzams) && ((zzams) obj).f11177a.equals(this.f11177a));
    }

    public boolean getAsBoolean() {
        if (this.f11177a.size() == 1) {
            return ((zzamv) this.f11177a.get(0)).getAsBoolean();
        }
        throw new IllegalStateException();
    }

    public double getAsDouble() {
        if (this.f11177a.size() == 1) {
            return ((zzamv) this.f11177a.get(0)).getAsDouble();
        }
        throw new IllegalStateException();
    }

    public int getAsInt() {
        if (this.f11177a.size() == 1) {
            return ((zzamv) this.f11177a.get(0)).getAsInt();
        }
        throw new IllegalStateException();
    }

    public long getAsLong() {
        if (this.f11177a.size() == 1) {
            return ((zzamv) this.f11177a.get(0)).getAsLong();
        }
        throw new IllegalStateException();
    }

    public int hashCode() {
        return this.f11177a.hashCode();
    }

    public Iterator<zzamv> iterator() {
        return this.f11177a.iterator();
    }

    public void zzc(zzamv com_google_android_gms_internal_zzamv) {
        Object obj;
        if (com_google_android_gms_internal_zzamv == null) {
            obj = zzamx.bei;
        }
        this.f11177a.add(obj);
    }

    public Number zzcze() {
        if (this.f11177a.size() == 1) {
            return ((zzamv) this.f11177a.get(0)).zzcze();
        }
        throw new IllegalStateException();
    }

    public String zzczf() {
        if (this.f11177a.size() == 1) {
            return ((zzamv) this.f11177a.get(0)).zzczf();
        }
        throw new IllegalStateException();
    }
}
