package com.bigroad.ttb.android.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.C0586c.C0584a;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.bigroad.shared.C0906x;
import com.bigroad.shared.C1180y;
import com.bigroad.shared.am;
import com.bigroad.shared.validation.C1166f;
import com.bigroad.shared.validation.model.Dvir.Field;
import com.bigroad.shared.validation.model.DvirInspection;
import com.bigroad.shared.validation.p024b.C1155d;
import com.bigroad.ttb.android.C2226q;
import com.bigroad.ttb.android.C2226q.C1221a;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.OurActivity.Feature;
import com.bigroad.ttb.android.ai;
import com.bigroad.ttb.android.dialog.C1843a;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.p029c.C1738c;
import com.bigroad.ttb.android.p039h.C2085a;
import com.bigroad.ttb.android.p039h.C2094f;
import com.bigroad.ttb.android.util.ac;
import com.bigroad.ttb.android.widget.C2458h;
import com.bigroad.ttb.android.widget.InstantAutoComplete;
import com.bigroad.ttb.protocol.TTProtocol.Dvir;
import com.bigroad.ttb.protocol.TTProtocol.Dvir.C2630a;
import com.google.protobuf.C3642c;
import java.util.Collections;
import java.util.List;

public class DvirHeaderEditActivity extends OurKeyboardActivity implements C0906x {
    private C2226q f5093a = OurApplication.m6297s();
    private ai f5094b = OurApplication.m6256M();
    private C3642c f5095c;
    private int f5096d;
    private InstantAutoComplete f5097e;
    private InstantAutoComplete f5098f;
    private Button f5099g;
    private Button f5100h;
    private TextView f5101i;
    private C2094f<Field> f5102j = new C2094f(this);
    private final C1221a f5103k = new C14761(this);

    class C14761 implements C1221a {
        final /* synthetic */ DvirHeaderEditActivity f5087a;

        C14761(DvirHeaderEditActivity dvirHeaderEditActivity) {
            this.f5087a = dvirHeaderEditActivity;
        }

        public void mo905a(C2226q c2226q) {
            this.f5087a.m7481s();
            this.f5087a.mo963k();
        }
    }

    class C14772 implements OnClickListener {
        final /* synthetic */ DvirHeaderEditActivity f5088a;

        C14772(DvirHeaderEditActivity dvirHeaderEditActivity) {
            this.f5088a = dvirHeaderEditActivity;
        }

        public void onClick(View view) {
            this.f5088a.showDialog(0);
        }
    }

    class C14783 implements OnClickListener {
        final /* synthetic */ DvirHeaderEditActivity f5089a;

        C14783(DvirHeaderEditActivity dvirHeaderEditActivity) {
            this.f5089a = dvirHeaderEditActivity;
        }

        public void onClick(View view) {
            this.f5089a.m7478p();
        }
    }

    class C14794 implements DialogInterface.OnClickListener {
        final /* synthetic */ DvirHeaderEditActivity f5090a;

        C14794(DvirHeaderEditActivity dvirHeaderEditActivity) {
            this.f5090a = dvirHeaderEditActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f5090a.m7479q();
            dialogInterface.dismiss();
        }
    }

    class C14805 implements Runnable {
        final /* synthetic */ DvirHeaderEditActivity f5091a;

        C14805(DvirHeaderEditActivity dvirHeaderEditActivity) {
            this.f5091a = dvirHeaderEditActivity;
        }

        public void run() {
            this.f5091a.mo963k();
        }
    }

    private class C1481a extends C1155d {
        final /* synthetic */ DvirHeaderEditActivity f5092a;

        private C1481a(DvirHeaderEditActivity dvirHeaderEditActivity) {
            this.f5092a = dvirHeaderEditActivity;
        }

        public int mo852b() {
            return this.f5092a.a_();
        }

        public String mo853c() {
            return this.f5092a.mo974h();
        }

        public String mo854d() {
            return this.f5092a.mo961i();
        }

        public List<? extends DvirInspection> mo855e() {
            return Collections.emptyList();
        }

        public boolean mo856f() {
            return false;
        }
    }

    public DvirHeaderEditActivity() {
        super(Feature.FINISH_ON_SIGN_OUT);
    }

    protected TextView mo930f() {
        return this.f5101i;
    }

    private Dvir m7477o() {
        return this.f5093a.m10971a(this.f5095c);
    }

    protected String mo974h() {
        return this.f5098f.getText().toString().trim();
    }

