package com.bigroad.ttb.android.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.C0126a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bigroad.shared.af;
import com.bigroad.shared.ah;
import com.bigroad.shared.ai;
import com.bigroad.shared.am;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.p029c.C1738c;
import com.bigroad.ttb.android.util.C2300s;
import com.bigroad.ttb.android.util.C2303v;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import com.bigroad.ttb.protocol.TTProtocol.DailyLogChangeListEntry;
import com.bigroad.ttb.protocol.TTProtocol.DailyLogTruck;
import com.bigroad.ttb.protocol.TTProtocol.Delta;
import com.bigroad.ttb.protocol.TTProtocol.OdometerUnit;
import com.bigroad.ttb.protocol.TTProtocol.ct;
import java.util.List;

public class C2454d extends LinearLayout {
    private C2303v f8747a;
    private TextView f8748b;
    private TextView f8749c;
    private ViewGroup f8750d;
    private TextView f8751e;
    private TextView f8752f;
    private ViewGroup f8753g;
    private ViewGroup f8754h;
    private TextView f8755i;
    private TextView f8756j;
    private TextView f8757k;
    private TextView f8758l;
    private TextView f8759m;
    private TextView f8760n;
    private TextView f8761o;
    private TextView f8762p;
    private TextView f8763q;
    private CorrectionReviewHeaderStringListView f8764r;
    private CorrectionReviewHeaderStringListView f8765s;
    private ViewGroup f8766t;
    private ViewGroup f8767u;

    public C2454d(Context context) {
        super(context);
        m12086a(context);
    }

