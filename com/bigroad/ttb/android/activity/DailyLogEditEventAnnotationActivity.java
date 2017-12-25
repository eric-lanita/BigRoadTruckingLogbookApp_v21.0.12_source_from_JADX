package com.bigroad.ttb.android.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.bigroad.shared.DrivingModeChangeBits.Reason;
import com.bigroad.shared.DutyStatusChangeBits;
import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.protocol.TTProtocol.ActiveDrivingMode;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.facebook.internal.NativeProtocol;
import com.google.protobuf.C3642c;
import java.util.Calendar;

public class DailyLogEditEventAnnotationActivity extends DailyLogEventBaseActivity {
    private static final String aa = DailyLogEditEventAnnotationActivity.class.getName();
    private static final String ab = (aa + ".drivingMode");
    private Event ac;
    private ActiveDrivingMode ad;

    class C13651 implements OnClickListener {
        final /* synthetic */ DailyLogEditEventAnnotationActivity f4631a;

        C13651(DailyLogEditEventAnnotationActivity dailyLogEditEventAnnotationActivity) {
            this.f4631a = dailyLogEditEventAnnotationActivity;
        }

        public void onClick(View view) {
            this.f4631a.aa();
        }
    }

    class C13662 implements OnClickListener {
        final /* synthetic */ DailyLogEditEventAnnotationActivity f4632a;

        C13662(DailyLogEditEventAnnotationActivity dailyLogEditEventAnnotationActivity) {
            this.f4632a = dailyLogEditEventAnnotationActivity;
        }

        public void onClick(View view) {
            this.f4632a.m7050Z();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.daily_log_edit);
        if (bundle != null) {
            this.ad = ActiveDrivingMode.m12378a(bundle.getInt(ab));
        }
        if (this.ad == null) {
            this.ad = ActiveDrivingMode.m12378a(getIntent().getIntExtra("com.bigroad.ttb.drivingMode", -1));
        }
        if (this.ad == null) {
            setResult(4);
            finish();
            return;
        }
        this.ac = Event.newBuilder().m13846a(C3642c.f13210a).m13843a(OurApplication.m6285g().m12202d()).m13859c(OurApplication.m6269Z().mo914b()).m13842a(36).m13864d((int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST).m13862c();
        m6988v();
        ac();
        ((Button) findViewById(R.id.dailyLogEdit_cancel)).setOnClickListener(new C13651(this));
        this.Q = (Button) findViewById(R.id.dailyLogEdit_done);
        this.Q.setOnClickListener(new C13662(this));
        findViewById(R.id.dailyLogEdit_locationGroup).setVisibility(8);
        findViewById(R.id.dailyLogEdit_delete).setVisibility(8);
        this.M.requestFocus();
        this.M.setNextFocusDownId(R.id.dailyLogEdit_done);
        FailReason o = mo975o();
        if (o != null) {
            setResult(o.m7160a());
            finish();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.ad != null) {
            bundle.putInt(ab, this.ad.m12379a());
        }
    }

    protected Calendar mo930f() {
        return m6943A();
    }

    protected boolean mo973g() {
        return true;
    }

    protected boolean mo932m() {
        return false;
    }

    protected boolean mo961i() {
        return true;
    }

    protected boolean mo967a(DutyStatus dutyStatus) {
        return false;
    }

    protected Event mo931l() {
        return this.ac;
    }

    public void mo966a(Calendar calendar) {
    }

    public void onBackPressed() {
        aa();
    }

    private void m7050Z() {
        ab();
    }

    private void aa() {
        this.g.m6188a(Reason.EOBR_SELECTED_DIALOG);
        finish();
    }

    protected void mo933n() {
    }

    private void ab() {
        this.d.m8374a(this.M, 5);
        m6984r();
        this.g.m6192a(this.ad, Reason.EOBR_SELECTED_DIALOG, DutyStatusChangeBits.Reason.EOBR_SELECTED_DIALOG, this.M.getText().toString());
        finish();
    }

    protected void mo969b(DutyStatus dutyStatus) {
    }

    protected boolean f_() {
        return true;
    }

    protected void mo978p() {
        this.P.setVisibility(8);
    }

    protected void mo976a(long j) {
        this.q.setVisibility(8);
        this.v.setVisibility(8);
        this.r.setVisibility(8);
    }

    private void ac() {
        if (this.ad == ActiveDrivingMode.PERSONAL_CONVEYANCE_MODE) {
            setTitle(getString(R.string.dailyLogEdit_editPersonalConveyanceEventTitle));
        } else {
            setTitle(getString(R.string.dailyLogEdit_editYardMoveEventTitle));
        }
    }
}
