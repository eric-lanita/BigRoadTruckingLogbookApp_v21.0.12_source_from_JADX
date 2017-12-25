package com.bigroad.ttb.android.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.bigroad.shared.InspectionTerm;
import com.bigroad.shared.ac;
import com.bigroad.shared.af;
import com.bigroad.shared.am;
import com.bigroad.shared.ar;
import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.shared.duty.C0874m;
import com.bigroad.shared.duty.C0898i;
import com.bigroad.shared.duty.C0956v;
import com.bigroad.shared.duty.DutyLimits;
import com.bigroad.shared.model.C1116d;
import com.bigroad.shared.model.C1116d.C1114a;
import com.bigroad.ttb.android.C2474y;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.DailyLogInspectInstructionActivity.CompleteInspectionDialogFragment;
import com.bigroad.ttb.android.activity.OurActivity.Feature;
import com.bigroad.ttb.android.activity.OurActivity.TitleStyle;
import com.bigroad.ttb.android.p029c.C1736b;
import com.bigroad.ttb.android.p029c.C1738c;
import com.bigroad.ttb.android.p029c.C1738c.C1737a;
import com.bigroad.ttb.android.util.C2303v;
import com.bigroad.ttb.android.vehicle.C2338a;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager.C1201a;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager.ChangeListener;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import com.bigroad.ttb.protocol.TTProtocol.TruckLogType;
import com.bigroad.ttb.protocol.TTProtocol.al;
import com.facebook.appevents.AppEventsConstants;
import java.util.Locale;
import java.util.TimeZone;

public class DailyLogInspectSummaryActivity extends OurActivity {
    private final C1736b f4841a = OurApplication.m6296r();
    private final C2474y f4842b = OurApplication.m6285g();
    private final ChangeListener f4843c = new C14241(this);

    class C14241 extends C1201a {
        final /* synthetic */ DailyLogInspectSummaryActivity f4839a;

        C14241(DailyLogInspectSummaryActivity dailyLogInspectSummaryActivity) {
            this.f4839a = dailyLogInspectSummaryActivity;
        }

        public void mo888a(C2338a c2338a) {
            this.f4839a.m7276f();
        }
    }

    class C14252 implements OnClickListener {
        final /* synthetic */ DailyLogInspectSummaryActivity f4840a;

        C14252(DailyLogInspectSummaryActivity dailyLogInspectSummaryActivity) {
            this.f4840a = dailyLogInspectSummaryActivity;
        }

        public void onClick(View view) {
            CompleteInspectionDialogFragment.m7265a(this.f4840a);
        }
    }

    public DailyLogInspectSummaryActivity() {
        super(Feature.FINISH_ON_SIGN_OUT, TitleStyle.NONE);
    }

    protected void onStart() {
        OurApplication.m6300v().m10901a(false);
        super.onStart();
    }

    public Locale d_() {
        return ac.f2617a;
    }

