package com.bigroad.ttb.android.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.bigroad.shared.DrivingModeChangeBits.Reason;
import com.bigroad.ttb.android.DrivingModeManager;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.vehicle.C2338a;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager.C1201a;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager.ChangeListener;
import com.bigroad.ttb.android.widget.C2468r;
import com.bigroad.ttb.android.widget.C2468r.C1303a;
import com.bigroad.ttb.protocol.TTProtocol.ActiveDrivingMode;
import com.bigroad.ttb.protocol.TTProtocol.MotionType;

public class ConfirmDrivingModeActivity extends OurActivity {
    private final DrivingModeManager f4440a = OurApplication.ah();
    private final VehicleConnectionManager f4441b = OurApplication.m6252I();
    private C2468r f4442c;
    private Button f4443d;
    private Button f4444e;
    private ActiveDrivingMode f4445f;
    private final ChangeListener f4446g = new C13001(this);

    class C13001 extends C1201a {
        final /* synthetic */ ConfirmDrivingModeActivity f4435a;

        C13001(ConfirmDrivingModeActivity confirmDrivingModeActivity) {
            this.f4435a = confirmDrivingModeActivity;
        }

        public void mo888a(C2338a c2338a) {
            this.f4435a.m6803f();
        }

        public void mo891a(MotionType motionType) {
            this.f4435a.m6803f();
        }
    }

    class C13012 implements OnClickListener {
        final /* synthetic */ ConfirmDrivingModeActivity f4436a;

        C13012(ConfirmDrivingModeActivity confirmDrivingModeActivity) {
            this.f4436a = confirmDrivingModeActivity;
        }

        public void onClick(View view) {
            this.f4436a.f4440a.m6191a(this.f4436a.f4445f, Reason.EOBR_SELECTED_DIALOG);
            this.f4436a.finish();
        }
    }

    class C13023 implements OnClickListener {
        final /* synthetic */ ConfirmDrivingModeActivity f4437a;

        C13023(ConfirmDrivingModeActivity confirmDrivingModeActivity) {
            this.f4437a = confirmDrivingModeActivity;
        }

        public void onClick(View view) {
            this.f4437a.f4440a.m6191a(null, Reason.EOBR_SELECTED_DIALOG);
            this.f4437a.finish();
        }
    }

    class C13044 implements C1303a {
        final /* synthetic */ ConfirmDrivingModeActivity f4438a;

        C13044(ConfirmDrivingModeActivity confirmDrivingModeActivity) {
            this.f4438a = confirmDrivingModeActivity;
        }

        public void mo947a() {
            this.f4438a.f4440a.m6191a(null, Reason.EOBR_SELECTED_DIALOG);
            this.f4438a.finish();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.confirm_driving_mode);
        this.f4445f = ActiveDrivingMode.m12378a(getIntent().getIntExtra("com.bigroad.ttb.drivingMode", -1));
        if (this.f4445f == null) {
            finish();
        }
        TextView textView = (TextView) findViewById(R.id.confirmMode_title);
        TextView textView2 = (TextView) findViewById(R.id.confirmMode_message);
        this.f4442c = new C2468r(findViewById(R.id.confirmMode_content_wrapper));
        this.f4443d = (Button) findViewById(R.id.confirmMode_firstChoice);
        this.f4444e = (Button) findViewById(R.id.confirmMode_secondChoice);
        switch (this.f4445f) {
            case ELD_YARD_MOVE_MODE:
            case AOBRD_YARD_MOVE_MODE:
                setTitle(R.string.confirmYardMovePrompt_activityTitle);
                textView.setText(R.string.confirmYardMovePrompt_title);
                textView2.setText(R.string.confirmYardMovePrompt_explanation);
                this.f4443d.setText(R.string.confirmYardMovePrompt_continueButton);
                this.f4444e.setText(R.string.confirmYardMovePrompt_endButton);
                break;
            case PERSONAL_CONVEYANCE_MODE:
                break;
            default:
                finish();
                return;
        }
        this.f4443d.setOnClickListener(new C13012(this));
        this.f4444e.setOnClickListener(new C13023(this));
        this.f4442c.m12130a(new C13044(this));
    }

    public void onBackPressed() {
        this.f4440a.m6191a(null, Reason.EOBR_SELECTED_DIALOG);
        super.onBackPressed();
    }

    protected void onStart() {
        super.onStart();
        this.f4441b.m11399a(this.f4446g);
        this.f4442c.m12128a();
        int intExtra = getIntent().getIntExtra("com.bigroad.ttb.promptTimeout", 0);
        long d = this.f4440a.m6198d();
        int i = intExtra - ((int) (d / 1000));
        if (d < 1000) {
            finish();
        } else {
            this.f4442c.m12129a(intExtra, i);
        }
        m6803f();
    }

    protected void onStop() {
        this.f4442c.m12131b();
        this.f4441b.m11404b(this.f4446g);
        super.onStop();
    }

    private void m6803f() {
        if (!this.f4441b.m11411i() || this.f4441b.m11413k()) {
            this.f4440a.m6191a(null, Reason.EOBR_SELECTED_DIALOG);
            finish();
        }
    }
}
