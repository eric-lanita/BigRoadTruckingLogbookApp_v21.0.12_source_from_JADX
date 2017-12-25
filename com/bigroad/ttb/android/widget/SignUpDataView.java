package com.bigroad.ttb.android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bigroad.shared.C1131p;
import com.bigroad.shared.Password;
import com.bigroad.shared.Password.C0826a;
import com.bigroad.shared.Password.NewPasswordStatus;
import com.bigroad.shared.am;
import com.bigroad.ttb.android.C2474y;
import com.bigroad.ttb.android.C2476z.C2475a;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.util.C1408t;
import com.bigroad.ttb.android.util.C2296p;
import com.bigroad.ttb.android.util.ac;
import com.bigroad.ttb.protocol.TTProtocol.Person;
import java.util.HashSet;
import java.util.Set;

public class SignUpDataView extends LinearLayout {
    private C2474y f8627a;
    private String f8628b;
    private String f8629c;
    private boolean f8630d;
    private boolean f8631e;
    private boolean f8632f;
    private EditText f8633g;
    private EditText f8634h;
    private InstantAutoComplete f8635i;
    private EditText f8636j;
    private EditText f8637k;
    private Button f8638l;
    private TextView f8639m;
    private TextView f8640n;
    private TextView f8641o;
    private View f8642p;
    private View f8643q;
    private EditText[] f8644r;
    private boolean f8645s = false;
    private Set<C1592a> f8646t = new HashSet();
    private TextWatcher f8647u = new C24341(this);
    private OnClickListener f8648v = new C24352(this);
    private OnFocusChangeListener f8649w = new C24363(this);
    private TextWatcher f8650x = new C24374(this);
    private TextWatcher f8651y = new C24385(this);
    private TextWatcher f8652z = new C24396(this);

    public interface C1592a {
        void mo1027a(View view, boolean z);
    }

    class C24341 extends C1408t {
        final /* synthetic */ SignUpDataView f8621a;

        C24341(SignUpDataView signUpDataView) {
            this.f8621a = signUpDataView;
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (this.f8621a.f8643q.getVisibility() == 0 && this.f8621a.f8627a.m12175T()) {
                String obj = this.f8621a.f8637k.getText().toString();
                if (obj.isEmpty()) {
                    obj = "app.bigroad.com";
                } else {
                    obj = obj + ".bigroad.com";
                }
                OurApplication.m6245B().m10546a(obj);
                this.f8621a.f8627a.m12207e(obj);
            }
        }
    }

    class C24352 implements OnClickListener {
        final /* synthetic */ SignUpDataView f8622a;

        C24352(SignUpDataView signUpDataView) {
            this.f8622a = signUpDataView;
        }

        public void onClick(View view) {
            this.f8622a.m12019h();
        }
    }

    class C24363 implements OnFocusChangeListener {
        final /* synthetic */ SignUpDataView f8623a;

        C24363(SignUpDataView signUpDataView) {
            this.f8623a = signUpDataView;
        }

        public void onFocusChange(View view, boolean z) {
            boolean z2 = false;
            for (View view2 : this.f8623a.f8644r) {
                if (z2 || view2.hasFocus()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            }
            if (z2 != this.f8623a.f8645s) {
                this.f8623a.f8645s = z2;
                this.f8623a.m12006a(this.f8623a.f8645s);
            }
            if (!z && view == this.f8623a.f8635i) {
                this.f8623a.f8635i.setSelection(this.f8623a.f8635i.getSelectionStart());
            }
        }
    }

    class C24374 extends C1408t {
        final /* synthetic */ SignUpDataView f8624a;

        C24374(SignUpDataView signUpDataView) {
            this.f8624a = signUpDataView;
        }

        public void afterTextChanged(Editable editable) {
            if (editable.toString().length() > 0) {
                this.f8624a.f8639m.setVisibility(8);
            }
        }
    }

    class C24385 extends C1408t {
        final /* synthetic */ SignUpDataView f8625a;

        C24385(SignUpDataView signUpDataView) {
            this.f8625a = signUpDataView;
        }

        public void afterTextChanged(Editable editable) {
            String obj = editable.toString();
            if (this.f8625a.f8640n.getVisibility() == 0) {
                this.f8625a.m12005a(obj);
            }
            if (this.f8625a.f8631e && this.f8625a.f8643q.getVisibility() == 8 && obj.equals("supersecretdonotenter")) {
                ac.m11179a(this.f8625a.f8635i, this.f8625a.getCurrentPersonEmailAddress());
                this.f8625a.m12017g();
            }
        }
    }

