package com.google.android.gms.gcm;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import com.facebook.applinks.AppLinkData;
import java.util.HashSet;
import java.util.Set;

public abstract class GcmTaskService extends Service {
    public static final String SERVICE_ACTION_EXECUTE_TASK = "com.google.android.gms.gcm.ACTION_TASK_READY";
    public static final String SERVICE_ACTION_INITIALIZE = "com.google.android.gms.gcm.SERVICE_ACTION_INITIALIZE";
    public static final String SERVICE_PERMISSION = "com.google.android.gms.permission.BIND_NETWORK_TASK_SERVICE";
    private final Set<String> f10986a = new HashSet();
    private int f10987b;

    private class zza extends Thread {
        final /* synthetic */ GcmTaskService f10982a;
        private final String f10983b;
        private final zzb f10984c;
        private final Bundle f10985d;

        zza(GcmTaskService gcmTaskService, String str, IBinder iBinder, Bundle bundle) {
            this.f10982a = gcmTaskService;
            super(String.valueOf(str).concat(" GCM Task"));
            this.f10983b = str;
            this.f10984c = com.google.android.gms.gcm.zzb.zza.zzgm(iBinder);
            this.f10985d = bundle;
        }

        public void run() {
            Process.setThreadPriority(10);
            try {
                this.f10984c.zzsn(this.f10982a.onRunTask(new TaskParams(this.f10983b, this.f10985d)));
            } catch (RemoteException e) {
                String str = "GcmTaskService";
                String str2 = "Error reporting result of operation to scheduler for ";
                String valueOf = String.valueOf(this.f10983b);
                Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            } finally {
                this.f10982a.m17057a(this.f10983b);
            }
        }
    }

    private void m17055a(int i) {
        synchronized (this.f10986a) {
            this.f10987b = i;
            if (this.f10986a.size() == 0) {
                stopSelf(this.f10987b);
            }
        }
    }

    private void m17057a(String str) {
        synchronized (this.f10986a) {
            this.f10986a.remove(str);
            if (this.f10986a.size() == 0) {
                stopSelf(this.f10987b);
            }
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onInitializeTasks() {
    }

    public abstract int onRunTask(TaskParams taskParams);

    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            m17055a(i2);
        } else {
            try {
                intent.setExtrasClassLoader(PendingCallback.class.getClassLoader());
                String action = intent.getAction();
                if (SERVICE_ACTION_EXECUTE_TASK.equals(action)) {
                    String stringExtra = intent.getStringExtra("tag");
                    Parcelable parcelableExtra = intent.getParcelableExtra("callback");
                    Bundle bundle = (Bundle) intent.getParcelableExtra(AppLinkData.ARGUMENTS_EXTRAS_KEY);
                    if (parcelableExtra == null || !(parcelableExtra instanceof PendingCallback)) {
                        String valueOf = String.valueOf(getPackageName());
                        Log.e("GcmTaskService", new StringBuilder((String.valueOf(valueOf).length() + 47) + String.valueOf(stringExtra).length()).append(valueOf).append(" ").append(stringExtra).append(": Could not process request, invalid callback.").toString());
                    } else {
                        synchronized (this.f10986a) {
                            this.f10986a.add(stringExtra);
                        }
                        new zza(this, stringExtra, ((PendingCallback) parcelableExtra).getIBinder(), bundle).start();
                    }
                } else if (SERVICE_ACTION_INITIALIZE.equals(action)) {
                    onInitializeTasks();
                } else {
                    Log.e("GcmTaskService", new StringBuilder(String.valueOf(action).length() + 37).append("Unknown action received ").append(action).append(", terminating").toString());
                }
                m17055a(i2);
            } finally {
                m17055a(i2);
            }
        }
        return 2;
    }
}
