package com.bigroad.shared;

public enum LogPriority {
    LOG_VERBOSE(2),
    LOG_DEBUG(3),
    LOG_INFO(4),
    LOG_WARN(5),
    LOG_ERROR(6),
    LOG_ASSERT(7);
    
    private int m_priority;

    private LogPriority(int i) {
        this.m_priority = i;
    }

    public int m4086a() {
        return this.m_priority;
    }
}
