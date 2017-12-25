package com.urbanairship.richpush;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.urbanairship.C3790k;

class RichPushInbox$4 extends ResultReceiver {
    final /* synthetic */ C3790k f13956a;
    final /* synthetic */ C3941b f13957b;

    RichPushInbox$4(C3941b c3941b, Handler handler, C3790k c3790k) {
        this.f13957b = c3941b;
        this.f13956a = c3790k;
        super(handler);
    }

    public void onReceiveResult(int i, Bundle bundle) {
        this.f13957b.f13982j = this.f13957b.f13982j - 1;
        this.f13956a.m19788a(Boolean.valueOf(i == 0));
    }
}
