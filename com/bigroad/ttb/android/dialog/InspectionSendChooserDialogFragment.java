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
import com.bigroad.ttb.protocol.TTProtocol.TruckLogType;

public class InspectionSendChooserDialogFragment extends DialogFragment {

    public interface C1423a {
        void mo993a(InspectionOption inspectionOption, InspectionTerm inspectionTerm, TruckLogType truckLogType);
    }

    public enum InspectionOption {
        UNKNOWN,
        SEND_EMAIL,
        PRINT,
        FAX
    }

    public void m8878a(OurActivity ourActivity, InspectionTerm inspectionTerm, TruckLogType truckLogType) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("inspectionTerm", inspectionTerm);
        bundle.putInt("truckLogType", truckLogType.m15635a());
        setArguments(bundle);
        show(ourActivity.getSupportFragmentManager(), "dialog");
    }

    public Dialog onCreateDialog(Bundle bundle) {
        final InspectionTerm inspectionTerm = (InspectionTerm) getArguments().getSerializable("inspectionTerm");
        final TruckLogType a = TruckLogType.m15634a(getArguments().getInt("truckLogType", 0));
        return new C0584a(getActivity()).m2678c(R.drawable.ic_dialog_info_light).m2659a((int) R.string.inspectionSendDialog_title).m2660a((int) R.array.inspectionSendDialog_options, 0, null).m2661a((int) R.string.inspectionSendDialog_accept, new OnClickListener(this) {
            final /* synthetic */ InspectionSendChooserDialogFragment f6236c;

            public void onClick(DialogInterface dialogInterface, int i) {
                InspectionOption inspectionOption;
                int checkedItemPosition = ((C0586c) dialogInterface).m2690a().getCheckedItemPosition();
                InspectionOption inspectionOption2 = InspectionOption.UNKNOWN;
                switch (checkedItemPosition) {
                    case 0:
                        inspectionOption = InspectionOption.SEND_EMAIL;
                        break;
                    case 1:
                        inspectionOption = InspectionOption.PRINT;
                        break;
                    case 2:
                        inspectionOption = InspectionOption.FAX;
                        break;
                    default:
                        inspectionOption = inspectionOption2;
                        break;
                }
                dialogInterface.dismiss();
                Activity activity = this.f6236c.getActivity();
                if (activity instanceof C1423a) {
                    ((C1423a) activity).mo993a(inspectionOption, inspectionTerm, a);
                } else {
                    activity.finish();
                }
            }
        }).m2673b((int) R.string.inspectionSendDialog_cancel, C1843a.f6286a).m2670a(true).m2677b();
    }
}
