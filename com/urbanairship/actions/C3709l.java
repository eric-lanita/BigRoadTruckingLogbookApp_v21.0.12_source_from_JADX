package com.urbanairship.actions;

import android.content.Intent;
import android.net.Uri;
import com.urbanairship.C3783j;
import com.urbanairship.C3929q;
import com.urbanairship.util.C3955j;

public class C3709l extends C3690a {
    public C3701e mo2770d(C3694b c3694b) {
        Uri a = C3955j.m20514a(c3694b.m19357a().m19314a());
        C3783j.m19727d("Opening URI: " + a);
        Intent intent = new Intent("android.intent.action.VIEW", a);
        intent.addFlags(268435456);
        C3929q.m20382h().startActivity(intent);
        return C3701e.m19374a(c3694b.m19357a());
    }

    public boolean mo2769b(C3694b c3694b) {
        switch (c3694b.m19358b()) {
            case 0:
            case 2:
            case 3:
            case 4:
                return C3955j.m20514a(c3694b.m19357a().m19314a()) != null;
            default:
                return false;
        }
    }
}