    class C24396 extends C1408t {
        final /* synthetic */ SignUpDataView f8626a;

        C24396(SignUpDataView signUpDataView) {
            this.f8626a = signUpDataView;
        }

        public void afterTextChanged(Editable editable) {
            if (editable.toString().length() >= (this.f8626a.f8632f ? 1 : 6)) {
                this.f8626a.f8641o.setVisibility(8);
            }
        }
    }

    public SignUpDataView(Context context) {
        super(context);
        m12003a(null);
    }

    public SignUpDataView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m12003a(attributeSet);
    }

    public SignUpDataView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m12003a(attributeSet);
    }

    private void m12003a(AttributeSet attributeSet) {
        int i = 8;
        inflate(getContext(), R.layout.sign_up_data_view, this);
        if (!isInEditMode()) {
            this.f8627a = OurApplication.m6285g();
        }
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, C2475a.SignUpDataView, 0, 0);
        try {
            String string = obtainStyledAttributes.getString(0);
            this.f8630d = obtainStyledAttributes.getBoolean(1, true);
            this.f8631e = obtainStyledAttributes.getBoolean(2, false);
            this.f8632f = obtainStyledAttributes.getBoolean(3, false);
            this.f8633g = (EditText) findViewById(R.id.signUpView_firstName);
            this.f8634h = (EditText) findViewById(R.id.signUpView_lastName);
            this.f8635i = (InstantAutoComplete) findViewById(R.id.signUpView_emailAddress);
            this.f8636j = (EditText) findViewById(R.id.signUpView_password);
            this.f8637k = (EditText) findViewById(R.id.signUpView_devServerField);
            this.f8638l = (Button) findViewById(R.id.signUpView_devDisableButton);
            this.f8639m = (TextView) findViewById(R.id.signUpView_nameErrorText);
            this.f8640n = (TextView) findViewById(R.id.signUpView_emailErrorText);
            this.f8641o = (TextView) findViewById(R.id.signUpView_passwordErrorText);
            this.f8642p = findViewById(R.id.signUpView_nameContainer);
            this.f8643q = findViewById(R.id.signUpView_devLayoutContainer);
            this.f8639m.setVisibility(8);
            this.f8640n.setVisibility(8);
            this.f8641o.setVisibility(8);
            this.f8642p.setVisibility(this.f8630d ? 0 : 8);
            this.f8643q.setVisibility(8);
            this.f8633g.addTextChangedListener(this.f8650x);
            this.f8634h.addTextChangedListener(this.f8650x);
            this.f8635i.addTextChangedListener(this.f8651y);
            this.f8635i.setAdapter(new ArrayAdapter(getContext(), -1));
            this.f8636j.addTextChangedListener(this.f8652z);
            this.f8637k.addTextChangedListener(this.f8647u);
            this.f8638l.setOnClickListener(this.f8648v);
            this.f8644r = new EditText[]{this.f8633g, this.f8634h, this.f8635i, this.f8636j};
            for (View onFocusChangeListener : this.f8644r) {
                onFocusChangeListener.setOnFocusChangeListener(this.f8649w);
            }
            if (this.f8632f) {
                this.f8641o.setText(R.string.signUpView_warningPasswordAnyText);
            }
            TextView textView = (TextView) findViewById(R.id.signUpView_messageText);
            if (!am.m4188a((CharSequence) string)) {
                i = 0;
            }
            textView.setVisibility(i);
            textView.setText(am.m4185a(string));
            if (this.f8627a != null && this.f8627a.m12175T()) {
                this.f8643q.setVisibility(0);
                String U = this.f8627a.m12176U();
                ac.m11179a(this.f8637k, U.substring(0, U.length() - ".bigroad.com".length()));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public boolean getAllowNameEntry() {
        return this.f8630d;
    }

    public void setPartialAccount(Person person) {
        if (person != null) {
            this.f8628b = person.getEmailAddress();
            this.f8635i.setText(getCurrentPersonEmailAddress());
            this.f8635i.setSelection(this.f8635i.getSelectionStart());
            ac.m11179a(this.f8633g, person.getFirstName());
            ac.m11179a(this.f8634h, person.getLastName());
        }
    }

    public void setDefaultEmailAddress(String str) {
        boolean a = am.m4189a(getEmailAddress(), getCurrentPersonEmailAddress());
        this.f8629c = str;
        if (a) {
            this.f8635i.setText(getCurrentPersonEmailAddress());
            this.f8635i.setSelection(this.f8635i.getSelectionStart());
        }
    }

    public String getFirstName() {
        return this.f8633g.getText().toString().trim();
    }

    public String getLastName() {
        return this.f8634h.getText().toString().trim();
    }

    public String getEmailAddress() {
        return this.f8635i.getText().toString().trim();
    }

    public String getPassword() {
        return this.f8636j.getText().toString().trim();
    }

    public InstantAutoComplete getEmailAddressField() {
        return this.f8635i;
    }

    public EditText getPasswordField() {
        return this.f8636j;
    }

    public EditText getDevServerField() {
        return this.f8637k;
    }

    public void m12027a(C1592a c1592a) {
        this.f8646t.add(c1592a);
    }

    private void m12006a(boolean z) {
        for (C1592a a : (C1592a[]) this.f8646t.toArray(new C1592a[this.f8646t.size()])) {
            a.mo1027a(this, z);
        }
    }

    public void m12026a() {
        m12012e();
        m12028b();
        m12014f();
    }

    private void m12012e() {
        int i;
        int i2 = 0;
        if (this.f8630d && this.f8633g.getText().length() == 0 && this.f8634h.getText().length() == 0) {
            i = 1;
        } else {
            i = 0;
        }
        TextView textView = this.f8639m;
        if (i == 0) {
            i2 = 8;
        }
        textView.setVisibility(i2);
    }

    public void m12028b() {
        m12005a(getEmailAddress());
    }

    private void m12005a(String str) {
        int i = 1;
        int i2 = 0;
        int i3 = str.length() == 0 ? 1 : 0;
        if ((!this.f8632f || str.length() < 1) && !(i3 == 0 && C1131p.m5718a(str))) {
            i = 0;
        }
        TextView textView = this.f8640n;
        if (i != 0) {
            i2 = 8;
        }
        textView.setVisibility(i2);
        this.f8640n.setText(i3 != 0 ? R.string.signUpView_warningEnterEmail : R.string.signUpView_warningInvalidEmail);
    }

    private void m12014f() {
        String password = getPassword();
        if (this.f8632f) {
            int i;
            TextView textView = this.f8641o;
            if (password.length() >= 1) {
                i = 8;
            } else {
                i = 0;
            }
            textView.setVisibility(i);
            return;
        }
        NewPasswordStatus a = Password.m4096a(new C0826a(password, password, getEmailAddress(), getFirstName(), getLastName()));
        if (NewPasswordStatus.PASSWORD_VALID.equals(a)) {
            this.f8641o.setVisibility(8);
            return;
        }
        this.f8641o.setText(C2296p.m11244a(a, getContext()));
        this.f8641o.setVisibility(0);
    }

    public boolean m12029c() {
        return getFirstFieldWithWarning() != null;
    }

    public EditText getFirstEmptyField() {
        if (this.f8642p.getVisibility() == 0 && this.f8633g.getText().length() == 0) {
            return this.f8633g;
        }
        if (this.f8642p.getVisibility() == 0 && this.f8634h.getText().length() == 0) {
            return this.f8634h;
        }
        if (this.f8635i.getVisibility() == 0 && this.f8635i.getText().length() == 0) {
            return this.f8635i;
        }
        if (this.f8636j.getVisibility() == 0 && this.f8636j.getText().length() == 0) {
            return this.f8636j;
        }
        return null;
    }

    public EditText getFirstFieldWithWarning() {
        if (this.f8642p.getVisibility() == 0 && this.f8639m.getVisibility() == 0) {
            return this.f8633g;
        }
        if (this.f8635i.getVisibility() == 0 && this.f8640n.getVisibility() == 0) {
            return this.f8635i;
        }
        if (this.f8636j.getVisibility() == 0 && this.f8641o.getVisibility() == 0) {
            return this.f8636j;
        }
        return null;
    }

    public void m12030d() {
        this.f8639m.setVisibility(8);
        this.f8640n.setVisibility(8);
        this.f8641o.setVisibility(8);
    }

    private void m12017g() {
        this.f8643q.setVisibility(0);
        this.f8627a.m12205d(true);
    }

    private void m12019h() {
        this.f8643q.setVisibility(8);
        this.f8627a.m12205d(false);
        OurApplication.m6245B().m10551f();
    }

    private String getCurrentPersonEmailAddress() {
        return am.m4185a(am.m4188a(this.f8628b) ? this.f8629c : this.f8628b);
    }
}
