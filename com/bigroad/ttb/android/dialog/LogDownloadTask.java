package com.bigroad.ttb.android.dialog;

import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.dialog.ListOptionDialogFragment.C1829a;
import java.io.File;

public class LogDownloadTask extends C1830c {
    private final SendLogOptions f6257a;
    private final int f6258b;
    private final int f6259c;
    private File f6260d;

    public enum SendLogOptions implements C1829a {
        EMAIL(R.string.dailyLog_emailLogButton),
        PRINT(R.string.dailyLog_printLogButton),
        SAVE(R.string.dailyLog_downloadLogButton, false);
        
        private final int m_resId;
        private final boolean m_show;

        private SendLogOptions(int i, boolean z) {
            this.m_resId = i;
            this.m_show = z;
        }

        private SendLogOptions(int i) {
            this(r2, r3, i, true);
        }

        public int mo1069a() {
            return this.m_resId;
        }

        public boolean mo1070b() {
            return this.m_show;
        }
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m8891a((Void[]) objArr);
    }

    public LogDownloadTask(int i, int i2, SendLogOptions sendLogOptions) {
        this.f6257a = sendLogOptions;
        this.f6258b = i;
        if (i2 >= i) {
            i = i2;
        }
        this.f6259c = i;
    }

    public LogDownloadTask(int i, SendLogOptions sendLogOptions) {
        this(i, i, sendLogOptions);
    }

    public SendLogOptions m8890a() {
        return this.f6257a;
    }

