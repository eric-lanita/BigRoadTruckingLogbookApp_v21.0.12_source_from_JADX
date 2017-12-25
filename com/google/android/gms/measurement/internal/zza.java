package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzab;

class zza {
    private final zzx f12123a;
    private final String f12124b;
    private String f12125c;
    private String f12126d;
    private String f12127e;
    private String f12128f;
    private long f12129g;
    private long f12130h;
    private long f12131i;
    private String f12132j;
    private long f12133k;
    private String f12134l;
    private long f12135m;
    private long f12136n;
    private boolean f12137o;
    private long f12138p;
    private long f12139q;
    private long f12140r;
    private long f12141s;
    private long f12142t;
    private boolean f12143u;
    private long f12144v;
    private long f12145w;

    zza(zzx com_google_android_gms_measurement_internal_zzx, String str) {
        zzab.zzy(com_google_android_gms_measurement_internal_zzx);
        zzab.zzhr(str);
        this.f12123a = com_google_android_gms_measurement_internal_zzx;
        this.f12124b = str;
        this.f12123a.zzwu();
    }

    public void setAppVersion(String str) {
        this.f12123a.zzwu();
        this.f12143u = (!zzal.zzbb(this.f12132j, str) ? 1 : 0) | this.f12143u;
        this.f12132j = str;
    }

    public void setMeasurementEnabled(boolean z) {
        this.f12123a.zzwu();
        this.f12143u = (this.f12137o != z ? 1 : 0) | this.f12143u;
        this.f12137o = z;
    }

    public void zzau(long j) {
        this.f12123a.zzwu();
        this.f12143u = (this.f12130h != j ? 1 : 0) | this.f12143u;
        this.f12130h = j;
    }

    public void zzav(long j) {
        this.f12123a.zzwu();
        this.f12143u = (this.f12131i != j ? 1 : 0) | this.f12143u;
        this.f12131i = j;
    }

    public void zzaw(long j) {
        this.f12123a.zzwu();
        this.f12143u = (this.f12133k != j ? 1 : 0) | this.f12143u;
        this.f12133k = j;
    }

    public String zzawo() {
        this.f12123a.zzwu();
        return this.f12125c;
    }

    public void zzax(long j) {
        this.f12123a.zzwu();
        this.f12143u = (this.f12135m != j ? 1 : 0) | this.f12143u;
        this.f12135m = j;
    }

    public void zzay(long j) {
        this.f12123a.zzwu();
        this.f12143u = (this.f12136n != j ? 1 : 0) | this.f12143u;
        this.f12136n = j;
    }

    public void zzaz(long j) {
        int i = 1;
        zzab.zzbo(j >= 0);
        this.f12123a.zzwu();
        boolean z = this.f12143u;
        if (this.f12129g == j) {
            i = 0;
        }
        this.f12143u = z | i;
        this.f12129g = j;
    }

    public void zzba(long j) {
        this.f12123a.zzwu();
        this.f12143u = (this.f12144v != j ? 1 : 0) | this.f12143u;
        this.f12144v = j;
    }

    public void zzbb(long j) {
        this.f12123a.zzwu();
        this.f12143u = (this.f12145w != j ? 1 : 0) | this.f12143u;
        this.f12145w = j;
    }

    public void zzbc(long j) {
        this.f12123a.zzwu();
        this.f12143u = (this.f12138p != j ? 1 : 0) | this.f12143u;
        this.f12138p = j;
    }

    public void zzbd(long j) {
        this.f12123a.zzwu();
        this.f12143u = (this.f12139q != j ? 1 : 0) | this.f12143u;
        this.f12139q = j;
    }

    public void zzbe(long j) {
        this.f12123a.zzwu();
        this.f12143u = (this.f12140r != j ? 1 : 0) | this.f12143u;
        this.f12140r = j;
    }

    public void zzbf(long j) {
        this.f12123a.zzwu();
        this.f12143u = (this.f12141s != j ? 1 : 0) | this.f12143u;
        this.f12141s = j;
    }

    public void zzbg(long j) {
        this.f12123a.zzwu();
        this.f12143u = (this.f12142t != j ? 1 : 0) | this.f12143u;
        this.f12142t = j;
    }

    public void zzbpr() {
        this.f12123a.zzwu();
        this.f12143u = false;
    }

    public String zzbps() {
        this.f12123a.zzwu();
        return this.f12126d;
    }

    public String zzbpt() {
        this.f12123a.zzwu();
        return this.f12127e;
    }

    public String zzbpu() {
        this.f12123a.zzwu();
        return this.f12128f;
    }

    public long zzbpv() {
        this.f12123a.zzwu();
        return this.f12130h;
    }

    public long zzbpw() {
        this.f12123a.zzwu();
        return this.f12131i;
    }

    public long zzbpx() {
        this.f12123a.zzwu();
        return this.f12133k;
    }

    public String zzbpy() {
        this.f12123a.zzwu();
        return this.f12134l;
    }

    public long zzbpz() {
        this.f12123a.zzwu();
        return this.f12135m;
    }

    public long zzbqa() {
        this.f12123a.zzwu();
        return this.f12136n;
    }

    public boolean zzbqb() {
        this.f12123a.zzwu();
        return this.f12137o;
    }

    public long zzbqc() {
        this.f12123a.zzwu();
        return this.f12129g;
    }

    public long zzbqd() {
        this.f12123a.zzwu();
        return this.f12144v;
    }

    public long zzbqe() {
        this.f12123a.zzwu();
        return this.f12145w;
    }

    public void zzbqf() {
        this.f12123a.zzwu();
        long j = this.f12129g + 1;
        if (j > 2147483647L) {
            this.f12123a.zzbsd().zzbsx().log("Bundle index overflow");
            j = 0;
        }
        this.f12143u = true;
        this.f12129g = j;
    }

    public long zzbqg() {
        this.f12123a.zzwu();
        return this.f12138p;
    }

    public long zzbqh() {
        this.f12123a.zzwu();
        return this.f12139q;
    }

    public long zzbqi() {
        this.f12123a.zzwu();
        return this.f12140r;
    }

    public long zzbqj() {
        this.f12123a.zzwu();
        return this.f12141s;
    }

    public long zzbqk() {
        this.f12123a.zzwu();
        return this.f12142t;
    }

    public void zzky(String str) {
        this.f12123a.zzwu();
        this.f12143u = (!zzal.zzbb(this.f12125c, str) ? 1 : 0) | this.f12143u;
        this.f12125c = str;
    }

    public void zzkz(String str) {
        this.f12123a.zzwu();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.f12143u = (!zzal.zzbb(this.f12126d, str) ? 1 : 0) | this.f12143u;
        this.f12126d = str;
    }

    public void zzla(String str) {
        this.f12123a.zzwu();
        this.f12143u = (!zzal.zzbb(this.f12127e, str) ? 1 : 0) | this.f12143u;
        this.f12127e = str;
    }

    public void zzlb(String str) {
        this.f12123a.zzwu();
        this.f12143u = (!zzal.zzbb(this.f12128f, str) ? 1 : 0) | this.f12143u;
        this.f12128f = str;
    }

    public void zzlc(String str) {
        this.f12123a.zzwu();
        this.f12143u = (!zzal.zzbb(this.f12134l, str) ? 1 : 0) | this.f12143u;
        this.f12134l = str;
    }

    public String zzsh() {
        this.f12123a.zzwu();
        return this.f12124b;
    }

    public String zzxc() {
        this.f12123a.zzwu();
        return this.f12132j;
    }
}
