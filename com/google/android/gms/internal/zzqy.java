package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import android.support.v4.p008d.C0270a;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzd;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class zzqy {
    private static final com.google.android.gms.internal.zzpm.zza<?, ?>[] f11688b = new com.google.android.gms.internal.zzpm.zza[0];
    final Set<com.google.android.gms.internal.zzpm.zza<?, ?>> f11689a;
    private final zzb f11690c;
    private final Map<com.google.android.gms.common.api.Api.zzc<?>, zze> f11691d;
    private zzc f11692e;

    interface zzc {
        void zzaqn();
    }

    interface zzb {
        void zzh(com.google.android.gms.internal.zzpm.zza<?, ?> com_google_android_gms_internal_zzpm_zza___);
    }

    class C33301 implements zzb {
        final /* synthetic */ zzqy f11684a;

        C33301(zzqy com_google_android_gms_internal_zzqy) {
            this.f11684a = com_google_android_gms_internal_zzqy;
        }

        public void zzh(com.google.android.gms.internal.zzpm.zza<?, ?> com_google_android_gms_internal_zzpm_zza___) {
            this.f11684a.f11689a.remove(com_google_android_gms_internal_zzpm_zza___);
            if (!(com_google_android_gms_internal_zzpm_zza___.zzaoj() == null || null == null)) {
                null.remove(com_google_android_gms_internal_zzpm_zza___.zzaoj().intValue());
            }
            if (this.f11684a.f11692e != null && this.f11684a.f11689a.isEmpty()) {
                this.f11684a.f11692e.zzaqn();
            }
        }
    }

    private static class zza implements DeathRecipient, zzb {
        private final WeakReference<com.google.android.gms.internal.zzpm.zza<?, ?>> f11685a;
        private final WeakReference<zzd> f11686b;
        private final WeakReference<IBinder> f11687c;

        private zza(com.google.android.gms.internal.zzpm.zza<?, ?> com_google_android_gms_internal_zzpm_zza___, zzd com_google_android_gms_common_api_zzd, IBinder iBinder) {
            this.f11686b = new WeakReference(com_google_android_gms_common_api_zzd);
            this.f11685a = new WeakReference(com_google_android_gms_internal_zzpm_zza___);
            this.f11687c = new WeakReference(iBinder);
        }

        private void m17530a() {
            com.google.android.gms.internal.zzpm.zza com_google_android_gms_internal_zzpm_zza = (com.google.android.gms.internal.zzpm.zza) this.f11685a.get();
            zzd com_google_android_gms_common_api_zzd = (zzd) this.f11686b.get();
            if (!(com_google_android_gms_common_api_zzd == null || com_google_android_gms_internal_zzpm_zza == null)) {
                com_google_android_gms_common_api_zzd.remove(com_google_android_gms_internal_zzpm_zza.zzaoj().intValue());
            }
            IBinder iBinder = (IBinder) this.f11687c.get();
            if (this.f11687c != null) {
                iBinder.unlinkToDeath(this, 0);
            }
        }

        public void binderDied() {
            m17530a();
        }

        public void zzh(com.google.android.gms.internal.zzpm.zza<?, ?> com_google_android_gms_internal_zzpm_zza___) {
            m17530a();
        }
    }

    public zzqy(com.google.android.gms.common.api.Api.zzc<?> com_google_android_gms_common_api_Api_zzc_, zze com_google_android_gms_common_api_Api_zze) {
        this.f11689a = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
        this.f11690c = new C33301(this);
        this.f11692e = null;
        this.f11691d = new C0270a();
        this.f11691d.put(com_google_android_gms_common_api_Api_zzc_, com_google_android_gms_common_api_Api_zze);
    }

    public zzqy(Map<com.google.android.gms.common.api.Api.zzc<?>, zze> map) {
        this.f11689a = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
        this.f11690c = new C33301(this);
        this.f11692e = null;
        this.f11691d = map;
    }

    private static void m17532a(com.google.android.gms.internal.zzpm.zza<?, ?> com_google_android_gms_internal_zzpm_zza___, zzd com_google_android_gms_common_api_zzd, IBinder iBinder) {
        if (com_google_android_gms_internal_zzpm_zza___.isReady()) {
            com_google_android_gms_internal_zzpm_zza___.zza(new zza(com_google_android_gms_internal_zzpm_zza___, com_google_android_gms_common_api_zzd, iBinder));
        } else if (iBinder == null || !iBinder.isBinderAlive()) {
            com_google_android_gms_internal_zzpm_zza___.zza(null);
            com_google_android_gms_internal_zzpm_zza___.cancel();
            com_google_android_gms_common_api_zzd.remove(com_google_android_gms_internal_zzpm_zza___.zzaoj().intValue());
        } else {
            Object com_google_android_gms_internal_zzqy_zza = new zza(com_google_android_gms_internal_zzpm_zza___, com_google_android_gms_common_api_zzd, iBinder);
            com_google_android_gms_internal_zzpm_zza___.zza(com_google_android_gms_internal_zzqy_zza);
            try {
                iBinder.linkToDeath(com_google_android_gms_internal_zzqy_zza, 0);
            } catch (RemoteException e) {
                com_google_android_gms_internal_zzpm_zza___.cancel();
                com_google_android_gms_common_api_zzd.remove(com_google_android_gms_internal_zzpm_zza___.zzaoj().intValue());
            }
        }
    }

    <A extends com.google.android.gms.common.api.Api.zzb> void m17534a(com.google.android.gms.internal.zzpm.zza<? extends Result, A> com_google_android_gms_internal_zzpm_zza__extends_com_google_android_gms_common_api_Result__A) {
        this.f11689a.add(com_google_android_gms_internal_zzpm_zza__extends_com_google_android_gms_common_api_Result__A);
        com_google_android_gms_internal_zzpm_zza__extends_com_google_android_gms_common_api_Result__A.zza(this.f11690c);
    }

    public void dump(PrintWriter printWriter) {
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.f11689a.size());
    }

    public void release() {
        for (com.google.android.gms.internal.zzpm.zza com_google_android_gms_internal_zzpm_zza : (com.google.android.gms.internal.zzpm.zza[]) this.f11689a.toArray(f11688b)) {
            com_google_android_gms_internal_zzpm_zza.zza(null);
            if (com_google_android_gms_internal_zzpm_zza.zzaoj() != null) {
                com_google_android_gms_internal_zzpm_zza.zzaor();
                m17532a(com_google_android_gms_internal_zzpm_zza, null, ((zze) this.f11691d.get(com_google_android_gms_internal_zzpm_zza.zzans())).zzanv());
                this.f11689a.remove(com_google_android_gms_internal_zzpm_zza);
            } else if (com_google_android_gms_internal_zzpm_zza.zzaov()) {
                this.f11689a.remove(com_google_android_gms_internal_zzpm_zza);
            }
        }
    }

    public void zza(zzc com_google_android_gms_internal_zzqy_zzc) {
        if (this.f11689a.isEmpty()) {
            com_google_android_gms_internal_zzqy_zzc.zzaqn();
        }
        this.f11692e = com_google_android_gms_internal_zzqy_zzc;
    }

    public void zzaqz() {
        for (com.google.android.gms.internal.zzpm.zza zzaa : (com.google.android.gms.internal.zzpm.zza[]) this.f11689a.toArray(f11688b)) {
            zzaa.zzaa(new Status(8, "The connection to Google Play services was lost"));
        }
    }

    public boolean zzara() {
        for (com.google.android.gms.internal.zzpm.zza isReady : (com.google.android.gms.internal.zzpm.zza[]) this.f11689a.toArray(f11688b)) {
            if (!isReady.isReady()) {
                return true;
            }
        }
        return false;
    }
}
