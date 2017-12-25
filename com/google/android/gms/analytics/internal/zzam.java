package com.google.android.gms.analytics.internal;

public class zzam extends zzq<zzan> {

    private static class zza extends zzc implements com.google.android.gms.analytics.internal.zzq.zza<zzan> {
        private final zzan f10276a = new zzan();

        public zza(zzf com_google_android_gms_analytics_internal_zzf) {
            super(com_google_android_gms_analytics_internal_zzf);
        }

        public /* synthetic */ zzp zzabb() {
            return zzaea();
        }

        public zzan zzaea() {
            return this.f10276a;
        }

        public void zzc(String str, int i) {
            if ("ga_sessionTimeout".equals(str)) {
                this.f10276a.at = i;
            } else {
                zzd("int configuration name not recognized", str);
            }
        }

        public void zzg(String str, boolean z) {
            int i = 1;
            zzan com_google_android_gms_analytics_internal_zzan;
            if ("ga_autoActivityTracking".equals(str)) {
                com_google_android_gms_analytics_internal_zzan = this.f10276a;
                if (!z) {
                    i = 0;
                }
                com_google_android_gms_analytics_internal_zzan.au = i;
            } else if ("ga_anonymizeIp".equals(str)) {
                com_google_android_gms_analytics_internal_zzan = this.f10276a;
                if (!z) {
                    i = 0;
                }
                com_google_android_gms_analytics_internal_zzan.av = i;
            } else if ("ga_reportUncaughtExceptions".equals(str)) {
                com_google_android_gms_analytics_internal_zzan = this.f10276a;
                if (!z) {
                    i = 0;
                }
                com_google_android_gms_analytics_internal_zzan.aw = i;
            } else {
                zzd("bool configuration name not recognized", str);
            }
        }

        public void zzp(String str, String str2) {
            this.f10276a.ax.put(str, str2);
        }

        public void zzq(String str, String str2) {
            if ("ga_trackingId".equals(str)) {
                this.f10276a.zzcrs = str2;
            } else if ("ga_sampleFrequency".equals(str)) {
                try {
                    this.f10276a.as = Double.parseDouble(str2);
                } catch (NumberFormatException e) {
                    zzc("Error parsing ga_sampleFrequency value", str2, e);
                }
            } else {
                zzd("string configuration name not recognized", str);
            }
        }
    }

    public zzam(zzf com_google_android_gms_analytics_internal_zzf) {
        super(com_google_android_gms_analytics_internal_zzf, new zza(com_google_android_gms_analytics_internal_zzf));
    }
}
