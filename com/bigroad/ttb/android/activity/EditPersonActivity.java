package com.bigroad.ttb.android.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.C0586c;
import android.support.v7.app.C0586c.C0584a;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.bigroad.shared.C1131p;
import com.bigroad.shared.am;
import com.bigroad.shared.duty.C0956v;
import com.bigroad.ttb.android.C2474y;
import com.bigroad.ttb.android.C2474y.C1182a;
import com.bigroad.ttb.android.C2474y.C1183b;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.SignatureManager;
import com.bigroad.ttb.android.SignatureManager.C1224a;
import com.bigroad.ttb.android.SyncManager;
import com.bigroad.ttb.android.SyncManager.C1239c;
import com.bigroad.ttb.android.activity.OurActivity.Feature;
import com.bigroad.ttb.android.af;
import com.bigroad.ttb.android.dialog.C1845d;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.util.ac;
import com.bigroad.ttb.android.widget.HosSettingsView;
import com.bigroad.ttb.android.widget.TimeZoneSettingsView;
import com.bigroad.ttb.protocol.TTProtocol.Fleet;
import com.bigroad.ttb.protocol.TTProtocol.Person;
import com.bigroad.ttb.protocol.TTProtocol.ResponseStatus;
import com.bigroad.ttb.protocol.TTProtocol.ct;
import java.io.Serializable;
import java.util.List;

public class EditPersonActivity extends OurKeyboardActivity {
    private TextView f5175a;
    private EditText f5176b;
    private EditText f5177c;
    private EditText f5178d;
    private TextView f5179e;
    private Button f5180f;
    private EditText f5181g;
    private HosSettingsView f5182h;
    private TimeZoneSettingsView f5183i;
    private ImageView f5184j;
    private Button f5185k;
    private Button f5186l;
    private SyncManager f5187m;
    private EmailChangedAction f5188n = EmailChangedAction.NONE;
    private final C1182a f5189o = new C14931(this);
    private final C1239c f5190p = new C14997(this);
    private final C1224a f5191q = new C15008(this);
    private final OnClickListener f5192r = new C15019(this);

    class C14931 extends C1183b {
        final /* synthetic */ EditPersonActivity f5161a;

        C14931(EditPersonActivity editPersonActivity) {
            this.f5161a = editPersonActivity;
        }

        public void mo868e(C2474y c2474y) {
            this.f5161a.m7557a(c2474y.m12222l());
            this.f5161a.m7578s();
        }
    }

    class C14942 implements OnClickListener {
        final /* synthetic */ EditPersonActivity f5162a;

        C14942(EditPersonActivity editPersonActivity) {
            this.f5162a = editPersonActivity;
        }

        public void onClick(View view) {
            C1632a.m8003l(this.f5162a);
        }
    }

    class C14953 implements OnClickListener {
        final /* synthetic */ EditPersonActivity f5163a;

        C14953(EditPersonActivity editPersonActivity) {
            this.f5163a = editPersonActivity;
        }

        public void onClick(View view) {
            if (this.f5163a.m7575p()) {
                this.f5163a.finish();
            }
        }
    }

    class C14964 implements OnCancelListener {
        final /* synthetic */ EditPersonActivity f5164a;

        C14964(EditPersonActivity editPersonActivity) {
            this.f5164a = editPersonActivity;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f5164a.f5187m.m6501f();
        }
    }

    class C14975 implements DialogInterface.OnClickListener {
        final /* synthetic */ EditPersonActivity f5165a;

        C14975(EditPersonActivity editPersonActivity) {
            this.f5165a = editPersonActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            switch (this.f5165a.f5188n) {
                case FINISH:
                    this.f5165a.finish();
                    return;
                case CHANGE_PASSWORD:
                    this.f5165a.m7576q();
                    return;
                default:
                    return;
            }
        }
    }

    class C14997 implements C1239c {
        final /* synthetic */ EditPersonActivity f5168a;

        C14997(EditPersonActivity editPersonActivity) {
            this.f5168a = editPersonActivity;
        }

