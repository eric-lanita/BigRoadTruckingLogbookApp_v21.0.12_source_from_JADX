package io.fabric.sdk.android.services.concurrency;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class C4032e<V> extends FutureTask<V> implements C2927a<C2929i>, C2928f, C2929i {
    final Object f14220b;

    public /* synthetic */ void mo1478c(Object obj) {
        m20839a((C2929i) obj);
    }

    public C4032e(Callable<V> callable) {
        super(callable);
        this.f14220b = m20838a((Object) callable);
    }

    public C4032e(Runnable runnable, V v) {
        super(runnable, v);
        this.f14220b = m20838a((Object) runnable);
    }

    public int compareTo(Object obj) {
        return ((C2928f) mo2883a()).compareTo(obj);
    }

    public void m20839a(C2929i c2929i) {
        ((C2927a) ((C2928f) mo2883a())).mo1478c(c2929i);
    }

    public Collection<C2929i> mo1477c() {
        return ((C2927a) ((C2928f) mo2883a())).mo1477c();
    }

    public boolean mo1479d() {
        return ((C2927a) ((C2928f) mo2883a())).mo1479d();
    }

    public Priority mo1475b() {
        return ((C2928f) mo2883a()).mo1475b();
    }

    public void mo1476b(boolean z) {
        ((C2929i) ((C2928f) mo2883a())).mo1476b(z);
    }

    public boolean mo1480f() {
        return ((C2929i) ((C2928f) mo2883a())).mo1480f();
    }

    public void mo1474a(Throwable th) {
        ((C2929i) ((C2928f) mo2883a())).mo1474a(th);
    }

    public <T extends C2927a<C2929i> & C2928f & C2929i> T mo2883a() {
        return (C2927a) this.f14220b;
    }

    protected <T extends C2927a<C2929i> & C2928f & C2929i> T m20838a(Object obj) {
        if (C2930g.m16369a(obj)) {
            return (C2927a) obj;
        }
        return new C2930g();
    }
}
