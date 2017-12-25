package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzf;
import com.google.android.gms.measurement.AppMeasurement.zzb;
import com.google.android.gms.measurement.AppMeasurement.zzc;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class zzac extends zzaa {
    private zza f12173a;
    private zzb f12174c;
    private final Set<zzc> f12175d = new HashSet();
    private boolean f12176e;

    @TargetApi(14)
    private class zza implements ActivityLifecycleCallbacks {
        final /* synthetic */ zzac f12172a;

        private zza(zzac com_google_android_gms_measurement_internal_zzac) {
            this.f12172a = com_google_android_gms_measurement_internal_zzac;
        }

        private boolean m17735a(Uri uri) {
            Object queryParameter = uri.getQueryParameter("utm_campaign");
            Object queryParameter2 = uri.getQueryParameter("utm_source");
            Object queryParameter3 = uri.getQueryParameter("utm_medium");
            Object queryParameter4 = uri.getQueryParameter("gclid");
            if (TextUtils.isEmpty(queryParameter) && TextUtils.isEmpty(queryParameter2) && TextUtils.isEmpty(queryParameter3) && TextUtils.isEmpty(queryParameter4)) {
                return false;
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("campaign", queryParameter);
            }
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString(ShareConstants.FEED_SOURCE_PARAM, queryParameter2);
            }
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString("medium", queryParameter3);
            }
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString("gclid", queryParameter4);
            }
            queryParameter = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("term", queryParameter);
            }
            queryParameter = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("content", queryParameter);
            }
            queryParameter = uri.getQueryParameter("aclid");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("aclid", queryParameter);
            }
            queryParameter = uri.getQueryParameter("cp1");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("cp1", queryParameter);
            }
            queryParameter = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("anid", queryParameter);
            }
            this.f12172a.zze("auto", "_cmp", bundle);
            return true;
        }

        private boolean m17736a(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            this.f12172a.zzd("auto", "_ldl", str);
            return true;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            try {
                this.f12172a.zzbsd().zzbtc().log("onActivityCreated");
                Intent intent = activity.getIntent();
                if (intent != null) {
                    Uri data = intent.getData();
                    if (data != null && data.isHierarchical()) {
                        if (bundle == null) {
                            m17735a(data);
                        }
                        String queryParameter = data.getQueryParameter("referrer");
                        if (!TextUtils.isEmpty(queryParameter)) {
                            if (queryParameter.contains("gclid")) {
                                this.f12172a.zzbsd().zzbtb().zzj("Activity created with referrer", queryParameter);
                                m17736a(queryParameter);
                                return;
                            }
                            this.f12172a.zzbsd().zzbtb().log("Activity created with data 'referrer' param without gclid");
                        }
                    }
                }
            } catch (Throwable th) {
                this.f12172a.zzbsd().zzbsv().zzj("Throwable caught in onActivityCreated", th);
            }
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
            this.f12172a.zzbsb().m17792f();
        }

        public void onActivityResumed(Activity activity) {
            this.f12172a.zzbsb().m17791e();
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    protected zzac(zzx com_google_android_gms_measurement_internal_zzx) {
        super(com_google_android_gms_measurement_internal_zzx);
    }

    private void m17740a(String str, String str2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        m17747a(str, str2, zzyw().currentTimeMillis(), bundle, z, z2, z3, str3);
    }

    private void m17741a(String str, String str2, Object obj, long j) {
        zzab.zzhr(str);
        zzab.zzhr(str2);
        zzwu();
        zzyv();
        m17715c();
        if (!this.b.isEnabled()) {
            zzbsd().zzbtb().log("User property not set since app measurement is disabled");
        } else if (this.b.m17990b()) {
            zzbsd().zzbtb().zze("Setting user property (FE)", str2, obj);
            zzbrx().m17770a(new UserAttributeParcel(str2, j, obj, str));
        }
    }

    private void m17742a(boolean z) {
        zzwu();
        zzyv();
        m17715c();
        zzbsd().zzbtb().zzj("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        zzbse().m17926b(z);
        zzbrx().m17773e();
    }

    private void m17743b(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zzab.zzhr(str);
        zzab.zzhr(str2);
        zzab.zzy(bundle);
        zzwu();
        m17715c();
        if (this.b.isEnabled()) {
            if (!this.f12176e) {
                this.f12176e = true;
                m17744e();
            }
            boolean zzmt = zzal.zzmt(str2);
            if (z && this.f12174c != null && !zzmt) {
                zzbsd().zzbtb().zze("Passing event to registered event handler (FE)", str2, bundle);
                this.f12174c.zzb(str, str2, bundle, j);
                return;
            } else if (this.b.m17990b()) {
                int zzml = zzbrz().zzml(str2);
                if (zzml != 0) {
                    this.b.zzbrz().zze(zzml, "_ev", zzbrz().zza(str2, zzbsf().zzbqn(), true));
                    return;
                }
                bundle.putString("_o", str);
                Bundle zza = zzbrz().zza(str2, bundle, zzf.zzz("_o"), z3);
                Bundle a = z2 ? m17746a(zza) : zza;
                zzbsd().zzbtb().zze("Logging event (FE)", str2, a);
                zzbrx().m17769a(new EventParcel(str2, new EventParams(a), str, j), str3);
                for (zzc zzc : this.f12175d) {
                    zzc.zzc(str, str2, a, j);
                }
                return;
            } else {
                return;
            }
        }
        zzbsd().zzbtb().log("Event not sent since app measurement is disabled");
    }

    private void m17744e() {
        try {
            zzg(Class.forName(m17745f()));
        } catch (ClassNotFoundException e) {
            zzbsd().zzbta().log("Tag Manager is not found and thus will not be used");
        }
    }

    private String m17745f() {
        return "com.google.android.gms.tagmanager.TagManagerService";
    }

    Bundle m17746a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object zzl = zzbrz().zzl(str, bundle.get(str));
                if (zzl == null) {
                    zzbsd().zzbsx().zzj("Param value can't be null", str);
                } else if ((!(zzl instanceof String) && !(zzl instanceof Character) && !(zzl instanceof CharSequence)) || !TextUtils.isEmpty(String.valueOf(zzl))) {
                    zzbrz().zza(bundle2, str, zzl);
                }
            }
        }
        return bundle2;
    }

    protected void m17747a(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        final Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        final String str4 = str;
        final String str5 = str2;
        final long j2 = j;
        final boolean z4 = z;
        final boolean z5 = z2;
        final boolean z6 = z3;
        final String str6 = str3;
        zzbsc().zzm(new Runnable(this) {
            final /* synthetic */ zzac f12163i;

            public void run() {
                this.f12163i.m17743b(str4, str5, j2, bundle2, z4, z5, z6, str6);
            }
        });
    }

    void m17748a(String str, String str2, long j, Object obj) {
        final String str3 = str;
        final String str4 = str2;
        final Object obj2 = obj;
        final long j2 = j;
        zzbsc().zzm(new Runnable(this) {
            final /* synthetic */ zzac f12168e;

            public void run() {
                this.f12168e.m17741a(str3, str4, obj2, j2);
            }
        });
    }

    protected void mo2375d() {
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public void setMeasurementEnabled(final boolean z) {
        m17715c();
        zzyv();
        zzbsc().zzm(new Runnable(this) {
            final /* synthetic */ zzac f12150b;

            public void run() {
                this.f12150b.m17742a(z);
            }
        });
    }

    public void setMinimumSessionDuration(final long j) {
        zzyv();
        zzbsc().zzm(new Runnable(this) {
            final /* synthetic */ zzac f12152b;

            public void run() {
                this.f12152b.zzbse().akh.set(j);
                this.f12152b.zzbsd().zzbtb().zzj("Minimum session duration set", Long.valueOf(j));
            }
        });
    }

    public void setSessionTimeoutDuration(final long j) {
        zzyv();
        zzbsc().zzm(new Runnable(this) {
            final /* synthetic */ zzac f12154b;

            public void run() {
                this.f12154b.zzbse().aki.set(j);
                this.f12154b.zzbsd().zzbtb().zzj("Session timeout duration set", Long.valueOf(j));
            }
        });
    }

    public void zza(zzb com_google_android_gms_measurement_AppMeasurement_zzb) {
        zzwu();
        zzyv();
        m17715c();
        if (!(com_google_android_gms_measurement_AppMeasurement_zzb == null || com_google_android_gms_measurement_AppMeasurement_zzb == this.f12174c)) {
            zzab.zza(this.f12174c == null, (Object) "EventInterceptor already set.");
        }
        this.f12174c = com_google_android_gms_measurement_AppMeasurement_zzb;
    }

    public void zza(zzc com_google_android_gms_measurement_AppMeasurement_zzc) {
        zzwu();
        zzyv();
        m17715c();
        zzab.zzy(com_google_android_gms_measurement_AppMeasurement_zzc);
        if (this.f12175d.contains(com_google_android_gms_measurement_AppMeasurement_zzc)) {
            throw new IllegalStateException("OnEventListener already registered.");
        }
        this.f12175d.add(com_google_android_gms_measurement_AppMeasurement_zzc);
    }

    public void zza(String str, String str2, Bundle bundle, boolean z) {
        zzyv();
        boolean z2 = this.f12174c == null || zzal.zzmt(str2);
        m17740a(str, str2, bundle, true, z2, z, null);
    }

    public /* bridge */ /* synthetic */ void zzbrs() {
        super.zzbrs();
    }

    public /* bridge */ /* synthetic */ zzc zzbrt() {
        return super.zzbrt();
    }

    public /* bridge */ /* synthetic */ zzac zzbru() {
        return super.zzbru();
    }

    public /* bridge */ /* synthetic */ zzn zzbrv() {
        return super.zzbrv();
    }

    public /* bridge */ /* synthetic */ zzg zzbrw() {
        return super.zzbrw();
    }

    public /* bridge */ /* synthetic */ zzad zzbrx() {
        return super.zzbrx();
    }

    public /* bridge */ /* synthetic */ zze zzbry() {
        return super.zzbry();
    }

    public /* bridge */ /* synthetic */ zzal zzbrz() {
        return super.zzbrz();
    }

    public /* bridge */ /* synthetic */ zzv zzbsa() {
        return super.zzbsa();
    }

    public /* bridge */ /* synthetic */ zzaf zzbsb() {
        return super.zzbsb();
    }

    public /* bridge */ /* synthetic */ zzw zzbsc() {
        return super.zzbsc();
    }

    public /* bridge */ /* synthetic */ zzp zzbsd() {
        return super.zzbsd();
    }

    public /* bridge */ /* synthetic */ zzt zzbse() {
        return super.zzbse();
    }

    public /* bridge */ /* synthetic */ zzd zzbsf() {
        return super.zzbsf();
    }

    @TargetApi(14)
    public void zzbun() {
        if (getContext().getApplicationContext() instanceof Application) {
            Application application = (Application) getContext().getApplicationContext();
            if (this.f12173a == null) {
                this.f12173a = new zza();
            }
            application.unregisterActivityLifecycleCallbacks(this.f12173a);
            application.registerActivityLifecycleCallbacks(this.f12173a);
            zzbsd().zzbtc().log("Registered activity lifecycle callback");
        }
    }

    public void zzbuo() {
        zzwu();
        zzyv();
        m17715c();
        if (this.b.m17990b()) {
            zzbrx().m17774f();
            String k = zzbse().m17936k();
            if (!TextUtils.isEmpty(k) && !k.equals(zzbrw().zzbso())) {
                Bundle bundle = new Bundle();
                bundle.putString("_po", k);
                zze("auto", "_ou", bundle);
            }
        }
    }

    public List<UserAttributeParcel> zzce(final boolean z) {
        zzyv();
        m17715c();
        zzbsd().zzbtb().log("Fetching user attributes (FE)");
        if (Looper.myLooper() == Looper.getMainLooper()) {
            zzbsd().zzbsx().log("getUserProperties called from main thread.");
            return null;
        }
        final AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            this.b.zzbsc().zzm(new Runnable(this) {
                final /* synthetic */ zzac f12171c;

                public void run() {
                    this.f12171c.zzbrx().m17771a(atomicReference, z);
                }
            });
            try {
                atomicReference.wait(5000);
            } catch (InterruptedException e) {
                zzbsd().zzbsx().zzj("Interrupted waiting for get user properties", e);
            }
        }
        List<UserAttributeParcel> list = (List) atomicReference.get();
        if (list != null) {
            return list;
        }
        zzbsd().zzbsx().log("Timed out waiting for get user properties");
        return null;
    }

    public void zzd(String str, String str2, Bundle bundle, long j) {
        zzyv();
        m17747a(str, str2, j, bundle, false, true, true, null);
    }

    public void zzd(String str, String str2, Object obj) {
        zzab.zzhr(str);
        long currentTimeMillis = zzyw().currentTimeMillis();
        int zzmn = zzbrz().zzmn(str2);
        if (zzmn != 0) {
            this.b.zzbrz().zze(zzmn, "_ev", zzbrz().zza(str2, zzbsf().zzbqo(), true));
        } else if (obj != null) {
            zzmn = zzbrz().zzm(str2, obj);
            if (zzmn != 0) {
                this.b.zzbrz().zze(zzmn, "_ev", zzbrz().zza(str2, zzbsf().zzbqo(), true));
                return;
            }
            Object zzn = zzbrz().zzn(str2, obj);
            if (zzn != null) {
                m17748a(str, str2, currentTimeMillis, zzn);
            }
        } else {
            m17748a(str, str2, currentTimeMillis, null);
        }
    }

    public void zze(String str, String str2, Bundle bundle) {
        zzyv();
        boolean z = this.f12174c == null || zzal.zzmt(str2);
        m17740a(str, str2, bundle, true, z, false, null);
    }

    public void zzg(Class<?> cls) {
        try {
            cls.getDeclaredMethod("initialize", new Class[]{Context.class}).invoke(null, new Object[]{getContext()});
        } catch (Exception e) {
            zzbsd().zzbsx().zzj("Failed to invoke Tag Manager's initialize() method", e);
        }
    }

    public /* bridge */ /* synthetic */ void zzwu() {
        super.zzwu();
    }

    public /* bridge */ /* synthetic */ void zzyv() {
        super.zzyv();
    }

    public /* bridge */ /* synthetic */ zze zzyw() {
        return super.zzyw();
    }
}
