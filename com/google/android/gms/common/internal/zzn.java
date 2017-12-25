package com.google.android.gms.common.internal;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

final class zzn extends zzm implements Callback {
    private final HashMap<zza, zzb> f10789a = new HashMap();
    private final Context f10790b;
    private final Handler f10791c;
    private final com.google.android.gms.common.stats.zzb f10792d;
    private final long f10793e;

    private static final class zza {
        private final String f10777a;
        private final String f10778b;
        private final ComponentName f10779c;

        public zza(ComponentName componentName) {
            this.f10777a = null;
            this.f10778b = null;
            this.f10779c = (ComponentName) zzab.zzy(componentName);
        }

        public zza(String str, String str2) {
            this.f10777a = zzab.zzhr(str);
            this.f10778b = zzab.zzhr(str2);
            this.f10779c = null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_common_internal_zzn_zza = (zza) obj;
            return zzaa.equal(this.f10777a, com_google_android_gms_common_internal_zzn_zza.f10777a) && zzaa.equal(this.f10779c, com_google_android_gms_common_internal_zzn_zza.f10779c);
        }

        public int hashCode() {
            return zzaa.hashCode(this.f10777a, this.f10779c);
        }

        public String toString() {
            return this.f10777a == null ? this.f10779c.flattenToString() : this.f10777a;
        }

        public Intent zzasy() {
            return this.f10777a != null ? new Intent(this.f10777a).setPackage(this.f10778b) : new Intent().setComponent(this.f10779c);
        }
    }

    private final class zzb {
        final /* synthetic */ zzn f10781a;
        private final zza f10782b = new zza(this);
        private final Set<ServiceConnection> f10783c = new HashSet();
        private int f10784d = 2;
        private boolean f10785e;
        private IBinder f10786f;
        private final zza f10787g;
        private ComponentName f10788h;

        public class zza implements ServiceConnection {
            final /* synthetic */ zzb f10780a;

            public zza(zzb com_google_android_gms_common_internal_zzn_zzb) {
                this.f10780a = com_google_android_gms_common_internal_zzn_zzb;
            }

            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                synchronized (this.f10780a.f10781a.f10789a) {
                    this.f10780a.f10786f = iBinder;
                    this.f10780a.f10788h = componentName;
                    for (ServiceConnection onServiceConnected : this.f10780a.f10783c) {
                        onServiceConnected.onServiceConnected(componentName, iBinder);
                    }
                    this.f10780a.f10784d = 1;
                }
            }

            public void onServiceDisconnected(ComponentName componentName) {
                synchronized (this.f10780a.f10781a.f10789a) {
                    this.f10780a.f10786f = null;
                    this.f10780a.f10788h = componentName;
                    for (ServiceConnection onServiceDisconnected : this.f10780a.f10783c) {
                        onServiceDisconnected.onServiceDisconnected(componentName);
                    }
                    this.f10780a.f10784d = 2;
                }
            }
        }

        public zzb(zzn com_google_android_gms_common_internal_zzn, zza com_google_android_gms_common_internal_zzn_zza) {
            this.f10781a = com_google_android_gms_common_internal_zzn;
            this.f10787g = com_google_android_gms_common_internal_zzn_zza;
        }

        public IBinder getBinder() {
            return this.f10786f;
        }

        public ComponentName getComponentName() {
            return this.f10788h;
        }

        public int getState() {
            return this.f10784d;
        }

        public boolean isBound() {
            return this.f10785e;
        }

        public void zza(ServiceConnection serviceConnection, String str) {
            this.f10781a.f10792d.zza(this.f10781a.f10790b, serviceConnection, str, this.f10787g.zzasy());
            this.f10783c.add(serviceConnection);
        }

        public boolean zza(ServiceConnection serviceConnection) {
            return this.f10783c.contains(serviceConnection);
        }

        public boolean zzasz() {
            return this.f10783c.isEmpty();
        }

        public void zzb(ServiceConnection serviceConnection, String str) {
            this.f10781a.f10792d.zzb(this.f10781a.f10790b, serviceConnection);
            this.f10783c.remove(serviceConnection);
        }

        @TargetApi(14)
        public void zzhm(String str) {
            this.f10784d = 3;
            this.f10785e = this.f10781a.f10792d.zza(this.f10781a.f10790b, str, this.f10787g.zzasy(), this.f10782b, 129);
            if (!this.f10785e) {
                this.f10784d = 2;
                try {
                    this.f10781a.f10792d.zza(this.f10781a.f10790b, this.f10782b);
                } catch (IllegalArgumentException e) {
                }
            }
        }

