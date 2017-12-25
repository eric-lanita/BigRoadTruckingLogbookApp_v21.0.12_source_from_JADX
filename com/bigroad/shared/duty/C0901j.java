package com.bigroad.shared.duty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class C0901j implements Iterable<DutyStatus> {
    private List<DutyStatus> f2790a;
    private List<DutyStatus> f2791b;
    private boolean f2792c;
    private boolean f2793d;

    public static class C0900a {
        private C0956v f2787a;
        private boolean f2788b;
        private boolean f2789c;

        private C0900a() {
            this.f2787a = null;
            this.f2788b = false;
            this.f2789c = false;
        }

        public C0900a m4564a(C0956v c0956v) {
            this.f2787a = c0956v;
            return this;
        }

        public C0900a m4565a(Iterable<? extends C0871l> iterable) {
            for (C0871l m : iterable) {
                m4563a(m.mo702m());
            }
            return this;
        }

        public C0900a m4563a(DutyStatus dutyStatus) {
            if (dutyStatus != null) {
                switch (dutyStatus) {
                    case OFF_DUTY_WAITING:
                        this.f2788b = true;
                        break;
                    case OFF_DUTY_DRIVING:
                        this.f2789c = true;
                        break;
                    default:
                        break;
                }
            }
            return this;
        }

        public C0900a m4566a(boolean z) {
            boolean z2 = this.f2789c || z;
            this.f2789c = z2;
            return this;
        }

        public C0901j m4567a() {
            return new C0901j(this.f2787a, this.f2788b, this.f2789c);
        }
    }

    public static C0900a m4568a() {
        return new C0900a();
    }

    private C0901j(C0956v c0956v, boolean z, boolean z2) {
        this.f2790a = new ArrayList();
        this.f2792c = false;
        this.f2793d = false;
        this.f2790a.add(DutyStatus.OFF_DUTY);
        this.f2790a.add(DutyStatus.SLEEPER);
        this.f2790a.add(DutyStatus.DRIVING);
        this.f2790a.add(DutyStatus.ON_DUTY_NOT_DRIVING);
        this.f2792c = z;
        this.f2793d = z2;
        if (c0956v != null && c0956v.m4880n()) {
            this.f2792c = true;
        }
        if (this.f2792c) {
            this.f2790a.add(DutyStatus.OFF_DUTY_WAITING);
        }
        this.f2791b = Collections.unmodifiableList(new ArrayList(this.f2790a));
        if (this.f2793d) {
            this.f2790a.add(DutyStatus.OFF_DUTY_DRIVING);
        }
        this.f2790a = Collections.unmodifiableList(this.f2790a);
    }

    public Iterator<DutyStatus> iterator() {
        return this.f2790a.iterator();
    }

    public DutyStatus m4570a(int i) {
        return (DutyStatus) this.f2790a.get(i);
    }

    public List<DutyStatus> m4571a(boolean z) {
        if (z) {
            return this.f2791b;
        }
        return this.f2790a;
    }

    public boolean m4572b() {
        return this.f2792c;
    }

    public boolean m4573c() {
        return this.f2793d;
    }

    public int m4569a(DutyStatus dutyStatus) {
        for (int i = 0; i < this.f2790a.size(); i++) {
            if (this.f2790a.get(i) == dutyStatus) {
                return i;
            }
        }
        return -1;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C0901j) && ((C0901j) obj).f2790a.equals(this.f2790a);
    }

    public int hashCode() {
        return this.f2790a.hashCode();
    }
}
