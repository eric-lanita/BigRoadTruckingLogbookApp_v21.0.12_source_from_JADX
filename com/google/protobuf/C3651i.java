package com.google.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public class C3651i extends AbstractList<String> implements C3650j, RandomAccess {
    public static final C3650j f13238a = new C3671q(new C3651i());
    private final List<Object> f13239b;

    public /* synthetic */ void add(int i, Object obj) {
        m19162b(i, (String) obj);
    }

    public /* synthetic */ Object get(int i) {
        return m19157a(i);
    }

    public /* synthetic */ Object remove(int i) {
        return m19161b(i);
    }

    public /* synthetic */ Object set(int i, Object obj) {
        return m19158a(i, (String) obj);
    }

    public C3651i() {
        this.f13239b = new ArrayList();
    }

    public C3651i(C3650j c3650j) {
        this.f13239b = new ArrayList(c3650j.size());
        addAll(c3650j);
    }

    public String m19157a(int i) {
        Object obj = this.f13239b.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        C3642c c3642c = (C3642c) obj;
        String e = c3642c.m19092e();
        if (c3642c.mo2757f()) {
            this.f13239b.set(i, e);
        }
        return e;
    }

    public int size() {
        return this.f13239b.size();
    }

    public String m19158a(int i, String str) {
        return m19156a(this.f13239b.set(i, str));
    }

    public void m19162b(int i, String str) {
        this.f13239b.add(i, str);
        this.modCount++;
    }

    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public boolean addAll(int i, Collection<? extends String> collection) {
        if (collection instanceof C3650j) {
            collection = ((C3650j) collection).mo2745a();
        }
        boolean addAll = this.f13239b.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    public String m19161b(int i) {
        Object remove = this.f13239b.remove(i);
        this.modCount++;
        return m19156a(remove);
    }

    public void clear() {
        this.f13239b.clear();
        this.modCount++;
    }

    public void mo2746a(C3642c c3642c) {
        this.f13239b.add(c3642c);
        this.modCount++;
    }

    public C3642c mo2747c(int i) {
        Object obj = this.f13239b.get(i);
        if (!(obj instanceof String)) {
            return (C3642c) obj;
        }
        C3642c a = C3642c.m19077a((String) obj);
        this.f13239b.set(i, a);
        return a;
    }

    private String m19156a(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        return ((C3642c) obj).m19092e();
    }

    public List<?> mo2745a() {
        return Collections.unmodifiableList(this.f13239b);
    }
}
