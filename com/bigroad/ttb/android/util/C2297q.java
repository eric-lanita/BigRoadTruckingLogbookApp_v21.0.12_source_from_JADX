package com.bigroad.ttb.android.util;

import android.util.Base64;
import com.bigroad.shared.ai;
import com.google.protobuf.C2487l;

public class C2297q extends ai {
    public static String m11245a(C2487l c2487l) {
        if (c2487l == null) {
            return "{null}";
        }
        byte[] toByteArray = c2487l.toByteArray();
        return "{" + c2487l.getClass().getName().replace('$', '_') + "=" + Base64.encodeToString(toByteArray, 0, toByteArray.length, 2) + "}";
    }
}
