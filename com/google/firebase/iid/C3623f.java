package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.util.zzx;
import java.io.File;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class C3623f {
    SharedPreferences f13148a;
    Context f13149b;

    public C3623f(Context context) {
        this(context, "com.google.android.gms.appid");
    }

    public C3623f(Context context, String str) {
        this.f13149b = context;
        this.f13148a = context.getSharedPreferences(str, 4);
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf("-no-backup");
        m18936g(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
    }

    private String m18935c(String str, String str2, String str3) {
        String valueOf = String.valueOf("|T|");
        return new StringBuilder((((String.valueOf(str).length() + 1) + String.valueOf(valueOf).length()) + String.valueOf(str2).length()) + String.valueOf(str3).length()).append(str).append(valueOf).append(str2).append("|").append(str3).toString();
    }

    private void m18936g(String str) {
        File file = new File(zzx.getNoBackupFilesDir(this.f13149b), str);
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !m18946b()) {
                    Log.i("InstanceID/Store", "App restored, clearing state");
                    FirebaseInstanceId.m18882a(this.f13149b, this);
                }
            } catch (IOException e) {
                if (Log.isLoggable("InstanceID/Store", 3)) {
                    String str2 = "InstanceID/Store";
                    String str3 = "Error creating file in no backup dir: ";
                    String valueOf = String.valueOf(e.getMessage());
                    Log.d(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                }
            }
        }
    }

    public SharedPreferences m18937a() {
        return this.f13148a;
    }

    synchronized String m18938a(String str) {
        return this.f13148a.getString(str, null);
    }

    synchronized String m18939a(String str, String str2) {
        SharedPreferences sharedPreferences;
        String valueOf;
        sharedPreferences = this.f13148a;
        valueOf = String.valueOf("|S|");
        return sharedPreferences.getString(new StringBuilder(((String.valueOf(str).length() + 0) + String.valueOf(valueOf).length()) + String.valueOf(str2).length()).append(str).append(valueOf).append(str2).toString(), null);
    }

    public synchronized String m18940a(String str, String str2, String str3) {
        return this.f13148a.getString(m18935c(str, str2, str3), null);
    }

    synchronized KeyPair m18941a(String str, long j) {
        KeyPair a;
        a = C3617a.m18903a();
        Editor edit = this.f13148a.edit();
        m18942a(edit, str, "|P|", FirebaseInstanceId.m18881a(a.getPublic().getEncoded()));
        m18942a(edit, str, "|K|", FirebaseInstanceId.m18881a(a.getPrivate().getEncoded()));
        m18942a(edit, str, "cre", Long.toString(j));
        edit.commit();
        return a;
    }

    synchronized void m18942a(Editor editor, String str, String str2, String str3) {
        String valueOf = String.valueOf("|S|");
        editor.putString(new StringBuilder(((String.valueOf(str).length() + 0) + String.valueOf(valueOf).length()) + String.valueOf(str2).length()).append(str).append(valueOf).append(str2).toString(), str3);
    }

    public synchronized void m18943a(String str, String str2, String str3, String str4, String str5) {
        String c = m18935c(str, str2, str3);
        Editor edit = this.f13148a.edit();
        edit.putString(c, str4);
        edit.putString("appVersion", str5);
        edit.putString("lastToken", Long.toString(System.currentTimeMillis() / 1000));
        edit.commit();
    }

    public synchronized void m18944b(String str) {
        Editor edit = this.f13148a.edit();
        for (String str2 : this.f13148a.getAll().keySet()) {
            if (str2.startsWith(str)) {
                edit.remove(str2);
            }
        }
        edit.commit();
    }

    public synchronized void m18945b(String str, String str2, String str3) {
        String c = m18935c(str, str2, str3);
        Editor edit = this.f13148a.edit();
        edit.remove(c);
        edit.commit();
    }

    public boolean m18946b() {
        return this.f13148a.getAll().isEmpty();
    }

    public KeyPair m18947c(String str) {
        return m18951f(str);
    }

    public synchronized void m18948c() {
        this.f13148a.edit().clear().commit();
    }

    void m18949d(String str) {
        m18944b(String.valueOf(str).concat("|"));
    }

    public void m18950e(String str) {
        m18944b(String.valueOf(str).concat("|T|"));
    }

    KeyPair m18951f(String str) {
        Object e;
        String a = m18939a(str, "|P|");
        String a2 = m18939a(str, "|K|");
        if (a == null || a2 == null) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(a, 8);
            byte[] decode2 = Base64.decode(a2, 8);
            KeyFactory instance = KeyFactory.getInstance("RSA");
            return new KeyPair(instance.generatePublic(new X509EncodedKeySpec(decode)), instance.generatePrivate(new PKCS8EncodedKeySpec(decode2)));
        } catch (InvalidKeySpecException e2) {
            e = e2;
            a = String.valueOf(e);
            Log.w("InstanceID/Store", new StringBuilder(String.valueOf(a).length() + 19).append("Invalid key stored ").append(a).toString());
            FirebaseInstanceId.m18882a(this.f13149b, this);
            return null;
        } catch (NoSuchAlgorithmException e3) {
            e = e3;
            a = String.valueOf(e);
            Log.w("InstanceID/Store", new StringBuilder(String.valueOf(a).length() + 19).append("Invalid key stored ").append(a).toString());
            FirebaseInstanceId.m18882a(this.f13149b, this);
            return null;
        }
    }
}
