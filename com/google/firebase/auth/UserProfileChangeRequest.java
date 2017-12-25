package com.google.firebase.auth;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class UserProfileChangeRequest extends AbstractSafeParcelable {
    public static final Creator<UserProfileChangeRequest> CREATOR = new C3614c();
    public final int f13100a;
    private String f13101b;
    private String f13102c;
    private boolean f13103d;
    private boolean f13104e;
    private Uri f13105f;

    UserProfileChangeRequest(int i, String str, String str2, boolean z, boolean z2) {
        this.f13100a = i;
        this.f13101b = str;
        this.f13102c = str2;
        this.f13103d = z;
        this.f13104e = z2;
        this.f13105f = TextUtils.isEmpty(str2) ? null : Uri.parse(str2);
    }

    public String m18868a() {
        return this.f13101b;
    }

    public String m18869b() {
        return this.f13102c;
    }

    public boolean m18870c() {
        return this.f13103d;
    }

    public boolean m18871d() {
        return this.f13104e;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C3614c.m18872a(this, parcel, i);
    }
}
