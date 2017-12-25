package com.google.android.gms.internal;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

final class zzamk implements zzamu<Date>, zzand<Date> {
    private final DateFormat f11147a;
    private final DateFormat f11148b;
    private final DateFormat f11149c;

    zzamk() {
        this(DateFormat.getDateTimeInstance(2, 2, Locale.US), DateFormat.getDateTimeInstance(2, 2));
    }

    public zzamk(int i, int i2) {
        this(DateFormat.getDateTimeInstance(i, i2, Locale.US), DateFormat.getDateTimeInstance(i, i2));
    }

    zzamk(String str) {
        this(new SimpleDateFormat(str, Locale.US), new SimpleDateFormat(str));
    }

    zzamk(DateFormat dateFormat, DateFormat dateFormat2) {
        this.f11147a = dateFormat;
        this.f11148b = dateFormat2;
        this.f11149c = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        this.f11149c.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    private Date m17177a(zzamv com_google_android_gms_internal_zzamv) {
        Date parse;
        synchronized (this.f11148b) {
            try {
                parse = this.f11148b.parse(com_google_android_gms_internal_zzamv.zzczf());
            } catch (ParseException e) {
                try {
                    parse = this.f11147a.parse(com_google_android_gms_internal_zzamv.zzczf());
                } catch (ParseException e2) {
                    try {
                        parse = this.f11149c.parse(com_google_android_gms_internal_zzamv.zzczf());
                    } catch (Throwable e3) {
                        throw new zzane(com_google_android_gms_internal_zzamv.zzczf(), e3);
                    }
                }
            }
        }
        return parse;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(zzamk.class.getSimpleName());
        stringBuilder.append('(').append(this.f11148b.getClass().getSimpleName()).append(')');
        return stringBuilder.toString();
    }

    public zzamv zza(Date date, Type type, zzanc com_google_android_gms_internal_zzanc) {
        zzamv com_google_android_gms_internal_zzanb;
        synchronized (this.f11148b) {
            com_google_android_gms_internal_zzanb = new zzanb(this.f11147a.format(date));
        }
        return com_google_android_gms_internal_zzanb;
    }

    public Date zza(zzamv com_google_android_gms_internal_zzamv, Type type, zzamt com_google_android_gms_internal_zzamt) {
        if (com_google_android_gms_internal_zzamv instanceof zzanb) {
            Date a = m17177a(com_google_android_gms_internal_zzamv);
            if (type == Date.class) {
                return a;
            }
            if (type == Timestamp.class) {
                return new Timestamp(a.getTime());
            }
            if (type == java.sql.Date.class) {
                return new java.sql.Date(a.getTime());
            }
            String valueOf = String.valueOf(getClass());
            String valueOf2 = String.valueOf(type);
            throw new IllegalArgumentException(new StringBuilder((String.valueOf(valueOf).length() + 23) + String.valueOf(valueOf2).length()).append(valueOf).append(" cannot deserialize to ").append(valueOf2).toString());
        }
        throw new zzamz("The date should be a string value");
    }

    public /* synthetic */ Object zzb(zzamv com_google_android_gms_internal_zzamv, Type type, zzamt com_google_android_gms_internal_zzamt) {
        return zza(com_google_android_gms_internal_zzamv, type, com_google_android_gms_internal_zzamt);
    }
}
