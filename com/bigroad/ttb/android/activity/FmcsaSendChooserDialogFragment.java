package com.bigroad.ttb.android.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.C0586c;
import android.support.v7.app.C0586c.C0584a;
import com.bigroad.shared.InspectionTerm;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.dialog.C1843a;

public class FmcsaSendChooserDialogFragment extends DialogFragment {
    public void m7600a(OurActivity ourActivity, InspectionTerm inspectionTerm) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("inspectionTerm", inspectionTerm);
        setArguments(bundle);
        show(ourActivity.getSupportFragmentManager(), "dialog");
    }

    public Dialog onCreateDialog(Bundle bundle) {
        final InspectionTerm inspectionTerm = (InspectionTerm) getArguments().getSerializable("inspectionTerm");
        return new C0584a(getActivity()).m2678c(R.drawable.ic_dialog_info_light).m2659a((int) R.string.dailyLogInspectFmcsa_optionsTitle).m2660a((int) R.array.dailyLogInspectFmcsa_options, 0, null).m2661a((int) R.string.dailyLogInspectFmcsa_optionsAccept, new OnClickListener(this) {
            final /* synthetic */ FmcsaSendChooserDialogFragment f5216b;

            public void onClick(DialogInterface dialogInterface, int i) {
                int checkedItemPosition = ((C0586c) dialogInterface).m2690a().getCheckedItemPosition();
                dialogInterface.dismiss();
                C1632a.m7953a(this.f5216b.getActivity(), inspectionTerm, checkedItemPosition == 1);
            }
        }).m2673b((int) R.string.inspectionSendDialog_cancel, C1843a.f6286a).m2670a(true).m2677b();
    }
}
