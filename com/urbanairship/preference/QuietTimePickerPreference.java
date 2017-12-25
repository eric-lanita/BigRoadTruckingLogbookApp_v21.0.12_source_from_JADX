package com.urbanairship.preference;

import android.preference.DialogPreference;
import android.text.format.DateFormat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TimePicker;
import com.urbanairship.C3929q;
import java.util.Calendar;

public abstract class QuietTimePickerPreference extends DialogPreference {
    private TimePicker f13737a;
    private long f13738b;

    protected abstract String mo2816a();

    protected abstract void mo2817a(C3929q c3929q, long j);

    public /* synthetic */ CharSequence getSummary() {
        return m20031b();
    }

    public View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        onCreateView.setContentDescription(mo2816a());
        return onCreateView;
    }

    protected View onCreateDialogView() {
        this.f13737a = new TimePicker(getContext());
        this.f13737a.setIs24HourView(Boolean.valueOf(DateFormat.is24HourFormat(getContext())));
        Calendar c = m20028c();
        this.f13737a.setCurrentHour(Integer.valueOf(c.get(11)));
        this.f13737a.setCurrentMinute(Integer.valueOf(c.get(12)));
        return this.f13737a;
    }

    public void onDialogClosed(boolean z) {
        if (z) {
            Calendar instance = Calendar.getInstance();
            instance.set(11, this.f13737a.getCurrentHour().intValue());
            instance.set(12, this.f13737a.getCurrentMinute().intValue());
            long timeInMillis = instance.getTimeInMillis();
            if (callChangeListener(Long.valueOf(timeInMillis))) {
                this.f13738b = timeInMillis;
                mo2817a(C3929q.m20372a(), this.f13738b);
                notifyChanged();
            }
        }
    }

    public String m20031b() {
        return DateFormat.getTimeFormat(getContext()).format(m20028c().getTime());
    }

    private Calendar m20028c() {
        Calendar instance = Calendar.getInstance();
        if (this.f13738b != -1) {
            instance.setTimeInMillis(this.f13738b);
        }
        return instance;
    }

    protected boolean shouldPersist() {
        return false;
    }
}
