package com.bigroad.shared.eobr.genx;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.List;

public class C0985h extends C0975o {
    private List<C0976j> f3096a;
    private long f3097b;
    private long f3098c;
    private long f3099d;
    private long f3100e;
    private long f3101f;

    public C0985h(int i, List<C0976j> list, long j, long j2, long j3, long j4, long j5) {
        super(i);
        this.f3096a = ImmutableList.m18511a((Collection) list);
        this.f3097b = j;
        this.f3098c = j2;
        this.f3099d = j3;
        this.f3100e = j4;
        this.f3101f = j5;
    }

    public List<C0976j> m5055a() {
        return this.f3096a;
    }

    public boolean m5057b() {
        return this.f3096a.isEmpty();
    }

    public long m5058c() {
        return this.f3101f;
    }

    public int m5059d() {
        return (int) (this.f3101f / 1000);
    }

    public long m5060h() {
        return this.f3096a.isEmpty() ? -1 : ((C0976j) this.f3096a.get(this.f3096a.size() - 1)).m4995t();
    }

    public long m5061i() {
        return this.f3099d;
    }

    public long m5062j() {
        return this.f3100e;
    }

    public long m5063k() {
        return this.f3097b;
    }

    public long m5064l() {
        return this.f3098c;
    }

    public boolean m5065m() {
        return this.f3098c == this.f3100e;
    }

    public boolean m5056a(long j) {
        return this.f3097b <= j && this.f3098c >= j;
    }

    public String toString() {
        return MoreObjects.toStringHelper(C0985h.class).add("seq", m4990v()).add("numEntries", m5055a().size()).add("minScan", this.f3097b).add("maxScan", this.f3098c).add("minQueue", this.f3099d).add("maxQueue", this.f3100e).toString();
    }
}
