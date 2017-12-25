package com.bigroad.ttb.android.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.bigroad.shared.InspectionTerm;
import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.OurActivity.Feature;
import com.bigroad.ttb.android.dialog.InspectionSendChooserDialogFragment;
import com.bigroad.ttb.android.dialog.InspectionSendChooserDialogFragment.C1423a;
import com.bigroad.ttb.android.dialog.InspectionSendChooserDialogFragment.InspectionOption;
import com.bigroad.ttb.android.vehicle.C2338a;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager.C1201a;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager.ChangeListener;
import com.bigroad.ttb.protocol.TTProtocol.DailyLogShareType;
import com.bigroad.ttb.protocol.TTProtocol.TruckLogType;

public class DailyLogInspectSelectionActivity extends LogDownloadTaskActivity implements C1423a {
    private final ChangeListener f4838a = new C14181(this);

    class C14181 extends C1201a {
        final /* synthetic */ DailyLogInspectSelectionActivity f4828a;

        C14181(DailyLogInspectSelectionActivity dailyLogInspectSelectionActivity) {
            this.f4828a = dailyLogInspectSelectionActivity;
        }

        public void mo888a(C2338a c2338a) {
            this.f4828a.m7271f();
        }
    }

    public DailyLogInspectSelectionActivity() {
        super(Feature.FINISH_ON_SIGN_OUT);
    }

    protected void onStart() {
        OurApplication.m6300v().m10901a(false);
        super.onStart();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.daily_log_inspect_selection);
        m6692K().setStatusMessageVisible(false);
        findViewById(R.id.dailyLogInspectSelect_scrollView).setVerticalFadingEdgeEnabled(true);
        final InspectionTerm a = InspectionTerm.m4084a(getIntent().getIntExtra("com.bigroad.ttb.inspectionTerm", -1));
        final TruckLogType a2 = TruckLogType.m15634a(getIntent().getIntExtra("com.bigroad.ttb.truckLogType", 0));
        Button button = (Button) findViewById(R.id.dailyLogInspectSelect_send);
        ((Button) findViewById(R.id.dailyLogInspectSelect_inspect)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ DailyLogInspectSelectionActivity f4831c;

            public void onClick(View view) {
                C1632a.m7951a(this.f4831c, a, a2);
                this.f4831c.setResult(7, null);
                this.f4831c.finish();
            }
        });
        button.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ DailyLogInspectSelectionActivity f4834c;

            public void onClick(View view) {
                new InspectionSendChooserDialogFragment().m8878a(this.f4834c, a, a2);
            }
        });
        ((Button) findViewById(R.id.dailyLogInspectSelect_fmcsa)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ DailyLogInspectSelectionActivity f4836b;

            public void onClick(View view) {
                new FmcsaSendChooserDialogFragment().m7600a(this.f4836b, a);
            }
        });
        OurApplication.m6252I().m11399a(this.f4838a);
        m7271f();
    }

    protected void onDestroy() {
        super.onDestroy();
        OurApplication.m6252I().m11404b(this.f4838a);
    }

    private void m7271f() {
        int i;
        int i2 = 0;
        TruckLogType a = TruckLogType.m15634a(getIntent().getIntExtra("com.bigroad.ttb.truckLogType", 0));
        int i3 = (a == TruckLogType.AOBRD || a == TruckLogType.ELD) ? 1 : 0;
        boolean e = OurApplication.m6254K().m11102e();
        View findViewById = findViewById(R.id.dailyLogInspectSelect_aobrdInstructions);
        if (i3 == 0 || e) {
            i = 8;
        } else {
            i = 0;
        }
        findViewById.setVisibility(i);
        View findViewById2 = findViewById(R.id.dailyLogInspectSelect_aobrdMalfunction);
        if (i3 == 0 || !e) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        findViewById2.setVisibility(i3);
        findViewById2 = findViewById(R.id.dailyLogInspectSelect_fmcsa);
        if (a == TruckLogType.ELD) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        findViewById2.setVisibility(i3);
        findViewById2 = findViewById(R.id.dailyLogInspectFmcsa_filler);
        if (a == TruckLogType.ELD) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        findViewById2.setVisibility(i3);
        View findViewById3 = findViewById(R.id.dailyLogInspect_fmcsaRow);
        if (a != TruckLogType.ELD) {
            i2 = 8;
        }
        findViewById3.setVisibility(i2);
        if (a != TruckLogType.ELD) {
            ((TextView) findViewById(R.id.dailyLogInspect_item4)).setText(R.string.numberedListItem_3);
        }
    }

    public void mo993a(InspectionOption inspectionOption, InspectionTerm inspectionTerm, TruckLogType truckLogType) {
        int a = DailyLogUtils.m4285a(OurApplication.m6285g().m12228r().m4868b());
        int a2 = a - (inspectionTerm.m4085a() - 1);
        switch (inspectionOption) {
            case PRINT:
                m6779a(a2, a);
                return;
            case SEND_EMAIL:
                C1632a.m7947a((Context) this, a2, a, DailyLogShareType.INSPECT_EMAIL_SHARE);
                return;
            case FAX:
                C1632a.m7946a((Context) this, a2, a);
                return;
            default:
                return;
        }
    }
}
