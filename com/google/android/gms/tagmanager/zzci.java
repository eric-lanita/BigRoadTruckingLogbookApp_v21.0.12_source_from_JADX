package com.google.android.gms.tagmanager;

import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

class zzci {
    private static zzci f12612a;
    private volatile zza f12613b;
    private volatile String f12614c;
    private volatile String f12615d;
    private volatile String f12616e;

    enum zza {
        NONE,
        CONTAINER,
        CONTAINER_DEBUG
    }

    zzci() {
        m18135e();
    }

    static zzci m18128a() {
        zzci com_google_android_gms_tagmanager_zzci;
        synchronized (zzci.class) {
            if (f12612a == null) {
                f12612a = new zzci();
            }
            com_google_android_gms_tagmanager_zzci = f12612a;
        }
        return com_google_android_gms_tagmanager_zzci;
    }

    private String m18129a(String str) {
        return str.split("&")[0].split("=")[1];
    }

    private String m18130b(Uri uri) {
        return uri.getQuery().replace("&gtm_debug=x", "");
    }

    synchronized boolean m18131a(Uri uri) {
        boolean z = true;
        synchronized (this) {
            try {
                String decode = URLDecoder.decode(uri.toString(), "UTF-8");
                String str;
                String valueOf;
                if (decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
                    str = "Container preview url: ";
                    valueOf = String.valueOf(decode);
                    zzbn.m18106v(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                    if (decode.matches(".*?&gtm_debug=x$")) {
                        this.f12613b = zza.CONTAINER_DEBUG;
                    } else {
                        this.f12613b = zza.CONTAINER;
                    }
                    this.f12616e = m18130b(uri);
                    if (this.f12613b == zza.CONTAINER || this.f12613b == zza.CONTAINER_DEBUG) {
                        decode = String.valueOf("/r?");
                        valueOf = String.valueOf(this.f12616e);
                        this.f12615d = valueOf.length() != 0 ? decode.concat(valueOf) : new String(decode);
                    }
                    this.f12614c = m18129a(this.f12616e);
                } else if (!decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$")) {
                    str = "Invalid preview uri: ";
                    String valueOf2 = String.valueOf(decode);
                    zzbn.zzcx(valueOf2.length() != 0 ? str.concat(valueOf2) : new String(str));
                    z = false;
                } else if (m18129a(uri.getQuery()).equals(this.f12614c)) {
                    decode = "Exit preview mode for container: ";
                    valueOf = String.valueOf(this.f12614c);
                    zzbn.m18106v(valueOf.length() != 0 ? decode.concat(valueOf) : new String(decode));
                    this.f12613b = zza.NONE;
                    this.f12615d = null;
                } else {
                    z = false;
                }
            } catch (UnsupportedEncodingException e) {
                z = false;
            }
        }
        return z;
    }

    zza m18132b() {
        return this.f12613b;
    }

    String m18133c() {
        return this.f12615d;
    }

    String m18134d() {
        return this.f12614c;
    }

    void m18135e() {
        this.f12613b = zza.NONE;
        this.f12615d = null;
        this.f12614c = null;
        this.f12616e = null;
    }
}