    protected String mo961i() {
        return this.f5097e.getText().toString().trim();
    }

    private void m7478p() {
        this.f5094b.m8374a(this.f5097e, 6);
        Dvir o = m7477o();
        if (o != null) {
            C2630a newBuilder = Dvir.newBuilder(o);
            String h = mo974h();
            if (am.m4188a((CharSequence) h)) {
                newBuilder.m13651m();
            } else {
                newBuilder.m13630a(h);
            }
            h = mo961i();
            if (am.m4188a((CharSequence) h)) {
                newBuilder.m13652n();
            } else {
                newBuilder.m13635b(h);
            }
            this.f5093a.m10983b(newBuilder.m13638c());
        }
        setResult(-1);
        finish();
    }

    private void m7479q() {
        this.f5093a.m10985b(this.f5095c);
        setResult(3);
        finish();
    }

    private void m7480r() {
        C2134e.m10680d("TT-DvirHdrEdit", "DVIR id=" + C1180y.m5989a(this.f5095c) + " doesn't exist: finishing");
        setResult(4);
        finish();
    }

    private void m7481s() {
        if (m7477o() == null) {
            m7480r();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5095c = com.bigroad.shared.ai.m4175a(getIntent().getByteArrayExtra("com.bigroad.ttb.dvirId"));
        if (this.f5095c == null) {
            C2134e.m10682e("TT-DvirHdrEdit", "No DVIR ID specified");
            finish();
            return;
        }
        Dvir o = m7477o();
        if (o == null) {
            m7480r();
            return;
        }
        this.f5096d = o.getLogDay();
        setTitle(getString(R.string.dvirEditHeader_title, new Object[]{C1738c.m8514c(this.f5096d)}));
        setContentView((int) R.layout.dvir_edit_header);
        this.f5097e = (InstantAutoComplete) findViewById(R.id.dvirHeader_carrier);
        this.f5098f = (InstantAutoComplete) findViewById(R.id.dvirHeader_inspector);
        this.f5097e.setAdapter(this.f5094b.m8372a((Context) this, 6));
        this.f5098f.setAdapter(this.f5094b.m8372a((Context) this, 7));
        this.f5099g = (Button) findViewById(R.id.dvirEditHeader_delete);
        this.f5099g.setOnClickListener(new C14772(this));
        this.f5100h = (Button) findViewById(R.id.dvirEditHeader_done);
        this.f5100h.setOnClickListener(new C14783(this));
        this.f5093a.m10974a(this.f5103k);
        m7481s();
        if (bundle == null) {
            ac.m11179a(this.f5097e, o.getCarrierName());
            ac.m11179a(this.f5098f, o.getInspectorName());
        }
        if (getIntent().getBooleanExtra("com.bigroad.ttb.isFixing", false)) {
            findViewById(R.id.dvirEditHeader_nextValidationText).setVisibility(0);
        }
        this.f5101i = this.f5097e;
        mo962j();
        mo963k();
    }

    public void onBackPressed() {
        setResult(0);
        finish();
    }

    public int a_() {
        return this.f5096d;
    }

    public void onDestroy() {
        this.f5093a.m10982b(this.f5103k);
        super.onDestroy();
    }

    public Dialog onCreateDialog(int i) {
        switch (i) {
            case 0:
                return new C0584a(this).m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.dvirEditHeader_deleteTitle).m2672b((int) R.string.dvirEditHeader_deleteMessage).m2661a((int) R.string.dvirEditHeader_delete, new C14794(this)).m2673b(17039360, C1843a.f6286a).m2677b();
            default:
                return super.onCreateDialog(i);
        }
    }

    protected void mo962j() {
        TextWatcher c2458h = new C2458h(m6701T(), new C14805(this));
        this.f5097e.addTextChangedListener(c2458h);
        this.f5098f.addTextChangedListener(c2458h);
        this.f5102j.m10486a();
        this.f5102j.m10488a(Field.CARRIER_NAME, R.id.dvirHeader_carrierError, R.id.dvirHeader_carrierErrorText);
        this.f5102j.m10488a(Field.INSPECTOR_NAME, R.id.dvirHeader_inspectorError, R.id.dvirHeader_inspectorErrorText);
    }

    protected void mo963k() {
        if (m7477o() != null) {
            Object c1481a = new C1481a();
            C1166f.m5932a(c1481a, new C2085a(), a_());
            this.f5102j.m10487a(c1481a.mo716A(), this);
        }
    }
}
