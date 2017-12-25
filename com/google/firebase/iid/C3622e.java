package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.iid.InstanceID;
import com.google.android.gms.iid.MessengerCompat;
import java.io.IOException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class C3622e {
    static String f13133a = null;
    static int f13134b = 0;
    static int f13135c = 0;
    static int f13136d = 0;
    Context f13137e;
    Map<String, Object> f13138f = new HashMap();
    Messenger f13139g;
    Messenger f13140h;
    MessengerCompat f13141i;
    PendingIntent f13142j;
    long f13143k;
    long f13144l;
    int f13145m;
    int f13146n;
    long f13147o;

    public C3622e(Context context) {
        this.f13137e = context;
    }

    public static String m18917a(Context context) {
        if (f13133a != null) {
            return f13133a;
        }
        f13134b = Process.myUid();
        PackageManager packageManager = context.getPackageManager();
        for (ResolveInfo resolveInfo : packageManager.queryIntentServices(new Intent("com.google.android.c2dm.intent.REGISTER"), 0)) {
            if (packageManager.checkPermission("com.google.android.c2dm.permission.RECEIVE", resolveInfo.serviceInfo.packageName) == 0) {
                try {
                    ApplicationInfo applicationInfo = packageManager.getApplicationInfo(resolveInfo.serviceInfo.packageName, 0);
                    Log.w("InstanceID/Rpc", "Found " + applicationInfo.uid);
                    f13135c = applicationInfo.uid;
                    f13133a = resolveInfo.serviceInfo.packageName;
                    return f13133a;
                } catch (NameNotFoundException e) {
                }
            } else {
                String valueOf = String.valueOf(resolveInfo.serviceInfo.packageName);
                String valueOf2 = String.valueOf("com.google.android.c2dm.intent.REGISTER");
                Log.w("InstanceID/Rpc", new StringBuilder((String.valueOf(valueOf).length() + 56) + String.valueOf(valueOf2).length()).append("Possible malicious package ").append(valueOf).append(" declares ").append(valueOf2).append(" without permission").toString());
            }
        }
        Log.w("InstanceID/Rpc", "Failed to resolve REGISTER intent, falling back");
        ApplicationInfo applicationInfo2;
        try {
            applicationInfo2 = packageManager.getApplicationInfo("com.google.android.gms", 0);
            f13133a = applicationInfo2.packageName;
            f13135c = applicationInfo2.uid;
            return f13133a;
        } catch (NameNotFoundException e2) {
            try {
                applicationInfo2 = packageManager.getApplicationInfo("com.google.android.gsf", 0);
                f13133a = applicationInfo2.packageName;
                f13135c = applicationInfo2.uid;
                return f13133a;
            } catch (NameNotFoundException e3) {
                Log.w("InstanceID/Rpc", "Both Google Play Services and legacy GSF package are missing");
                return null;
            }
        }
    }

    static String m18918a(KeyPair keyPair, String... strArr) {
        String str = null;
        try {
            byte[] bytes = TextUtils.join("\n", strArr).getBytes("UTF-8");
            try {
                PrivateKey privateKey = keyPair.getPrivate();
                Signature instance = Signature.getInstance(privateKey instanceof RSAPrivateKey ? "SHA256withRSA" : "SHA256withECDSA");
                instance.initSign(privateKey);
                instance.update(bytes);
                str = FirebaseInstanceId.m18881a(instance.sign());
            } catch (Throwable e) {
                Log.e("InstanceID/Rpc", "Unable to sign registration request", e);
            }
        } catch (Throwable e2) {
            Log.e("InstanceID/Rpc", "Unable to encode string", e2);
        }
        return str;
    }

    private void m18919a(Object obj) {
        synchronized (getClass()) {
            for (String str : this.f13138f.keySet()) {
                Object obj2 = this.f13138f.get(str);
                this.f13138f.put(str, obj);
                m18920a(obj2, obj);
            }
        }
    }

    private void m18920a(Object obj, Object obj2) {
        if (obj instanceof ConditionVariable) {
            ((ConditionVariable) obj).open();
        }
        if (obj instanceof Messenger) {
            Messenger messenger = (Messenger) obj;
            Message obtain = Message.obtain();
            obtain.obj = obj2;
            try {
                messenger.send(obtain);
            } catch (RemoteException e) {
                String valueOf = String.valueOf(e);
                Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 24).append("Failed to send response ").append(valueOf).toString());
            }
        }
    }

    private void m18921a(String str) {
        if ("com.google.android.gsf".equals(f13133a)) {
            this.f13145m++;
            if (this.f13145m >= 3) {
                if (this.f13145m == 3) {
                    this.f13146n = new Random().nextInt(1000) + 1000;
                }
                this.f13146n *= 2;
                this.f13147o = SystemClock.elapsedRealtime() + ((long) this.f13146n);
                Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(str).length() + 31).append("Backoff due to ").append(str).append(" for ").append(this.f13146n).toString());
            }
        }
    }

    private void m18922a(String str, Object obj) {
        synchronized (getClass()) {
            Object obj2 = this.f13138f.get(str);
            this.f13138f.put(str, obj);
            m18920a(obj2, obj);
        }
    }

    private static int m18923b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(C3622e.m18917a(context), 0).versionCode;
        } catch (NameNotFoundException e) {
            return -1;
        }
    }

    private Intent m18924b(Bundle bundle, KeyPair keyPair) {
        Intent intent;
        ConditionVariable conditionVariable = new ConditionVariable();
        String b = C3622e.m18925b();
        synchronized (getClass()) {
            this.f13138f.put(b, conditionVariable);
        }
        m18930a(bundle, keyPair, b);
        conditionVariable.block(30000);
        synchronized (getClass()) {
            Object remove = this.f13138f.remove(b);
            if (remove instanceof Intent) {
                intent = (Intent) remove;
            } else if (remove instanceof String) {
                throw new IOException((String) remove);
            } else {
                String valueOf = String.valueOf(remove);
                Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 12).append("No response ").append(valueOf).toString());
                throw new IOException(InstanceID.ERROR_TIMEOUT);
            }
        }
        return intent;
    }

    public static synchronized String m18925b() {
        String num;
        synchronized (C3622e.class) {
            int i = f13136d;
            f13136d = i + 1;
            num = Integer.toString(i);
        }
        return num;
    }

    Intent m18926a(Bundle bundle, KeyPair keyPair) {
        Intent b = m18924b(bundle, keyPair);
        return (b == null || !b.hasExtra("google.messenger")) ? b : m18924b(bundle, keyPair);
    }

    void m18927a() {
        if (this.f13139g == null) {
            C3622e.m18917a(this.f13137e);
            this.f13139g = new Messenger(new Handler(this, Looper.getMainLooper()) {
                final /* synthetic */ C3622e f13132a;

                public void handleMessage(Message message) {
                    this.f13132a.m18931a(message);
                }
            });
        }
    }

    synchronized void m18928a(Intent intent) {
        if (this.f13142j == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.f13142j = PendingIntent.getBroadcast(this.f13137e, 0, intent2, 0);
        }
        intent.putExtra("app", this.f13142j);
    }

    protected void m18929a(Intent intent, String str) {
        this.f13143k = SystemClock.elapsedRealtime();
        intent.putExtra("kid", new StringBuilder(String.valueOf(str).length() + 5).append("|ID|").append(str).append("|").toString());
        intent.putExtra("X-kid", new StringBuilder(String.valueOf(str).length() + 5).append("|ID|").append(str).append("|").toString());
        boolean equals = "com.google.android.gsf".equals(f13133a);
        if (Log.isLoggable("InstanceID/Rpc", 3)) {
            String valueOf = String.valueOf(intent.getExtras());
            Log.d("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 8).append("Sending ").append(valueOf).toString());
        }
        if (equals) {
            this.f13137e.startService(intent);
            return;
        }
        intent.putExtra("google.messenger", this.f13139g);
        if (!(this.f13140h == null && this.f13141i == null)) {
            Message obtain = Message.obtain();
            obtain.obj = intent;
            try {
                if (this.f13140h != null) {
                    this.f13140h.send(obtain);
                    return;
                } else {
                    this.f13141i.send(obtain);
                    return;
                }
            } catch (RemoteException e) {
                if (Log.isLoggable("InstanceID/Rpc", 3)) {
                    Log.d("InstanceID/Rpc", "Messenger failed, fallback to startService");
                }
            }
        }
        this.f13137e.startService(intent);
    }

    public void m18930a(Bundle bundle, KeyPair keyPair, String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.f13147o == 0 || elapsedRealtime > this.f13147o) {
            m18927a();
            if (f13133a == null) {
                throw new IOException(InstanceID.ERROR_MISSING_INSTANCEID_SERVICE);
            }
            this.f13143k = SystemClock.elapsedRealtime();
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage(f13133a);
            bundle.putString("gmsv", Integer.toString(C3622e.m18923b(this.f13137e)));
            bundle.putString("osv", Integer.toString(VERSION.SDK_INT));
            bundle.putString("app_ver", Integer.toString(FirebaseInstanceId.m18883b(this.f13137e)));
            bundle.putString("app_ver_name", FirebaseInstanceId.m18884c(this.f13137e));
            bundle.putString("cliv", "fiid-9452000");
            bundle.putString("appid", FirebaseInstanceId.m18880a(keyPair));
            String a = FirebaseInstanceId.m18879a(this.f13137e);
            if (a != null) {
                bundle.putString("gmp_app_id", a);
            }
            bundle.putString("pub2", FirebaseInstanceId.m18881a(keyPair.getPublic().getEncoded()));
            bundle.putString("sig", C3622e.m18918a(keyPair, this.f13137e.getPackageName(), a));
            intent.putExtras(bundle);
            m18928a(intent);
            m18929a(intent, str);
            return;
        }
        elapsedRealtime = this.f13147o - elapsedRealtime;
        Log.w("InstanceID/Rpc", "Backoff mode, next request attempt: " + elapsedRealtime + " interval: " + this.f13146n);
        throw new IOException(InstanceID.ERROR_BACKOFF);
    }

    public void m18931a(Message message) {
        if (message != null) {
            if (message.obj instanceof Intent) {
                Intent intent = (Intent) message.obj;
                intent.setExtrasClassLoader(MessengerCompat.class.getClassLoader());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof MessengerCompat) {
                        this.f13141i = (MessengerCompat) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        this.f13140h = (Messenger) parcelableExtra;
                    }
                }
                m18934d((Intent) message.obj);
                return;
            }
            Log.w("InstanceID/Rpc", "Dropping invalid message");
        }
    }

    String m18932b(Intent intent) {
        if (intent == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String stringExtra = intent.getStringExtra("registration_id");
        if (stringExtra == null) {
            stringExtra = intent.getStringExtra("unregistered");
        }
        if (stringExtra != null) {
            return stringExtra;
        }
        stringExtra = intent.getStringExtra("error");
        if (stringExtra != null) {
            throw new IOException(stringExtra);
        }
        String valueOf = String.valueOf(intent.getExtras());
        Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 29).append("Unexpected response from GCM ").append(valueOf).toString(), new Throwable());
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    void m18933c(Intent intent) {
        String stringExtra = intent.getStringExtra("error");
        if (stringExtra == null) {
            String valueOf = String.valueOf(intent.getExtras());
            Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 49).append("Unexpected response, no error or registration id ").append(valueOf).toString());
            return;
        }
        if (Log.isLoggable("InstanceID/Rpc", 3)) {
            valueOf = "InstanceID/Rpc";
            String str = "Received InstanceID error ";
            String valueOf2 = String.valueOf(stringExtra);
            Log.d(valueOf, valueOf2.length() != 0 ? str.concat(valueOf2) : new String(str));
        }
        if (stringExtra.startsWith("|")) {
            String[] split = stringExtra.split("\\|");
            if (!"ID".equals(split[1])) {
                String str2 = "InstanceID/Rpc";
                String str3 = "Unexpected structured response ";
                valueOf2 = String.valueOf(stringExtra);
                Log.w(str2, valueOf2.length() != 0 ? str3.concat(valueOf2) : new String(str3));
            }
            if (split.length > 2) {
                valueOf2 = split[2];
                valueOf = split[3];
                if (valueOf.startsWith(":")) {
                    valueOf = valueOf.substring(1);
                }
            } else {
                valueOf = "UNKNOWN";
                valueOf2 = null;
            }
            intent.putExtra("error", valueOf);
        } else {
            valueOf2 = null;
            valueOf = stringExtra;
        }
        if (valueOf2 == null) {
            m18919a((Object) valueOf);
        } else {
            m18922a(valueOf2, (Object) valueOf);
        }
        long longExtra = intent.getLongExtra("Retry-After", 0);
        if (longExtra > 0) {
            this.f13144l = SystemClock.elapsedRealtime();
            this.f13146n = ((int) longExtra) * 1000;
            this.f13147o = SystemClock.elapsedRealtime() + ((long) this.f13146n);
            Log.w("InstanceID/Rpc", "Explicit request from server to backoff: " + this.f13146n);
        } else if ("SERVICE_NOT_AVAILABLE".equals(valueOf) || "AUTHENTICATION_FAILED".equals(valueOf)) {
            m18921a(valueOf);
        }
    }

    void m18934d(Intent intent) {
        if (intent != null) {
            String stringExtra;
            String str;
            if ("com.google.android.c2dm.intent.REGISTRATION".equals(intent.getAction())) {
                stringExtra = intent.getStringExtra("registration_id");
                if (stringExtra == null) {
                    stringExtra = intent.getStringExtra("unregistered");
                }
                if (stringExtra == null) {
                    m18933c(intent);
                    return;
                }
                this.f13143k = SystemClock.elapsedRealtime();
                this.f13147o = 0;
                this.f13145m = 0;
                this.f13146n = 0;
                if (Log.isLoggable("InstanceID/Rpc", 3)) {
                    String valueOf = String.valueOf(intent.getExtras());
                    Log.d("InstanceID/Rpc", new StringBuilder((String.valueOf(stringExtra).length() + 16) + String.valueOf(valueOf).length()).append("AppIDResponse: ").append(stringExtra).append(" ").append(valueOf).toString());
                }
                if (stringExtra.startsWith("|")) {
                    String[] split = stringExtra.split("\\|");
                    if (!"ID".equals(split[1])) {
                        str = "InstanceID/Rpc";
                        String str2 = "Unexpected structured response ";
                        stringExtra = String.valueOf(stringExtra);
                        Log.w(str, stringExtra.length() != 0 ? str2.concat(stringExtra) : new String(str2));
                    }
                    str = split[2];
                    if (split.length > 4) {
                        if ("SYNC".equals(split[3])) {
                            FirebaseInstanceId.m18885d(this.f13137e);
                        } else if ("RST".equals(split[3])) {
                            FirebaseInstanceId.m18882a(this.f13137e, C3619c.m18906a(this.f13137e, null).m18911c());
                            intent.removeExtra("registration_id");
                            m18922a(str, (Object) intent);
                            return;
                        }
                    }
                    stringExtra = split[split.length - 1];
                    if (stringExtra.startsWith(":")) {
                        stringExtra = stringExtra.substring(1);
                    }
                    intent.putExtra("registration_id", stringExtra);
                    stringExtra = str;
                } else {
                    stringExtra = null;
                }
                if (stringExtra == null) {
                    m18919a((Object) intent);
                } else {
                    m18922a(stringExtra, (Object) intent);
                }
            } else if (Log.isLoggable("InstanceID/Rpc", 3)) {
                str = "InstanceID/Rpc";
                String str3 = "Unexpected response ";
                stringExtra = String.valueOf(intent.getAction());
                Log.d(str, stringExtra.length() != 0 ? str3.concat(stringExtra) : new String(str3));
            }
        } else if (Log.isLoggable("InstanceID/Rpc", 3)) {
            Log.d("InstanceID/Rpc", "Unexpected response: null");
        }
    }
}
