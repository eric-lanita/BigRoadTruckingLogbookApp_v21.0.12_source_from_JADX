package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Sets.C3516a;
import com.google.j2objc.annotations.Weak;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class Maps {

    static abstract class C3517a<K, V> extends C3516a<Entry<K, V>> {
        abstract Map<K, V> mo2634a();

        C3517a() {
        }

        public int size() {
            return mo2634a().size();
        }

        public void clear() {
            mo2634a().clear();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            Object key = entry.getKey();
            Object a = Maps.m18653a(mo2634a(), key);
            if (!Objects.equal(a, entry.getValue())) {
                return false;
            }
            if (a != null || mo2634a().containsKey(key)) {
                return true;
            }
            return false;
        }

        public boolean isEmpty() {
            return mo2634a().isEmpty();
        }

        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            return mo2634a().keySet().remove(((Entry) obj).getKey());
        }

        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) Preconditions.checkNotNull(collection));
            } catch (UnsupportedOperationException e) {
                return Sets.m18759a((Set) this, collection.iterator());
            }
        }

        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) Preconditions.checkNotNull(collection));
            } catch (UnsupportedOperationException e) {
                Collection a = Sets.m18755a(collection.size());
                for (Object next : collection) {
                    if (contains(next)) {
                        a.add(((Entry) next).getKey());
                    }
                }
                return mo2634a().keySet().retainAll(a);
            }
        }
    }

    static abstract class C3520d<K, V> extends AbstractMap<K, V> {
        private transient Set<Entry<K, V>> f12942a;
        private transient Set<K> f12943b;
        private transient Collection<V> f12944c;

        abstract Set<Entry<K, V>> mo2637a();

        C3520d() {
        }

        public Set<Entry<K, V>> entrySet() {
            Set<Entry<K, V>> set = this.f12942a;
            if (set != null) {
                return set;
            }
            set = mo2637a();
            this.f12942a = set;
            return set;
        }

        public Set<K> keySet() {
            Set<K> set = this.f12943b;
            if (set != null) {
                return set;
            }
            set = mo2642h();
            this.f12943b = set;
            return set;
        }

        Set<K> mo2642h() {
            return new C3523b(this);
        }

        public Collection<V> values() {
            Collection<V> collection = this.f12944c;
            if (collection != null) {
                return collection;
            }
            collection = m18385i();
            this.f12944c = collection;
            return collection;
        }

        Collection<V> m18385i() {
            return new C3571c(this);
        }
    }

    static class C3523b<K, V> extends C3516a<K> {
        @Weak
        final Map<K, V> f12950d;

        C3523b(Map<K, V> map) {
            this.f12950d = (Map) Preconditions.checkNotNull(map);
        }

        Map<K, V> m18390c() {
            return this.f12950d;
        }

        public Iterator<K> iterator() {
            return Maps.m18656a(m18390c().entrySet().iterator());
        }

        public int size() {
            return m18390c().size();
        }

        public boolean isEmpty() {
            return m18390c().isEmpty();
        }

        public boolean contains(Object obj) {
            return m18390c().containsKey(obj);
        }

        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            m18390c().remove(obj);
            return true;
        }

        public void clear() {
            m18390c().clear();
        }
    }

    static class C35681 extends C3556z<K, Entry<K, V>> {
        final /* synthetic */ Function f13020a;

        /* synthetic */ Object mo2703a(Object obj) {
            return m18648b(obj);
        }

        Entry<K, V> m18648b(K k) {
            return Maps.m18657a((Object) k, this.f13020a.apply(k));
        }
    }

    private enum EntryFunction implements Function<Entry<?, ?>, Object> {
        KEY {
            public /* synthetic */ Object apply(Object obj) {
                return m18649a((Entry) obj);
            }

            public Object m18649a(Entry<?, ?> entry) {
                return entry.getKey();
            }
        },
        VALUE {
            public /* synthetic */ Object apply(Object obj) {
                return m18650a((Entry) obj);
            }

            public Object m18650a(Entry<?, ?> entry) {
                return entry.getValue();
            }
        }
    }

    static class C3571c<K, V> extends AbstractCollection<V> {
        @Weak
        final Map<K, V> f13024a;

        C3571c(Map<K, V> map) {
            this.f13024a = (Map) Preconditions.checkNotNull(map);
        }

        final Map<K, V> m18651a() {
            return this.f13024a;
        }

        public Iterator<V> iterator() {
            return Maps.m18660b(m18651a().entrySet().iterator());
        }

        public boolean remove(Object obj) {
            try {
                return super.remove(obj);
            } catch (UnsupportedOperationException e) {
                for (Entry entry : m18651a().entrySet()) {
                    if (Objects.equal(obj, entry.getValue())) {
                        m18651a().remove(entry.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) Preconditions.checkNotNull(collection));
            } catch (UnsupportedOperationException e) {
                Collection a = Sets.m18754a();
                for (Entry entry : m18651a().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        a.add(entry.getKey());
                    }
                }
                return m18651a().keySet().removeAll(a);
            }
        }

        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) Preconditions.checkNotNull(collection));
            } catch (UnsupportedOperationException e) {
                Collection a = Sets.m18754a();
                for (Entry entry : m18651a().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        a.add(entry.getKey());
                    }
                }
                return m18651a().keySet().retainAll(a);
            }
        }

        public int size() {
            return m18651a().size();
        }

        public boolean isEmpty() {
            return m18651a().isEmpty();
        }

        public boolean contains(Object obj) {
            return m18651a().containsValue(obj);
        }

        public void clear() {
            m18651a().clear();
        }
    }

    static <K> Function<Entry<K, ?>, K> m18652a() {
        return EntryFunction.KEY;
    }

    static <V> Function<Entry<?, V>, V> m18659b() {
        return EntryFunction.VALUE;
    }

    static <K, V> Iterator<K> m18656a(Iterator<Entry<K, V>> it) {
        return Iterators.m18619a((Iterator) it, m18652a());
    }

    static <K, V> Iterator<V> m18660b(Iterator<Entry<K, V>> it) {
        return Iterators.m18619a((Iterator) it, m18659b());
    }

    public static <K, V> HashMap<K, V> m18663c() {
        return new HashMap();
    }

    public static <K, V> HashMap<K, V> m18655a(int i) {
        return new HashMap(m18658b(i));
    }

    static int m18658b(int i) {
        if (i < 3) {
            C3587d.m18767a(i, "expectedSize");
            return i + 1;
        } else if (i < 1073741824) {
            return (int) ((((float) i) / 0.75f) + 1.0f);
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public static <K, V> Entry<K, V> m18657a(K k, V v) {
        return new ImmutableEntry(k, v);
    }

    static <V> V m18653a(Map<?, V> map, Object obj) {
        V v = null;
        Preconditions.checkNotNull(map);
        try {
            v = map.get(obj);
        } catch (ClassCastException e) {
        } catch (NullPointerException e2) {
        }
        return v;
    }

    static boolean m18661b(Map<?, ?> map, Object obj) {
        boolean z = false;
        Preconditions.checkNotNull(map);
        try {
            z = map.containsKey(obj);
        } catch (ClassCastException e) {
        } catch (NullPointerException e2) {
        }
        return z;
    }

    static <V> V m18662c(Map<?, V> map, Object obj) {
        V v = null;
        Preconditions.checkNotNull(map);
        try {
            v = map.remove(obj);
        } catch (ClassCastException e) {
        } catch (NullPointerException e2) {
        }
        return v;
    }

    static boolean m18664d(Map<?, ?> map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        return map.entrySet().equals(((Map) obj).entrySet());
    }

    static String m18654a(Map<?, ?> map) {
        StringBuilder append = C3588e.m18770a(map.size()).append('{');
        Object obj = 1;
        for (Entry entry : map.entrySet()) {
            if (obj == null) {
                append.append(", ");
            }
            obj = null;
            append.append(entry.getKey()).append('=').append(entry.getValue());
        }
        return append.append('}').toString();
    }
}
