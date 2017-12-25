package com.bigroad.ttb.android;

import android.content.Context;
import com.bigroad.shared.am;
import com.bigroad.ttb.android.adapter.C1695r;
import com.bigroad.ttb.android.p035d.C1790a;
import com.bigroad.ttb.android.p035d.p036a.C1789z;
import com.bigroad.ttb.android.widget.InstantAutoComplete;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ai {
    private static ai f5926a;
    private final C1790a f5927b = OurApplication.m6287i();
    private final C2474y f5928c = OurApplication.m6285g();
    private final TruckManager f5929d = OurApplication.m6294p();

    private static class C1715a {
        private Set<String> f5923a;
        private List<String> f5924b;
        private Set<String> f5925c;

        private C1715a() {
            this.f5923a = new HashSet();
            this.f5924b = new ArrayList();
            this.f5925c = null;
        }

        public void m8363a(Set<String> set) {
            this.f5925c = set;
        }

        public void m8362a(List<C1789z> list, Comparator<C1789z> comparator) {
            Collections.sort(list, comparator);
            for (C1789z b : list) {
                m8361a(b.m8683b());
            }
        }

        public void m8364b(List<String> list, Comparator<String> comparator) {
            Collections.sort(list, comparator);
            for (String a : list) {
                m8361a(a);
            }
        }

        public void m8361a(String str) {
            if (!this.f5923a.contains(str) && !am.m4188a((CharSequence) str)) {
                if (this.f5925c == null || this.f5925c.contains(str)) {
                    this.f5923a.add(str);
                    this.f5924b.add(str);
                }
            }
        }

        public List<String> m8360a() {
            return this.f5924b;
        }
    }

    public static ai m8368a() {
        if (f5926a == null) {
            f5926a = new ai();
        }
        return f5926a;
    }

    private ai() {
    }

    public void m8376a(String str) {
        if (!am.m4188a((CharSequence) str)) {
            m8370b(str, 0, -1);
        }
    }

    public void m8374a(InstantAutoComplete instantAutoComplete, int i) {
        if (instantAutoComplete != null) {
            m8375a(instantAutoComplete.getText(), i);
        }
    }

    public void m8375a(CharSequence charSequence, int i) {
        m8370b(charSequence.toString(), i, this.f5928c.m12202d());
    }

    public void m8377a(String str, int i) {
        m8370b(str, i, this.f5928c.m12202d());
    }

    private void m8370b(String str, int i, long j) {
        String b = am.m4191b(str);
        if (!am.m4188a((CharSequence) b)) {
            this.f5927b.m8723a(i, j, b);
        }
    }

    public void m8378a(String str, int i, long j) {
        this.f5927b.m8753b(i, j, str);
    }

    public C1695r m8371a(Context context) {
        return m8366a(context, 0, -1);
    }

    public C1695r m8372a(Context context, int i) {
        return m8366a(context, i, this.f5928c.m12202d());
    }

    private C1695r m8366a(Context context, int i, long j) {
        if (i == 1) {
            return new C1695r(context, m8373a(j), i, j);
        } else if (i == 4) {
            return m8365a(context, i, 2, j);
        } else {
            if (i != 7) {
                return m8369b(context, i, j);
            }
            return m8367a(this.f5928c.m12223m(), context, i, j);
        }
    }

    public List<String> m8373a(long j) {
        C1715a c1715a = new C1715a();
        Set d = this.f5929d.m6575d();
        c1715a.m8363a(d);
        Truck f = this.f5929d.m6578f();
        if (f != null) {
            c1715a.m8361a(f.getTruckNumber());
        }
        c1715a.m8362a(this.f5927b.m8718a(1, j), C1789z.f6118b);
        List arrayList = new ArrayList(d.size());
        arrayList.addAll(d);
        c1715a.m8364b(arrayList, String.CASE_INSENSITIVE_ORDER);
        return c1715a.m8360a();
    }

    private C1695r m8367a(String str, Context context, int i, long j) {
        C1715a c1715a = new C1715a();
        c1715a.m8361a(str);
        c1715a.m8362a(this.f5927b.m8718a(i, j), C1789z.f6118b);
        return new C1695r(context, c1715a.m8360a(), i, j);
    }

    private C1695r m8369b(Context context, int i, long j) {
        C1715a c1715a = new C1715a();
        c1715a.m8362a(this.f5927b.m8718a(i, j), C1789z.f6118b);
        return new C1695r(context, c1715a.m8360a(), i, j);
    }

    private C1695r m8365a(Context context, int i, int i2, long j) {
        List a = this.f5927b.m8718a(i, j);
        a.addAll(this.f5927b.m8718a(i2, j));
        C1715a c1715a = new C1715a();
        c1715a.m8362a(a, C1789z.f6118b);
        return new C1695r(context, c1715a.m8360a(), i, j);
    }
}
