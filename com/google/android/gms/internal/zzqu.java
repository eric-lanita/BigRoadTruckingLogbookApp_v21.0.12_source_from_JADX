package com.google.android.gms.internal;

import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public class zzqu extends zzpo<Status> {
    @Deprecated
    public zzqu(Looper looper) {
        super(looper);
    }

    public zzqu(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    protected Status m17512a(Status status) {
        return status;
    }

    protected /* synthetic */ Result zzc(Status status) {
        return m17512a(status);
    }
}
