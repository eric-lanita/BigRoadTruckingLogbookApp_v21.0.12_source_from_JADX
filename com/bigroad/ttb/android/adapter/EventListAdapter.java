package com.bigroad.ttb.android.adapter;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.bigroad.shared.C1144s;
import com.bigroad.shared.EventStatusMaskBits;
import com.bigroad.shared.EventStatusMaskBits.RecordOrigin;
import com.bigroad.shared.aa;
import com.bigroad.shared.am;
import com.bigroad.shared.ao;
import com.bigroad.shared.aq;
import com.bigroad.shared.duty.C0890f;
import com.bigroad.shared.duty.C0896g;
import com.bigroad.shared.duty.C0896g.C0870a;
import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.shared.model.C1127k;
import com.bigroad.shared.validation.C1168m;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.TruckManager;
import com.bigroad.ttb.android.widget.C1643q;
import com.bigroad.ttb.android.widget.C2462j;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import com.bigroad.ttb.protocol.TTProtocol.TruckLogType;
import com.google.common.base.Objects;
import com.google.common.collect.C3540t;
import com.google.common.collect.C3589f;
import com.google.protobuf.C3642c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

public class EventListAdapter extends BaseAdapter {
    private static final String f4766a = (EventListAdapter.class.getName() + ".selectedItem");
    private static final Comparator<DisplayedRow> f4767b = new C16421();
    private List<DisplayedRow> f4768c = Collections.emptyList();
    private boolean f4769d = false;

    static class C16421 implements Comparator<DisplayedRow> {
        C16421() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m8081a((DisplayedRow) obj, (DisplayedRow) obj2);
        }

