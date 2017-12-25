package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.zzab;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

public class zzk {
    private static final Lock f10477a = new ReentrantLock();
    private static zzk f10478b;
    private final Lock f10479c = new ReentrantLock();
    private final SharedPreferences f10480d;

    zzk(Context context) {
        this.f10480d = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    private String m16764b(String str, String str2) {
        String valueOf = String.valueOf(":");
        return new StringBuilder(((String.valueOf(str).length() + 0) + String.valueOf(valueOf).length()) + String.valueOf(str2).length()).append(str).append(valueOf).append(str2).toString();
    }

    public static zzk zzbc(Context context) {
        zzab.zzy(context);
        f10477a.lock();
        try {
            if (f10478b == null) {
                f10478b = new zzk(context.getApplicationContext());
            }
            zzk com_google_android_gms_auth_api_signin_internal_zzk = f10478b;
            return com_google_android_gms_auth_api_signin_internal_zzk;
        } finally {
            f10477a.unlock();
        }
    }

    GoogleSignInAccount m16765a(String str) {
        GoogleSignInAccount googleSignInAccount = null;
        if (!TextUtils.isEmpty(str)) {
            String c = m16769c(m16764b("googleSignInAccount", str));
            if (c != null) {
                try {
                    googleSignInAccount = GoogleSignInAccount.zzfo(c);
                } catch (JSONException e) {
                }
            }
        }
        return googleSignInAccount;
    }

    void m16766a(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        zzab.zzy(googleSignInAccount);
        zzab.zzy(googleSignInOptions);
        String zzafm = googleSignInAccount.zzafm();
        m16767a(m16764b("googleSignInAccount", zzafm), googleSignInAccount.zzafo());
        m16767a(m16764b("googleSignInOptions", zzafm), googleSignInOptions.zzafn());
    }

    protected void m16767a(String str, String str2) {
        this.f10479c.lock();
        try {
            this.f10480d.edit().putString(str, str2).apply();
        } finally {
            this.f10479c.unlock();
        }
    }

    GoogleSignInOptions m16768b(String str) {
        GoogleSignInOptions googleSignInOptions = null;
        if (!TextUtils.isEmpty(str)) {
            String c = m16769c(m16764b("googleSignInOptions", str));
            if (c != null) {
                try {
                    googleSignInOptions = GoogleSignInOptions.zzfq(c);
                } catch (JSONException e) {
                }
            }
        }
        return googleSignInOptions;
    }

    protected String m16769c(String str) {
        this.f10479c.lock();
        try {
            String string = this.f10480d.getString(str, null);
            return string;
        } finally {
            this.f10479c.unlock();
        }
    }

    void m16770d(String str) {
        if (!TextUtils.isEmpty(str)) {
            m16771e(m16764b("googleSignInAccount", str));
            m16771e(m16764b("googleSignInOptions", str));
        }
    }

    protected void m16771e(String str) {
        this.f10479c.lock();
        try {
            this.f10480d.edit().remove(str).apply();
        } finally {
            this.f10479c.unlock();
        }
    }

    public GoogleSignInAccount zzagj() {
        return m16765a(m16769c("defaultGoogleSignInAccount"));
    }

    public GoogleSignInOptions zzagk() {
        return m16768b(m16769c("defaultGoogleSignInAccount"));
    }

    public void zzagl() {
        String c = m16769c("defaultGoogleSignInAccount");
        m16771e("defaultGoogleSignInAccount");
        m16770d(c);
    }

    public void zzb(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        zzab.zzy(googleSignInAccount);
        zzab.zzy(googleSignInOptions);
        m16767a("defaultGoogleSignInAccount", googleSignInAccount.zzafm());
        m16766a(googleSignInAccount, googleSignInOptions);
    }
}
