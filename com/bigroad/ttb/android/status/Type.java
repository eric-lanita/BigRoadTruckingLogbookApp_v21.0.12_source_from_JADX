package com.bigroad.ttb.android.status;

import com.bigroad.ttb.android.R;

public enum Type {
    DASHLINK_ERROR(Category.DASHLINK, Severity.ERROR, R.drawable.notice_error_bg, R.drawable.ic_dashlink_bad_status),
    DASHLINK_WARNING(Category.DASHLINK, Severity.WARNING, R.drawable.notice_warn_bg, R.drawable.ic_dashlink_warn_status),
    DASHLINK_BATTERY_WARNING(Category.DASHLINK, Severity.WARNING, R.drawable.notice_warn_bg, R.drawable.ic_dashlink_warn_battery_status),
    SYSTEM_WARNING(Category.SYSTEM, Severity.WARNING, R.drawable.notice_warn_bg, 0),
    APP_WARNING(Category.APP, Severity.WARNING, R.drawable.notice_warn_bg, 0),
    DASHLINK_NOTICE(Category.DASHLINK, Severity.NOTICE, R.drawable.notice_warn_bg, 0);
    
    private final int m_backgroundResId;
    private final Category m_category;
    private final int m_iconResId;
    private final Severity m_severity;

    private Type(Category category, Severity severity, int i, int i2) {
        this.m_severity = severity;
        this.m_category = category;
        this.m_backgroundResId = i;
        this.m_iconResId = i2;
    }

    public Category m11035a() {
        return this.m_category;
    }

    public int m11036b() {
        return this.m_backgroundResId;
    }

    public int m11037c() {
        return this.m_iconResId;
    }
}
