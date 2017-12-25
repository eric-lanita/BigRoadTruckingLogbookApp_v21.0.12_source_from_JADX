package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.support.v4.p008d.C0270a;
import android.util.Base64;
import android.util.Log;
import com.google.firebase.C3611a;
import java.io.IOException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class FirebaseInstanceId {
    private static Map<String, FirebaseInstanceId> f13112a = new C0270a();
    private static C3620d f13113b;
    private final C3611a f13114c;
    private final C3619c f13115d;
    private final String f13116e = m18888b();

    private FirebaseInstanceId(C3611a c3611a, C3619c c3619c) {
        this.f13114c = c3611a;
        this.f13115d = c3619c;
        if (this.f13116e == null) {
            throw new IllegalStateException("IID failing to initialize, FirebaseApp is missing project ID");
        }
        FirebaseInstanceIdService.m6207a(this.f13114c.m18864a(), this);
    }

    public static FirebaseInstanceId m18878a() {
        return getInstance(C3611a.m18861d());
    }

    static String m18879a(Context context) {
        return m18878a().f13114c.m18866c().m18876a();
    }

    static String m18880a(KeyPair keyPair) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(keyPair.getPublic().getEncoded());
            digest[0] = (byte) (((digest[0] & 15) + 112) & 255);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException e) {
            Log.w("FirebaseInstanceId", "Unexpected error, device missing required alghorithms");
            return null;
        }
    }

    static String m18881a(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    static void m18882a(Context context, C3623f c3623f) {
        c3623f.m18948c();
        Intent intent = new Intent();
        intent.putExtra("CMD", "RST");
        context.sendBroadcast(FirebaseInstanceIdInternalReceiver.m18897a(context, intent));
    }

    static int m18883b(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(valueOf).length() + 38).append("Never happens: can't find own package ").append(valueOf).toString());
            return i;
        }
    }

    static String m18884c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(valueOf).length() + 38).append("Never happens: can't find own package ").append(valueOf).toString());
            return null;
        }
    }

    static void m18885d(Context context) {
        Intent intent = new Intent();
        intent.setPackage(context.getPackageName());
        intent.putExtra("CMD", "SYNC");
        context.sendBroadcast(FirebaseInstanceIdInternalReceiver.m18897a(context, intent));
    }

    @Keep
    public static synchronized FirebaseInstanceId getInstance(C3611a c3611a) {
        FirebaseInstanceId firebaseInstanceId;
        synchronized (FirebaseInstanceId.class) {
            firebaseInstanceId = (FirebaseInstanceId) f13112a.get(c3611a.m18866c().m18876a());
            if (firebaseInstanceId == null) {
                C3619c a = C3619c.m18906a(c3611a.m18864a(), null);
                if (f13113b == null) {
                    f13113b = new C3620d(a.m18911c());
                }
                firebaseInstanceId = new FirebaseInstanceId(c3611a, a);
                f13112a.put(c3611a.m18866c().m18876a(), firebaseInstanceId);
            }
        }
        return firebaseInstanceId;
    }

    public String m18886a(String str, String str2) {
        return this.f13115d.m18909b(str, str2, null);
    }

    void m18887a(String str) {
        if (m18891d() == null) {
            throw new IOException("token not available");
        }
        Bundle bundle = new Bundle();
        String str2 = "gcm.topic";
        String valueOf = String.valueOf("/topics/");
        String valueOf2 = String.valueOf(str);
        bundle.putString(str2, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        C3619c c3619c = this.f13115d;
        valueOf = m18891d();
        String valueOf3 = String.valueOf("/topics/");
        valueOf2 = String.valueOf(str);
        c3619c.m18909b(valueOf, valueOf2.length() != 0 ? valueOf3.concat(valueOf2) : new String(valueOf3), bundle);
    }

    String m18888b() {
        String b = this.f13114c.m18866c().m18877b();
        if (b != null) {
            return b;
        }
        b = this.f13114c.m18866c().m18876a();
        if (!b.startsWith("1:")) {
            return b;
        }
        String[] split = b.split(":");
        if (split.length < 2) {
            return null;
        }
        b = split[1];
        return b.isEmpty() ? null : b;
    }

    void m18889b(String str) {
        if (m18891d() == null) {
            throw new IOException("token not available");
        }
        Bundle bundle = new Bundle();
        String str2 = "gcm.topic";
        String valueOf = String.valueOf("/topics/");
        String valueOf2 = String.valueOf(str);
        bundle.putString(str2, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        C3619c c3619c = this.f13115d;
        valueOf = m18891d();
        String valueOf3 = String.valueOf("/topics/");
        valueOf2 = String.valueOf(str);
        c3619c.m18908a(valueOf, valueOf2.length() != 0 ? valueOf3.concat(valueOf2) : new String(valueOf3), bundle);
    }

    public String m18890c() {
        return m18880a(this.f13115d.m18907a());
    }

    public String m18891d() {
        String e = m18892e();
        if (e == null) {
            FirebaseInstanceIdService.m6206a(this.f13114c.m18864a());
        }
        return e;
    }

    String m18892e() {
        return this.f13115d.m18911c().m18940a("", this.f13116e, "*");
    }

    String m18893f() {
        return m18886a(this.f13116e, "*");
    }

    C3620d m18894g() {
        return f13113b;
    }
}
