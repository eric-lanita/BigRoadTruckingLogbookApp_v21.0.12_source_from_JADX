package com.google.common.collect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CompatibleWith;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

public interface C3510p<K, V> {
    @CanIgnoreReturnValue
    boolean mo2614a(K k, V v);

    Collection<V> mo2621b(K k);

    Map<K, Collection<V>> mo2615b();

    boolean mo2616b(@CompatibleWith("K") Object obj, @CompatibleWith("V") Object obj2);

    @CanIgnoreReturnValue
    boolean mo2617c(@CompatibleWith("K") Object obj, @CompatibleWith("V") Object obj2);

    int mo2622e();

    void mo2623f();

    Collection<V> mo2618h();

    Collection<Entry<K, V>> mo2619j();

    boolean mo2620m();
}
