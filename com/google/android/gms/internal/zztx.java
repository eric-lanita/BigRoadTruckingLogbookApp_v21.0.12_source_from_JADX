package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import com.google.android.gms.internal.zzty.zza;

public class zztx {
    private boolean f11758a = false;
    private zzty f11759b = null;

    public void initialize(Context context) {
        Throwable e;
        synchronized (this) {
            if (this.f11758a) {
                return;
            }
            try {
                this.f11759b = zza.asInterface(zzsb.zza(context, zzsb.KI, ModuleDescriptor.MODULE_ID).zziu("com.google.android.gms.flags.impl.FlagProviderImpl"));
                this.f11759b.init(zze.zzac(context));
                this.f11758a = true;
            } catch (zzsb.zza e2) {
                e = e2;
                Log.w("FlagValueProvider", "Failed to initialize flags module.", e);
            } catch (RemoteException e3) {
                e = e3;
                Log.w("FlagValueProvider", "Failed to initialize flags module.", e);
            }
        }
    }

    public <T> T zzb(zztv<T> com_google_android_gms_internal_zztv_T) {
        synchronized (this) {
            if (this.f11758a) {
                return com_google_android_gms_internal_zztv_T.zza(this.f11759b);
            }
            T zzjw = com_google_android_gms_internal_zztv_T.zzjw();
            return zzjw;
        }
    }
}
