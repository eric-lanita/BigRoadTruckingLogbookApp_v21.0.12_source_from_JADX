package com.bigroad.ttb.android.event;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import com.bigroad.shared.C1099k;
import com.bigroad.shared.C1100l;
import com.bigroad.shared.C1101m;
import com.bigroad.shared.C1130o;
import com.bigroad.shared.C1142r;
import com.bigroad.shared.C1142r.C1135c;
import com.bigroad.shared.C1144s;
import com.bigroad.shared.C1146u;
import com.bigroad.shared.C1180y;
import com.bigroad.shared.DutyStatusChangeBits;
import com.bigroad.shared.DutyStatusChangeBits.Reason;
import com.bigroad.shared.EventStatusMaskBits;
import com.bigroad.shared.EventStatusMaskBits.RecordOrigin;
import com.bigroad.shared.EventStatusMaskBits.RecordStatus;
import com.bigroad.shared.ag;
import com.bigroad.shared.ag.C0837a;
import com.bigroad.shared.ai;
import com.bigroad.shared.al;
import com.bigroad.shared.ao;
import com.bigroad.shared.ap;
import com.bigroad.shared.ap.C0842a;
import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.shared.duty.C0890f;
import com.bigroad.shared.duty.C0890f.C0886a;
import com.bigroad.shared.duty.C0907o;
import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.shared.duty.rule.C0947t;
import com.bigroad.shared.duty.rule.C0947t.C0946a;
import com.bigroad.shared.eobr.turbo.logs.EobrEventLogData;
import com.bigroad.shared.p021a.C0831a;
import com.bigroad.ttb.android.C2032f;
import com.bigroad.ttb.android.C2230r;
import com.bigroad.ttb.android.C2474y;
import com.bigroad.ttb.android.C2474y.C1182a;
import com.bigroad.ttb.android.C2474y.C1183b;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.TruckManager;
import com.bigroad.ttb.android.TruckManager.C1203b;
import com.bigroad.ttb.android.TruckManager.ChangeListener.Priority;
import com.bigroad.ttb.android.aj;
import com.bigroad.ttb.android.aobrd.MalfunctionReason;
import com.bigroad.ttb.android.eobr.C1902e.C1206c;
import com.bigroad.ttb.android.eobr.EobrDevice;
import com.bigroad.ttb.android.fragment.UnassignedDrivingClaimer.ClaimState;
import com.bigroad.ttb.android.location.LocationTracker;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.p029c.C1736b;
import com.bigroad.ttb.android.p029c.C1736b.C1219a;
import com.bigroad.ttb.android.p030a.C1257b;
import com.bigroad.ttb.android.p035d.C1790a;
import com.bigroad.ttb.android.p035d.p036a.C1774m;
import com.bigroad.ttb.android.p035d.p036a.C1783u;
import com.bigroad.ttb.android.p035d.p036a.C1786x;
import com.bigroad.ttb.android.util.C2292l;
import com.bigroad.ttb.android.util.C2297q;
import com.bigroad.ttb.android.util.C2307z;
import com.bigroad.ttb.android.vehicle.C2363e;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager.C1201a;
import com.bigroad.ttb.android.vehicle.task.DrivingTask;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.Event.C2647a;
import com.bigroad.ttb.protocol.TTProtocol.EventList;
import com.bigroad.ttb.protocol.TTProtocol.EventType;
import com.bigroad.ttb.protocol.TTProtocol.ExternalVarEntry;
import com.bigroad.ttb.protocol.TTProtocol.ExternalVarEntryType;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import com.bigroad.ttb.protocol.TTProtocol.VarDutyStatusChange;
import com.bigroad.ttb.protocol.TTProtocol.VarDutyStatusChange.C2803a;
import com.bigroad.ttb.protocol.TTProtocol.VehicleIdentification;
import com.google.common.base.Objects;
import com.google.protobuf.C3642c;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

public class EventManager {
    private static EventManager f6954b;
    private final com.bigroad.ttb.android.TruckManager.ChangeListener f6955A = new C20135(this);
    private final com.bigroad.ttb.android.vehicle.VehicleConnectionManager.ChangeListener f6956B = new C20146(this);
    private final C1219a f6957C = new C20157(this);
    private final C1135c f6958D = new C20168(this);
    private final C0842a f6959E = new C20179(this);
    private final C1206c f6960a;
    private final Context f6961c;
    private final C2032f f6962d;
    private final C2474y f6963e;
    private final C1790a f6964f;
    private final TruckManager f6965g;
    private final VehicleConnectionManager f6966h;
    private final AlarmManager f6967i;
    private final ap f6968j;
    private final C2230r f6969k;
    private final LocationTracker f6970l;
    private final aj f6971m;
    private final ag<ChangeListener> f6972n = new ag();
    private C3642c f6973o;
    private List<Event> f6974p = new ArrayList();
    private List<C1783u> f6975q = new ArrayList();
    private Intent f6976r = new Intent("com.bigroad.ttb.android.event.EventManager.FUTURE_ALARM");
    private Map<C3642c, C2019b> f6977s = new HashMap();
    private Map<C3642c, Event> f6978t = new HashMap();
    private Map<Integer, List<C0890f>> f6979u = new HashMap();
    private List<Integer> f6980v = new ArrayList();
    private Set<C3642c> f6981w = new HashSet();
    private final C2021d f6982x;
    private final C2025b f6983y;
    private final C1182a f6984z = new C20091(this);

    public interface ChangeListener {

        public enum Priority {
            MALFUNCTION_MONITOR,
            AOBRD_MANAGER,
            AOBRD_DRIVING_MONITOR,
            DEFAULT
        }

        void mo882a();

        void mo883a(C1142r c1142r);

        void mo884a(EventManager eventManager, boolean z);

        void mo885b();
    }

