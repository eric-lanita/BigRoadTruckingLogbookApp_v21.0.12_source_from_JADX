package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class zzqj {
    protected final zzqk f11460d;

    protected zzqj(zzqk com_google_android_gms_internal_zzqk) {
        this.f11460d = com_google_android_gms_internal_zzqk;
    }

    protected static zzqk m17359a(Activity activity) {
        return m17360a(new zzqi(activity));
    }

    protected static zzqk m17360a(zzqi com_google_android_gms_internal_zzqi) {
        return com_google_android_gms_internal_zzqi.zzaqq() ? zzqv.zza(com_google_android_gms_internal_zzqi.zzaqs()) : zzql.zzt(com_google_android_gms_internal_zzqi.zzaqr());
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public Activity getActivity() {
        return this.f11460d.zzaqt();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public void onCreate(Bundle bundle) {
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
    }

    public void onStop() {
    }
}
