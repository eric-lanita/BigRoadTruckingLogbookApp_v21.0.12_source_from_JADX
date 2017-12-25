package com.google.android.gms.internal;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class zzaoi extends zzanh<Time> {
    public static final zzani bfu = new C32971();
    private final DateFormat f11322a = new SimpleDateFormat("hh:mm:ss a");

    static class C32971 implements zzani {
        C32971() {
        }

        public <T> zzanh<T> zza(zzamp com_google_android_gms_internal_zzamp, zzaol<T> com_google_android_gms_internal_zzaol_T) {
            return com_google_android_gms_internal_zzaol_T.m17303m() == Time.class ? new zzaoi() : null;
        }
    }

    public synchronized void zza(zzaoo com_google_android_gms_internal_zzaoo, Time time) {
        com_google_android_gms_internal_zzaoo.zzts(time == null ? null : this.f11322a.format(time));
    }

    public /* synthetic */ Object zzb(zzaom com_google_android_gms_internal_zzaom) {
        return zzn(com_google_android_gms_internal_zzaom);
    }

    public synchronized Time zzn(zzaom com_google_android_gms_internal_zzaom) {
        Time time;
        if (com_google_android_gms_internal_zzaom.mo1835b() == zzaon.NULL) {
            com_google_android_gms_internal_zzaom.nextNull();
            time = null;
        } else {
            try {
                time = new Time(this.f11322a.parse(com_google_android_gms_internal_zzaom.nextString()).getTime());
            } catch (Throwable e) {
                throw new zzane(e);
            }
        }
        return time;
    }
}
