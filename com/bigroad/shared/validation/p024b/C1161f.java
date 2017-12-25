package com.bigroad.shared.validation.p024b;

import com.bigroad.shared.validation.C1176p;
import com.bigroad.shared.validation.ValidationError.Severity;
import com.bigroad.shared.validation.model.DailyLog;
import com.bigroad.shared.validation.model.DailyLog.Field;
import com.bigroad.shared.validation.model.DailyLogHeader;
import com.bigroad.shared.validation.model.Dvir;
import com.bigroad.shared.validation.model.Event;
import com.google.common.base.Predicate;
import com.google.common.collect.C3600n;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class C1161f implements DailyLog {
    private final int f3947a;
    private final DailyLogHeader f3948b;
    private final List<? extends Event> f3949c;
    private final List<? extends Dvir> f3950d;
    private final C1176p<Field> f3951e;

    static class C11591 implements Predicate<Event> {
        C11591() {
        }

        public /* synthetic */ boolean apply(Object obj) {
            return m5893a((Event) obj);
        }

        public boolean m5893a(Event event) {
            return event.mo726y();
        }
    }

    public static class C1160a {
        private int f3943a;
        private DailyLogHeader f3944b;
        private List<? extends Event> f3945c;
        private List<? extends Dvir> f3946d;

        public C1160a(int i) {
            m5898a(i);
        }

        public C1160a m5898a(int i) {
            this.f3943a = i;
            return this;
        }

        public C1160a m5899a(DailyLogHeader dailyLogHeader) {
            this.f3944b = dailyLogHeader;
            return this;
        }

        public C1160a m5900a(List<? extends Event> list) {
            this.f3945c = list;
            return this;
        }

        public C1160a m5902b(List<? extends Dvir> list) {
            this.f3946d = list;
            return this;
        }

        public C1161f m5901a() {
            if (this.f3945c == null) {
                this.f3945c = Collections.emptyList();
            } else {
                this.f3945c = Collections.unmodifiableList(this.f3945c);
            }
            if (this.f3946d == null) {
                this.f3946d = Collections.emptyList();
            } else {
                this.f3946d = Collections.unmodifiableList(this.f3946d);
            }
            return new C1161f();
        }
    }

    private C1161f(C1160a c1160a) {
        this.f3947a = c1160a.f3943a;
        this.f3948b = c1160a.f3944b;
        this.f3949c = c1160a.f3945c;
        this.f3950d = c1160a.f3946d;
        this.f3951e = new C1176p();
    }

    public int mo857a() {
        return this.f3947a;
    }

    public DailyLogHeader mo858b() {
        return this.f3948b;
    }

    public List<? extends Event> mo859c() {
        return this.f3949c;
    }

    public List<? extends Dvir> mo860d() {
        return this.f3950d;
    }

    public boolean mo861e() {
        return this.f3948b != null && this.f3948b.mo842s();
    }

    public boolean mo862f() {
        return (this.f3948b != null && this.f3948b.mo843t()) || (!(this.f3948b == null || this.f3948b.mo833j().isEmpty()) || C1161f.m5909a(mo859c()));
    }

    private static boolean m5909a(Iterable<? extends Event> iterable) {
        return C3600n.m18812a((Iterable) iterable, new C11591());
    }

    public C1176p<Field> mo716A() {
        return this.f3951e;
    }

    public boolean mo717B() {
        return m5914a(true);
    }

    public boolean m5914a(boolean z) {
        if (this.f3951e.m5962b()) {
            return true;
        }
        if (z) {
            if (mo858b() != null && mo858b().mo717B()) {
                return true;
            }
            for (Event B : mo859c()) {
                if (B.mo717B()) {
                    return true;
                }
            }
            for (Dvir B2 : mo860d()) {
                if (B2.mo717B()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean mo718a(Set<Severity> set) {
        if (this.f3951e.m5959a((Set) set)) {
            return true;
        }
        if (mo858b() != null && mo858b().mo718a(set)) {
            return true;
        }
        for (Event a : mo859c()) {
            if (a.mo718a(set)) {
                return true;
            }
        }
        for (Dvir a2 : mo860d()) {
            if (a2.mo718a(set)) {
                return true;
            }
        }
        return false;
    }
}
