package com.bigroad.ttb.android.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bigroad.shared.UserAuthenticationChangeBits.Reason;
import com.bigroad.shared.am;
import com.bigroad.ttb.android.AuthMonitor;
import com.bigroad.ttb.android.C2474y;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.TrialUserMonitor;
import com.bigroad.ttb.android.TruckManager;
import com.bigroad.ttb.android.activity.OurActivity.TitleStyle;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.protocol.TTProtocol.Person;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import com.facebook.appevents.AppEventsLogger;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends OurActivity {
    private final Runnable f5312a = new C15271(this);

    class C15271 implements Runnable {
        final /* synthetic */ MainActivity f5311a;

        C15271(MainActivity mainActivity) {
            this.f5311a = mainActivity;
        }

        public void run() {
            this.f5311a.m7674f();
        }
    }

    public MainActivity() {
        super(TitleStyle.NONE);
    }

    private void m7674f() {
        m7673c(null);
    }

    private void m7673c(Intent intent) {
        C2474y R = m6699R();
        AuthMonitor S = m6700S();
        TrialUserMonitor Y = OurApplication.m6268Y();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("com.bigroad.ttb.emailAddress");
            if (!(am.m4188a((CharSequence) stringExtra) || (S.m6031d() && stringExtra.equalsIgnoreCase(R.m12192b())))) {
                OurApplication.m6289k().m6458a(Reason.CREDENTIAL_CHANGE);
                C1632a.m7939a((Activity) this, stringExtra);
                return;
            }
        }
        Person c;
        if (S.m6030c()) {
            c = Y.m6527c();
            if (c != null) {
                C1632a.m7934a((Activity) this, c);
            } else {
                C1632a.m7924a((Activity) this);
            }
            R.m12174S();
            return;
        }
        c = R.m12222l();
        if (c == null) {
            C2134e.m10682e("TT-MainActivity", "Unexpected null Person for EULA check");
        } else if (!c.getEulaAccepted()) {
            C1632a.m7987e((Activity) this);
            return;
        }
        long g = R.m12213g();
        TruckManager p = OurApplication.m6294p();
        Truck R2 = R.m12173R();
        if (R2 != null) {
            if (g < 0 && R2.getFleetId() > 0) {
                R.m12183a(R2.getFleetId());
            }
            List arrayList = new ArrayList(1);
            arrayList.add(R2);
            p.m6565a(arrayList);
            p.m6577e(R2.getTruckNumber());
            R.m12174S();
        }
        OurApplication.m6295q().m10068r();
        if (intent == null || !intent.hasExtra("com.bigroad.ttb.destinationActivity")) {
            C1632a.m7979c((Activity) this);
        } else {
            C1632a.m7925a((Activity) this, intent.getIntExtra("com.bigroad.ttb.destinationActivity", -1));
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C2134e.m10676b("TT-MainActivity", "onCreate");
        if (bundle == null) {
            m7673c(getIntent());
        }
    }

    protected void onResume() {
        super.onResume();
        AppEventsLogger.activateApp((Context) this);
        m6701T().postDelayed(this.f5312a, 2500);
    }

    protected void onPause() {
        m6701T().removeCallbacks(this.f5312a);
        super.onPause();
    }

    protected void onDestroy() {
        C2134e.m10676b("TT-MainActivity", "onDestroy");
        super.onDestroy();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        C2134e.m10676b("TT-MainActivity", "onNewIntent");
        setIntent(intent);
        m7673c(intent);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        C2134e.m10676b("TT-MainActivity", "onActivityResult(" + i + ", " + i2 + ", " + intent + ")");
        switch (i2) {
            case -1:
            case 2:
                m7674f();
                return;
            case 1:
                if (i == 4) {
                    m7674f();
                    return;
                } else {
                    finish();
                    return;
                }
            default:
                C2134e.m10678c("TT-MainActivity", "Ignoring child activity resultCode " + i2);
                return;
        }
    }
}
