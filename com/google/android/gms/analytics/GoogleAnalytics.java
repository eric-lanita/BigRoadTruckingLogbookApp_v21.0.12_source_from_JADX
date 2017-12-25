package com.google.android.gms.analytics;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.analytics.internal.zzae;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzan;
import com.google.android.gms.analytics.internal.zzap;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzy;
import com.google.android.gms.common.internal.zzab;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class GoogleAnalytics extends zza {
    private static List<Runnable> f10176b = new ArrayList();
    private boolean f10177c;
    private Set<zza> f10178d = new HashSet();
    private boolean f10179e;
    private boolean f10180f;
    private volatile boolean f10181g;
    private boolean f10182h;

    interface zza {
        void zzo(Activity activity);

        void zzp(Activity activity);
    }

    @TargetApi(14)
    class zzb implements ActivityLifecycleCallbacks {
        final /* synthetic */ GoogleAnalytics f10170a;

        zzb(GoogleAnalytics googleAnalytics) {
            this.f10170a = googleAnalytics;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            this.f10170a.m16525a(activity);
        }

        public void onActivityStopped(Activity activity) {
            this.f10170a.m16528b(activity);
        }
    }

    public GoogleAnalytics(zzf com_google_android_gms_analytics_internal_zzf) {
        super(com_google_android_gms_analytics_internal_zzf);
    }

    private com.google.android.gms.analytics.internal.zzb m16522e() {
        return m16521c().zzwd();
    }

    private zzap m16523f() {
        return m16521c().zzwe();
    }

    public static GoogleAnalytics getInstance(Context context) {
        return zzf.zzay(context).zzzk();
    }

    public static void zzwa() {
        synchronized (GoogleAnalytics.class) {
            if (f10176b != null) {
                for (Runnable run : f10176b) {
                    run.run();
                }
                f10176b = null;
            }
        }
    }

    void m16524a() {
        zzap f = m16523f();
        if (f.zzacr()) {
            getLogger().setLogLevel(f.getLogLevel());
        }
        if (f.zzacv()) {
            setDryRun(f.zzacw());
        }
        if (f.zzacr()) {
            Logger logger = zzae.getLogger();
            if (logger != null) {
                logger.setLogLevel(f.getLogLevel());
            }
        }
    }

    void m16525a(Activity activity) {
        for (zza zzo : this.f10178d) {
            zzo.zzo(activity);
        }
    }

    void m16526a(zza com_google_android_gms_analytics_GoogleAnalytics_zza) {
        this.f10178d.add(com_google_android_gms_analytics_GoogleAnalytics_zza);
        Context context = m16521c().getContext();
        if (context instanceof Application) {
            enableAutoActivityReports((Application) context);
        }
    }

    void m16527b() {
        m16522e().zzyq();
    }

    void m16528b(Activity activity) {
        for (zza zzp : this.f10178d) {
            zzp.zzp(activity);
        }
    }

    void m16529b(zza com_google_android_gms_analytics_GoogleAnalytics_zza) {
        this.f10178d.remove(com_google_android_gms_analytics_GoogleAnalytics_zza);
    }

    public void dispatchLocalHits() {
        m16522e().zzyp();
    }

    @TargetApi(14)
    public void enableAutoActivityReports(Application application) {
        if (VERSION.SDK_INT >= 14 && !this.f10179e) {
            application.registerActivityLifecycleCallbacks(new zzb(this));
            this.f10179e = true;
        }
    }

    public boolean getAppOptOut() {
        return this.f10181g;
    }

    @Deprecated
    public Logger getLogger() {
        return zzae.getLogger();
    }

    public void initialize() {
        m16524a();
        this.f10177c = true;
    }

    public boolean isDryRunEnabled() {
        return this.f10180f;
    }

    public boolean isInitialized() {
        return this.f10177c;
    }

    public Tracker newTracker(int i) {
        Tracker tracker;
        synchronized (this) {
            tracker = new Tracker(m16521c(), null, null);
            if (i > 0) {
                zzan com_google_android_gms_analytics_internal_zzan = (zzan) new zzam(m16521c()).zzbx(i);
                if (com_google_android_gms_analytics_internal_zzan != null) {
                    tracker.m16575a(com_google_android_gms_analytics_internal_zzan);
                }
            }
            tracker.initialize();
        }
        return tracker;
    }

    public Tracker newTracker(String str) {
        Tracker tracker;
        synchronized (this) {
            tracker = new Tracker(m16521c(), str, null);
            tracker.initialize();
        }
        return tracker;
    }

    public void reportActivityStart(Activity activity) {
        if (!this.f10179e) {
            m16525a(activity);
        }
    }

    public void reportActivityStop(Activity activity) {
        if (!this.f10179e) {
            m16528b(activity);
        }
    }

    public void setAppOptOut(boolean z) {
        this.f10181g = z;
        if (this.f10181g) {
            m16522e().zzyo();
        }
    }

    public void setDryRun(boolean z) {
        this.f10180f = z;
    }

    public void setLocalDispatchPeriod(int i) {
        m16522e().setLocalDispatchPeriod(i);
    }

    @Deprecated
    public void setLogger(Logger logger) {
        zzae.setLogger(logger);
        if (!this.f10182h) {
            String str = (String) zzy.zzczn.get();
            Log.i((String) zzy.zzczn.get(), new StringBuilder(String.valueOf(str).length() + 112).append("GoogleAnalytics.setLogger() is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag.").append(str).append(" DEBUG").toString());
            this.f10182h = true;
        }
    }

    public String zzwb() {
        zzab.zzhj("getClientId can not be called from the main thread");
        return m16521c().zzzn().zzaav();
    }
}
