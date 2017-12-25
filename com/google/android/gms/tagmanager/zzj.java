package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.internal.zzaf;
import com.google.android.gms.internal.zzag;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class zzj extends zzdj {
    static final String f12768a;
    private static final String f12769b = zzaf.ARBITRARY_PIXEL.toString();
    private static final String f12770c = zzag.URL.toString();
    private static final String f12771d = zzag.ADDITIONAL_PARAMS.toString();
    private static final String f12772e = zzag.UNREPEATABLE.toString();
    private static final Set<String> f12773f = new HashSet();
    private final zza f12774g;
    private final Context f12775h;

    public interface zza {
        zzas zzcah();
    }

    class C34461 implements zza {
        final /* synthetic */ Context f12767a;

        C34461(Context context) {
            this.f12767a = context;
        }

        public zzas zzcah() {
            return zzz.zzdv(this.f12767a);
        }
    }

    static {
        String str = f12769b;
        f12768a = new StringBuilder(String.valueOf(str).length() + 17).append("gtm_").append(str).append("_unrepeatable").toString();
    }

    public zzj(Context context) {
        this(context, new C34461(context));
    }

    zzj(Context context, zza com_google_android_gms_tagmanager_zzj_zza) {
        super(f12769b, f12770c);
        this.f12774g = com_google_android_gms_tagmanager_zzj_zza;
        this.f12775h = context;
    }

    private synchronized boolean m18222c(String str) {
        boolean z = true;
        synchronized (this) {
            if (!m18224b(str)) {
                if (m18223a(str)) {
                    f12773f.add(str);
                } else {
                    z = false;
                }
            }
        }
        return z;
    }

    boolean m18223a(String str) {
        return this.f12775h.getSharedPreferences(f12768a, 0).contains(str);
    }

    boolean m18224b(String str) {
        return f12773f.contains(str);
    }

    public void zzax(Map<String, com.google.android.gms.internal.zzai.zza> map) {
        String zzg = map.get(f12772e) != null ? zzdl.zzg((com.google.android.gms.internal.zzai.zza) map.get(f12772e)) : null;
        if (zzg == null || !m18222c(zzg)) {
            String valueOf;
            Builder buildUpon = Uri.parse(zzdl.zzg((com.google.android.gms.internal.zzai.zza) map.get(f12770c))).buildUpon();
            com.google.android.gms.internal.zzai.zza com_google_android_gms_internal_zzai_zza = (com.google.android.gms.internal.zzai.zza) map.get(f12771d);
            if (com_google_android_gms_internal_zzai_zza != null) {
                Object zzl = zzdl.zzl(com_google_android_gms_internal_zzai_zza);
                if (zzl instanceof List) {
                    for (Object zzl2 : (List) zzl2) {
                        if (zzl2 instanceof Map) {
                            for (Entry entry : ((Map) zzl2).entrySet()) {
                                buildUpon.appendQueryParameter(entry.getKey().toString(), entry.getValue().toString());
                            }
                        } else {
                            zzg = "ArbitraryPixel: additional params contains non-map: not sending partial hit: ";
                            valueOf = String.valueOf(buildUpon.build().toString());
                            zzbn.m18105e(valueOf.length() != 0 ? zzg.concat(valueOf) : new String(zzg));
                            return;
                        }
                    }
                }
                zzg = "ArbitraryPixel: additional params not a list: not sending partial hit: ";
                valueOf = String.valueOf(buildUpon.build().toString());
                zzbn.m18105e(valueOf.length() != 0 ? zzg.concat(valueOf) : new String(zzg));
                return;
            }
            valueOf = buildUpon.build().toString();
            this.f12774g.zzcah().zzor(valueOf);
            String str = "ArbitraryPixel: url = ";
            valueOf = String.valueOf(valueOf);
            zzbn.m18106v(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            if (zzg != null) {
                synchronized (zzj.class) {
                    f12773f.add(zzg);
                    zzdc.m18186a(this.f12775h, f12768a, zzg, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                }
            }
        }
    }
}
