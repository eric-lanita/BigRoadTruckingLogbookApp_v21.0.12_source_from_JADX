package com.bigroad.shared.duty;

import com.bigroad.shared.C0836a;
import com.bigroad.shared.C1144s;
import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.shared.model.C1122f;
import com.bigroad.shared.model.CanonicalMalfunctionType;
import com.bigroad.shared.p021a.C0832c;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.Event.C2647a;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.TimeZone;

public final class C0898i extends C0836a {
    private final List<C0896g> f2780a;
    private final List<C0907o> f2781b;
    private final List<Event> f2782c;
    private final List<C1122f> f2783d = new ArrayList();
    private final TimeZone f2784e;
    private final C0882q f2785f;

    public C0898i(List<C0907o> list, List<Event> list2, long j, TimeZone timeZone) {
        this.f2782c = new ArrayList(list2.size());
        for (Event event : list2) {
            if (event.getOccurredAt() < j) {
                if (DutyStatus.m4387b(event.getEventType())) {
                    if ((!event.hasCycleResetStartedAt() || event.getCycleResetStartedAt() <= j) && (!event.hasCycleResetEndedAt() || event.getCycleResetEndedAt() <= j)) {
                        this.f2782c.add(event);
                    } else {
                        C2647a newBuilder = Event.newBuilder(event);
                        newBuilder.m13903x().m13904y();
                        this.f2782c.add(newBuilder.m13862c());
                    }
                } else if (CanonicalMalfunctionType.m5453a(event.getEventType(), event.getEventSubtype())) {
                    this.f2783d.add(new C1122f(event));
                }
            }
        }
        Collections.sort(this.f2782c, C1144s.f3800a);
        Collections.sort(this.f2783d, C1122f.f3760a);
        List arrayList = new ArrayList();
        Event event2 = null;
        for (Event event3 : this.f2782c) {
            arrayList.add(new C0896g(event2, event3));
            event2 = event3;
        }
        arrayList.add(new C0896g(event2, j));
        this.f2781b = new ArrayList(list);
        Collections.sort(this.f2781b, C0907o.f2797a);
        this.f2780a = Collections.unmodifiableList(arrayList);
        this.f2784e = timeZone;
        this.f2785f = new C0882q(this.f2780a);
    }

    public List<Event> m4553b() {
        return this.f2782c;
    }

    public List<C1122f> m4555c() {
        return this.f2783d;
    }

    public TimeZone m4557d() {
        return this.f2784e;
    }

    public C0882q m4558e() {
        return this.f2785f;
    }

    public C0882q m4550a(int i, int i2) {
        return new C0882q(this.f2780a, i, i2);
    }

    public C0882q m4549a(int i) {
        return m4550a(i, i + 1);
    }

    public C0883p m4548a(long j, long j2) {
        return C0883p.m4468a(this.f2780a, j, j2);
    }

    public int m4561h() {
        return this.f2780a.size();
    }

    public boolean m4562i() {
        return this.f2780a.isEmpty();
    }

    public C0896g m4552b(int i) {
        return (C0896g) this.f2780a.get(i);
    }

    public Iterator<C0884e> m4551a(final TimeZone timeZone) {
        return new C0832c<C0884e>(this) {
            int f2776a = 0;
            Calendar f2777b = Calendar.getInstance(timeZone);
            final /* synthetic */ C0898i f2779d;

            public /* synthetic */ Object next() {
                return m4546a();
            }

            public boolean hasNext() {
                return this.f2776a < this.f2779d.f2780a.size();
            }

            public C0884e m4546a() {
                if (hasNext()) {
                    C0884e a = C0884e.m4472a(this.f2779d.f2780a, this.f2776a, this.f2777b);
                    this.f2777b.add(5, 1);
                    this.f2776a = a.m4464k() - 1;
                    if (!((C0896g) this.f2779d.f2780a.get(this.f2776a)).mo690a(this.f2777b.getTimeInMillis())) {
                        this.f2776a++;
                    }
                    return a;
                }
                throw new NoSuchElementException();
            }
        };
    }

    public C0907o m4556d(long j) {
        return DailyLogUtils.m4294a(this.f2781b, j, this.f2784e);
    }

    public C0907o m4554c(int i) {
        for (C0907o c0907o : this.f2781b) {
            int a_ = c0907o.a_();
            if (a_ != i) {
                if (a_ > i) {
                    break;
                }
            }
            return c0907o;
        }
        return new C0907o(this.f2784e, i);
    }

    public long mo697f() {
        return this.f2785f.mo697f();
    }

    public long mo698g() {
        return this.f2785f.mo698g();
    }
}
