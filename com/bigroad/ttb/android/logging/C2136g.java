package com.bigroad.ttb.android.logging;

import com.bigroad.ttb.android.OurApplication;

public class C2136g {
    private final int f7458a;
    private final int f7459b;
    private final long f7460c;
    private final String f7461d;
    private final String f7462e;

    public C2136g(int i, long j, String str, String str2) {
        this.f7459b = ((str.length() + 1) + str2.length()) * 2;
        this.f7460c = j;
        this.f7458a = i;
        this.f7461d = str;
        this.f7462e = str2;
    }

    public C2136g(int i, String str, String str2) {
        this(i, OurApplication.m6269Z().mo913a(), str, str2);
    }

    public String toString() {
        return C2138i.m10690a(this.f7460c) + " " + C2138i.m10688a(this.f7458a) + " " + this.f7461d + " " + this.f7462e;
    }

    public int m10683a() {
        return this.f7458a;
    }

    public int m10684b() {
        return this.f7459b;
    }

    public long m10685c() {
        return this.f7460c;
    }

    public String m10686d() {
        return this.f7461d;
    }

    public String m10687e() {
        return this.f7462e;
    }
}
