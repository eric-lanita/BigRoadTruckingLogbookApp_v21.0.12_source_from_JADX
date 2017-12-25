package com.google.android.gms.internal;

public abstract class zzapp<M extends zzapp<M>> extends zzapv {
    protected zzapr f11086a;

    protected int mo1813a() {
        int i = 0;
        if (this.f11086a == null) {
            return 0;
        }
        int i2 = 0;
        while (i < this.f11086a.m17327a()) {
            i2 += this.f11086a.m17330b(i).m17332a();
            i++;
        }
        return i2;
    }

    protected final boolean m17145a(zzapn com_google_android_gms_internal_zzapn, int i) {
        int position = com_google_android_gms_internal_zzapn.getPosition();
        if (!com_google_android_gms_internal_zzapn.zzafp(i)) {
            return false;
        }
        int zzagj = zzapy.zzagj(i);
        zzapx com_google_android_gms_internal_zzapx = new zzapx(i, com_google_android_gms_internal_zzapn.zzad(position, com_google_android_gms_internal_zzapn.getPosition() - position));
        zzaps com_google_android_gms_internal_zzaps = null;
        if (this.f11086a == null) {
            this.f11086a = new zzapr();
        } else {
            com_google_android_gms_internal_zzaps = this.f11086a.m17328a(zzagj);
        }
        if (com_google_android_gms_internal_zzaps == null) {
            com_google_android_gms_internal_zzaps = new zzaps();
            this.f11086a.m17329a(zzagj, com_google_android_gms_internal_zzaps);
        }
        com_google_android_gms_internal_zzaps.m17335a(com_google_android_gms_internal_zzapx);
        return true;
    }

    public M aA() {
        zzapp com_google_android_gms_internal_zzapp = (zzapp) super.aB();
        zzapt.zza(this, com_google_android_gms_internal_zzapp);
        return com_google_android_gms_internal_zzapp;
    }

    public /* synthetic */ zzapv aB() {
        return (zzapp) clone();
    }

    public /* synthetic */ Object clone() {
        return aA();
    }

    public final <T> T zza(zzapq<M, T> com_google_android_gms_internal_zzapq_M__T) {
        if (this.f11086a == null) {
            return null;
        }
        zzaps a = this.f11086a.m17328a(zzapy.zzagj(com_google_android_gms_internal_zzapq_M__T.tag));
        return a != null ? a.m17333a((zzapq) com_google_android_gms_internal_zzapq_M__T) : null;
    }

    public void zza(zzapo com_google_android_gms_internal_zzapo) {
        if (this.f11086a != null) {
            for (int i = 0; i < this.f11086a.m17327a(); i++) {
                this.f11086a.m17330b(i).m17334a(com_google_android_gms_internal_zzapo);
            }
        }
    }
}