        public int m8081a(DisplayedRow displayedRow, DisplayedRow displayedRow2) {
            Object c;
            Object obj = null;
            if (displayedRow.m8095e()) {
                c = displayedRow.m8096f().m8129c();
            } else {
                c = null;
            }
            if (displayedRow2.m8095e()) {
                obj = displayedRow2.m8096f().m8129c();
            }
            return C3589f.m18773a().mo2736a(displayedRow.m8102l(), displayedRow2.m8102l()).mo2739a(displayedRow.m8095e(), displayedRow2.m8095e()).mo2738a(c, obj, C3540t.m18450c().mo2709b()).mo2739a(displayedRow.m8093c(), displayedRow2.m8093c()).mo2738a(displayedRow.m8097g(), displayedRow2.m8097g(), C1144s.f3800a).mo2740b();
        }
    }

    public static final class DisplayedRow implements C1643q {
        private final Type f5717a;
        private final Object f5718b;

        private enum Type {
            DUTY_STATUS_EVENT,
            ELD_INFO_EVENT,
            TRUCK
        }

        private DisplayedRow(Type type, Object obj) {
            this.f5717a = type;
            this.f5718b = obj;
        }

        public static DisplayedRow m8084a(C0890f c0890f, List<C1168m> list, List<C1168m> list2, boolean z) {
            return new DisplayedRow(Type.DUTY_STATUS_EVENT, new C1644a(c0890f, list, list2, z));
        }

        public static DisplayedRow m8085a(Event event, boolean z) {
            return new DisplayedRow(Type.ELD_INFO_EVENT, new C1645b(event, z));
        }

        public static DisplayedRow m8086a(Truck truck, Event event) {
            return new DisplayedRow(Type.TRUCK, new C1646c(truck, event));
        }

        public boolean m8090a() {
            return this.f5717a == Type.DUTY_STATUS_EVENT;
        }

        public C1644a m8092b() {
            return (C1644a) this.f5718b;
        }

        public boolean m8093c() {
            return this.f5717a == Type.ELD_INFO_EVENT;
        }

        public C1645b m8094d() {
            return (C1645b) this.f5718b;
        }

        public boolean m8095e() {
            return this.f5717a == Type.TRUCK;
        }

        public C1646c m8096f() {
            return (C1646c) this.f5718b;
        }

        public boolean mo1036a(C1643q c1643q) {
            if (this == c1643q) {
                return true;
            }
            if (!(c1643q instanceof DisplayedRow)) {
                return false;
            }
            DisplayedRow displayedRow = (DisplayedRow) c1643q;
            if (m8090a()) {
                if (displayedRow.m8090a() && m8092b().m8121a(displayedRow.m8092b())) {
                    return true;
                }
                return false;
            } else if (!m8093c()) {
                return false;
            } else {
                if (displayedRow.m8093c() && m8094d().m8123a(displayedRow.m8094d())) {
                    return true;
                }
                return false;
            }
        }

        public void mo1035a(Bundle bundle) {
            if (!m8095e()) {
                long j = 0;
                if (m8090a()) {
                    j = m8092b().m4522q();
                } else if (m8093c()) {
                    j = m8094d().m8125c();
                }
                bundle.putLong(EventListAdapter.f4766a, j);
            }
        }

        public Event m8097g() {
            if (m8090a()) {
                return m8092b().m4519n();
            }
            if (m8093c()) {
                return m8094d().m8122a();
            }
            return null;
        }

        public boolean m8098h() {
            if (m8090a()) {
                return m8092b().m8116C();
            }
            if (m8093c()) {
                return m8094d().m8124b();
            }
            return true;
        }

        public boolean m8099i() {
            Event g = m8097g();
            if (!g.hasTruckId()) {
                return false;
            }
            Truck a = OurApplication.m6294p().m6552a(g.getTruckId());
            if (a == null || a.getOdometerUnit() != 1) {
                return false;
            }
            return true;
        }

        public boolean m8100j() {
            Event g = m8097g();
            return g != null && g.hasSequenceId();
        }

        public long m8101k() {
            return this.f5717a == Type.DUTY_STATUS_EVENT ? m8092b().m4515j() : 0;
        }

        public long m8102l() {
            if (m8095e()) {
                return m8096f().m8128b();
            }
            return m8097g().getOccurredAt();
        }

        public long m8103m() {
            if (this.f5717a == Type.DUTY_STATUS_EVENT) {
                return m8092b().m4508c();
            }
            return aq.m4214a(m8097g().getOccurredAt());
        }

        public boolean m8104n() {
            Event g = m8097g();
            return g != null && g.hasStatusMask();
        }

        public RecordOrigin m8105o() {
            Event g = m8097g();
            if (g == null || !g.hasStatusMask()) {
                return RecordOrigin.UNKNOWN;
            }
            return EventStatusMaskBits.m4081b(g.getStatusMask());
        }

        public boolean m8106p() {
            Event g = m8097g();
            return g != null && g.getEventType() == 23;
        }

        public boolean m8107q() {
            Event g = m8097g();
            return g != null && g.getEventType() == 34;
        }

        public C3642c m8108r() {
            Event g = m8097g();
            return (g == null || !g.hasEventId()) ? null : g.getEventId();
        }

        public String m8088a(Resources resources) {
            Event g = m8097g();
            CharSequence a = C2462j.m12109a(resources, g);
            if (a == null && DutyStatus.m4389b(g)) {
                a = C2462j.m12108a(resources, DutyStatus.m4384a(g));
            }
            if (am.m4188a(a)) {
                return "";
            }
            return a.toString();
        }

        public Integer m8109s() {
            Event g = m8097g();
            if (g == null || !g.hasOdometer()) {
                return null;
            }
            return Integer.valueOf(g.getOdometer());
        }

        public Integer m8110t() {
            Event g = m8097g();
            if (g == null || !g.hasEngineCycleDistance()) {
                return null;
            }
            return Integer.valueOf(g.getEngineCycleDistance());
        }

        public Long m8111u() {
            Event g = m8097g();
            if (g == null || !g.hasEngineTotalUptime()) {
                return null;
            }
            return Long.valueOf(g.getEngineTotalUptime());
        }

        public Long m8112v() {
            Event g = m8097g();
            if (g == null || !g.hasEngineCycleUptime()) {
                return null;
            }
            return Long.valueOf(g.getEngineCycleUptime());
        }

        public String m8113w() {
            return C1127k.m5707b(m8097g());
        }

        public String m8114x() {
            Event g = m8097g();
            if (g.hasNotes()) {
                return g.getNotes();
            }
            return null;
        }

        public static boolean m8087a(Collection<DisplayedRow> collection) {
            for (DisplayedRow displayedRow : collection) {
                if (displayedRow.m8090a() && displayedRow.m8092b().m4513h()) {
                    return true;
                }
            }
            return false;
        }
    }

    public static final class C1644a extends C0890f {
        private final boolean f5719b;
        private final List<C1168m> f5720c;
        private final List<C1168m> f5721d;

        public C1644a(C0890f c0890f, List<C1168m> list, List<C1168m> list2, boolean z) {
            super(c0890f);
            this.f5719b = z;
            this.f5720c = m8115a(c0890f, list, DutyStatus.DRIVING);
            this.f5721d = m8115a(c0890f, list2, C0896g.f2768a);
        }

        private List<C1168m> m8115a(C0890f c0890f, List<C1168m> list, C0870a c0870a) {
            List list2 = null;
            if (c0870a.mo701a(c0890f.mo702m())) {
                ao g = c0890f.m4512g();
                for (C1168m c1168m : list) {
                    if (g.mo693b(c1168m.m5940a())) {
                        if (list2 == null) {
                            list2 = new ArrayList();
                        }
                        list2.add(c1168m);
                    }
                }
            }
            if (list2 == null) {
                return Collections.emptyList();
            }
            return Collections.unmodifiableList(list2);
        }

        public boolean m8116C() {
            return this.f5719b;
        }

        public boolean m8117D() {
            return !this.f5720c.isEmpty();
        }

        public List<C1168m> m8118E() {
            return this.f5720c;
        }

        public boolean m8119F() {
            return !this.f5721d.isEmpty();
        }

        public List<C1168m> m8120G() {
            return this.f5721d;
        }

        public boolean m8121a(C1644a c1644a) {
            if (m4520o() && c1644a.m4520o()) {
                return Arrays.equals(m4521p(), c1644a.m4521p());
            }
            return m4522q() == c1644a.m4522q();
        }
    }

    public static final class C1645b {
        private final Event f5722a;
        private final boolean f5723b;

        public C1645b(Event event, boolean z) {
            this.f5722a = event;
            this.f5723b = z;
        }

        public Event m8122a() {
            return this.f5722a;
        }

        public boolean m8124b() {
            return this.f5723b;
        }

        public long m8125c() {
            return aa.m4137a(this.f5722a.getEventId().m19091d(), 0);
        }

        public byte[] m8126d() {
            return this.f5722a.getEventId().m19091d();
        }

        public boolean m8123a(C1645b c1645b) {
            return Arrays.equals(m8126d(), c1645b.m8126d());
        }
    }

    public static final class C1646c {
        private final Truck f5724a;
        private final Event f5725b;

        public C1646c(Truck truck, Event event) {
            this.f5724a = truck;
            this.f5725b = event;
        }

        public TruckLogType m8127a() {
            TruckLogType truckLogType = TruckLogType.UNKNOWN_LOG_TYPE;
            if (this.f5724a == null || !this.f5724a.hasTruckLogType()) {
                return truckLogType;
            }
            return TruckLogType.m15634a(this.f5724a.getTruckLogType());
        }

        public long m8128b() {
            return this.f5725b.getOccurredAt();
        }

        public String m8129c() {
            if (this.f5724a == null) {
                return null;
            }
            return this.f5724a.getTruckNumber();
        }
    }

    public /* synthetic */ Object getItem(int i) {
        return m7196a(i);
    }

    protected List<DisplayedRow> m7199b(List<C0890f> list, List<Event> list2, List<C1168m> list3, List<C1168m> list4, boolean z) {
        List arrayList = new ArrayList(list.size() + list2.size());
        for (C0890f c0890f : list) {
            if (!c0890f.mo720v() || !list3.isEmpty() || !list4.isEmpty()) {
                arrayList.add(DisplayedRow.m8084a(c0890f, list3, list4, z));
            }
        }
        for (Event a : list2) {
            arrayList.add(DisplayedRow.m8085a(a, z));
        }
        Collections.sort(arrayList, f4767b);
        if (g_()) {
            mo987a(arrayList);
        }
        return arrayList;
    }

    protected boolean g_() {
        return true;
    }

    private void mo987a(List<DisplayedRow> list) {
        if (!list.isEmpty()) {
            TruckManager p = OurApplication.m6294p();
            ListIterator listIterator = list.listIterator();
            Object obj = null;
            Object obj2 = null;
            while (listIterator.hasNext()) {
                Object obj3;
                DisplayedRow displayedRow = (DisplayedRow) listIterator.next();
                Event g = displayedRow.m8097g();
                if (displayedRow.m8090a() && displayedRow.m8092b().mo720v()) {
                    obj3 = null;
                } else {
                    int i = 1;
                }
                Object valueOf = g.hasTruckId() ? Long.valueOf(g.getTruckId()) : null;
                Object obj4;
                if (Objects.equal(obj, valueOf)) {
                    obj4 = null;
                } else {
                    obj4 = 1;
                }
                if (obj3 == null || (obj2 != null && r7 == null)) {
                    obj3 = null;
                } else {
                    obj3 = 1;
                }
                if (obj3 != null) {
                    DisplayedRow a = DisplayedRow.m8086a(p.m6552a(g.getTruckId()), g);
                    listIterator.previous();
                    listIterator.add(a);
                    listIterator.next();
                    obj = 1;
                } else {
                    valueOf = obj;
                    obj = obj2;
                }
                obj2 = obj;
                obj = valueOf;
            }
        }
    }

    protected void m7200b(List<DisplayedRow> list) {
        this.f4768c = Collections.unmodifiableList(list);
        this.f4769d = DisplayedRow.m8087a(this.f4768c);
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.f4768c.size();
    }

    public boolean isEmpty() {
        if (getCount() == 0) {
            return true;
        }
        C1644a c1644a = null;
        for (int i = 0; i < getCount(); i++) {
            DisplayedRow a = m7196a(i);
            if (a.m8093c()) {
                return false;
            }
            if (a.m8090a()) {
                if (c1644a != null) {
                    return false;
                }
                c1644a = a.m8092b();
            }
        }
        if (c1644a == null || !c1644a.mo720v() || c1644a.m8117D() || c1644a.m8119F()) {
            return false;
        }
        return true;
    }

    public DisplayedRow m7196a(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (DisplayedRow) this.f4768c.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public boolean m7202l() {
        return this.f4769d;
    }

    public DisplayedRow m7201c(Bundle bundle) {
        if (bundle.containsKey(f4766a)) {
            return m7197a(bundle.getLong(f4766a));
        }
        return null;
    }

    public DisplayedRow m7197a(long j) {
        for (int i = 0; i < getCount(); i++) {
            DisplayedRow a = m7196a(i);
            if (a.m8090a() && a.m8092b().m4522q() == j) {
                return a;
            }
            if (a.m8093c() && a.m8094d().m8125c() == j) {
                return a;
            }
        }
        return null;
    }

    public DisplayedRow m7198a(byte[] bArr) {
        for (int i = 0; i < getCount(); i++) {
            DisplayedRow a = m7196a(i);
            if (a.m8090a() && Arrays.equals(a.m8092b().m4521p(), bArr)) {
                return a;
            }
            if (a.m8093c() && Arrays.equals(a.m8094d().m8126d(), bArr)) {
                return a;
            }
        }
        return null;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    public List<C0890f> m7203m() {
        List<C0890f> arrayList = new ArrayList(this.f4768c.size());
        for (DisplayedRow displayedRow : this.f4768c) {
            if (displayedRow.m8090a()) {
                arrayList.add(displayedRow.m8092b());
            }
        }
        return arrayList;
    }
}
