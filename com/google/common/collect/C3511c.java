package com.google.common.collect;

import com.google.common.collect.Maps.C3523b;
import com.google.common.collect.Multimaps.C3577a;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

abstract class C3511c<K, V> implements C3510p<K, V> {
    private transient Collection<Entry<K, V>> f12925a;
    private transient Set<K> f12926b;
    private transient Collection<V> f12927c;
    private transient Map<K, Collection<V>> f12928d;

    private class C3584a extends C3577a<K, V> {
        final /* synthetic */ C3511c f13063a;

        private C3584a(C3511c c3511c) {
            this.f13063a = c3511c;
        }

        C3510p<K, V> mo2734a() {
            return this.f13063a;
        }

        public Iterator<Entry<K, V>> iterator() {
            return this.f13063a.mo2626k();
        }
    }

    private class C3585b extends C3584a implements Set<Entry<K, V>> {
        final /* synthetic */ C3511c f13064b;

        private C3585b(C3511c c3511c) {
            this.f13064b = c3511c;
            super();
        }

        public int hashCode() {
            return Sets.m18753a((Set) this);
        }

        public boolean equals(Object obj) {
            return Sets.m18757a((Set) this, obj);
        }
    }

    class C3586c extends AbstractCollection<V> {
        final /* synthetic */ C3511c f13065a;

        C3586c(C3511c c3511c) {
            this.f13065a = c3511c;
        }

        public Iterator<V> iterator() {
            return this.f13065a.mo2625i();
        }

        public int size() {
            return this.f13065a.mo2622e();
        }

        public boolean contains(Object obj) {
            return this.f13065a.mo2656d(obj);
        }

        public void clear() {
            this.f13065a.mo2623f();
        }
    }

    abstract Iterator<Entry<K, V>> mo2626k();

    abstract Map<K, Collection<V>> mo2627l();

    C3511c() {
    }

    public boolean mo2620m() {
        return mo2622e() == 0;
    }

    public boolean mo2656d(Object obj) {
        for (Collection contains : mo2615b().values()) {
            if (contains.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public boolean mo2616b(Object obj, Object obj2) {
        Collection collection = (Collection) mo2615b().get(obj);
        return collection != null && collection.contains(obj2);
    }

    @CanIgnoreReturnValue
    public boolean mo2617c(Object obj, Object obj2) {
        Collection collection = (Collection) mo2615b().get(obj);
        return collection != null && collection.remove(obj2);
    }

    @CanIgnoreReturnValue
    public boolean mo2614a(K k, V v) {
        return mo2621b(k).add(v);
    }

    public Collection<Entry<K, V>> mo2619j() {
        Collection<Entry<K, V>> collection = this.f12925a;
        if (collection != null) {
            return collection;
        }
        collection = m18340n();
        this.f12925a = collection;
        return collection;
    }

    Collection<Entry<K, V>> m18340n() {
        if (this instanceof C3537w) {
            return new C3585b();
        }
        return new C3584a();
    }

    public Set<K> mo2658o() {
        Set<K> set = this.f12926b;
        if (set != null) {
            return set;
        }
        set = mo2624g();
        this.f12926b = set;
        return set;
    }

    Set<K> mo2624g() {
        return new C3523b(mo2615b());
    }

    public Collection<V> mo2618h() {
        Collection<V> collection = this.f12927c;
        if (collection != null) {
            return collection;
        }
        collection = m18342p();
        this.f12927c = collection;
        return collection;
    }

    Collection<V> m18342p() {
        return new C3586c(this);
    }

    Iterator<V> mo2625i() {
        return Maps.m18660b(mo2619j().iterator());
    }

    public Map<K, Collection<V>> mo2615b() {
        Map<K, Collection<V>> map = this.f12928d;
        if (map != null) {
            return map;
        }
        map = mo2627l();
        this.f12928d = map;
        return map;
    }

    public boolean equals(Object obj) {
        return Multimaps.m18679a((C3510p) this, obj);
    }

    public int hashCode() {
        return mo2615b().hashCode();
    }

    public String toString() {
        return mo2615b().toString();
    }
}
