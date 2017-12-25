package com.google.firebase;

import com.google.android.gms.common.internal.zzab;

public class FirebaseException extends Exception {
    @Deprecated
    protected FirebaseException() {
    }

    public FirebaseException(String str) {
        super(zzab.zzh(str, "Detail message must not be empty"));
    }

    public FirebaseException(String str, Throwable th) {
        super(zzab.zzh(str, "Detail message must not be empty"), th);
    }
}
