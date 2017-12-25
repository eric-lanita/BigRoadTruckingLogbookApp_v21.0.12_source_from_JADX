package com.bigroad.ttb.android.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bigroad.shared.InspectionTerm;
import com.bigroad.shared.UserAuthenticationChangeBits.Reason;
import com.bigroad.shared.ac;
import com.bigroad.shared.am;
import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.ttb.android.ConnectivityTracker.Connectivity;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.OurActivity.Feature;
import com.bigroad.ttb.android.dialog.AsyncApiRequestDialogFragment;
import com.bigroad.ttb.android.dialog.AsyncApiRequestDialogFragment.C1398a;
import com.bigroad.ttb.android.dialog.AsyncApiRequestDialogFragment.FinishedResponse;
import com.bigroad.ttb.android.dialog.ErrorDialogFragment;
import com.bigroad.ttb.android.location.Location;
import com.bigroad.ttb.android.location.LocationTracker;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.util.C1408t;
import com.bigroad.ttb.protocol.TTProtocol.FmcsaErodsRequest;
import com.bigroad.ttb.protocol.TTProtocol.FmcsaErodsRequest.C2667a;
import com.bigroad.ttb.protocol.TTProtocol.LatLon;
import com.bigroad.ttb.protocol.TTProtocol.RequestType;
import com.bigroad.ttb.protocol.TTProtocol.RequestUnion;
import java.util.Locale;

public class DailyLogInspectFmcsaActivity extends OurActivity implements C1398a {
    private LocationTracker f4809a;
    private InspectionTerm f4810b;
    private boolean f4811c = false;

    class C14071 implements OnClickListener {
        final /* synthetic */ DailyLogInspectFmcsaActivity f4806a;

        C14071(DailyLogInspectFmcsaActivity dailyLogInspectFmcsaActivity) {
            this.f4806a = dailyLogInspectFmcsaActivity;
        }

        public void onClick(View view) {
            CharSequence text = ((TextView) this.f4806a.findViewById(R.id.dailyLogInspectFmcsa_commentText)).getText();
            if (am.m4188a(text)) {
                this.f4806a.m7260e(0);
            } else {
                this.f4806a.m7256a(text);
            }
        }
    }

    class C14092 extends C1408t {
        final /* synthetic */ DailyLogInspectFmcsaActivity f4807a;

        C14092(DailyLogInspectFmcsaActivity dailyLogInspectFmcsaActivity) {
            this.f4807a = dailyLogInspectFmcsaActivity;
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (!am.m4188a(charSequence)) {
                this.f4807a.m7260e(8);
            }
            this.f4807a.m7259d(charSequence.length());
        }
    }

    public DailyLogInspectFmcsaActivity() {
        super(Feature.FINISH_ON_SIGN_OUT);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.daily_log_inspect_fmcsa);
        this.f4809a = OurApplication.m6302x();
        this.f4810b = (InspectionTerm) getIntent().getSerializableExtra("com.bigroad.ttb.inspectionTerm");
        this.f4811c = getIntent().getBooleanExtra("com.bigroad.ttb.fmcsaErodsUseEmail", false);
        ((Button) findViewById(R.id.dailyLogInspectFmcsa_send)).setOnClickListener(new C14071(this));
        TextView textView = (TextView) findViewById(R.id.dailyLogInspectFmcsa_commentText);
        textView.addTextChangedListener(new C14092(this));
        m7259d(textView.getText().length());
    }

    protected void onStart() {
        OurApplication.m6300v().m10901a(false);
        super.onStart();
    }

    public Locale d_() {
        return ac.f2617a;
    }

    private void m7256a(CharSequence charSequence) {
        if (OurApplication.m6244A().m6111b() != Connectivity.CONNECTED) {
            ErrorDialogFragment.m8860a((OurActivity) this, (int) R.string.dailyLogFax_noConnectionTitle, (int) R.string.dailyLogFax_noConnection);
            return;
        }
        LatLon f = m7261f();
        if (f == null) {
            FmcsaErodsStatusDialogFragment.m7597a(this);
        } else {
            m7253a(charSequence, f).show(getSupportFragmentManager(), "dialog");
        }
    }

    private AsyncApiRequestDialogFragment m7253a(CharSequence charSequence, LatLon latLon) {
        C2667a b = m7257b(charSequence, latLon);
        return AsyncApiRequestDialogFragment.m8819a(RequestType.ERODS_TO_FMCSA, RequestUnion.newBuilder().m14985a(b), getString(R.string.dailyLogInspectFmcsa_sendTitle), getString(R.string.dailyLogInspectFmcsa_sendToFmcsa), true);
    }

    private C2667a m7257b(CharSequence charSequence, LatLon latLon) {
        int a = DailyLogUtils.m4285a(OurApplication.m6285g().m12228r().m4868b());
        int a2 = a - (this.f4810b.m4085a() - 1);
        return FmcsaErodsRequest.newBuilder().m14117a(charSequence.toString()).m14123c(OurApplication.m6292n().m11013b().getFleetId()).m14113a((long) a2).m14120b((long) a).m14118a(this.f4811c).m14115a(latLon);
    }

    private LatLon m7261f() {
        Location e = this.f4809a.m10605e();
        if (e != null) {
            return e.m10554a();
        }
        C2134e.m10680d("TT-InsFmcsaActivity", "No trusted fresh location available!");
        return null;
    }

    private void m7259d(int i) {
        TextView textView = (TextView) findViewById(R.id.dailyLogInspectFmcsa_charCount);
        Resources resources = getBaseContext().getResources();
        textView.setText(getString(R.string.dailyLogInspectFmcsa_charCount, new Object[]{Integer.valueOf(i), Integer.valueOf(resources.getInteger(R.integer.t_fmcsa_comment_length))}));
    }

    private void m7260e(int i) {
        ImageView imageView = (ImageView) findViewById(R.id.dailyLogInspectFmcsa_errorImage);
        ((TextView) findViewById(R.id.dailyLogInspectFmcsa_commentError)).setVisibility(i);
        imageView.setVisibility(i);
    }

    public void mo984a(FinishedResponse finishedResponse) {
        switch (finishedResponse.f6161a) {
            case CANCELED:
                return;
            case SUCCESS:
                FmcsaErodsStatusDialogFragment.m7598b(this);
                return;
            case AUTHENTICATION_FAILURE:
                OurApplication.m6289k().m6458a(Reason.AUTHENTICATION_FAILURE);
                finish();
                return;
            case TRANSPORT_FAILURE:
                FmcsaErodsStatusDialogFragment.m7599c(this);
                return;
            default:
                FmcsaErodsStatusDialogFragment.m7597a(this);
                return;
        }
    }
}
