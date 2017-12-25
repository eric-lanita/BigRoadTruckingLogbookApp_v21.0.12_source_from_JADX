package com.google.android.gms.tagmanager;

import android.content.Context;

public class zzz implements zzas {
    private static zzz f12846a;
    private static final Object f12847b = new Object();
    private zzck f12848c;
    private zzat f12849d;

    private zzz(Context context) {
        this(zzau.m18091a(context), new zzcz());
    }

    zzz(zzat com_google_android_gms_tagmanager_zzat, zzck com_google_android_gms_tagmanager_zzck) {
        this.f12849d = com_google_android_gms_tagmanager_zzat;
        this.f12848c = com_google_android_gms_tagmanager_zzck;
    }

    public static zzas zzdv(Context context) {
        zzas com_google_android_gms_tagmanager_zzas;
        synchronized (f12847b) {
            if (f12846a == null) {
                f12846a = new zzz(context);
            }
            com_google_android_gms_tagmanager_zzas = f12846a;
        }
        return com_google_android_gms_tagmanager_zzas;
    }

    public boolean zzor(String str) {
        if (this.f12848c.zzade()) {
            this.f12849d.zzov(str);
            return true;
        }
        zzbn.zzcx("Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
        return false;
    }
}
