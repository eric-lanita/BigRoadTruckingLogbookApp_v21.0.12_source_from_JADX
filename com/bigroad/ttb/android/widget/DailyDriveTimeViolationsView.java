package com.bigroad.ttb.android.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bigroad.shared.validation.C1168m;
import com.bigroad.shared.validation.ValidationError;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.p039h.C2089d;
import java.util.List;

public class DailyDriveTimeViolationsView extends LinearLayout {
    protected LayoutInflater f8352a;
    private boolean f8353b;

    public DailyDriveTimeViolationsView(Context context) {
        super(context);
        m11797a(context);
    }

    public DailyDriveTimeViolationsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11797a(context);
    }

    private void m11797a(Context context) {
        this.f8352a = LayoutInflater.from(context);
        this.f8353b = false;
    }

    public boolean m11799a() {
        return this.f8353b;
    }

    public void setViolations(List<ValidationError> list) {
        removeAllViews();
        this.f8353b = false;
        for (ValidationError validationError : list) {
            if (!(validationError instanceof C1168m)) {
                m11798a(validationError);
                this.f8353b = true;
            }
        }
    }

    private void m11798a(ValidationError validationError) {
        View inflate = this.f8352a.inflate(R.layout.daily_drive_time_violation_detail, this, false);
        ((TextView) inflate.findViewById(R.id.dailyDriveTimeViolations_message)).setText(C2089d.m10473a(validationError, getContext()));
        addView(inflate);
    }
}
