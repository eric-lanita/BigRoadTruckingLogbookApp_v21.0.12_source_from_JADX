package com.bigroad.ttb.android.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.bigroad.shared.C0906x;
import com.bigroad.shared.am;
import com.bigroad.shared.duty.C0956v;
import com.bigroad.shared.p022b.C0848a;
import com.bigroad.ttb.android.C2103j;
import com.bigroad.ttb.android.C2103j.C1337a;
import com.bigroad.ttb.android.C2472x;
import com.bigroad.ttb.android.C2472x.C1306a;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.SyncManager;
import com.bigroad.ttb.android.activity.OurActivity.Feature;
import com.bigroad.ttb.android.adapter.C1659c;
import com.bigroad.ttb.android.adapter.EventListAdapter.DisplayedRow;
import com.bigroad.ttb.android.fragment.DailyLogNavigator;
import com.bigroad.ttb.android.fragment.DailyLogNavigator.C1296b;
import com.bigroad.ttb.android.util.C2303v;
import com.bigroad.ttb.android.util.ac;
import com.bigroad.ttb.android.widget.C1343n;
import com.bigroad.ttb.android.widget.C1643q;
import com.bigroad.ttb.android.widget.C2454d;
import com.bigroad.ttb.android.widget.C2464m;
import com.bigroad.ttb.android.widget.DailyLogGraphView;
import com.bigroad.ttb.protocol.TTProtocol.Correction;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import com.bigroad.ttb.protocol.TTProtocol.Delta;
import com.bigroad.ttb.protocol.TTProtocol.Person;
import com.p017a.p018a.p019a.C0816a;
import java.util.EnumSet;
import java.util.List;

public class CorrectionReviewActivity extends OurActivity implements C0906x, C1296b, C1343n {
    protected C1643q f4532a;
    private final C1337a f4533b = new C13381(this);
    private final C1306a f4534c = new C13392(this);
    private final Runnable f4535d = new C13403(this);
    private final C2103j f4536e = OurApplication.ae();
    private final C2472x f4537f = OurApplication.m6293o();
    private final SyncManager f4538g = OurApplication.m6289k();
    private DailyLogNavigator f4539h;
    private DailyLogGraphView f4540i;
    private C0816a f4541j;
    private ListView f4542k;
    private View f4543l;
    private C2454d f4544m;
    private View f4545n;
    private C1659c f4546o;
    private View f4547p;
    private TextView f4548q;
    private Button f4549r;
    private Button f4550s;
    private int f4551t;
    private Correction f4552u;
    private Delta f4553v;

    class C13381 implements C1337a {
        final /* synthetic */ CorrectionReviewActivity f4527a;

        C13381(CorrectionReviewActivity correctionReviewActivity) {
            this.f4527a = correctionReviewActivity;
        }

        public void mo956a(C2103j c2103j) {
            this.f4527a.m6896h();
        }
    }

    class C13392 implements C1306a {
        final /* synthetic */ CorrectionReviewActivity f4528a;

        C13392(CorrectionReviewActivity correctionReviewActivity) {
            this.f4528a = correctionReviewActivity;
        }

        public void mo948a(C2472x c2472x, List<Person> list) {
            this.f4528a.m6896h();
        }
    }

    class C13403 implements Runnable {
        final /* synthetic */ CorrectionReviewActivity f4529a;

        C13403(CorrectionReviewActivity correctionReviewActivity) {
            this.f4529a = correctionReviewActivity;
        }

        public void run() {
            int g = this.f4529a.m6902g();
            if (g != -1) {
                this.f4529a.f4542k.smoothScrollToPositionFromTop(g, this.f4529a.f4542k.getHeight() / 3, 100);
            }
        }
    }

    class C13414 implements OnClickListener {
        final /* synthetic */ CorrectionReviewActivity f4530a;

        C13414(CorrectionReviewActivity correctionReviewActivity) {
            this.f4530a = correctionReviewActivity;
        }

        public void onClick(View view) {
            this.f4530a.f4536e.m10538b(this.f4530a.f4552u.getId());
            this.f4530a.finish();
        }
    }

    class C13425 implements OnClickListener {
        final /* synthetic */ CorrectionReviewActivity f4531a;

        C13425(CorrectionReviewActivity correctionReviewActivity) {
            this.f4531a = correctionReviewActivity;
        }

        public void onClick(View view) {
            C1632a.m7988e(this.f4531a, this.f4531a.f4551t);
        }
    }

