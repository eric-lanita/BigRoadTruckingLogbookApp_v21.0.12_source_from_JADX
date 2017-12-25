package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public final class Iterators {

    private enum EmptyModifiableIterator implements Iterator<Object> {
        INSTANCE;

        public boolean hasNext() {
            return false;
        }

        public Object next() {
            throw new NoSuchElementException();
        }

        public void remove() {
            C3587d.m18769a(false);
        }
    }

    private static final class C3559a<T> extends C3547a<T> {
        static final ac<Object> f13008a = new C3559a(new Object[0], 0, 0, 0);
        private final T[] f13009b;
        private final int f13010c;

        C3559a(T[] tArr, int i, int i2, int i3) {
            super(i2, i3);
            this.f13009b = tArr;
            this.f13010c = i;
        }

        protected T mo2682a(int i) {
            return this.f13009b[this.f13010c + i];
        }
    }

    private static class C3562b<T> extends C3560r<Iterator<? extends T>, T> {
        public C3562b(Iterator<? extends Iterator<? extends T>> it) {
            super(C3562b.m18609c(it));
        }

        Iterator<? extends T> m18611a(Iterator<? extends T> it) {
            return it;
        }

        private static <T> Iterator<Iterator<? extends T>> m18609c(Iterator<? extends Iterator<? extends T>> it) {
            return new C3560r<Iterator<? extends T>, Iterator<? extends T>>(it) {
                Iterator<? extends Iterator<? extends T>> m18607a(Iterator<? extends T> it) {
                    if (it instanceof C3562b) {
                        C3562b c3562b = (C3562b) it;
                        if (!c3562b.b.hasNext()) {
                            return C3562b.m18609c(c3562b.a);
                        }
                    }
                    return Iterators.m18614a((Object) it);
                }
            };
        }
    }

    static <T> ab<T> m18613a() {
        return m18623b();
    }

    static <T> ac<T> m18623b() {
        return C3559a.f13008a;
    }

    static <T> Iterator<T> m18627c() {
        return EmptyModifiableIterator.INSTANCE;
    }

    public static <T> ab<T> m18615a(final Iterator<? extends T> it) {
        Preconditions.checkNotNull(it);
        if (it instanceof ab) {
            return (ab) it;
        }
        return new ab<T>() {
            public boolean hasNext() {
                return it.hasNext();
            }

            public T next() {
                return it.next();
            }
        };
    }

    @CanIgnoreReturnValue
    public static boolean m18621a(Iterator<?> it, Collection<?> collection) {
        Preconditions.checkNotNull(collection);
        boolean z = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public static boolean m18622a(Iterator<?> it, Iterator<?> it2) {
        while (it.hasNext()) {
            if (!it2.hasNext()) {
                return false;
            }
            if (!Objects.equal(it.next(), it2.next())) {
                return false;
            }
        }
        if (it2.hasNext()) {
            return false;
        }
        return true;
    }

    public static String m18624b(Iterator<?> it) {
        StringBuilder append = new StringBuilder().append('[');
        Object obj = 1;
        while (it.hasNext()) {
            if (obj == null) {
                append.append(", ");
            }
            obj = null;
            append.append(it.next());
        }
        return append.append(']').toString();
    }

    @CanIgnoreReturnValue
    public static <T> boolean m18620a(Collection<T> collection, Iterator<? extends T> it) {
        Preconditions.checkNotNull(collection);
        Preconditions.checkNotNull(it);
        boolean z = false;
        while (it.hasNext()) {
            z |= collection.add(it.next());
        }
        return z;
    }

    public static <T> Iterator<T> m18628c(Iterator<? extends Iterator<? extends T>> it) {
        return new C3562b(it);
    }

    public static <T> ab<T> m18616a(final Iterator<T> it, final Predicate<? super T> predicate) {
        Preconditions.checkNotNull(it);
        Preconditions.checkNotNull(predicate);
        return new AbstractIterator<T>() {
            protected T mo2702a() {
                while (it.hasNext()) {
                    T next = it.next();
                    if (predicate.apply(next)) {
                        return next;
                    }
                }
                return m18317b();
            }
        };
    }

    public static <T> boolean m18625b(Iterator<T> it, Predicate<? super T> predicate) {
        return m18629d(it, predicate) != -1;
    }

    public static <T> Optional<T> m18626c(Iterator<T> it, Predicate<? super T> predicate) {
        ab a = m18616a((Iterator) it, (Predicate) predicate);
        return a.hasNext() ? Optional.of(a.next()) : Optional.absent();
    }

    public static <T> int m18629d(Iterator<T> it, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(predicate, "predicate");
        int i = 0;
        while (it.hasNext()) {
            if (predicate.apply(it.next())) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static <F, T> Iterator<T> m18619a(Iterator<F> it, final Function<? super F, ? extends T> function) {
        Preconditions.checkNotNull(function);
        return new C3556z<F, T>(it) {
            T mo2703a(F f) {
                return function.apply(f);
            }
        };
    }

    public static <T> T m18618a(Iterator<? extends T> it, T t) {
        return it.hasNext() ? it.next() : t;
    }

    @CanIgnoreReturnValue
    public static int m18612a(Iterator<?> it, int i) {
        boolean z;
        int i2 = 0;
        Preconditions.checkNotNull(it);
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "numberToAdvance must be nonnegative");
        while (i2 < i && it.hasNext()) {
            it.next();
            i2++;
        }
        return i2;
    }

    static <T> T m18630d(Iterator<T> it) {
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        it.remove();
        return next;
    }

    static void m18631e(Iterator<?> it) {
        Preconditions.checkNotNull(it);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    static <T> ac<T> m18617a(T[] tArr, int i, int i2, int i3) {
        Preconditions.checkArgument(i2 >= 0);
        Preconditions.checkPositionIndexes(i, i + i2, tArr.length);
        Preconditions.checkPositionIndex(i3, i2);
        if (i2 == 0) {
            return m18623b();
        }
        return new C3559a(tArr, i, i2, i3);
    }

    public static <T> ab<T> m18614a(final T t) {
        return new ab<T>() {
            boolean f13004a;

            public boolean hasNext() {
                return !this.f13004a;
            }

            public T next() {
                if (this.f13004a) {
                    throw new NoSuchElementException();
                }
                this.f13004a = true;
                return t;
            }
        };
    }

    static <T> ListIterator<T> m18632f(Iterator<T> it) {
        return (ListIterator) it;
    }
}
