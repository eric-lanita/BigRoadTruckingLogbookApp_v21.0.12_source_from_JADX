package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;

public class zzap extends zzd {
    protected String f10279a;
    protected String f10280b;
    protected int f10281c;
    protected boolean f10282d;
    protected int f10283e;
    protected boolean f10284f;
    protected boolean f10285g;

    public zzap(zzf com_google_android_gms_analytics_internal_zzf) {
        super(com_google_android_gms_analytics_internal_zzf);
    }

    private static int m16633a(String str) {
        String toLowerCase = str.toLowerCase();
        return "verbose".equals(toLowerCase) ? 0 : "info".equals(toLowerCase) ? 1 : "warning".equals(toLowerCase) ? 2 : "error".equals(toLowerCase) ? 3 : -1;
    }

    protected void mo1605a() {
        m16636b();
    }

    void m16635a(zzaa com_google_android_gms_analytics_internal_zzaa) {
        int a;
        zzeh("Loading global XML config values");
        if (com_google_android_gms_analytics_internal_zzaa.zzacp()) {
            String zzxb = com_google_android_gms_analytics_internal_zzaa.zzxb();
            this.f10280b = zzxb;
            zzb("XML config - app name", zzxb);
        }
        if (com_google_android_gms_analytics_internal_zzaa.zzacq()) {
            zzxb = com_google_android_gms_analytics_internal_zzaa.zzxc();
            this.f10279a = zzxb;
            zzb("XML config - app version", zzxb);
        }
        if (com_google_android_gms_analytics_internal_zzaa.zzacr()) {
            a = m16633a(com_google_android_gms_analytics_internal_zzaa.zzacs());
            if (a >= 0) {
                this.f10281c = a;
                zza("XML config - log level", Integer.valueOf(a));
            }
        }
        if (com_google_android_gms_analytics_internal_zzaa.zzact()) {
            a = com_google_android_gms_analytics_internal_zzaa.zzacu();
            this.f10283e = a;
            this.f10282d = true;
            zzb("XML config - dispatch period (sec)", Integer.valueOf(a));
        }
        if (com_google_android_gms_analytics_internal_zzaa.zzacv()) {
            boolean zzacw = com_google_android_gms_analytics_internal_zzaa.zzacw();
            this.f10285g = zzacw;
            this.f10284f = true;
            zzb("XML config - dry run", Boolean.valueOf(zzacw));
        }
    }

    protected void m16636b() {
        ApplicationInfo applicationInfo;
        Context g = m16540g();
        try {
            applicationInfo = g.getPackageManager().getApplicationInfo(g.getPackageName(), 129);
        } catch (NameNotFoundException e) {
            zzd("PackageManager doesn't know about the app package", e);
            applicationInfo = null;
        }
        if (applicationInfo == null) {
            zzek("Couldn't get ApplicationInfo to load global config");
            return;
        }
        Bundle bundle = applicationInfo.metaData;
        if (bundle != null) {
            int i = bundle.getInt("com.google.android.gms.analytics.globalConfigResource");
            if (i > 0) {
                zzaa com_google_android_gms_analytics_internal_zzaa = (zzaa) new zzz(zzyu()).zzbx(i);
                if (com_google_android_gms_analytics_internal_zzaa != null) {
                    m16635a(com_google_android_gms_analytics_internal_zzaa);
                }
            }
        }
    }

    public int getLogLevel() {
        m16553s();
        return this.f10281c;
    }

    public boolean zzacr() {
        m16553s();
        return false;
    }

    public boolean zzact() {
        m16553s();
        return this.f10282d;
    }

    public boolean zzacv() {
        m16553s();
        return this.f10284f;
    }

    public boolean zzacw() {
        m16553s();
        return this.f10285g;
    }

    public int zzaek() {
        m16553s();
        return this.f10283e;
    }

    public String zzxb() {
        m16553s();
        return this.f10280b;
    }

    public String zzxc() {
        m16553s();
        return this.f10279a;
    }
}
