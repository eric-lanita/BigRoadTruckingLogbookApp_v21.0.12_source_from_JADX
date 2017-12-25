package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map.Entry;

final class RegularImmutableMap<K, V> extends ImmutableMap<K, V> {
    static final ImmutableMap<Object, Object> f13048b = new RegularImmutableMap(null, new Object[0], 0);
    private static final long serialVersionUID = 0;
    private final transient int[] f13049c;
    private final transient Object[] f13050d;
    private final transient int f13051e;

    static class EntrySet<K, V> extends ImmutableSet<Entry<K, V>> {
        private final transient ImmutableMap<K, V> f13039a;
        private final transient Object[] f13040b;
        private final transient int f13041c;
        private final transient int f13042d;

        class C35801 extends ImmutableList<Entry<K, V>> {
            C35801() {
            }

            public /* synthetic */ Object get(int i) {
                return m18704b(i);
            }

            public Entry<K, V> m18704b(int i) {
                Preconditions.checkElementIndex(i, EntrySet.this.f13042d);
                return new SimpleImmutableEntry(EntrySet.this.f13040b[(i * 2) + EntrySet.this.f13041c], EntrySet.this.f13040b[(i * 2) + (EntrySet.this.f13041c ^ 1)]);
            }

            public int size() {
                return EntrySet.this.f13042d;
            }

            public boolean mo2690c() {
                return true;
            }
        }

        public /* synthetic */ Iterator iterator() {
            return mo2684a();
        }

        EntrySet(ImmutableMap<K, V> immutableMap, Object[] objArr, int i, int i2) {
            this.f13039a = immutableMap;
            this.f13040b = objArr;
            this.f13041c = i;
            this.f13042d = i2;
        }

        public ab<Entry<K, V>> mo2684a() {
            return mo2685b().mo2684a();
        }

        ImmutableList<Entry<K, V>> mo2711f() {
            return new C35801();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value == null || !value.equals(this.f13039a.get(key))) {
                return false;
            }
            return true;
        }

        boolean mo2690c() {
            return true;
        }

        public int size() {
            return this.f13042d;
        }
    }

    static final class KeySet<K> extends ImmutableSet<K> {
        private final transient ImmutableMap<K, ?> f13043a;
        private final transient ImmutableList<K> f13044b;

        public /* synthetic */ Iterator iterator() {
            return mo2684a();
        }

        KeySet(ImmutableMap<K, ?> immutableMap, ImmutableList<K> immutableList) {
            this.f13043a = immutableMap;
            this.f13044b = immutableList;
        }

        public ab<K> mo2684a() {
            return mo2685b().mo2684a();
        }

        public ImmutableList<K> mo2685b() {
            return this.f13044b;
        }

        public boolean contains(Object obj) {
            return this.f13043a.get(obj) != null;
        }

        boolean mo2690c() {
            return true;
        }

        public int size() {
            return this.f13043a.size();
        }
    }

    static final class KeysOrValuesAsList extends ImmutableList<Object> {
        private final transient Object[] f13045a;
        private final transient int f13046b;
        private final transient int f13047c;

        KeysOrValuesAsList(Object[] objArr, int i, int i2) {
            this.f13045a = objArr;
            this.f13046b = i;
            this.f13047c = i2;
        }

        public Object get(int i) {
            Preconditions.checkElementIndex(i, this.f13047c);
            return this.f13045a[(i * 2) + this.f13046b];
        }

        boolean mo2690c() {
            return true;
        }

        public int size() {
            return this.f13047c;
        }
    }

    static <K, V> RegularImmutableMap<K, V> m18716a(int i, Object[] objArr) {
        if (i == 0) {
            return (RegularImmutableMap) f13048b;
        }
        if (i == 1) {
            C3587d.m18768a(objArr[0], objArr[1]);
            return new RegularImmutableMap(null, objArr, 1);
        }
        Preconditions.checkPositionIndex(i, objArr.length >> 1);
        return new RegularImmutableMap(m18718a(objArr, i, ImmutableSet.m18564a(i), 0), objArr, i);
    }

    static int[] m18718a(Object[] objArr, int i, int i2, int i3) {
        if (i == 1) {
            C3587d.m18768a(objArr[i3], objArr[i3 ^ 1]);
            return null;
        }
        int i4 = i2 - 1;
        int[] iArr = new int[i2];
        Arrays.fill(iArr, -1);
        for (int i5 = 0; i5 < i; i5++) {
            Object obj = objArr[(i5 * 2) + i3];
            Object obj2 = objArr[(i5 * 2) + (i3 ^ 1)];
            C3587d.m18768a(obj, obj2);
            int a = C3594m.m18803a(obj.hashCode());
            while (true) {
                a &= i4;
                int i6 = iArr[a];
                if (i6 == -1) {
                    break;
                } else if (objArr[i6].equals(obj)) {
                    throw new IllegalArgumentException("Multiple entries with same key: " + obj + "=" + obj2 + " and " + objArr[i6] + "=" + objArr[i6 ^ 1]);
                } else {
                    a++;
                }
            }
            iArr[a] = (i5 * 2) + i3;
        }
        return iArr;
    }

    private RegularImmutableMap(int[] iArr, Object[] objArr, int i) {
        this.f13049c = iArr;
        this.f13050d = objArr;
        this.f13051e = i;
    }

    public int size() {
        return this.f13051e;
    }

    public V get(Object obj) {
        return m18717a(this.f13049c, this.f13050d, this.f13051e, 0, obj);
    }

    static Object m18717a(int[] iArr, Object[] objArr, int i, int i2, Object obj) {
        if (obj == null) {
            return null;
        }
        if (i == 1) {
            if (objArr[i2].equals(obj)) {
                return objArr[i2 ^ 1];
            }
            return null;
        } else if (iArr == null) {
            return null;
        } else {
            int length = iArr.length - 1;
            int a = C3594m.m18803a(obj.hashCode());
            while (true) {
                a &= length;
                int i3 = iArr[a];
                if (i3 == -1) {
                    return null;
                }
                if (objArr[i3].equals(obj)) {
                    return objArr[i3 ^ 1];
                }
                a++;
            }
        }
    }

    ImmutableSet<Entry<K, V>> mo2712b() {
        return new EntrySet(this, this.f13050d, 0, this.f13051e);
    }

    ImmutableSet<K> mo2713d() {
        return new KeySet(this, new KeysOrValuesAsList(this.f13050d, 0, this.f13051e));
    }

    ImmutableCollection<V> mo2714f() {
        return new KeysOrValuesAsList(this.f13050d, 1, this.f13051e);
    }

    boolean mo2715g() {
        return false;
    }
}
