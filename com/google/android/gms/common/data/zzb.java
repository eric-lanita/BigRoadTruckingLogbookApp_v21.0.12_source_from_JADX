package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.zzab;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class zzb<T> implements Iterator<T> {
    protected final DataBuffer<T> f10601a;
    protected int f10602b = -1;

    public zzb(DataBuffer<T> dataBuffer) {
        this.f10601a = (DataBuffer) zzab.zzy(dataBuffer);
    }

    public boolean hasNext() {
        return this.f10602b < this.f10601a.getCount() + -1;
    }

    public T next() {
        if (hasNext()) {
            DataBuffer dataBuffer = this.f10601a;
            int i = this.f10602b + 1;
            this.f10602b = i;
            return dataBuffer.get(i);
        }
        throw new NoSuchElementException("Cannot advance the iterator beyond " + this.f10602b);
    }

    public void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
