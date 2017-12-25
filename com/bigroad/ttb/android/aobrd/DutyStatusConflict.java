package com.bigroad.ttb.android.aobrd;

import com.bigroad.ttb.android.C2032f;
import com.bigroad.ttb.android.util.C2292l;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

public enum DutyStatusConflict {
    DAILY_LOG_SIGNED(1),
    FUTURE_DAILY_LOG_SIGNED(8);
    
    private final long m_eventBit;

    private DutyStatusConflict(long j) {
        this.m_eventBit = j;
    }

    public long m8429a(long j) {
        return this.m_eventBit | j;
    }

    public static long m8426a(long j, Set<DutyStatusConflict> set) {
        if (set != null) {
            for (DutyStatusConflict a : set) {
                j = a.m8429a(j);
            }
        }
        return j;
    }

    private static EnumSet<DutyStatusConflict> m8427a(EnumSet<DutyStatusConflict> enumSet, DutyStatusConflict dutyStatusConflict) {
        if (enumSet == null) {
            return EnumSet.of(dutyStatusConflict);
        }
        enumSet.add(dutyStatusConflict);
        return enumSet;
    }

    public static Set<DutyStatusConflict> m8428a(int i, C2032f c2032f) {
        Set set = null;
        int d = c2032f.mo1302j().m8487d();
        for (int i2 = i; i2 <= d; i2++) {
            DailyLog b = c2032f.mo1302j().m8480b(i2);
            if (b != null && C2292l.m11231a(b)) {
                if (b.getLogDay() != i) {
                    set = m8427a((EnumSet) set, FUTURE_DAILY_LOG_SIGNED);
                    break;
                }
                set = m8427a((EnumSet) set, DAILY_LOG_SIGNED);
            }
        }
        if (set == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(set);
    }
}
