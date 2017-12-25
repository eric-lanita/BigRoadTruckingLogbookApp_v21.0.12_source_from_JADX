package com.crashlytics.android.answers;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.common.IdManager.DeviceIdentifierType;
import java.util.Map;
import java.util.UUID;

class C2871u {
    private final Context f9890a;
    private final IdManager f9891b;
    private final String f9892c;
    private final String f9893d;

    public C2871u(Context context, IdManager idManager, String str, String str2) {
        this.f9890a = context;
        this.f9891b = idManager;
        this.f9892c = str;
        this.f9893d = str2;
    }

    public C2868s m16121a() {
        Map i = this.f9891b.m20742i();
        return new C2868s(this.f9891b.m20736c(), UUID.randomUUID().toString(), this.f9891b.m20735b(), (String) i.get(DeviceIdentifierType.ANDROID_ID), (String) i.get(DeviceIdentifierType.ANDROID_ADVERTISING_ID), this.f9891b.m20745l(), (String) i.get(DeviceIdentifierType.FONT_TOKEN), CommonUtils.m20726m(this.f9890a), this.f9891b.m20737d(), this.f9891b.m20740g(), this.f9892c, this.f9893d);
    }
}
