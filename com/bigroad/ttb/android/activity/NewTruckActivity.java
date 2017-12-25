package com.bigroad.ttb.android.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.C0586c.C0584a;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.bigroad.shared.C1180y;
import com.bigroad.shared.af;
import com.bigroad.shared.am;
import com.bigroad.shared.duty.C0956v;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.TruckManager;
import com.bigroad.ttb.android.activity.OurActivity.Feature;
import com.bigroad.ttb.android.dialog.C1843a;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.util.C2303v;
import com.bigroad.ttb.android.util.ac;
import com.bigroad.ttb.protocol.TTProtocol.OdometerOffsets;
import com.bigroad.ttb.protocol.TTProtocol.OdometerUnit;
import com.bigroad.ttb.protocol.TTProtocol.Truck;

public class NewTruckActivity extends OurKeyboardActivity {
    private static final String f5338a = NewTruckActivity.class.getName();
    private static final String f5339b = (f5338a + ".vin");
    private static final String f5340c = (f5338a + ".dashLinkId");
    private static final String f5341d = (f5338a + ".odometerOffsets");
    private static final String f5342e = (f5338a + ".supportedBusTypes");
    private static final String f5343f = (f5338a + ".dashLinkVersion");
    private final TruckManager f5344g = OurApplication.m6294p();
    private String f5345h;
    private byte[] f5346i;
    private byte[] f5347j;
    private OdometerOffsets f5348k;
    private long f5349l;
    private String f5350m;
    private EditText f5351n;
    private EditText f5352o;
    private RadioGroup f5353p;
    private TextView f5354q;
    private TextView f5355r;
    private TextView f5356s;
    private TextView f5357t;
    private Button f5358u;
    private Button f5359v;

    class C15331 implements OnClickListener {
        final /* synthetic */ NewTruckActivity f5335a;

        C15331(NewTruckActivity newTruckActivity) {
            this.f5335a = newTruckActivity;
        }

        public void onClick(View view) {
            this.f5335a.setResult(0);
            this.f5335a.finish();
        }
    }

    class C15342 implements OnClickListener {
        final /* synthetic */ NewTruckActivity f5336a;

        C15342(NewTruckActivity newTruckActivity) {
            this.f5336a = newTruckActivity;
        }

        public void onClick(View view) {
            this.f5336a.m7719j();
        }
    }

    public static class TruckNumberRequiredDialogFragment extends DialogFragment {
        public static void m7714a(OurActivity ourActivity) {
            new TruckNumberRequiredDialogFragment().show(ourActivity.getSupportFragmentManager(), "dialog");
        }

