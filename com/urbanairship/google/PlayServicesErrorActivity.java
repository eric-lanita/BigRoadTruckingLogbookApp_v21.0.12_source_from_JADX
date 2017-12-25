package com.urbanairship.google;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.urbanairship.C3783j;
import com.urbanairship.C3929q;
import com.urbanairship.analytics.C3735b;

public class PlayServicesErrorActivity extends FragmentActivity {

    public static class ErrorDialogFragment extends DialogFragment {
        public static ErrorDialogFragment m19701a(int i) {
            ErrorDialogFragment errorDialogFragment = new ErrorDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("dialog_error", i);
            errorDialogFragment.setArguments(bundle);
            return errorDialogFragment;
        }

        public Dialog onCreateDialog(Bundle bundle) {
            return GooglePlayServicesUtil.getErrorDialog(getArguments().getInt("dialog_error"), getActivity(), 1000);
        }

        public void onCancel(DialogInterface dialogInterface) {
            super.onCancel(dialogInterface);
            getActivity().finish();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 1000) {
            return;
        }
        if (i2 == -1) {
            C3783j.m19727d("Google Play services resolution received result ok.");
            m19702a();
            return;
        }
        C3783j.m19728e("Google Play services resolution canceled.");
        finish();
    }

    protected void onStart() {
        super.onStart();
        C3735b.m19444a((Activity) this);
        if (getSupportFragmentManager().mo149a("error_dialog") == null) {
            m19702a();
        }
    }

    protected void onStop() {
        super.onStop();
        C3735b.m19448b((Activity) this);
        if (isFinishing() && GooglePlayServicesUtil.isGooglePlayServicesAvailable(this) == 0 && C3929q.m20372a().m20390n().m20308b()) {
            C3929q.m20372a().m20390n().m20316h();
        }
    }

    private void m19702a() {
        C3783j.m19727d("Checking Google Play services.");
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (isGooglePlayServicesAvailable == 0) {
            C3783j.m19727d("Google Play services available!");
            finish();
        } else if (GooglePlayServicesUtil.isUserRecoverableError(isGooglePlayServicesAvailable)) {
            C3783j.m19727d("Google Play services recoverable error: " + isGooglePlayServicesAvailable);
            ErrorDialogFragment.m19701a(isGooglePlayServicesAvailable).show(getSupportFragmentManager(), "error_dialog");
        } else {
            C3783j.m19728e("Unrecoverable Google Play services error: " + isGooglePlayServicesAvailable);
            finish();
        }
    }
}
