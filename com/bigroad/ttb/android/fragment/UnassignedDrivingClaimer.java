package com.bigroad.ttb.android.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.bigroad.shared.C1142r;
import com.bigroad.shared.C1142r.C1135c;
import com.bigroad.shared.C1144s;
import com.bigroad.shared.C1146u;
import com.bigroad.shared.EventStatusMaskBits;
import com.bigroad.shared.EventStatusMaskBits.RecordOrigin;
import com.bigroad.shared.EventStatusMaskBits.RecordStatus;
import com.bigroad.shared.aj;
import com.bigroad.shared.ap;
import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.shared.duty.C0890f;
import com.bigroad.shared.duty.C0890f.C0886a;
import com.bigroad.shared.duty.C0956v;
import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.shared.model.C1116d.C1114a;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.ClaimUnassignedDrivingActivity;
import com.bigroad.ttb.android.adapter.C1653a;
import com.bigroad.ttb.android.event.C2022a;
import com.bigroad.ttb.android.fragment.DailyLogFragment.C1295b;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.util.C2292l;
import com.bigroad.ttb.android.util.C2297q;
import com.bigroad.ttb.android.widget.C1643q;
import com.bigroad.ttb.android.widget.DailyLogHeaderView.MissingHeader;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.Event.C2647a;
import com.bigroad.ttb.protocol.TTProtocol.al;
import com.facebook.internal.NativeProtocol;
import com.google.protobuf.C3642c;
import com.p017a.p018a.p019a.C0816a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;

public class UnassignedDrivingClaimer extends DailyLogFragment {
    public static final String f7252a = UnassignedDrivingClaimer.class.getName();
    private static final String f7253u = (f7252a + ".lastLogDayKey");
    private static final String f7254v = (f7252a + ".claimableEvents");
    private int f7255A = Integer.MAX_VALUE;
    private List<Event> f7256B;
    private List<Event> f7257C;
    private List<C0890f> f7258D;
    private Map<C3642c, C2073a> f7259E;
    private Map<C3642c, SerialClaimableEvent> f7260F;
    private final Runnable f7261G = new C20681(this);
    private final C1135c f7262H = new C20692(this);
    private final ap f7263w = OurApplication.m6269Z();
    private C1653a f7264x;
    private Button f7265y;
    private Button f7266z;

    class C20681 implements Runnable {
        final /* synthetic */ UnassignedDrivingClaimer f7240a;

        C20681(UnassignedDrivingClaimer unassignedDrivingClaimer) {
            this.f7240a = unassignedDrivingClaimer;
        }

        public void run() {
            int y = this.f7240a.m10244y();
            if (y != -1) {
                this.f7240a.j.smoothScrollToPositionFromTop(y, this.f7240a.j.getHeight() / 3, 100);
            }
        }
    }

    class C20692 implements C1135c {
        final /* synthetic */ UnassignedDrivingClaimer f7241a;

        C20692(UnassignedDrivingClaimer unassignedDrivingClaimer) {
            this.f7241a = unassignedDrivingClaimer;
        }

        public boolean mo818a(Event event, List<byte[]> list) {
            if (!this.f7241a.f7259E.containsKey(event.getEventId())) {
                this.f7241a.f7257C.add(event);
            }
            return true;
        }

        public boolean mo817a(Event event) {
            ListIterator listIterator = this.f7241a.f7257C.listIterator();
            while (listIterator.hasNext()) {
                if (event.getEventId().equals(((Event) listIterator.next()).getEventId())) {
                    listIterator.set(event);
                    return true;
                }
            }
            return false;
        }

        public boolean mo819b(Event event) {
            ListIterator listIterator = this.f7241a.f7257C.listIterator();
            while (listIterator.hasNext()) {
                if (event.getEventId().equals(((Event) listIterator.next()).getEventId())) {
                    listIterator.remove();
                    return true;
                }
            }
            return false;
        }
    }

    class C20703 implements OnClickListener {
        final /* synthetic */ UnassignedDrivingClaimer f7242a;

        C20703(UnassignedDrivingClaimer unassignedDrivingClaimer) {
            this.f7242a = unassignedDrivingClaimer;
        }

        public void onClick(View view) {
            this.f7242a.m10406a(ClaimState.CLAIMED);
        }
    }

    class C20714 implements OnClickListener {
        final /* synthetic */ UnassignedDrivingClaimer f7243a;

        C20714(UnassignedDrivingClaimer unassignedDrivingClaimer) {
            this.f7243a = unassignedDrivingClaimer;
        }

        public void onClick(View view) {
            this.f7243a.m10406a(ClaimState.IGNORED);
        }
    }

    public enum ClaimState {
        CLAIMED,
        IGNORED,
        UNKNOWN
    }

