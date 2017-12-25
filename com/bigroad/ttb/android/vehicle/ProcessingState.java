package com.bigroad.ttb.android.vehicle;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

public enum ProcessingState {
    NOT_PROCESSING,
    BEFORE_APP_START,
    BEFORE_CURSOR,
    AT_CURSOR,
    TEMPORALLY_AT_CURSOR,
    INCREMENTING_CURSOR,
    CORRUPT_ENTRIES_DETECTED;
    
    private static final Set<ProcessingState> f7990h = null;
    private static final Set<ProcessingState> f7991i = null;

    static {
        f7990h = Collections.unmodifiableSet(EnumSet.of(AT_CURSOR, TEMPORALLY_AT_CURSOR, INCREMENTING_CURSOR));
        f7991i = Collections.unmodifiableSet(EnumSet.of(BEFORE_APP_START, BEFORE_CURSOR));
    }

    public boolean m11310a() {
        return f7990h.contains(this);
    }

    public boolean m11311b() {
        return f7991i.contains(this);
    }
}
