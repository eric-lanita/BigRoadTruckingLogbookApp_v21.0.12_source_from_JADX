package com.crashlytics.android.answers;

final class C2868s {
    public final String f9877a;
    public final String f9878b;
    public final String f9879c;
    public final String f9880d;
    public final String f9881e;
    public final Boolean f9882f;
    public final String f9883g;
    public final String f9884h;
    public final String f9885i;
    public final String f9886j;
    public final String f9887k;
    public final String f9888l;
    private String f9889m;

    public C2868s(String str, String str2, String str3, String str4, String str5, Boolean bool, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.f9877a = str;
        this.f9878b = str2;
        this.f9879c = str3;
        this.f9880d = str4;
        this.f9881e = str5;
        this.f9882f = bool;
        this.f9883g = str6;
        this.f9884h = str7;
        this.f9885i = str8;
        this.f9886j = str9;
        this.f9887k = str10;
        this.f9888l = str11;
    }

    public String toString() {
        if (this.f9889m == null) {
            this.f9889m = "appBundleId=" + this.f9877a + ", executionId=" + this.f9878b + ", installationId=" + this.f9879c + ", androidId=" + this.f9880d + ", advertisingId=" + this.f9881e + ", limitAdTrackingEnabled=" + this.f9882f + ", betaDeviceToken=" + this.f9883g + ", buildId=" + this.f9884h + ", osVersion=" + this.f9885i + ", deviceModel=" + this.f9886j + ", appVersionCode=" + this.f9887k + ", appVersionName=" + this.f9888l;
        }
        return this.f9889m;
    }
}
