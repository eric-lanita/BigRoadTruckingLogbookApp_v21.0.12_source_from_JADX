package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public class PeriodicTask extends Task {
    public static final Creator<PeriodicTask> CREATOR = new C32481();
    protected long f11019a;
    protected long f11020b;

    class C32481 implements Creator<PeriodicTask> {
        C32481() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return zzmk(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return zzsq(i);
        }

        public PeriodicTask zzmk(Parcel parcel) {
            return new PeriodicTask(parcel);
        }

        public PeriodicTask[] zzsq(int i) {
            return new PeriodicTask[i];
        }
    }

    public static class Builder extends com.google.android.gms.gcm.Task.Builder {
        private long f11017i;
        private long f11018j;

        public Builder() {
            this.f11017i = -1;
            this.f11018j = -1;
            this.e = true;
        }

        protected void mo1797a() {
            super.mo1797a();
            if (this.f11017i == -1) {
                throw new IllegalArgumentException("Must call setPeriod(long) to establish an execution interval for this periodic task.");
            } else if (this.f11017i <= 0) {
                throw new IllegalArgumentException("Period set cannot be less than or equal to 0: " + this.f11017i);
            } else if (this.f11018j == -1) {
                this.f11018j = (long) (((float) this.f11017i) * 0.1f);
            } else if (this.f11018j > this.f11017i) {
                this.f11018j = this.f11017i;
            }
        }

        public PeriodicTask build() {
            mo1797a();
            return new PeriodicTask();
        }

        public Builder setExtras(Bundle bundle) {
            this.h = bundle;
            return this;
        }

        public Builder setFlex(long j) {
            this.f11018j = j;
            return this;
        }

        public Builder setPeriod(long j) {
            this.f11017i = j;
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
    private PeriodicTask(Parcel parcel) {
        super(parcel);
        this.f11019a = -1;
        this.f11020b = -1;
        this.f11019a = parcel.readLong();
        this.f11020b = Math.min(parcel.readLong(), this.f11019a);
    }

    private PeriodicTask(Builder builder) {
        super((com.google.android.gms.gcm.Task.Builder) builder);
        this.f11019a = -1;
        this.f11020b = -1;
        this.f11019a = builder.f11017i;
        this.f11020b = Math.min(builder.f11018j, this.f11019a);
    }

    public long getFlex() {
        return this.f11020b;
    }

    public long getPeriod() {
        return this.f11019a;
    }

    public void toBundle(Bundle bundle) {
        super.toBundle(bundle);
        bundle.putLong("period", this.f11019a);
        bundle.putLong("period_flex", this.f11020b);
    }

    public String toString() {
        String valueOf = String.valueOf(super.toString());
        long period = getPeriod();
        return new StringBuilder(String.valueOf(valueOf).length() + 54).append(valueOf).append(" period=").append(period).append(" flex=").append(getFlex()).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.f11019a);
        parcel.writeLong(this.f11020b);
    }
}
