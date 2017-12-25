package com.bigroad.ttb.android.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.constraint.C0025b;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bigroad.shared.EldDrivingModeBits;
import com.bigroad.shared.EldDrivingModeBits.Mode;
import com.bigroad.shared.aa;
import com.bigroad.shared.af;
import com.bigroad.shared.am;
import com.bigroad.shared.duty.C0890f;
import com.bigroad.shared.validation.C1168m;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.adapter.EventListAdapter.C1646c;
import com.bigroad.ttb.android.adapter.EventListAdapter.DisplayedRow;
import com.bigroad.ttb.android.p029c.C1738c;
import com.bigroad.ttb.android.util.C2289i;
import com.bigroad.ttb.android.util.C2303v;
import com.bigroad.ttb.android.util.ac;
import com.bigroad.ttb.android.widget.C1343n;
import com.bigroad.ttb.android.widget.C1643q;
import com.bigroad.ttb.android.widget.TruckInfoView;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.OdometerUnit;
import com.google.protobuf.C3642c;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

public abstract class C1404e extends EventListAdapter {
    private static final String f4770a = (C1404e.class.getName() + ".expandedGroups");
    protected final LayoutInflater f4771b;
    protected final C2303v f4772c = C2303v.m11258c();
    private final Map<C3642c, List<C3642c>> f4773d = new HashMap();
    private final Set<C3642c> f4774e = new HashSet();
    private List<DisplayedRow> f4775f = Collections.emptyList();
    private C1343n f4776g;

    protected abstract TimeZone mo989a();

    public C1404e(Context context) {
        this.f4771b = LayoutInflater.from(context);
    }

    protected int mo1038d() {
        return R.plurals.dailyLogList_expandableHeaderPrompt;
    }

    protected boolean mo990b() {
        return false;
    }

    protected boolean mo1037a(C0890f c0890f) {
        return true;
    }

    public void m7227a(C1343n c1343n) {
        this.f4776g = c1343n;
    }

    public final int getItemViewType(int i) {
        DisplayedRow a = m7196a(i);
        if (a.m8095e()) {
            return 2;
        }
        return this.f4773d.containsKey(a.m8108r()) ? 1 : 0;
    }

