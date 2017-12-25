package com.bigroad.ttb.android.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.bigroad.shared.am;
import com.bigroad.ttb.android.C2230r;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.TruckManager;
import com.bigroad.ttb.android.TruckManager.C1203b;
import com.bigroad.ttb.android.TruckManager.ChangeListener;
import com.bigroad.ttb.android.TruckManager.ChangeListener.Priority;
import com.bigroad.ttb.android.activity.OurActivity.Feature;
import com.bigroad.ttb.android.activity.OurActivity.TitleStyle;
import com.bigroad.ttb.android.adapter.C1312m;
import com.bigroad.ttb.android.event.C2022a;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.util.C2303v;
import com.bigroad.ttb.android.widget.C1267k;
import com.bigroad.ttb.protocol.TTProtocol.OdometerOffsets;
import com.bigroad.ttb.protocol.TTProtocol.OdometerUnit;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import com.bigroad.ttb.protocol.TTProtocol.TruckLogType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelectTruckActivity extends OurKeyboardActivity {
    private static final String f5465a = SelectTruckActivity.class.getName();
    private static final String f5466b = (f5465a + ".truckNumber");
    private final TruckManager f5467c = OurApplication.m6294p();
    private final C2230r f5468d = OurApplication.m6292n();
    private ListView f5469e;
    private EditText f5470f;
    private C1572a f5471g;
    private TextWatcher f5472h;
    private Button f5473i;
    private boolean f5474j = false;
    private boolean f5475k = false;
    private String f5476l;
    private final ChangeListener f5477m = new C15661(this);

    class C15661 extends C1203b {
        final /* synthetic */ SelectTruckActivity f5444a;

        C15661(SelectTruckActivity selectTruckActivity) {
            this.f5444a = selectTruckActivity;
        }

        public void mo895b() {
            this.f5444a.f5471g.m7797a(this.f5444a.f5474j, this.f5444a.f5475k);
        }
    }

    class C15672 implements TextWatcher {
        final /* synthetic */ SelectTruckActivity f5445a;

        C15672(SelectTruckActivity selectTruckActivity) {
            this.f5445a = selectTruckActivity;
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.f5445a.f5471g.getFilter().filter(charSequence);
            this.f5445a.f5469e.smoothScrollToPosition(0);
            if (charSequence != null) {
                this.f5445a.m7804a(charSequence.toString());
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    class C15683 extends C1267k {
        final /* synthetic */ SelectTruckActivity f5446a;

        C15683(SelectTruckActivity selectTruckActivity) {
            this.f5446a = selectTruckActivity;
        }

        public boolean mo929a(TextView textView) {
            this.f5446a.f5473i.performClick();
            return true;
        }
    }

    class C15694 implements OnItemClickListener {
        final /* synthetic */ SelectTruckActivity f5447a;

        C15694(SelectTruckActivity selectTruckActivity) {
            this.f5447a = selectTruckActivity;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.f5447a.m7810d(i);
        }
    }

    class C15705 implements OnClickListener {
        final /* synthetic */ SelectTruckActivity f5448a;

        C15705(SelectTruckActivity selectTruckActivity) {
            this.f5448a = selectTruckActivity;
        }

        public void onClick(View view) {
            String trim = this.f5448a.f5470f.getText().toString().trim();
            if (am.m4188a((CharSequence) trim) && this.f5448a.f5468d.m11021g()) {
                C1632a.m7969b(this.f5448a, "");
                return;
            }
            Truck d = this.f5448a.f5467c.m6574d(trim);
            if (d == null && this.f5448a.f5468d.m11021g()) {
                C1632a.m7969b(this.f5448a, trim);
            } else if (d != null) {
                this.f5448a.m7806b(d);
            }
        }
    }

    private static final class DisplayTruck {
        public static final DisplayTruck f5456a = new DisplayTruck();
        private final Type f5457b;
        private final Truck f5458c;
        private final List<String> f5459d;

        public enum Type {
            TRUCK,
            LAST_TRUCK,
            CURRENT_TRUCK,
            UNKNOWN_TRUCK,
            TEMPORARY_TRUCK
        }

        private DisplayTruck() {
            this.f5458c = Truck.newBuilder().m15572a(-2).m15581b(-1).m15577a("").m15578a(false).m15592c();
            this.f5457b = Type.UNKNOWN_TRUCK;
            this.f5459d = Collections.emptyList();
        }

        public DisplayTruck(Truck truck) {
            this(truck, Type.TRUCK);
        }

        public DisplayTruck(Truck truck, Type type) {
            this.f5458c = truck;
            this.f5457b = type;
            this.f5459d = new ArrayList();
            this.f5459d.addAll(am.m4193d(this.f5458c.getTruckNumber()));
            this.f5459d.addAll(am.m4193d(this.f5458c.getTruckLicense()));
        }

        public Truck m7790a() {
            return this.f5458c;
        }

        public Type m7791b() {
            return this.f5457b;
        }

        public String m7792c() {
            return this.f5458c != null ? this.f5458c.getTruckNumber() : "";
        }

        public String m7793d() {
            return this.f5458c != null ? this.f5458c.getTruckLicense() : "";
        }

        public boolean m7794e() {
            return this.f5458c != null && this.f5458c.getHasAobrd();
        }

        public List<String> m7795f() {
            return this.f5459d;
        }
    }

    public enum Option {
        LOAD_TRUCK_LIST,
        ALLOW_UNKNOWN_TRUCK,
        REQUIRE_TITLE,
        WITHOUT_EOBR_TRUCKS
    }

    private static final class C1572a extends C1312m<DisplayTruck> {
        public C1572a(Context context, List<DisplayTruck> list) {
            super(context, R.layout.our_simple_list_item_2, list);
        }

        public C1572a(Context context) {
            this(context, new ArrayList());
        }

        public boolean hasStableIds() {
            return true;
        }

        protected boolean m7798a(DisplayTruck displayTruck, CharSequence charSequence) {
            if (displayTruck.m7790a() == null) {
                return charSequence.length() == 0;
            } else {
                String c = displayTruck.m7792c();
                String charSequence2 = charSequence.toString();
                return am.m4190a(c, charSequence2, displayTruck.m7795f(), am.m4192c(charSequence2));
            }
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            DisplayTruck displayTruck = (DisplayTruck) getItem(i);
            if (view == null) {
                view = mo949a(R.layout.our_simple_list_item_2, viewGroup, false);
            }
            TextView textView = (TextView) view.findViewById(R.id.ourSimpleListItem_text1);
            TextView textView2 = (TextView) view.findViewById(R.id.ourSimpleListItem_text2);
            ImageView imageView = (ImageView) view.findViewById(R.id.ourSimpleListItem_icon);
            int currentTextColor = textView2.getCurrentTextColor();
            if (displayTruck.m7794e()) {
                imageView.setVisibility(0);
                imageView.setImageResource(R.drawable.ic_dashlink_good);
            } else {
                imageView.setVisibility(8);
            }
            switch (displayTruck.m7791b()) {
                case UNKNOWN_TRUCK:
                    C2303v c = C2303v.m11258c();
                    c.m11264a(viewGroup.getResources().getString(R.string.selectTruck_noTruck), new ForegroundColorSpan(currentTextColor));
                    textView.setText(c.m11270e());
                    textView2.setText("");
                    break;
                case LAST_TRUCK:
                case CURRENT_TRUCK:
                    CharSequence string;
                    C2303v c2 = C2303v.m11258c();
                    c2.m11268c(displayTruck.m7792c());
                    if (displayTruck.m7791b() == Type.LAST_TRUCK) {
                        string = viewGroup.getResources().getString(R.string.selectTruck_lastUsed);
                    } else {
                        string = viewGroup.getResources().getString(R.string.selectTruck_current);
                    }
                    c2.m11264a(string, new ForegroundColorSpan(currentTextColor));
                    textView.setText(c2.m11270e());
                    if (!am.m4188a(displayTruck.m7793d())) {
                        textView2.setText(viewGroup.getResources().getString(R.string.selectTruck_license, new Object[]{displayTruck.m7793d()}));
                        break;
                    }
                    textView2.setText("");
                    break;
                case TEMPORARY_TRUCK:
                    C2303v c3 = C2303v.m11258c();
                    c3.m11264a(viewGroup.getResources().getString(R.string.selectTruck_notCreated, new Object[]{displayTruck.m7792c()}), new ForegroundColorSpan(currentTextColor));
                    textView.setText(c3.m11270e());
                    if (!am.m4188a(displayTruck.m7793d())) {
                        textView2.setText(viewGroup.getResources().getString(R.string.selectTruck_license, new Object[]{displayTruck.m7793d()}));
                        break;
                    }
                    textView2.setText("");
                    break;
                default:
                    textView.setText(displayTruck.m7792c());
                    if (!am.m4188a(displayTruck.m7793d())) {
                        textView2.setText(viewGroup.getResources().getString(R.string.selectTruck_license, new Object[]{displayTruck.m7793d()}));
                        break;
                    }
                    textView2.setText("");
                    break;
            }
            return view;
        }

        public void m7797a(boolean z, boolean z2) {
            Truck truck;
            String str = null;
            m6816a();
            List<String> a = OurApplication.m6256M().m8373a(OurApplication.m6285g().m12202d());
            TruckManager p = OurApplication.m6294p();
            Truck f = p.m6578f();
            if (z) {
                m6817a((Object) DisplayTruck.f5456a);
            }
            if (f == null) {
                CharSequence k = OurApplication.m6285g().m12221k();
                if (am.m4188a(k)) {
                    truck = null;
                } else {
                    truck = p.m6574d(k);
                }
                if (m7796a(truck, z2)) {
                    m6817a((Object) new DisplayTruck(truck, Type.LAST_TRUCK));
                    str = k;
                }
            }
            for (String str2 : a) {
                if (m7796a(f, z2) && am.m4189a(str2, f.getTruckNumber())) {
                    m6817a((Object) new DisplayTruck(f, Type.CURRENT_TRUCK));
                } else if (str == null || !am.m4189a(str2, str)) {
                    truck = p.m6574d(str2);
                    if (m7796a(truck, z2)) {
                        if (truck.getTruckId() == -1) {
                            m6817a((Object) new DisplayTruck(truck, Type.TEMPORARY_TRUCK));
                        } else {
                            m6817a((Object) new DisplayTruck(truck));
                        }
                    }
                }
            }
        }

        private boolean m7796a(Truck truck, boolean z) {
            if (truck == null) {
                return false;
            }
            TruckLogType a = TruckLogType.m15634a(truck.getTruckLogType());
            if (a == null) {
                return true;
            }
            boolean z2;
            if (a == TruckLogType.AOBRD || a == TruckLogType.ELD) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z && r2) {
                return false;
            }
            return true;
        }
    }

    public SelectTruckActivity() {
        super(Feature.FINISH_ON_SIGN_OUT);
    }

    private void m7803a(Truck truck) {
        Intent intent = new Intent();
        if (truck != null) {
            intent.putExtra("com.bigroad.ttb.truck", truck.toByteArray());
        }
        if (getIntent().hasExtra("com.bigroad.ttb.pendingDutyStatus")) {
            intent.putExtra("com.bigroad.ttb.pendingDutyStatus", getIntent().getIntExtra("com.bigroad.ttb.pendingDutyStatus", -1));
        }
        setResult(-1, intent);
        finish();
    }

    private void m7806b(Truck truck) {
        if (truck.getHasAobrd() && am.m4188a(truck.getVin()) && ((!truck.hasAssociatedDashLink() || truck.getAssociatedDashLink().m19090c()) && (!truck.hasGenxSerialNumber() || truck.getGenxSerialNumber().isEmpty()))) {
            this.f5476l = truck.getTruckNumber();
            C1632a.m7940a((Activity) this, this.f5476l, OdometerUnit.m14668a(truck.getOdometerUnit()));
            return;
        }
        m7803a(truck);
    }

    private void m7810d(int i) {
        if (i >= 0 && i < this.f5471g.getCount()) {
            m7806b(((DisplayTruck) this.f5471g.getItem(i)).m7790a());
        }
    }

    private void m7804a(String str) {
        if (str == null || !this.f5467c.m6571b(str)) {
            this.f5473i.setText(R.string.selectTruck_addNewTruckButton);
        } else {
            this.f5473i.setText(R.string.selectTruck_pickTruckButton);
        }
    }

    protected TextView mo930f() {
        if (this.f5471g == null) {
            return null;
        }
        if (this.f5471g.isEmpty()) {
            return this.f5470f;
        }
        return (this.f5471g.getCount() == 1 && ((DisplayTruck) this.f5471g.getItem(0)).m7791b() == Type.UNKNOWN_TRUCK) ? this.f5470f : null;
    }

    protected TitleStyle mo1024a(TitleStyle titleStyle, Bundle bundle) {
        if (getIntent().getBooleanExtra("com.bigroad.ttb.requireTitle", true) || !m6706Y()) {
            return super.mo1024a(titleStyle, bundle);
        }
        return super.mo1024a(TitleStyle.NONE, bundle);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setSoftInputMode(18);
        this.f5474j = getIntent().getBooleanExtra("com.bigroad.ttb.allowUnknown", false);
        this.f5475k = getIntent().getBooleanExtra("com.bigroad.ttb.withoutEobrTrucks", false);
        setContentView((int) R.layout.select_truck);
        m6692K().setStatusMessageVisible(false);
        this.f5469e = (ListView) findViewById(R.id.selectTruck_listView);
        this.f5473i = (Button) findViewById(R.id.selectTruck_addNewTruckButton);
        this.f5470f = (EditText) findViewById(R.id.selectTruck_searchBox);
        this.f5471g = new C1572a(this);
        this.f5471g.m7797a(this.f5474j, this.f5475k);
        this.f5472h = new C15672(this);
        m7804a("");
        this.f5470f.addTextChangedListener(this.f5472h);
        this.f5470f.setOnEditorActionListener(new C15683(this));
        this.f5469e.setAdapter(this.f5471g);
        TextView textView = (TextView) findViewById(R.id.selectTruck_emptyText);
        this.f5469e.setEmptyView(textView);
        this.f5469e.setOnItemClickListener(new C15694(this));
        this.f5473i.setOnClickListener(new C15705(this));
        if (this.f5468d.m11021g()) {
            textView.setText(R.string.selectTruck_empty_addTruckText);
            this.f5473i.setVisibility(0);
            this.f5470f.setHint(R.string.selectTruck_findOrAddHint);
        } else {
            textView.setText(R.string.selectTruck_empty_noTruckText);
            this.f5473i.setVisibility(8);
            this.f5470f.setHint(R.string.selectTruck_findHint);
        }
        this.f5467c.m6560a(this.f5477m, Priority.DEFAULT);
        if (bundle != null) {
            this.f5476l = bundle.getString(f5466b);
        } else if (getIntent().getBooleanExtra("com.bigroad.ttb.loadTruckList", true)) {
            OurApplication.m6289k().m6504i();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(f5466b, this.f5476l);
    }

    public void onBackPressed() {
        if (getIntent().hasExtra("com.bigroad.ttb.pendingDutyStatus")) {
            int intExtra = getIntent().getIntExtra("com.bigroad.ttb.pendingDutyStatus", -1);
            Intent intent = new Intent();
            intent.putExtra("com.bigroad.ttb.pendingDutyStatus", intExtra);
            setResult(1, intent);
        } else {
            setResult(1);
        }
        finish();
    }

    protected void onDestroy() {
        super.onDestroy();
        this.f5470f.removeTextChangedListener(this.f5472h);
        this.f5467c.m6568b(this.f5477m);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Truck a;
        switch (i) {
            case 25:
                if (i2 == -1) {
                    a = TruckManager.m6538a(intent.getByteArrayExtra("com.bigroad.ttb.truck"));
                    if (a != null) {
                        m7803a(a);
                        return;
                    }
                    return;
                }
                return;
            case 27:
                Truck c;
                switch (i2) {
                    case -1:
                    case 0:
                        c = this.f5467c.m6572c(this.f5476l);
                        if (c == null) {
                            C2134e.m10682e("TT-SelTruck", "DashLinkDiscovery completed but can't find truck: " + this.f5476l);
                            return;
                        }
                        if (i2 == -1) {
                            CharSequence stringExtra = intent.getStringExtra("com.bigroad.ttb.vin");
                            byte[] byteArrayExtra = intent.getByteArrayExtra("com.bigroad.ttb.macAddress");
                            byte[] byteArrayExtra2 = intent.getByteArrayExtra("com.bigroad.ttb.firmwareOdometerId");
                            if (!(am.m4188a(stringExtra) && byteArrayExtra == null)) {
                                OdometerUnit odometerUnit = (OdometerUnit) intent.getSerializableExtra("com.bigroad.ttb.odometerUnit");
                                OdometerOffsets odometerOffsets = (OdometerOffsets) intent.getSerializableExtra("com.bigroad.ttb.odometerOffsets");
                                OurApplication.m6295q().m10050e(C2022a.m10081a(OurApplication.ac(), c, byteArrayExtra2));
                                a = this.f5467c.m6554a(c.getTruckNumber(), null, odometerUnit, stringExtra, byteArrayExtra, true, odometerOffsets, byteArrayExtra2);
                                m7803a(a);
                                return;
                            }
                        }
                        a = c;
                        m7803a(a);
                        return;
                    case 5:
                        String stringExtra2 = intent.getStringExtra("com.bigroad.ttb.truckNumber");
                        c = this.f5467c.m6572c(stringExtra2);
                        if (c == null) {
                            C2134e.m10682e("TT-SelTruck", "DashLinkDiscovery requested to switch to non-existent truck: " + stringExtra2);
                            return;
                        } else {
                            m7803a(c);
                            return;
                        }
                    default:
                        return;
                }
            default:
                return;
        }
    }
}
