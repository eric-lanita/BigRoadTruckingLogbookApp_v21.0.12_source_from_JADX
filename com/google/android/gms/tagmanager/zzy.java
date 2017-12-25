package com.google.android.gms.tagmanager;

import android.util.Log;

public class zzy implements zzbo {
    private int f12845a = 5;

    public void mo2510e(String str) {
        if (this.f12845a <= 6) {
            Log.e("GoogleTagManager", str);
        }
    }

    public void setLogLevel(int i) {
        this.f12845a = i;
    }

    public void mo2512v(String str) {
        if (this.f12845a <= 2) {
            Log.v("GoogleTagManager", str);
        }
    }

    public void zzb(String str, Throwable th) {
        if (this.f12845a <= 6) {
            Log.e("GoogleTagManager", str, th);
        }
    }

    public void zzcv(String str) {
        if (this.f12845a <= 3) {
            Log.d("GoogleTagManager", str);
        }
    }

    public void zzcw(String str) {
        if (this.f12845a <= 4) {
            Log.i("GoogleTagManager", str);
        }
    }

    public void zzcx(String str) {
        if (this.f12845a <= 5) {
            Log.w("GoogleTagManager", str);
        }
    }

    public void zzd(String str, Throwable th) {
        if (this.f12845a <= 5) {
            Log.w("GoogleTagManager", str, th);
        }
    }
}
