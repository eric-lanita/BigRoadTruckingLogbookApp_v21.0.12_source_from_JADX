package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.measurement.internal.zzm.zza;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class zzy extends zza {
    private final zzx f12435a;
    private final boolean f12436b;

    public zzy(zzx com_google_android_gms_measurement_internal_zzx) {
        zzab.zzy(com_google_android_gms_measurement_internal_zzx);
        this.f12435a = com_google_android_gms_measurement_internal_zzx;
        this.f12436b = false;
    }

    public zzy(zzx com_google_android_gms_measurement_internal_zzx, boolean z) {
        zzab.zzy(com_google_android_gms_measurement_internal_zzx);
        this.f12435a = com_google_android_gms_measurement_internal_zzx;
        this.f12436b = z;
    }

    private void m18006a(AppMetadata appMetadata) {
        zzab.zzy(appMetadata);
        m18007c(appMetadata.packageName);
        this.f12435a.zzbrz().zzmq(appMetadata.aic);
    }

    private void m18007c(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f12435a.zzbsd().zzbsv().log("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        try {
            m18009b(str);
        } catch (SecurityException e) {
            this.f12435a.zzbsd().zzbsv().zzj("Measurement Service called with invalid calling package", str);
            throw e;
        }
    }

    void m18008a(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(":", 2);
            if (split.length == 2) {
                try {
                    long longValue = Long.valueOf(split[0]).longValue();
                    if (longValue > 0) {
                        this.f12435a.zzbse().ajX.zzh(split[1], longValue);
                    } else {
                        this.f12435a.zzbsd().zzbsx().zzj("Combining sample with a non-positive weight", Long.valueOf(longValue));
                    }
                } catch (NumberFormatException e) {
                    this.f12435a.zzbsd().zzbsx().zzj("Combining sample with a non-number weight", split[0]);
                }
            }
        }
    }

    protected void m18009b(String str) {
        int myUid = this.f12436b ? Process.myUid() : Binder.getCallingUid();
        if (!com.google.android.gms.common.util.zzy.zzb(this.f12435a.getContext(), myUid, str)) {
            if (!com.google.android.gms.common.util.zzy.zze(this.f12435a.getContext(), myUid) || this.f12435a.m17998h()) {
                throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[]{str}));
            }
        }
    }

    public List<UserAttributeParcel> zza(final AppMetadata appMetadata, boolean z) {
        Object e;
        m18006a(appMetadata);
        try {
            List<zzak> list = (List) this.f12435a.zzbsc().zzd(new Callable<List<zzak>>(this) {
                final /* synthetic */ zzy f12432b;

                public /* synthetic */ Object call() {
                    return zzbuk();
                }

                public List<zzak> zzbuk() {
                    this.f12432b.f12435a.m18003m();
                    return this.f12432b.f12435a.zzbry().zzlm(appMetadata.packageName);
                }
            }).get();
            List<UserAttributeParcel> arrayList = new ArrayList(list.size());
            for (zzak com_google_android_gms_measurement_internal_zzak : list) {
                if (z || !zzal.zzmt(com_google_android_gms_measurement_internal_zzak.f12244b)) {
                    arrayList.add(new UserAttributeParcel(com_google_android_gms_measurement_internal_zzak));
                }
            }
            return arrayList;
        } catch (InterruptedException e2) {
            e = e2;
            this.f12435a.zzbsd().zzbsv().zzj("Failed to get user attributes", e);
            return null;
        } catch (ExecutionException e3) {
            e = e3;
            this.f12435a.zzbsd().zzbsv().zzj("Failed to get user attributes", e);
            return null;
        }
    }

    public void zza(final AppMetadata appMetadata) {
        m18006a(appMetadata);
        this.f12435a.zzbsc().zzm(new Runnable(this) {
            final /* synthetic */ zzy f12434b;

            public void run() {
                this.f12434b.f12435a.m18003m();
                this.f12434b.m18008a(appMetadata.aig);
                this.f12434b.f12435a.zzd(appMetadata);
            }
        });
    }

    public void zza(final EventParcel eventParcel, final AppMetadata appMetadata) {
        zzab.zzy(eventParcel);
        m18006a(appMetadata);
        this.f12435a.zzbsc().zzm(new Runnable(this) {
            final /* synthetic */ zzy f12417c;

            public void run() {
                this.f12417c.f12435a.m18003m();
                this.f12417c.m18008a(appMetadata.aig);
                this.f12417c.f12435a.m17979a(eventParcel, appMetadata);
            }
        });
    }

    public void zza(final EventParcel eventParcel, final String str, final String str2) {
        zzab.zzy(eventParcel);
        zzab.zzhr(str);
        m18007c(str);
        this.f12435a.zzbsc().zzm(new Runnable(this) {
            final /* synthetic */ zzy f12421d;

            public void run() {
                this.f12421d.f12435a.m18003m();
                this.f12421d.m18008a(str2);
                this.f12421d.f12435a.m17980a(eventParcel, str);
            }
        });
    }

    public void zza(final UserAttributeParcel userAttributeParcel, final AppMetadata appMetadata) {
        zzab.zzy(userAttributeParcel);
        m18006a(appMetadata);
        if (userAttributeParcel.getValue() == null) {
            this.f12435a.zzbsc().zzm(new Runnable(this) {
                final /* synthetic */ zzy f12427c;

                public void run() {
                    this.f12427c.f12435a.m18003m();
                    this.f12427c.m18008a(appMetadata.aig);
                    this.f12427c.f12435a.m17989b(userAttributeParcel, appMetadata);
                }
            });
        } else {
            this.f12435a.zzbsc().zzm(new Runnable(this) {
                final /* synthetic */ zzy f12430c;

                public void run() {
                    this.f12430c.f12435a.m18003m();
                    this.f12430c.m18008a(appMetadata.aig);
                    this.f12430c.f12435a.m17981a(userAttributeParcel, appMetadata);
                }
            });
        }
    }

    public byte[] zza(final EventParcel eventParcel, final String str) {
        Object e;
        zzab.zzhr(str);
        zzab.zzy(eventParcel);
        m18007c(str);
        this.f12435a.zzbsd().zzbtb().zzj("Log and bundle. event", eventParcel.name);
        long nanoTime = this.f12435a.zzyw().nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) this.f12435a.zzbsc().zze(new Callable<byte[]>(this) {
                final /* synthetic */ zzy f12424c;

                public /* synthetic */ Object call() {
                    return zzbuj();
                }

                public byte[] zzbuj() {
                    this.f12424c.f12435a.m18003m();
                    return this.f12424c.f12435a.zza(eventParcel, str);
                }
            }).get();
            if (bArr == null) {
                this.f12435a.zzbsd().zzbsv().log("Log and bundle returned null");
                bArr = new byte[0];
            }
            this.f12435a.zzbsd().zzbtb().zzd("Log and bundle processed. event, size, time_ms", eventParcel.name, Integer.valueOf(bArr.length), Long.valueOf((this.f12435a.zzyw().nanoTime() / 1000000) - nanoTime));
            return bArr;
        } catch (InterruptedException e2) {
            e = e2;
            this.f12435a.zzbsd().zzbsv().zze("Failed to log and bundle. event, error", eventParcel.name, e);
            return null;
        } catch (ExecutionException e3) {
            e = e3;
            this.f12435a.zzbsd().zzbsv().zze("Failed to log and bundle. event, error", eventParcel.name, e);
            return null;
        }
    }

    public void zzb(final AppMetadata appMetadata) {
        m18006a(appMetadata);
        this.f12435a.zzbsc().zzm(new Runnable(this) {
            final /* synthetic */ zzy f12414b;

            public void run() {
                this.f12414b.f12435a.m18003m();
                this.f12414b.m18008a(appMetadata.aig);
                this.f12414b.f12435a.m17977a(appMetadata);
            }
        });
    }
}
