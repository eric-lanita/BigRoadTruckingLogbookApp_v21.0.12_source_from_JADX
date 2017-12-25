package com.bigroad.ttb.android.widget;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.bigroad.shared.af;
import com.bigroad.shared.am;
import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.shared.model.C1108a;
import com.bigroad.shared.validation.C1176p;
import com.bigroad.shared.validation.C1178r;
import com.bigroad.shared.validation.ValidationError.ErrorCode;
import com.bigroad.shared.validation.model.DailyLogTruck.Field;
import com.bigroad.shared.validation.p024b.C1148b;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.DailyLogEditHeaderActivity;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.p039h.C2091e;
import com.bigroad.ttb.android.util.ac;
import com.bigroad.ttb.protocol.TTProtocol.DailyLogTruck;
import com.bigroad.ttb.protocol.TTProtocol.DailyLogTruck.C2602a;
import com.bigroad.ttb.protocol.TTProtocol.OdometerUnit;
import com.bigroad.ttb.protocol.TTProtocol.TruckLogType;
import com.google.protobuf.C3642c;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.List;

public class DailyLogEditHeaderTruckView extends C1148b {
    private boolean f8357A;
    private final DailyLogEditHeaderActivity f8358a;
    private final View f8359b;
    private final TruckInfoView f8360c;
    private final ImageView f8361d;
    private final View f8362e;
    private final TextView f8363f;
    private final EditText f8364g;
    private final EditText f8365h;
    private final EditText f8366i;
    private final TextView f8367j;
    private final TextView f8368k;
    private final TextView f8369l;
    private final View f8370m;
    private final EditText f8371n;
    private final EditText f8372o;
    private final ImageView f8373p;
    private final ImageView f8374q;
    private final ImageView f8375r;
    private final TextView f8376s;
    private final TextView f8377t;
    private final TextView f8378u;
    private TruckLogType f8379v;
    private DailyLogTruck f8380w;
    private C1108a f8381x;
    private int f8382y;
    private C2460i f8383z;

    class C24111 implements OnClickListener {
        final /* synthetic */ DailyLogEditHeaderTruckView f8354a;

        C24111(DailyLogEditHeaderTruckView dailyLogEditHeaderTruckView) {
            this.f8354a = dailyLogEditHeaderTruckView;
        }

        public void onClick(View view) {
            this.f8354a.f8358a.m7142a(this.f8354a);
        }
    }

    public static final class ParcelableTruckSection implements Parcelable {
        public static final Creator<ParcelableTruckSection> CREATOR = new C24121();
        private DailyLogTruck f8355a;
        private boolean f8356b;

        static class C24121 implements Creator<ParcelableTruckSection> {
            C24121() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m11800a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m11801a(i);
            }

            public ParcelableTruckSection m11800a(Parcel parcel) {
                return new ParcelableTruckSection(parcel);
            }

