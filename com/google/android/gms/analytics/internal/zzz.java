package com.google.android.gms.analytics.internal;

public class zzz extends zzq<zzaa> {

    private static class zza implements com.google.android.gms.analytics.internal.zzq.zza<zzaa> {
        private final zzf f10412a;
        private final zzaa f10413b = new zzaa();

        public zza(zzf com_google_android_gms_analytics_internal_zzf) {
            this.f10412a = com_google_android_gms_analytics_internal_zzf;
        }

        public /* synthetic */ zzp zzabb() {
            return zzaco();
        }

        public zzaa zzaco() {
            return this.f10413b;
        }

        public void zzc(String str, int i) {
            if ("ga_dispatchPeriod".equals(str)) {
                this.f10413b.f10224I = i;
            } else {
                this.f10412a.zzyx().zzd("Int xml configuration name not recognized", str);
            }
        }

        public void zzg(String str, boolean z) {
            if ("ga_dryRun".equals(str)) {
                this.f10413b.f10225J = z ? 1 : 0;
                return;
            }
            this.f10412a.zzyx().zzd("Bool xml configuration name not recognized", str);
        }

        public void zzp(String str, String str2) {
        }

        public void zzq(String str, String str2) {
            if ("ga_appName".equals(str)) {
                this.f10413b.zzcum = str2;
            } else if ("ga_appVersion".equals(str)) {
                this.f10413b.zzcun = str2;
            } else if ("ga_logLevel".equals(str)) {
                this.f10413b.f10223H = str2;
            } else {
                this.f10412a.zzyx().zzd("String xml configuration name not recognized", str);
            }
        }
    }

    public zzz(zzf com_google_android_gms_analytics_internal_zzf) {
        super(com_google_android_gms_analytics_internal_zzf, new zza(com_google_android_gms_analytics_internal_zzf));
    }
}
