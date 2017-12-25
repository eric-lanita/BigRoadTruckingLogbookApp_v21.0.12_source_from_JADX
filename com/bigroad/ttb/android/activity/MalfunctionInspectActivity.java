package com.bigroad.ttb.android.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.bigroad.shared.ac;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.DailyLogInspectInstructionActivity.CompleteInspectionDialogFragment;
import com.bigroad.ttb.android.activity.OurActivity.Feature;
import com.bigroad.ttb.android.fragment.DailyLogInspectHeader;
import java.util.Locale;

public class MalfunctionInspectActivity extends OurActivity {

    class C15281 implements OnClickListener {
        final /* synthetic */ MalfunctionInspectActivity f5313a;

        C15281(MalfunctionInspectActivity malfunctionInspectActivity) {
            this.f5313a = malfunctionInspectActivity;
        }

        public void onClick(View view) {
            CompleteInspectionDialogFragment.m7265a(this.f5313a);
        }
    }

    public MalfunctionInspectActivity() {
        super(Feature.FINISH_ON_SIGN_OUT);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.daily_log_list_inspect_malfunction_detail);
        m6692K().setStatusMessageVisible(false);
        ((Button) findViewById(R.id.malfunctionInspect_endInspection)).setOnClickListener(new C15281(this));
        DailyLogInspectHeader.m10330a(getSupportFragmentManager(), getResources().getString(R.string.malfunctionInspect_subtitle), -1);
        ((TextView) findViewById(R.id.malfunctionDiagnosticInspect_otherText)).setText(OurApplication.m6254K().m11102e() ? R.string.yes : R.string.none);
    }

    protected void onStart() {
        OurApplication.m6300v().m10901a(false);
        super.onStart();
    }

    public Locale d_() {
        return ac.f2617a;
    }
}
