package com.bigroad.ttb.android.logging;

import com.google.android.gms.analytics.Logger;

public class C2126a implements Logger {
    private int f7439a = 1;

    public void error(String str) {
        if (m10644a(3)) {
            C2134e.m10682e("TT-Analytics", str);
        }
    }

    public void error(Exception exception) {
        if (m10644a(3)) {
            C2134e.m10681d("TT-Analytics", exception.getMessage(), exception);
        }
    }

    public void warn(String str) {
        if (m10644a(2)) {
            C2134e.m10680d("TT-Analytics", str);
        }
    }

    public void info(String str) {
        if (m10644a(1)) {
            C2134e.m10678c("TT-Analytics", str);
        }
    }

    public void verbose(String str) {
        if (m10644a(0)) {
            C2134e.m10673a("TT-Analytics", str);
        }
    }

    public void setLogLevel(int i) {
        this.f7439a = i;
    }

    public int getLogLevel() {
        return this.f7439a;
    }

    private boolean m10644a(int i) {
        return i >= this.f7439a;
    }
}
