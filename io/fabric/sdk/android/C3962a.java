package io.fabric.sdk.android;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Set;

public class C3962a {
    private final Application f14024a;
    private C3961a f14025b;

    public static abstract class C2819b {
        public void mo1434a(Activity activity, Bundle bundle) {
        }

        public void mo1425a(Activity activity) {
        }

        public void mo1435b(Activity activity) {
        }

        public void mo1437c(Activity activity) {
        }

        public void mo1438d(Activity activity) {
        }

        public void mo1436b(Activity activity, Bundle bundle) {
        }

        public void mo1439e(Activity activity) {
        }
    }

    private static class C3961a {
        private final Set<ActivityLifecycleCallbacks> f14022a = new HashSet();
        private final Application f14023b;

        C3961a(Application application) {
            this.f14023b = application;
        }

        @TargetApi(14)
        private void m20527a() {
            for (ActivityLifecycleCallbacks unregisterActivityLifecycleCallbacks : this.f14022a) {
                this.f14023b.unregisterActivityLifecycleCallbacks(unregisterActivityLifecycleCallbacks);
            }
        }

        @TargetApi(14)
        private boolean m20530a(final C2819b c2819b) {
            if (this.f14023b == null) {
                return false;
            }
            ActivityLifecycleCallbacks c39601 = new ActivityLifecycleCallbacks(this) {
                final /* synthetic */ C3961a f14021b;

                public void onActivityCreated(Activity activity, Bundle bundle) {
                    c2819b.mo1434a(activity, bundle);
                }

                public void onActivityStarted(Activity activity) {
                    c2819b.mo1425a(activity);
                }

                public void onActivityResumed(Activity activity) {
                    c2819b.mo1435b(activity);
                }

                public void onActivityPaused(Activity activity) {
                    c2819b.mo1437c(activity);
                }

                public void onActivityStopped(Activity activity) {
                    c2819b.mo1438d(activity);
                }

                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    c2819b.mo1436b(activity, bundle);
                }

                public void onActivityDestroyed(Activity activity) {
                    c2819b.mo1439e(activity);
                }
            };
            this.f14023b.registerActivityLifecycleCallbacks(c39601);
            this.f14022a.add(c39601);
            return true;
        }
    }

    public C3962a(Context context) {
        this.f14024a = (Application) context.getApplicationContext();
        if (VERSION.SDK_INT >= 14) {
            this.f14025b = new C3961a(this.f14024a);
        }
    }

    public boolean m20532a(C2819b c2819b) {
        return this.f14025b != null && this.f14025b.m20530a(c2819b);
    }

    public void m20531a() {
        if (this.f14025b != null) {
            this.f14025b.m20527a();
        }
    }
}
