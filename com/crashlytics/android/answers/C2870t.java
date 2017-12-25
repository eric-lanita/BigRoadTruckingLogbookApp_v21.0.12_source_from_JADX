package com.crashlytics.android.answers;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import com.facebook.share.internal.ShareConstants;
import io.fabric.sdk.android.services.p046b.C2869a;
import java.io.IOException;
import org.json.JSONObject;

class C2870t implements C2869a<SessionEvent> {
    C2870t() {
    }

    public byte[] m16118a(SessionEvent sessionEvent) {
        return m16120b(sessionEvent).toString().getBytes("UTF-8");
    }

    @TargetApi(9)
    public JSONObject m16120b(SessionEvent sessionEvent) {
        try {
            JSONObject jSONObject = new JSONObject();
            C2868s c2868s = sessionEvent.f9803a;
            jSONObject.put("appBundleId", c2868s.f9877a);
            jSONObject.put("executionId", c2868s.f9878b);
            jSONObject.put("installationId", c2868s.f9879c);
            jSONObject.put("androidId", c2868s.f9880d);
            jSONObject.put("advertisingId", c2868s.f9881e);
            jSONObject.put("limitAdTrackingEnabled", c2868s.f9882f);
            jSONObject.put("betaDeviceToken", c2868s.f9883g);
            jSONObject.put("buildId", c2868s.f9884h);
            jSONObject.put("osVersion", c2868s.f9885i);
            jSONObject.put("deviceModel", c2868s.f9886j);
            jSONObject.put("appVersionCode", c2868s.f9887k);
            jSONObject.put("appVersionName", c2868s.f9888l);
            jSONObject.put("timestamp", sessionEvent.f9804b);
            jSONObject.put(ShareConstants.MEDIA_TYPE, sessionEvent.f9805c.toString());
            if (sessionEvent.f9806d != null) {
                jSONObject.put("details", new JSONObject(sessionEvent.f9806d));
            }
            jSONObject.put("customType", sessionEvent.f9807e);
            if (sessionEvent.f9808f != null) {
                jSONObject.put("customAttributes", new JSONObject(sessionEvent.f9808f));
            }
            jSONObject.put("predefinedType", sessionEvent.f9809g);
            if (sessionEvent.f9810h != null) {
                jSONObject.put("predefinedAttributes", new JSONObject(sessionEvent.f9810h));
            }
            return jSONObject;
        } catch (Throwable e) {
            if (VERSION.SDK_INT >= 9) {
                throw new IOException(e.getMessage(), e);
            }
            throw new IOException(e.getMessage());
        }
    }
}
