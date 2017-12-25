package android.support.v4.app;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.provider.Settings.Secure;
import android.support.v4.app.C0218v.C0220a;
import android.util.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class am {
    private static final int f578a = f584i.mo126a();
    private static final Object f579b = new Object();
    private static String f580c;
    private static Set<String> f581d = new HashSet();
    private static final Object f582g = new Object();
    private static C0166h f583h;
    private static final C0159b f584i;
    private final Context f585e;
    private final NotificationManager f586f = ((NotificationManager) this.f585e.getSystemService("notification"));

    private interface C0157i {
        void mo125a(C0218v c0218v);
    }

    private static class C0158a implements C0157i {
        final String f558a;
        final int f559b;
        final String f560c;
        final boolean f561d = false;

        public C0158a(String str, int i, String str2) {
            this.f558a = str;
            this.f559b = i;
            this.f560c = str2;
        }

        public void mo125a(C0218v c0218v) {
            if (this.f561d) {
                c0218v.mo156a(this.f558a);
            } else {
                c0218v.mo157a(this.f558a, this.f559b, this.f560c);
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("CancelTask[");
            stringBuilder.append("packageName:").append(this.f558a);
            stringBuilder.append(", id:").append(this.f559b);
            stringBuilder.append(", tag:").append(this.f560c);
            stringBuilder.append(", all:").append(this.f561d);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    interface C0159b {
        int mo126a();

        void mo127a(NotificationManager notificationManager, String str, int i);

        void mo128a(NotificationManager notificationManager, String str, int i, Notification notification);
    }

    static class C0160c implements C0159b {
        C0160c() {
        }

        public void mo127a(NotificationManager notificationManager, String str, int i) {
            notificationManager.cancel(i);
        }

        public void mo128a(NotificationManager notificationManager, String str, int i, Notification notification) {
            notificationManager.notify(i, notification);
        }

        public int mo126a() {
            return 1;
        }
    }

    static class C0161d extends C0160c {
        C0161d() {
        }

        public void mo127a(NotificationManager notificationManager, String str, int i) {
            an.m745a(notificationManager, str, i);
        }

        public void mo128a(NotificationManager notificationManager, String str, int i, Notification notification) {
            an.m746a(notificationManager, str, i, notification);
        }
    }

    static class C0162e extends C0161d {
        C0162e() {
        }

        public int mo126a() {
            return 33;
        }
    }

    private static class C0163f implements C0157i {
        final String f562a;
        final int f563b;
        final String f564c;
        final Notification f565d;

        public C0163f(String str, int i, String str2, Notification notification) {
            this.f562a = str;
            this.f563b = i;
            this.f564c = str2;
            this.f565d = notification;
        }

        public void mo125a(C0218v c0218v) {
            c0218v.mo158a(this.f562a, this.f563b, this.f564c, this.f565d);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("NotifyTask[");
            stringBuilder.append("packageName:").append(this.f562a);
            stringBuilder.append(", id:").append(this.f563b);
            stringBuilder.append(", tag:").append(this.f564c);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    private static class C0164g {
        final ComponentName f566a;
        final IBinder f567b;

        public C0164g(ComponentName componentName, IBinder iBinder) {
            this.f566a = componentName;
            this.f567b = iBinder;
        }
    }

    private static class C0166h implements ServiceConnection, Callback {
        private final Context f573a;
        private final HandlerThread f574b;
        private final Handler f575c;
        private final Map<ComponentName, C0165a> f576d = new HashMap();
        private Set<String> f577e = new HashSet();

        private static class C0165a {
            public final ComponentName f568a;
            public boolean f569b = false;
            public C0218v f570c;
            public LinkedList<C0157i> f571d = new LinkedList();
            public int f572e = 0;

            public C0165a(ComponentName componentName) {
                this.f568a = componentName;
            }
        }

        public C0166h(Context context) {
            this.f573a = context;
            this.f574b = new HandlerThread("NotificationManagerCompat");
            this.f574b.start();
            this.f575c = new Handler(this.f574b.getLooper(), this);
        }

        public void m735a(C0157i c0157i) {
            this.f575c.obtainMessage(0, c0157i).sendToTarget();
        }

        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    m732b((C0157i) message.obj);
                    return true;
                case 1:
                    C0164g c0164g = (C0164g) message.obj;
                    m728a(c0164g.f566a, c0164g.f567b);
                    return true;
                case 2:
                    m727a((ComponentName) message.obj);
                    return true;
                case 3:
                    m730b((ComponentName) message.obj);
                    return true;
                default:
                    return false;
            }
        }

        private void m732b(C0157i c0157i) {
            m726a();
            for (C0165a c0165a : this.f576d.values()) {
                c0165a.f571d.add(c0157i);
                m734d(c0165a);
            }
        }

        private void m728a(ComponentName componentName, IBinder iBinder) {
            C0165a c0165a = (C0165a) this.f576d.get(componentName);
            if (c0165a != null) {
                c0165a.f570c = C0220a.m1004a(iBinder);
                c0165a.f572e = 0;
                m734d(c0165a);
            }
        }

        private void m727a(ComponentName componentName) {
            C0165a c0165a = (C0165a) this.f576d.get(componentName);
            if (c0165a != null) {
                m731b(c0165a);
            }
        }

        private void m730b(ComponentName componentName) {
            C0165a c0165a = (C0165a) this.f576d.get(componentName);
            if (c0165a != null) {
                m734d(c0165a);
            }
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Connected to service " + componentName);
            }
            this.f575c.obtainMessage(1, new C0164g(componentName, iBinder)).sendToTarget();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Disconnected from service " + componentName);
            }
            this.f575c.obtainMessage(2, componentName).sendToTarget();
        }

        private void m726a() {
            Set b = am.m740b(this.f573a);
            if (!b.equals(this.f577e)) {
                this.f577e = b;
                List<ResolveInfo> queryIntentServices = this.f573a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 4);
                Set<ComponentName> hashSet = new HashSet();
                for (ResolveInfo resolveInfo : queryIntentServices) {
                    if (b.contains(resolveInfo.serviceInfo.packageName)) {
                        ComponentName componentName = new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
                        if (resolveInfo.serviceInfo.permission != null) {
                            Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                        } else {
                            hashSet.add(componentName);
                        }
                    }
                }
                for (ComponentName componentName2 : hashSet) {
                    if (!this.f576d.containsKey(componentName2)) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                        }
                        this.f576d.put(componentName2, new C0165a(componentName2));
                    }
                }
                Iterator it = this.f576d.entrySet().iterator();
                while (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    if (!hashSet.contains(entry.getKey())) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Removing listener record for " + entry.getKey());
                        }
                        m731b((C0165a) entry.getValue());
                        it.remove();
                    }
                }
            }
        }

        private boolean m729a(C0165a c0165a) {
            if (c0165a.f569b) {
                return true;
            }
            c0165a.f569b = this.f573a.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(c0165a.f568a), this, am.f578a);
            if (c0165a.f569b) {
                c0165a.f572e = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + c0165a.f568a);
                this.f573a.unbindService(this);
            }
            return c0165a.f569b;
        }

        private void m731b(C0165a c0165a) {
            if (c0165a.f569b) {
                this.f573a.unbindService(this);
                c0165a.f569b = false;
            }
            c0165a.f570c = null;
        }

        private void m733c(C0165a c0165a) {
            if (!this.f575c.hasMessages(3, c0165a.f568a)) {
                c0165a.f572e++;
                if (c0165a.f572e > 6) {
                    Log.w("NotifManCompat", "Giving up on delivering " + c0165a.f571d.size() + " tasks to " + c0165a.f568a + " after " + c0165a.f572e + " retries");
                    c0165a.f571d.clear();
                    return;
                }
                int i = (1 << (c0165a.f572e - 1)) * 1000;
                if (Log.isLoggable("NotifManCompat", 3)) {
                    Log.d("NotifManCompat", "Scheduling retry for " + i + " ms");
                }
                this.f575c.sendMessageDelayed(this.f575c.obtainMessage(3, c0165a.f568a), (long) i);
            }
        }

        private void m734d(C0165a c0165a) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Processing component " + c0165a.f568a + ", " + c0165a.f571d.size() + " queued tasks");
            }
            if (!c0165a.f571d.isEmpty()) {
                if (!m729a(c0165a) || c0165a.f570c == null) {
                    m733c(c0165a);
                    return;
                }
                while (true) {
                    C0157i c0157i = (C0157i) c0165a.f571d.peek();
                    if (c0157i == null) {
                        break;
                    }
                    try {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Sending task " + c0157i);
                        }
                        c0157i.mo125a(c0165a.f570c);
                        c0165a.f571d.remove();
                    } catch (DeadObjectException e) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Remote service has died: " + c0165a.f568a);
                        }
                    } catch (Throwable e2) {
                        Log.w("NotifManCompat", "RemoteException communicating with " + c0165a.f568a, e2);
                    }
                }
                if (!c0165a.f571d.isEmpty()) {
                    m733c(c0165a);
                }
            }
        }
    }

    static {
        if (VERSION.SDK_INT >= 14) {
            f584i = new C0162e();
        } else if (VERSION.SDK_INT >= 5) {
            f584i = new C0161d();
        } else {
            f584i = new C0160c();
        }
    }

    public static am m737a(Context context) {
        return new am(context);
    }

    private am(Context context) {
        this.f585e = context;
    }

    public void m741a(int i) {
        m743a(null, i);
    }

    public void m743a(String str, int i) {
        f584i.mo127a(this.f586f, str, i);
        if (VERSION.SDK_INT <= 19) {
            m738a(new C0158a(this.f585e.getPackageName(), i, str));
        }
    }

    public void m742a(int i, Notification notification) {
        m744a(null, i, notification);
    }

    public void m744a(String str, int i, Notification notification) {
        if (m739a(notification)) {
            m738a(new C0163f(this.f585e.getPackageName(), i, str, notification));
            f584i.mo127a(this.f586f, str, i);
            return;
        }
        f584i.mo128a(this.f586f, str, i, notification);
    }

    public static Set<String> m740b(Context context) {
        String string = Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        if (!(string == null || string.equals(f580c))) {
            String[] split = string.split(":");
            Set hashSet = new HashSet(split.length);
            for (String unflattenFromString : split) {
                ComponentName unflattenFromString2 = ComponentName.unflattenFromString(unflattenFromString);
                if (unflattenFromString2 != null) {
                    hashSet.add(unflattenFromString2.getPackageName());
                }
            }
            synchronized (f579b) {
                f581d = hashSet;
                f580c = string;
            }
        }
        return f581d;
    }

    private static boolean m739a(Notification notification) {
        Bundle a = ad.m679a(notification);
        return a != null && a.getBoolean("android.support.useSideChannel");
    }

    private void m738a(C0157i c0157i) {
        synchronized (f582g) {
            if (f583h == null) {
                f583h = new C0166h(this.f585e.getApplicationContext());
            }
        }
        f583h.m735a(c0157i);
    }
}
