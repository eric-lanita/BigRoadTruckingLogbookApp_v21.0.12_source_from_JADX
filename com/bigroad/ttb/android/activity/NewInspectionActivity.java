package com.bigroad.ttb.android.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.bigroad.shared.C0906x;
import com.bigroad.shared.am;
import com.bigroad.shared.ap;
import com.bigroad.shared.aq;
import com.bigroad.shared.dailylog.DailyLogOdometerSearchType;
import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.shared.duty.C0907o;
import com.bigroad.shared.model.C1107b;
import com.bigroad.shared.model.C1116d;
import com.bigroad.shared.model.C1116d.C1114a;
import com.bigroad.shared.validation.C1166f;
import com.bigroad.shared.validation.model.Dvir.Field;
import com.bigroad.shared.validation.model.DvirInspection;
import com.bigroad.shared.validation.p024b.C1155d;
import com.bigroad.ttb.android.C2226q;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.TruckManager;
import com.bigroad.ttb.android.activity.DvirInspectionEditActivity.IntentExtras;
import com.bigroad.ttb.android.activity.OurActivity.Feature;
import com.bigroad.ttb.android.activity.SelectTruckActivity.Option;
import com.bigroad.ttb.android.adapter.C1692p;
import com.bigroad.ttb.android.ai;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.model.C2177b;
import com.bigroad.ttb.android.model.C2184f;
import com.bigroad.ttb.android.p029c.C1736b;
import com.bigroad.ttb.android.p029c.C1738c;
import com.bigroad.ttb.android.p039h.C2085a;
import com.bigroad.ttb.android.p039h.C2094f;
import com.bigroad.ttb.android.util.ac;
import com.bigroad.ttb.android.widget.C2458h;
import com.bigroad.ttb.android.widget.C2464m;
import com.bigroad.ttb.android.widget.InstantAutoComplete;
import com.bigroad.ttb.protocol.TTProtocol;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import com.bigroad.ttb.protocol.TTProtocol.Dvir;
import com.bigroad.ttb.protocol.TTProtocol.DvirInspection.C2632a;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import com.bigroad.ttb.protocol.TTProtocol.VehicleType;
import com.google.protobuf.C3642c;
import com.p017a.p018a.p019a.C0816a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NewInspectionActivity extends OurActivity implements C0906x {
    private static final String f5318a = (NewInspectionActivity.class.getName() + ".viewState");
    private final C2226q f5319b = OurApplication.m6297s();
    private final ai f5320c = OurApplication.m6256M();
    private final TruckManager f5321d = OurApplication.m6294p();
    private final C1736b f5322e = OurApplication.m6296r();
    private final ap f5323f = OurApplication.m6269Z();
    private C0907o f5324g;
    private C1116d f5325h;
    private C0816a f5326i;
    private C1692p f5327j;
    private TextView f5328k;
    private TextView f5329l;
    private ListView f5330m;
    private InstantAutoComplete f5331n;
    private InstantAutoComplete f5332o;
    private Button f5333p;
    private C2094f<Field> f5334q = new C2094f(this);

    class C15291 implements OnClickListener {
        final /* synthetic */ NewInspectionActivity f5314a;

        C15291(NewInspectionActivity newInspectionActivity) {
            this.f5314a = newInspectionActivity;
        }

        public void onClick(View view) {
            this.f5314a.finish();
        }
    }

    class C15302 implements OnItemClickListener {
        final /* synthetic */ NewInspectionActivity f5315a;

        C15302(NewInspectionActivity newInspectionActivity) {
            this.f5315a = newInspectionActivity;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            C3642c c3642c = null;
            String a = NewInspectionActivity.m7697b(this.f5315a.f5331n);
            String a2 = NewInspectionActivity.m7697b(this.f5315a.f5332o);
            Object itemAtPosition = adapterView.getItemAtPosition(i);
            Dvir a3 = this.f5315a.m7684a(this.f5315a.m7705i(), a, a2);
            if (itemAtPosition instanceof C2184f) {
                Activity activity = this.f5315a;
                int a_ = this.f5315a.f5324g.a_();
                if (a3 != null) {
                    c3642c = a3.getId();
                }
                C1632a.m7931a(activity, IntentExtras.m7490a(a_, a, a2, c3642c, this.f5315a.m7688a((C2184f) itemAtPosition)), this.f5315a.m7711o());
            } else if (view == this.f5315a.f5328k) {
                C1632a.m7962a(this.f5315a, EnumSet.of(Option.LOAD_TRUCK_LIST, Option.REQUIRE_TITLE));
            } else if (view == this.f5315a.f5329l) {
                Activity activity2 = this.f5315a;
                int a_2 = this.f5315a.f5324g.a_();
                if (a3 != null) {
                    c3642c = a3.getId();
                }
                C1632a.m7931a(activity2, IntentExtras.m7490a(a_2, a, a2, c3642c, this.f5315a.m7696b(VehicleType.TRAILER)), this.f5315a.m7711o());
            }
        }
    }

    class C15313 implements Runnable {
        final /* synthetic */ NewInspectionActivity f5316a;

        C15313(NewInspectionActivity newInspectionActivity) {
            this.f5316a = newInspectionActivity;
        }

        public void run() {
            this.f5316a.mo974h();
        }
    }

    private class C1532a extends C1155d {
        final /* synthetic */ NewInspectionActivity f5317a;

        private C1532a(NewInspectionActivity newInspectionActivity) {
            this.f5317a = newInspectionActivity;
        }

        public int mo852b() {
            return this.f5317a.a_();
        }

        public String mo853c() {
            return NewInspectionActivity.m7697b(this.f5317a.f5332o);
        }

        public String mo854d() {
            return NewInspectionActivity.m7697b(this.f5317a.f5331n);
        }

        public List<? extends DvirInspection> mo855e() {
            return Collections.emptyList();
        }

        public boolean mo856f() {
            return false;
        }
    }

    private C3642c m7705i() {
        return com.bigroad.shared.ai.m4175a(getIntent().getByteArrayExtra("com.bigroad.ttb.dvirId"));
    }

    private static String m7697b(EditText editText) {
        return editText.getText().toString().trim();
    }

    public NewInspectionActivity() {
        super(Feature.FINISH_ON_SIGN_OUT);
    }

    private void m7692a(Set<C2184f> set, Iterable<Dvir> iterable) {
        for (Dvir inspectionList : iterable) {
            for (TTProtocol.DvirInspection dvirInspection : inspectionList.getInspectionList()) {
                if (!am.m4188a(dvirInspection.getVehicleNumber())) {
                    set.add(C2184f.m10825a(dvirInspection));
                }
            }
        }
    }

    private List<C2184f> m7706j() {
        Object obj;
        Set hashSet = new HashSet();
        Truck f = this.f5321d.m6578f();
        if (f != null) {
            C2184f a = C2184f.m10826a(f);
            hashSet.add(a);
            obj = a;
        } else {
            obj = null;
        }
        if (this.f5325h != null) {
            for (C1107b a2 : this.f5325h.m5667s()) {
                hashSet.add(C2184f.m10824a(a2));
            }
        }
        m7692a(hashSet, this.f5319b.m10973a(this.f5324g.a_()));
        m7692a(hashSet, this.f5319b.m10981b(this.f5324g.a_()));
        m7692a(hashSet, this.f5319b.m10988c(this.f5324g.a_()));
        List<C2184f> arrayList = new ArrayList(hashSet);
        Collections.sort(arrayList, C2184f.f7573a);
        if (obj != null) {
            arrayList.remove(obj);
            arrayList.add(0, obj);
        }
        return arrayList;
    }

    private void m7707k() {
        LayoutInflater layoutInflater = getLayoutInflater();
        this.f5330m.addHeaderView(layoutInflater.inflate(R.layout.new_inspection_header, null));
        this.f5330m.addFooterView(layoutInflater.inflate(R.layout.new_inspection_footer, null));
    }

    private void m7708l() {
        this.f5326i = new C0816a();
        this.f5326i.m4025a(C2464m.m12116a(this, R.string.newInspection_inspectVehicleHeading));
        this.f5327j = new C1692p(this);
        this.f5326i.m4027a(this.f5327j);
        this.f5326i.m4026a(this.f5328k, true);
        this.f5326i.m4026a(this.f5329l, true);
    }

    private void m7709m() {
        this.f5327j.m8259a(m7706j());
    }

    private Dvir m7683a(Dvir dvir, String str, String str2) {
        if (dvir == null) {
            return null;
        }
        if (!dvir.getCarrierName().equals(str)) {
            return null;
        }
        if (dvir.getInspectorName().equals(str2)) {
            return dvir;
        }
        return null;
    }

    private Dvir m7684a(C3642c c3642c, String str, String str2) {
        Dvir a = m7683a(this.f5319b.m10971a(c3642c), str, str2);
        if (a != null) {
            return a;
        }
        List a2 = this.f5319b.m10973a(this.f5324g.a_());
        if (a2.isEmpty()) {
            return a;
        }
        return m7683a((Dvir) a2.get(a2.size() - 1), str, str2);
    }

    private void m7710n() {
        CharSequence charSequence;
        CharSequence charSequence2;
        Dvir a = this.f5319b.m10971a(m7705i());
        if (a != null) {
            String carrierName = a.getCarrierName();
            String inspectorName = a.getInspectorName();
            charSequence = carrierName;
            charSequence2 = inspectorName;
        } else {
            charSequence2 = null;
            charSequence = null;
        }
        List a2 = this.f5319b.m10973a(this.f5324g.a_());
        if (!a2.isEmpty()) {
            Dvir dvir = (Dvir) a2.get(a2.size() - 1);
            if (am.m4188a(charSequence)) {
                charSequence = dvir.getCarrierName();
            }
            if (am.m4188a(charSequence2)) {
                charSequence2 = dvir.getInspectorName();
            }
        }
        if (am.m4188a(charSequence)) {
            charSequence = this.f5325h.m5651A();
        }
        if (am.m4188a(charSequence2)) {
            charSequence2 = this.f5325h.m5660l();
        }
        if (am.m4188a(charSequence)) {
            charSequence = OurApplication.m6292n().m11016c();
        }
        if (am.m4188a(charSequence2)) {
            charSequence2 = m6699R().m12224n();
        }
        ac.m11179a(this.f5331n, charSequence);
        ac.m11179a(this.f5332o, charSequence2);
    }

    private long m7680a(Dvir dvir) {
        List a;
        if (dvir == null) {
            a = this.f5319b.m10973a(this.f5324g.a_());
        } else {
            a = new ArrayList(1);
            a.add(dvir);
        }
        if (this.f5324g.a_() == DailyLogUtils.m4285a(this.f5324g.m4585b())) {
            return OurApplication.m6269Z().mo914b();
        }
        long j = 0;
        for (Dvir inspectionList : r0) {
            for (TTProtocol.DvirInspection dvirInspection : inspectionList.getInspectionList()) {
                if (dvirInspection.hasOccurredAt() && dvirInspection.getOccurredAt() > r2) {
                    j = dvirInspection.getOccurredAt();
                }
            }
        }
        return j <= 0 ? aq.m4223a(this.f5324g.m4586c(), 8, 0).getTimeInMillis() : j;
    }

    private boolean m7711o() {
        return this.f5324g.a_() == DailyLogUtils.m4285a(this.f5324g.m4585b());
    }

    private String m7698b(Dvir dvir) {
        List a;
        if (dvir == null) {
            a = this.f5319b.m10973a(this.f5324g.a_());
        } else {
            a = new ArrayList(1);
            a.add(dvir);
        }
        if (!(m7711o() || a.isEmpty())) {
            a = ((Dvir) a.get(a.size() - 1)).getInspectionList();
            if (!a.isEmpty()) {
                return ((TTProtocol.DvirInspection) a.get(a.size() - 1)).getLocationName();
            }
        }
        return null;
    }

    private boolean m7694a(List<Dvir> list, String str, Integer num) {
        for (Dvir a : list) {
            if (m7693a(a, str, num)) {
                return true;
            }
        }
        return false;
    }

    private boolean m7693a(Dvir dvir, String str, Integer num) {
        if (dvir == null) {
            return false;
        }
        for (TTProtocol.DvirInspection dvirInspection : dvir.getInspectionList()) {
            if (dvirInspection.getVehicleType() == 1 && ((str == null || am.m4189a(dvirInspection.getVehicleNumber(), str)) && (num == null || num.intValue() == dvirInspection.getOdometer()))) {
                return true;
            }
        }
        return false;
    }

    private C2632a m7685a(VehicleType vehicleType) {
        Dvir a = this.f5319b.m10971a(m7705i());
        C2632a a2 = TTProtocol.DvirInspection.newBuilder().m13666a(com.bigroad.shared.ai.m4174a()).m13663a(vehicleType.m15918a());
        a2.m13664a(m7680a(a));
        String b = m7698b(a);
        if (b != null) {
            a2.m13668a(b);
        }
        return a2;
    }

    private TTProtocol.DvirInspection m7696b(VehicleType vehicleType) {
        C2632a a = m7685a(vehicleType);
        m7691a(a);
        return a.m13676c();
    }

    private void m7691a(C2632a c2632a) {
        Integer num = null;
        if (c2632a.m13687l() == 1) {
            List a = this.f5319b.m10973a(this.f5324g.a_());
            boolean a2 = m7694a(a, c2632a.m13688m(), null);
            Truck f = this.f5321d.m6578f();
            if (f != null && f.getHasAobrd() && am.m4189a(f.getTruckNumber(), c2632a.m13688m())) {
                C2177b b = OurApplication.m6252I().m11403b();
                if (b != null) {
                    num = Integer.valueOf(b.m10801a(f));
                }
            } else {
                DailyLog b2 = this.f5322e.m8480b(this.f5324g.a_());
                if (b2 != null) {
                    num = DailyLogUtils.m4295a(a2 ? DailyLogOdometerSearchType.END_ODOMETER_ONLY : DailyLogOdometerSearchType.START_ODOMETER_ONLY, C1114a.m5598a(b2, OurApplication.af(), this.f5323f.mo914b()).m5635a(), c2632a.m13688m());
                } else {
                    DailyLog c = this.f5322e.m8486c(this.f5324g.a_());
                    if (c != null) {
                        num = DailyLogUtils.m4295a(DailyLogOdometerSearchType.END_ODOMETER_ONLY, C1114a.m5598a(c, OurApplication.af(), this.f5323f.mo914b()).m5635a(), c2632a.m13688m());
                    }
                }
            }
            if (num != null && !m7694a(a, c2632a.m13688m(), num)) {
                c2632a.m13671b(num.intValue());
            }
        }
    }

    private TTProtocol.DvirInspection m7689a(Truck truck) {
        C2632a c = m7685a(VehicleType.TRUCK).m13672b(truck.getTruckNumber()).m13675c(truck.getTruckLicense());
        m7691a(c);
        return c.m13676c();
    }

    private TTProtocol.DvirInspection m7688a(C2184f c2184f) {
        String c = c2184f.m10831c();
        if (c2184f.m10828a() == VehicleType.TRUCK) {
            Truck c2 = this.f5321d.m6572c(c2184f.m10830b());
            if (c2 != null) {
                c = c2.getTruckLicense();
            }
        }
        C2632a b = m7685a(c2184f.m10828a()).m13672b(c2184f.m10830b());
        if (!am.m4188a((CharSequence) c)) {
            b.m13675c(c);
        }
        m7691a(b);
        return b.m13676c();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int intExtra = getIntent().getIntExtra("com.bigroad.ttb.logDay", -1);
        if (intExtra < 0) {
            C2134e.m10682e("TT-NewInspection", "No log day");
            finish();
            return;
        }
        DailyLog f = this.f5322e.m8491f(intExtra);
        if (f == null) {
            finish();
            return;
        }
        this.f5325h = C1114a.m5598a(f, OurApplication.af(), this.f5323f.mo914b()).m5635a();
        this.f5324g = new C0907o(f);
        setTitle(getString(R.string.newInspection_title, new Object[]{C1738c.m8514c(this.f5324g.a_())}));
        setContentView((int) R.layout.new_inspection);
        this.f5330m = (ListView) findViewById(R.id.newInspection_newInspectionList);
        m7707k();
        this.f5331n = (InstantAutoComplete) findViewById(R.id.dvirHeader_carrier);
        this.f5332o = (InstantAutoComplete) findViewById(R.id.dvirHeader_inspector);
        this.f5331n.setAdapter(this.f5320c.m8372a((Context) this, 6));
        this.f5332o.setAdapter(this.f5320c.m8372a((Context) this, 7));
        this.f5328k = m7700d((int) R.string.newInspection_otherTruck);
        this.f5329l = m7700d((int) R.string.newInspection_otherTrailer);
        this.f5333p = (Button) findViewById(R.id.newInspection_cancelButton);
        this.f5333p.setOnClickListener(new C15291(this));
        if (bundle == null) {
            m7710n();
        } else {
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(f5318a);
            if (sparseParcelableArray != null) {
                this.f5331n.restoreHierarchyState(sparseParcelableArray);
                this.f5332o.restoreHierarchyState(sparseParcelableArray);
            }
        }
        m7708l();
        this.f5330m.setAdapter(this.f5326i);
        this.f5330m.setOnItemClickListener(new C15302(this));
        m7709m();
        mo930f();
        mo974h();
    }

    private TextView m7700d(int i) {
        TextView textView = (TextView) getLayoutInflater().inflate(17367043, null);
        textView.setText(i);
        textView.setTextColor(getResources().getColorStateList(R.color.adder_item_text));
        return textView;
    }

    public int a_() {
        return this.f5324g.a_();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 13:
                if (i2 == -1) {
                    Truck a = TruckManager.m6538a(intent.getByteArrayExtra("com.bigroad.ttb.truck"));
                    if (a != null) {
                        C3642c c3642c;
                        String b = m7697b(this.f5331n);
                        String b2 = m7697b(this.f5332o);
                        Dvir a2 = m7684a(m7705i(), b, b2);
                        int a_ = this.f5324g.a_();
                        if (a2 == null) {
                            c3642c = null;
                        } else {
                            c3642c = a2.getId();
                        }
                        C1632a.m7931a((Activity) this, IntentExtras.m7490a(a_, b, b2, c3642c, m7689a(a)), m7711o());
                        return;
                    }
                    C2134e.m10682e("TT-NewInspection", "Unexpected empty truck from SelectTruckActivity");
                    return;
                }
                return;
            case 17:
                setResult(i2, intent);
                if (i2 != 0) {
                    finish();
                    return;
                }
                return;
            default:
                super.onActivityResult(i, i2, intent);
                return;
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        SparseArray sparseArray = new SparseArray();
        this.f5331n.saveHierarchyState(sparseArray);
        this.f5332o.saveHierarchyState(sparseArray);
        bundle.putSparseParcelableArray(f5318a, sparseArray);
    }

    protected void mo930f() {
        TextWatcher c2458h = new C2458h(m6701T(), new C15313(this));
        this.f5331n.addTextChangedListener(c2458h);
        this.f5332o.addTextChangedListener(c2458h);
        this.f5334q.m10486a();
        this.f5334q.m10488a(Field.CARRIER_NAME, R.id.dvirHeader_carrierError, R.id.dvirHeader_carrierErrorText);
        this.f5334q.m10488a(Field.INSPECTOR_NAME, R.id.dvirHeader_inspectorError, R.id.dvirHeader_inspectorErrorText);
    }

    protected void mo974h() {
        Object c1532a = new C1532a();
        C1166f.m5932a(c1532a, new C2085a(), a_());
        this.f5334q.m10487a(c1532a.mo716A(), this);
    }
}
