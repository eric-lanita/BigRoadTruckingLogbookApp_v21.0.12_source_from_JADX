package com.bigroad.ttb.android.activity;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v7.app.C0586c.C0584a;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.dialog.ErrorDialogFragment;

public class FmcsaErodsStatusDialogFragment extends DialogFragment {

    class C15091 implements OnClickListener {
        final /* synthetic */ FmcsaErodsStatusDialogFragment f5214a;

        C15091(FmcsaErodsStatusDialogFragment fmcsaErodsStatusDialogFragment) {
            this.f5214a = fmcsaErodsStatusDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f5214a.getActivity().finish();
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        int i = R.string.dailyLogInspectFmcsa_successTitle;
        int i2 = R.string.dailyLogInspectFmcsa_successMessage;
        int i3 = R.string.dailyLogInspectFmcsa_okBtn;
        if (!Boolean.valueOf(getArguments().getBoolean("showFmcsaSendSuccess")).booleanValue()) {
            i = R.string.dailyLogInspectFmcsa_errorTitle;
            i2 = R.string.dailyLogInspectFmcsa_errorMessage;
            i3 = R.string.dailyLogInspectFmcsa_otherBtn;
        }
        return new C0584a(getActivity()).m2659a(i).m2672b(i2).m2670a(false).m2661a(i3, new C15091(this)).m2677b();
    }

    public static void m7597a(OurActivity ourActivity) {
        FmcsaErodsStatusDialogFragment fmcsaErodsStatusDialogFragment = new FmcsaErodsStatusDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean("showFmcsaSendSuccess", false);
        fmcsaErodsStatusDialogFragment.setArguments(bundle);
        fmcsaErodsStatusDialogFragment.show(ourActivity.getFragmentManager(), "dialog");
    }

    public static void m7598b(OurActivity ourActivity) {
        FmcsaErodsStatusDialogFragment fmcsaErodsStatusDialogFragment = new FmcsaErodsStatusDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean("showFmcsaSendSuccess", true);
        fmcsaErodsStatusDialogFragment.setArguments(bundle);
        fmcsaErodsStatusDialogFragment.show(ourActivity.getFragmentManager(), "dialog");
    }

    public static void m7599c(OurActivity ourActivity) {
        ErrorDialogFragment.m8860a(ourActivity, (int) R.string.dailyLogInspectFmcsa_transportError, (int) R.string.dailyLogInspectFmcsa_transportErrorMessage);
    }
}
