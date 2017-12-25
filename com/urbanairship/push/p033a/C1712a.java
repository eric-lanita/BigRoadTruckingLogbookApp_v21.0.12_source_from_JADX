package com.urbanairship.push.p033a;

import android.app.Notification;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.app.ad.C0135q;
import android.support.v4.app.ad.C0137c;
import android.support.v4.app.ad.C0138d;
import com.urbanairship.C3783j;
import com.urbanairship.push.PushMessage;
import com.urbanairship.util.C3951f;
import com.urbanairship.util.C3954i;

public class C1712a extends C1711e {
    private int f5898a;
    private int f5899b;
    private int f5900c;
    private Uri f5901d = null;
    private int f5902e = -1;
    private int f5903f = 0;

    public C1712a(Context context) {
        super(context);
        this.f5898a = context.getApplicationInfo().labelRes;
        this.f5899b = context.getApplicationInfo().icon;
    }

    public Notification mo1053a(PushMessage pushMessage, int i) {
        if (C3954i.m20512a(pushMessage.m20046e())) {
            return null;
        }
        return mo1054a(pushMessage, i, new C0137c().m622c(pushMessage.m20046e())).m639b();
    }

    public int mo1052a(PushMessage pushMessage) {
        if (this.f5902e > 0) {
            return this.f5902e;
        }
        return C3951f.m20504a();
    }

    protected C0138d mo1054a(PushMessage pushMessage, int i, C0135q c0135q) {
        C0138d e = new C0138d(m8332c()).m636a(C3954i.m20512a(pushMessage.m20053l()) ? m8340b() : pushMessage.m20053l()).m642b(pushMessage.m20046e()).m646c(true).m626a(this.f5899b).m648d(this.f5903f).m650d(pushMessage.m20057p()).m644c(pushMessage.m20058q()).m637a(pushMessage.m20061t()).m651e(pushMessage.m20059r());
        Notification d = m8334d(pushMessage, this.f5899b);
        if (d != null) {
            e.m629a(d);
        }
        int i2 = 3;
        if (pushMessage.m20041a(m8332c()) != null) {
            e.m632a(pushMessage.m20041a(m8332c()));
            i2 = 2;
        } else if (this.f5901d != null) {
            e.m632a(this.f5901d);
            i2 = 2;
        }
        e.m640b(i2);
        if (this.f5900c > 0) {
            e.m631a(BitmapFactory.decodeResource(m8332c().getResources(), this.f5900c));
        }
        if (pushMessage.m20054m() != null) {
            e.m645c(pushMessage.m20054m());
        }
        C0135q c0135q2 = null;
        try {
            c0135q2 = m8331b(pushMessage);
        } catch (Throwable e2) {
            C3783j.m19726c("Failed to create notification style.", e2);
        }
        if (c0135q2 != null) {
            e.m635a(c0135q2);
        } else if (c0135q != null) {
            e.m635a(c0135q);
        }
        if (!pushMessage.m20057p()) {
            try {
                e.m634a(m8333c(pushMessage, i));
            } catch (Throwable e3) {
                C3783j.m19726c("Failed to create wearable extender.", e3);
            }
        }
        e.m634a(m8330b(pushMessage, i));
        return e;
    }

    public int m8335a() {
        return this.f5898a;
    }

    public void m8339a(int i) {
        this.f5899b = i;
    }

    public void m8341b(int i) {
        this.f5903f = i;
    }

    protected String m8340b() {
        if (m8335a() == 0) {
            return m8332c().getPackageManager().getApplicationLabel(m8332c().getApplicationInfo()).toString();
        }
        if (m8335a() > 0) {
            return m8332c().getString(m8335a());
        }
        return "";
    }
}
