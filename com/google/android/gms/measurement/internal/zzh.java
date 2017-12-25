package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzab;
import java.util.Iterator;

public class zzh {
    final String f12261a;
    final String f12262b;
    final String f12263c;
    final long f12264d;
    final long f12265e;
    final EventParams f12266f;

    zzh(zzx com_google_android_gms_measurement_internal_zzx, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        zzab.zzhr(str2);
        zzab.zzhr(str3);
        this.f12261a = str2;
        this.f12262b = str3;
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.f12263c = str;
        this.f12264d = j;
        this.f12265e = j2;
        if (this.f12265e != 0 && this.f12265e > this.f12264d) {
            com_google_android_gms_measurement_internal_zzx.zzbsd().zzbsx().log("Event created with reverse previous/current timestamps");
        }
        this.f12266f = m17871a(com_google_android_gms_measurement_internal_zzx, bundle);
    }

    private zzh(zzx com_google_android_gms_measurement_internal_zzx, String str, String str2, String str3, long j, long j2, EventParams eventParams) {
        zzab.zzhr(str2);
        zzab.zzhr(str3);
        zzab.zzy(eventParams);
        this.f12261a = str2;
        this.f12262b = str3;
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.f12263c = str;
        this.f12264d = j;
        this.f12265e = j2;
        if (this.f12265e != 0 && this.f12265e > this.f12264d) {
            com_google_android_gms_measurement_internal_zzx.zzbsd().zzbsx().log("Event created with reverse previous/current timestamps");
        }
        this.f12266f = eventParams;
    }

    EventParams m17871a(zzx com_google_android_gms_measurement_internal_zzx, Bundle bundle) {
        if (bundle == null || bundle.isEmpty()) {
            return new EventParams(new Bundle());
        }
        Bundle bundle2 = new Bundle(bundle);
        Iterator it = bundle2.keySet().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str == null) {
                com_google_android_gms_measurement_internal_zzx.zzbsd().zzbsv().log("Param name can't be null");
                it.remove();
            } else {
                Object zzl = com_google_android_gms_measurement_internal_zzx.zzbrz().zzl(str, bundle2.get(str));
                if (zzl == null) {
                    com_google_android_gms_measurement_internal_zzx.zzbsd().zzbsx().zzj("Param value can't be null", str);
                    it.remove();
                } else {
                    com_google_android_gms_measurement_internal_zzx.zzbrz().zza(bundle2, str, zzl);
                }
            }
        }
        return new EventParams(bundle2);
    }

    zzh m17872a(zzx com_google_android_gms_measurement_internal_zzx, long j) {
        return new zzh(com_google_android_gms_measurement_internal_zzx, this.f12263c, this.f12261a, this.f12262b, this.f12264d, j, this.f12266f);
    }

    public String toString() {
        String str = this.f12261a;
        String str2 = this.f12262b;
        String valueOf = String.valueOf(this.f12266f);
        return new StringBuilder(((String.valueOf(str).length() + 33) + String.valueOf(str2).length()) + String.valueOf(valueOf).length()).append("Event{appId='").append(str).append("'").append(", name='").append(str2).append("'").append(", params=").append(valueOf).append("}").toString();
    }
}
