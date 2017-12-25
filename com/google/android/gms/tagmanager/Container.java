package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzadw;
import com.google.android.gms.internal.zzadw.zzc;
import com.google.android.gms.internal.zzadw.zzg;
import com.google.android.gms.internal.zzah.zzf;
import com.google.android.gms.internal.zzah.zzi;
import com.google.android.gms.internal.zzah.zzj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Container {
    private final Context f12473a;
    private final String f12474b;
    private final DataLayer f12475c;
    private zzcw f12476d;
    private Map<String, FunctionCallMacroCallback> f12477e = new HashMap();
    private Map<String, FunctionCallTagCallback> f12478f = new HashMap();
    private volatile long f12479g;
    private volatile String f12480h = "";

    public interface FunctionCallMacroCallback {
        Object getValue(String str, Map<String, Object> map);
    }

    public interface FunctionCallTagCallback {
        void execute(String str, Map<String, Object> map);
    }

    private class zza implements com.google.android.gms.tagmanager.zzt.zza {
        final /* synthetic */ Container f12471a;

        private zza(Container container) {
            this.f12471a = container;
        }

        public Object zze(String str, Map<String, Object> map) {
            FunctionCallMacroCallback a = this.f12471a.m18036a(str);
            return a == null ? null : a.getValue(str, map);
        }
    }

    private class zzb implements com.google.android.gms.tagmanager.zzt.zza {
        final /* synthetic */ Container f12472a;

        private zzb(Container container) {
            this.f12472a = container;
        }

        public Object zze(String str, Map<String, Object> map) {
            FunctionCallTagCallback zzof = this.f12472a.zzof(str);
            if (zzof != null) {
                zzof.execute(str, map);
            }
            return zzdl.zzcdt();
        }
    }

    Container(Context context, DataLayer dataLayer, String str, long j, zzc com_google_android_gms_internal_zzadw_zzc) {
        this.f12473a = context;
        this.f12475c = dataLayer;
        this.f12474b = str;
        this.f12479g = j;
        m18031a(com_google_android_gms_internal_zzadw_zzc);
    }

    Container(Context context, DataLayer dataLayer, String str, long j, zzj com_google_android_gms_internal_zzah_zzj) {
        this.f12473a = context;
        this.f12475c = dataLayer;
        this.f12474b = str;
        this.f12479g = j;
        m18032a(com_google_android_gms_internal_zzah_zzj.zzwr);
        if (com_google_android_gms_internal_zzah_zzj.zzwq != null) {
            m18034a(com_google_android_gms_internal_zzah_zzj.zzwq);
        }
    }

    private void m18031a(zzc com_google_android_gms_internal_zzadw_zzc) {
        this.f12480h = com_google_android_gms_internal_zzadw_zzc.getVersion();
        zzc com_google_android_gms_internal_zzadw_zzc2 = com_google_android_gms_internal_zzadw_zzc;
        m18033a(new zzcw(this.f12473a, com_google_android_gms_internal_zzadw_zzc2, this.f12475c, new zza(), new zzb(), m18038b(this.f12480h)));
        if (getBoolean("_gtm.loadEventEnabled")) {
            this.f12475c.pushEvent("gtm.load", DataLayer.mapOf("gtm.id", this.f12474b));
        }
    }

    private void m18032a(zzf com_google_android_gms_internal_zzah_zzf) {
        if (com_google_android_gms_internal_zzah_zzf == null) {
            throw new NullPointerException();
        }
        try {
            m18031a(zzadw.zzb(com_google_android_gms_internal_zzah_zzf));
        } catch (zzg e) {
            String valueOf = String.valueOf(com_google_android_gms_internal_zzah_zzf);
            String valueOf2 = String.valueOf(e.toString());
            zzbn.m18105e(new StringBuilder((String.valueOf(valueOf).length() + 46) + String.valueOf(valueOf2).length()).append("Not loading resource: ").append(valueOf).append(" because it is invalid: ").append(valueOf2).toString());
        }
    }

    private synchronized void m18033a(zzcw com_google_android_gms_tagmanager_zzcw) {
        this.f12476d = com_google_android_gms_tagmanager_zzcw;
    }

    private void m18034a(zzi[] com_google_android_gms_internal_zzah_zziArr) {
        List arrayList = new ArrayList();
        for (Object add : com_google_android_gms_internal_zzah_zziArr) {
            arrayList.add(add);
        }
        m18035b().zzaj(arrayList);
    }

    private synchronized zzcw m18035b() {
        return this.f12476d;
    }

    FunctionCallMacroCallback m18036a(String str) {
        FunctionCallMacroCallback functionCallMacroCallback;
        synchronized (this.f12477e) {
            functionCallMacroCallback = (FunctionCallMacroCallback) this.f12477e.get(str);
        }
        return functionCallMacroCallback;
    }

    void m18037a() {
        this.f12476d = null;
    }

    zzai m18038b(String str) {
        if (zzci.m18128a().m18132b().equals(zza.CONTAINER_DEBUG)) {
        }
        return new zzbv();
    }

    public boolean getBoolean(String str) {
        zzcw b = m18035b();
        if (b == null) {
            zzbn.m18105e("getBoolean called for closed container.");
            return zzdl.zzcdr().booleanValue();
        }
        try {
            return zzdl.zzk((com.google.android.gms.internal.zzai.zza) b.zzpc(str).getObject()).booleanValue();
        } catch (Exception e) {
            String valueOf = String.valueOf(e.getMessage());
            zzbn.m18105e(new StringBuilder(String.valueOf(valueOf).length() + 66).append("Calling getBoolean() threw an exception: ").append(valueOf).append(" Returning default value.").toString());
            return zzdl.zzcdr().booleanValue();
        }
    }

    public String getContainerId() {
        return this.f12474b;
    }

    public double getDouble(String str) {
        zzcw b = m18035b();
        if (b == null) {
            zzbn.m18105e("getDouble called for closed container.");
            return zzdl.zzcdq().doubleValue();
        }
        try {
            return zzdl.zzj((com.google.android.gms.internal.zzai.zza) b.zzpc(str).getObject()).doubleValue();
        } catch (Exception e) {
            String valueOf = String.valueOf(e.getMessage());
            zzbn.m18105e(new StringBuilder(String.valueOf(valueOf).length() + 65).append("Calling getDouble() threw an exception: ").append(valueOf).append(" Returning default value.").toString());
            return zzdl.zzcdq().doubleValue();
        }
    }

    public long getLastRefreshTime() {
        return this.f12479g;
    }

    public long getLong(String str) {
        zzcw b = m18035b();
        if (b == null) {
            zzbn.m18105e("getLong called for closed container.");
            return zzdl.zzcdp().longValue();
        }
        try {
            return zzdl.zzi((com.google.android.gms.internal.zzai.zza) b.zzpc(str).getObject()).longValue();
        } catch (Exception e) {
            String valueOf = String.valueOf(e.getMessage());
            zzbn.m18105e(new StringBuilder(String.valueOf(valueOf).length() + 63).append("Calling getLong() threw an exception: ").append(valueOf).append(" Returning default value.").toString());
            return zzdl.zzcdp().longValue();
        }
    }

    public String getString(String str) {
        zzcw b = m18035b();
        if (b == null) {
            zzbn.m18105e("getString called for closed container.");
            return zzdl.zzcdt();
        }
        try {
            return zzdl.zzg((com.google.android.gms.internal.zzai.zza) b.zzpc(str).getObject());
        } catch (Exception e) {
            String valueOf = String.valueOf(e.getMessage());
            zzbn.m18105e(new StringBuilder(String.valueOf(valueOf).length() + 65).append("Calling getString() threw an exception: ").append(valueOf).append(" Returning default value.").toString());
            return zzdl.zzcdt();
        }
    }

    public boolean isDefault() {
        return getLastRefreshTime() == 0;
    }

    public void registerFunctionCallMacroCallback(String str, FunctionCallMacroCallback functionCallMacroCallback) {
        if (functionCallMacroCallback == null) {
            throw new NullPointerException("Macro handler must be non-null");
        }
        synchronized (this.f12477e) {
            this.f12477e.put(str, functionCallMacroCallback);
        }
    }

    public void registerFunctionCallTagCallback(String str, FunctionCallTagCallback functionCallTagCallback) {
        if (functionCallTagCallback == null) {
            throw new NullPointerException("Tag callback must be non-null");
        }
        synchronized (this.f12478f) {
            this.f12478f.put(str, functionCallTagCallback);
        }
    }

    public void unregisterFunctionCallMacroCallback(String str) {
        synchronized (this.f12477e) {
            this.f12477e.remove(str);
        }
    }

    public void unregisterFunctionCallTagCallback(String str) {
        synchronized (this.f12478f) {
            this.f12478f.remove(str);
        }
    }

    public String zzcal() {
        return this.f12480h;
    }

    public FunctionCallTagCallback zzof(String str) {
        FunctionCallTagCallback functionCallTagCallback;
        synchronized (this.f12478f) {
            functionCallTagCallback = (FunctionCallTagCallback) this.f12478f.get(str);
        }
        return functionCallTagCallback;
    }

    public void zzog(String str) {
        m18035b().zzog(str);
    }
}