        public Dialog onCreateDialog(Bundle bundle) {
            return new C0584a(getActivity()).m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.newTruck_truckNumberRequiredTitle).m2672b((int) R.string.newTruck_truckNumberRequiredMessage).m2661a(17039370, C1843a.f6286a).m2677b();
        }
    }

    public NewTruckActivity() {
        super(Feature.FINISH_ON_SIGN_OUT);
    }

    private OdometerUnit m7717h() {
        if (this.f5353p.getCheckedRadioButtonId() == R.id.newTruck_milesButton) {
            return OdometerUnit.MILES;
        }
        if (this.f5353p.getCheckedRadioButtonId() == R.id.newTruck_kmButton) {
            return OdometerUnit.KM;
        }
        return m6699R().m12230t();
    }

    private void m7716a(OdometerUnit odometerUnit) {
        if (odometerUnit != null) {
            switch (odometerUnit) {
                case MILES:
                    this.f5353p.check(R.id.newTruck_milesButton);
                    return;
                case KM:
                    this.f5353p.check(R.id.newTruck_kmButton);
                    return;
                case UNKNOWN_UNIT:
                    this.f5353p.clearCheck();
                    return;
                default:
                    return;
            }
        }
    }

    private String m7718i() {
        return this.f5351n.getText().toString().trim();
    }

    private void m7719j() {
        String i = m7718i();
        String trim = this.f5352o.getText().toString().trim();
        OdometerUnit h = m7717h();
        if (am.m4188a((CharSequence) i)) {
            TruckNumberRequiredDialogFragment.m7714a(this);
            return;
        }
        boolean z = (am.m4188a(this.f5345h) && this.f5346i == null) ? false : true;
        Intent intent = new Intent();
        if (this.f5344g.m6567a(i)) {
            intent.putExtra("com.bigroad.ttb.truck", this.f5344g.m6554a(i, trim, h, this.f5345h, this.f5346i, z, this.f5348k, this.f5347j).toByteArray());
        } else {
            intent.putExtra("com.bigroad.ttb.truck", this.f5344g.m6555a(i, trim, h, this.f5345h, this.f5346i, z, this.f5348k, this.f5347j, Long.valueOf(this.f5349l)).toByteArray());
        }
        setResult(-1, intent);
        finish();
    }

    private void m7720k() {
        int dimensionPixelSize;
        int i = 0;
        int i2 = 8;
        if (am.m4188a(this.f5345h)) {
            this.f5354q.setVisibility(8);
            if (this.f5346i != null) {
                dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.text_wrap_indent);
                C2303v b = C2303v.m11257b(dimensionPixelSize);
                b.m11262a(getString(R.string.newTruck_dashLinkIdLabel)).m11260a(' ').m11268c(C1180y.m5996c(this.f5346i));
                this.f5355r.setText(b.m11270e());
                if (this.f5350m != null) {
                    C2303v b2 = C2303v.m11257b(dimensionPixelSize);
                    b2.m11262a(getString(R.string.newTruck_dashLinkVersionLabel)).m11260a(' ').m11268c(this.f5350m);
                    this.f5356s.setText(b2.m11270e());
                    i2 = 0;
                }
                dimensionPixelSize = 0;
            } else {
                i = 8;
                dimensionPixelSize = 8;
            }
        } else {
            C2303v b3 = C2303v.m11257b(getResources().getDimensionPixelSize(R.dimen.text_wrap_indent));
            b3.m11262a(getString(R.string.newTruck_vinLabel)).m11260a(' ').m11268c(this.f5345h);
            this.f5354q.setText(b3.m11270e());
            this.f5354q.setVisibility(0);
            dimensionPixelSize = 0;
            i = 8;
        }
        this.f5357t.setVisibility(dimensionPixelSize);
        this.f5355r.setVisibility(i);
        this.f5356s.setVisibility(i2);
    }

    protected TextView mo930f() {
        if (this.f5351n.length() == 0) {
            return this.f5351n;
        }
        return this.f5352o;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.new_truck);
        m6692K().setStatusMessageVisible(false);
        this.f5351n = (EditText) findViewById(R.id.newTruck_truckNumber);
        this.f5352o = (EditText) findViewById(R.id.newTruck_truckLicense);
        this.f5353p = (RadioGroup) findViewById(R.id.newTruck_unitsGroup);
        this.f5354q = (TextView) findViewById(R.id.newTruck_vin);
        this.f5355r = (TextView) findViewById(R.id.newTruck_dashLinkId);
        this.f5356s = (TextView) findViewById(R.id.newTruck_dashLinkVersion);
        this.f5357t = (TextView) findViewById(R.id.newTruck_dashLinkNote);
        this.f5358u = (Button) findViewById(R.id.newTruck_cancel);
        this.f5359v = (Button) findViewById(R.id.newTruck_add);
        this.f5358u.setOnClickListener(new C15331(this));
        this.f5359v.setOnClickListener(new C15342(this));
        if (bundle == null) {
            CharSequence stringExtra = getIntent().getStringExtra("com.bigroad.ttb.truckNumber");
            ac.m11179a(this.f5351n, stringExtra);
            OdometerUnit odometerUnit = null;
            Truck c = this.f5344g.m6572c(stringExtra);
            if (c != null) {
                if (!am.m4188a(c.getTruckLicense())) {
                    ac.m11179a(this.f5352o, c.getTruckLicense());
                }
                if (c.hasOdometerUnit()) {
                    odometerUnit = af.m4151a(c);
                }
            }
            if (odometerUnit == null) {
                C0956v r = m6699R().m12228r();
                if (r == null || !r.mo706e()) {
                    odometerUnit = OdometerUnit.MILES;
                } else {
                    odometerUnit = OdometerUnit.KM;
                }
            }
            m7716a(odometerUnit);
        } else {
            this.f5345h = bundle.getString(f5339b);
            this.f5346i = bundle.getByteArray(f5340c);
            this.f5348k = (OdometerOffsets) bundle.getSerializable(f5341d);
            this.f5349l = bundle.getLong(f5342e);
        }
        m7720k();
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(f5339b, this.f5345h);
        bundle.putByteArray(f5340c, this.f5346i);
        bundle.putSerializable(f5341d, this.f5348k);
        bundle.putLong(f5342e, this.f5349l);
        bundle.putSerializable(f5343f, this.f5350m);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 27:
                if (i2 == -1) {
                    CharSequence stringExtra = intent.getStringExtra("com.bigroad.ttb.vin");
                    byte[] byteArrayExtra = intent.getByteArrayExtra("com.bigroad.ttb.macAddress");
                    if (!am.m4188a(stringExtra) || byteArrayExtra != null) {
                        this.f5345h = stringExtra;
                        this.f5346i = byteArrayExtra;
                        this.f5347j = intent.getByteArrayExtra("com.bigroad.ttb.firmwareOdometerId");
                        this.f5348k = (OdometerOffsets) intent.getSerializableExtra("com.bigroad.ttb.odometerOffsets");
                        this.f5349l = intent.getLongExtra("com.bigroad.ttb.supportedBusTypes", 0);
                        this.f5350m = intent.getStringExtra("com.bigroad.ttb.eobrVersion");
                        m7716a((OdometerUnit) intent.getSerializableExtra("com.bigroad.ttb.odometerUnit"));
                        m7720k();
                        return;
                    }
                    return;
                } else if (i2 == 5) {
                    String stringExtra2 = intent.getStringExtra("com.bigroad.ttb.truckNumber");
                    Truck c = this.f5344g.m6572c(stringExtra2);
                    if (c == null) {
                        C2134e.m10682e("TT-NewTruck", "DashLinkDiscovery asked for a switch to unknown truck number" + stringExtra2);
                        return;
                    }
                    setResult(-1, new Intent().putExtra("com.bigroad.ttb.truck", c.toByteArray()));
                    finish();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }
}
