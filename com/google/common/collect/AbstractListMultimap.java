package com.google.common.collect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.List;
import java.util.Map;

abstract class AbstractListMultimap<K, V> extends AbstractMapBasedMultimap<K, V> implements C3512o<K, V> {
    private static final long serialVersionUID = 6588350623831699109L;

    abstract List<V> mo2655a();

    public /* synthetic */ Collection mo2621b(Object obj) {
        return mo2628a(obj);
    }

    /* synthetic */ Collection mo2629c() {
        return mo2655a();
    }

    protected AbstractListMultimap(Map<K, Collection<V>> map) {
        super(map);
    }

    public List<V> mo2628a(K k) {
        return (List) super.mo2621b((Object) k);
    }

    @CanIgnoreReturnValue
    public boolean mo2614a(K k, V v) {
        return super.mo2614a((Object) k, (Object) v);
    }

    public Map<K, Collection<V>> mo2615b() {
        return super.mo2615b();
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
