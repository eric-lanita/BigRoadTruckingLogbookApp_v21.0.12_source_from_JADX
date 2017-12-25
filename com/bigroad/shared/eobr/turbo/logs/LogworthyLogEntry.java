package com.bigroad.shared.eobr.turbo.logs;

import com.bigroad.shared.eobr.turbo.C1000c;

public class LogworthyLogEntry extends C1017o {
    public final LogworthyReason f3208a;
    public final String f3209b;

    public enum LogworthyReason implements C1000c {
        LOGWORTHY_RESET(0),
        LOGWORTHY_BLUETOOTH(1),
        LOGWORTHY_VAR(2),
        LOGWORTHY_UNKNOWN(3),
        LOGWORTHY_TRANSPORT(4),
        LOGWORTHY_FLASH(5);
        
        private final int m_id;

        private LogworthyReason(int i) {
            this.m_id = i;
        }

        public int mo760a() {
            return this.m_id;
        }

        public boolean mo761b() {
            return this == LOGWORTHY_UNKNOWN;
        }
    }

    public LogworthyLogEntry(int i, LogworthyReason logworthyReason, String str) {
        super(i);
        this.f3208a = logworthyReason;
        this.f3209b = str;
    }
}
