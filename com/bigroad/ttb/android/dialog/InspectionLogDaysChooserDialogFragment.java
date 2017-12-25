package com.bigroad.ttb.android.dialog;

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

public class InspectionLogDaysChooserDialogFragment extends DialogFragment {

    public interface C1524a {
        void mo1008a(InspectionTerm inspectionTerm, TruckLogType truckLogType);
    }

    class C18261 implements OnClickListener {
        final /* synthetic */ InspectionLogDaysChooserDialogFragment f6233a;

        C18261(InspectionLogDaysChooserDialogFragment inspectionLogDaysChooserDialogFragment) {
            this.f6233a = inspectionLogDaysChooserDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            int checkedItemPosition = ((C0586c) dialogInterface).m2690a().getCheckedItemPosition();
            dialogInterface.dismiss();
            if (this.f6233a.getActivity() instanceof C1524a) {
                C1524a c1524a = (C1524a) this.f6233a.getActivity();
                TruckLogType a = TruckLogType.m15634a(this.f6233a.getArguments().getInt("truckLogType"));
                InspectionTerm inspectionTerm = InspectionTerm.values()[checkedItemPosition];
                if (inspectionTerm == InspectionTerm.FOURTEEN_DAYS && a == TruckLogType.ELD) {
                    a = TruckLogType.AOBRD;
                }
                c1524a.mo1008a(inspectionTerm, a);
                return;
            }
            this.f6233a.getActivity().finish();
        }
    }

    public void m8877a(OurActivity ourActivity, InspectionTerm inspectionTerm, TruckLogType truckLogType) {
        Bundle bundle = new Bundle();
        bundle.putInt("inspection_term", inspectionTerm.ordinal());
        bundle.putInt("truckLogType", truckLogType.m15635a());
        setArguments(bundle);
        show(ourActivity.getSupportFragmentManager(), "dialog");
    }

    public Dialog onCreateDialog(Bundle bundle) {
        return new C0584a(getActivity()).m2678c(R.drawable.ic_dialog_info_light).m2659a((int) R.string.inspectionLogDaysDialog_title).m2660a((int) R.array.inspectionLogDaysDialog_options, InspectionTerm.values()[getArguments().getInt("inspection_term")].ordinal(), null).m2661a((int) R.string.inspectionLogDaysDialog_accept, new C18261(this)).m2673b((int) R.string.inspectionLogDaysDialog_cancel, C1843a.f6286a).m2670a(true).m2677b();
    }
}
