package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzh;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<GoogleSignInAccount> CREATOR = new zza();
    public static zze dA = zzh.zzavm();
    private static Comparator<Scope> f10446m = new C32081();
    final int f10447a;
    List<Scope> f10448b;
    private String f10449c;
    private String f10450d;
    private String f10451e;
    private String f10452f;
    private Uri f10453g;
    private String f10454h;
    private long f10455i;
    private String f10456j;
    private String f10457k;
    private String f10458l;

    class C32081 implements Comparator<Scope> {
        C32081() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return zza((Scope) obj, (Scope) obj2);
        }

        public int zza(Scope scope, Scope scope2) {
            return scope.zzaok().compareTo(scope2.zzaok());
        }
    }

    GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, List<Scope> list, String str7, String str8) {
        this.f10447a = i;
        this.f10449c = str;
        this.f10450d = str2;
        this.f10451e = str3;
        this.f10452f = str4;
        this.f10453g = uri;
        this.f10454h = str5;
        this.f10455i = j;
        this.f10456j = str6;
        this.f10448b = list;
        this.f10457k = str7;
        this.f10458l = str8;
    }

    private JSONObject m16754a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (getId() != null) {
                jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_ID, getId());
            }
            if (getIdToken() != null) {
                jSONObject.put("tokenId", getIdToken());
            }
            if (getEmail() != null) {
                jSONObject.put(Scopes.EMAIL, getEmail());
            }
            if (getDisplayName() != null) {
                jSONObject.put("displayName", getDisplayName());
            }
            if (getGivenName() != null) {
                jSONObject.put("givenName", getGivenName());
            }
            if (getFamilyName() != null) {
                jSONObject.put("familyName", getFamilyName());
            }
            if (getPhotoUrl() != null) {
                jSONObject.put("photoUrl", getPhotoUrl().toString());
            }
            if (getServerAuthCode() != null) {
                jSONObject.put("serverAuthCode", getServerAuthCode());
            }
            jSONObject.put("expirationTime", this.f10455i);
            jSONObject.put("obfuscatedIdentifier", zzafm());
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.f10448b, f10446m);
            for (Scope zzaok : this.f10448b) {
                jSONArray.put(zzaok.zzaok());
            }
            jSONObject.put("grantedScopes", jSONArray);
            return jSONObject;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static GoogleSignInAccount zza(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Long l, String str7, Set<Scope> set) {
        if (l == null) {
            l = Long.valueOf(dA.currentTimeMillis() / 1000);
        }
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, null, l.longValue(), zzab.zzhr(str7), new ArrayList((Collection) zzab.zzy(set)), str5, str6);
    }

    public static GoogleSignInAccount zzfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        Object optString = jSONObject.optString("photoUrl", null);
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        Set hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        return zza(jSONObject.optString(ShareConstants.WEB_DIALOG_PARAM_ID), jSONObject.optString("tokenId", null), jSONObject.optString(Scopes.EMAIL, null), jSONObject.optString("displayName", null), jSONObject.optString("givenName", null), jSONObject.optString("familyName", null), parse, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet).zzfp(jSONObject.optString("serverAuthCode", null));
    }

    public boolean equals(Object obj) {
        return !(obj instanceof GoogleSignInAccount) ? false : ((GoogleSignInAccount) obj).zzafn().equals(zzafn());
    }

    public String getDisplayName() {
        return this.f10452f;
    }

    public String getEmail() {
        return this.f10451e;
    }

    public String getFamilyName() {
        return this.f10458l;
    }

    public String getGivenName() {
        return this.f10457k;
    }

    public Set<Scope> getGrantedScopes() {
        return new HashSet(this.f10448b);
    }

    public String getId() {
        return this.f10449c;
    }

    public String getIdToken() {
        return this.f10450d;
    }

    public Uri getPhotoUrl() {
        return this.f10453g;
    }

    public String getServerAuthCode() {
        return this.f10454h;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.m16772a(this, parcel, i);
    }

    public boolean zza() {
        return dA.currentTimeMillis() / 1000 >= this.f10455i - 300;
    }

    public long zzafl() {
        return this.f10455i;
    }

    public String zzafm() {
        return this.f10456j;
    }

    public String zzafn() {
        return m16754a().toString();
    }

    public String zzafo() {
        JSONObject a = m16754a();
        a.remove("serverAuthCode");
        return a.toString();
    }

    public GoogleSignInAccount zzfp(String str) {
        this.f10454h = str;
        return this;
    }
}
