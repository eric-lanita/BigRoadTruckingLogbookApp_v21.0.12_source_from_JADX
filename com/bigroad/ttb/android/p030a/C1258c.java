package com.bigroad.ttb.android.p030a;

import android.content.ComponentName;
import android.content.Intent;

public abstract class C1258c {
    public static Intent m6615a(ComponentName componentName) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setComponent(componentName);
        intent.addCategory("android.intent.category.LAUNCHER");
        return intent;
    }

    public static Intent m6616b(ComponentName componentName) {
        Intent a = C1258c.m6615a(componentName);
        a.addFlags(335577088);
        return a;
    }
}
