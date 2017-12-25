package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

class zzdb extends zzda {
    private static final Object f12698a = new Object();
    private static zzdb f12699n;
    private Context f12700b;
    private zzav f12701c;
    private volatile zzat f12702d;
    private int f12703e = 1800000;
    private boolean f12704f = true;
    private boolean f12705g = false;
    private boolean f12706h = true;
    private boolean f12707i = true;
    private zzaw f12708j = new C34411(this);
    private zza f12709k;
    private zzbs f12710l;
    private boolean f12711m = false;

    class C34411 implements zzaw {
        final /* synthetic */ zzdb f12693a;

        C34411(zzdb com_google_android_gms_tagmanager_zzdb) {
            this.f12693a = com_google_android_gms_tagmanager_zzdb;
        }

        public void zzch(boolean z) {
            this.f12693a.m18185a(z, this.f12693a.f12706h);
        }
    }

    class C34422 implements Runnable {
        final /* synthetic */ zzdb f12694a;

        C34422(zzdb com_google_android_gms_tagmanager_zzdb) {
            this.f12694a = com_google_android_gms_tagmanager_zzdb;
        }

        public void run() {
            this.f12694a.f12701c.dispatch();
        }
    }

    public interface zza {
        void cancel();

        void zzcdh();

        void zzv(long j);
    }

    private class zzb implements zza {
        final /* synthetic */ zzdb f12696a;
        private Handler f12697b;

        class C34431 implements Callback {
            final /* synthetic */ zzb f12695a;

            C34431(zzb com_google_android_gms_tagmanager_zzdb_zzb) {
                this.f12695a = com_google_android_gms_tagmanager_zzdb_zzb;
            }

            public boolean handleMessage(Message message) {
                if (1 == message.what && zzdb.f12698a.equals(message.obj)) {
                    this.f12695a.f12696a.dispatch();
                    if (!this.f12695a.f12696a.m18181e()) {
                        this.f12695a.zzv((long) this.f12695a.f12696a.f12703e);
                    }
                }
                return true;
            }
        }

        private zzb(zzdb com_google_android_gms_tagmanager_zzdb) {
            this.f12696a = com_google_android_gms_tagmanager_zzdb;
            this.f12697b = new Handler(this.f12696a.f12700b.getMainLooper(), new C34431(this));
        }

        private Message m18172a() {
            return this.f12697b.obtainMessage(1, zzdb.f12698a);
        }

        public void cancel() {
            this.f12697b.removeMessages(1, zzdb.f12698a);
        }

        public void zzcdh() {
            this.f12697b.removeMessages(1, zzdb.f12698a);
            this.f12697b.sendMessage(m18172a());
        }

        public void zzv(long j) {
            this.f12697b.removeMessages(1, zzdb.f12698a);
            this.f12697b.sendMessageDelayed(m18172a(), j);
        }
    }

    private zzdb() {
    }

    private void m18177c() {
        this.f12710l = new zzbs(this);
        this.f12710l.zzed(this.f12700b);
    }

    private void m18178d() {
        this.f12709k = new zzb();
        if (this.f12703e > 0) {
            this.f12709k.zzv((long) this.f12703e);
        }
    }

    private boolean m18181e() {
        return this.f12711m || !this.f12706h || this.f12703e <= 0;
    }

    private void m18182f() {
        if (m18181e()) {
            this.f12709k.cancel();
            zzbn.m18106v("PowerSaveMode initiated.");
            return;
        }
        this.f12709k.zzv((long) this.f12703e);
        zzbn.m18106v("PowerSaveMode terminated.");
    }

    public static zzdb zzcdc() {
        if (f12699n == null) {
            f12699n = new zzdb();
        }
        return f12699n;
    }

    synchronized zzav m18183a() {
        if (this.f12701c == null) {
            if (this.f12700b == null) {
                throw new IllegalStateException("Cant get a store unless we have a context");
            }
            this.f12701c = new zzcf(this.f12708j, this.f12700b);
        }
        if (this.f12709k == null) {
            m18178d();
        }
        this.f12705g = true;
        if (this.f12704f) {
            dispatch();
            this.f12704f = false;
        }
        if (this.f12710l == null && this.f12707i) {
            m18177c();
        }
        return this.f12701c;
    }

    synchronized void m18184a(Context context, zzat com_google_android_gms_tagmanager_zzat) {
        if (this.f12700b == null) {
            this.f12700b = context.getApplicationContext();
            if (this.f12702d == null) {
                this.f12702d = com_google_android_gms_tagmanager_zzat;
            }
        }
    }

    synchronized void m18185a(boolean z, boolean z2) {
        boolean e = m18181e();
        this.f12711m = z;
        this.f12706h = z2;
        if (m18181e() != e) {
            m18182f();
        }
    }

    public synchronized void dispatch() {
        if (this.f12705g) {
            this.f12702d.zzp(new C34422(this));
        } else {
            zzbn.m18106v("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.f12704f = true;
        }
    }

    public synchronized void zzci(boolean z) {
        m18185a(this.f12711m, z);
    }

    public synchronized void zzys() {
        if (!m18181e()) {
            this.f12709k.zzcdh();
        }
    }
}
