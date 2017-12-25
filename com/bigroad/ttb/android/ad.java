package com.bigroad.ttb.android;

import android.content.Context;
import android.os.Handler;
import com.bigroad.shared.C1142r;
import com.bigroad.shared.DrivingModeChangeBits;
import com.bigroad.shared.UserAuthenticationChangeBits.Reason;
import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.ttb.android.activity.C1632a;
import com.bigroad.ttb.android.activity.OurActivity;
import com.bigroad.ttb.android.event.EventManager;
import com.bigroad.ttb.android.event.EventManager.C1199e;
import com.bigroad.ttb.android.event.EventManager.ChangeListener;
import com.bigroad.ttb.android.util.C2292l;

public class ad {
    private static ad f5646a;
    private final Handler f5647b = new Handler();
    private final C2474y f5648c = OurApplication.m6285g();
    private final AuthMonitor f5649d = OurApplication.m6249F();
    private final EventManager f5650e = OurApplication.m6295q();
    private final DrivingModeManager f5651f = OurApplication.ah();
    private boolean f5652g = false;
    private byte[] f5653h;
    private final ChangeListener f5654i = new C16361(this);
    private final Runnable f5655j = new C16372(this);

    class C16361 extends C1199e {
        final /* synthetic */ ad f5644a;

        C16361(ad adVar) {
            this.f5644a = adVar;
        }

        public void mo883a(C1142r c1142r) {
            if (this.f5644a.f5653h != null && this.f5644a.f5652g && this.f5644a.f5650e.m10005a(this.f5644a.f5653h) != null) {
                this.f5644a.f5653h = null;
                this.f5644a.f5652g = false;
                this.f5644a.m8038a(OurApplication.m6281c(), Reason.OFF_DUTY_AND_SIGN_OUT);
            }
        }
    }

    class C16372 implements Runnable {
        final /* synthetic */ ad f5645a;

        C16372(ad adVar) {
            this.f5645a = adVar;
        }

        public void run() {
            this.f5645a.f5653h = null;
            this.f5645a.f5652g = false;
            this.f5645a.m8038a(OurApplication.m6281c(), Reason.OFF_DUTY_AND_SIGN_OUT_TIMEOUT);
        }
    }

    public static ad m8032a() {
        if (f5646a == null) {
            f5646a = new ad();
        }
        return f5646a;
    }

    private ad() {
        this.f5650e.m10012a(this.f5654i);
    }

    public void m8041b() {
        this.f5652g = true;
        this.f5647b.postDelayed(this.f5655j, 15000);
    }

    public void m8040a(byte[] bArr) {
        this.f5653h = bArr;
    }

    public void m8039a(OurActivity ourActivity) {
        if (!(this.f5649d.m6030c() || OurApplication.m6252I().m11413k())) {
            boolean a = C2292l.m11231a(OurApplication.m6296r().m8480b(DailyLogUtils.m4284a(this.f5648c.m12228r().m4879m())));
            Object obj = this.f5650e.m10060j() == DutyStatus.OFF_DUTY ? 1 : null;
            boolean i = this.f5650e.m10059i();
            if (!(a || obj != null || i)) {
                ourActivity.m6698Q();
                return;
            }
        }
        this.f5651f.m6188a(DrivingModeChangeBits.Reason.USER_SIGN_OUT);
        m8038a((Context) ourActivity, Reason.EXPLICIT_SIGN_OUT);
    }

    public void m8038a(Context context, Reason reason) {
        this.f5652g = false;
        this.f5647b.removeCallbacks(this.f5655j);
        if (OurApplication.m6285g().m12226p()) {
            OurApplication.m6289k().m6458a(reason);
        } else {
            C1632a.m7954a(context, reason);
        }
    }
}
