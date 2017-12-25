package com.bigroad.ttb.android.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.C0586c;
import android.support.v7.app.C0586c.C0584a;
import android.widget.Button;
import com.bigroad.shared.DrivingModeChangeBits.Reason;
import com.bigroad.shared.DutyStatusChangeBits;
import com.bigroad.shared.model.CanonicalOdometerUnit;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.OurActivity;
import com.bigroad.ttb.android.ak;
import com.bigroad.ttb.android.ak.C1536a;
import com.bigroad.ttb.android.ak.C1722b;

public class YardMoveDialogFragment extends DialogFragment {
    private static final ak f6283a = OurApplication.ag();
    private C1722b f6284b = C1722b.f5940a;
    private final C1536a f6285c = new C18411(this);

    class C18411 implements C1536a {
        final /* synthetic */ YardMoveDialogFragment f6281a;

        C18411(YardMoveDialogFragment yardMoveDialogFragment) {
            this.f6281a = yardMoveDialogFragment;
        }

        public void mo1011a(C1722b c1722b) {
            this.f6281a.m8912c();
        }
    }

    class C18422 implements OnClickListener {
        final /* synthetic */ YardMoveDialogFragment f6282a;

        C18422(YardMoveDialogFragment yardMoveDialogFragment) {
            this.f6282a = yardMoveDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            YardMoveDialogFragment.f6283a.m8422a(Reason.YARD_MOVE_USER_ENDED, DutyStatusChangeBits.Reason.EOBR_SELECTED_DIALOG);
            this.f6282a.dismiss();
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        return new C0584a(getActivity()).m2678c(R.drawable.ic_dashlink_good_notification).m2659a((int) R.string.dutyStatusDialog_yardMoveTitle).m2675b(m8914e()).m2673b((int) R.string.dutyStatusDialog_yardMoveButton, new C18422(this)).m2677b();
    }

    public void onStart() {
        super.onStart();
        f6283a.m8424a(this.f6285c);
        this.f6284b = f6283a.m8421a();
        m8913d();
        m8912c();
    }

    public void onStop() {
        f6283a.m8425b(this.f6285c);
        super.onStop();
    }

    private void m8912c() {
        C1722b c1722b = this.f6284b;
        this.f6284b = f6283a.m8421a();
        if (this.f6284b.m8398a()) {
            m8913d();
            return;
        }
        if (c1722b.m8398a() && c1722b.m8400c() <= 0 && (getActivity() instanceof OurActivity)) {
            ErrorDialogFragment.m8860a((OurActivity) getActivity(), (int) R.string.dutyStatusDialog_yardMoveDrivingTitle, (int) R.string.dutyStatusDialog_yardMoveDrivingMessage);
        }
        dismiss();
    }

    private void m8913d() {
        C0586c c0586c = (C0586c) getDialog();
        if (c0586c != null) {
            C1722b a = f6283a.m8421a();
            c0586c.m2693a(m8914e());
            Button a2 = c0586c.m2689a(-2);
            a2.setEnabled(!a.m8399b());
            if (a.m8399b()) {
                a2.setText(R.string.dutyStatusDialog_yardMoveButtonDriving);
            } else {
                a2.setText(R.string.dutyStatusDialog_yardMoveButton);
            }
        }
    }

    private String m8914e() {
        C1722b a = f6283a.m8421a();
        CanonicalOdometerUnit a2 = CanonicalOdometerUnit.m5466a(a.m8401d());
        if (a2 == null) {
            a2 = CanonicalOdometerUnit.MILES;
        }
        String d = a2.m5474d(a.m8400c());
        return getString(R.string.dutyStatusDialog_yardMoveMessage, d);
    }

    public static void m8909a() {
        Activity c = OurApplication.m6284f().m10451c();
        if (c instanceof OurActivity) {
            OurActivity ourActivity = (OurActivity) c;
            if (ourActivity.getSupportFragmentManager().mo149a("YARD_MOVE_IN_PROGRESS") == null) {
                YardMoveDialogFragment yardMoveDialogFragment = new YardMoveDialogFragment();
                yardMoveDialogFragment.setCancelable(false);
                yardMoveDialogFragment.show(ourActivity.getSupportFragmentManager(), "YARD_MOVE_IN_PROGRESS");
                ourActivity.getSupportFragmentManager().mo154b();
            }
        }
    }
}
