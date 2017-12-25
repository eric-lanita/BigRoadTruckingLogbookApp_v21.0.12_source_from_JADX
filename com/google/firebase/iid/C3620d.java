package com.google.firebase.iid;

import android.text.TextUtils;

public class C3620d {
    private static final Object f13130a = new Object();
    private final C3623f f13131b;

    C3620d(C3623f c3623f) {
        this.f13131b = c3623f;
    }

    String m18915a() {
        String str = null;
        synchronized (f13130a) {
            String string = this.f13131b.m18937a().getString("topic_operaion_queue", null);
            if (string != null) {
                String[] split = string.split(",");
                if (split.length > 1 && !TextUtils.isEmpty(split[1])) {
                    str = split[1];
                }
            }
        }
        return str;
    }

    boolean m18916a(String str) {
        boolean z;
        synchronized (f13130a) {
            String string = this.f13131b.m18937a().getString("topic_operaion_queue", "");
            String valueOf = String.valueOf(",");
            String valueOf2 = String.valueOf(str);
            if (string.startsWith(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf))) {
                valueOf = String.valueOf(",");
                valueOf2 = String.valueOf(str);
                this.f13131b.m18937a().edit().putString("topic_operaion_queue", string.substring((valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).length())).apply();
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }
}
