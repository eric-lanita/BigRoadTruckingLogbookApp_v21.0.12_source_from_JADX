package com.bigroad.ttb.android.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.C0586c.C0584a;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.bigroad.shared.UserAuthenticationChangeBits.Reason;
import com.bigroad.shared.ap;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.SyncManager;
import com.bigroad.ttb.android.SyncManager.C1239c;
import com.bigroad.ttb.android.activity.OurActivity.Feature;
import com.bigroad.ttb.android.dialog.C1845d;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.util.C2306y;
import com.bigroad.ttb.android.widget.C1267k;
import com.bigroad.ttb.android.widget.SignUpDataView;
import com.bigroad.ttb.android.widget.SignUpDataView.C1592a;
import com.bigroad.ttb.protocol.TTProtocol.Fleet;
import com.bigroad.ttb.protocol.TTProtocol.ResponseStatus;
import java.util.List;

public class SignOutSignUpActivity extends OurKeyboardActivity {
    Reason f5516a;
    private SyncManager f5517b;
    private ap f5518c;
    private TextView f5519d = null;
    private ScrollView f5520e;
    private SignUpDataView f5521f;
    private Button f5522g;
    private Button f5523h;
    private long f5524i;
    private final OnClickListener f5525j = new C15891(this);
    private final OnClickListener f5526k = new C15902(this);
    private final OnEditorActionListener f5527l = new C15913(this);
    private final C1592a f5528m = new C15934(this);
    private final OnLayoutChangeListener f5529n = new C15945(this);
    private final C1239c f5530o = new C15956(this);

    class C15891 implements OnClickListener {
        final /* synthetic */ SignOutSignUpActivity f5507a;

        C15891(SignOutSignUpActivity signOutSignUpActivity) {
            this.f5507a = signOutSignUpActivity;
        }

        public void onClick(View view) {
            this.f5507a.m7859i();
        }
    }

    class C15902 implements OnClickListener {
        final /* synthetic */ SignOutSignUpActivity f5508a;

        C15902(SignOutSignUpActivity signOutSignUpActivity) {
            this.f5508a = signOutSignUpActivity;
        }

        public void onClick(View view) {
            this.f5508a.m7857h();
        }
    }

    class C15913 extends C1267k {
        final /* synthetic */ SignOutSignUpActivity f5509a;

        C15913(SignOutSignUpActivity signOutSignUpActivity) {
            this.f5509a = signOutSignUpActivity;
        }

        public boolean mo929a(TextView textView) {
            this.f5509a.f5522g.performClick();
            return true;
        }
    }

    class C15934 implements C1592a {
        final /* synthetic */ SignOutSignUpActivity f5510a;

        C15934(SignOutSignUpActivity signOutSignUpActivity) {
            this.f5510a = signOutSignUpActivity;
        }

        public void mo1027a(View view, boolean z) {
            if (z && this.f5510a.f5521f == view) {
                this.f5510a.f5524i = this.f5510a.f5518c.mo915c();
                this.f5510a.f5520e.smoothScrollTo(0, view.getTop());
            }
        }
    }

    class C15945 implements OnLayoutChangeListener {
        final /* synthetic */ SignOutSignUpActivity f5511a;

        C15945(SignOutSignUpActivity signOutSignUpActivity) {
            this.f5511a = signOutSignUpActivity;
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (this.f5511a.f5518c.mo915c() - this.f5511a.f5524i <= 500) {
                this.f5511a.f5520e.smoothScrollTo(0, this.f5511a.f5521f.getTop());
            }
        }
    }

    class C15956 implements C1239c {
        final /* synthetic */ SignOutSignUpActivity f5512a;

        C15956(SignOutSignUpActivity signOutSignUpActivity) {
            this.f5512a = signOutSignUpActivity;
        }

        public void mo911a(ResponseStatus responseStatus, List<Fleet> list) {
            this.f5512a.f5517b.m6491b(this.f5512a.f5530o);
            this.f5512a.m6712b(0);
            switch (responseStatus) {
                case RS_SUCCESS:
                    this.f5512a.f5517b.m6458a(this.f5512a.f5516a);
                    this.f5512a.finish();
                    return;
                case RS_LOGIN_ALREADY_EXISTS:
                    this.f5512a.showDialog(1);
                    return;
                case RS_REQUEST_CANCELLED:
                    return;
                default:
                    C2134e.m10680d("TT-SignOutSignUpActivity", "unexpected createAccountWithEmail result: " + responseStatus);
                    return;
            }
        }
    }

