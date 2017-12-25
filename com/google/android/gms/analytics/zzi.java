package com.google.android.gms.analytics;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.google.android.gms.analytics.internal.zzao;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzlu;
import com.google.android.gms.internal.zzlz;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzi {
    private static volatile zzi f10439a;
    private final Context f10440b;
    private final List<zzj> f10441c = new CopyOnWriteArrayList();
    private final zzd f10442d = new zzd();
    private final zza f10443e = new zza(this);
    private volatile zzlu f10444f;
    private UncaughtExceptionHandler f10445g;

    private class zza extends ThreadPoolExecutor {
        final /* synthetic */ zzi f10437a;

        public zza(zzi com_google_android_gms_analytics_zzi) {
            this.f10437a = com_google_android_gms_analytics_zzi;
            super(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
            setThreadFactory(new zzb());
        }

        protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
            return new FutureTask<T>(this, runnable, t) {
                final /* synthetic */ zza f10436a;

                protected void setException(Throwable th) {
                    UncaughtExceptionHandler b = this.f10436a.f10437a.f10445g;
                    if (b != null) {
                        b.uncaughtException(Thread.currentThread(), th);
                    } else if (Log.isLoggable("GAv4", 6)) {
                        String valueOf = String.valueOf(th);
                        Log.e("GAv4", new StringBuilder(String.valueOf(valueOf).length() + 37).append("MeasurementExecutor: job failed with ").append(valueOf).toString());
                    }
                    super.setException(th);
                }
            };
        }
    }

    private static class zzb implements ThreadFactory {
        private static final AtomicInteger f10438a = new AtomicInteger();

        private zzb() {
        }

        public Thread newThread(Runnable runnable) {
            return new zzc(runnable, "measurement-" + f10438a.incrementAndGet());
        }
    }

    private static class zzc extends Thread {
        zzc(Runnable runnable, String str) {
            super(runnable, str);
        }

        public void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    zzi(Context context) {
        Context applicationContext = context.getApplicationContext();
        zzab.zzy(applicationContext);
        this.f10440b = applicationContext;
    }

    private void m16752b(zze com_google_android_gms_analytics_zze) {
        zzab.zzhj("deliver should be called from worker thread");
        zzab.zzb(com_google_android_gms_analytics_zze.zzwk(), (Object) "Measurement must be submitted");
        List<zzk> zzwh = com_google_android_gms_analytics_zze.zzwh();
        if (!zzwh.isEmpty()) {
            Set hashSet = new HashSet();
            for (zzk com_google_android_gms_analytics_zzk : zzwh) {
                Uri zzvu = com_google_android_gms_analytics_zzk.zzvu();
                if (!hashSet.contains(zzvu)) {
                    hashSet.add(zzvu);
                    com_google_android_gms_analytics_zzk.zzb(com_google_android_gms_analytics_zze);
                }
            }
        }
    }

    public static zzi zzax(Context context) {
        zzab.zzy(context);
        if (f10439a == null) {
            synchronized (zzi.class) {
                if (f10439a == null) {
                    f10439a = new zzi(context);
                }
            }
        }
        return f10439a;
    }

    public static void zzwu() {
        if (!(Thread.currentThread() instanceof zzc)) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    void m16753a(zze com_google_android_gms_analytics_zze) {
        if (com_google_android_gms_analytics_zze.m16746d()) {
            throw new IllegalStateException("Measurement prototype can't be submitted");
        } else if (com_google_android_gms_analytics_zze.zzwk()) {
            throw new IllegalStateException("Measurement can only be submitted once");
        } else {
            final zze zzwf = com_google_android_gms_analytics_zze.zzwf();
            zzwf.m16743a();
            this.f10443e.execute(new Runnable(this) {
                final /* synthetic */ zzi f10435b;

                public void run() {
                    zzwf.m16744b().mo1601a(zzwf);
                    for (zzj zza : this.f10435b.f10441c) {
                        zza.zza(zzwf);
                    }
                    this.f10435b.m16752b(zzwf);
                }
            });
        }
    }

    public Context getContext() {
        return this.f10440b;
    }

    public void zza(UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f10445g = uncaughtExceptionHandler;
    }

    public <V> Future<V> zzc(Callable<V> callable) {
        zzab.zzy(callable);
        if (!(Thread.currentThread() instanceof zzc)) {
            return this.f10443e.submit(callable);
        }
        Future futureTask = new FutureTask(callable);
        futureTask.run();
        return futureTask;
    }

    public void zzg(Runnable runnable) {
        zzab.zzy(runnable);
        this.f10443e.submit(runnable);
    }

    public zzlu zzws() {
        if (this.f10444f == null) {
            synchronized (this) {
                if (this.f10444f == null) {
                    zzlu com_google_android_gms_internal_zzlu = new zzlu();
                    PackageManager packageManager = this.f10440b.getPackageManager();
                    String packageName = this.f10440b.getPackageName();
                    com_google_android_gms_internal_zzlu.setAppId(packageName);
                    com_google_android_gms_internal_zzlu.setAppInstallerId(packageManager.getInstallerPackageName(packageName));
                    String str = null;
                    try {
                        PackageInfo packageInfo = packageManager.getPackageInfo(this.f10440b.getPackageName(), 0);
                        if (packageInfo != null) {
                            CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                            if (!TextUtils.isEmpty(applicationLabel)) {
                                packageName = applicationLabel.toString();
                            }
                            str = packageInfo.versionName;
                        }
                    } catch (NameNotFoundException e) {
                        String str2 = "GAv4";
                        String str3 = "Error retrieving package info: appName set to ";
                        String valueOf = String.valueOf(packageName);
                        Log.e(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                    }
                    com_google_android_gms_internal_zzlu.setAppName(packageName);
                    com_google_android_gms_internal_zzlu.setAppVersion(str);
                    this.f10444f = com_google_android_gms_internal_zzlu;
                }
            }
        }
        return this.f10444f;
    }

    public zzlz zzwt() {
        DisplayMetrics displayMetrics = this.f10440b.getResources().getDisplayMetrics();
        zzlz com_google_android_gms_internal_zzlz = new zzlz();
        com_google_android_gms_internal_zzlz.setLanguage(zzao.zza(Locale.getDefault()));
        com_google_android_gms_internal_zzlz.zzbq(displayMetrics.widthPixels);
        com_google_android_gms_internal_zzlz.zzbr(displayMetrics.heightPixels);
        return com_google_android_gms_internal_zzlz;
    }
}
