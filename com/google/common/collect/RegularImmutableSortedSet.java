package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

final class RegularImmutableSortedSet<E> extends ImmutableSortedSet<E> {
    static final RegularImmutableSortedSet<Comparable> f13058c = new RegularImmutableSortedSet(ImmutableList.m18516d(), C3540t.m18450c());
    final transient ImmutableList<E> f13059d;

    public /* synthetic */ Iterator descendingIterator() {
        return mo2729i();
    }

    public /* synthetic */ Iterator iterator() {
        return mo2684a();
    }

    RegularImmutableSortedSet(ImmutableList<E> immutableList, Comparator<? super E> comparator) {
        super(comparator);
        this.f13059d = immutableList;
    }

    public ab<E> mo2684a() {
        return this.f13059d.mo2684a();
    }

    public ab<E> mo2729i() {
        return this.f13059d.mo2691f().mo2684a();
    }

    public int size() {
        return this.f13059d.size();
    }

    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return m18728d(obj) >= 0;
        } catch (ClassCastException e) {
            return false;
        }
    }

    public boolean containsAll(Collection<?> collection) {
        if (collection instanceof C3601q) {
            collection = ((C3601q) collection).m18815a();
        }
        if (!C3605y.m18825a(comparator(), collection) || collection.size() <= 1) {
            return super.containsAll(collection);
        }
        Iterator a = mo2684a();
        Iterator it = collection.iterator();
        if (!a.hasNext()) {
            return false;
        }
        Object next = it.next();
        Object next2 = a.next();
        while (true) {
            try {
                int a2 = m18587a(next2, next);
                if (a2 < 0) {
                    if (!a.hasNext()) {
                        return false;
                    }
                    next2 = a.next();
                } else if (a2 == 0) {
                    if (!it.hasNext()) {
                        return true;
                    }
                    next = it.next();
                } else if (a2 > 0) {
                    return false;
                }
            } catch (NullPointerException e) {
                return false;
            } catch (ClassCastException e2) {
                return false;
            }
        }
    }

    private int m18728d(Object obj) {
        return Collections.binarySearch(this.f13059d, obj, m18741j());
    }

    boolean mo2690c() {
        return this.f13059d.mo2690c();
    }

    int mo2683a(Object[] objArr, int i) {
        return this.f13059d.mo2683a(objArr, i);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (size() != set.size()) {
            return false;
        }
        if (isEmpty()) {
            return true;
        }
        if (!C3605y.m18825a(this.a, set)) {
            return containsAll(set);
        }
        Iterator it = set.iterator();
        try {
            Iterator a = mo2684a();
            while (a.hasNext()) {
                Object next = a.next();
                Object next2 = it.next();
                if (next2 != null) {
                    if (m18587a(next, next2) != 0) {
                    }
                }
                return false;
            }
            return true;
        } catch (ClassCastException e) {
            return false;
        } catch (NoSuchElementException e2) {
            return false;
        }
    }

    public E first() {
        if (!isEmpty()) {
            return this.f13059d.get(0);
        }
        throw new NoSuchElementException();
    }

    public E last() {
        if (!isEmpty()) {
            return this.f13059d.get(size() - 1);
        }
        throw new NoSuchElementException();
    }

    public E lower(E e) {
        int e2 = m18737e(e, false) - 1;
        return e2 == -1 ? null : this.f13059d.get(e2);
    }

    public E floor(E e) {
        int e2 = m18737e(e, true) - 1;
        return e2 == -1 ? null : this.f13059d.get(e2);
    }

    public E ceiling(E e) {
        int f = m18738f(e, true);
        return f == size() ? null : this.f13059d.get(f);
    }

    public E higher(E e) {
        int f = m18738f(e, false);
        return f == size() ? null : this.f13059d.get(f);
    }

    ImmutableSortedSet<E> mo2720c(E e, boolean z) {
        return m18730a(0, m18737e(e, z));
    }

    int m18737e(E e, boolean z) {
        int binarySearch = Collections.binarySearch(this.f13059d, Preconditions.checkNotNull(e), comparator());
        if (binarySearch < 0) {
            return binarySearch ^ -1;
        }
        if (z) {
            return binarySearch + 1;
        }
        return binarySearch;
    }

    ImmutableSortedSet<E> mo2719b(E e, boolean z, E e2, boolean z2) {
        return mo2722d(e, z).mo2720c(e2, z2);
    }

    ImmutableSortedSet<E> mo2722d(E e, boolean z) {
        return m18730a(m18738f(e, z), size());
    }

    int m18738f(E e, boolean z) {
        int binarySearch = Collections.binarySearch(this.f13059d, Preconditions.checkNotNull(e), comparator());
        if (binarySearch < 0) {
            return binarySearch ^ -1;
        }
        if (z) {
            return binarySearch;
        }
        return binarySearch + 1;
    }

    Comparator<Object> m18741j() {
        return this.a;
    }

    RegularImmutableSortedSet<E> m18730a(int i, int i2) {
        if (i == 0 && i2 == size()) {
            return this;
        }
        if (i < i2) {
            return new RegularImmutableSortedSet(this.f13059d.mo2689a(i, i2), this.a);
        }
        return ImmutableSortedSet.m18586a(this.a);
    }

    public ImmutableList<E> mo2685b() {
        return this.f13059d;
    }

    ImmutableSortedSet<E> mo2727h() {
        Comparator reverseOrder = Collections.reverseOrder(this.a);
        if (isEmpty()) {
            return ImmutableSortedSet.m18586a(reverseOrder);
        }
        return new RegularImmutableSortedSet(this.f13059d.mo2691f(), reverseOrder);
    }
}
