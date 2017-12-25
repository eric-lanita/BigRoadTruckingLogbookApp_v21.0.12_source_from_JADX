package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public class OneoffTask extends Task {
    public static final Creator<OneoffTask> CREATOR = new C32461();
    private final long f11014a;
    private final long f11015b;

    class C32461 implements Creator<OneoffTask> {
        C32461() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return zzmi(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return zzso(i);
        }

        public OneoffTask zzmi(Parcel parcel) {
            return new OneoffTask(parcel);
        }

        public OneoffTask[] zzso(int i) {
            return new OneoffTask[i];
        }
    }

    public static class Builder extends com.google.android.gms.gcm.Task.Builder {
        private long f11004i;
        private long f11005j;

        public Builder() {
            this.f11004i = -1;
            this.f11005j = -1;
            this.e = false;
        }

        protected void mo1797a() {
            super.mo1797a();
            if (this.f11004i == -1 || this.f11005j == -1) {
                throw new IllegalArgumentException("Must specify an execution window using setExecutionWindow.");
            } else if (this.f11004i >= this.f11005j) {
                throw new IllegalArgumentException("Window start must be shorter than window end.");
            }
        }

        public OneoffTask build() {
            mo1797a();
            return new OneoffTask();
        }

        public Builder setExecutionWindow(long j, long j2) {
            this.f11004i = j;
            this.f11005j = j2;
            return this;
        }

        public Builder setExtras(Bundle bundle) {
            this.h = bundle;
            return this;
        }

        public Builder setPersisted(boolean z) {
            this.e = z;
            return this;
        }

        public Builder setRequiredNetwork(int i) {
            this.a = i;
            return this;
        }

        public Builder setRequiresCharging(boolean z) {
            this.f = z;
            return this;
        }

        public Builder setService(Class<? extends GcmTaskService> cls) {
            this.b = cls.getName();
            return this;
        }

        public Builder setTag(String str) {
            this.c = str;
            return this;
        }

        public Builder setUpdateCurrent(boolean z) {
            this.d = z;
            return this;
        }
    }

    @Deprecated
    private OneoffTask(Parcel parcel) {
        super(parcel);
        this.f11014a = parcel.readLong();
        this.f11015b = parcel.readLong();
    }

    private OneoffTask(Builder builder) {
        super((com.google.android.gms.gcm.Task.Builder) builder);
        this.f11014a = builder.f11004i;
        this.f11015b = builder.f11005j;
    }

    public long getWindowEnd() {
        return this.f11015b;
    }

    public long getWindowStart() {
        return this.f11014a;
    }

    public void toBundle(Bundle bundle) {
        super.toBundle(bundle);
        bundle.putLong("window_start", this.f11014a);
        bundle.putLong("window_end", this.f11015b);
    }

    public String toString() {
        String valueOf = String.valueOf(super.toString());
        long windowStart = getWindowStart();
        return new StringBuilder(String.valueOf(valueOf).length() + 64).append(valueOf).append(" windowStart=").append(windowStart).append(" windowEnd=").append(getWindowEnd()).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.f11014a);
        parcel.writeLong(this.f11015b);
    }
}
