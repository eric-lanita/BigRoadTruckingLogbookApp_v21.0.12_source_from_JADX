package io.fabric.sdk.android;

import android.content.Context;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.concurrency.C2929i;
import io.fabric.sdk.android.services.concurrency.C4031b;
import java.io.File;
import java.util.Collection;

public abstract class C2822h<Result> implements Comparable<C2822h> {
    C3969c f9757e;
    C3975g<Result> f9758f = new C3975g(this);
    Context f9759g;
    C3966f<Result> f9760h;
    IdManager f9761i;
    final C4031b f9762j = ((C4031b) getClass().getAnnotation(C4031b.class));

    public abstract String mo1426a();

    public abstract String mo1427b();

    protected abstract Result mo1429f();

    public /* synthetic */ int compareTo(Object obj) {
        return m15960a((C2822h) obj);
    }

    void m15962a(Context context, C3969c c3969c, C3966f<Result> c3966f, IdManager idManager) {
        this.f9757e = c3969c;
        this.f9759g = new C3970d(context, mo1427b(), m15972t());
        this.f9760h = c3966f;
        this.f9761i = idManager;
    }

    final void m15968p() {
        this.f9758f.m20614a(this.f9757e.m20588f(), (Void) null);
    }

    protected boolean h_() {
        return true;
    }

    protected void m15963a(Result result) {
    }

    protected void m15965b(Result result) {
    }

    protected IdManager m15969q() {
        return this.f9761i;
    }

    public Context m15970r() {
        return this.f9759g;
    }

    public C3969c m15971s() {
        return this.f9757e;
    }

    public String m15972t() {
        return ".Fabric" + File.separator + mo1427b();
    }

    public int m15960a(C2822h c2822h) {
        if (m15966b(c2822h)) {
            return 1;
        }
        if (c2822h.m15966b(this)) {
            return -1;
        }
        if (m15973u() && !c2822h.m15973u()) {
            return 1;
        }
        if (m15973u() || !c2822h.m15973u()) {
            return 0;
        }
        return -1;
    }

    boolean m15966b(C2822h c2822h) {
        if (!m15973u()) {
            return false;
        }
        for (Class isAssignableFrom : this.f9762j.m20836a()) {
            if (isAssignableFrom.isAssignableFrom(c2822h.getClass())) {
                return true;
            }
        }
        return false;
    }

    boolean m15973u() {
        return this.f9762j != null;
    }

    protected Collection<C2929i> m15974v() {
        return this.f9758f.mo1477c();
    }
}
