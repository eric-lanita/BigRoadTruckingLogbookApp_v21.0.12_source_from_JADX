package com.bigroad.ttb.android.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.C0586c.C0584a;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.bigroad.shared.C1131p;
import com.bigroad.shared.Password;
import com.bigroad.shared.Password.C0826a;
import com.bigroad.shared.Password.NewPasswordStatus;
import com.bigroad.shared.am;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.SyncManager;
import com.bigroad.ttb.android.SyncManager.C1239c;
import com.bigroad.ttb.android.dialog.ErrorDialogFragment;
import com.bigroad.ttb.android.dialog.ProgressDialogFragment;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.util.C2296p;
import com.bigroad.ttb.protocol.TTProtocol.Fleet;
import com.bigroad.ttb.protocol.TTProtocol.Person;
import com.bigroad.ttb.protocol.TTProtocol.ResponseStatus;
import java.util.List;

public class CreateAccountActivity extends OurKeyboardActivity {
    private EditText f4560a;
    private EditText f4561b;
    private EditText f4562c;
    private SyncManager f4563d;
    private final C1239c f4564e = new C13441(this);

    class C13441 implements C1239c {
        final /* synthetic */ CreateAccountActivity f4554a;

        C13441(CreateAccountActivity createAccountActivity) {
            this.f4554a = createAccountActivity;
        }

        public void mo911a(ResponseStatus responseStatus, List<Fleet> list) {
            DialogFragment dialogFragment = (DialogFragment) this.f4554a.getSupportFragmentManager().mo149a("progress-dialog");
            if (dialogFragment != null) {
                dialogFragment.dismiss();
            }
            switch (responseStatus) {
                case RS_SUCCESS:
                    this.f4554a.m6699R().m12189a(this.f4554a.m6912h());
                    AccountCreatedDialogFragment.m6904a(this.f4554a);
                    this.f4554a.mo933n().m11256b(this.f4554a.f4562c);
                    return;
                case RS_REQUEST_CANCELLED:
                    return;
                case RS_LOGIN_ALREADY_EXISTS:
                    this.f4554a.m6906a(this.f4554a.f4560a);
                    ErrorDialogFragment.m8861a(this.f4554a, (int) R.string.createAccount_duplicateEmailTitle, this.f4554a.getString(R.string.createAccount_duplicateEmailMessage, new Object[]{this.f4554a.m6912h()}));
                    return;
                default:
                    C2134e.m10680d("TT-CreateAccount", "Unexpected sign-in result: " + responseStatus);
                    return;
            }
        }
    }

    class C13452 implements OnClickListener {
        final /* synthetic */ CreateAccountActivity f4555a;

        C13452(CreateAccountActivity createAccountActivity) {
            this.f4555a = createAccountActivity;
        }

        public void onClick(View view) {
            if (this.f4555a.m6913i()) {
                ProgressDialogFragment.m8896a(this.f4555a, R.string.createAccount_creatingAccountMessage, "progress-dialog");
            }
        }
    }

    public static class AccountCreatedDialogFragment extends DialogFragment {

        class C13481 implements DialogInterface.OnClickListener {
            final /* synthetic */ AccountCreatedDialogFragment f4559a;

            C13481(AccountCreatedDialogFragment accountCreatedDialogFragment) {
                this.f4559a = accountCreatedDialogFragment;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                ((CreateAccountActivity) this.f4559a.getActivity()).finish();
            }
        }

        public static void m6904a(OurActivity ourActivity) {
            new AccountCreatedDialogFragment().show(ourActivity.getSupportFragmentManager(), "dialog");
        }

        public Dialog onCreateDialog(Bundle bundle) {
            return new C0584a(getActivity()).m2678c(R.drawable.ic_dialog_info_light).m2659a((int) R.string.createAccount_accountCreatedTitle).m2672b((int) R.string.createAccount_accountCreatedMessage).m2661a(17039370, new C13481(this)).m2677b();
        }
    }

    protected TextView mo930f() {
        if (am.m4188a(m6912h())) {
            return this.f4560a;
        }
        return this.f4561b;
    }

    private void m6906a(EditText editText) {
        if (editText != null) {
            editText.requestFocus();
            editText.setSelection(editText.length());
        }
    }

    private String m6912h() {
        return m6909b(this.f4560a).trim();
    }

    private static String m6909b(EditText editText) {
        if (editText != null) {
            return editText.getText().toString();
        }
        return "";
    }

    private boolean m6913i() {
        String h = m6912h();
        String b = m6909b(this.f4561b);
        String b2 = m6909b(this.f4562c);
        if (C1131p.m5718a(h)) {
            NewPasswordStatus a = Password.m4096a(new C0826a(b, b2, h, null, null));
            if (NewPasswordStatus.PASSWORD_VALID.equals(a)) {
                this.f4563d.m6485a(h, b, null, null);
                return true;
            }
            m6906a(this.f4561b);
            ErrorDialogFragment.m8861a((OurActivity) this, (int) R.string.common.password.validation.invalid.title, C2296p.m11244a(a, OurApplication.m6281c()));
            return false;
        }
        m6906a(this.f4560a);
        ErrorDialogFragment.m8861a((OurActivity) this, (int) R.string.changeEmail_emailInvalidTitle, getString(R.string.changeEmail_emailInvalidMessage, new Object[]{m6912h()}));
        return false;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (OurApplication.m6285g().m12226p()) {
            finish();
        }
        this.f4563d = OurApplication.m6289k();
        this.f4563d.m6462a(this.f4564e);
        setContentView((int) R.layout.create_account);
        this.f4560a = (EditText) findViewById(R.id.createAccount_editEmail);
        this.f4561b = (EditText) findViewById(R.id.createAccount_password1);
        this.f4562c = (EditText) findViewById(R.id.createAccount_password2);
        final Button button = (Button) findViewById(R.id.createAccount_doneButton);
        button.setOnClickListener(new C13452(this));
        Person l = m6699R().m12222l();
        if (bundle == null) {
            if (l == null) {
                finish();
                overridePendingTransition(0, 0);
                return;
            }
            this.f4560a.setText(l.getEmailAddress());
        }
        this.f4562c.setOnEditorActionListener(new OnEditorActionListener(this) {
            final /* synthetic */ CreateAccountActivity f4557b;

            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 2) {
                    return false;
                }
                button.performClick();
                return true;
            }
        });
    }

    protected void onDestroy() {
        this.f4563d.m6491b(this.f4564e);
        super.onDestroy();
    }
}
