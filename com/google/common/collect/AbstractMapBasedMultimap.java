package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMapBasedMultimap$i.a;
import com.google.common.collect.Maps.C3517a;
import com.google.common.collect.Maps.C3520d;
import com.google.common.collect.Maps.C3523b;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

abstract class AbstractMapBasedMultimap<K, V> extends C3511c<K, V> implements Serializable {
    private static final long serialVersionUID = 2447537837011683357L;
    private transient Map<K, Collection<V>> f12929a;
    private transient int f12930b;

    private abstract class C3513b<T> implements Iterator<T> {
        final Iterator<Entry<K, Collection<V>>> f12931b;
        K f12932c = null;
        Collection<V> f12933d = null;
        Iterator<V> f12934e = Iterators.m18627c();
        final /* synthetic */ AbstractMapBasedMultimap f12935f;

        abstract T mo2631a(K k, V v);

        C3513b(AbstractMapBasedMultimap abstractMapBasedMultimap) {
            this.f12935f = abstractMapBasedMultimap;
            this.f12931b = abstractMapBasedMultimap.f12929a.entrySet().iterator();
        }

        public boolean hasNext() {
            return this.f12931b.hasNext() || this.f12934e.hasNext();
        }

        public T next() {
            if (!this.f12934e.hasNext()) {
                Entry entry = (Entry) this.f12931b.next();
                this.f12932c = entry.getKey();
                this.f12933d = (Collection) entry.getValue();
                this.f12934e = this.f12933d.iterator();
            }
            return mo2631a(this.f12932c, this.f12934e.next());
        }

        public void remove() {
            this.f12934e.remove();
            if (this.f12933d.isEmpty()) {
                this.f12931b.remove();
            }
            this.f12935f.f12930b = this.f12935f.f12930b - 1;
        }
    }

    class C35141 extends C3513b<V> {
        final /* synthetic */ AbstractMapBasedMultimap f12936a;

        C35141(AbstractMapBasedMultimap abstractMapBasedMultimap) {
            this.f12936a = abstractMapBasedMultimap;
            super(abstractMapBasedMultimap);
        }

        V mo2631a(K k, V v) {
            return v;
        }
    }

    class C35152 extends C3513b<Entry<K, V>> {
        final /* synthetic */ AbstractMapBasedMultimap f12937a;

        C35152(AbstractMapBasedMultimap abstractMapBasedMultimap) {
            this.f12937a = abstractMapBasedMultimap;
            super(abstractMapBasedMultimap);
        }

        /* synthetic */ Object mo2631a(Object obj, Object obj2) {
            return m18379b(obj, obj2);
        }

        Entry<K, V> m18379b(K k, V v) {
            return Maps.m18657a((Object) k, (Object) v);
        }
    }

    private class C3521a extends C3520d<K, Collection<V>> {
        final transient Map<K, Collection<V>> f12945a;
        final /* synthetic */ AbstractMapBasedMultimap f12946b;

        class C3518a extends C3517a<K, Collection<V>> {
            final /* synthetic */ C3521a f12938a;

            C3518a(C3521a c3521a) {
                this.f12938a = c3521a;
            }

            Map<K, Collection<V>> mo2634a() {
                return this.f12938a;
            }

            public Iterator<Entry<K, Collection<V>>> iterator() {
                return new C3519b(this.f12938a);
            }

            public boolean contains(Object obj) {
                return C3588e.m18772a(this.f12938a.f12945a.entrySet(), obj);
            }

            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                this.f12938a.f12946b.mo2628a(((Entry) obj).getKey());
                return true;
            }
        }

        class C3519b implements Iterator<Entry<K, Collection<V>>> {
            final Iterator<Entry<K, Collection<V>>> f12939a = this.f12941c.f12945a.entrySet().iterator();
            Collection<V> f12940b;
            final /* synthetic */ C3521a f12941c;

            C3519b(C3521a c3521a) {
                this.f12941c = c3521a;
            }

            public /* synthetic */ Object next() {
                return m18382a();
            }

            public boolean hasNext() {
                return this.f12939a.hasNext();
            }

            public Entry<K, Collection<V>> m18382a() {
                Entry entry = (Entry) this.f12939a.next();
                this.f12940b = (Collection) entry.getValue();
                return this.f12941c.m18387a(entry);
            }

            public void remove() {
                this.f12939a.remove();
                this.f12941c.f12946b.f12930b = this.f12941c.f12946b.f12930b - this.f12940b.size();
                this.f12940b.clear();
            }
        }

