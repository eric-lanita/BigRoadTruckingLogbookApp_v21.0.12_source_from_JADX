package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.internal.zzadw;
import com.google.android.gms.internal.zzadz;
import com.google.android.gms.internal.zzaea;
import com.google.android.gms.internal.zzah.zzj;
import com.google.android.gms.tagmanager.zzbm.zza;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;

class zzcs implements Runnable {
    private final Context f12629a;
    private final zzaea f12630b;
    private final String f12631c;
    private final String f12632d;
    private zzbm<zzj> f12633e;
    private volatile zzs f12634f;
    private volatile String f12635g;
    private volatile String f12636h;

    zzcs(Context context, String str, zzaea com_google_android_gms_internal_zzaea, zzs com_google_android_gms_tagmanager_zzs) {
        this.f12629a = context;
        this.f12630b = com_google_android_gms_internal_zzaea;
        this.f12631c = str;
        this.f12634f = com_google_android_gms_tagmanager_zzs;
        String valueOf = String.valueOf("/r?id=");
        String valueOf2 = String.valueOf(str);
        this.f12632d = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        this.f12635g = this.f12632d;
        this.f12636h = null;
    }

    public zzcs(Context context, String str, zzs com_google_android_gms_tagmanager_zzs) {
        this(context, str, new zzaea(), com_google_android_gms_tagmanager_zzs);
    }

    private boolean m18137b() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f12629a.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        zzbn.m18106v("...no network connectivity");
        return false;
    }

    private void m18138c() {
        String valueOf;
        if (m18137b()) {
            zzbn.m18106v("Start loading resource from network ...");
            String a = m18139a();
            zzadz zzchl = this.f12630b.zzchl();
            String valueOf2;
            try {
                InputStream zzqj = zzchl.zzqj(a);
                try {
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    zzadw.zzc(zzqj, byteArrayOutputStream);
                    zzj zzf = zzj.zzf(byteArrayOutputStream.toByteArray());
                    valueOf2 = String.valueOf(zzf);
                    zzbn.m18106v(new StringBuilder(String.valueOf(valueOf2).length() + 43).append("Successfully loaded supplemented resource: ").append(valueOf2).toString());
                    if (zzf.zzwr == null && zzf.zzwq.length == 0) {
                        String str = "No change for container: ";
                        valueOf2 = String.valueOf(this.f12631c);
                        zzbn.m18106v(valueOf2.length() != 0 ? str.concat(valueOf2) : new String(str));
                    }
                    this.f12633e.onSuccess(zzf);
                    zzbn.m18106v("Load resource from network finished.");
                } catch (Throwable e) {
                    valueOf = String.valueOf(e.getMessage());
                    zzbn.zzd(new StringBuilder((String.valueOf(a).length() + 51) + String.valueOf(valueOf).length()).append("Error when parsing downloaded resources from url: ").append(a).append(" ").append(valueOf).toString(), e);
                    this.f12633e.zza(zza.SERVER_ERROR);
                    zzchl.close();
                }
            } catch (FileNotFoundException e2) {
                valueOf2 = this.f12631c;
                zzbn.zzcx(new StringBuilder((String.valueOf(a).length() + 79) + String.valueOf(valueOf2).length()).append("No data is retrieved from the given url: ").append(a).append(". Make sure container_id: ").append(valueOf2).append(" is correct.").toString());
                this.f12633e.zza(zza.SERVER_ERROR);
            } catch (Throwable e3) {
                valueOf = String.valueOf(e3.getMessage());
                zzbn.zzd(new StringBuilder((String.valueOf(a).length() + 40) + String.valueOf(valueOf).length()).append("Error when loading resources from url: ").append(a).append(" ").append(valueOf).toString(), e3);
                this.f12633e.zza(zza.IO_ERROR);
            } finally {
                zzchl.close();
            }
        } else {
            this.f12633e.zza(zza.NOT_AVAILABLE);
        }
    }

    String m18139a() {
        String valueOf = String.valueOf(this.f12634f.zzcaw());
        String str = this.f12635g;
        String valueOf2 = String.valueOf("&v=a65833898");
        valueOf = new StringBuilder(((String.valueOf(valueOf).length() + 0) + String.valueOf(str).length()) + String.valueOf(valueOf2).length()).append(valueOf).append(str).append(valueOf2).toString();
        if (!(this.f12636h == null || this.f12636h.trim().equals(""))) {
            valueOf = String.valueOf(valueOf);
            str = String.valueOf("&pv=");
            valueOf2 = this.f12636h;
            valueOf = new StringBuilder(((String.valueOf(valueOf).length() + 0) + String.valueOf(str).length()) + String.valueOf(valueOf2).length()).append(valueOf).append(str).append(valueOf2).toString();
        }
        if (!zzci.m18128a().m18132b().equals(zza.CONTAINER_DEBUG)) {
            return valueOf;
        }
        str = String.valueOf(valueOf);
        valueOf = String.valueOf("&gtm_debug=x");
        return valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
    }

    void m18140a(zzbm<zzj> com_google_android_gms_tagmanager_zzbm_com_google_android_gms_internal_zzah_zzj) {
        this.f12633e = com_google_android_gms_tagmanager_zzbm_com_google_android_gms_internal_zzah_zzj;
    }

    void m18141a(String str) {
        if (str == null) {
            this.f12635g = this.f12632d;
            return;
        }
        String str2 = "Setting CTFE URL path: ";
        String valueOf = String.valueOf(str);
        zzbn.zzcv(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        this.f12635g = str;
    }

    void m18142b(String str) {
        String str2 = "Setting previous container version: ";
        String valueOf = String.valueOf(str);
        zzbn.zzcv(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        this.f12636h = str;
    }

    public void run() {
        if (this.f12633e == null) {
            throw new IllegalStateException("callback must be set before execute");
        }
        this.f12633e.zzcau();
        m18138c();
    }
}
