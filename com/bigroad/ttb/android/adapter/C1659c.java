package com.bigroad.ttb.android.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.C0126a;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bigroad.shared.C1130o;
import com.bigroad.shared.C1142r.C1137a;
import com.bigroad.shared.C1144s;
import com.bigroad.shared.ai;
import com.bigroad.shared.am;
import com.bigroad.shared.ap;
import com.bigroad.shared.aq;
import com.bigroad.shared.duty.C0890f;
import com.bigroad.shared.duty.C0890f.C0886a;
import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.shared.p022b.C0848a;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.CorrectionReviewActivity;
import com.bigroad.ttb.android.event.EventManager;
import com.bigroad.ttb.android.util.ac;
import com.bigroad.ttb.android.widget.C1643q;
import com.bigroad.ttb.protocol.TTProtocol.Delta;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.EventChangeListEntry;
import com.google.protobuf.C3642c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

public class C1659c extends C1652g {
    private final EventManager f5779a = OurApplication.m6295q();
    private final ap f5780d = OurApplication.m6269Z();
    private final CorrectionReviewActivity f5781e;
    private final TimeZone f5782f;
    private final Set<C3642c> f5783g;
    private final Set<C3642c> f5784h;
    private final Set<C3642c> f5785i;
    private int f5786j;
    private List<C0890f> f5787k;

    private class C1658a implements Comparator<C0890f> {
        final /* synthetic */ C1659c f5778a;

        private C1658a(C1659c c1659c) {
            this.f5778a = c1659c;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m8173a((C0890f) obj, (C0890f) obj2);
        }

        public int m8173a(C0890f c0890f, C0890f c0890f2) {
            Event n = c0890f.m4519n();
            Event n2 = c0890f2.m4519n();
            int signum = Long.signum(n.getOccurredAt() - n2.getOccurredAt());
            if (signum != 0) {
                return signum;
            }
            boolean contains = this.f5778a.f5785i.contains(n.getEventId());
            if (contains != this.f5778a.f5785i.contains(n2.getEventId())) {
                return contains ? -1 : 1;
            } else {
                return ai.f2620a.compare(n.getEventId(), n2.getEventId());
            }
        }
    }

    public C1659c(CorrectionReviewActivity correctionReviewActivity, TimeZone timeZone) {
        super(correctionReviewActivity);
        this.f5781e = correctionReviewActivity;
        this.f5782f = timeZone;
        this.f5783g = new HashSet();
        this.f5784h = new HashSet();
        this.f5785i = new HashSet();
        this.f5787k = Collections.emptyList();
    }

    public List<C0890f> m8182c() {
        return this.f5787k;
    }

    protected TimeZone mo989a() {
        return this.f5782f;
    }

