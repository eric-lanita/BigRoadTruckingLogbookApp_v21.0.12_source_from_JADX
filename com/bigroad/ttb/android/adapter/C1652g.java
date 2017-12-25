package com.bigroad.ttb.android.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.bigroad.shared.C0906x;
import com.bigroad.shared.validation.model.Event;
import com.bigroad.shared.validation.model.Event.Field;
import com.bigroad.ttb.android.C2315v;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.adapter.EventListAdapter.DisplayedRow;
import com.bigroad.ttb.android.p039h.C2091e;
import com.bigroad.ttb.android.widget.DriveTimeViolationsView;

public abstract class C1652g extends C1404e {
    private final C0906x f5761a;
    private final C2315v f5762d = OurApplication.m6298t();

    public <T extends Activity & C0906x> C1652g(T t) {
        super(t);
        this.f5761a = (C0906x) t;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        int i2 = 8;
        int i3 = 0;
        View view2 = super.getView(i, view, viewGroup);
        if (getItemViewType(i) != 0) {
            return view2;
        }
        DisplayedRow a = m7196a(i);
        TextView textView = (TextView) view2.findViewById(R.id.eventItem_location);
        View findViewById = view2.findViewById(R.id.eventItem_header);
        View findViewById2 = view2.findViewById(R.id.eventItem_body);
        DriveTimeViolationsView driveTimeViolationsView = (DriveTimeViolationsView) view2.findViewById(R.id.eventItem_violations);
        if (a.m8093c()) {
            findViewById.setVisibility(0);
            findViewById2.setVisibility(0);
            driveTimeViolationsView.setVisibility(8);
            textView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            m8152a(view2);
            return view2;
        }
        Event b = a.m8092b();
        boolean v = b.mo720v();
        findViewById.setVisibility(v ? 8 : 0);
        if (!v) {
            i2 = 0;
        }
        findViewById2.setVisibility(i2);
        C2091e.m10479a(this.f5762d.m11298a(this.f5761a.a_(), b), textView, Field.LOCATION_NAME);
        driveTimeViolationsView.m11926a(b.m8118E(), b.m8120G(), mo989a());
        if (b.m8117D() && v) {
            i3 = (int) view2.getContext().getResources().getDimension(R.dimen.widget_spacing);
        }
        driveTimeViolationsView.setPadding(driveTimeViolationsView.getPaddingLeft(), i3, driveTimeViolationsView.getPaddingRight(), driveTimeViolationsView.getPaddingBottom());
        m8152a(view2);
        return view2;
    }

    private void m8152a(View view) {
        Button button = (Button) view.findViewById(R.id.eventItem_ignoreButton);
        TextView textView = (TextView) view.findViewById(R.id.eventItem_question);
        Button button2 = (Button) view.findViewById(R.id.eventItem_editButton);
        ((Button) view.findViewById(R.id.eventItem_claimButton)).setVisibility(8);
        button.setVisibility(8);
        textView.setVisibility(8);
        button2.setVisibility(8);
    }

    public void m8153d(View view, int i) {
        DriveTimeViolationsView driveTimeViolationsView = (DriveTimeViolationsView) view.findViewById(R.id.eventItem_violations);
        if (driveTimeViolationsView != null) {
            driveTimeViolationsView.setVisibility(i);
        }
    }
}
