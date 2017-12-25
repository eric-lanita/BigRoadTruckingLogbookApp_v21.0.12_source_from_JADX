package com.bigroad.shared.p021a;

import com.google.common.base.Function;
import com.google.common.collect.C3540t;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class C0831a {
    public static final C3540t<Comparable<?>> f2607a = C3540t.m18450c().mo2709b();
    public static final Function<C0830a, Long> f2608b = new C08271();

    static class C08271 implements Function<C0830a, Long> {
        C08271() {
        }

        public /* synthetic */ Object apply(Object obj) {
            return m4103a((C0830a) obj);
        }

        public Long m4103a(C0830a c0830a) {
            return Long.valueOf(c0830a.m4104a());
        }
    }

    public interface C0830a {
        long m4104a();
    }

    public static <T> Iterable<T> m4105a(final List<T> list) {
        return new Iterable<T>() {
            public Iterator<T> iterator() {
                final ListIterator listIterator = list.listIterator(list.size());
                return new Iterator<T>(this) {
                    final /* synthetic */ C08292 f2605b;

                    public boolean hasNext() {
                        return listIterator.hasPrevious();
                    }

                    public T next() {
                        return listIterator.previous();
                    }

                    public void remove() {
                        listIterator.remove();
                    }
                };
            }
        };
    }

    public static <T> boolean m4107a(Collection<T> collection, T t) {
        if (t == null) {
            return false;
        }
        collection.add(t);
        return true;
    }

    public static <T> void m4106a(List<T> list, T t, Comparator<T> comparator) {
        if (t != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (comparator.compare(it.next(), t) == 0) {
                    it.remove();
                }
            }
        }
    }
}
