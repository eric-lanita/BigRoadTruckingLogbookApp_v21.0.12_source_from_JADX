package com.bigroad.ttb.android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bigroad.shared.af;
import com.bigroad.shared.ah;
import com.bigroad.shared.ak;
import com.bigroad.shared.am;
import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.shared.duty.C0874m;
import com.bigroad.shared.duty.C0954t;
import com.bigroad.shared.duty.C0956v;
import com.bigroad.shared.model.C1108a;
import com.bigroad.shared.model.C1116d;
import com.bigroad.shared.model.C1118e;
import com.bigroad.shared.validation.C1178r;
import com.bigroad.shared.validation.ValidationError.ErrorCode;
import com.bigroad.shared.validation.model.DailyLogHeader;
import com.bigroad.shared.validation.model.DailyLogHeader.Field;
import com.bigroad.shared.validation.model.DailyLogTruck;
import com.bigroad.ttb.android.C2315v;
import com.bigroad.ttb.android.C2476z.C2475a;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.aj;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.p029c.C1738c;
import com.bigroad.ttb.android.p039h.C2086b;
import com.bigroad.ttb.android.p039h.C2091e;
import com.bigroad.ttb.android.util.C2295o;
import com.bigroad.ttb.android.util.C2300s;
import com.bigroad.ttb.android.util.C2303v;
import com.bigroad.ttb.android.widget.RecapTable.Style;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import com.bigroad.ttb.protocol.TTProtocol.Fleet;
import com.bigroad.ttb.protocol.TTProtocol.OdometerUnit;
import com.bigroad.ttb.protocol.TTProtocol.RecapType;
import com.bigroad.ttb.protocol.TTProtocol.ct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DailyLogHeaderView extends LinearLayout {
    private TextView f8444A;
    private TextView f8445B;
    private TextView f8446C;
    private Button f8447D;
    private TextView f8448E;
    private int f8449F = -1;
    private boolean f8450G = false;
    private boolean f8451H = false;
    private boolean f8452I = false;
    private boolean f8453J = false;
    private C2036a f8454K = null;
    private C2303v f8455L;
    private C2303v f8456M;
    private final C2086b<Field> f8457N = new C2086b();
    private final OnClickListener f8458O = new C24141(this);
    private final aj f8459P = OurApplication.ai();
    protected C1116d f8460a = null;
    protected TextView f8461b;
    protected View f8462c;
    protected TextView f8463d;
    protected View f8464e;
    RecapTable f8465f;
    private LayoutInflater f8466g;
    private ViewGroup f8467h;
    private ViewGroup f8468i;
    private TextView f8469j;
    private Button f8470k;
    private TextView f8471l;
    private Button f8472m;
    private TextView f8473n;
    private TextView f8474o;
    private TextView f8475p;
    private TextView f8476q;
    private TextView f8477r;
    private TextView f8478s;
    private TextView f8479t;
    private TextView f8480u;
    private Button f8481v;
    private LinearLayout f8482w;
    private View f8483x;
    private TextView f8484y;
    private TextView f8485z;

    public interface C2036a {
        void mo1188a();
    }

    class C24141 implements OnClickListener {
        final /* synthetic */ DailyLogHeaderView f8440a;

        C24141(DailyLogHeaderView dailyLogHeaderView) {
            this.f8440a = dailyLogHeaderView;
        }

        public void onClick(View view) {
            this.f8440a.f8454K.mo1188a();
        }
    }

    public enum MissingHeader {
        HIDE,
        SHOW
    }

    public DailyLogHeaderView(Context context) {
        super(context);
        mo1320a(context);
    }

    public DailyLogHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2475a.DailyLogHeaderView);
        this.f8450G = obtainStyledAttributes.getBoolean(0, false);
        this.f8453J = obtainStyledAttributes.getBoolean(1, false);
        obtainStyledAttributes.recycle();
        mo1320a(context);
    }

    protected void mo1320a(Context context) {
        this.f8466g = LayoutInflater.from(context);
        this.f8466g.inflate(R.layout.daily_log_header_view, this);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f8455L = C2303v.m11257b(getResources().getDimensionPixelOffset(R.dimen.dailyLogHeader_indent));
        this.f8456M = C2303v.m11258c();
        this.f8467h = (ViewGroup) findViewById(R.id.dailyLogHeader_cards);
        this.f8468i = (ViewGroup) findViewById(R.id.dailyLogHeader_missing);
        this.f8469j = (TextView) findViewById(R.id.dailyLogHeader_missingText);
        this.f8469j.setText(R.string.validation.dailyLog.missingHeader);
        this.f8461b = (TextView) findViewById(R.id.dailyLogHeader_driverName);
        this.f8471l = (TextView) findViewById(R.id.dailyLogHeader_coDriverName);
        this.f8472m = (Button) findViewById(R.id.dailyLogHeader_driverEdit);
        this.f8473n = (TextView) findViewById(R.id.dailyLogHeader_carrierName);
        this.f8474o = (TextView) findViewById(R.id.dailyLogHeader_carrierDotNoLabel);
        this.f8475p = (TextView) findViewById(R.id.dailyLogHeader_carrierDotNo);
        this.f8476q = (TextView) findViewById(R.id.dailyLogHeader_carrierAddress);
        this.f8477r = (TextView) findViewById(R.id.dailyLogHeader_carrierHomeTerminalLabel);
        this.f8478s = (TextView) findViewById(R.id.dailyLogHeader_carrierHomeTerminal);
        this.f8479t = (TextView) findViewById(R.id.dailyLogHeader_carrierShippingDoc);
        this.f8480u = (TextView) findViewById(R.id.dailyLogHeader_carrierTrailer);
        this.f8481v = (Button) findViewById(R.id.dailyLogHeader_carrierEdit);
        this.f8482w = (LinearLayout) findViewById(R.id.dailyLogHeader_truckList);
        this.f8483x = findViewById(R.id.dailyLogHeader_truckTotalDistanceGroup);
        this.f8484y = (TextView) findViewById(R.id.dailyLogHeader_truckTotalDistance);
        this.f8485z = (TextView) findViewById(R.id.dailyLogHeader_truckTotalEngineHours);
        this.f8444A = (TextView) findViewById(R.id.dailyLogHeader_truckNone);
        m11862a(this.f8444A, null);
        this.f8445B = (TextView) findViewById(R.id.dailyLogHeader_hosTimeZone);
        this.f8446C = (TextView) findViewById(R.id.dailyLogHeader_hosCycle);
        this.f8447D = (Button) findViewById(R.id.dailyLogHeader_hosEdit);
        if (mo1323c()) {
            this.f8462c = findViewById(R.id.dailyLogHeader_hosRecapTypeLabel);
            this.f8463d = (TextView) findViewById(R.id.dailyLogHeader_hosRecapType);
        }
        this.f8448E = (TextView) findViewById(R.id.dailyLogHeader_remarks);
        if (mo1330b()) {
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.dailyLogHeader_recapContainer);
            this.f8465f = new RecapTable(getContext());
            this.f8465f.setUseMargins(false);
            viewGroup.addView(this.f8465f);
            this.f8464e = findViewById(R.id.dailyLogHeader_recapTomorrowNotAvailable);
        }
        m11855a(this.f8472m);
        m11855a(this.f8481v);
        m11855a(this.f8447D);
        this.f8470k = (Button) findViewById(R.id.dailyLogHeader_add);
        m11855a(this.f8470k);
        this.f8457N.m10463a(Field.DRIVER_NAME, this.f8461b);
        this.f8457N.m10463a(Field.TRAILERS, this.f8480u);
        this.f8457N.m10463a(Field.HOME_TERMINAL, this.f8478s);
        this.f8457N.m10463a(Field.SHIPMENTS, this.f8479t);
        this.f8457N.m10463a(Field.TOTAL_DISTANCE, this.f8484y);
        this.f8457N.m10463a(Field.CARRIER_NAME, this.f8473n);
        this.f8457N.m10463a(Field.CARRIER_ADDRESS, this.f8473n);
    }

    private void m11855a(View view) {
        if (view != null) {
            if (this.f8450G) {
                view.setOnClickListener(this.f8458O);
                view.setVisibility(0);
                return;
            }
            view.setOnClickListener(null);
            view.setVisibility(8);
        }
    }

    public void setIsEditable(boolean z) {
        this.f8450G = z;
        m11855a(this.f8472m);
        m11855a(this.f8481v);
        m11855a(this.f8447D);
        m11855a(this.f8470k);
    }

    public void setOnEditClickedListener(C2036a c2036a) {
        this.f8454K = c2036a;
    }

    public boolean m11865a() {
        return this.f8451H;
    }

    public void m11860a(int i, DailyLog dailyLog, C1116d c1116d, boolean z, boolean z2, MissingHeader missingHeader) {
        OdometerUnit odometerUnit = null;
        this.f8449F = i;
        this.f8460a = c1116d;
        this.f8452I = z2;
        this.f8451H = z;
        if (this.f8451H) {
            this.f8467h.setVisibility(0);
            this.f8468i.setVisibility(8);
        } else {
            this.f8467h.setVisibility(8);
            if (missingHeader == MissingHeader.HIDE) {
                this.f8468i.setVisibility(8);
            } else {
                this.f8468i.setVisibility(0);
            }
        }
        this.f8455L.m11265a();
        mo1322b(c1116d);
        mo1329a(dailyLog);
        m11862a(this.f8473n, c1116d.m5651A());
        Fleet b = OurApplication.m6292n().m11013b();
        if (mo1324d()) {
            CharSequence charSequence;
            this.f8474o.setVisibility(0);
            this.f8475p.setVisibility(0);
            TextView textView = this.f8475p;
            if (b == null || !b.hasDotNumber()) {
                charSequence = null;
            } else {
                charSequence = String.valueOf(b.getDotNumber());
            }
            m11862a(textView, charSequence);
        } else {
            this.f8474o.setVisibility(8);
            this.f8475p.setVisibility(8);
        }
        m11862a(this.f8476q, c1116d.m5652B());
        if (mo1321a(c1116d)) {
            this.f8477r.setVisibility(0);
            this.f8478s.setVisibility(0);
            m11862a(this.f8478s, c1116d.m5653C());
        } else {
            this.f8477r.setVisibility(8);
            this.f8478s.setVisibility(8);
        }
        m11862a(this.f8479t, c1116d.m5654D());
        m11858b(c1116d, this.f8459P.m8387b());
        m11857a(c1116d, this.f8459P.m8384a());
        if (c1116d.m5671w()) {
            String num = Integer.toString(c1116d.m5670v().intValue());
            if (c1116d.m5673y()) {
                odometerUnit = c1116d.m5672x().m5472b();
            }
            this.f8484y.setText(af.m4154a(num, odometerUnit));
        } else {
            m11862a(this.f8484y, null);
        }
        if (mo1325e()) {
            this.f8485z.setVisibility(0);
            findViewById(R.id.dailyLogHeader_truckTotalEngineHoursLabel).setVisibility(0);
            num = DailyLogUtils.m4296a(c1116d.m5659I());
            this.f8485z.setText(getResources().getString(R.string.dailyLogHeader_engineHoursValueDisplay, new Object[]{num}));
        } else {
            this.f8485z.setVisibility(8);
            findViewById(R.id.dailyLogHeader_truckTotalEngineHoursLabel).setVisibility(8);
        }
        m11862a(this.f8445B, com.bigroad.ttb.android.af.m8283a(c1116d.m4424b(), getContext()));
        m11862a(this.f8446C, C1738c.m8505a(new C0956v((C0874m) c1116d), getContext()));
        if (mo1323c()) {
            m11862a(this.f8463d, C2300s.m11251a(getResources(), c1116d.m5656F().m5476a()));
        }
        m11862a(this.f8448E, c1116d.m5655E());
        if (mo1330b()) {
            m11859b(dailyLog);
        }
        m11873g();
    }

    protected boolean mo1330b() {
        return true;
    }

    protected boolean mo1323c() {
        return true;
    }

    protected boolean mo1321a(C1116d c1116d) {
        return true;
    }

    protected boolean mo1324d() {
        return true;
    }

    protected C2455e getDailyLogHeaderTruckView() {
        return new C2455e(getContext());
    }

    protected boolean mo1325e() {
        return this.f8460a == null ? false : this.f8460a.m5665q();
    }

    protected void mo1322b(C1116d c1116d) {
        m11862a(this.f8461b, c1116d.m5660l());
    }

    protected void mo1329a(DailyLog dailyLog) {
        CharSequence charSequence = null;
        if (dailyLog.hasCodriverId()) {
            ct a = OurApplication.m6293o().m12138a(dailyLog.getCodriverId());
            if (a == null) {
                m11862a(this.f8471l, null);
                return;
            } else {
                m11862a(this.f8471l, ah.m4160a(a));
                return;
            }
        }
        if (dailyLog.hasCodriversDeprecated()) {
            charSequence = dailyLog.getCodriversDeprecated();
        }
        m11862a(this.f8471l, charSequence);
    }

    private void m11859b(DailyLog dailyLog) {
        if (dailyLog != null) {
            RecapType a = RecapType.m14775a(dailyLog.getRecapType());
            if (a == RecapType.NO_RECAP || !m11865a()) {
                this.f8465f.setVisibility(8);
                this.f8464e.setVisibility(8);
                return;
            }
            this.f8465f.setVisibility(0);
            C0954t a2 = C2300s.m11249a(dailyLog, OurApplication.m6269Z().mo914b());
            this.f8465f.m12000a(a, a2.m4852b(), dailyLog.getLogDay(), DailyLogUtils.m4305b(dailyLog), ak.m4181a(a2, getResources().getConfiguration().locale), this.f8453J ? Style.LIGHT : Style.DARK);
            if (this.f8465f.m12001a()) {
                this.f8464e.setVisibility(8);
            } else {
                this.f8464e.setVisibility(0);
            }
        }
    }

    protected void mo1328a(DailyLogHeader dailyLogHeader) {
        int i = 8;
        if (m11872f()) {
            Iterator it;
            Iterator a;
            DailyLogTruck dailyLogTruck;
            DailyLogTruck dailyLogTruck2;
            Object obj;
            int i2;
            this.f8482w.removeAllViews();
            Map hashMap = new HashMap();
            if (dailyLogHeader != null) {
                List arrayList = new ArrayList();
                arrayList.addAll(dailyLogHeader.mo833j());
                arrayList.addAll(dailyLogHeader.mo834k());
                it = arrayList.iterator();
            } else {
                it = null;
            }
            if (!this.f8460a.m5663o().isEmpty()) {
                a = this.f8460a.m5663o().mo2684a();
                while (a.hasNext()) {
                    C1108a c1108a = (C1108a) a.next();
                    dailyLogTruck = (it == null || !it.hasNext()) ? null : (DailyLogTruck) it.next();
                    if (dailyLogTruck == null || am.m4189a(dailyLogTruck.mo823b(), c1108a.m5490q())) {
                        dailyLogTruck2 = dailyLogTruck;
                    } else {
                        C2134e.m10676b("TT-DailyLogHeaderView", "Unexpected view/truck mismatch");
                        obj = null;
                    }
                    if (!hashMap.containsKey(c1108a.m5490q())) {
                        hashMap.put(c1108a.m5490q(), new ArrayList());
                    }
                    ((List) hashMap.get(c1108a.m5490q())).add(new C2295o(c1108a, obj));
                }
            }
            if (!this.f8460a.m5666r().isEmpty()) {
                it = dailyLogHeader != null ? dailyLogHeader.mo832i().iterator() : null;
                a = this.f8460a.m5666r().mo2684a();
                while (a.hasNext()) {
                    C1118e c1118e = (C1118e) a.next();
                    if (it == null || !it.hasNext()) {
                        dailyLogTruck = null;
                    } else {
                        dailyLogTruck = (DailyLogTruck) it.next();
                    }
                    if (dailyLogTruck == null || dailyLogTruck.mo823b().equals(c1118e.m5490q())) {
                        dailyLogTruck2 = dailyLogTruck;
                    } else {
                        C2134e.m10676b("TT-DailyLogHeaderView", "Unexpected view/truck mismatch");
                        obj = null;
                    }
                    if (!hashMap.containsKey(c1118e.m5490q())) {
                        hashMap.put(c1118e.m5490q(), new ArrayList());
                    }
                    ((List) hashMap.get(c1118e.m5490q())).add(new C2295o(c1118e, obj));
                }
            }
            for (Entry entry : hashMap.entrySet()) {
                View dailyLogHeaderTruckView = getDailyLogHeaderTruckView();
                dailyLogHeaderTruckView.setTruck((List) entry.getValue());
                this.f8482w.addView(dailyLogHeaderTruckView);
            }
            View view = this.f8483x;
            if (hashMap.size() > 1) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            view.setVisibility(i2);
            TextView textView = this.f8444A;
            if (hashMap.size() <= 0) {
                i = 0;
            }
            textView.setVisibility(i);
        }
    }

    public boolean m11872f() {
        return this.f8449F >= 0 && this.f8460a != null;
    }

    public void m11873g() {
        DailyLogHeader dailyLogHeader = null;
        if (!m11872f()) {
            return;
        }
        if (this.f8452I) {
            C2315v t = OurApplication.m6298t();
            this.f8457N.m10462a(t.m11308g(this.f8449F));
            this.f8469j.setCompoundDrawablesWithIntrinsicBounds(C2091e.m10475a(C1178r.m5972a(t.m11307f(this.f8449F), ErrorCode.DAILY_LOG_HEADER_MISSING)), 0, 0, 0);
            com.bigroad.shared.validation.model.DailyLog c = t.m11304c(this.f8449F);
            if (c != null) {
                dailyLogHeader = c.mo858b();
            }
            mo1328a(dailyLogHeader);
            return;
        }
        mo1328a(null);
    }

    protected void m11862a(TextView textView, CharSequence charSequence) {
        m11856a(textView, charSequence, true);
    }

    private void m11856a(TextView textView, CharSequence charSequence, boolean z) {
        C2303v c2303v = z ? this.f8455L : this.f8456M;
        if (am.m4188a(charSequence)) {
            c2303v.m11267b(getResources().getString(R.string.none));
        } else {
            c2303v.m11268c(charSequence);
        }
        textView.setText(c2303v.m11270e());
    }

    private void m11857a(C1116d c1116d, String str) {
        if (c1116d.m5657G().isEmpty()) {
            m11862a(this.f8480u, c1116d.m5674z());
        } else {
            m11856a(this.f8480u, m11854a(c1116d.m5657G(), str), false);
        }
    }

    private void m11858b(C1116d c1116d, String str) {
        if (c1116d.m5658H().isEmpty()) {
            m11862a(this.f8479t, c1116d.m5654D());
        } else {
            m11856a(this.f8479t, m11854a(c1116d.m5658H(), str), false);
        }
    }

    private String m11854a(List<String> list, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str2 : list) {
            if (stringBuilder.length() != 0) {
                stringBuilder.append("\r\n");
            }
            stringBuilder.append(str2);
            if (am.m4189a(str2, str)) {
                stringBuilder.append(" (" + getResources().getString(R.string.dailyLogHeader_currentObject) + ")");
            }
        }
        return stringBuilder.toString();
    }
}
