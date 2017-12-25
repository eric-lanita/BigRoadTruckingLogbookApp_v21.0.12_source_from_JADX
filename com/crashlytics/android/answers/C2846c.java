package com.crashlytics.android.answers;

import android.content.Context;
import android.os.Looper;
import io.fabric.sdk.android.services.common.C4016p;
import io.fabric.sdk.android.services.p046b.C3985g;
import io.fabric.sdk.android.services.p057c.C3987a;

class C2846c {
    final Context f9830a;
    final C3987a f9831b;

    public C2846c(Context context, C3987a c3987a) {
        this.f9830a = context;
        this.f9831b = c3987a;
    }

    public C2865o m16040a() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("AnswersFilesManagerProvider cannot be called on the main thread");
        }
        return new C2865o(this.f9830a, new C2870t(), new C4016p(), new C3985g(this.f9830a, this.f9831b.mo2877a(), "session_analytics.tap", "session_analytics_to_send"));
    }
}
