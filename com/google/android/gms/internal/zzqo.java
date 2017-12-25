package com.google.android.gms.internal;

import android.os.Looper;
import com.google.android.gms.common.internal.zzab;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public class zzqo {
    private final Set<zzqn<?>> f11660a = Collections.newSetFromMap(new WeakHashMap());

    public void release() {
        for (zzqn clear : this.f11660a) {
            clear.clear();
        }
        this.f11660a.clear();
    }

    public <L> zzqn<L> zzb(L l, Looper looper) {
        zzab.zzb((Object) l, (Object) "Listener must not be null");
        zzab.zzb((Object) looper, (Object) "Looper must not be null");
        zzqn<L> com_google_android_gms_internal_zzqn = new zzqn(looper, l);
        this.f11660a.add(com_google_android_gms_internal_zzqn);
        return com_google_android_gms_internal_zzqn;
    }
}
