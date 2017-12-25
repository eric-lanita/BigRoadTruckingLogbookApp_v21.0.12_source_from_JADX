package com.bigroad.ttb.android.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.bigroad.shared.am;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.OurActivity.Feature;
import com.bigroad.ttb.android.p029c.C1738c;
import com.bigroad.ttb.android.util.C1408t;
import com.bigroad.ttb.android.util.ac;

public class RejectCarrierEditActivity extends OurKeyboardActivity {
    private Button f5429a;
    private TextView f5430b;
    private EditText f5431c;
    private long f5432d;

    class C15601 implements OnClickListener {
        final /* synthetic */ RejectCarrierEditActivity f5427a;

        C15601(RejectCarrierEditActivity rejectCarrierEditActivity) {
            this.f5427a = rejectCarrierEditActivity;
        }

        public void onClick(View view) {
            if (!am.m4188a(this.f5427a.f5431c.getText())) {
                OurApplication.ae().m10533a(this.f5427a.f5432d, this.f5427a.f5431c.getText().toString());
                this.f5427a.setResult(-1);
                this.f5427a.finish();
            }
        }
    }

    class C15612 extends C1408t {
        final /* synthetic */ RejectCarrierEditActivity f5428a;

        C15612(RejectCarrierEditActivity rejectCarrierEditActivity) {
            this.f5428a = rejectCarrierEditActivity;
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.f5428a.m7776a(charSequence);
        }
    }

    public RejectCarrierEditActivity() {
        super(Feature.FINISH_ON_SIGN_OUT);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5432d = OurApplication.ae().m10537b(getIntent().getIntExtra("com.bigroad.ttb.logDay", -1));
        setContentView((int) R.layout.reject_carrier_edit);
        setTitle(getString(R.string.rejectCorrection_title, new Object[]{C1738c.m8514c(r0)}));
        this.f5429a = (Button) findViewById(R.id.rejectCorrection_doneButton);
        this.f5430b = (TextView) findViewById(R.id.rejectCorrection_commentCounter);
        this.f5431c = (EditText) findViewById(R.id.rejectCorrection_comment);
        ac.m11180a(this.f5431c, 60);
        this.f5429a.setOnClickListener(new C15601(this));
        this.f5431c.addTextChangedListener(new C15612(this));
        m7776a((CharSequence) "");
    }

    private void m7776a(CharSequence charSequence) {
        boolean z;
        int length = charSequence == null ? 0 : charSequence.length();
        Button button = this.f5429a;
        if (length != 0) {
            z = true;
        } else {
            z = false;
        }
        button.setClickable(z);
        button = this.f5429a;
        if (length != 0) {
            z = true;
        } else {
            z = false;
        }
        button.setEnabled(z);
        this.f5430b.setText(getString(R.string.rejectCorrection_commentCounter, new Object[]{Integer.valueOf(length), Integer.valueOf(60)}));
    }

    protected TextView mo930f() {
        return this.f5431c;
    }
}
