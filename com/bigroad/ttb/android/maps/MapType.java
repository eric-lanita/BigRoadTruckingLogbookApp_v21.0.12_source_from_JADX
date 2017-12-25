package com.bigroad.ttb.android.maps;

import com.bigroad.ttb.android.R;

public enum MapType {
    MAP(R.string.dashboard_mapMap, -1, "roadmap", 1),
    SATELLITE(R.string.dashboard_mapSat, R.string.dashboard_mapShortSat, "hybrid", 4),
    NIGHT(R.string.dashboard_mapNight, -1, "nitemap", -1);
    
    private final String m_javaScriptName;
    private final int m_nameResId;
    private final int m_nativeId;
    private final int m_shortResId;

    private MapType(int i, int i2, String str, int i3) {
        this.m_nameResId = i;
        this.m_shortResId = i2;
        this.m_javaScriptName = str;
        this.m_nativeId = i3;
    }

    public int m10742a() {
        return this.m_nameResId;
    }

    public int m10743b() {
        return this.m_shortResId < 0 ? this.m_nameResId : this.m_shortResId;
    }

    public String m10744c() {
        return this.m_javaScriptName;
    }

    public int m10745d() {
        return this.m_nativeId;
    }
}
