package com.bigroad.ttb.android.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.bigroad.shared.InspectionTerm;
import com.bigroad.shared.ac;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.DailyLogInspectInstructionActivity.CompleteInspectionDialogFragment;
import com.bigroad.ttb.android.activity.OurActivity.Feature;
import com.bigroad.ttb.android.fragment.DailyLogInspectHeader;
import com.bigroad.ttb.android.util.C2286g;
import java.util.Locale;

public class DiagnosticInspectActivity extends OurActivity {
    private TextView f5086a;

    class C14751 implements OnClickListener {
        final /* synthetic */ DiagnosticInspectActivity f5085a;

        C14751(DiagnosticInspectActivity diagnosticInspectActivity) {
            this.f5085a = diagnosticInspectActivity;
        }

        public void onClick(View view) {
            CompleteInspectionDialogFragment.m7265a(this.f5085a);
        }
    }

    public DiagnosticInspectActivity() {
        super(Feature.FINISH_ON_SIGN_OUT);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.daily_log_list_inspect_diagnostic_detail);
        m6692K().setStatusMessageVisible(false);
        int a = ((InspectionTerm) getIntent().getSerializableExtra("com.bigroad.ttb.inspectionTerm")).m4085a();
        this.f5086a = (TextView) findViewById(R.id.malfunctionDiagnosticInspect_unidentifiedDrivingRecordText);
        ((Button) findViewById(R.id.diagnosticInspect_endInspection)).setOnClickListener(new C14751(this));
        DailyLogInspectHeader.m10330a(getSupportFragmentManager(), getResources().getString(R.string.diagnosticInspect_subtitle), -1);
        m7467d(a);
    }

    protected void onStart() {
        OurApplication.m6300v().m10901a(false);
        super.onStart();
    }

    public Locale d_() {
        return ac.f2617a;
    }

    private void m7467d(int i) {
        if (C2286g.m11210a(OurApplication.ac(), i)) {
            this.f5086a.setText(R.string.malfunctionDiagnosticInspect_onText);
        } else {
            this.f5086a.setText(R.string.malfunctionDiagnosticInspect_offText);
        }
    }
}
