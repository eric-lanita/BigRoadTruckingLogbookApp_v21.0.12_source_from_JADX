package com.crashlytics.android.p044a;

import android.annotation.TargetApi;
import android.app.Activity;
import io.fabric.sdk.android.C3962a;
import io.fabric.sdk.android.C3962a.C2819b;
import java.util.concurrent.ExecutorService;

@TargetApi(14)
class C2821b extends C2817a {
    private final C2819b f9755a = new C28201(this);
    private final ExecutorService f9756b;

    class C28201 extends C2819b {
        final /* synthetic */ C2821b f9754a;

        class C28181 implements Runnable {
            final /* synthetic */ C28201 f9753a;

            C28181(C28201 c28201) {
                this.f9753a = c28201;
            }

            public void run() {
                this.f9753a.f9754a.m15949c();
            }
        }

        C28201(C2821b c2821b) {
            this.f9754a = c2821b;
        }

        public void mo1425a(Activity activity) {
            if (this.f9754a.m15947a()) {
                this.f9754a.f9756b.submit(new C28181(this));
            }
        }
    }

    public C2821b(C3962a c3962a, ExecutorService executorService) {
        this.f9756b = executorService;
        c3962a.m20532a(this.f9755a);
    }
}
