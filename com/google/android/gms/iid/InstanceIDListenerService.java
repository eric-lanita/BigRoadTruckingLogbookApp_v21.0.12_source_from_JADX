package com.google.android.gms.iid;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;
import com.facebook.internal.NativeProtocol;

public class InstanceIDListenerService extends Service {
    static String f11039a = NativeProtocol.WEB_DIALOG_ACTION;
    private static String f11040f = "google.com/iid";
    private static String f11041g = "CMD";
    private static String f11042h = "gcm.googleapis.com/refresh";
    MessengerCompat f11043b = new MessengerCompat(new Handler(this, Looper.getMainLooper()) {
        final /* synthetic */ InstanceIDListenerService f11037a;

        public void handleMessage(Message message) {
            this.f11037a.m17100a(message, MessengerCompat.zzc(message));
        }
    });
    BroadcastReceiver f11044c = new C32512(this);
    int f11045d;
    int f11046e;

    class C32512 extends BroadcastReceiver {
        final /* synthetic */ InstanceIDListenerService f11038a;

        C32512(InstanceIDListenerService instanceIDListenerService) {
            this.f11038a = instanceIDListenerService;
        }

        public void onReceive(Context context, Intent intent) {
            if (Log.isLoggable("InstanceID", 3)) {
                intent.getStringExtra("registration_id");
                String valueOf = String.valueOf(intent.getExtras());
                Log.d("InstanceID", new StringBuilder(String.valueOf(valueOf).length() + 46).append("Received GSF callback using dynamic receiver: ").append(valueOf).toString());
            }
            this.f11038a.zzn(intent);
            this.f11038a.m17102a();
        }
    }

    static void m17098a(Context context) {
        Intent intent = new Intent("com.google.android.gms.iid.InstanceID");
        intent.setPackage(context.getPackageName());
        intent.putExtra(f11041g, "SYNC");
        context.startService(intent);
    }

    static void m17099a(Context context, zzd com_google_android_gms_iid_zzd) {
        com_google_android_gms_iid_zzd.zzbmd();
        Intent intent = new Intent("com.google.android.gms.iid.InstanceID");
        intent.putExtra(f11041g, "RST");
        intent.setPackage(context.getPackageName());
        context.startService(intent);
    }

    private void m17100a(Message message, int i) {
        zzc.zzdi(this);
        getPackageManager();
        if (i == zzc.f11055c || i == zzc.f11054b) {
            zzn((Intent) message.obj);
            return;
        }
        int i2 = zzc.f11054b;
        Log.w("InstanceID", "Message from unexpected caller " + i + " mine=" + i2 + " appid=" + zzc.f11055c);
    }

    void m17102a() {
        synchronized (this) {
            this.f11045d--;
            if (this.f11045d == 0) {
                stopSelf(this.f11046e);
            }
            if (Log.isLoggable("InstanceID", 3)) {
                int i = this.f11045d;
                Log.d("InstanceID", "Stop " + i + " " + this.f11046e);
            }
        }
    }

    void m17103a(int i) {
        synchronized (this) {
            this.f11045d++;
            if (i > this.f11046e) {
                this.f11046e = i;
            }
        }
    }

    public IBinder onBind(Intent intent) {
        return (intent == null || !"com.google.android.gms.iid.InstanceID".equals(intent.getAction())) ? null : this.f11043b.getBinder();
    }

    public void onCreate() {
        IntentFilter intentFilter = new IntentFilter("com.google.android.c2dm.intent.REGISTRATION");
        intentFilter.addCategory(getPackageName());
        registerReceiver(this.f11044c, intentFilter, "com.google.android.c2dm.permission.RECEIVE", null);
    }

    public void onDestroy() {
        unregisterReceiver(this.f11044c);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        m17103a(i2);
        if (intent == null) {
            m17102a();
            return 2;
        }
        try {
            if ("com.google.android.gms.iid.InstanceID".equals(intent.getAction())) {
                if (VERSION.SDK_INT <= 18) {
                    Intent intent2 = (Intent) intent.getParcelableExtra("GSF");
                    if (intent2 != null) {
                        startService(intent2);
                        return 1;
                    }
                }
                zzn(intent);
            }
            m17102a();
            if (intent.getStringExtra("from") != null) {
                WakefulBroadcastReceiver.completeWakefulIntent(intent);
            }
            return 2;
        } finally {
            m17102a();
        }
    }

    public void onTokenRefresh() {
    }

    public void zzbx(boolean z) {
        onTokenRefresh();
    }

    public void zzn(Intent intent) {
        InstanceID instance;
        String stringExtra = intent.getStringExtra("subtype");
        if (stringExtra == null) {
            instance = InstanceID.getInstance(this);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("subtype", stringExtra);
            instance = InstanceID.zza(this, bundle);
        }
        String stringExtra2 = intent.getStringExtra(f11041g);
        if (intent.getStringExtra("error") == null && intent.getStringExtra("registration_id") == null) {
            if (Log.isLoggable("InstanceID", 3)) {
                String valueOf = String.valueOf(intent.getExtras());
                Log.d("InstanceID", new StringBuilder(((String.valueOf(stringExtra).length() + 18) + String.valueOf(stringExtra2).length()) + String.valueOf(valueOf).length()).append("Service command ").append(stringExtra).append(" ").append(stringExtra2).append(" ").append(valueOf).toString());
            }
            if (intent.getStringExtra("unregistered") != null) {
                zzd zzbly = instance.zzbly();
                if (stringExtra == null) {
                    stringExtra = "";
                }
                zzbly.zzkj(stringExtra);
                instance.zzblz().zzv(intent);
                return;
            } else if (f11042h.equals(intent.getStringExtra("from"))) {
                instance.zzbly().zzkj(stringExtra);
                zzbx(false);
                return;
            } else if ("RST".equals(stringExtra2)) {
                instance.zzblx();
                zzbx(true);
                return;
            } else if ("RST_FULL".equals(stringExtra2)) {
                if (!instance.zzbly().isEmpty()) {
                    instance.zzbly().zzbmd();
                    zzbx(true);
                    return;
                }
                return;
            } else if ("SYNC".equals(stringExtra2)) {
                instance.zzbly().zzkj(stringExtra);
                zzbx(false);
                return;
            } else if (!"PING".equals(stringExtra2)) {
                return;
            } else {
                return;
            }
        }
        if (Log.isLoggable("InstanceID", 3)) {
            stringExtra2 = "InstanceID";
            String str = "Register result in service ";
            stringExtra = String.valueOf(stringExtra);
            Log.d(stringExtra2, stringExtra.length() != 0 ? str.concat(stringExtra) : new String(str));
        }
        instance.zzblz().zzv(intent);
    }
}
