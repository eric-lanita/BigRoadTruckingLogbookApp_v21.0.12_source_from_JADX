package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

public final class Lists {

    private static class TransformingRandomAccessList<F, T> extends AbstractList<T> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;
        final List<F> fromList;
        final Function<? super F, ? extends T> function;

        TransformingRandomAccessList(List<F> list, Function<? super F, ? extends T> function) {
            this.fromList = (List) Preconditions.checkNotNull(list);
            this.function = (Function) Preconditions.checkNotNull(function);
        }

        public void clear() {
            this.fromList.clear();
        }

        public T get(int i) {
            return this.function.apply(this.fromList.get(i));
        }

        public Iterator<T> iterator() {
            return listIterator();
        }

        public ListIterator<T> listIterator(int i) {
            return new aa<F, T>(this, this.fromList.listIterator(i)) {
                final /* synthetic */ TransformingRandomAccessList f13014a;

                T mo2703a(F f) {
                    return this.f13014a.function.apply(f);
                }
            };
        }

        public boolean isEmpty() {
            return this.fromList.isEmpty();
        }

        public T remove(int i) {
            return this.function.apply(this.fromList.remove(i));
        }

        public int size() {
            return this.fromList.size();
        }
    }

    private static class TransformingSequentialList<F, T> extends AbstractSequentialList<T> implements Serializable {
        private static final long serialVersionUID = 0;
        final List<F> fromList;
        final Function<? super F, ? extends T> function;

        TransformingSequentialList(List<F> list, Function<? super F, ? extends T> function) {
            this.fromList = (List) Preconditions.checkNotNull(list);
            this.function = (Function) Preconditions.checkNotNull(function);
        }

        public void clear() {
            this.fromList.clear();
        }

        public int size() {
            return this.fromList.size();
        }

        public ListIterator<T> listIterator(int i) {
            return new aa<F, T>(this, this.fromList.listIterator(i)) {
                final /* synthetic */ TransformingSequentialList f13015a;

                T mo2703a(F f) {
                    return this.f13015a.function.apply(f);
                }
            };
        }
    }

    private static class C3565b<T> extends AbstractList<T> {
        private final List<T> f13016a;

        C3565b(List<T> list) {
            this.f13016a = (List) Preconditions.checkNotNull(list);
        }

        List<T> m18639a() {
            return this.f13016a;
        }

        private int m18636a(int i) {
            int size = size();
            Preconditions.checkElementIndex(i, size);
            return (size - 1) - i;
        }

        private int m18638b(int i) {
            int size = size();
            Preconditions.checkPositionIndex(i, size);
            return size - i;
        }

        public void add(int i, T t) {
            this.f13016a.add(m18638b(i), t);
        }

        public void clear() {
            this.f13016a.clear();
        }

        public T remove(int i) {
            return this.f13016a.remove(m18636a(i));
        }

        protected void removeRange(int i, int i2) {
            subList(i, i2).clear();
        }

        public T set(int i, T t) {
            return this.f13016a.set(m18636a(i), t);
        }

        public T get(int i) {
            return this.f13016a.get(m18636a(i));
        }

        public int size() {
            return this.f13016a.size();
        }

        public List<T> subList(int i, int i2) {
            Preconditions.checkPositionIndexes(i, i2, size());
            return Lists.m18640a(this.f13016a.subList(m18638b(i2), m18638b(i)));
        }

        public Iterator<T> iterator() {
            return listIterator();
        }

        public ListIterator<T> listIterator(int i) {
            final ListIterator listIterator = this.f13016a.listIterator(m18638b(i));
            return new ListIterator<T>(this) {
                boolean f13017a;
                final /* synthetic */ C3565b f13019c;

                public void add(T t) {
                    listIterator.add(t);
                    listIterator.previous();
                    this.f13017a = false;
                }

                public boolean hasNext() {
                    return listIterator.hasPrevious();
                }

                public boolean hasPrevious() {
                    return listIterator.hasNext();
                }

                public T next() {
                    if (hasNext()) {
                        this.f13017a = true;
                        return listIterator.previous();
                    }
                    throw new NoSuchElementException();
                }

                public int nextIndex() {
                    return this.f13019c.m18638b(listIterator.nextIndex());
                }

                public T previous() {
                    if (hasPrevious()) {
                        this.f13017a = true;
                        return listIterator.next();
                    }
                    throw new NoSuchElementException();
                }

                public int previousIndex() {
                    return nextIndex() - 1;
                }

                public void remove() {
                    C3587d.m18769a(this.f13017a);
                    listIterator.remove();
                    this.f13017a = false;
                }

                public void set(T t) {
                    Preconditions.checkState(this.f13017a);
                    listIterator.set(t);
                }
            };
        }
    }

    private static class C3566a<T> extends C3565b<T> implements RandomAccess {
        C3566a(List<T> list) {
            super(list);
        }
    }

    public static <F, T> List<T> m18641a(List<F> list, Function<? super F, ? extends T> function) {
        return list instanceof RandomAccess ? new TransformingRandomAccessList(list, function) : new TransformingSequentialList(list, function);
    }

    public static <T> List<T> m18640a(List<T> list) {
        if (list instanceof ImmutableList) {
            return ((ImmutableList) list).mo2691f();
        }
        if (list instanceof C3565b) {
            return ((C3565b) list).m18639a();
        }
        if (list instanceof RandomAccess) {
            return new C3566a(list);
        }
        return new C3565b(list);
    }

    static boolean m18642a(List<?> list, Object obj) {
        if (obj == Preconditions.checkNotNull(list)) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list2 = (List) obj;
        int size = list.size();
        if (size != list2.size()) {
            return false;
        }
        if (!(list instanceof RandomAccess) || !(list2 instanceof RandomAccess)) {
            return Iterators.m18622a(list.iterator(), list2.iterator());
        }
        for (int i = 0; i < size; i++) {
            if (!Objects.equal(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    static int m18643b(List<?> list, Object obj) {
        if (list instanceof RandomAccess) {
            return m18645d(list, obj);
        }
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (Objects.equal(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    private static int m18645d(List<?> list, Object obj) {
        int i = 0;
        int size = list.size();
        if (obj == null) {
            while (i < size) {
                if (list.get(i) == null) {
                    return i;
                }
                i++;
            }
        } else {
            while (i < size) {
                if (obj.equals(list.get(i))) {
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    static int m18644c(List<?> list, Object obj) {
        if (list instanceof RandomAccess) {
            return m18646e(list, obj);
        }
        ListIterator listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (Objects.equal(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    private static int m18646e(List<?> list, Object obj) {
        int size;
        if (obj == null) {
            for (size = list.size() - 1; size >= 0; size--) {
                if (list.get(size) == null) {
                    return size;
                }
            }
        } else {
            for (size = list.size() - 1; size >= 0; size--) {
                if (obj.equals(list.get(size))) {
                    return size;
                }
            }
        }
        return -1;
    }
}
