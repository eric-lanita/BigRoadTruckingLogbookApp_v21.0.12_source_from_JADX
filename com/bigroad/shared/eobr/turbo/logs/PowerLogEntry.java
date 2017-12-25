package com.bigroad.shared.eobr.turbo.logs;

import com.bigroad.shared.eobr.turbo.C1000c;
import com.facebook.internal.AnalyticsEvents;

public class PowerLogEntry extends C1017o {
    public final PowerLogReason f3243a;
    public final int f3244b;

    public enum PowerLogReason implements C1000c {
        POWER_LOG_REASON_PEAK_VOLTAGE(0, "Startup Voltage"),
        POWER_LOG_REASON_VOLTAGE_DROP(1, "Voltage dropped by 1V"),
        POWER_LOG_REASON_POWER_SAVE_ENABLED(2, "Entering Power Save"),
        POWER_LOG_REASON_POWER_SAVE_DISABLED(3, "Exiting Power Save"),
        POWER_LOG_REASON_BATTERY_LOW(4, "Vehicle Battery Low"),
        POWER_LOG_REASON_UNKNOWN(5, AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN);
        
        private final String m_diagnosticsText;
        private final int m_id;

        private PowerLogReason(int i, String str) {
            this.m_id = i;
            this.m_diagnosticsText = str;
        }

        public int mo760a() {
            return this.m_id;
        }

        public boolean mo761b() {
            return this == POWER_LOG_REASON_UNKNOWN;
        }
    }

    public PowerLogEntry(int i, PowerLogReason powerLogReason, int i2) {
        super(i);
        this.f3243a = powerLogReason;
        this.f3244b = i2;
    }
}
