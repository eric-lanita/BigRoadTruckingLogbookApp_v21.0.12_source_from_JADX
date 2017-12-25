package com.bigroad.ttb.android.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.support.v4.app.ad.C0137c;
import android.support.v4.app.ad.C0138d;
import com.bigroad.ttb.android.C2098i;
import com.bigroad.ttb.android.C2098i.C1320a;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.C1632a;

class C2207b extends C2204d {
    private static C2207b f7643c;
    private final C2098i f7644d = OurApplication.m6299u();
    private Notification f7645e;
    private int f7646f = 0;
    private final C1320a f7647g = new C22061(this);

    class C22061 implements C1320a {
        final /* synthetic */ C2207b f7642a;

        C22061(C2207b c2207b) {
            this.f7642a = c2207b;
        }

        public void mo952a(C2098i c2098i, long[] jArr) {
            this.f7642a.m10897b();
        }
    }

    public static C2207b m10894a(Context context) {
        if (f7643c == null) {
            f7643c = new C2207b(context);
        }
        return f7643c;
    }

    private C2207b(Context context) {
        super(context);
        this.f7644d.m10511a(this.f7647g);
        m10897b();
    }

    private String m10896b(int i) {
        return this.b.getResources().getQuantityString(R.plurals.notification_unreadMessageTitle, i, new Object[]{Integer.valueOf(i)});
    }

    private PendingIntent m10893a() {
        return PendingIntent.getActivity(this.b, 1, C1632a.m7978c(this.b, 0), 268435456);
    }

    private void m10897b() {
        int i = this.f7646f;
        int a = this.f7644d.m10507a();
        if (a != this.f7646f) {
            this.f7646f = a;
            if (a == 0) {
                m10873a(1);
                return;
            }
            long a2 = OurApplication.m6269Z().mo913a();
            CharSequence b = m10896b(this.f7646f);
            CharSequence string = this.b.getString(R.string.notification_unreadMessageContentText);
            this.f7645e = new C0138d(this.b).m626a((int) R.drawable.message_notification_icon).m636a(b).m642b(string).m635a(new C0137c().m622c(string)).m628a(a2).m649d(b).m640b(a > i ? 3 : 0).m627a(this.b.getResources().getColor(R.color.brand), 1000, 5000).m630a(m10893a()).m639b();
            m10874a(1, this.f7645e);
        }
    }
}
