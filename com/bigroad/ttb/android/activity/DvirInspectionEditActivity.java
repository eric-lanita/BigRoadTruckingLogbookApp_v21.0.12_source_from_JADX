package com.bigroad.ttb.android.activity;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.app.C0586c;
import android.support.v7.app.C0586c.C0584a;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.TimePicker;
import com.bigroad.shared.C0906x;
import com.bigroad.shared.aa;
import com.bigroad.shared.am;
import com.bigroad.shared.aq;
import com.bigroad.shared.validation.C1165e;
import com.bigroad.shared.validation.model.DvirInspection.Field;
import com.bigroad.shared.validation.p024b.C1153c;
import com.bigroad.ttb.android.C2226q;
import com.bigroad.ttb.android.C2226q.C1221a;
import com.bigroad.ttb.android.C2474y;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.TruckManager;
import com.bigroad.ttb.android.activity.OurActivity.Feature;
import com.bigroad.ttb.android.adapter.C1695r;
import com.bigroad.ttb.android.ai;
import com.bigroad.ttb.android.dialog.C1843a;
import com.bigroad.ttb.android.dialog.ConfirmUsingTruckDialogFragment;
import com.bigroad.ttb.android.dialog.ConfirmUsingTruckDialogFragment.C1378a;
import com.bigroad.ttb.android.fragment.LocationLookupEditText;
import com.bigroad.ttb.android.fragment.LocationLookupEditText.C1356a;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.model.C2186g;
import com.bigroad.ttb.android.p029c.C1736b;
import com.bigroad.ttb.android.p029c.C1738c;
import com.bigroad.ttb.android.p039h.C2085a;
import com.bigroad.ttb.android.p039h.C2094f;
import com.bigroad.ttb.android.util.ac;
import com.bigroad.ttb.android.widget.C2457g;
import com.bigroad.ttb.android.widget.C2458h;
import com.bigroad.ttb.android.widget.InstantAutoComplete;
import com.bigroad.ttb.protocol.TTProtocol.Dvir;
import com.bigroad.ttb.protocol.TTProtocol.Dvir.C2630a;
import com.bigroad.ttb.protocol.TTProtocol.DvirInspection;
import com.bigroad.ttb.protocol.TTProtocol.DvirInspection.C2632a;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import com.google.protobuf.C3642c;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.Calendar;
import java.util.TimeZone;

public class DvirInspectionEditActivity extends OurActivity implements C0906x, C1378a, C1356a {
    private static final String f5130a = (DvirInspectionEditActivity.class.getName() + ".currentDate");
    private static final String f5131b = (DvirInspectionEditActivity.class.getName() + ".currentTz");
    private static final String f5132c = (DvirInspectionEditActivity.class.getName() + ".dvirInspection");
    private final TruckManager f5133d = OurApplication.m6294p();
    private final C2226q f5134e = OurApplication.m6297s();
    private final C1736b f5135f = OurApplication.m6296r();
    private final ai f5136g = OurApplication.m6256M();
    private IntentExtras f5137h;
    private DvirInspection f5138i;
    private Calendar f5139j;
    private TextView f5140k;
    private TextView f5141l;
    private InstantAutoComplete f5142m;
    private InstantAutoComplete f5143n;
    private EditText f5144o;
    private EditText f5145p;
    private CheckBox f5146q;
    private InstantAutoComplete f5147r;
    private C1695r f5148s;
    private C1695r f5149t;
    private C1695r f5150u;
    private C2094f<Field> f5151v = new C2094f(this);
    private C2457g f5152w = null;
    private final OnTimeSetListener f5153x = new C14821(this);
    private final C1221a f5154y = new C14909(this);

    class C14821 implements OnTimeSetListener {
        final /* synthetic */ DvirInspectionEditActivity f5111a;

        C14821(DvirInspectionEditActivity dvirInspectionEditActivity) {
            this.f5111a = dvirInspectionEditActivity;
        }

        public void onTimeSet(TimePicker timePicker, int i, int i2) {
            this.f5111a.m7505a(i, i2);
        }
    }

    class C14832 implements OnClickListener {
        final /* synthetic */ DvirInspectionEditActivity f5112a;

        C14832(DvirInspectionEditActivity dvirInspectionEditActivity) {
            this.f5112a = dvirInspectionEditActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f5112a.m7533q();
            dialogInterface.dismiss();
        }
    }

