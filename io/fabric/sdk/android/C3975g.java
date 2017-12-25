package io.fabric.sdk.android;

import io.fabric.sdk.android.services.common.C4017q;
import io.fabric.sdk.android.services.concurrency.C3974c;
import io.fabric.sdk.android.services.concurrency.Priority;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;

class C3975g<Result> extends C3974c<Void, Void, Result> {
    final C2822h<Result> f14073a;

    public C3975g(C2822h<Result> c2822h) {
        this.f14073a = c2822h;
    }

    protected void mo2861a() {
        super.mo2861a();
        C4017q a = m20622a("onPreExecute");
        try {
            boolean h_ = this.f14073a.h_();
            a.m20819b();
            if (!h_) {
                m20608a(true);
            }
        } catch (UnmetDependencyException e) {
            throw e;
        } catch (Throwable e2) {
            C3969c.m20576h().mo2857e("Fabric", "Failure onPreExecute()", e2);
            a.m20819b();
            m20608a(true);
        } catch (Throwable th) {
            a.m20819b();
            m20608a(true);
        }
    }

    protected Result m20624a(Void... voidArr) {
        C4017q a = m20622a("doInBackground");
        Result result = null;
        if (!m20611e()) {
            result = this.f14073a.mo1429f();
        }
        a.m20819b();
        return result;
    }

    protected void mo2862a(Result result) {
        this.f14073a.m15963a((Object) result);
        this.f14073a.f9760h.mo2859a((Object) result);
    }

    protected void mo2863b(Result result) {
        this.f14073a.m15965b((Object) result);
        this.f14073a.f9760h.mo2858a(new InitializationException(this.f14073a.mo1427b() + " Initialization was cancelled"));
    }

    public Priority mo1475b() {
        return Priority.HIGH;
    }

    private C4017q m20622a(String str) {
        C4017q c4017q = new C4017q(this.f14073a.mo1427b() + "." + str, "KitInitialization");
        c4017q.m20818a();
        return c4017q;
    }
}
