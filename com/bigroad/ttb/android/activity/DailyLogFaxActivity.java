package com.bigroad.ttb.android.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.C0586c.C0584a;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bigroad.shared.UserAuthenticationChangeBits.Reason;
import com.bigroad.shared.aj;
import com.bigroad.shared.am;
import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.shared.validation.C1172k;
import com.bigroad.ttb.android.ConnectivityTracker.Connectivity;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.OurActivity.Feature;
import com.bigroad.ttb.android.adapter.C1695r;
import com.bigroad.ttb.android.ai;
import com.bigroad.ttb.android.dialog.AsyncApiRequestDialogFragment;
import com.bigroad.ttb.android.dialog.AsyncApiRequestDialogFragment.C1398a;
import com.bigroad.ttb.android.dialog.AsyncApiRequestDialogFragment.FinishedResponse;
import com.bigroad.ttb.android.dialog.ErrorDialogFragment;
import com.bigroad.ttb.android.fragment.AbstractNoteInput;
import com.bigroad.ttb.android.fragment.AbstractNoteInput.C1289a;
import com.bigroad.ttb.android.p029c.C1736b;
import com.bigroad.ttb.android.p039h.C2091e;
import com.bigroad.ttb.android.widget.C2458h;
import com.bigroad.ttb.android.widget.InstantAutoComplete;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import com.bigroad.ttb.protocol.TTProtocol.DailyLogFax;
import com.bigroad.ttb.protocol.TTProtocol.DailyLogFaxRequest;
import com.bigroad.ttb.protocol.TTProtocol.DailyLogFaxResponse;
import com.bigroad.ttb.protocol.TTProtocol.DailyLogFaxResponseStatus;
import com.bigroad.ttb.protocol.TTProtocol.RequestType;
import com.bigroad.ttb.protocol.TTProtocol.RequestUnion;
import com.bigroad.ttb.protocol.TTProtocol.ResponseStatus;
import com.google.protobuf.C3642c;
import java.util.Calendar;
import java.util.List;

public class DailyLogFaxActivity extends OurActivity implements C1398a, C1289a {
    private final C1736b f4739a = OurApplication.m6296r();
    private final ai f4740b = OurApplication.m6256M();
    private C1695r f4741c;
    private C1695r f4742d;
    private TextWatcher f4743e;
    private int f4744f;
    private int f4745g;
    private TextView f4746h;
    private InstantAutoComplete f4747i;
    private InstantAutoComplete f4748j;
    private Button f4749k;
    private boolean f4750l = false;
    private boolean f4751m = false;
    private FinishedResponse f4752n = null;

    class C13941 implements Runnable {
        final /* synthetic */ DailyLogFaxActivity f4735a;

        C13941(DailyLogFaxActivity dailyLogFaxActivity) {
            this.f4735a = dailyLogFaxActivity;
        }

        public void run() {
            this.f4735a.m7174h();
        }
    }

    class C13952 implements OnClickListener {
        final /* synthetic */ DailyLogFaxActivity f4736a;

        C13952(DailyLogFaxActivity dailyLogFaxActivity) {
            this.f4736a = dailyLogFaxActivity;
        }

        public void onClick(View view) {
            if (this.f4736a.m7175i()) {
                this.f4736a.m7176j();
            }
        }
    }

    public static class FaxSuccessDialogFragment extends DialogFragment {

        class C13971 implements DialogInterface.OnClickListener {
            final /* synthetic */ FaxSuccessDialogFragment f4738a;

            C13971(FaxSuccessDialogFragment faxSuccessDialogFragment) {
                this.f4738a = faxSuccessDialogFragment;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                if (this.f4738a.getActivity() instanceof DailyLogFaxActivity) {
                    ((DailyLogFaxActivity) this.f4738a.getActivity()).mo930f();
                }
                dialogInterface.dismiss();
            }
        }

