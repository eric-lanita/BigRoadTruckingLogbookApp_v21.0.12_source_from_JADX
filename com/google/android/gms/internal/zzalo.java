package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.firebase.C3611a;
import java.util.concurrent.atomic.AtomicBoolean;

@TargetApi(14)
public class zzalo implements ActivityLifecycleCallbacks, ComponentCallbacks2 {
    private static final zzalo f11143a = new zzalo();
    private final AtomicBoolean f11144b = new AtomicBoolean();
    private boolean f11145c;

    private zzalo() {
    }

    public static void zza(Application application) {
        application.registerActivityLifecycleCallbacks(f11143a);
        application.registerComponentCallbacks(f11143a);
        f11143a.f11145c = true;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (this.f11144b.compareAndSet(true, false)) {
            C3611a.m18857a(false);
        }
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
        if (this.f11144b.compareAndSet(true, false)) {
            C3611a.m18857a(false);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
    }

    public void onTrimMemory(int i) {
        if (i == 20 && this.f11144b.compareAndSet(false, true)) {
            C3611a.m18857a(true);
        }
    }
}
