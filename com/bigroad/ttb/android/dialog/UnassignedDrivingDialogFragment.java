package com.bigroad.ttb.android.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.C0586c.C0584a;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.C1632a;
import com.bigroad.ttb.android.adapter.DailyLogListFilterAdapter.DailyLogListFilter;
import com.bigroad.ttb.android.event.EventManager;
import com.bigroad.ttb.android.util.ac;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager.C1201a;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager.ChangeListener;
import com.bigroad.ttb.protocol.TTProtocol.MotionType;

public class UnassignedDrivingDialogFragment extends DialogFragment {
    public static final String f6277a = UnassignedDrivingDialogFragment.class.getName();
    private EventManager f6278b = OurApplication.m6295q();
    private VehicleConnectionManager f6279c = OurApplication.m6252I();
    private ChangeListener f6280d = new C18391(this);

    class C18391 extends C1201a {
        final /* synthetic */ UnassignedDrivingDialogFragment f6275a;

        C18391(UnassignedDrivingDialogFragment unassignedDrivingDialogFragment) {
            this.f6275a = unassignedDrivingDialogFragment;
        }

        public void mo891a(MotionType motionType) {
            if (motionType == MotionType.MOVING) {
                this.f6275a.dismiss();
            }
        }
    }

    class C18402 implements OnClickListener {
        final /* synthetic */ UnassignedDrivingDialogFragment f6276a;

        C18402(UnassignedDrivingDialogFragment unassignedDrivingDialogFragment) {
            this.f6276a = unassignedDrivingDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            C1632a.m7955a(this.f6276a.getActivity(), DailyLogListFilter.UNIDENTIFIED_DRIVING);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        String a = ac.m11175a(this.f6278b.m10063m(), getResources());
        this.f6279c.m11399a(this.f6280d);
        return new C0584a(getActivity()).m2678c(R.drawable.ic_dialog_alert_light).m2675b(getString(R.string.unassignedDrivingDialog_bodyText, a)).m2661a((int) R.string.unassignedDrivingDialog_buttonReviewLaterText, null).m2673b((int) R.string.unassignedDrivingDialog_buttonReviewNowText, new C18402(this)).m2670a(true).m2677b();
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f6279c.m11404b(this.f6280d);
    }
}
