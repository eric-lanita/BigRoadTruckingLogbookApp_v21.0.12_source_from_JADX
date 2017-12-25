package io.fabric.sdk.android.services.p045a;

import android.content.Context;

public abstract class C3979a<T> implements C3978c<T> {
    private final C3978c<T> f14088a;

    protected abstract T mo2865a(Context context);

    protected abstract void mo2866a(Context context, T t);

    public C3979a(C3978c<T> c3978c) {
        this.f14088a = c3978c;
    }

    public final synchronized T mo2864a(Context context, C2830d<T> c2830d) {
        T a;
        a = mo2865a(context);
        if (a == null) {
            a = this.f14088a != null ? this.f14088a.mo2864a(context, c2830d) : c2830d.mo1431b(context);
            m20645b(context, a);
        }
        return a;
    }

    private void m20645b(Context context, T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        mo2866a(context, (Object) t);
    }
}
