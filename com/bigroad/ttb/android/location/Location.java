package com.bigroad.ttb.android.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.bigroad.shared.C1147v;
import com.bigroad.ttb.protocol.TTProtocol.Breadcrumb;
import com.bigroad.ttb.protocol.TTProtocol.LatLon;
import com.google.common.base.Objects;

public class Location implements Parcelable {
    public static final Creator<Location> CREATOR = new C21051();
    private final int f7351a;
    private final int f7352b;
    private final Float f7353c;

    static class C21051 implements Creator<Location> {
        C21051() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m10559a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m10560a(i);
        }

        public Location m10559a(Parcel parcel) {
            return new Location(parcel);
        }

        public Location[] m10560a(int i) {
            return new Location[i];
        }
    }

    public Location(int i, int i2, Float f) {
        this.f7351a = i;
        this.f7352b = i2;
        this.f7353c = f;
    }

    public Location(android.location.Location location) {
        this(C1147v.m5771a(location.getLatitude()), C1147v.m5771a(location.getLongitude()), location.hasAccuracy() ? Float.valueOf(location.getAccuracy()) : null);
    }

    public Location(Breadcrumb breadcrumb) {
        this(breadcrumb.getLatitudeE6(), breadcrumb.getLongitudeE6(), breadcrumb.hasAccuracy() ? Float.valueOf(breadcrumb.getAccuracy()) : null);
    }

    private Location(Parcel parcel) {
        ClassLoader classLoader = Location.class.getClassLoader();
        this.f7351a = parcel.readInt();
        this.f7352b = parcel.readInt();
        this.f7353c = (Float) parcel.readValue(classLoader);
    }

    public LatLon m10554a() {
        return LatLon.newBuilder().m14248a(this.f7351a).m14252b(this.f7352b).m14254c();
    }

    public int m10555b() {
        return this.f7351a;
    }

    public int m10556c() {
        return this.f7352b;
    }

    public boolean m10557d() {
        return this.f7353c != null;
    }

    public Float m10558e() {
        return this.f7353c;
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Location location = (Location) obj;
        if (Objects.equal(Integer.valueOf(this.f7351a), Integer.valueOf(location.f7351a)) && Objects.equal(Integer.valueOf(this.f7352b), Integer.valueOf(location.f7352b)) && Objects.equal(this.f7353c, location.f7353c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f7351a), Integer.valueOf(this.f7352b), this.f7353c);
    }

    public String toString() {
        return "Location [" + this.f7351a + "," + this.f7352b + "]";
    }

    public static Location m10552a(android.location.Location location) {
        if (location == null) {
            return null;
        }
        return new Location(location);
    }

    public static Location m10553a(Breadcrumb breadcrumb) {
        if (breadcrumb == null) {
            return null;
        }
        return new Location(breadcrumb);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f7351a);
        parcel.writeInt(this.f7352b);
        parcel.writeFloat(this.f7353c.floatValue());
    }
}
