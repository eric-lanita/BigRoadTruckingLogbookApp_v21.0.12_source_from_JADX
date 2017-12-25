package android.support.v4.app;

import android.app.RemoteInput;
import android.app.RemoteInput.Builder;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.aq.C0174a;

class ap {
    static RemoteInput[] m768a(C0174a[] c0174aArr) {
        if (c0174aArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[c0174aArr.length];
        for (int i = 0; i < c0174aArr.length; i++) {
            C0174a c0174a = c0174aArr[i];
            remoteInputArr[i] = new Builder(c0174a.mo130a()).setLabel(c0174a.mo131b()).setChoices(c0174a.mo132c()).setAllowFreeFormInput(c0174a.mo133d()).addExtras(c0174a.mo134e()).build();
        }
        return remoteInputArr;
    }

    static Bundle m767a(Intent intent) {
        return RemoteInput.getResultsFromIntent(intent);
    }
}