    public static class C1199e implements ChangeListener {
        public void mo884a(EventManager eventManager, boolean z) {
        }

        public void mo882a() {
        }

        public void mo885b() {
        }

        public void mo883a(C1142r c1142r) {
        }
    }

    class C20091 extends C1183b {
        final /* synthetic */ EventManager f6935a;

        C20091(EventManager eventManager) {
            this.f6935a = eventManager;
        }

        public void mo863a(C2474y c2474y) {
            this.f6935a.m9996w();
            this.f6935a.m9995v();
        }

        public void mo868e(C2474y c2474y) {
            this.f6935a.m9969A();
            this.f6935a.m9970B();
        }
    }

    class C20102 implements C0837a<ChangeListener> {
        final /* synthetic */ EventManager f6936a;

        C20102(EventManager eventManager) {
            this.f6936a = eventManager;
        }

        public void m9952a(ChangeListener changeListener) {
            changeListener.mo882a();
        }
    }

    class C20124 implements C0837a<ChangeListener> {
        final /* synthetic */ EventManager f6939a;

        C20124(EventManager eventManager) {
            this.f6939a = eventManager;
        }

        public void m9956a(ChangeListener changeListener) {
            changeListener.mo885b();
        }
    }

    class C20135 extends C1203b {
        final /* synthetic */ EventManager f6940a;

        C20135(EventManager eventManager) {
            this.f6940a = eventManager;
        }

        public void mo894a(Truck truck) {
            if (truck == null || !truck.getHasAobrd()) {
                this.f6940a.m9995v();
            } else if (this.f6940a.m10060j().m4397e() && !truck.getHasAobrd()) {
                Truck e = this.f6940a.m9999z();
                if (e == null || e.getTruckId() != truck.getTruckId()) {
                    DailyLog h = this.f6940a.f6962d.mo1302j().m8494h();
                    if (C2292l.m11231a(h)) {
                        C2292l.m11227a(h, false, this.f6940a.f6962d);
                    }
                    C2647a newBuilder = Event.newBuilder(C2022a.m10085a(this.f6940a.m10060j().m4392a(), DutyStatusChangeBits.m4033a(Reason.TRUCK_PICKED_WHILE_DRIVING), this.f6940a.f6962d));
                    newBuilder.m13856b(this.f6940a.f6961c.getString(R.string.truckSwitchNote, new Object[]{truck.getTruckNumber()}));
                    this.f6940a.m10050e(newBuilder.m13862c());
                }
            }
        }
    }

    class C20146 extends C1201a {
        final /* synthetic */ EventManager f6941a;

        C20146(EventManager eventManager) {
            this.f6941a = eventManager;
        }

        public void mo889a(C2363e c2363e) {
            this.f6941a.m9994u();
        }
    }

    class C20157 implements C1219a {
        final /* synthetic */ EventManager f6942a;

        C20157(EventManager eventManager) {
            this.f6942a = eventManager;
        }

        public void mo904a(C1736b c1736b) {
            this.f6942a.m9969A();
            this.f6942a.m9970B();
        }
    }

    class C20168 implements C1135c {
        final /* synthetic */ EventManager f6943a;

        C20168(EventManager eventManager) {
            this.f6943a = eventManager;
        }

        public boolean mo818a(Event event, List<byte[]> list) {
            if (C1144s.m5759a(event)) {
                this.f6943a.f6974p.add(event);
            }
            return true;
        }

        public boolean mo817a(Event event) {
            ListIterator listIterator = this.f6943a.f6974p.listIterator();
            while (listIterator.hasNext()) {
                if (event.getEventId().equals(((Event) listIterator.next()).getEventId())) {
                    if (C1144s.m5759a(event)) {
                        listIterator.set(event);
                    }
                    return true;
                }
            }
            C2134e.m10680d("TT-EventManager", "Unable to update event with id=" + C1180y.m5989a(event.getEventId()) + " (not found)");
            return false;
        }

        public boolean mo819b(Event event) {
            ListIterator listIterator = this.f6943a.f6974p.listIterator();
            while (listIterator.hasNext()) {
                if (((Event) listIterator.next()).getEventId().equals(event.getEventId())) {
                    listIterator.remove();
                    return true;
                }
            }
            C2134e.m10680d("TT-EventManager", "Unable to delete event with id=" + C1180y.m5989a(event.getEventId()) + " (not found)");
            return false;
        }
    }

    class C20179 implements C0842a {
        final /* synthetic */ EventManager f6944a;

        C20179(EventManager eventManager) {
            this.f6944a = eventManager;
        }

        public void mo1016a() {
            this.f6944a.m9976a(false);
        }
    }

    public interface C2018a {
        void mo1288a(Event event);
    }

    static class C2019b {
        public final Event f6950a;
        public final C2018a f6951b;

        public C2019b(Event event, C2018a c2018a) {
            this.f6950a = event;
            this.f6951b = c2018a;
        }
    }

    private class C2020c extends BroadcastReceiver {
        final /* synthetic */ EventManager f6952a;

        private C2020c(EventManager eventManager) {
            this.f6952a = eventManager;
        }

        public void onReceive(Context context, Intent intent) {
            Event event;
            Event h = this.f6952a.m10056h();
            if (h == null) {
                event = null;
            } else {
                event = this.f6952a.m10037c(h.getOccurredAt());
            }
            if (h != null && event != null) {
                this.f6952a.m9976a(event.getEventType() != h.getEventType());
            }
        }
    }

    public class C2021d {
        final /* synthetic */ EventManager f6953a;

        public C2021d(EventManager eventManager) {
            this.f6953a = eventManager;
        }

