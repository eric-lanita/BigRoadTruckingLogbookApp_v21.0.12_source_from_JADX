package com.google.firebase.messaging;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.p008d.C0270a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Map;

public final class RemoteMessage extends AbstractSafeParcelable {
    public static final Creator<RemoteMessage> CREATOR = new C3628c();
    final int f13153a;
    Bundle f13154b;
    private Map<String, String> f13155c;

    RemoteMessage(int i, Bundle bundle) {
        this.f13153a = i;
        this.f13154b = bundle;
    }

    RemoteMessage(Bundle bundle) {
        this(1, bundle);
    }

    public Map<String, String> m18952a() {
        if (this.f13155c == null) {
            this.f13155c = new C0270a();
            for (String str : this.f13154b.keySet()) {
                Object obj = this.f13154b.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (!(str.startsWith("google.") || str.startsWith("gcm.") || str.equals("from") || str.equals("message_type") || str.equals("collapse_key"))) {
                        this.f13155c.put(str, str2);
                    }
                }
            }
        }
        return this.f13155c;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C3628c.m18980a(this, parcel, i);
    }
}
