package com.bigroad.shared.eobr.turbo.logs;

import java.util.ArrayList;
import java.util.List;

public class C1031k extends C1017o {
    public final int f3270a;
    public final int f3271b;
    public final int f3272c;
    public final int f3273d;
    public final int f3274e;
    public final int f3275f;

    public C1031k(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        super(i);
        this.f3270a = i2;
        this.f3271b = i3;
        this.f3272c = i4;
        this.f3273d = i5;
        this.f3274e = i6;
        this.f3275f = i7;
    }

    protected boolean mo769a(String str) {
        return str.equals("appMajorVersion") || str.equals("appMinorVersion") || str.equals("bootromMajorVersion") || str.equals("bootromMinorVersion");
    }

    protected List<String> mo768k() {
        List arrayList = new ArrayList();
        arrayList.add("appVersion");
        arrayList.add("bootromVersion");
        return arrayList;
    }

    public boolean mo746a() {
        return true;
    }
}
