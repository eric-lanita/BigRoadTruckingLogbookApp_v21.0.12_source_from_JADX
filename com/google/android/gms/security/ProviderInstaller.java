package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.zzc;
import com.google.android.gms.common.zze;
import java.lang.reflect.Method;

public class ProviderInstaller {
    public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
    private static final zzc f12447a = zzc.zzang();
    private static final Object f12448b = new Object();
    private static Method f12449c = null;

    class C34191 extends AsyncTask<Void, Void, Integer> {
        final /* synthetic */ Context f12445a;
        final /* synthetic */ ProviderInstallListener f12446b;

        C34191(Context context, ProviderInstallListener providerInstallListener) {
            this.f12445a = context;
            this.f12446b = providerInstallListener;
        }

        protected Integer m18018a(Void... voidArr) {
            try {
                ProviderInstaller.installIfNeeded(this.f12445a);
                return Integer.valueOf(0);
            } catch (GooglePlayServicesRepairableException e) {
                return Integer.valueOf(e.getConnectionStatusCode());
            } catch (GooglePlayServicesNotAvailableException e2) {
                return Integer.valueOf(e2.errorCode);
            }
        }

        protected void m18019a(Integer num) {
            if (num.intValue() == 0) {
                this.f12446b.onProviderInstalled();
                return;
            }
            this.f12446b.onProviderInstallFailed(num.intValue(), ProviderInstaller.f12447a.zza(this.f12445a, num.intValue(), "pi"));
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m18018a((Void[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m18019a((Integer) obj);
        }
    }

    public interface ProviderInstallListener {
        void onProviderInstallFailed(int i, Intent intent);

        void onProviderInstalled();
    }

    private static void m18021a(Context context) {
        f12449c = context.getClassLoader().loadClass("com.google.android.gms.common.security.ProviderInstallerImpl").getMethod("insertProvider", new Class[]{Context.class});
    }

    public static void installIfNeeded(Context context) {
        zzab.zzb((Object) context, (Object) "Context must not be null");
        f12447a.zzbo(context);
        Context remoteContext = zze.getRemoteContext(context);
        if (remoteContext == null) {
            Log.e("ProviderInstaller", "Failed to get remote context");
            throw new GooglePlayServicesNotAvailableException(8);
        }
        synchronized (f12448b) {
            try {
                if (f12449c == null) {
                    m18021a(remoteContext);
                }
                f12449c.invoke(null, new Object[]{remoteContext});
            } catch (Exception e) {
                String str = "ProviderInstaller";
                String str2 = "Failed to install provider: ";
                String valueOf = String.valueOf(e.getMessage());
                Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                throw new GooglePlayServicesNotAvailableException(8);
            }
        }
    }

    public static void installIfNeededAsync(Context context, ProviderInstallListener providerInstallListener) {
        zzab.zzb((Object) context, (Object) "Context must not be null");
        zzab.zzb((Object) providerInstallListener, (Object) "Listener must not be null");
        zzab.zzhi("Must be called on the UI thread");
        new C34191(context, providerInstallListener).execute(new Void[0]);
    }
}