    class C14843 implements OnClickListener {
        final /* synthetic */ DvirInspectionEditActivity f5113a;

        C14843(DvirInspectionEditActivity dvirInspectionEditActivity) {
            this.f5113a = dvirInspectionEditActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f5113a.m7506a(this.f5113a.m7538v() ? this.f5113a.f5143n : this.f5113a.f5142m);
            dialogInterface.dismiss();
        }
    }

    class C14854 implements OnClickListener {
        final /* synthetic */ DvirInspectionEditActivity f5114a;

        C14854(DvirInspectionEditActivity dvirInspectionEditActivity) {
            this.f5114a = dvirInspectionEditActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f5114a.m7529m();
            dialogInterface.dismiss();
        }
    }

    class C14865 implements OnClickListener {
        final /* synthetic */ DvirInspectionEditActivity f5115a;

        C14865(DvirInspectionEditActivity dvirInspectionEditActivity) {
            this.f5115a = dvirInspectionEditActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f5115a.m7530n();
            dialogInterface.dismiss();
        }
    }

    class C14876 implements Runnable {
        final /* synthetic */ DvirInspectionEditActivity f5116a;

        C14876(DvirInspectionEditActivity dvirInspectionEditActivity) {
            this.f5116a = dvirInspectionEditActivity;
        }

        public void run() {
            this.f5116a.mo961i();
        }
    }

    class C14887 implements OnCheckedChangeListener {
        final /* synthetic */ DvirInspectionEditActivity f5117a;

        C14887(DvirInspectionEditActivity dvirInspectionEditActivity) {
            this.f5117a = dvirInspectionEditActivity;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.f5117a.mo961i();
        }
    }

    class C14909 implements C1221a {
        final /* synthetic */ DvirInspectionEditActivity f5119a;

        C14909(DvirInspectionEditActivity dvirInspectionEditActivity) {
            this.f5119a = dvirInspectionEditActivity;
        }

        public void mo905a(C2226q c2226q) {
            this.f5119a.m7534r();
            this.f5119a.mo961i();
        }
    }

    public static class IntentExtras implements Parcelable {
        public static final Creator<IntentExtras> CREATOR = new C14911();
        private final Integer f5120a;
        private final String f5121b;
        private final String f5122c;
        private final byte[] f5123d;
        private final byte[] f5124e;
        private final Boolean f5125f;

        static class C14911 implements Creator<IntentExtras> {
            C14911() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m7488a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m7489a(i);
            }

            public IntentExtras m7488a(Parcel parcel) {
                return new IntentExtras(parcel);
            }

            public IntentExtras[] m7489a(int i) {
                return new IntentExtras[i];
            }
        }

        IntentExtras(int i, String str, String str2, C3642c c3642c, DvirInspection dvirInspection, Mode mode) {
            byte[] bArr = null;
            this.f5120a = Integer.valueOf(i);
            this.f5121b = str;
            this.f5122c = str2;
            this.f5123d = c3642c == null ? null : c3642c.m19091d();
            if (dvirInspection != null) {
                bArr = dvirInspection.toByteArray();
            }
            this.f5124e = bArr;
            this.f5125f = Boolean.valueOf(mode == Mode.ADD);
        }

        public static IntentExtras m7490a(int i, String str, String str2, C3642c c3642c, DvirInspection dvirInspection) {
            return new IntentExtras(i, str, str2, c3642c, dvirInspection, Mode.ADD);
        }

        public static IntentExtras m7491a(Dvir dvir, DvirInspection dvirInspection) {
            return new IntentExtras(dvir.getLogDay(), dvir.getCarrierName(), dvir.getInspectorName(), dvir.getId(), dvirInspection, Mode.EDIT);
        }

        public int m7492a() {
            return this.f5120a.intValue();
        }

        public String m7493b() {
            return this.f5121b;
        }

        public String m7494c() {
            return this.f5122c;
        }

        public C3642c m7495d() {
            return this.f5123d == null ? null : C3642c.m19078a(this.f5123d);
        }

        public C3642c m7496e() {
            return this.f5124e == null ? null : C3642c.m19078a(this.f5124e);
        }

        public Mode m7497f() {
            if (this.f5125f == null || !this.f5125f.booleanValue()) {
                return Mode.EDIT;
            }
            return Mode.ADD;
        }

