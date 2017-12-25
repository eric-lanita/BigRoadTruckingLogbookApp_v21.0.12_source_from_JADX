package com.google.android.gms.analytics;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.analytics.internal.zzad;
import com.google.android.gms.analytics.internal.zzan;
import com.google.android.gms.analytics.internal.zzao;
import com.google.android.gms.analytics.internal.zzd;
import com.google.android.gms.analytics.internal.zze;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzh;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzlu;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class Tracker extends zzd {
    private boolean f10205a;
    private final Map<String, String> f10206b = new HashMap();
    private final Map<String, String> f10207c = new HashMap();
    private final zzad f10208d;
    private final zza f10209e;
    private ExceptionReporter f10210f;
    private zzan f10211g;

    private class zza extends zzd implements zza {
        final /* synthetic */ Tracker f10199a;
        private boolean f10200b;
        private int f10201c;
        private long f10202d = -1;
        private boolean f10203e;
        private long f10204f;

        protected zza(Tracker tracker, zzf com_google_android_gms_analytics_internal_zzf) {
            this.f10199a = tracker;
            super(com_google_android_gms_analytics_internal_zzf);
        }

        private void m16554c() {
            if (this.f10202d >= 0 || this.f10200b) {
                zzvx().m16526a(this.f10199a.f10209e);
            } else {
                zzvx().m16529b(this.f10199a.f10209e);
            }
        }

        protected void mo1605a() {
        }

        boolean m16556b() {
            return m16539f().elapsedRealtime() >= this.f10204f + Math.max(1000, this.f10202d);
        }

        public void enableAutoActivityTracking(boolean z) {
            this.f10200b = z;
            m16554c();
        }

        public void setSessionTimeout(long j) {
            this.f10202d = j;
            m16554c();
        }

        public void zzo(Activity activity) {
            if (this.f10201c == 0 && m16556b()) {
                this.f10203e = true;
            }
            this.f10201c++;
            if (this.f10200b) {
                Intent intent = activity.getIntent();
                if (intent != null) {
                    this.f10199a.setCampaignParamsOnNextHit(intent.getData());
                }
                Map hashMap = new HashMap();
                hashMap.put("&t", "screenview");
                this.f10199a.set("&cd", this.f10199a.f10211g != null ? this.f10199a.f10211g.zzr(activity) : activity.getClass().getCanonicalName());
                if (TextUtils.isEmpty((CharSequence) hashMap.get("&dr"))) {
                    CharSequence a = Tracker.m16558a(activity);
                    if (!TextUtils.isEmpty(a)) {
                        hashMap.put("&dr", a);
                    }
                }
                this.f10199a.send(hashMap);
            }
        }

        public void zzp(Activity activity) {
            this.f10201c--;
            this.f10201c = Math.max(0, this.f10201c);
            if (this.f10201c == 0) {
                this.f10204f = m16539f().elapsedRealtime();
            }
        }

        public synchronized boolean zzwy() {
            boolean z;
            z = this.f10203e;
            this.f10203e = false;
            return z;
        }
    }

    Tracker(zzf com_google_android_gms_analytics_internal_zzf, String str, zzad com_google_android_gms_analytics_internal_zzad) {
        super(com_google_android_gms_analytics_internal_zzf);
        if (str != null) {
            this.f10206b.put("&tid", str);
        }
        this.f10206b.put("useSecure", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        this.f10206b.put("&a", Integer.toString(new Random().nextInt(Integer.MAX_VALUE) + 1));
        if (com_google_android_gms_analytics_internal_zzad == null) {
            this.f10208d = new zzad("tracking", m16539f());
        } else {
            this.f10208d = com_google_android_gms_analytics_internal_zzad;
        }
        this.f10209e = new zza(this, com_google_android_gms_analytics_internal_zzf);
    }

    static String m16558a(Activity activity) {
        zzab.zzy(activity);
        Intent intent = activity.getIntent();
        if (intent == null) {
            return null;
        }
        CharSequence stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        return !TextUtils.isEmpty(stringExtra) ? stringExtra : null;
    }

    private static void m16559a(Map<String, String> map, Map<String, String> map2) {
        zzab.zzy(map2);
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                String b = m16562b(entry);
                if (b != null) {
                    map2.put(b, (String) entry.getValue());
                }
            }
        }
    }

    private static boolean m16560a(Entry<String, String> entry) {
        String str = (String) entry.getKey();
        String str2 = (String) entry.getValue();
        return str.startsWith("&") && str.length() >= 2;
    }

    private static String m16562b(Entry<String, String> entry) {
        return !m16560a((Entry) entry) ? null : ((String) entry.getKey()).substring(1);
    }

    private static void m16563b(Map<String, String> map, Map<String, String> map2) {
        zzab.zzy(map2);
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                String b = m16562b(entry);
                if (!(b == null || map2.containsKey(b))) {
                    map2.put(b, (String) entry.getValue());
                }
            }
        }
    }

    private boolean m16565c() {
        return this.f10210f != null;
    }

    protected void mo1605a() {
        this.f10209e.initialize();
        String zzxb = m16546m().zzxb();
        if (zzxb != null) {
            set("&an", zzxb);
        }
        zzxb = m16546m().zzxc();
        if (zzxb != null) {
            set("&av", zzxb);
        }
    }

    void m16575a(zzan com_google_android_gms_analytics_internal_zzan) {
        zzeh("Loading Tracker config values");
        this.f10211g = com_google_android_gms_analytics_internal_zzan;
        if (this.f10211g.zzaeb()) {
            String trackingId = this.f10211g.getTrackingId();
            set("&tid", trackingId);
            zza("trackingId loaded", trackingId);
        }
        if (this.f10211g.zzaec()) {
            trackingId = Double.toString(this.f10211g.zzaed());
            set("&sf", trackingId);
            zza("Sample frequency loaded", trackingId);
        }
        if (this.f10211g.zzaee()) {
            int sessionTimeout = this.f10211g.getSessionTimeout();
            setSessionTimeout((long) sessionTimeout);
            zza("Session timeout loaded", Integer.valueOf(sessionTimeout));
        }
        if (this.f10211g.zzaef()) {
            boolean zzaeg = this.f10211g.zzaeg();
            enableAutoActivityTracking(zzaeg);
            zza("Auto activity tracking loaded", Boolean.valueOf(zzaeg));
        }
        if (this.f10211g.zzaeh()) {
            zzaeg = this.f10211g.zzaei();
            if (zzaeg) {
                set("&aip", AppEventsConstants.EVENT_PARAM_VALUE_YES);
            }
            zza("Anonymize ip loaded", Boolean.valueOf(zzaeg));
        }
        enableExceptionReporting(this.f10211g.zzaej());
    }

    boolean m16576b() {
        return this.f10205a;
    }

    public void enableAdvertisingIdCollection(boolean z) {
        this.f10205a = z;
    }

    public void enableAutoActivityTracking(boolean z) {
        this.f10209e.enableAutoActivityTracking(z);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void enableExceptionReporting(boolean r4) {
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = r3.m16565c();	 Catch:{ all -> 0x0026 }
        if (r0 != r4) goto L_0x0009;
    L_0x0007:
        monitor-exit(r3);	 Catch:{ all -> 0x0026 }
    L_0x0008:
        return;
    L_0x0009:
        if (r4 == 0) goto L_0x0029;
    L_0x000b:
        r0 = r3.m16540g();	 Catch:{ all -> 0x0026 }
        r1 = java.lang.Thread.getDefaultUncaughtExceptionHandler();	 Catch:{ all -> 0x0026 }
        r2 = new com.google.android.gms.analytics.ExceptionReporter;	 Catch:{ all -> 0x0026 }
        r2.<init>(r3, r1, r0);	 Catch:{ all -> 0x0026 }
        r3.f10210f = r2;	 Catch:{ all -> 0x0026 }
        r0 = r3.f10210f;	 Catch:{ all -> 0x0026 }
        java.lang.Thread.setDefaultUncaughtExceptionHandler(r0);	 Catch:{ all -> 0x0026 }
        r0 = "Uncaught exceptions will be reported to Google Analytics";
        r3.zzeh(r0);	 Catch:{ all -> 0x0026 }
    L_0x0024:
        monitor-exit(r3);	 Catch:{ all -> 0x0026 }
        goto L_0x0008;
    L_0x0026:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0026 }
        throw r0;
    L_0x0029:
        r0 = r3.f10210f;	 Catch:{ all -> 0x0026 }
        r0 = r0.m16516b();	 Catch:{ all -> 0x0026 }
        java.lang.Thread.setDefaultUncaughtExceptionHandler(r0);	 Catch:{ all -> 0x0026 }
        r0 = "Uncaught exceptions will not be reported to Google Analytics";
        r3.zzeh(r0);	 Catch:{ all -> 0x0026 }
        goto L_0x0024;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.Tracker.enableExceptionReporting(boolean):void");
    }

    public String get(String str) {
        m16553s();
        return TextUtils.isEmpty(str) ? null : this.f10206b.containsKey(str) ? (String) this.f10206b.get(str) : str.equals("&ul") ? zzao.zza(Locale.getDefault()) : str.equals("&cid") ? m16548o().zzaav() : str.equals("&sr") ? m16551r().zzacl() : str.equals("&aid") ? m16550q().zzaad().zzsh() : str.equals("&an") ? m16550q().zzaad().zzxb() : str.equals("&av") ? m16550q().zzaad().zzxc() : str.equals("&aiid") ? m16550q().zzaad().zzxd() : null;
    }

    public void send(Map<String, String> map) {
        final long currentTimeMillis = m16539f().currentTimeMillis();
        if (zzvx().getAppOptOut()) {
            zzei("AppOptOut is set to true. Not sending Google Analytics hit");
            return;
        }
        final boolean isDryRunEnabled = zzvx().isDryRunEnabled();
        final Map hashMap = new HashMap();
        m16559a(this.f10206b, hashMap);
        m16559a(map, hashMap);
        final boolean zzi = zzao.zzi((String) this.f10206b.get("useSecure"), true);
        m16563b(this.f10207c, hashMap);
        this.f10207c.clear();
        final String str = (String) hashMap.get("t");
        if (TextUtils.isEmpty(str)) {
            m16541h().zzh(hashMap, "Missing hit type parameter");
            return;
        }
        final String str2 = (String) hashMap.get("tid");
        if (TextUtils.isEmpty(str2)) {
            m16541h().zzh(hashMap, "Missing tracking id parameter");
            return;
        }
        final boolean b = m16576b();
        synchronized (this) {
            if ("screenview".equalsIgnoreCase(str) || "pageview".equalsIgnoreCase(str) || "appview".equalsIgnoreCase(str) || TextUtils.isEmpty(str)) {
                int parseInt = Integer.parseInt((String) this.f10206b.get("&a")) + 1;
                if (parseInt >= Integer.MAX_VALUE) {
                    parseInt = 1;
                }
                this.f10206b.put("&a", Integer.toString(parseInt));
            }
        }
        m16543j().zzg(new Runnable(this) {
            final /* synthetic */ Tracker f10196h;

            public void run() {
                boolean z = true;
                if (this.f10196h.f10209e.zzwy()) {
                    hashMap.put("sc", "start");
                }
                zzao.zzd(hashMap, "cid", this.f10196h.zzvx().zzwb());
                String str = (String) hashMap.get("sf");
                if (str != null) {
                    double zza = zzao.zza(str, 100.0d);
                    if (zzao.zza(zza, (String) hashMap.get("cid"))) {
                        this.f10196h.zzb("Sampling enabled. Hit sampled out. sample rate", Double.valueOf(zza));
                        return;
                    }
                }
                com.google.android.gms.analytics.internal.zza b = this.f10196h.m16549p();
                if (b) {
                    zzao.zzb(hashMap, "ate", b.zzxz());
                    zzao.zzc(hashMap, "adid", b.zzyk());
                } else {
                    hashMap.remove("ate");
                    hashMap.remove("adid");
                }
                zzlu zzaad = this.f10196h.m16550q().zzaad();
                zzao.zzc(hashMap, "an", zzaad.zzxb());
                zzao.zzc(hashMap, "av", zzaad.zzxc());
                zzao.zzc(hashMap, "aid", zzaad.zzsh());
                zzao.zzc(hashMap, "aiid", zzaad.zzxd());
                hashMap.put("v", AppEventsConstants.EVENT_PARAM_VALUE_YES);
                hashMap.put("_v", zze.zzcwr);
                zzao.zzc(hashMap, "ul", this.f10196h.m16551r().zzack().getLanguage());
                zzao.zzc(hashMap, "sr", this.f10196h.m16551r().zzacl());
                boolean z2 = str.equals("transaction") || str.equals("item");
                if (z2 || this.f10196h.f10208d.zzade()) {
                    long zzey = zzao.zzey((String) hashMap.get("ht"));
                    if (zzey == 0) {
                        zzey = currentTimeMillis;
                    }
                    if (isDryRunEnabled) {
                        this.f10196h.m16541h().zzc("Dry run enabled. Would have sent hit", new com.google.android.gms.analytics.internal.zzab(this.f10196h, hashMap, zzey, zzi));
                        return;
                    }
                    String str2 = (String) hashMap.get("cid");
                    Map hashMap = new HashMap();
                    zzao.zza(hashMap, "uid", hashMap);
                    zzao.zza(hashMap, "an", hashMap);
                    zzao.zza(hashMap, "aid", hashMap);
                    zzao.zza(hashMap, "av", hashMap);
                    zzao.zza(hashMap, "aiid", hashMap);
                    String str3 = str2;
                    if (TextUtils.isEmpty((CharSequence) hashMap.get("adid"))) {
                        z = false;
                    }
                    hashMap.put("_s", String.valueOf(this.f10196h.m16544k().zza(new zzh(0, str2, str3, z, 0, hashMap))));
                    this.f10196h.m16544k().zza(new com.google.android.gms.analytics.internal.zzab(this.f10196h, hashMap, zzey, zzi));
                    return;
                }
                this.f10196h.m16541h().zzh(hashMap, "Too many hits sent too quickly, rate limiting invoked");
            }
        });
    }

    public void set(String str, String str2) {
        zzab.zzb((Object) str, (Object) "Key should be non-null");
        if (!TextUtils.isEmpty(str)) {
            this.f10206b.put(str, str2);
        }
    }

    public void setAnonymizeIp(boolean z) {
        set("&aip", zzao.zzat(z));
    }

    public void setAppId(String str) {
        set("&aid", str);
    }

    public void setAppInstallerId(String str) {
        set("&aiid", str);
    }

    public void setAppName(String str) {
        set("&an", str);
    }

    public void setAppVersion(String str) {
        set("&av", str);
    }

    public void setCampaignParamsOnNextHit(Uri uri) {
        if (uri != null && !uri.isOpaque()) {
            CharSequence queryParameter = uri.getQueryParameter("referrer");
            if (!TextUtils.isEmpty(queryParameter)) {
                String str = "http://hostname/?";
                String valueOf = String.valueOf(queryParameter);
                Uri parse = Uri.parse(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                str = parse.getQueryParameter("utm_id");
                if (str != null) {
                    this.f10207c.put("&ci", str);
                }
                str = parse.getQueryParameter("anid");
                if (str != null) {
                    this.f10207c.put("&anid", str);
                }
                str = parse.getQueryParameter("utm_campaign");
                if (str != null) {
                    this.f10207c.put("&cn", str);
                }
                str = parse.getQueryParameter("utm_content");
                if (str != null) {
                    this.f10207c.put("&cc", str);
                }
                str = parse.getQueryParameter("utm_medium");
                if (str != null) {
                    this.f10207c.put("&cm", str);
                }
                str = parse.getQueryParameter("utm_source");
                if (str != null) {
                    this.f10207c.put("&cs", str);
                }
                str = parse.getQueryParameter("utm_term");
                if (str != null) {
                    this.f10207c.put("&ck", str);
                }
                str = parse.getQueryParameter("dclid");
                if (str != null) {
                    this.f10207c.put("&dclid", str);
                }
                str = parse.getQueryParameter("gclid");
                if (str != null) {
                    this.f10207c.put("&gclid", str);
                }
                valueOf = parse.getQueryParameter("aclid");
                if (valueOf != null) {
                    this.f10207c.put("&aclid", valueOf);
                }
            }
        }
    }

    public void setClientId(String str) {
        set("&cid", str);
    }

    public void setEncoding(String str) {
        set("&de", str);
    }

    public void setHostname(String str) {
        set("&dh", str);
    }

    public void setLanguage(String str) {
        set("&ul", str);
    }

    public void setLocation(String str) {
        set("&dl", str);
    }

    public void setPage(String str) {
        set("&dp", str);
    }

    public void setReferrer(String str) {
        set("&dr", str);
    }

    public void setSampleRate(double d) {
        set("&sf", Double.toString(d));
    }

    public void setScreenColors(String str) {
        set("&sd", str);
    }

    public void setScreenName(String str) {
        set("&cd", str);
    }

    public void setScreenResolution(int i, int i2) {
        if (i >= 0 || i2 >= 0) {
            set("&sr", i + "x" + i2);
        } else {
            zzek("Invalid width or height. The values should be non-negative.");
        }
    }

    public void setSessionTimeout(long j) {
        this.f10209e.setSessionTimeout(1000 * j);
    }

    public void setTitle(String str) {
        set("&dt", str);
    }

    public void setUseSecure(boolean z) {
        set("useSecure", zzao.zzat(z));
    }

    public void setViewportSize(String str) {
        set("&vp", str);
    }
}
