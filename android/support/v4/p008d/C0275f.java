package android.support.v4.p008d;

import java.util.LinkedHashMap;
import java.util.Map;

public class C0275f<K, V> {
    private final LinkedHashMap<K, V> f808a;
    private int f809b;
    private int f810c;
    private int f811d;
    private int f812e;
    private int f813f;
    private int f814g;
    private int f815h;

    public C0275f(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f810c = i;
        this.f808a = new LinkedHashMap(0, 0.75f, true);
    }

    public void resize(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        synchronized (this) {
            this.f810c = i;
        }
        trimToSize(i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final V get(K r5) {
        /*
        r4 = this;
        if (r5 != 0) goto L_0x000a;
    L_0x0002:
        r0 = new java.lang.NullPointerException;
        r1 = "key == null";
        r0.<init>(r1);
        throw r0;
    L_0x000a:
        monitor-enter(r4);
        r0 = r4.f808a;	 Catch:{ all -> 0x002a }
        r0 = r0.get(r5);	 Catch:{ all -> 0x002a }
        if (r0 == 0) goto L_0x001b;
    L_0x0013:
        r1 = r4.f814g;	 Catch:{ all -> 0x002a }
        r1 = r1 + 1;
        r4.f814g = r1;	 Catch:{ all -> 0x002a }
        monitor-exit(r4);	 Catch:{ all -> 0x002a }
    L_0x001a:
        return r0;
    L_0x001b:
        r0 = r4.f815h;	 Catch:{ all -> 0x002a }
        r0 = r0 + 1;
        r4.f815h = r0;	 Catch:{ all -> 0x002a }
        monitor-exit(r4);	 Catch:{ all -> 0x002a }
        r1 = r4.m1173a(r5);
        if (r1 != 0) goto L_0x002d;
    L_0x0028:
        r0 = 0;
        goto L_0x001a;
    L_0x002a:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x002a }
        throw r0;
    L_0x002d:
        monitor-enter(r4);
        r0 = r4.f812e;	 Catch:{ all -> 0x0053 }
        r0 = r0 + 1;
        r4.f812e = r0;	 Catch:{ all -> 0x0053 }
        r0 = r4.f808a;	 Catch:{ all -> 0x0053 }
        r0 = r0.put(r5, r1);	 Catch:{ all -> 0x0053 }
        if (r0 == 0) goto L_0x0049;
    L_0x003c:
        r2 = r4.f808a;	 Catch:{ all -> 0x0053 }
        r2.put(r5, r0);	 Catch:{ all -> 0x0053 }
    L_0x0041:
        monitor-exit(r4);	 Catch:{ all -> 0x0053 }
        if (r0 == 0) goto L_0x0056;
    L_0x0044:
        r2 = 0;
        r4.mo1666a(r2, r5, r1, r0);
        goto L_0x001a;
    L_0x0049:
        r2 = r4.f809b;	 Catch:{ all -> 0x0053 }
        r3 = r4.m1171b(r5, r1);	 Catch:{ all -> 0x0053 }
        r2 = r2 + r3;
        r4.f809b = r2;	 Catch:{ all -> 0x0053 }
        goto L_0x0041;
    L_0x0053:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0053 }
        throw r0;
    L_0x0056:
        r0 = r4.f810c;
        r4.trimToSize(r0);
        r0 = r1;
        goto L_0x001a;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.d.f.get(java.lang.Object):V");
    }

    public final V put(K k, V v) {
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        V put;
        synchronized (this) {
            this.f811d++;
            this.f809b += m1171b(k, v);
            put = this.f808a.put(k, v);
            if (put != null) {
                this.f809b -= m1171b(k, put);
            }
        }
        if (put != null) {
            mo1666a(false, k, put, v);
        }
        trimToSize(this.f810c);
        return put;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void trimToSize(int r5) {
        /*
        r4 = this;
    L_0x0000:
        monitor-enter(r4);
        r0 = r4.f809b;	 Catch:{ all -> 0x0032 }
        if (r0 < 0) goto L_0x0011;
    L_0x0005:
        r0 = r4.f808a;	 Catch:{ all -> 0x0032 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0032 }
        if (r0 == 0) goto L_0x0035;
    L_0x000d:
        r0 = r4.f809b;	 Catch:{ all -> 0x0032 }
        if (r0 == 0) goto L_0x0035;
    L_0x0011:
        r0 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0032 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0032 }
        r1.<init>();	 Catch:{ all -> 0x0032 }
        r2 = r4.getClass();	 Catch:{ all -> 0x0032 }
        r2 = r2.getName();	 Catch:{ all -> 0x0032 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x0032 }
        r2 = ".sizeOf() is reporting inconsistent results!";
        r1 = r1.append(r2);	 Catch:{ all -> 0x0032 }
        r1 = r1.toString();	 Catch:{ all -> 0x0032 }
        r0.<init>(r1);	 Catch:{ all -> 0x0032 }
        throw r0;	 Catch:{ all -> 0x0032 }
    L_0x0032:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0032 }
        throw r0;
    L_0x0035:
        r0 = r4.f809b;	 Catch:{ all -> 0x0032 }
        if (r0 <= r5) goto L_0x0041;
    L_0x0039:
        r0 = r4.f808a;	 Catch:{ all -> 0x0032 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0032 }
        if (r0 == 0) goto L_0x0043;
    L_0x0041:
        monitor-exit(r4);	 Catch:{ all -> 0x0032 }
        return;
    L_0x0043:
        r0 = r4.f808a;	 Catch:{ all -> 0x0032 }
        r0 = r0.entrySet();	 Catch:{ all -> 0x0032 }
        r0 = r0.iterator();	 Catch:{ all -> 0x0032 }
        r0 = r0.next();	 Catch:{ all -> 0x0032 }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ all -> 0x0032 }
        r1 = r0.getKey();	 Catch:{ all -> 0x0032 }
        r0 = r0.getValue();	 Catch:{ all -> 0x0032 }
        r2 = r4.f808a;	 Catch:{ all -> 0x0032 }
        r2.remove(r1);	 Catch:{ all -> 0x0032 }
        r2 = r4.f809b;	 Catch:{ all -> 0x0032 }
        r3 = r4.m1171b(r1, r0);	 Catch:{ all -> 0x0032 }
        r2 = r2 - r3;
        r4.f809b = r2;	 Catch:{ all -> 0x0032 }
        r2 = r4.f813f;	 Catch:{ all -> 0x0032 }
        r2 = r2 + 1;
        r4.f813f = r2;	 Catch:{ all -> 0x0032 }
        monitor-exit(r4);	 Catch:{ all -> 0x0032 }
        r2 = 1;
        r3 = 0;
        r4.mo1666a(r2, r1, r0, r3);
        goto L_0x0000;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.d.f.trimToSize(int):void");
    }

    public final V remove(K k) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        V remove;
        synchronized (this) {
            remove = this.f808a.remove(k);
            if (remove != null) {
                this.f809b -= m1171b(k, remove);
            }
        }
        if (remove != null) {
            mo1666a(false, k, remove, null);
        }
        return remove;
    }

    protected void mo1666a(boolean z, K k, V v, V v2) {
    }

    protected V m1173a(K k) {
        return null;
    }

    private int m1171b(K k, V v) {
        int a = mo1665a(k, v);
        if (a >= 0) {
            return a;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    protected int mo1665a(K k, V v) {
        return 1;
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final synchronized int size() {
        return this.f809b;
    }

    public final synchronized int maxSize() {
        return this.f810c;
    }

    public final synchronized int hitCount() {
        return this.f814g;
    }

    public final synchronized int missCount() {
        return this.f815h;
    }

    public final synchronized int createCount() {
        return this.f812e;
    }

    public final synchronized int putCount() {
        return this.f811d;
    }

    public final synchronized int evictionCount() {
        return this.f813f;
    }

    public final synchronized Map<K, V> snapshot() {
        return new LinkedHashMap(this.f808a);
    }

    public final synchronized String toString() {
        String format;
        int i = 0;
        synchronized (this) {
            int i2 = this.f814g + this.f815h;
            if (i2 != 0) {
                i = (this.f814g * 100) / i2;
            }
            format = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.f810c), Integer.valueOf(this.f814g), Integer.valueOf(this.f815h), Integer.valueOf(i)});
        }
        return format;
    }
}