        private IntentExtras(Parcel parcel) {
            ClassLoader classLoader = IntentExtras.class.getClassLoader();
            this.f5120a = (Integer) parcel.readValue(classLoader);
            this.f5121b = (String) parcel.readValue(classLoader);
            this.f5122c = (String) parcel.readValue(classLoader);
            this.f5123d = (byte[]) parcel.readValue(classLoader);
            this.f5124e = (byte[]) parcel.readValue(classLoader);
            this.f5125f = (Boolean) parcel.readValue(classLoader);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeValue(this.f5120a);
            parcel.writeValue(this.f5121b);
            parcel.writeValue(this.f5122c);
            parcel.writeValue(this.f5123d);
            parcel.writeValue(this.f5124e);
            parcel.writeValue(this.f5125f);
        }
    }

    enum Mode {
        ADD(R.string.dvirEditVehicle_titleAdd),
        EDIT(R.string.dvirEditVehicle_titleEdit);
        
        private final int m_titleResId;

        private Mode(int i) {
            this.m_titleResId = i;
        }

        public int m7498a() {
            return this.m_titleResId;
        }
    }

    private class C1492a extends C1153c {
        final /* synthetic */ DvirInspectionEditActivity f5129a;

        private C1492a(DvirInspectionEditActivity dvirInspectionEditActivity) {
            this.f5129a = dvirInspectionEditActivity;
        }

        public int mo845b() {
            return this.f5129a.f5138i.getVehicleType();
        }

        public String mo846c() {
            return this.f5129a.m7526k();
        }

        public Integer mo847d() {
            int a = aa.m4133a(this.f5129a.f5145p.getText().toString().trim(), -1);
            return a < 0 ? null : Integer.valueOf(a);
        }

        public String mo848e() {
            return LocationLookupEditText.m10365d(this.f5129a, R.id.dvirEditVehicle_locationFragment);
        }

        public boolean mo849f() {
            return this.f5129a.f5146q.isChecked();
        }

        public String mo850g() {
            return this.f5129a.f5147r.getText().toString().trim();
        }
    }

    private void m7506a(EditText editText) {
        if (editText != null) {
            editText.setSelection(editText.length());
            editText.requestFocus();
        }
    }

    public DvirInspectionEditActivity() {
        super(Feature.FINISH_ON_SIGN_OUT);
    }

    private TextView m7523j() {
        if (m7538v()) {
            return this.f5141l;
        }
        return this.f5142m;
    }

    private String m7526k() {
        if (m7538v()) {
            return this.f5138i.getVehicleNumber();
        }
        return this.f5142m.getText().toString().trim();
    }

    private void m7528l() {
        if (this.f5138i != null) {
            C2632a newBuilder = DvirInspection.newBuilder(this.f5138i);
            newBuilder.m13672b(m7526k());
            String trim = this.f5143n.getText().toString().trim();
            if (am.m4188a((CharSequence) trim)) {
                newBuilder.m13689n();
            } else {
                newBuilder.m13675c(trim);
            }
            int a = aa.m4133a(this.f5145p.getText().toString().trim(), -1);
            if (a < 0) {
                newBuilder.m13690o();
            } else {
                newBuilder.m13671b(a);
            }
            trim = LocationLookupEditText.m10365d(this, R.id.dvirEditVehicle_locationFragment);
            if (am.m4188a((CharSequence) trim)) {
                newBuilder.m13686k();
            } else {
                newBuilder.m13668a(trim);
            }
            newBuilder.m13669a(this.f5146q.isChecked());
            CharSequence obj = this.f5147r.getText().toString();
            if (am.m4188a(obj)) {
                newBuilder.m13691p();
            } else {
                newBuilder.m13678d(obj);
            }
            this.f5138i = newBuilder.m13676c();
        }
    }

    private void m7514d(int i) {
        if (this.f5138i != null) {
            C2474y R = m6699R();
            this.f5136g.m8377a(this.f5137h.m7493b(), 6);
            this.f5136g.m8377a(this.f5137h.m7494c(), 7);
            this.f5136g.m8374a(this.f5147r, 10);
            if (m7538v()) {
                this.f5136g.m8377a(m7526k(), 1);
                this.f5136g.m8374a(this.f5143n, 8);
            } else {
                this.f5136g.m8377a(m7526k(), 2);
                this.f5136g.m8374a(this.f5143n, 9);
            }
            if (this.f5137h.m7497f() == Mode.EDIT) {
                this.f5134e.m10984b(this.f5138i);
                this.f5133d.m6563a(this.f5138i);
            } else if (this.f5137h.m7497f() == Mode.ADD) {
                int i2;
                Truck f = this.f5133d.m6578f();
                String truckNumber = f != null ? f.getTruckNumber() : null;
                int e = C1738c.m8516e(OurApplication.m6296r().m8480b(this.f5137h.m7492a()));
                Long d = this.f5134e.m10989d(this.f5137h.m7492a());
                if (this.f5138i.getVehicleType() != 1 || e != this.f5137h.m7492a() || am.m4188a(this.f5138i.getVehicleNumber()) || am.m4189a(truckNumber, this.f5138i.getVehicleNumber()) || (d != null && this.f5138i.getOccurredAt() <= d.longValue())) {
                    i2 = 0;
                } else {
                    i2 = 1;
                }
                Dvir a = this.f5134e.m10971a(this.f5137h.m7495d());
                if (a == null) {
                    C2630a a2 = Dvir.newBuilder().m13627a(com.bigroad.shared.ai.m4174a()).m13623a(R.m12202d()).m13621a(this.f5137h.m7492a()).m13626a(this.f5138i);
                    long g = R.m12213g();
                    if (g >= 0) {
                        a2.m13633b(g);
                    }
                    if (!am.m4188a(this.f5137h.m7494c())) {
                        a2.m13630a(this.f5137h.m7494c());
                    }
                    if (!am.m4188a(this.f5137h.m7493b())) {
                        a2.m13635b(this.f5137h.m7493b());
                    }
                    this.f5134e.m10975a(a2.m13638c());
                } else {
                    this.f5134e.m10976a(a.getId(), this.f5138i);
                }
                if (this.f5138i.getVehicleType() == 1) {
                    this.f5135f.m8473a(this.f5137h.m7492a(), this.f5138i);
                }
                this.f5133d.m6563a(this.f5138i);
                if (i2 != 0) {
                    ConfirmUsingTruckDialogFragment.m8829a(this, this.f5138i.getVehicleNumber());
                    setResult(i, new Intent().putExtra("com.bigroad.ttb.dvirInspection", this.f5138i.toByteArray()));
                    return;
                }
            } else {
                C2134e.m10682e("TT-DvirInspectionEdit", "Unexpected Mode value used");
            }
            setResult(i, new Intent().putExtra("com.bigroad.ttb.dvirInspection", this.f5138i.toByteArray()));
            finish();
        }
    }

    public void mo980a(String str) {
        finish();
    }

    private void m7529m() {
        m7528l();
        if (this.f5138i != null) {
            m7514d(-1);
        }
    }

    private void m7530n() {
        m7528l();
        if (this.f5138i != null) {
            C3642c id = this.f5138i.getId();
            this.f5138i = DvirInspection.newBuilder(this.f5138i).m13666a(com.bigroad.shared.ai.m4174a()).m13676c();
            this.f5137h = IntentExtras.m7490a(this.f5137h.m7492a(), this.f5137h.m7493b(), this.f5137h.m7494c(), null, this.f5138i);
            this.f5134e.m10990d(id);
            m7514d(-1);
        }
    }

    private boolean m7531o() {
        if (this.f5138i.getVehicleType() != 1 || this.f5137h.m7495d() == null) {
            return false;
        }
        Dvir a = this.f5134e.m10971a(this.f5137h.m7495d());
        if (a == null) {
            return false;
        }
        boolean z = false;
        for (DvirInspection dvirInspection : a.getInspectionList()) {
            if (dvirInspection.getVehicleType() == 1) {
                if (am.m4189a(dvirInspection.getVehicleNumber(), this.f5138i.getVehicleNumber()) && am.m4189a(dvirInspection.getVehicleLicense(), this.f5138i.getVehicleLicense())) {
                    return false;
                }
                if (!this.f5138i.getId().equals(dvirInspection.getId())) {
                    z = true;
                }
            }
        }
        return z;
    }

    private String m7532p() {
        if (this.f5138i.getVehicleType() == 1) {
            return C2186g.m10833a(this.f5138i).m10837a((Context) this);
        }
        return "";
    }

    private void m7517e(int i) {
        m7528l();
        if (this.f5138i != null) {
            if (am.m4188a(this.f5138i.getVehicleNumber())) {
                showDialog(2);
            } else if (m7531o()) {
                showDialog(3);
            } else {
                m7514d(i);
            }
        }
    }

    private void m7519f(int i) {
        setResult(i);
        finish();
    }

    private void m7533q() {
        if (this.f5138i != null) {
            this.f5134e.m10990d(this.f5138i.getId());
        }
        setResult(3);
        finish();
    }

    private void m7534r() {
        if (this.f5138i != null && this.f5137h.m7497f() == Mode.EDIT && this.f5134e.m10986c(this.f5138i.getId()) == null) {
            C2134e.m10678c("TT-DvirInspectionEdit", "DVIR inspection went away; finishing");
            m7519f(4);
        }
    }

    public void onBackPressed() {
        switch (this.f5137h.m7497f()) {
            case EDIT:
                m7517e(0);
                return;
            default:
                m7519f(0);
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5137h = (IntentExtras) getIntent().getParcelableExtra("com.bigroad.ttb.dvirInspectionActivity");
        if (this.f5137h == null) {
            C2134e.m10682e("TT-DvirInspectionEdit", "Could not start DvirInspectionEditActivity - no extras found");
            m7519f(4);
            return;
        }
        C3642c e;
        if (bundle == null) {
            this.f5139j = C1738c.m8509a(this.f5137h.m7492a(), OurApplication.m6296r().m8480b(this.f5137h.m7492a()));
            e = this.f5137h.m7496e();
        } else {
            this.f5139j = Calendar.getInstance(TimeZone.getTimeZone(bundle.getString(f5131b)));
            this.f5139j.setTimeInMillis(bundle.getLong(f5130a));
            e = C3642c.m19078a(bundle.getByteArray(f5132c));
        }
        try {
            this.f5138i = DvirInspection.parseFrom(e);
        } catch (InvalidProtocolBufferException e2) {
            C2134e.m10680d("TT-DvirInspectionEdit", "Unable to unpack saved DvirInspection instance state: " + e2);
        }
        if (this.f5138i == null) {
            m7519f(4);
            return;
        }
        int i;
        setContentView((int) R.layout.dvir_edit_vehicle);
        setTitle(getString(this.f5137h.m7497f().m7498a(), new Object[]{C1738c.m8514c(this.f5137h.m7492a())}));
        this.f5140k = (TextView) findViewById(R.id.dvirEditVehicle_vehicleLabel);
        this.f5141l = (TextView) findViewById(R.id.dvirEditVehicle_truckNumber);
        this.f5142m = (InstantAutoComplete) findViewById(R.id.dvirEditVehicle_trailerNumber);
        this.f5143n = (InstantAutoComplete) findViewById(R.id.dvirEditVehicle_license);
        this.f5144o = (EditText) findViewById(R.id.dvirEditVehicle_occurredAt);
        this.f5145p = (EditText) findViewById(R.id.dvirEditVehicle_odometer);
        this.f5146q = (CheckBox) findViewById(R.id.dvirEditVehicle_foundDefects);
        this.f5147r = (InstantAutoComplete) findViewById(R.id.dvirEditVehicle_note);
        this.f5148s = this.f5136g.m8372a((Context) this, 2);
        this.f5149t = this.f5136g.m8372a((Context) this, 8);
        this.f5150u = this.f5136g.m8372a((Context) this, 9);
        this.f5147r.setAdapter(this.f5136g.m8372a((Context) this, 10));
        if (m7538v()) {
            this.f5142m.setVisibility(8);
            this.f5143n.setAdapter(this.f5149t);
            i = R.string.dvirEditVehicle_truckLabel;
        } else {
            this.f5141l.setVisibility(8);
            this.f5142m.setAdapter(this.f5148s);
            this.f5143n.setAdapter(this.f5150u);
            i = R.string.dvirEditVehicle_trailerLabel;
        }
        this.f5140k.setText(i);
        mo961i();
        this.f5143n.setOnEditorActionListener(new OnEditorActionListener(this) {
            final /* synthetic */ DvirInspectionEditActivity f5104a;

            {
                this.f5104a = r1;
            }

            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 5) {
                    return false;
                }
                this.f5104a.f5145p.requestFocus();
                return true;
            }
        });
        this.f5144o.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ DvirInspectionEditActivity f5105a;

            {
                this.f5105a = r1;
            }

            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getActionMasked() != 1) {
                    return false;
                }
                view.requestFocus();
                this.f5105a.showDialog(0);
                return true;
            }
        });
        this.f5144o.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ DvirInspectionEditActivity f5106a;

            {
                this.f5106a = r1;
            }

            public void onClick(View view) {
                this.f5106a.showDialog(0);
            }
        });
        Button button = (Button) findViewById(R.id.dvirEditVehicle_delete);
        if (this.f5137h.m7497f() == Mode.EDIT) {
            button.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ DvirInspectionEditActivity f5107a;

                {
                    this.f5107a = r1;
                }

                public void onClick(View view) {
                    this.f5107a.showDialog(1);
                }
            });
        } else {
            button.setVisibility(8);
        }
        button = (Button) findViewById(R.id.dvirEditVehicle_cancel);
        if (this.f5137h.m7497f() == Mode.ADD) {
            button.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ DvirInspectionEditActivity f5108a;

                {
                    this.f5108a = r1;
                }

                public void onClick(View view) {
                    this.f5108a.m7519f(0);
                }
            });
        } else {
            button.setVisibility(8);
        }
        ((Button) findViewById(R.id.dvirEditVehicle_done)).setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ DvirInspectionEditActivity f5109a;

            {
                this.f5109a = r1;
            }

            public void onClick(View view) {
                this.f5109a.m7517e(-1);
            }
        });
        this.f5147r.setNextFocusDownId(R.id.dvirEditVehicle_done);
        if (bundle == null) {
            m7539w();
            mo930f();
        } else if (m7538v()) {
            this.f5141l.setText(this.f5138i.getVehicleNumber());
        }
        this.f5152w = new C2457g(m6701T(), new Runnable(this) {
            final /* synthetic */ DvirInspectionEditActivity f5110a;

            {
                this.f5110a = r1;
            }

            public void run() {
                this.f5110a.mo961i();
            }
        }, 500);
        if (getIntent().getBooleanExtra("com.bigroad.ttb.isFixing", false)) {
            findViewById(R.id.dvirEditVehicle_nextValidationText).setVisibility(0);
        }
        this.f5134e.m10974a(this.f5154y);
        m7534r();
        mo974h();
        mo961i();
    }

    void mo930f() {
        EditText editText = null;
        if (!m7538v() && this.f5142m.length() == 0) {
            editText = this.f5142m;
        } else if (this.f5143n.length() == 0) {
            editText = this.f5143n;
        } else if (this.f5145p.length() == 0) {
            editText = this.f5145p;
        } else {
            LocationLookupEditText.m10364c(this, R.id.dvirEditVehicle_locationFragment);
        }
        m7506a(editText);
    }

    public int a_() {
        return this.f5137h.m7492a();
    }

    public void onDestroy() {
        this.f5134e.m10982b(this.f5154y);
        super.onDestroy();
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong(f5130a, this.f5139j.getTimeInMillis());
        bundle.putString(f5131b, this.f5139j.getTimeZone().getID());
        if (this.f5138i != null) {
            bundle.putByteArray(f5132c, this.f5138i.toByteArray());
        }
    }

    public Dialog onCreateDialog(int i) {
        switch (i) {
            case 0:
                Calendar s = m7535s();
                return new TimePickerDialog(this, this.f5153x, s.get(11), s.get(12), DateFormat.is24HourFormat(this));
            case 1:
                return new C0584a(this).m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.dvirEditVehicle_deleteConfirmationTitle).m2672b((int) R.string.dvirEditVehicle_deleteConfirmationMessage).m2661a((int) R.string.dvirEditVehicle_deleteButton, new C14832(this)).m2673b(17039360, C1843a.f6286a).m2677b();
            case 2:
                return new C0584a(this).m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.dvirEditVehicle_noUnitNumberTitle).m2672b((int) R.string.dvirEditVehicle_noUnitNumberMessage).m2661a(17039370, new C14843(this)).m2677b();
            case 3:
                return new C0584a(this).m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.newInspection_secondTruckTitle).m2675b(getString(R.string.newInspection_conflictingTruckMessage, new Object[]{m7532p()})).m2661a((int) R.string.newInspection_conflictingTruckNewDvirButton, new C14865(this)).m2673b((int) R.string.newInspection_conflictingTruckAddButton, new C14854(this)).m2677b();
            default:
                return super.onCreateDialog(i);
        }
    }

    protected void onPrepareDialog(int i, Dialog dialog) {
        super.onPrepareDialog(i, dialog);
        switch (i) {
            case 0:
                Calendar s = m7535s();
                ((TimePickerDialog) dialog).updateTime(s.get(11), s.get(12));
                return;
            case 3:
                C0586c c0586c = (C0586c) dialog;
                c0586c.m2693a(getString(R.string.newInspection_conflictingTruckMessage, new Object[]{m7532p()}));
                return;
            default:
                return;
        }
    }

    private Calendar m7535s() {
        Calendar calendar = (Calendar) this.f5139j.clone();
        if (this.f5138i.hasOccurredAt()) {
            calendar.setTimeInMillis(this.f5138i.getOccurredAt());
        }
        return calendar;
    }

    private void m7505a(int i, int i2) {
        Calendar s = m7535s();
        aq.m4223a(s, i, i2);
        this.f5138i = DvirInspection.newBuilder(this.f5138i).m13664a(s.getTimeInMillis()).m13676c();
        m7537u();
    }

    private String m7536t() {
        Calendar s = m7535s();
        java.text.DateFormat timeFormat = DateFormat.getTimeFormat(this);
        timeFormat.setTimeZone(s.getTimeZone());
        return timeFormat.format(s.getTime());
    }

    private void m7537u() {
        this.f5144o.setText(m7536t());
    }

    private boolean m7538v() {
        boolean z = true;
        if (this.f5138i == null) {
            return false;
        }
        if (this.f5138i.getVehicleType() != 1) {
            z = false;
        }
        return z;
    }

    private void m7539w() {
        if (m7538v()) {
            this.f5141l.setText(this.f5138i.getVehicleNumber());
        } else {
            ac.m11179a(this.f5142m, this.f5138i.getVehicleNumber());
        }
        ac.m11179a(this.f5143n, this.f5138i.getVehicleLicense());
        m7537u();
        if (this.f5138i.hasLocationName()) {
            LocationLookupEditText.m10357a(this, R.id.dvirEditVehicle_locationFragment, this.f5138i.getLocationName(), false);
        }
        if (this.f5138i.hasOdometer()) {
            ac.m11179a(this.f5145p, Integer.toString(this.f5138i.getOdometer()));
        }
        this.f5146q.setChecked(this.f5138i.getFoundDefects());
        if (this.f5138i.hasRemarks()) {
            ac.m11179a(this.f5147r, this.f5138i.getRemarks());
        }
    }

    protected void mo974h() {
        TextWatcher c2458h = new C2458h(m6701T(), new C14876(this));
        OnCheckedChangeListener c14887 = new C14887(this);
        m7523j().addTextChangedListener(c2458h);
        this.f5143n.addTextChangedListener(c2458h);
        this.f5145p.addTextChangedListener(c2458h);
        this.f5147r.addTextChangedListener(c2458h);
        this.f5146q.setOnCheckedChangeListener(c14887);
        this.f5151v.m10486a();
        this.f5151v.m10488a(Field.VEHICLE_NUMBER, R.id.dvirEditVehicle_vehicleNameError, R.id.dvirEditVehicle_vehicleNameErrorText);
        this.f5151v.m10488a(Field.VEHICLE_LICENSE, R.id.dvirEditVehicle_licenseError, R.id.dvirEditVehicle_licenseErrorText);
        this.f5151v.m10488a(Field.ODOMETER, R.id.dvirEditVehicle_odometerError, R.id.dvirEditVehicle_odometerErrorText);
        this.f5151v.m10488a(Field.REMARKS, R.id.dvirEditVehicle_noteError, R.id.dvirEditVehicle_noteErrorText);
    }

    public void mo958H() {
        if (this.f5152w != null) {
            this.f5152w.m12102b();
        }
    }

    protected void mo961i() {
        if (this.f5138i != null) {
            C1492a c1492a = new C1492a();
            C1165e.m5931a(c1492a, new C2085a(), a_());
            this.f5151v.m10487a(c1492a.mo716A(), this);
            LocationLookupEditText.m10358a((OurActivity) this, (int) R.id.dvirEditVehicle_locationFragment, c1492a.mo716A().m5961b(Field.LOCATION_NAME));
        }
    }
}
