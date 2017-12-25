package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Process;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzh;

public class zza {
    private static Object f12503l = new Object();
    private static zza f12504m;
    private volatile long f12505a;
    private volatile long f12506b;
    private volatile boolean f12507c;
    private volatile Info f12508d;
    private volatile long f12509e;
    private volatile long f12510f;
    private final Context f12511g;
    private final zze f12512h;
    private final Thread f12513i;
    private final Object f12514j;
    private zza f12515k;

    public interface zza {
        Info zzcaf();
    }

    class C34281 implements zza {
        final /* synthetic */ zza f12501a;

        C34281(zza com_google_android_gms_tagmanager_zza) {
            this.f12501a = com_google_android_gms_tagmanager_zza;
        }

        public Info zzcaf() {
            Info info = null;
            try {
                info = AdvertisingIdClient.getAdvertisingIdInfo(this.f12501a.f12511g);
            } catch (Throwable e) {
                zzbn.zzd("IllegalStateException getting Advertising Id Info", e);
            } catch (Throwable e2) {
                zzbn.zzd("GooglePlayServicesRepairableException getting Advertising Id Info", e2);
            } catch (Throwable e22) {
                zzbn.zzd("IOException getting Ad Id Info", e22);
            } catch (Throwable e222) {
                zzbn.zzd("GooglePlayServicesNotAvailableException getting Advertising Id Info", e222);
            } catch (Throwable e2222) {
                zzbn.zzd("Unknown exception. Could not get the Advertising Id Info.", e2222);
            }
            return info;
        }
    }

    class C34292 implements Runnable {
        final /* synthetic */ zza f12502a;

        C34292(zza com_google_android_gms_tagmanager_zza) {
            this.f12502a = com_google_android_gms_tagmanager_zza;
        }

        public void run() {
            this.f12502a.m18069d();
        }
    }

    private zza(Context context) {
        this(context, null, zzh.zzavm());
    }

    public zza(Context context, zza com_google_android_gms_tagmanager_zza_zza, zze com_google_android_gms_common_util_zze) {
        this.f12505a = 900000;
        this.f12506b = 30000;
        this.f12507c = false;
        this.f12514j = new Object();
        this.f12515k = new C34281(this);
        this.f12512h = com_google_android_gms_common_util_zze;
        if (context != null) {
            this.f12511g = context.getApplicationContext();
        } else {
            this.f12511g = context;
        }
        if (com_google_android_gms_tagmanager_zza_zza != null) {
            this.f12515k = com_google_android_gms_tagmanager_zza_zza;
        }
        this.f12509e = this.f12512h.currentTimeMillis();
        this.f12513i = new Thread(new C34292(this));
    }

    private void m18065a() {
        synchronized (this) {
            try {
                m18066b();
                wait(500);
            } catch (InterruptedException e) {
            }
        }
    }

    private void m18066b() {
        if (this.f12512h.currentTimeMillis() - this.f12509e > this.f12506b) {
            synchronized (this.f12514j) {
                this.f12514j.notify();
            }
            this.f12509e = this.f12512h.currentTimeMillis();
        }
    }

    private void m18068c() {
        if (this.f12512h.currentTimeMillis() - this.f12510f > 3600000) {
            this.f12508d = null;
        }
    }

    private void m18069d() {
        Process.setThreadPriority(10);
        while (!this.f12507c) {
            Info zzcaf = this.f12515k.zzcaf();
            if (zzcaf != null) {
                this.f12508d = zzcaf;
                this.f12510f = this.f12512h.currentTimeMillis();
                zzbn.zzcw("Obtained fresh AdvertisingId info from GmsCore.");
            }
            synchronized (this) {
                notifyAll();
            }
            try {
                synchronized (this.f12514j) {
                    this.f12514j.wait(this.f12505a);
                }
            } catch (InterruptedException e) {
                zzbn.zzcw("sleep interrupted in AdvertiserDataPoller thread; continuing");
            }
        }
    }

    public static zza zzdu(Context context) {
        if (f12504m == null) {
            synchronized (f12503l) {
                if (f12504m == null) {
                    f12504m = new zza(context);
                    f12504m.start();
                }
            }
        }
        return f12504m;
    }

    public boolean isLimitAdTrackingEnabled() {
        if (this.f12508d == null) {
            m18065a();
        } else {
            m18066b();
        }
        m18068c();
        return this.f12508d == null ? true : this.f12508d.isLimitAdTrackingEnabled();
    }

    public void start() {
        this.f12513i.start();
    }

    public String zzcaa() {
        if (this.f12508d == null) {
            m18065a();
        } else {
            m18066b();
        }
        m18068c();
        return this.f12508d == null ? null : this.f12508d.getId();
    }
}
