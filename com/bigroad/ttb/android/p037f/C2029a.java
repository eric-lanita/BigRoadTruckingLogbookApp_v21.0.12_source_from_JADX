package com.bigroad.ttb.android.p037f;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.C1632a;
import com.bigroad.ttb.android.dialog.HelpDialogFragment;
import com.bigroad.ttb.protocol.TTProtocol.Truck;

public class C2029a extends C2028d {
    static boolean m10129a(final C2028d c2028d, HelpDialogFragment helpDialogFragment) {
        if (!C2029a.m10128a()) {
            return false;
        }
        c2028d.m10123c(R.id.customTitle_dashLinkState);
        helpDialogFragment.m8869a();
        helpDialogFragment.m8873b((int) R.string.dashboard_helpDiscoverDashLink);
        TextView c = helpDialogFragment.m8874c((int) R.string.dashLink_overviewLearnMore);
        c.setClickable(true);
        c.setPaintFlags(8);
        c.setTextColor(-16776961);
        c.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                OurApplication.m6282d().m8307i();
                C1632a.m8012p(c2028d.m10124d());
            }
        });
        return true;
    }

    public static boolean m10128a() {
        Truck f = OurApplication.m6294p().m6578f();
        return (f == null || !f.getHasAobrd()) && OurApplication.m6292n().m11018d();
    }

    public HelpDialogFragment mo1181b() {
        return HelpDialogFragment.m8863a(true);
    }

    protected int mo1182c() {
        return 0;
    }

    protected boolean mo1180a(int i, HelpDialogFragment helpDialogFragment) {
        C2029a.m10129a((C2028d) this, helpDialogFragment);
        helpDialogFragment.m8872b();
        return true;
    }

    protected void mo1179a(int i, HelpDialogFragment helpDialogFragment, View view) {
    }

    protected void mo1178a(int i, Activity activity, View view) {
    }
}
