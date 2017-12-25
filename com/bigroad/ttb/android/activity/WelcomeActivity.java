package com.bigroad.ttb.android.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.SyncManager;
import com.bigroad.ttb.android.TrialUserMonitor;
import com.bigroad.ttb.android.TrialUserMonitor.C1245a;
import com.bigroad.ttb.android.activity.OurActivity.Feature;
import com.bigroad.ttb.android.activity.OurActivity.TitleStyle;
import com.bigroad.ttb.android.dialog.C1845d;
import com.bigroad.ttb.protocol.TTProtocol.Person;

public class WelcomeActivity extends OurActivity {
    private static final String f5617a = (SignUpActivity.class.getName() + ".userSignedInAlready");
    private SyncManager f5618b = OurApplication.m6289k();
    private TrialUserMonitor f5619c = OurApplication.m6268Y();
    private Button f5620d;
    private Button f5621e;
    private TrialUserResultAction f5622f;
    private C1245a f5623g = new C16191(this);

    class C16191 implements C1245a {
        final /* synthetic */ WelcomeActivity f5608a;

        C16191(WelcomeActivity welcomeActivity) {
            this.f5608a = welcomeActivity;
        }

        public void mo1029a(Person person) {
            this.f5608a.f5619c.m6525b((C1245a) this);
            this.f5608a.m6712b(1);
            this.f5608a.m7906a(person);
        }
    }

    class C16202 implements OnClickListener {
        final /* synthetic */ WelcomeActivity f5609a;

        C16202(WelcomeActivity welcomeActivity) {
            this.f5609a = welcomeActivity;
        }

        public void onClick(View view) {
            this.f5609a.m7910f();
        }
    }

    class C16213 implements OnClickListener {
        final /* synthetic */ WelcomeActivity f5610a;

        C16213(WelcomeActivity welcomeActivity) {
            this.f5610a = welcomeActivity;
        }

        public void onClick(View view) {
            this.f5610a.m7911h();
        }
    }

    class C16224 implements OnCancelListener {
        final /* synthetic */ WelcomeActivity f5611a;

        C16224(WelcomeActivity welcomeActivity) {
            this.f5611a = welcomeActivity;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f5611a.f5618b.m6501f();
        }
    }

    class C16235 implements OnCancelListener {
        final /* synthetic */ WelcomeActivity f5612a;

        C16235(WelcomeActivity welcomeActivity) {
            this.f5612a = welcomeActivity;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f5612a.f5622f = null;
        }
    }

    private enum TrialUserResultAction {
        SIGN_UP,
        SIGN_IN
    }

    public WelcomeActivity() {
        super(Feature.PORTRAIT_ONLY_ON_SMALL_DEVICES, TitleStyle.NONE);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.welcome);
        this.f5620d = (Button) findViewById(R.id.welcome_signInButton);
        this.f5621e = (Button) findViewById(R.id.welcome_signUpButton);
        this.f5620d.setOnClickListener(new C16202(this));
        this.f5621e.setOnClickListener(new C16213(this));
        m6712b(1);
        if (bundle != null) {
            this.f5622f = (TrialUserResultAction) bundle.getSerializable(f5617a);
            if (this.f5619c.m6526b()) {
                m7906a(this.f5619c.m6527c());
            }
        }
    }

    protected void onDestroy() {
        this.f5619c.m6525b(this.f5623g);
        super.onDestroy();
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable(f5617a, this.f5622f);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (!m6700S().m6030c()) {
            setResult(-1);
            finish();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.welcome_menu, menu);
        return true;
    }

    private void m7904a(TrialUserResultAction trialUserResultAction) {
        this.f5622f = trialUserResultAction;
        if (!this.f5619c.m6526b() && !this.f5618b.m6498c()) {
            m7906a(null);
        } else if (this.f5619c.m6526b()) {
            m7906a(this.f5619c.m6527c());
        } else {
            showDialog(1);
            this.f5619c.m6524a(this.f5623g);
        }
    }

    private void m7906a(Person person) {
        if (this.f5622f != null) {
            TrialUserResultAction trialUserResultAction = this.f5622f;
            this.f5622f = null;
            switch (trialUserResultAction) {
                case SIGN_IN:
                    if (person == null) {
                        C1632a.m7984d((Activity) this);
                        return;
                    }
                    setResult(-1);
                    finish();
                    return;
                case SIGN_UP:
                    if (person == null) {
                        C1632a.m7968b((Activity) this, null);
                        return;
                    }
                    setResult(-1);
                    finish();
                    C1632a.m7968b((Activity) this, person);
                    return;
                default:
                    return;
            }
        }
    }

    private void m7910f() {
        m7904a(TrialUserResultAction.SIGN_IN);
    }

    private void m7911h() {
        m7904a(TrialUserResultAction.SIGN_UP);
    }

    protected Dialog onCreateDialog(int i) {
        Dialog c1845d;
        switch (i) {
            case 0:
                c1845d = new C1845d(this);
                c1845d.setOnCancelListener(new C16224(this));
                return c1845d;
            case 1:
                c1845d = new C1845d(this, R.string.welcome_checkingTrialAccount);
                c1845d.setOnCancelListener(new C16235(this));
                return c1845d;
            default:
                return super.onCreateDialog(i);
        }
    }
}
