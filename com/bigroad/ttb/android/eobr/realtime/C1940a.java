package com.bigroad.ttb.android.eobr.realtime;

import com.bigroad.shared.eobr.turbo.C1002b;
import com.bigroad.shared.eobr.turbo.C1015l;
import com.bigroad.shared.eobr.turbo.logs.C1017o;
import com.bigroad.ttb.android.vehicle.p041b.C2348f;
import com.google.common.collect.EvictingQueue;
import java.util.ArrayList;
import java.util.Collection;

public class C1940a {
    private final EvictingQueue<C2348f> f6699a;
    private long f6700b = 0;
    private C1015l f6701c = new C1015l(1234567000, 1);
    private final long f6702d;

    public C1940a(long j, int i) {
        this.f6702d = j;
        this.f6699a = EvictingQueue.m18488a(i);
    }

    public C1015l m9552a() {
        return this.f6701c;
    }

    public synchronized Collection<C2348f> m9554b() {
        return new ArrayList(this.f6699a);
    }

    public synchronized C2348f m9553a(C1017o c1017o, long j) {
        C2348f c2348f;
        if (this.f6701c.m5230b() >= Integer.MAX_VALUE) {
            this.f6701c = new C1015l(this.f6701c.m5228a() + 1, 1);
        } else {
            this.f6701c = this.f6701c.m5234e();
        }
        c2348f = new C2348f(new C1002b(this.f6701c, c1017o, (long) c1017o.f3193g, j));
        this.f6699a.add(c2348f);
        this.f6700b = c2348f.mo1281l().getAbsoluteTimeMillis();
        while (!this.f6699a.isEmpty() && this.f6700b - ((C2348f) this.f6699a.peek()).mo1281l().getAbsoluteTimeMillis() > this.f6702d) {
            this.f6699a.poll();
        }
        return c2348f;
    }

    public synchronized long m9555c() {
        return this.f6700b;
    }
}
