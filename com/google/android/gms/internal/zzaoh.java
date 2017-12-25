package com.google.android.gms.internal;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class zzaoh extends zzanh<Date> {
    public static final zzani bfu = new C32961();
    private final DateFormat f11321a = new SimpleDateFormat("MMM d, yyyy");

    static class C32961 implements zzani {
        C32961() {
        }

        public <T> zzanh<T> zza(zzamp com_google_android_gms_internal_zzamp, zzaol<T> com_google_android_gms_internal_zzaol_T) {
            return com_google_android_gms_internal_zzaol_T.m17303m() == Date.class ? new zzaoh() : null;
        }
    }

    public synchronized void zza(zzaoo com_google_android_gms_internal_zzaoo, Date date) {
        com_google_android_gms_internal_zzaoo.zzts(date == null ? null : this.f11321a.format(date));
    }

    public /* synthetic */ Object zzb(zzaom com_google_android_gms_internal_zzaom) {
        return zzm(com_google_android_gms_internal_zzaom);
    }

    public synchronized Date zzm(zzaom com_google_android_gms_internal_zzaom) {
        Date date;
        if (com_google_android_gms_internal_zzaom.mo1835b() == zzaon.NULL) {
            com_google_android_gms_internal_zzaom.nextNull();
            date = null;
        } else {
            try {
                date = new Date(this.f11321a.parse(com_google_android_gms_internal_zzaom.nextString()).getTime());
            } catch (Throwable e) {
                throw new zzane(e);
            }
        }
        return date;
    }
}
