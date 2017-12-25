package com.bigroad.ttb.android.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.C0586c.C0584a;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.bigroad.shared.UserAuthenticationChangeBits.Reason;
import com.bigroad.ttb.android.AuthMonitor;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.SyncManager;
import com.bigroad.ttb.android.SyncManager.C1239c;
import com.bigroad.ttb.android.TruckManager;
import com.bigroad.ttb.android.activity.OurActivity.Feature;
import com.bigroad.ttb.android.activity.SelectTruckActivity.Option;
import com.bigroad.ttb.android.ai;
import com.bigroad.ttb.android.dialog.C1845d;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.util.C2306y;
import com.bigroad.ttb.android.widget.C1267k;
import com.bigroad.ttb.android.widget.SignUpDataView;
import com.bigroad.ttb.protocol.TTProtocol.Fleet;
import com.bigroad.ttb.protocol.TTProtocol.Person;
import com.bigroad.ttb.protocol.TTProtocol.ResponseStatus;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.EnumSet;
import java.util.List;

public class SignUpActivity extends OurKeyboardActivity {
    private static final String f5540a = (SignUpActivity.class.getName() + ".userSignedInAlready");
    private SyncManager f5541b;
    private AuthMonitor f5542c;
    private TruckManager f5543d;
    private ai f5544e;
    private ScrollView f5545f;
    private TextView f5546g = null;
    private CheckBox f5547h;
    private TextView f5548i;
    private TextView f5549j;
    private View f5550k;
    private boolean f5551l;
    private SignUpDataView f5552m;
    private Button f5553n;
    private final OnClickListener f5554o = new C15991(this);
    private final OnEditorActionListener f5555p = new C16002(this);
    private final C1239c f5556q = new C16013(this);

    class C15991 implements OnClickListener {
        final /* synthetic */ SignUpActivity f5531a;

        C15991(SignUpActivity signUpActivity) {
            this.f5531a = signUpActivity;
        }

        public void onClick(View view) {
            this.f5531a.m7872h();
        }
    }

    class C16002 extends C1267k {
        final /* synthetic */ SignUpActivity f5532a;

        C16002(SignUpActivity signUpActivity) {
            this.f5532a = signUpActivity;
        }

        public boolean mo929a(TextView textView) {
            this.f5532a.f5553n.performClick();
            return true;
        }
    }

    class C16013 implements C1239c {
        final /* synthetic */ SignUpActivity f5533a;

        C16013(SignUpActivity signUpActivity) {
            this.f5533a = signUpActivity;
        }

        public void mo911a(ResponseStatus responseStatus, List<Fleet> list) {
            this.f5533a.f5541b.m6491b(this.f5533a.f5556q);
            this.f5533a.m6712b(0);
            switch (responseStatus) {
                case RS_SUCCESS:
                    this.f5533a.m7873i();
                    return;
                case RS_LOGIN_ALREADY_EXISTS:
                    this.f5533a.showDialog(1);
                    return;
                case RS_REQUEST_CANCELLED:
                    return;
                default:
                    C2134e.m10680d("TT-SignUpActivity", "unexpected createAccountWithEmail result: " + responseStatus);
                    return;
            }
        }
    }

    class C16024 implements OnCheckedChangeListener {
        final /* synthetic */ SignUpActivity f5534a;

