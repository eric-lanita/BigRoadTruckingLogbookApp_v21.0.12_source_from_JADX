package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.zzc;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import java.lang.reflect.Field;

public final class zzsb {
    public static final zzb KI = new C33402();
    public static final zzb KJ = new C33413();
    public static final zzb KK = new C33424();
    public static final zzb KL = new C33435();
    public static final zzb KM = new C33446();
    private static zzsc f11743a;
    private static final zza f11744b = new C33391();
    private final Context f11745c;

    class C33391 implements zza {
        C33391() {
        }

        public int zzd(Context context, String str, boolean z) {
            return zzsb.zzd(context, str, z);
        }

        public int zzt(Context context, String str) {
            return zzsb.zzt(context, str);
        }
    }

    public interface zzb {

        public interface zza {
            int zzd(Context context, String str, boolean z);

            int zzt(Context context, String str);
        }

        public static class zzb {
            public int KP = 0;
            public int KQ = 0;
            public int KR = 0;
        }

        zzb zza(Context context, String str, zza com_google_android_gms_internal_zzsb_zzb_zza);
    }

    class C33402 implements zzb {
        C33402() {
        }

        public zzb zza(Context context, String str, zza com_google_android_gms_internal_zzsb_zzb_zza) {
            zzb com_google_android_gms_internal_zzsb_zzb_zzb = new zzb();
            com_google_android_gms_internal_zzsb_zzb_zzb.KQ = com_google_android_gms_internal_zzsb_zzb_zza.zzd(context, str, true);
            if (com_google_android_gms_internal_zzsb_zzb_zzb.KQ != 0) {
                com_google_android_gms_internal_zzsb_zzb_zzb.KR = 1;
            } else {
                com_google_android_gms_internal_zzsb_zzb_zzb.KP = com_google_android_gms_internal_zzsb_zzb_zza.zzt(context, str);
                if (com_google_android_gms_internal_zzsb_zzb_zzb.KP != 0) {
                    com_google_android_gms_internal_zzsb_zzb_zzb.KR = -1;
                }
            }
            return com_google_android_gms_internal_zzsb_zzb_zzb;
        }
    }

    class C33413 implements zzb {
        C33413() {
        }

        public zzb zza(Context context, String str, zza com_google_android_gms_internal_zzsb_zzb_zza) {
            zzb com_google_android_gms_internal_zzsb_zzb_zzb = new zzb();
            com_google_android_gms_internal_zzsb_zzb_zzb.KP = com_google_android_gms_internal_zzsb_zzb_zza.zzt(context, str);
            if (com_google_android_gms_internal_zzsb_zzb_zzb.KP != 0) {
                com_google_android_gms_internal_zzsb_zzb_zzb.KR = -1;
            } else {
                com_google_android_gms_internal_zzsb_zzb_zzb.KQ = com_google_android_gms_internal_zzsb_zzb_zza.zzd(context, str, true);
                if (com_google_android_gms_internal_zzsb_zzb_zzb.KQ != 0) {
                    com_google_android_gms_internal_zzsb_zzb_zzb.KR = 1;
                }
            }
            return com_google_android_gms_internal_zzsb_zzb_zzb;
        }
    }

    class C33424 implements zzb {
        C33424() {
        }

        public zzb zza(Context context, String str, zza com_google_android_gms_internal_zzsb_zzb_zza) {
            zzb com_google_android_gms_internal_zzsb_zzb_zzb = new zzb();
            com_google_android_gms_internal_zzsb_zzb_zzb.KP = com_google_android_gms_internal_zzsb_zzb_zza.zzt(context, str);
            com_google_android_gms_internal_zzsb_zzb_zzb.KQ = com_google_android_gms_internal_zzsb_zzb_zza.zzd(context, str, true);
            if (com_google_android_gms_internal_zzsb_zzb_zzb.KP == 0 && com_google_android_gms_internal_zzsb_zzb_zzb.KQ == 0) {
                com_google_android_gms_internal_zzsb_zzb_zzb.KR = 0;
            } else if (com_google_android_gms_internal_zzsb_zzb_zzb.KP >= com_google_android_gms_internal_zzsb_zzb_zzb.KQ) {
                com_google_android_gms_internal_zzsb_zzb_zzb.KR = -1;
            } else {
                com_google_android_gms_internal_zzsb_zzb_zzb.KR = 1;
            }
            return com_google_android_gms_internal_zzsb_zzb_zzb;
        }
    }

    class C33435 implements zzb {
        C33435() {
        }

