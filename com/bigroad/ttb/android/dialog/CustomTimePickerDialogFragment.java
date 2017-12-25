package com.bigroad.ttb.android.dialog;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.widget.TimePicker;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.util.C2291k;
import java.util.Calendar;

public abstract class CustomTimePickerDialogFragment extends DialogFragment implements OnTimeSetListener {
    private static final String f6190a = CustomTimePickerDialogFragment.class.getName();
    private static final String f6191b = (f6190a + ".hour");
    private static final String f6192c = (f6190a + ".minute");
    private int f6193d;
    private int f6194e;

    protected abstract void mo1068a(int i, int i2);

    protected void m8835a(Calendar calendar) {
        Bundle bundle = new Bundle();
        bundle.putInt(f6191b, calendar.get(11));
        bundle.putInt(f6192c, calendar.get(12));
        setArguments(bundle);
    }

    public final void onTimeSet(TimePicker timePicker, int i, int i2) {
        this.f6193d = i;
        this.f6194e = i2;
        if (C2291k.m11225d() > 25) {
            mo1068a(i, i2);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Calendar instance = Calendar.getInstance();
        int i = getArguments().getInt(f6191b, instance.get(11));
        int i2 = getArguments().getInt(f6192c, instance.get(12));
        Context activity = getActivity();
        TimePickerDialog timePickerDialog = new TimePickerDialog(activity, this, i, i2, DateFormat.is24HourFormat(activity));
        if (C2291k.m11225d() <= 25) {
            m8832a(timePickerDialog);
        }
        timePickerDialog.setButton(-2, getString(17039360), C1843a.f6286a);
        return timePickerDialog;
    }

    private void m8832a(final TimePickerDialog timePickerDialog) {
        timePickerDialog.setButton(-1, getString(R.string.customTimePickerDialog_setButton), new OnClickListener(this) {
            final /* synthetic */ CustomTimePickerDialogFragment f6189b;

            public void onClick(DialogInterface dialogInterface, int i) {
                timePickerDialog.onClick(dialogInterface, i);
                this.f6189b.mo1068a(this.f6189b.f6193d, this.f6189b.f6194e);
                this.f6189b.dismiss();
            }
        });
    }
}
