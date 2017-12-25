package com.bigroad.ttb.android.activity;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.bigroad.ttb.android.C2103j;
import com.bigroad.ttb.android.C2103j.C1337a;
import com.bigroad.ttb.android.C2230r;
import com.bigroad.ttb.android.C2230r.C1331a;
import com.bigroad.ttb.android.C2230r.C1332b;
import com.bigroad.ttb.android.C2315v;
import com.bigroad.ttb.android.C2315v.C1428a;
import com.bigroad.ttb.android.C2474y;
import com.bigroad.ttb.android.C2474y.C1182a;
import com.bigroad.ttb.android.C2474y.C1183b;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.TruckManager;
import com.bigroad.ttb.android.TruckManager.C1203b;
import com.bigroad.ttb.android.adapter.C1669f;
import com.bigroad.ttb.android.adapter.DailyLogListFilterAdapter;
import com.bigroad.ttb.android.adapter.DailyLogListFilterAdapter.DailyLogListFilter;
import com.bigroad.ttb.android.event.EventManager;
import com.bigroad.ttb.android.event.EventManager.C1199e;
import com.bigroad.ttb.android.event.EventManager.ChangeListener;
import com.bigroad.ttb.android.fragment.ViewMoreLogs;
import com.bigroad.ttb.android.p029c.C1736b;
import com.bigroad.ttb.android.p029c.C1736b.C1219a;
import com.bigroad.ttb.android.p029c.C1740e;
import com.bigroad.ttb.android.widget.OurLinearLayout;
import com.bigroad.ttb.android.widget.OurSpinner;
import com.bigroad.ttb.android.widget.OurSpinner.C1435a;
import com.bigroad.ttb.protocol.TTProtocol.Fleet;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import com.p017a.p018a.p019a.C0816a;

public class DailyLogListActivity extends OurActivity {
    private static final String f4854a = DailyLogListActivity.class.getName();
    private static final String f4855b = (f4854a + ".filter");
    private final TruckManager f4856c = OurApplication.m6294p();
    private final C2230r f4857d = OurApplication.m6292n();
    private final EventManager f4858e = OurApplication.m6295q();
    private final C2103j f4859f = OurApplication.ae();
    private final C1736b f4860g = OurApplication.m6296r();
    private final C2474y f4861h = OurApplication.m6285g();
    private final C2315v f4862i = OurApplication.m6298t();
    private OurSpinner f4863j;
    private ListView f4864k;
    private C0816a f4865l;
    private C1669f f4866m;
    private DailyLogListFilterAdapter f4867n;
    private View f4868o;
    private final ChangeListener f4869p = new C14261(this);
    private final C1428a f4870q = new C14293(this);
    private final C1219a f4871r = new C14304(this);
    private final C1337a f4872s = new C14315(this);
    private final C1331a f4873t = new C14326(this);
    private final TruckManager.ChangeListener f4874u = new C14337(this);
    private final C1182a f4875v = new C14348(this);

    class C14261 extends C1199e {
        final /* synthetic */ DailyLogListActivity f4845a;

        C14261(DailyLogListActivity dailyLogListActivity) {
            this.f4845a = dailyLogListActivity;
        }

        public void mo884a(EventManager eventManager, boolean z) {
            this.f4845a.m7296h();
        }

        public void mo882a() {
            this.f4845a.m7296h();
        }

        public void mo885b() {
            this.f4845a.m7296h();
        }
    }

    class C14272 implements OnClickListener {
        final /* synthetic */ DailyLogListActivity f4846a;

        C14272(DailyLogListActivity dailyLogListActivity) {
            this.f4846a = dailyLogListActivity;
        }

        public void onClick(View view) {
            C1632a.m7999j(this.f4846a);
        }
    }

    class C14293 implements C1428a {
        final /* synthetic */ DailyLogListActivity f4847a;

        C14293(DailyLogListActivity dailyLogListActivity) {
            this.f4847a = dailyLogListActivity;
        }

        public void mo994a(C2315v c2315v) {
            this.f4847a.m7296h();
        }
    }

    class C14304 implements C1219a {
        final /* synthetic */ DailyLogListActivity f4848a;

        C14304(DailyLogListActivity dailyLogListActivity) {
            this.f4848a = dailyLogListActivity;
        }

        public void mo904a(C1736b c1736b) {
            this.f4848a.m7296h();
        }
    }

    class C14315 implements C1337a {
        final /* synthetic */ DailyLogListActivity f4849a;

        C14315(DailyLogListActivity dailyLogListActivity) {
            this.f4849a = dailyLogListActivity;
        }

        public void mo956a(C2103j c2103j) {
            this.f4849a.m7296h();
            this.f4849a.m7297i();
        }
    }

    class C14326 extends C1332b {
        final /* synthetic */ DailyLogListActivity f4850a;

        C14326(DailyLogListActivity dailyLogListActivity) {
            this.f4850a = dailyLogListActivity;
        }

        public void mo954a(C2230r c2230r) {
            this.f4850a.m7296h();
            this.f4850a.m7297i();
        }
    }

    class C14337 extends C1203b {
        final /* synthetic */ DailyLogListActivity f4851a;

        C14337(DailyLogListActivity dailyLogListActivity) {
            this.f4851a = dailyLogListActivity;
        }

        public void mo894a(Truck truck) {
            this.f4851a.m7296h();
            this.f4851a.m7297i();
        }
    }

    class C14348 extends C1183b {
        final /* synthetic */ DailyLogListActivity f4852a;

        C14348(DailyLogListActivity dailyLogListActivity) {
            this.f4852a = dailyLogListActivity;
        }

