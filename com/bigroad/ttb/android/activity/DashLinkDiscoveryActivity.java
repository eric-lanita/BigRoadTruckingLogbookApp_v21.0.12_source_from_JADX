package com.bigroad.ttb.android.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.bigroad.shared.C1180y;
import com.bigroad.shared.am;
import com.bigroad.shared.an;
import com.bigroad.shared.at;
import com.bigroad.shared.eobr.EobrType;
import com.bigroad.shared.model.CanonicalOdometerSource;
import com.bigroad.shared.model.CanonicalOdometerUnit;
import com.bigroad.ttb.android.BluetoothMonitor;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.TruckManager;
import com.bigroad.ttb.android.activity.OurActivity.Feature;
import com.bigroad.ttb.android.activity.UpdateOdometerActivity.OdometerSetConfirmMode;
import com.bigroad.ttb.android.eobr.EobrDevice;
import com.bigroad.ttb.android.eobr.EobrDevice.ConnectionState;
import com.bigroad.ttb.android.eobr.EobrManager;
import com.bigroad.ttb.android.eobr.EobrManager.ChangeListener;
import com.bigroad.ttb.android.eobr.EobrManager.ChangeListener.Priority;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.model.C2179d;
import com.bigroad.ttb.android.model.C2182e;
import com.bigroad.ttb.android.util.C2303v;
import com.bigroad.ttb.protocol.TTProtocol.OdometerUnit;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DashLinkDiscoveryActivity extends OurActivity {
    private static final String f4965a = DashLinkDiscoveryActivity.class.getName();
    private static final String f4966b = (f4965a + ".rejectedDevices");
    private static final String f4967c = (f4965a + ".currentDevice");
    private Button f4968A;
    private Button f4969B;
    private int f4970C;
    private final ChangeListener f4971D = new C14511(this);
    private final Runnable f4972E = new C14522(this);
    private final Runnable f4973F = new C14533(this);
    private final BluetoothMonitor f4974d = OurApplication.m6250G();
    private final EobrManager f4975e = OurApplication.m6251H();
    private final TruckManager f4976f = OurApplication.m6294p();
    private final Set<String> f4977g = new HashSet();
    private Mode f4978h = null;
    private EobrDevice f4979i = null;
    private String f4980j;
    private OdometerUnit f4981k;
    private ViewGroup f4982l;
    private View f4983m;
    private TextView f4984n;
    private TextView f4985o;
    private View f4986p;
    private TextView f4987q;
    private TextView f4988r;
    private TextView f4989s;
    private TextView f4990t;
    private TextView f4991u;
    private TextView f4992v;
    private TextView f4993w;
    private TextView f4994x;
    private Button f4995y;
    private Button f4996z;

    class C14511 implements ChangeListener {
        final /* synthetic */ DashLinkDiscoveryActivity f4951a;

        C14511(DashLinkDiscoveryActivity dashLinkDiscoveryActivity) {
            this.f4951a = dashLinkDiscoveryActivity;
        }

        public void mo999a(EobrManager eobrManager) {
            this.f4951a.m7370h();
        }

        public void mo997a(EobrDevice eobrDevice) {
        }

        public void mo1000b(EobrDevice eobrDevice) {
            if (this.f4951a.f4979i != null && eobrDevice.m8991c().equals(this.f4951a.f4979i.m8991c())) {
                this.f4951a.m7376k();
            }
        }

        public void mo1001c(EobrDevice eobrDevice) {
        }

        public void mo998a(EobrDevice eobrDevice, boolean z) {
            if (this.f4951a.f4979i == null || !eobrDevice.m8991c().equals(this.f4951a.f4979i.m8991c())) {
                return;
            }
            if (z) {
                this.f4951a.m7376k();
            } else if (this.f4951a.f4978h != Mode.FOUND) {
                this.f4951a.m7372i();
            }
        }
    }

    class C14522 implements Runnable {
        final /* synthetic */ DashLinkDiscoveryActivity f4952a;

        C14522(DashLinkDiscoveryActivity dashLinkDiscoveryActivity) {
            this.f4952a = dashLinkDiscoveryActivity;
        }

        public void run() {
            if (this.f4952a.f4979i != null && this.f4952a.f4978h == Mode.FOUND && this.f4952a.f4979i.m8997i() == ConnectionState.NOT_CONNECTED) {
                C2134e.m10676b("TT-DLDisc", "Reconnecting to device " + this.f4952a.f4979i.m8993e());
                this.f4952a.f4975e.m9117a(this.f4952a.f4979i);
            }
            Handler T = this.f4952a.m6701T();
            T.removeCallbacks(this.f4952a.f4972E);
            T.postDelayed(this.f4952a.f4972E, 2000);
        }
    }

    class C14533 implements Runnable {
        final /* synthetic */ DashLinkDiscoveryActivity f4953a;

        C14533(DashLinkDiscoveryActivity dashLinkDiscoveryActivity) {
            this.f4953a = dashLinkDiscoveryActivity;
        }

        public void run() {
            this.f4953a.m6701T().removeCallbacks(this.f4953a.f4973F);
            if (this.f4953a.f4979i != null && this.f4953a.f4979i.m8997i() == ConnectionState.CONNECTED) {
                this.f4953a.m6701T().postDelayed(this.f4953a.f4973F, 2000);
                m7350a();
            }
        }

        private void m7350a() {
            C2179d c2179d;
            Object obj;
            C2179d c2179d2;
            at atVar = new at(this.f4953a.f4979i.m9000l());
            CharSequence e = atVar.m4255e();
            String b = atVar.m4252b();
            String c = atVar.m4253c();
            String a = this.f4953a.f4979i.m8980a();
            C2182e m = this.f4953a.f4979i.m9001m();
            if (m == null) {
                c2179d = null;
            } else {
                c2179d = m.m10821b();
            }
            Object obj2 = (c2179d == null || c2179d.m10812b() != CanonicalOdometerSource.DASHLINK_FIRMWARE) ? null : 1;
            boolean d = an.m4197d(this.f4953a.f4979i.m9004p());
            if (this.f4953a.f4979i.m9008t() > 10000) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj2 == null || d || obj != null) {
                c2179d2 = c2179d;
            } else {
                c2179d2 = null;
            }
            String str = null;
            if (c2179d2 != null) {
                long a2 = c2179d2.m10811a();
                str = CanonicalOdometerUnit.MILES.m5473c(a2) + " / " + CanonicalOdometerUnit.KM.m5473c(a2);
            }
            this.f4953a.m7353a(this.f4953a.f4987q, (int) R.string.dashLinkDiscovery_modelYearLabel, b);
            this.f4953a.m7353a(this.f4953a.f4988r, (int) R.string.dashLinkDiscovery_manufacturerLabel, c);
            if (obj2 != null) {
                this.f4953a.f4989s.setVisibility(8);
            } else {
                this.f4953a.m7353a(this.f4953a.f4989s, (int) R.string.dashLinkDiscovery_odometerLabel, str);
                this.f4953a.f4989s.setVisibility(0);
            }
            this.f4953a.m7353a(this.f4953a.f4990t, (int) R.string.dashLinkDiscovery_vinLabel, (String) e);
            this.f4953a.m7353a(this.f4953a.f4991u, (int) R.string.dashLinkDiscovery_dashLinkIdLabel, C1180y.m5995c(this.f4953a.f4979i.m8991c()));
            this.f4953a.m7353a(this.f4953a.f4992v, (int) R.string.dashLinkDiscovery_dashLinkVersionLabel, a);
            this.f4953a.f4993w.setText(this.f4953a.getString(R.string.dashLinkDiscovery_isThisYourTruck, new Object[]{this.f4953a.f4980j}));
            if (c2179d2 == null) {
                if (obj != null) {
                    this.f4953a.f4994x.setText(R.string.dashLinkDiscovery_noOdometerMessage);
                } else {
                    this.f4953a.f4994x.setText(R.string.dashLinkDiscovery_readingOdometerMessage);
                }
                this.f4953a.f4994x.setVisibility(0);
                this.f4953a.f4995y.setVisibility(8);
                this.f4953a.f4993w.setText(R.string.dashLinkDiscovery_skipToKeepSearching);
            } else if (am.m4188a(e)) {
                this.f4953a.f4994x.setText(R.string.dashLinkDiscovery_noVinMessage);
                this.f4953a.f4994x.setVisibility(0);
                this.f4953a.f4995y.setVisibility(0);
            } else {
                this.f4953a.f4994x.setVisibility(8);
                this.f4953a.f4995y.setVisibility(0);
            }
            this.f4953a.m7354a(Mode.FOUND);
        }
    }

    class C14544 implements OnClickListener {
        final /* synthetic */ DashLinkDiscoveryActivity f4954a;

        C14544(DashLinkDiscoveryActivity dashLinkDiscoveryActivity) {
            this.f4954a = dashLinkDiscoveryActivity;
        }

        public void onClick(View view) {
            this.f4954a.f4975e.m9127f();
            this.f4954a.setResult(0);
            this.f4954a.finish();
        }
    }

    class C14555 implements OnClickListener {
        final /* synthetic */ DashLinkDiscoveryActivity f4955a;

        C14555(DashLinkDiscoveryActivity dashLinkDiscoveryActivity) {
            this.f4955a = dashLinkDiscoveryActivity;
        }

        public void onClick(View view) {
            this.f4955a.m7367f();
        }
    }

    class C14566 implements OnClickListener {
        final /* synthetic */ DashLinkDiscoveryActivity f4956a;

        C14566(DashLinkDiscoveryActivity dashLinkDiscoveryActivity) {
            this.f4956a = dashLinkDiscoveryActivity;
        }

        public void onClick(View view) {
            this.f4956a.m7378l();
        }
    }

    class C14577 implements OnClickListener {
        final /* synthetic */ DashLinkDiscoveryActivity f4957a;

        C14577(DashLinkDiscoveryActivity dashLinkDiscoveryActivity) {
            this.f4957a = dashLinkDiscoveryActivity;
        }

        public void onClick(View view) {
            this.f4957a.m7372i();
        }
    }

    private enum Mode {
        SEARCHING,
        CONNECTING,
        NOT_FOUND,
        FOUND
    }

    public DashLinkDiscoveryActivity() {
        super(EnumSet.of(Feature.FINISH_ON_SIGN_OUT, Feature.FINISH_ON_FLEET_LOSS));
    }

    private void m7354a(Mode mode) {
        int i = 4;
        if (mode != this.f4978h) {
            this.f4978h = mode;
            View view = null;
            switch (mode) {
                case SEARCHING:
                    this.f4984n.setText(R.string.dashLinkDiscovery_searchingCaption);
                    view = this.f4983m;
                    break;
                case CONNECTING:
                    this.f4984n.setText(R.string.dashLinkDiscovery_gatheringCaption);
                    view = this.f4983m;
                    break;
                case NOT_FOUND:
                    this.f4985o.setText(this.f4975e.m9115a().isEmpty() ? R.string.dashLinkDiscovery_noneFound : R.string.dashLinkDiscovery_noMoreFound);
                    view = this.f4985o;
                    break;
                case FOUND:
                    view = this.f4986p;
                    break;
            }
            for (int i2 = 0; i2 < this.f4982l.getChildCount(); i2++) {
                int i3;
                View childAt = this.f4982l.getChildAt(i2);
                if (childAt == view) {
                    i3 = 0;
                } else {
                    i3 = 4;
                }
                childAt.setVisibility(i3);
            }
            Button button = this.f4969B;
            if (this.f4978h != Mode.SEARCHING) {
                i = 0;
            }
            button.setVisibility(i);
        }
    }

    private void m7367f() {
        switch (this.f4974d.m6063d()) {
            case DISABLED:
                C1632a.m8009o((Activity) this);
                return;
            case UNSUPPORTED:
            case ENABLED:
                m7358a(null);
                this.f4977g.clear();
                this.f4975e.m9124c();
                m7354a(Mode.SEARCHING);
                return;
            default:
                return;
        }
    }

    private void m7370h() {
        if (!this.f4975e.m9123b() && this.f4978h == Mode.SEARCHING) {
            m7372i();
        }
    }

    private void m7372i() {
        if (this.f4979i != null) {
            this.f4977g.add(this.f4979i.m8991c());
        }
        m7358a(null);
        EobrDevice a = m7351a(this.f4975e.m9115a());
        if (a == null) {
            m7354a(Mode.NOT_FOUND);
            return;
        }
        m7358a(a);
        m7374j();
    }

    private void m7374j() {
        if (this.f4979i != null) {
            if (this.f4979i.m8997i() == ConnectionState.CONNECTED) {
                m7376k();
                return;
            }
            m7354a(Mode.CONNECTING);
            this.f4975e.m9117a(this.f4979i);
        }
    }

    private void m7376k() {
        this.f4973F.run();
    }

    private void m7353a(TextView textView, int i, String str) {
        C2303v b = C2303v.m11257b(this.f4970C);
        b.m11262a(getString(i)).m11260a(' ');
        if (am.m4188a((CharSequence) str)) {
            b.m11267b(getString(R.string.dashLinkDiscovery_unknownValue));
        } else {
            b.m11268c(str);
        }
        textView.setText(b.m11270e());
    }

    private EobrDevice m7351a(List<EobrDevice> list) {
        for (EobrDevice eobrDevice : list) {
            if (!this.f4977g.contains(eobrDevice.m8991c())) {
                if (eobrDevice.mo1121o() != EobrType.GENX) {
                    return eobrDevice;
                }
                C2134e.m10678c("TT-DLDisc", "Skipping over GENX device " + eobrDevice.m8993e());
                this.f4977g.add(eobrDevice.m8991c());
            }
        }
        return null;
    }

    private void m7358a(EobrDevice eobrDevice) {
        EobrDevice eobrDevice2 = this.f4979i;
        this.f4979i = eobrDevice;
        this.f4975e.m9121b(eobrDevice2);
    }

    private void m7378l() {
        if (this.f4979i == null) {
            C2134e.m10682e("TT-DLDisc", "chose current device, but it was null");
            m7372i();
            return;
        }
        byte[] d;
        String l = this.f4979i.m9000l();
        if (am.m4188a((CharSequence) l)) {
            d = this.f4979i.m8992d();
        } else {
            d = null;
        }
        if (am.m4188a((CharSequence) l) && d == null) {
            C2134e.m10680d("TT-DLDisc", "ignoring attempt to choose device with no VIN or DashLink id");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Truck truck : OurApplication.m6294p().m6573c()) {
            if (!truck.getTruckNumber().equals(this.f4980j)) {
                if (d != null && Arrays.equals(truck.getAssociatedDashLink().m19091d(), d)) {
                    arrayList.add(truck.getTruckNumber());
                } else if (truck.getVin().equalsIgnoreCase(l)) {
                    arrayList.add(truck.getTruckNumber());
                }
            }
        }
        if (arrayList.isEmpty()) {
            m7380m();
        } else {
            C1632a.m7941a((Activity) this, this.f4980j, l, this.f4979i.m8991c(), arrayList);
        }
    }

    private void m7380m() {
        C2182e m = this.f4979i.m9001m();
        if (m == null) {
            C2134e.m10680d("TT-DLDisc", "Ignoring attempt to confirm odometer with no readings");
            return;
        }
        C2179d b = m.m10821b();
        if (b == null) {
            C2134e.m10680d("TT-DLDisc", "Ignoring attempt to confirm odometer with no best reading");
        } else if (!b.m10812b().m5465a()) {
            C2134e.m10678c("TT-DLDisc", "Ignoring attempt to confirm uncalibratable " + b.m10812b() + " odometer");
        } else if (b.m10812b() == CanonicalOdometerSource.DASHLINK_FIRMWARE) {
            C1632a.m7932a(this, OdometerSetConfirmMode.SET, this.f4980j, this.f4981k, -1, -1);
        } else {
            C1632a.m7932a(this, OdometerSetConfirmMode.CONFIRM, this.f4980j, this.f4981k, b.m10811a(), -1);
        }
    }

    private void m7352a(long j) {
        m7360a(null, j, true);
    }

    private void m7359a(OdometerUnit odometerUnit, long j) {
        m7360a(odometerUnit, j, false);
    }

    private void m7360a(OdometerUnit odometerUnit, long j, boolean z) {
        Serializable serializable = null;
        if (this.f4979i == null) {
            C2134e.m10682e("TT-DLDisc", "Ignoring attempt to set or confirm odometer with no current EobrDevice");
            return;
        }
        C2179d c2179d;
        C2182e m = this.f4979i.m9001m();
        if (m == null) {
            c2179d = null;
        } else {
            c2179d = m.m10821b();
        }
        if (m != null) {
            serializable = m.m10819a(j);
        }
        Intent putExtra = new Intent().putExtra("com.bigroad.ttb.truckNumber", this.f4980j).putExtra("com.bigroad.ttb.odometerOffsets", serializable).putExtra("com.bigroad.ttb.supportedBusTypes", this.f4979i.m9004p());
        if (odometerUnit != null) {
            putExtra.putExtra("com.bigroad.ttb.odometerUnit", odometerUnit);
        }
        if (z) {
            putExtra.putExtra("com.bigroad.ttb.eobrVersion", this.f4979i.m8980a());
        }
        if (c2179d != null && c2179d.m10812b() == CanonicalOdometerSource.DASHLINK_FIRMWARE) {
            putExtra.putExtra("com.bigroad.ttb.firmwareOdometerId", this.f4979i.m8992d());
        }
        if (am.m4188a(this.f4979i.m9000l())) {
            putExtra.putExtra("com.bigroad.ttb.macAddress", this.f4979i.m8992d());
        } else {
            putExtra.putExtra("com.bigroad.ttb.vin", this.f4979i.m9000l());
        }
        setResult(-1, putExtra);
        finish();
    }

    private void m7362b(long j) {
        C1632a.m7932a(this, OdometerSetConfirmMode.SET, this.f4980j, this.f4981k, j, -1);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.dashlink_discovery);
        this.f4982l = (ViewGroup) findViewById(R.id.dashLinkDiscovery_frame);
        this.f4983m = findViewById(R.id.dashLinkDiscovery_spinnerView);
        this.f4984n = (TextView) findViewById(R.id.dashLinkDiscovery_spinnerCaption);
        this.f4985o = (TextView) findViewById(R.id.dashLinkDiscovery_notFoundView);
        this.f4986p = findViewById(R.id.dashLinkDiscovery_foundView);
        this.f4987q = (TextView) findViewById(R.id.dashLinkDiscovery_modelYear);
        this.f4988r = (TextView) findViewById(R.id.dashLinkDiscovery_manufacturer);
        this.f4989s = (TextView) findViewById(R.id.dashLinkDiscovery_odometer);
        this.f4990t = (TextView) findViewById(R.id.dashLinkDiscovery_vin);
        this.f4991u = (TextView) findViewById(R.id.dashLinkDiscovery_dashLinkId);
        this.f4992v = (TextView) findViewById(R.id.dashLinkDiscovery_dashLinkVersion);
        this.f4994x = (TextView) findViewById(R.id.dashLinkDiscovery_message);
        this.f4993w = (TextView) findViewById(R.id.dashLinkDiscovery_isThisYourTruck);
        this.f4995y = (Button) findViewById(R.id.dashLinkDiscovery_connect);
        this.f4996z = (Button) findViewById(R.id.dashLinkDiscovery_skip);
        this.f4968A = (Button) findViewById(R.id.dashLinkDiscovery_cancel);
        this.f4969B = (Button) findViewById(R.id.dashLinkDiscovery_search);
        this.f4970C = getResources().getDimensionPixelSize(R.dimen.text_wrap_indent);
        this.f4968A.setOnClickListener(new C14544(this));
        this.f4969B.setOnClickListener(new C14555(this));
        this.f4995y.setOnClickListener(new C14566(this));
        this.f4996z.setOnClickListener(new C14577(this));
        this.f4980j = getIntent().getStringExtra("com.bigroad.ttb.truckNumber");
        this.f4981k = (OdometerUnit) getIntent().getSerializableExtra("com.bigroad.ttb.odometerUnit");
        m7354a(Mode.NOT_FOUND);
        this.f4975e.m9119a(this.f4971D, Priority.DEFAULT);
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        if (bundle == null) {
            m7367f();
        } else {
            Collection stringArrayList = bundle.getStringArrayList(f4966b);
            this.f4977g.clear();
            if (stringArrayList != null) {
                this.f4977g.addAll(stringArrayList);
            }
            m7358a(this.f4975e.m9113a(bundle.getString(f4967c)));
            if (this.f4975e.m9123b()) {
                m7367f();
            } else if (this.f4979i == null) {
                m7354a(Mode.NOT_FOUND);
            } else {
                m7374j();
            }
        }
        this.f4972E.run();
    }

    protected void onSaveInstanceState(Bundle bundle) {
        String str;
        super.onSaveInstanceState(bundle);
        String str2 = f4967c;
        if (this.f4979i == null) {
            str = null;
        } else {
            str = this.f4979i.m8991c();
        }
        bundle.putString(str2, str);
        bundle.putStringArrayList(f4966b, new ArrayList(this.f4977g));
    }

    protected void onDestroy() {
        m6701T().removeCallbacks(this.f4972E);
        m6701T().removeCallbacks(this.f4973F);
        this.f4975e.m9122b(this.f4971D);
        if (isFinishing()) {
            this.f4975e.m9125d();
            this.f4975e.m9127f();
        }
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        OdometerUnit odometerUnit = null;
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 23:
                if (i2 == -1) {
                    m7367f();
                    return;
                } else {
                    C2134e.m10676b("TT-DLDisc", "Bluetooth enabling canceled");
                    return;
                }
            case 28:
                if (i2 == -1) {
                    if (this.f4979i == null) {
                        C2134e.m10682e("TT-DLDisc", "Dup DashLink activity returned to a missing device.");
                        return;
                    } else {
                        m7380m();
                        return;
                    }
                } else if (i2 == 5) {
                    String stringExtra = intent.getStringExtra("com.bigroad.ttb.truckNumber");
                    C2134e.m10676b("TT-DLDisc", "Dup DashLink activity returned truck number " + stringExtra);
                    Truck c = this.f4976f.m6572c(stringExtra);
                    if (c == null) {
                        C2134e.m10682e("TT-DLDisc", "Dup DashLink activity asked for a switch to unknown truck number: " + stringExtra);
                        return;
                    }
                    if (!c.getHasAobrd()) {
                        this.f4976f.m6554a(stringExtra, null, null, null, null, true, null, null);
                    }
                    setResult(5, new Intent().putExtra("com.bigroad.ttb.truckNumber", stringExtra));
                    finish();
                    return;
                } else {
                    return;
                }
            case 32:
                long longExtra;
                if (intent != null) {
                    OdometerUnit odometerUnit2 = (OdometerUnit) intent.getSerializableExtra("com.bigroad.ttb.odometerUnit");
                    odometerUnit = odometerUnit2;
                    longExtra = intent.getLongExtra("com.bigroad.ttb.odometerValue", -1);
                } else {
                    C2134e.m10680d("TT-DLDisc", "Odometer data are not specified when setting or confirming odometer.");
                    longExtra = -1;
                }
                if (i2 == 8) {
                    m7359a(odometerUnit, longExtra);
                    return;
                } else if (i2 == 0) {
                    return;
                } else {
                    if (i2 == 9) {
                        m7352a(longExtra);
                        return;
                    } else if (i2 == 10) {
                        m7362b(longExtra);
                        return;
                    } else {
                        return;
                    }
                }
            default:
                return;
        }
    }
}
