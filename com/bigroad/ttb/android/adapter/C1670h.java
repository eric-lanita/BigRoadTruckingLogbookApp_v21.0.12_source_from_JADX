package com.bigroad.ttb.android.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.bigroad.shared.dailylog.C0866b;
import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.shared.duty.C0890f;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.UnassignedDrivingInspectActivity;
import com.bigroad.ttb.android.adapter.EventListAdapter.DisplayedRow;
import java.util.TimeZone;

public class C1670h extends C1404e {
    private final UnassignedDrivingInspectActivity f5809a;
    private final int f5810d;

    public C1670h(UnassignedDrivingInspectActivity unassignedDrivingInspectActivity, int i) {
        super(unassignedDrivingInspectActivity);
        this.f5809a = unassignedDrivingInspectActivity;
        this.f5810d = i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        DisplayedRow a = m7196a(i);
        if (!a.m8090a()) {
            return view2;
        }
        m7226a(view2.findViewById(R.id.eventItem_locationRow), !mo1037a(a.m8092b()));
        Button button = (Button) view2.findViewById(R.id.eventItem_editButton);
        if (button != null) {
            button.setVisibility(8);
        }
        return view2;
    }

    protected TimeZone mo989a() {
        return DailyLogUtils.m4305b(C0866b.m4319a(OurApplication.m6260Q(), this.f5810d));
    }

    protected boolean mo990b() {
        return true;
    }

    public boolean g_() {
        return false;
    }

    protected boolean mo1037a(C0890f c0890f) {
        return this.f5809a.m7875a(c0890f);
    }
}
