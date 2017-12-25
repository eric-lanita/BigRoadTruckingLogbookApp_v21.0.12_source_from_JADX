package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.zze;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class GoogleSignInOptions extends AbstractSafeParcelable implements Optional, ReflectedParcelable {
    public static final Creator<GoogleSignInOptions> CREATOR = new zzb();
    public static final GoogleSignInOptions DEFAULT_SIGN_IN = new Builder().requestId().requestProfile().build();
    public static final Scope dK = new Scope(Scopes.PROFILE);
    public static final Scope dL = new Scope(Scopes.EMAIL);
    public static final Scope dM = new Scope("openid");
    private static Comparator<Scope> f10466i = new C32091();
    final int f10467a;
    private final ArrayList<Scope> f10468b;
    private Account f10469c;
    private boolean f10470d;
    private final boolean f10471e;
    private final boolean f10472f;
    private String f10473g;
    private String f10474h;

    class C32091 implements Comparator<Scope> {
        C32091() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return zza((Scope) obj, (Scope) obj2);
        }

        public int zza(Scope scope, Scope scope2) {
            return scope.zzaok().compareTo(scope2.zzaok());
        }
    }

    public static final class Builder {
        private Set<Scope> f10459a = new HashSet();
        private boolean f10460b;
        private boolean f10461c;
        private boolean f10462d;
        private String f10463e;
        private Account f10464f;
        private String f10465g;

        public Builder(GoogleSignInOptions googleSignInOptions) {
            zzab.zzy(googleSignInOptions);
            this.f10459a = new HashSet(googleSignInOptions.f10468b);
            this.f10460b = googleSignInOptions.f10471e;
            this.f10461c = googleSignInOptions.f10472f;
            this.f10462d = googleSignInOptions.f10470d;
            this.f10463e = googleSignInOptions.f10473g;
            this.f10464f = googleSignInOptions.f10469c;
            this.f10465g = googleSignInOptions.f10474h;
        }

        private String m16755a(String str) {
            zzab.zzhr(str);
            boolean z = this.f10463e == null || this.f10463e.equals(str);
            zzab.zzb(z, (Object) "two different server client ids provided");
            return str;
        }

        public GoogleSignInOptions build() {
            if (this.f10462d && (this.f10464f == null || !this.f10459a.isEmpty())) {
                requestId();
            }
            return new GoogleSignInOptions(this.f10459a, this.f10464f, this.f10462d, this.f10460b, this.f10461c, this.f10463e, this.f10465g);
        }

        public Builder requestEmail() {
            this.f10459a.add(GoogleSignInOptions.dL);
            return this;
        }

        public Builder requestId() {
            this.f10459a.add(GoogleSignInOptions.dM);
            return this;
        }

        public Builder requestIdToken(String str) {
            this.f10462d = true;
            this.f10463e = m16755a(str);
            return this;
        }

        public Builder requestProfile() {
            this.f10459a.add(GoogleSignInOptions.dK);
            return this;
        }

        public Builder requestScopes(Scope scope, Scope... scopeArr) {
            this.f10459a.add(scope);
            this.f10459a.addAll(Arrays.asList(scopeArr));
            return this;
        }

        public Builder requestServerAuthCode(String str) {
            return requestServerAuthCode(str, false);
        }

        public Builder requestServerAuthCode(String str, boolean z) {
            this.f10460b = true;
            this.f10463e = m16755a(str);
            this.f10461c = z;
            return this;
        }

        public Builder setAccountName(String str) {
            this.f10464f = new Account(zzab.zzhr(str), "com.google");
            return this;
        }

        public Builder setHostedDomain(String str) {
            this.f10465g = zzab.zzhr(str);
            return this;
        }
    }

    GoogleSignInOptions(int i, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2) {
        this.f10467a = i;
        this.f10468b = arrayList;
        this.f10469c = account;
        this.f10470d = z;
        this.f10471e = z2;
        this.f10472f = z3;
        this.f10473g = str;
        this.f10474h = str2;
    }

    private GoogleSignInOptions(Set<Scope> set, Account account, boolean z, boolean z2, boolean z3, String str, String str2) {
        this(2, new ArrayList(set), account, z, z2, z3, str, str2);
    }

    private JSONObject m16757a() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.f10468b, f10466i);
            Iterator it = this.f10468b.iterator();
            while (it.hasNext()) {
                jSONArray.put(((Scope) it.next()).zzaok());
            }
            jSONObject.put("scopes", jSONArray);
            if (this.f10469c != null) {
                jSONObject.put("accountName", this.f10469c.name);
            }
            jSONObject.put("idTokenRequested", this.f10470d);
            jSONObject.put("forceCodeForRefreshToken", this.f10472f);
            jSONObject.put("serverAuthRequested", this.f10471e);
            if (!TextUtils.isEmpty(this.f10473g)) {
                jSONObject.put("serverClientId", this.f10473g);
            }
            if (!TextUtils.isEmpty(this.f10474h)) {
                jSONObject.put("hostedDomain", this.f10474h);
            }
            return jSONObject;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static GoogleSignInOptions zzfq(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        Set hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        Object optString = jSONObject.optString("accountName", null);
        return new GoogleSignInOptions(hashSet, !TextUtils.isEmpty(optString) ? new Account(optString, "com.google") : null, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.optString("serverClientId", null), jSONObject.optString("hostedDomain", null));
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
            if (this.f10468b.size() != googleSignInOptions.zzafq().size() || !this.f10468b.containsAll(googleSignInOptions.zzafq())) {
                return false;
            }
            if (this.f10469c == null) {
                if (googleSignInOptions.getAccount() != null) {
                    return false;
                }
            } else if (!this.f10469c.equals(googleSignInOptions.getAccount())) {
                return false;
            }
            if (TextUtils.isEmpty(this.f10473g)) {
                if (!TextUtils.isEmpty(googleSignInOptions.zzafu())) {
                    return false;
                }
            } else if (!this.f10473g.equals(googleSignInOptions.zzafu())) {
                return false;
            }
            return this.f10472f == googleSignInOptions.zzaft() && this.f10470d == googleSignInOptions.zzafr() && this.f10471e == googleSignInOptions.zzafs();
        } catch (ClassCastException e) {
            return false;
        }
    }

    public Account getAccount() {
        return this.f10469c;
    }

    public Scope[] getScopeArray() {
        return (Scope[]) this.f10468b.toArray(new Scope[this.f10468b.size()]);
    }

    public int hashCode() {
        List arrayList = new ArrayList();
        Iterator it = this.f10468b.iterator();
        while (it.hasNext()) {
            arrayList.add(((Scope) it.next()).zzaok());
        }
        Collections.sort(arrayList);
        return new zze().zzq(arrayList).zzq(this.f10469c).zzq(this.f10473g).zzba(this.f10472f).zzba(this.f10470d).zzba(this.f10471e).zzagc();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.m16773a(this, parcel, i);
    }

    public String zzafn() {
        return m16757a().toString();
    }

    public ArrayList<Scope> zzafq() {
        return new ArrayList(this.f10468b);
    }

    public boolean zzafr() {
        return this.f10470d;
    }

    public boolean zzafs() {
        return this.f10471e;
    }

    public boolean zzaft() {
        return this.f10472f;
    }

    public String zzafu() {
        return this.f10473g;
    }

    public String zzafv() {
        return this.f10474h;
    }
}