        public void mo911a(ResponseStatus responseStatus, List<Fleet> list) {
            this.f5168a.m6712b(4);
            switch (responseStatus) {
                case RS_SUCCESS:
                    this.f5168a.m6699R().m12189a(this.f5168a.m7566h());
                    this.f5168a.showDialog(5);
                    this.f5168a.m7569j();
                    return;
                case RS_REQUEST_CANCELLED:
                    return;
                case RS_LOGIN_ALREADY_EXISTS:
                    this.f5168a.m7572k();
                    this.f5168a.showDialog(6);
                    return;
                default:
                    C2134e.m10680d("TT-EditPerson", "Unexpected sign-in result: " + responseStatus);
                    return;
            }
        }
    }

    class C15008 implements C1224a {
        final /* synthetic */ EditPersonActivity f5169a;

        C15008(EditPersonActivity editPersonActivity) {
            this.f5169a = editPersonActivity;
        }

        public void mo1007a(SignatureManager signatureManager) {
            this.f5169a.m7578s();
        }
    }

    class C15019 implements OnClickListener {
        final /* synthetic */ EditPersonActivity f5170a;

        C15019(EditPersonActivity editPersonActivity) {
            this.f5170a = editPersonActivity;
        }

        public void onClick(View view) {
            String b = this.f5170a.m7566h();
            if (b.length() == 0) {
                this.f5170a.m7572k();
                this.f5170a.showDialog(3);
            } else if (this.f5170a.m7574o()) {
                this.f5170a.m7553a(EmailChangedAction.CHANGE_PASSWORD, b);
            } else {
                this.f5170a.m7576q();
            }
        }
    }

    private enum EmailChangedAction {
        NONE,
        FINISH,
        CHANGE_PASSWORD
    }

    public EditPersonActivity() {
        super(Feature.FINISH_ON_SIGN_OUT);
    }

    protected TextView mo930f() {
        return this.f5176b;
    }

    private void m7552a(EditText editText) {
        if (editText != null) {
            editText.requestFocus();
            editText.setSelection(editText.length());
        }
    }

    private void m7557a(Person person) {
        if (person != null) {
            this.f5183i.setTimeZoneText(af.m8282a(person.getHosHomeTimezoneId(), (Context) this));
            this.f5182h.setHosSettings(new C0956v((ct) person));
        }
    }

    private String m7566h() {
        return this.f5178d.getText().toString().trim();
    }

    private boolean m7568i() {
        Person l = m6699R().m12222l();
        return (l == null || am.m4188a(l.getEmailAddress())) ? false : true;
    }

    private void m7569j() {
        int i;
        int i2 = 8;
        Person l = m6699R().m12222l();
        Object obj = (m7568i() && l != null && l.getPasswordSet()) ? null : 1;
        EditText editText = this.f5178d;
        if (obj != null) {
            i = 0;
        } else {
            i = 8;
        }
        editText.setVisibility(i);
        TextView textView = this.f5179e;
        if (obj == null) {
            i2 = 0;
        }
        textView.setVisibility(i2);
    }

    private void m7558a(String str) {
        this.f5178d.setText(str);
        this.f5179e.setText(str);
    }

    private void m7572k() {
        if (this.f5178d.getVisibility() == 0) {
            m7552a(this.f5178d);
        } else {
            this.f5179e.requestFocus();
        }
    }

    private boolean m7574o() {
        return !m7566h().equals(am.m4185a(m6699R().m12222l().getEmailAddress()));
    }

    private void m7553a(EmailChangedAction emailChangedAction, String str) {
        if (str.length() <= 0 || C1131p.m5718a(str)) {
            this.f5188n = emailChangedAction;
            showDialog(4);
            this.f5187m.m6482a(str);
            return;
        }
        m7572k();
        showDialog(2);
    }

