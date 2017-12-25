package com.google.firebase.iid;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.iid.MessengerCompat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class zzb extends Service {
    MessengerCompat f4104a = new MessengerCompat(new Handler(this, Looper.getMainLooper()) {
        final /* synthetic */ zzb f13150a;

        public void handleMessage(Message message) {
            int zzc = MessengerCompat.zzc(message);
            C3622e.m18917a(this.f13150a);
            this.f13150a.getPackageManager();
            if (zzc == C3622e.f13135c || zzc == C3622e.f13134b) {
                this.f13150a.mo899b((Intent) message.obj);
                return;
            }
            int i = C3622e.f13134b;
            Log.w("FirebaseInstanceId", "Message from unexpected caller " + zzc + " mine=" + i + " appid=" + C3622e.f13135c);
        }
    });
    final ExecutorService f4105b = Executors.newSingleThreadExecutor();
    private final Object f4106c = new Object();
    private int f4107d;
    private int f4108e = 0;

    protected int mo898a(final Intent intent) {
        this.f4105b.execute(new Runnable(this) {
            final /* synthetic */ zzb f13152b;

            public void run() {
                this.f13152b.mo899b(intent);
                this.f13152b.m6200b();
            }
        });
        return 3;
    }

    protected void m6200b() {
        synchronized (this.f4106c) {
            this.f4108e--;
            if (this.f4108e == 0) {
                m6202b(this.f4107d);
            }
        }
    }

    public abstract void mo899b(Intent intent);

    boolean m6202b(int i) {
        return stopSelfResult(i);
    }

    protected abstract Intent mo900c(Intent intent);

    public final IBinder onBind(Intent intent) {
        return (intent == null || !"com.google.firebase.INSTANCE_ID_EVENT".equals(intent.getAction())) ? null : this.f4104a.getBinder();
    }

    public final int onStartCommand(android.content.Intent r4, int r5, int r6) {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1431)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1453)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r3 = this;
        r1 = r3.f4106c;
        monitor-enter(r1);
        r3.f4107d = r6;
        r0 = r3.f4108e;
        r0 = r0 + 1;
        r3.f4108e = r0;
        monitor-exit(r1);
        r1 = r3.mo900c(r4);
        if (r1 != 0) goto L_0x001a;
    L_0x0012:
        r3.m6200b();
        r0 = 2;
    L_0x0016:
        return r0;
    L_0x0017:
        r0 = move-exception;
        monitor-exit(r1);
        throw r0;
    L_0x001a:
        r0 = r3.mo898a(r1);	 Catch:{ all -> 0x002a }
        r2 = "from";
        r2 = r1.getStringExtra(r2);
        if (r2 == 0) goto L_0x0016;
    L_0x0026:
        android.support.v4.content.WakefulBroadcastReceiver.completeWakefulIntent(r1);
        goto L_0x0016;
    L_0x002a:
        r0 = move-exception;
        r2 = "from";
        r2 = r1.getStringExtra(r2);
        if (r2 == 0) goto L_0x0036;
    L_0x0033:
        android.support.v4.content.WakefulBroadcastReceiver.completeWakefulIntent(r1);
    L_0x0036:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzb.onStartCommand(android.content.Intent, int, int):int");
    }
}
