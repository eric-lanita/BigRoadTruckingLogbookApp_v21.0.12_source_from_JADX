package io.fabric.sdk.android.services.concurrency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class C2930g implements C2927a<C2929i>, C2928f, C2929i {
    private final List<C2929i> f10052a = new ArrayList();
    private final AtomicBoolean f10053b = new AtomicBoolean(false);
    private final AtomicReference<Throwable> f10054c = new AtomicReference(null);

    public /* synthetic */ void mo1478c(Object obj) {
        m16370a((C2929i) obj);
    }

    public synchronized Collection<C2929i> mo1477c() {
        return Collections.unmodifiableCollection(this.f10052a);
    }

    public synchronized void m16370a(C2929i c2929i) {
        this.f10052a.add(c2929i);
    }

    public boolean mo1479d() {
        for (C2929i f : mo1477c()) {
            if (!f.mo1480f()) {
                return false;
            }
        }
        return true;
    }

    public synchronized void mo1476b(boolean z) {
        this.f10053b.set(z);
    }

    public boolean mo1480f() {
        return this.f10053b.get();
    }

    public Priority mo1475b() {
        return Priority.NORMAL;
    }

    public void mo1474a(Throwable th) {
        this.f10054c.set(th);
    }

    public int compareTo(Object obj) {
        return Priority.m20831a(this, obj);
    }

    public static boolean m16369a(Object obj) {
        try {
            C2927a c2927a = (C2927a) obj;
            C2929i c2929i = (C2929i) obj;
            C2928f c2928f = (C2928f) obj;
            if (c2927a == null || c2929i == null || c2928f == null) {
                return false;
            }
            return true;
        } catch (ClassCastException e) {
            return false;
        }
    }
}
