package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class C3560r<F, T> implements Iterator<T> {
    final Iterator<? extends F> f13011a;
    Iterator<? extends T> f13012b = Iterators.m18613a();
    private Iterator<? extends T> f13013c;

    abstract Iterator<? extends T> mo2704a(F f);

    C3560r(Iterator<? extends F> it) {
        this.f13011a = (Iterator) Preconditions.checkNotNull(it);
    }

    public boolean hasNext() {
        Preconditions.checkNotNull(this.f13012b);
        if (this.f13012b.hasNext()) {
            return true;
        }
        while (this.f13011a.hasNext()) {
            Iterator a = mo2704a(this.f13011a.next());
            this.f13012b = a;
            Preconditions.checkNotNull(a);
            if (this.f13012b.hasNext()) {
                return true;
            }
        }
        return false;
    }

    public T next() {
        if (hasNext()) {
            this.f13013c = this.f13012b;
            return this.f13012b.next();
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        C3587d.m18769a(this.f13013c != null);
        this.f13013c.remove();
        this.f13013c = null;
    }
}
