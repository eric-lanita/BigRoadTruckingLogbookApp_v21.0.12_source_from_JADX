package com.google.android.gms.internal;

import android.os.Binder;

public abstract class zzqz<T> {
    private static final Object f11693c = new Object();
    private static zza f11694d = null;
    private static int f11695e = 0;
    private static String f11696f = "com.google.android.providers.gsf.permission.READ_GSERVICES";
    protected final String f11697a;
    protected final T f11698b;
    private T f11699g = null;

    class C33311 extends zzqz<Boolean> {
        C33311(String str, Boolean bool) {
            super(str, bool);
        }

        protected /* synthetic */ Object mo1975a(String str) {
            return m17538b(str);
        }

        protected Boolean m17538b(String str) {
            return null.zza(this.a, (Boolean) this.b);
        }
    }

    class C33322 extends zzqz<Long> {
        C33322(String str, Long l) {
            super(str, l);
        }

        protected /* synthetic */ Object mo1975a(String str) {
            return m17540b(str);
        }

        protected Long m17540b(String str) {
            return null.getLong(this.a, (Long) this.b);
        }
    }

    class C33333 extends zzqz<Integer> {
        C33333(String str, Integer num) {
            super(str, num);
        }

        protected /* synthetic */ Object mo1975a(String str) {
            return m17542b(str);
        }

        protected Integer m17542b(String str) {
            return null.zzb(this.a, (Integer) this.b);
        }
    }

    class C33344 extends zzqz<Float> {
        C33344(String str, Float f) {
            super(str, f);
        }

        protected /* synthetic */ Object mo1975a(String str) {
            return m17544b(str);
        }

        protected Float m17544b(String str) {
            return null.zzb(this.a, (Float) this.b);
        }
    }

    class C33355 extends zzqz<String> {
        C33355(String str, String str2) {
            super(str, str2);
        }

        protected /* synthetic */ Object mo1975a(String str) {
            return m17546b(str);
        }

        protected String m17546b(String str) {
            return null.getString(this.a, (String) this.b);
        }
    }

    private interface zza {
        Long getLong(String str, Long l);

        String getString(String str, String str2);

        Boolean zza(String str, Boolean bool);

        Float zzb(String str, Float f);

        Integer zzb(String str, Integer num);
    }

    protected zzqz(String str, T t) {
        this.f11697a = str;
        this.f11698b = t;
    }

    public static zzqz<Float> zza(String str, Float f) {
        return new C33344(str, f);
    }

    public static zzqz<Integer> zza(String str, Integer num) {
        return new C33333(str, num);
    }

    public static zzqz<Long> zza(String str, Long l) {
        return new C33322(str, l);
    }

    public static zzqz<String> zzab(String str, String str2) {
        return new C33355(str, str2);
    }

    public static zzqz<Boolean> zzm(String str, boolean z) {
        return new C33311(str, Boolean.valueOf(z));
    }

    protected abstract T mo1975a(String str);

    public final T get() {
        T a;
        long clearCallingIdentity;
        try {
            a = mo1975a(this.f11697a);
        } catch (SecurityException e) {
            clearCallingIdentity = Binder.clearCallingIdentity();
            a = mo1975a(this.f11697a);
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
        return a;
    }
}
