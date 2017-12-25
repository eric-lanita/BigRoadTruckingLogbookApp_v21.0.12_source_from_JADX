package com.bigroad.ttb.android.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.bigroad.shared.InspectionTerm;
import com.bigroad.shared.ac;
import com.bigroad.shared.am;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.DailyLogInspectInstructionActivity.CompleteInspectionDialogFragment;
import com.bigroad.ttb.android.adapter.C1669f;
import com.bigroad.ttb.android.p029c.C1736b;
import com.bigroad.ttb.android.p029c.C1740e;
import com.bigroad.ttb.android.status.p031a.C2260d;
import com.bigroad.ttb.android.util.C2286g;
import com.bigroad.ttb.protocol.TTProtocol.TruckLogType;
import com.p017a.p018a.p019a.C0816a;
import java.util.ArrayList;
import java.util.Locale;

public class DailyLogListInspectActivity extends OurActivity {
    private final C1736b f4880a = OurApplication.m6296r();
    private final C2260d f4881b = OurApplication.m6254K();
    private ListView f4882c;
    private C0816a f4883d;
    private C1669f f4884e;
    private C1669f f4885f;
    private TextView f4886g;
    private TextView f4887h;
    private TextView f4888i;
    private int f4889j;

    class C14382 implements OnClickListener {
        final /* synthetic */ DailyLogListInspectActivity f4879a;

        C14382(DailyLogListInspectActivity dailyLogListInspectActivity) {
            this.f4879a = dailyLogListInspectActivity;
        }

        public void onClick(View view) {
            CompleteInspectionDialogFragment.m7265a(this.f4879a);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.daily_log_list_inspect);
        m6692K().setStatusMessageVisible(false);
        final InspectionTerm inspectionTerm = (InspectionTerm) getIntent().getSerializableExtra("com.bigroad.ttb.inspectionTerm");
        this.f4889j = inspectionTerm.m4085a();
        final TruckLogType truckLogType = (TruckLogType) getIntent().getSerializableExtra("com.bigroad.ttb.truckLogType");
        this.f4883d = new C0816a();
        this.f4883d.m4026a(m7299d(R.layout.daily_log_list_inspect_title), true);
        this.f4884e = new C1669f(this, true);
        this.f4884e.m8190a(this.f4880a.m8492f(), this.f4889j);
        this.f4883d.m4027a(this.f4884e);
        if (truckLogType == TruckLogType.ELD && inspectionTerm == InspectionTerm.SEVEN_DAYS) {
            this.f4883d.m4026a(m7301f(), true);
            this.f4885f = new C1669f(this, new ArrayList(), true, true);
            this.f4885f.m8190a(this.f4880a.m8492f(), this.f4889j);
            if (this.f4885f.isEmpty()) {
                this.f4888i.setVisibility(0);
            } else {
                this.f4883d.m4027a(this.f4885f);
                this.f4888i.setVisibility(8);
            }
            this.f4883d.m4026a(m7299d(R.layout.daily_log_list_malfunction_diagnostic_inspect_title), true);
            this.f4883d.m4026a(m7302h(), true);
            this.f4883d.m4026a(m7300e(this.f4889j), true);
        }
        this.f4882c = (ListView) findViewById(R.id.dailyLogListInspect_listView);
        this.f4882c.setAdapter(this.f4883d);
        this.f4882c.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ DailyLogListInspectActivity f4878c;

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Object item = this.f4878c.f4883d.getItem(i);
                if (item != null) {
                    if (item instanceof C1740e) {
                        C1740e c1740e = (C1740e) item;
                        if (c1740e.m8533i()) {
                            C1632a.m7971b(this.f4878c, c1740e.m8525a());
                        } else {
                            C1632a.m7952a(this.f4878c, inspectionTerm, truckLogType, c1740e.m8525a());
                        }
                    } else if (item instanceof View) {
                        item = ((View) item).getTag();
                        if (item == null) {
                            return;
                        }
                        if (am.m4189a(item.toString(), "MALFUNCTION")) {
                            C1632a.m7950a(this.f4878c, inspectionTerm);
                        } else if (am.m4189a(item.toString(), "DIAGNOSTIC")) {
                            C1632a.m7972b(this.f4878c, inspectionTerm);
                        }
                    }
                }
            }
        });
        ((Button) findViewById(R.id.dailyLogListInspect_endInspection)).setOnClickListener(new C14382(this));
    }

    protected void onStart() {
        OurApplication.m6300v().m10901a(false);
        super.onStart();
    }

    public Locale d_() {
        return ac.f2617a;
    }

    private View m7299d(int i) {
        return getLayoutInflater().inflate(i, null);
    }

    private View m7301f() {
        View inflate = getLayoutInflater().inflate(R.layout.daily_log_list_unidentified_driving_inspect, null);
        this.f4888i = (TextView) inflate.findViewById(R.id.dailyLogListInspectUnidentifiedDriving_noneToDisplay);
        return inflate;
    }

    private View m7302h() {
        View inflate = getLayoutInflater().inflate(R.layout.daily_log_list_malfunction_inspect, null);
        this.f4886g = (TextView) inflate.findViewById(R.id.dailyLogListInspect_malfunction);
        this.f4886g.setText(getResources().getQuantityString(R.plurals.dailyLogListInspect_malfunctionText, this.f4881b.m11102e() ? 1 : 0, new Object[]{Integer.valueOf(this.f4881b.m11102e() ? 1 : 0)}));
        inflate.setTag("MALFUNCTION");
        return inflate;
    }

    private View m7300e(int i) {
        int i2;
        View inflate = getLayoutInflater().inflate(R.layout.daily_log_list_diagnostic_inspect, null);
        this.f4887h = (TextView) inflate.findViewById(R.id.dailyLogListInspect_diagnostic);
        if (C2286g.m11210a(OurApplication.ac(), i)) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        this.f4887h.setText(getResources().getQuantityString(R.plurals.dailyLogListInspect_diagnosticText, i2, new Object[]{Integer.valueOf(i2)}));
        inflate.setTag("DIAGNOSTIC");
        return inflate;
    }
}
