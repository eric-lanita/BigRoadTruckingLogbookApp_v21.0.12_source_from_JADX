package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public abstract class MultimapBuilder<K0, V0> {

    public static abstract class C3572a<K0> {
        abstract <K extends K0, V> Map<K, Collection<V>> mo2705a();

        C3572a() {
        }

        public C3575b<K0, Object> m18667b() {
            return m18665a(2);
        }

        public C3575b<K0, Object> m18665a(final int i) {
            C3587d.m18767a(i, "expectedValuesPerKey");
            return new C3575b<K0, Object>(this) {
                final /* synthetic */ C3572a f13028b;

                public <K extends K0, V> C3537w<K, V> mo2706b() {
                    return Multimaps.m18678a(this.f13028b.mo2705a(), new LinkedHashSetSupplier(i));
                }
            };
        }
    }

    static class C35731 extends C3572a<Object> {
        final /* synthetic */ int f13025a;

        <K, V> Map<K, Collection<V>> mo2705a() {
            return Maps.m18655a(this.f13025a);
        }
    }

    private static final class LinkedHashSetSupplier<V> implements Supplier<Set<V>>, Serializable {
        private final int expectedValuesPerKey;

        public /* synthetic */ Object get() {
            return m18670a();
        }

        LinkedHashSetSupplier(int i) {
            this.expectedValuesPerKey = C3587d.m18767a(i, "expectedValuesPerKey");
        }

        public Set<V> m18670a() {
            return Sets.m18760b(this.expectedValuesPerKey);
        }
    }

    public static abstract class C3575b<K0, V0> extends MultimapBuilder<K0, V0> {
        public abstract <K extends K0, V extends V0> C3537w<K, V> mo2706b();

        C3575b() {
            super();
        }
    }

    private MultimapBuilder() {
    }

    public static C3572a<Comparable> m18671a() {
        return m18672a(C3540t.m18450c());
    }

    public static <K0> C3572a<K0> m18672a(final Comparator<K0> comparator) {
        Preconditions.checkNotNull(comparator);
        return new C3572a<K0>() {
            <K extends K0, V> Map<K, Collection<V>> mo2705a() {
                return new TreeMap(comparator);
            }
        };
    }
}
