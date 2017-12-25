package com.google.android.gms.common.data;

import android.os.Bundle;
import java.util.Iterator;

public abstract class AbstractDataBuffer<T> implements DataBuffer<T> {
    protected final DataHolder f10576a;

    protected AbstractDataBuffer(DataHolder dataHolder) {
        this.f10576a = dataHolder;
        if (this.f10576a == null) {
        }
    }

    @Deprecated
    public final void close() {
        release();
    }

    public abstract T get(int i);

    public int getCount() {
        return this.f10576a == null ? 0 : this.f10576a.getCount();
    }

    @Deprecated
    public boolean isClosed() {
        return this.f10576a == null || this.f10576a.isClosed();
    }

    public Iterator<T> iterator() {
        return new zzb(this);
    }

    public void release() {
        if (this.f10576a != null) {
            this.f10576a.close();
        }
    }

    public Iterator<T> singleRefIterator() {
        return new zzg(this);
    }

    public Bundle zzarc() {
        return this.f10576a.zzarc();
    }
}
