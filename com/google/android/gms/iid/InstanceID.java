package com.google.android.gms.iid;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.internal.ShareConstants;
import java.io.IOException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class InstanceID {
    public static final String ERROR_BACKOFF = "RETRY_LATER";
    public static final String ERROR_MAIN_THREAD = "MAIN_THREAD";
    public static final String ERROR_MISSING_INSTANCEID_SERVICE = "MISSING_INSTANCEID_SERVICE";
    public static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";
    public static final String ERROR_TIMEOUT = "TIMEOUT";
    static Map<String, InstanceID> f11029a = new HashMap();
    static String f11030f;
    private static zzd f11031g;
    private static zzc f11032h;
    Context f11033b;
    KeyPair f11034c;
    String f11035d = "";
    long f11036e;

    protected InstanceID(Context context, String str, Bundle bundle) {
        this.f11033b = context.getApplicationContext();
        this.f11035d = str;
    }

    static int m17092a(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            Log.w("InstanceID", new StringBuilder(String.valueOf(valueOf).length() + 38).append("Never happens: can't find own package ").append(valueOf).toString());
            return i;
        }
    }

    static String m17093a(KeyPair keyPair) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(keyPair.getPublic().getEncoded());
            digest[0] = (byte) (((digest[0] & 15) + 112) & 255);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException e) {
            Log.w("InstanceID", "Unexpected error, device missing required alghorithms");
            return null;
        }
    }

    static String m17094a(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    static String m17095b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            Log.w("InstanceID", new StringBuilder(String.valueOf(valueOf).length() + 38).append("Never happens: can't find own package ").append(valueOf).toString());
            return null;
        }
    }

    public static InstanceID getInstance(Context context) {
        return zza(context, null);
    }

    public static synchronized InstanceID zza(Context context, Bundle bundle) {
        InstanceID instanceID;
        synchronized (InstanceID.class) {
            String string = bundle == null ? "" : bundle.getString("subtype");
            String str = string == null ? "" : string;
            Context applicationContext = context.getApplicationContext();
            if (f11031g == null) {
                f11031g = new zzd(applicationContext);
                f11032h = new zzc(applicationContext);
            }
            f11030f = Integer.toString(m17092a(applicationContext));
            instanceID = (InstanceID) f11029a.get(str);
            if (instanceID == null) {
                instanceID = new InstanceID(applicationContext, str, bundle);
                f11029a.put(str, instanceID);
            }
        }
        return instanceID;
    }

    KeyPair m17096a() {
        if (this.f11034c == null) {
            this.f11034c = f11031g.zzkh(this.f11035d);
        }
        if (this.f11034c == null) {
            this.f11036e = System.currentTimeMillis();
            this.f11034c = f11031g.m17123a(this.f11035d, this.f11036e);
        }
        return this.f11034c;
    }

    boolean m17097b() {
        String a = f11031g.m17121a("appVersion");
        if (a == null || !a.equals(f11030f)) {
            return true;
        }
        a = f11031g.m17121a("lastToken");
        if (a == null) {
            return true;
        }
        return (System.currentTimeMillis() / 1000) - Long.valueOf(Long.parseLong(a)).longValue() > 604800;
    }

    public void deleteInstanceID() {
        zzb("*", "*", null);
        zzblx();
    }

    public void deleteToken(String str, String str2) {
        zzb(str, str2, null);
    }

    public long getCreationTime() {
        if (this.f11036e == 0) {
            String a = f11031g.m17122a(this.f11035d, "cre");
            if (a != null) {
                this.f11036e = Long.parseLong(a);
            }
        }
        return this.f11036e;
    }

    public String getId() {
        return m17093a(m17096a());
    }

    public String getToken(String str, String str2) {
        return getToken(str, str2, null);
    }

    public String getToken(String str, String str2, Bundle bundle) {
        Object obj = null;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        Object obj2 = 1;
        String zzi = m17097b() ? null : f11031g.zzi(this.f11035d, str, str2);
        if (zzi == null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            if (bundle.getString("ttl") != null) {
                obj2 = null;
            }
            if (!"jwt".equals(bundle.getString(ShareConstants.MEDIA_TYPE))) {
                obj = obj2;
            }
            zzi = zzc(str, str2, bundle);
            if (!(zzi == null || r1 == null)) {
                f11031g.zza(this.f11035d, str, str2, zzi, f11030f);
            }
        }
        return zzi;
    }

    public void zzb(String str, String str2, Bundle bundle) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        f11031g.zzj(this.f11035d, str, str2);
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("sender", str);
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("subscription", str);
        bundle.putString("delete", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        bundle.putString("X-delete", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        bundle.putString("subtype", "".equals(this.f11035d) ? str : this.f11035d);
        String str3 = "X-subtype";
        if (!"".equals(this.f11035d)) {
            str = this.f11035d;
        }
        bundle.putString(str3, str);
        f11032h.m17117b(f11032h.m17112a(bundle, m17096a()));
    }

    public void zzblx() {
        this.f11036e = 0;
        f11031g.m17125b(this.f11035d);
        this.f11034c = null;
    }

    public zzd zzbly() {
        return f11031g;
    }

    public zzc zzblz() {
        return f11032h;
    }

    public String zzc(String str, String str2, Bundle bundle) {
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("sender", str);
        String str3 = "".equals(this.f11035d) ? str : this.f11035d;
        if (!bundle.containsKey("legacy.register")) {
            bundle.putString("subscription", str);
            bundle.putString("subtype", str3);
            bundle.putString("X-subscription", str);
            bundle.putString("X-subtype", str3);
        }
        return f11032h.m17117b(f11032h.m17112a(bundle, m17096a()));
    }
}
