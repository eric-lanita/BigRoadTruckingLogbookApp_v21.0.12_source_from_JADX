package com.bigroad.ttb.android.service;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.logging.C2134e;

public class SyncService extends Service {
    private static void m11032a(String str) {
    }

    public static void m11031a() {
        Context b = OurApplication.m6279b();
        C2134e.m10678c("TT-SyncService", "Starting SyncService");
        b.startService(new Intent(b, SyncService.class));
    }

    public static void m11033a(boolean z, int i, Notification notification) {
        Context b = OurApplication.m6279b();
        Intent intent = new Intent(b, SyncService.class);
        intent.putExtra("com.bigroad.ttb.android.service.startForeground", z);
        intent.putExtra("com.bigroad.ttb.android.service.notificationid", i);
        if (notification != null) {
            intent.putExtra("com.bigroad.ttb.android.service.notification", notification);
        }
        b.startService(intent);
    }

    public static void m11034b() {
        Context b = OurApplication.m6279b();
        C2134e.m10678c("TT-SyncService", "Stopping SyncService");
        b.stopService(new Intent(b, SyncService.class));
    }

    public void onCreate() {
        m11032a("onCreate");
    }

    public void onStart(Intent intent, int i) {
        m11032a("onStart");
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null && intent.hasExtra("com.bigroad.ttb.android.service.startForeground")) {
            boolean booleanExtra = intent.getBooleanExtra("com.bigroad.ttb.android.service.startForeground", false);
            int intExtra = intent.getIntExtra("com.bigroad.ttb.android.service.notificationid", 3);
            Notification notification = (Notification) intent.getParcelableExtra("com.bigroad.ttb.android.service.notification");
            if (booleanExtra && notification != null) {
                startForeground(intExtra, notification);
            } else if (!booleanExtra) {
                stopForeground(true);
            }
        }
        return 1;
    }

    public void onDestroy() {
        m11032a("onDestroy");
    }

    public IBinder onBind(Intent intent) {
        m11032a("onBind");
        return null;
    }

    public void onRebind(Intent intent) {
        m11032a("onRebind");
    }

    public boolean onUnbind(Intent intent) {
        m11032a("onUnbind");
        return true;
    }
}
