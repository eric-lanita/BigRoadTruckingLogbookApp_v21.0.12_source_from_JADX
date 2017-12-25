package com.bigroad.ttb.android.maps;

import com.bigroad.shared.MobileAppDiagnosticFlags;
import com.bigroad.ttb.android.OurApplication;

public enum MapTechnology {
    DEFAULT(true, true),
    NATIVE_ONLY(true, false),
    WEB_ONLY(false, true),
    DISABLED(false, false);
    
    private final boolean m_allowsNative;
    private final boolean m_allowsWeb;

    private MapTechnology(boolean z, boolean z2) {
        this.m_allowsNative = z;
        this.m_allowsWeb = z2;
    }

    public boolean m10740a() {
        return this.m_allowsNative && OurApplication.al();
    }

    public boolean m10741b() {
        return this.m_allowsWeb;
    }

    public static MapTechnology m10739a(Long l) {
        if (l == null) {
            return DEFAULT;
        }
        boolean b = MobileAppDiagnosticFlags.ALLOW_NATIVE_MAP.m4089b(l.longValue());
        boolean b2 = MobileAppDiagnosticFlags.ALLOW_WEB_MAP.m4089b(l.longValue());
        for (MapTechnology mapTechnology : values()) {
            if (mapTechnology.m_allowsNative == b && mapTechnology.m_allowsWeb == b2) {
                return mapTechnology;
            }
        }
        throw new IllegalStateException("No map technology found corresponding to diagnostic flags: " + l);
    }
}
