package com.urbanairship.actions;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.urbanairship.json.C3684c;
import com.urbanairship.json.C3785a;
import com.urbanairship.json.C3788b;
import com.urbanairship.json.JsonValue;

public class ActionValue implements Parcelable, C3684c {
    public static final Creator<ActionValue> CREATOR = new C36831();
    private final JsonValue f13311a;

    static class C36831 implements Creator<ActionValue> {
        C36831() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m19309a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m19310a(i);
        }

        public ActionValue m19309a(Parcel parcel) {
            return new ActionValue((JsonValue) parcel.readParcelable(JsonValue.class.getClassLoader()));
        }

        public ActionValue[] m19310a(int i) {
            return new ActionValue[i];
        }
    }

    public ActionValue(JsonValue jsonValue) {
        if (jsonValue == null) {
            jsonValue = JsonValue.f13565a;
        }
        this.f13311a = jsonValue;
    }

    public static ActionValue m19312a(String str) {
        return new ActionValue(JsonValue.m19743c(str));
    }

    public static ActionValue m19313a(boolean z) {
        return new ActionValue(JsonValue.m19741b(z));
    }

    public ActionValue() {
        this.f13311a = JsonValue.f13565a;
    }

    public String m19314a() {
        return m19316b(null);
    }

    public String m19316b(String str) {
        return this.f13311a.m19748a(str);
    }

    public boolean m19317b(boolean z) {
        return this.f13311a.m19750a(z);
    }

    public C3785a m19315b() {
        return this.f13311a.m19752c();
    }

    public C3788b m19318c() {
        return this.f13311a.m19755f();
    }

    public boolean m19319d() {
        return this.f13311a.m19757h();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ActionValue)) {
            return false;
        }
        return this.f13311a.equals(((ActionValue) obj).f13311a);
    }

    public int hashCode() {
        return this.f13311a.hashCode();
    }

    public String toString() {
        return this.f13311a.toString();
    }

    public JsonValue mo2767e() {
        return this.f13311a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f13311a, i);
    }
}
