package com.google.android.gms.iid;

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

public class zzd {
    SharedPreferences f11068a;
    Context f11069b;

    public zzd(Context context) {
        this(context, "com.google.android.gms.appid");
    }

    public zzd(Context context, String str) {
        this.f11069b = context;
        this.f11068a = context.getSharedPreferences(str, 4);
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf("-no-backup");
        m17120d(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
    }

    private String m17119a(String str, String str2, String str3) {
        String valueOf = String.valueOf("|T|");
        return new StringBuilder((((String.valueOf(str).length() + 1) + String.valueOf(valueOf).length()) + String.valueOf(str2).length()) + String.valueOf(str3).length()).append(str).append(valueOf).append(str2).append("|").append(str3).toString();
    }

    private void m17120d(String str) {
        File file = new File(zzx.getNoBackupFilesDir(this.f11069b), str);
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !isEmpty()) {
                    Log.i("InstanceID/Store", "App restored, clearing state");
                    InstanceIDListenerService.m17099a(this.f11069b, this);
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

    synchronized String m17121a(String str) {
        return this.f11068a.getString(str, null);
    }

    synchronized String m17122a(String str, String str2) {
        SharedPreferences sharedPreferences;
        String valueOf;
        sharedPreferences = this.f11068a;
        valueOf = String.valueOf("|S|");
        return sharedPreferences.getString(new StringBuilder(((String.valueOf(str).length() + 0) + String.valueOf(valueOf).length()) + String.valueOf(str2).length()).append(str).append(valueOf).append(str2).toString(), null);
    }

    synchronized KeyPair m17123a(String str, long j) {
        KeyPair zzblv;
        zzblv = zza.zzblv();
        Editor edit = this.f11068a.edit();
        m17124a(edit, str, "|P|", InstanceID.m17094a(zzblv.getPublic().getEncoded()));
        m17124a(edit, str, "|K|", InstanceID.m17094a(zzblv.getPrivate().getEncoded()));
        m17124a(edit, str, "cre", Long.toString(j));
        edit.commit();
        return zzblv;
    }

    synchronized void m17124a(Editor editor, String str, String str2, String str3) {
        String valueOf = String.valueOf("|S|");
        editor.putString(new StringBuilder(((String.valueOf(str).length() + 0) + String.valueOf(valueOf).length()) + String.valueOf(str2).length()).append(str).append(valueOf).append(str2).toString(), str3);
    }

    void m17125b(String str) {
        zzkg(String.valueOf(str).concat("|"));
    }

    KeyPair m17126c(String str) {
        Object e;
        String a = m17122a(str, "|P|");
        String a2 = m17122a(str, "|K|");
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
            InstanceIDListenerService.m17099a(this.f11069b, this);
            return null;
        } catch (NoSuchAlgorithmException e3) {
            e = e3;
            a = String.valueOf(e);
            Log.w("InstanceID/Store", new StringBuilder(String.valueOf(a).length() + 19).append("Invalid key stored ").append(a).toString());
            InstanceIDListenerService.m17099a(this.f11069b, this);
            return null;
        }
    }

    public boolean isEmpty() {
        return this.f11068a.getAll().isEmpty();
    }

    public synchronized void zza(String str, String str2, String str3, String str4, String str5) {
        String a = m17119a(str, str2, str3);
        Editor edit = this.f11068a.edit();
        edit.putString(a, str4);
        edit.putString("appVersion", str5);
        edit.putString("lastToken", Long.toString(System.currentTimeMillis() / 1000));
        edit.commit();
    }

    public synchronized void zzbmd() {
        this.f11068a.edit().clear().commit();
    }

    public synchronized String zzi(String str, String str2, String str3) {
        return this.f11068a.getString(m17119a(str, str2, str3), null);
    }

    public synchronized void zzj(String str, String str2, String str3) {
        String a = m17119a(str, str2, str3);
        Editor edit = this.f11068a.edit();
        edit.remove(a);
        edit.commit();
    }

    public synchronized void zzkg(String str) {
        Editor edit = this.f11068a.edit();
        for (String str2 : this.f11068a.getAll().keySet()) {
            if (str2.startsWith(str)) {
                edit.remove(str2);
            }
        }
        edit.commit();
    }

    public KeyPair zzkh(String str) {
        return m17126c(str);
    }

    public void zzkj(String str) {
        zzkg(String.valueOf(str).concat("|T|"));
    }
}
