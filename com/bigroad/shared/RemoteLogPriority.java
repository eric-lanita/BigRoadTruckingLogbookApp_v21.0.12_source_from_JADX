package com.bigroad.shared;

import java.util.logging.Level;

public enum RemoteLogPriority {
    UNKNOWN('?', com.bigroad.ttb.protocol.TTProtocol.RemoteLogPriority.UNKNOWN_PRIORITY, Level.WARNING),
    VERBOSE('V', com.bigroad.ttb.protocol.TTProtocol.RemoteLogPriority.VERBOSE_PRIORITY, Level.INFO),
    DEBUG('D', com.bigroad.ttb.protocol.TTProtocol.RemoteLogPriority.DEBUG_PRIORITY, Level.INFO),
    INFO('I', com.bigroad.ttb.protocol.TTProtocol.RemoteLogPriority.INFO_PRIORITY, Level.INFO),
    WARN('W', com.bigroad.ttb.protocol.TTProtocol.RemoteLogPriority.WARN_PRIORITY, Level.WARNING),
    ERROR('E', com.bigroad.ttb.protocol.TTProtocol.RemoteLogPriority.ERROR_PRIORITY, Level.SEVERE),
    ASSERT('A', com.bigroad.ttb.protocol.TTProtocol.RemoteLogPriority.ASSERT_PRIORITY, Level.SEVERE);
    
    private final char m_messageChar;
    private final com.bigroad.ttb.protocol.TTProtocol.RemoteLogPriority m_pb;
    private final Level m_serverLevel;

    private RemoteLogPriority(char c, com.bigroad.ttb.protocol.TTProtocol.RemoteLogPriority remoteLogPriority, Level level) {
        this.m_messageChar = c;
        this.m_pb = remoteLogPriority;
        this.m_serverLevel = level;
    }

    public char m4099a() {
        return this.m_messageChar;
    }

    public com.bigroad.ttb.protocol.TTProtocol.RemoteLogPriority m4101b() {
        return this.m_pb;
    }

    public static RemoteLogPriority m4097a(com.bigroad.ttb.protocol.TTProtocol.RemoteLogPriority remoteLogPriority) {
        if (remoteLogPriority == null) {
            return UNKNOWN;
        }
        for (RemoteLogPriority remoteLogPriority2 : values()) {
            if (remoteLogPriority == remoteLogPriority2.m4101b()) {
                return remoteLogPriority2;
            }
        }
        return UNKNOWN;
    }

    public boolean m4100a(RemoteLogPriority remoteLogPriority) {
        return compareTo(remoteLogPriority) <= 0;
    }

    public static RemoteLogPriority m4098a(Long l) {
        if (l == null) {
            return null;
        }
        int a = MobileAppDiagnosticFlags.REMOTE_LOG_PRIORITY.m4087a(l.longValue());
        if (a != 0) {
            return m4097a(com.bigroad.ttb.protocol.TTProtocol.RemoteLogPriority.m14883a(a));
        }
        return null;
    }
}
