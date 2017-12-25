package com.google.android.gms.internal;

import android.text.TextUtils;
import android.util.Log;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.analytics.zzg;
import com.google.android.gms.common.internal.zzab;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class zzme extends zzg<zzme> {
    private String f11447a;
    private int f11448b;
    private int f11449c;
    private String f11450d;
    private String f11451e;
    private boolean f11452f;
    private boolean f11453g;

    public zzme() {
        this(false);
    }

    public zzme(boolean z) {
        this(z, m17357a());
    }

    public zzme(boolean z, int i) {
        zzab.zzgh(i);
        this.f11448b = i;
        this.f11453g = z;
    }

    static int m17357a() {
        UUID randomUUID = UUID.randomUUID();
        int leastSignificantBits = (int) (randomUUID.getLeastSignificantBits() & 2147483647L);
        if (leastSignificantBits != 0) {
            return leastSignificantBits;
        }
        leastSignificantBits = (int) (randomUUID.getMostSignificantBits() & 2147483647L);
        if (leastSignificantBits != 0) {
            return leastSignificantBits;
        }
        Log.e("GAv4", "UUID.randomUUID() returned 0.");
        return Integer.MAX_VALUE;
    }

    private void m17358b() {
    }

    public void setScreenName(String str) {
        m17358b();
        this.f11447a = str;
    }

    public String toString() {
        Map hashMap = new HashMap();
        hashMap.put("screenName", this.f11447a);
        hashMap.put("interstitial", Boolean.valueOf(this.f11452f));
        hashMap.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_AUTOMATIC, Boolean.valueOf(this.f11453g));
        hashMap.put("screenId", Integer.valueOf(this.f11448b));
        hashMap.put("referrerScreenId", Integer.valueOf(this.f11449c));
        hashMap.put("referrerScreenName", this.f11450d);
        hashMap.put("referrerUri", this.f11451e);
        return zzg.zzj(hashMap);
    }

    public void zza(zzme com_google_android_gms_internal_zzme) {
        if (!TextUtils.isEmpty(this.f11447a)) {
            com_google_android_gms_internal_zzme.setScreenName(this.f11447a);
        }
        if (this.f11448b != 0) {
            com_google_android_gms_internal_zzme.zzbu(this.f11448b);
        }
        if (this.f11449c != 0) {
            com_google_android_gms_internal_zzme.zzbv(this.f11449c);
        }
        if (!TextUtils.isEmpty(this.f11450d)) {
            com_google_android_gms_internal_zzme.zzdz(this.f11450d);
        }
        if (!TextUtils.isEmpty(this.f11451e)) {
            com_google_android_gms_internal_zzme.zzea(this.f11451e);
        }
        if (this.f11452f) {
            com_google_android_gms_internal_zzme.zzar(this.f11452f);
        }
        if (this.f11453g) {
            com_google_android_gms_internal_zzme.zzaq(this.f11453g);
        }
    }

    public void zzaq(boolean z) {
        m17358b();
        this.f11453g = z;
    }

    public void zzar(boolean z) {
        m17358b();
        this.f11452f = z;
    }

    public /* synthetic */ void zzb(zzg com_google_android_gms_analytics_zzg) {
        zza((zzme) com_google_android_gms_analytics_zzg);
    }

    public void zzbu(int i) {
        m17358b();
        this.f11448b = i;
    }

    public void zzbv(int i) {
        m17358b();
        this.f11449c = i;
    }

    public void zzdz(String str) {
        m17358b();
        this.f11450d = str;
    }

    public void zzea(String str) {
        m17358b();
        if (TextUtils.isEmpty(str)) {
            this.f11451e = null;
        } else {
            this.f11451e = str;
        }
    }

    public String zzye() {
        return this.f11447a;
    }

    public int zzyf() {
        return this.f11448b;
    }

    public String zzyg() {
        return this.f11451e;
    }
}
