package com.bigroad.ttb.android.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.C0586c.C0584a;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.bigroad.shared.UserAuthenticationChangeBits.Reason;
import com.bigroad.shared.am;
import com.bigroad.ttb.android.C2474y;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.SyncManager;
import com.bigroad.ttb.android.SyncManager.C1239c;
import com.bigroad.ttb.android.TruckManager;
import com.bigroad.ttb.android.activity.OurActivity.Feature;
import com.bigroad.ttb.android.activity.SelectTruckActivity.Option;
import com.bigroad.ttb.android.ai;
import com.bigroad.ttb.android.dialog.C1843a;
import com.bigroad.ttb.android.dialog.C1844b;
import com.bigroad.ttb.android.dialog.C1845d;
import com.bigroad.ttb.android.dialog.SelectFleetDialogFragment;
import com.bigroad.ttb.android.dialog.SelectFleetDialogFragment.C1588a;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.util.ac;
import com.bigroad.ttb.android.widget.C1267k;
import com.bigroad.ttb.android.widget.SignUpDataView;
import com.bigroad.ttb.protocol.TTProtocol.Fleet;
import com.bigroad.ttb.protocol.TTProtocol.ResponseStatus;
import java.util.EnumSet;
import java.util.List;

public class SignInActivity extends OurKeyboardActivity implements C1588a {
    private SyncManager f5496a;
    private TruckManager f5497b;
    private ai f5498c;
    private TextView f5499d = null;
    private SignUpDataView f5500e;
    private Button f5501f;
    private Button f5502g;
    private final OnClickListener f5503h = new C15791(this);
    private final OnClickListener f5504i = new C15802(this);
    private final OnEditorActionListener f5505j = new C15813(this);
    private final C1239c f5506k = new C15824(this);

    class C15791 implements OnClickListener {
        final /* synthetic */ SignInActivity f5487a;

        C15791(SignInActivity signInActivity) {
            this.f5487a = signInActivity;
        }

        public void onClick(View view) {
            this.f5487a.m7835i();
        }
    }

    class C15802 implements OnClickListener {
        final /* synthetic */ SignInActivity f5488a;

        C15802(SignInActivity signInActivity) {
            this.f5488a = signInActivity;
        }

        public void onClick(View view) {
            this.f5488a.m7829b(-1);
        }
    }

    class C15813 extends C1267k {
        final /* synthetic */ SignInActivity f5489a;

        C15813(SignInActivity signInActivity) {
            this.f5489a = signInActivity;
        }

        public boolean mo929a(TextView textView) {
            this.f5489a.f5502g.performClick();
            return true;
        }
    }

    class C15824 implements C1239c {
        final /* synthetic */ SignInActivity f5490a;

        C15824(SignInActivity signInActivity) {
            this.f5490a = signInActivity;
        }

        public void mo911a(ResponseStatus responseStatus, List<Fleet> list) {
            C1844b.m8916a(SigningInDialogFragment.class, this.f5490a.getSupportFragmentManager());
            C1844b.m8916a(ResettingPasswordDialogFragment.class, this.f5490a.getSupportFragmentManager());
            switch (responseStatus) {
                case RS_SUCCESS:
                    this.f5490a.m6700S().m6026a();
                    if (this.f5490a.f5497b.m6566a()) {
                        C1632a.m7977b(this.f5490a, EnumSet.of(Option.ALLOW_UNKNOWN_TRUCK, Option.REQUIRE_TITLE));
                        return;
                    }
                    this.f5490a.m6700S().m6028b();
                    this.f5490a.setResult(-1);
                    this.f5490a.finish();
                    return;
                case RS_REQUEST_CANCELLED:
                    return;
                case RS_LOGIN_NOT_FOUND:
                    this.f5490a.m6719a(this.f5490a.f5500e.getEmailAddressField());
                    C1844b.m8915a(new LoginNotFoundDialogFragment(), this.f5490a.getSupportFragmentManager());
                    return;
                case RS_INCORRECT_PASSWORD:
                    this.f5490a.f5500e.getPasswordField().setText("");
                    this.f5490a.m7824a(this.f5490a.f5500e.getPasswordField());
                    C1844b.m8915a(new IncorrectPasswordDialogFragment(), this.f5490a.getSupportFragmentManager());
                    return;
                case RS_FLEET_NOT_FOUND:
                case RS_TOO_MANY_FLEETS:
                    C1844b.m8915a(SelectFleetDialogFragment.m8902a(list, this.f5490a.m6699R().m12216h()), this.f5490a.getSupportFragmentManager());
                    return;
                case RS_PASSWORD_RESET:
                    C1844b.m8915a(new PasswordResetSuccessDialogFragment(), this.f5490a.getSupportFragmentManager());
                    return;
                default:
                    C2134e.m10680d("TT-SignInActivity", "Unexpected sign-in result: " + responseStatus);
                    return;
            }
        }
    }

