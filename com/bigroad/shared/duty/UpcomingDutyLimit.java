package com.bigroad.shared.duty;

import com.bigroad.shared.duty.TimeWindow.Condition;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UpcomingDutyLimit {
    private Type f2743a;
    private TimeWindow f2744b;

    static class C08721 implements Comparator<UpcomingDutyLimit> {
        C08721() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m4407a((UpcomingDutyLimit) obj, (UpcomingDutyLimit) obj2);
        }

        public int m4407a(UpcomingDutyLimit upcomingDutyLimit, UpcomingDutyLimit upcomingDutyLimit2) {
            long b = upcomingDutyLimit.m4412b().m4402b() - upcomingDutyLimit2.m4412b().m4402b();
            if (b == 0) {
                return 0;
            }
            return b < 0 ? -1 : 1;
        }
    }

    public enum Type {
        BREAK_COMPLETE(false),
        SHIFT_COMPLETE(false),
        CYCLE_COMPLETE(false),
        SLEEPER_SPLIT(false),
        DUTY_LIMIT(true),
        DRIVE_LIMIT(true),
        DRIVE_BEFORE_BREAK(true);
        
        private boolean m_warnBeforeCompletion;

        private Type(boolean z) {
            this.m_warnBeforeCompletion = z;
        }

        public boolean m4408a() {
            return this.m_warnBeforeCompletion;
        }
    }

    public UpcomingDutyLimit(Type type, TimeWindow timeWindow) {
        this.f2743a = type;
        this.f2744b = timeWindow;
    }

    public Type m4411a() {
        return this.f2743a;
    }

    public TimeWindow m4412b() {
        return this.f2744b;
    }

    public static List<UpcomingDutyLimit> m4409a(DutyLimits dutyLimits, DutyStatus dutyStatus) {
        List<UpcomingDutyLimit> arrayList = new ArrayList();
        if (!(dutyLimits == null || dutyStatus == null)) {
            TimeWindow f;
            switch (dutyStatus) {
                case OFF_DUTY:
                case OFF_DUTY_DRIVING:
                case SLEEPER:
                    f = dutyLimits.m4370f();
                    if (f != null && f.m4402b() > 0 && f.mo727a() != Condition.FINE && dutyLimits.m4380p()) {
                        arrayList.add(new UpcomingDutyLimit(Type.BREAK_COMPLETE, f));
                    }
                    f = dutyLimits.m4371g();
                    if (f.mo727a() != Condition.FINE && f.m4402b() > 0) {
                        arrayList.add(new UpcomingDutyLimit(Type.SHIFT_COMPLETE, f));
                    }
                    f = dutyLimits.m4372h();
                    if (f.m4402b() > 0) {
                        arrayList.add(new UpcomingDutyLimit(Type.CYCLE_COMPLETE, f));
                        break;
                    }
                    break;
                case OFF_DUTY_WAITING:
                    f = dutyLimits.m4370f();
                    if (!(f == null || f.mo727a() == Condition.FINE || !dutyLimits.m4380p())) {
                        arrayList.add(new UpcomingDutyLimit(Type.BREAK_COMPLETE, f));
                    }
                    arrayList.add(new UpcomingDutyLimit(Type.DUTY_LIMIT, dutyLimits.m4369e()));
                    break;
                case ON_DUTY_NOT_DRIVING:
                case ELD_YARD_MOVE:
                    arrayList.add(new UpcomingDutyLimit(Type.DUTY_LIMIT, dutyLimits.m4369e()));
                    break;
                case DRIVING:
                    f = dutyLimits.m4366b();
                    if (f != null && dutyLimits.m4380p()) {
                        arrayList.add(new UpcomingDutyLimit(Type.DRIVE_BEFORE_BREAK, f));
                    }
                    arrayList.add(new UpcomingDutyLimit(Type.DRIVE_LIMIT, dutyLimits.m4364a()));
                    break;
            }
            if (dutyLimits.m4365a(dutyStatus) && dutyLimits.m4375k()) {
                arrayList.add(new UpcomingDutyLimit(Type.SLEEPER_SPLIT, dutyLimits.m4377m()));
                Collections.sort(arrayList, new C08721());
            }
        }
        return arrayList;
    }

    public static UpcomingDutyLimit m4410b(DutyLimits dutyLimits, DutyStatus dutyStatus) {
        List a = m4409a(dutyLimits, dutyStatus);
        return a.isEmpty() ? null : (UpcomingDutyLimit) a.get(0);
    }
}
