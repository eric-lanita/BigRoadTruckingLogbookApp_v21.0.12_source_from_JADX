package com.bigroad.ttb.android.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.bigroad.shared.UserAuthenticationChangeBits.Reason;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.SyncManager;
import com.bigroad.ttb.android.SyncManager.C1239c;
import com.bigroad.ttb.android.TruckManager;
import com.bigroad.ttb.android.activity.OurActivity.Feature;
import com.bigroad.ttb.android.activity.OurActivity.TitleStyle;
import com.bigroad.ttb.android.activity.SelectTruckActivity.Option;
import com.bigroad.ttb.android.dialog.C1845d;
import com.bigroad.ttb.protocol.TTProtocol.Fleet;
import com.bigroad.ttb.protocol.TTProtocol.Person;
import com.bigroad.ttb.protocol.TTProtocol.ResponseStatus;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.EnumSet;
import java.util.List;

public class WelcomeBackActivity extends OurActivity {
    private SyncManager f5629a = OurApplication.m6289k();
    private TruckManager f5630b = OurApplication.m6294p();
    private Button f5631c;
    private Button f5632d;
    private final C1239c f5633e = new C16273(this);

    class C16251 implements OnClickListener {
        final /* synthetic */ WelcomeBackActivity f5624a;

        C16251(WelcomeBackActivity welcomeBackActivity) {
            this.f5624a = welcomeBackActivity;
        }

        public void onClick(View view) {
            Person person = null;
            byte[] byteArrayExtra = this.f5624a.getIntent().getByteArrayExtra("com.bigroad.ttb.personRecord");
            if (byteArrayExtra != null) {
                try {
                    person = Person.parseFrom(byteArrayExtra);
                } catch (InvalidProtocolBufferException e) {
                }
            }
            C1632a.m7968b(this.f5624a, person);
        }
    }

    class C16262 implements OnClickListener {
        final /* synthetic */ WelcomeBackActivity f5625a;

        C16262(WelcomeBackActivity welcomeBackActivity) {
            this.f5625a = welcomeBackActivity;
        }

        public void onClick(View view) {
            this.f5625a.m7917f();
        }
    }

    class C16273 implements C1239c {
        final /* synthetic */ WelcomeBackActivity f5626a;

        C16273(WelcomeBackActivity welcomeBackActivity) {
            this.f5626a = welcomeBackActivity;
        }

        public void mo911a(ResponseStatus responseStatus, List<Fleet> list) {
            this.f5626a.f5629a.m6491b(this.f5626a.f5633e);
            this.f5626a.m6712b(0);
            switch (responseStatus) {
                case RS_SUCCESS:
                    this.f5626a.m6700S().m6026a();
                    if (this.f5626a.f5630b.m6566a()) {
                        C1632a.m7977b(this.f5626a, EnumSet.of(Option.ALLOW_UNKNOWN_TRUCK, Option.REQUIRE_TITLE));
                        return;
                    }
                    this.f5626a.m6700S().m6028b();
                    this.f5626a.setResult(-1);
                    this.f5626a.finish();
                    return;
                case RS_REQUEST_CANCELLED:
                    return;
                default:
                    Log.w("TT-WelcomeBack", "Unexpected sign-in result: " + responseStatus);
                    return;
            }
        }
    }

    class C16284 implements OnCancelListener {
        final /* synthetic */ WelcomeBackActivity f5627a;

        C16284(WelcomeBackActivity welcomeBackActivity) {
            this.f5627a = welcomeBackActivity;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f5627a.f5629a.m6501f();
        }
    }

    public WelcomeBackActivity() {
        super(Feature.PORTRAIT_ONLY_ON_SMALL_DEVICES, TitleStyle.NONE);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.welcome_back);
        this.f5631c = (Button) findViewById(R.id.welcomeBack_signUpButton);
        this.f5632d = (Button) findViewById(R.id.welcomeBack_remindMeLaterButton);
        this.f5631c.setOnClickListener(new C16251(this));
        this.f5632d.setOnClickListener(new C16262(this));
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
                this.f5629a.m6458a(Reason.SELECT_TRUCK_FAILED);
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

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.welcome_menu, menu);
        return true;
    }

    private void m7917f() {
        if (OurApplication.m6249F().m6031d()) {
            setResult(-1);
            finish();
            return;
        }
        this.f5629a.m6462a(this.f5633e);
        m6699R().m12198c();
        this.f5629a.m6499d();
        showDialog(0);
    }

    protected void onDestroy() {
        this.f5629a.m6491b(this.f5633e);
        super.onDestroy();
    }

    protected Dialog onCreateDialog(int i) {
        switch (i) {
            case 0:
                Dialog c1845d = new C1845d(this);
                c1845d.setOnCancelListener(new C16284(this));
                return c1845d;
            default:
                return super.onCreateDialog(i);
        }
    }
}
