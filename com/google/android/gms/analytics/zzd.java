package com.google.android.gms.analytics;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.LogPrinter;
import com.facebook.share.internal.ShareConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class zzd implements zzk {
    private static final Uri f10421a;
    private final LogPrinter f10422b = new LogPrinter(4, "GA/LogCatTransport");

    class C32051 implements Comparator<zzg> {
        final /* synthetic */ zzd f10420a;

        C32051(zzd com_google_android_gms_analytics_zzd) {
            this.f10420a = com_google_android_gms_analytics_zzd;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return zza((zzg) obj, (zzg) obj2);
        }

        public int zza(zzg com_google_android_gms_analytics_zzg, zzg com_google_android_gms_analytics_zzg2) {
            return com_google_android_gms_analytics_zzg.getClass().getCanonicalName().compareTo(com_google_android_gms_analytics_zzg2.getClass().getCanonicalName());
        }
    }

    static {
        Builder builder = new Builder();
        builder.scheme(ShareConstants.MEDIA_URI);
        builder.authority("local");
        f10421a = builder.build();
    }

    public void zzb(zze com_google_android_gms_analytics_zze) {
        List<zzg> arrayList = new ArrayList(com_google_android_gms_analytics_zze.zzwg());
        Collections.sort(arrayList, new C32051(this));
        StringBuilder stringBuilder = new StringBuilder();
        for (zzg obj : arrayList) {
            Object obj2 = obj.toString();
            if (!TextUtils.isEmpty(obj2)) {
                if (stringBuilder.length() != 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(obj2);
            }
        }
        this.f10422b.println(stringBuilder.toString());
    }

    public Uri zzvu() {
        return f10421a;
    }
}
