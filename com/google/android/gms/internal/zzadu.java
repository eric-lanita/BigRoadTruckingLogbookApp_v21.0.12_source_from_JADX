package com.google.android.gms.internal;

import com.google.android.gms.internal.zzah.zzf;
import com.google.android.gms.internal.zzah.zzj;

public interface zzadu {

    public static final class zza extends zzapp<zza> {
        public long aCV;
        public zzj aCW;
        public zzf zzwr;

        public zza() {
            zzcgx();
        }

        public static zza zzao(byte[] bArr) {
            return (zza) zzapv.zza(new zza(), bArr);
        }

        protected int mo1813a() {
            int a = super.mo1813a() + zzapo.zze(1, this.aCV);
            if (this.zzwr != null) {
                a += zzapo.zzc(2, this.zzwr);
            }
            return this.aCW != null ? a + zzapo.zzc(3, this.aCW) : a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzadu_zza = (zza) obj;
            if (this.aCV != com_google_android_gms_internal_zzadu_zza.aCV) {
                return false;
            }
            if (this.zzwr == null) {
                if (com_google_android_gms_internal_zzadu_zza.zzwr != null) {
                    return false;
                }
            } else if (!this.zzwr.equals(com_google_android_gms_internal_zzadu_zza.zzwr)) {
                return false;
            }
            if (this.aCW == null) {
                if (com_google_android_gms_internal_zzadu_zza.aCW != null) {
                    return false;
                }
            } else if (!this.aCW.equals(com_google_android_gms_internal_zzadu_zza.aCW)) {
                return false;
            }
            return (this.a == null || this.a.isEmpty()) ? com_google_android_gms_internal_zzadu_zza.a == null || com_google_android_gms_internal_zzadu_zza.a.isEmpty() : this.a.equals(com_google_android_gms_internal_zzadu_zza.a);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.aCW == null ? 0 : this.aCW.hashCode()) + (((this.zzwr == null ? 0 : this.zzwr.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + ((int) (this.aCV ^ (this.aCV >>> 32)))) * 31)) * 31)) * 31;
            if (!(this.a == null || this.a.isEmpty())) {
                i = this.a.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzapo com_google_android_gms_internal_zzapo) {
            com_google_android_gms_internal_zzapo.zzb(1, this.aCV);
            if (this.zzwr != null) {
                com_google_android_gms_internal_zzapo.zza(2, this.zzwr);
            }
            if (this.aCW != null) {
                com_google_android_gms_internal_zzapo.zza(3, this.aCW);
            }
            super.zza(com_google_android_gms_internal_zzapo);
        }

        public zza zzas(zzapn com_google_android_gms_internal_zzapn) {
            while (true) {
                int ah = com_google_android_gms_internal_zzapn.ah();
                switch (ah) {
                    case 0:
                        break;
                    case 8:
                        this.aCV = com_google_android_gms_internal_zzapn.ak();
                        continue;
                    case 18:
                        if (this.zzwr == null) {
                            this.zzwr = new zzf();
                        }
                        com_google_android_gms_internal_zzapn.zza(this.zzwr);
                        continue;
                    case 26:
                        if (this.aCW == null) {
                            this.aCW = new zzj();
                        }
                        com_google_android_gms_internal_zzapn.zza(this.aCW);
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

        public /* synthetic */ zzapv zzb(zzapn com_google_android_gms_internal_zzapn) {
            return zzas(com_google_android_gms_internal_zzapn);
        }

        public zza zzcgx() {
            this.aCV = 0;
            this.zzwr = null;
            this.aCW = null;
            this.a = null;
            this.b = -1;
            return this;
        }
    }
}
