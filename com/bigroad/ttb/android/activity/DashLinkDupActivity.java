package com.bigroad.ttb.android.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.bigroad.shared.am;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.OurActivity.Feature;
import com.google.common.p050a.C3462d;
import com.google.common.p051b.C3473a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DashLinkDupActivity extends OurActivity {
    private String f5002a;
    private String f5003b;
    private String f5004c;
    private TextView f5005d;
    private ListView f5006e;
    private Button f5007f;

    class C14591 implements OnItemClickListener {
        final /* synthetic */ DashLinkDupActivity f4997a;

        C14591(DashLinkDupActivity dashLinkDupActivity) {
            this.f4997a = dashLinkDupActivity;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i >= 0 && i < this.f4997a.f5006e.getCount()) {
                ((C1461a) this.f4997a.f5006e.getItemAtPosition(i)).mo1002a();
            }
        }
    }

    class C14602 implements OnClickListener {
        final /* synthetic */ DashLinkDupActivity f4998a;

        C14602(DashLinkDupActivity dashLinkDupActivity) {
            this.f4998a = dashLinkDupActivity;
        }

        public void onClick(View view) {
            this.f4998a.m7396f();
        }
    }

    private interface C1461a {
        void mo1002a();
    }

    private final class C1462b implements C1461a {
        final /* synthetic */ DashLinkDupActivity f4999a;

        private C1462b(DashLinkDupActivity dashLinkDupActivity) {
            this.f4999a = dashLinkDupActivity;
        }

        public String toString() {
            return this.f4999a.getString(R.string.dashLinkDupVin_useCurrent, new Object[]{this.f4999a.f5002a});
        }

        public void mo1002a() {
            Intent intent = new Intent();
            if (am.m4188a(this.f4999a.f5003b)) {
                intent.putExtra("com.bigroad.ttb.macAddress", this.f4999a.f5004c);
            } else {
                intent.putExtra("com.bigroad.ttb.vin", this.f4999a.f5003b);
            }
            this.f4999a.setResult(-1, intent);
            this.f4999a.finish();
        }
    }

    private final class C1463c implements C1461a {
        final /* synthetic */ DashLinkDupActivity f5000a;
        private final String f5001b;

        public C1463c(DashLinkDupActivity dashLinkDupActivity, String str) {
            this.f5000a = dashLinkDupActivity;
            this.f5001b = str;
        }

        public String toString() {
            return this.f5000a.getString(R.string.dashLinkDupVin_useInstead, new Object[]{this.f5001b});
        }

        public void mo1002a() {
            this.f5000a.setResult(5, new Intent().putExtra("com.bigroad.ttb.truckNumber", this.f5001b));
            this.f5000a.finish();
        }
    }

    public DashLinkDupActivity() {
        super(Feature.FINISH_ON_SIGN_OUT);
    }

    private void m7396f() {
        setResult(0);
        finish();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.dashlink_dup_vin);
        this.f5005d = (TextView) findViewById(R.id.dashLinkDupVin_heading);
        this.f5006e = (ListView) findViewById(R.id.dashLinkDupVin_options);
        this.f5007f = (Button) findViewById(R.id.dashLinkDupVin_cancel);
        Intent intent = getIntent();
        this.f5002a = intent.getStringExtra("com.bigroad.ttb.truckNumber");
        this.f5003b = intent.getStringExtra("com.bigroad.ttb.vin");
        this.f5004c = intent.getStringExtra("com.bigroad.ttb.macAddress");
        ArrayList stringArrayListExtra = intent.getStringArrayListExtra("com.bigroad.ttb.truckNumberList");
        Collections.sort(stringArrayListExtra);
        Resources resources = getResources();
        C3462d a = C3473a.m18314a();
        int i = am.m4188a(this.f5003b) ? R.plurals.dashLinkDupId_heading : R.plurals.dashLinkDupVin_heading;
        TextView textView = this.f5005d;
        int size = stringArrayListExtra.size();
        Object[] objArr = new Object[3];
        objArr[0] = a.mo2541a(this.f5002a);
        objArr[1] = a.mo2541a(am.m4188a(this.f5003b) ? this.f5004c : this.f5003b);
        objArr[2] = Integer.valueOf(stringArrayListExtra.size());
        textView.setText(Html.fromHtml(resources.getQuantityString(i, size, objArr)));
        List arrayList = new ArrayList();
        arrayList.add(new C1462b());
        Iterator it = stringArrayListExtra.iterator();
        while (it.hasNext()) {
            arrayList.add(new C1463c(this, (String) it.next()));
        }
        this.f5006e.setAdapter(new ArrayAdapter(this, 17367043, arrayList));
        this.f5006e.setOnItemClickListener(new C14591(this));
        this.f5007f.setOnClickListener(new C14602(this));
    }
}
