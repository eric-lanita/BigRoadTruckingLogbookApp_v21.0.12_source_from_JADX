package com.bigroad.ttb.android;

import android.content.Context;
import com.bigroad.ttb.android.C2474y.C1183b;
import com.bigroad.ttb.android.p035d.C1790a;
import com.bigroad.ttb.protocol.TTProtocol.Person;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class C2472x {
    private static C2472x f8807a;
    private final C2474y f8808b = OurApplication.m6285g();
    private final C1790a f8809c = OurApplication.m6287i();
    private final Set<C1306a> f8810d = new HashSet();
    private boolean f8811e = false;
    private List<Person> f8812f = Collections.emptyList();
    private final C1183b f8813g = new C24711(this);

    public interface C1306a {
        void mo948a(C2472x c2472x, List<Person> list);
    }

    class C24711 extends C1183b {
        final /* synthetic */ C2472x f8806a;

        C24711(C2472x c2472x) {
            this.f8806a = c2472x;
        }

        public void mo866c(C2474y c2474y) {
            this.f8806a.m12137d();
            if (c2474y.m12213g() != -1) {
                OurApplication.m6289k().m6502g();
            }
        }
    }

    public static C2472x m12134a(Context context) {
        if (f8807a == null) {
            f8807a = new C2472x();
        }
        return f8807a;
    }

    private C2472x() {
        boolean z = false;
        if (!this.f8809c.m8782f()) {
            z = true;
        }
        this.f8811e = z;
        this.f8808b.m12184a(this.f8813g);
    }

    public void m12140a(C1306a c1306a) {
        this.f8810d.add(c1306a);
    }

    public void m12142b(C1306a c1306a) {
        this.f8810d.remove(c1306a);
    }

    private void m12136c() {
        for (C1306a a : (C1306a[]) this.f8810d.toArray(new C1306a[this.f8810d.size()])) {
            a.mo948a(this, this.f8812f);
        }
    }

    public void m12141a(List<Person> list) {
        this.f8811e = true;
        this.f8809c.m8744a((List) list);
        this.f8812f = Collections.unmodifiableList(list);
        m12136c();
    }

    public Person m12138a(long j) {
        for (Person person : this.f8812f) {
            if (person.getPersonId() == j) {
                return person;
            }
        }
        return null;
    }

    public List<Person> m12139a() {
        return this.f8812f;
    }

    private void m12137d() {
        this.f8811e = false;
        this.f8809c.m8784g();
        this.f8812f = Collections.emptyList();
        m12136c();
    }

    public boolean m12143b() {
        return this.f8811e;
    }
}