    public File m8892b() {
        return this.f6260d;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected java.lang.Void m8891a(java.lang.Void... r13) {
        /*
        r12 = this;
        r0 = 1;
        r1 = 0;
        r2 = com.bigroad.ttb.android.OurApplication.m6285g();	 Catch:{ SocketException -> 0x022c, IOException -> 0x0213, all -> 0x01db }
        r2 = r2.m12210f();	 Catch:{ SocketException -> 0x022c, IOException -> 0x0213, all -> 0x01db }
        r2 = r2.toByteArray();	 Catch:{ SocketException -> 0x022c, IOException -> 0x0213, all -> 0x01db }
        r3 = java.util.TimeZone.getDefault();	 Catch:{ SocketException -> 0x022c, IOException -> 0x0213, all -> 0x01db }
        r4 = new java.util.Date;	 Catch:{ SocketException -> 0x022c, IOException -> 0x0213, all -> 0x01db }
        r4.<init>();	 Catch:{ SocketException -> 0x022c, IOException -> 0x0213, all -> 0x01db }
        r4 = r4.getTime();	 Catch:{ SocketException -> 0x022c, IOException -> 0x0213, all -> 0x01db }
        r3 = r3.getOffset(r4);	 Catch:{ SocketException -> 0x022c, IOException -> 0x0213, all -> 0x01db }
        r4 = new java.lang.StringBuilder;	 Catch:{ SocketException -> 0x022c, IOException -> 0x0213, all -> 0x01db }
        r4.<init>();	 Catch:{ SocketException -> 0x022c, IOException -> 0x0213, all -> 0x01db }
        r5 = "https://";
        r4 = r4.append(r5);	 Catch:{ SocketException -> 0x022c, IOException -> 0x0213, all -> 0x01db }
        r5 = com.bigroad.ttb.android.OurApplication.m6245B();	 Catch:{ SocketException -> 0x022c, IOException -> 0x0213, all -> 0x01db }
        r5 = r5.m10547b();	 Catch:{ SocketException -> 0x022c, IOException -> 0x0213, all -> 0x01db }
        r4 = r4.append(r5);	 Catch:{ SocketException -> 0x022c, IOException -> 0x0213, all -> 0x01db }
        r5 = "/pdf/daily-logs";
        r4 = r4.append(r5);	 Catch:{ SocketException -> 0x022c, IOException -> 0x0213, all -> 0x01db }
        r5 = "?personId=";
        r4 = r4.append(r5);	 Catch:{ SocketException -> 0x022c, IOException -> 0x0213, all -> 0x01db }
        r5 = com.bigroad.ttb.android.OurApplication.m6285g();	 Catch:{ SocketException -> 0x022c, IOException -> 0x0213, all -> 0x01db }
        r6 = r5.m12202d();	 Catch:{ SocketException -> 0x022c, IOException -> 0x0213, all -> 0x01db }
        r4 = r4.append(r6);	 Catch:{ SocketException -> 0x022c, IOException -> 0x0213, all -> 0x01db }
        r5 = "&fleetId=";
        r4 = r4.append(r5);	 Catch:{ SocketException -> 0x022c, IOException -> 0x0213, all -> 0x01db }
        r5 = com.bigroad.ttb.android.OurApplication.m6285g();	 Catch:{ SocketException -> 0x022c, IOException -> 0x0213, all -> 0x01db }
        r6 = r5.m12213g();	 Catch:{ SocketException -> 0x022c, IOException -> 0x0213, all -> 0x01db }
        r4 = r4.append(r6);	 Catch:{ SocketException -> 0x022c, IOException -> 0x0213, all -> 0x01db }
        r5 = "&timezoneOffset=";
        r4 = r4.append(r5);	 Catch:{ SocketException -> 0x022c, IOException -> 0x0213, all -> 0x01db }
        r3 = r4.append(r3);	 Catch:{ SocketException -> 0x022c, IOException -> 0x0213, all -> 0x01db }
        r4 = "&startLogDay=";
        r3 = r3.append(r4);	 Catch:{ SocketException -> 0x022c, IOException -> 0x0213, all -> 0x01db }
        r4 = r12.f6258b;	 Catch:{ SocketException -> 0x022c, IOException -> 0x0213, all -> 0x01db }
        r3 = r3.append(r4);	 Catch:{ SocketException -> 0x022c, IOException -> 0x0213, all -> 0x01db }
        r4 = "&endLogDay=";
        r3 = r3.append(r4);	 Catch:{ SocketException -> 0x022c, IOException -> 0x0213, all -> 0x01db }
        r4 = r12.f6259c;	 Catch:{ SocketException -> 0x022c, IOException -> 0x0213, all -> 0x01db }
        r3 = r3.append(r4);	 Catch:{ SocketException -> 0x022c, IOException -> 0x0213, all -> 0x01db }
        r4 = "&token=";
        r3 = r3.append(r4);	 Catch:{ SocketException -> 0x022c, IOException -> 0x0213, all -> 0x01db }
        r4 = 8;
        r2 = android.util.Base64.encodeToString(r2, r4);	 Catch:{ SocketException -> 0x022c, IOException -> 0x0213, all -> 0x01db }
        r2 = r3.append(r2);	 Catch:{ SocketException -> 0x022c, IOException -> 0x0213, all -> 0x01db }
        r2 = r2.toString();	 Catch:{ SocketException -> 0x022c, IOException -> 0x0213, all -> 0x01db }
        r3 = "TT-LogDownloadTask";
        r4 = new java.lang.StringBuilder;	 Catch:{ SocketException -> 0x022c, IOException -> 0x0213, all -> 0x01db }
        r4.<init>();	 Catch:{ SocketException -> 0x022c, IOException -> 0x0213, all -> 0x01db }
        r5 = "Downloading daily log PDF from ";
        r4 = r4.append(r5);	 Catch:{ SocketException -> 0x022c, IOException -> 0x0213, all -> 0x01db }
        r4 = r4.append(r2);	 Catch:{ SocketException -> 0x022c, IOException -> 0x0213, all -> 0x01db }
        r4 = r4.toString();	 Catch:{ SocketException -> 0x022c, IOException -> 0x0213, all -> 0x01db }
        com.bigroad.ttb.android.logging.C2134e.m10678c(r3, r4);	 Catch:{ SocketException -> 0x022c, IOException -> 0x0213, all -> 0x01db }
        r3 = new java.net.URL;	 Catch:{ SocketException -> 0x022c, IOException -> 0x0213, all -> 0x01db }
        r3.<init>(r2);	 Catch:{ SocketException -> 0x022c, IOException -> 0x0213, all -> 0x01db }
        r4 = com.bigroad.ttb.android.util.C2283e.m11197a(r3);	 Catch:{ SocketException -> 0x022c, IOException -> 0x0213, all -> 0x01db }
        r3 = 0;
        r4.setUseCaches(r3);	 Catch:{ SocketException -> 0x0233, IOException -> 0x0219, all -> 0x01f0 }
        r3 = r4.getResponseCode();	 Catch:{ SocketException -> 0x0233, IOException -> 0x0219, all -> 0x01f0 }
        switch(r3) {
            case 200: goto L_0x010d;
            default: goto L_0x00c2;
        };	 Catch:{ SocketException -> 0x0233, IOException -> 0x0219, all -> 0x01f0 }
    L_0x00c2:
        r0 = "TT-LogDownloadTask";
        r3 = new java.lang.StringBuilder;	 Catch:{ SocketException -> 0x0233, IOException -> 0x0219, all -> 0x01f0 }
        r3.<init>();	 Catch:{ SocketException -> 0x0233, IOException -> 0x0219, all -> 0x01f0 }
        r5 = "Could not download log from ";
        r3 = r3.append(r5);	 Catch:{ SocketException -> 0x0233, IOException -> 0x0219, all -> 0x01f0 }
        r2 = r3.append(r2);	 Catch:{ SocketException -> 0x0233, IOException -> 0x0219, all -> 0x01f0 }
        r3 = " -- Response code: ";
        r2 = r2.append(r3);	 Catch:{ SocketException -> 0x0233, IOException -> 0x0219, all -> 0x01f0 }
        r3 = r4.getResponseCode();	 Catch:{ SocketException -> 0x0233, IOException -> 0x0219, all -> 0x01f0 }
        r2 = r2.append(r3);	 Catch:{ SocketException -> 0x0233, IOException -> 0x0219, all -> 0x01f0 }
        r3 = ": ";
        r2 = r2.append(r3);	 Catch:{ SocketException -> 0x0233, IOException -> 0x0219, all -> 0x01f0 }
        r3 = r4.getResponseMessage();	 Catch:{ SocketException -> 0x0233, IOException -> 0x0219, all -> 0x01f0 }
        r2 = r2.append(r3);	 Catch:{ SocketException -> 0x0233, IOException -> 0x0219, all -> 0x01f0 }
        r2 = r2.toString();	 Catch:{ SocketException -> 0x0233, IOException -> 0x0219, all -> 0x01f0 }
        com.bigroad.ttb.android.logging.C2134e.m10682e(r0, r2);	 Catch:{ SocketException -> 0x0233, IOException -> 0x0219, all -> 0x01f0 }
        r0 = 1;
        r12.m8887a(r0);	 Catch:{ SocketException -> 0x0233, IOException -> 0x0219, all -> 0x01f0 }
        r0 = r1;
        r2 = r1;
    L_0x00fc:
        com.bigroad.shared.C1181z.m5999a(r2);
        com.bigroad.shared.C1181z.m5999a(r0);
        if (r4 == 0) goto L_0x0107;
    L_0x0104:
        r4.disconnect();
    L_0x0107:
        if (r1 == 0) goto L_0x010c;
    L_0x0109:
        r1.delete();
    L_0x010c:
        return r1;
    L_0x010d:
        r2 = r4.getInputStream();	 Catch:{ SocketException -> 0x0233, IOException -> 0x0219, all -> 0x01f0 }
        r3 = "Content-Disposition";
        r3 = r4.getHeaderField(r3);	 Catch:{ SocketException -> 0x023a, IOException -> 0x021e, all -> 0x01f4 }
        if (r3 == 0) goto L_0x0175;
    L_0x0119:
        r5 = "\"";
        r3 = r3.split(r5);	 Catch:{ SocketException -> 0x023a, IOException -> 0x021e, all -> 0x01f4 }
        r5 = 1;
        r3 = r3[r5];	 Catch:{ SocketException -> 0x023a, IOException -> 0x021e, all -> 0x01f4 }
        r7 = r3;
    L_0x0123:
        r3 = r12.f6257a;	 Catch:{ SocketException -> 0x023a, IOException -> 0x021e, all -> 0x01f4 }
        r5 = com.bigroad.ttb.android.dialog.LogDownloadTask.SendLogOptions.PRINT;	 Catch:{ SocketException -> 0x023a, IOException -> 0x021e, all -> 0x01f4 }
        r3 = r3.equals(r5);	 Catch:{ SocketException -> 0x023a, IOException -> 0x021e, all -> 0x01f4 }
        if (r3 == 0) goto L_0x0179;
    L_0x012d:
        r0 = com.bigroad.ttb.android.OurApplication.ao();	 Catch:{ SocketException -> 0x023a, IOException -> 0x021e, all -> 0x01f4 }
        r5 = new java.io.File;	 Catch:{ SocketException -> 0x023a, IOException -> 0x021e, all -> 0x01f4 }
        r5.<init>(r0, r7);	 Catch:{ SocketException -> 0x023a, IOException -> 0x021e, all -> 0x01f4 }
    L_0x0136:
        r5.createNewFile();	 Catch:{ SocketException -> 0x0247, IOException -> 0x0227, all -> 0x01fd }
        r0 = new java.io.FileOutputStream;	 Catch:{ SocketException -> 0x0247, IOException -> 0x0227, all -> 0x01fd }
        r3 = 0;
        r0.<init>(r5, r3);	 Catch:{ SocketException -> 0x0247, IOException -> 0x0227, all -> 0x01fd }
        r3 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r3 = new byte[r3];	 Catch:{ SocketException -> 0x0152, IOException -> 0x01b8, all -> 0x0203 }
    L_0x0143:
        r6 = r12.isCancelled();	 Catch:{ SocketException -> 0x0152, IOException -> 0x01b8, all -> 0x0203 }
        if (r6 != 0) goto L_0x014f;
    L_0x0149:
        r6 = r2.read(r3);	 Catch:{ SocketException -> 0x0152, IOException -> 0x01b8, all -> 0x0203 }
        if (r6 >= 0) goto L_0x01b3;
    L_0x014f:
        r12.f6260d = r5;	 Catch:{ SocketException -> 0x0152, IOException -> 0x01b8, all -> 0x0203 }
        goto L_0x00fc;
    L_0x0152:
        r3 = move-exception;
        r11 = r3;
        r3 = r5;
        r5 = r2;
        r2 = r4;
        r4 = r0;
        r0 = r11;
    L_0x0159:
        r6 = "TT-LogDownloadTask";
        r7 = "Connection lost during transfer";
        com.bigroad.ttb.android.logging.C2134e.m10681d(r6, r7, r0);	 Catch:{ all -> 0x020a }
        r0 = 1;
        r12.m8887a(r0);	 Catch:{ all -> 0x020a }
        com.bigroad.shared.C1181z.m5999a(r5);
        com.bigroad.shared.C1181z.m5999a(r4);
        if (r2 == 0) goto L_0x016f;
    L_0x016c:
        r2.disconnect();
    L_0x016f:
        if (r3 == 0) goto L_0x010c;
    L_0x0171:
        r3.delete();
        goto L_0x010c;
    L_0x0175:
        r3 = "BigRoad Driver Log.pdf";
        r7 = r3;
        goto L_0x0123;
    L_0x0179:
        r3 = android.os.Environment.DIRECTORY_DOWNLOADS;	 Catch:{ SocketException -> 0x023a, IOException -> 0x021e, all -> 0x01f4 }
        r8 = android.os.Environment.getExternalStoragePublicDirectory(r3);	 Catch:{ SocketException -> 0x023a, IOException -> 0x021e, all -> 0x01f4 }
        r3 = new java.io.File;	 Catch:{ SocketException -> 0x023a, IOException -> 0x021e, all -> 0x01f4 }
        r3.<init>(r8, r7);	 Catch:{ SocketException -> 0x023a, IOException -> 0x021e, all -> 0x01f4 }
    L_0x0184:
        r5 = r3.exists();	 Catch:{ SocketException -> 0x0241, IOException -> 0x0223, all -> 0x01f8 }
        if (r5 == 0) goto L_0x024e;
    L_0x018a:
        r6 = new java.io.File;	 Catch:{ SocketException -> 0x0241, IOException -> 0x0223, all -> 0x01f8 }
        r9 = ".pdf";
        r5 = new java.lang.StringBuilder;	 Catch:{ SocketException -> 0x0241, IOException -> 0x0223, all -> 0x01f8 }
        r5.<init>();	 Catch:{ SocketException -> 0x0241, IOException -> 0x0223, all -> 0x01f8 }
        r10 = " (";
        r10 = r5.append(r10);	 Catch:{ SocketException -> 0x0241, IOException -> 0x0223, all -> 0x01f8 }
        r5 = r0 + 1;
        r0 = r10.append(r0);	 Catch:{ SocketException -> 0x0241, IOException -> 0x0223, all -> 0x01f8 }
        r10 = ").pdf";
        r0 = r0.append(r10);	 Catch:{ SocketException -> 0x0241, IOException -> 0x0223, all -> 0x01f8 }
        r0 = r0.toString();	 Catch:{ SocketException -> 0x0241, IOException -> 0x0223, all -> 0x01f8 }
        r0 = r7.replace(r9, r0);	 Catch:{ SocketException -> 0x0241, IOException -> 0x0223, all -> 0x01f8 }
        r6.<init>(r8, r0);	 Catch:{ SocketException -> 0x0241, IOException -> 0x0223, all -> 0x01f8 }
        r0 = r5;
        r3 = r6;
        goto L_0x0184;
    L_0x01b3:
        r7 = 0;
        r0.write(r3, r7, r6);	 Catch:{ SocketException -> 0x0152, IOException -> 0x01b8, all -> 0x0203 }
        goto L_0x0143;
    L_0x01b8:
        r3 = move-exception;
        r11 = r3;
        r3 = r5;
        r5 = r2;
        r2 = r0;
        r0 = r11;
    L_0x01be:
        r6 = "TT-LogDownloadTask";
        r7 = "Error saving log to downloads folder";
        com.bigroad.ttb.android.logging.C2134e.m10681d(r6, r7, r0);	 Catch:{ all -> 0x0210 }
        r0 = 1;
        r12.m8887a(r0);	 Catch:{ all -> 0x0210 }
        com.bigroad.shared.C1181z.m5999a(r5);
        com.bigroad.shared.C1181z.m5999a(r2);
        if (r4 == 0) goto L_0x01d4;
    L_0x01d1:
        r4.disconnect();
    L_0x01d4:
        if (r3 == 0) goto L_0x010c;
    L_0x01d6:
        r3.delete();
        goto L_0x010c;
    L_0x01db:
        r0 = move-exception;
        r4 = r1;
        r2 = r1;
        r5 = r1;
    L_0x01df:
        com.bigroad.shared.C1181z.m5999a(r5);
        com.bigroad.shared.C1181z.m5999a(r2);
        if (r4 == 0) goto L_0x01ea;
    L_0x01e7:
        r4.disconnect();
    L_0x01ea:
        if (r1 == 0) goto L_0x01ef;
    L_0x01ec:
        r1.delete();
    L_0x01ef:
        throw r0;
    L_0x01f0:
        r0 = move-exception;
        r2 = r1;
        r5 = r1;
        goto L_0x01df;
    L_0x01f4:
        r0 = move-exception;
        r5 = r2;
        r2 = r1;
        goto L_0x01df;
    L_0x01f8:
        r0 = move-exception;
        r5 = r2;
        r2 = r1;
        r1 = r3;
        goto L_0x01df;
    L_0x01fd:
        r0 = move-exception;
        r11 = r5;
        r5 = r2;
        r2 = r1;
        r1 = r11;
        goto L_0x01df;
    L_0x0203:
        r1 = move-exception;
        r11 = r1;
        r1 = r5;
        r5 = r2;
        r2 = r0;
        r0 = r11;
        goto L_0x01df;
    L_0x020a:
        r0 = move-exception;
        r1 = r3;
        r11 = r2;
        r2 = r4;
        r4 = r11;
        goto L_0x01df;
    L_0x0210:
        r0 = move-exception;
        r1 = r3;
        goto L_0x01df;
    L_0x0213:
        r0 = move-exception;
        r4 = r1;
        r3 = r1;
        r2 = r1;
        r5 = r1;
        goto L_0x01be;
    L_0x0219:
        r0 = move-exception;
        r3 = r1;
        r2 = r1;
        r5 = r1;
        goto L_0x01be;
    L_0x021e:
        r0 = move-exception;
        r3 = r1;
        r5 = r2;
        r2 = r1;
        goto L_0x01be;
    L_0x0223:
        r0 = move-exception;
        r5 = r2;
        r2 = r1;
        goto L_0x01be;
    L_0x0227:
        r0 = move-exception;
        r3 = r5;
        r5 = r2;
        r2 = r1;
        goto L_0x01be;
    L_0x022c:
        r0 = move-exception;
        r2 = r1;
        r3 = r1;
        r4 = r1;
        r5 = r1;
        goto L_0x0159;
    L_0x0233:
        r0 = move-exception;
        r2 = r4;
        r3 = r1;
        r5 = r1;
        r4 = r1;
        goto L_0x0159;
    L_0x023a:
        r0 = move-exception;
        r3 = r1;
        r5 = r2;
        r2 = r4;
        r4 = r1;
        goto L_0x0159;
    L_0x0241:
        r0 = move-exception;
        r5 = r2;
        r2 = r4;
        r4 = r1;
        goto L_0x0159;
    L_0x0247:
        r0 = move-exception;
        r3 = r5;
        r5 = r2;
        r2 = r4;
        r4 = r1;
        goto L_0x0159;
    L_0x024e:
        r5 = r3;
        goto L_0x0136;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bigroad.ttb.android.dialog.LogDownloadTask.a(java.lang.Void[]):java.lang.Void");
    }
}
