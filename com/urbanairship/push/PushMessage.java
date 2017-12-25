package com.urbanairship.push;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.urbanairship.C3783j;
import com.urbanairship.actions.ActionValue;
import com.urbanairship.json.C3788b;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonValue;
import com.urbanairship.push.iam.InAppMessage;
import com.urbanairship.push.iam.InAppMessage.C3887a;
import com.urbanairship.util.C3953h;
import com.urbanairship.util.C3954i;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class PushMessage implements Parcelable {
    public static final Creator<PushMessage> CREATOR = new C38651();
    private static final List<String> f13739a = Arrays.asList(new String[]{"open_mc_action", "^mc", "open_mc_overlay_action", "^mco"});
    private final Bundle f13740b;
    private Uri f13741c = null;

    static class C38651 implements Creator<PushMessage> {
        C38651() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m20038a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m20039a(i);
        }

        public PushMessage m20038a(Parcel parcel) {
            return new PushMessage(parcel.readBundle(PushMessage.class.getClassLoader()));
        }

        public PushMessage[] m20039a(int i) {
            return new PushMessage[i];
        }
    }

    public PushMessage(Bundle bundle) {
        this.f13740b = bundle;
    }

    boolean m20042a() {
        String string = this.f13740b.getString("com.urbanairship.push.EXPIRATION");
        if (!C3954i.m20512a(string)) {
            C3783j.m19725c("Notification expiration time is \"" + string + "\"");
            try {
                if (Long.parseLong(string) * 1000 < System.currentTimeMillis()) {
                    return true;
                }
            } catch (NumberFormatException e) {
                C3783j.m19725c("Ignoring malformed expiration time: " + e.getMessage());
            }
        }
        return false;
    }

    boolean m20043b() {
        return this.f13740b.get("com.urbanairship.push.PING") != null;
    }

    public String m20044c() {
        return this.f13740b.getString("com.urbanairship.push.CANONICAL_PUSH_ID");
    }

    public String m20045d() {
        return this.f13740b.getString("_uamid");
    }

    public String m20046e() {
        return this.f13740b.getString("com.urbanairship.push.ALERT");
    }

    public String m20047f() {
        return this.f13740b.getString("com.urbanairship.push.PUSH_ID");
    }

    public String m20048g() {
        return this.f13740b.getString("com.urbanairship.metadata");
    }

    public Bundle m20049h() {
        return new Bundle(this.f13740b);
    }

    public Map<String, ActionValue> m20050i() {
        String string = this.f13740b.getString("com.urbanairship.actions");
        Map<String, ActionValue> hashMap = new HashMap();
        try {
            C3788b f = JsonValue.m19740b(string).m19755f();
            if (f != null) {
                Iterator it = f.iterator();
                while (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    hashMap.put(entry.getKey(), new ActionValue((JsonValue) entry.getValue()));
                }
            }
            if (!C3954i.m20512a(m20045d()) && Collections.disjoint(hashMap.keySet(), f13739a)) {
                hashMap.put("^mc", ActionValue.m19312a(m20045d()));
            }
            return hashMap;
        } catch (JsonException e) {
            C3783j.m19728e("Unable to parse action payload: " + string);
            return hashMap;
        }
    }

    public String m20051j() {
        return this.f13740b.getString("com.urbanairship.interactive_actions");
    }

    public String m20052k() {
        return this.f13740b.getString("com.urbanairship.interactive_type");
    }

    public String m20053l() {
        return this.f13740b.getString("com.urbanairship.title");
    }

    public String m20054m() {
        return this.f13740b.getString("com.urbanairship.summary");
    }

    public String m20055n() {
        return this.f13740b.getString("com.urbanairship.wearable");
    }

    public String m20056o() {
        return this.f13740b.getString("com.urbanairship.style");
    }

    public boolean m20057p() {
        return Boolean.parseBoolean(this.f13740b.getString("com.urbanairship.local_only"));
    }

    public int m20058q() {
        try {
            return C3953h.m20510a(Integer.parseInt(this.f13740b.getString("com.urbanairship.priority")), -2, 2);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public int m20059r() {
        int i = 1;
        try {
            i = C3953h.m20510a(Integer.parseInt(this.f13740b.getString("com.urbanairship.visibility")), -1, 1);
        } catch (NumberFormatException e) {
        }
        return i;
    }

    public String m20060s() {
        return this.f13740b.getString("com.urbanairship.public_notification");
    }

    public String m20061t() {
        return this.f13740b.getString("com.urbanairship.category");
    }

    public Uri m20041a(Context context) {
        if (this.f13741c == null && this.f13740b.getString("com.urbanairship.sound") != null) {
            String string = this.f13740b.getString("com.urbanairship.sound");
            int identifier = context.getResources().getIdentifier(string, "raw", context.getPackageName());
            if (identifier != 0) {
                this.f13741c = Uri.parse("android.resource://" + context.getPackageName() + "/" + identifier);
            } else if (!"default".equals(string)) {
                C3783j.m19721a("PushMessage - unable to find notification sound with name: " + string);
            }
        }
        return this.f13741c;
    }

    public InAppMessage m20062u() {
        InAppMessage inAppMessage = null;
        if (this.f13740b.containsKey("com.urbanairship.in_app")) {
            try {
                InAppMessage b = InAppMessage.m20172b(this.f13740b.getString("com.urbanairship.in_app"));
                if (b != null) {
                    C3887a a = new C3887a(b).m20163a(m20047f());
                    if (!C3954i.m20512a(m20045d()) && Collections.disjoint(b.m20190f().keySet(), f13739a)) {
                        Map hashMap = new HashMap(b.m20190f());
                        hashMap.put("^mc", new ActionValue(JsonValue.m19743c(m20045d())));
                        a.m20165a(hashMap);
                    }
                    inAppMessage = a.m20166a();
                }
            } catch (Throwable e) {
                C3783j.m19726c("PushMessage - unable to create in-app message from push payload", e);
            }
        }
        return inAppMessage;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PushMessage pushMessage = (PushMessage) obj;
        if (this.f13740b != null) {
            if (this.f13740b.equals(pushMessage.f13740b)) {
                return true;
            }
        } else if (pushMessage.f13740b == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f13740b != null ? this.f13740b.hashCode() : 0;
    }

    public static PushMessage m20040a(Intent intent) {
        if (intent == null) {
            return null;
        }
        Bundle bundleExtra = intent.getBundleExtra("com.urbanairship.push.EXTRA_PUSH_MESSAGE_BUNDLE");
        if (bundleExtra != null) {
            return new PushMessage(bundleExtra);
        }
        return null;
    }

    public String toString() {
        return this.f13740b.toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.f13740b);
    }
}
