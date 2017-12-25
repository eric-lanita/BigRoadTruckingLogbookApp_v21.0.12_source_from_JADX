package com.bigroad.ttb.android.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.C0586c.C0584a;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.TruckManager;
import com.bigroad.ttb.android.activity.OurActivity;

public class ConfirmUsingTruckDialogFragment extends DialogFragment {

    public interface C1378a {
        void mo980a(String str);
    }

    class C17971 implements OnClickListener {
        final /* synthetic */ ConfirmUsingTruckDialogFragment f6185a;

        C17971(ConfirmUsingTruckDialogFragment confirmUsingTruckDialogFragment) {
            this.f6185a = confirmUsingTruckDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            if (this.f6185a.getActivity() instanceof C1378a) {
                ((C1378a) this.f6185a.getActivity()).mo980a(null);
            }
        }
    }

    public static void m8829a(OurActivity ourActivity, String str) {
        ConfirmUsingTruckDialogFragment confirmUsingTruckDialogFragment = new ConfirmUsingTruckDialogFragment();
        confirmUsingTruckDialogFragment.setCancelable(false);
        confirmUsingTruckDialogFragment.m8830b(ourActivity, str);
    }

    private void m8830b(OurActivity ourActivity, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("truckNumber", str);
        setArguments(bundle);
        show(ourActivity.getSupportFragmentManager(), "dialog");
    }

    public Dialog onCreateDialog(Bundle bundle) {
        final String string = getArguments().getString("truckNumber");
        return new C0584a(getActivity()).m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.usingTruckDialog_title).m2675b(getString(R.string.usingTruckDialog_message, string)).m2661a((int) R.string.usingTruckDialog_accept, new OnClickListener(this) {
            final /* synthetic */ ConfirmUsingTruckDialogFragment f6187b;

            public void onClick(DialogInterface dialogInterface, int i) {
                TruckManager p = OurApplication.m6294p();
                if (p.m6572c(string) == null) {
                    p.m6582h(string);
                } else {
                    p.m6577e(string);
                }
                dialogInterface.dismiss();
                if (this.f6187b.getActivity() instanceof C1378a) {
                    ((C1378a) this.f6187b.getActivity()).mo980a(string);
                }
            }
        }).m2673b((int) R.string.usingTruckDialog_cancel, new C17971(this)).m2677b();
    }
}
