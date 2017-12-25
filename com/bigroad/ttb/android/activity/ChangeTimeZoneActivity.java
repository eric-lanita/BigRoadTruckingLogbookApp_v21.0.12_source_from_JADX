package com.bigroad.ttb.android.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.adapter.C1693q;
import com.bigroad.ttb.android.af;
import com.bigroad.ttb.android.util.C2292l;
import com.bigroad.ttb.android.widget.OurSpinner;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import com.bigroad.ttb.protocol.TTProtocol.Fleet;
import com.bigroad.ttb.protocol.TTProtocol.Person;

public class ChangeTimeZoneActivity extends OurActivity {
    private C1693q f4398a;
    private OurSpinner f4399b;
    private int f4400c;
    private DailyLog f4401d = null;

    class C12841 implements OnClickListener {
        final /* synthetic */ ChangeTimeZoneActivity f4397a;

        C12841(ChangeTimeZoneActivity changeTimeZoneActivity) {
            this.f4397a = changeTimeZoneActivity;
        }

        public void onClick(View view) {
            this.f4397a.m6756f();
        }
    }

    protected void onCreate(Bundle bundle) {
        String timezoneId;
        super.onCreate(bundle);
        setContentView((int) R.layout.change_timezone);
        TextView textView = (TextView) findViewById(R.id.changeTimeZone_fleetTitle);
        TextView textView2 = (TextView) findViewById(R.id.changeTimeZone_fleetTimeZone);
        Fleet a = OurApplication.m6292n().m11007a(m6699R().m12213g());
        if (a == null) {
            textView.setVisibility(8);
            textView2.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView2.setVisibility(0);
            textView2.setText(af.m8282a(a.getTimezone(), (Context) this));
        }
        this.f4399b = (OurSpinner) findViewById(R.id.changeTimeZone_spinner);
        this.f4398a = new C1693q(this);
        this.f4399b.setAdapter(this.f4398a);
        this.f4400c = getIntent().getIntExtra("com.bigroad.ttb.logDay", -1);
        if (this.f4400c >= 0) {
            this.f4401d = OurApplication.m6296r().m8491f(this.f4400c);
        }
        if (this.f4401d != null) {
            timezoneId = this.f4401d.getTimezoneId();
        } else {
            timezoneId = m6699R().m12222l().getHosHomeTimezoneId();
        }
        int a2 = this.f4398a.m8260a(timezoneId);
        if (a2 >= 0) {
            this.f4399b.setSelection(a2);
        }
        findViewById(R.id.changeTimeZone_saveButton).setOnClickListener(new C12841(this));
    }

    public void onBackPressed() {
        m6756f();
    }

    private void m6756f() {
        String id = this.f4398a.m8261a(this.f4399b.getSelectedItemPosition()).getID();
        if (this.f4400c < 0 && !id.equals(m6699R().m12222l().getHosHomeTimezoneId())) {
            OurApplication.m6289k().m6473a(Person.newBuilder().m14718a(m6699R().m12222l().getPersonId()).m14731c("").m14740e(id).m14733c());
        } else if (!(this.f4401d == null || C2292l.m11231a(this.f4401d) || id.equals(this.f4401d.getTimezoneId()))) {
            OurApplication.m6296r().m8484b(DailyLog.newBuilder(this.f4401d).m13053a(id).m13069c());
        }
        setResult(-1);
        finish();
    }
}
