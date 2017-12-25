package com.bigroad.ttb.android.eobr.vna;

import com.bigroad.ttb.android.eobr.RpmSource;
import com.bigroad.ttb.android.logging.C2134e;
import com.google.common.base.Predicate;
import com.google.common.collect.C3600n;
import com.google.common.collect.EvictingQueue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class C1995c {
    private static final Predicate<Integer> f6882a = new C19931();
    private static final Predicate<Integer> f6883b = new C19942();
    private final C2006i f6884c;
    private EvictingQueue<Integer>[] f6885d = new EvictingQueue[RpmSource.values().length];
    private EvictingQueue<Integer> f6886e = EvictingQueue.m18488a(5);
    private long f6887f;
    private long f6888g;

    static class C19931 implements Predicate<Integer> {
        C19931() {
        }

        public /* synthetic */ boolean apply(Object obj) {
            return m9875a((Integer) obj);
        }

        public boolean m9875a(Integer num) {
            return num != null && num.intValue() >= 100 && num.intValue() < 65535;
        }
    }

    static class C19942 implements Predicate<Integer> {
        C19942() {
        }

        public /* synthetic */ boolean apply(Object obj) {
            return m9876a((Integer) obj);
        }

        public boolean m9876a(Integer num) {
            return (num == null || num.intValue() == 65535) ? false : true;
        }
    }

    public C1995c(C2006i c2006i) {
        int i = 0;
        this.f6884c = c2006i;
        for (RpmSource ordinal : RpmSource.values()) {
            this.f6885d[ordinal.ordinal()] = EvictingQueue.m18488a(16);
        }
        while (i < 5) {
            this.f6886e.add(Integer.valueOf(65535));
            i++;
        }
    }

    synchronized void m9879a(RpmSource rpmSource, int i) {
        if (i < 65535) {
            this.f6885d[rpmSource.ordinal()].add(Integer.valueOf(i));
        }
    }

    synchronized void m9878a(long j, long j2) {
        long j3 = 0;
        synchronized (this) {
            boolean b;
            boolean a;
            C2006i c2006i;
            int i;
            if (m9877a(j2) > 0) {
                this.f6884c.m9932b(32, j2);
            } else {
                this.f6884c.m9931a(-33, j2);
            }
            int i2 = 0;
            while (i2 < RpmSource.values().length) {
                EvictingQueue evictingQueue = this.f6885d[i2];
                List<Integer> arrayList = new ArrayList();
                Iterator it = evictingQueue.iterator();
                while (it.hasNext() && arrayList.size() < 16) {
                    arrayList.add(it.next());
                    it.remove();
                }
                if (arrayList.isEmpty()) {
                    i2++;
                } else {
                    for (Integer intValue : arrayList) {
                        j3 += (long) intValue.intValue();
                    }
                    this.f6886e.add(Integer.valueOf((int) (j3 / ((long) arrayList.size()))));
                    if (i2 == RpmSource.values().length) {
                        this.f6886e.add(Integer.valueOf(65535));
                    }
                    b = m9883b();
                    a = m9881a();
                    if (b || !a) {
                        c2006i = this.f6884c;
                        if (b) {
                            i = 4;
                        } else {
                            i = 0;
                        }
                        c2006i.m9931a((i | 8) ^ -1, j2);
                        c2006i = this.f6884c;
                        if (b) {
                            i = 0;
                        } else {
                            i = 4;
                        }
                        c2006i.m9932b(i, j2);
                    } else {
                        this.f6884c.m9932b(12, j2);
                    }
                }
            }
            if (i2 == RpmSource.values().length) {
                this.f6886e.add(Integer.valueOf(65535));
            }
            b = m9883b();
            a = m9881a();
            if (b) {
            }
            c2006i = this.f6884c;
            if (b) {
                i = 0;
            } else {
                i = 4;
            }
            c2006i.m9931a((i | 8) ^ -1, j2);
            c2006i = this.f6884c;
            if (b) {
                i = 0;
            } else {
                i = 4;
            }
            c2006i.m9932b(i, j2);
        }
    }

    public synchronized boolean m9881a() {
        return C3600n.m18812a(this.f6886e, f6882a);
    }

    public synchronized boolean m9883b() {
        return C3600n.m18812a(this.f6886e, f6883b);
    }

    public synchronized void m9880a(boolean z, long j) {
        if (z) {
            this.f6884c.m9932b(16, j);
        }
    }

    public synchronized long m9877a(long j) {
        if (j - this.f6887f > 5000 && this.f6887f > 0) {
            C2134e.m10673a("TT-VnaEngine", "Running time measurement timed out");
            this.f6887f = 0;
            this.f6888g = 0;
        }
        return this.f6888g;
    }

    public synchronized void m9882b(long j, long j2) {
        this.f6887f = j2;
        this.f6888g = j;
    }
}
