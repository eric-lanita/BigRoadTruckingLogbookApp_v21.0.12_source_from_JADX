package com.urbanairship;

import android.util.Log;
import com.urbanairship.util.C3954i;

public class C3783j {
    public static int f13563a = 6;
    public static String f13564b = "UALib";

    public static void m19721a(String str) {
        if (f13563a <= 5 && str != null) {
            Log.w(f13564b, str);
        }
    }

    public static void m19722a(String str, Throwable th) {
        if (f13563a <= 5 && str != null && th != null) {
            Log.w(f13564b, str, th);
        }
    }

    public static void m19723b(String str) {
        if (f13563a <= 2 && str != null) {
            Log.v(f13564b, str);
        }
    }

    public static void m19725c(String str) {
        if (f13563a <= 3 && str != null) {
            Log.d(f13564b, str);
        }
    }

    public static void m19724b(String str, Throwable th) {
        if (f13563a <= 3 && str != null && th != null) {
            Log.d(f13564b, str, th);
        }
    }

    public static void m19727d(String str) {
        if (f13563a <= 4 && str != null) {
            Log.i(f13564b, str);
        }
    }

    public static void m19728e(String str) {
        if (f13563a <= 6 && str != null) {
            Log.e(f13564b, str);
        }
    }

    public static void m19726c(String str, Throwable th) {
        if (f13563a <= 6 && str != null && th != null) {
            Log.e(f13564b, str, th);
        }
    }

    static int m19720a(String str, int i) {
        if (C3954i.m20512a(str)) {
            return i;
        }
        String toUpperCase = str.toUpperCase();
        Object obj = -1;
        int i2;
        switch (toUpperCase.hashCode()) {
            case 2251950:
                if (toUpperCase.equals("INFO")) {
                    i2 = 4;
                    break;
                }
                break;
            case 2402104:
                if (toUpperCase.equals("NONE")) {
                    obj = 1;
                    break;
                }
                break;
            case 2656902:
                if (toUpperCase.equals("WARN")) {
                    i2 = 6;
                    break;
                }
                break;
            case 64921139:
                if (toUpperCase.equals("DEBUG")) {
                    i2 = 2;
                    break;
                }
                break;
            case 66247144:
                if (toUpperCase.equals("ERROR")) {
                    i2 = 3;
                    break;
                }
                break;
            case 1069090146:
                if (toUpperCase.equals("VERBOSE")) {
                    i2 = 5;
                    break;
                }
                break;
            case 1940088646:
                if (toUpperCase.equals("ASSERT")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
            case 1:
                return 7;
            case 2:
                return 3;
            case 3:
                return 6;
            case 4:
                return 4;
            case 5:
                return 2;
            case 6:
                return 5;
            default:
                try {
                    int intValue = Integer.valueOf(str).intValue();
                    if (intValue <= 7 && intValue >= 2) {
                        return intValue;
                    }
                    C3783j.m19728e(intValue + " is not a valid log level. Falling back to " + i + ".");
                    return i;
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid log level: " + str);
                }
        }
    }
}
