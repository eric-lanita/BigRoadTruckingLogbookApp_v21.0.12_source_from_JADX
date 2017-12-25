package com.google.android.gms.analytics.internal;

import android.util.Log;
import com.google.android.gms.analytics.Logger;

class zzs implements Logger {
    private int f10376a = 2;
    private boolean f10377b;

    zzs() {
    }

    public void error(Exception exception) {
    }

    public void error(String str) {
    }

    public int getLogLevel() {
        return this.f10376a;
    }

    public void info(String str) {
    }

    public void setLogLevel(int i) {
        this.f10376a = i;
        if (!this.f10377b) {
            String str = (String) zzy.zzczn.get();
            Log.i((String) zzy.zzczn.get(), new StringBuilder(String.valueOf(str).length() + 91).append("Logger is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag.").append(str).append(" DEBUG").toString());
            this.f10377b = true;
        }
    }

    public void verbose(String str) {
    }

    public void warn(String str) {
    }
}