    private void m12086a(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.correction_review_header, this);
        this.f8747a = C2303v.m11257b(getResources().getDimensionPixelOffset(R.dimen.dailyLogHeader_indent));
        this.f8748b = (TextView) findViewById(R.id.correctionReviewHeader_driverName);
        this.f8749c = (TextView) findViewById(R.id.correctionReviewHeader_codriverHeader);
        this.f8750d = (ViewGroup) findViewById(R.id.correctionReviewHeader_codriversSection);
        this.f8751e = (TextView) findViewById(R.id.correctionReviewHeader_codriverName);
        this.f8752f = (TextView) findViewById(R.id.correctionReviewHeader_codriverId);
        this.f8753g = (ViewGroup) findViewById(R.id.correctionReviewHeader_truckSection);
        this.f8754h = (ViewGroup) findViewById(R.id.correctionReviewHeader_truckList);
        this.f8756j = (TextView) findViewById(R.id.correctionReviewHeader_truckLogsRemoved);
        this.f8755i = (TextView) findViewById(R.id.correctionReviewHeader_totalDistance);
        this.f8757k = (TextView) findViewById(R.id.correctionReviewHeader_carrierName);
        this.f8758l = (TextView) findViewById(R.id.correctionReviewHeader_carrierAddress);
        this.f8759m = (TextView) findViewById(R.id.correctionReviewHeader_homeTerminal);
        this.f8760n = (TextView) findViewById(R.id.correctionReviewHeader_remarks);
        this.f8761o = (TextView) findViewById(R.id.correctionReviewHeader_rules);
        this.f8762p = (TextView) findViewById(R.id.correctionReviewHeader_homeTimeZone);
        this.f8763q = (TextView) findViewById(R.id.correctionReviewHeader_recapType);
        this.f8764r = (CorrectionReviewHeaderStringListView) findViewById(R.id.correctionReviewHeader_shippingDocsList);
        this.f8765s = (CorrectionReviewHeaderStringListView) findViewById(R.id.correctionReviewHeader_trailersList);
        this.f8766t = (ViewGroup) findViewById(R.id.correctionReviewHeader_shippingDocsSection);
        this.f8767u = (ViewGroup) findViewById(R.id.correctionReviewHeader_trailersSection);
    }

    public boolean m12090a(Delta delta) {
        int i = 0;
        String str = null;
        if (delta == null || delta.getDailyLogChangesCount() == 0) {
            return false;
        }
        String valueOf;
        String a;
        this.f8747a.m11265a();
        DailyLogChangeListEntry dailyLogChanges = delta.getDailyLogChanges(0);
        DailyLog beforeChange = dailyLogChanges.getBeforeChange();
        DailyLog afterChange = dailyLogChanges.getAfterChange();
        int a2 = m12088a(this.f8748b, R.string.corrections_headerDriver, beforeChange.getDriverName(), afterChange.getDriverName()) | m12089a(beforeChange, afterChange);
        if (ai.m4177a(beforeChange.getDailyLogTruckList(), afterChange.getDailyLogTruckList())) {
            this.f8753g.setVisibility(8);
            this.f8756j.setVisibility(8);
        } else {
            List<DailyLogTruck> dailyLogTruckList = afterChange.hasDailyLogTruckList() ? afterChange.getDailyLogTruckList().getDailyLogTruckList() : null;
            if (dailyLogTruckList == null || dailyLogTruckList.isEmpty()) {
                this.f8753g.setVisibility(8);
                this.f8756j.setVisibility(0);
            } else {
                this.f8753g.setVisibility(0);
                this.f8756j.setVisibility(8);
                this.f8754h.removeAllViews();
                for (DailyLogTruck dailyLogTruck : dailyLogTruckList) {
                    View c2453c = new C2453c(getContext());
                    c2453c.setTruck(dailyLogTruck);
                    this.f8754h.addView(c2453c);
                }
            }
            a2 = 1;
        }
        if (beforeChange.hasTotalDistance()) {
            OdometerUnit a3;
            valueOf = String.valueOf(beforeChange.getTotalDistance());
            if (beforeChange.hasTotalDistanceUnit()) {
                a3 = OdometerUnit.m14668a(beforeChange.getTotalDistanceUnit());
            } else {
                a3 = null;
            }
            a = af.m4154a(valueOf, a3);
        } else {
            a = null;
        }
        if (afterChange.hasTotalDistance()) {
            OdometerUnit a4;
            String valueOf2 = String.valueOf(afterChange.getTotalDistance());
            if (afterChange.hasTotalDistanceUnit()) {
                a4 = OdometerUnit.m14668a(afterChange.getTotalDistanceUnit());
            } else {
                a4 = null;
            }
            valueOf = af.m4154a(valueOf2, a4);
        } else {
            valueOf = null;
        }
        int a5 = m12088a(this.f8760n, R.string.corrections_headerRemarks, beforeChange.getRemarks(), afterChange.getRemarks()) | ((((a2 | m12088a(this.f8755i, R.string.corrections_totalDistance, a, valueOf)) | m12088a(this.f8757k, R.string.corrections_headerCarrierName, beforeChange.getCarrierName(), afterChange.getCarrierName())) | m12088a(this.f8758l, R.string.corrections_headerCarrierAddress, beforeChange.getCarrierAddress(), afterChange.getCarrierAddress())) | m12088a(this.f8759m, R.string.corrections_headerHomeTerminal, beforeChange.getHomeTerminalAddress(), afterChange.getHomeTerminalAddress()));
        String a6 = !am.m4188a(beforeChange.getTimezoneId()) ? com.bigroad.ttb.android.af.m8282a(beforeChange.getTimezoneId(), getContext()) : null;
        if (!am.m4188a(afterChange.getTimezoneId())) {
            str = com.bigroad.ttb.android.af.m8282a(afterChange.getTimezoneId(), getContext());
        }
        a5 = m12088a(this.f8763q, R.string.corrections_recapType, C2300s.m11250a(getResources(), beforeChange.getRecapType()), C2300s.m11250a(getResources(), afterChange.getRecapType())) | ((m12088a(this.f8762p, R.string.corrections_homeTimeZone, a6, str) | a5) | m12088a(this.f8761o, R.string.corrections_rules, C1738c.m8507a(beforeChange, getContext()), C1738c.m8507a(afterChange, getContext())));
        this.f8764r.m11768a(beforeChange.getShipmentsList(), afterChange.getShipmentsList());
        this.f8766t.setVisibility(this.f8764r.m11769a() ? 0 : 8);
        a2 = this.f8764r.m11769a() | a5;
        this.f8765s.m11768a(beforeChange.getTrailersList(), afterChange.getTrailersList());
        ViewGroup viewGroup = this.f8767u;
        if (!this.f8765s.m11769a()) {
            i = 8;
        }
        viewGroup.setVisibility(i);
        return a2 | this.f8765s.m11769a();
    }

    private boolean m12089a(DailyLog dailyLog, DailyLog dailyLog2) {
        if ((!dailyLog.hasCodriverId() && !dailyLog2.hasCodriverId()) || (dailyLog.hasCodriverId() && dailyLog2.hasCodriverId() && dailyLog.getCodriverId() == dailyLog2.getCodriverId())) {
            this.f8749c.setVisibility(8);
            this.f8750d.setVisibility(8);
            return false;
        } else if (dailyLog2.hasCodriverId()) {
            String string;
            ct a = OurApplication.m6293o().m12138a(dailyLog2.getCodriverId());
            this.f8749c.setText(R.string.corrections_headerCoDriverUpdated);
            this.f8750d.setVisibility(0);
            TextView textView = this.f8751e;
            if (a == null) {
                string = getResources().getString(R.string.corrections_codriverUnknown);
            } else {
                string = ah.m4160a(a);
            }
            m12087a(textView, R.string.corrections_headerCoDriverName, string);
            textView = this.f8752f;
            if (a == null) {
                string = getResources().getString(R.string.corrections_codriverUnknown);
            } else {
                string = a.getEmailAddress();
            }
            m12087a(textView, R.string.corrections_headerCoDriverId, string);
            return true;
        } else {
            m12088a(this.f8749c, R.string.corrections_headerCoDrivers, "Something", "");
            this.f8750d.setVisibility(8);
            return true;
        }
    }

    private boolean m12088a(TextView textView, int i, String str, String str2) {
        if (am.m4189a(str, str2)) {
            textView.setVisibility(8);
            return false;
        }
        Resources resources = getResources();
        this.f8747a.m11268c(resources.getString(i)).m11268c(" ").m11268c(resources.getString(R.string.corrections_headerChangeTo)).m11268c(" ").m11261a(C0126a.m584b(getContext(), R.color.correctionReviewChanged));
        if (am.m4188a((CharSequence) str2)) {
            this.f8747a.m11267b(resources.getString(R.string.none));
        } else {
            this.f8747a.m11268c(str2);
        }
        this.f8747a.m11266b();
        textView.setText(this.f8747a.m11270e());
        textView.setVisibility(0);
        return true;
    }

    private void m12087a(TextView textView, int i, String str) {
        Resources resources = getResources();
        this.f8747a.m11268c(resources.getString(i)).m11268c(" ").m11261a(C0126a.m584b(getContext(), R.color.correctionReviewChanged));
        if (am.m4188a((CharSequence) str)) {
            this.f8747a.m11267b(resources.getString(R.string.none));
        } else {
            this.f8747a.m11268c(str);
        }
        this.f8747a.m11266b();
        textView.setText(this.f8747a.m11270e());
        textView.setVisibility(0);
    }
}
