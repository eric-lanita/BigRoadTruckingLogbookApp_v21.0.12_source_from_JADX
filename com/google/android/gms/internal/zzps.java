package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.zzqn.zzb;

public abstract class zzps<L> implements zzb<L> {
    private final DataHolder f11496a;

    protected abstract void m17401a(L l, DataHolder dataHolder);

    public void zzapj() {
        if (this.f11496a != null) {
            this.f11496a.close();
        }
    }

    public final void zzt(L l) {
        m17401a(l, this.f11496a);
    }
}
