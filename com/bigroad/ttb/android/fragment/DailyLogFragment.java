package com.bigroad.ttb.android.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.bigroad.shared.ap;
import com.bigroad.shared.dailylog.C0866b;
import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.shared.dailylog.DailyLogUtils.C0860b;
import com.bigroad.shared.duty.C0890f;
import com.bigroad.shared.duty.C0956v;
import com.bigroad.shared.validation.ValidationError.Category;
import com.bigroad.ttb.android.C2315v;
import com.bigroad.ttb.android.C2315v.C1428a;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.adapter.EventListAdapter;
import com.bigroad.ttb.android.adapter.EventListAdapter.DisplayedRow;
import com.bigroad.ttb.android.event.EventManager;
import com.bigroad.ttb.android.event.EventManager.C1199e;
import com.bigroad.ttb.android.event.EventManager.ChangeListener;
import com.bigroad.ttb.android.p029c.C1738c;
import com.bigroad.ttb.android.util.C2292l;
import com.bigroad.ttb.android.util.ac;
import com.bigroad.ttb.android.widget.C1343n;
import com.bigroad.ttb.android.widget.C1643q;
import com.bigroad.ttb.android.widget.C2464m;
import com.bigroad.ttb.android.widget.DailyDriveTimeViolationsView;
import com.bigroad.ttb.android.widget.DailyLogGraphView;
import com.bigroad.ttb.android.widget.DailyLogGraphView.C2050b;
import com.bigroad.ttb.android.widget.DailyLogHeaderView;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import com.p017a.p018a.p019a.C0816a;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public abstract class DailyLogFragment extends Fragment implements C1343n {
    private final C1428a f7088a = new C20481(this);
    protected final EventManager f7089b = OurApplication.m6295q();
    protected final C2315v f7090c = OurApplication.m6298t();
    protected final ap f7091d = OurApplication.m6269Z();
    protected DailyLogHeaderView f7092e;
    protected DailyDriveTimeViolationsView f7093f;
    protected DailyLogGraphView f7094g;
    protected TextView f7095h;
    protected TextView f7096i;
    protected ListView f7097j;
    protected View f7098k;
    protected View f7099l;
    protected View f7100m;
    protected View f7101n;
    protected Button f7102o;
    protected C1643q f7103p;
    protected C0816a f7104q;
    protected C0816a f7105r;
    protected C1294a f7106s;
    protected List<Runnable> f7107t = new ArrayList();
    private final ChangeListener f7108u = new C20492(this);

    public interface C1294a {
        DailyLog mo930f();

        int mo946g();
    }

    public interface C1295b {
        void mo945a(Runnable runnable);
    }

    class C20481 implements C1428a {
        final /* synthetic */ DailyLogFragment f7142a;

        C20481(DailyLogFragment dailyLogFragment) {
            this.f7142a = dailyLogFragment;
        }

        public void mo994a(C2315v c2315v) {
            this.f7142a.mo1207s();
        }
    }

    class C20492 extends C1199e {
        final /* synthetic */ DailyLogFragment f7143a;

        C20492(DailyLogFragment dailyLogFragment) {
            this.f7143a = dailyLogFragment;
        }

        public void mo884a(EventManager eventManager, boolean z) {
            this.f7143a.mo1208t();
        }

        public void mo882a() {
            this.f7143a.mo1205h();
        }

        public void mo885b() {
            this.f7143a.mo1206i();
        }
    }

    public abstract void mo1193a(DailyLog dailyLog, boolean z);

    protected abstract Runnable mo1204g();

    protected abstract void mo1205h();

    protected abstract void mo1206i();

    public abstract void mo1207s();

    protected abstract void mo1208t();

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.f7098k = layoutInflater.inflate(R.layout.unassigned_driving_header, null);
        this.f7099l = layoutInflater.inflate(R.layout.carrier_edit_header, null);
        this.f7100m = layoutInflater.inflate(R.layout.daily_log_details_header, null);
        this.f7092e = (DailyLogHeaderView) this.f7100m.findViewById(R.id.dailyLogHeader_container);
        this.f7101n = layoutInflater.inflate(R.layout.toggle_collapse_button, null);
        this.f7102o = (Button) this.f7101n.findViewById(R.id.toggleCollapseButton);
        this.f7095h = (TextView) layoutInflater.inflate(R.layout.daily_log_small_text_view, null);
        this.f7096i = (TextView) layoutInflater.inflate(R.layout.daily_log_small_text_view, null);
        this.f7093f = (DailyDriveTimeViolationsView) layoutInflater.inflate(R.layout.daily_log_drive_time_violations, null);
        this.f7104q = new C0816a();
        this.f7105r = new C0816a();
        ac.m11177a(this.f7098k, this.f7104q);
        ac.m11177a(this.f7098k, this.f7105r);
        ac.m11177a(this.f7099l, this.f7104q);
        ac.m11177a(this.f7099l, this.f7105r);
        ac.m11177a(this.f7100m, this.f7105r);
        ac.m11177a(this.f7095h, this.f7104q);
        ac.m11177a(this.f7096i, this.f7104q);
        ac.m11177a(this.f7093f, this.f7104q);
        this.f7104q.m4025a(C2464m.m12116a(getActivity(), R.string.claimUnassignedDriving_eventListHeader));
        ac.m11177a(this.f7101n, this.f7104q);
        this.f7105r.m4030b(this.f7098k, false);
        this.f7105r.m4030b(this.f7099l, false);
        this.f7104q.m4030b(this.f7098k, false);
        this.f7104q.m4030b(this.f7099l, false);
        this.f7104q.m4030b(this.f7101n, false);
        return null;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f7106s = (C1294a) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement " + C1294a.class.getSimpleName() + " to use " + DailyLogFragment.class.getSimpleName() + ".");
        }
    }

    public void onStart() {
        super.onStart();
        this.f7089b.m10012a(this.f7108u);
        this.f7090c.m11301a(this.f7088a);
    }

    public void onResume() {
        super.onResume();
        for (Runnable a : this.f7107t) {
            ((C1295b) getActivity()).mo945a(a);
        }
        this.f7107t.clear();
    }

    public void onStop() {
        super.onStop();
        this.f7089b.m10029b(this.f7108u);
        this.f7090c.m11303b(this.f7088a);
    }

    public void onDetach() {
        this.f7106s = null;
        super.onDetach();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        C1643q f = mo930f();
        if (f != null) {
            f.mo1035a(bundle);
        }
    }

    public void mo957a(C1643q c1643q) {
        this.f7103p = c1643q;
        this.f7104q.notifyDataSetChanged();
        if (c1643q instanceof DisplayedRow) {
            mo1190a((DisplayedRow) c1643q);
        } else {
            mo1190a(null);
        }
        m10230a((Object) c1643q);
    }

    public C1643q mo930f() {
        return this.f7103p;
    }

    public TimeZone m10232b() {
        return DailyLogUtils.m4305b(m10242w());
    }

    public boolean m10241v() {
        return C2292l.m11231a(m10242w());
    }

    protected void m10227a(View view, final EventListAdapter eventListAdapter) {
        this.f7094g = (DailyLogGraphView) view.findViewById(R.id.daily_log_graph_view);
        this.f7094g.m11851a(true);
        this.f7094g.setOnSelectionListener(new C2050b(this) {
            final /* synthetic */ DailyLogFragment f7145b;

            public void mo1211a(long j) {
                this.f7145b.mo957a(eventListAdapter.m7197a(j));
            }

            public void mo1210a() {
                this.f7145b.mo957a(null);
            }
        });
        this.f7097j = (ListView) view.findViewById(R.id.event_list);
        this.f7097j.setAdapter(this.f7104q);
        this.f7097j.setItemsCanFocus(true);
        this.f7097j.setVerticalFadingEdgeEnabled(true);
    }

    protected DailyLog m10242w() {
        if (this.f7106s != null) {
            return this.f7106s.mo930f();
        }
        return C0866b.m4319a(OurApplication.m6260Q(), DailyLogUtils.m4285a(TimeZone.getDefault()));
    }

    protected void m10230a(Object obj) {
        if (obj != null) {
            this.f7097j.removeCallbacks(mo1204g());
            this.f7097j.postDelayed(mo1204g(), 50);
        }
    }

    protected int m10243x() {
        return m10242w().getLogDay();
    }

    protected int m10244y() {
        if (this.f7103p != null) {
            for (int i = 0; i < this.f7104q.getCount(); i++) {
                Object item = this.f7104q.getItem(i);
                if ((item instanceof C1643q) && this.f7103p.mo1036a((C1643q) item)) {
                    return i;
                }
            }
        }
        return -1;
    }

    protected void m10245z() {
        if (mo930f() != null && m10244y() == -1) {
            mo957a(null);
        }
    }

    protected void mo1209u() {
        this.f7092e.m11873g();
    }

    protected void m10231a(List<C0890f> list) {
        C0860b a = DailyLogUtils.m4292a(m10242w(), (List) list);
        if (a != null) {
            this.f7096i.setText(C1738c.m8506a(new C0956v(m10242w()), a, getActivity()));
            this.f7104q.m4030b(this.f7096i, true);
            return;
        }
        this.f7104q.m4030b(this.f7096i, false);
    }

    protected void m10226A() {
        com.bigroad.shared.validation.model.DailyLog c = this.f7090c.m11304c(m10243x());
        boolean z = false;
        if (c != null) {
            this.f7093f.setViolations(c.mo716A().m5960b(Category.DRIVE_TIME));
            z = this.f7093f.m11799a();
        }
        this.f7104q.m4030b(this.f7093f, z);
    }

    protected boolean m10233b(final DailyLog dailyLog, final boolean z) {
        if (isResumed()) {
            return true;
        }
        this.f7107t.add(new Runnable(this) {
            final /* synthetic */ DailyLogFragment f7148c;

            public void run() {
                this.f7148c.mo1193a(dailyLog, z);
            }
        });
        return false;
    }

    private void mo1190a(DisplayedRow displayedRow) {
        if (displayedRow != null) {
            Long l = null;
            if (displayedRow.m8090a()) {
                l = Long.valueOf(displayedRow.m8092b().m4522q());
            } else if (displayedRow.m8093c()) {
                l = Long.valueOf(displayedRow.m8094d().m8125c());
            }
            this.f7094g.setSelection(l);
            return;
        }
        this.f7094g.m11848a();
    }
}