    public final int getViewTypeCount() {
        return 3;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate;
        DisplayedRow a;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            if (itemViewType == 2) {
                inflate = this.f4771b.inflate(R.layout.truck_event_list_item, viewGroup, false);
            } else {
                view = this.f4771b.inflate(R.layout.duty_status_event_item, viewGroup, false);
                if (itemViewType == 1) {
                    ViewGroup viewGroup2 = (ViewGroup) this.f4771b.inflate(R.layout.expanding_event_list_item, viewGroup, false);
                    viewGroup2.addView(view);
                }
            }
            a = m7196a(i);
            if (itemViewType == 1) {
                m7206a(inflate, a.m8108r());
            }
            if (itemViewType != 2) {
                m7205a(inflate, a);
            } else {
                m7209a(a, inflate);
            }
            return inflate;
        }
        inflate = view;
        a = m7196a(i);
        if (itemViewType == 1) {
            m7206a(inflate, a.m8108r());
        }
        if (itemViewType != 2) {
            m7209a(a, inflate);
        } else {
            m7205a(inflate, a);
        }
        return inflate;
    }

    private void m7206a(View view, final C3642c c3642c) {
        Resources resources = view.getContext().getResources();
        View findViewById = view.findViewById(R.id.expandingEventListItem_header);
        View findViewById2 = view.findViewById(R.id.eventItem);
        ImageView imageView = (ImageView) findViewById.findViewById(R.id.expandingEventListItem_arrowOpen);
        ImageView imageView2 = (ImageView) findViewById.findViewById(R.id.expandingEventListItem_arrowClosed);
        if (this.f4774e.contains(c3642c)) {
            findViewById2.setVisibility(0);
            imageView.setVisibility(0);
            imageView2.setVisibility(8);
        } else {
            findViewById2.setVisibility(8);
            imageView.setVisibility(8);
            imageView2.setVisibility(0);
        }
        findViewById.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ C1404e f5799b;

            public void onClick(View view) {
                if (this.f5799b.f4774e.contains(c3642c)) {
                    this.f5799b.f4774e.remove(c3642c);
                } else {
                    this.f5799b.f4774e.add(c3642c);
                }
                this.f5799b.m7237e();
            }
        });
        List list = (List) this.f4773d.get(c3642c);
        ((TextView) view.findViewById(R.id.expandingEventListItem_prompt)).setText(resources.getQuantityString(mo1038d(), list.size(), new Object[]{Integer.valueOf(list.size())}));
    }

    private void m7205a(View view, DisplayedRow displayedRow) {
        Context context = view.getContext();
        C1646c f = displayedRow.m8096f();
        ((TextView) view.findViewById(R.id.truckEventItem_occurredAt)).setText(m7223a(context, f.m8128b()));
        TruckInfoView truckInfoView = (TruckInfoView) view.findViewById(R.id.truckEventItem_truckNumber);
        truckInfoView.m12042a(true, true, true);
        truckInfoView.m12041a(f.m8129c(), f.m8127a());
    }

    protected void m7237e() {
        List arrayList = new ArrayList(this.f4775f.size());
        boolean z = false;
        List list = null;
        for (DisplayedRow displayedRow : this.f4775f) {
            C3642c r = displayedRow.m8108r();
            if (r == null) {
                arrayList.add(displayedRow);
            } else {
                if (list != null) {
                    if (!list.contains(r)) {
                        list = null;
                    } else if (!z) {
                        m7208a(displayedRow);
                    }
                }
                if (this.f4773d.containsKey(r)) {
                    List list2 = (List) this.f4773d.get(r);
                    boolean contains = this.f4774e.contains(r);
                    if (!contains) {
                        m7208a(displayedRow);
                    }
                    boolean z2 = contains;
                    list = list2;
                    z = z2;
                }
                arrayList.add(displayedRow);
            }
        }
        m7200b(arrayList);
    }

    private void m7208a(DisplayedRow displayedRow) {
        if (this.f4776g != null && this.f4776g.mo930f() != null && this.f4776g.mo930f().mo1036a((C1643q) displayedRow)) {
            this.f4776g.mo957a(null);
        }
    }

    protected String m7223a(Context context, long j) {
        Date date = new Date(j);
        TimeZone a = mo989a();
        DateFormat timeFormat = android.text.format.DateFormat.getTimeFormat(context);
        timeFormat.setTimeZone(a);
        StringBuilder stringBuilder = new StringBuilder(timeFormat.format(date));
        if (m7202l()) {
            stringBuilder.append(" ").append(a.getDisplayName(a.inDaylightTime(date), 0));
        }
        return stringBuilder.toString();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m7207a(com.bigroad.shared.duty.C0890f r3, android.widget.TextView r4) {
        /*
        r0 = r4.getContext();
        r1 = 2131231899; // 0x7f08049b float:1.8079892E38 double:1.0529684646E-314;
        r1 = r0.getString(r1);
        r0 = r3.m4523r();
        if (r0 == 0) goto L_0x001f;
    L_0x0011:
        r0 = r3.mo724t();
        r2 = com.bigroad.shared.am.m4188a(r0);
        if (r2 != 0) goto L_0x001f;
    L_0x001b:
        r4.setText(r0);
        return;
    L_0x001f:
        r0 = r1;
        goto L_0x001b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bigroad.ttb.android.adapter.e.a(com.bigroad.shared.duty.f, android.widget.TextView):void");
    }

    public void m7230a(List<C0890f> list, List<Event> list2, List<C1168m> list3, List<C1168m> list4, boolean z) {
        this.f4775f = m7199b(list, list2, list3, list4, z);
        m7238f();
        C3642c c3642c = null;
        long j = -1;
        for (DisplayedRow displayedRow : this.f4775f) {
            Event g = displayedRow.m8097g();
            if (g != null) {
                int eventType = g.getEventType();
                if (!displayedRow.m8093c() || eventType == 17 || eventType == 24) {
                    c3642c = null;
                } else {
                    long truckId;
                    C3642c c3642c2;
                    C3642c eventId = g.getEventId();
                    if (c3642c == null || j != g.getTruckId()) {
                        truckId = g.getTruckId();
                        c3642c2 = eventId;
                    } else {
                        long j2 = j;
                        c3642c2 = c3642c;
                        truckId = j2;
                    }
                    m7228a(c3642c2, eventId);
                    c3642c = c3642c2;
                    j = truckId;
                }
            }
        }
        m7237e();
    }

    protected void mo987a(List<DisplayedRow> list) {
        this.f4775f = Collections.unmodifiableList(list);
    }

    protected void m7238f() {
        this.f4773d.clear();
    }

    public int m7239g() {
        return this.f4773d.size();
    }

    public void m7240h() {
        this.f4774e.addAll(this.f4773d.keySet());
        m7237e();
    }

    public void m7241i() {
        this.f4774e.clear();
        m7237e();
    }

    public void m7242j() {
        if (m7243k()) {
            m7241i();
        } else {
            m7240h();
        }
    }

    public boolean m7243k() {
        return this.f4774e.size() > 0;
    }

    protected void m7228a(C3642c c3642c, C3642c c3642c2) {
        List list;
        if (this.f4773d.containsKey(c3642c)) {
            list = (List) this.f4773d.get(c3642c);
        } else {
            list = new ArrayList();
            this.f4773d.put(c3642c, list);
        }
        list.add(c3642c2);
    }

    public void m7225a(Bundle bundle) {
        Serializable hashSet = new HashSet();
        for (C3642c d : this.f4774e) {
            hashSet.add(d.m19091d());
        }
        bundle.putSerializable(f4770a, hashSet);
    }

    public void m7232b(Bundle bundle) {
        HashSet hashSet = (HashSet) bundle.getSerializable(f4770a);
        if (hashSet != null) {
            this.f4774e.clear();
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                this.f4774e.add(C3642c.m19078a((byte[]) it.next()));
            }
        }
    }

    protected void m7226a(View view, boolean z) {
        if (view != null) {
            view.setVisibility(z ? 8 : 0);
        }
    }

    private void m7209a(DisplayedRow displayedRow, View view) {
        m7218j(displayedRow, view);
        m7213e(displayedRow, view);
        m7214f(displayedRow, view);
        m7215g(displayedRow, view);
        m7216h(displayedRow, view);
        m7212d(displayedRow, view);
        m7211c(displayedRow, view);
        m7217i(displayedRow, view);
        m7210b(displayedRow, view);
        m7220l(displayedRow, view);
    }

    private void m7210b(DisplayedRow displayedRow, View view) {
        CharSequence x = displayedRow.m8114x();
        if (am.m4188a(x)) {
            m7233b(view, (int) R.id.eventItem_note);
            return;
        }
        m7222a(view, R.id.eventItem_note, x);
        m7235c(view, (int) R.id.eventItem_note);
    }

    private void m7211c(DisplayedRow displayedRow, View view) {
        if (displayedRow.m8100j()) {
            Context context = view.getContext();
            String str = null;
            if (displayedRow.m8111u() != null) {
                if (mo990b()) {
                    str = view.getResources().getString(R.string.dailyLogEvents_accumulatedEngineHours, new Object[]{C1738c.m8504a(context, displayedRow.m8111u()), C1738c.m8504a(context, Long.valueOf(aa.m4135a(displayedRow.m8112v(), 0)))});
                } else {
                    str = view.getResources().getString(R.string.dailyLogEvents_engineHours, new Object[]{C1738c.m8504a(context, displayedRow.m8111u())});
                }
            }
            m7222a(view, R.id.eventItem_engineHours, str);
            m7235c(view, (int) R.id.eventItem_engineHoursRow);
            return;
        }
        m7233b(view, (int) R.id.eventItem_engineHoursRow);
    }

    private void m7212d(DisplayedRow displayedRow, View view) {
        if (displayedRow.m8100j()) {
            String str = null;
            Integer s = displayedRow.m8109s();
            if (s != null) {
                OdometerUnit odometerUnit = displayedRow.m8099i() ? OdometerUnit.KM : OdometerUnit.MILES;
                if (mo990b()) {
                    str = view.getResources().getString(R.string.dailyLogEvents_accumulatedOdometer, new Object[]{String.valueOf(displayedRow.m8109s()), af.m4153a(odometerUnit), String.valueOf(aa.m4132a(displayedRow.m8110t(), 0))});
                } else {
                    str = af.m4154a(s.toString(), odometerUnit);
                }
            }
            m7222a(view, R.id.eventItem_odometer, str);
            m7235c(view, (int) R.id.eventItem_odometerRow);
            return;
        }
        m7233b(view, (int) R.id.eventItem_odometerRow);
    }

    private void m7213e(DisplayedRow displayedRow, View view) {
        if (displayedRow.m8097g() != null) {
            m7222a(view, R.id.eventItem_dutyStatus, displayedRow.m8088a(view.getContext().getResources()));
        }
    }

    private void m7214f(DisplayedRow displayedRow, View view) {
        int i = R.string.dutyStatus_subtitle_personalConveyance;
        if (!displayedRow.m8106p()) {
            if (displayedRow.m8107q()) {
                i = R.string.dutyStatus_subtitle_yardMove;
            } else {
                if (displayedRow.m8097g().getEventType() == 36) {
                    Mode a = EldDrivingModeBits.m4066a(displayedRow.m8097g());
                    if (a != null) {
                        switch (a) {
                            case PERSONAL_CONVEYANCE:
                                break;
                            case YARD_MOVE:
                                i = R.string.dutyStatus_subtitle_yardMove;
                                break;
                            case NORMAL_DRIVING:
                                i = R.string.eventType_subtitle_noSpecialDrivingMode;
                                break;
                        }
                    }
                }
                i = 0;
            }
        }
        if (i == 0) {
            m7233b(view, (int) R.id.eventItem_dutyStatusSubtitle);
            return;
        }
        m7222a(view, R.id.eventItem_dutyStatusSubtitle, view.getContext().getString(i));
        m7235c(view, (int) R.id.eventItem_dutyStatusSubtitle);
    }

    private void m7215g(DisplayedRow displayedRow, View view) {
        if (displayedRow.m8090a()) {
            m7222a(view, R.id.eventItem_duration, ac.m11175a(displayedRow.m8101k(), view.getContext().getResources()));
            m7235c(view, (int) R.id.eventItem_duration);
            return;
        }
        m7233b(view, (int) R.id.eventItem_duration);
    }

    private void m7216h(DisplayedRow displayedRow, View view) {
        if (displayedRow.m8100j()) {
            CharSequence w = displayedRow.m8113w();
            if (!am.m4188a(w)) {
                m7222a(view, R.id.eventItem_location, w);
                return;
            } else if (displayedRow.m8090a()) {
                m7219k(displayedRow, view);
                return;
            } else {
                m7221a(view, (int) R.id.eventItem_location).setText(view.getContext().getString(R.string.eventItem_noLocation));
                return;
            }
        }
        m7219k(displayedRow, view);
    }

    private void m7217i(DisplayedRow displayedRow, View view) {
        if (displayedRow.m8100j()) {
            int i = R.string.recordOrigin_manualEntry;
            if (displayedRow.m8104n()) {
                i = C2289i.m11215a(displayedRow.m8105o());
            }
            m7222a(view, R.id.eventItem_origin, view.getContext().getString(i));
            m7235c(view, (int) R.id.eventItem_originRow);
            return;
        }
        m7233b(view, (int) R.id.eventItem_originRow);
    }

    private void m7218j(DisplayedRow displayedRow, View view) {
        m7222a(view, R.id.eventItem_time, m7223a(view.getContext(), displayedRow.m8103m()));
    }

    private void m7219k(DisplayedRow displayedRow, View view) {
        C1404e.m7207a(displayedRow.m8092b(), m7221a(view, (int) R.id.eventItem_location));
    }

    private void m7220l(DisplayedRow displayedRow, View view) {
        C0025b c0025b = new C0025b();
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.eventItem_constraintLayout);
        c0025b.m113a(constraintLayout);
        c0025b.m110a((int) R.id.eventItem_locationContainer, 2);
        if (displayedRow.m8100j()) {
            c0025b.m111a(R.id.eventItem_locationContainer, 2, 0, 2);
        } else {
            c0025b.m111a(R.id.eventItem_locationContainer, 2, R.id.eventItem_editButton, 1);
        }
        c0025b.m115b(constraintLayout);
    }

    protected TextView m7222a(View view, int i, String str) {
        Resources resources = view.getContext().getResources();
        if (am.m4188a((CharSequence) str)) {
            this.f4772c.m11267b(resources.getString(R.string.none));
        } else {
            this.f4772c.m11268c(str);
        }
        TextView a = m7221a(view, i);
        a.setText(this.f4772c.m11270e());
        return a;
    }

    protected TextView m7221a(View view, int i) {
        return (TextView) view.findViewById(i);
    }

    protected void m7233b(View view, int i) {
        view.findViewById(i).setVisibility(8);
    }

    protected void m7235c(View view, int i) {
        view.findViewById(i).setVisibility(0);
    }
}
