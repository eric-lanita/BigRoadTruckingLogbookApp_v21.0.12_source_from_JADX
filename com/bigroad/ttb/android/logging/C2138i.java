package com.bigroad.ttb.android.logging;

import com.bigroad.shared.RemoteLogPriority;
import com.bigroad.ttb.protocol.TTProtocol;
import com.google.android.gms.maps.model.LatLng;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

public final class C2138i {
    private static final SimpleDateFormat f7464a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);

    static {
        f7464a.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    public static char m10688a(int i) {
        return C2138i.m10693b(i).m4099a();
    }

    public static RemoteLogPriority m10693b(int i) {
        switch (i) {
            case 2:
                return RemoteLogPriority.VERBOSE;
            case 3:
                return RemoteLogPriority.DEBUG;
            case 4:
                return RemoteLogPriority.INFO;
            case 5:
                return RemoteLogPriority.WARN;
            case 6:
                return RemoteLogPriority.ERROR;
            case 7:
                return RemoteLogPriority.ASSERT;
            default:
                return RemoteLogPriority.UNKNOWN;
        }
    }

    public static int m10689a(TTProtocol.RemoteLogPriority remoteLogPriority) {
        switch (remoteLogPriority) {
            case DEBUG_PRIORITY:
                return 3;
            case INFO_PRIORITY:
                return 4;
            case WARN_PRIORITY:
                return 5;
            case ERROR_PRIORITY:
                return 6;
            case ASSERT_PRIORITY:
                return 7;
            default:
                return 2;
        }
    }

    public static String m10690a(long j) {
        String format;
        synchronized (f7464a) {
            format = f7464a.format(Long.valueOf(j));
        }
        return format;
    }

    public static String m10692a(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static String m10691a(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        return "(" + ((int) (latLng.latitude * 1000000.0d)) + ", " + ((int) (latLng.latitude * 1000000.0d)) + ")";
    }
}