    public CorrectionReviewActivity() {
        super(EnumSet.of(Feature.FINISH_ON_SIGN_OUT, Feature.ALLOW_TRIAL_USER_CONVERSION));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4551t = getIntent().getIntExtra("com.bigroad.ttb.logDay", -1);
        this.f4552u = this.f4536e.m10530a(this.f4551t);
        if (this.f4552u != null) {
            this.f4553v = C0848a.m4260a(this.f4552u.getDelta());
        }
        if (this.f4553v == null) {
            finish();
            return;
        }
        setContentView((int) R.layout.correction_review);
        this.f4539h = DailyLogNavigator.m10337a(getSupportFragmentManager(), false, false, true, this.f4551t);
        this.f4540i = (DailyLogGraphView) findViewById(R.id.correctionReview_dailyLogGraph);
        this.f4540i.setHosSettings(m6897i());
        this.f4541j = new C0816a();
        this.f4543l = C2464m.m12116a(this, R.string.corrections_headerTitle);
        this.f4541j.m4025a(this.f4543l);
        this.f4542k = (ListView) findViewById(R.id.correctionReview_displayList);
        this.f4542k.setVerticalFadingEdgeEnabled(true);
        this.f4544m = new C2454d(this);
        ac.m11177a(this.f4544m, this.f4541j);
        this.f4545n = C2464m.m12116a(this, R.string.corrections_logsTitle);
        this.f4541j.m4025a(this.f4545n);
        this.f4546o = new C1659c(this, m6897i().m4868b());
        this.f4546o.m7227a((C1343n) this);
        this.f4541j.m4027a(this.f4546o);
        this.f4547p = C2464m.m12116a(this, R.string.corrections_suggestionCommentTitle);
        this.f4541j.m4025a(this.f4547p);
        this.f4548q = (TextView) getLayoutInflater().inflate(R.layout.correction_review_suggestion_comment, null);
        this.f4541j.m4025a(this.f4548q);
        this.f4549r = (Button) findViewById(R.id.correctionReview_acceptButton);
        this.f4549r.setOnClickListener(new C13414(this));
        this.f4550s = (Button) findViewById(R.id.correctionReview_rejectButton);
        this.f4550s.setOnClickListener(new C13425(this));
        this.f4542k.setAdapter(this.f4541j);
        this.f4536e.m10534a(this.f4533b);
        this.f4537f.m12140a(this.f4534c);
        m6896h();
        this.f4538g.m6502g();
        if (bundle != null) {
            this.f4532a = this.f4546o.m7201c(bundle);
            this.f4546o.m7232b(bundle);
        }
    }

    protected void onDestroy() {
        this.f4536e.m10539b(this.f4533b);
        this.f4537f.m12142b(this.f4534c);
        super.onDestroy();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f4532a != null) {
            this.f4532a.mo1035a(bundle);
        }
        this.f4546o.m7225a(bundle);
    }

    private void m6896h() {
        if (this.f4552u == null || this.f4553v == null || this.f4536e.m10531a(this.f4552u.getId()) == null) {
            finish();
            return;
        }
        if (this.f4544m.m12090a(this.f4553v)) {
            this.f4541j.m4030b(this.f4543l, true);
            this.f4541j.m4030b(this.f4544m, true);
        } else {
            this.f4541j.m4030b(this.f4543l, false);
            this.f4541j.m4030b(this.f4544m, false);
        }
        this.f4546o.m8181a(this.f4551t, this.f4553v);
        List list = null;
        if (this.f4553v != null && this.f4553v.getEventChangesCount() > 0) {
            list = this.f4553v.getEventChangesList();
        }
        this.f4540i.m11852b(this.f4546o.m8182c(), list);
        C2303v c = C2303v.m11258c();
        if (this.f4552u == null || am.m4188a(this.f4552u.getSuggestionComment())) {
            c.m11267b(getResources().getString(R.string.none));
        } else {
            c.m11268c(this.f4552u.getSuggestionComment());
        }
        this.f4548q.setText(c.m11270e());
    }

    public void mo944a(DailyLog dailyLog, boolean z) {
        this.f4551t = dailyLog.getLogDay();
        this.f4552u = this.f4536e.m10530a(this.f4551t);
        if (this.f4552u == null) {
            finish();
        }
        m6896h();
    }

    private C0956v m6897i() {
        if (this.f4553v.getDailyLogChangesCount() == 0) {
            return m6699R().m12228r();
        }
        return new C0956v(this.f4553v.getDailyLogChanges(0).getBeforeChange());
    }

    public int a_() {
        return this.f4551t;
    }

    public void mo957a(C1643q c1643q) {
        this.f4532a = c1643q;
        this.f4541j.notifyDataSetChanged();
        if (c1643q instanceof DisplayedRow) {
            m6891a((DisplayedRow) c1643q);
        } else {
            m6891a(null);
        }
        m6900a((Object) c1643q);
    }

    public C1643q mo930f() {
        return this.f4532a;
    }

    protected int m6902g() {
        if (this.f4532a != null) {
            for (int i = 0; i < this.f4541j.getCount(); i++) {
                Object item = this.f4541j.getItem(i);
                if ((item instanceof C1643q) && this.f4532a.mo1036a((C1643q) item)) {
                    return i;
                }
            }
        }
        return -1;
    }

    private void m6891a(DisplayedRow displayedRow) {
        Long l = null;
        if (displayedRow != null && displayedRow.m8090a()) {
            l = Long.valueOf(displayedRow.m8092b().m4522q());
        } else if (displayedRow != null && displayedRow.m8093c()) {
            l = Long.valueOf(displayedRow.m8094d().m8125c());
        }
        if (l != null) {
            this.f4540i.setSelection(l);
        } else {
            this.f4540i.m11848a();
        }
    }

    protected void m6900a(Object obj) {
        if (obj != null) {
            this.f4542k.removeCallbacks(this.f4535d);
            this.f4542k.postDelayed(this.f4535d, 50);
        }
    }
}
