package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class C3600n {

    static class C35951 implements Function<Iterable<? extends T>, Iterator<? extends T>> {
        C35951() {
        }

        public /* synthetic */ Object apply(Object obj) {
            return m18805a((Iterable) obj);
        }

        public Iterator<? extends T> m18805a(Iterable<? extends T> iterable) {
            return iterable.iterator();
        }
    }

    public static String m18811a(Iterable<?> iterable) {
        return Iterators.m18624b(iterable.iterator());
    }

    @CanIgnoreReturnValue
    public static <T> boolean m18813a(Collection<T> collection, Iterable<? extends T> iterable) {
        if (iterable instanceof Collection) {
            return collection.addAll(C3588e.m18771a((Iterable) iterable));
        }
        return Iterators.m18620a((Collection) collection, ((Iterable) Preconditions.checkNotNull(iterable)).iterator());
    }

    public static <T> Iterable<T> m18809a(Iterable<? extends T> iterable, Iterable<? extends T> iterable2, Iterable<? extends T> iterable3) {
        return C3592g.m18801a(iterable, iterable2, iterable3);
    }

    public static <T> boolean m18812a(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.m18625b(iterable.iterator(), predicate);
    }

    public static <T> Optional<T> m18814b(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.m18626c(iterable.iterator(), predicate);
    }

    public static <F, T> Iterable<T> m18808a(final Iterable<F> iterable, final Function<? super F, ? extends T> function) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkNotNull(function);
        return new C3592g<T>() {
            public Iterator<T> iterator() {
                return Iterators.m18619a(iterable.iterator(), function);
            }
        };
    }

    public static <T> T m18810a(Iterable<? extends T> iterable, T t) {
        return Iterators.m18618a(iterable.iterator(), (Object) t);
    }

    public static <T> Iterable<T> m18807a(final Iterable<T> iterable, final int i) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkArgument(i >= 0, "number to skip cannot be negative");
        if (!(iterable instanceof List)) {
            return new C3592g<T>() {
                public Iterator<T> iterator() {
                    final Iterator it = iterable.iterator();
                    Iterators.m18612a(it, i);
                    return new Iterator<T>(this) {
                        boolean f13076a = true;
                        final /* synthetic */ C35994 f13078c;

                        public boolean hasNext() {
                            return it.hasNext();
                        }

                        public T next() {
                            T next = it.next();
                            this.f13076a = false;
                            return next;
                        }

                        public void remove() {
                            C3587d.m18769a(!this.f13076a);
                            it.remove();
                        }
                    };
                }
            };
        }
        final List list = (List) iterable;
        return new C3592g<T>() {
            public Iterator<T> iterator() {
                return list.subList(Math.min(list.size(), i), list.size()).iterator();
            }
        };
    }

    static <T> Function<Iterable<? extends T>, Iterator<? extends T>> m18806a() {
        return new C35951();
    }
}
