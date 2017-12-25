package com.bigroad.shared.eobr.turbo.logs;

import java.util.ArrayList;
import java.util.List;

public class C1029i extends C1017o {
    public final long f3264a;
    public final int[] f3265b;
    public final boolean[] f3266c;
    public final boolean f3267d;

    public C1029i(int i, long j, int[] iArr, boolean[] zArr, boolean z) {
        super(i);
        this.f3264a = j;
        this.f3265b = iArr;
        this.f3266c = zArr;
        this.f3267d = z;
    }

    protected List<String> mo768k() {
        List arrayList = new ArrayList();
        arrayList.add("numSources");
        return arrayList;
    }
}
