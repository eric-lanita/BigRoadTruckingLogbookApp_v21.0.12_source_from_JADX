package io.fabric.sdk.android.services.concurrency;

import io.fabric.sdk.android.services.concurrency.AsyncTask.Status;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public abstract class C3974c<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> implements C2927a<C2929i>, C2928f, C2929i {
    private final C2930g f14072a = new C2930g();

    private static class C4034a<Result> implements Executor {
        private final Executor f14222a;
        private final C3974c f14223b;

        public C4034a(Executor executor, C3974c c3974c) {
            this.f14222a = executor;
            this.f14223b = c3974c;
        }

        public void execute(Runnable runnable) {
            this.f14222a.execute(new C4032e<Result>(this, runnable, null) {
                final /* synthetic */ C4034a f14221a;

                public <T extends C2927a<C2929i> & C2928f & C2929i> T mo2883a() {
                    return this.f14221a.f14223b;
                }
            });
        }
    }

    public /* synthetic */ void mo1478c(Object obj) {
        m20612a((C2929i) obj);
    }

    public final void m20614a(ExecutorService executorService, Params... paramsArr) {
        super.m20604a(new C4034a(executorService, this), (Object[]) paramsArr);
    }

    public int compareTo(Object obj) {
        return Priority.m20831a(this, obj);
    }

    public void m20612a(C2929i c2929i) {
        if (i_() != Status.PENDING) {
            throw new IllegalStateException("Must not add Dependency after task is running");
        }
        ((C2927a) ((C2928f) m20621g())).mo1478c(c2929i);
    }

    public Collection<C2929i> mo1477c() {
        return ((C2927a) ((C2928f) m20621g())).mo1477c();
    }

    public boolean mo1479d() {
        return ((C2927a) ((C2928f) m20621g())).mo1479d();
    }

    public Priority mo1475b() {
        return ((C2928f) m20621g()).mo1475b();
    }

    public void mo1476b(boolean z) {
        ((C2929i) ((C2928f) m20621g())).mo1476b(z);
    }

    public boolean mo1480f() {
        return ((C2929i) ((C2928f) m20621g())).mo1480f();
    }

    public void mo1474a(Throwable th) {
        ((C2929i) ((C2928f) m20621g())).mo1474a(th);
    }

    public <T extends C2927a<C2929i> & C2928f & C2929i> T m20621g() {
        return this.f14072a;
    }
}
