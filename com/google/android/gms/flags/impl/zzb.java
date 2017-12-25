package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.internal.zzua;
import java.util.concurrent.Callable;

public class zzb {
    private static SharedPreferences f10967a = null;

    class C32421 implements Callable<SharedPreferences> {
        final /* synthetic */ Context f10966a;

        C32421(Context context) {
            this.f10966a = context;
        }

        public /* synthetic */ Object call() {
            return zzbex();
        }

        public SharedPreferences zzbex() {
            return this.f10966a.getSharedPreferences("google_sdk_flags", 1);
        }
    }

    public static SharedPreferences zzn(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (SharedPreferences.class) {
            if (f10967a == null) {
                f10967a = (SharedPreferences) zzua.zzb(new C32421(context));
            }
            sharedPreferences = f10967a;
        }
        return sharedPreferences;
    }
}
