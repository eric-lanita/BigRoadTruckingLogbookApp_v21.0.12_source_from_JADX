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
import com.bigroad.shared.C1131p;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.SyncManager;
import com.bigroad.ttb.android.SyncManager.C1239c;
import com.bigroad.ttb.android.activity.OurActivity.Feature;
import com.bigroad.ttb.android.dialog.C1845d;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.widget.C1267k;
import com.bigroad.ttb.protocol.TTProtocol.Fleet;
import com.bigroad.ttb.protocol.TTProtocol.ResponseStatus;
import java.util.List;

public class ChangeEmailActivity extends OurKeyboardActivity {
    private EditText f4364a;
    private EditText f4365b;
    private Button f4366c;
    private SyncManager f4367d;
    private final OnEditorActionListener f4368e = new C12681(this);
    private final C1239c f4369f = new C12692(this);

    class C12681 extends C1267k {
        final /* synthetic */ ChangeEmailActivity f4357a;

        C12681(ChangeEmailActivity changeEmailActivity) {
            this.f4357a = changeEmailActivity;
        }

        public boolean mo929a(TextView textView) {
            this.f4357a.f4366c.performClick();
            return true;
        }
    }

    class C12692 implements C1239c {
        final /* synthetic */ ChangeEmailActivity f4358a;

        C12692(ChangeEmailActivity changeEmailActivity) {
            this.f4358a = changeEmailActivity;
        }

        public void mo911a(ResponseStatus responseStatus, List<Fleet> list) {
            this.f4358a.m6712b(0);
            switch (responseStatus) {
                case RS_SUCCESS:
                    this.f4358a.m6699R().m12189a(this.f4358a.m6734i());
                    this.f4358a.showDialog(3);
                    return;
                case RS_REQUEST_CANCELLED:
                    return;
                case RS_LOGIN_ALREADY_EXISTS:
                    this.f4358a.m6725a(this.f4358a.f4365b);
                    this.f4358a.showDialog(5);
                    return;
                case RS_INCORRECT_PASSWORD:
                    this.f4358a.f4364a.setText("");
                    this.f4358a.m6725a(this.f4358a.f4364a);
                    this.f4358a.showDialog(4);
                    return;
                default:
                    C2134e.m10680d("TT-ChangeEmail", "Unexpected email change result: " + responseStatus);
                    return;
            }
        }
    }

    class C12703 implements OnClickListener {
        final /* synthetic */ ChangeEmailActivity f4359a;

        C12703(ChangeEmailActivity changeEmailActivity) {
            this.f4359a = changeEmailActivity;
        }

        public void onClick(View view) {
            this.f4359a.m6735j();
        }
    }

    class C12714 implements OnCancelListener {
        final /* synthetic */ ChangeEmailActivity f4360a;

        C12714(ChangeEmailActivity changeEmailActivity) {
            this.f4360a = changeEmailActivity;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f4360a.f4367d.m6501f();
        }
    }

    class C12725 implements DialogInterface.OnClickListener {
        final /* synthetic */ ChangeEmailActivity f4361a;

        C12725(ChangeEmailActivity changeEmailActivity) {
            this.f4361a = changeEmailActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            this.f4361a.finish();
        }
    }

    public ChangeEmailActivity() {
        super(Feature.FINISH_ON_SIGN_OUT);
    }

    private void m6725a(EditText editText) {
        if (editText != null) {
            editText.requestFocus();
            editText.setSelection(editText.length());
            m6719a(editText);
        }
    }

    private static String m6727b(EditText editText) {
        return editText.getText().toString();
    }

    private String m6733h() {
        return m6727b(this.f4364a);
    }

    private String m6734i() {
        return m6727b(this.f4365b).trim();
    }

    private void m6735j() {
        String i = m6734i();
        String h = m6733h();
        if (i.length() == 0) {
            this.f4365b.requestFocus();
            showDialog(1);
        } else if (C1131p.m5718a(i)) {
            showDialog(0);
            this.f4367d.m6484a(h, i);
        } else {
            this.f4365b.requestFocus();
            showDialog(2);
        }
    }

    protected TextView mo930f() {
        return this.f4365b;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.change_email);
        this.f4367d = OurApplication.m6289k();
        this.f4365b = (EditText) findViewById(R.id.changeEmail_newEmail);
        this.f4364a = (EditText) findViewById(R.id.changeEmail_currentPassword);
        this.f4366c = (Button) findViewById(R.id.changeEmail_button);
        this.f4364a.setOnEditorActionListener(this.f4368e);
        this.f4366c.setOnClickListener(new C12703(this));
        if (bundle == null) {
            this.f4365b.setText(m6699R().m12222l().getEmailAddress());
        }
        this.f4367d.m6462a(this.f4369f);
    }

    protected void onDestroy() {
        this.f4367d.m6491b(this.f4369f);
        super.onDestroy();
    }

    protected Dialog onCreateDialog(int i) {
        switch (i) {
            case 0:
                Dialog c1845d = new C1845d(this, R.string.editPerson_changingEmailAddressMessage);
                c1845d.setOnCancelListener(new C12714(this));
                return c1845d;
            case 1:
                return new C0584a(this).m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.changeEmail_emailMissingTitle).m2672b((int) R.string.changeEmail_emailMissingMessage).m2661a(17039370, null).m2677b();
            case 2:
                return new C0584a(this).m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.changeEmail_emailInvalidTitle).m2675b((CharSequence) "").m2661a(17039370, null).m2677b();
            case 3:
                return new C0584a(this).m2678c(R.drawable.ic_dialog_info_light).m2659a((int) R.string.editPerson_emailAddressChangedTitle).m2675b((CharSequence) "").m2661a(17039370, new C12725(this)).m2677b();
            case 4:
                return new C0584a(this).m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.changeEmail_incorrectPasswordTitle).m2672b((int) R.string.changeEmail_incorrectPasswordMessage).m2661a(17039370, null).m2677b();
            case 5:
                return new C0584a(this).m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.editPerson_duplicateEmailTitle).m2675b((CharSequence) "").m2661a(17039370, null).m2677b();
            default:
                return super.onCreateDialog(i);
        }
    }

    protected void onPrepareDialog(int i, Dialog dialog) {
        switch (i) {
            case 2:
                ((C0586c) dialog).m2693a(getString(R.string.changeEmail_emailInvalidMessage, new Object[]{m6734i()}));
                break;
            case 3:
                ((C0586c) dialog).m2693a(getString(R.string.editPerson_emailAddressChangedMessage, new Object[]{m6734i()}));
                break;
            case 5:
                ((C0586c) dialog).m2693a(getString(R.string.editPerson_duplicateEmailMessage, new Object[]{m6734i()}));
                break;
        }
        super.onPrepareDialog(i, dialog);
    }
}
