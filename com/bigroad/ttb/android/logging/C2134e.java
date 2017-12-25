package com.bigroad.ttb.android.logging;

import com.bigroad.shared.MobileAppDiagnosticFlags;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public final class C2134e {
    private static final C2127h f7455a = new C2147l();
    private static C2127h f7456b = f7455a;

    private static void m10675b(int i, String str, String str2, Throwable th) {
        Writer stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        f7456b.mo1242a(i, str, str2 + " " + stringWriter.toString());
    }

    private static void m10669a(long j, int i, String str, String str2, Throwable th) {
        Writer stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        f7456b.mo1243a(j, i, str, str2 + " " + stringWriter.toString());
    }

    public static void m10672a(C2127h c2127h) {
        f7456b = c2127h;
    }

    public static void m10673a(String str, String str2) {
        f7456b.mo1242a(2, str, str2);
    }

    public static void m10676b(String str, String str2) {
        f7456b.mo1242a(3, str, str2);
    }

    public static void m10674a(String str, String str2, Throwable th) {
        C2134e.m10675b(3, str, str2, th);
    }

    public static void m10678c(String str, String str2) {
        f7456b.mo1242a(4, str, str2);
    }

    public static void m10677b(String str, String str2, Throwable th) {
        C2134e.m10675b(4, str, str2, th);
    }

    public static void m10680d(String str, String str2) {
        f7456b.mo1242a(5, str, str2);
    }

    public static void m10679c(String str, String str2, Throwable th) {
        C2134e.m10675b(5, str, str2, th);
    }

    public static void m10682e(String str, String str2) {
        f7456b.mo1242a(6, str, str2);
    }

    public static void m10681d(String str, String str2, Throwable th) {
        C2134e.m10675b(6, str, str2, th);
    }

    public static void m10667a(int i, String str, String str2) {
        f7456b.mo1242a(i, str, str2);
    }

    public static void m10668a(int i, String str, String str2, Throwable th) {
        C2134e.m10675b(i, str, str2, th);
    }

    public static void m10670a(MobileAppDiagnosticFlags mobileAppDiagnosticFlags, int i, String str, String str2) {
        f7456b.mo1243a(mobileAppDiagnosticFlags.m4088a(), i, str, str2);
    }

    public static void m10671a(MobileAppDiagnosticFlags mobileAppDiagnosticFlags, int i, String str, String str2, Throwable th) {
        C2134e.m10669a(mobileAppDiagnosticFlags.m4088a(), i, str, str2, th);
    }

    public static void m10666a() {
        f7456b.mo1241a();
    }
}
