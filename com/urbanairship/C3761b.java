package com.urbanairship;

import android.content.Context;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.urbanairship.util.C3954i;

public class C3761b {
    public final String f13501a;
    public final String f13502b;
    public final String f13503c;
    public final String f13504d;
    public final String f13505e;
    public final String f13506f;
    public final String f13507g;
    public final String f13508h;
    public final String[] f13509i;
    public final String[] f13510j;
    public final boolean f13511k;
    public final boolean f13512l;
    public final long f13513m;
    public final boolean f13514n;
    public final int f13515o;
    public final int f13516p;
    public final boolean f13517q;
    public final boolean f13518r;
    public final boolean f13519s;
    public final int f13520t;
    public final String f13521u;
    public final int f13522v;

    public static final class C3755a {
        private String f13460a;
        private String f13461b;
        private String f13462c;
        private String f13463d;
        private String f13464e = "https://device-api.urbanairship.com/";
        private String f13465f = "https://combine.urbanairship.com/";
        private String f13466g = "https://dl.urbanairship.com/aaa/";
        private String f13467h;
        private String[] f13468i = new String[]{"ADM", GoogleCloudMessaging.INSTANCE_ID_SCOPE};
        private String[] f13469j = null;
        private boolean f13470k = false;
        private boolean f13471l = true;
        private long f13472m = 900000;
        private boolean f13473n = false;
        private int f13474o = 3;
        private int f13475p = 6;
        private boolean f13476q = true;
        private boolean f13477r = false;
        private boolean f13478s = true;
        private int f13479t;
        private int f13480u;
        private String f13481v = "https://wallet-api.urbanairship.com";

        public C3755a m19617a(Context context) {
            return m19618a(context, "airshipconfig.properties");
        }

