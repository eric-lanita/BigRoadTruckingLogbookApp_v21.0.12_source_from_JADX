package com.google.android.gms.iid;

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
import com.facebook.appevents.AppEventsConstants;
import java.io.IOException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class zzc {
    static String f11053a = null;
    static int f11054b = 0;
    static int f11055c = 0;
    static int f11056d = 0;
    Context f11057e;
    Map<String, Object> f11058f = new HashMap();
    Messenger f11059g;
    Messenger f11060h;
    MessengerCompat f11061i;
    PendingIntent f11062j;
    long f11063k;
    long f11064l;
    int f11065m;
    int f11066n;
    long f11067o;

    public zzc(Context context) {
        this.f11057e = context;
    }

    private static int m17105a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(zzdi(context), 0).versionCode;
        } catch (NameNotFoundException e) {
            return -1;
        }
    }

    static String m17106a(KeyPair keyPair, String... strArr) {
        String str = null;
        try {
            byte[] bytes = TextUtils.join("\n", strArr).getBytes("UTF-8");
            try {
                PrivateKey privateKey = keyPair.getPrivate();
                Signature instance = Signature.getInstance(privateKey instanceof RSAPrivateKey ? "SHA256withRSA" : "SHA256withECDSA");
                instance.initSign(privateKey);
                instance.update(bytes);
                str = InstanceID.m17094a(instance.sign());
            } catch (Throwable e) {
                Log.e("InstanceID/Rpc", "Unable to sign registration request", e);
            }
        } catch (Throwable e2) {
            Log.e("InstanceID/Rpc", "Unable to encode string", e2);
        }
        return str;
    }

    private void m17107a(Object obj) {
        synchronized (getClass()) {
            for (String str : this.f11058f.keySet()) {
                Object obj2 = this.f11058f.get(str);
                this.f11058f.put(str, obj);
                m17108a(obj2, obj);
            }
        }
    }

    private void m17108a(Object obj, Object obj2) {
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

    private void m17109a(String str) {
        if ("com.google.android.gsf".equals(f11053a)) {
            this.f11065m++;
            if (this.f11065m >= 3) {
                if (this.f11065m == 3) {
                    this.f11066n = new Random().nextInt(1000) + 1000;
                }
                this.f11066n *= 2;
                this.f11067o = SystemClock.elapsedRealtime() + ((long) this.f11066n);
                Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(str).length() + 31).append("Backoff due to ").append(str).append(" for ").append(this.f11066n).toString());
            }
        }
    }

    private void m17110a(String str, Object obj) {
        synchronized (getClass()) {
            Object obj2 = this.f11058f.get(str);
            this.f11058f.put(str, obj);
            m17108a(obj2, obj);
        }
    }

    private Intent m17111b(Bundle bundle, KeyPair keyPair) {
        Intent intent;
        ConditionVariable conditionVariable = new ConditionVariable();
        String zzbmc = zzbmc();
        synchronized (getClass()) {
            this.f11058f.put(zzbmc, conditionVariable);
        }
        m17116a(bundle, keyPair, zzbmc);
        conditionVariable.block(30000);
        synchronized (getClass()) {
            Object remove = this.f11058f.remove(zzbmc);
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

    public static synchronized String zzbmc() {
        String num;
        synchronized (zzc.class) {
            int i = f11056d;
            f11056d = i + 1;
            num = Integer.toString(i);
        }
        return num;
    }

    public static String zzdi(Context context) {
        if (f11053a != null) {
            return f11053a;
        }
        f11054b = Process.myUid();
        PackageManager packageManager = context.getPackageManager();
        for (ResolveInfo resolveInfo : packageManager.queryIntentServices(new Intent("com.google.android.c2dm.intent.REGISTER"), 0)) {
            if (packageManager.checkPermission("com.google.android.c2dm.permission.RECEIVE", resolveInfo.serviceInfo.packageName) == 0) {
                try {
                    ApplicationInfo applicationInfo = packageManager.getApplicationInfo(resolveInfo.serviceInfo.packageName, 0);
                    Log.w("InstanceID/Rpc", "Found " + applicationInfo.uid);
                    f11055c = applicationInfo.uid;
                    f11053a = resolveInfo.serviceInfo.packageName;
                    return f11053a;
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
            f11053a = applicationInfo2.packageName;
            f11055c = applicationInfo2.uid;
            return f11053a;
        } catch (NameNotFoundException e2) {
            try {
                applicationInfo2 = packageManager.getApplicationInfo("com.google.android.gsf", 0);
                f11053a = applicationInfo2.packageName;
                f11055c = applicationInfo2.uid;
                return f11053a;
            } catch (NameNotFoundException e3) {
                Log.w("InstanceID/Rpc", "Both Google Play Services and legacy GSF package are missing");
                return null;
            }
        }
    }

    Intent m17112a(Bundle bundle, KeyPair keyPair) {
        Intent b = m17111b(bundle, keyPair);
        return (b == null || !b.hasExtra("google.messenger")) ? b : m17111b(bundle, keyPair);
    }

    void m17113a() {
        if (this.f11059g == null) {
            zzdi(this.f11057e);
            this.f11059g = new Messenger(new Handler(this, Looper.getMainLooper()) {
                final /* synthetic */ zzc f11052a;

                public void handleMessage(Message message) {
                    this.f11052a.zze(message);
                }
            });
        }
    }

    synchronized void m17114a(Intent intent) {
        if (this.f11062j == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.f11062j = PendingIntent.getBroadcast(this.f11057e, 0, intent2, 0);
        }
        intent.putExtra("app", this.f11062j);
    }

    protected void m17115a(Intent intent, String str) {
        this.f11063k = SystemClock.elapsedRealtime();
        intent.putExtra("kid", new StringBuilder(String.valueOf(str).length() + 5).append("|ID|").append(str).append("|").toString());
        intent.putExtra("X-kid", new StringBuilder(String.valueOf(str).length() + 5).append("|ID|").append(str).append("|").toString());
        boolean equals = "com.google.android.gsf".equals(f11053a);
        String stringExtra = intent.getStringExtra("useGsf");
        if (stringExtra != null) {
            equals = AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(stringExtra);
        }
        if (Log.isLoggable("InstanceID/Rpc", 3)) {
            String valueOf = String.valueOf(intent.getExtras());
            Log.d("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 8).append("Sending ").append(valueOf).toString());
        }
        if (this.f11060h != null) {
            intent.putExtra("google.messenger", this.f11059g);
            Message obtain = Message.obtain();
            obtain.obj = intent;
            try {
                this.f11060h.send(obtain);
                return;
            } catch (RemoteException e) {
                if (Log.isLoggable("InstanceID/Rpc", 3)) {
                    Log.d("InstanceID/Rpc", "Messenger failed, fallback to startService");
                }
            }
        }
        if (equals) {
            Intent intent2 = new Intent("com.google.android.gms.iid.InstanceID");
            intent2.setPackage(this.f11057e.getPackageName());
            intent2.putExtra("GSF", intent);
            this.f11057e.startService(intent2);
            return;
        }
        intent.putExtra("google.messenger", this.f11059g);
        intent.putExtra("messenger2", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        if (this.f11061i != null) {
            Message obtain2 = Message.obtain();
            obtain2.obj = intent;
            try {
                this.f11061i.send(obtain2);
                return;
            } catch (RemoteException e2) {
                if (Log.isLoggable("InstanceID/Rpc", 3)) {
                    Log.d("InstanceID/Rpc", "Messenger failed, fallback to startService");
                }
            }
        }
        this.f11057e.startService(intent);
    }

    void m17116a(Bundle bundle, KeyPair keyPair, String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.f11067o == 0 || elapsedRealtime > this.f11067o) {
            m17113a();
            if (f11053a == null) {
                throw new IOException(InstanceID.ERROR_MISSING_INSTANCEID_SERVICE);
            }
            this.f11063k = SystemClock.elapsedRealtime();
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage(f11053a);
            bundle.putString("gmsv", Integer.toString(m17105a(this.f11057e)));
            bundle.putString("osv", Integer.toString(VERSION.SDK_INT));
            bundle.putString("app_ver", Integer.toString(InstanceID.m17092a(this.f11057e)));
            bundle.putString("app_ver_name", InstanceID.m17095b(this.f11057e));
            bundle.putString("cliv", "iid-9452000");
            bundle.putString("appid", InstanceID.m17093a(keyPair));
            bundle.putString("pub2", InstanceID.m17094a(keyPair.getPublic().getEncoded()));
            bundle.putString("sig", m17106a(keyPair, this.f11057e.getPackageName(), r1));
            intent.putExtras(bundle);
            m17114a(intent);
            m17115a(intent, str);
            return;
        }
        elapsedRealtime = this.f11067o - elapsedRealtime;
        Log.w("InstanceID/Rpc", "Backoff mode, next request attempt: " + elapsedRealtime + " interval: " + this.f11066n);
        throw new IOException(InstanceID.ERROR_BACKOFF);
    }

    String m17117b(Intent intent) {
        if (intent == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String stringExtra = intent.getStringExtra("registration_id");
        if (stringExtra == null) {
            stringExtra = intent.getStringExtra("unregistered");
        }
        intent.getLongExtra("Retry-After", 0);
        String valueOf;
        if (stringExtra != null) {
            if (stringExtra == null) {
                return stringExtra;
            }
            stringExtra = intent.getStringExtra("error");
            if (stringExtra == null) {
                throw new IOException(stringExtra);
            }
            valueOf = String.valueOf(intent.getExtras());
            Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 29).append("Unexpected response from GCM ").append(valueOf).toString(), new Throwable());
            throw new IOException("SERVICE_NOT_AVAILABLE");
        } else if (stringExtra == null) {
            return stringExtra;
        } else {
            stringExtra = intent.getStringExtra("error");
            if (stringExtra == null) {
                valueOf = String.valueOf(intent.getExtras());
                Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 29).append("Unexpected response from GCM ").append(valueOf).toString(), new Throwable());
                throw new IOException("SERVICE_NOT_AVAILABLE");
            }
            throw new IOException(stringExtra);
        }
    }

    void m17118c(Intent intent) {
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
            m17107a((Object) valueOf);
        } else {
            m17110a(valueOf2, (Object) valueOf);
        }
        long longExtra = intent.getLongExtra("Retry-After", 0);
        if (longExtra > 0) {
            this.f11064l = SystemClock.elapsedRealtime();
            this.f11066n = ((int) longExtra) * 1000;
            this.f11067o = SystemClock.elapsedRealtime() + ((long) this.f11066n);
            Log.w("InstanceID/Rpc", "Explicit request from server to backoff: " + this.f11066n);
        } else if ("SERVICE_NOT_AVAILABLE".equals(valueOf) || "AUTHENTICATION_FAILED".equals(valueOf)) {
            m17109a(valueOf);
        }
    }

    public void zze(Message message) {
        if (message != null) {
            if (message.obj instanceof Intent) {
                Intent intent = (Intent) message.obj;
                intent.setExtrasClassLoader(MessengerCompat.class.getClassLoader());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof MessengerCompat) {
                        this.f11061i = (MessengerCompat) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        this.f11060h = (Messenger) parcelableExtra;
                    }
                }
                zzv((Intent) message.obj);
                return;
            }
            Log.w("InstanceID/Rpc", "Dropping invalid message");
        }
    }

    public void zzv(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            String stringExtra;
            String valueOf;
            if ("com.google.android.c2dm.intent.REGISTRATION".equals(action) || "com.google.android.gms.iid.InstanceID".equals(action)) {
                action = intent.getStringExtra("registration_id");
                stringExtra = action == null ? intent.getStringExtra("unregistered") : action;
                if (stringExtra == null) {
                    m17118c(intent);
                    return;
                }
                this.f11063k = SystemClock.elapsedRealtime();
                this.f11067o = 0;
                this.f11065m = 0;
                this.f11066n = 0;
                if (Log.isLoggable("InstanceID/Rpc", 3)) {
                    valueOf = String.valueOf(intent.getExtras());
                    Log.d("InstanceID/Rpc", new StringBuilder((String.valueOf(stringExtra).length() + 16) + String.valueOf(valueOf).length()).append("AppIDResponse: ").append(stringExtra).append(" ").append(valueOf).toString());
                }
                action = null;
                if (stringExtra.startsWith("|")) {
                    String[] split = stringExtra.split("\\|");
                    if (!"ID".equals(split[1])) {
                        String str = "InstanceID/Rpc";
                        String str2 = "Unexpected structured response ";
                        action = String.valueOf(stringExtra);
                        Log.w(str, action.length() != 0 ? str2.concat(action) : new String(str2));
                    }
                    stringExtra = split[2];
                    if (split.length > 4) {
                        if ("SYNC".equals(split[3])) {
                            InstanceIDListenerService.m17098a(this.f11057e);
                        } else if ("RST".equals(split[3])) {
                            InstanceIDListenerService.m17099a(this.f11057e, InstanceID.getInstance(this.f11057e).zzbly());
                            intent.removeExtra("registration_id");
                            m17110a(stringExtra, (Object) intent);
                            return;
                        }
                    }
                    action = split[split.length - 1];
                    if (action.startsWith(":")) {
                        action = action.substring(1);
                    }
                    intent.putExtra("registration_id", action);
                    action = stringExtra;
                }
                if (action == null) {
                    m17107a((Object) intent);
                } else {
                    m17110a(action, (Object) intent);
                }
            } else if (Log.isLoggable("InstanceID/Rpc", 3)) {
                stringExtra = "InstanceID/Rpc";
                valueOf = "Unexpected response ";
                action = String.valueOf(intent.getAction());
                Log.d(stringExtra, action.length() != 0 ? valueOf.concat(action) : new String(valueOf));
            }
        } else if (Log.isLoggable("InstanceID/Rpc", 3)) {
            Log.d("InstanceID/Rpc", "Unexpected response: null");
        }
    }
}
