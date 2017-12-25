package com.bigroad.ttb.android.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bigroad.ttb.android.ClockMonitor;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.OurActivity.TitleStyle;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ClockSkewActivity extends OurActivity {
    private TextView f4428a;
    private TextView f4429b;
    private TextView f4430c;
    private TextView f4431d;
    private LinearLayout f4432e;
    private Button f4433f;
    private SimpleDateFormat f4434g;

    class C12971 implements OnClickListener {
        final /* synthetic */ ClockSkewActivity f4425a;

        C12971(ClockSkewActivity clockSkewActivity) {
            this.f4425a = clockSkewActivity;
        }

        public void onClick(View view) {
            C1632a.m8002k(this.f4425a);
            OurApplication.m6272a(this.f4425a).show();
        }
    }

    class C12982 implements OnClickListener {
        final /* synthetic */ ClockSkewActivity f4426a;

        C12982(ClockSkewActivity clockSkewActivity) {
            this.f4426a = clockSkewActivity;
        }

        public void onClick(View view) {
            this.f4426a.finish();
        }
    }

    class C12993 implements Runnable {
        final /* synthetic */ ClockSkewActivity f4427a;

        C12993(ClockSkewActivity clockSkewActivity) {
            this.f4427a = clockSkewActivity;
        }

        public void run() {
            this.f4427a.m6795f();
        }
    }

    private void m6795f() {
        int i = 8;
        this.f4428a.setText(this.f4434g.format(Calendar.getInstance().getTime()).replace("PM", "pm").replace("AM", "am"));
        this.f4429b.setText(this.f4434g.format(new Date(ClockMonitor.m6079a().m6102b())).replace("PM", "pm").replace("AM", "am"));
        int i2 = ClockMonitor.m6079a().m6104d() ? 0 : 8;
        if (!ClockMonitor.m6079a().m6104d()) {
            i = 0;
        }
        this.f4430c.setVisibility(i2);
        this.f4432e.setVisibility(i2);
        this.f4433f.setVisibility(i2);
        this.f4431d.setVisibility(i);
    }

    public ClockSkewActivity() {
        super(TitleStyle.DEFAULT);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.clock_skew);
        m6692K().setStatusMessageVisible(false);
        this.f4428a = (TextView) findViewById(R.id.clockSkew_deviceDateTime);
        this.f4429b = (TextView) findViewById(R.id.clockSkew_currentDateTime);
        this.f4430c = (TextView) findViewById(R.id.clockSkew_trueMessage);
        this.f4431d = (TextView) findViewById(R.id.clockSkew_falseMessage);
        this.f4432e = (LinearLayout) findViewById(R.id.clockSkew_trueLayout);
        this.f4433f = (Button) findViewById(R.id.clockSkew_fixDateTime);
        this.f4434g = new SimpleDateFormat("K:mma, E. MMM. d, yyyy zzz", Locale.CANADA);
        this.f4433f.setOnClickListener(new C12971(this));
        findViewById(R.id.clockSkew_done).setOnClickListener(new C12982(this));
        m6709a(0, 60000, new C12993(this));
    }

    protected void onResume() {
        super.onResume();
        m6795f();
    }
}
