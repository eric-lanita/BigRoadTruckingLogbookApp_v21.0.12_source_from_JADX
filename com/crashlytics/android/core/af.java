package com.crashlytics.android.core;

import android.app.ActivityManager.RunningAppProcessInfo;
import android.os.Build.VERSION;
import com.facebook.appevents.AppEventsConstants;
import io.fabric.sdk.android.C3969c;
import io.fabric.sdk.android.services.common.IdManager.DeviceIdentifierType;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class af {
    private static final C2891b f9954a = C2891b.m16252a(AppEventsConstants.EVENT_PARAM_VALUE_NO);
    private static final C2891b f9955b = C2891b.m16252a("Unity");

    public static void m16234a(CodedOutputStream codedOutputStream, String str, String str2, long j) {
        codedOutputStream.m16150a(1, C2891b.m16252a(str2));
        codedOutputStream.m16150a(2, C2891b.m16252a(str));
        codedOutputStream.m16149a(3, j);
    }

    public static void m16236a(CodedOutputStream codedOutputStream, String str, String str2, String str3, String str4, String str5, int i, String str6) {
        C2891b a = C2891b.m16252a(str);
        C2891b a2 = C2891b.m16252a(str2);
        C2891b a3 = C2891b.m16252a(str3);
        C2891b a4 = C2891b.m16252a(str4);
        C2891b a5 = C2891b.m16252a(str5);
        C2891b a6 = str6 != null ? C2891b.m16252a(str6) : null;
        codedOutputStream.m16165g(7, 2);
        codedOutputStream.m16167k(m16218a(a, a2, a3, a4, a5, i, a6));
        codedOutputStream.m16150a(1, a);
        codedOutputStream.m16150a(2, a3);
        codedOutputStream.m16150a(3, a4);
        codedOutputStream.m16165g(5, 2);
        codedOutputStream.m16167k(m16216a(a2));
        codedOutputStream.m16150a(1, a2);
        codedOutputStream.m16150a(6, a5);
        if (a6 != null) {
            codedOutputStream.m16150a(8, f9955b);
            codedOutputStream.m16150a(9, a6);
        }
        codedOutputStream.m16159b(10, i);
    }

    public static void m16239a(CodedOutputStream codedOutputStream, boolean z) {
        C2891b a = C2891b.m16252a(VERSION.RELEASE);
        C2891b a2 = C2891b.m16252a(VERSION.CODENAME);
        codedOutputStream.m16165g(8, 2);
        codedOutputStream.m16167k(m16219a(a, a2, z));
        codedOutputStream.m16159b(1, 3);
        codedOutputStream.m16150a(2, a);
        codedOutputStream.m16150a(3, a2);
        codedOutputStream.m16151a(4, z);
    }

    public static void m16233a(CodedOutputStream codedOutputStream, String str, int i, String str2, int i2, long j, long j2, boolean z, Map<DeviceIdentifierType, String> map, int i3, String str3, String str4) {
        C2891b a = C2891b.m16252a(str);
        C2891b a2 = m16225a(str2);
        C2891b a3 = m16225a(str4);
        C2891b a4 = m16225a(str3);
        codedOutputStream.m16165g(9, 2);
        codedOutputStream.m16167k(m16211a(i, a, a2, i2, j, j2, z, (Map) map, i3, a4, a3));
        codedOutputStream.m16150a(1, a);
        codedOutputStream.m16159b(3, i);
        codedOutputStream.m16150a(4, a2);
        codedOutputStream.m16148a(5, i2);
        codedOutputStream.m16149a(6, j);
        codedOutputStream.m16149a(7, j2);
        codedOutputStream.m16151a(10, z);
        for (Entry entry : map.entrySet()) {
            codedOutputStream.m16165g(11, 2);
            codedOutputStream.m16167k(m16220a((DeviceIdentifierType) entry.getKey(), (String) entry.getValue()));
            codedOutputStream.m16159b(1, ((DeviceIdentifierType) entry.getKey()).protobufIndex);
            codedOutputStream.m16150a(2, C2891b.m16252a((String) entry.getValue()));
        }
        codedOutputStream.m16148a(12, i3);
        if (a4 != null) {
            codedOutputStream.m16150a(13, a4);
        }
        if (a3 != null) {
            codedOutputStream.m16150a(14, a3);
        }
    }

    public static void m16235a(CodedOutputStream codedOutputStream, String str, String str2, String str3) {
        if (str == null) {
            str = "";
        }
        C2891b a = C2891b.m16252a(str);
        C2891b a2 = m16225a(str2);
        C2891b a3 = m16225a(str3);
        int b = 0 + CodedOutputStream.m16128b(1, a);
        if (str2 != null) {
            b += CodedOutputStream.m16128b(2, a2);
        }
        if (str3 != null) {
            b += CodedOutputStream.m16128b(3, a3);
        }
        codedOutputStream.m16165g(6, 2);
        codedOutputStream.m16167k(b);
        codedOutputStream.m16150a(1, a);
        if (str2 != null) {
            codedOutputStream.m16150a(2, a2);
        }
        if (str3 != null) {
            codedOutputStream.m16150a(3, a3);
        }
    }

    public static void m16227a(CodedOutputStream codedOutputStream, long j, String str, ai aiVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, Map<String, String> map, C2954t c2954t, RunningAppProcessInfo runningAppProcessInfo, int i, String str2, String str3, Float f, int i2, boolean z, long j2, long j3) {
        C2891b c2891b;
        C2891b a = C2891b.m16252a(str2);
        if (str3 == null) {
            c2891b = null;
        } else {
            c2891b = C2891b.m16252a(str3.replace("-", ""));
        }
        C2891b a2 = c2954t.m16452a();
        if (a2 == null) {
            C3969c.m20576h().mo2849a("CrashlyticsCore", "No log data to include with this event.");
        }
        c2954t.m16457b();
        codedOutputStream.m16165g(10, 2);
        codedOutputStream.m16167k(m16212a(j, str, aiVar, thread, stackTraceElementArr, threadArr, (List) list, 8, (Map) map, runningAppProcessInfo, i, a, c2891b, f, i2, z, j2, j3, a2));
        codedOutputStream.m16149a(1, j);
        codedOutputStream.m16150a(2, C2891b.m16252a(str));
        m16230a(codedOutputStream, aiVar, thread, stackTraceElementArr, threadArr, (List) list, 8, a, c2891b, (Map) map, runningAppProcessInfo, i);
        m16232a(codedOutputStream, f, i2, z, i, j2, j3);
        m16231a(codedOutputStream, a2);
    }

    private static void m16230a(CodedOutputStream codedOutputStream, ai aiVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, C2891b c2891b, C2891b c2891b2, Map<String, String> map, RunningAppProcessInfo runningAppProcessInfo, int i2) {
        codedOutputStream.m16165g(3, 2);
        codedOutputStream.m16167k(m16215a(aiVar, thread, stackTraceElementArr, threadArr, (List) list, i, c2891b, c2891b2, (Map) map, runningAppProcessInfo, i2));
        m16229a(codedOutputStream, aiVar, thread, stackTraceElementArr, threadArr, list, i, c2891b, c2891b2);
        if (!(map == null || map.isEmpty())) {
            m16238a(codedOutputStream, (Map) map);
        }
        if (runningAppProcessInfo != null) {
            codedOutputStream.m16151a(3, runningAppProcessInfo.importance != 100);
        }
        codedOutputStream.m16148a(4, i2);
    }

    private static void m16229a(CodedOutputStream codedOutputStream, ai aiVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, C2891b c2891b, C2891b c2891b2) {
        codedOutputStream.m16165g(1, 2);
        codedOutputStream.m16167k(m16214a(aiVar, thread, stackTraceElementArr, threadArr, (List) list, i, c2891b, c2891b2));
        m16237a(codedOutputStream, thread, stackTraceElementArr, 4, true);
        int length = threadArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            m16237a(codedOutputStream, threadArr[i2], (StackTraceElement[]) list.get(i2), 0, false);
        }
        m16228a(codedOutputStream, aiVar, 1, i, 2);
        codedOutputStream.m16165g(3, 2);
        codedOutputStream.m16167k(m16210a());
        codedOutputStream.m16150a(1, f9954a);
        codedOutputStream.m16150a(2, f9954a);
        codedOutputStream.m16149a(3, 0);
        codedOutputStream.m16165g(4, 2);
        codedOutputStream.m16167k(m16217a(c2891b, c2891b2));
        codedOutputStream.m16149a(1, 0);
        codedOutputStream.m16149a(2, 0);
        codedOutputStream.m16150a(3, c2891b);
        if (c2891b2 != null) {
            codedOutputStream.m16150a(4, c2891b2);
        }
    }

    private static void m16238a(CodedOutputStream codedOutputStream, Map<String, String> map) {
        for (Entry entry : map.entrySet()) {
            codedOutputStream.m16165g(2, 2);
            codedOutputStream.m16167k(m16223a((String) entry.getKey(), (String) entry.getValue()));
            codedOutputStream.m16150a(1, C2891b.m16252a((String) entry.getKey()));
            String str = (String) entry.getValue();
            if (str == null) {
                str = "";
            }
            codedOutputStream.m16150a(2, C2891b.m16252a(str));
        }
    }

    private static void m16228a(CodedOutputStream codedOutputStream, ai aiVar, int i, int i2, int i3) {
        int i4 = 0;
        codedOutputStream.m16165g(i3, 2);
        codedOutputStream.m16167k(m16213a(aiVar, 1, i2));
        codedOutputStream.m16150a(1, C2891b.m16252a(aiVar.f9960b));
        String str = aiVar.f9959a;
        if (str != null) {
            codedOutputStream.m16150a(3, C2891b.m16252a(str));
        }
        for (StackTraceElement a : aiVar.f9961c) {
            m16226a(codedOutputStream, 4, a, true);
        }
        ai aiVar2 = aiVar.f9962d;
        if (aiVar2 == null) {
            return;
        }
        if (i < i2) {
            m16228a(codedOutputStream, aiVar2, i + 1, i2, 6);
            return;
        }
        while (aiVar2 != null) {
            aiVar2 = aiVar2.f9962d;
            i4++;
        }
        codedOutputStream.m16148a(7, i4);
    }

    private static void m16237a(CodedOutputStream codedOutputStream, Thread thread, StackTraceElement[] stackTraceElementArr, int i, boolean z) {
        codedOutputStream.m16165g(1, 2);
        codedOutputStream.m16167k(m16224a(thread, stackTraceElementArr, i, z));
        codedOutputStream.m16150a(1, C2891b.m16252a(thread.getName()));
        codedOutputStream.m16148a(2, i);
        for (StackTraceElement a : stackTraceElementArr) {
            m16226a(codedOutputStream, 3, a, z);
        }
    }

    private static void m16226a(CodedOutputStream codedOutputStream, int i, StackTraceElement stackTraceElement, boolean z) {
        int i2 = 4;
        codedOutputStream.m16165g(i, 2);
        codedOutputStream.m16167k(m16222a(stackTraceElement, z));
        if (stackTraceElement.isNativeMethod()) {
            codedOutputStream.m16149a(1, (long) Math.max(stackTraceElement.getLineNumber(), 0));
        } else {
            codedOutputStream.m16149a(1, 0);
        }
        codedOutputStream.m16150a(2, C2891b.m16252a(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName()));
        if (stackTraceElement.getFileName() != null) {
            codedOutputStream.m16150a(3, C2891b.m16252a(stackTraceElement.getFileName()));
        }
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            codedOutputStream.m16149a(4, (long) stackTraceElement.getLineNumber());
        }
        if (!z) {
            i2 = 0;
        }
        codedOutputStream.m16148a(5, i2);
    }

    private static void m16232a(CodedOutputStream codedOutputStream, Float f, int i, boolean z, int i2, long j, long j2) {
        codedOutputStream.m16165g(5, 2);
        codedOutputStream.m16167k(m16221a(f, i, z, i2, j, j2));
        if (f != null) {
            codedOutputStream.m16147a(1, f.floatValue());
        }
        codedOutputStream.m16161c(2, i);
        codedOutputStream.m16151a(3, z);
        codedOutputStream.m16148a(4, i2);
        codedOutputStream.m16149a(5, j);
        codedOutputStream.m16149a(6, j2);
    }

    private static void m16231a(CodedOutputStream codedOutputStream, C2891b c2891b) {
        if (c2891b != null) {
            codedOutputStream.m16165g(6, 2);
            codedOutputStream.m16167k(m16240b(c2891b));
            codedOutputStream.m16150a(1, c2891b);
        }
    }

    private static int m16218a(C2891b c2891b, C2891b c2891b2, C2891b c2891b3, C2891b c2891b4, C2891b c2891b5, int i, C2891b c2891b6) {
        int b = ((0 + CodedOutputStream.m16128b(1, c2891b)) + CodedOutputStream.m16128b(2, c2891b3)) + CodedOutputStream.m16128b(3, c2891b4);
        int a = m16216a(c2891b2);
        b = (b + (a + (CodedOutputStream.m16141j(5) + CodedOutputStream.m16142l(a)))) + CodedOutputStream.m16128b(6, c2891b5);
        if (c2891b6 != null) {
            b = (b + CodedOutputStream.m16128b(8, f9955b)) + CodedOutputStream.m16128b(9, c2891b6);
        }
        return b + CodedOutputStream.m16136e(10, i);
    }

    private static int m16216a(C2891b c2891b) {
        return 0 + CodedOutputStream.m16128b(1, c2891b);
    }

    private static int m16219a(C2891b c2891b, C2891b c2891b2, boolean z) {
        return (((0 + CodedOutputStream.m16136e(1, 3)) + CodedOutputStream.m16128b(2, c2891b)) + CodedOutputStream.m16128b(3, c2891b2)) + CodedOutputStream.m16129b(4, z);
    }

    private static int m16220a(DeviceIdentifierType deviceIdentifierType, String str) {
        return CodedOutputStream.m16136e(1, deviceIdentifierType.protobufIndex) + CodedOutputStream.m16128b(2, C2891b.m16252a(str));
    }

    private static int m16211a(int i, C2891b c2891b, C2891b c2891b2, int i2, long j, long j2, boolean z, Map<DeviceIdentifierType, String> map, int i3, C2891b c2891b3, C2891b c2891b4) {
        int i4;
        int i5;
        int e = CodedOutputStream.m16136e(3, i) + (0 + CodedOutputStream.m16128b(1, c2891b));
        if (c2891b2 == null) {
            i4 = 0;
        } else {
            i4 = CodedOutputStream.m16128b(4, c2891b2);
        }
        i4 = ((((i4 + e) + CodedOutputStream.m16133d(5, i2)) + CodedOutputStream.m16127b(6, j)) + CodedOutputStream.m16127b(7, j2)) + CodedOutputStream.m16129b(10, z);
        if (map != null) {
            i5 = i4;
            for (Entry entry : map.entrySet()) {
                i4 = m16220a((DeviceIdentifierType) entry.getKey(), (String) entry.getValue());
                i5 = (i4 + (CodedOutputStream.m16141j(11) + CodedOutputStream.m16142l(i4))) + i5;
            }
        } else {
            i5 = i4;
        }
        return (c2891b4 == null ? 0 : CodedOutputStream.m16128b(14, c2891b4)) + ((i5 + CodedOutputStream.m16133d(12, i3)) + (c2891b3 == null ? 0 : CodedOutputStream.m16128b(13, c2891b3)));
    }

    private static int m16217a(C2891b c2891b, C2891b c2891b2) {
        int b = ((0 + CodedOutputStream.m16127b(1, 0)) + CodedOutputStream.m16127b(2, 0)) + CodedOutputStream.m16128b(3, c2891b);
        if (c2891b2 != null) {
            return b + CodedOutputStream.m16128b(4, c2891b2);
        }
        return b;
    }

    private static int m16212a(long j, String str, ai aiVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, Map<String, String> map, RunningAppProcessInfo runningAppProcessInfo, int i2, C2891b c2891b, C2891b c2891b2, Float f, int i3, boolean z, long j2, long j3, C2891b c2891b3) {
        int b = (0 + CodedOutputStream.m16127b(1, j)) + CodedOutputStream.m16128b(2, C2891b.m16252a(str));
        int a = m16215a(aiVar, thread, stackTraceElementArr, threadArr, (List) list, i, c2891b, c2891b2, (Map) map, runningAppProcessInfo, i2);
        int j4 = b + (a + (CodedOutputStream.m16141j(3) + CodedOutputStream.m16142l(a)));
        a = m16221a(f, i3, z, i2, j2, j3);
        a = (a + (CodedOutputStream.m16141j(5) + CodedOutputStream.m16142l(a))) + j4;
        if (c2891b3 == null) {
            return a;
        }
        int b2 = m16240b(c2891b3);
        return a + (b2 + (CodedOutputStream.m16141j(6) + CodedOutputStream.m16142l(b2)));
    }

    private static int m16215a(ai aiVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, C2891b c2891b, C2891b c2891b2, Map<String, String> map, RunningAppProcessInfo runningAppProcessInfo, int i2) {
        int a = m16214a(aiVar, thread, stackTraceElementArr, threadArr, (List) list, i, c2891b, c2891b2);
        int j = 0 + (a + (CodedOutputStream.m16141j(1) + CodedOutputStream.m16142l(a)));
        if (map != null) {
            int i3 = j;
            for (Entry entry : map.entrySet()) {
                j = m16223a((String) entry.getKey(), (String) entry.getValue());
                i3 = (j + (CodedOutputStream.m16141j(2) + CodedOutputStream.m16142l(j))) + i3;
            }
            a = i3;
        } else {
            a = j;
        }
        if (runningAppProcessInfo != null) {
            j = CodedOutputStream.m16129b(3, runningAppProcessInfo.importance != 100) + a;
        } else {
            j = a;
        }
        return j + CodedOutputStream.m16133d(4, i2);
    }

    private static int m16214a(ai aiVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, C2891b c2891b, C2891b c2891b2) {
        int a;
        int a2 = m16224a(thread, stackTraceElementArr, 4, true);
        a2 = (a2 + (CodedOutputStream.m16141j(1) + CodedOutputStream.m16142l(a2))) + 0;
        int length = threadArr.length;
        int i2 = a2;
        for (a2 = 0; a2 < length; a2++) {
            a = m16224a(threadArr[a2], (StackTraceElement[]) list.get(a2), 0, false);
            i2 += a + (CodedOutputStream.m16141j(1) + CodedOutputStream.m16142l(a));
        }
        a = m16213a(aiVar, 1, i);
        a = (a + (CodedOutputStream.m16141j(2) + CodedOutputStream.m16142l(a))) + i2;
        a2 = m16210a();
        a += a2 + (CodedOutputStream.m16141j(3) + CodedOutputStream.m16142l(a2));
        a2 = m16217a(c2891b, c2891b2);
        return a + (a2 + (CodedOutputStream.m16141j(3) + CodedOutputStream.m16142l(a2)));
    }

    private static int m16223a(String str, String str2) {
        int b = CodedOutputStream.m16128b(1, C2891b.m16252a(str));
        if (str2 == null) {
            str2 = "";
        }
        return b + CodedOutputStream.m16128b(2, C2891b.m16252a(str2));
    }

    private static int m16221a(Float f, int i, boolean z, int i2, long j, long j2) {
        int i3 = 0;
        if (f != null) {
            i3 = 0 + CodedOutputStream.m16126b(1, f.floatValue());
        }
        return ((((i3 + CodedOutputStream.m16138f(2, i)) + CodedOutputStream.m16129b(3, z)) + CodedOutputStream.m16133d(4, i2)) + CodedOutputStream.m16127b(5, j)) + CodedOutputStream.m16127b(6, j2);
    }

    private static int m16240b(C2891b c2891b) {
        return CodedOutputStream.m16128b(1, c2891b);
    }

    private static int m16213a(ai aiVar, int i, int i2) {
        int i3 = 0;
        int b = CodedOutputStream.m16128b(1, C2891b.m16252a(aiVar.f9960b)) + 0;
        String str = aiVar.f9959a;
        if (str != null) {
            b += CodedOutputStream.m16128b(3, C2891b.m16252a(str));
        }
        StackTraceElement[] stackTraceElementArr = aiVar.f9961c;
        int length = stackTraceElementArr.length;
        int i4 = 0;
        while (i4 < length) {
            int a = m16222a(stackTraceElementArr[i4], true);
            i4++;
            b = (a + (CodedOutputStream.m16141j(4) + CodedOutputStream.m16142l(a))) + b;
        }
        ai aiVar2 = aiVar.f9962d;
        if (aiVar2 == null) {
            return b;
        }
        if (i < i2) {
            i3 = m16213a(aiVar2, i + 1, i2);
            return b + (i3 + (CodedOutputStream.m16141j(6) + CodedOutputStream.m16142l(i3)));
        }
        while (aiVar2 != null) {
            aiVar2 = aiVar2.f9962d;
            i3++;
        }
        return b + CodedOutputStream.m16133d(7, i3);
    }

    private static int m16210a() {
        return ((0 + CodedOutputStream.m16128b(1, f9954a)) + CodedOutputStream.m16128b(2, f9954a)) + CodedOutputStream.m16127b(3, 0);
    }

    private static int m16222a(StackTraceElement stackTraceElement, boolean z) {
        int b;
        int i;
        if (stackTraceElement.isNativeMethod()) {
            b = CodedOutputStream.m16127b(1, (long) Math.max(stackTraceElement.getLineNumber(), 0)) + 0;
        } else {
            b = CodedOutputStream.m16127b(1, 0) + 0;
        }
        b += CodedOutputStream.m16128b(2, C2891b.m16252a(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName()));
        if (stackTraceElement.getFileName() != null) {
            b += CodedOutputStream.m16128b(3, C2891b.m16252a(stackTraceElement.getFileName()));
        }
        if (stackTraceElement.isNativeMethod() || stackTraceElement.getLineNumber() <= 0) {
            i = b;
        } else {
            i = b + CodedOutputStream.m16127b(4, (long) stackTraceElement.getLineNumber());
        }
        return CodedOutputStream.m16133d(5, z ? 2 : 0) + i;
    }

    private static int m16224a(Thread thread, StackTraceElement[] stackTraceElementArr, int i, boolean z) {
        int d = CodedOutputStream.m16133d(2, i) + CodedOutputStream.m16128b(1, C2891b.m16252a(thread.getName()));
        for (StackTraceElement a : stackTraceElementArr) {
            int a2 = m16222a(a, z);
            d += a2 + (CodedOutputStream.m16141j(3) + CodedOutputStream.m16142l(a2));
        }
        return d;
    }

    private static C2891b m16225a(String str) {
        return str == null ? null : C2891b.m16252a(str);
    }
}
