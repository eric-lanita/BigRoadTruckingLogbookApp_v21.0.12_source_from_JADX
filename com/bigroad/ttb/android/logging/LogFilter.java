package com.bigroad.ttb.android.logging;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LogFilter {
    private final Set<String> f7437a = new HashSet();
    private FilterMode f7438b;

    public enum FilterMode {
        INCLUDE_ONLY,
        EXCLUDE_ALL
    }

    public LogFilter(String[] strArr, FilterMode filterMode) {
        this.f7438b = filterMode;
        Collections.addAll(this.f7437a, strArr);
    }

    public boolean m10642a(C2136g c2136g) {
        return !m10643b(c2136g);
    }

    public boolean m10643b(C2136g c2136g) {
        boolean contains = this.f7437a.contains(c2136g.m10686d());
        switch (this.f7438b) {
            case INCLUDE_ONLY:
                return contains;
            case EXCLUDE_ALL:
                if (contains) {
                    return false;
                }
                return true;
            default:
                return false;
        }
    }
}
