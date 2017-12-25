package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class RecordConsentRequest extends AbstractSafeParcelable {
    public static final Creator<RecordConsentRequest> CREATOR = new zzf();
    final int f12456a;
    private final Account f12457b;
    private final Scope[] f12458c;
    private final String f12459d;

    RecordConsentRequest(int i, Account account, Scope[] scopeArr, String str) {
        this.f12456a = i;
        this.f12457b = account;
        this.f12458c = scopeArr;
        this.f12459d = str;
    }

    public Account getAccount() {
        return this.f12457b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzf.m18024a(this, parcel, i);
    }

    public String zzafu() {
        return this.f12459d;
    }

    public Scope[] zzbzw() {
        return this.f12458c;
    }
}
