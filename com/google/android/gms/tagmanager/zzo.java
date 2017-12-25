package com.google.android.gms.tagmanager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tagmanager.ContainerHolder.ContainerAvailableListener;

class zzo implements ContainerHolder {
    private final Looper f12782a;
    private Container f12783b;
    private Container f12784c;
    private Status f12785d;
    private zzb f12786e;
    private zza f12787f;
    private boolean f12788g;
    private TagManager f12789h;

    public interface zza {
        String zzcan();

        void zzcap();

        void zzoi(String str);
    }

    private class zzb extends Handler {
        final /* synthetic */ zzo f12780a;
        private final ContainerAvailableListener f12781b;

        public zzb(zzo com_google_android_gms_tagmanager_zzo, ContainerAvailableListener containerAvailableListener, Looper looper) {
            this.f12780a = com_google_android_gms_tagmanager_zzo;
            super(looper);
            this.f12781b = containerAvailableListener;
        }

        protected void m18226a(String str) {
            this.f12781b.onContainerAvailable(this.f12780a, str);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    m18226a((String) message.obj);
                    return;
                default:
                    zzbn.m18105e("Don't know how to handle this message.");
                    return;
            }
        }

        public void zzoj(String str) {
            sendMessage(obtainMessage(1, str));
        }
    }

    public zzo(Status status) {
        this.f12785d = status;
        this.f12782a = null;
    }

    public zzo(TagManager tagManager, Looper looper, Container container, zza com_google_android_gms_tagmanager_zzo_zza) {
        this.f12789h = tagManager;
        if (looper == null) {
            looper = Looper.getMainLooper();
        }
        this.f12782a = looper;
        this.f12783b = container;
        this.f12787f = com_google_android_gms_tagmanager_zzo_zza;
        this.f12785d = Status.sq;
        tagManager.zza(this);
    }

    private void m18227c() {
        if (this.f12786e != null) {
            this.f12786e.zzoj(this.f12784c.zzcal());
        }
    }

    String m18228a() {
        if (!this.f12788g) {
            return this.f12783b.getContainerId();
        }
        zzbn.m18105e("getContainerId called on a released ContainerHolder.");
        return "";
    }

    void m18229a(String str) {
        if (this.f12788g) {
            zzbn.m18105e("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        } else {
            this.f12787f.zzoi(str);
        }
    }

    String m18230b() {
        if (!this.f12788g) {
            return this.f12787f.zzcan();
        }
        zzbn.m18105e("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        return "";
    }

    public synchronized Container getContainer() {
        Container container = null;
        synchronized (this) {
            if (this.f12788g) {
                zzbn.m18105e("ContainerHolder is released.");
            } else {
                if (this.f12784c != null) {
                    this.f12783b = this.f12784c;
                    this.f12784c = null;
                }
                container = this.f12783b;
            }
        }
        return container;
    }

    public Status getStatus() {
        return this.f12785d;
    }

    public synchronized void refresh() {
        if (this.f12788g) {
            zzbn.m18105e("Refreshing a released ContainerHolder.");
        } else {
            this.f12787f.zzcap();
        }
    }

    public synchronized void release() {
        if (this.f12788g) {
            zzbn.m18105e("Releasing a released ContainerHolder.");
        } else {
            this.f12788g = true;
            this.f12789h.zzb(this);
            this.f12783b.m18037a();
            this.f12783b = null;
            this.f12784c = null;
            this.f12787f = null;
            this.f12786e = null;
        }
    }

    public synchronized void setContainerAvailableListener(ContainerAvailableListener containerAvailableListener) {
        if (this.f12788g) {
            zzbn.m18105e("ContainerHolder is released.");
        } else if (containerAvailableListener == null) {
            this.f12786e = null;
        } else {
            this.f12786e = new zzb(this, containerAvailableListener, this.f12782a);
            if (this.f12784c != null) {
                m18227c();
            }
        }
    }

    public synchronized void zza(Container container) {
        if (!this.f12788g) {
            if (container == null) {
                zzbn.m18105e("Unexpected null container.");
            } else {
                this.f12784c = container;
                m18227c();
            }
        }
    }

    public synchronized void zzog(String str) {
        if (!this.f12788g) {
            this.f12783b.zzog(str);
        }
    }
}
