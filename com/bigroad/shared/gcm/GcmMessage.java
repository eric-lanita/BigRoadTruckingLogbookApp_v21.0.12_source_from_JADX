package com.bigroad.shared.gcm;

import com.bigroad.shared.am;
import com.facebook.share.internal.ShareConstants;
import java.util.Map;

public class GcmMessage {
    private MessageType f3572a;
    private long f3573b;

    public enum MessageType {
        SYNC
    }

    public GcmMessage(MessageType messageType, long j) {
        this.f3572a = messageType;
        this.f3573b = j;
    }

    public static GcmMessage m5434a(String str, String str2) {
        if (am.m4188a((CharSequence) str)) {
            return null;
        }
        try {
            try {
                return new GcmMessage(MessageType.valueOf(str), Long.parseLong(str2));
            } catch (IllegalArgumentException e) {
                return null;
            }
        } catch (NumberFormatException e2) {
            return null;
        }
    }

    public static GcmMessage m5435a(Map<String, String> map) {
        if (map != null && map.containsKey(ShareConstants.WEB_DIALOG_PARAM_MESSAGE) && map.containsKey("timestamp")) {
            return m5434a((String) map.get(ShareConstants.WEB_DIALOG_PARAM_MESSAGE), (String) map.get("timestamp"));
        }
        return null;
    }

    public MessageType m5436a() {
        return this.f3572a;
    }

    public String m5437b() {
        return this.f3572a.name();
    }

    public long m5438c() {
        return this.f3573b;
    }
}
