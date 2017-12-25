package com.urbanairship;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

@TargetApi(14)
public abstract class C3731i {
    private final Application f13392a;
    private final ActivityLifecycleCallbacks f13393b;
    private boolean f13394c = false;

    class C37821 implements ActivityLifecycleCallbacks {
        final /* synthetic */ C3731i f13562a;

        C37821(C3731i c3731i) {
            this.f13562a = c3731i;
        }

        public void onActivityPaused(Activity activity) {
            this.f13562a.mo2830c(activity);
        }

        public void onActivityResumed(Activity activity) {
            this.f13562a.mo2831d(activity);
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            this.f13562a.mo2775b(activity);
        }

        public void onActivityStopped(Activity activity) {
            this.f13562a.mo2774a(activity);
        }
    }

    public C3731i(Application application) {
        this.f13392a = application;
        this.f13393b = new C37821(this);
    }

    public void m19431a() {
        if (!this.f13394c) {
            this.f13392a.registerActivityLifecycleCallbacks(this.f13393b);
            this.f13394c = true;
        }
    }

    public void mo2774a(Activity activity) {
    }

    public void mo2775b(Activity activity) {
    }

    public void mo2830c(Activity activity) {
    }

    public void mo2831d(Activity activity) {
    }
}
