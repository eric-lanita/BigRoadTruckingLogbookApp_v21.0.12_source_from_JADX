package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;

public class zzc {
    private final zzf f10197a;

    protected zzc(zzf com_google_android_gms_analytics_internal_zzf) {
        zzab.zzy(com_google_android_gms_analytics_internal_zzf);
        this.f10197a = com_google_android_gms_analytics_internal_zzf;
    }

    private static String mo1611a(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (!(obj instanceof Boolean)) {
            return obj instanceof Throwable ? ((Throwable) obj).toString() : obj.toString();
        } else {
            return obj == Boolean.TRUE ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false";
        }
    }

    protected static String m16535a(String str, Object obj, Object obj2, Object obj3) {
        if (str == null) {
            Object obj4 = "";
        }
        Object a = mo1611a(obj);
        Object a2 = mo1611a(obj2);
        Object a3 = mo1611a(obj3);
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "";
        if (!TextUtils.isEmpty(obj4)) {
            stringBuilder.append(obj4);
            str2 = ": ";
        }
        if (!TextUtils.isEmpty(a)) {
            stringBuilder.append(str2);
            stringBuilder.append(a);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(a2)) {
            stringBuilder.append(str2);
            stringBuilder.append(a2);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(a3)) {
            stringBuilder.append(str2);
            stringBuilder.append(a3);
            str2 = ", ";
        }
        return stringBuilder.toString();
    }

    private void m16536a(int i, String str, Object obj, Object obj2, Object obj3) {
        zzaf com_google_android_gms_analytics_internal_zzaf = null;
        if (this.f10197a != null) {
            com_google_android_gms_analytics_internal_zzaf = this.f10197a.zzzj();
        }
        if (com_google_android_gms_analytics_internal_zzaf != null) {
            com_google_android_gms_analytics_internal_zzaf.zza(i, str, obj, obj2, obj3);
            return;
        }
        String str2 = (String) zzy.zzczn.get();
        if (Log.isLoggable(str2, i)) {
            Log.println(i, str2, m16535a(str, obj, obj2, obj3));
        }
    }

    protected void m16537d() {
        if (m16542i().zzabc()) {
            throw new IllegalStateException("Call only supported on the client side");
        }
    }

    protected void m16538e() {
        this.f10197a.zzwu();
    }

    protected zze m16539f() {
        return this.f10197a.zzyw();
    }

    protected Context m16540g() {
        return this.f10197a.getContext();
    }

    protected zzaf m16541h() {
        return this.f10197a.zzyx();
    }

    protected zzr m16542i() {
        return this.f10197a.zzyy();
    }

    protected zzi m16543j() {
        return this.f10197a.zzyz();
    }

    protected zzb m16544k() {
        return this.f10197a.zzwd();
    }

    protected zzv m16545l() {
        return this.f10197a.zzza();
    }

    protected zzap m16546m() {
        return this.f10197a.zzwe();
    }

    protected zzai m16547n() {
        return this.f10197a.zzzb();
    }

    protected zzn m16548o() {
        return this.f10197a.zzzn();
    }

    protected zza m16549p() {
        return this.f10197a.zzzm();
    }

    protected zzk m16550q() {
        return this.f10197a.zzze();
    }

    protected zzu m16551r() {
        return this.f10197a.zzzf();
    }

    public void zza(String str, Object obj) {
        m16536a(2, str, obj, null, null);
    }

    public void zza(String str, Object obj, Object obj2) {
        m16536a(2, str, obj, obj2, null);
    }

    public void zza(String str, Object obj, Object obj2, Object obj3) {
        m16536a(3, str, obj, obj2, obj3);
    }

    public void zzb(String str, Object obj) {
        m16536a(3, str, obj, null, null);
    }

    public void zzb(String str, Object obj, Object obj2) {
        m16536a(3, str, obj, obj2, null);
    }

    public void zzb(String str, Object obj, Object obj2, Object obj3) {
        m16536a(5, str, obj, obj2, obj3);
    }

    public void zzc(String str, Object obj) {
        m16536a(4, str, obj, null, null);
    }

    public void zzc(String str, Object obj, Object obj2) {
        m16536a(5, str, obj, obj2, null);
    }

    public void zzd(String str, Object obj) {
        m16536a(5, str, obj, null, null);
    }

    public void zzd(String str, Object obj, Object obj2) {
        m16536a(6, str, obj, obj2, null);
    }

    public void zze(String str, Object obj) {
        m16536a(6, str, obj, null, null);
    }

    public void zzeh(String str) {
        m16536a(2, str, null, null, null);
    }

    public void zzei(String str) {
        m16536a(3, str, null, null, null);
    }

    public void zzej(String str) {
        m16536a(4, str, null, null, null);
    }

    public void zzek(String str) {
        m16536a(5, str, null, null, null);
    }

    public void zzel(String str) {
        m16536a(6, str, null, null, null);
    }

    public boolean zztb() {
        return Log.isLoggable((String) zzy.zzczn.get(), 2);
    }

    public GoogleAnalytics zzvx() {
        return this.f10197a.zzzk();
    }

    public zzf zzyu() {
        return this.f10197a;
    }
}
