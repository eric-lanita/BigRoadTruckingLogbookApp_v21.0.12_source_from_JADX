package com.bigroad.ttb.android;

import com.bigroad.ttb.android.C2474y.C1183b;
import com.bigroad.ttb.android.p035d.C1790a;
import com.bigroad.ttb.protocol.TTProtocol.PersonGroup;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class C2232s {
    private static C2232s f7730a;
    private final C2474y f7731b = OurApplication.m6285g();
    private final C1790a f7732c = OurApplication.m6287i();
    private final Set<C1329a> f7733d = new HashSet();
    private boolean f7734e = false;
    private final C1183b f7735f = new C22311(this);

    public interface C1329a {
        void mo953a(List<PersonGroup> list);
    }

    class C22311 extends C1183b {
        final /* synthetic */ C2232s f7729a;

        C22311(C2232s c2232s) {
            this.f7729a = c2232s;
        }

        public void mo866c(C2474y c2474y) {
            this.f7729a.m11026c();
        }
    }

    public static C2232s m11023a() {
        if (f7730a == null) {
            f7730a = new C2232s();
        }
        return f7730a;
    }

    private C2232s() {
        boolean z = false;
        if (!this.f7732c.m8812x()) {
            z = true;
        }
        this.f7734e = z;
        this.f7731b.m12184a(this.f7735f);
    }

    public void m11027a(C1329a c1329a) {
        this.f7733d.add(c1329a);
    }

    public void m11030b(C1329a c1329a) {
        this.f7733d.remove(c1329a);
    }

    private void m11025b(List<PersonGroup> list) {
        for (C1329a a : (C1329a[]) this.f7733d.toArray(new C1329a[this.f7733d.size()])) {
            a.mo953a(list);
        }
    }

    public void m11028a(List<PersonGroup> list) {
        this.f7734e = true;
        this.f7732c.m8792i((List) list);
        m11025b((List) list);
    }

    public List<PersonGroup> m11029b() {
        return this.f7732c.m8811w();
    }

    private void m11026c() {
        this.f7732c.m8813y();
        this.f7734e = false;
        m11025b(Collections.emptyList());
    }
}
