package com.bigroad.ttb.android.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TextView;
import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.SyncManager;
import com.bigroad.ttb.android.activity.OurActivity.Feature;
import com.bigroad.ttb.android.fragment.SelectRecipients;
import com.bigroad.ttb.android.fragment.SelectRecipients.C1290a;
import com.bigroad.ttb.android.p029c.C1736b;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import com.bigroad.ttb.protocol.TTProtocol.DailyLogShare;
import com.bigroad.ttb.protocol.TTProtocol.DailyLogShare.C2595a;
import com.bigroad.ttb.protocol.TTProtocol.DailyLogShareType;
import java.util.Calendar;

public class DailyLogSendActivity extends OurActivity implements C1290a {
    private int f4890a;
    private int f4891b;
    private DailyLogShareType f4892c;
    private TextView f4893d;
    private TextView f4894e;
    private final C1736b f4895f = OurApplication.m6296r();

    public DailyLogSendActivity() {
        super(Feature.FINISH_ON_SIGN_OUT);
    }

    public void mo930f() {
        m7303h();
        m6702U().m8297b();
        finish();
        OurApplication.m6278b((Context) this).show();
    }

    private void m7303h() {
        Iterable a = SelectRecipients.m10386a((OurActivity) this, (int) R.id.selectRecipients_fragment);
        long d = OurApplication.m6285g().m12202d();
        long g = OurApplication.m6285g().m12213g();
        C2595a a2 = DailyLogShare.newBuilder().m13242a(this.f4890a).m13255d(this.f4891b).m13251c(this.f4892c.m13309a()).m13243a(d).m13252c(OurApplication.m6269Z().mo913a()).mo1377a(a);
        if (g >= 0) {
            a2.m13248b(g);
        }
        SyncManager.m6377a((Context) this).m6467a(a2.m13253c());
    }

    public boolean c_() {
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.daily_log_send);
        m6692K().setStatusMessageVisible(false);
        this.f4893d = (TextView) findViewById(R.id.dailyLogSend_preamble1);
        this.f4894e = (TextView) findViewById(R.id.dailyLogSend_preamble2);
        Intent intent = getIntent();
        this.f4890a = intent.getIntExtra("com.bigroad.ttb.logDay", -1);
        if (this.f4890a == -1) {
            finish();
            return;
        }
        String string;
        this.f4891b = intent.getIntExtra("com.bigroad.ttb.logDayEnd", this.f4890a);
        if (this.f4891b < this.f4890a) {
            this.f4891b = this.f4890a;
        }
        this.f4892c = DailyLogShareType.m13308a(intent.getIntExtra("com.bigroad.ttb.shareType", 0));
        if (this.f4892c == DailyLogShareType.INSPECT_EMAIL_SHARE) {
            string = getString(R.string.dailyLogSend_receiveInspectionEmail);
        } else {
            string = getString(R.string.dailyLogSend_receiveMarketingEmail);
        }
        DailyLog f;
        if (this.f4891b > this.f4890a) {
            setTitle(R.string.dailyLogSend_titleMultiple);
            DailyLog f2 = this.f4895f.m8491f(this.f4890a);
            f = this.f4895f.m8491f(this.f4891b);
            if (f2 == null || f == null) {
                finish();
                return;
            }
            Calendar c = DailyLogUtils.m4306c(f2);
            Calendar c2 = DailyLogUtils.m4306c(f);
            this.f4893d.setText(getString(R.string.dailyLogSend_multiplePreamble1, new Object[]{Integer.valueOf((this.f4891b - this.f4890a) + 1), DateFormat.format("EEEE MMMM d, yyyy", c), DateFormat.format("EEEE MMMM d, yyyy", c2)}));
            this.f4894e.setText(getString(R.string.dailyLogSend_multiplePreamble2, new Object[]{string}));
            return;
        }
        int i;
        setTitle(R.string.dailyLogSend_title);
        f = this.f4895f.m8491f(this.f4890a);
        if (OurApplication.m6297s().m10973a(this.f4890a).isEmpty()) {
            i = R.string.dailyLogSend_preamble1;
        } else {
            i = R.string.dailyLogSend_preamble1_dvir;
        }
        c2 = DailyLogUtils.m4306c(f);
        this.f4893d.setText(getString(i, new Object[]{DateFormat.format("EEEE MMMM d, yyyy", c2)}));
        this.f4894e.setText(getString(R.string.dailyLogSend_preamble2, new Object[]{string}));
    }
}
