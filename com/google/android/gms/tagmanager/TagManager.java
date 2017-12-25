package com.google.android.gms.tagmanager;

import android.annotation.TargetApi;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.PendingResult;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TagManager {
    private static TagManager f12494g;
    private final zza f12495a;
    private final Context f12496b;
    private final DataLayer f12497c;
    private final zzda f12498d;
    private final ConcurrentMap<zzo, Boolean> f12499e;
    private final zzs f12500f;

    class C34241 implements zzb {
        final /* synthetic */ TagManager f12491a;

        C34241(TagManager tagManager) {
            this.f12491a = tagManager;
        }

        public void zzaw(Map<String, Object> map) {
            Object obj = map.get(DataLayer.EVENT_KEY);
            if (obj != null) {
                this.f12491a.m18062a(obj.toString());
            }
        }
    }

    public interface zza {
        zzp zza(Context context, TagManager tagManager, Looper looper, String str, int i, zzs com_google_android_gms_tagmanager_zzs);
    }

    class C34252 implements zza {
        C34252() {
        }

        public zzp zza(Context context, TagManager tagManager, Looper looper, String str, int i, zzs com_google_android_gms_tagmanager_zzs) {
            return new zzp(context, tagManager, looper, str, i, com_google_android_gms_tagmanager_zzs);
        }
    }

    class C34263 implements ComponentCallbacks2 {
        final /* synthetic */ TagManager f12492a;

        C34263(TagManager tagManager) {
            this.f12492a = tagManager;
        }

        public void onConfigurationChanged(Configuration configuration) {
        }

        public void onLowMemory() {
        }

        public void onTrimMemory(int i) {
            if (i == 20) {
                this.f12492a.dispatch();
            }
        }
    }

    TagManager(Context context, zza com_google_android_gms_tagmanager_TagManager_zza, DataLayer dataLayer, zzda com_google_android_gms_tagmanager_zzda) {
        if (context == null) {
            throw new NullPointerException("context cannot be null");
        }
        this.f12496b = context.getApplicationContext();
        this.f12498d = com_google_android_gms_tagmanager_zzda;
        this.f12495a = com_google_android_gms_tagmanager_TagManager_zza;
        this.f12499e = new ConcurrentHashMap();
        this.f12497c = dataLayer;
        this.f12497c.m18053a(new C34241(this));
        this.f12497c.m18053a(new zzd(this.f12496b));
        this.f12500f = new zzs();
        m18060a();
    }

    @TargetApi(14)
    private void m18060a() {
        if (VERSION.SDK_INT >= 14) {
            this.f12496b.registerComponentCallbacks(new C34263(this));
        }
    }

    private void m18062a(String str) {
        for (zzo zzog : this.f12499e.keySet()) {
            zzog.zzog(str);
        }
    }

    public static TagManager getInstance(Context context) {
        TagManager tagManager;
        synchronized (TagManager.class) {
            if (f12494g == null) {
                if (context == null) {
                    zzbn.m18105e("TagManager.getInstance requires non-null context.");
                    throw new NullPointerException();
                }
                f12494g = new TagManager(context, new C34252(), new DataLayer(new zzw(context)), zzdb.zzcdc());
            }
            tagManager = f12494g;
        }
        return tagManager;
    }

    synchronized boolean m18063a(Uri uri) {
        boolean z;
        zzci a = zzci.m18128a();
        if (a.m18131a(uri)) {
            String d = a.m18134d();
            switch (a.m18132b()) {
                case NONE:
                    for (zzo com_google_android_gms_tagmanager_zzo : this.f12499e.keySet()) {
                        if (com_google_android_gms_tagmanager_zzo.m18228a().equals(d)) {
                            com_google_android_gms_tagmanager_zzo.m18229a(null);
                            com_google_android_gms_tagmanager_zzo.refresh();
                        }
                    }
                    break;
                case CONTAINER:
                case CONTAINER_DEBUG:
                    for (zzo com_google_android_gms_tagmanager_zzo2 : this.f12499e.keySet()) {
                        if (com_google_android_gms_tagmanager_zzo2.m18228a().equals(d)) {
                            com_google_android_gms_tagmanager_zzo2.m18229a(a.m18133c());
                            com_google_android_gms_tagmanager_zzo2.refresh();
                        } else if (com_google_android_gms_tagmanager_zzo2.m18230b() != null) {
                            com_google_android_gms_tagmanager_zzo2.m18229a(null);
                            com_google_android_gms_tagmanager_zzo2.refresh();
                        }
                    }
                    break;
            }
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public void dispatch() {
        this.f12498d.dispatch();
    }

    public DataLayer getDataLayer() {
        return this.f12497c;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String str, int i) {
        PendingResult zza = this.f12495a.zza(this.f12496b, this, null, str, i, this.f12500f);
        zza.zzcaq();
        return zza;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String str, int i, Handler handler) {
        PendingResult zza = this.f12495a.zza(this.f12496b, this, handler.getLooper(), str, i, this.f12500f);
        zza.zzcaq();
        return zza;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String str, int i) {
        PendingResult zza = this.f12495a.zza(this.f12496b, this, null, str, i, this.f12500f);
        zza.zzcas();
        return zza;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String str, int i, Handler handler) {
        PendingResult zza = this.f12495a.zza(this.f12496b, this, handler.getLooper(), str, i, this.f12500f);
        zza.zzcas();
        return zza;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String str, int i) {
        PendingResult zza = this.f12495a.zza(this.f12496b, this, null, str, i, this.f12500f);
        zza.zzcar();
        return zza;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String str, int i, Handler handler) {
        PendingResult zza = this.f12495a.zza(this.f12496b, this, handler.getLooper(), str, i, this.f12500f);
        zza.zzcar();
        return zza;
    }

    public void setVerboseLoggingEnabled(boolean z) {
        zzbn.setLogLevel(z ? 2 : 5);
    }

    public void zza(zzo com_google_android_gms_tagmanager_zzo) {
        this.f12499e.put(com_google_android_gms_tagmanager_zzo, Boolean.valueOf(true));
    }

    public boolean zzb(zzo com_google_android_gms_tagmanager_zzo) {
        return this.f12499e.remove(com_google_android_gms_tagmanager_zzo) != null;
    }
}
