package com.bigroad.ttb.android.activity;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.bigroad.shared.UserAuthenticationChangeBits.Reason;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.OurActivity.Feature;

public class EulaActivity extends OurActivity {
    private Button f5208a;
    private Button f5209b;
    private CheckBox f5210c;
    private TextView f5211d;
    private TextView f5212e;
    private TextView f5213f;

    class C15071 implements OnClickListener {
        final /* synthetic */ EulaActivity f5206a;

        C15071(EulaActivity eulaActivity) {
            this.f5206a = eulaActivity;
        }

        public void onClick(View view) {
            if (this.f5206a.f5210c.isChecked()) {
                OurApplication.m6289k().m6503h();
                this.f5206a.setResult(-1);
                this.f5206a.finish();
                return;
            }
            this.f5206a.f5213f.setVisibility(0);
        }
    }

    class C15082 implements OnClickListener {
        final /* synthetic */ EulaActivity f5207a;

        C15082(EulaActivity eulaActivity) {
            this.f5207a = eulaActivity;
        }

        public void onClick(View view) {
            OurApplication.m6289k().m6458a(Reason.EXPLICIT_SIGN_OUT);
            this.f5207a.setResult(2);
            this.f5207a.finish();
        }
    }

    public EulaActivity() {
        super(Feature.FINISH_ON_SIGN_OUT);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.eula);
        this.f5208a = (Button) findViewById(R.id.eula_acceptButton);
        this.f5209b = (Button) findViewById(R.id.eula_declineButton);
        this.f5210c = (CheckBox) findViewById(R.id.eula_checkbox);
        this.f5211d = (TextView) findViewById(R.id.eula_checkboxText);
        this.f5212e = (TextView) findViewById(R.id.eula_accessAgreement);
        this.f5213f = (TextView) findViewById(R.id.eula_uncheckMessage);
        this.f5211d.setMovementMethod(LinkMovementMethod.getInstance());
        this.f5211d.setText(Html.fromHtml(getString(R.string.eula_acceptText)));
        this.f5212e.setMovementMethod(LinkMovementMethod.getInstance());
        this.f5212e.setText(Html.fromHtml(getString(R.string.eula_accessText)));
        this.f5208a.setOnClickListener(new C15071(this));
        this.f5209b.setOnClickListener(new C15082(this));
    }
}