        public void zzhn(String str) {
            this.f10781a.f10792d.zza(this.f10781a.f10790b, this.f10782b);
            this.f10785e = false;
            this.f10784d = 2;
        }
    }

    zzn(Context context) {
        this.f10790b = context.getApplicationContext();
        this.f10791c = new Handler(context.getMainLooper(), this);
        this.f10792d = com.google.android.gms.common.stats.zzb.zzaux();
        this.f10793e = 5000;
    }

    private boolean m16940a(zza com_google_android_gms_common_internal_zzn_zza, ServiceConnection serviceConnection, String str) {
        boolean isBound;
        zzab.zzb((Object) serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.f10789a) {
            zzb com_google_android_gms_common_internal_zzn_zzb = (zzb) this.f10789a.get(com_google_android_gms_common_internal_zzn_zza);
            if (com_google_android_gms_common_internal_zzn_zzb != null) {
                this.f10791c.removeMessages(0, com_google_android_gms_common_internal_zzn_zzb);
                if (!com_google_android_gms_common_internal_zzn_zzb.zza(serviceConnection)) {
                    com_google_android_gms_common_internal_zzn_zzb.zza(serviceConnection, str);
                    switch (com_google_android_gms_common_internal_zzn_zzb.getState()) {
                        case 1:
                            serviceConnection.onServiceConnected(com_google_android_gms_common_internal_zzn_zzb.getComponentName(), com_google_android_gms_common_internal_zzn_zzb.getBinder());
                            break;
                        case 2:
                            com_google_android_gms_common_internal_zzn_zzb.zzhm(str);
                            break;
                        default:
                            break;
                    }
                }
                String valueOf = String.valueOf(com_google_android_gms_common_internal_zzn_zza);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 81).append("Trying to bind a GmsServiceConnection that was already connected before.  config=").append(valueOf).toString());
            }
            com_google_android_gms_common_internal_zzn_zzb = new zzb(this, com_google_android_gms_common_internal_zzn_zza);
            com_google_android_gms_common_internal_zzn_zzb.zza(serviceConnection, str);
            com_google_android_gms_common_internal_zzn_zzb.zzhm(str);
            this.f10789a.put(com_google_android_gms_common_internal_zzn_zza, com_google_android_gms_common_internal_zzn_zzb);
            isBound = com_google_android_gms_common_internal_zzn_zzb.isBound();
        }
        return isBound;
    }

    private void m16942b(zza com_google_android_gms_common_internal_zzn_zza, ServiceConnection serviceConnection, String str) {
        zzab.zzb((Object) serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.f10789a) {
            zzb com_google_android_gms_common_internal_zzn_zzb = (zzb) this.f10789a.get(com_google_android_gms_common_internal_zzn_zza);
            String valueOf;
            if (com_google_android_gms_common_internal_zzn_zzb == null) {
                valueOf = String.valueOf(com_google_android_gms_common_internal_zzn_zza);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 50).append("Nonexistent connection status for service config: ").append(valueOf).toString());
            } else if (com_google_android_gms_common_internal_zzn_zzb.zza(serviceConnection)) {
                com_google_android_gms_common_internal_zzn_zzb.zzb(serviceConnection, str);
                if (com_google_android_gms_common_internal_zzn_zzb.zzasz()) {
                    this.f10791c.sendMessageDelayed(this.f10791c.obtainMessage(0, com_google_android_gms_common_internal_zzn_zzb), this.f10793e);
                }
            } else {
                valueOf = String.valueOf(com_google_android_gms_common_internal_zzn_zza);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 76).append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=").append(valueOf).toString());
            }
        }
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                zzb com_google_android_gms_common_internal_zzn_zzb = (zzb) message.obj;
                synchronized (this.f10789a) {
                    if (com_google_android_gms_common_internal_zzn_zzb.zzasz()) {
                        if (com_google_android_gms_common_internal_zzn_zzb.isBound()) {
                            com_google_android_gms_common_internal_zzn_zzb.zzhn("GmsClientSupervisor");
                        }
                        this.f10789a.remove(com_google_android_gms_common_internal_zzn_zzb.f10787g);
                    }
                }
                return true;
            default:
                return false;
        }
    }

    public boolean zza(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        return m16940a(new zza(componentName), serviceConnection, str);
    }

    public boolean zza(String str, String str2, ServiceConnection serviceConnection, String str3) {
        return m16940a(new zza(str, str2), serviceConnection, str3);
    }

    public void zzb(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        m16942b(new zza(componentName), serviceConnection, str);
    }

    public void zzb(String str, String str2, ServiceConnection serviceConnection, String str3) {
        m16942b(new zza(str, str2), serviceConnection, str3);
    }
}
