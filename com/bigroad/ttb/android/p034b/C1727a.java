package com.bigroad.ttb.android.p034b;

import com.bigroad.shared.C1142r;
import com.bigroad.shared.C1142r.C1135c;
import com.bigroad.shared.C1142r.C1137a;
import com.bigroad.shared.C1146u;
import com.bigroad.shared.C1180y;
import com.bigroad.shared.EventStatusMaskBits.RecordOrigin;
import com.bigroad.shared.ap;
import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.shared.duty.C0890f.C0886a;
import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.shared.p022b.C0848a;
import com.bigroad.ttb.android.C2032f;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.p029c.C1738c;
import com.bigroad.ttb.android.util.C2292l;
import com.bigroad.ttb.android.util.C2297q;
import com.bigroad.ttb.protocol.TTProtocol.Correction;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import com.bigroad.ttb.protocol.TTProtocol.Delta;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.EventType;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Range;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

public class C1727a {
    private final C2032f f5985a;
    private final ap f5986b = this.f5985a.mo1314v();
    private List<DailyLog> f5987c;
    private List<Event> f5988d;
    private List<Event> f5989e;
    private C1135c f5990f;

    public C1727a(C2032f c2032f, List<DailyLog> list, List<Event> list2) {
        this.f5985a = c2032f;
        this.f5987c = new ArrayList(list);
        this.f5988d = ImmutableList.m18511a((Collection) list2);
        this.f5989e = new ArrayList(list2);
        this.f5990f = new C1137a(this.f5989e);
    }

    public List<DailyLog> m8442a() {
        return this.f5987c;
    }

    public List<Event> m8444b() {
        return this.f5989e;
    }

    private DailyLog m8434a(int i) {
        for (DailyLog dailyLog : this.f5987c) {
            if (dailyLog.getLogDay() == i) {
                return dailyLog;
            }
        }
        return null;
    }

    private void m8440a(DailyLog dailyLog) {
        if (dailyLog != null) {
            Iterator it = this.f5987c.iterator();
            while (it.hasNext()) {
                if (((DailyLog) it.next()).getLogDay() == dailyLog.getLogDay()) {
                    it.remove();
                    break;
                }
            }
            this.f5987c.add(dailyLog);
        }
    }

    public boolean m8443a(Correction correction, Delta delta) {
        C2134e.m10678c("TT-DeltaApplicator", "Applying delta {" + C1180y.m5990a(delta.toByteArray()) + "}");
        Range a = C0848a.m4261a(delta);
        if (((Integer) a.m18700e()).intValue() - ((Integer) a.m18698c()).intValue() > 0) {
            C2134e.m10680d("TT-DeltaApplicator", "Attempt to apply delta that spans multiple days?");
        }
        int intValue = ((Integer) a.m18698c()).intValue();
        int intValue2 = ((Integer) a.m18700e()).intValue();
        for (int i = intValue; i <= intValue2; i++) {
            DailyLog a2 = m8434a(i);
            if (a2 == null) {
                return false;
            }
            a2 = m8436a(m8435a(correction, a2), delta);
            if (a2 == null) {
                return false;
            }
            m8440a(a2);
            if (!m8441b(correction, delta)) {
                return false;
            }
        }
        return true;
    }

    private DailyLog m8436a(DailyLog dailyLog, Delta delta) {
        int a = C0848a.m4256a(delta, dailyLog.getLogDay());
        if (a == -1) {
            return dailyLog;
        }
        DailyLog a2 = C0848a.m4259a(delta.getDailyLogChanges(a), dailyLog);
        if (a2 == null) {
            C2134e.m10680d("TT-DeltaApplicator", "Incompatible log day change detected: current [" + C2297q.m11245a(dailyLog) + "], entry [" + C2297q.m11245a(delta.getDailyLogChanges(a)) + "]");
        }
        return a2;
    }

    private boolean m8441b(Correction correction, Delta delta) {
        if (delta.getEventChangesCount() == 0) {
            return true;
        }
        if (C1728b.m8445a(this.f5989e, delta)) {
            C2134e.m10680d("TT-DeltaApplicator", "Incompatible event stream detected");
            return false;
        }
        EventType eventType;
        EventType eventType2;
        long timeInMillis = DailyLogUtils.m4304b(delta.getEndLogDay(), TimeZone.getTimeZone(m8434a(delta.getEndLogDay()).getTimezoneId())).getTimeInMillis();
        Event a = C1727a.m8437a(timeInMillis, this.f5989e);
        C1142r b = C0848a.m4265b(delta);
        b.m5748a(RecordOrigin.EDIT_REQUEST);
        b.m5750a(this.f5990f);
        Event a2 = C1727a.m8437a(timeInMillis, this.f5989e);
        if (a == null) {
            eventType = EventType.OFF_DUTY;
        } else {
            eventType = EventType.m13979a(a.getEventType());
        }
        if (a2 == null) {
            eventType2 = EventType.OFF_DUTY;
        } else {
            eventType2 = EventType.m13979a(a2.getEventType());
        }
        if (eventType == eventType2) {
            return true;
        }
        m8439a(correction, m8438a(timeInMillis, delta.getEndLogDay()));
        return true;
    }

    private static Event m8437a(long j, List<Event> list) {
        Event event = null;
        for (Event event2 : list) {
            Event event22;
            if (DutyStatus.m4389b(event22)) {
                if (event22.getOccurredAt() > j) {
                    break;
                } else if (event == null) {
                    event = event22;
                } else {
                    if (event22.getOccurredAt() <= event.getOccurredAt()) {
                        event22 = event;
                    }
                    event = event22;
                }
            }
        }
        return event;
    }

    private List<DailyLog> m8438a(long j, int i) {
        Long l = null;
        List<DailyLog> arrayList = new ArrayList();
        for (Event event : this.f5989e) {
            if (event.getOccurredAt() > j - 1 && DutyStatus.m4387b(event.getEventType())) {
                break;
            }
        }
        Event event2 = null;
        if (event2 != null) {
            l = Long.valueOf(event2.getOccurredAt());
        }
        for (DailyLog dailyLog : this.f5987c) {
            if (dailyLog.getLogDay() > i) {
                if (l != null) {
                    if (l.longValue() <= C1738c.m8509a(i, dailyLog).getTimeInMillis()) {
                        break;
                    }
                }
                if (C2292l.m11231a(dailyLog)) {
                    arrayList.add(dailyLog);
                }
            }
        }
        return arrayList;
    }

    private void m8439a(Correction correction, List<DailyLog> list) {
        for (DailyLog a : list) {
            m8440a(m8435a(correction, a));
        }
    }

    private DailyLog m8435a(Correction correction, DailyLog dailyLog) {
        boolean a = C1738c.m8511a(dailyLog, new C0886a(new C1146u(this.f5989e), dailyLog.getLogDay(), TimeZone.getTimeZone(dailyLog.getTimezoneId())).m4478a(true).m4479a(this.f5986b.mo914b()));
        if (!C1738c.m8518g(dailyLog)) {
            return dailyLog;
        }
        if (a) {
            return C2292l.m11226a(dailyLog, correction.getSuggestedBy());
        }
        return C2292l.m11237d(dailyLog);
    }
}
