package com.google.android.gms.tagmanager;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

class zzau extends Thread implements zzat {
    private static zzau f12547d;
    private final LinkedBlockingQueue<Runnable> f12548a = new LinkedBlockingQueue();
    private volatile boolean f12549b = false;
    private volatile boolean f12550c = false;
    private volatile zzav f12551e;
    private final Context f12552f;

    private zzau(Context context) {
        super("GAThread");
        if (context != null) {
            this.f12552f = context.getApplicationContext();
        } else {
            this.f12552f = context;
        }
        start();
    }

    static zzau m18091a(Context context) {
        if (f12547d == null) {
            f12547d = new zzau(context);
        }
        return f12547d;
    }

    private String m18094a(Throwable th) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        th.printStackTrace(printStream);
        printStream.flush();
        return new String(byteArrayOutputStream.toByteArray());
    }

    void m18096a(String str, long j) {
        final zzau com_google_android_gms_tagmanager_zzau = this;
        final long j2 = j;
        final String str2 = str;
        zzp(new Runnable(this) {
            final /* synthetic */ zzau f12546d;

            public void run() {
                if (this.f12546d.f12551e == null) {
                    zzdb zzcdc = zzdb.zzcdc();
                    zzcdc.m18184a(this.f12546d.f12552f, com_google_android_gms_tagmanager_zzau);
                    this.f12546d.f12551e = zzcdc.m18183a();
                }
                this.f12546d.f12551e.zzg(j2, str2);
            }
        });
    }

    public void run() {
        while (!this.f12550c) {
            try {
                Runnable runnable = (Runnable) this.f12548a.take();
                if (!this.f12549b) {
                    runnable.run();
                }
            } catch (InterruptedException e) {
                zzbn.zzcw(e.toString());
            } catch (Throwable th) {
                String str = "Error on Google TagManager Thread: ";
                String valueOf = String.valueOf(m18094a(th));
                zzbn.m18105e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                zzbn.m18105e("Google TagManager is shutting down.");
                this.f12549b = true;
            }
        }
    }

    public void zzov(String str) {
        m18096a(str, System.currentTimeMillis());
    }

    public void zzp(Runnable runnable) {
        this.f12548a.add(runnable);
    }
}