        public void m9967a(Event event, long j, long j2, boolean z) {
            if (this.f6953a.m10005a(event.getEventId().m19091d()) == null) {
                C2134e.m10680d("TT-EventManager", "Can't find event to extend: " + C1144s.m5763c(event));
                return;
            }
            this.f6953a.f6983y.m10108a(event.getEventId(), event.getPersonId(), j, j2);
            this.f6953a.f6962d.mo1302j().m8476a(event);
            this.f6953a.f6983y.m10104a(this.f6953a.f6974p);
            if (z) {
                this.f6953a.m9976a(false);
            }
        }

        public void m9968a(byte[] bArr, long j) {
            if (this.f6953a.m10005a(bArr) == null) {
                C2134e.m10680d("TT-EventManager", "Can't find event to update contextual data: " + bArr);
                return;
            }
            this.f6953a.f6983y.m10107a(ai.m4175a(bArr), j);
            this.f6953a.f6983y.m10104a(this.f6953a.f6974p);
            this.f6953a.m9976a(false);
        }

        public void m9966a() {
            this.f6953a.f6983y.m10106a();
        }
    }

    public static EventManager m9971a(Context context, C2032f c2032f) {
        if (f6954b == null) {
            f6954b = new EventManager(context, c2032f);
        }
        return f6954b;
    }

    private EventManager(Context context, C2032f c2032f) {
        this.f6961c = context;
        this.f6962d = c2032f;
        this.f6963e = c2032f.mo1295c();
        this.f6964f = c2032f.mo1297e();
        this.f6965g = c2032f.mo1300h();
        this.f6966h = c2032f.mo1311s();
        this.f6968j = c2032f.mo1314v();
        this.f6969k = c2032f.mo1299g();
        this.f6970l = c2032f.mo1304l();
        this.f6971m = c2032f.mo1318z();
        this.f6963e.m12184a(this.f6984z);
        this.f6965g.m6560a(this.f6955A, Priority.EVENT_MANAGER);
        this.f6966h.m11399a(this.f6956B);
        this.f6968j.m4201a(this.f6959E);
        this.f6960a = new C2026c(this, this.f6962d);
        new Handler().post(new Runnable(this) {
            final /* synthetic */ EventManager f6931a;

            {
                this.f6931a = r1;
            }

            public void run() {
                this.f6931a.f6962d.mo1302j().m8474a(this.f6931a.f6957C);
            }
        });
        this.f6983y = new C2025b(c2032f);
        this.f6982x = new C2021d(this);
        m9993t();
        this.f6967i = this.f6962d.mo1292a(context);
        context.registerReceiver(new C2020c(), new IntentFilter("com.bigroad.ttb.android.event.EventManager.FUTURE_ALARM"));
        context.registerReceiver(new BroadcastReceiver(this) {
            final /* synthetic */ EventManager f6932a;

            {
                this.f6932a = r1;
            }

            public void onReceive(Context context, Intent intent) {
                this.f6932a.m9976a(true);
            }
        }, new IntentFilter("android.intent.action.TIME_SET"));
    }

    private void m9993t() {
        this.f6973o = null;
        this.f6974p = new ArrayList();
        for (C1774m d : this.f6964f.m8803o()) {
            Event d2 = d.m8613d();
            if (d2 != null) {
                this.f6974p.add(d2);
            }
        }
        this.f6975q.clear();
        this.f6975q.addAll(this.f6964f.m8805q());
        this.f6983y.m10104a(this.f6974p);
        Collections.sort(this.f6974p, C1144s.f3800a);
    }

    private void m9994u() {
        m9995v();
        EobrDevice j = this.f6966h.m11412j();
        if (j != null) {
            for (C1786x c1786x : this.f6964f.m8752b(j.mo1120h())) {
                Event f = c1786x.m8661f();
                if (f != null) {
                    C2134e.m10676b("TT-EventManager", "Loading unclaimed event from database: " + C1144s.m5763c(f));
                    if (c1786x.m8660e()) {
                        this.f6981w.add(f.getEventId());
                    }
                    this.f6978t.put(f.getEventId(), f);
                }
            }
            m9969A();
            m9970B();
            m9997x();
        }
    }

    private void m9995v() {
        C2134e.m10676b("TT-EventManager", "Clearing unclaimed events list");
        this.f6978t.clear();
        this.f6979u.clear();
        this.f6980v.clear();
        this.f6981w.clear();
        m9997x();
    }

    public C3642c m10006a() {
        return this.f6973o;
    }

    public List<Event> m10025b() {
        return Collections.unmodifiableList(this.f6974p);
    }

