package com.bigroad.ttb.android.model;

import com.bigroad.shared.duty.C0874m;
import com.bigroad.ttb.android.R;

public enum DutyCycle {
    CANADIAN_CYCLE_1(R.string.cycle_hosCanadianCycle1, R.string.cycle_hosCanadianCycle1Short),
    CANADIAN_CYCLE_2(R.string.cycle_hosCanadianCycle2, R.string.cycle_hosCanadianCycle2Short),
    CANADIAN_NORTH_OF_60_CYCLE_1(R.string.cycle_hosCanadianNorthOf60Cycle1, R.string.cycle_hosCanadianNorthOf60Cycle1Short),
    CANADIAN_NORTH_OF_60_CYCLE_2(R.string.cycle_hosCanadianNorthOf60Cycle2, R.string.cycle_hosCanadianNorthOf60Cycle2Short),
    US_7DAY(R.string.cycle_hosUS7DayCycle, R.string.cycle_hosUS7DayCycleShort),
    US_8DAY(R.string.cycle_hosUS8DayCycle, R.string.cycle_hosUS8DayCycleShort),
    ALASKAN_7DAY(R.string.cycle_hosAlaskan7DayCycle, R.string.cycle_hosAlaskan7DayCycleShort),
    ALASKAN_8DAY(R.string.cycle_hosAlaskan8DayCycle, R.string.cycle_hosAlaskan8DayCycleShort),
    CALIFORNIA_8DAY(R.string.cycle_hosCalifornia8DayCycle, R.string.cycle_hosCalifornia8DayCycleShort),
    CALIFORNIA_8DAY_FARM(R.string.cycle_hosCalifornia8DayFarmCycle, R.string.cycle_hosCalifornia8DayFarmCycleShort),
    TEXAS_7DAY(R.string.cycle_hosTexas7DayCycle, R.string.cycle_hosTexas7DayCycleShort);
    
    private int m_resourceId;
    private int m_shortResourceId;

    private DutyCycle(int i, int i2) {
        this.m_resourceId = i;
        this.m_shortResourceId = i2;
    }

    public int m10791a(boolean z) {
        if (z) {
            return this.m_shortResourceId;
        }
        return this.m_resourceId;
    }

    public static DutyCycle m10790a(C0874m c0874m) {
        if (c0874m.mo705d()) {
            if (c0874m.mo710i().m4901c()) {
                return ALASKAN_8DAY;
            }
            if (c0874m.mo710i().m4907i()) {
                return CALIFORNIA_8DAY;
            }
            if (c0874m.mo710i().m4909k()) {
                return CALIFORNIA_8DAY_FARM;
            }
            return US_8DAY;
        } else if (c0874m.mo704c()) {
            if (c0874m.mo709h().m4901c()) {
                return ALASKAN_7DAY;
            }
            if (c0874m.mo709h().m4905g()) {
                return TEXAS_7DAY;
            }
            return US_7DAY;
        } else if (c0874m.mo707f()) {
            if (c0874m.mo711j().m4437b()) {
                return CANADIAN_NORTH_OF_60_CYCLE_1;
            }
            return CANADIAN_CYCLE_1;
        } else if (!c0874m.mo708g()) {
            return US_8DAY;
        } else {
            if (c0874m.mo712k().m4437b()) {
                return CANADIAN_NORTH_OF_60_CYCLE_2;
            }
            return CANADIAN_CYCLE_2;
        }
    }
}
