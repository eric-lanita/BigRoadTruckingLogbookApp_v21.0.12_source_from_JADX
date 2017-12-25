package com.google.android.gms.internal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class zzaoa extends zzanh<Date> {
    public static final zzani bfu = new C32901();
    private final DateFormat f11260a = DateFormat.getDateTimeInstance(2, 2, Locale.US);
    private final DateFormat f11261b = DateFormat.getDateTimeInstance(2, 2);
    private final DateFormat f11262c = m17229a();

    static class C32901 implements zzani {
        C32901() {
        }

        public <T> zzanh<T> zza(zzamp com_google_android_gms_internal_zzamp, zzaol<T> com_google_android_gms_internal_zzaol_T) {
            return com_google_android_gms_internal_zzaol_T.m17303m() == Date.class ? new zzaoa() : null;
        }
    }

    private static DateFormat m17229a() {
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat;
    }

    private synchronized Date m17230a(String str) {
        Date parse;
        try {
            parse = this.f11261b.parse(str);
        } catch (ParseException e) {
            try {
                parse = this.f11260a.parse(str);
            } catch (ParseException e2) {
                try {
                    parse = this.f11262c.parse(str);
                } catch (Throwable e3) {
                    throw new zzane(str, e3);
                }
            }
        }
        return parse;
    }

    public synchronized void zza(zzaoo com_google_android_gms_internal_zzaoo, Date date) {
        if (date == null) {
            com_google_android_gms_internal_zzaoo.mo1858l();
        } else {
            com_google_android_gms_internal_zzaoo.zzts(this.f11260a.format(date));
        }
    }

    public /* synthetic */ Object zzb(zzaom com_google_android_gms_internal_zzaom) {
        return zzk(com_google_android_gms_internal_zzaom);
    }

    public Date zzk(zzaom com_google_android_gms_internal_zzaom) {
        if (com_google_android_gms_internal_zzaom.mo1835b() != zzaon.NULL) {
            return m17230a(com_google_android_gms_internal_zzaom.nextString());
        }
        com_google_android_gms_internal_zzaom.nextNull();
        return null;
    }
}
