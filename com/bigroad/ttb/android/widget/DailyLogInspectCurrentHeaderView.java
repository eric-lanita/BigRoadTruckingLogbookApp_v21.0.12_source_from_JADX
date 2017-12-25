package com.bigroad.ttb.android.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bigroad.shared.am;
import com.bigroad.shared.aq;
import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.shared.duty.C0898i;
import com.bigroad.shared.duty.C0956v;
import com.bigroad.shared.duty.DutyLimits;
import com.bigroad.shared.model.C1108a;
import com.bigroad.shared.model.C1116d;
import com.bigroad.shared.model.C1127k;
import com.bigroad.shared.validation.model.DailyLogHeader;
import com.bigroad.ttb.android.C2474y;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.eobr.EobrDevice;
import com.bigroad.ttb.android.p029c.C1736b;
import com.bigroad.ttb.android.p029c.C1738c;
import com.bigroad.ttb.android.p029c.C1738c.C1737a;
import com.bigroad.ttb.android.util.C2295o;
import com.bigroad.ttb.android.util.ac;
import com.bigroad.ttb.android.widget.DailyLogHeaderView.MissingHeader;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import com.bigroad.ttb.protocol.TTProtocol.Geocode;
import com.bigroad.ttb.protocol.TTProtocol.Person;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import com.bigroad.ttb.protocol.TTProtocol.al;
import com.facebook.appevents.AppEventsConstants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class DailyLogInspectCurrentHeaderView extends DailyLogInspectHeaderView {
    protected TextView f8490g;
    private TextView f8491l;
    private TextView f8492m;
    private LinearLayout f8493n;
    private View f8494o;
    private TextView f8495p;
    private TextView f8496q;
    private TextView f8497r;
    private TextView f8498s;
    private TextView f8499t;
    private TextView f8500u;
    private TextView f8501v;
    private TextView f8502w;
    private TextView f8503x;

    public DailyLogInspectCurrentHeaderView(Context context) {
        super(context);
        mo1320a(context);
    }

    public DailyLogInspectCurrentHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void mo1320a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.daily_log_inspect_current_header_view, this);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f8490g = (TextView) findViewById(R.id.dailyLogHeader_coDriverEldId);
        this.f8491l = (TextView) findViewById(R.id.dailyLogHeader_inspectionDate);
        this.f8492m = (TextView) findViewById(R.id.dailyLogHeader_currentLocation);
        this.f8493n = (LinearLayout) findViewById(R.id.dailyLogHeader_truckList);
        this.f8494o = findViewById(R.id.dailyLogHeader_truckTotalDistanceGroup);
        this.f8495p = (TextView) findViewById(R.id.dailyLogHeader_truckNone);
        m11862a(this.f8495p, null);
        this.f8496q = (TextView) findViewById(R.id.dailyLogInspectCurrentHeader_manufacturer);
        this.f8497r = (TextView) findViewById(R.id.dailyLogInspectCurrentHeader_eldId);
        this.f8498s = (TextView) findViewById(R.id.dailyLogHeader_hosTimeDrivingToday);
        this.f8499t = (TextView) findViewById(R.id.dailyLogHeader_hosTimeOnDutyToday);
        this.f8500u = (TextView) findViewById(R.id.dailyLogHeader_hosTimeOnDuty7Days);
        this.f8501v = (TextView) findViewById(R.id.dailyLogHeader_hosTimeOnDuty8Days);
        this.f8502w = (TextView) findViewById(R.id.dailyLogHeader_hosCycleDutyRemaining);
        this.f8503x = (TextView) findViewById(R.id.dailyLogHeader_hosCycleDutyUsed);
    }

    protected boolean mo1323c() {
        return false;
    }

    protected boolean mo1330b() {
        return false;
    }

    protected boolean mo1321a(C1116d c1116d) {
        return !am.m4188a(c1116d.m5653C());
    }

    public void m11883a(int i, DailyLog dailyLog, C1116d c1116d) {
        CharSequence charSequence;
        super.m11860a(i, dailyLog, c1116d, true, false, MissingHeader.HIDE);
        TimeZone b = DailyLogUtils.m4305b(dailyLog);
        Locale locale = getContext().getResources().getConfiguration().locale;
        Calendar a = aq.m4224a(b, System.currentTimeMillis());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM dd, yyyy", locale);
        simpleDateFormat.setTimeZone(b);
        m11862a(this.f8491l, simpleDateFormat.format(a.getTime()));
        Geocode a2 = OurApplication.m6302x().m10597a();
        if (a2 == null) {
            charSequence = null;
        } else if (a2.hasRelativeLocation()) {
            charSequence = C1127k.m5706a(a2.getRelativeLocation());
        } else {
            charSequence = a2.getCity() + ", " + a2.getState();
        }
        m11862a(this.f8492m, charSequence);
        m11862a(this.f8496q, getResources().getString(R.string.dailyLogInspectCurrentHeader_eldManufacturer));
        EobrDevice j = OurApplication.m6252I().m11412j();
        m11862a(this.f8497r, j == null ? null : j.mo1122w());
        b = DailyLogUtils.m4305b(dailyLog);
        long b2 = OurApplication.m6269Z().mo914b();
        C1737a a3 = m11880a(b2, i, b);
        m11862a(this.f8498s, m11881a(a3.m8496a()));
        m11862a(this.f8499t, m11881a(a3.m8497b()) + " " + getResources().getString(R.string.dailyLogInspectSummary_includesDriving));
        m11862a(this.f8500u, m11881a(a3.m8498c()) + " " + getResources().getString(R.string.dailyLogInspectSummary_includesToday));
        m11862a(this.f8501v, m11881a(a3.m8499d()) + " " + getResources().getString(R.string.dailyLogInspectSummary_includesToday));
        m11882a(dailyLog, b2);
        mo1328a(null);
    }

    private void m11882a(DailyLog dailyLog, long j) {
        C0956v c0956v = new C0956v((al) dailyLog);
        C1736b r = OurApplication.m6296r();
        C2474y g = OurApplication.m6285g();
        DutyLimits a = DutyLimits.m4362a(c0956v.m4881o(), new C0898i(r.m8493g(), OurApplication.m6295q().m10025b(), j, g.m12229s()));
        this.f8502w.setText(m11881a(a.m4368d().m4402b()));
        this.f8503x.setText(m11881a(a.m4368d().m4403c() - a.m4368d().m4402b()));
    }

    protected void mo1329a(DailyLog dailyLog) {
        super.mo1329a(dailyLog);
        if (dailyLog.hasCodriverId()) {
            Person a = OurApplication.m6293o().m12138a(dailyLog.getCodriverId());
            if (a == null) {
                m11862a(this.f8490g, null);
                return;
            } else {
                m11862a(this.f8490g, a.getEmailAddress());
                return;
            }
        }
        m11862a(this.f8490g, null);
    }

    protected void mo1328a(DailyLogHeader dailyLogHeader) {
        if (m11872f()) {
            this.f8493n.removeAllViews();
            this.f8494o.setVisibility(8);
            Truck f = OurApplication.m6294p().m6578f();
            if (f != null) {
                Iterator a = this.a.m5663o().mo2684a();
                while (a.hasNext()) {
                    C1108a c1108a = (C1108a) a.next();
                    if (am.m4189a(f.getTruckNumber(), c1108a.m5490q())) {
                        View dailyLogHeaderTruckView = getDailyLogHeaderTruckView();
                        List arrayList = new ArrayList();
                        arrayList.add(new C2295o(c1108a, null));
                        dailyLogHeaderTruckView.setTruck(arrayList);
                        this.f8493n.addView(dailyLogHeaderTruckView);
                        this.f8495p.setVisibility(8);
                        return;
                    }
                }
            }
            this.f8495p.setVisibility(0);
        }
    }

    public static C1737a m11880a(long j, int i, TimeZone timeZone) {
        C1736b r = OurApplication.m6296r();
        C2474y g = OurApplication.m6285g();
        return C1738c.m8500a(new C0898i(r.m8493g(), OurApplication.m6295q().m10025b(), j, g.m12229s()), j, i, timeZone);
    }

    private String m11881a(long j) {
        if (j <= 0) {
            return AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        return ac.m11175a(j, getResources());
    }
}