    private static class SerialClaimableEvent implements Serializable {
        private static final long serialVersionUID = 209906758540670725L;
        ClaimState m_claimState;
        byte[] m_eventId;

        SerialClaimableEvent(C2073a c2073a) {
            this.m_eventId = c2073a.f7249a.mo719s();
            this.m_claimState = c2073a.f7250b;
        }
    }

    private class C2073a {
        final C0890f f7249a;
        ClaimState f7250b;
        final /* synthetic */ UnassignedDrivingClaimer f7251c;

        C2073a(UnassignedDrivingClaimer unassignedDrivingClaimer, C0890f c0890f, ClaimState claimState) {
            this.f7251c = unassignedDrivingClaimer;
            this.f7249a = c0890f;
            this.f7250b = claimState;
        }

        public SerialClaimableEvent m10399a() {
            return new SerialClaimableEvent(this);
        }
    }

    public static <T extends FragmentActivity & C1295b> UnassignedDrivingClaimer m10402a(T t) {
        UnassignedDrivingClaimer unassignedDrivingClaimer = (UnassignedDrivingClaimer) t.getSupportFragmentManager().mo149a(f7252a);
        if (unassignedDrivingClaimer == null) {
            return new UnassignedDrivingClaimer();
        }
        return unassignedDrivingClaimer;
    }

    public boolean m10414a(C0890f c0890f) {
        return this.b.m10032b(c0890f);
    }

    public boolean m10415b(C0890f c0890f) {
        C3642c eventId = c0890f.m4519n().getEventId();
        return this.f7259E.containsKey(eventId) && ((C2073a) this.f7259E.get(eventId)).f7250b == ClaimState.CLAIMED;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(R.layout.unassigned_driving_claimer, null);
        this.f7264x = new C1653a((ClaimUnassignedDrivingActivity) getActivity(), this);
        this.q.m4027a(this.f7264x);
        m10227a(inflate, this.f7264x);
        this.f7265y = (Button) inflate.findViewById(R.id.claimUnassignedDriving_claimAllButton);
        this.f7265y.setOnClickListener(new C20703(this));
        this.f7266z = (Button) inflate.findViewById(R.id.claimUnassignedDriving_ignoreAllButton);
        this.f7266z.setOnClickListener(new C20714(this));
        this.f7256B = new ArrayList();
        this.f7257C = new ArrayList();
        this.f7258D = new ArrayList();
        this.f7259E = new HashMap();
        m10405a(bundle);
        this.f7264x.notifyDataSetChanged();
        return inflate;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f7255A = this.s.mo946g();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(f7253u, this.f7255A);
        Serializable arrayList = new ArrayList(this.f7259E.size());
        for (C2073a a : this.f7259E.values()) {
            arrayList.add(a.m10399a());
        }
        bundle.putSerializable(f7254v, arrayList);
    }

