package io.fabric.sdk.android.services.p057c;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import io.fabric.sdk.android.C2822h;

public class C3990d implements C3989c {
    private final SharedPreferences f14104a;
    private final String f14105b;
    private final Context f14106c;

    public C3990d(Context context, String str) {
        if (context == null) {
            throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
        }
        this.f14106c = context;
        this.f14105b = str;
        this.f14104a = this.f14106c.getSharedPreferences(this.f14105b, 0);
    }

    @Deprecated
    public C3990d(C2822h c2822h) {
        this(c2822h.m15970r(), c2822h.getClass().getName());
    }

    public SharedPreferences mo2878a() {
        return this.f14104a;
    }

    public Editor mo2880b() {
        return this.f14104a.edit();
    }

    @TargetApi(9)
    public boolean mo2879a(Editor editor) {
        if (VERSION.SDK_INT < 9) {
            return editor.commit();
        }
        editor.apply();
        return true;
    }
}
