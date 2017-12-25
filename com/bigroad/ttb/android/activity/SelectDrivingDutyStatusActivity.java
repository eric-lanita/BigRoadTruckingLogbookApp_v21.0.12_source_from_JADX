package com.bigroad.ttb.android.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.bigroad.shared.C1142r;
import com.bigroad.shared.DrivingModeChangeBits;
import com.bigroad.shared.DutyStatusChangeBits;
import com.bigroad.shared.DutyStatusChangeBits.Reason;
import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.TruckManager;
import com.bigroad.ttb.android.event.EventManager;
import com.bigroad.ttb.android.event.EventManager.C1199e;
import com.bigroad.ttb.android.event.EventManager.ChangeListener;
import com.bigroad.ttb.android.widget.C2468r;
import com.bigroad.ttb.android.widget.C2468r.C1303a;
import com.bigroad.ttb.protocol.TTProtocol.ActiveDrivingMode;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.Event.C2647a;
import com.bigroad.ttb.protocol.TTProtocol.Truck;

public class SelectDrivingDutyStatusActivity extends OurActivity {
    private final EventManager f5437a = OurApplication.m6295q();
    private final TruckManager f5438b = OurApplication.m6294p();
    private C2468r f5439c;
    private Button f5440d;
    private Button f5441e;
    private Event f5442f;
    private final ChangeListener f5443g = new C15621(this);

    class C15621 extends C1199e {
        final /* synthetic */ SelectDrivingDutyStatusActivity f5433a;

        C15621(SelectDrivingDutyStatusActivity selectDrivingDutyStatusActivity) {
            this.f5433a = selectDrivingDutyStatusActivity;
        }

        public void mo884a(EventManager eventManager, boolean z) {
            this.f5433a.m7787f();
        }
    }

    class C15632 implements OnClickListener {
        final /* synthetic */ SelectDrivingDutyStatusActivity f5434a;

        C15632(SelectDrivingDutyStatusActivity selectDrivingDutyStatusActivity) {
            this.f5434a = selectDrivingDutyStatusActivity;
        }

        public void onClick(View view) {
            this.f5434a.m7785b(Reason.EOBR_SELECTED_DIALOG, DrivingModeChangeBits.Reason.EOBR_SELECTED_DIALOG);
        }
    }

    class C15643 implements OnClickListener {
        final /* synthetic */ SelectDrivingDutyStatusActivity f5435a;

        C15643(SelectDrivingDutyStatusActivity selectDrivingDutyStatusActivity) {
            this.f5435a = selectDrivingDutyStatusActivity;
        }

        public void onClick(View view) {
            this.f5435a.m7781a(Reason.EOBR_SELECTED_DIALOG, DrivingModeChangeBits.Reason.EOBR_SELECTED_DIALOG);
            this.f5435a.finish();
        }
    }

    class C15654 implements C1303a {
        final /* synthetic */ SelectDrivingDutyStatusActivity f5436a;

        C15654(SelectDrivingDutyStatusActivity selectDrivingDutyStatusActivity) {
            this.f5436a = selectDrivingDutyStatusActivity;
        }

        public void mo947a() {
            this.f5436a.m7785b(Reason.EOBR_AUTO_DIALOG, DrivingModeChangeBits.Reason.EOBR_AUTO_DIALOG);
        }
    }

    protected void onCreate(Bundle bundle) {
        Truck truck;
        super.onCreate(bundle);
        setContentView((int) R.layout.select_driving_duty_status);
        this.f5442f = this.f5437a.m10005a(getIntent().getByteArrayExtra("com.bigroad.ttb.eventId"));
        if (this.f5442f == null || !this.f5442f.hasTruckId()) {
            truck = null;
        } else {
            truck = this.f5438b.m6552a(this.f5442f.getTruckId());
        }
        if (truck == null) {
            finish();
            return;
        }
        m7787f();
        ((TextView) findViewById(R.id.offDutyDriving_message)).setText(getString(R.string.selectDrivingDutyStatus_explanation, new Object[]{truck.getTruckNumber()}));
        this.f5439c = new C2468r(findViewById(R.id.offDutyDriving_content_wrapper));
        this.f5441e = (Button) findViewById(R.id.offDutyDriving_firstChoice);
        this.f5440d = (Button) findViewById(R.id.offDutyDriving_secondChoice);
        this.f5441e.setOnClickListener(new C15632(this));
        this.f5440d.setOnClickListener(new C15643(this));
        this.f5439c.m12130a(new C15654(this));
    }

    public void onBackPressed() {
        m7785b(Reason.EOBR_SELECTED_DIALOG, DrivingModeChangeBits.Reason.EOBR_SELECTED_DIALOG);
        super.onBackPressed();
    }

    protected void onStart() {
        super.onStart();
        this.f5437a.m10012a(this.f5443g);
        m7787f();
        this.f5439c.m12128a();
    }

    protected void onStop() {
        this.f5439c.m12131b();
        this.f5437a.m10029b(this.f5443g);
        super.onStop();
    }

    private void m7787f() {
        Event h = this.f5437a.m10056h();
        if (this.f5442f == null || h == null || !this.f5442f.getEventId().equals(h.getEventId()) || h.getEventType() != DutyStatus.DRIVING.m4394b()) {
            this.f5442f = null;
            finish();
            return;
        }
        this.f5442f = h;
    }

    private void m7781a(Reason reason, DrivingModeChangeBits.Reason reason2) {
        m7782a(reason, reason2, false);
    }

    private void m7785b(Reason reason, DrivingModeChangeBits.Reason reason2) {
        m7782a(reason, reason2, true);
    }

    private void m7782a(Reason reason, DrivingModeChangeBits.Reason reason2, boolean z) {
        OurApplication.ah().m6193a(z ? ActiveDrivingMode.NORMAL_DRIVING_MODE : ActiveDrivingMode.PERSONAL_CONVEYANCE_MODE, reason2, null);
        if (this.f5442f != null) {
            C2647a g = Event.newBuilder(this.f5442f).m13879g((this.f5442f.getContextualData() & -32) | DutyStatusChangeBits.m4033a(reason));
            if (!z) {
                g.m13842a(DutyStatus.OFF_DUTY_DRIVING.m4394b());
            }
            Event c = g.m13862c();
            this.f5437a.m10028b(new C1142r().m5746a(c), c.getOccurredAt());
        }
        finish();
    }
}
