package com.urbanairship.actions;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.urbanairship.C3929q;

public class C3708i extends C3690a {
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
        String a2;
        if (c3694b.m19357a().m19318c() != null) {
            a = c3694b.m19357a().m19318c().m19780b("text").m19747a();
            a2 = c3694b.m19357a().m19318c().m19780b("label").m19747a();
        } else {
            a = c3694b.m19357a().m19314a();
            a2 = null;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable(this) {
            final /* synthetic */ C3708i f13356c;

            public void run() {
                if (VERSION.SDK_INT >= 11) {
                    ((ClipboardManager) C3929q.m20382h().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(a2, a));
                } else {
                    ((android.text.ClipboardManager) C3929q.m20382h().getSystemService("clipboard")).setText(a);
                }
            }
        });
        return C3701e.m19374a(c3694b.m19357a());
    }
}
