package com.bigroad.shared;

import com.bigroad.shared.EventStatusMaskBits.RecordOrigin;
import com.bigroad.shared.EventStatusMaskBits.RecordStatus;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.EventChangeListEntry;
import com.bigroad.ttb.protocol.TTProtocol.EventChangeType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class C1142r {
    private final List<C1138b> f3798a = new ArrayList();
    private boolean f3799b = false;

    public interface C1135c {
        boolean mo817a(Event event);

        boolean mo818a(Event event, List<byte[]> list);

        boolean mo819b(Event event);
    }

    public static class C1137a implements C1135c {
        protected List<Event> f3793a;

        public C1137a(List<Event> list) {
            this.f3793a = list;
        }

        public boolean mo818a(Event event, List<byte[]> list) {
            this.f3793a.add(event);
            return true;
        }

        public boolean mo817a(Event event) {
            mo819b(event);
            mo818a(event, null);
            return true;
        }

        public boolean mo819b(Event event) {
            Iterator it = this.f3793a.iterator();
            while (it.hasNext()) {
                if (((Event) it.next()).getEventId().equals(event.getEventId())) {
                    it.remove();
                    break;
                }
            }
            return true;
        }
    }

    private interface C1138b {
        void mo820a(RecordOrigin recordOrigin);

        boolean mo821a(C1135c c1135c);
    }

    private static class C1139d implements C1138b {
        private Event f3794a;
        private final List<byte[]> f3795b;

        private C1139d(Event event, List<byte[]> list) {
            this.f3794a = event;
            if (list == null) {
                list = Collections.emptyList();
            }
            this.f3795b = list;
        }

        public boolean mo821a(C1135c c1135c) {
            return c1135c.mo818a(this.f3794a, this.f3795b);
        }

        public void mo820a(RecordOrigin recordOrigin) {
            long statusMask;
            if (this.f3794a.hasStatusMask()) {
                statusMask = this.f3794a.getStatusMask();
            } else {
                statusMask = EventStatusMaskBits.m4075a(RecordOrigin.UNKNOWN, RecordStatus.ACTIVE);
            }
            this.f3794a = this.f3794a.toBuilder().m13886j(EventStatusMaskBits.m4071a(statusMask, recordOrigin)).m13862c();
        }
    }

    private static class C1140e implements C1138b {
        private Event f3796a;

        private C1140e(Event event) {
            this.f3796a = event;
        }

        public boolean mo821a(C1135c c1135c) {
            return c1135c.mo819b(this.f3796a);
        }

        public void mo820a(RecordOrigin recordOrigin) {
            long statusMask;
            if (this.f3796a.hasStatusMask()) {
                statusMask = this.f3796a.getStatusMask();
            } else {
                statusMask = EventStatusMaskBits.m4075a(RecordOrigin.UNKNOWN, RecordStatus.ACTIVE);
            }
            this.f3796a = this.f3796a.toBuilder().m13886j(EventStatusMaskBits.m4071a(statusMask, recordOrigin)).m13862c();
        }
    }

    private static class C1141f implements C1138b {
        private Event f3797a;

        private C1141f(Event event) {
            this.f3797a = event;
        }

        public boolean mo821a(C1135c c1135c) {
            return c1135c.mo817a(this.f3797a);
        }

        public void mo820a(RecordOrigin recordOrigin) {
            long statusMask;
            if (this.f3797a.hasStatusMask()) {
                statusMask = this.f3797a.getStatusMask();
            } else {
                statusMask = EventStatusMaskBits.m4075a(RecordOrigin.UNKNOWN, RecordStatus.ACTIVE);
            }
            this.f3797a = this.f3797a.toBuilder().m13886j(EventStatusMaskBits.m4071a(statusMask, recordOrigin)).m13862c();
        }
    }

    public boolean m5749a() {
        return this.f3799b;
    }

    public C1142r m5747a(Event event, List<byte[]> list) {
        if (event != null) {
            this.f3798a.add(new C1139d(event, list));
            this.f3799b |= C1144s.m5759a(event);
        }
        return this;
    }

    public C1142r m5746a(Event event) {
        if (event != null) {
            this.f3798a.add(new C1141f(event));
            this.f3799b |= C1144s.m5759a(event);
        }
        return this;
    }

    public C1142r m5751b(Event event) {
        if (event != null) {
            this.f3798a.add(new C1140e(event));
            this.f3799b = true;
        }
        return this;
    }

    public C1142r m5745a(C1142r c1142r) {
        this.f3798a.addAll(c1142r.f3798a);
        this.f3799b |= c1142r.m5749a();
        return this;
    }

    public void m5752b() {
        this.f3798a.clear();
    }

    public boolean m5753c() {
        return this.f3798a.isEmpty();
    }

    public void m5748a(RecordOrigin recordOrigin) {
        for (C1138b a : this.f3798a) {
            a.mo820a(recordOrigin);
        }
    }

    public boolean m5750a(C1135c c1135c) {
        boolean z = false;
        for (C1138b a : this.f3798a) {
            z = a.mo821a(c1135c) | z;
        }
        return z;
    }

    public List<EventChangeListEntry> m5754d() {
        final List<EventChangeListEntry> arrayList = new ArrayList();
        m5750a(new C1135c(this) {
            final /* synthetic */ C1142r f3792b;

            public boolean mo818a(Event event, List<byte[]> list) {
                arrayList.add(EventChangeListEntry.newBuilder().m13914a(EventChangeType.CREATE_EVENT_CHANGE).m13912a(event).m13919c());
                return true;
            }

            public boolean mo817a(Event event) {
                arrayList.add(EventChangeListEntry.newBuilder().m13914a(EventChangeType.UPDATE_EVENT_CHANGE).m13912a(event).m13919c());
                return true;
            }

            public boolean mo819b(Event event) {
                arrayList.add(EventChangeListEntry.newBuilder().m13914a(EventChangeType.DELETE_EVENT_CHANGE).m13912a(event).m13919c());
                return true;
            }
        });
        return arrayList;
    }
}
