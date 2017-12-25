package com.crashlytics.android.p044a;

import org.json.JSONObject;

class C2829g {
    C2829g() {
    }

    public C2828f m15997a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new C2828f(jSONObject.optString("url", null), jSONObject.optString("version_string", null), jSONObject.optString("display_version", null), jSONObject.optString("build_version", null), jSONObject.optString("identifier", null), jSONObject.optString("instance_identifier", null));
    }
}
