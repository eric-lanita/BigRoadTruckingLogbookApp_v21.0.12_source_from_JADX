package com.google.android.gms.common.data;

import java.util.NoSuchElementException;

public class zzg<T> extends zzb<T> {
    private T f10610c;

    public zzg(DataBuffer<T> dataBuffer) {
        super(dataBuffer);
    }

    public T next() {
        if (hasNext()) {
            this.b++;
            if (this.b == 0) {
                this.f10610c = this.a.get(0);
                if (!(this.f10610c instanceof zzc)) {
                    String valueOf = String.valueOf(this.f10610c.getClass());
                    throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 44).append("DataBuffer reference of type ").append(valueOf).append(" is not movable").toString());
                }
            }
            ((zzc) this.f10610c).m16823a(this.b);
            return this.f10610c;
        }
        throw new NoSuchElementException("Cannot advance the iterator beyond " + this.b);
    }
}
