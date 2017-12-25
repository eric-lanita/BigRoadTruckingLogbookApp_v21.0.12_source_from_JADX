package com.bigroad.ttb.android.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.C0586c.C0584a;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.OurActivity;
import com.facebook.share.internal.ShareConstants;

public class ErrorDialogFragment extends DialogFragment {
    public static void m8860a(OurActivity ourActivity, int i, int i2) {
        ErrorDialogFragment errorDialogFragment = new ErrorDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ShareConstants.WEB_DIALOG_PARAM_TITLE, ourActivity.getString(i));
        bundle.putString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, ourActivity.getString(i2));
        errorDialogFragment.setArguments(bundle);
        errorDialogFragment.show(ourActivity.getSupportFragmentManager(), "dialog");
    }

    public static void m8861a(OurActivity ourActivity, int i, String str) {
        ErrorDialogFragment errorDialogFragment = new ErrorDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ShareConstants.WEB_DIALOG_PARAM_TITLE, ourActivity.getString(i));
        bundle.putString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, str);
        errorDialogFragment.setArguments(bundle);
        errorDialogFragment.show(ourActivity.getSupportFragmentManager(), "dialog");
    }

    public Dialog onCreateDialog(Bundle bundle) {
        CharSequence string = getArguments().getString(ShareConstants.WEB_DIALOG_PARAM_TITLE);
        return new C0584a(getActivity()).m2678c(R.drawable.ic_dialog_alert_light).m2668a(string).m2675b(getArguments().getString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE)).m2679c(17039370, C1843a.f6286a).m2677b();
    }
}