    private void m10405a(Bundle bundle) {
        if (bundle != null) {
            C1643q c = this.f7264x.m7201c(bundle);
            if (c != null) {
                mo957a(c);
            }
            if (bundle.containsKey(f7253u)) {
                this.f7255A = bundle.getInt(f7253u);
            }
            if (bundle.containsKey(f7254v)) {
                ArrayList arrayList = (ArrayList) bundle.getSerializable(f7254v);
                if (arrayList != null) {
                    this.f7260F = new HashMap(arrayList.size());
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        SerialClaimableEvent serialClaimableEvent = (SerialClaimableEvent) it.next();
                        this.f7260F.put(C3642c.m19078a(serialClaimableEvent.m_eventId), serialClaimableEvent);
                    }
                    return;
                }
                return;
            }
            this.f7260F = null;
        }
    }

    public void mo1193a(DailyLog dailyLog, boolean z) {
        if (m10233b(dailyLog, z)) {
            C0956v c0956v = new C0956v((al) dailyLog);
            this.e.m11860a(dailyLog.getLogDay(), dailyLog, C1114a.m5598a(dailyLog, OurApplication.af(), this.f7263w.mo914b()).m5635a(), z, true, MissingHeader.SHOW);
            this.g.setHosSettings(c0956v);
            mo1207s();
            this.j.removeCallbacks(this.f7261G);
            C1643q c = this.f7264x.m8160c();
            if (c != null) {
                mo957a(c);
            } else {
                mo957a(this.f7264x.m7196a(0));
            }
        }
    }

    public void mo1207s() {
        mo1208t();
        mo1205h();
        mo1209u();
    }

    public void m10412a(C0890f c0890f, ClaimState claimState) {
        C3642c eventId = c0890f.m4519n().getEventId();
        if (this.f7259E.containsKey(eventId)) {
            if (claimState == ClaimState.CLAIMED && m10414a(c0890f)) {
                ((C2073a) this.f7259E.get(eventId)).f7250b = ClaimState.CLAIMED;
            } else if (claimState == ClaimState.IGNORED) {
                ((C2073a) this.f7259E.get(eventId)).f7250b = ClaimState.IGNORED;
            }
            m10404a();
            m10410c();
        }
    }

    private C1142r m10400a(C2073a c2073a, boolean z) {
        C1142r c1142r = null;
        if (c2073a.f7250b == ClaimState.CLAIMED && m10414a(c2073a.f7249a)) {
            Event n = c2073a.f7249a.m4519n();
            C2647a j = Event.newBuilder(n).m13846a(C3642c.m19078a(aj.m4179a())).m13843a(OurApplication.m6285g().m12202d()).m13886j(EventStatusMaskBits.m4071a(EventStatusMaskBits.m4072a(n.getStatusMask(), RecordStatus.ACTIVE), RecordOrigin.UNIDENTIFIED_DRIVER));
            if (n.hasSequenceId()) {
                j.m13864d((int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
            }
            try {
                c1142r = m10401a(this.b.m10009a(n.getOccurredAt() + n.getMinDuration()), j.m13862c(), z);
            } catch (Throwable e) {
                C2134e.m10681d("TT-DrivingClaimer", "Failed to create claim event changelist.", e);
            }
        }
        return c1142r;
    }

    private C1142r m10401a(List<Event> list, Event event, boolean z) {
        Object obj;
        long minDuration = event.getMinDuration() + event.getOccurredAt();
        C1142r c1142r = new C1142r();
        Event event2 = null;
        for (Event event3 : list) {
            if (event3.getOccurredAt() > minDuration) {
                obj = null;
                break;
            } else if (event3.getOccurredAt() == minDuration) {
                obj = 1;
                break;
            } else {
                if (event3.getOccurredAt() >= event.getOccurredAt()) {
                    if (event3.getImmutableDutySegment()) {
                        throw new IllegalArgumentException("Claimed event overlaps with an immutable event");
                    }
                    c1142r.m5751b(event3);
                }
                event2 = event3;
            }
        }
        obj = null;
        if (!z) {
            c1142r.m5747a(event, null);
        }
        if (obj == null) {
            DutyStatus dutyStatus;
            C2647a a;
            if (event2 == null) {
                dutyStatus = DutyStatus.OFF_DUTY;
            } else if (DutyStatus.m4384a(event2).m4397e()) {
                dutyStatus = DutyStatus.ON_DUTY_NOT_DRIVING;
            } else {
                dutyStatus = DutyStatus.m4384a(event2);
            }
            event2 = this.b.m10052f(minDuration);
            if (event2 != null) {
                a = Event.newBuilder(event2).m13846a(C3642c.m19078a(aj.m4179a())).m13843a(event.getPersonId()).m13842a(dutyStatus.m4394b());
                if (event.hasSequenceId()) {
                    a.m13864d((int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
                }
            } else {
                a = Event.newBuilder().m13846a(C3642c.m19078a(aj.m4179a())).m13843a(event.getPersonId()).m13842a(dutyStatus.m4394b()).m13859c(minDuration);
                if (event.hasTruckId()) {
                    C2022a.m10091a(a, Long.valueOf(event.getTruckId()), OurApplication.ac());
                }
            }
            c1142r.m5747a(a.m13862c(), null);
        }
        return c1142r;
    }

    private void m10404a() {
        List arrayList = new ArrayList();
        Iterable arrayList2 = new ArrayList();
        for (C2073a c2073a : this.f7259E.values()) {
            switch (c2073a.f7250b) {
                case CLAIMED:
                    C1142r a = m10400a(c2073a, false);
                    if (a == null) {
                        break;
                    }
                    arrayList.add(c2073a.f7249a.m4519n());
                    arrayList2.add(a);
                    break;
                case IGNORED:
                    this.b.m10053f(c2073a.f7249a.m4519n());
                    break;
                default:
                    break;
            }
        }
        if (!arrayList.isEmpty()) {
            Collections.sort(arrayList, C1144s.f3800a);
            this.b.m10018a(arrayList, arrayList2);
        }
    }

    public boolean m10416c(C0890f c0890f) {
        return this.b.m10041c(c0890f);
    }

    public ClaimState m10417d(C0890f c0890f) {
        C3642c eventId = c0890f.m4519n().getEventId();
        if (this.f7259E.containsKey(eventId)) {
            return ((C2073a) this.f7259E.get(eventId)).f7250b;
        }
        return ClaimState.UNKNOWN;
    }

    protected Runnable mo1204g() {
        return this.f7261G;
    }

    protected void mo1208t() {
        List<C0890f> a = this.b.m10010a(m10242w());
        this.f7256B = new ArrayList();
        for (C0890f n : a) {
            this.f7256B.add(n.m4519n());
        }
        List<C0890f> b = this.b.m10026b(m10242w().getLogDay());
        if (this.f7260F == null) {
            this.f7260F = new HashMap();
            for (Entry entry : this.f7259E.entrySet()) {
                this.f7260F.put(entry.getKey(), ((C2073a) entry.getValue()).m10399a());
            }
        }
        this.f7259E = new HashMap();
        for (C0890f n2 : b) {
            Event n3 = n2.m4519n();
            if (n3.getMinDuration() <= 0) {
                C2134e.m10680d("TT-DrivingClaimer", "Ignoring claimable event with minDuration 0: " + C2297q.m11245a(n3));
            } else {
                C3642c eventId = n3.getEventId();
                if (this.b.m10043d(eventId) == ClaimState.UNKNOWN) {
                    ClaimState claimState = ClaimState.UNKNOWN;
                    if (this.f7260F.containsKey(eventId)) {
                        claimState = ((SerialClaimableEvent) this.f7260F.get(eventId)).m_claimState;
                    }
                    this.f7259E.put(n3.getEventId(), new C2073a(this, n2, claimState));
                }
            }
        }
        this.f7260F = null;
        m10410c();
    }

    private List<C0890f> m10409b(List<Event> list) {
        DailyLog w = m10242w();
        return new C0886a(new C1146u(list), w.getLogDay(), DailyLogUtils.m4305b(w)).m4478a(C2292l.m11231a(w)).m4479a(this.f7263w.mo914b());
    }

    private void m10410c() {
        boolean z = true;
        this.f7257C = new ArrayList(this.f7256B);
        this.f7258D = new ArrayList(this.f7257C.size() + this.f7259E.size());
        for (C2073a c2073a : this.f7259E.values()) {
            if (c2073a.f7250b == ClaimState.CLAIMED) {
                this.f7257C.add(c2073a.f7249a.m4519n());
                C1142r a = m10400a(c2073a, true);
                if (a != null) {
                    a.m5750a(this.f7262H);
                }
            } else if (c2073a.f7250b != ClaimState.IGNORED) {
                this.f7258D.add(c2073a.f7249a);
            }
        }
        Collections.sort(this.f7257C, C1144s.f3800a);
        this.f7258D.addAll(m10409b(this.f7257C));
        Collections.sort(this.f7258D, C0890f.f2761a);
        int x = m10243x();
        List d = this.c.m11305d(x);
        List e = this.c.m11306e(x);
        this.f7264x.m7230a(this.f7258D, Collections.emptyList(), d, e, m10241v());
        this.q.m4028a(this.f7264x, !this.f7264x.isEmpty());
        m10245z();
        this.g.m11850a(this.f7258D, d, this);
        if (!e.isEmpty()) {
            this.h.setText(getResources().getQuantityString(R.plurals.dailyLog_canadianMalfunctionCount, e.size(), new Object[]{Integer.valueOf(e.size())}));
        }
        C0816a c0816a = this.q;
        View view = this.h;
        if (e.isEmpty()) {
            z = false;
        }
        c0816a.m4030b(view, z);
        m10411d();
        m10231a(this.f7258D);
        m10226A();
        this.f7264x.notifyDataSetChanged();
    }

    protected void mo1205h() {
        this.f7264x.notifyDataSetChanged();
    }

    protected void mo1206i() {
    }

    private void m10406a(ClaimState claimState) {
        for (C2073a c2073a : this.f7259E.values()) {
            if (c2073a.f7250b == ClaimState.UNKNOWN) {
                c2073a.f7250b = claimState;
            }
        }
        m10404a();
        m10410c();
    }

    private void m10411d() {
        int i = 0;
        int i2 = 0;
        for (C2073a c2073a : this.f7259E.values()) {
            int i3;
            if (c2073a.f7250b == ClaimState.UNKNOWN) {
                i3 = i;
                i = 1;
            } else {
                i3 = 1;
                i = i2;
            }
            i2 = i;
            i = i3;
        }
        if (i2 != 0) {
            this.f7265y.setVisibility(0);
            this.f7266z.setVisibility(0);
            if (i != 0) {
                this.f7265y.setText(R.string.claimUnassignedDriving_claimRemaining);
                this.f7266z.setText(R.string.claimUnassignedDriving_ignoreRemaining);
                return;
            }
            this.f7265y.setText(R.string.claimUnassignedDriving_claimAll);
            this.f7266z.setText(R.string.claimUnassignedDriving_ignoreAll);
            return;
        }
        this.f7265y.setVisibility(8);
        this.f7266z.setVisibility(8);
    }
}
