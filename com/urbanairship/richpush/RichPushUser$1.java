package com.urbanairship.richpush;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.urbanairship.richpush.C3944e.C3932a;
import java.util.ArrayList;
import java.util.Iterator;

class RichPushUser$1 extends ResultReceiver {
    final /* synthetic */ C3944e f13958a;

    RichPushUser$1(C3944e c3944e, Handler handler) {
        this.f13958a = c3944e;
        super(handler);
    }

    protected void onReceiveResult(int i, Bundle bundle) {
        boolean z = i == 0;
        synchronized (this.f13958a.f13999a) {
            Iterator it = new ArrayList(this.f13958a.f13999a).iterator();
            while (it.hasNext()) {
                ((C3932a) it.next()).mo2846a(z);
            }
        }
    }
}