    public void onCreate(Bundle bundle) {
        Object obj;
        super.onCreate(bundle);
        setContentView((int) R.layout.daily_log_inspect_summary);
        findViewById(R.id.dailyLogInspectSummary_scrollView).setVerticalFadingEdgeEnabled(true);
        int intExtra = getIntent().getIntExtra("com.bigroad.ttb.inspectionTerm", -1);
        InspectionTerm inspectionTerm = (intExtra < 0 || intExtra >= InspectionTerm.values().length) ? InspectionTerm.SEVEN_DAYS : InspectionTerm.values()[intExtra];
        if (inspectionTerm == InspectionTerm.FOURTEEN_DAYS) {
            obj = 1;
        } else {
            obj = null;
        }
        int a = DailyLogUtils.m4284a(this.f4842b.m12228r().m4879m());
        al f = this.f4841a.m8491f(a);
        if (f == null) {
            finish();
            return;
        }
        CharSequence a2;
        C0874m c0956v = new C0956v(f);
        TimeZone b = DailyLogUtils.m4305b((DailyLog) f);
        Truck f2 = OurApplication.m6294p().m6578f();
        if (f2 != null) {
            a2 = ar.m4235a(f2);
        } else {
            a2 = null;
        }
        long b2 = OurApplication.m6269Z().mo914b();
        C0898i c0898i = new C0898i(this.f4841a.m8493g(), OurApplication.m6295q().m10025b(), b2, this.f4842b.m12229s());
        C1737a a3 = C1738c.m8500a(c0898i, b2, a, b);
        C1116d a4 = C1114a.m5598a(f, OurApplication.af(), b2).m5635a();
        C2303v b3 = C2303v.m11257b(getResources().getDimensionPixelOffset(R.dimen.text_wrap_indent));
        TextView textView = (TextView) findViewById(R.id.dailyLogInspectSummary_driver);
        if (am.m4188a(a4.m5660l())) {
            textView.setVisibility(8);
        } else {
            textView.setText(a4.m5660l());
        }
        textView = (TextView) findViewById(R.id.dailyLogInspectSummary_truckNumber);
        if (am.m4188a(a2)) {
            b3.m11267b(getResources().getString(R.string.dailyLogHeader_none));
        } else {
            b3.m11268c(a2);
        }
        textView.setText(b3.m11270e());
        ((TextView) findViewById(R.id.dailyLogInspectSummary_cycle)).setText(C1738c.m8505a(c0956v, (Context) this));
        ((TextView) findViewById(R.id.dailyLogInspectSummary_totalDriving)).setText(m7274a(a3.m8496a()));
        ((TextView) findViewById(R.id.dailyLogInspectSummary_totalDuty)).setText(b3.m11268c(m7274a(a3.m8497b())).m11260a(' ').m11268c(getString(R.string.dailyLogInspectSummary_includesDriving)).m11270e());
        ((TextView) findViewById(R.id.dailyLogInspectSummary_milesDriven)).setText(af.m4154a(Integer.toString(a4.m5671w() ? a4.m5670v().intValue() : 0), a4.m5673y() ? a4.m5672x().m5472b() : null));
        ((TextView) findViewById(R.id.dailyLogInspectSummary_onDuty7Days)).setText(b3.m11268c(m7274a(a3.m8498c())).m11260a(' ').m11268c(getString(R.string.dailyLogInspectSummary_includesToday)).m11270e());
        ((TextView) findViewById(R.id.dailyLogInspectSummary_onDuty8Days)).setText(b3.m11268c(m7274a(a3.m8499d())).m11260a(' ').m11268c(getString(R.string.dailyLogInspectSummary_includesToday)).m11270e());
        if (obj != null) {
            ((TextView) findViewById(R.id.dailyLogInspectSummary_header)).setText(getString(R.string.dailyLogInspectSummary_headerCanadaAobrd));
            DutyLimits a5 = DutyLimits.m4362a(c0956v.m4881o(), c0898i);
            ((TextView) findViewById(R.id.dailyLogInspectSummary_cycleDutyRemaining)).setText(m7274a(a5.m4368d().m4402b()));
            ((TextView) findViewById(R.id.dailyLogInspectSummary_cycleDutyUsed)).setText(m7274a(a5.m4368d().m4403c() - a5.m4368d().m4402b()));
        } else {
            findViewById(R.id.dailyLogInspectSummary_cycleDutyRemainingLabel).setVisibility(8);
            findViewById(R.id.dailyLogInspectSummary_cycleDutyUsedLabel).setVisibility(8);
            findViewById(R.id.dailyLogInspectSummary_cycleDutyRemaining).setVisibility(8);
            findViewById(R.id.dailyLogInspectSummary_cycleDutyUsed).setVisibility(8);
        }
        ((Button) findViewById(R.id.dailyLogEndInspectionButton_endInspection)).setOnClickListener(new C14252(this));
        OurApplication.m6252I().m11399a(this.f4843c);
        m7276f();
    }

    protected void onDestroy() {
        super.onDestroy();
        OurApplication.m6252I().m11404b(this.f4843c);
    }

    private void m7276f() {
        int i = 0;
        TruckLogType a = TruckLogType.m15634a(getIntent().getIntExtra("com.bigroad.ttb.truckLogType", 0));
        int i2 = (a == TruckLogType.AOBRD || a == TruckLogType.ELD) ? 1 : 0;
        boolean e = OurApplication.m6254K().m11102e();
        View findViewById = findViewById(R.id.dailyLogInspectSummary_aobrdMalfunction);
        if (i2 == 0 || !e) {
            i = 8;
        }
        findViewById.setVisibility(i);
    }

    private String m7274a(long j) {
        if (j <= 0) {
            return AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        return com.bigroad.ttb.android.util.ac.m11175a(j, getResources());
    }
}