        C16024(SignUpActivity signUpActivity) {
            this.f5534a = signUpActivity;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                this.f5534a.f5549j.setVisibility(8);
            }
        }
    }

    class C16035 implements OnCancelListener {
        final /* synthetic */ SignUpActivity f5535a;

        C16035(SignUpActivity signUpActivity) {
            this.f5535a = signUpActivity;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f5535a.f5541b.m6501f();
        }
    }

    class C16046 implements DialogInterface.OnClickListener {
        final /* synthetic */ SignUpActivity f5536a;

        C16046(SignUpActivity signUpActivity) {
            this.f5536a = signUpActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f5536a.m7863a(this.f5536a.f5552m.getEmailAddressField());
        }
    }

    class C16057 implements DialogInterface.OnClickListener {
        final /* synthetic */ SignUpActivity f5537a;

        C16057(SignUpActivity signUpActivity) {
            this.f5537a = signUpActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f5537a.m6699R().m12189a(this.f5537a.f5552m.getEmailAddress());
            C1632a.m7939a(this.f5537a, this.f5537a.f5552m.getEmailAddress());
            this.f5537a.finish();
        }
    }

    class C16068 implements DialogInterface.OnClickListener {
        final /* synthetic */ SignUpActivity f5538a;

        C16068(SignUpActivity signUpActivity) {
            this.f5538a = signUpActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f5538a.m7863a(this.f5538a.f5552m.getEmailAddressField());
        }
    }

    public SignUpActivity() {
        super(Feature.PORTRAIT_ONLY_ON_SMALL_DEVICES);
    }

    public TextView mo930f() {
        return this.f5546g;
    }

    private void m7863a(EditText editText) {
        if (editText != null) {
            editText.requestFocus();
            editText.setSelection(editText.length());
            this.f5546g = editText;
            mo931l();
        }
    }

    private void m7872h() {
        this.f5552m.m12030d();
        this.f5552m.m12026a();
        this.f5549j.setVisibility(this.f5547h.isChecked() ? 8 : 0);
        if (this.f5552m.m12029c()) {
            m7863a(this.f5552m.getFirstFieldWithWarning());
        } else if (this.f5549j.getVisibility() == 0) {
            this.f5545f.smoothScrollTo(0, this.f5550k.getTop());
        } else {
            this.f5541b.m6462a(this.f5556q);
            this.f5541b.m6485a(this.f5552m.getEmailAddress(), this.f5552m.getPassword(), this.f5552m.getFirstName(), this.f5552m.getLastName());
            showDialog(0);
        }
    }

    private void m7873i() {
        if (this.f5547h.isChecked()) {
            this.f5541b.m6503h();
        }
        m6700S().m6026a();
        if (!this.f5543d.m6566a() || this.f5551l) {
            m6700S().m6028b();
            setResult(-1);
            finish();
            return;
        }
        C1632a.m7977b((OurActivity) this, EnumSet.of(Option.ALLOW_UNKNOWN_TRUCK, Option.REQUIRE_TITLE));
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 26:
                if (i2 == -1) {
                    setResult(-1);
                    finish();
                    return;
                }
                this.f5541b.m6458a(Reason.SELECT_TRUCK_FAILED);
                return;
            default:
                if (!m6700S().m6030c()) {
                    setResult(-1);
                    finish();
                    return;
                }
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        Person parseFrom;
        super.onCreate(bundle);
        Person person = null;
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("com.bigroad.ttb.personRecord");
        if (byteArrayExtra != null) {
            try {
                parseFrom = Person.parseFrom(byteArrayExtra);
            } catch (InvalidProtocolBufferException e) {
                parseFrom = person;
            }
        } else {
            parseFrom = person;
        }
        setContentView((int) R.layout.sign_up);
        this.f5541b = OurApplication.m6289k();
        this.f5542c = OurApplication.m6249F();
        this.f5543d = OurApplication.m6294p();
        this.f5544e = OurApplication.m6256M();
        this.f5545f = (ScrollView) findViewById(R.id.signUp_scrollView);
        this.f5552m = (SignUpDataView) findViewById(R.id.signUp_dataEntry);
        this.f5553n = (Button) findViewById(R.id.signUp_button);
        this.f5547h = (CheckBox) findViewById(R.id.signUp_eulaCheckbox);
        this.f5548i = (TextView) findViewById(R.id.signUp_eulaCheckboxText);
        this.f5549j = (TextView) findViewById(R.id.signUp_eulaUncheckMessage);
        this.f5550k = findViewById(R.id.signUp_eulaCheckBar);
        this.f5553n.setOnClickListener(this.f5554o);
        this.f5552m.setPartialAccount(parseFrom);
        this.f5552m.getPasswordField().setOnEditorActionListener(this.f5555p);
        this.f5552m.getDevServerField().setOnEditorActionListener(this.f5555p);
        this.f5548i.setMovementMethod(LinkMovementMethod.getInstance());
        this.f5548i.setText(Html.fromHtml(getString(R.string.eula_acceptText)));
        this.f5547h.setOnCheckedChangeListener(new C16024(this));
        m6712b(0);
        if (bundle == null) {
            m7863a(this.f5552m.getFirstEmptyField());
            this.f5551l = this.f5542c.m6031d();
        } else {
            boolean z = bundle.getBoolean(f5540a) && this.f5542c.m6031d();
            this.f5551l = z;
        }
        if (C2306y.m11275b(m6699R().m12222l())) {
            m7873i();
        }
    }

    protected void onDestroy() {
        this.f5541b.m6491b(this.f5556q);
        super.onDestroy();
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(f5540a, this.f5551l);
    }

    protected Dialog onCreateDialog(int i) {
        switch (i) {
            case 0:
                Dialog c1845d = new C1845d(this, R.string.signUpDialog_creatingAccount);
                if (this.f5551l) {
                    return c1845d;
                }
                c1845d.setOnCancelListener(new C16035(this));
                return c1845d;
            case 1:
                if (this.f5551l) {
                    return new C0584a(this).m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.signOutSignUpDialog_emailAlreadyInUseTitle).m2672b((int) R.string.signOutSignUpDialog_emailAlreadyInUseMessage).m2661a(17039370, new C16046(this)).m2677b();
                }
                return new C0584a(this).m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.signUpDialog_emailAlreadyInUseTitle).m2672b((int) R.string.signUpDialog_emailAlreadyInUseMessage).m2673b((int) R.string.signUpDialog_useAnotherEmail, new C16068(this)).m2661a((int) R.string.signUpDialog_signInWithThisEmail, new C16057(this)).m2677b();
            default:
                return super.onCreateDialog(i);
        }
    }
}