    public List<Event> m10039c() {
        List arrayList = new ArrayList(this.f6974p.size());
        for (Event event : this.f6974p) {
            if (DutyStatus.m4387b(event.getEventType())) {
                arrayList.add(event);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public List<Event> m10045d() {
        List arrayList = new ArrayList(this.f6974p.size());
        for (Event event : this.f6974p) {
            if (C1130o.m5716b(event)) {
                arrayList.add(event);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public List<Event> m10009a(long j) {
        List arrayList = new ArrayList();
        for (Event event : this.f6974p) {
            if (event.getOccurredAt() <= j && DutyStatus.m4387b(event.getEventType())) {
                arrayList.add(event);
            } else if (event.getOccurredAt() > j) {
                break;
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public List<Event> m10027b(long j) {
        List arrayList = new ArrayList();
        for (Event event : this.f6974p) {
            if (event.getEventType() == 16 && event.hasTruckId() && event.getTruckId() == j) {
                arrayList.add(event);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public List<Event> m10007a(int i) {
        List arrayList = new ArrayList(this.f6974p.size());
        for (Event event : this.f6974p) {
            if (event.getEventType() == 32 && i == ((int) event.getContextualData())) {
                arrayList.add(event);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Event m10005a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        for (Event event : this.f6974p) {
            if (Arrays.equals(event.getEventId().m19091d(), bArr)) {
                return event;
            }
        }
        return null;
    }

    public long m10047e() {
        Event b = m9978b(false);
        return b == null ? 0 : b.getOccurredAt();
    }

    public long m10051f() {
        Event d = m10044d(0);
        return d == null ? Long.MAX_VALUE : d.getOccurredAt();
    }

    public Event m10037c(long j) {
        Event event = null;
        for (Event event2 : this.f6974p) {
            Event event22;
            if (event22.getOccurredAt() >= j || !DutyStatus.m4387b(event22.getEventType())) {
                if (event22.getOccurredAt() >= j) {
                    break;
                }
                event22 = event;
            }
            event = event22;
        }
        return event;
    }

    public Event m10004a(Event event) {
        Event event2 = null;
        for (Event event3 : this.f6974p) {
            if (DutyStatus.m4387b(event3.getEventType())) {
                if (C1144s.f3800a.compare(event3, event) >= 0) {
                    break;
                }
                event2 = event3;
            }
        }
        return event2;
    }

    public Event m10044d(long j) {
        for (Event event : this.f6974p) {
            if (event.getOccurredAt() > j && DutyStatus.m4387b(event.getEventType())) {
                return event;
            }
        }
        return null;
    }

    public Event m10001a(long j, long j2, MalfunctionReason malfunctionReason) {
        return m10002a(j, j2, malfunctionReason, 0, 0);
    }

    public Event m10002a(long j, long j2, MalfunctionReason malfunctionReason, long j3, long j4) {
        for (Event event : this.f6974p) {
            if ((event.getContextualData() & j4) == j3 && event.getPersonId() == j2) {
                long occurredAt = event.getOccurredAt();
                Long a;
                long longValue;
                if (event.getEventType() == 13) {
                    a = C1099k.m5447a(event.getContextualData());
                    if (a != null) {
                        longValue = a.longValue();
                    }
                    longValue = occurredAt;
                } else {
                    if (event.getEventType() == 11) {
                        a = C1100l.m5450b(event.getContextualData());
                        if (a != null) {
                            longValue = a.longValue();
                        }
                    }
                    longValue = occurredAt;
                }
                if (j >= occurredAt && j <= r2 && EventType.m13979a(event.getEventType()) == malfunctionReason.m8431a() && Objects.equal(event.getEventSubtype(), malfunctionReason.m8432b())) {
                    return event;
                }
            }
        }
        return null;
    }

    public Map<MalfunctionReason, Long> m10049e(long j) {
        Map hashMap = new HashMap();
        Set hashSet = new HashSet();
        for (MalfunctionReason a : MalfunctionReason.values()) {
            hashSet.add(a.m8431a());
        }
        for (Event event : this.f6974p) {
            if (event.getTruckId() == j && hashSet.contains(EventType.m13979a(event.getEventType()))) {
                MalfunctionReason[] values = MalfunctionReason.values();
                int length = values.length;
                int i = 0;
                while (i < length) {
                    MalfunctionReason malfunctionReason = values[i];
                    if (EventType.m13979a(event.getEventType()) == malfunctionReason.m8431a() && Objects.equal(event.getEventSubtype(), malfunctionReason.m8432b())) {
                        long occurredAt = event.getOccurredAt();
                        Long a2;
                        if (event.getEventType() == 13) {
                            long longValue;
                            a2 = C1099k.m5447a(event.getContextualData());
                            if (a2 != null) {
                                longValue = a2.longValue();
                            } else {
                                longValue = occurredAt;
                            }
                            occurredAt = longValue;
                        } else if (event.getEventType() == 11) {
                            a2 = C1100l.m5450b(event.getContextualData());
                            if (a2 != null) {
                                occurredAt = a2.longValue();
                            }
                        }
                        hashMap.put(malfunctionReason, Long.valueOf(occurredAt));
                    } else {
                        i++;
                    }
                }
            }
        }
        return hashMap;
    }

    private void m9996w() {
        this.f6973o = null;
        this.f6974p = new ArrayList();
        this.f6964f.m8804p();
        m9976a(m10060j() != DutyStatus.OFF_DUTY);
    }

    public void m10012a(ChangeListener changeListener) {
        m10013a(changeListener, Priority.DEFAULT);
    }

    public void m10013a(ChangeListener changeListener, Priority priority) {
        this.f6972n.m4159a(changeListener, priority.ordinal());
    }

    public void m10029b(ChangeListener changeListener) {
        this.f6972n.m4158a((Object) changeListener);
    }

    private void m9976a(final boolean z) {
        Event d = m10044d(this.f6968j.mo914b());
        if (d != null) {
            C1257b.m6610a(this.f6967i, 1, d.getOccurredAt(), PendingIntent.getBroadcast(this.f6961c, 0, this.f6976r, 134217728));
        } else {
            PendingIntent broadcast = PendingIntent.getBroadcast(this.f6961c, 0, this.f6976r, 536870912);
            if (broadcast != null) {
                this.f6967i.cancel(broadcast);
                broadcast.cancel();
            }
        }
        this.f6972n.m4157a(new C0837a<ChangeListener>(this) {
            final /* synthetic */ EventManager f6934b;

            public void m9948a(ChangeListener changeListener) {
                changeListener.mo884a(this.f6934b, z);
            }
        });
    }

    private void m9997x() {
        this.f6972n.m4157a(new C20102(this));
    }

    private void m9972a(final C1142r c1142r) {
        this.f6972n.m4157a(new C0837a<ChangeListener>(this) {
            final /* synthetic */ EventManager f6938b;

            public void m9954a(ChangeListener changeListener) {
                changeListener.mo883a(c1142r);
            }
        });
    }

    private void m9998y() {
        this.f6972n.m4157a(new C20124(this));
    }

    public void m10016a(C3642c c3642c, C3642c c3642c2) {
        if (!c3642c.equals(this.f6973o)) {
            try {
                boolean z;
                EventList parseFrom = EventList.parseFrom(c3642c2);
                DutyStatus j = m10060j();
                this.f6973o = c3642c;
                this.f6974p = new ArrayList(parseFrom.getEventList());
                this.f6983y.m10104a(this.f6974p);
                Collections.sort(this.f6974p, C1144s.f3800a);
                this.f6964f.m8775e(parseFrom.getEventList());
                if (m10060j() != j) {
                    z = true;
                } else {
                    z = false;
                }
                m9976a(z);
            } catch (InvalidProtocolBufferException e) {
                C2134e.m10682e("TT-EventManager", "Can't parse event list: " + e);
            }
        }
    }

    public void m10017a(List<Event> list) {
        DutyStatus j = m10060j();
        this.f6974p = new ArrayList(list);
        this.f6973o = null;
        Collections.sort(this.f6974p, C1144s.f3800a);
        this.f6964f.m8775e((List) list);
        m9976a(m10060j() != j);
    }

    public Event m10054g() {
        return m9978b(false);
    }

    public Event m10056h() {
        return m9978b(true);
    }

    private Event m9978b(boolean z) {
        long b = z ? this.f6968j.mo914b() : Long.MAX_VALUE;
        for (Event event : C0831a.m4105a(this.f6974p)) {
            if (event.getOccurredAt() <= b && DutyStatus.m4387b(event.getEventType())) {
                return event;
            }
        }
        return null;
    }

    public boolean m10059i() {
        return m10047e() > this.f6968j.mo914b();
    }

    public DutyStatus m10060j() {
        Event h = m10056h();
        return h == null ? DutyStatus.OFF_DUTY : DutyStatus.m4383a(h.getEventType());
    }

    private Truck m9999z() {
        long b = this.f6968j.mo914b();
        for (Event event : C0831a.m4105a(this.f6974p)) {
            if (event.getOccurredAt() <= b && (event.getEventType() == 5 || event.getEventType() == 23)) {
                return this.f6965g.m6552a(event.getTruckId());
            }
        }
        return null;
    }

    public boolean m10019a(DutyStatus dutyStatus, EventSource eventSource, long j) {
        if (dutyStatus == null) {
            return false;
        }
        Event b;
        C1142r c1142r = new C1142r();
        Event b2 = m9978b(true);
        Truck f = this.f6965g.m6578f();
        Object obj = null;
        Object obj2 = null;
        if (b2 != null) {
            obj = b2.getEventType() == dutyStatus.m4394b() ? 1 : null;
            obj2 = ((f != null || b2.hasTruckId()) && (f == null || b2.getTruckId() != f.getTruckId())) ? null : 1;
        }
        long a = DutyStatusChangeBits.m4036a(Long.valueOf(j), dutyStatus.m4392a());
        if (obj == null || r0 == null) {
            if (this.f6962d.mo1317y().m6196b()) {
                a = DutyStatusChangeBits.m4038b(Long.valueOf(a));
            }
            b = C2022a.m10096b(dutyStatus.m4392a(), this.f6962d.mo1314v().mo914b(), this.f6962d.mo1295c().m12202d(), Long.valueOf(this.f6962d.mo1300h().m6580g()), this.f6962d.mo1304l().m10605e(), a, this.f6962d);
            c1142r.m5747a(b, null);
        } else {
            b = null;
        }
        if (b == null) {
            return false;
        }
        m10028b(c1142r, b.getOccurredAt());
        return true;
    }

    public Event m10003a(long j, long j2, VehicleIdentification vehicleIdentification) {
        List<Event> arrayList = new ArrayList(this.f6974p);
        arrayList.addAll(this.f6978t.values());
        Collections.sort(arrayList, C1144s.f3800a);
        for (Event event : arrayList) {
            if (event.getOccurredAt() > j2) {
                break;
            }
            EventType a = EventType.m13979a(event.getEventType());
            if (event.getOccurredAt() == j2 && DrivingTask.f8223a.contains(a)) {
                if ((!DutyStatus.m4390b(a) || event.getImmutableDutySegment()) && event.hasTruckId() && vehicleIdentification.hasTruckId() && event.getTruckId() == vehicleIdentification.getTruckId() && event.getPersonId() == j) {
                    return event;
                }
            }
        }
        return null;
    }

    public boolean m10033b(Event event) {
        long occurredAt = event.getOccurredAt();
        List<Event> arrayList = new ArrayList(this.f6974p);
        arrayList.addAll(this.f6978t.values());
        Collections.sort(arrayList, C1144s.f3800a);
        for (Event event2 : arrayList) {
            if (event2.getOccurredAt() > occurredAt) {
                break;
            } else if (event2.getOccurredAt() == occurredAt && event2.getPersonId() == event.getPersonId() && event2.getTruckId() == event.getTruckId() && event2.getEventType() == event.getEventType() && event2.getEventSubtype().equals(event.getEventSubtype())) {
                return true;
            }
        }
        return false;
    }

    public boolean m10024a(EobrDevice eobrDevice, Event event, C2018a c2018a) {
        if (event.hasVarPosition()) {
            try {
                eobrDevice.m8988a(EobrEventLogData.m5241a(event), this.f6960a);
                this.f6977s.put(event.getEventId(), new C2019b(event, c2018a));
                return true;
            } catch (IOException e) {
                C2134e.m10680d("TT-EventManager", "Unable to write event to VAR: " + C2297q.m11245a(event));
                return false;
            }
        }
        throw new IllegalArgumentException("EOBR events must have a VAR position");
    }

    void m10040c(Event event) {
        this.f6962d.mo1302j().m8476a(event);
        if (event.getPersonId() == this.f6963e.m12202d()) {
            C1142r c1142r = new C1142r();
            c1142r.m5747a(event, null);
            DailyLog b = this.f6962d.mo1302j().m8480b(DailyLogUtils.m4283a(event.getOccurredAt()));
            if (b != null && DutyStatus.m4389b(event) && C2292l.m11231a(b)) {
                C2292l.m11227a(b, false, this.f6962d);
            }
            m10028b(c1142r, event.getOccurredAt());
        } else if (this.f6962d.mo1299g().m11017c(event.getPersonId())) {
            m9991j(event);
        }
    }

    public boolean m10023a(EobrDevice eobrDevice, DutyStatus dutyStatus, boolean z) {
        return m10022a(eobrDevice, dutyStatus, null, null, z);
    }

    public boolean m10021a(EobrDevice eobrDevice, DutyStatus dutyStatus, String str, String str2) {
        return m10022a(eobrDevice, dutyStatus, str, str2, false);
    }

    public boolean m10022a(EobrDevice eobrDevice, DutyStatus dutyStatus, String str, String str2, boolean z) {
        if (dutyStatus == null) {
            return false;
        }
        C2803a a = VarDutyStatusChange.newBuilder().m15805a(dutyStatus.m4394b()).m15809a(z);
        if (str != null) {
            a.m15808a(str);
        }
        if (str2 != null) {
            a.m15811b(str2);
        }
        eobrDevice.m8990b(ExternalVarEntry.newBuilder().m13994a(ExternalVarEntryType.DUTY_STATUS_CHANGE).m13995a(a.m15813c()).m14000c().toByteArray(), this.f6960a);
        return true;
    }

    C2019b m10000a(C3642c c3642c) {
        return (C2019b) this.f6977s.remove(c3642c);
    }

    public boolean m10035b(byte[] bArr) {
        return this.f6977s.containsKey(C3642c.m19078a(bArr));
    }

    boolean m10034b(C3642c c3642c) {
        return this.f6977s.containsKey(c3642c);
    }

    public void m10046d(Event event) {
        if (event != null && !m10033b(event)) {
            m10014a(event, null);
        }
    }

    public void m10050e(Event event) {
        m10014a(event, null);
    }

    public void m10030b(List<Event> list) {
        for (Event e : list) {
            m10050e(e);
        }
    }

    public void m10014a(Event event, List<byte[]> list) {
        if (event != null) {
            m10028b(new C1142r().m5747a(event, list), event.getOccurredAt());
        }
    }

    public void m10011a(C1142r c1142r, long j) {
        m9973a(c1142r, j, false);
    }

    public void m10028b(C1142r c1142r, long j) {
        m9973a(c1142r, j, true);
    }

    private void m9973a(C1142r c1142r, long j, boolean z) {
        DutyStatus j2 = m10060j();
        if (c1142r.m5750a(this.f6958D)) {
            Collections.sort(this.f6974p, C1144s.f3800a);
            boolean z2 = m10060j() != j2;
            C1142r g = m9987g(j - 1);
            if (g.m5750a(this.f6958D)) {
                Collections.sort(this.f6974p, C1144s.f3800a);
            }
            g = new C1142r().m5745a(c1142r).m5745a(g);
            if (g.m5749a()) {
                this.f6964f.m8727a(g);
                this.f6973o = null;
                m9976a(z2);
            }
            if (z) {
                this.f6962d.mo1298f().m6459a(g);
                m9972a(g);
            }
        }
    }

    private C1142r m9987g(long j) {
        List<C0946a> a = new C0947t(this.f6963e.m12229s()).m4810a(this.f6962d.mo1302j().m8493g(), this.f6974p, j);
        C1142r c1142r = new C1142r();
        for (C0946a c0946a : a) {
            for (Event newBuilder : c0946a.m4806d()) {
                C2647a newBuilder2 = Event.newBuilder(newBuilder);
                if (c0946a.m4805c()) {
                    newBuilder2.m13865d(c0946a.m4803a()).m13870e(c0946a.m4804b());
                } else {
                    newBuilder2.m13903x().m13904y();
                }
                c1142r.m5746a(newBuilder2.m13862c());
            }
        }
        return c1142r;
    }

    public C1101m m10061k() {
        return new C1146u(m10025b());
    }

    public boolean m10031b(DutyStatus dutyStatus, EventSource eventSource, long j) {
        if (!m10019a(dutyStatus, eventSource, j)) {
            return false;
        }
        this.f6962d.mo1293a().m8294a(dutyStatus, "Auto-" + eventSource);
        return true;
    }

    private void m9991j(Event event) {
        this.f6962d.mo1298f().m6496c(event);
        this.f6964f.m8760b(event);
        EobrDevice j = this.f6966h.m11412j();
        if (j != null) {
            if (event.getPersonId() == this.f6962d.mo1299g().m11020f().longValue() && C2022a.m10092a(event, j) && !this.f6978t.containsKey(event.getEventId())) {
                C2134e.m10676b("TT-EventManager", "Adding unclaimed event: " + C1144s.m5763c(event));
                this.f6978t.put(event.getEventId(), event);
                m9969A();
                m9970B();
                m9997x();
            }
        }
    }

    private void m9969A() {
        this.f6980v = m9981c(true);
        m9998y();
    }

    private void m9970B() {
        Long b = C2307z.m11277b(this.f6965g.m6578f(), this.f6969k.m11013b());
        List arrayList = new ArrayList(this.f6978t.size());
        for (Event event : this.f6978t.values()) {
            if (m9977a(event, b) && DutyStatus.m4389b(event)) {
                if (!DutyStatus.m4384a(event).m4397e() || event.getMinDuration() > 0) {
                    arrayList.add(event);
                }
            }
        }
        Collections.sort(arrayList, C1144s.f3800a);
        this.f6979u.clear();
        for (Integer intValue : m9981c(false)) {
            int intValue2 = intValue.intValue();
            DailyLog f = this.f6962d.mo1302j().m8491f(intValue2);
            if (f != null) {
                List a = new C0886a(arrayList, intValue2, DailyLogUtils.m4305b(f)).m4478a(false).m4479a(this.f6968j.mo914b());
                Iterator it = a.iterator();
                while (it.hasNext()) {
                    if (!((C0890f) it.next()).m4531z()) {
                        it.remove();
                    }
                }
                this.f6979u.put(Integer.valueOf(intValue2), a);
            }
        }
    }

    private List<Integer> m9981c(boolean z) {
        List<Integer> arrayList = new ArrayList();
        List g = this.f6962d.mo1302j().m8493g();
        Long b = C2307z.m11277b(this.f6965g.m6578f(), this.f6969k.m11013b());
        if (b == null) {
            return Collections.emptyList();
        }
        for (Event event : this.f6978t.values()) {
            if (m9980b(event, b)) {
                boolean contains = this.f6981w.contains(event.getEventId());
                Object obj = m10043d(event.getEventId()) != ClaimState.UNKNOWN ? 1 : null;
                if (!z || (obj == null && !contains)) {
                    C0907o a = DailyLogUtils.m4294a(g, event.getOccurredAt(), this.f6963e.m12229s());
                    if (!arrayList.contains(Integer.valueOf(a.a_()))) {
                        arrayList.add(Integer.valueOf(a.a_()));
                    }
                }
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static boolean m9977a(Event event, Long l) {
        return l != null && event.getOccurredAt() >= l.longValue();
    }

    private static boolean m9980b(Event event, Long l) {
        boolean c = DutyStatus.m4391c(event);
        boolean z;
        if (event.getMinDuration() <= 0) {
            z = true;
        } else {
            z = false;
        }
        if (m9977a(event, l) && c && !r0) {
            return true;
        }
        return false;
    }

    public Map<Integer, List<C0890f>> m10062l() {
        return this.f6979u;
    }

    public List<C0890f> m10026b(int i) {
        if (this.f6979u.containsKey(Integer.valueOf(i))) {
            return new ArrayList((Collection) this.f6979u.get(Integer.valueOf(i)));
        }
        return Collections.emptyList();
    }

    public Event m10038c(C3642c c3642c) {
        return (Event) this.f6978t.get(c3642c);
    }

    public Event m10052f(long j) {
        for (Event event : this.f6978t.values()) {
            if (event.getOccurredAt() == j && event.getEventType() == 6) {
                return event;
            }
        }
        return null;
    }

    public long m10036c(int i) {
        long j = 0;
        for (C0890f c0890f : m10026b(i)) {
            long i2;
            if (m10020a(c0890f)) {
                i2 = c0890f.m4514i() + j;
            } else {
                i2 = j;
            }
            j = i2;
        }
        return j;
    }

    public int m10042d(int i) {
        int i2 = 0;
        for (C0890f a : m10026b(i)) {
            int i3;
            if (m10020a(a)) {
                i3 = i2 + 1;
            } else {
                i3 = i2;
            }
            i2 = i3;
        }
        return i2;
    }

    public boolean m10020a(C0890f c0890f) {
        return m10043d(c0890f.m4519n().getEventId()) == ClaimState.UNKNOWN && !m10041c(c0890f) && c0890f.m4531z();
    }

    public long m10063m() {
        long j = 0;
        for (Integer intValue : this.f6979u.keySet()) {
            j = m10036c(intValue.intValue()) + j;
        }
        return j;
    }

    public long m10048e(int i) {
        long j = 0;
        for (C0890f c0890f : m10026b(i)) {
            long distanceMeters;
            if (m10020a(c0890f)) {
                distanceMeters = c0890f.m4519n().getDistanceMeters() + j;
            } else {
                distanceMeters = j;
            }
            j = distanceMeters;
        }
        return j;
    }

    public boolean m10032b(C0890f c0890f) {
        if (c0890f.m4519n().getMinDuration() <= 0) {
            return false;
        }
        ao alVar = new al(c0890f.mo721a(), c0890f.mo721a() + c0890f.m4514i());
        for (Event event : this.f6974p) {
            if (!event.getEventId().equals(c0890f.m4519n().getEventId()) && event.getImmutableDutySegment()) {
                ao alVar2 = new al(event.getOccurredAt(), event.getOccurredAt() + event.getMinDuration());
                if (alVar.mo693b(alVar2) || alVar.mo691a(alVar2) || alVar2.mo691a(alVar)) {
                    return false;
                }
                if (alVar2.mo695d(alVar)) {
                    break;
                }
            }
        }
        return true;
    }

    public boolean m10064n() {
        return C2307z.m11276a(this.f6965g.m6578f(), this.f6969k.m11013b());
    }

    public List<C0890f> m10010a(DailyLog dailyLog) {
        return m10008a(dailyLog.getLogDay(), DailyLogUtils.m4305b(dailyLog), C2292l.m11231a(dailyLog));
    }

    public List<C0890f> m10008a(int i, TimeZone timeZone, boolean z) {
        return new C0886a(m10061k(), i, timeZone).m4478a(z).m4479a(this.f6968j.mo914b());
    }

    public List<Integer> m10065o() {
        return new ArrayList(this.f6980v);
    }

    public void m10018a(List<Event> list, Iterable<C1142r> iterable) {
        if (!list.isEmpty()) {
            C2134e.m10676b("TT-EventManager", "Claiming unassigned events: ");
            for (Event event : list) {
                C2134e.m10676b("TT-EventManager", C1144s.m5763c(event));
                this.f6964f.m8747a(event.getEventId().m19091d(), RecordStatus.INACTIVE_CHANGED);
                this.f6962d.mo1302j().m8476a(event);
            }
            m9994u();
            long occurredAt = ((Event) list.get(0)).getOccurredAt();
            Iterable arrayList = new ArrayList();
            for (C1142r c1142r : iterable) {
                arrayList.addAll(c1142r.m5754d());
                m10028b(c1142r, occurredAt);
            }
            this.f6962d.mo1298f().m6481a((Iterable) list, arrayList);
        }
    }

    public void m10053f(Event event) {
        C2134e.m10676b("TT-EventManager", "Ignoring event: " + C1144s.m5763c(event));
        this.f6981w.add(event.getEventId());
        this.f6964f.m8765c(event.getEventId().m19091d());
        m9969A();
    }

    public ClaimState m10043d(C3642c c3642c) {
        if (this.f6981w.contains(c3642c)) {
            return ClaimState.IGNORED;
        }
        ClaimState claimState = ClaimState.UNKNOWN;
        if (this.f6978t.containsKey(c3642c)) {
            long statusMask = ((Event) this.f6978t.get(c3642c)).getStatusMask();
            if (EventStatusMaskBits.m4077a(statusMask) == RecordStatus.INACTIVE_CHANGED && EventStatusMaskBits.m4081b(statusMask) == RecordOrigin.AUTOMATICALLY_RECORDED) {
                return ClaimState.CLAIMED;
            }
        }
        return claimState;
    }

    public boolean m10041c(C0890f c0890f) {
        Long f = this.f6962d.mo1299g().m11020f();
        return f == null || c0890f.m4505a(f.longValue());
    }

    public void m10015a(C3642c c3642c, Event event) {
        Event a;
        if (event.getPersonId() != this.f6963e.m12202d()) {
            a = C2022a.m10072a(this.f6965g, (Event) this.f6978t.get(c3642c), event);
            if (a != null) {
                this.f6978t.put(c3642c, a);
                this.f6964f.m8760b(a);
                m9969A();
                m9970B();
                m9997x();
            }
        } else {
            ListIterator listIterator = this.f6974p.listIterator();
            while (listIterator.hasNext()) {
                a = (Event) listIterator.next();
                if (a.getEventId().equals(c3642c)) {
                    a = C2022a.m10072a(this.f6965g, a, event);
                    if (a != null) {
                        listIterator.set(a);
                        this.f6962d.mo1302j().m8476a(event);
                    }
                }
            }
            a = null;
        }
        this.f6962d.mo1298f().m6479a(c3642c, event.getEventId());
        m10055g(a);
    }

    void m10066p() {
        m10055g(this.f6983y.m10109b(this.f6974p));
    }

    public void m10055g(Event event) {
        for (Event eventId : this.f6983y.m10105a(this.f6974p, event)) {
            this.f6964f.m8746a(eventId.getEventId().m19091d());
        }
    }

    public boolean m10057h(Event event) {
        Event event2 = null;
        DutyStatus j = m10060j();
        Event event3 = (Event) this.f6978t.get(event.getEventId());
        if (event3 != null) {
            event3 = C2022a.m10083a(event3, event);
            if (event3 == null) {
                return false;
            }
            this.f6978t.put(event.getEventId(), event3);
            this.f6964f.m8760b(event3);
            event2 = event3;
        } else {
            ListIterator listIterator = this.f6974p.listIterator();
            while (listIterator.hasNext()) {
                event3 = (Event) listIterator.next();
                if (event3.getEventId().equals(event.getEventId())) {
                    event3 = C2022a.m10083a(event3, event);
                    if (event3 == null) {
                        return false;
                    }
                    this.f6973o = null;
                    listIterator.set(event3);
                    Collections.sort(this.f6974p, C1144s.f3800a);
                    this.f6964f.m8735a(event3);
                    event2 = event3;
                }
            }
        }
        if (event2 == null) {
            C2134e.m10682e("TT-EventManager", "EventManager: unable to coalesce event changes with event=" + C2297q.m11245a(event) + " (not found)");
            return false;
        }
        boolean z;
        if (m10060j() != j) {
            z = true;
        } else {
            z = false;
        }
        m9976a(z);
        this.f6962d.mo1298f().m6492b(event2);
        return true;
    }

    public C2021d m10067q() {
        return this.f6982x;
    }

    public void m10058i(Event event) {
        C2134e.m10678c("TT-EobrLoginLogout", "Speculating logout of session " + event.getContextualData());
        C1783u a = C1783u.m8645a(event);
        this.f6975q.add(a);
        this.f6964f.m8754b(a);
    }

    public void m10068r() {
        Collection arrayList = new ArrayList();
        for (C1783u c1783u : this.f6975q) {
            Event e = c1783u.m8649e();
            if (e == null) {
                this.f6964f.m8731a(c1783u);
                arrayList.add(c1783u);
            } else if (e.getEventType() == 28) {
                C2134e.m10678c("TT-EobrLoginLogout", "Actualizing logout of session " + e.getContextualData());
                if (e.getPersonId() == OurApplication.m6285g().m12202d() && !m10033b(e)) {
                    this.f6964f.m8735a(e);
                    this.f6974p.add(e);
                    Collections.sort(this.f6974p, C1144s.f3800a);
                    m9976a(false);
                }
                OurApplication.m6289k().m6464a(c1783u);
                this.f6964f.m8731a(c1783u);
                arrayList.add(c1783u);
            }
        }
        this.f6975q.removeAll(arrayList);
    }

    public void m10069s() {
        Collection arrayList = new ArrayList();
        for (C1783u c1783u : this.f6975q) {
            Event e = c1783u.m8649e();
            if (e.getEventType() == 28) {
                C2134e.m10678c("TT-EobrLoginLogout", "Disregarding logout of session " + e.getContextualData());
                this.f6964f.m8731a(c1783u);
                arrayList.add(c1783u);
            }
        }
        this.f6975q.removeAll(arrayList);
    }
}
