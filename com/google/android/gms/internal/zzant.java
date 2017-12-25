package com.google.android.gms.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

public final class zzant<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean f11243a = (!zzant.class.desiredAssertionStatus());
    private static final Comparator<Comparable> f11244b = new C32811();
    Comparator<? super K> aPZ;
    zzd<K, V> beX;
    final zzd<K, V> beY;
    private zza beZ;
    private zzb bfa;
    int modCount;
    int size;

    static class C32811 implements Comparator<Comparable> {
        C32811() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return zza((Comparable) obj, (Comparable) obj2);
        }

        public int zza(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    private abstract class zzc<T> implements Iterator<T> {
        zzd<K, V> f11227b;
        zzd<K, V> f11228c;
        int f11229d;
        final /* synthetic */ zzant f11230e;

        private zzc(zzant com_google_android_gms_internal_zzant) {
            this.f11230e = com_google_android_gms_internal_zzant;
            this.f11227b = this.f11230e.beY.f11238d;
            this.f11228c = null;
            this.f11229d = this.f11230e.modCount;
        }

        final zzd<K, V> m17217a() {
            zzd<K, V> com_google_android_gms_internal_zzant_zzd_K__V = this.f11227b;
            if (com_google_android_gms_internal_zzant_zzd_K__V == this.f11230e.beY) {
                throw new NoSuchElementException();
            } else if (this.f11230e.modCount != this.f11229d) {
                throw new ConcurrentModificationException();
            } else {
                this.f11227b = com_google_android_gms_internal_zzant_zzd_K__V.f11238d;
                this.f11228c = com_google_android_gms_internal_zzant_zzd_K__V;
                return com_google_android_gms_internal_zzant_zzd_K__V;
            }
        }

        public final boolean hasNext() {
            return this.f11227b != this.f11230e.beY;
        }

        public final void remove() {
            if (this.f11228c == null) {
                throw new IllegalStateException();
            }
            this.f11230e.m17226a(this.f11228c, true);
            this.f11228c = null;
            this.f11229d = this.f11230e.modCount;
        }
    }

    class zza extends AbstractSet<Entry<K, V>> {
        final /* synthetic */ zzant f11232a;

        class C32821 extends zzc<Entry<K, V>> {
            final /* synthetic */ zza f11231a;

            C32821(zza com_google_android_gms_internal_zzant_zza) {
                this.f11231a = com_google_android_gms_internal_zzant_zza;
                super();
            }

            public Entry<K, V> next() {
                return m17217a();
            }
        }

        zza(zzant com_google_android_gms_internal_zzant) {
            this.f11232a = com_google_android_gms_internal_zzant;
        }

        public void clear() {
            this.f11232a.clear();
        }

        public boolean contains(Object obj) {
            return (obj instanceof Entry) && this.f11232a.m17225a((Entry) obj) != null;
        }

        public Iterator<Entry<K, V>> iterator() {
            return new C32821(this);
        }

        public boolean remove(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            zzd a = this.f11232a.m17225a((Entry) obj);
            if (a == null) {
                return false;
            }
            this.f11232a.m17226a(a, true);
            return true;
        }

        public int size() {
            return this.f11232a.size;
        }
    }

    final class zzb extends AbstractSet<K> {
        final /* synthetic */ zzant f11234a;

        class C32831 extends zzc<K> {
            final /* synthetic */ zzb f11233a;

            C32831(zzb com_google_android_gms_internal_zzant_zzb) {
                this.f11233a = com_google_android_gms_internal_zzant_zzb;
                super();
            }

            public K next() {
                return m17217a().f11240f;
            }
        }

        zzb(zzant com_google_android_gms_internal_zzant) {
            this.f11234a = com_google_android_gms_internal_zzant;
        }

        public void clear() {
            this.f11234a.clear();
        }

        public boolean contains(Object obj) {
            return this.f11234a.containsKey(obj);
        }

        public Iterator<K> iterator() {
            return new C32831(this);
        }

        public boolean remove(Object obj) {
            return this.f11234a.m17227b(obj) != null;
        }

        public int size() {
            return this.f11234a.size;
        }
    }

    static final class zzd<K, V> implements Entry<K, V> {
        zzd<K, V> f11235a;
        zzd<K, V> f11236b;
        zzd<K, V> f11237c;
        zzd<K, V> f11238d;
        zzd<K, V> f11239e;
        final K f11240f;
        V f11241g;
        int f11242h;

        zzd() {
            this.f11240f = null;
            this.f11239e = this;
            this.f11238d = this;
        }

        zzd(zzd<K, V> com_google_android_gms_internal_zzant_zzd_K__V, K k, zzd<K, V> com_google_android_gms_internal_zzant_zzd_K__V2, zzd<K, V> com_google_android_gms_internal_zzant_zzd_K__V3) {
            this.f11235a = com_google_android_gms_internal_zzant_zzd_K__V;
            this.f11240f = k;
            this.f11242h = 1;
            this.f11238d = com_google_android_gms_internal_zzant_zzd_K__V2;
            this.f11239e = com_google_android_gms_internal_zzant_zzd_K__V3;
            com_google_android_gms_internal_zzant_zzd_K__V3.f11238d = this;
            com_google_android_gms_internal_zzant_zzd_K__V2.f11239e = this;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            if (this.f11240f == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!this.f11240f.equals(entry.getKey())) {
                return false;
            }
            if (this.f11241g == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!this.f11241g.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        public K getKey() {
            return this.f11240f;
        }

        public V getValue() {
            return this.f11241g;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = this.f11240f == null ? 0 : this.f11240f.hashCode();
            if (this.f11241g != null) {
                i = this.f11241g.hashCode();
            }
            return hashCode ^ i;
        }

        public V setValue(V v) {
            V v2 = this.f11241g;
            this.f11241g = v;
            return v2;
        }

        public String toString() {
            String valueOf = String.valueOf(this.f11240f);
            String valueOf2 = String.valueOf(this.f11241g);
            return new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(valueOf2).length()).append(valueOf).append("=").append(valueOf2).toString();
        }

        public zzd<K, V> zzczx() {
            zzd<K, V> com_google_android_gms_internal_zzant_zzd_K__V;
            for (zzd<K, V> com_google_android_gms_internal_zzant_zzd_K__V2 = this.f11236b; com_google_android_gms_internal_zzant_zzd_K__V2 != null; com_google_android_gms_internal_zzant_zzd_K__V2 = com_google_android_gms_internal_zzant_zzd_K__V2.f11236b) {
                com_google_android_gms_internal_zzant_zzd_K__V = com_google_android_gms_internal_zzant_zzd_K__V2;
            }
            return com_google_android_gms_internal_zzant_zzd_K__V;
        }

        public zzd<K, V> zzczy() {
            zzd<K, V> com_google_android_gms_internal_zzant_zzd_K__V;
            for (zzd<K, V> com_google_android_gms_internal_zzant_zzd_K__V2 = this.f11237c; com_google_android_gms_internal_zzant_zzd_K__V2 != null; com_google_android_gms_internal_zzant_zzd_K__V2 = com_google_android_gms_internal_zzant_zzd_K__V2.f11237c) {
                com_google_android_gms_internal_zzant_zzd_K__V = com_google_android_gms_internal_zzant_zzd_K__V2;
            }
            return com_google_android_gms_internal_zzant_zzd_K__V;
        }
    }

    public zzant() {
        this(f11244b);
    }

    public zzant(Comparator<? super K> comparator) {
        Comparator comparator2;
        this.size = 0;
        this.modCount = 0;
        this.beY = new zzd();
        if (comparator == null) {
            comparator2 = f11244b;
        }
        this.aPZ = comparator2;
    }

    private void m17218a(zzd<K, V> com_google_android_gms_internal_zzant_zzd_K__V) {
        int i = 0;
        zzd com_google_android_gms_internal_zzant_zzd = com_google_android_gms_internal_zzant_zzd_K__V.f11236b;
        zzd com_google_android_gms_internal_zzant_zzd2 = com_google_android_gms_internal_zzant_zzd_K__V.f11237c;
        zzd com_google_android_gms_internal_zzant_zzd3 = com_google_android_gms_internal_zzant_zzd2.f11236b;
        zzd com_google_android_gms_internal_zzant_zzd4 = com_google_android_gms_internal_zzant_zzd2.f11237c;
        com_google_android_gms_internal_zzant_zzd_K__V.f11237c = com_google_android_gms_internal_zzant_zzd3;
        if (com_google_android_gms_internal_zzant_zzd3 != null) {
            com_google_android_gms_internal_zzant_zzd3.f11235a = com_google_android_gms_internal_zzant_zzd_K__V;
        }
        m17219a((zzd) com_google_android_gms_internal_zzant_zzd_K__V, com_google_android_gms_internal_zzant_zzd2);
        com_google_android_gms_internal_zzant_zzd2.f11236b = com_google_android_gms_internal_zzant_zzd_K__V;
        com_google_android_gms_internal_zzant_zzd_K__V.f11235a = com_google_android_gms_internal_zzant_zzd2;
        com_google_android_gms_internal_zzant_zzd_K__V.f11242h = Math.max(com_google_android_gms_internal_zzant_zzd != null ? com_google_android_gms_internal_zzant_zzd.f11242h : 0, com_google_android_gms_internal_zzant_zzd3 != null ? com_google_android_gms_internal_zzant_zzd3.f11242h : 0) + 1;
        int i2 = com_google_android_gms_internal_zzant_zzd_K__V.f11242h;
        if (com_google_android_gms_internal_zzant_zzd4 != null) {
            i = com_google_android_gms_internal_zzant_zzd4.f11242h;
        }
        com_google_android_gms_internal_zzant_zzd2.f11242h = Math.max(i2, i) + 1;
    }

    private void m17219a(zzd<K, V> com_google_android_gms_internal_zzant_zzd_K__V, zzd<K, V> com_google_android_gms_internal_zzant_zzd_K__V2) {
        zzd com_google_android_gms_internal_zzant_zzd = com_google_android_gms_internal_zzant_zzd_K__V.f11235a;
        com_google_android_gms_internal_zzant_zzd_K__V.f11235a = null;
        if (com_google_android_gms_internal_zzant_zzd_K__V2 != null) {
            com_google_android_gms_internal_zzant_zzd_K__V2.f11235a = com_google_android_gms_internal_zzant_zzd;
        }
        if (com_google_android_gms_internal_zzant_zzd == null) {
            this.beX = com_google_android_gms_internal_zzant_zzd_K__V2;
        } else if (com_google_android_gms_internal_zzant_zzd.f11236b == com_google_android_gms_internal_zzant_zzd_K__V) {
            com_google_android_gms_internal_zzant_zzd.f11236b = com_google_android_gms_internal_zzant_zzd_K__V2;
        } else if (f11243a || com_google_android_gms_internal_zzant_zzd.f11237c == com_google_android_gms_internal_zzant_zzd_K__V) {
            com_google_android_gms_internal_zzant_zzd.f11237c = com_google_android_gms_internal_zzant_zzd_K__V2;
        } else {
            throw new AssertionError();
        }
    }

    private boolean m17220a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void m17221b(zzd<K, V> com_google_android_gms_internal_zzant_zzd_K__V) {
        int i = 0;
        zzd com_google_android_gms_internal_zzant_zzd = com_google_android_gms_internal_zzant_zzd_K__V.f11236b;
        zzd com_google_android_gms_internal_zzant_zzd2 = com_google_android_gms_internal_zzant_zzd_K__V.f11237c;
        zzd com_google_android_gms_internal_zzant_zzd3 = com_google_android_gms_internal_zzant_zzd.f11236b;
        zzd com_google_android_gms_internal_zzant_zzd4 = com_google_android_gms_internal_zzant_zzd.f11237c;
        com_google_android_gms_internal_zzant_zzd_K__V.f11236b = com_google_android_gms_internal_zzant_zzd4;
        if (com_google_android_gms_internal_zzant_zzd4 != null) {
            com_google_android_gms_internal_zzant_zzd4.f11235a = com_google_android_gms_internal_zzant_zzd_K__V;
        }
        m17219a((zzd) com_google_android_gms_internal_zzant_zzd_K__V, com_google_android_gms_internal_zzant_zzd);
        com_google_android_gms_internal_zzant_zzd.f11237c = com_google_android_gms_internal_zzant_zzd_K__V;
        com_google_android_gms_internal_zzant_zzd_K__V.f11235a = com_google_android_gms_internal_zzant_zzd;
        com_google_android_gms_internal_zzant_zzd_K__V.f11242h = Math.max(com_google_android_gms_internal_zzant_zzd2 != null ? com_google_android_gms_internal_zzant_zzd2.f11242h : 0, com_google_android_gms_internal_zzant_zzd4 != null ? com_google_android_gms_internal_zzant_zzd4.f11242h : 0) + 1;
        int i2 = com_google_android_gms_internal_zzant_zzd_K__V.f11242h;
        if (com_google_android_gms_internal_zzant_zzd3 != null) {
            i = com_google_android_gms_internal_zzant_zzd3.f11242h;
        }
        com_google_android_gms_internal_zzant_zzd.f11242h = Math.max(i2, i) + 1;
    }

    private void m17222b(zzd<K, V> com_google_android_gms_internal_zzant_zzd_K__V, boolean z) {
        zzd com_google_android_gms_internal_zzant_zzd;
        while (com_google_android_gms_internal_zzant_zzd != null) {
            zzd com_google_android_gms_internal_zzant_zzd2 = com_google_android_gms_internal_zzant_zzd.f11236b;
            zzd com_google_android_gms_internal_zzant_zzd3 = com_google_android_gms_internal_zzant_zzd.f11237c;
            int i = com_google_android_gms_internal_zzant_zzd2 != null ? com_google_android_gms_internal_zzant_zzd2.f11242h : 0;
            int i2 = com_google_android_gms_internal_zzant_zzd3 != null ? com_google_android_gms_internal_zzant_zzd3.f11242h : 0;
            int i3 = i - i2;
            zzd com_google_android_gms_internal_zzant_zzd4;
            if (i3 == -2) {
                com_google_android_gms_internal_zzant_zzd2 = com_google_android_gms_internal_zzant_zzd3.f11236b;
                com_google_android_gms_internal_zzant_zzd4 = com_google_android_gms_internal_zzant_zzd3.f11237c;
                i2 = (com_google_android_gms_internal_zzant_zzd2 != null ? com_google_android_gms_internal_zzant_zzd2.f11242h : 0) - (com_google_android_gms_internal_zzant_zzd4 != null ? com_google_android_gms_internal_zzant_zzd4.f11242h : 0);
                if (i2 == -1 || (i2 == 0 && !z)) {
                    m17218a(com_google_android_gms_internal_zzant_zzd);
                } else if (f11243a || i2 == 1) {
                    m17221b(com_google_android_gms_internal_zzant_zzd3);
                    m17218a(com_google_android_gms_internal_zzant_zzd);
                } else {
                    throw new AssertionError();
                }
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                com_google_android_gms_internal_zzant_zzd3 = com_google_android_gms_internal_zzant_zzd2.f11236b;
                com_google_android_gms_internal_zzant_zzd4 = com_google_android_gms_internal_zzant_zzd2.f11237c;
                i2 = (com_google_android_gms_internal_zzant_zzd3 != null ? com_google_android_gms_internal_zzant_zzd3.f11242h : 0) - (com_google_android_gms_internal_zzant_zzd4 != null ? com_google_android_gms_internal_zzant_zzd4.f11242h : 0);
                if (i2 == 1 || (i2 == 0 && !z)) {
                    m17221b(com_google_android_gms_internal_zzant_zzd);
                } else if (f11243a || i2 == -1) {
                    m17218a(com_google_android_gms_internal_zzant_zzd2);
                    m17221b(com_google_android_gms_internal_zzant_zzd);
                } else {
                    throw new AssertionError();
                }
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                com_google_android_gms_internal_zzant_zzd.f11242h = i + 1;
                if (z) {
                    return;
                }
            } else if (f11243a || i3 == -1 || i3 == 1) {
                com_google_android_gms_internal_zzant_zzd.f11242h = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            } else {
                throw new AssertionError();
            }
            com_google_android_gms_internal_zzant_zzd = com_google_android_gms_internal_zzant_zzd.f11235a;
        }
    }

    zzd<K, V> m17223a(Object obj) {
        zzd<K, V> com_google_android_gms_internal_zzant_zzd_K__V = null;
        if (obj != null) {
            try {
                com_google_android_gms_internal_zzant_zzd_K__V = m17224a(obj, false);
            } catch (ClassCastException e) {
            }
        }
        return com_google_android_gms_internal_zzant_zzd_K__V;
    }

    zzd<K, V> m17224a(K k, boolean z) {
        int i;
        Comparator comparator = this.aPZ;
        zzd<K, V> com_google_android_gms_internal_zzant_zzd_K__V = this.beX;
        if (com_google_android_gms_internal_zzant_zzd_K__V != null) {
            int compareTo;
            Comparable comparable = comparator == f11244b ? (Comparable) k : null;
            while (true) {
                compareTo = comparable != null ? comparable.compareTo(com_google_android_gms_internal_zzant_zzd_K__V.f11240f) : comparator.compare(k, com_google_android_gms_internal_zzant_zzd_K__V.f11240f);
                if (compareTo == 0) {
                    return com_google_android_gms_internal_zzant_zzd_K__V;
                }
                zzd<K, V> com_google_android_gms_internal_zzant_zzd_K__V2 = compareTo < 0 ? com_google_android_gms_internal_zzant_zzd_K__V.f11236b : com_google_android_gms_internal_zzant_zzd_K__V.f11237c;
                if (com_google_android_gms_internal_zzant_zzd_K__V2 == null) {
                    break;
                }
                com_google_android_gms_internal_zzant_zzd_K__V = com_google_android_gms_internal_zzant_zzd_K__V2;
            }
            int i2 = compareTo;
            zzd com_google_android_gms_internal_zzant_zzd = com_google_android_gms_internal_zzant_zzd_K__V;
            i = i2;
        } else {
            zzd<K, V> com_google_android_gms_internal_zzant_zzd_K__V3 = com_google_android_gms_internal_zzant_zzd_K__V;
            i = 0;
        }
        if (!z) {
            return null;
        }
        zzd<K, V> com_google_android_gms_internal_zzant_zzd2;
        zzd com_google_android_gms_internal_zzant_zzd3 = this.beY;
        if (com_google_android_gms_internal_zzant_zzd != null) {
            com_google_android_gms_internal_zzant_zzd2 = new zzd(com_google_android_gms_internal_zzant_zzd, k, com_google_android_gms_internal_zzant_zzd3, com_google_android_gms_internal_zzant_zzd3.f11239e);
            if (i < 0) {
                com_google_android_gms_internal_zzant_zzd.f11236b = com_google_android_gms_internal_zzant_zzd2;
            } else {
                com_google_android_gms_internal_zzant_zzd.f11237c = com_google_android_gms_internal_zzant_zzd2;
            }
            m17222b(com_google_android_gms_internal_zzant_zzd, true);
        } else if (comparator != f11244b || (k instanceof Comparable)) {
            com_google_android_gms_internal_zzant_zzd2 = new zzd(com_google_android_gms_internal_zzant_zzd, k, com_google_android_gms_internal_zzant_zzd3, com_google_android_gms_internal_zzant_zzd3.f11239e);
            this.beX = com_google_android_gms_internal_zzant_zzd2;
        } else {
            throw new ClassCastException(String.valueOf(k.getClass().getName()).concat(" is not Comparable"));
        }
        this.size++;
        this.modCount++;
        return com_google_android_gms_internal_zzant_zzd2;
    }

    zzd<K, V> m17225a(Entry<?, ?> entry) {
        zzd<K, V> a = m17223a(entry.getKey());
        Object obj = (a == null || !m17220a(a.f11241g, entry.getValue())) ? null : 1;
        return obj != null ? a : null;
    }

    void m17226a(zzd<K, V> com_google_android_gms_internal_zzant_zzd_K__V, boolean z) {
        int i = 0;
        if (z) {
            com_google_android_gms_internal_zzant_zzd_K__V.f11239e.f11238d = com_google_android_gms_internal_zzant_zzd_K__V.f11238d;
            com_google_android_gms_internal_zzant_zzd_K__V.f11238d.f11239e = com_google_android_gms_internal_zzant_zzd_K__V.f11239e;
        }
        zzd com_google_android_gms_internal_zzant_zzd = com_google_android_gms_internal_zzant_zzd_K__V.f11236b;
        zzd com_google_android_gms_internal_zzant_zzd2 = com_google_android_gms_internal_zzant_zzd_K__V.f11237c;
        zzd com_google_android_gms_internal_zzant_zzd3 = com_google_android_gms_internal_zzant_zzd_K__V.f11235a;
        if (com_google_android_gms_internal_zzant_zzd == null || com_google_android_gms_internal_zzant_zzd2 == null) {
            if (com_google_android_gms_internal_zzant_zzd != null) {
                m17219a((zzd) com_google_android_gms_internal_zzant_zzd_K__V, com_google_android_gms_internal_zzant_zzd);
                com_google_android_gms_internal_zzant_zzd_K__V.f11236b = null;
            } else if (com_google_android_gms_internal_zzant_zzd2 != null) {
                m17219a((zzd) com_google_android_gms_internal_zzant_zzd_K__V, com_google_android_gms_internal_zzant_zzd2);
                com_google_android_gms_internal_zzant_zzd_K__V.f11237c = null;
            } else {
                m17219a((zzd) com_google_android_gms_internal_zzant_zzd_K__V, null);
            }
            m17222b(com_google_android_gms_internal_zzant_zzd3, false);
            this.size--;
            this.modCount++;
            return;
        }
        int i2;
        com_google_android_gms_internal_zzant_zzd = com_google_android_gms_internal_zzant_zzd.f11242h > com_google_android_gms_internal_zzant_zzd2.f11242h ? com_google_android_gms_internal_zzant_zzd.zzczy() : com_google_android_gms_internal_zzant_zzd2.zzczx();
        m17226a(com_google_android_gms_internal_zzant_zzd, false);
        com_google_android_gms_internal_zzant_zzd3 = com_google_android_gms_internal_zzant_zzd_K__V.f11236b;
        if (com_google_android_gms_internal_zzant_zzd3 != null) {
            i2 = com_google_android_gms_internal_zzant_zzd3.f11242h;
            com_google_android_gms_internal_zzant_zzd.f11236b = com_google_android_gms_internal_zzant_zzd3;
            com_google_android_gms_internal_zzant_zzd3.f11235a = com_google_android_gms_internal_zzant_zzd;
            com_google_android_gms_internal_zzant_zzd_K__V.f11236b = null;
        } else {
            i2 = 0;
        }
        com_google_android_gms_internal_zzant_zzd3 = com_google_android_gms_internal_zzant_zzd_K__V.f11237c;
        if (com_google_android_gms_internal_zzant_zzd3 != null) {
            i = com_google_android_gms_internal_zzant_zzd3.f11242h;
            com_google_android_gms_internal_zzant_zzd.f11237c = com_google_android_gms_internal_zzant_zzd3;
            com_google_android_gms_internal_zzant_zzd3.f11235a = com_google_android_gms_internal_zzant_zzd;
            com_google_android_gms_internal_zzant_zzd_K__V.f11237c = null;
        }
        com_google_android_gms_internal_zzant_zzd.f11242h = Math.max(i2, i) + 1;
        m17219a((zzd) com_google_android_gms_internal_zzant_zzd_K__V, com_google_android_gms_internal_zzant_zzd);
    }

    zzd<K, V> m17227b(Object obj) {
        zzd a = m17223a(obj);
        if (a != null) {
            m17226a(a, true);
        }
        return a;
    }

    public void clear() {
        this.beX = null;
        this.size = 0;
        this.modCount++;
        zzd com_google_android_gms_internal_zzant_zzd = this.beY;
        com_google_android_gms_internal_zzant_zzd.f11239e = com_google_android_gms_internal_zzant_zzd;
        com_google_android_gms_internal_zzant_zzd.f11238d = com_google_android_gms_internal_zzant_zzd;
    }

    public boolean containsKey(Object obj) {
        return m17223a(obj) != null;
    }

    public Set<Entry<K, V>> entrySet() {
        Set set = this.beZ;
        if (set != null) {
            return set;
        }
        set = new zza(this);
        this.beZ = set;
        return set;
    }

    public V get(Object obj) {
        zzd a = m17223a(obj);
        return a != null ? a.f11241g : null;
    }

    public Set<K> keySet() {
        Set set = this.bfa;
        if (set != null) {
            return set;
        }
        set = new zzb(this);
        this.bfa = set;
        return set;
    }

    public V put(K k, V v) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        zzd a = m17224a((Object) k, true);
        V v2 = a.f11241g;
        a.f11241g = v;
        return v2;
    }

    public V remove(Object obj) {
        zzd b = m17227b(obj);
        return b != null ? b.f11241g : null;
    }

    public int size() {
        return this.size;
    }
}