    class C15967 implements DialogInterface.OnClickListener {
        final /* synthetic */ SignOutSignUpActivity f5513a;

        C15967(SignOutSignUpActivity signOutSignUpActivity) {
            this.f5513a = signOutSignUpActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f5513a.m7847a(this.f5513a.f5521f.getEmailAddressField());
        }
    }

    class C15978 implements DialogInterface.OnClickListener {
        final /* synthetic */ SignOutSignUpActivity f5514a;

        C15978(SignOutSignUpActivity signOutSignUpActivity) {
            this.f5514a = signOutSignUpActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f5514a.m6699R().m12197b(true);
            this.f5514a.f5517b.m6458a(this.f5514a.f5516a);
            this.f5514a.finish();
        }
    }

    public TextView mo930f() {
        return this.f5519d;
    }

    private void m7847a(EditText editText) {
        if (editText != null) {
            editText.requestFocus();
            editText.setSelection(editText.length());
            this.f5519d = editText;
            mo931l();
        }
    }

    private void m7857h() {
        showDialog(2);
    }

    private void m7859i() {
        this.f5521f.m12030d();
        this.f5521f.m12026a();
        if (this.f5521f.m12029c()) {
            m7847a(this.f5521f.getFirstFieldWithWarning());
            return;
        }
        this.f5517b.m6462a(this.f5530o);
        this.f5517b.m6485a(this.f5521f.getEmailAddress(), this.f5521f.getPassword(), this.f5521f.getFirstName(), this.f5521f.getLastName());
        showDialog(0);
    }

    public SignOutSignUpActivity() {
        super(Feature.PORTRAIT_ONLY_ON_SMALL_DEVICES);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5516a = (Reason) getIntent().getSerializableExtra("com.bigroad.ttb.signOutReason");
        setContentView((int) R.layout.sign_out_sign_up);
        this.f5517b = OurApplication.m6289k();
        this.f5518c = OurApplication.m6269Z();
        this.f5520e = (ScrollView) findViewById(R.id.signOutSignUp_scrollView);
        this.f5521f = (SignUpDataView) findViewById(R.id.signOutSignUp_dataEntry);
        this.f5522g = (Button) findViewById(R.id.signOutSignUp_button);
        this.f5523h = (Button) findViewById(R.id.signOutSignUp_forsakeAccountButton);
        this.f5523h.setOnClickListener(this.f5526k);
        this.f5522g.setOnClickListener(this.f5525j);
        this.f5521f.setPartialAccount(m6699R().m12222l());
        this.f5521f.getPasswordField().setOnEditorActionListener(this.f5527l);
        this.f5521f.getDevServerField().setOnEditorActionListener(this.f5527l);
        this.f5521f.m12027a(this.f5528m);
        this.f5521f.addOnLayoutChangeListener(this.f5529n);
        m6712b(0);
        if (C2306y.m11275b(m6699R().m12222l())) {
            this.f5517b.m6458a(this.f5516a);
            finish();
        }
    }

    protected void onDestroy() {
        this.f5517b.m6491b(this.f5530o);
        super.onDestroy();
    }

    protected Dialog onCreateDialog(int i) {
        switch (i) {
            case 0:
                return new C1845d(this, R.string.signUpDialog_creatingAccount);
            case 1:
                return new C0584a(this).m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.signOutSignUpDialog_emailAlreadyInUseTitle).m2672b((int) R.string.signOutSignUpDialog_emailAlreadyInUseMessage).m2661a(17039370, new C15967(this)).m2677b();
            case 2:
                return new C0584a(this).m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.signOutSignUpDialog_forsakeAccountTitle).m2672b((int) R.string.signOutSignUpDialog_forsakeAccountMessage).m2661a(17039379, new C15978(this)).m2673b(17039369, null).m2677b();
            default:
                return super.onCreateDialog(i);
        }
    }
}
