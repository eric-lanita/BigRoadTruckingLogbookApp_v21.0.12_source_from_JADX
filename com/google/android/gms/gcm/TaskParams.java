package com.google.android.gms.gcm;

import android.os.Bundle;

public class TaskParams {
    private final String f11021a;
    private final Bundle f11022b;

    public TaskParams(String str) {
        this(str, null);
    }

    public TaskParams(String str, Bundle bundle) {
        this.f11021a = str;
        this.f11022b = bundle;
    }

    public Bundle getExtras() {
        return this.f11022b;
    }

    public String getTag() {
        return this.f11021a;
    }
}
