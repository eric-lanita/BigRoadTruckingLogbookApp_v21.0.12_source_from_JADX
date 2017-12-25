package com.urbanairship.util;

import android.content.pm.ComponentInfo;
import com.urbanairship.C3929q;
import com.urbanairship.CoreActivity;
import com.urbanairship.CoreReceiver;
import com.urbanairship.UrbanAirshipProvider;
import com.urbanairship.actions.ActionActivity;
import com.urbanairship.actions.ActionService;
import com.urbanairship.analytics.EventService;
import com.urbanairship.location.LocationService;
import com.urbanairship.push.PushService;
import com.urbanairship.richpush.RichPushUpdateService;
import java.util.HashMap;

class ManifestUtils$1 extends HashMap<Class, ComponentInfo> {
    ManifestUtils$1() {
        put(EventService.class, C3949d.m20493a(EventService.class));
        put(PushService.class, C3949d.m20493a(PushService.class));
        put(RichPushUpdateService.class, C3949d.m20493a(RichPushUpdateService.class));
        put(ActionService.class, C3949d.m20493a(ActionService.class));
        put(LocationService.class, C3949d.m20493a(LocationService.class));
        put(CoreReceiver.class, C3949d.m20500c(CoreReceiver.class));
        put(UrbanAirshipProvider.class, C3949d.m20501c(UrbanAirshipProvider.m19289c(C3929q.m20382h())));
        put(ActionActivity.class, C3949d.m20498b(ActionActivity.class));
        put(CoreActivity.class, C3949d.m20498b(CoreActivity.class));
    }
}
