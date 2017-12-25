package com.urbanairship.push.iam;

import android.content.Context;
import com.facebook.share.internal.ShareConstants;
import com.urbanairship.C3929q;
import com.urbanairship.analytics.C3737i;
import com.urbanairship.json.C3788b;
import com.urbanairship.push.p033a.C3869c;
import com.urbanairship.util.C3948c;
import java.util.HashMap;
import java.util.Map;

public class C3910d extends C3737i {
    private final String f13872a;
    private final Map<String, Object> f13873b;

    private C3910d(String str, Map<String, Object> map) {
        this.f13872a = str;
        this.f13873b = map;
    }

    public static C3910d m20274a(Context context, InAppMessage inAppMessage, C3869c c3869c, long j) {
        Map hashMap = new HashMap();
        hashMap.put(ShareConstants.MEDIA_TYPE, "button_click");
        hashMap.put("button_id", c3869c.m20072b());
        hashMap.put("button_group", inAppMessage.m20191g());
        hashMap.put("display_time", C3737i.m19485a(j));
        if (c3869c.m20071a() != null) {
            hashMap.put("button_description", c3869c.m20071a());
        } else if (c3869c.m20073c() > 0) {
            hashMap.put("button_description", context.getString(c3869c.m20073c()));
        }
        return new C3910d(inAppMessage.m20187c(), hashMap);
    }

    public static C3910d m20276a(InAppMessage inAppMessage, long j) {
        Map hashMap = new HashMap();
        hashMap.put(ShareConstants.MEDIA_TYPE, "message_click");
        hashMap.put("display_time", C3737i.m19485a(j));
        return new C3910d(inAppMessage.m20187c(), hashMap);
    }

    public static C3910d m20277a(InAppMessage inAppMessage, InAppMessage inAppMessage2) {
        Map hashMap = new HashMap();
        hashMap.put(ShareConstants.MEDIA_TYPE, "replaced");
        hashMap.put("replacement_id", inAppMessage2.m20187c());
        return new C3910d(inAppMessage.m20187c(), hashMap);
    }

    public static C3910d m20275a(InAppMessage inAppMessage) {
        Map hashMap = new HashMap();
        hashMap.put(ShareConstants.MEDIA_TYPE, "direct_open");
        return new C3910d(inAppMessage.m20187c(), hashMap);
    }

    public static C3910d m20278b(InAppMessage inAppMessage) {
        Map hashMap = new HashMap();
        hashMap.put(ShareConstants.MEDIA_TYPE, "expired");
        hashMap.put("expiry", C3948c.m20492a(inAppMessage.m20184a()));
        return new C3910d(inAppMessage.m20187c(), hashMap);
    }

    public static C3910d m20279b(InAppMessage inAppMessage, long j) {
        Map hashMap = new HashMap();
        hashMap.put(ShareConstants.MEDIA_TYPE, "user_dismissed");
        hashMap.put("display_time", C3737i.m19485a(j));
        return new C3910d(inAppMessage.m20187c(), hashMap);
    }

    public static C3910d m20280c(InAppMessage inAppMessage, long j) {
        Map hashMap = new HashMap();
        hashMap.put(ShareConstants.MEDIA_TYPE, "timed_out");
        hashMap.put("display_time", C3737i.m19485a(j));
        return new C3910d(inAppMessage.m20187c(), hashMap);
    }

    public final String mo2778a() {
        return "in_app_resolution";
    }

    protected final C3788b mo2779b() {
        return C3788b.m19777a().m19774a(ShareConstants.WEB_DIALOG_PARAM_ID, this.f13872a).m19773a("resolution", this.f13873b).m19774a("conversion_send_id", C3929q.m20372a().m20394r().m19459c()).m19774a("conversion_metadata", C3929q.m20372a().m20394r().m19461d()).m19776a();
    }
}
