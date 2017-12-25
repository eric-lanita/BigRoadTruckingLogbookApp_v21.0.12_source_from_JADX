package com.urbanairship.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.urbanairship.C3783j;
import com.urbanairship.json.C3684c;
import com.urbanairship.json.C3788b;
import com.urbanairship.json.JsonValue;
import java.util.HashMap;

public class LocationRequestOptions implements Parcelable, C3684c {
    public static final Creator<LocationRequestOptions> CREATOR = new C37971();
    private final int f13592a;
    private final long f13593b;
    private final float f13594c;

    static class C37971 implements Creator<LocationRequestOptions> {
        C37971() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m19822a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m19823a(i);
        }

        public LocationRequestOptions m19822a(Parcel parcel) {
            return new LocationRequestOptions(parcel);
        }

        public LocationRequestOptions[] m19823a(int i) {
            return new LocationRequestOptions[i];
        }
    }

    public static class C3798a {
        private long f13589a = 300000;
        private float f13590b = 800.0f;
        private int f13591c = 2;

        public LocationRequestOptions m19827a() {
            return new LocationRequestOptions();
        }
    }

    private LocationRequestOptions(C3798a c3798a) {
        this(c3798a.f13591c, c3798a.f13589a, c3798a.f13590b);
    }

    private LocationRequestOptions(Parcel parcel) {
        this(parcel.readInt(), parcel.readLong(), parcel.readFloat());
    }

    private LocationRequestOptions(int i, long j, float f) {
        this.f13592a = i;
        this.f13593b = j;
        this.f13594c = f;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f13592a);
        parcel.writeLong(this.f13593b);
        parcel.writeFloat(this.f13594c);
    }

    public int m19832a() {
        return this.f13592a;
    }

    public long m19833b() {
        return this.f13593b;
    }

    public float m19834c() {
        return this.f13594c;
    }

    public String toString() {
        return "LocationRequestOptions: Priority " + this.f13592a + " minTime " + this.f13593b + " minDistance " + this.f13594c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LocationRequestOptions)) {
            return false;
        }
        LocationRequestOptions locationRequestOptions = (LocationRequestOptions) obj;
        if (locationRequestOptions.f13592a == this.f13592a && locationRequestOptions.f13593b == this.f13593b && locationRequestOptions.f13594c == this.f13594c) {
            return true;
        }
        return false;
    }

    private static void m19831a(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("minTime must be greater or equal to 0");
        }
    }

    private static void m19829a(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("minDistance must be greater or equal to 0");
        }
    }

    private static void m19830a(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
                return;
            default:
                throw new IllegalArgumentException("Priority can only be either PRIORITY_HIGH_ACCURACY, PRIORITY_BALANCED_POWER_ACCURACY, PRIORITY_LOW_POWER, or PRIORITY_NO_POWER");
        }
    }

    public JsonValue mo2767e() {
        Object hashMap = new HashMap();
        hashMap.put("priority", Integer.valueOf(m19832a()));
        hashMap.put("minDistance", Float.valueOf(m19834c()));
        hashMap.put("minTime", Long.valueOf(m19833b()));
        try {
            return JsonValue.m19739b(hashMap);
        } catch (Throwable e) {
            C3783j.m19726c("LocationRequestOptions - Unable to serialize to JSON.", e);
            return JsonValue.f13565a;
        }
    }

    public static LocationRequestOptions m19828a(String str) {
        C3788b f = JsonValue.m19740b(str).m19755f();
        if (f == null) {
            return null;
        }
        Number b = f.m19782c("minDistance").m19751b();
        float floatValue = b == null ? 800.0f : b.floatValue();
        long a = f.m19782c("minTime").m19746a(300000);
        int a2 = f.m19782c("priority").m19745a(2);
        m19830a(a2);
        m19829a(floatValue);
        m19831a(a);
        return new LocationRequestOptions(a2, a, floatValue);
    }
}
