package com.bigroad.ttb.android.widget;

import android.content.Context;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bigroad.shared.af;
import com.bigroad.shared.am;
import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.shared.model.C1107b;
import com.bigroad.shared.model.C1108a;
import com.bigroad.shared.model.CanonicalOdometerUnit;
import com.bigroad.shared.validation.C1176p;
import com.bigroad.shared.validation.C1178r;
import com.bigroad.shared.validation.ValidationError.ErrorCode;
import com.bigroad.shared.validation.model.DailyLogTruck;
import com.bigroad.shared.validation.model.DailyLogTruck.Field;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.p039h.C2091e;
import com.bigroad.ttb.android.util.C2295o;
import com.bigroad.ttb.android.util.C2303v;
import com.bigroad.ttb.android.util.ac;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import com.bigroad.ttb.protocol.TTProtocol.TruckLogType;
import java.util.List;

public class C2455e extends LinearLayout {
    private LayoutInflater f8768a;
    private TruckInfoView f8769b;
    private TextView f8770c;
    private TextView f8771d;
    private ViewGroup f8772e;
    private TextView f8773f;
    private TextView f8774g;
    private TextView f8775h;
    private C2303v f8776i;

    public C2455e(Context context) {
        super(context);
        m12092a(context);
    }

    private void m12092a(Context context) {
        this.f8768a = LayoutInflater.from(context);
        this.f8768a.inflate(R.layout.daily_log_section_truck_entry, this);
        this.f8776i = C2303v.m11257b(getResources().getDimensionPixelOffset(R.dimen.dailyLogHeader_indent));
        this.f8769b = (TruckInfoView) findViewById(R.id.dailyLogHeaderTruck_truckId);
        this.f8770c = (TextView) findViewById(R.id.dailyLogHeaderTruck_vinLabel);
        this.f8771d = (TextView) findViewById(R.id.dailyLogHeaderTruck_vin);
        this.f8772e = (ViewGroup) findViewById(R.id.dailyLogHeaderTruck_odometerGroup);
        this.f8773f = (TextView) findViewById(R.id.dailyLogHeaderTruck_distance);
        this.f8774g = (TextView) findViewById(R.id.dailyLogHeaderTruck_engine);
        this.f8775h = (TextView) findViewById(R.id.dailyLogHeaderTruck_engineHours);
        m12094b();
    }

    public void setTruck(List<C2295o<C1107b, DailyLogTruck>> list) {
        C1108a c1108a;
        String a;
        CanonicalOdometerUnit canonicalOdometerUnit;
        TruckLogType truckLogType = TruckLogType.ELECTRONIC;
        TruckLogType truckLogType2 = truckLogType;
        for (C2295o c2295o : list) {
            truckLogType = ((C1107b) c2295o.f7935a).m5486m();
            if (truckLogType.ordinal() <= truckLogType2.ordinal()) {
                truckLogType = truckLogType2;
            }
            truckLogType2 = truckLogType;
        }
        String q = ((C1107b) ((C2295o) list.get(0)).f7935a).m5490q();
        this.f8769b.m12041a(q, truckLogType2);
        m12094b();
        String str = "";
        for (C2295o c2295o2 : list) {
            if (c2295o2.f7935a instanceof C1108a) {
                c1108a = (C1108a) c2295o2.f7935a;
                if (!am.m4188a(c1108a.m5504a())) {
                    a = c1108a.m5504a();
                    break;
                }
            }
        }
        a = str;
        Truck c = OurApplication.m6294p().m6572c(q);
        if (am.m4188a((CharSequence) a) && c != null) {
            a = c.getVin();
        }
        if (mo1345a(truckLogType2)) {
            ac.m11182a(this.f8771d, a);
        } else {
            this.f8771d.setVisibility(8);
            this.f8770c.setVisibility(8);
        }
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        long j = 0;
        for (C2295o c2295o22 : list) {
            i += m12091a(c2295o22);
            if (mo1346b(truckLogType2) && c2295o22.f7935a != null && (c2295o22.f7935a instanceof C1108a)) {
                c1108a = (C1108a) c2295o22.f7935a;
                if (c1108a.m5486m().equals(TruckLogType.ELD)) {
                    Long l = c1108a.m5515l();
                    if (l != null) {
                        j += l.longValue();
                        Long j2 = c1108a.m5513j();
                        if (j2 != null) {
                            long longValue = j2.longValue() - l.longValue();
                            if (stringBuilder.length() > 0) {
                                stringBuilder.append("\n");
                            }
                            stringBuilder.append(getResources().getString(R.string.dailyLogHeader_engineHoursRangeDisplay, new Object[]{DailyLogUtils.m4296a(Long.valueOf(longValue)), DailyLogUtils.m4296a(j2)}));
                        }
                    }
                }
            }
            j = j;
        }
        CanonicalOdometerUnit canonicalOdometerUnit2 = null;
        for (C2295o c2295o222 : list) {
            if (c2295o222.f7935a == null || !((C1107b) c2295o222.f7935a).m5494u()) {
                canonicalOdometerUnit = canonicalOdometerUnit2;
            } else {
                canonicalOdometerUnit = ((C1107b) c2295o222.f7935a).m5492s();
            }
            if (canonicalOdometerUnit == CanonicalOdometerUnit.MILES) {
                break;
            }
            canonicalOdometerUnit2 = canonicalOdometerUnit;
        }
        canonicalOdometerUnit = canonicalOdometerUnit2;
        if (canonicalOdometerUnit == null) {
            canonicalOdometerUnit = CanonicalOdometerUnit.MILES;
        }
        this.f8773f.setText(Integer.toString((int) Math.round(canonicalOdometerUnit.m5471b((long) i))) + (" " + af.m4153a(canonicalOdometerUnit.m5472b())));
        if (mo1346b(truckLogType2)) {
            this.f8774g.setText(stringBuilder.toString());
            this.f8775h.setText(getResources().getString(R.string.dailyLogHeader_engineHoursValueDisplay, new Object[]{DailyLogUtils.m4296a(Long.valueOf(j))}));
            return;
        }
        this.f8774g.setVisibility(8);
        this.f8775h.setVisibility(8);
        findViewById(R.id.dailyLogHeaderTruck_engineLabel).setVisibility(8);
        findViewById(R.id.dailyLogHeaderTruck_engineHoursLabel).setVisibility(8);
    }

