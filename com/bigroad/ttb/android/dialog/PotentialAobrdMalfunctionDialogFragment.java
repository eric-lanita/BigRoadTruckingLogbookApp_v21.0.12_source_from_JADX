package com.bigroad.ttb.android.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.C0586c.C0584a;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.OurActivity;

public class PotentialAobrdMalfunctionDialogFragment extends DialogFragment {
    public void m8894a(OurActivity ourActivity) {
        show(ourActivity.getSupportFragmentManager(), "dialog");
    }

    public Dialog onCreateDialog(Bundle bundle) {
        return new C0584a(getActivity()).m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.aobrdManualDrivingAttemptNotConnected_title).m2672b((int) R.string.aobrdManualDrivingAttemptNotConnected_message).m2661a(17039370, C1843a.f6286a).m2670a(true).m2677b();
    }
}