        public C3755a m19618a(Context context, String str) {
            try {
                m19593a(new C3847n(context, str));
            } catch (Throwable e) {
                C3783j.m19726c("AirshipConfigOptions - Unable to apply config.", e);
            }
            return this;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void m19593a(com.urbanairship.C3781h r9) {
            /*
            r8 = this;
            r4 = 6;
            r3 = 3;
            r1 = 0;
            r0 = r1;
        L_0x0004:
            r2 = r9.mo2807a();
            if (r0 >= r2) goto L_0x0204;
        L_0x000a:
            r5 = r9.mo2808a(r0);	 Catch:{ Exception -> 0x011a }
            r2 = -1;
            r6 = r5.hashCode();	 Catch:{ Exception -> 0x011a }
            switch(r6) {
                case -2131444128: goto L_0x00d5;
                case -1776171144: goto L_0x0026;
                case -1720015653: goto L_0x008d;
                case -1653850041: goto L_0x0077;
                case -1565320553: goto L_0x001c;
                case -1285301710: goto L_0x006c;
                case -1266098791: goto L_0x0030;
                case -1249058386: goto L_0x00c9;
                case -1192476644: goto L_0x0058;
                case -398391045: goto L_0x00b1;
                case -361592578: goto L_0x00e1;
                case -318159706: goto L_0x0062;
                case -187695495: goto L_0x00bd;
                case -172743977: goto L_0x00a5;
                case -116200981: goto L_0x0099;
                case 24145854: goto L_0x0082;
                case 282201398: goto L_0x003a;
                case 476084841: goto L_0x004e;
                case 1098683047: goto L_0x0044;
                case 1465076406: goto L_0x0105;
                case 1505552078: goto L_0x00f9;
                case 1611189252: goto L_0x00ed;
                default: goto L_0x0016;
            };	 Catch:{ Exception -> 0x011a }
        L_0x0016:
            switch(r2) {
                case 0: goto L_0x0111;
                case 1: goto L_0x013d;
                case 2: goto L_0x0146;
                case 3: goto L_0x014f;
                case 4: goto L_0x0158;
                case 5: goto L_0x0161;
                case 6: goto L_0x016a;
                case 7: goto L_0x0173;
                case 8: goto L_0x017c;
                case 9: goto L_0x0185;
                case 10: goto L_0x018e;
                case 11: goto L_0x0197;
                case 12: goto L_0x01a0;
                case 13: goto L_0x01a9;
                case 14: goto L_0x01b2;
                case 15: goto L_0x01c0;
                case 16: goto L_0x01ce;
                case 17: goto L_0x01d7;
                case 18: goto L_0x01e0;
                case 19: goto L_0x01e9;
                case 20: goto L_0x01f2;
                case 21: goto L_0x01fb;
                default: goto L_0x0019;
            };	 Catch:{ Exception -> 0x011a }
        L_0x0019:
            r0 = r0 + 1;
            goto L_0x0004;
        L_0x001c:
            r6 = "productionAppKey";
            r5 = r5.equals(r6);	 Catch:{ Exception -> 0x011a }
            if (r5 == 0) goto L_0x0016;
        L_0x0024:
            r2 = r1;
            goto L_0x0016;
        L_0x0026:
            r6 = "productionAppSecret";
            r5 = r5.equals(r6);	 Catch:{ Exception -> 0x011a }
            if (r5 == 0) goto L_0x0016;
        L_0x002e:
            r2 = 1;
            goto L_0x0016;
        L_0x0030:
            r6 = "developmentAppKey";
            r5 = r5.equals(r6);	 Catch:{ Exception -> 0x011a }
            if (r5 == 0) goto L_0x0016;
        L_0x0038:
            r2 = 2;
            goto L_0x0016;
        L_0x003a:
            r6 = "developmentAppSecret";
            r5 = r5.equals(r6);	 Catch:{ Exception -> 0x011a }
            if (r5 == 0) goto L_0x0016;
        L_0x0042:
            r2 = r3;
            goto L_0x0016;
        L_0x0044:
            r6 = "hostURL";
            r5 = r5.equals(r6);	 Catch:{ Exception -> 0x011a }
            if (r5 == 0) goto L_0x0016;
        L_0x004c:
            r2 = 4;
            goto L_0x0016;
        L_0x004e:
            r6 = "analyticsServer";
            r5 = r5.equals(r6);	 Catch:{ Exception -> 0x011a }
            if (r5 == 0) goto L_0x0016;
        L_0x0056:
            r2 = 5;
            goto L_0x0016;
        L_0x0058:
            r6 = "landingPageContentURL";
            r5 = r5.equals(r6);	 Catch:{ Exception -> 0x011a }
            if (r5 == 0) goto L_0x0016;
        L_0x0060:
            r2 = r4;
            goto L_0x0016;
        L_0x0062:
            r6 = "gcmSender";
            r5 = r5.equals(r6);	 Catch:{ Exception -> 0x011a }
            if (r5 == 0) goto L_0x0016;
        L_0x006a:
            r2 = 7;
            goto L_0x0016;
        L_0x006c:
            r6 = "allowedTransports";
            r5 = r5.equals(r6);	 Catch:{ Exception -> 0x011a }
            if (r5 == 0) goto L_0x0016;
        L_0x0074:
            r2 = 8;
            goto L_0x0016;
        L_0x0077:
            r6 = "whitelist";
            r5 = r5.equals(r6);	 Catch:{ Exception -> 0x011a }
            if (r5 == 0) goto L_0x0016;
        L_0x007f:
            r2 = 9;
            goto L_0x0016;
        L_0x0082:
            r6 = "inProduction";
            r5 = r5.equals(r6);	 Catch:{ Exception -> 0x011a }
            if (r5 == 0) goto L_0x0016;
        L_0x008a:
            r2 = 10;
            goto L_0x0016;
        L_0x008d:
            r6 = "analyticsEnabled";
            r5 = r5.equals(r6);	 Catch:{ Exception -> 0x011a }
            if (r5 == 0) goto L_0x0016;
        L_0x0095:
            r2 = 11;
            goto L_0x0016;
        L_0x0099:
            r6 = "backgroundReportingIntervalMS";
            r5 = r5.equals(r6);	 Catch:{ Exception -> 0x011a }
            if (r5 == 0) goto L_0x0016;
        L_0x00a1:
            r2 = 12;
            goto L_0x0016;
        L_0x00a5:
            r6 = "clearNamedUser";
            r5 = r5.equals(r6);	 Catch:{ Exception -> 0x011a }
            if (r5 == 0) goto L_0x0016;
        L_0x00ad:
            r2 = 13;
            goto L_0x0016;
        L_0x00b1:
            r6 = "developmentLogLevel";
            r5 = r5.equals(r6);	 Catch:{ Exception -> 0x011a }
            if (r5 == 0) goto L_0x0016;
        L_0x00b9:
            r2 = 14;
            goto L_0x0016;
        L_0x00bd:
            r6 = "productionLogLevel";
            r5 = r5.equals(r6);	 Catch:{ Exception -> 0x011a }
            if (r5 == 0) goto L_0x0016;
        L_0x00c5:
            r2 = 15;
            goto L_0x0016;
        L_0x00c9:
            r6 = "autoLaunchApplication";
            r5 = r5.equals(r6);	 Catch:{ Exception -> 0x011a }
            if (r5 == 0) goto L_0x0016;
        L_0x00d1:
            r2 = 16;
            goto L_0x0016;
        L_0x00d5:
            r6 = "channelCreationDelayEnabled";
            r5 = r5.equals(r6);	 Catch:{ Exception -> 0x011a }
            if (r5 == 0) goto L_0x0016;
        L_0x00dd:
            r2 = 17;
            goto L_0x0016;
        L_0x00e1:
            r6 = "channelCaptureEnabled";
            r5 = r5.equals(r6);	 Catch:{ Exception -> 0x011a }
            if (r5 == 0) goto L_0x0016;
        L_0x00e9:
            r2 = 18;
            goto L_0x0016;
        L_0x00ed:
            r6 = "notificationIcon";
            r5 = r5.equals(r6);	 Catch:{ Exception -> 0x011a }
            if (r5 == 0) goto L_0x0016;
        L_0x00f5:
            r2 = 19;
            goto L_0x0016;
        L_0x00f9:
            r6 = "notificationAccentColor";
            r5 = r5.equals(r6);	 Catch:{ Exception -> 0x011a }
            if (r5 == 0) goto L_0x0016;
        L_0x0101:
            r2 = 20;
            goto L_0x0016;
        L_0x0105:
            r6 = "walletUrl";
            r5 = r5.equals(r6);	 Catch:{ Exception -> 0x011a }
            if (r5 == 0) goto L_0x0016;
        L_0x010d:
            r2 = 21;
            goto L_0x0016;
        L_0x0111:
            r2 = r9.mo2809b(r0);	 Catch:{ Exception -> 0x011a }
            r8.m19619a(r2);	 Catch:{ Exception -> 0x011a }
            goto L_0x0019;
        L_0x011a:
            r2 = move-exception;
            r5 = new java.lang.StringBuilder;
            r5.<init>();
            r6 = "Unable to set config field '";
            r5 = r5.append(r6);
            r6 = r9.mo2808a(r0);
            r5 = r5.append(r6);
            r6 = "' due to invalid configuration value.";
            r5 = r5.append(r6);
            r5 = r5.toString();
            com.urbanairship.C3783j.m19726c(r5, r2);
            goto L_0x0019;
        L_0x013d:
            r2 = r9.mo2809b(r0);	 Catch:{ Exception -> 0x011a }
            r8.m19624b(r2);	 Catch:{ Exception -> 0x011a }
            goto L_0x0019;
        L_0x0146:
            r2 = r9.mo2809b(r0);	 Catch:{ Exception -> 0x011a }
            r8.m19628c(r2);	 Catch:{ Exception -> 0x011a }
            goto L_0x0019;
        L_0x014f:
            r2 = r9.mo2809b(r0);	 Catch:{ Exception -> 0x011a }
            r8.m19631d(r2);	 Catch:{ Exception -> 0x011a }
            goto L_0x0019;
        L_0x0158:
            r2 = r9.mo2809b(r0);	 Catch:{ Exception -> 0x011a }
            r8.m19633e(r2);	 Catch:{ Exception -> 0x011a }
            goto L_0x0019;
        L_0x0161:
            r2 = r9.mo2809b(r0);	 Catch:{ Exception -> 0x011a }
            r8.m19635f(r2);	 Catch:{ Exception -> 0x011a }
            goto L_0x0019;
        L_0x016a:
            r2 = r9.mo2809b(r0);	 Catch:{ Exception -> 0x011a }
            r8.m19637g(r2);	 Catch:{ Exception -> 0x011a }
            goto L_0x0019;
        L_0x0173:
            r2 = r9.mo2809b(r0);	 Catch:{ Exception -> 0x011a }
            r8.m19638h(r2);	 Catch:{ Exception -> 0x011a }
            goto L_0x0019;
        L_0x017c:
            r2 = r9.mo2811d(r0);	 Catch:{ Exception -> 0x011a }
            r8.m19621a(r2);	 Catch:{ Exception -> 0x011a }
            goto L_0x0019;
        L_0x0185:
            r2 = r9.mo2811d(r0);	 Catch:{ Exception -> 0x011a }
            r8.m19626b(r2);	 Catch:{ Exception -> 0x011a }
            goto L_0x0019;
        L_0x018e:
            r2 = r9.mo2810c(r0);	 Catch:{ Exception -> 0x011a }
            r8.m19620a(r2);	 Catch:{ Exception -> 0x011a }
            goto L_0x0019;
        L_0x0197:
            r2 = r9.mo2810c(r0);	 Catch:{ Exception -> 0x011a }
            r8.m19625b(r2);	 Catch:{ Exception -> 0x011a }
            goto L_0x0019;
        L_0x01a0:
            r6 = r9.mo2814g(r0);	 Catch:{ Exception -> 0x011a }
            r8.m19616a(r6);	 Catch:{ Exception -> 0x011a }
            goto L_0x0019;
        L_0x01a9:
            r2 = r9.mo2810c(r0);	 Catch:{ Exception -> 0x011a }
            r8.m19629c(r2);	 Catch:{ Exception -> 0x011a }
            goto L_0x0019;
        L_0x01b2:
            r2 = r9.mo2809b(r0);	 Catch:{ Exception -> 0x011a }
            r5 = 3;
            r2 = com.urbanairship.C3783j.m19720a(r2, r5);	 Catch:{ Exception -> 0x011a }
            r8.m19627c(r2);	 Catch:{ Exception -> 0x011a }
            goto L_0x0019;
        L_0x01c0:
            r2 = r9.mo2809b(r0);	 Catch:{ Exception -> 0x011a }
            r5 = 6;
            r2 = com.urbanairship.C3783j.m19720a(r2, r5);	 Catch:{ Exception -> 0x011a }
            r8.m19630d(r2);	 Catch:{ Exception -> 0x011a }
            goto L_0x0019;
        L_0x01ce:
            r2 = r9.mo2810c(r0);	 Catch:{ Exception -> 0x011a }
            r8.m19632d(r2);	 Catch:{ Exception -> 0x011a }
            goto L_0x0019;
        L_0x01d7:
            r2 = r9.mo2810c(r0);	 Catch:{ Exception -> 0x011a }
            r8.m19634e(r2);	 Catch:{ Exception -> 0x011a }
            goto L_0x0019;
        L_0x01e0:
            r2 = r9.mo2810c(r0);	 Catch:{ Exception -> 0x011a }
            r8.m19636f(r2);	 Catch:{ Exception -> 0x011a }
            goto L_0x0019;
        L_0x01e9:
            r2 = r9.mo2812e(r0);	 Catch:{ Exception -> 0x011a }
            r8.m19615a(r2);	 Catch:{ Exception -> 0x011a }
            goto L_0x0019;
        L_0x01f2:
            r2 = r9.mo2813f(r0);	 Catch:{ Exception -> 0x011a }
            r8.m19623b(r2);	 Catch:{ Exception -> 0x011a }
            goto L_0x0019;
        L_0x01fb:
            r2 = r9.mo2809b(r0);	 Catch:{ Exception -> 0x011a }
            r8.m19639i(r2);	 Catch:{ Exception -> 0x011a }
            goto L_0x0019;
        L_0x0204:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.b.a.a(com.urbanairship.h):void");
        }

        public C3755a m19615a(int i) {
            this.f13479t = i;
            return this;
        }

        public C3755a m19623b(int i) {
            this.f13480u = i;
            return this;
        }

        public C3755a m19619a(String str) {
            this.f13460a = str;
            return this;
        }

        public C3755a m19624b(String str) {
            this.f13461b = str;
            return this;
        }

        public C3755a m19628c(String str) {
            this.f13462c = str;
            return this;
        }

        public C3755a m19631d(String str) {
            this.f13463d = str;
            return this;
        }

        public C3755a m19633e(String str) {
            this.f13464e = str;
            return this;
        }

        public C3755a m19635f(String str) {
            this.f13465f = str;
            return this;
        }

        public C3755a m19637g(String str) {
            this.f13466g = str;
            return this;
        }

        public C3755a m19638h(String str) {
            this.f13467h = str;
            return this;
        }

        public C3755a m19621a(String[] strArr) {
            this.f13468i = strArr;
            return this;
        }

        public C3755a m19626b(String[] strArr) {
            this.f13469j = strArr;
            return this;
        }

        public C3755a m19620a(boolean z) {
            this.f13470k = z;
            return this;
        }

        public C3755a m19625b(boolean z) {
            this.f13471l = z;
            return this;
        }

        public C3755a m19616a(long j) {
            this.f13472m = j;
            return this;
        }

        public C3755a m19629c(boolean z) {
            this.f13473n = z;
            return this;
        }

        public C3755a m19627c(int i) {
            this.f13474o = i;
            return this;
        }

        public C3755a m19630d(int i) {
            this.f13475p = i;
            return this;
        }

        public C3755a m19632d(boolean z) {
            this.f13476q = z;
            return this;
        }

        public C3755a m19634e(boolean z) {
            this.f13477r = z;
            return this;
        }

        public C3755a m19636f(boolean z) {
            this.f13478s = z;
            return this;
        }

        public C3755a m19639i(String str) {
            this.f13481v = str;
            return this;
        }

        public C3761b m19622a() {
            String str = this.f13470k ? "production" : "development";
            String str2 = this.f13470k ? this.f13460a : this.f13462c;
            if (str2 == null || str2.length() == 0 || str2.indexOf(32) > 0) {
                throw new IllegalArgumentException("AirshipConfigOptions: " + str2 + " is not a valid " + str + " app key");
            }
            str2 = this.f13470k ? this.f13461b : this.f13463d;
            if (str2 == null || str2.length() == 0 || str2.indexOf(32) > 0) {
                throw new IllegalArgumentException("AirshipConfigOptions: " + str2 + " is not a valid " + str + " app secret");
            } else if (this.f13471l && C3954i.m20512a(this.f13465f)) {
                throw new IllegalArgumentException("Invalid config - analyticsServer is empty or null.");
            } else if (C3954i.m20512a(this.f13464e)) {
                throw new IllegalArgumentException("Invalid config - hostURL is empty or null.");
            } else {
                if (this.f13472m < 60000) {
                    C3783j.m19721a("AirshipConfigOptions - The backgroundReportingIntervalMS " + this.f13472m + " may decrease battery life.");
                } else if (this.f13472m > 86400000) {
                    C3783j.m19721a("AirshipConfigOptions - The backgroundReportingIntervalMS " + this.f13472m + " may provide less detailed analytic reports.");
                }
                if (this.f13460a != null && this.f13460a.equals(this.f13462c)) {
                    C3783j.m19721a("Production App Key matches Development App Key");
                }
                if (this.f13461b != null && this.f13461b.equals(this.f13463d)) {
                    C3783j.m19721a("Production App Secret matches Development App Secret");
                }
                return new C3761b();
            }
        }
    }

    private C3761b(C3755a c3755a) {
        this.f13501a = c3755a.f13460a;
        this.f13502b = c3755a.f13461b;
        this.f13503c = c3755a.f13462c;
        this.f13504d = c3755a.f13463d;
        this.f13505e = c3755a.f13464e;
        this.f13506f = c3755a.f13465f;
        this.f13507g = c3755a.f13466g;
        this.f13508h = c3755a.f13467h;
        this.f13509i = c3755a.f13468i;
        this.f13510j = c3755a.f13469j;
        this.f13511k = c3755a.f13470k;
        this.f13512l = c3755a.f13471l;
        this.f13513m = c3755a.f13472m;
        this.f13514n = c3755a.f13473n;
        this.f13515o = c3755a.f13474o;
        this.f13516p = c3755a.f13475p;
        this.f13517q = c3755a.f13476q;
        this.f13518r = c3755a.f13477r;
        this.f13519s = c3755a.f13478s;
        this.f13520t = c3755a.f13479t;
        this.f13522v = c3755a.f13480u;
        this.f13521u = c3755a.f13481v;
    }

    public String m19664a() {
        return this.f13511k ? this.f13501a : this.f13503c;
    }

    public String m19666b() {
        return this.f13511k ? this.f13502b : this.f13504d;
    }

    public int m19667c() {
        return this.f13511k ? this.f13516p : this.f13515o;
    }

    public boolean m19665a(String str) {
        if (this.f13509i == null || str == null) {
            return false;
        }
        for (String equalsIgnoreCase : this.f13509i) {
            if (str.equalsIgnoreCase(equalsIgnoreCase)) {
                return true;
            }
        }
        return false;
    }
}
