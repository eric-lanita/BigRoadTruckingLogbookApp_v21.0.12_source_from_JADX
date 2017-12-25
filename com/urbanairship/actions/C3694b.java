package com.urbanairship.actions;

import android.os.Bundle;

public final class C3694b {
    private final int f13327a;
    private final ActionValue f13328b;
    private final Bundle f13329c;

    public C3694b(int i, ActionValue actionValue, Bundle bundle) {
        this.f13327a = i;
        if (actionValue == null) {
            actionValue = new ActionValue();
        }
        this.f13328b = actionValue;
        this.f13329c = bundle == null ? new Bundle() : new Bundle(bundle);
    }

    public ActionValue m19357a() {
        return this.f13328b;
    }

    public int m19358b() {
        return this.f13327a;
    }

    public Bundle m19359c() {
        return this.f13329c;
    }

    public String toString() {
        return "ActionArguments { situation: " + this.f13327a + ", value: " + this.f13328b + ", metadata: " + this.f13329c + " }";
    }
}