    private int m12091a(C2295o<C1107b, DailyLogTruck> c2295o) {
        CharSequence num;
        C1176p c1176p = null;
        C1107b c1107b = (C1107b) c2295o.f7935a;
        DailyLogTruck dailyLogTruck = (DailyLogTruck) c2295o.f7936b;
        View inflate = this.f8768a.inflate(R.layout.daily_log_section_truck_odometer, null);
        TextView textView = (TextView) inflate.findViewById(R.id.dailyLogHeaderOdometer_label);
        TextView textView2 = (TextView) inflate.findViewById(R.id.dailyLogHeaderOdometer_value);
        if (dailyLogTruck != null) {
            c1176p = dailyLogTruck.mo716A();
        }
        CharSequence string = getResources().getString(R.string.dailyLogHeader_none);
        C2303v c = C2303v.m11258c();
        if (c1107b.m5487n() && !c1107b.m5488o()) {
            textView.setText(R.string.dailyLogHeaderTruck_startOdometerLabel);
        } else if (!c1107b.m5488o() || c1107b.m5487n()) {
            textView.setVisibility(8);
        } else {
            textView.setText(R.string.dailyLogHeaderTruck_endOdometerLabel);
        }
        if (c1107b.m5487n()) {
            num = Integer.toString(c1107b.mo779f().intValue());
            if (C1178r.m5978a(c1176p, Field.START_ODOMETER, ErrorCode.DAILY_LOG_TRUCK_GAP)) {
                c.m11264a(num, new ForegroundColorSpan(getResources().getColor(R.color.validationError)));
            } else {
                c.m11268c(num);
            }
            if (c1107b.m5488o()) {
                c.m11268c(" - ");
            }
        }
        if (c1107b.m5488o()) {
            num = Integer.toString(c1107b.mo780g().intValue());
            if (C1178r.m5978a(c1176p, Field.END_ODOMETER, ErrorCode.DAILY_LOG_TRUCK_GAP)) {
                c.m11264a(num, new ForegroundColorSpan(getResources().getColor(R.color.validationError)));
            } else {
                c.m11268c(num);
            }
        }
        if (c1107b.m5494u() && !c.m11269d()) {
            c.m11260a(' ').m11268c(c1107b.m5492s().m5470a());
        }
        if (c.m11269d()) {
            textView2.setText(this.f8776i.m11267b(string).m11270e());
        } else {
            textView2.setText(c.m11270e());
        }
        if (dailyLogTruck != null) {
            m12093a(dailyLogTruck.mo716A(), inflate);
        }
        CanonicalOdometerUnit s = c1107b.m5494u() ? c1107b.m5492s() : CanonicalOdometerUnit.MILES;
        this.f8772e.addView(inflate);
        if (c1107b.m5489p()) {
            return (int) Math.round(s.m5469a((long) c1107b.mo781i().intValue()));
        }
        return 0;
    }

    protected boolean mo1344a() {
        return false;
    }

    private void m12094b() {
        this.f8769b.m12042a(mo1344a(), false, false);
    }

    private void m12093a(C1176p<Field> c1176p, View view) {
        C2091e.m10479a(c1176p, (TextView) view.findViewById(R.id.dailyLogHeaderOdometer_value), Field.START_ODOMETER, Field.END_ODOMETER);
        View findViewById = view.findViewById(R.id.dailyLogHeaderOdometer_validationErrorGroup);
        TextView textView = (TextView) view.findViewById(R.id.dailyLogHeaderTruck_startOdometerErrorText);
        TextView textView2 = (TextView) view.findViewById(R.id.dailyLogHeaderTruck_endOdometerErrorText);
        List b = c1176p.m5961b(Field.START_ODOMETER);
        if (C1178r.m5980a(b, ErrorCode.DAILY_LOG_TRUCK_GAP)) {
            textView.setText(C2091e.m10476a(b, getContext()));
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        b = c1176p.m5961b(Field.END_ODOMETER);
        if (C1178r.m5980a(b, ErrorCode.DAILY_LOG_TRUCK_GAP)) {
            textView2.setText(C2091e.m10476a(b, getContext()));
            textView2.setVisibility(0);
        } else {
            textView2.setVisibility(8);
        }
        if (textView.getVisibility() == 8 && textView2.getVisibility() == 8) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
    }

    protected boolean mo1345a(TruckLogType truckLogType) {
        return true;
    }

    protected boolean mo1346b(TruckLogType truckLogType) {
        return truckLogType == TruckLogType.ELD;
    }
}
