package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzq.zza;
import com.google.android.gms.common.zzc;
import java.util.Collection;

public class GetServiceRequest extends AbstractSafeParcelable {
    public static final Creator<GetServiceRequest> CREATOR = new zzj();
    final int f10662a;
    final int f10663b;
    int f10664c;
    String f10665d;
    IBinder f10666e;
    Scope[] f10667f;
    Bundle f10668g;
    Account f10669h;
    long f10670i;

    public GetServiceRequest(int i) {
        this.f10662a = 3;
        this.f10664c = zzc.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        this.f10663b = i;
    }

    GetServiceRequest(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, long j) {
        this.f10662a = i;
        this.f10663b = i2;
        this.f10664c = i3;
        this.f10665d = str;
        if (i < 2) {
            this.f10669h = m16866a(iBinder);
        } else {
            this.f10666e = iBinder;
            this.f10669h = account;
        }
        this.f10667f = scopeArr;
        this.f10668g = bundle;
        this.f10670i = j;
    }

    private Account m16866a(IBinder iBinder) {
        return iBinder != null ? zza.zza(zza.zzdp(iBinder)) : null;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzj.m16933a(this, parcel, i);
    }

    public GetServiceRequest zzb(zzq com_google_android_gms_common_internal_zzq) {
        if (com_google_android_gms_common_internal_zzq != null) {
            this.f10666e = com_google_android_gms_common_internal_zzq.asBinder();
        }
        return this;
    }

    public GetServiceRequest zzd(Account account) {
        this.f10669h = account;
        return this;
    }

    public GetServiceRequest zzf(Collection<Scope> collection) {
        this.f10667f = (Scope[]) collection.toArray(new Scope[collection.size()]);
        return this;
    }

    public GetServiceRequest zzhl(String str) {
        this.f10665d = str;
        return this;
    }

    public GetServiceRequest zzn(Bundle bundle) {
        this.f10668g = bundle;
        return this;
    }
}
