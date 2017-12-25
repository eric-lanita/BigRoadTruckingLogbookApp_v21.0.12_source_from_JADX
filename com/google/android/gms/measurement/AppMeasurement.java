package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Keep;
import com.facebook.AccessToken;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zzf;
import com.google.android.gms.measurement.internal.UserAttributeParcel;
import com.google.android.gms.measurement.internal.zzx;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Deprecated
public class AppMeasurement {
    private final zzx f12117a;

    public static final class zza {
        public static final Map<String, String> ahE = zzf.zzb(new String[]{"app_clear_data", "app_exception", "app_uninstall", "app_update", "firebase_campaign", "error", "first_open", "in_app_purchase", "notification_dismiss", "notification_foreground", "notification_open", "notification_receive", "os_update", "session_start", "user_engagement"}, new String[]{"_cd", "_ae", "_ui", "_au", "_cmp", "_err", "_f", "_iap", "_nd", "_nf", "_no", "_nr", "_ou", "_s", "_e"});
    }

    public interface zzb {
        void zzb(String str, String str2, Bundle bundle, long j);
    }

    public interface zzc {
        void zzc(String str, String str2, Bundle bundle, long j);
    }

    public static final class zzd {
        public static final Map<String, String> ahF = zzf.zzb(new String[]{"firebase_conversion", "engagement_time_msec", "firebase_error", "error_value", "firebase_event_origin", "message_device_time", "message_id", "message_name", "message_time", "previous_app_version", "previous_os_version", "topic"}, new String[]{"_c", "_et", "_err", "_ev", "_o", "_ndt", "_nmid", "_nmn", "_nmt", "_pv", "_po", "_nt"});
    }

    public static final class zze {
        public static final Map<String, String> ahG = zzf.zzb(new String[]{"firebase_last_notification", "first_open_time", "last_deep_link_referrer", AccessToken.USER_ID_KEY}, new String[]{"_ln", "_fot", "_ldl", "_id"});
    }

    public AppMeasurement(zzx com_google_android_gms_measurement_internal_zzx) {
        zzab.zzy(com_google_android_gms_measurement_internal_zzx);
        this.f12117a = com_google_android_gms_measurement_internal_zzx;
    }

    private void m17708a(String str, String str2, Object obj) {
        this.f12117a.zzbru().zzd(str, str2, obj);
    }

    @Keep
    @Deprecated
    public static AppMeasurement getInstance(Context context) {
        return zzx.zzdo(context).zzbtr();
    }

    @Deprecated
    public void logEvent(String str, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (this.f12117a.zzbsf().zzabc() || !"_iap".equals(str)) {
            int zzmk = this.f12117a.zzbrz().zzmk(str);
            if (zzmk != 0) {
                this.f12117a.zzbrz().zze(zzmk, "_ev", this.f12117a.zzbrz().zza(str, this.f12117a.zzbsf().zzbqn(), true));
                return;
            }
        }
        this.f12117a.zzbru().zza("app", str, bundle, true);
    }

    @Deprecated
    public void setMeasurementEnabled(boolean z) {
        this.f12117a.zzbru().setMeasurementEnabled(z);
    }

    @Deprecated
    public void setMinimumSessionDuration(long j) {
        this.f12117a.zzbru().setMinimumSessionDuration(j);
    }

    @Deprecated
    public void setSessionTimeoutDuration(long j) {
        this.f12117a.zzbru().setSessionTimeoutDuration(j);
    }

    @Deprecated
    public void setUserId(String str) {
        zzb("app", "_id", str);
    }

    @Deprecated
    public void setUserProperty(String str, String str2) {
        int zzmm = this.f12117a.zzbrz().zzmm(str);
        if (zzmm != 0) {
            this.f12117a.zzbrz().zze(zzmm, "_ev", this.f12117a.zzbrz().zza(str, this.f12117a.zzbsf().zzbqo(), true));
            return;
        }
        zzb("app", str, str2);
    }

    public void zza(zzb com_google_android_gms_measurement_AppMeasurement_zzb) {
        this.f12117a.zzbru().zza(com_google_android_gms_measurement_AppMeasurement_zzb);
    }

    public void zza(zzc com_google_android_gms_measurement_AppMeasurement_zzc) {
        this.f12117a.zzbru().zza(com_google_android_gms_measurement_AppMeasurement_zzc);
    }

    public void zza(String str, String str2, Bundle bundle, long j) {
        this.f12117a.zzbru().zzd(str, str2, bundle == null ? new Bundle() : bundle, j);
    }

    public void zzb(String str, String str2, Object obj) {
        m17708a(str, str2, obj);
    }

    public Map<String, Object> zzca(boolean z) {
        List<UserAttributeParcel> zzce = this.f12117a.zzbru().zzce(z);
        Map<String, Object> hashMap = new HashMap(zzce.size());
        for (UserAttributeParcel userAttributeParcel : zzce) {
            hashMap.put(userAttributeParcel.name, userAttributeParcel.getValue());
        }
        return hashMap;
    }

    public void zzd(String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.f12117a.zzbru().zze(str, str2, bundle);
    }
}
