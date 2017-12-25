package com.bigroad.ttb.android.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.C0586c.C0584a;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.bigroad.shared.InspectionTerm;
import com.bigroad.shared.ac;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.OurActivity.Feature;
import com.bigroad.ttb.android.activity.OurActivity.TitleStyle;
import com.bigroad.ttb.android.dialog.C1843a;
import com.bigroad.ttb.android.vehicle.C2338a;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager.C1201a;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager.ChangeListener;
import com.bigroad.ttb.protocol.TTProtocol.TruckLogType;
import java.util.Locale;

public class DailyLogInspectInstructionActivity extends OurActivity {
    private static final String f4825b = (DailyLogInspectActivity.class.getName() + ".dismissedBeginDialog");
    private boolean f4826a;
    private final ChangeListener f4827c = new C14111(this);

    class C14111 extends C1201a {
        final /* synthetic */ DailyLogInspectInstructionActivity f4812a;

        C14111(DailyLogInspectInstructionActivity dailyLogInspectInstructionActivity) {
            this.f4812a = dailyLogInspectInstructionActivity;
        }

        public void mo888a(C2338a c2338a) {
            this.f4812a.m7267f();
        }
    }

    class C14144 implements OnClickListener {
        final /* synthetic */ DailyLogInspectInstructionActivity f4819a;

        C14144(DailyLogInspectInstructionActivity dailyLogInspectInstructionActivity) {
            this.f4819a = dailyLogInspectInstructionActivity;
        }

        public void onClick(View view) {
            C1632a.m7996h(this.f4819a);
        }
    }

    class C14166 implements OnClickListener {
        final /* synthetic */ DailyLogInspectInstructionActivity f4823a;

        C14166(DailyLogInspectInstructionActivity dailyLogInspectInstructionActivity) {
            this.f4823a = dailyLogInspectInstructionActivity;
        }

        public void onClick(View view) {
            C1632a.m8013q(this.f4823a);
        }
    }

    public static class BeginInspectionDialogFragment extends DialogFragment {
        public static void m7264a(OurActivity ourActivity) {
            new BeginInspectionDialogFragment().show(ourActivity.getSupportFragmentManager(), "beginInspectDialog");
        }

        public Dialog onCreateDialog(Bundle bundle) {
            return new C0584a(getActivity()).m2678c(OurActivity.m6669a((int) R.attr.dialogIconInfo, getActivity())).m2659a((int) R.string.dailyLogInspect_beginDialogTitle).m2672b((int) R.string.dailyLogInspect_beginDialogMessage).m2661a((int) R.string.dailyLogInspect_beginDialogContinue, C1843a.f6286a).m2677b();
        }
    }

    public static class CompleteInspectionDialogFragment extends DialogFragment {

        class C14171 implements DialogInterface.OnClickListener {
            final /* synthetic */ CompleteInspectionDialogFragment f4824a;

            C14171(CompleteInspectionDialogFragment completeInspectionDialogFragment) {
                this.f4824a = completeInspectionDialogFragment;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                if (this.f4824a.getActivity() == null) {
                    dialogInterface.dismiss();
                } else {
                    C1632a.m7966b(this.f4824a.getActivity());
                }
            }
        }

        public static void m7265a(OurActivity ourActivity) {
            new CompleteInspectionDialogFragment().show(ourActivity.getSupportFragmentManager(), "completeInspectDialog");
        }

        public Dialog onCreateDialog(Bundle bundle) {
            return new C0584a(getActivity()).m2678c(OurActivity.m6669a((int) R.attr.dialogIconAlert, getActivity())).m2659a((int) R.string.dailyLogInspect_completeDialogTitle).m2672b((int) R.string.dailyLogInspect_completeDialogMessage).m2661a((int) R.string.dailyLogInspect_completeDialogDone, new C14171(this)).m2673b((int) R.string.dailyLogInspect_completeDialogCancel, C1843a.f6286a).m2670a(true).m2677b();
        }
    }

    public DailyLogInspectInstructionActivity() {
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
        super.onCreate(bundle);
        setContentView((int) R.layout.daily_log_inspect_instructions);
        findViewById(R.id.dailyLogInspectInstruction_scrollView).setVerticalFadingEdgeEnabled(true);
        int intExtra = getIntent().getIntExtra("com.bigroad.ttb.inspectionTerm", -1);
        final InspectionTerm inspectionTerm = (intExtra < 0 || intExtra >= InspectionTerm.values().length) ? InspectionTerm.SEVEN_DAYS : InspectionTerm.values()[intExtra];
        final TruckLogType a = TruckLogType.m15634a(getIntent().getIntExtra("com.bigroad.ttb.truckLogType", TruckLogType.UNKNOWN_LOG_TYPE.m15635a()));
        Button button = (Button) findViewById(R.id.dailyLogInspectInstruction_logs);
        TextView textView = (TextView) findViewById(R.id.dailyLogInspectInstruction_userManualTextView);
        ((Button) findViewById(R.id.dailyLogInspectInstruction_summary)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ DailyLogInspectInstructionActivity f4815c;

            public void onClick(View view) {
                C1632a.m7973b(this.f4815c, inspectionTerm, a);
            }
        });
        button.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ DailyLogInspectInstructionActivity f4818c;