        public /* synthetic */ Object get(Object obj) {
            return m18386a(obj);
        }

        public /* synthetic */ Object remove(Object obj) {
            return m18389b(obj);
        }

        C3521a(AbstractMapBasedMultimap abstractMapBasedMultimap, Map<K, Collection<V>> map) {
            this.f12946b = abstractMapBasedMultimap;
            this.f12945a = map;
        }

        protected Set<Entry<K, Collection<V>>> mo2637a() {
            return new C3518a(this);
        }

        public boolean containsKey(Object obj) {
            return Maps.m18661b(this.f12945a, obj);
        }

        public Collection<V> m18386a(Object obj) {
            Collection collection = (Collection) Maps.m18653a(this.f12945a, obj);
            if (collection == null) {
                return null;
            }
            return this.f12946b.m18355a(obj, collection);
        }

        public Set<K> keySet() {
            return this.f12946b.mo2658o();
        }

        public int size() {
            return this.f12945a.size();
        }

        public Collection<V> m18389b(Object obj) {
            Collection collection = (Collection) this.f12945a.remove(obj);
            if (collection == null) {
                return null;
            }
            Collection<V> c = this.f12946b.mo2629c();
            c.addAll(collection);
            this.f12946b.f12930b = this.f12946b.f12930b - collection.size();
            collection.clear();
            return c;
        }

        public boolean equals(Object obj) {
            return this == obj || this.f12945a.equals(obj);
        }

        public int hashCode() {
            return this.f12945a.hashCode();
        }

        public String toString() {
            return this.f12945a.toString();
        }

        public void clear() {
            if (this.f12945a == this.f12946b.f12929a) {
                this.f12946b.mo2623f();
            } else {
                Iterators.m18631e(new C3519b(this));
            }
        }

