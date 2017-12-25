package com.bigroad.ttb.android.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.bigroad.shared.C0906x;
import com.bigroad.shared.C1130o;
import com.bigroad.shared.InspectionTerm;
import com.bigroad.shared.ac;
import com.bigroad.shared.ap;
import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.shared.duty.C0890f.C0886a;
import com.bigroad.shared.duty.C0956v;
import com.bigroad.shared.model.C1116d.C1114a;
import com.bigroad.ttb.android.C2226q;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.SignatureManager;
import com.bigroad.ttb.android.activity.DailyLogInspectInstructionActivity.CompleteInspectionDialogFragment;
import com.bigroad.ttb.android.activity.OurActivity.Feature;
import com.bigroad.ttb.android.adapter.C1402k;
import com.bigroad.ttb.android.adapter.C1404e;
import com.bigroad.ttb.android.adapter.EventListAdapter.DisplayedRow;
import com.bigroad.ttb.android.event.EventManager;
import com.bigroad.ttb.android.fragment.DailyLogNavigator;
import com.bigroad.ttb.android.fragment.DailyLogNavigator.C1296b;
import com.bigroad.ttb.android.p029c.C1738c;
import com.bigroad.ttb.android.util.C2292l;
import com.bigroad.ttb.android.widget.C2452b;
import com.bigroad.ttb.android.widget.C2464m;
import com.bigroad.ttb.android.widget.DailyLogGraphView;
import com.bigroad.ttb.android.widget.DailyLogHeaderView.MissingHeader;
import com.bigroad.ttb.android.widget.DailyLogInspectHeaderView;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import com.bigroad.ttb.protocol.TTProtocol.TruckLogType;
import com.bigroad.ttb.protocol.TTProtocol.al;
import com.p017a.p018a.p019a.C0816a;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class DailyLogInspectActivity extends OurActivity implements C0906x, C1296b {
    private static final String f4778a = (DailyLogInspectActivity.class.getName() + ".tab");
    private final EventManager f4779b = OurApplication.m6295q();
    private final C2226q f4780c = OurApplication.m6297s();
    private final ap f4781d = OurApplication.m6269Z();
    private View f4782e;
    private View f4783f;
    private View f4784g;
    private View f4785h;
    private DailyLogNavigator f4786i;
    private DailyLogInspectHeaderView f4787j;
    private TextView f4788k;
    private DailyLogGraphView f4789l;
    private View f4790m;
    private View f4791n;
    private ListView f4792o;
    private View f4793p;
    private TextView f4794q;
    private ImageView f4795r;
    private C0816a f4796s;
    private C0816a f4797t;
    private C1404e f4798u;
    private C1402k f4799v;
    private C2452b f4800w;
    private boolean f4801x;
    private InspectionTerm f4802y;
    private Tab f4803z;

    class C13991 implements OnClickListener {
        final /* synthetic */ DailyLogInspectActivity f4753a;

        C13991(DailyLogInspectActivity dailyLogInspectActivity) {
            this.f4753a = dailyLogInspectActivity;
        }

        public void onClick(View view) {
            this.f4753a.m7247a(Tab.LOG);
        }
    }

    class C14002 implements OnClickListener {
        final /* synthetic */ DailyLogInspectActivity f4754a;

        C14002(DailyLogInspectActivity dailyLogInspectActivity) {
            this.f4754a = dailyLogInspectActivity;
        }

        public void onClick(View view) {
            this.f4754a.m7247a(Tab.HEADER);
        }
    }

    class C14013 implements OnClickListener {
        final /* synthetic */ DailyLogInspectActivity f4755a;

        C14013(DailyLogInspectActivity dailyLogInspectActivity) {
            this.f4755a = dailyLogInspectActivity;
        }

        public void onClick(View view) {
            CompleteInspectionDialogFragment.m7265a(this.f4755a);
        }
    }

    private enum Tab {
        LOG,
        HEADER
    }

    private class C1403a extends C1402k {
        final /* synthetic */ DailyLogInspectActivity f4765a;

        public C1403a(DailyLogInspectActivity dailyLogInspectActivity) {
            this.f4765a = dailyLogInspectActivity;
            super(dailyLogInspectActivity, true, null);
        }

        protected TimeZone mo985a() {
            return TimeZone.getTimeZone(this.f4765a.m7249h().getTimezoneId());
        }

        public boolean mo986b() {
            return false;
        }
    }

    private class C1405b extends C1404e {
        final /* synthetic */ DailyLogInspectActivity f4777a;

        public C1405b(DailyLogInspectActivity dailyLogInspectActivity) {
            this.f4777a = dailyLogInspectActivity;
            super(dailyLogInspectActivity);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View view2 = super.getView(i, view, viewGroup);
            DisplayedRow a = m7196a(i);
            if (!a.m8095e()) {
                view2.findViewById(R.id.eventItem_editButton).setVisibility(8);
                if (a.m8093c()) {
                    view2.setBackgroundResource(R.color.lighter_gray);
                } else {
                    view2.setBackgroundResource(R.drawable.list_selector_background);
                }
            }
            return view2;
        }

        protected TimeZone mo989a() {
            return TimeZone.getTimeZone(this.f4777a.m7249h().getTimezoneId());
        }

        protected boolean mo990b() {
            return true;
        }
    }

    private DailyLog m7249h() {
        return this.f4786i.m10347a();
    }

    public TimeZone mo930f() {
        return DailyLogUtils.m4305b(m7249h());
    }

    public int a_() {
        return this.f4786i.m10348b();
    }

    public DailyLogInspectActivity() {
        super(Feature.FINISH_ON_SIGN_OUT);
    }

    protected void onStart() {
        OurApplication.m6300v().m10901a(false);
        super.onStart();
    }

    public Locale d_() {
        return ac.f2617a;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.daily_log_inspect);
        m6692K().setStatusMessageVisible(false);
        if (bundle == null || !bundle.containsKey(f4778a)) {
            this.f4803z = Tab.LOG;
        } else {
            this.f4803z = (Tab) bundle.getSerializable(f4778a);
        }
        this.f4782e = findViewById(R.id.headerTabs_logTab);
        this.f4783f = this.f4782e.findViewById(R.id.headerTabs_logSelected);
        this.f4784g = findViewById(R.id.headerTabs_headerTab);
        this.f4785h = this.f4784g.findViewById(R.id.headerTabs_headerSelected);
        this.f4785h.setVisibility(8);
        this.f4782e.setOnClickListener(new C13991(this));
        this.f4784g.setOnClickListener(new C14002(this));
        TruckLogType a = TruckLogType.m15634a(getIntent().getIntExtra("com.bigroad.ttb.truckLogType", 0));
        boolean z = a == TruckLogType.UNKNOWN_LOG_TYPE || a == TruckLogType.ELECTRONIC;
        this.f4801x = z;
        int intExtra = getIntent().getIntExtra("com.bigroad.ttb.inspectionTerm", -1);
        InspectionTerm inspectionTerm = (intExtra < 0 || intExtra >= InspectionTerm.values().length) ? InspectionTerm.SEVEN_DAYS : InspectionTerm.values()[intExtra];
        this.f4802y = inspectionTerm;
        this.f4786i = DailyLogNavigator.m10336a(getSupportFragmentManager(), true, false, getIntent().getIntExtra("com.bigroad.ttb.logDay", -1), this.f4802y);
        this.f4791n = getLayoutInflater().inflate(R.layout.daily_log_inspect_header, null);
        this.f4790m = getLayoutInflater().inflate(R.layout.daily_log_inspect_log, null);
        this.f4787j = (DailyLogInspectHeaderView) this.f4791n.findViewById(R.id.dailyLog_header);
        this.f4787j.setInspectAsLogType(a);
        this.f4789l = (DailyLogGraphView) this.f4790m.findViewById(R.id.daily_log_graph_view);
        this.f4789l.setInspection(true);
        this.f4792o = (ListView) findViewById(R.id.dailyLog_list);
        this.f4788k = (TextView) LayoutInflater.from(this).inflate(R.layout.daily_log_small_text_view, null);
        this.f4797t = new C0816a();
        com.bigroad.ttb.android.util.ac.m11177a(this.f4790m, this.f4797t);
        com.bigroad.ttb.android.util.ac.m11177a(this.f4788k, this.f4797t);
        this.f4798u = new C1405b(this);
        this.f4797t.m4027a(this.f4798u);
        this.f4793p = getLayoutInflater().inflate(R.layout.daily_log_approved_footer, null);
        this.f4794q = (TextView) this.f4793p.findViewById(R.id.dailyLogApprovedFooter_approvalIndicator);
        this.f4795r = (ImageView) this.f4793p.findViewById(R.id.dailyLogApprovedFooter_signatureImageView);
        com.bigroad.ttb.android.util.ac.m11177a(this.f4793p, this.f4797t);
        this.f4797t.m4030b(this.f4793p, false);
        this.f4797t.m4025a(C2464m.m12116a(this, R.string.certificationList_title));
        this.f4800w = new C2452b(this);
        com.bigroad.ttb.android.util.ac.m11177a(this.f4800w, this.f4797t);
        this.f4799v = new C1403a(this);
        this.f4797t.m4027a(this.f4799v);
        this.f4789l.setHosSettings(m7250i());
        this.f4792o.setVerticalFadingEdgeEnabled(true);
        this.f4796s = new C0816a();
        com.bigroad.ttb.android.util.ac.m11177a(this.f4791n, this.f4796s);
        m7247a(this.f4803z);
        if (bundle != null) {
            this.f4798u.m7232b(bundle);
        }
        ((Button) findViewById(R.id.dailyLogEndInspectionButton_endInspection)).setOnClickListener(new C14013(this));
    }

    private void m7247a(Tab tab) {
        int i;
        boolean z = true;
        int i2 = 0;
        boolean z2 = tab == Tab.HEADER;
        View view = this.f4782e;
        if (z2) {
            z = false;
        }
        view.setSelected(z);
        view = this.f4783f;
        if (z2) {
            i = 8;
        } else {
            i = 0;
        }
        view.setVisibility(i);
        this.f4784g.setSelected(z2);
        View view2 = this.f4785h;
        if (!z2) {
            i2 = 8;
        }
        view2.setVisibility(i2);
        this.f4792o.setAdapter(z2 ? this.f4796s : this.f4797t);
        this.f4803z = tab;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable(f4778a, this.f4803z);
        this.f4798u.m7225a(bundle);
    }

    public void mo944a(DailyLog dailyLog, boolean z) {
        int i;
        boolean z2 = false;
        C0956v c0956v = new C0956v((al) dailyLog);
        this.f4787j.m11860a(dailyLog.getLogDay(), dailyLog, C1114a.m5598a(dailyLog, OurApplication.af(), this.f4781d.mo914b()).m5635a(), z, false, MissingHeader.HIDE);
        boolean a = C2292l.m11231a(dailyLog);
        Iterable a2 = new C0886a(this.f4779b.m10061k(), a_(), mo930f()).m4478a(a).m4479a(this.f4781d.mo914b());
        this.f4798u.m7230a(DailyLogUtils.m4299a((List) a2), C1130o.m5709a(this.f4779b.m10025b(), a_(), mo930f()), Collections.emptyList(), Collections.emptyList(), true);
        this.f4789l.setEventData(a2);
        this.f4799v.m7189a(this.f4780c.m10973a(a_()), true, false);
        this.f4800w.m12083a(mo930f(), this.f4798u.m7202l(), this.f4779b.m10007a(a_()));
        Bitmap b = SignatureManager.m6336b(dailyLog.getSignatureId());
        if (a) {
            CharSequence string;
            if (!dailyLog.hasSignatureId() || b == null) {
                this.f4795r.setVisibility(8);
            } else {
                this.f4795r.setImageBitmap(b);
                this.f4795r.setVisibility(0);
            }
            if (C1738c.m8512a(a2)) {
                string = getString(R.string.dailyLogApprove_eldMessage, new Object[]{OurApplication.m6285g().m12223m()});
            } else if (C1738c.m8511a(dailyLog, a2)) {
                string = getString(R.string.dailyLogApprove_aobrdMessage, new Object[]{OurApplication.m6285g().m12223m()});
            } else {
                string = getString(R.string.dailyLogApprove_message, new Object[]{OurApplication.m6285g().m12223m()});
            }
            this.f4794q.setText(string);
            TextView textView = this.f4794q;
            if (dailyLog.hasSignatureId()) {
                i = 0;
            } else {
                i = m6714c(5);
            }
            textView.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
            a = true;
        } else {
            a = false;
        }
        this.f4797t.m4030b(this.f4793p, a);
        this.f4789l.setHosSettings(c0956v);
        if (this.f4802y == InspectionTerm.FOURTEEN_DAYS) {
            i = OurApplication.m6298t().m11306e(dailyLog.getLogDay()).size();
            if (i > 0) {
                this.f4788k.setText(getResources().getQuantityString(R.plurals.dailyLog_canadianMalfunctionCount, i, new Object[]{Integer.valueOf(i)}));
                z2 = true;
            }
        }
        this.f4797t.m4030b(this.f4788k, z2);
    }

    public void onBackPressed() {
        if (this.f4801x) {
            CompleteInspectionDialogFragment.m7265a(this);
        } else {
            super.onBackPressed();
        }
    }

    private C0956v m7250i() {
        al h = m7249h();
        return h == null ? m6699R().m12228r() : new C0956v(h);
    }
}
