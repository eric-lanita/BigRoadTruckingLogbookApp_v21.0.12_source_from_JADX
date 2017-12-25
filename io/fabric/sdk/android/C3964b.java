package io.fabric.sdk.android;

import android.util.Log;

public class C3964b implements C3963k {
    private int f14026a;

    public C3964b(int i) {
        this.f14026a = i;
    }

    public C3964b() {
        this.f14026a = 4;
    }

    public boolean mo2851a(String str, int i) {
        return this.f14026a <= i;
    }

    public void mo2850a(String str, String str2, Throwable th) {
        if (mo2851a(str, 3)) {
            Log.d(str, str2, th);
        }
    }

    public void m20549b(String str, String str2, Throwable th) {
        if (mo2851a(str, 2)) {
            Log.v(str, str2, th);
        }
    }

    public void m20551c(String str, String str2, Throwable th) {
        if (mo2851a(str, 4)) {
            Log.i(str, str2, th);
        }
    }

    public void mo2855d(String str, String str2, Throwable th) {
        if (mo2851a(str, 5)) {
            Log.w(str, str2, th);
        }
    }

    public void mo2857e(String str, String str2, Throwable th) {
        if (mo2851a(str, 6)) {
            Log.e(str, str2, th);
        }
    }

    public void mo2849a(String str, String str2) {
        mo2850a(str, str2, null);
    }

    public void mo2852b(String str, String str2) {
        m20549b(str, str2, null);
    }

    public void mo2853c(String str, String str2) {
        m20551c(str, str2, null);
    }

    public void mo2854d(String str, String str2) {
        mo2855d(str, str2, null);
    }

    public void mo2856e(String str, String str2) {
        mo2857e(str, str2, null);
    }

    public void mo2848a(int i, String str, String str2) {
        m20544a(i, str, str2, false);
    }

    public void m20544a(int i, String str, String str2, boolean z) {
        if (z || mo2851a(str, i)) {
            Log.println(i, str, str2);
        }
    }
}
