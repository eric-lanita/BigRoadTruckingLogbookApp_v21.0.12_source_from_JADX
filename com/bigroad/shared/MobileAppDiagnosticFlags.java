package com.bigroad.shared;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import java.util.TreeMap;

public enum MobileAppDiagnosticFlags {
    ALLOW_NATIVE_MAP(0, "Native Maps"),
    ALLOW_WEB_MAP(1, "Web Maps"),
    REMOTE_LOG_PRIORITY(r3, 4, "Log Level", "None", null, "Verbose", "Debug", "Info", "Warn", "Error", "Assert"),
    LOG_DATA_USE(5, "Log Data Use"),
    ANALYTICS_DRY_RUN(6, "Google Analytics Dry Run"),
    LOG_CLOCK_CHANGES(7, "Log Clock Changes"),
    LOG_ANRS(8, "Log ANRs"),
    LOG_SLOW_UI(9, "Log Slow UI"),
    LOG_UNCAUGHT_EXCEPTION(10, "Log Uncaught Exception");
    
    private final ImmutableMap<Integer, String> m_immutableOptions;
    private final int m_lsb;
    private final long m_mask;
    private final String m_name;

    private MobileAppDiagnosticFlags(int i, String str) {
        this(r8, r9, i, i, str, "Disable", "Enable");
    }

    private MobileAppDiagnosticFlags(int i, int i2, String str, String... strArr) {
        int i3;
        this.m_lsb = i;
        long j = 0;
        for (i3 = i; i3 <= i2; i3++) {
            j |= (long) (1 << i3);
        }
        this.m_mask = j;
        this.m_name = str;
        Map treeMap = new TreeMap();
        for (i3 = 0; i3 < strArr.length; i3++) {
            Object obj = strArr[i3];
            if (obj != null) {
                treeMap.put(Integer.valueOf(i3 << i), obj);
            }
        }
        this.m_immutableOptions = ImmutableMap.m18549a(treeMap);
    }

    public long m4088a() {
        return this.m_mask;
    }

    public int m4087a(long j) {
        return (int) ((this.m_mask & j) >> this.m_lsb);
    }

    public boolean m4089b(long j) {
        return (m4088a() & j) != 0;
    }

    public String toString() {
        return this.m_name;
    }
}
