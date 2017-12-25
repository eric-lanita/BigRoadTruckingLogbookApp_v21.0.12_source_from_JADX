package com.google.android.gms.internal;

public interface zzad {

    public static final class zza extends zzapp<zza> {
        public String stackTrace;
        public String zzck;
        public Long zzcl;
        public String zzcm;
        public String zzcn;
        public Long zzco;
        public Long zzcp;
        public String zzcq;
        public Long zzcr;
        public String zzcs;

        public zza() {
            this.zzck = null;
            this.zzcl = null;
            this.stackTrace = null;
            this.zzcm = null;
            this.zzcn = null;
            this.zzco = null;
            this.zzcp = null;
            this.zzcq = null;
            this.zzcr = null;
            this.zzcs = null;
            this.b = -1;
        }

        protected int mo1813a() {
            int a = super.mo1813a();
            if (this.zzck != null) {
                a += zzapo.zzs(1, this.zzck);
            }
            if (this.zzcl != null) {
                a += zzapo.zze(2, this.zzcl.longValue());
            }
            if (this.stackTrace != null) {
                a += zzapo.zzs(3, this.stackTrace);
            }
            if (this.zzcm != null) {
                a += zzapo.zzs(4, this.zzcm);
            }
            if (this.zzcn != null) {
                a += zzapo.zzs(5, this.zzcn);
            }
            if (this.zzco != null) {
                a += zzapo.zze(6, this.zzco.longValue());
            }
            if (this.zzcp != null) {
                a += zzapo.zze(7, this.zzcp.longValue());
            }
            if (this.zzcq != null) {
                a += zzapo.zzs(8, this.zzcq);
            }
            if (this.zzcr != null) {
                a += zzapo.zze(9, this.zzcr.longValue());
            }
            return this.zzcs != null ? a + zzapo.zzs(10, this.zzcs) : a;
        }

        public zza zza(zzapn com_google_android_gms_internal_zzapn) {
            while (true) {
                int ah = com_google_android_gms_internal_zzapn.ah();
                switch (ah) {
                    case 0:
                        break;
                    case 10:
                        this.zzck = com_google_android_gms_internal_zzapn.readString();
                        continue;
                    case 16:
                        this.zzcl = Long.valueOf(com_google_android_gms_internal_zzapn.ak());
                        continue;
                    case 26:
                        this.stackTrace = com_google_android_gms_internal_zzapn.readString();
                        continue;
                    case 34:
                        this.zzcm = com_google_android_gms_internal_zzapn.readString();
                        continue;
                    case 42:
                        this.zzcn = com_google_android_gms_internal_zzapn.readString();
                        continue;
                    case 48:
                        this.zzco = Long.valueOf(com_google_android_gms_internal_zzapn.ak());
                        continue;
                    case 56:
                        this.zzcp = Long.valueOf(com_google_android_gms_internal_zzapn.ak());
                        continue;
                    case 66:
                        this.zzcq = com_google_android_gms_internal_zzapn.readString();
                        continue;
                    case 72:
                        this.zzcr = Long.valueOf(com_google_android_gms_internal_zzapn.ak());
                        continue;
                    case 82:
                        this.zzcs = com_google_android_gms_internal_zzapn.readString();
                        continue;
                    default:
                        if (!super.m17145a(com_google_android_gms_internal_zzapn, ah)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void zza(zzapo com_google_android_gms_internal_zzapo) {
            if (this.zzck != null) {
                com_google_android_gms_internal_zzapo.zzr(1, this.zzck);
            }
            if (this.zzcl != null) {
                com_google_android_gms_internal_zzapo.zzb(2, this.zzcl.longValue());
            }
            if (this.stackTrace != null) {
                com_google_android_gms_internal_zzapo.zzr(3, this.stackTrace);
            }
            if (this.zzcm != null) {
                com_google_android_gms_internal_zzapo.zzr(4, this.zzcm);
            }
            if (this.zzcn != null) {
                com_google_android_gms_internal_zzapo.zzr(5, this.zzcn);
            }
            if (this.zzco != null) {
                com_google_android_gms_internal_zzapo.zzb(6, this.zzco.longValue());
            }
            if (this.zzcp != null) {
                com_google_android_gms_internal_zzapo.zzb(7, this.zzcp.longValue());
            }
            if (this.zzcq != null) {
                com_google_android_gms_internal_zzapo.zzr(8, this.zzcq);
            }
            if (this.zzcr != null) {
                com_google_android_gms_internal_zzapo.zzb(9, this.zzcr.longValue());
            }
            if (this.zzcs != null) {
                com_google_android_gms_internal_zzapo.zzr(10, this.zzcs);
            }
            super.zza(com_google_android_gms_internal_zzapo);
        }

        public /* synthetic */ zzapv zzb(zzapn com_google_android_gms_internal_zzapn) {
            return zza(com_google_android_gms_internal_zzapn);
        }
    }
}
