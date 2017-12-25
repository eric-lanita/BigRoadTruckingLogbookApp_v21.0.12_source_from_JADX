package com.bigroad.ttb.android.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.bigroad.shared.ah;
import com.bigroad.shared.am;
import com.bigroad.shared.model.C1116d;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.protocol.TTProtocol.TruckLogType;
import com.bigroad.ttb.protocol.TTProtocol.ct;

public class DailyLogInspectHeaderView extends DailyLogHeaderView {
    protected TextView f8486h;
    protected TextView f8487i;
    protected TextView f8488j;
    protected TruckLogType f8489k = TruckLogType.ELECTRONIC;

    public DailyLogInspectHeaderView(Context context) {
        super(context);
        mo1320a(context);
    }

    public DailyLogInspectHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void mo1320a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.daily_log_inspect_header_view, this);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f8486h = (TextView) findViewById(R.id.dailyLogHeader_driverEldId);
        this.f8487i = (TextView) findViewById(R.id.dailyLogHeader_driverLicenseNumber);
        this.f8488j = (TextView) findViewById(R.id.dailyLogHeader_driverLicenseState);
    }

    protected void mo1322b(C1116d c1116d) {
        super.mo1322b(c1116d);
        ct l = OurApplication.m6285g().m12222l();
        if (this.f8489k == TruckLogType.ELD) {
            m11862a(this.f8486h, l == null ? null : l.getEmailAddress());
            m11862a(this.f8487i, l.getDriverLicense());
            m11862a(this.f8488j, l.getLicenseIssuedIn());
        } else {
            this.f8486h.setVisibility(8);
            findViewById(R.id.dailyLogHeader_driverEldIdLabel).setVisibility(8);
            findViewById(R.id.dailyLogHeader_driverLicenseNumberLabel).setVisibility(8);
            findViewById(R.id.dailyLogHeader_driverLicenseStateLabel).setVisibility(8);
            this.f8487i.setVisibility(8);
            this.f8488j.setVisibility(8);
        }
        m11862a(this.b, ah.m4160a(l));
    }

    protected boolean mo1323c() {
        return false;
    }

    public void setInspectAsLogType(TruckLogType truckLogType) {
        this.f8489k = truckLogType;
    }

    protected boolean mo1321a(C1116d c1116d) {
        return this.f8489k == TruckLogType.ELD || !am.m4188a(c1116d.m5653C());
    }

    protected boolean mo1324d() {
        return this.f8489k == TruckLogType.ELD;
    }

    protected C2455e getDailyLogHeaderTruckView() {
        return new C2456f(getContext(), this.f8489k == TruckLogType.ELD);
    }

    protected boolean mo1325e() {
        if (this.a != null && this.f8489k == TruckLogType.ELD && this.a.m5665q()) {
            return true;
        }
        return false;
    }
}
