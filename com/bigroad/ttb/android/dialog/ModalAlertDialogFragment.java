package com.bigroad.ttb.android.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.C0586c.C0584a;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.OurActivity;
import com.facebook.share.internal.ShareConstants;

public class ModalAlertDialogFragment extends DialogFragment {

    public interface C1354a {
        void mo964q();
    }

    class C18311 implements OnClickListener {
        final /* synthetic */ ModalAlertDialogFragment f6261a;

        C18311(ModalAlertDialogFragment modalAlertDialogFragment) {
            this.f6261a = modalAlertDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (this.f6261a.getActivity() instanceof C1354a) {
                ((C1354a) this.f6261a.getActivity()).mo964q();
                dialogInterface.dismiss();
            }
        }
    }

    public static ModalAlertDialogFragment m8893a(OurActivity ourActivity, String str, int i, int i2, int i3) {
        ModalAlertDialogFragment modalAlertDialogFragment = new ModalAlertDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ShareConstants.WEB_DIALOG_PARAM_TITLE, ourActivity.getString(i));
        bundle.putString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, ourActivity.getString(i2));
        bundle.putString("buttonText", ourActivity.getString(i3));
        modalAlertDialogFragment.setArguments(bundle);
        modalAlertDialogFragment.setCancelable(false);
        modalAlertDialogFragment.show(ourActivity.getSupportFragmentManager(), str);
        return modalAlertDialogFragment;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        CharSequence string = getArguments().getString(ShareConstants.WEB_DIALOG_PARAM_TITLE);
        CharSequence string2 = getArguments().getString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        return new C0584a(getActivity()).m2678c(R.drawable.ic_dialog_alert_light).m2668a(string).m2675b(string2).m2676b(getArguments().getString("buttonText"), new C18311(this)).m2677b();
    }
}
