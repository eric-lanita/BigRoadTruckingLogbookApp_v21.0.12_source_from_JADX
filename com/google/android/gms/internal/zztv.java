package com.google.android.gms.internal;

import android.os.RemoteException;

public abstract class zztv<T> {
    private final int f11752a;
    private final String f11753b;
    private final T f11754c;

    public static class zza extends zztv<Boolean> {
        public zza(int i, String str, Boolean bool) {
            super(i, str, bool);
        }

        public /* synthetic */ Object zza(zzty com_google_android_gms_internal_zzty) {
            return zzb(com_google_android_gms_internal_zzty);
        }

        public Boolean zzb(zzty com_google_android_gms_internal_zzty) {
            try {
                return Boolean.valueOf(com_google_android_gms_internal_zzty.getBooleanFlagValue(getKey(), ((Boolean) zzjw()).booleanValue(), getSource()));
            } catch (RemoteException e) {
                return (Boolean) zzjw();
            }
        }
    }

    public static class zzb extends zztv<Integer> {
        public zzb(int i, String str, Integer num) {
            super(i, str, num);
        }

        public /* synthetic */ Object zza(zzty com_google_android_gms_internal_zzty) {
            return zzc(com_google_android_gms_internal_zzty);
        }

        public Integer zzc(zzty com_google_android_gms_internal_zzty) {
            try {
                return Integer.valueOf(com_google_android_gms_internal_zzty.getIntFlagValue(getKey(), ((Integer) zzjw()).intValue(), getSource()));
            } catch (RemoteException e) {
                return (Integer) zzjw();
            }
        }
    }

    public static class zzc extends zztv<Long> {
        public zzc(int i, String str, Long l) {
            super(i, str, l);
        }

        public /* synthetic */ Object zza(zzty com_google_android_gms_internal_zzty) {
            return zzd(com_google_android_gms_internal_zzty);
        }

        public Long zzd(zzty com_google_android_gms_internal_zzty) {
            try {
                return Long.valueOf(com_google_android_gms_internal_zzty.getLongFlagValue(getKey(), ((Long) zzjw()).longValue(), getSource()));
            } catch (RemoteException e) {
                return (Long) zzjw();
            }
        }
    }

    public static class zzd extends zztv<String> {
        public zzd(int i, String str, String str2) {
            super(i, str, str2);
        }

        public /* synthetic */ Object zza(zzty com_google_android_gms_internal_zzty) {
            return zze(com_google_android_gms_internal_zzty);
        }

        public String zze(zzty com_google_android_gms_internal_zzty) {
            try {
                return com_google_android_gms_internal_zzty.getStringFlagValue(getKey(), (String) zzjw(), getSource());
            } catch (RemoteException e) {
                return (String) zzjw();
            }
        }
    }

    private zztv(int i, String str, T t) {
        this.f11752a = i;
        this.f11753b = str;
        this.f11754c = t;
        zztz.zzbet().zza(this);
    }

    public static zza zzb(int i, String str, Boolean bool) {
        return new zza(i, str, bool);
    }

    public static zzb zzb(int i, String str, int i2) {
        return new zzb(i, str, Integer.valueOf(i2));
    }

    public static zzc zzb(int i, String str, long j) {
        return new zzc(i, str, Long.valueOf(j));
    }

    public static zzd zzc(int i, String str, String str2) {
        return new zzd(i, str, str2);
    }

    public T get() {
        return zztz.zzbeu().zzb(this);
    }

    public String getKey() {
        return this.f11753b;
    }

    public int getSource() {
        return this.f11752a;
    }

    protected abstract T zza(zzty com_google_android_gms_internal_zzty);

    public T zzjw() {
        return this.f11754c;
    }
}
