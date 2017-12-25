package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;

public final class Status extends AbstractSafeParcelable implements Result, ReflectedParcelable {
    public static final Creator<Status> CREATOR = new zzf();
    public static final Status sq = new Status(0);
    public static final Status sr = new Status(14);
    public static final Status ss = new Status(8);
    public static final Status st = new Status(15);
    public static final Status su = new Status(16);
    public static final Status sv = new Status(17);
    public static final Status sw = new Status(18);
    private final int f10556a;
    private final int f10557b;
    private final String f10558c;
    private final PendingIntent f10559d;

    public Status(int i) {
        this(i, null);
    }

    Status(int i, int i2, String str, PendingIntent pendingIntent) {
        this.f10556a = i;
        this.f10557b = i2;
        this.f10558c = str;
        this.f10559d = pendingIntent;
    }

    public Status(int i, String str) {
        this(1, i, str, null);
    }

    public Status(int i, String str, PendingIntent pendingIntent) {
        this(1, i, str, pendingIntent);
    }

    private String m16805c() {
        return this.f10558c != null ? this.f10558c : CommonStatusCodes.getStatusCodeString(this.f10557b);
    }

    PendingIntent m16806a() {
        return this.f10559d;
    }

    int m16807b() {
        return this.f10556a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f10556a == status.f10556a && this.f10557b == status.f10557b && zzaa.equal(this.f10558c, status.f10558c) && zzaa.equal(this.f10559d, status.f10559d);
    }

    public PendingIntent getResolution() {
        return this.f10559d;
    }

    public Status getStatus() {
        return this;
    }

    public int getStatusCode() {
        return this.f10557b;
    }

    public String getStatusMessage() {
        return this.f10558c;
    }

    public boolean hasResolution() {
        return this.f10559d != null;
    }

    public int hashCode() {
        return zzaa.hashCode(Integer.valueOf(this.f10556a), Integer.valueOf(this.f10557b), this.f10558c, this.f10559d);
    }

    public boolean isCanceled() {
        return this.f10557b == 16;
    }

    public boolean isInterrupted() {
        return this.f10557b == 14;
    }

    public boolean isSuccess() {
        return this.f10557b <= 0;
    }

    public void startResolutionForResult(Activity activity, int i) {
        if (hasResolution()) {
            activity.startIntentSenderForResult(this.f10559d.getIntentSender(), i, null, 0, 0, 0);
        }
    }

    public String toString() {
        return zzaa.zzx(this).zzg("statusCode", m16805c()).zzg("resolution", this.f10559d).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzf.m16811a(this, parcel, i);
    }
}
