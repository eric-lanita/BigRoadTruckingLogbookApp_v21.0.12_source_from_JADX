package io.fabric.sdk.android.services.p046b;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;

public class C3986i implements Runnable {
    private final Context f14099a;
    private final C2854e f14100b;

    public C3986i(Context context, C2854e c2854e) {
        this.f14099a = context;
        this.f14100b = c2854e;
    }

    public void run() {
        try {
            CommonUtils.m20701a(this.f14099a, "Performing time based file roll over.");
            if (!this.f14100b.mo1445c()) {
                this.f14100b.mo1446d();
            }
        } catch (Throwable e) {
            CommonUtils.m20702a(this.f14099a, "Failed to roll over file", e);
        }
    }
}
