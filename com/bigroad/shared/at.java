package com.bigroad.shared;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class at {
    private static final byte[] f2644a = new byte[]{(byte) 8, (byte) 7, (byte) 6, (byte) 5, (byte) 4, (byte) 3, (byte) 2, (byte) 10, (byte) 0, (byte) 9, (byte) 8, (byte) 7, (byte) 6, (byte) 5, (byte) 4, (byte) 3, (byte) 2};
    private static final Map<String, String> f2645b = new HashMap();
    private final String f2646c;
    private final boolean f2647d;

    static {
        f2645b.put("1A4", "Chrysler");
        f2645b.put("1A8", "Chrysler");
        f2645b.put("1B4", "Dodge");
        f2645b.put("1B5", "Dodge");
        f2645b.put("1B6", "Dodge");
        f2645b.put("1B7", "Dodge");
        f2645b.put("1B8", "Dodge");
        f2645b.put("1C4", "Chrysler");
        f2645b.put("1C6", "Dodge");
        f2645b.put("1C8", "Chrysler");
        f2645b.put("1CA", "Chrysler");
        f2645b.put("1D3", "Dodge");
        f2645b.put("1D4", "Dodge");
        f2645b.put("1D7", "Dodge");
        f2645b.put("1D8", "Dodge");
        f2645b.put("1E5", "Dodge");
        f2645b.put("1E6", "Dodge");
        f2645b.put("1E7", "Dodge");
        f2645b.put("1F4", "Ford");
        f2645b.put("1F6", "Ford");
        f2645b.put("1FA", "Ford");
        f2645b.put("1FB", "Ford");
        f2645b.put("1FC", "Ford");
        f2645b.put("1FD", "Ford");
        f2645b.put("1FF", "Ford");
        f2645b.put("1FM", "Ford");
        f2645b.put("1FT", "Ford");
        f2645b.put("1FU", "Freightliner");
        f2645b.put("1FV", "Freightliner");
        f2645b.put("1G0", "GMC");
        f2645b.put("1G5", "GMC");
        f2645b.put("1GB", "GMC");
        f2645b.put("1GC", "GMC");
        f2645b.put("1GD", "GMC");
        f2645b.put("1GJ", "GMC");
        f2645b.put("1GK", "GMC");
        f2645b.put("1GT", "GMC");
        f2645b.put("1HP", "International");
        f2645b.put("1HS", "International");
        f2645b.put("1HT", "International");
        f2645b.put("1HV", "International");
        f2645b.put("1M1", "Mack");
        f2645b.put("1M2", "Mack");
        f2645b.put("1M3", "Mack");
        f2645b.put("1M4", "Mack");
        f2645b.put("1ND", "Peterbilt");
        f2645b.put("1NK", "Kenworth");
        f2645b.put("1NP", "Peterbilt");
        f2645b.put("1X1", "Peterbilt");
        f2645b.put("1X2", "Peterbilt");
        f2645b.put("1XD", "Peterbilt");
        f2645b.put("1XK", "Kenworth");
        f2645b.put("1XP", "Peterbilt");
        f2645b.put("2A4", "Chrysler");
        f2645b.put("2A8", "Chrysler");
        f2645b.put("2AY", "Hino");
        f2645b.put("2B4", "Dodge");
        f2645b.put("2B5", "Dodge");
        f2645b.put("2B6", "Dodge");
        f2645b.put("2B7", "Dodge");
        f2645b.put("2B8", "Dodge");
        f2645b.put("2C4", "Chrysler");
        f2645b.put("2C8", "Chrysler");
        f2645b.put("2CA", "Chrysler");
        f2645b.put("2CT", "GMC");
        f2645b.put("2D3", "Dodge");
        f2645b.put("2D4", "Dodge");
        f2645b.put("2D6", "Dodge");
        f2645b.put("2D7", "Dodge");
        f2645b.put("2D8", "Dodge");
        f2645b.put("2E5", "Dodge");
        f2645b.put("2E6", "Dodge");
        f2645b.put("2E7", "Dodge");
        f2645b.put("2FB", "Ford");
        f2645b.put("2FC", "Ford");
        f2645b.put("2FD", "Ford");
        f2645b.put("2FF", "Ford");
        f2645b.put("2FM", "Ford");
        f2645b.put("2FT", "Ford");
        f2645b.put("2FU", "Freightliner");
        f2645b.put("2FV", "Freightliner");
        f2645b.put("2FW", "Freightliner");
        f2645b.put("2FZ", "Sterling");
        f2645b.put("2G0", "GMC");
        f2645b.put("2G5", "GMC");
        f2645b.put("2GD", "GMC");
        f2645b.put("2GJ", "GMC");
        f2645b.put("2GK", "GMC");
        f2645b.put("2GT", "GMC");
        f2645b.put("2HP", "International");
        f2645b.put("2HS", "International");
        f2645b.put("2HT", "International");
        f2645b.put("2HV", "International");
        f2645b.put("2M1", "Mack");
        f2645b.put("2M2", "Mack");
        f2645b.put("2M3", "Mack");
        f2645b.put("2M4", "Mack");
        f2645b.put("2MA", "Mack");
        f2645b.put("2MC", "Mack");
        f2645b.put("2MG", "Motor Coach Industries");
        f2645b.put("2MK", "Mack");
        f2645b.put("2NK", "Kenworth");
        f2645b.put("2NP", "Peterbilt");
        f2645b.put("2P9", "Prevost");
        f2645b.put("2PC", "Prevost");
        f2645b.put("2WK", "Western Star");
        f2645b.put("2WL", "Western Star");
        f2645b.put("2WM", "Western Star");
        f2645b.put("2XK", "Kenworth");
        f2645b.put("2XP", "Peterbilt");
        f2645b.put("3AK", "Freightliner");
        f2645b.put("3AL", "Freightliner");
        f2645b.put("3B3", "Dodge");
        f2645b.put("3B4", "Dodge");
        f2645b.put("3B5", "Dodge");
        f2645b.put("3B6", "Dodge");
        f2645b.put("3B7", "Dodge");
        f2645b.put("3B8", "Dodge");
        f2645b.put("3BK", "Kenworth");
        f2645b.put("3BP", "Peterbilt");
        f2645b.put("3C4", "Chrysler");
        f2645b.put("3C6", "Dodge");
        f2645b.put("3C7", "Dodge");
        f2645b.put("3CE", "Volvo");
        f2645b.put("3D3", "Dodge");
        f2645b.put("3D4", "Dodge");
        f2645b.put("3D6", "Dodge");
        f2645b.put("3D7", "Dodge");
        f2645b.put("3E4", "Dodge");
        f2645b.put("3E5", "Dodge");
        f2645b.put("3E6", "Dodge");
        f2645b.put("3E7", "Dodge");
        f2645b.put("3FB", "Ford");
        f2645b.put("3FC", "Ford");
        f2645b.put("3FD", "Ford");
        f2645b.put("3FE", "Ford");
        f2645b.put("3FF", "Ford");
        f2645b.put("3FN", "Kenworth");
        f2645b.put("3FR", "Ford");
        f2645b.put("3FT", "Ford");
        f2645b.put("3GD", "GMC");
        f2645b.put("3GJ", "GMC");
        f2645b.put("3GK", "GMC");
        f2645b.put("3GT", "GMC");
        f2645b.put("3HA", "International");
        f2645b.put("3HB", "International");
        f2645b.put("3HC", "International");
        f2645b.put("3HS", "International");
        f2645b.put("3HT", "International");
        f2645b.put("3HV", "International");
        f2645b.put("3NK", "Kenworth");
        f2645b.put("3NM", "Kenworth");
        f2645b.put("3WK", "Kenworth");
        f2645b.put("3WM", "Kenworth");
        f2645b.put("3WP", "Peterbilt");
        f2645b.put("4DR", "International");
        f2645b.put("4GT", "Isuzu");
        f2645b.put("4KA", "International");
        f2645b.put("4UZ", "Freightliner");
        f2645b.put("4V1", "Volvo");
        f2645b.put("4V2", "Volvo");
        f2645b.put("4V3", "Volvo");
        f2645b.put("4V4", "Volvo");
        f2645b.put("4V5", "Volvo");
        f2645b.put("4V6", "Volvo");
        f2645b.put("4VA", "Volvo");
        f2645b.put("4VG", "Volvo");
        f2645b.put("4VH", "Volvo");
        f2645b.put("4VJ", "Volvo");
        f2645b.put("4VK", "Volvo");
        f2645b.put("4VL", "Volvo");
        f2645b.put("4VM", "Volvo");
        f2645b.put("4VZ", "Volvo");
        f2645b.put("52U", "International");
        f2645b.put("52V", "International");
        f2645b.put("54D", "Isuzu");
        f2645b.put("5CJ", "Western Star");
        f2645b.put("5CK", "Western Star");
        f2645b.put("5KJ", "Western Star");
        f2645b.put("5KK", "Western Star");
        f2645b.put("5PV", "Hino");
        f2645b.put("5RJ", "International");
        f2645b.put("5WE", "International");
        f2645b.put("9BF", "Ford");
        f2645b.put("9DW", "Peterbilt");
        f2645b.put("9F1", "GMC");
        f2645b.put("9F4", "GMC");
        f2645b.put("AFV", "Freightliner");
        f2645b.put("J8D", "GMC");
        f2645b.put("J8T", "GMC");
        f2645b.put("JAL", "Isuzu");
        f2645b.put("JB4", "Dodge");
        f2645b.put("JB5", "Dodge");
        f2645b.put("JB6", "Dodge");
        f2645b.put("JB7", "Dodge");
        f2645b.put("JH6", "Hino");
        f2645b.put("JH7", "Hino");
        f2645b.put("JH8", "Hino");
        f2645b.put("JHA", "Hino");
        f2645b.put("JHB", "Hino");
        f2645b.put("JHC", "Hino");
        f2645b.put("JHH", "Hino");
        f2645b.put("JNA", "Nissan");
        f2645b.put("JPA", "International");
        f2645b.put("JPB", "International");
        f2645b.put("JPE", "International");
        f2645b.put("KFB", "Freightliner");
        f2645b.put("NLT", "Temsa");
        f2645b.put("NM0", "Ford");
        f2645b.put("RSA", "Freightliner");
        f2645b.put("RSB", "Freightliner");
        f2645b.put("SBV", "Kenworth");
        f2645b.put("VG6", "Mack");
        f2645b.put("VG7", "Mack");
        f2645b.put("WCD", "Freightliner");
        f2645b.put("WDA", "Mercedes-Benz");
        f2645b.put("WD0", "Dodge");
        f2645b.put("WD1", "Dodge");
        f2645b.put("WD2", "Dodge");
        f2645b.put("WD3", "Mercedes-Benz");
        f2645b.put("WD5", "Dodge");
        f2645b.put("WD8", "Dodge");
        f2645b.put("WDP", "Freightliner");
        f2645b.put("WDR", "Freightliner");
        f2645b.put("WDW", "Dodge");
        f2645b.put("WDX", "Dodge");
        f2645b.put("WDY", "Freightliner");
        f2645b.put("WDZ", "Mercedes-Benz");
        f2645b.put("YB3", "Volvo");
        f2645b.put("YE2", "Van Hool");
        f2645b.put("YV1", "Volvo");
        f2645b.put("YV2", "Volvo");
        f2645b.put("YV4", "Volvo");
        f2645b.put("YV5", "Volvo");
    }

    private static int m4247a(char c) {
        if (c >= '0' && c <= '9') {
            return c - 48;
        }
        switch (c) {
            case 'A':
                return 1;
            case 'B':
            case 'K':
            case 'S':
                return 2;
            case 'C':
                return 3;
            case 'D':
                return 4;
            case 'E':
                return 5;
            case 'F':
                return 6;
            case 'G':
                return 7;
            case 'H':
                return 8;
            case 'J':
                return 1;
            case 'L':
                return 3;
            case 'M':
                return 4;
            case 'N':
                return 5;
            case 'P':
                return 7;
            case 'R':
                return 9;
            case 'T':
                return 3;
            case 'U':
                return 4;
            case 'V':
                return 5;
            case 'W':
                return 6;
            case 'X':
                return 7;
            case 'Y':
                return 8;
            case 'Z':
                return 9;
            default:
                return 0;
        }
    }

    private static boolean m4249b(char c) {
        if (c != '0' && m4247a(c) == 0) {
            return false;
        }
        return true;
    }

    private static boolean m4248a(String str) {
        if (str.length() != 17) {
            return false;
        }
        boolean z = true;
        for (char c : str.toCharArray()) {
            if (!m4249b(c)) {
                return false;
            }
            if (c != '0') {
                z = false;
            }
        }
        if (z) {
            return false;
        }
        return true;
    }

    private char m4250f() {
        int i = 0;
        if (!m4251a()) {
            return '\u0000';
        }
        int i2 = 0;
        while (i < 17) {
            i2 += m4247a(this.f2646c.charAt(i)) * f2644a[i];
            i++;
        }
        i = i2 % 11;
        return i == 10 ? 'X' : (char) (i + 48);
    }

    public boolean m4251a() {
        return this.f2647d;
    }

    public at(String str) {
        if (str == null) {
            this.f2646c = null;
            this.f2647d = false;
            return;
        }
        String replaceAll = str.replaceAll("^\\s*", "");
        if (replaceAll.length() > 17) {
            replaceAll = replaceAll.substring(0, 17);
        }
        this.f2646c = replaceAll.toUpperCase(Locale.ENGLISH);
        this.f2647d = m4248a(this.f2646c);
    }

    public String m4252b() {
        if (!m4251a()) {
            return null;
        }
        int indexOf = "ABCDEFGHJKLMNPRSTVWXY123456789".indexOf(this.f2646c.charAt(9));
        if (indexOf < 0) {
            return null;
        }
        indexOf += 1980;
        return Integer.toString(Math.max(0, aa.m4138b((Calendar.getInstance().get(1) + 1) - indexOf, "ABCDEFGHJKLMNPRSTVWXY123456789".length())) + indexOf);
    }

    public String m4253c() {
        if (m4251a() && this.f2646c.length() > 3) {
            return (String) f2645b.get(this.f2646c.substring(0, 3));
        }
        return null;
    }

    public boolean m4254d() {
        char f = m4250f();
        return f != '\u0000' && this.f2646c.charAt(8) == f;
    }

    public String m4255e() {
        return this.f2646c;
    }

    public String toString() {
        return this.f2646c == null ? "VinDecoder [m_vin=null]" : this.f2646c;
    }
}
