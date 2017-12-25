package com.bigroad.ttb.android.dialog;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import java.util.Calendar;

public class EndTimePickerDialogFragment extends CustomTimePickerDialogFragment {
    private C1353a f6219a = null;

    public interface C1353a {
        void mo960c(int i, int i2);
    }

    public static EndTimePickerDialogFragment m8858b(Calendar calendar) {
        EndTimePickerDialogFragment endTimePickerDialogFragment = new EndTimePickerDialogFragment();
        endTimePickerDialogFragment.m8835a(calendar);
        return endTimePickerDialogFragment;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f6219a = (C1353a) activity;
    }

    public void onDetach() {
        super.onDetach();
        this.f6219a = null;
    }

    public void mo1068a(int i, int i2) {
        if (this.f6219a != null) {
            this.f6219a.mo960c(i, i2);
        }
    }

    public static void m8857a(FragmentActivity fragmentActivity, Calendar calendar) {
        m8858b(calendar).show(fragmentActivity.getSupportFragmentManager(), EndTimePickerDialogFragment.class.getName());
    }
}