            public void onClick(View view) {
                C1632a.m7983c(this.f4818c, inspectionTerm, a);
            }
        });
        ((Button) findViewById(R.id.dailyLogInspectInstruction_currentHeader)).setOnClickListener(new C14144(this));
        ((Button) findViewById(R.id.dailyLogInspectInstruction_inspectionLogs)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ DailyLogInspectInstructionActivity f4822c;

            public void onClick(View view) {
                C1632a.m7983c(this.f4822c, inspectionTerm, a);
            }
        });
        OurApplication.m6252I().m11399a(this.f4827c);
        m7267f();
        boolean z = bundle != null && bundle.getBoolean(f4825b);
        this.f4826a = z;
        if (!this.f4826a) {
            BeginInspectionDialogFragment.m7264a(this);
            this.f4826a = true;
        }
        textView.setClickable(true);
        textView.setPaintFlags(8);
        textView.setOnClickListener(new C14166(this));
    }

    private void m7267f() {
        int i;
        int i2;
        int i3 = 1;
        int i4 = 0;
        TruckLogType a = TruckLogType.m15634a(getIntent().getIntExtra("com.bigroad.ttb.truckLogType", TruckLogType.UNKNOWN_LOG_TYPE.m15635a()));
        int i5 = (a == TruckLogType.AOBRD || a == TruckLogType.ELD) ? 1 : 0;
        if (a == TruckLogType.AOBRD) {
            i = 1;
        } else {
            i = 0;
        }
        if (a != TruckLogType.ELD) {
            i3 = 0;
        }
        boolean e = OurApplication.m6254K().m11102e();
        View findViewById = findViewById(R.id.dailyLogInspectInstruction_dashLinkGoodIcon);
        if (i5 == 0 || e) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        findViewById.setVisibility(i2);
        View findViewById2 = findViewById(R.id.dailyLogInspectInstruction_dashLinkBadIcon);
        if (i5 == 0 || !e) {
            i5 = 8;
        } else {
            i5 = 0;
        }
        findViewById2.setVisibility(i5);
        findViewById2 = findViewById(R.id.dailyLogInspectInstruction_aobrdGood);
        if (i == 0 || e) {
            i5 = 8;
        } else {
            i5 = 0;
        }
        findViewById2.setVisibility(i5);
        findViewById2 = findViewById(R.id.dailyLogInspectInstruction_aobrdMalfunction);
        if (i == 0 || !e) {
            i5 = 8;
        } else {
            i5 = 0;
        }
        findViewById2.setVisibility(i5);
        findViewById2 = findViewById(R.id.dailyLogInspectInstruction_malfunctionText);
        if (i == 0 || !e) {
            i5 = 8;
        } else {
            i5 = 0;
        }
        findViewById2.setVisibility(i5);
        View findViewById3 = findViewById(R.id.dailyLogInspectInstruction_eldGood);
        if (i3 == 0 || e) {
            i5 = 8;
        } else {
            i5 = 0;
        }
        findViewById3.setVisibility(i5);
        findViewById3 = findViewById(R.id.dailyLogInspectInstruction_eldMalfunction);
        if (i3 == 0 || !e) {
            i5 = 8;
        } else {
            i5 = 0;
        }
        findViewById3.setVisibility(i5);
        findViewById3 = findViewById(R.id.dailyLogInspectInstruction_eldMalfunctionText);
        if (i3 == 0 || !e) {
            i5 = 8;
        } else {
            i5 = 0;
        }
        findViewById3.setVisibility(i5);
        findViewById3 = findViewById(R.id.dailyLogInspectInstructionUsageText);
        if (i3 == 0) {
            i5 = 0;
        } else {
            i5 = 8;
        }
        findViewById3.setVisibility(i5);
        findViewById3 = findViewById(R.id.dailyLogInspectInstruction_instructionsTextAobrd);
        if (i3 == 0) {
            i5 = 0;
        } else {
            i5 = 8;
        }
        findViewById3.setVisibility(i5);
        findViewById3 = findViewById(R.id.dailyLogInspectInstructionUsageText_eld);
        if (i3 != 0) {
            i5 = 0;
        } else {
            i5 = 8;
        }
        findViewById3.setVisibility(i5);
        findViewById3 = findViewById(R.id.dailyLogInspectInstruction_summary);
        if (i3 == 0) {
            i5 = 0;
        } else {
            i5 = 8;
        }
        findViewById3.setVisibility(i5);
        findViewById3 = findViewById(R.id.dailyLogInspectInstruction_logs);
        if (i3 == 0) {
            i5 = 0;
        } else {
            i5 = 8;
        }
        findViewById3.setVisibility(i5);
        findViewById3 = findViewById(R.id.dailyLogInspectInstruction_currentHeader);
        if (i3 != 0) {
            i5 = 0;
        } else {
            i5 = 8;
        }
        findViewById3.setVisibility(i5);
        findViewById3 = findViewById(R.id.dailyLogInspectInstruction_userManualTextView);
        if (i3 != 0) {
            i5 = 0;
        } else {
            i5 = 8;
        }
        findViewById3.setVisibility(i5);
        View findViewById4 = findViewById(R.id.dailyLogInspectInstruction_inspectionLogs);
        if (i3 == 0) {
            i4 = 8;
        }
        findViewById4.setVisibility(i4);
    }

    protected void onDestroy() {
        super.onDestroy();
        OurApplication.m6252I().m11404b(this.f4827c);
    }

    public void onBackPressed() {
        CompleteInspectionDialogFragment.m7265a(this);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(f4825b, this.f4826a);
    }
}
