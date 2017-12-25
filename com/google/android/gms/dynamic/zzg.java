package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.zze;

public abstract class zzg<T> {
    private final String f10693a;
    private T f10694b;

    public static class zza extends Exception {
        public zza(String str) {
            super(str);
        }

        public zza(String str, Throwable th) {
            super(str, th);
        }
    }

    protected zzg(String str) {
        this.f10693a = str;
    }

    protected final T m16876a(Context context) {
        if (this.f10694b == null) {
            zzab.zzy(context);
            Context remoteContext = zze.getRemoteContext(context);
            if (remoteContext == null) {
                throw new zza("Could not get remote context.");
            }
            try {
                this.f10694b = zzc((IBinder) remoteContext.getClassLoader().loadClass(this.f10693a).newInstance());
            } catch (Throwable e) {
                throw new zza("Could not load creator class.", e);
            } catch (Throwable e2) {
                throw new zza("Could not instantiate creator.", e2);
            } catch (Throwable e22) {
                throw new zza("Could not access creator.", e22);
            }
        }
        return this.f10694b;
    }

    protected abstract T zzc(IBinder iBinder);
}
