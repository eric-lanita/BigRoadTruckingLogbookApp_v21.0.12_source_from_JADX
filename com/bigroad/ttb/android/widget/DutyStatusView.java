package com.bigroad.ttb.android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.bigroad.shared.duty.C0901j;
import com.bigroad.shared.duty.DutyLimits;
import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.ttb.android.C2476z.C2475a;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.adapter.DutyStatusAdapter;
import com.bigroad.ttb.android.adapter.DutyStatusAdapter.DutyStatusChoice;
import com.bigroad.ttb.android.adapter.DutyStatusAdapter.EditMode;
import com.bigroad.ttb.android.adapter.DutyStatusAdapter.Option;
import com.bigroad.ttb.android.vehicle.C2338a;
import com.bigroad.ttb.android.widget.OurSpinner.C1435a;
import com.bigroad.ttb.android.widget.OurSpinner.C1471b;
import java.util.EnumSet;
import java.util.Set;

public class DutyStatusView extends LinearLayout {
    private LayoutInflater f8532a;
    private OurSpinner f8533b;
    private boolean f8534c;
    private boolean f8535d;
    private DutyStatusAdapter f8536e;
    private C1386p f8537f;

    class C24231 implements C1435a {
        final /* synthetic */ DutyStatusView f8531a;

        C24231(DutyStatusView dutyStatusView) {
            this.f8531a = dutyStatusView;
        }

        public void mo995a(int i) {
            if (i != -1) {
                DutyStatusChoice b = this.f8531a.f8536e.m8079b(i);
                if (b != null) {
                    Object obj = (this.f8531a.f8537f == null || this.f8531a.f8537f.mo982a(b)) ? 1 : null;
                    if (obj != null) {
                        this.f8531a.f8536e.m8080b(b.m8045a());
                    }
                    if (obj == null || b.m8046b()) {
                        this.f8531a.f8536e.m8076a(this.f8531a.f8533b);
                    }
                }
            }
        }
    }

    public DutyStatusView(Context context) {
        super(context);
        this.f8534c = true;
        this.f8535d = true;
        m11929a(context);
    }

    public DutyStatusView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DutyStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f8534c = true;
        this.f8535d = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2475a.DutyStatusView, i, 0);
        this.f8534c = obtainStyledAttributes.getBoolean(0, true);
        this.f8535d = obtainStyledAttributes.getBoolean(1, true);
        obtainStyledAttributes.recycle();
        m11929a(context);
    }

    private void m11929a(Context context) {
        this.f8532a = LayoutInflater.from(context);
        this.f8532a.inflate(R.layout.duty_status, this);
        setOrientation(1);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f8533b = (OurSpinner) findViewById(R.id.dutyStatus_spinner);
        Set noneOf = EnumSet.noneOf(Option.class);
        if (!this.f8534c) {
            noneOf.add(Option.HIDE_AVAILABILITY);
        }
        if (!this.f8535d) {
            noneOf.add(Option.HIDE_CUSTOM_CHOICES);
        }
        this.f8536e = new DutyStatusAdapter(getContext(), noneOf, isInEditMode());
        if (!isInEditMode()) {
            this.f8536e.m8077a(C0901j.m4568a().m4564a(OurApplication.m6285g().m12228r()).m4567a());
        }
        this.f8533b.setAdapter(this.f8536e);
        this.f8533b.setOnUserSelectedListener(new C24231(this));
    }

    public void setOnDutyStatusSelectedListener(C1386p c1386p) {
        this.f8537f = c1386p;
    }

    public void setOverrideClickListener(C1471b c1471b) {
        this.f8533b.setOverrideClickListener(c1471b);
    }

    public boolean m11934a(C0901j c0901j) {
        DutyStatusChoice selection = getSelection();
        boolean a = this.f8536e.m8077a(c0901j);
        setSelection(selection != null ? selection.m8045a() : null);
        return a;
    }

    public void setSelection(DutyStatus dutyStatus) {
        if (this.f8536e.m8071a(dutyStatus) == -1) {
            this.f8536e.m8077a(C0901j.m4568a().m4564a(OurApplication.m6285g().m12228r()).m4563a(dutyStatus).m4567a());
        }
        int a = this.f8536e.m8071a(dutyStatus);
        if (a != -1) {
            this.f8533b.setNonUserSelection(a);
            this.f8536e.m8080b(dutyStatus);
        }
    }

    public DutyStatusChoice getSelection() {
        int selectedItemPosition = this.f8533b.getSelectedItemPosition();
        if (selectedItemPosition == -1) {
            return null;
        }
        return this.f8536e.m8079b(selectedItemPosition);
    }

    public void setAvailability(DutyLimits dutyLimits) {
        this.f8536e.m8074a(dutyLimits);
    }

    public boolean m11935a(C2338a c2338a) {
        return this.f8536e.m8078a(c2338a);
    }

    public void m11932a() {
        this.f8536e.m8073a();
    }

    public void setEditMode(EditMode editMode) {
        this.f8536e.m8075a(editMode);
    }

    public void m11933a(boolean z) {
        this.f8533b.setEnabled(z);
    }
}
