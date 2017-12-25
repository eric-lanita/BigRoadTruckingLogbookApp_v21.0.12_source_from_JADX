package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class Multimaps {

    private static class CustomSetMultimap<K, V> extends AbstractSetMultimap<K, V> {
        private static final long serialVersionUID = 0;
        transient Supplier<? extends Set<V>> f13029a;

        protected /* synthetic */ Collection mo2629c() {
            return mo2707a();
        }

        CustomSetMultimap(Map<K, Collection<V>> map, Supplier<? extends Set<V>> supplier) {
            super(map);
            this.f13029a = (Supplier) Preconditions.checkNotNull(supplier);
        }

        protected Set<V> mo2707a() {
            return (Set) this.f13029a.get();
        }

        private void writeObject(ObjectOutputStream objectOutputStream) {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.f13029a);
            objectOutputStream.writeObject(m18361d());
        }

        private void readObject(ObjectInputStream objectInputStream) {
            objectInputStream.defaultReadObject();
            this.f13029a = (Supplier) objectInputStream.readObject();
            m18356a((Map) objectInputStream.readObject());
        }
    }

    static abstract class C3577a<K, V> extends AbstractCollection<Entry<K, V>> {
        abstract C3510p<K, V> mo2734a();

        C3577a() {
        }

        public int size() {
            return mo2734a().mo2622e();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            return mo2734a().mo2616b(entry.getKey(), entry.getValue());
        }

        public boolean remove(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            return mo2734a().mo2617c(entry.getKey(), entry.getValue());
        }

        public void clear() {
            mo2734a().mo2623f();
        }
    }

    public static <K, V> C3537w<K, V> m18678a(Map<K, Collection<V>> map, Supplier<? extends Set<V>> supplier) {
        return new CustomSetMultimap(map, supplier);
    }

    static boolean m18679a(C3510p<?, ?> c3510p, Object obj) {
        if (obj == c3510p) {
            return true;
        }
        if (!(obj instanceof C3510p)) {
            return false;
        }
        return c3510p.mo2615b().equals(((C3510p) obj).mo2615b());
    }
}
