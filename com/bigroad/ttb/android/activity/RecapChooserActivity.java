package com.bigroad.ttb.android.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import com.bigroad.shared.ak;
import com.bigroad.shared.ap;
import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.shared.duty.C0954t;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.OurActivity.Feature;
import com.bigroad.ttb.android.util.C2300s;
import com.bigroad.ttb.android.widget.RecapTable;
import com.bigroad.ttb.android.widget.RecapTable.Style;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import com.bigroad.ttb.protocol.TTProtocol.RecapType;

public class RecapChooserActivity extends OurActivity {
    private final ap f5420a = OurApplication.m6269Z();
    private RadioGroup f5421b;
    private TextView f5422c;
    private RecapTable f5423d;
    private Button f5424e;
    private RecapType f5425f;
    private DailyLog f5426g;

    class C15571 implements OnCheckedChangeListener {
        final /* synthetic */ RecapChooserActivity f5417a;

        C15571(RecapChooserActivity recapChooserActivity) {
            this.f5417a = recapChooserActivity;
        }

        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            this.f5417a.f5425f = this.f5417a.m7771h();
            this.f5417a.m7772i();
        }
    }

    class C15582 implements OnClickListener {
        final /* synthetic */ RecapChooserActivity f5418a;

        C15582(RecapChooserActivity recapChooserActivity) {
            this.f5418a = recapChooserActivity;
        }

        public void onClick(View view) {
            this.f5418a.m7773j();
        }
    }

    public RecapChooserActivity() {
        super(Feature.FINISH_ON_SIGN_OUT);
    }

    private int m7770f() {
        return getIntent().getIntExtra("com.bigroad.ttb.logDay", -1);
    }

    private RecapType m7771h() {
        switch (this.f5421b.getCheckedRadioButtonId()) {
            case R.id.recapChooser_noRecapButton:
                return RecapType.NO_RECAP;
            case R.id.recapChooser_summaryButton:
                return RecapType.SUMMARY;
            case R.id.recapChooser_fullButton:
                return RecapType.FULL;
            default:
                return RecapType.NO_RECAP;
        }
    }

    private void m7772i() {
        if (this.f5425f == RecapType.NO_RECAP) {
            this.f5422c.setVisibility(8);
            this.f5423d.setVisibility(8);
            return;
        }
        this.f5422c.setVisibility(0);
        this.f5423d.setVisibility(0);
        C0954t a = C2300s.m11249a(this.f5426g, this.f5420a.mo914b());
        this.f5423d.m12000a(this.f5425f, a.m4852b(), this.f5426g.getLogDay(), DailyLogUtils.m4305b(this.f5426g), ak.m4181a(a, getResources().getConfiguration().locale), Style.DARK);
    }

    private void m7773j() {
        DailyLog b = OurApplication.m6296r().m8480b(m7770f());
        if (b == null) {
            setResult(4);
            finish();
            return;
        }
        OurApplication.m6296r().m8484b(DailyLog.newBuilder(b).m13076e(m7771h().ordinal()).m13069c());
        setResult(-1);
        finish();
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.f5425f = m7771h();
        m7772i();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.recap_chooser);
        m6692K().setStatusMessageVisible(false);
        this.f5421b = (RadioGroup) findViewById(R.id.recapChooser_recapTypeGroup);
        this.f5422c = (TextView) findViewById(R.id.recapChooser_previewHeader);
        this.f5423d = (RecapTable) findViewById(R.id.recapChooser_recapTable);
        this.f5424e = (Button) findViewById(R.id.recapChooser_done);
        this.f5421b.setOnCheckedChangeListener(new C15571(this));
        this.f5424e.setOnClickListener(new C15582(this));
        int f = m7770f();
        this.f5426g = null;
        if (f > 0) {
            this.f5426g = OurApplication.m6296r().m8480b(f);
        }
        if (this.f5426g == null) {
            setResult(4);
            finish();
            return;
        }
        this.f5425f = RecapType.m14775a(this.f5426g.getRecapType());
        if (bundle == null) {
            switch (this.f5425f) {
                case NO_RECAP:
                    this.f5421b.check(R.id.recapChooser_noRecapButton);
                    break;
                case SUMMARY:
                    this.f5421b.check(R.id.recapChooser_summaryButton);
                    break;
                case FULL:
                    this.f5421b.check(R.id.recapChooser_fullButton);
                    break;
            }
            this.f5425f = m7771h();
            m7772i();
        }
    }

    public void onBackPressed() {
        m7773j();
    }
}
