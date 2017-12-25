package com.google.android.gms.internal;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public abstract class zzpt implements Releasable, Result {
    protected final Status f11497a;
    protected final DataHolder f11498b;

    public Status getStatus() {
        return this.f11497a;
    }

    public void release() {
        if (this.f11498b != null) {
            this.f11498b.close();
        }
    }
}