            public ParcelableTruckSection[] m11801a(int i) {
                return new ParcelableTruckSection[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public ParcelableTruckSection(DailyLogEditHeaderTruckView dailyLogEditHeaderTruckView) {
            this.f8355a = dailyLogEditHeaderTruckView.m11823o();
            this.f8356b = dailyLogEditHeaderTruckView.m11816h();
        }

        public ParcelableTruckSection(DailyLogTruck dailyLogTruck) {
            this.f8355a = dailyLogTruck;
            this.f8356b = false;
        }

        public DailyLogTruck m11802a() {
            return this.f8355a;
        }

        public boolean m11803b() {
            return this.f8356b;
        }

        private ParcelableTruckSection(Parcel parcel) {
            ClassLoader classLoader = ParcelableTruckSection.class.getClassLoader();
            byte[] bArr = (byte[]) parcel.readValue(classLoader);
            if (bArr != null) {
                try {
                    this.f8355a = DailyLogTruck.parseFrom(C3642c.m19078a(bArr));
                } catch (InvalidProtocolBufferException e) {
                    C2134e.m10680d("TT-ParcelableTruckSection", "Unable to unpack saved DailyLogTruck instance state: " + e);
                }
            }
            this.f8356b = ((Boolean) parcel.readValue(classLoader)).booleanValue();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeValue(this.f8355a.toByteArray());
            parcel.writeValue(Boolean.valueOf(this.f8356b));
        }
    }

    public static DailyLogEditHeaderTruckView m11805a(DailyLogEditHeaderActivity dailyLogEditHeaderActivity, ParcelableTruckSection parcelableTruckSection) {
        if (parcelableTruckSection.m11802a() == null) {
            return null;
        }
        DailyLogEditHeaderTruckView dailyLogEditHeaderTruckView = new DailyLogEditHeaderTruckView(dailyLogEditHeaderActivity, parcelableTruckSection.m11802a());
        dailyLogEditHeaderTruckView.m11810b(parcelableTruckSection.m11803b());
        return dailyLogEditHeaderTruckView;
    }

    private DailyLogEditHeaderTruckView(DailyLogEditHeaderActivity dailyLogEditHeaderActivity) {
        this.f8358a = dailyLogEditHeaderActivity;
        this.f8359b = LayoutInflater.from(this.f8358a).inflate(R.layout.daily_log_edit_section_truck_entry, null);
        this.f8360c = (TruckInfoView) this.f8359b.findViewById(R.id.dailyLogEditHeaderTruck_truckId);
        this.f8362e = this.f8359b.findViewById(R.id.dailyLogEditHeaderTruck_vinGroup);
        this.f8363f = (EditText) this.f8359b.findViewById(R.id.dailyLogEditHeaderTruck_vin);
        this.f8364g = (EditText) this.f8359b.findViewById(R.id.dailyLogEditHeaderTruck_startOdometer);
        this.f8365h = (EditText) this.f8359b.findViewById(R.id.dailyLogEditHeaderTruck_endOdometer);
        this.f8366i = (EditText) this.f8359b.findViewById(R.id.dailyLogEditHeaderTruck_totalDistance);
        this.f8367j = (TextView) this.f8359b.findViewById(R.id.dailyLogEditHeaderTruck_startOdometerUnit);
        this.f8368k = (TextView) this.f8359b.findViewById(R.id.dailyLogEditHeaderTruck_endOdometerUnit);
        this.f8369l = (TextView) this.f8359b.findViewById(R.id.dailyLogEditHeaderTruck_totalDistanceUnit);
        this.f8361d = (ImageView) this.f8359b.findViewById(R.id.dailyLogEditHeaderTruck_removeTruck);
        this.f8370m = this.f8359b.findViewById(R.id.dailyLogEditHeaderTruck_engineGroup);
        this.f8371n = (EditText) this.f8359b.findViewById(R.id.dailyLogEditHeaderTruck_engine);
        this.f8372o = (EditText) this.f8359b.findViewById(R.id.dailyLogEditHeaderTruck_engineHours);
        this.f8373p = (ImageView) this.f8359b.findViewById(R.id.dailyLogEditHeaderTruck_odometerError);
        this.f8374q = (ImageView) this.f8359b.findViewById(R.id.dailyLogEditHeaderTruck_endOdometerError);
        this.f8375r = (ImageView) this.f8359b.findViewById(R.id.dailyLogEditHeaderTruck_totalDistanceError);
        this.f8376s = (TextView) this.f8359b.findViewById(R.id.dailyLogEditHeaderTruck_odometerErrorText);
        this.f8377t = (TextView) this.f8359b.findViewById(R.id.dailyLogEditHeaderTruck_endOdometerErrorText);
        this.f8378u = (TextView) this.f8359b.findViewById(R.id.dailyLogEditHeaderTruck_totalDistanceErrorText);
    }

    public DailyLogEditHeaderTruckView(DailyLogEditHeaderActivity dailyLogEditHeaderActivity, DailyLogTruck dailyLogTruck) {
        CharSequence num;
        CharSequence charSequence = null;
        this(dailyLogEditHeaderActivity);
        this.f8379v = TruckLogType.ELECTRONIC;
        this.f8362e.setVisibility(8);
        this.f8370m.setVisibility(8);
        this.f8364g.setId(ac.m11171a());
        this.f8365h.setId(ac.m11171a());
        this.f8366i.setId(ac.m11171a());
        this.f8380w = dailyLogTruck;
        this.f8382y = -1;
        this.f8357A = false;
        this.f8360c.m12041a(this.f8380w.getTruckNumber(), this.f8379v);
        ac.m11179a(this.f8364g, this.f8380w.hasStartOdometer() ? Integer.toString(this.f8380w.getStartOdometer()) : null);
        EditText editText = this.f8365h;
        if (this.f8380w.hasEndOdometer()) {
            num = Integer.toString(this.f8380w.getEndOdometer());
        } else {
            num = null;
        }
        ac.m11179a(editText, num);
        EditText editText2 = this.f8366i;
        if (this.f8380w.hasDistance()) {
            charSequence = Integer.toString(this.f8380w.getDistance());
        }
        ac.m11179a(editText2, charSequence);
        m11806q();
        this.f8383z = new C2460i(this.f8364g, this.f8365h, this.f8366i);
        this.f8364g.addTextChangedListener(this.f8383z);
        this.f8365h.addTextChangedListener(this.f8383z);
        TextWatcher h = this.f8358a.mo974h();
        this.f8364g.addTextChangedListener(h);
        this.f8365h.addTextChangedListener(h);
        this.f8366i.addTextChangedListener(h);
        this.f8366i.addTextChangedListener(this.f8358a.mo961i());
        this.f8361d.setOnClickListener(new C24111(this));
    }

    public DailyLogEditHeaderTruckView(DailyLogEditHeaderActivity dailyLogEditHeaderActivity, C1108a c1108a) {
        CharSequence num;
        CharSequence charSequence = null;
        this(dailyLogEditHeaderActivity);
        this.f8379v = c1108a.m5486m();
        this.f8381x = c1108a;
        if (this.f8379v != TruckLogType.ELD) {
            this.f8370m.setVisibility(8);
        } else {
            Long valueOf = Long.valueOf(c1108a.m5513j().longValue() - c1108a.m5515l().longValue());
            this.f8371n.setText(dailyLogEditHeaderActivity.getResources().getString(R.string.dailyLogHeader_engineHoursRangeWithDashDisplay, new Object[]{DailyLogUtils.m4296a(valueOf), DailyLogUtils.m4296a(r0)}));
            this.f8372o.setText(c1108a.m5514k());
        }
        this.f8361d.setVisibility(8);
        this.f8363f.setEnabled(false);
        this.f8364g.setEnabled(false);
        this.f8365h.setEnabled(false);
        this.f8366i.setEnabled(false);
        this.f8371n.setEnabled(false);
        this.f8372o.setEnabled(false);
        this.f8360c.m12041a(this.f8381x.m5490q(), this.f8379v);
        ac.m11182a(this.f8363f, this.f8381x.m5504a());
        this.f8364g.setText(this.f8381x.m5487n() ? Integer.toString(this.f8381x.mo779f().intValue()) : null);
        EditText editText = this.f8365h;
        if (this.f8381x.m5488o()) {
            num = Integer.toString(this.f8381x.mo780g().intValue());
        } else {
            num = null;
        }
        editText.setText(num);
        EditText editText2 = this.f8366i;
        if (this.f8381x.m5489p()) {
            charSequence = Integer.toString(this.f8381x.mo781i().intValue());
        }
        editText2.setText(charSequence);
        m11806q();
    }

    private void m11806q() {
        if (mo782t() != null) {
            CharSequence a = af.m4153a(mo782t());
            if (am.m4188a(a)) {
                this.f8367j.setVisibility(8);
                this.f8368k.setVisibility(8);
                this.f8369l.setVisibility(8);
                return;
            }
            this.f8367j.setText(a);
            this.f8368k.setText(a);
            this.f8369l.setText(a);
            return;
        }
        this.f8367j.setVisibility(8);
        this.f8368k.setVisibility(8);
        this.f8369l.setVisibility(8);
    }

    public void m11811c() {
        if (this.f8383z != null) {
            this.f8364g.removeTextChangedListener(this.f8383z);
            this.f8365h.removeTextChangedListener(this.f8383z);
            this.f8383z = null;
        }
        TextWatcher h = this.f8358a.mo974h();
        this.f8364g.removeTextChangedListener(h);
        this.f8365h.removeTextChangedListener(h);
        this.f8366i.removeTextChangedListener(h);
        this.f8366i.removeTextChangedListener(this.f8358a.mo961i());
    }

    public View m11812d() {
        return this.f8359b;
    }

    public void m11807a(int i) {
        this.f8382y = i;
    }

    public int m11813e() {
        return this.f8382y;
    }

    public boolean m11816h() {
        return this.f8357A;
    }

    public void m11810b(boolean z) {
        this.f8357A = z;
    }

    public TruckLogType m11818j() {
        return this.f8379v;
    }

    public int a_() {
        return this.f8358a.a_();
    }

    public String mo823b() {
        if (this.f8379v == TruckLogType.ELECTRONIC) {
            return this.f8380w.getTruckNumber();
        }
        return this.f8381x.m5490q();
    }

    public String m11819k() {
        return null;
    }

    public Integer mo779f() {
        return ac.m11173a(this.f8364g);
    }

    public Integer mo780g() {
        return ac.m11173a(this.f8365h);
    }

    public Integer mo781i() {
        return ac.m11173a(this.f8366i);
    }

    public OdometerUnit mo782t() {
        if (this.f8379v == TruckLogType.ELECTRONIC) {
            if (this.f8380w.hasOdometerUnit()) {
                return OdometerUnit.m14668a(this.f8380w.getOdometerUnit());
            }
        } else if (this.f8381x.m5494u()) {
            return this.f8381x.m5492s().m5472b();
        }
        return null;
    }

    public void m11820l() {
        this.f8364g.requestFocus();
    }

    public EditText m11821m() {
        return this.f8364g;
    }

    public void m11822n() {
        if (ac.m11173a(this.f8366i) == null) {
            this.f8383z.m12105a();
        }
    }

    public void m11808a(C1176p<Field> c1176p, Context context) {
        List b = c1176p.m5961b(Field.START_ODOMETER);
        List b2 = c1176p.m5961b(Field.END_ODOMETER);
        List b3 = c1176p.m5961b(Field.TOTAL_DISTANCE);
        C2091e.m10477a(b, this.f8373p, this.f8376s, context);
        C2091e.m10477a(b2, this.f8374q, this.f8377t, context);
        C2091e.m10477a(b3, this.f8375r, this.f8378u, context);
        if (C1178r.m5980a(b3, ErrorCode.DAILY_LOG_TRUCK_TOTAL_DISTANCE_INCORRECT)) {
            CharSequence a = C2460i.m12103a(this.f8364g, this.f8365h);
            if (!am.m4188a(a)) {
                C2460i.m12104a(b3, ErrorCode.DAILY_LOG_TRUCK_TOTAL_DISTANCE_INCORRECT, this.f8366i, this.f8378u, a, context);
            }
        }
    }

    public DailyLogTruck m11823o() {
        if (this.f8379v != TruckLogType.ELECTRONIC) {
            return null;
        }
        C2602a a = DailyLogTruck.newBuilder().m13319a(this.f8380w.getTruckNumber());
        if (this.f8380w.hasOdometerUnit()) {
            a.m13327d(this.f8380w.getOdometerUnit());
        }
        Integer f = mo779f();
        if (f != null) {
            a.m13316a(f.intValue());
        }
        f = mo780g();
        if (f != null) {
            a.m13321b(f.intValue());
        }
        f = mo781i();
        if (f != null) {
            a.m13324c(f.intValue());
        }
        return a.m13325c();
    }

    public C1108a m11824p() {
        return this.f8381x;
    }
}