        public zzb zza(Context context, String str, zza com_google_android_gms_internal_zzsb_zzb_zza) {
            zzb com_google_android_gms_internal_zzsb_zzb_zzb = new zzb();
            com_google_android_gms_internal_zzsb_zzb_zzb.KP = com_google_android_gms_internal_zzsb_zzb_zza.zzt(context, str);
            com_google_android_gms_internal_zzsb_zzb_zzb.KQ = com_google_android_gms_internal_zzsb_zzb_zza.zzd(context, str, true);
            if (com_google_android_gms_internal_zzsb_zzb_zzb.KP == 0 && com_google_android_gms_internal_zzsb_zzb_zzb.KQ == 0) {
                com_google_android_gms_internal_zzsb_zzb_zzb.KR = 0;
            } else if (com_google_android_gms_internal_zzsb_zzb_zzb.KQ >= com_google_android_gms_internal_zzsb_zzb_zzb.KP) {
                com_google_android_gms_internal_zzsb_zzb_zzb.KR = 1;
            } else {
                com_google_android_gms_internal_zzsb_zzb_zzb.KR = -1;
            }
            return com_google_android_gms_internal_zzsb_zzb_zzb;
        }
    }

    class C33446 implements zzb {
        C33446() {
        }

        public zzb zza(Context context, String str, zza com_google_android_gms_internal_zzsb_zzb_zza) {
            zzb com_google_android_gms_internal_zzsb_zzb_zzb = new zzb();
            com_google_android_gms_internal_zzsb_zzb_zzb.KP = com_google_android_gms_internal_zzsb_zzb_zza.zzt(context, str);
            if (com_google_android_gms_internal_zzsb_zzb_zzb.KP != 0) {
                com_google_android_gms_internal_zzsb_zzb_zzb.KQ = com_google_android_gms_internal_zzsb_zzb_zza.zzd(context, str, false);
            } else {
                com_google_android_gms_internal_zzsb_zzb_zzb.KQ = com_google_android_gms_internal_zzsb_zzb_zza.zzd(context, str, true);
            }
            if (com_google_android_gms_internal_zzsb_zzb_zzb.KP == 0 && com_google_android_gms_internal_zzsb_zzb_zzb.KQ == 0) {
                com_google_android_gms_internal_zzsb_zzb_zzb.KR = 0;
            } else if (com_google_android_gms_internal_zzsb_zzb_zzb.KQ >= com_google_android_gms_internal_zzsb_zzb_zzb.KP) {
                com_google_android_gms_internal_zzsb_zzb_zzb.KR = 1;
            } else {
                com_google_android_gms_internal_zzsb_zzb_zzb.KR = -1;
            }
            return com_google_android_gms_internal_zzsb_zzb_zzb;
        }
    }

    class C33457 implements zza {
        final /* synthetic */ int f11742a;

        C33457(int i) {
            this.f11742a = i;
        }

        public int zzd(Context context, String str, boolean z) {
            return 0;
        }

        public int zzt(Context context, String str) {
            return this.f11742a;
        }
    }

    public static class zza extends Exception {
        private zza(String str) {
            super(str);
        }

        private zza(String str, Throwable th) {
            super(str, th);
        }
    }

    private zzsb(Context context) {
        this.f11745c = (Context) zzab.zzy(context);
    }

