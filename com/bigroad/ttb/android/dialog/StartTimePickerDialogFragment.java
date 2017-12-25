package com.bigroad.ttb.android.dialog;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import java.util.Calendar;

public class StartTimePickerDialogFragment extends CustomTimePickerDialogFragment {
    private C1355a f6274a = null;

    public interface C1355a {
        void mo959b(int i, int i2);
    }

    public static StartTimePickerDialogFragment m8905b(Calendar calendar) {
        StartTimePickerDialogFragment startTimePickerDialogFragment = new StartTimePickerDialogFragment();
        startTimePickerDialogFragment.m8835a(calendar);
        return startTimePickerDialogFragment;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f6274a = (C1355a) activity;
    }

    public void onDetach() {
        super.onDetach();
        this.f6274a = null;
    }

    public void mo1068a(int i, int i2) {
        if (this.f6274a != null) {
            this.f6274a.mo959b(i, i2);
        }
    }

    public static void m8904a(FragmentActivity fragmentActivity, Calendar calendar) {
        m8905b(calendar).show(fragmentActivity.getSupportFragmentManager(), StartTimePickerDialogFragment.class.getName());
    }
}
