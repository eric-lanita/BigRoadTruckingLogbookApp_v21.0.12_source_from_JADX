package com.google.android.gms.internal;

import java.math.BigInteger;

public final class zzanb extends zzamv {
    private static final Class<?>[] f11179a = new Class[]{Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};
    private Object f11180b;

    public zzanb(Boolean bool) {
        m17194a((Object) bool);
    }

    public zzanb(Number number) {
        m17194a((Object) number);
    }

    public zzanb(String str) {
        m17194a((Object) str);
    }

    private static boolean m17191a(zzanb com_google_android_gms_internal_zzanb) {
        if (!(com_google_android_gms_internal_zzanb.f11180b instanceof Number)) {
            return false;
        }
        Number number = (Number) com_google_android_gms_internal_zzanb.f11180b;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    private static boolean m17192b(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        Class cls = obj.getClass();
        for (Class isAssignableFrom : f11179a) {
            if (isAssignableFrom.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    Boolean mo1831a() {
        return (Boolean) this.f11180b;
    }

    void m17194a(Object obj) {
        if (obj instanceof Character) {
            this.f11180b = String.valueOf(((Character) obj).charValue());
            return;
        }
        boolean z = (obj instanceof Number) || m17192b(obj);
        zzann.zzbo(z);
        this.f11180b = obj;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzanb com_google_android_gms_internal_zzanb = (zzanb) obj;
        if (this.f11180b == null) {
            return com_google_android_gms_internal_zzanb.f11180b == null;
        } else {
            if (m17191a(this) && m17191a(com_google_android_gms_internal_zzanb)) {
                return zzcze().longValue() == com_google_android_gms_internal_zzanb.zzcze().longValue();
            } else {
                if (!(this.f11180b instanceof Number) || !(com_google_android_gms_internal_zzanb.f11180b instanceof Number)) {
                    return this.f11180b.equals(com_google_android_gms_internal_zzanb.f11180b);
                }
                double doubleValue = zzcze().doubleValue();
                double doubleValue2 = com_google_android_gms_internal_zzanb.zzcze().doubleValue();
                if (doubleValue == doubleValue2 || (Double.isNaN(doubleValue) && Double.isNaN(doubleValue2))) {
                    z = true;
                }
                return z;
            }
        }
    }

    public boolean getAsBoolean() {
        return zzczo() ? mo1831a().booleanValue() : Boolean.parseBoolean(zzczf());
    }

    public double getAsDouble() {
        return zzczp() ? zzcze().doubleValue() : Double.parseDouble(zzczf());
    }

    public int getAsInt() {
        return zzczp() ? zzcze().intValue() : Integer.parseInt(zzczf());
    }

    public long getAsLong() {
        return zzczp() ? zzcze().longValue() : Long.parseLong(zzczf());
    }

    public int hashCode() {
        if (this.f11180b == null) {
            return 31;
        }
        long longValue;
        if (m17191a(this)) {
            longValue = zzcze().longValue();
            return (int) (longValue ^ (longValue >>> 32));
        } else if (!(this.f11180b instanceof Number)) {
            return this.f11180b.hashCode();
        } else {
            longValue = Double.doubleToLongBits(zzcze().doubleValue());
            return (int) (longValue ^ (longValue >>> 32));
        }
    }

    public Number zzcze() {
        return this.f11180b instanceof String ? new zzans((String) this.f11180b) : (Number) this.f11180b;
    }

    public String zzczf() {
        return zzczp() ? zzcze().toString() : zzczo() ? mo1831a().toString() : (String) this.f11180b;
    }

    public boolean zzczo() {
        return this.f11180b instanceof Boolean;
    }

    public boolean zzczp() {
        return this.f11180b instanceof Number;
    }

    public boolean zzczq() {
        return this.f11180b instanceof String;
    }
}
