package com.google.common.p050a;

import com.google.common.base.Preconditions;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Map;

public final class C3465b {
    private static final char[][] f12901b = ((char[][]) Array.newInstance(Character.TYPE, new int[]{0, 0}));
    private final char[][] f12902a;

    public static C3465b m18301a(Map<Character, String> map) {
        return new C3465b(C3465b.m18302b(map));
    }

    private C3465b(char[][] cArr) {
        this.f12902a = cArr;
    }

    char[][] m18303a() {
        return this.f12902a;
    }

    static char[][] m18302b(Map<Character, String> map) {
        Preconditions.checkNotNull(map);
        if (map.isEmpty()) {
            return f12901b;
        }
        char[][] cArr = new char[(((Character) Collections.max(map.keySet())).charValue() + 1)][];
        for (Character charValue : map.keySet()) {
            char charValue2 = charValue.charValue();
            cArr[charValue2] = ((String) map.get(Character.valueOf(charValue2))).toCharArray();
        }
        return cArr;
    }
}
