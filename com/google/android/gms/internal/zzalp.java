package com.google.android.gms.internal;

import android.content.Context;
import com.google.firebase.C3611a;
import com.google.firebase.C3615b;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class zzalp {
    private static final AtomicReference<zzalp> f11146a = new AtomicReference();

    zzalp(Context context) {
    }

    public static zzalp zzcxc() {
        return (zzalp) f11146a.get();
    }

    public static zzalp zzeq(Context context) {
        f11146a.compareAndSet(null, new zzalp(context));
        return (zzalp) f11146a.get();
    }

    public Set<String> zzcxd() {
        return Collections.emptySet();
    }

    public void zzf(C3611a c3611a) {
    }

    public C3615b zzta(String str) {
        return null;
    }
}
