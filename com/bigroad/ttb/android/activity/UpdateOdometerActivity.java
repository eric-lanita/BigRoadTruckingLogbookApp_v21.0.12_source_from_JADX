package com.bigroad.ttb.android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.bigroad.shared.aa;
import com.bigroad.shared.am;
import com.bigroad.shared.model.CanonicalOdometerUnit;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.TruckManager;
import com.bigroad.ttb.android.TruckManager.C1203b;
import com.bigroad.ttb.android.TruckManager.ChangeListener;
import com.bigroad.ttb.android.TruckManager.ChangeListener.Priority;
import com.bigroad.ttb.android.activity.OurActivity.Feature;
import com.bigroad.ttb.android.event.C2022a;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.util.ac;
import com.bigroad.ttb.android.widget.C1267k;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.Event.C2647a;
import com.bigroad.ttb.protocol.TTProtocol.EventType;
import com.bigroad.ttb.protocol.TTProtocol.OdometerUnit;
import com.bigroad.ttb.protocol.TTProtocol.Truck;

public class UpdateOdometerActivity extends OurKeyboardActivity {
    private final TruckManager f5577a = OurApplication.m6294p();
    private TextView f5578b;
    private TextView f5579c;
    private EditText f5580d;
    private TextView f5581e;
    private RadioGroup f5582f;
    private TextView f5583g;
    private Button f5584h;
    private Button f5585i;
    private boolean f5586j;
    private boolean f5587k = true;
    private String f5588l = null;
    private Truck f5589m = null;
    private OdometerUnit f5590n;
    private long f5591o;
    private int f5592p;
    private String f5593q = null;
    private final OnEditorActionListener f5594r = new C16091(this);
    private final TextWatcher f5595s = new C16102(this);
    private final ChangeListener f5596t = new C16113(this);
    private final OnClickListener f5597u = new C16124(this);
    private final OnClickListener f5598v = new C16135(this);
    private final OnClickListener f5599w = new C16146(this);
    private final OnClickListener f5600x = new C16157(this);
    private final OnClickListener f5601y = new C16168(this);

    class C16091 extends C1267k {
        final /* synthetic */ UpdateOdometerActivity f5562a;

        C16091(UpdateOdometerActivity updateOdometerActivity) {
            this.f5562a = updateOdometerActivity;
        }

        public boolean mo929a(TextView textView) {
            if (this.f5562a.f5586j) {
                this.f5562a.f5585i.performClick();
            }
            return false;
        }
    }

    class C16102 implements TextWatcher {
        final /* synthetic */ UpdateOdometerActivity f5563a;

        C16102(UpdateOdometerActivity updateOdometerActivity) {
            this.f5563a = updateOdometerActivity;
        }

