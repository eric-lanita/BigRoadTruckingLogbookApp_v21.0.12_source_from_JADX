package com.bigroad.ttb.android.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import com.bigroad.shared.ac;
import com.bigroad.shared.duty.C0890f;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.DailyLogInspectInstructionActivity.CompleteInspectionDialogFragment;
import com.bigroad.ttb.android.activity.OurActivity.Feature;
import com.bigroad.ttb.android.adapter.C1670h;
import com.bigroad.ttb.android.event.EventManager;
import com.bigroad.ttb.android.fragment.DailyLogInspectHeader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class UnassignedDrivingInspectActivity extends OurActivity {
    private final EventManager f5558a = OurApplication.m6295q();
    private ListView f5559b;
    private List<C0890f> f5560c;
    private C1670h f5561d;

    class C16081 implements OnClickListener {
        final /* synthetic */ UnassignedDrivingInspectActivity f5557a;

        C16081(UnassignedDrivingInspectActivity unassignedDrivingInspectActivity) {
            this.f5557a = unassignedDrivingInspectActivity;
        }

        public void onClick(View view) {
            CompleteInspectionDialogFragment.m7265a(this.f5557a);
        }
    }

    public UnassignedDrivingInspectActivity() {
        super(Feature.FINISH_ON_SIGN_OUT);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.unassigned_driving_inspect);
        m6692K().setStatusMessageVisible(false);
        int intExtra = getIntent().getIntExtra("com.bigroad.ttb.logDayWithUnclaimedEvents", -1);
        ((Button) findViewById(R.id.unassignedDrivingInspect_endInspection)).setOnClickListener(new C16081(this));
        DailyLogInspectHeader.m10330a(getSupportFragmentManager(), getResources().getString(R.string.unassignedDrivingInspect_subtitle), intExtra);
        this.f5560c = new ArrayList();
        mo1028d(intExtra);
        this.f5561d = new C1670h(this, intExtra);
        this.f5561d.m7230a(this.f5560c, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), false);
        this.f5559b = (ListView) findViewById(R.id.unassignedEvent_list);
        this.f5559b.setAdapter(this.f5561d);
    }

    protected void onStart() {
        OurApplication.m6300v().m10901a(false);
        super.onStart();
    }

    public Locale d_() {
        return ac.f2617a;
    }

    public void mo1028d(int i) {
        for (C0890f c0890f : this.f5558a.m10026b(i)) {
            if (this.f5558a.m10020a(c0890f)) {
                this.f5560c.add(c0890f);
            }
        }
    }

    public boolean m7875a(C0890f c0890f) {
        return this.f5558a.m10041c(c0890f);
    }
}