        public Dialog onCreateDialog(Bundle bundle) {
            return new C0584a(getActivity()).m2678c(R.drawable.ic_dialog_info_light).m2659a((int) R.string.dailyLogFax_sentTitle).m2672b((int) R.string.dailyLogFax_sentMessage).m2670a(false).m2679c(17039370, new C13971(this)).m2677b();
        }

        public static void m7169a(OurActivity ourActivity) {
            new FaxSuccessDialogFragment().show(ourActivity.getSupportFragmentManager(), "dialog");
        }
    }

    public DailyLogFaxActivity() {
        super(Feature.FINISH_ON_SIGN_OUT);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4743e = new C2458h(m6701T(), new C13941(this));
        if (m6706Y()) {
            getWindow().setSoftInputMode(18);
        } else {
            getWindow().setSoftInputMode(16);
        }
        setContentView((int) R.layout.daily_log_fax);
        m6692K().setStatusMessageVisible(false);
        this.f4746h = (TextView) findViewById(R.id.dailyLogFax_preamble);
        this.f4747i = (InstantAutoComplete) findViewById(R.id.dailyLogFax_faxNumber);
        this.f4748j = (InstantAutoComplete) findViewById(R.id.dailyLogFax_name);
        this.f4749k = (Button) findViewById(R.id.dailyLogFax_faxButton);
        this.f4741c = this.f4740b.m8372a((Context) this, 16);
        this.f4742d = this.f4740b.m8372a((Context) this, 17);
        this.f4747i.setAdapter(this.f4741c);
        this.f4748j.setAdapter(this.f4742d);
        Intent intent = getIntent();
        this.f4744f = intent.getIntExtra("com.bigroad.ttb.logDay", -1);
        if (this.f4744f == -1) {
            finish();
            return;
        }
        this.f4745g = intent.getIntExtra("com.bigroad.ttb.logDayEnd", this.f4744f);
        if (this.f4745g < this.f4744f) {
            this.f4745g = this.f4744f;
        }
        DailyLog f;
        Calendar c;
        if (this.f4745g > this.f4744f) {
            setTitle(R.string.dailyLogFax_titleMultiple);
            DailyLog f2 = this.f4739a.m8491f(this.f4744f);
            f = this.f4739a.m8491f(this.f4745g);
            if (f2 == null || f == null) {
                finish();
                return;
            }
            Calendar c2 = DailyLogUtils.m4306c(f2);
            c = DailyLogUtils.m4306c(f);
            this.f4746h.setText(getString(R.string.dailyLogFax_multiplePreamble, new Object[]{Integer.valueOf((this.f4745g - this.f4744f) + 1), DateFormat.format("EEEE MMMM d, yyyy", c2), DateFormat.format("EEEE MMMM d, yyyy", c)}));
        } else {
            int i;
            setTitle(R.string.dailyLogFax_title);
            f = this.f4739a.m8491f(this.f4744f);
            if (OurApplication.m6297s().m10973a(this.f4744f).isEmpty()) {
                i = R.string.dailyLogFax_preamble;
            } else {
                i = R.string.dailyLogFax_preamble_dvir;
            }
            c = DailyLogUtils.m4306c(f);
            this.f4746h.setText(getString(i, new Object[]{DateFormat.format("EEEE MMMM d, yyyy", c)}));
        }
        this.f4749k.setOnClickListener(new C13952(this));
        this.f4747i.addTextChangedListener(this.f4743e);
        m7174h();
    }

    private void m7174h() {
        ImageView imageView = (ImageView) findViewById(R.id.dailyLogFax_phoneNumberError);
        TextView textView = (TextView) findViewById(R.id.dailyLogFax_phoneNumberErrorText);
        C2091e.m10477a(C1172k.m5949a(this.f4747i.getText().toString().trim()), imageView, textView, this);
    }

    private boolean m7175i() {
        List a = C1172k.m5949a(this.f4747i.getText().toString().trim());
        if (!a.isEmpty()) {
            ErrorDialogFragment.m8861a((OurActivity) this, (int) R.string.dailyLogFax_invalidPhoneNumberTitle, C2091e.m10476a(a, (Context) this));
            return false;
        } else if (OurApplication.m6244A().m6111b() == Connectivity.CONNECTED) {
            return true;
        } else {
            ErrorDialogFragment.m8860a((OurActivity) this, (int) R.string.dailyLogFax_noConnectionTitle, (int) R.string.dailyLogFax_noConnection);
            return false;
        }
    }

