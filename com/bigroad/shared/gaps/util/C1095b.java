package com.bigroad.shared.gaps.util;

import com.bigroad.shared.gaps.C1080c;
import com.bigroad.shared.gaps.C1081g;
import com.bigroad.shared.gaps.C1082d;
import com.bigroad.shared.gaps.C1083e;
import com.bigroad.shared.gaps.C1085f;
import java.util.HashMap;
import java.util.Map;

public class C1095b implements C1080c {
    private final Map<String, C1081g> f3568a = new HashMap();
    private final C1083e f3569b;

    public C1095b(C1083e c1083e) {
        this.f3569b = c1083e;
    }

    public C1085f mo778a(int i, String str) {
        return m5433a(i, str, null);
    }

    public C1085f m5433a(int i, String str, AnalysisStats analysisStats) {
        if (this.f3569b == null) {
            return null;
        }
        C1081g c1081g = (C1081g) this.f3568a.get(str);
        if (c1081g == null) {
            c1081g = new C1082d(this.f3569b.mo1231a(str), this.f3569b.mo1232a());
            this.f3568a.put(str, c1081g);
        }
        return c1081g.mo777a(i);
    }
}
