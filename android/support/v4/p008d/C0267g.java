package android.support.v4.p008d;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

abstract class C0267g<K, V> {
    C0277b f786b;
    C0278c f787c;
    C0280e f788d;

    final class C0276a<T> implements Iterator<T> {
        final int f816a;
        int f817b;
        int f818c;
        boolean f819d = false;
        final /* synthetic */ C0267g f820e;

        C0276a(C0267g c0267g, int i) {
            this.f820e = c0267g;
            this.f816a = i;
            this.f817b = c0267g.mo169a();
        }

        public boolean hasNext() {
            return this.f818c < this.f817b;
        }

        public T next() {
            T a = this.f820e.mo171a(this.f818c, this.f816a);
            this.f818c++;
            this.f819d = true;
            return a;
        }

        public void remove() {
            if (this.f819d) {
                this.f818c--;
                this.f817b--;
                this.f819d = false;
                this.f820e.mo173a(this.f818c);
                return;
            }
            throw new IllegalStateException();
        }
    }

    final class C0277b implements Set<Entry<K, V>> {
        final /* synthetic */ C0267g f821a;

        C0277b(C0267g c0267g) {
            this.f821a = c0267g;
        }

        public /* synthetic */ boolean add(Object obj) {
            return m1175a((Entry) obj);
        }

        public boolean m1175a(Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends Entry<K, V>> collection) {
            int a = this.f821a.mo169a();
            for (Entry entry : collection) {
                this.f821a.mo174a(entry.getKey(), entry.getValue());
            }
            return a != this.f821a.mo169a();
        }

        public void clear() {
            this.f821a.mo177c();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            int a = this.f821a.mo170a(entry.getKey());
            if (a >= 0) {
                return C0271b.m1157a(this.f821a.mo171a(a, 1), entry.getValue());
            }
            return false;
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return this.f821a.mo169a() == 0;
        }

