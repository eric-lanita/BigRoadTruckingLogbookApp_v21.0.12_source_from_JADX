package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzab;

public abstract class zzc {
    protected final DataHolder f10603a;
    protected int f10604b;
    private int f10605c;

    public zzc(DataHolder dataHolder, int i) {
        this.f10603a = (DataHolder) zzab.zzy(dataHolder);
        m16823a(i);
    }

    protected void m16823a(int i) {
        boolean z = i >= 0 && i < this.f10603a.getCount();
        zzab.zzbn(z);
        this.f10604b = i;
        this.f10605c = this.f10603a.zzfs(this.f10604b);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzc)) {
            return false;
        }
        zzc com_google_android_gms_common_data_zzc = (zzc) obj;
        return zzaa.equal(Integer.valueOf(com_google_android_gms_common_data_zzc.f10604b), Integer.valueOf(this.f10604b)) && zzaa.equal(Integer.valueOf(com_google_android_gms_common_data_zzc.f10605c), Integer.valueOf(this.f10605c)) && com_google_android_gms_common_data_zzc.f10603a == this.f10603a;
    }

    public int hashCode() {
        return zzaa.hashCode(Integer.valueOf(this.f10604b), Integer.valueOf(this.f10605c), this.f10603a);
    }

    public boolean isDataValid() {
        return !this.f10603a.isClosed();
    }

    public boolean zzhe(String str) {
        return this.f10603a.zzhe(str);
    }
}