        Entry<K, Collection<V>> m18387a(Entry<K, Collection<V>> entry) {
            Object key = entry.getKey();
            return Maps.m18657a(key, this.f12946b.m18355a(key, (Collection) entry.getValue()));
        }
    }

    private class C3524c extends C3523b<K, Collection<V>> {
        final /* synthetic */ AbstractMapBasedMultimap f12951a;

        C3524c(AbstractMapBasedMultimap abstractMapBasedMultimap, Map<K, Collection<V>> map) {
            this.f12951a = abstractMapBasedMultimap;
            super(map);
        }

        public Iterator<K> iterator() {
            final Iterator it = m18390c().entrySet().iterator();
            return new Iterator<K>(this) {
                Entry<K, Collection<V>> f12947a;
                final /* synthetic */ C3524c f12949c;

                public boolean hasNext() {
                    return it.hasNext();
                }

                public K next() {
                    this.f12947a = (Entry) it.next();
                    return this.f12947a.getKey();
                }

                public void remove() {
                    C3587d.m18769a(this.f12947a != null);
                    Collection collection = (Collection) this.f12947a.getValue();
                    it.remove();
                    this.f12949c.f12951a.f12930b = this.f12949c.f12951a.f12930b - collection.size();
                    collection.clear();
                }
            };
        }

        public boolean remove(Object obj) {
            int i;
            Collection collection = (Collection) m18390c().remove(obj);
            if (collection != null) {
                int size = collection.size();
                collection.clear();
                this.f12951a.f12930b = this.f12951a.f12930b - size;
                i = size;
            } else {
                i = 0;
            }
            return i > 0;
        }

        public void clear() {
            Iterators.m18631e(iterator());
        }

        public boolean containsAll(Collection<?> collection) {
            return m18390c().keySet().containsAll(collection);
        }

        public boolean equals(Object obj) {
            return this == obj || m18390c().keySet().equals(obj);
        }

        public int hashCode() {
            return m18390c().keySet().hashCode();
        }
    }

    private class C3525g extends C3521a implements SortedMap<K, Collection<V>> {
        SortedSet<K> f12952d;
        final /* synthetic */ AbstractMapBasedMultimap f12953e;

        /* synthetic */ Set mo2642h() {
            return mo2643e();
        }

        public /* synthetic */ Set keySet() {
            return mo2644f();
        }

        C3525g(AbstractMapBasedMultimap abstractMapBasedMultimap, SortedMap<K, Collection<V>> sortedMap) {
            this.f12953e = abstractMapBasedMultimap;
            super(abstractMapBasedMultimap, sortedMap);
        }

        SortedMap<K, Collection<V>> mo2645g() {
            return (SortedMap) this.a;
        }

        public Comparator<? super K> comparator() {
            return mo2645g().comparator();
        }

        public K firstKey() {
            return mo2645g().firstKey();
        }

        public K lastKey() {
            return mo2645g().lastKey();
        }

        public SortedMap<K, Collection<V>> headMap(K k) {
            return new C3525g(this.f12953e, mo2645g().headMap(k));
        }

        public SortedMap<K, Collection<V>> subMap(K k, K k2) {
            return new C3525g(this.f12953e, mo2645g().subMap(k, k2));
        }

        public SortedMap<K, Collection<V>> tailMap(K k) {
            return new C3525g(this.f12953e, mo2645g().tailMap(k));
        }

        public SortedSet<K> mo2644f() {
            SortedSet<K> sortedSet = this.f12952d;
            if (sortedSet != null) {
                return sortedSet;
            }
            sortedSet = mo2643e();
            this.f12952d = sortedSet;
            return sortedSet;
        }

        SortedSet<K> mo2643e() {
            return new C3527h(this.f12953e, mo2645g());
        }
    }

    class C3526d extends C3525g implements NavigableMap<K, Collection<V>> {
        final /* synthetic */ AbstractMapBasedMultimap f12954c;

        /* synthetic */ SortedSet mo2643e() {
            return m18401d();
        }

        public /* synthetic */ SortedSet mo2644f() {
            return m18399c();
        }

        /* synthetic */ SortedMap mo2645g() {
            return m18397b();
        }

        /* synthetic */ Set mo2642h() {
            return m18401d();
        }

        public /* synthetic */ SortedMap headMap(Object obj) {
            return m18398c(obj);
        }

        public /* synthetic */ Set keySet() {
            return m18399c();
        }

        public /* synthetic */ SortedMap subMap(Object obj, Object obj2) {
            return m18396a(obj, obj2);
        }

        public /* synthetic */ SortedMap tailMap(Object obj) {
            return m18400d(obj);
        }

        C3526d(AbstractMapBasedMultimap abstractMapBasedMultimap, NavigableMap<K, Collection<V>> navigableMap) {
            this.f12954c = abstractMapBasedMultimap;
            super(abstractMapBasedMultimap, navigableMap);
        }

        NavigableMap<K, Collection<V>> m18397b() {
            return (NavigableMap) super.mo2645g();
        }

        public Entry<K, Collection<V>> lowerEntry(K k) {
            Entry lowerEntry = m18397b().lowerEntry(k);
            return lowerEntry == null ? null : m18387a(lowerEntry);
        }

        public K lowerKey(K k) {
            return m18397b().lowerKey(k);
        }

        public Entry<K, Collection<V>> floorEntry(K k) {
            Entry floorEntry = m18397b().floorEntry(k);
            return floorEntry == null ? null : m18387a(floorEntry);
        }

        public K floorKey(K k) {
            return m18397b().floorKey(k);
        }

        public Entry<K, Collection<V>> ceilingEntry(K k) {
            Entry ceilingEntry = m18397b().ceilingEntry(k);
            return ceilingEntry == null ? null : m18387a(ceilingEntry);
        }

        public K ceilingKey(K k) {
            return m18397b().ceilingKey(k);
        }

        public Entry<K, Collection<V>> higherEntry(K k) {
            Entry higherEntry = m18397b().higherEntry(k);
            return higherEntry == null ? null : m18387a(higherEntry);
        }

        public K higherKey(K k) {
            return m18397b().higherKey(k);
        }

        public Entry<K, Collection<V>> firstEntry() {
            Entry firstEntry = m18397b().firstEntry();
            return firstEntry == null ? null : m18387a(firstEntry);
        }

        public Entry<K, Collection<V>> lastEntry() {
            Entry lastEntry = m18397b().lastEntry();
            return lastEntry == null ? null : m18387a(lastEntry);
        }

        public Entry<K, Collection<V>> pollFirstEntry() {
            return m18395a(entrySet().iterator());
        }

        public Entry<K, Collection<V>> pollLastEntry() {
            return m18395a(descendingMap().entrySet().iterator());
        }

        Entry<K, Collection<V>> m18395a(Iterator<Entry<K, Collection<V>>> it) {
            if (!it.hasNext()) {
                return null;
            }
            Entry entry = (Entry) it.next();
            Collection c = this.f12954c.mo2629c();
            c.addAll((Collection) entry.getValue());
            it.remove();
            return Maps.m18657a(entry.getKey(), AbstractMapBasedMultimap.m18344a(c));
        }

        public NavigableMap<K, Collection<V>> descendingMap() {
            return new C3526d(this.f12954c, m18397b().descendingMap());
        }

        public NavigableSet<K> m18399c() {
            return (NavigableSet) super.mo2644f();
        }

        NavigableSet<K> m18401d() {
            return new C3528e(this.f12954c, m18397b());
        }

        public NavigableSet<K> navigableKeySet() {
            return m18399c();
        }

        public NavigableSet<K> descendingKeySet() {
            return descendingMap().navigableKeySet();
        }

        public NavigableMap<K, Collection<V>> m18396a(K k, K k2) {
            return subMap(k, true, k2, false);
        }

        public NavigableMap<K, Collection<V>> subMap(K k, boolean z, K k2, boolean z2) {
            return new C3526d(this.f12954c, m18397b().subMap(k, z, k2, z2));
        }

        public NavigableMap<K, Collection<V>> m18398c(K k) {
            return headMap(k, false);
        }

        public NavigableMap<K, Collection<V>> headMap(K k, boolean z) {
            return new C3526d(this.f12954c, m18397b().headMap(k, z));
        }

        public NavigableMap<K, Collection<V>> m18400d(K k) {
            return tailMap(k, true);
        }

        public NavigableMap<K, Collection<V>> tailMap(K k, boolean z) {
            return new C3526d(this.f12954c, m18397b().tailMap(k, z));
        }
    }

    private class C3527h extends C3524c implements SortedSet<K> {
        final /* synthetic */ AbstractMapBasedMultimap f12955c;

        C3527h(AbstractMapBasedMultimap abstractMapBasedMultimap, SortedMap<K, Collection<V>> sortedMap) {
            this.f12955c = abstractMapBasedMultimap;
            super(abstractMapBasedMultimap, sortedMap);
        }

        SortedMap<K, Collection<V>> mo2649b() {
            return (SortedMap) super.m18390c();
        }

        public Comparator<? super K> comparator() {
            return mo2649b().comparator();
        }

        public K first() {
            return mo2649b().firstKey();
        }

        public SortedSet<K> headSet(K k) {
            return new C3527h(this.f12955c, mo2649b().headMap(k));
        }

        public K last() {
            return mo2649b().lastKey();
        }

        public SortedSet<K> subSet(K k, K k2) {
            return new C3527h(this.f12955c, mo2649b().subMap(k, k2));
        }

        public SortedSet<K> tailSet(K k) {
            return new C3527h(this.f12955c, mo2649b().tailMap(k));
        }
    }

    class C3528e extends C3527h implements NavigableSet<K> {
        final /* synthetic */ AbstractMapBasedMultimap f12956b;

        /* synthetic */ SortedMap mo2649b() {
            return m18407a();
        }

        public /* synthetic */ SortedSet headSet(Object obj) {
            return m18408a(obj);
        }

        public /* synthetic */ SortedSet subSet(Object obj, Object obj2) {
            return m18409a(obj, obj2);
        }

        public /* synthetic */ SortedSet tailSet(Object obj) {
            return m18410b(obj);
        }

        C3528e(AbstractMapBasedMultimap abstractMapBasedMultimap, NavigableMap<K, Collection<V>> navigableMap) {
            this.f12956b = abstractMapBasedMultimap;
            super(abstractMapBasedMultimap, navigableMap);
        }

        NavigableMap<K, Collection<V>> m18407a() {
            return (NavigableMap) super.mo2649b();
        }

        public K lower(K k) {
            return m18407a().lowerKey(k);
        }

        public K floor(K k) {
            return m18407a().floorKey(k);
        }

        public K ceiling(K k) {
            return m18407a().ceilingKey(k);
        }

        public K higher(K k) {
            return m18407a().higherKey(k);
        }

        public K pollFirst() {
            return Iterators.m18630d(iterator());
        }

        public K pollLast() {
            return Iterators.m18630d(descendingIterator());
        }

        public NavigableSet<K> descendingSet() {
            return new C3528e(this.f12956b, m18407a().descendingMap());
        }

        public Iterator<K> descendingIterator() {
            return descendingSet().iterator();
        }

        public NavigableSet<K> m18408a(K k) {
            return headSet(k, false);
        }

        public NavigableSet<K> headSet(K k, boolean z) {
            return new C3528e(this.f12956b, m18407a().headMap(k, z));
        }

        public NavigableSet<K> m18409a(K k, K k2) {
            return subSet(k, true, k2, false);
        }

        public NavigableSet<K> subSet(K k, boolean z, K k2, boolean z2) {
            return new C3528e(this.f12956b, m18407a().subMap(k, z, k2, z2));
        }

        public NavigableSet<K> m18410b(K k) {
            return tailSet(k, true);
        }

        public NavigableSet<K> tailSet(K k, boolean z) {
            return new C3528e(this.f12956b, m18407a().tailMap(k, z));
        }
    }

    private class C3529i extends AbstractCollection<V> {
        final K f12957b;
        Collection<V> f12958c;
        final C3529i f12959d;
        final Collection<V> f12960e;
        final /* synthetic */ AbstractMapBasedMultimap f12961f;

        class C3532a implements Iterator<V> {
            final Iterator<V> f12964a;
            final Collection<V> f12965b = this.f12966c.f12958c;
            final /* synthetic */ C3529i f12966c;

            C3532a(C3529i c3529i) {
                this.f12966c = c3529i;
                this.f12964a = AbstractMapBasedMultimap.m18353c(c3529i.f12958c);
            }

            C3532a(C3529i c3529i, Iterator<V> it) {
                this.f12966c = c3529i;
                this.f12964a = it;
            }

            void m18419a() {
                this.f12966c.m18412a();
                if (this.f12966c.f12958c != this.f12965b) {
                    throw new ConcurrentModificationException();
                }
            }

            public boolean hasNext() {
                m18419a();
                return this.f12964a.hasNext();
            }

            public V next() {
                m18419a();
                return this.f12964a.next();
            }

            public void remove() {
                this.f12964a.remove();
                this.f12966c.f12961f.f12930b = this.f12966c.f12961f.f12930b - 1;
                this.f12966c.m18413b();
            }

            Iterator<V> m18420b() {
                m18419a();
                return this.f12964a;
            }
        }

        C3529i(AbstractMapBasedMultimap abstractMapBasedMultimap, K k, Collection<V> collection, C3529i c3529i) {
            this.f12961f = abstractMapBasedMultimap;
            this.f12957b = k;
            this.f12958c = collection;
            this.f12959d = c3529i;
            this.f12960e = c3529i == null ? null : c3529i.m18416e();
        }

        void m18412a() {
            if (this.f12959d != null) {
                this.f12959d.m18412a();
                if (this.f12959d.m18416e() != this.f12960e) {
                    throw new ConcurrentModificationException();
                }
            } else if (this.f12958c.isEmpty()) {
                Collection collection = (Collection) this.f12961f.f12929a.get(this.f12957b);
                if (collection != null) {
                    this.f12958c = collection;
                }
            }
        }

        void m18413b() {
            if (this.f12959d != null) {
                this.f12959d.m18413b();
            } else if (this.f12958c.isEmpty()) {
                this.f12961f.f12929a.remove(this.f12957b);
            }
        }

        K m18414c() {
            return this.f12957b;
        }

        void m18415d() {
            if (this.f12959d != null) {
                this.f12959d.m18415d();
            } else {
                this.f12961f.f12929a.put(this.f12957b, this.f12958c);
            }
        }

        public int size() {
            m18412a();
            return this.f12958c.size();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            m18412a();
            return this.f12958c.equals(obj);
        }

        public int hashCode() {
            m18412a();
            return this.f12958c.hashCode();
        }

        public String toString() {
            m18412a();
            return this.f12958c.toString();
        }

        Collection<V> m18416e() {
            return this.f12958c;
        }

        public Iterator<V> iterator() {
            m18412a();
            return new C3532a(this);
        }

        public boolean add(V v) {
            m18412a();
            boolean isEmpty = this.f12958c.isEmpty();
            boolean add = this.f12958c.add(v);
            if (add) {
                this.f12961f.f12930b = this.f12961f.f12930b + 1;
                if (isEmpty) {
                    m18415d();
                }
            }
            return add;
        }

        C3529i m18417f() {
            return this.f12959d;
        }

        public boolean addAll(Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = this.f12958c.addAll(collection);
            if (!addAll) {
                return addAll;
            }
            this.f12961f.f12930b = (this.f12958c.size() - size) + this.f12961f.f12930b;
            if (size != 0) {
                return addAll;
            }
            m18415d();
            return addAll;
        }

        public boolean contains(Object obj) {
            m18412a();
            return this.f12958c.contains(obj);
        }

        public boolean containsAll(Collection<?> collection) {
            m18412a();
            return this.f12958c.containsAll(collection);
        }

        public void clear() {
            int size = size();
            if (size != 0) {
                this.f12958c.clear();
                this.f12961f.f12930b = this.f12961f.f12930b - size;
                m18413b();
            }
        }

        public boolean remove(Object obj) {
            m18412a();
            boolean remove = this.f12958c.remove(obj);
            if (remove) {
                this.f12961f.f12930b = this.f12961f.f12930b - 1;
                m18413b();
            }
            return remove;
        }

        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean removeAll = this.f12958c.removeAll(collection);
            if (!removeAll) {
                return removeAll;
            }
            this.f12961f.f12930b = (this.f12958c.size() - size) + this.f12961f.f12930b;
            m18413b();
            return removeAll;
        }

        public boolean retainAll(Collection<?> collection) {
            Preconditions.checkNotNull(collection);
            int size = size();
            boolean retainAll = this.f12958c.retainAll(collection);
            if (retainAll) {
                this.f12961f.f12930b = (this.f12958c.size() - size) + this.f12961f.f12930b;
                m18413b();
            }
            return retainAll;
        }
    }

    private class C3530j extends C3529i implements List<V> {
        final /* synthetic */ AbstractMapBasedMultimap f12962g;

        private class C3533a extends a implements ListIterator<V> {
            final /* synthetic */ C3530j f12967d;

            C3533a(C3530j c3530j) {
                this.f12967d = c3530j;
                super(c3530j);
            }

            public C3533a(C3530j c3530j, int i) {
                this.f12967d = c3530j;
                super(c3530j, c3530j.m18418g().listIterator(i));
            }

            private ListIterator<V> m18421c() {
                return (ListIterator) b();
            }

            public boolean hasPrevious() {
                return m18421c().hasPrevious();
            }

            public V previous() {
                return m18421c().previous();
            }

            public int nextIndex() {
                return m18421c().nextIndex();
            }

            public int previousIndex() {
                return m18421c().previousIndex();
            }

            public void set(V v) {
                m18421c().set(v);
            }

            public void add(V v) {
                boolean isEmpty = this.f12967d.isEmpty();
                m18421c().add(v);
                this.f12967d.f12962g.f12930b = this.f12967d.f12962g.f12930b + 1;
                if (isEmpty) {
                    this.f12967d.m18415d();
                }
            }
        }

        C3530j(AbstractMapBasedMultimap abstractMapBasedMultimap, K k, List<V> list, C3529i c3529i) {
            this.f12962g = abstractMapBasedMultimap;
            super(abstractMapBasedMultimap, k, list, c3529i);
        }

        List<V> m18418g() {
            return (List) m18416e();
        }

        public boolean addAll(int i, Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = m18418g().addAll(i, collection);
            if (!addAll) {
                return addAll;
            }
            this.f12962g.f12930b = (m18416e().size() - size) + this.f12962g.f12930b;
            if (size != 0) {
                return addAll;
            }
            m18415d();
            return addAll;
        }

        public V get(int i) {
            m18412a();
            return m18418g().get(i);
        }

        public V set(int i, V v) {
            m18412a();
            return m18418g().set(i, v);
        }

        public void add(int i, V v) {
            m18412a();
            boolean isEmpty = m18416e().isEmpty();
            m18418g().add(i, v);
            this.f12962g.f12930b = this.f12962g.f12930b + 1;
            if (isEmpty) {
                m18415d();
            }
        }

        public V remove(int i) {
            m18412a();
            V remove = m18418g().remove(i);
            this.f12962g.f12930b = this.f12962g.f12930b - 1;
            m18413b();
            return remove;
        }

        public int indexOf(Object obj) {
            m18412a();
            return m18418g().indexOf(obj);
        }

        public int lastIndexOf(Object obj) {
            m18412a();
            return m18418g().lastIndexOf(obj);
        }

        public ListIterator<V> listIterator() {
            m18412a();
            return new C3533a(this);
        }

        public ListIterator<V> listIterator(int i) {
            m18412a();
            return new C3533a(this, i);
        }

        public List<V> subList(int i, int i2) {
            C3529i f;
            m18412a();
            AbstractMapBasedMultimap abstractMapBasedMultimap = this.f12962g;
            Object c = m18414c();
            List subList = m18418g().subList(i, i2);
            if (m18417f() != null) {
                f = m18417f();
            }
            return abstractMapBasedMultimap.m18346a(c, subList, f);
        }
    }

    private class C3531f extends C3530j implements RandomAccess {
        final /* synthetic */ AbstractMapBasedMultimap f12963a;

        C3531f(AbstractMapBasedMultimap abstractMapBasedMultimap, K k, List<V> list, C3529i c3529i) {
            this.f12963a = abstractMapBasedMultimap;
            super(abstractMapBasedMultimap, k, list, c3529i);
        }
    }

    private class C3534m extends C3529i implements SortedSet<V> {
        final /* synthetic */ AbstractMapBasedMultimap f12968g;

        C3534m(AbstractMapBasedMultimap abstractMapBasedMultimap, K k, SortedSet<V> sortedSet, C3529i c3529i) {
            this.f12968g = abstractMapBasedMultimap;
            super(abstractMapBasedMultimap, k, sortedSet, c3529i);
        }

        SortedSet<V> mo2653h() {
            return (SortedSet) m18416e();
        }

        public Comparator<? super V> comparator() {
            return mo2653h().comparator();
        }

        public V first() {
            m18412a();
            return mo2653h().first();
        }

        public V last() {
            m18412a();
            return mo2653h().last();
        }

        public SortedSet<V> headSet(V v) {
            C3529i f;
            m18412a();
            AbstractMapBasedMultimap abstractMapBasedMultimap = this.f12968g;
            Object c = m18414c();
            SortedSet headSet = mo2653h().headSet(v);
            if (m18417f() != null) {
                f = m18417f();
            }
            return new C3534m(abstractMapBasedMultimap, c, headSet, f);
        }

        public SortedSet<V> subSet(V v, V v2) {
            C3529i f;
            m18412a();
            AbstractMapBasedMultimap abstractMapBasedMultimap = this.f12968g;
            Object c = m18414c();
            SortedSet subSet = mo2653h().subSet(v, v2);
            if (m18417f() != null) {
                f = m18417f();
            }
            return new C3534m(abstractMapBasedMultimap, c, subSet, f);
        }

        public SortedSet<V> tailSet(V v) {
            C3529i f;
            m18412a();
            AbstractMapBasedMultimap abstractMapBasedMultimap = this.f12968g;
            Object c = m18414c();
            SortedSet tailSet = mo2653h().tailSet(v);
            if (m18417f() != null) {
                f = m18417f();
            }
            return new C3534m(abstractMapBasedMultimap, c, tailSet, f);
        }
    }

    class C3535k extends C3534m implements NavigableSet<V> {
        final /* synthetic */ AbstractMapBasedMultimap f12969a;

        /* synthetic */ SortedSet mo2653h() {
            return m18424g();
        }

        C3535k(AbstractMapBasedMultimap abstractMapBasedMultimap, K k, NavigableSet<V> navigableSet, C3529i c3529i) {
            this.f12969a = abstractMapBasedMultimap;
            super(abstractMapBasedMultimap, k, navigableSet, c3529i);
        }

        NavigableSet<V> m18424g() {
            return (NavigableSet) super.mo2653h();
        }

        public V lower(V v) {
            return m18424g().lower(v);
        }

        public V floor(V v) {
            return m18424g().floor(v);
        }

        public V ceiling(V v) {
            return m18424g().ceiling(v);
        }

        public V higher(V v) {
            return m18424g().higher(v);
        }

        public V pollFirst() {
            return Iterators.m18630d(iterator());
        }

        public V pollLast() {
            return Iterators.m18630d(descendingIterator());
        }

        private NavigableSet<V> m18423a(NavigableSet<V> navigableSet) {
            C3529i f;
            AbstractMapBasedMultimap abstractMapBasedMultimap = this.f12969a;
            Object obj = this.b;
            if (m18417f() != null) {
                f = m18417f();
            }
            return new C3535k(abstractMapBasedMultimap, obj, navigableSet, f);
        }

        public NavigableSet<V> descendingSet() {
            return m18423a(m18424g().descendingSet());
        }

        public Iterator<V> descendingIterator() {
            return new C3532a(this, m18424g().descendingIterator());
        }

        public NavigableSet<V> subSet(V v, boolean z, V v2, boolean z2) {
            return m18423a(m18424g().subSet(v, z, v2, z2));
        }

        public NavigableSet<V> headSet(V v, boolean z) {
            return m18423a(m18424g().headSet(v, z));
        }

        public NavigableSet<V> tailSet(V v, boolean z) {
            return m18423a(m18424g().tailSet(v, z));
        }
    }

    private class C3536l extends C3529i implements Set<V> {
        final /* synthetic */ AbstractMapBasedMultimap f12970a;

        C3536l(AbstractMapBasedMultimap abstractMapBasedMultimap, K k, Set<V> set) {
            this.f12970a = abstractMapBasedMultimap;
            super(abstractMapBasedMultimap, k, set, null);
        }

        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean a = Sets.m18758a((Set) this.c, (Collection) collection);
            if (!a) {
                return a;
            }
            this.f12970a.f12930b = (this.c.size() - size) + this.f12970a.f12930b;
            m18413b();
            return a;
        }
    }

    abstract Collection<V> mo2629c();

    protected AbstractMapBasedMultimap(Map<K, Collection<V>> map) {
        Preconditions.checkArgument(map.isEmpty());
        this.f12929a = map;
    }

    final void m18356a(Map<K, Collection<V>> map) {
        this.f12929a = map;
        this.f12930b = 0;
        for (Collection collection : map.values()) {
            boolean z;
            if (collection.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            Preconditions.checkArgument(z);
            this.f12930b = collection.size() + this.f12930b;
        }
    }

    Collection<V> m18360c(K k) {
        return mo2629c();
    }

    Map<K, Collection<V>> m18361d() {
        return this.f12929a;
    }

    public int mo2622e() {
        return this.f12930b;
    }

    public boolean mo2614a(K k, V v) {
        Collection collection = (Collection) this.f12929a.get(k);
        if (collection == null) {
            collection = m18360c((Object) k);
            if (collection.add(v)) {
                this.f12930b++;
                this.f12929a.put(k, collection);
                return true;
            }
            throw new AssertionError("New Collection violated the Collection spec");
        } else if (!collection.add(v)) {
            return false;
        } else {
            this.f12930b++;
            return true;
        }
    }

    static <E> Collection<E> m18344a(Collection<E> collection) {
        if (collection instanceof NavigableSet) {
            return Sets.m18756a((NavigableSet) collection);
        }
        if (collection instanceof SortedSet) {
            return Collections.unmodifiableSortedSet((SortedSet) collection);
        }
        if (collection instanceof Set) {
            return Collections.unmodifiableSet((Set) collection);
        }
        if (collection instanceof List) {
            return Collections.unmodifiableList((List) collection);
        }
        return Collections.unmodifiableCollection(collection);
    }

    public void mo2623f() {
        for (Collection clear : this.f12929a.values()) {
            clear.clear();
        }
        this.f12929a.clear();
        this.f12930b = 0;
    }

    public Collection<V> mo2621b(K k) {
        Collection collection = (Collection) this.f12929a.get(k);
        if (collection == null) {
            collection = m18360c((Object) k);
        }
        return m18355a((Object) k, collection);
    }

    Collection<V> m18355a(K k, Collection<V> collection) {
        if (collection instanceof NavigableSet) {
            return new C3535k(this, k, (NavigableSet) collection, null);
        }
        if (collection instanceof SortedSet) {
            return new C3534m(this, k, (SortedSet) collection, null);
        }
        if (collection instanceof Set) {
            return new C3536l(this, k, (Set) collection);
        }
        if (collection instanceof List) {
            return m18346a(k, (List) collection, null);
        }
        return new C3529i(this, k, collection, null);
    }

    private List<V> m18346a(K k, List<V> list, C3529i c3529i) {
        return list instanceof RandomAccess ? new C3531f(this, k, list, c3529i) : new C3530j(this, k, list, c3529i);
    }

    private static <E> Iterator<E> m18353c(Collection<E> collection) {
        if (collection instanceof List) {
            return ((List) collection).listIterator();
        }
        return collection.iterator();
    }

    Set<K> mo2624g() {
        if (this.f12929a instanceof NavigableMap) {
            return new C3528e(this, (NavigableMap) this.f12929a);
        }
        if (this.f12929a instanceof SortedMap) {
            return new C3527h(this, (SortedMap) this.f12929a);
        }
        return new C3524c(this, this.f12929a);
    }

    private void mo2628a(Object obj) {
        Collection collection = (Collection) Maps.m18662c(this.f12929a, obj);
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            this.f12930b -= size;
        }
    }

    public Collection<V> mo2618h() {
        return super.mo2618h();
    }

    Iterator<V> mo2625i() {
        return new C35141(this);
    }

    public Collection<Entry<K, V>> mo2619j() {
        return super.mo2619j();
    }

    Iterator<Entry<K, V>> mo2626k() {
        return new C35152(this);
    }

    Map<K, Collection<V>> mo2627l() {
        if (this.f12929a instanceof NavigableMap) {
            return new C3526d(this, (NavigableMap) this.f12929a);
        }
        if (this.f12929a instanceof SortedMap) {
            return new C3525g(this, (SortedMap) this.f12929a);
        }
        return new C3521a(this, this.f12929a);
    }
}
