package com.urbanairship.actions;

import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.urbanairship.C3929q;

public class C3721p extends C3690a {
    public boolean mo2769b(C3694b c3694b) {
        switch (c3694b.m19358b()) {
            case 0:
            case 2:
            case 3:
            case 4:
            case 5:
                if (c3694b.m19357a().m19318c() != null) {
                    return c3694b.m19357a().m19318c().m19780b("text").m19758i();
                }
                return c3694b.m19357a().m19314a() != null;
            default:
                return false;
        }
    }

    public C3701e mo2770d(C3694b c3694b) {
        String a;
        int i = 0;
        if (c3694b.m19357a().m19318c() != null) {
            i = c3694b.m19357a().m19318c().m19782c("length").m19745a(0);
            a = c3694b.m19357a().m19318c().m19782c("text").m19747a();
        } else {
            a = c3694b.m19357a().m19314a();
        }
        new Handler(Looper.getMainLooper()).post(new Runnable(this) {
            final /* synthetic */ C3721p f13372c;

            public void run() {
                if (i == 1) {
                    Toast.makeText(C3929q.m20382h(), a, 1).show();
                } else {
                    Toast.makeText(C3929q.m20382h(), a, 0).show();
                }
            }
        });
        return C3701e.m19374a(c3694b.m19357a());
    }
}
