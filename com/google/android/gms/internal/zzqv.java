package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.p008d.C0270a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public final class zzqv extends Fragment implements zzqk {
    private static WeakHashMap<FragmentActivity, WeakReference<zzqv>> f11668a = new WeakHashMap();
    private Map<String, zzqj> f11669b = new C0270a();
    private int f11670c = 0;
    private Bundle f11671d;

    private void m17514a(final String str, final zzqj com_google_android_gms_internal_zzqj) {
        if (this.f11670c > 0) {
            new Handler(Looper.getMainLooper()).post(new Runnable(this) {
                final /* synthetic */ zzqv f11667c;

                public void run() {
                    if (this.f11667c.f11670c >= 1) {
                        com_google_android_gms_internal_zzqj.onCreate(this.f11667c.f11671d != null ? this.f11667c.f11671d.getBundle(str) : null);
                    }
                    if (this.f11667c.f11670c >= 2) {
                        com_google_android_gms_internal_zzqj.onStart();
                    }
                    if (this.f11667c.f11670c >= 3) {
                        com_google_android_gms_internal_zzqj.onStop();
                    }
                }
            });
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.zzqv zza(android.support.v4.app.FragmentActivity r3) {
        /*
        r0 = f11668a;
        r0 = r0.get(r3);
        r0 = (java.lang.ref.WeakReference) r0;
        if (r0 == 0) goto L_0x0013;
    L_0x000a:
        r0 = r0.get();
        r0 = (com.google.android.gms.internal.zzqv) r0;
        if (r0 == 0) goto L_0x0013;
    L_0x0012:
        return r0;
    L_0x0013:
        r0 = r3.getSupportFragmentManager();	 Catch:{ ClassCastException -> 0x0048 }
        r1 = "SupportLifecycleFragmentImpl";
        r0 = r0.mo149a(r1);	 Catch:{ ClassCastException -> 0x0048 }
        r0 = (com.google.android.gms.internal.zzqv) r0;	 Catch:{ ClassCastException -> 0x0048 }
        if (r0 == 0) goto L_0x0027;
    L_0x0021:
        r1 = r0.isRemoving();
        if (r1 == 0) goto L_0x003d;
    L_0x0027:
        r0 = new com.google.android.gms.internal.zzqv;
        r0.<init>();
        r1 = r3.getSupportFragmentManager();
        r1 = r1.mo150a();
        r2 = "SupportLifecycleFragmentImpl";
        r1 = r1.mo142a(r0, r2);
        r1.mo143b();
    L_0x003d:
        r1 = f11668a;
        r2 = new java.lang.ref.WeakReference;
        r2.<init>(r0);
        r1.put(r3, r2);
        goto L_0x0012;
    L_0x0048:
        r0 = move-exception;
        r1 = new java.lang.IllegalStateException;
        r2 = "Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl";
        r1.<init>(r2, r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzqv.zza(android.support.v4.app.FragmentActivity):com.google.android.gms.internal.zzqv");
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (zzqj dump : this.f11669b.values()) {
            dump.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (zzqj onActivityResult : this.f11669b.values()) {
            onActivityResult.onActivityResult(i, i2, intent);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f11670c = 1;
        this.f11671d = bundle;
        for (Entry entry : this.f11669b.entrySet()) {
            ((zzqj) entry.getValue()).onCreate(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Entry entry : this.f11669b.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((zzqj) entry.getValue()).onSaveInstanceState(bundle2);
                bundle.putBundle((String) entry.getKey(), bundle2);
            }
        }
    }

    public void onStart() {
        super.onStop();
        this.f11670c = 2;
        for (zzqj onStart : this.f11669b.values()) {
            onStart.onStart();
        }
    }

    public void onStop() {
        super.onStop();
        this.f11670c = 3;
        for (zzqj onStop : this.f11669b.values()) {
            onStop.onStop();
        }
    }

    public <T extends zzqj> T zza(String str, Class<T> cls) {
        return (zzqj) cls.cast(this.f11669b.get(str));
    }

    public void zza(String str, zzqj com_google_android_gms_internal_zzqj) {
        if (this.f11669b.containsKey(str)) {
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 59).append("LifecycleCallback with tag ").append(str).append(" already added to this fragment.").toString());
        }
        this.f11669b.put(str, com_google_android_gms_internal_zzqj);
        m17514a(str, com_google_android_gms_internal_zzqj);
    }

    public /* synthetic */ Activity zzaqt() {
        return zzaqv();
    }

    public FragmentActivity zzaqv() {
        return getActivity();
    }
}
