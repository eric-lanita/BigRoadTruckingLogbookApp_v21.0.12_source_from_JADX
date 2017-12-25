package com.bigroad.ttb.android.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.OurActivity.TitleStyle;
import com.bigroad.ttb.android.util.C2291k;
import com.bigroad.ttb.android.util.C2304w;

public class AboutActivity extends OurActivity {
    private TextView f4354a;
    private Button f4355b;

    public AboutActivity() {
        super(TitleStyle.NONE);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.about);
        this.f4354a = (TextView) findViewById(R.id.about_footerText);
        this.f4354a.setText(getString(R.string.about_footerText, new Object[]{C2291k.m11220a(this)}));
        this.f4355b = (Button) findViewById(R.id.about_supportButton);
        this.f4355b.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ AboutActivity f4322b;

            public void onClick(View view) {
                C2304w.m11272a(this, "TT-About");
            }
        });
    }
}