    private boolean m7575p() {
        Person l = m6699R().m12222l();
        if (l == null) {
            return false;
        }
        String trim = this.f5176b.getText().toString().trim();
        String trim2 = this.f5177c.getText().toString().trim();
        String h = m7566h();
        String trim3 = this.f5181g.getText().toString().trim();
        if ((l.getFirstName().length() > 0 || l.getLastName().length() > 0) && trim.length() == 0 && trim2.length() == 0) {
            m7552a(this.f5176b);
            showDialog(1);
            return false;
        }
        this.f5187m.m6473a(Person.newBuilder().m14718a(l.getPersonId()).m14731c("").m14723a(trim).m14727b(trim2).m14736d(trim3).m14733c());
        if (!m7574o()) {
            return true;
        }
        m7553a(EmailChangedAction.FINISH, h);
        return false;
    }

    private void m7576q() {
        this.f5187m.m6491b(this.f5190p);
        C1632a.m7993g((Activity) this);
    }

    private void m7577r() {
        this.f5187m.m6491b(this.f5190p);
        C1632a.m7995h((Activity) this);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.edit_person);
        this.f5176b = (EditText) findViewById(R.id.editPerson_firstName);
        this.f5177c = (EditText) findViewById(R.id.editPerson_lastName);
        this.f5178d = (EditText) findViewById(R.id.editPerson_editableEmailAddress);
        this.f5179e = (TextView) findViewById(R.id.editPerson_uneditableEmailAddress);
        this.f5180f = (Button) findViewById(R.id.editPerson_changePasswordButton);
        this.f5181g = (EditText) findViewById(R.id.editPerson_phoneNumber);
        this.f5182h = (HosSettingsView) findViewById(R.id.editPerson_hosSettings);
        this.f5183i = (TimeZoneSettingsView) findViewById(R.id.editPerson_timeZoneSettings);
        this.f5184j = (ImageView) findViewById(R.id.editPerson_signatureImageView);
        this.f5185k = (Button) findViewById(R.id.editPerson_changeSignatureButton);
        this.f5186l = (Button) findViewById(R.id.editPerson_doneButton);
        this.f5175a = (TextView) findViewById(R.id.editPerson_approvalMessage);
        this.f5175a.setVisibility(getIntent().getBooleanExtra("com.bigroad.ttb.showApprovalMessage", false) ? 0 : 8);
        this.f5187m = OurApplication.m6289k();
        this.f5177c.setOnEditorActionListener(new OnEditorActionListener(this) {
            final /* synthetic */ EditPersonActivity f5156a;

            {
                this.f5156a = r1;
            }

            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 5) {
                    return false;
                }
                if (this.f5156a.m7568i()) {
                    this.f5156a.f5181g.requestFocus();
                } else {
                    this.f5156a.m7572k();
                }
                return true;
            }
        });
        this.f5179e.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ EditPersonActivity f5157a;

            {
                this.f5157a = r1;
            }

            public void onClick(View view) {
                this.f5157a.m7577r();
            }
        });
        this.f5179e.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ EditPersonActivity f5158a;

            {
                this.f5158a = r1;
            }

            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getActionMasked() != 1) {
                    return false;
                }
                this.f5158a.m7577r();
                return true;
            }
        });
        m7569j();
        this.f5180f.setOnClickListener(this.f5192r);
        this.f5182h.setOnEditClickListener(new OnClickListener(this) {
            final /* synthetic */ EditPersonActivity f5159a;

            {
                this.f5159a = r1;
            }

            public void onClick(View view) {
                C1632a.m8006m(this.f5159a);
            }
        });
        this.f5183i.setOnEditClickListener(new OnClickListener(this) {
            final /* synthetic */ EditPersonActivity f5160a;

            {
                this.f5160a = r1;
            }

            public void onClick(View view) {
                C1632a.m8001k(this.f5160a);
            }
        });
        this.f5185k.setOnClickListener(new C14942(this));
        this.f5186l.setOnClickListener(new C14953(this));
        this.f5184j.setColorFilter(SignatureManager.f4157a);
        Person l = m6699R().m12222l();
        if (bundle != null) {
            Serializable serializable = bundle.getSerializable("emailChangedAction");
            this.f5188n = serializable == null ? EmailChangedAction.NONE : (EmailChangedAction) serializable;
        } else if (l == null) {
            finish();
            return;
        } else {
            ac.m11179a(this.f5176b, l.getFirstName());
            ac.m11179a(this.f5177c, l.getLastName());
            m7558a(l.getEmailAddress());
            ac.m11179a(this.f5181g, l.getPhoneNumber());
        }
        m6699R().m12184a(this.f5189o);
        this.f5187m.m6462a(this.f5190p);
        OurApplication.m6255L().m6353a(this.f5191q);
        m7557a(l);
        m7578s();
    }

    private void m7578s() {
        Bitmap e = SignatureManager.m6343e();
        if (e == null) {
            this.f5184j.setVisibility(8);
            this.f5185k.setText(R.string.editPerson_createSignatureButton);
            return;
        }
        this.f5184j.setVisibility(0);
        this.f5185k.setText(R.string.editPerson_changeSignatureButton);
        this.f5184j.setImageBitmap(e);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        Button button = (Button) this.f5182h.findViewById(R.id.hosSettings_rulesButton);
        ac.m11184a((Button) this.f5183i.findViewById(R.id.timeZoneSettingsView_changeTimeZoneButton), button);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("emailChangedAction", this.f5188n);
    }

    protected void onDestroy() {
        OurApplication.m6255L().m6354b(this.f5191q);
        this.f5187m.m6491b(this.f5190p);
        m6699R().m12194b(this.f5189o);
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12 || i == 20) {
            this.f5187m.m6462a(this.f5190p);
            m7569j();
            m7558a(m6699R().m12222l().getEmailAddress());
        } else if (i == 24) {
            m7578s();
        }
    }

    protected Dialog onCreateDialog(int i) {
        C0584a c0584a;
        switch (i) {
            case 1:
                c0584a = new C0584a(this);
                c0584a.m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.editPerson_namesMissingTitle).m2672b((int) R.string.editPerson_namesMissingMessage).m2661a(17039370, null);
                return c0584a.m2677b();
            case 2:
                c0584a = new C0584a(this);
                c0584a.m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.editPerson_emailInvalidTitle).m2675b((CharSequence) "").m2661a(17039370, null);
                return c0584a.m2677b();
            case 3:
                c0584a = new C0584a(this);
                c0584a.m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.editPerson_emailBeforePasswordTitle).m2672b((int) R.string.editPerson_emailBeforePasswordMessage).m2661a(17039370, null);
                return c0584a.m2677b();
            case 4:
                Dialog c1845d = new C1845d(this, R.string.editPerson_changingEmailAddressMessage);
                c1845d.setOnCancelListener(new C14964(this));
                return c1845d;
            case 5:
                c0584a = new C0584a(this);
                c0584a.m2678c(R.drawable.ic_dialog_info_light).m2659a((int) R.string.editPerson_emailAddressChangedTitle).m2675b((CharSequence) "").m2661a(17039370, new C14975(this));
                return c0584a.m2677b();
            case 6:
                c0584a = new C0584a(this);
                c0584a.m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.editPerson_duplicateEmailTitle).m2675b((CharSequence) "").m2661a(17039370, null);
                return c0584a.m2677b();
            default:
                return super.onCreateDialog(i);
        }
    }

    protected void onPrepareDialog(int i, Dialog dialog) {
        switch (i) {
            case 2:
                ((C0586c) dialog).m2693a(getString(R.string.editPerson_emailInvalidMessage, new Object[]{m7566h()}));
                break;
            case 5:
                ((C0586c) dialog).m2693a(getString(R.string.editPerson_emailAddressChangedMessage, new Object[]{m7566h()}));
                break;
            case 6:
                ((C0586c) dialog).m2693a(getString(R.string.editPerson_duplicateEmailMessage, new Object[]{m7566h()}));
                break;
        }
        super.onPrepareDialog(i, dialog);
    }
}
