package com.bigroad.ttb.android.dialog;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import com.bigroad.ttb.android.activity.OurActivity;
import com.facebook.share.internal.ShareConstants;

public class ProgressDialogFragment extends DialogFragment {
    public static void m8896a(OurActivity ourActivity, int i, String str) {
        ProgressDialogFragment progressDialogFragment = new ProgressDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, ourActivity.getString(i));
        progressDialogFragment.setArguments(bundle);
        progressDialogFragment.show(ourActivity.getSupportFragmentManager(), str);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        CharSequence string = getArguments().getString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Dialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setCancelable(true);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage(string);
        return progressDialog;
    }
}