        public void mo867d(C2474y c2474y) {
            this.f4852a.m7297i();
        }
    }

    class C14369 implements C1435a {
        final /* synthetic */ DailyLogListActivity f4853a;

        C14369(DailyLogListActivity dailyLogListActivity) {
            this.f4853a = dailyLogListActivity;
        }

        public void mo995a(int i) {
            DailyLogListFilter dailyLogListFilter = (DailyLogListFilter) this.f4853a.f4863j.getItemAtPosition(i);
            this.f4853a.f4866m.getFilter().filter(dailyLogListFilter.toString());
            this.f4853a.f4865l.m4030b(this.f4853a.f4868o, dailyLogListFilter == DailyLogListFilter.ALL);
        }
    }

    protected void onCreate(Bundle bundle) {
        DailyLogListFilter dailyLogListFilter;
        super.onCreate(bundle);
        setContentView((int) R.layout.daily_log_list);
        this.f4863j = (OurSpinner) findViewById(R.id.dailyLogList_filterSpinner);
        this.f4863j.setOnUserSelectedListener(new C14369(this));
        m7297i();
        this.f4865l = new C0816a();
        this.f4866m = new C1669f(this);
        this.f4865l.m4027a(this.f4866m);
        this.f4868o = m7294f();
        this.f4865l.m4026a(this.f4868o, true);
        this.f4864k = (ListView) findViewById(R.id.dailyLogList_listView);
        this.f4864k.setAdapter(this.f4865l);
        this.f4864k.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ DailyLogListActivity f4844a;

            {
                this.f4844a = r1;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                C1740e c1740e = (C1740e) this.f4844a.f4866m.getItem(i);
                if (c1740e != null) {
                    C1632a.m7945a(this.f4844a, c1740e.m8525a());
                }
            }
        });
        this.f4864k.setEmptyView(findViewById(R.id.dailyLogList_noLogsToDisplay));
        this.f4858e.m10012a(this.f4869p);
        this.f4862i.m11301a(this.f4870q);
        this.f4860g.m8474a(this.f4871r);
        this.f4859f.m10534a(this.f4872s);
        this.f4857d.m11009a(this.f4873t);
        this.f4856c.m6559a(this.f4874u);
        this.f4861h.m12184a(this.f4875v);
        if (bundle == null) {
            dailyLogListFilter = (DailyLogListFilter) getIntent().getSerializableExtra("com.bigroad.ttb.dailyLogListFilter");
        } else {
            dailyLogListFilter = (DailyLogListFilter) bundle.getSerializable(f4855b);
        }
        if (dailyLogListFilter == null) {
            dailyLogListFilter = DailyLogListFilter.ALL;
        }
        this.f4866m.getFilter().filter(dailyLogListFilter.toString());
        this.f4863j.setSelection(this.f4867n.m8043a(dailyLogListFilter));
        m7296h();
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable(f4855b, (DailyLogListFilter) this.f4863j.getSelectedItem());
    }

    protected void onDestroy() {
        this.f4858e.m10029b(this.f4869p);
        this.f4862i.m11303b(this.f4870q);
        this.f4860g.m8483b(this.f4871r);
        this.f4859f.m10539b(this.f4872s);
        this.f4857d.m11015b(this.f4873t);
        this.f4856c.m6568b(this.f4874u);
        this.f4861h.m12194b(this.f4875v);
        super.onDestroy();
    }

    private View m7294f() {
        View inflate = getLayoutInflater().inflate(R.layout.view_more_logs, null);
        OurLinearLayout ourLinearLayout = (OurLinearLayout) inflate.findViewById(R.id.viewMoreLogs_authenticatedGroup);
        TextView textView = (TextView) ourLinearLayout.findViewById(R.id.viewMoreLogs_link);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        OurLinearLayout ourLinearLayout2 = (OurLinearLayout) inflate.findViewById(R.id.viewMoreLogs_unauthenticatedGroup);
        ((Button) ourLinearLayout2.findViewById(R.id.viewMoreLogs_createAccountButton)).setOnClickListener(new C14272(this));
        if (this.f4861h.m12226p()) {
            ourLinearLayout2.setVisibility(8);
            ourLinearLayout.setVisibility(0);
            textView.setText(Html.fromHtml(ViewMoreLogs.m10427a(getResources())));
        } else {
            ourLinearLayout.setVisibility(8);
            ourLinearLayout2.setVisibility(0);
        }
        return inflate;
    }

    private void m7296h() {
        this.f4866m.m8189a(this.f4860g.m8492f());
    }

    private void m7297i() {
        boolean z = false;
        Truck f = this.f4856c.m6578f();
        Fleet b = this.f4857d.m11013b();
        boolean z2 = f != null && f.getHasAobrd();
        if (z2 && this.f4858e.m10064n()) {
            z2 = true;
        } else {
            z2 = false;
        }
        boolean v = this.f4861h.m12232v();
        boolean z3;
        if (b != null && b.hasRequireDriverCorrectionApproval() && b.getRequireDriverCorrectionApproval()) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (v || r3 || this.f4859f.m10536b() > 0) {
            z = true;
        }
        DailyLogListFilter dailyLogListFilter = (DailyLogListFilter) this.f4863j.getSelectedItem();
        this.f4867n = new DailyLogListFilterAdapter(this, z2, z);
        this.f4863j.setAdapter(this.f4867n);
        if (dailyLogListFilter != null) {
            this.f4863j.setSelection(this.f4867n.m8043a(dailyLogListFilter));
        }
    }
}