        public Iterator<Entry<K, V>> iterator() {
            return new C0279d(this.f821a);
        }

        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return this.f821a.mo169a();
        }

        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }

        public boolean equals(Object obj) {
            return C0267g.m1114a((Set) this, obj);
        }

        public int hashCode() {
            int a = this.f821a.mo169a() - 1;
            int i = 0;
            while (a >= 0) {
                Object a2 = this.f821a.mo171a(a, 0);
                Object a3 = this.f821a.mo171a(a, 1);
                a--;
                i += (a3 == null ? 0 : a3.hashCode()) ^ (a2 == null ? 0 : a2.hashCode());
            }
            return i;
        }
    }

    final class C0278c implements Set<K> {
        final /* synthetic */ C0267g f822a;

        C0278c(C0267g c0267g) {
            this.f822a = c0267g;
        }

        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            this.f822a.mo177c();
        }

        public boolean contains(Object obj) {
            return this.f822a.mo170a(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            return C0267g.m1113a(this.f822a.mo176b(), (Collection) collection);
        }

        public boolean isEmpty() {
            return this.f822a.mo169a() == 0;
        }

        public Iterator<K> iterator() {
            return new C0276a(this.f822a, 0);
        }

        public boolean remove(Object obj) {
            int a = this.f822a.mo170a(obj);
            if (a < 0) {
                return false;
            }
            this.f822a.mo173a(a);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            return C0267g.m1115b(this.f822a.mo176b(), collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return C0267g.m1116c(this.f822a.mo176b(), collection);
        }

        public int size() {
            return this.f822a.mo169a();
        }

        public Object[] toArray() {
            return this.f822a.m1126b(0);
        }

        public <T> T[] toArray(T[] tArr) {
            return this.f822a.m1123a((Object[]) tArr, 0);
        }

        public boolean equals(Object obj) {
            return C0267g.m1114a((Set) this, obj);
        }

        public int hashCode() {
            int i = 0;
            for (int a = this.f822a.mo169a() - 1; a >= 0; a--) {
                Object a2 = this.f822a.mo171a(a, 0);
                i += a2 == null ? 0 : a2.hashCode();
            }
            return i;
        }
    }

    final class C0279d implements Iterator<Entry<K, V>>, Entry<K, V> {
        int f823a;
        int f824b;
        boolean f825c = false;
        final /* synthetic */ C0267g f826d;

        public /* synthetic */ Object next() {
            return m1176a();
        }

        C0279d(C0267g c0267g) {
            this.f826d = c0267g;
            this.f823a = c0267g.mo169a() - 1;
            this.f824b = -1;
        }

        public boolean hasNext() {
            return this.f824b < this.f823a;
        }

        public Entry<K, V> m1176a() {
            this.f824b++;
            this.f825c = true;
            return this;
        }

        public void remove() {
            if (this.f825c) {
                this.f826d.mo173a(this.f824b);
                this.f824b--;
                this.f823a--;
                this.f825c = false;
                return;
            }
            throw new IllegalStateException();
        }

        public K getKey() {
            if (this.f825c) {
                return this.f826d.mo171a(this.f824b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V getValue() {
            if (this.f825c) {
                return this.f826d.mo171a(this.f824b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V setValue(V v) {
            if (this.f825c) {
                return this.f826d.mo172a(this.f824b, (Object) v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final boolean equals(Object obj) {
            boolean z = true;
            if (!this.f825c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Entry)) {
                return false;
            } else {
                Entry entry = (Entry) obj;
                if (!(C0271b.m1157a(entry.getKey(), this.f826d.mo171a(this.f824b, 0)) && C0271b.m1157a(entry.getValue(), this.f826d.mo171a(this.f824b, 1)))) {
                    z = false;
                }
                return z;
            }
        }

        public final int hashCode() {
            int i = 0;
            if (this.f825c) {
                Object a = this.f826d.mo171a(this.f824b, 0);
                Object a2 = this.f826d.mo171a(this.f824b, 1);
                int hashCode = a == null ? 0 : a.hashCode();
                if (a2 != null) {
                    i = a2.hashCode();
                }
                return i ^ hashCode;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    final class C0280e implements Collection<V> {
        final /* synthetic */ C0267g f827a;

        C0280e(C0267g c0267g) {
            this.f827a = c0267g;
        }

        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            this.f827a.mo177c();
        }

        public boolean contains(Object obj) {
            return this.f827a.mo175b(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return this.f827a.mo169a() == 0;
        }

        public Iterator<V> iterator() {
            return new C0276a(this.f827a, 1);
        }

        public boolean remove(Object obj) {
            int b = this.f827a.mo175b(obj);
            if (b < 0) {
                return false;
            }
            this.f827a.mo173a(b);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            int i = 0;
            int a = this.f827a.mo169a();
            boolean z = false;
            while (i < a) {
                if (collection.contains(this.f827a.mo171a(i, 1))) {
                    this.f827a.mo173a(i);
                    i--;
                    a--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public boolean retainAll(Collection<?> collection) {
            int i = 0;
            int a = this.f827a.mo169a();
            boolean z = false;
            while (i < a) {
                if (!collection.contains(this.f827a.mo171a(i, 1))) {
                    this.f827a.mo173a(i);
                    i--;
                    a--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public int size() {
            return this.f827a.mo169a();
        }

        public Object[] toArray() {
            return this.f827a.m1126b(1);
        }

        public <T> T[] toArray(T[] tArr) {
            return this.f827a.m1123a((Object[]) tArr, 1);
        }
    }

    protected abstract int mo169a();

    protected abstract int mo170a(Object obj);

    protected abstract Object mo171a(int i, int i2);

    protected abstract V mo172a(int i, V v);

    protected abstract void mo173a(int i);

    protected abstract void mo174a(K k, V v);

    protected abstract int mo175b(Object obj);

    protected abstract Map<K, V> mo176b();

    protected abstract void mo177c();

    C0267g() {
    }

    public static <K, V> boolean m1113a(Map<K, V> map, Collection<?> collection) {
        for (Object containsKey : collection) {
            if (!map.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public static <K, V> boolean m1115b(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        for (Object remove : collection) {
            map.remove(remove);
        }
        return size != map.size();
    }

    public static <K, V> boolean m1116c(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public Object[] m1126b(int i) {
        int a = mo169a();
        Object[] objArr = new Object[a];
        for (int i2 = 0; i2 < a; i2++) {
            objArr[i2] = mo171a(i2, i);
        }
        return objArr;
    }

    public <T> T[] m1123a(T[] tArr, int i) {
        T[] tArr2;
        int a = mo169a();
        if (tArr.length < a) {
            tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), a);
        } else {
            tArr2 = tArr;
        }
        for (int i2 = 0; i2 < a; i2++) {
            tArr2[i2] = mo171a(i2, i);
        }
        if (tArr2.length > a) {
            tArr2[a] = null;
        }
        return tArr2;
    }

    public static <T> boolean m1114a(Set<T> set, Object obj) {
        boolean z = true;
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            if (!(set.size() == set2.size() && set.containsAll(set2))) {
                z = false;
            }
            return z;
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }

    public Set<Entry<K, V>> m1128d() {
        if (this.f786b == null) {
            this.f786b = new C0277b(this);
        }
        return this.f786b;
    }

    public Set<K> m1129e() {
        if (this.f787c == null) {
            this.f787c = new C0278c(this);
        }
        return this.f787c;
    }

    public Collection<V> m1130f() {
        if (this.f788d == null) {
            this.f788d = new C0280e(this);
        }
        return this.f788d;
    }
}
