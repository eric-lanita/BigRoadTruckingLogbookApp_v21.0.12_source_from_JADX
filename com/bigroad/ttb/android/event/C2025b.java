package com.bigroad.ttb.android.event;

import android.os.Handler;
import com.bigroad.shared.C1142r;
import com.bigroad.shared.C1144s;
import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.shared.model.CanonicalMalfunctionType;
import com.bigroad.ttb.android.C2032f;
import com.bigroad.ttb.android.C2474y;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.bn;
import com.google.common.collect.Range;
import com.google.protobuf.C3642c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map.Entry;

class C2025b {
    private final Handler f6993a = new Handler();
    private final C2032f f6994b;
    private final C2474y f6995c;
    private C2024a f6996d;
    private HashMap<C3642c, Long> f6997e = new HashMap();
    private final Runnable f6998f = new C20231(this);

    class C20231 implements Runnable {
        final /* synthetic */ C2025b f6988a;

        C20231(C2025b c2025b) {
            this.f6988a = c2025b;
        }

        public void run() {
            this.f6988a.m10106a();
        }
    }

    private static class C2024a {
        private final long f6989a;
        private final C3642c f6990b;
        private final long f6991c;
        private final long f6992d;

        public C2024a(long j, C3642c c3642c, long j2, long j3) {
            this.f6989a = j;
            this.f6990b = c3642c;
            this.f6991c = j2;
            this.f6992d = j3;
        }

        public boolean m10098a(C2024a c2024a) {
            if (c2024a == null) {
                return true;
            }
            if (c2024a.m10097a() != this.f6989a) {
                return false;
            }
            if (!c2024a.m10099b().equals(this.f6990b)) {
                return false;
            }
            if (this.f6991c < c2024a.m10100c() || this.f6992d < c2024a.m10101d()) {
                return false;
            }
            return true;
        }

        public long m10097a() {
            return this.f6989a;
        }

        public C3642c m10099b() {
            return this.f6990b;
        }

        public long m10100c() {
            return this.f6991c;
        }

        public long m10101d() {
            return this.f6992d;
        }
    }

    C2025b(C2032f c2032f) {
        this.f6994b = c2032f;
        this.f6995c = this.f6994b.mo1295c();
    }

    private void m10103b() {
        if (this.f6996d == null && this.f6997e.isEmpty()) {
            this.f6993a.postDelayed(this.f6998f, 600000);
        }
    }

    public void m10106a() {
        this.f6993a.removeCallbacks(this.f6998f);
        long d = this.f6995c.m12202d();
        if (!this.f6997e.isEmpty()) {
            C1142r c1142r = new C1142r();
            long j = Long.MAX_VALUE;
            for (Entry entry : this.f6997e.entrySet()) {
                long j2;
                Event a = this.f6994b.mo1301i().m10005a(((C3642c) entry.getKey()).m19091d());
                if (a == null || !CanonicalMalfunctionType.m5453a(a.getEventType(), a.getEventSubtype())) {
                    j2 = j;
                } else {
                    Event c = Event.newBuilder(a).m13879g(((Long) entry.getValue()).longValue()).m13862c();
                    c1142r.m5746a(c);
                    j2 = Math.min(j, c.getOccurredAt());
                }
                j = j2;
            }
            this.f6997e.clear();
            if (!c1142r.m5753c()) {
                this.f6994b.mo1301i().m10028b(c1142r, j);
            }
        }
        if (this.f6996d != null) {
            if (d == this.f6996d.m10097a()) {
                this.f6994b.mo1298f().m6477a(this.f6996d.m10099b(), this.f6996d.m10100c(), this.f6996d.m10101d());
                this.f6994b.mo1301i().m10066p();
            } else {
                C2134e.m10680d("TT-EventSyncState", "Discarding pending update for personId=" + this.f6996d.m10097a());
            }
            this.f6996d = null;
        }
    }

    public void m10108a(C3642c c3642c, long j, long j2, long j3) {
        C2024a c2024a = new C2024a(j, c3642c, j2, j3);
        if (!c2024a.m10098a(this.f6996d)) {
            m10106a();
        }
        m10103b();
        this.f6996d = c2024a;
    }

    public void m10107a(C3642c c3642c, long j) {
        m10103b();
        this.f6997e.put(c3642c, Long.valueOf(j));
    }

    public List<Event> m10104a(List<Event> list) {
        return m10102b(list, m10109b(list));
    }

    public List<Event> m10105a(List<Event> list, Event event) {
        return m10102b(list, event);
    }

    public Event m10109b(List<Event> list) {
        Event c;
        Object obj = null;
        if (!this.f6997e.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                Long l = (Long) this.f6997e.get(((Event) list.get(i)).getEventId());
                if (l != null) {
                    list.set(i, Event.newBuilder((Event) list.get(i)).m13879g(l.longValue()).m13862c());
                }
            }
        }
        if (this.f6996d != null) {
            if (this.f6996d.m10097a() != this.f6995c.m12202d()) {
                return null;
            }
            int i2 = 0;
            while (i2 < list.size()) {
                if (((Event) list.get(i2)).getEventId().equals(this.f6996d.m10099b())) {
                    obj = 1;
                    break;
                }
                i2++;
            }
            i2 = -1;
            if (obj == null) {
                C2134e.m10680d("TT-EventSyncState", "Could not find event to apply pending update.");
                return null;
            }
            c = Event.newBuilder((Event) list.get(i2)).m13875f(this.f6996d.m10100c()).m13882h(this.f6996d.m10101d()).m13862c();
            list.set(i2, c);
        } else {
            c = null;
        }
        return c;
    }

    private List<Event> m10102b(List<Event> list, Event event) {
        ArrayList arrayList = new ArrayList();
        if (event == null) {
            return arrayList;
        }
        Range a = C1144s.m5758a((bn) event);
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            Event event2 = (Event) listIterator.next();
            if (!event2.getImmutableDutySegment() && DutyStatus.m4389b(event2) && a.m18695a(Long.valueOf(event2.getOccurredAt()))) {
                listIterator.remove();
                arrayList.add(event2);
            }
        }
        return arrayList;
    }
}
