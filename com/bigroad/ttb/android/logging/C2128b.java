package com.bigroad.ttb.android.logging;

import java.util.LinkedList;
import java.util.Queue;

public class C2128b implements C2127h {
    private final Queue<C2136g> f7440a;
    private final int f7441b;
    private int f7442c;
    private LogFilter f7443d;
    private final StringBuilder f7444e;

    public C2128b(int i, LogFilter logFilter) {
        this(i);
        this.f7443d = logFilter;
    }

    public C2128b(int i) {
        this.f7440a = new LinkedList();
        this.f7444e = new StringBuilder();
        this.f7442c = 0;
        this.f7441b = i;
    }

    public synchronized void mo1242a(int i, String str, String str2) {
        C2136g c2136g = new C2136g(i, str, str2);
        if (this.f7443d == null || !this.f7443d.m10642a(c2136g)) {
            int b = c2136g.m10684b();
            while (!this.f7440a.isEmpty() && this.f7442c + b > this.f7441b) {
                this.f7442c -= ((C2136g) this.f7440a.poll()).m10684b();
            }
            this.f7440a.offer(c2136g);
            this.f7442c += b;
        }
    }

    public void mo1243a(long j, int i, String str, String str2) {
        mo1242a(i, str, str2);
    }

    public synchronized String toString() {
        this.f7444e.setLength(0);
        for (C2136g c2136g : this.f7440a) {
            this.f7444e.append(c2136g.toString()).append('\n');
        }
        return this.f7444e.toString();
    }

    public void mo1241a() {
    }
}