    private static zzsb m17557a(Context context, String str) {
        String str2 = "DynamiteModule";
        String str3 = "Selected local version of ";
        String valueOf = String.valueOf(str);
        Log.i(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
        return new zzsb(context.getApplicationContext());
    }

    private static zzsb m17558a(Context context, String str, int i) {
        Log.i("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 51).append("Selected remote version of ").append(str).append(", version >= ").append(i).toString());
        zzsc a = m17559a(context);
        if (a == null) {
            throw new zza("Failed to create IDynamiteLoader.");
        }
        try {
            zzd zza = a.zza(zze.zzac(context), str, i);
            if (zze.zzad(zza) != null) {
                return new zzsb((Context) zze.zzad(zza));
            }
            throw new zza("Failed to load remote module.");
        } catch (Throwable e) {
            throw new zza("Failed to load remote module.", e);
        }
    }

    private static zzsc m17559a(Context context) {
        synchronized (zzsb.class) {
            zzsc com_google_android_gms_internal_zzsc;
            if (f11743a != null) {
                com_google_android_gms_internal_zzsc = f11743a;
                return com_google_android_gms_internal_zzsc;
            } else if (zzc.zzang().isGooglePlayServicesAvailable(context) != 0) {
                return null;
            } else {
                try {
                    com_google_android_gms_internal_zzsc = com.google.android.gms.internal.zzsc.zza.zzfd((IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance());
                    if (com_google_android_gms_internal_zzsc != null) {
                        f11743a = com_google_android_gms_internal_zzsc;
                        return com_google_android_gms_internal_zzsc;
                    }
                } catch (Exception e) {
                    String str = "DynamiteModule";
                    String str2 = "Failed to load IDynamiteLoader from GmsCore: ";
                    String valueOf = String.valueOf(e.getMessage());
                    Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                    return null;
                }
            }
        }
    }

    public static zzsb zza(Context context, zzb com_google_android_gms_internal_zzsb_zzb, String str) {
        zzb zza = com_google_android_gms_internal_zzsb_zzb.zza(context, str, f11744b);
        Log.i("DynamiteModule", new StringBuilder((String.valueOf(str).length() + 68) + String.valueOf(str).length()).append("Considering local module ").append(str).append(":").append(zza.KP).append(" and remote module ").append(str).append(":").append(zza.KQ).toString());
        if (zza.KR == 0 || ((zza.KR == -1 && zza.KP == 0) || (zza.KR == 1 && zza.KQ == 0))) {
            throw new zza("No acceptable module found. Local version is " + zza.KP + " and remote version is " + zza.KQ + ".");
        } else if (zza.KR == -1) {
            return m17557a(context, str);
        } else {
            if (zza.KR == 1) {
                try {
                    return m17558a(context, str, zza.KQ);
                } catch (Throwable e) {
                    Throwable th = e;
                    String str2 = "DynamiteModule";
                    String str3 = "Failed to load remote module: ";
                    String valueOf = String.valueOf(th.getMessage());
                    Log.w(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                    if (zza.KP != 0 && com_google_android_gms_internal_zzsb_zzb.zza(context, str, new C33457(zza.KP)).KR == -1) {
                        return m17557a(context, str);
                    }
                    throw new zza("Remote load failed. No local fallback found.", th);
                }
            }
            throw new zza("VersionPolicy returned invalid code:" + zza.KR);
        }
    }

    public static int zzd(Context context, String str, boolean z) {
        zzsc a = m17559a(context);
        if (a == null) {
            return 0;
        }
        try {
            return a.zza(zze.zzac(context), str, z);
        } catch (RemoteException e) {
            String str2 = "DynamiteModule";
            String str3 = "Failed to retrieve remote module version: ";
            String valueOf = String.valueOf(e.getMessage());
            Log.w(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            return 0;
        }
    }

    public static int zzt(Context context, String str) {
        String valueOf;
        String valueOf2;
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            valueOf = String.valueOf("com.google.android.gms.dynamite.descriptors.");
            valueOf2 = String.valueOf("ModuleDescriptor");
            Class loadClass = classLoader.loadClass(new StringBuilder(((String.valueOf(valueOf).length() + 1) + String.valueOf(str).length()) + String.valueOf(valueOf2).length()).append(valueOf).append(str).append(".").append(valueOf2).toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (declaredField.get(null).equals(str)) {
                return declaredField2.getInt(null);
            }
            valueOf = String.valueOf(declaredField.get(null));
            Log.e("DynamiteModule", new StringBuilder((String.valueOf(valueOf).length() + 51) + String.valueOf(str).length()).append("Module descriptor id '").append(valueOf).append("' didn't match expected id '").append(str).append("'").toString());
            return 0;
        } catch (ClassNotFoundException e) {
            Log.w("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 45).append("Local module descriptor class for ").append(str).append(" not found.").toString());
            return 0;
        } catch (Exception e2) {
            valueOf = "DynamiteModule";
            valueOf2 = "Failed to load module descriptor class: ";
            String valueOf3 = String.valueOf(e2.getMessage());
            Log.e(valueOf, valueOf3.length() != 0 ? valueOf2.concat(valueOf3) : new String(valueOf2));
            return 0;
        }
    }

    public static int zzu(Context context, String str) {
        return zzd(context, str, false);
    }

    public Context zzbby() {
        return this.f11745c;
    }

    public IBinder zziu(String str) {
        Throwable e;
        String str2;
        String valueOf;
        try {
            return (IBinder) this.f11745c.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException e2) {
            e = e2;
            str2 = "Failed to instantiate module class: ";
            valueOf = String.valueOf(str);
            throw new zza(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), e);
        } catch (InstantiationException e3) {
            e = e3;
            str2 = "Failed to instantiate module class: ";
            valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
            }
            throw new zza(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), e);
        } catch (IllegalAccessException e4) {
            e = e4;
            str2 = "Failed to instantiate module class: ";
            valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
            }
            throw new zza(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), e);
        }
    }
}
