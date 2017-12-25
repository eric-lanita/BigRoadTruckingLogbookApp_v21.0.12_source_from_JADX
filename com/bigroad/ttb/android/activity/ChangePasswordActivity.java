package com.bigroad.ttb.android.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.v7.app.C0586c;
import android.support.v7.app.C0586c.C0584a;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.bigroad.shared.Password;
import com.bigroad.shared.Password.C0826a;
import com.bigroad.shared.Password.NewPasswordStatus;
import com.bigroad.shared.UserAuthenticationChangeBits.Reason;
import com.bigroad.shared.am;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.SyncManager;
import com.bigroad.ttb.android.SyncManager.C1239c;
import com.bigroad.ttb.android.activity.OurActivity.Feature;
import com.bigroad.ttb.android.dialog.C1845d;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.util.C2296p;
import com.bigroad.ttb.android.widget.C1267k;
import com.bigroad.ttb.protocol.TTProtocol.Fleet;
import com.bigroad.ttb.protocol.TTProtocol.Person;
import com.bigroad.ttb.protocol.TTProtocol.ResponseStatus;
import java.util.List;

public class ChangePasswordActivity extends OurKeyboardActivity {
    private SyncManager f4378a;
    private TextView f4379b;
    private TextView f4380c;
    private EditText f4381d;
    private EditText f4382e;
    private EditText f4383f;
    private Button f4384g;
    private String f4385h;
    private String f4386i;
    private String f4387j;
    private NewPasswordStatus f4388k;
    private C0586c f4389l;
    private final OnEditorActionListener f4390m = new C12741(this);
    private final C1239c f4391n = new C12752(this);

    class C12741 extends C1267k {
        final /* synthetic */ ChangePasswordActivity f4370a;

        C12741(ChangePasswordActivity changePasswordActivity) {
            this.f4370a = changePasswordActivity;
        }

        public boolean mo929a(TextView textView) {
            this.f4370a.f4384g.performClick();
            return true;
        }
    }

    class C12752 implements C1239c {
        final /* synthetic */ ChangePasswordActivity f4371a;

        C12752(ChangePasswordActivity changePasswordActivity) {
            this.f4371a = changePasswordActivity;
        }

        public void mo911a(ResponseStatus responseStatus, List<Fleet> list) {
            this.f4371a.m6712b(1);
            switch (responseStatus) {
                case RS_SUCCESS:
                case RS_FLEET_NOT_FOUND:
                case RS_TOO_MANY_FLEETS:
                    this.f4371a.showDialog(4);
                    return;
                case RS_REQUEST_CANCELLED:
                    return;
                case RS_LOGIN_NOT_FOUND:
                    this.f4371a.f4378a.m6458a(Reason.LOGIN_NOT_FOUND);
                    this.f4371a.finish();
                    return;
                case RS_INCORRECT_PASSWORD:
                    this.f4371a.f4381d.setText("");
                    this.f4371a.mo932m();
                    this.f4371a.showDialog(3);
                    return;
                default:
                    C2134e.m10680d("TT-ChangePass", "Unexpected password change result: " + responseStatus);
                    return;
            }
        }
    }

    class C12763 implements OnClickListener {
        final /* synthetic */ ChangePasswordActivity f4372a;

        C12763(ChangePasswordActivity changePasswordActivity) {
            this.f4372a = changePasswordActivity;
        }

        public void onClick(View view) {
            this.f4372a.m6750k();
        }
    }

    class C12774 implements OnCancelListener {
        final /* synthetic */ ChangePasswordActivity f4373a;

        C12774(ChangePasswordActivity changePasswordActivity) {
            this.f4373a = changePasswordActivity;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f4373a.f4378a.m6501f();
        }
    }

    class C12785 implements DialogInterface.OnClickListener {
        final /* synthetic */ ChangePasswordActivity f4374a;

        C12785(ChangePasswordActivity changePasswordActivity) {
            this.f4374a = changePasswordActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f4374a.m6740a(this.f4374a.f4382e);
        }
    }

    class C12796 implements DialogInterface.OnClickListener {
        final /* synthetic */ ChangePasswordActivity f4375a;

        C12796(ChangePasswordActivity changePasswordActivity) {
            this.f4375a = changePasswordActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f4375a.m6740a(this.f4375a.f4381d);
        }
    }