    public boolean mo937a(TextView textView) {
        return false;
    }

    private void m7176j() {
        m6702U().m8302d();
        String string = getString(R.string.dailyLogFax_title);
        String trim = this.f4747i.getText().toString().trim();
        String trim2 = this.f4748j.getText().toString().trim();
        AsyncApiRequestDialogFragment.m8819a(RequestType.DAILY_LOG_FAX, RequestUnion.newBuilder().m14969a(DailyLogFaxRequest.newBuilder().m13175a(DailyLogFax.newBuilder().m13146a(C3642c.m19078a(aj.m4179a())).m13143a(1).m13144a(m6699R().m12202d()).m13148a(trim).m13152b(trim2).m13155c(AbstractNoteInput.m10179a(this, R.id.noteInput_fragment)).m13150b(this.f4744f).m13154c(this.f4745g).m13151b(OurApplication.m6269Z().mo913a()))), string, getString(R.string.dailyLogFax_faxingMessage), true).show(getSupportFragmentManager(), "dialog");
    }

    protected void onResumeFragments() {
        super.onResumeFragments();
        this.f4751m = false;
        if (this.f4750l) {
            mo984a(this.f4752n);
        }
    }

    protected void onPause() {
        super.onPause();
        this.f4751m = true;
    }

    public void mo984a(FinishedResponse finishedResponse) {
        if (this.f4751m) {
            this.f4750l = true;
            this.f4752n = finishedResponse;
            return;
        }
        this.f4750l = false;
        switch (finishedResponse.f6161a) {
            case CANCELED:
                return;
            case ERROR:
                if (finishedResponse.f6162b == ResponseStatus.RS_DUPLICATE_REQUEST_IGNORED) {
                    FaxSuccessDialogFragment.m7169a(this);
                    return;
                } else if (finishedResponse.f6162b == ResponseStatus.RS_NOT_AUTHORIZED) {
                    ErrorDialogFragment.m8860a((OurActivity) this, (int) R.string.dailyLogFax_faxingNotAllowedTitle, (int) R.string.dailyLogFax_faxingNotAllowedMessage);
                    return;
                } else {
                    if (finishedResponse.f6162b == ResponseStatus.RS_INVALID_REQUEST) {
                        DailyLogFaxResponse dailyLogFax = finishedResponse.f6163c.getDailyLogFax();
                        if (dailyLogFax.getStatus() == DailyLogFaxResponseStatus.DLFR_VALIDATION_FAILURE && !am.m4188a(dailyLogFax.getMessage())) {
                            ErrorDialogFragment.m8861a((OurActivity) this, (int) R.string.dailyLogFax_faxingNotAllowedTitle, dailyLogFax.getMessage());
                            this.f4747i.requestFocus();
                            return;
                        }
                    }
                    ErrorDialogFragment.m8860a((OurActivity) this, (int) R.string.dailyLogFax_unexpectedErrorTitle, (int) R.string.dailyLogFax_unexpectedErrorMessage);
                    return;
                }
            case SUCCESS:
                FaxSuccessDialogFragment.m7169a(this);
                return;
            case AUTHENTICATION_FAILURE:
                OurApplication.m6289k().m6458a(Reason.AUTHENTICATION_FAILURE);
                finish();
                return;
            case TRANSPORT_FAILURE:
                ErrorDialogFragment.m8860a((OurActivity) this, (int) R.string.dailyLogFax_transportErrorTitle, (int) R.string.dailyLogFax_transportErrorMessage);
                return;
            default:
                return;
        }
    }

    public void mo930f() {
        this.f4740b.m8374a(this.f4747i, 16);
        this.f4740b.m8374a(this.f4748j, 17);
        finish();
    }
}
