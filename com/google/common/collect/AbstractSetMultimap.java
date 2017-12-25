package com.google.common.collect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

abstract class AbstractSetMultimap<K, V> extends AbstractMapBasedMultimap<K, V> implements C3537w<K, V> {
    private static final long serialVersionUID = 7431625294878419160L;

    abstract Set<V> mo2707a();

    public /* synthetic */ Collection mo2621b(Object obj) {
        return mo2628a(obj);
    }

    /* synthetic */ Collection mo2629c() {
        return mo2707a();
    }

    public /* synthetic */ Collection mo2619j() {
        return m18433q();
    }

    protected AbstractSetMultimap(Map<K, Collection<V>> map) {
        super(map);
    }

    public Set<V> mo2628a(K k) {
        return (Set) super.mo2621b((Object) k);
    }

    public Set<Entry<K, V>> m18433q() {
        return (Set) super.mo2619j();
    }

    public Map<K, Collection<V>> mo2615b() {
        return super.mo2615b();
    }

    @CanIgnoreReturnValue
    public boolean mo2614a(K k, V v) {
        return super.mo2614a((Object) k, (Object) v);
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