    class C12807 implements DialogInterface.OnClickListener {
        final /* synthetic */ ChangePasswordActivity f4376a;

        C12807(ChangePasswordActivity changePasswordActivity) {
            this.f4376a = changePasswordActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            this.f4376a.finish();
        }
    }

    public ChangePasswordActivity() {
        super(Feature.FINISH_ON_SIGN_OUT);
    }

    private void m6740a(EditText editText) {
        if (editText != null) {
            editText.requestFocus();
            editText.setSelection(editText.length());
            m6719a(editText);
        }
    }

    private static String m6743b(EditText editText) {
        return editText.getText().toString();
    }

    private String m6747h() {
        return m6743b(this.f4381d);
    }

    private String m6748i() {
        return m6743b(this.f4382e);
    }

    private String m6749j() {
        return m6743b(this.f4383f);
    }

    private void m6750k() {
        String i = m6748i();
        this.f4388k = Password.m4096a(new C0826a(i, m6749j(), this.f4385h, this.f4386i, this.f4387j));
        if (NewPasswordStatus.PASSWORD_VALID.equals(this.f4388k)) {
            if (this.f4381d.getVisibility() == 0) {
                this.f4378a.m6495b(m6747h(), i);
            } else {
                this.f4378a.m6494b(i);
            }
            showDialog(1);
            return;
        }
        mo932m();
        showDialog(2);
    }

    protected TextView mo930f() {
        return this.f4381d;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f4388k = (NewPasswordStatus) bundle.get("pwdStatus");
        }
        setContentView((int) R.layout.change_password);
        this.f4378a = OurApplication.m6289k();
        this.f4379b = (TextView) findViewById(R.id.changePassword_overview);
        this.f4380c = (TextView) findViewById(R.id.changePassword_oldPasswordText);
        this.f4381d = (EditText) findViewById(R.id.changePassword_oldPassword);
        this.f4382e = (EditText) findViewById(R.id.changePassword_newPassword1);
        this.f4383f = (EditText) findViewById(R.id.changePassword_newPassword2);
        this.f4384g = (Button) findViewById(R.id.changePassword_button);
        this.f4385h = am.m4185a(m6699R().m12192b());
        this.f4379b.setText(getString(R.string.changePassword_overviewText, new Object[]{this.f4385h}));
        Person l = m6699R().m12222l();
        if (!l.getPasswordSet()) {
            this.f4380c.setVisibility(8);
            this.f4381d.setVisibility(8);
        }
        this.f4386i = l.getFirstName();
        this.f4387j = l.getLastName();
        this.f4383f.setOnEditorActionListener(this.f4390m);
        this.f4384g.setOnClickListener(new C12763(this));
        this.f4378a.m6462a(this.f4391n);
    }

    protected void onDestroy() {
        this.f4378a.m6491b(this.f4391n);
        super.onDestroy();
    }

    protected Dialog onCreateDialog(int i) {
        switch (i) {
            case 1:
                Dialog c1845d = new C1845d(this, R.string.signingInDialog_changingPassword);
                c1845d.setOnCancelListener(new C12774(this));
                return c1845d;
            case 2:
                this.f4389l = new C0584a(this).m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.common.password.validation.invalid.title).m2675b(C2296p.m11244a(this.f4388k, OurApplication.m6281c())).m2661a(17039370, new C12785(this)).m2677b();
                return this.f4389l;
            case 3:
                return new C0584a(this).m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.changePassword_incorrectPasswordTitle).m2672b((int) R.string.changePassword_incorrectPasswordMessage).m2661a(17039370, new C12796(this)).m2677b();
            case 4:
                return new C0584a(this).m2678c(R.drawable.ic_dialog_info_light).m2659a((int) R.string.changePassword_passwordChangedTitle).m2672b((int) R.string.changePassword_passwordChangedMessage).m2661a(17039370, new C12807(this)).m2677b();
            default:
                return super.onCreateDialog(i);
        }
    }

    protected void onPrepareDialog(int i, Dialog dialog) {
        if (i == 2) {
            this.f4389l.m2693a(C2296p.m11244a(this.f4388k, OurApplication.m6281c()));
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("pwdStatus", this.f4388k);
    }
}
