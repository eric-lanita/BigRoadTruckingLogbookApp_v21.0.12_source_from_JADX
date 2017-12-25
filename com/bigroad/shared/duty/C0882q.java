package com.bigroad.shared.duty;

import com.bigroad.shared.C0836a;
import com.bigroad.shared.aq;
import com.bigroad.shared.duty.C0896g.C0870a;
import com.bigroad.shared.p021a.C0831a;
import com.bigroad.shared.p021a.C0832c;
import java.text.DateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.TimeZone;

public class C0882q extends C0836a implements Comparable<C0882q>, Iterable<C0896g> {
    protected final List<C0896g> f2748a;
    private final int f2749b;
    private final int f2750c;

    public interface C0909a {
        void mo729a(List<C0896g> list, int i, int i2);
    }

    public /* synthetic */ int compareTo(Object obj) {
        return mo714a((C0882q) obj);
    }

    public C0882q(List<C0896g> list, int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException("startIndex(" + i + ") > endIndex(" + i2 + ")");
        } else if (i2 > list.size()) {
            throw new IndexOutOfBoundsException("endIndex(" + i2 + ") > size(" + list.size() + ")");
        } else {
            this.f2748a = list;
            this.f2749b = i;
            this.f2750c = i2;
        }
    }

    public C0882q(List<C0896g> list) {
        this(list, 0, list.size());
    }

    protected C0882q(C0882q c0882q) {
        this(c0882q.f2748a, c0882q.f2749b, c0882q.f2750c);
    }

    public long mo697f() {
        if (m4461h()) {
            return 0;
        }
        return ((C0896g) this.f2748a.get(this.f2749b)).mo697f();
    }

    public long mo698g() {
        if (m4461h()) {
            return 0;
        }
        return ((C0896g) this.f2748a.get(this.f2750c - 1)).mo698g();
    }

    public long m4446a(C0870a c0870a) {
        Iterator it = iterator();
        long j = 0;
        while (it.hasNext()) {
            long a;
            C0896g c0896g = (C0896g) it.next();
            if (c0870a.mo701a(c0896g.mo702m())) {
                a = c0896g.mo689a() + j;
            } else {
                a = j;
            }
            j = a;
        }
        return j;
    }

    public long m4448a(C0870a c0870a, long j, long j2) {
        Iterator it = iterator();
        long j3 = 0;
        while (it.hasNext()) {
            long a;
            C0896g c0896g = (C0896g) it.next();
            if (c0870a.mo701a(c0896g.mo702m())) {
                a = c0896g.m4538a(j, j2) + j3;
            } else {
                a = j3;
            }
            j3 = a;
        }
        return j3;
    }

    public long m4445a(long j, long j2) {
        return m4448a(C0896g.f2769b, j, j2);
    }

    public long m4452d() {
        return m4446a(C0896g.f2769b);
    }

    public long m4454e() {
        return m4446a(DutyStatus.DRIVING);
    }

    public long m4451b(long j, long j2) {
        return m4448a(DutyStatus.DRIVING, j, j2);
    }

    public C0896g m4453d(long j) {
        Iterator it = iterator();
        long j2 = 0;
        while (it.hasNext()) {
            C0896g c0896g = (C0896g) it.next();
            if (c0896g.m4539b()) {
                j2 += c0896g.mo689a();
                if (c0896g.m4541d() && j2 > j) {
                    return c0896g;
                }
            }
            j2 = j2;
        }
        return null;
    }

    public long m4447a(C0870a c0870a, long j) {
        long j2 = 0;
        for (C0896g c0896g : m4462i()) {
            if (!c0870a.mo701a(c0896g.mo702m())) {
                break;
            }
            long a = c0896g.mo689a() + j2;
            if (a >= j) {
                return j;
            }
            j2 = a;
        }
        return j2;
    }

    public long m4455e(long j) {
        return m4447a(C0896g.f2772e, j);
    }

    public long m4457f(long j) {
        return m4447a(C0896g.f2771d, j);
    }

    public long m4459g(long j) {
        return m4447a(DutyStatus.SLEEPER, j);
    }

    public <T extends C0909a> T m4450a(C0870a c0870a, T t) {
        int k = m4464k();
        int j = m4463j();
        int i = -1;
        while (j < k) {
            int i2;
            if (c0870a.mo701a(((C0896g) this.f2748a.get(j)).mo702m())) {
                if (i == -1) {
                    i2 = j;
                }
                i2 = i;
            } else {
                if (i != -1) {
                    t.mo729a(this.f2748a, i, j);
                    i2 = -1;
                }
                i2 = i;
            }
            j++;
            i = i2;
        }
        if (i != -1) {
            t.mo729a(this.f2748a, i, k);
        }
        return t;
    }

    public boolean m4461h() {
        return this.f2749b >= this.f2750c;
    }

    public Iterator<C0896g> iterator() {
        return this.f2748a.subList(this.f2749b, this.f2750c).iterator();
    }

    public Iterable<C0896g> m4462i() {
        return C0831a.m4105a(this.f2748a.subList(this.f2749b, this.f2750c));
    }

    public Iterator<C0882q> m4460h(final long j) {
        return new C0832c<C0882q>(this) {
            final /* synthetic */ C0882q f2803b;
            private int f2804c = this.f2803b.m4463j();

            public /* synthetic */ Object next() {
                return m4590a();
            }

            public boolean hasNext() {
                return this.f2804c < this.f2803b.m4464k();
            }

            private C0882q m4589a(int i, int i2) {
                C0882q c0882q = new C0882q(this.f2803b.f2748a, this.f2804c, i);
                this.f2804c = i2;
                return c0882q;
            }

            public C0882q m4590a() {
                if (hasNext()) {
                    int k = this.f2803b.m4464k();
                    int i = this.f2804c;
                    int i2 = -1;
                    long j = 0;
                    while (i < k) {
                        int i3;
                        C0896g c0896g = (C0896g) this.f2803b.f2748a.get(i);
                        if (c0896g.m4540c()) {
                            j += c0896g.mo689a();
                            if (i2 == -1) {
                                i3 = i;
                            } else {
                                i3 = i2;
                            }
                        } else if (j >= j) {
                            return m4589a(i2, i);
                        } else {
                            i3 = -1;
                            j = 0;
                        }
                        i++;
                        i2 = i3;
                    }
                    if (j >= j) {
                        return m4589a(i2, k);
                    }
                    return m4589a(k, k);
                }
                throw new NoSuchElementException();
            }
        };
    }

    public int m4463j() {
        return this.f2749b;
    }

    public int m4464k() {
        return this.f2750c;
    }

    protected C0896g m4449a(int i) {
        if (i >= this.f2749b && i < this.f2750c) {
            return (C0896g) this.f2748a.get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    public int mo714a(C0882q c0882q) {
        return this.f2749b - c0882q.f2749b;
    }

    public String toString() {
        DateFormat dateTimeInstance = DateFormat.getDateTimeInstance(2, 2);
        dateTimeInstance.setTimeZone(TimeZone.getTimeZone("UTC"));
        return "Period [m_startIndex=" + this.f2749b + ", m_endIndex=" + this.f2750c + ", startTime=" + dateTimeInstance.format(new Date(mo697f())) + ", endTime=" + dateTimeInstance.format(new Date(mo698g())) + ", duration=" + aq.m4232d(mo689a()) + "]";
    }
}
