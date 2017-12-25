package com.bigroad.shared.eobr.turbo.messages;

import java.text.SimpleDateFormat;

public class C1051n extends C1049l {
    private static final SimpleDateFormat f3442f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    public final int f3443a;
    public final int f3444b;
    public final int f3445c;
    public final int f3446d;
    public final long f3447e;

    public C1051n(int i, int i2, int i3, int i4, long j) {
        this.f3443a = i;
        this.f3444b = i2;
        this.f3445c = i3;
        this.f3446d = i4;
        this.f3447e = j;
    }
}
