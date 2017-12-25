package com.google.protobuf;

import com.google.protobuf.C3647f.C3630a;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class C3661p<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private final int f13266a;
    private List<C3666b> f13267b;
    private Map<K, V> f13268c;
    private boolean f13269d;
    private volatile C3668d f13270e;

    private static class C3665a {
        private static final Iterator<Object> f13271a = new C36631();
        private static final Iterable<Object> f13272b = new C36642();

        static class C36631 implements Iterator<Object> {
            C36631() {
            }

            public boolean hasNext() {
                return false;
            }

            public Object next() {
                throw new NoSuchElementException();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        static class C36642 implements Iterable<Object> {
            C36642() {
            }

            public Iterator<Object> iterator() {
                return C3665a.f13271a;
            }
        }

        static <T> Iterable<T> m19230a() {
            return f13272b;
        }
    }

    private class C3666b implements Comparable<C3666b>, Entry<K, V> {
        final /* synthetic */ C3661p f13273a;
        private final K f13274b;
        private V f13275c;

        public /* synthetic */ int compareTo(Object obj) {
            return m19233a((C3666b) obj);
        }

        public /* synthetic */ Object getKey() {
            return m19234a();
        }

        C3666b(C3661p c3661p, Entry<K, V> entry) {
            this(c3661p, (Comparable) entry.getKey(), entry.getValue());
        }

        C3666b(C3661p c3661p, K k, V v) {
            this.f13273a = c3661p;
            this.f13274b = k;
            this.f13275c = v;
        }

        public K m19234a() {
            return this.f13274b;
        }

        public V getValue() {
            return this.f13275c;
        }

        public int m19233a(C3666b c3666b) {
            return m19234a().compareTo(c3666b.m19234a());
        }

        public V setValue(V v) {
            this.f13273a.m19220e();
            V v2 = this.f13275c;
            this.f13275c = v;
            return v2;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            if (m19232a(this.f13274b, entry.getKey()) && m19232a(this.f13275c, entry.getValue())) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = this.f13274b == null ? 0 : this.f13274b.hashCode();
            if (this.f13275c != null) {
                i = this.f13275c.hashCode();
            }
            return hashCode ^ i;
        }

        public String toString() {
            return this.f13274b + "=" + this.f13275c;
        }

        private boolean m19232a(Object obj, Object obj2) {
            if (obj == null) {
                return obj2 == null;
            } else {
                return obj.equals(obj2);
            }
        }
    }

    private class C3667c implements Iterator<Entry<K, V>> {
        final /* synthetic */ C3661p f13276a;
        private int f13277b;
        private boolean f13278c;
        private Iterator<Entry<K, V>> f13279d;

        private C3667c(C3661p c3661p) {
            this.f13276a = c3661p;
            this.f13277b = -1;
        }

        public /* synthetic */ Object next() {
            return m19236a();
        }

        public boolean hasNext() {
            return this.f13277b + 1 < this.f13276a.f13267b.size() || m19235b().hasNext();
        }

        public Entry<K, V> m19236a() {
            this.f13278c = true;
            int i = this.f13277b + 1;
            this.f13277b = i;
            if (i < this.f13276a.f13267b.size()) {
                return (Entry) this.f13276a.f13267b.get(this.f13277b);
            }
            return (Entry) m19235b().next();
        }

        public void remove() {
            if (this.f13278c) {
                this.f13278c = false;
                this.f13276a.m19220e();
                if (this.f13277b < this.f13276a.f13267b.size()) {
                    C3661p c3661p = this.f13276a;
                    int i = this.f13277b;
                    this.f13277b = i - 1;
                    c3661p.m19218c(i);
                    return;
                }
                m19235b().remove();
                return;
            }
            throw new IllegalStateException("remove() was called before next()");
        }

        private Iterator<Entry<K, V>> m19235b() {
            if (this.f13279d == null) {
                this.f13279d = this.f13276a.f13268c.entrySet().iterator();
            }
            return this.f13279d;
        }
    }

    private class C3668d extends AbstractSet<Entry<K, V>> {
        final /* synthetic */ C3661p f13280a;

        private C3668d(C3661p c3661p) {
            this.f13280a = c3661p;
        }

        public /* synthetic */ boolean add(Object obj) {
            return m19237a((Entry) obj);
        }

        public Iterator<Entry<K, V>> iterator() {
            return new C3667c();
        }

        public int size() {
            return this.f13280a.size();
        }

        public boolean contains(Object obj) {
            Entry entry = (Entry) obj;
            Object obj2 = this.f13280a.get(entry.getKey());
            Object value = entry.getValue();
            return obj2 == value || (obj2 != null && obj2.equals(value));
        }

        public boolean m19237a(Entry<K, V> entry) {
            if (contains(entry)) {
                return false;
            }
            this.f13280a.m19223a((Comparable) entry.getKey(), entry.getValue());
            return true;
        }

        public boolean remove(Object obj) {
            Entry entry = (Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            this.f13280a.remove(entry.getKey());
            return true;
        }

        public void clear() {
            this.f13280a.clear();
        }
    }

    public /* synthetic */ Object put(Object obj, Object obj2) {
        return m19223a((Comparable) obj, obj2);
    }

    static <FieldDescriptorType extends C3630a<FieldDescriptorType>> C3661p<FieldDescriptorType, Object> m19214a(int i) {
        return new C3661p<FieldDescriptorType, Object>(i) {
            public /* synthetic */ Object put(Object obj, Object obj2) {
                return super.m19223a((C3630a) obj, obj2);
            }

            public void mo2764a() {
                if (!m19226b()) {
                    for (int i = 0; i < m19227c(); i++) {
                        Entry b = m19225b(i);
                        if (((C3630a) b.getKey()).mo2743b()) {
                            b.setValue(Collections.unmodifiableList((List) b.getValue()));
                        }
                    }
                    for (Entry entry : m19228d()) {
                        if (((C3630a) entry.getKey()).mo2743b()) {
                            entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                        }
                    }
                }
                super.mo2764a();
            }
        };
    }

    private C3661p(int i) {
        this.f13266a = i;
        this.f13267b = Collections.emptyList();
        this.f13268c = Collections.emptyMap();
    }

    public void mo2764a() {
        if (!this.f13269d) {
            this.f13268c = this.f13268c.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f13268c);
            this.f13269d = true;
        }
    }

    public boolean m19226b() {
        return this.f13269d;
    }

    public int m19227c() {
        return this.f13267b.size();
    }

    public Entry<K, V> m19225b(int i) {
        return (Entry) this.f13267b.get(i);
    }

    public Iterable<Entry<K, V>> m19228d() {
        return this.f13268c.isEmpty() ? C3665a.m19230a() : this.f13268c.entrySet();
    }

    public int size() {
        return this.f13267b.size() + this.f13268c.size();
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return m19213a(comparable) >= 0 || this.f13268c.containsKey(comparable);
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a = m19213a(comparable);
        if (a >= 0) {
            return ((C3666b) this.f13267b.get(a)).getValue();
        }
        return this.f13268c.get(comparable);
    }

    public V m19223a(K k, V v) {
        m19220e();
        int a = m19213a((Comparable) k);
        if (a >= 0) {
            return ((C3666b) this.f13267b.get(a)).setValue(v);
        }
        m19222g();
        int i = -(a + 1);
        if (i >= this.f13266a) {
            return m19221f().put(k, v);
        }
        if (this.f13267b.size() == this.f13266a) {
            C3666b c3666b = (C3666b) this.f13267b.remove(this.f13266a - 1);
            m19221f().put(c3666b.m19234a(), c3666b.getValue());
        }
        this.f13267b.add(i, new C3666b(this, k, v));
        return null;
    }

    public void clear() {
        m19220e();
        if (!this.f13267b.isEmpty()) {
            this.f13267b.clear();
        }
        if (!this.f13268c.isEmpty()) {
            this.f13268c.clear();
        }
    }

    public V remove(Object obj) {
        m19220e();
        Comparable comparable = (Comparable) obj;
        int a = m19213a(comparable);
        if (a >= 0) {
            return m19218c(a);
        }
        if (this.f13268c.isEmpty()) {
            return null;
        }
        return this.f13268c.remove(comparable);
    }

    private V m19218c(int i) {
        m19220e();
        V value = ((C3666b) this.f13267b.remove(i)).getValue();
        if (!this.f13268c.isEmpty()) {
            Iterator it = m19221f().entrySet().iterator();
            this.f13267b.add(new C3666b(this, (Entry) it.next()));
            it.remove();
        }
        return value;
    }

    private int m19213a(K k) {
        int compareTo;
        int i = 0;
        int size = this.f13267b.size() - 1;
        if (size >= 0) {
            compareTo = k.compareTo(((C3666b) this.f13267b.get(size)).m19234a());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        while (i <= size) {
            int i2 = (i + size) / 2;
            compareTo = k.compareTo(((C3666b) this.f13267b.get(i2)).m19234a());
            if (compareTo < 0) {
                compareTo = i2 - 1;
                size = i;
            } else if (compareTo <= 0) {
                return i2;
            } else {
                int i3 = size;
                size = i2 + 1;
                compareTo = i3;
            }
            i = size;
            size = compareTo;
        }
        return -(i + 1);
    }

    public Set<Entry<K, V>> entrySet() {
        if (this.f13270e == null) {
            this.f13270e = new C3668d();
        }
        return this.f13270e;
    }

    private void m19220e() {
        if (this.f13269d) {
            throw new UnsupportedOperationException();
        }
    }

    private SortedMap<K, V> m19221f() {
        m19220e();
        if (this.f13268c.isEmpty() && !(this.f13268c instanceof TreeMap)) {
            this.f13268c = new TreeMap();
        }
        return (SortedMap) this.f13268c;
    }

    private void m19222g() {
        m19220e();
        if (this.f13267b.isEmpty() && !(this.f13267b instanceof ArrayList)) {
            this.f13267b = new ArrayList(this.f13266a);
        }
    }
}
