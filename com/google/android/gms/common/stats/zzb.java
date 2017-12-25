package com.google.android.gms.common.stats;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Debug;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.stats.zzc.zza;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.common.util.zzt;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class zzb {
    private static final Object f10877a = new Object();
    private static zzb f10878b;
    private static Integer f10879h;
    private final List<String> f10880c;
    private final List<String> f10881d;
    private final List<String> f10882e;
    private final List<String> f10883f;
    private zze f10884g;
    private zze f10885i;

    private zzb() {
        if (m16995b() == zzd.LOG_LEVEL_OFF) {
            this.f10880c = Collections.EMPTY_LIST;
            this.f10881d = Collections.EMPTY_LIST;
            this.f10882e = Collections.EMPTY_LIST;
            this.f10883f = Collections.EMPTY_LIST;
            return;
        }
        String str = (String) zza.Au.get();
        this.f10880c = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        str = (String) zza.Av.get();
        this.f10881d = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        str = (String) zza.Aw.get();
        this.f10882e = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        str = (String) zza.Ax.get();
        this.f10883f = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        this.f10884g = new zze(1024, ((Long) zza.Ay.get()).longValue());
        this.f10885i = new zze(1024, ((Long) zza.Ay.get()).longValue());
    }

    private static String m16987a(int i, int i2) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StringBuffer stringBuffer = new StringBuffer();
        int i3 = i2 + i;
        while (i < i3) {
            stringBuffer.append(m16989a(stackTrace, i)).append(" ");
            i++;
        }
        return stringBuffer.toString();
    }

    private String m16988a(ServiceConnection serviceConnection) {
        return String.valueOf((((long) Process.myPid()) << 32) | ((long) System.identityHashCode(serviceConnection)));
    }

    private static String m16989a(StackTraceElement[] stackTraceElementArr, int i) {
        if (i + 4 >= stackTraceElementArr.length) {
            return "<bottom of call stack>";
        }
        StackTraceElement stackTraceElement = stackTraceElementArr[i + 4];
        String valueOf = String.valueOf(stackTraceElement.getClassName());
        String valueOf2 = String.valueOf(stackTraceElement.getMethodName());
        return new StringBuilder((String.valueOf(valueOf).length() + 13) + String.valueOf(valueOf2).length()).append(valueOf).append(".").append(valueOf2).append(":").append(stackTraceElement.getLineNumber()).toString();
    }

    private void m16990a(Context context, String str, int i, String str2, String str3, String str4, String str5) {
        Parcelable connectionEvent;
        long currentTimeMillis = System.currentTimeMillis();
        String str6 = null;
        if (!((m16995b() & zzd.AD) == 0 || i == 13)) {
            str6 = m16987a(3, 5);
        }
        long j = 0;
        if ((m16995b() & zzd.AF) != 0) {
            j = Debug.getNativeHeapAllocatedSize();
        }
        if (i == 1 || i == 4 || i == 14) {
            connectionEvent = new ConnectionEvent(currentTimeMillis, i, null, null, null, null, str6, str, SystemClock.elapsedRealtime(), j);
        } else {
            connectionEvent = new ConnectionEvent(currentTimeMillis, i, str2, str3, str4, str5, str6, str, SystemClock.elapsedRealtime(), j);
        }
        context.startService(new Intent().setComponent(zzd.Az).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", connectionEvent));
    }

    private void m16991a(Context context, String str, String str2, Intent intent, int i) {
        String str3 = null;
        if (m16992a() && this.f10884g != null) {
            String str4;
            String str5;
            if (i != 4 && i != 1) {
                ServiceInfo b = m16996b(context, intent);
                if (b == null) {
                    Log.w("ConnectionTracker", String.format("Client %s made an invalid request %s", new Object[]{str2, intent.toUri(0)}));
                    return;
                }
                str4 = b.processName;
                str5 = b.name;
                str3 = zzt.zzavz();
                if (m16994a(str3, str2, str4, str5)) {
                    this.f10884g.zzhx(str);
                } else {
                    return;
                }
            } else if (this.f10884g.zzhy(str)) {
                str5 = null;
                str4 = null;
            } else {
                return;
            }
            m16990a(context, str, i, str3, str2, str4, str5);
        }
    }

    private boolean m16992a() {
        return false;
    }

    private boolean m16993a(Context context, Intent intent) {
        ComponentName component = intent.getComponent();
        return component == null ? false : zzd.zzq(context, component.getPackageName());
    }

    private boolean m16994a(String str, String str2, String str3, String str4) {
        return (this.f10880c.contains(str) || this.f10881d.contains(str2) || this.f10882e.contains(str3) || this.f10883f.contains(str4) || (str3.equals(str) && (m16995b() & zzd.AE) != 0)) ? false : true;
    }

    private static int m16995b() {
        if (f10879h == null) {
            try {
                f10879h = Integer.valueOf(zzd.zzabc() ? ((Integer) zza.At.get()).intValue() : zzd.LOG_LEVEL_OFF);
            } catch (SecurityException e) {
                f10879h = Integer.valueOf(zzd.LOG_LEVEL_OFF);
            }
        }
        return f10879h.intValue();
    }

    private static ServiceInfo m16996b(Context context, Intent intent) {
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 128);
        if (queryIntentServices == null || queryIntentServices.size() == 0) {
            Log.w("ConnectionTracker", String.format("There are no handler of this intent: %s\n Stack trace: %s", new Object[]{intent.toUri(0), m16987a(3, 20)}));
            return null;
        } else if (queryIntentServices.size() <= 1) {
            return ((ResolveInfo) queryIntentServices.get(0)).serviceInfo;
        } else {
            Log.w("ConnectionTracker", String.format("Multiple handlers found for this intent: %s\n Stack trace: %s", new Object[]{intent.toUri(0), m16987a(3, 20)}));
            for (ResolveInfo resolveInfo : queryIntentServices) {
                Log.w("ConnectionTracker", resolveInfo.serviceInfo.name);
            }
            return null;
        }
    }

    public static zzb zzaux() {
        synchronized (f10877a) {
            if (f10878b == null) {
                f10878b = new zzb();
            }
        }
        return f10878b;
    }

    @SuppressLint({"UntrackedBindService"})
    public void zza(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
        m16991a(context, m16988a(serviceConnection), null, null, 1);
    }

    public void zza(Context context, ServiceConnection serviceConnection, String str, Intent intent) {
        m16991a(context, m16988a(serviceConnection), str, intent, 3);
    }

    public boolean zza(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return zza(context, context.getClass().getName(), intent, serviceConnection, i);
    }

    @SuppressLint({"UntrackedBindService"})
    public boolean zza(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        if (m16993a(context, intent)) {
            Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
            return false;
        }
        boolean bindService = context.bindService(intent, serviceConnection, i);
        if (bindService) {
            m16991a(context, m16988a(serviceConnection), str, intent, 2);
        }
        return bindService;
    }

    public void zzb(Context context, ServiceConnection serviceConnection) {
        m16991a(context, m16988a(serviceConnection), null, null, 4);
    }
}
