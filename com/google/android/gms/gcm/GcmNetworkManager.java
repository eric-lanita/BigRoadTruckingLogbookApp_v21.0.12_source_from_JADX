package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzab;
import java.util.List;

public class GcmNetworkManager {
    public static final int RESULT_FAILURE = 2;
    public static final int RESULT_RESCHEDULE = 1;
    public static final int RESULT_SUCCESS = 0;
    private static GcmNetworkManager f10975a;
    private Context f10976b;
    private final PendingIntent f10977c = PendingIntent.getBroadcast(this.f10976b, 0, new Intent(), 0);

    private GcmNetworkManager(Context context) {
        this.f10976b = context;
    }

    private Intent m17048a() {
        String zzdd = GoogleCloudMessaging.zzdd(this.f10976b);
        int i = -1;
        if (zzdd != null) {
            i = GoogleCloudMessaging.zzde(this.f10976b);
        }
        if (zzdd == null || i < GoogleCloudMessaging.Zm) {
            Log.e("GcmNetworkManager", "Google Play Services is not available, dropping GcmNetworkManager request. code=" + i);
            return null;
        }
        Intent intent = new Intent("com.google.android.gms.gcm.ACTION_SCHEDULE");
        intent.setPackage(zzdd);
        intent.putExtra("app", this.f10977c);
        return intent;
    }

    private void m17049a(ComponentName componentName) {
        m17052b(componentName.getClassName());
        Intent a = m17048a();
        if (a != null) {
            a.putExtra("scheduler_action", "CANCEL_ALL");
            a.putExtra("component", componentName);
            this.f10976b.sendBroadcast(a);
        }
    }

    static void m17050a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Must provide a valid tag.");
        } else if (100 < str.length()) {
            throw new IllegalArgumentException("Tag is larger than max permissible tag length (100)");
        }
    }

    private void m17051a(String str, ComponentName componentName) {
        m17050a(str);
        m17052b(componentName.getClassName());
        Intent a = m17048a();
        if (a != null) {
            a.putExtra("scheduler_action", "CANCEL_TASK");
            a.putExtra("tag", str);
            a.putExtra("component", componentName);
            this.f10976b.sendBroadcast(a);
        }
    }

    private void m17052b(String str) {
        boolean z = true;
        zzab.zzb((Object) str, (Object) "GcmTaskService must not be null.");
        Intent intent = new Intent(GcmTaskService.SERVICE_ACTION_EXECUTE_TASK);
        intent.setPackage(this.f10976b.getPackageName());
        List<ResolveInfo> queryIntentServices = this.f10976b.getPackageManager().queryIntentServices(intent, 0);
        boolean z2 = (queryIntentServices == null || queryIntentServices.size() == 0) ? false : true;
        zzab.zzb(z2, (Object) "There is no GcmTaskService component registered within this package. Have you extended GcmTaskService correctly?");
        for (ResolveInfo resolveInfo : queryIntentServices) {
            if (resolveInfo.serviceInfo.name.equals(str)) {
                break;
            }
        }
        z = false;
        zzab.zzb(z, new StringBuilder(String.valueOf(str).length() + 119).append("The GcmTaskService class you provided ").append(str).append(" does not seem to support receiving com.google.android.gms.gcm.ACTION_TASK_READY.").toString());
    }

    public static GcmNetworkManager getInstance(Context context) {
        GcmNetworkManager gcmNetworkManager;
        synchronized (GcmNetworkManager.class) {
            if (f10975a == null) {
                f10975a = new GcmNetworkManager(context.getApplicationContext());
            }
            gcmNetworkManager = f10975a;
        }
        return gcmNetworkManager;
    }

    public void cancelAllTasks(Class<? extends GcmTaskService> cls) {
        zze(cls);
    }

    public void cancelTask(String str, Class<? extends GcmTaskService> cls) {
        zzb(str, cls);
    }

    public void schedule(Task task) {
        m17052b(task.getServiceName());
        Intent a = m17048a();
        if (a != null) {
            Bundle extras = a.getExtras();
            extras.putString("scheduler_action", "SCHEDULE_TASK");
            task.toBundle(extras);
            a.putExtras(extras);
            this.f10976b.sendBroadcast(a);
        }
    }

    public void zzb(String str, Class<? extends Service> cls) {
        m17051a(str, new ComponentName(this.f10976b, cls));
    }

    public void zze(Class<? extends Service> cls) {
        m17049a(new ComponentName(this.f10976b, cls));
    }
}
