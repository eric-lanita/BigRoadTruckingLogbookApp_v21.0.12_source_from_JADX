package com.bigroad.ttb.android.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.C0586c;
import android.support.v7.app.C0586c.C0584a;
import com.bigroad.shared.InspectionTerm;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.OurActivity;

public class InspectionTypeChooserDialogFragment extends DialogFragment {

    public interface C1525a {
        void mo1009a(InspectionOption inspectionOption, InspectionTerm inspectionTerm);
    }

    public enum InspectionOption {
        UNKNOWN,
        VIEW_ON_SCREEN,
        SEND_EMAIL,
        PRINT,
        FAX
    }

    public void m8879a(OurActivity ourActivity, InspectionTerm inspectionTerm) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("inspectionTerm", inspectionTerm);
        setArguments(bundle);
        show(ourActivity.getSupportFragmentManager(), "dialog");
    }

    public Dialog onCreateDialog(Bundle bundle) {
        final InspectionTerm inspectionTerm = (InspectionTerm) getArguments().getSerializable("inspectionTerm");
        return new C0584a(getActivity()).m2678c(R.drawable.ic_dialog_info_light).m2659a((int) R.string.inspectionTypeDialog_title).m2660a((int) R.array.inspectionTypeDialog_options, 0, null).m2661a((int) R.string.inspectionTypeDialog_accept, new OnClickListener(this) {
            final /* synthetic */ InspectionTypeChooserDialogFragment f6243b;

            public void onClick(DialogInterface dialogInterface, int i) {
                InspectionOption inspectionOption;
                int checkedItemPosition = ((C0586c) dialogInterface).m2690a().getCheckedItemPosition();
                InspectionOption inspectionOption2 = InspectionOption.UNKNOWN;
                switch (checkedItemPosition) {
                    case 0:
                        inspectionOption = InspectionOption.VIEW_ON_SCREEN;
                        break;
                    case 1:
                        inspectionOption = InspectionOption.SEND_EMAIL;
                        break;
                    case 2:
                        inspectionOption = InspectionOption.PRINT;
                        break;
                    case 3:
                        inspectionOption = InspectionOption.FAX;
                        break;
                    default:
                        inspectionOption = inspectionOption2;
                        break;
                }
                dialogInterface.dismiss();
                Activity activity = this.f6243b.getActivity();
                if (activity instanceof C1525a) {
                    ((C1525a) activity).mo1009a(inspectionOption, inspectionTerm);
                } else {
                    activity.finish();
                }
            }
        }).m2673b((int) R.string.inspectionTypeDialog_cancel, C1843a.f6286a).m2670a(true).m2677b();
    }
}
