package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

public final class Sets {

    static abstract class C3516a<E> extends AbstractSet<E> {
        C3516a() {
        }

        public boolean removeAll(Collection<?> collection) {
            return Sets.m18758a((Set) this, (Collection) collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return super.retainAll((Collection) Preconditions.checkNotNull(collection));
        }
    }

    static final class UnmodifiableNavigableSet<E> extends C3582l<E> implements Serializable, NavigableSet<E> {
        private static final long serialVersionUID = 0;
        private transient UnmodifiableNavigableSet<E> f13060a;
        private final NavigableSet<E> delegate;

        protected /* synthetic */ Set mo2732a() {
            return mo2733b();
        }

        protected /* synthetic */ Collection mo2669c() {
            return mo2733b();
        }

        protected /* synthetic */ Object mo2668d() {
            return mo2733b();
        }

        UnmodifiableNavigableSet(NavigableSet<E> navigableSet) {
            this.delegate = (NavigableSet) Preconditions.checkNotNull(navigableSet);
        }

        protected SortedSet<E> mo2733b() {
            return Collections.unmodifiableSortedSet(this.delegate);
        }

        public E lower(E e) {
            return this.delegate.lower(e);
        }

        public E floor(E e) {
            return this.delegate.floor(e);
        }

        public E ceiling(E e) {
            return this.delegate.ceiling(e);
        }

        public E higher(E e) {
            return this.delegate.higher(e);
        }

        public E pollFirst() {
            throw new UnsupportedOperationException();
        }

        public E pollLast() {
            throw new UnsupportedOperationException();
        }

        public NavigableSet<E> descendingSet() {
            NavigableSet<E> navigableSet = this.f13060a;
            if (navigableSet != null) {
                return navigableSet;
            }
            NavigableSet unmodifiableNavigableSet = new UnmodifiableNavigableSet(this.delegate.descendingSet());
            this.f13060a = unmodifiableNavigableSet;
            unmodifiableNavigableSet.f13060a = this;
            return unmodifiableNavigableSet;
        }

        public Iterator<E> descendingIterator() {
            return Iterators.m18615a(this.delegate.descendingIterator());
        }

        public NavigableSet<E> subSet(E e, boolean z, E e2, boolean z2) {
            return Sets.m18756a(this.delegate.subSet(e, z, e2, z2));
        }

        public NavigableSet<E> headSet(E e, boolean z) {
            return Sets.m18756a(this.delegate.headSet(e, z));
        }

        public NavigableSet<E> tailSet(E e, boolean z) {
            return Sets.m18756a(this.delegate.tailSet(e, z));
        }
    }

    public static <E> HashSet<E> m18754a() {
        return new HashSet();
    }

    public static <E> HashSet<E> m18755a(int i) {
        return new HashSet(Maps.m18658b(i));
    }

    public static <E> LinkedHashSet<E> m18760b(int i) {
        return new LinkedHashSet(Maps.m18658b(i));
    }

    static int m18753a(Set<?> set) {
        int i = 0;
        for (Object next : set) {
            int hashCode;
            if (next != null) {
                hashCode = next.hashCode();
            } else {
                hashCode = 0;
            }
            i = ((i + hashCode) ^ -1) ^ -1;
        }
        return i;
    }

    static boolean m18757a(Set<?> set, Object obj) {
        boolean z = true;
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            if (!(set.size() == set2.size() && set.containsAll(set2))) {
                z = false;
            }
            return z;
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }

    public static <E> NavigableSet<E> m18756a(NavigableSet<E> navigableSet) {
        return ((navigableSet instanceof ImmutableSortedSet) || (navigableSet instanceof UnmodifiableNavigableSet)) ? navigableSet : new UnmodifiableNavigableSet(navigableSet);
    }

    static boolean m18759a(Set<?> set, Iterator<?> it) {
        boolean z = false;
        while (it.hasNext()) {
            z |= set.remove(it.next());
        }
        return z;
    }

    static boolean m18758a(Set<?> set, Collection<?> collection) {
        Preconditions.checkNotNull(collection);
        if (collection instanceof C3601q) {
            Collection a = ((C3601q) collection).m18815a();
        }
        if (!(a instanceof Set) || a.size() <= set.size()) {
            return m18759a((Set) set, a.iterator());
        }
        return Iterators.m18621a(set.iterator(), a);
    }
}
