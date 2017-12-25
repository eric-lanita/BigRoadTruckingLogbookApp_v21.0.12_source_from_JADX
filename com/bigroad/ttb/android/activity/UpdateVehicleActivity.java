package com.bigroad.ttb.android.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.bigroad.shared.am;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.ai;
import com.bigroad.ttb.android.aj;
import com.bigroad.ttb.android.widget.InstantAutoComplete;

public class UpdateVehicleActivity extends OurActivity {
    private InstantAutoComplete f5603a;
    private InstantAutoComplete f5604b;
    private Button f5605c;
    private aj f5606d = OurApplication.ai();
    private final ai f5607e = OurApplication.m6256M();

    class C16181 implements OnClickListener {
        final /* synthetic */ UpdateVehicleActivity f5602a;

        C16181(UpdateVehicleActivity updateVehicleActivity) {
            this.f5602a = updateVehicleActivity;
        }

        public void onClick(View view) {
            this.f5602a.m7896f();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.update_vehicle);
        this.f5603a = (InstantAutoComplete) findViewById(R.id.updateVehicle_trailers);
        this.f5603a.setAdapter(this.f5607e.m8372a((Context) this, 4));
        this.f5603a.setText(OurApplication.ai().m8384a());
        this.f5604b = (InstantAutoComplete) findViewById(R.id.updateVehicle_shippingDocs);
        this.f5604b.setAdapter(this.f5607e.m8372a((Context) this, 12));
        this.f5604b.setText(OurApplication.ai().m8387b());
        this.f5605c = (Button) findViewById(R.id.updateVehicle_doneButton);
        this.f5605c.setOnClickListener(new C16181(this));
    }

    private void m7896f() {
        this.f5607e.m8374a(this.f5603a, 4);
        this.f5607e.m8374a(this.f5604b, 12);
        m7897h();
        finish();
    }

    private void m7897h() {
        String str = null;
        String trim = this.f5603a.getText().toString().trim();
        CharSequence trim2 = this.f5604b.getText().toString().trim();
        aj ajVar = this.f5606d;
        if (am.m4188a((CharSequence) trim)) {
            trim = null;
        }
        ajVar.m8386a(trim);
        aj ajVar2 = this.f5606d;
        if (!am.m4188a(trim2)) {
            CharSequence charSequence = trim2;
        }
        ajVar2.m8389b(str);
    }
}
