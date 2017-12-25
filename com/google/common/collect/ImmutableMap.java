package com.google.common.collect;

import com.google.common.collect.ImmutableCollection.C3544b;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;

public abstract class ImmutableMap<K, V> implements Serializable, Map<K, V> {
    static final Entry<?, ?>[] f12991a = new Entry[0];
    @LazyInit
    private transient ImmutableSet<Entry<K, V>> f12992b;
    @LazyInit
    private transient ImmutableSet<K> f12993c;
    @LazyInit
    private transient ImmutableCollection<V> f12994d;

    static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final Object[] keys;
        private final Object[] values;

        SerializedForm(ImmutableMap<?, ?> immutableMap) {
            this.keys = new Object[immutableMap.size()];
            this.values = new Object[immutableMap.size()];
            Iterator a = immutableMap.m18550a().mo2684a();
            int i = 0;
            while (a.hasNext()) {
                Entry entry = (Entry) a.next();
                this.keys[i] = entry.getKey();
                this.values[i] = entry.getValue();
                i++;
            }
        }

        Object readResolve() {
            return m18541a(new C3550a(this.keys.length));
        }

        Object m18541a(C3550a<Object, Object> c3550a) {
            for (int i = 0; i < this.keys.length; i++) {
                c3550a.m18544a(this.keys[i], this.values[i]);
            }
            return c3550a.m18546a();
        }
    }

    public static class C3550a<K, V> {
        Comparator<? super V> f12987a;
        Object[] f12988b;
        int f12989c;
        boolean f12990d;

        public C3550a() {
            this(4);
        }

        C3550a(int i) {
            this.f12988b = new Object[(i * 2)];
            this.f12989c = 0;
            this.f12990d = false;
        }

        private void m18542a(int i) {
            if (i * 2 > this.f12988b.length) {
                this.f12988b = Arrays.copyOf(this.f12988b, C3544b.m18493a(this.f12988b.length, i * 2));
                this.f12990d = false;
            }
        }

        @CanIgnoreReturnValue
        public C3550a<K, V> m18544a(K k, V v) {
            m18542a(this.f12989c + 1);
            C3587d.m18768a((Object) k, (Object) v);
            this.f12988b[this.f12989c * 2] = k;
            this.f12988b[(this.f12989c * 2) + 1] = v;
            this.f12989c++;
            return this;
        }

        @CanIgnoreReturnValue
        public C3550a<K, V> m18545a(Entry<? extends K, ? extends V> entry) {
            return m18544a(entry.getKey(), entry.getValue());
        }

        @CanIgnoreReturnValue
        public C3550a<K, V> m18543a(Iterable<? extends Entry<? extends K, ? extends V>> iterable) {
            if (iterable instanceof Collection) {
                m18542a(((Collection) iterable).size() + this.f12989c);
            }
            for (Entry a : iterable) {
                m18545a(a);
            }
            return this;
        }

        public ImmutableMap<K, V> m18546a() {
            m18547b();
            this.f12990d = true;
            return RegularImmutableMap.m18716a(this.f12989c, this.f12988b);
        }

        void m18547b() {
            int i = 0;
            if (this.f12987a != null) {
                if (this.f12990d) {
                    this.f12988b = Arrays.copyOf(this.f12988b, this.f12989c * 2);
                }
                Entry[] entryArr = new Entry[this.f12989c];
                for (int i2 = 0; i2 < this.f12989c; i2++) {
                    entryArr[i2] = new SimpleImmutableEntry(this.f12988b[i2 * 2], this.f12988b[(i2 * 2) + 1]);
                }
                Arrays.sort(entryArr, 0, this.f12989c, C3540t.m18449a(this.f12987a).m18452a(Maps.m18659b()));
                while (i < this.f12989c) {
                    this.f12988b[i * 2] = entryArr[i].getKey();
                    this.f12988b[(i * 2) + 1] = entryArr[i].getValue();
                    i++;
                }
            }
        }
    }

    abstract ImmutableSet<Entry<K, V>> mo2712b();

    abstract ImmutableSet<K> mo2713d();

    abstract ImmutableCollection<V> mo2714f();

    abstract boolean mo2715g();

    public abstract V get(Object obj);

    public /* synthetic */ Set entrySet() {
        return m18550a();
    }

    public /* synthetic */ Set keySet() {
        return m18552c();
    }

    public /* synthetic */ Collection values() {
        return m18554e();
    }

    public static <K, V> ImmutableMap<K, V> m18549a(Map<? extends K, ? extends V> map) {
        if ((map instanceof ImmutableMap) && !(map instanceof SortedMap)) {
            ImmutableMap<K, V> immutableMap = (ImmutableMap) map;
            if (!immutableMap.mo2715g()) {
                return immutableMap;
            }
        }
        return m18548a(map.entrySet());
    }

    public static <K, V> ImmutableMap<K, V> m18548a(Iterable<? extends Entry<? extends K, ? extends V>> iterable) {
        C3550a c3550a = new C3550a(iterable instanceof Collection ? ((Collection) iterable).size() : 4);
        c3550a.m18543a((Iterable) iterable);
        return c3550a.m18546a();
    }

    ImmutableMap() {
    }

    @CanIgnoreReturnValue
    @Deprecated
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    public boolean containsValue(Object obj) {
        return m18554e().contains(obj);
    }

    public ImmutableSet<Entry<K, V>> m18550a() {
        ImmutableSet<Entry<K, V>> immutableSet = this.f12992b;
        if (immutableSet != null) {
            return immutableSet;
        }
        immutableSet = mo2712b();
        this.f12992b = immutableSet;
        return immutableSet;
    }

    public ImmutableSet<K> m18552c() {
        ImmutableSet<K> immutableSet = this.f12993c;
        if (immutableSet != null) {
            return immutableSet;
        }
        immutableSet = mo2713d();
        this.f12993c = immutableSet;
        return immutableSet;
    }

    public ImmutableCollection<V> m18554e() {
        ImmutableCollection<V> immutableCollection = this.f12994d;
        if (immutableCollection != null) {
            return immutableCollection;
        }
        immutableCollection = mo2714f();
        this.f12994d = immutableCollection;
        return immutableCollection;
    }

    public boolean equals(Object obj) {
        return Maps.m18664d(this, obj);
    }

    public int hashCode() {
        return Sets.m18753a(m18550a());
    }

    public String toString() {
        return Maps.m18654a((Map) this);
    }

    Object writeReplace() {
        return new SerializedForm(this);
    }
}