        public void afterTextChanged(Editable editable) {
            this.f5563a.m7882a(editable.toString());
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    class C16113 extends C1203b {
        final /* synthetic */ UpdateOdometerActivity f5564a;

        C16113(UpdateOdometerActivity updateOdometerActivity) {
            this.f5564a = updateOdometerActivity;
        }

        public void mo894a(Truck truck) {
            this.f5564a.m7881a(truck);
        }
    }

    class C16124 implements OnClickListener {
        final /* synthetic */ UpdateOdometerActivity f5565a;

        C16124(UpdateOdometerActivity updateOdometerActivity) {
            this.f5565a = updateOdometerActivity;
        }

        public void onClick(View view) {
            CanonicalOdometerUnit c = this.f5565a.m7891h();
            this.f5565a.setResult(8, new Intent().putExtra("com.bigroad.ttb.odometerUnit", c.m5472b()).putExtra("com.bigroad.ttb.odometerValue", (long) Math.ceil(c.m5469a(aa.m4136a(this.f5565a.f5580d.getText().toString().trim(), 0)))));
            this.f5565a.finish();
        }
    }

    class C16135 implements OnClickListener {
        final /* synthetic */ UpdateOdometerActivity f5566a;

        C16135(UpdateOdometerActivity updateOdometerActivity) {
            this.f5566a = updateOdometerActivity;
        }

        public void onClick(View view) {
            this.f5566a.setResult(9, new Intent().putExtra("com.bigroad.ttb.odometerValue", this.f5566a.f5591o));
            this.f5566a.finish();
        }
    }

    class C16146 implements OnClickListener {
        final /* synthetic */ UpdateOdometerActivity f5567a;

        C16146(UpdateOdometerActivity updateOdometerActivity) {
            this.f5567a = updateOdometerActivity;
        }

        public void onClick(View view) {
            this.f5567a.setResult(0);
            this.f5567a.finish();
        }
    }

    class C16157 implements OnClickListener {
        final /* synthetic */ UpdateOdometerActivity f5568a;

        C16157(UpdateOdometerActivity updateOdometerActivity) {
            this.f5568a = updateOdometerActivity;
        }

        public void onClick(View view) {
            this.f5568a.setResult(10, new Intent().putExtra("com.bigroad.ttb.odometerValue", this.f5568a.f5591o));
            this.f5568a.finish();
        }
    }

    class C16168 implements OnClickListener {
        final /* synthetic */ UpdateOdometerActivity f5569a;

        C16168(UpdateOdometerActivity updateOdometerActivity) {
            this.f5569a = updateOdometerActivity;
        }

        public void onClick(View view) {
            Truck f = this.f5569a.m7893j();
            if (f != null) {
                int odometerUnit = f.getOdometerUnit();
                OdometerUnit b = this.f5569a.m7891h().m5472b();
                if (!(b == null || odometerUnit == b.m14669a())) {
                    OurApplication.m6289k().m6456a(f.getTruckId(), b);
                }
            }
            CharSequence obj = this.f5569a.f5580d.getText().toString();
            if (!am.m4188a(obj)) {
                try {
                    int intValue = Integer.valueOf(obj).intValue();
                    if (f != null) {
                        this.f5569a.f5577a.m6564a(Truck.newBuilder(f).m15571a(intValue).m15592c());
                        C2647a newBuilder = Event.newBuilder(C2022a.m10084a(EventType.USER_NOTE, OurApplication.m6269Z().mo914b(), OurApplication.m6285g().m12202d(), Long.valueOf(f.getTruckId()), OurApplication.m6302x().m10605e(), 0, OurApplication.ac()));
                        newBuilder.m13869e(intValue);
                        OurApplication.m6295q().m10050e(newBuilder.m13862c());
                    }
                } catch (Throwable e) {
                    C2134e.m10681d("TT-UpdateOdom", "Failed to update odometer due to invalid value: \"" + obj + "\"", e);
                    return;
                }
            }
            this.f5569a.setResult(-1);
            this.f5569a.finish();
        }
    }

    class C16179 implements OnClickListener {
        final /* synthetic */ UpdateOdometerActivity f5570a;

        C16179(UpdateOdometerActivity updateOdometerActivity) {
            this.f5570a = updateOdometerActivity;
        }

        public void onClick(View view) {
            this.f5570a.setResult(0);
            this.f5570a.finish();
        }
    }

    private enum OdometerMode {
        UPDATE,
        SET_OR_CONFIRM
    }

    public enum OdometerSetConfirmMode {
        SET,
        CONFIRM
    }

    public UpdateOdometerActivity() {
        super(Feature.FINISH_ON_SIGN_OUT);
    }

    private CanonicalOdometerUnit m7891h() {
        int checkedRadioButtonId = this.f5582f.getCheckedRadioButtonId();
        switch (checkedRadioButtonId) {
            case R.id.updateOdometer_milesButton:
                return CanonicalOdometerUnit.MILES;
            case R.id.updateOdometer_kmButton:
                return CanonicalOdometerUnit.KM;
            default:
                throw new IllegalArgumentException("Unrecognized odometer unit radio button ID: " + checkedRadioButtonId);
        }
    }

    private void m7881a(Truck truck) {
        Truck j = m7893j();
        if (truck != null && j != null && am.m4189a(truck.getTruckNumber(), j.getTruckNumber())) {
            if (am.m4188a(truck.getTruckNumber())) {
                this.f5578b.setVisibility(8);
            } else {
                CharSequence string = getString(R.string.updateOdometer_preamble, new Object[]{truck.getTruckNumber()});
                this.f5578b.setVisibility(0);
                this.f5578b.setText(string);
            }
            this.f5579c.setText(m7885b(truck));
        }
    }

    private void m7892i() {
        String truckNumber = (this.f5589m == null || am.m4188a(this.f5589m.getTruckNumber())) ? this.f5588l : this.f5589m.getTruckNumber();
        if (truckNumber != null) {
            CharSequence string = getString(R.string.setOdometerDialog_title, new Object[]{truckNumber});
            this.f5578b.setVisibility(0);
            this.f5578b.setText(string);
        } else {
            this.f5578b.setVisibility(8);
        }
        CanonicalOdometerUnit a = CanonicalOdometerUnit.m5466a(this.f5590n);
        if (a == null) {
            a = CanonicalOdometerUnit.MILES;
        }
        if (this.f5591o != -1) {
            this.f5579c.setText(Long.toString((long) a.m5471b(this.f5591o)));
        }
    }

    private void m7882a(String str) {
        boolean z;
        int intValue;
        Integer num;
        boolean z2 = true;
        Truck j = m7893j();
        boolean z3 = j != null && j.hasOdometer();
        if (am.m4188a((CharSequence) str)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            try {
                int odometer;
                Integer valueOf;
                intValue = Integer.valueOf(str).intValue();
                if (z3) {
                    odometer = j.getOdometer();
                    if (intValue >= odometer) {
                        valueOf = Integer.valueOf(intValue - odometer);
                        odometer = 0;
                    } else {
                        valueOf = Integer.valueOf(0);
                        z3 = true;
                    }
                } else {
                    odometer = 0;
                    Object obj = null;
                }
                num = valueOf;
                intValue = odometer;
                z3 = true;
            } catch (NumberFormatException e) {
                z3 = false;
                intValue = 0;
                num = null;
            }
        } else {
            z3 = true;
            intValue = 0;
            num = null;
        }
        if (num == null) {
            this.f5581e.setText(null);
        } else {
            this.f5581e.setText(num.toString());
        }
        if (intValue != 0) {
            this.f5583g.setVisibility(0);
        } else {
            this.f5583g.setVisibility(8);
        }
        this.f5585i.setEnabled(z3);
        if (!(intValue == 0 && z3)) {
            z2 = false;
        }
        this.f5586j = z2;
    }

    private static String m7885b(Truck truck) {
        if (truck == null || !truck.hasOdometer()) {
            return null;
        }
        return Integer.toString(truck.getOdometer());
    }

    private Truck m7893j() {
        if (this.f5589m == null) {
            return this.f5577a.m6578f();
        }
        return this.f5589m;
    }

    protected TextView mo930f() {
        if (this.f5587k) {
            return this.f5580d;
        }
        return null;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.update_odometer);
        OdometerSetConfirmMode odometerSetConfirmMode = (OdometerSetConfirmMode) getIntent().getSerializableExtra("com.bigroad.ttb.odometerToSet");
        this.f5588l = getIntent().getStringExtra("com.bigroad.ttb.truckNumber");
        this.f5590n = (OdometerUnit) getIntent().getSerializableExtra("com.bigroad.ttb.odometerUnit");
        this.f5591o = getIntent().getLongExtra("com.bigroad.ttb.odometerValue", -1);
        this.f5592p = getIntent().getIntExtra("com.bigroad.ttb.noteResId", -1);
        this.f5589m = this.f5577a.m6572c(this.f5588l);
        OdometerMode odometerMode = this.f5588l == null ? OdometerMode.UPDATE : OdometerMode.SET_OR_CONFIRM;
        this.f5587k = true;
        this.f5586j = true;
        this.f5578b = (TextView) findViewById(R.id.updateOdometer_preamble);
        TextView textView = (TextView) findViewById(R.id.updateOdometer_previousLabel);
        this.f5579c = (TextView) findViewById(R.id.updateOdometer_previousText);
        TextView textView2 = (TextView) findViewById(R.id.updateOdometer_newLabel);
        this.f5580d = (EditText) findViewById(R.id.updateOdometer_newText);
        TextView textView3 = (TextView) findViewById(R.id.updateOdometer_distanceLabel);
        this.f5581e = (TextView) findViewById(R.id.updateOdometer_distanceText);
        this.f5582f = (RadioGroup) findViewById(R.id.updateOdometer_unitsGroup);
        this.f5583g = (TextView) findViewById(R.id.updateOdometer_distanceWarning);
        this.f5584h = (Button) findViewById(R.id.updateOdometer_cancelButton);
        this.f5585i = (Button) findViewById(R.id.updateOdometer_updateButton);
        this.f5580d.addTextChangedListener(this.f5595s);
        this.f5580d.setOnEditorActionListener(this.f5594r);
        if (odometerMode == OdometerMode.UPDATE) {
            textView.setVisibility(0);
            this.f5579c.setVisibility(0);
            textView2.setText(R.string.updateOdometer_newLabel);
            textView3.setVisibility(0);
            this.f5581e.setVisibility(0);
            this.f5584h.setOnClickListener(new C16179(this));
            this.f5585i.setOnClickListener(this.f5601y);
            this.f5577a.m6560a(this.f5596t, Priority.DEFAULT);
            Truck j = m7893j();
            m7881a(j);
            if (bundle == null) {
                CharSequence b = m7885b(j);
                if (b != null) {
                    ac.m11179a(this.f5580d, b);
                }
                this.f5580d.requestFocus();
                if (j != null) {
                    switch (j.getOdometerUnit()) {
                        case 1:
                            this.f5582f.check(R.id.updateOdometer_kmButton);
                            return;
                        case 2:
                            this.f5582f.check(R.id.updateOdometer_milesButton);
                            return;
                        default:
                            this.f5582f.clearCheck();
                            return;
                    }
                }
                return;
            }
            return;
        }
        textView.setVisibility(8);
        this.f5579c.setVisibility(8);
        textView2.setText(R.string.setOdometerDialog_odometerLabel);
        textView3.setVisibility(8);
        this.f5581e.setVisibility(8);
        m7892i();
        textView = (TextView) findViewById(R.id.setOdometer_noteText);
        CanonicalOdometerUnit a;
        if (odometerSetConfirmMode == OdometerSetConfirmMode.SET) {
            this.f5585i.setOnClickListener(this.f5597u);
            this.f5584h.setOnClickListener(this.f5599w);
            if (this.f5592p == -1) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setText(this.f5592p);
            }
            if (bundle == null) {
                a = CanonicalOdometerUnit.m5466a(this.f5590n);
                if (a == null) {
                    a = CanonicalOdometerUnit.MILES;
                }
                if (this.f5591o != -1) {
                    ac.m11179a(this.f5580d, Long.toString((long) a.m5471b(this.f5591o)));
                }
                this.f5580d.requestFocus();
                this.f5582f.check(a == CanonicalOdometerUnit.MILES ? R.id.updateOdometer_milesButton : R.id.updateOdometer_kmButton);
                if (a != CanonicalOdometerUnit.MILES && a != CanonicalOdometerUnit.KM) {
                    this.f5582f.clearCheck();
                    return;
                }
                return;
            }
            return;
        }
        this.f5587k = false;
        this.f5585i.setOnClickListener(this.f5598v);
        this.f5584h.setOnClickListener(this.f5600x);
        ((TableLayout) findViewById(R.id.odometerWidgets)).setVisibility(8);
        a = CanonicalOdometerUnit.m5466a(this.f5590n);
        if (a == null) {
            this.f5593q = CanonicalOdometerUnit.MILES.m5473c(this.f5591o) + " / " + CanonicalOdometerUnit.KM.m5473c(this.f5591o);
        } else {
            this.f5593q = a.m5473c(this.f5591o);
        }
        textView.setVisibility(0);
        textView.setText(getString(R.string.dashLinkDiscovery_confirmOdometerMessage, new Object[]{this.f5593q}));
        this.f5584h.setText(R.string.no);
        this.f5585i.setText(R.string.yes);
    }

    protected void onDestroy() {
        this.f5577a.m6568b(this.f5596t);
        super.onDestroy();
    }
}
