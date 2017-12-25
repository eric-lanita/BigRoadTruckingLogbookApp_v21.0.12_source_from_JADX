package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.internal.zzqf;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;

public class zzn extends zzaa {
    private static final X500Principal f12276a = new X500Principal("CN=Android Debug,O=Android,C=US");
    private String f12277c;
    private String f12278d;
    private int f12279e;
    private String f12280f;
    private String f12281g;
    private long f12282h;
    private String f12283i;

    zzn(zzx com_google_android_gms_measurement_internal_zzx) {
        super(com_google_android_gms_measurement_internal_zzx);
    }

    AppMetadata m17885a(String str) {
        return new AppMetadata(m17888e(), m17889f(), m17890g(), (long) m17891h(), m17892i(), m17893j(), m17894k(), str, this.b.isEnabled(), !zzbse().akm, zzbse().m17931f());
    }

    protected void m17886a(Status status) {
        if (status == null) {
            zzbsd().zzbsv().log("GoogleService failed to initialize (no status)");
        } else {
            zzbsd().zzbsv().zze("GoogleService failed to initialize, status", Integer.valueOf(status.getStatusCode()), status.getStatusMessage());
        }
    }

    protected void mo2375d() {
        String str = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        int i = Integer.MIN_VALUE;
        String str2 = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        PackageManager packageManager = getContext().getPackageManager();
        String packageName = getContext().getPackageName();
        String installerPackageName = packageManager.getInstallerPackageName(packageName);
        if (installerPackageName == null) {
            installerPackageName = "manual_install";
        } else if ("com.android.vending".equals(installerPackageName)) {
            installerPackageName = "";
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(getContext().getPackageName(), 0);
            if (packageInfo != null) {
                CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                if (!TextUtils.isEmpty(applicationLabel)) {
                    str2 = applicationLabel.toString();
                }
                str = packageInfo.versionName;
                i = packageInfo.versionCode;
            }
        } catch (NameNotFoundException e) {
            zzbsd().zzbsv().zzj("Error retrieving package info: appName", str2);
        }
        this.f12277c = packageName;
        this.f12280f = installerPackageName;
        this.f12278d = str;
        this.f12279e = i;
        this.f12281g = str2;
        MessageDigest c = zzal.m17811c("MD5");
        if (c == null) {
            zzbsd().zzbsv().log("Could not get MD5 instance");
            this.f12282h = -1;
        } else {
            this.f12282h = 0;
            try {
                if (!m17895l()) {
                    PackageInfo packageInfo2 = packageManager.getPackageInfo(getContext().getPackageName(), 64);
                    if (packageInfo2.signatures != null && packageInfo2.signatures.length > 0) {
                        this.f12282h = zzal.m17797a(c.digest(packageInfo2.signatures[0].toByteArray()));
                    }
                }
            } catch (NameNotFoundException e2) {
                zzbsd().zzbsv().zzj("Package name not found", e2);
            }
        }
        Status zzc = zzbsf().zzabc() ? zzqf.zzc(getContext(), "-", true) : zzqf.zzcb(getContext());
        boolean z = zzc != null && zzc.isSuccess();
        if (!z) {
            m17886a(zzc);
        }
        if (z) {
            Boolean zzbre = zzbsf().zzbre();
            if (zzbsf().zzbrd()) {
                zzbsd().zzbta().log("Collection disabled with firebase_analytics_collection_deactivated=1");
                z = false;
            } else if (zzbre != null && !zzbre.booleanValue()) {
                zzbsd().zzbta().log("Collection disabled with firebase_analytics_collection_enabled=0");
                z = false;
            } else if (zzbre == null && zzbsf().zzaqp()) {
                zzbsd().zzbta().log("Collection disabled with google_app_measurement_enable=0");
                z = false;
            } else {
                zzbsd().zzbtc().log("Collection enabled");
                z = true;
            }
        } else {
            z = false;
        }
        this.f12283i = "";
        if (!zzbsf().zzabc()) {
            try {
                String zzaqo = zzqf.zzaqo();
                if (TextUtils.isEmpty(zzaqo)) {
                    zzaqo = "";
                }
                this.f12283i = zzaqo;
                if (z) {
                    zzbsd().zzbtc().zze("App package, google app id", this.f12277c, this.f12283i);
                }
            } catch (IllegalStateException e3) {
                zzbsd().zzbsv().zzj("getGoogleAppId or isMeasurementEnabled failed with exception", e3);
            }
        }
    }

    String m17888e() {
        m17715c();
        return this.f12277c;
    }

    String m17889f() {
        m17715c();
        return this.f12283i;
    }

    String m17890g() {
        m17715c();
        return this.f12278d;
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    int m17891h() {
        m17715c();
        return this.f12279e;
    }

    String m17892i() {
        m17715c();
        return this.f12280f;
    }

    long m17893j() {
        return zzbsf().zzbpz();
    }

    long m17894k() {
        m17715c();
        return this.f12282h;
    }

    boolean m17895l() {
        try {
            PackageInfo packageInfo = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 64);
            if (!(packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length <= 0)) {
                return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray()))).getSubjectX500Principal().equals(f12276a);
            }
        } catch (CertificateException e) {
            zzbsd().zzbsv().zzj("Error obtaining certificate", e);
        } catch (NameNotFoundException e2) {
            zzbsd().zzbsv().zzj("Package name not found", e2);
        }
        return true;
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
