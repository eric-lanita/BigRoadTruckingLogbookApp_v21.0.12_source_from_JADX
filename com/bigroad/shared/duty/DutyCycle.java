package com.bigroad.shared.duty;

public enum DutyCycle {
    DUTY_CYCLE_CANADIAN_CYCLE_1("hosCanCycle1", "common.dutyCycleLabel.canadaCycle1", "Canada 70hr/7day", 7),
    DUTY_CYCLE_CANADIAN_CYCLE_2("hosCanCycle2", "common.dutyCycleLabel.canadaCycle2", "Canada 120hr/14day", 14),
    DUTY_CYCLE_CANADIAN_NORTH_OF_60_CYCLE_1("hosCanN60Cycle1", "common.dutyCycleLabel.canadaNortOf60Cycle1", "Canada (North of 60) 80hr/7day", 7),
    DUTY_CYCLE_CANADIAN_NORTH_OF_60_CYCLE_2("hosCanN60Cycle2", "common.dutyCycleLabel.canadaNorthOf60Cycle2", "Canada (North of 60) 120hr/14day", 14),
    DUTY_CYCLE_US_7DAY("hosUS7day", "common.dutyCycleLabel.us7Day", "U.S. 60hr/7day", 7),
    DUTY_CYCLE_US_8DAY("hosUS8day", "common.dutyCycleLabel.us8Day", "U.S. 70hr/8day", 8),
    DUTY_CYCLE_ALASKAN_7DAY("hosAK7day", "common.dutyCycleLabel.alaska7Day", "Alaska 70hr/7day", 7),
    DUTY_CYCLE_ALASKAN_8DAY("hosAK8day", "common.dutyCycleLabel.alaska8Day", "Alaska 80hr/8day", 8),
    DUTY_CYCLE_CALIFORNIA_8DAY("hosCA8day", "common.dutyCycleLabel.california8day", "California 80hr/8day", 8),
    DUTY_CYCLE_CALIFORNIA_8DAY_FARM("hosCA8dayFarm", "common.dutyCycleLabel.california8DayFarm", "California 112hr/8day", 8),
    DUTY_CYCLE_TEXAS_7DAY("hosTX7day", "common.dutyCycleLabel.texas7Day", "Texas 70hr/7day", 7);
    
    private final String m_id;
    private final String m_label;
    private final String m_labelResourceKey;
    private final int m_numDays;

    private DutyCycle(String str, String str2, String str3, int i) {
        this.m_id = str;
        this.m_labelResourceKey = str2;
        this.m_label = str3;
        this.m_numDays = i;
    }

    public int m4332a() {
        return this.m_numDays;
    }

    public String toString() {
        return this.m_label;
    }

    public static DutyCycle m4331a(C0874m c0874m) {
        if (c0874m == null) {
            return null;
        }
        if (c0874m.mo705d()) {
            if (c0874m.mo710i().m4901c()) {
                return DUTY_CYCLE_ALASKAN_8DAY;
            }
            if (c0874m.mo710i().m4907i()) {
                return DUTY_CYCLE_CALIFORNIA_8DAY;
            }
            if (c0874m.mo710i().m4909k()) {
                return DUTY_CYCLE_CALIFORNIA_8DAY_FARM;
            }
            return DUTY_CYCLE_US_8DAY;
        } else if (c0874m.mo704c()) {
            if (c0874m.mo709h().m4901c()) {
                return DUTY_CYCLE_ALASKAN_7DAY;
            }
            if (c0874m.mo709h().m4905g()) {
                return DUTY_CYCLE_TEXAS_7DAY;
            }
            return DUTY_CYCLE_US_7DAY;
        } else if (c0874m.mo707f()) {
            if (c0874m.mo711j().m4437b()) {
                return DUTY_CYCLE_CANADIAN_NORTH_OF_60_CYCLE_1;
            }
            return DUTY_CYCLE_CANADIAN_CYCLE_1;
        } else if (!c0874m.mo708g()) {
            return DUTY_CYCLE_US_8DAY;
        } else {
            if (c0874m.mo712k().m4437b()) {
                return DUTY_CYCLE_CANADIAN_NORTH_OF_60_CYCLE_2;
            }
            return DUTY_CYCLE_CANADIAN_CYCLE_2;
        }
    }
}
