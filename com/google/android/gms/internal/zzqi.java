package com.google.android.gms.internal;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zzs;

public class zzqi {
    private final Object f11649a;

    public zzqi(Activity activity) {
        zzab.zzb((Object) activity, (Object) "Activity must not be null");
        boolean z = zzs.zzavn() || (activity instanceof FragmentActivity);
        zzab.zzb(z, (Object) "This Activity is not supported before platform version 11 (3.0 Honeycomb). Please use FragmentActivity instead.");
        this.f11649a = activity;
    }

    public boolean zzaqq() {
        return this.f11649a instanceof FragmentActivity;
    }

    public Activity zzaqr() {
        return (Activity) this.f11649a;
    }

    public FragmentActivity zzaqs() {
        return (FragmentActivity) this.f11649a;
    }
}
