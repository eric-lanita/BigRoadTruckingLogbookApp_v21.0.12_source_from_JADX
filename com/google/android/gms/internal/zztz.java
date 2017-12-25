package com.google.android.gms.internal;

public final class zztz {
    private static zztz f11761a;
    private final zztw f11762b = new zztw();
    private final zztx f11763c = new zztx();

    static {
        m17566a(new zztz());
    }

    private zztz() {
    }

    private static zztz m17565a() {
        zztz com_google_android_gms_internal_zztz;
        synchronized (zztz.class) {
            com_google_android_gms_internal_zztz = f11761a;
        }
        return com_google_android_gms_internal_zztz;
    }

    protected static void m17566a(zztz com_google_android_gms_internal_zztz) {
        synchronized (zztz.class) {
            f11761a = com_google_android_gms_internal_zztz;
        }
    }

    public static zztw zzbet() {
        return m17565a().f11762b;
    }

    public static zztx zzbeu() {
        return m17565a().f11763c;
    }
}
