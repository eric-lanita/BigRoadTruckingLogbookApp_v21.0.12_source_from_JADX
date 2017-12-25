package com.google.android.gms.maps.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.maps.internal.zzc.zza;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class zzai {
    private static Context f11983a;
    private static zzc f11984b;

    private static Class<?> m17652a() {
        try {
            return Class.forName("com.google.android.gms.maps.internal.CreatorImpl");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static <T> T m17653a(Class<?> cls) {
        String str;
        String valueOf;
        try {
            return cls.newInstance();
        } catch (InstantiationException e) {
            str = "Unable to instantiate the dynamic class ";
            valueOf = String.valueOf(cls.getName());
            throw new IllegalStateException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        } catch (IllegalAccessException e2) {
            str = "Unable to call the default constructor of ";
            valueOf = String.valueOf(cls.getName());
            throw new IllegalStateException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }

    private static <T> T m17654a(ClassLoader classLoader, String str) {
        try {
            return m17653a(((ClassLoader) zzab.zzy(classLoader)).loadClass(str));
        } catch (ClassNotFoundException e) {
            String str2 = "Unable to find dynamic class ";
            String valueOf = String.valueOf(str);
            throw new IllegalStateException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }
    }

    private static void m17655a(Context context) {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        switch (isGooglePlayServicesAvailable) {
            case 0:
                return;
            default:
                throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
        }
    }

    private static zzc m17656b(Context context) {
        if (zzbpg()) {
            Log.i(zzai.class.getSimpleName(), "Making Creator statically");
            return (zzc) m17653a(m17652a());
        }
        Log.i(zzai.class.getSimpleName(), "Making Creator dynamically");
        return zza.zzhh((IBinder) m17654a(m17657c(context).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl"));
    }

    private static Context m17657c(Context context) {
        if (f11983a == null) {
            if (zzbpg()) {
                f11983a = context.getApplicationContext();
            } else {
                f11983a = GooglePlayServicesUtil.getRemoteContext(context);
            }
        }
        return f11983a;
    }

    public static boolean zzbpg() {
        return false;
    }

    public static zzc zzdk(Context context) {
        zzab.zzy(context);
        if (f11984b != null) {
            return f11984b;
        }
        m17655a(context);
        f11984b = m17656b(context);
        try {
            f11984b.zzh(zze.zzac(m17657c(context).getResources()), GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            return f11984b;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