    public static class IncorrectPasswordDialogFragment extends DialogFragment {

        class C15841 implements DialogInterface.OnClickListener {
            final /* synthetic */ IncorrectPasswordDialogFragment f5492a;

            C15841(IncorrectPasswordDialogFragment incorrectPasswordDialogFragment) {
                this.f5492a = incorrectPasswordDialogFragment;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                if (this.f5492a.getActivity() instanceof SignInActivity) {
                    ((SignInActivity) this.f5492a.getActivity()).m7835i();
                }
            }
        }

        public Dialog onCreateDialog(Bundle bundle) {
            return new C0584a(getActivity()).m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.signIn_incorrectPasswordTitle).m2672b((int) R.string.signIn_incorrectPasswordMessage).m2661a((int) R.string.signIn_tryAgainButton, null).m2673b((int) R.string.signIn_iForgotButton, new C15841(this)).m2677b();
        }
    }

    public static class LoginNotFoundDialogFragment extends DialogFragment {
        public Dialog onCreateDialog(Bundle bundle) {
            return new C0584a(getActivity()).m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.signIn_loginNotFoundTitle).m2672b((int) R.string.signIn_loginNotFoundMessage).m2661a(17039370, null).m2677b();
        }
    }

    public static class PasswordResetSuccessDialogFragment extends DialogFragment {
        public Dialog onCreateDialog(Bundle bundle) {
            String str = "";
            if (getActivity() instanceof SignInActivity) {
                str = ((SignInActivity) getActivity()).m7838o();
            }
            return new C0584a(getActivity()).m2678c(R.drawable.ic_dialog_info_light).m2659a((int) R.string.signIn_passwordResetSuccessTitle).m2675b(getString(R.string.signIn_passwordResetSuccessMessage, str)).m2661a(17039370, null).m2677b();
        }
    }

    public static class ResetPasswordDialogFragment extends DialogFragment {

        class C15851 implements DialogInterface.OnClickListener {
            final /* synthetic */ ResetPasswordDialogFragment f5493a;

            C15851(ResetPasswordDialogFragment resetPasswordDialogFragment) {
                this.f5493a = resetPasswordDialogFragment;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                if (this.f5493a.getActivity() instanceof SignInActivity) {
                    SignInActivity signInActivity = (SignInActivity) this.f5493a.getActivity();
                    C1844b.m8915a(new ResettingPasswordDialogFragment(), signInActivity.getSupportFragmentManager());
                    signInActivity.m7837k();
                }
            }
        }

        public Dialog onCreateDialog(Bundle bundle) {
            return new C0584a(getActivity()).m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.signIn_resetPasswordTitle).m2672b((int) R.string.signIn_resetPasswordMessage).m2661a((int) R.string.signIn_resetPasswordButton, new C15851(this)).m2673b(17039360, C1843a.f6286a).m2677b();
        }
    }

    public static class ResettingPasswordDialogFragment extends DialogFragment {

        class C15861 implements OnCancelListener {
            final /* synthetic */ ResettingPasswordDialogFragment f5494a;

            C15861(ResettingPasswordDialogFragment resettingPasswordDialogFragment) {
                this.f5494a = resettingPasswordDialogFragment;
            }

            public void onCancel(DialogInterface dialogInterface) {
                if (this.f5494a.getActivity() instanceof SignInActivity) {
                    ((SignInActivity) this.f5494a.getActivity()).m7836j();
                }
            }
        }

        public Dialog onCreateDialog(Bundle bundle) {
            Dialog c1845d = new C1845d(getActivity(), R.string.signingInDialog_resettingPassword);
            c1845d.setOnCancelListener(new C15861(this));
            return c1845d;
        }
    }

    public static class SigningInDialogFragment extends DialogFragment {

        class C15871 implements OnCancelListener {
            final /* synthetic */ SigningInDialogFragment f5495a;

            C15871(SigningInDialogFragment signingInDialogFragment) {
                this.f5495a = signingInDialogFragment;
            }

            public void onCancel(DialogInterface dialogInterface) {
                if (this.f5495a.getActivity() instanceof SignInActivity) {
                    ((SignInActivity) this.f5495a.getActivity()).m7836j();
                }
            }
        }

        public Dialog onCreateDialog(Bundle bundle) {
            Dialog c1845d = new C1845d(getActivity());
            c1845d.setOnCancelListener(new C15871(this));
            return c1845d;
        }
    }

    public SignInActivity() {
        super(Feature.PORTRAIT_ONLY_ON_SMALL_DEVICES);
    }

    private void m7835i() {
        this.f5500e.m12030d();
        this.f5500e.m12028b();
        if (!this.f5500e.m12029c()) {
            m6699R().m12189a(this.f5500e.getEmailAddress());
            C1844b.m8915a(new ResetPasswordDialogFragment(), getSupportFragmentManager());
        }
    }

    private void m7829b(long j) {
        this.f5500e.m12026a();
        if (this.f5500e.m12029c()) {
            m7824a(this.f5500e.getFirstFieldWithWarning());
            return;
        }
        m6699R().m12189a(this.f5500e.getEmailAddress());
        this.f5496a.m6483a(this.f5500e.getPassword(), j);
        C1844b.m8915a(new SigningInDialogFragment(), getSupportFragmentManager());
    }

    private void m7836j() {
        this.f5496a.m6501f();
    }

    private void m7837k() {
        this.f5496a.m6500e();
    }

    private String m7838o() {
        return this.f5500e.getEmailAddress();
    }

    public TextView mo930f() {
        return this.f5499d;
    }

    private void m7824a(EditText editText) {
        if (editText != null) {
            editText.requestFocus();
            editText.setSelection(editText.length());
            this.f5499d = editText;
            mo931l();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C2474y R = m6699R();
        setContentView((int) R.layout.sign_in);
        this.f5496a = OurApplication.m6289k();
        this.f5497b = OurApplication.m6294p();
        this.f5498c = OurApplication.m6256M();
        this.f5500e = (SignUpDataView) findViewById(R.id.signIn_dataEntry);
        this.f5501f = (Button) findViewById(R.id.signIn_forgotPasswordButton);
        this.f5501f.setOnClickListener(this.f5503h);
        this.f5502g = (Button) findViewById(R.id.signIn_button);
        this.f5502g.setOnClickListener(this.f5504i);
        this.f5500e.getEmailAddressField().setAdapter(this.f5498c.m8371a((Context) this));
        this.f5500e.setDefaultEmailAddress(R.m12192b());
        this.f5500e.getPasswordField().setOnEditorActionListener(this.f5505j);
        if (bundle == null) {
            CharSequence stringExtra = getIntent().getStringExtra("com.bigroad.ttb.emailAddress");
            if (!am.m4188a(stringExtra)) {
                R.m12189a((String) stringExtra);
                ac.m11179a(this.f5500e.getEmailAddressField(), stringExtra);
            }
        }
        m7824a(this.f5500e.getFirstEmptyField());
        this.f5496a.m6462a(this.f5506k);
    }

    protected void onDestroy() {
        this.f5496a.m6491b(this.f5506k);
        super.onDestroy();
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
                this.f5496a.m6458a(Reason.SELECT_TRUCK_FAILED);
                return;
            default:
                C2134e.m10676b("TT-SignInActivity", "Unexpected activity result from requestCode=" + i);
                return;
        }
    }

    public void mo1026a(long j) {
        m7829b(j);
        m6699R().m12193b(j);
    }

    public void mo974h() {
        this.f5496a.m6458a(Reason.CANCELLED_FLEET_SELECTION);
    }
}
