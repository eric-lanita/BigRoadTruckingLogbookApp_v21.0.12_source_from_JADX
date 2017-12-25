package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.facebook.applinks.AppLinkData;
import com.google.android.gms.common.internal.zzab;

public abstract class Task implements Parcelable {
    public static final int EXTRAS_LIMIT_BYTES = 10240;
    public static final int NETWORK_STATE_ANY = 2;
    public static final int NETWORK_STATE_CONNECTED = 0;
    public static final int NETWORK_STATE_UNMETERED = 1;
    private final String f11006a;
    private final String f11007b;
    private final boolean f11008c;
    private final boolean f11009d;
    private final int f11010e;
    private final boolean f11011f;
    private final zzc f11012g;
    private final Bundle f11013h;

    public static abstract class Builder {
        protected int f10996a;
        protected String f10997b;
        protected String f10998c;
        protected boolean f10999d;
        protected boolean f11000e;
        protected boolean f11001f;
        protected zzc f11002g = zzc.ZC;
        protected Bundle f11003h;

        protected void mo1797a() {
            zzab.zzb(this.f10997b != null, (Object) "Must provide an endpoint for this task by calling setService(ComponentName).");
            GcmNetworkManager.m17050a(this.f10998c);
            Task.zza(this.f11002g);
            if (this.f11000e) {
                Task.zzaj(this.f11003h);
            }
        }

        public abstract Task build();

        public abstract Builder setExtras(Bundle bundle);

        public abstract Builder setPersisted(boolean z);

        public abstract Builder setRequiredNetwork(int i);

        public abstract Builder setRequiresCharging(boolean z);

        public abstract Builder setService(Class<? extends GcmTaskService> cls);

        public abstract Builder setTag(String str);

        public abstract Builder setUpdateCurrent(boolean z);
    }

    @Deprecated
    Task(Parcel parcel) {
        boolean z = true;
        Log.e("Task", "Constructing a Task object using a parcel.");
        this.f11006a = parcel.readString();
        this.f11007b = parcel.readString();
        this.f11008c = parcel.readInt() == 1;
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.f11009d = z;
        this.f11010e = 2;
        this.f11011f = false;
        this.f11012g = zzc.ZC;
        this.f11013h = null;
    }

    Task(Builder builder) {
        this.f11006a = builder.f10997b;
        this.f11007b = builder.f10998c;
        this.f11008c = builder.f10999d;
        this.f11009d = builder.f11000e;
        this.f11010e = builder.f10996a;
        this.f11011f = builder.f11001f;
        this.f11013h = builder.f11003h;
        this.f11012g = builder.f11002g != null ? builder.f11002g : zzc.ZC;
    }

    private static boolean m17074a(Object obj) {
        return (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Double) || (obj instanceof String) || (obj instanceof Boolean);
    }

    public static void zza(zzc com_google_android_gms_gcm_zzc) {
        if (com_google_android_gms_gcm_zzc != null) {
            int zzblj = com_google_android_gms_gcm_zzc.zzblj();
            if (zzblj == 1 || zzblj == 0) {
                int zzblk = com_google_android_gms_gcm_zzc.zzblk();
                int zzbll = com_google_android_gms_gcm_zzc.zzbll();
                if (zzblj == 0 && zzblk < 0) {
                    throw new IllegalArgumentException("InitialBackoffSeconds can't be negative: " + zzblk);
                } else if (zzblj == 1 && zzblk < 10) {
                    throw new IllegalArgumentException("RETRY_POLICY_LINEAR must have an initial backoff at least 10 seconds.");
                } else if (zzbll < zzblk) {
                    throw new IllegalArgumentException("MaximumBackoffSeconds must be greater than InitialBackoffSeconds: " + com_google_android_gms_gcm_zzc.zzbll());
                } else {
                    return;
                }
            }
            throw new IllegalArgumentException("Must provide a valid RetryPolicy: " + zzblj);
        }
    }

    public static void zzaj(Bundle bundle) {
        if (bundle != null) {
            Parcel obtain = Parcel.obtain();
            bundle.writeToParcel(obtain, 0);
            int dataSize = obtain.dataSize();
            if (dataSize > EXTRAS_LIMIT_BYTES) {
                obtain.recycle();
                String valueOf = String.valueOf("Extras exceeding maximum size(10240 bytes): ");
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 11).append(valueOf).append(dataSize).toString());
            }
            obtain.recycle();
            for (String str : bundle.keySet()) {
                if (!m17074a(bundle.get(str))) {
                    throw new IllegalArgumentException("Only the following extra parameter types are supported: Integer, Long, Double, String, and Boolean. ");
                }
            }
        }
    }

    public int describeContents() {
        return 0;
    }

    public Bundle getExtras() {
        return this.f11013h;
    }

    public int getRequiredNetwork() {
        return this.f11010e;
    }

    public boolean getRequiresCharging() {
        return this.f11011f;
    }

    public String getServiceName() {
        return this.f11006a;
    }

    public String getTag() {
        return this.f11007b;
    }

    public boolean isPersisted() {
        return this.f11009d;
    }

    public boolean isUpdateCurrent() {
        return this.f11008c;
    }

    public void toBundle(Bundle bundle) {
        bundle.putString("tag", this.f11007b);
        bundle.putBoolean("update_current", this.f11008c);
        bundle.putBoolean("persisted", this.f11009d);
        bundle.putString("service", this.f11006a);
        bundle.putInt("requiredNetwork", this.f11010e);
        bundle.putBoolean("requiresCharging", this.f11011f);
        bundle.putBundle("retryStrategy", this.f11012g.zzai(new Bundle()));
        bundle.putBundle(AppLinkData.ARGUMENTS_EXTRAS_KEY, this.f11013h);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeString(this.f11006a);
        parcel.writeString(this.f11007b);
        parcel.writeInt(this.f11008c ? 1 : 0);
        if (!this.f11009d) {
            i2 = 0;
        }
        parcel.writeInt(i2);
    }
}
