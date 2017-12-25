package com.bigroad.ttb.android.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.C0586c.C0584a;
import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.OurActivity;

public class ConfirmSelectTruckDialogFragment extends DialogFragment {

    public interface C1357a {
        void mo970c(DutyStatus dutyStatus);

        void mo971d(DutyStatus dutyStatus);

        void mo972e(DutyStatus dutyStatus);
    }

    public static void m8828a(OurActivity ourActivity, DutyStatus dutyStatus) {
        ConfirmSelectTruckDialogFragment confirmSelectTruckDialogFragment = new ConfirmSelectTruckDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("pendingDutyStatus", dutyStatus.m4394b());
        confirmSelectTruckDialogFragment.setArguments(bundle);
        confirmSelectTruckDialogFragment.m8827a(ourActivity);
    }

    private void m8827a(OurActivity ourActivity) {
        show(ourActivity.getSupportFragmentManager(), "dialog");
    }

    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        if (getActivity() instanceof C1357a) {
            C1357a c1357a = (C1357a) getActivity();
            int i = getArguments().getInt("pendingDutyStatus", -1);
            if (i >= 0) {
                c1357a.mo972e(DutyStatus.m4383a(i));
            }
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        final DutyStatus a = DutyStatus.m4383a(getArguments().getInt("pendingDutyStatus", -1));
        C0584a a2 = new C0584a(getActivity()).m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.selectTruckDialog_title).m2672b((int) R.string.selectTruckDialog_message).m2661a((int) R.string.selectTruckDialog_accept, new OnClickListener(this) {
            final /* synthetic */ ConfirmSelectTruckDialogFragment f6182b;

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                if (this.f6182b.getActivity() instanceof C1357a) {
                    ((C1357a) this.f6182b.getActivity()).mo970c(a);
                }
            }
        });
        if (OurApplication.m6292n().m11013b() == null) {
            a2.m2673b((int) R.string.selectTruckDialog_cancel, new OnClickListener(this) {
                final /* synthetic */ ConfirmSelectTruckDialogFragment f6184b;

                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    if (this.f6184b.getActivity() instanceof C1357a) {
                        ((C1357a) this.f6184b.getActivity()).mo971d(a);
                    }
                }
            });
        }
        return a2.m2677b();
    }
}
