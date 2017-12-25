package io.fabric.sdk.android.services.settings;

import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.ShareConstants;
import io.fabric.sdk.android.services.common.C4004j;
import org.json.JSONObject;

class C4062k implements C4061u {
    C4062k() {
    }

    public C4072s mo2895a(C4004j c4004j, JSONObject jSONObject) {
        int optInt = jSONObject.optInt("settings_version", 0);
        int optInt2 = jSONObject.optInt("cache_duration", 3600);
        return new C4072s(m20958a(c4004j, (long) optInt2, jSONObject), m20959a(jSONObject.getJSONObject("app")), m20963e(jSONObject.getJSONObject("session")), m20964f(jSONObject.getJSONObject("prompt")), m20961c(jSONObject.getJSONObject("features")), m20962d(jSONObject.getJSONObject("analytics")), m20965g(jSONObject.getJSONObject("beta")), optInt, optInt2);
    }

    private C4054e m20959a(JSONObject jSONObject) {
        String string = jSONObject.getString("identifier");
        String string2 = jSONObject.getString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
        String string3 = jSONObject.getString("url");
        String string4 = jSONObject.getString("reports_url");
        boolean optBoolean = jSONObject.optBoolean("update_required", false);
        C4052c c4052c = null;
        if (jSONObject.has("icon") && jSONObject.getJSONObject("icon").has("hash")) {
            c4052c = m20960b(jSONObject.getJSONObject("icon"));
        }
        return new C4054e(string, string2, string3, string4, optBoolean, c4052c);
    }

    private C4052c m20960b(JSONObject jSONObject) {
        return new C4052c(jSONObject.getString("hash"), jSONObject.getInt("width"), jSONObject.getInt("height"));
    }

    private C4065m m20961c(JSONObject jSONObject) {
        return new C4065m(jSONObject.optBoolean("prompt_enabled", false), jSONObject.optBoolean("collect_logged_exceptions", true), jSONObject.optBoolean("collect_reports", true), jSONObject.optBoolean("collect_analytics", false));
    }

    private C4051b m20962d(JSONObject jSONObject) {
        return new C4051b(jSONObject.optString("url", "https://e.crashlytics.com/spi/v2/events"), jSONObject.optInt("flush_interval_secs", 600), jSONObject.optInt("max_byte_size_per_file", 8000), jSONObject.optInt("max_file_count_per_send", 1), jSONObject.optInt("max_pending_send_file_count", 100), jSONObject.optBoolean("track_custom_events", true), jSONObject.optBoolean("track_predefined_events", true), jSONObject.optInt("sampling_rate", 1), jSONObject.optBoolean("flush_on_background", true));
    }

    private C4068p m20963e(JSONObject jSONObject) {
        return new C4068p(jSONObject.optInt("log_buffer_size", 64000), jSONObject.optInt("max_chained_exception_depth", 8), jSONObject.optInt("max_custom_exception_events", 64), jSONObject.optInt("max_custom_key_value_pairs", 64), jSONObject.optInt("identifier_mask", 255), jSONObject.optBoolean("send_session_without_crash", false), jSONObject.optInt("max_complete_sessions_count", 4));
    }

    private C4067o m20964f(JSONObject jSONObject) {
        return new C4067o(jSONObject.optString(ShareConstants.WEB_DIALOG_PARAM_TITLE, "Send Crash Report?"), jSONObject.optString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "Looks like we crashed! Please help us fix the problem by sending a crash report."), jSONObject.optString("send_button_title", "Send"), jSONObject.optBoolean("show_cancel_button", true), jSONObject.optString("cancel_button_title", "Don't Send"), jSONObject.optBoolean("show_always_send_button", true), jSONObject.optString("always_send_button_title", "Always Send"));
    }

    private C4055f m20965g(JSONObject jSONObject) {
        return new C4055f(jSONObject.optString("update_endpoint", C4073t.f14344a), jSONObject.optInt("update_suspend_duration", 3600));
    }

    private long m20958a(C4004j c4004j, long j, JSONObject jSONObject) {
        if (jSONObject.has("expires_at")) {
            return jSONObject.getLong("expires_at");
        }
        return c4004j.mo2882a() + (1000 * j);
    }
}
