package com.bigroad.ttb.android.util;

import java.util.ArrayDeque;

public class C2123x<Type> {
    private final ArrayDeque<C2305a<Type>> f7429a = new ArrayDeque();
    private int f7430b;
    private long f7431c;
    private long f7432d;

    private static class C2305a<Type> {
        public final Type f7952a;
        public final long f7953b;

        public C2305a(Type type, long j) {
            this.f7952a = type;
            this.f7953b = j;
        }
    }

    private void m10630a(long j) {
        while (this.f7429a.size() > this.f7430b) {
            this.f7429a.remove();
        }
        while (this.f7429a.peekFirst() != null && ((C2305a) this.f7429a.peekFirst()).f7953b + this.f7431c < j) {
            this.f7429a.removeFirst();
        }
    }

    private void m10631b(long j) {
        while (this.f7429a.peekLast() != null && ((C2305a) this.f7429a.peekLast()).f7953b > j) {
            this.f7429a.removeLast();
        }
    }

    public C2123x(int i, long j, long j2) {
        this.f7430b = i;
        this.f7431c = j;
        this.f7432d = j2;
    }

    public void m10632a() {
        this.f7429a.clear();
    }

    public boolean m10634b() {
        return this.f7429a.isEmpty();
    }

    public int m10635c() {
        return this.f7429a.size();
    }

    public void m10633a(Type type, long j) {
        m10631b(j);
        C2305a c2305a = (C2305a) this.f7429a.peekLast();
        if (c2305a == null || j - c2305a.f7953b >= this.f7432d) {
            this.f7429a.addLast(new C2305a(type, j));
            m10630a(j);
        }
    }

    public Type m10636d() {
        return this.f7429a.isEmpty() ? null : ((C2305a) this.f7429a.peekFirst()).f7952a;
    }

    public long m10637e() {
        return this.f7429a.isEmpty() ? 0 : ((C2305a) this.f7429a.peekFirst()).f7953b;
    }

    public Type m10638f() {
        return this.f7429a.isEmpty() ? null : ((C2305a) this.f7429a.peekLast()).f7952a;
    }

    public long m10639g() {
        return this.f7429a.isEmpty() ? 0 : ((C2305a) this.f7429a.peekLast()).f7953b;
    }

    public long m10640h() {
        return m10639g() - m10637e();
    }
}