    protected int mo1038d() {
        return R.plurals.corrections_eventRemoved;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        final C1643q a = m7196a(i);
        if (!a.m8095e()) {
            Context context = view2.getContext();
            Resources resources = context.getResources();
            Event g = a.m8097g();
            C3642c eventId = g.getEventId();
            boolean z = this.f5781e.mo930f() != null && this.f5781e.mo930f().mo1036a(a);
            boolean contains = this.f5783g.contains(eventId);
            boolean contains2 = this.f5784h.contains(eventId);
            boolean contains3 = this.f5785i.contains(eventId);
            boolean z2 = contains || contains2;
            TextView textView = (TextView) view2.findViewById(R.id.eventItem_time);
            m8176a(textView, context, z, z2);
            textView.setText(m7223a(context, a.m8103m()));
            m8174a(view2, context, R.id.eventItem_locationRow, R.id.eventItem_locationLabel, R.id.eventItem_location, z, z2);
            View a2 = m8174a(view2, context, R.id.eventItem_odometerRow, R.id.eventItem_odometerLabel, R.id.eventItem_odometer, z, z2);
            View a3 = m8174a(view2, context, R.id.eventItem_engineHoursRow, R.id.eventItem_engineHoursLabel, R.id.eventItem_engineHours, z, z2);
            m8174a(view2, context, R.id.eventItem_originRow, R.id.eventItem_originLabel, R.id.eventItem_origin, z, z2);
            if (a.m8100j()) {
                a2.setVisibility(0);
                a3.setVisibility(0);
            } else {
                a2.setVisibility(8);
                a3.setVisibility(8);
            }
            m8176a((TextView) view2.findViewById(R.id.eventItem_dutyStatus), context, z, z2);
            if (a.m8090a()) {
                C0890f b = a.m8092b();
                textView = (TextView) view2.findViewById(R.id.eventItem_duration);
                m8176a(textView, context, z, z2);
                textView.setText(ac.m11175a(aq.m4214a(b.m4515j()), resources));
            }
            textView = (TextView) view2.findViewById(R.id.eventItem_note);
            m8176a(textView, context, z, z2);
            textView.setMaxLines(Integer.MAX_VALUE);
            textView.setText(g.getNotes());
            if (am.m4188a(g.getNotes())) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
            }
            TextView textView2 = (TextView) view2.findViewById(R.id.eventItem_question);
            m8176a(textView2, context, z, z2);
            if (contains || contains2 || contains3) {
                textView2.setVisibility(0);
                textView2.setCompoundDrawablesWithIntrinsicBounds(C0126a.m582a(context, (int) R.drawable.ic_alert_carrier_small), null, null, null);
                if (contains) {
                    textView2.setText(resources.getString(R.string.corrections_eventAdded));
                } else if (contains2) {
                    textView2.setText(resources.getString(R.string.corrections_eventEdited));
                } else {
                    textView2.setText(resources.getString(R.string.corrections_eventDeleted));
                }
            } else {
                textView2.setVisibility(8);
            }
            if (z) {
                view2.setBackgroundResource(R.drawable.list_highlight);
                view2.setOnClickListener(null);
                textView.setMaxLines(Integer.MAX_VALUE);
            } else {
                if (z2) {
                    view2.setBackgroundResource(R.color.white);
                } else {
                    view2.setBackgroundResource(R.drawable.list_selector_background);
                }
                view2.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ C1659c f5776b;

                    public void onClick(View view) {
                        this.f5776b.f5781e.mo957a(a);
                    }
                });
            }
        }
        return view2;
    }

    private View m8174a(View view, Context context, int i, int i2, int i3, boolean z, boolean z2) {
        m8176a((TextView) view.findViewById(i2), context, z, z2);
        m8176a((TextView) view.findViewById(i3), context, z, z2);
        return view.findViewById(i);
    }

    private void m8176a(TextView textView, Context context, boolean z, boolean z2) {
        if (!z2 || z) {
            textView.setTextColor(C0126a.m584b(context, R.color.white));
        } else {
            textView.setTextColor(C0126a.m584b(context, R.color.black));
        }
    }

    public void m8181a(int i, Delta delta) {
        List emptyList;
        this.f5786j = i;
        if (delta == null || delta.getEventChangesCount() == 0) {
            emptyList = Collections.emptyList();
        } else {
            emptyList = delta.getEventChangesList();
        }
        for (EventChangeListEntry eventChangeListEntry : r0) {
            C3642c eventId = eventChangeListEntry.getEvent().getEventId();
            switch (eventChangeListEntry.getType()) {
                case CREATE_EVENT_CHANGE:
                    this.f5783g.add(eventId);
                    break;
                case UPDATE_EVENT_CHANGE:
                    break;
                case DELETE_EVENT_CHANGE:
                    this.f5785i.add(eventId);
                    continue;
                default:
                    continue;
            }
            this.f5784h.add(eventId);
        }
        emptyList = new ArrayList(this.f5779a.m10045d());
        List<C0890f> a = new C0886a(emptyList, this.f5786j, this.f5782f).m4478a(true).m4479a(this.f5780d.mo914b());
        if (delta == null) {
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            m8177a(a, arrayList, arrayList2);
            this.f5787k = m8179c(arrayList);
            m7230a(arrayList, arrayList2, Collections.emptyList(), Collections.emptyList(), true);
            notifyDataSetChanged();
            return;
        }
        C0848a.m4265b(delta).m5750a(new C1137a(emptyList));
        Collections.sort(emptyList, C1144s.f3800a);
        List<C0890f> a2 = new C0886a(emptyList, i, this.f5782f).m4478a(true).m4479a(this.f5780d.mo914b());
        arrayList = new ArrayList();
        arrayList2 = new ArrayList();
        m8177a(a2, arrayList, arrayList2);
        this.f5787k = m8179c(arrayList);
        for (C0890f c0890f : a) {
            if (this.f5785i.contains(c0890f.m4519n().getEventId())) {
                arrayList.add(c0890f);
            }
        }
        Collections.sort(arrayList, new C1658a());
        mo987a(m7199b(arrayList, arrayList2, Collections.emptyList(), Collections.emptyList(), true));
        m7238f();
        C16561 c16561 = null;
        for (C0890f c0890f2 : a2) {
            C3642c eventId2 = c0890f2.m4519n().getEventId();
            if (this.f5785i.contains(eventId2)) {
                C3642c c3642c;
                if (c16561 == null) {
                    c3642c = eventId2;
                } else {
                    Object obj = c16561;
                }
                m7228a(c3642c, eventId2);
                c16561 = c3642c;
            } else {
                c16561 = null;
            }
        }
        m7237e();
    }

    private List<C0890f> m8179c(List<C0890f> list) {
        List arrayList = new ArrayList();
        for (C0890f n : list) {
            arrayList.add(n.m4519n());
        }
        return new C0886a(arrayList, this.f5786j, this.f5782f).m4478a(true).m4479a(this.f5780d.mo914b());
    }

    private void m8177a(List<C0890f> list, List<C0890f> list2, List<Event> list3) {
        for (C0890f c0890f : list) {
            int eventType = c0890f.m4519n().getEventType();
            if (DutyStatus.m4387b(eventType)) {
                list2.add(c0890f);
            } else if (C1130o.m5710a(eventType)) {
                C3642c a = C3642c.m19078a(c0890f.mo719s());
                if (this.f5783g.contains(a) || this.f5784h.contains(a) || this.f5785i.contains(a)) {
                    list3.add(c0890f.m4519n());
                }
            }
        }
    }
}
