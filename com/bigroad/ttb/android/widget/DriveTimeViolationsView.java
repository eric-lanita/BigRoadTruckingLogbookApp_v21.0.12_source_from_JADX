package com.bigroad.ttb.android.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bigroad.shared.validation.C1168m;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.p039h.C2089d;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class DriveTimeViolationsView extends LinearLayout {
    protected LayoutInflater f8530a;

    public DriveTimeViolationsView(Context context) {
        super(context);
        m11921a(context);
    }

    public DriveTimeViolationsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11921a(context);
    }

    private void m11921a(Context context) {
        this.f8530a = LayoutInflater.from(context);
    }

    public void m11926a(List<C1168m> list, List<C1168m> list2, TimeZone timeZone) {
        removeAllViews();
        setVisibility(8);
        for (C1168m a : list) {
            m11923a(a, timeZone);
            setVisibility(0);
        }
        for (C1168m a2 : list2) {
            m11924b(a2, timeZone);
            setVisibility(0);
        }
    }

    private void m11923a(C1168m c1168m, TimeZone timeZone) {
        m11922a(this.f8530a.inflate(R.layout.drive_time_violation_detail, this, false), c1168m, timeZone);
    }

    private void m11924b(C1168m c1168m, TimeZone timeZone) {
        m11922a(this.f8530a.inflate(R.layout.malfunction_violation_detail, this, false), c1168m, timeZone);
    }

    private void m11922a(View view, C1168m c1168m, TimeZone timeZone) {
        TextView textView = (TextView) view.findViewById(R.id.violation_start);
        textView.setCompoundDrawablesWithIntrinsicBounds(c1168m.m5782d().m5779a() ? R.drawable.ic_alert_violation_small : R.drawable.ic_alert_flag_small, 0, 0, 0);
        TextView textView2 = (TextView) view.findViewById(R.id.violation_message);
        textView.setText(m11925a(view.getContext(), c1168m.m5940a().mo697f(), timeZone));
        textView2.setText(C2089d.m10473a(c1168m, view.getContext()));
        addView(view);
    }

    protected String m11925a(Context context, long j, TimeZone timeZone) {
        Date date = new Date(j);
        DateFormat timeFormat = android.text.format.DateFormat.getTimeFormat(context);
        timeFormat.setTimeZone(timeZone);
        return timeFormat.format(date);
    }
}
