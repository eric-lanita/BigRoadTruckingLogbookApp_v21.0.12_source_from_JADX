package com.bigroad.ttb.android.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.bigroad.shared.ac;
import com.bigroad.shared.ap;
import com.bigroad.shared.model.C1116d.C1114a;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.DailyLogInspectInstructionActivity.CompleteInspectionDialogFragment;
import com.bigroad.ttb.android.activity.OurActivity.Feature;
import com.bigroad.ttb.android.p029c.C1736b;
import com.bigroad.ttb.android.widget.DailyLogInspectCurrentHeaderView;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import com.bigroad.ttb.protocol.TTProtocol.TruckLogType;
import java.util.Locale;

public class DailyLogInspectCurrentHeaderActivity extends OurActivity {
    private final ap f4805a = OurApplication.m6269Z();

    class C14061 implements OnClickListener {
        final /* synthetic */ DailyLogInspectCurrentHeaderActivity f4804a;

        C14061(DailyLogInspectCurrentHeaderActivity dailyLogInspectCurrentHeaderActivity) {
            this.f4804a = dailyLogInspectCurrentHeaderActivity;
        }

        public void onClick(View view) {
            CompleteInspectionDialogFragment.m7265a(this.f4804a);
        }
    }

    public DailyLogInspectCurrentHeaderActivity() {
        super(Feature.FINISH_ON_SIGN_OUT);
    }

    protected void onStart() {
        OurApplication.m6300v().m10901a(false);
        super.onStart();
    }

    public Locale d_() {
        return ac.f2617a;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.daily_log_inspect_current_header);
        m6692K().setStatusMessageVisible(false);
        DailyLogInspectCurrentHeaderView dailyLogInspectCurrentHeaderView = (DailyLogInspectCurrentHeaderView) findViewById(R.id.dailyLog_currentHeader);
        dailyLogInspectCurrentHeaderView.setInspectAsLogType(TruckLogType.ELD);
        C1736b r = OurApplication.m6296r();
        DailyLog f = r.m8491f(r.m8485c());
        dailyLogInspectCurrentHeaderView.m11883a(f.getLogDay(), f, C1114a.m5598a(f, OurApplication.af(), this.f4805a.mo914b()).m5635a());
        ((Button) findViewById(R.id.dailyLogEndInspectionButton_endInspection)).setOnClickListener(new C14061(this));
    }
}
