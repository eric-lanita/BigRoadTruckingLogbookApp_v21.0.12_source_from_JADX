package com.bigroad.shared.eobr.turbo;

import com.bigroad.shared.LogPriority;
import java.io.IOException;

public class TurboDataSerializationException extends IOException {
    private static final long serialVersionUID = -3517945563856946735L;
    private LogPriority m_priority = LogPriority.LOG_ERROR;

    public TurboDataSerializationException(String str) {
        super(str);
    }

    public TurboDataSerializationException(String str, LogPriority logPriority) {
        super(str);
        this.m_priority = logPriority;
    }

    public LogPriority m5124a() {
        return this.m_priority;
    }
}
