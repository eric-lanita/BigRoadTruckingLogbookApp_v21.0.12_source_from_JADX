package com.google.android.gms.analytics.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Command implements Parcelable {
    @Deprecated
    public static final Creator<Command> CREATOR = new C31821();
    private String f10215a;
    private String f10216b;
    private String f10217c;

    class C31821 implements Creator<Command> {
        C31821() {
        }

        @Deprecated
        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return zzt(parcel);
        }

        @Deprecated
        public /* synthetic */ Object[] newArray(int i) {
            return zzbw(i);
        }

        @Deprecated
        public Command[] zzbw(int i) {
            return new Command[i];
        }

        @Deprecated
        public Command zzt(Parcel parcel) {
            return new Command(parcel);
        }
    }

    @Deprecated
    Command(Parcel parcel) {
        m16580a(parcel);
    }

    @Deprecated
    private void m16580a(Parcel parcel) {
        this.f10215a = parcel.readString();
        this.f10216b = parcel.readString();
        this.f10217c = parcel.readString();
    }

    @Deprecated
    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.f10215a;
    }

    public String getValue() {
        return this.f10217c;
    }

    @Deprecated
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f10215a);
        parcel.writeString(this.f10216b);
        parcel.writeString(this.f10217c);
    }
}
