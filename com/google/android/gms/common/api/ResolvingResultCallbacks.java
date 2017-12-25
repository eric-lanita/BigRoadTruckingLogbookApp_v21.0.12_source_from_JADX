package com.google.android.gms.common.api;

import android.app.Activity;
import android.util.Log;

public abstract class ResolvingResultCallbacks<R extends Result> extends ResultCallbacks<R> {
    private final Activity f10552a;
    private final int f10553b;

    public final void onFailure(Status status) {
        if (status.hasResolution()) {
            try {
                status.startResolutionForResult(this.f10552a, this.f10553b);
                return;
            } catch (Throwable e) {
                Log.e("ResolvingResultCallback", "Failed to start resolution", e);
                onUnresolvableFailure(new Status(8));
                return;
            }
        }
        onUnresolvableFailure(status);
    }

    public abstract void onSuccess(R r);

    public abstract void onUnresolvableFailure(Status status);
}
