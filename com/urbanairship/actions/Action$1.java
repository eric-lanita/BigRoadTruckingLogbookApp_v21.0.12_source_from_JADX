package com.urbanairship.actions;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

class Action$1 extends ResultReceiver {
    final /* synthetic */ int[] f13303a;
    final /* synthetic */ C3690a f13304b;

    Action$1(C3690a c3690a, Handler handler, int[] iArr) {
        this.f13304b = c3690a;
        this.f13303a = iArr;
        super(handler);
    }

    public void onReceiveResult(int i, Bundle bundle) {
        int[] intArray = bundle.getIntArray("com.urbanairship.actions.actionactivity.RESULT_INTENT_EXTRA");
        if (intArray != null && intArray.length == this.f13303a.length) {
            for (int i2 = 0; i2 < this.f13303a.length; i2++) {
                this.f13303a[i2] = intArray[i2];
            }
        }
        synchronized (this.f13303a) {
            this.f13303a.notify();
        }
    }
}
