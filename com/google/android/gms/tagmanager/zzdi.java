package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.analytics.Tracker;

public class zzdi {
    private GoogleAnalytics f12723a;
    private Context f12724b;
    private Tracker f12725c;

    static class zza implements Logger {
        zza() {
        }

        private static int m18192a(int i) {
            switch (i) {
                case 2:
                    return 0;
                case 3:
                case 4:
                    return 1;
                case 5:
                    return 2;
                default:
                    return 3;
            }
        }

        public void error(Exception exception) {
            zzbn.zzb("", exception);
        }

        public void error(String str) {
            zzbn.m18105e(str);
        }

        public int getLogLevel() {
            return m18192a(zzbn.getLogLevel());
        }

        public void info(String str) {
            zzbn.zzcw(str);
        }

        public void setLogLevel(int i) {
            zzbn.zzcx("GA uses GTM logger. Please use TagManager.setLogLevel(int) instead.");
        }

        public void verbose(String str) {
            zzbn.m18106v(str);
        }

        public void warn(String str) {
            zzbn.zzcx(str);
        }
    }

    public zzdi(Context context) {
        this.f12724b = context;
    }

    private synchronized void m18193a(String str) {
        if (this.f12723a == null) {
            this.f12723a = GoogleAnalytics.getInstance(this.f12724b);
            this.f12723a.setLogger(new zza());
            this.f12725c = this.f12723a.newTracker(str);
        }
    }

    public Tracker zzpf(String str) {
        m18193a(str);
        return this.f12725c;
    }
}
