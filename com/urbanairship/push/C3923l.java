package com.urbanairship.push;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.urbanairship.BaseIntentService.C3676a;
import com.urbanairship.C3783j;
import com.urbanairship.C3796l;
import com.urbanairship.C3929q;
import com.urbanairship.json.JsonValue;
import com.urbanairship.p055b.C3760c;
import com.urbanairship.util.C3952g;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class C3923l extends C3676a {
    private final C3919j f13921a;
    private final C3883g f13922b;
    private final C3924m f13923c;

    public C3923l(Context context, C3796l c3796l) {
        this(context, c3796l, new C3924m(C3929q.m20372a().m20388l()), C3929q.m20372a().m20390n(), C3929q.m20372a().m20389m());
    }

    public C3923l(Context context, C3796l c3796l, C3924m c3924m, C3919j c3919j, C3883g c3883g) {
        super(context, c3796l);
        this.f13923c = c3924m;
        this.f13921a = c3919j;
        this.f13922b = c3883g;
    }

    protected void mo2820a(Intent intent) {
        String action = intent.getAction();
        Object obj = -1;
        switch (action.hashCode()) {
            case -832939733:
                if (action.equals("com.urbanairship.push.ACTION_CLEAR_PENDING_NAMED_USER_TAGS")) {
                    obj = 2;
                    break;
                }
                break;
            case 962413331:
                if (action.equals("com.urbanairship.push.ACTION_UPDATE_NAMED_USER_TAGS")) {
                    obj = 1;
                    break;
                }
                break;
            case 1048059625:
                if (action.equals("com.urbanairship.push.ACTION_UPDATE_CHANNEL_TAG_GROUPS")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
            case 1:
                m20354e(intent);
                return;
            case 2:
                m20353c();
                return;
            default:
                return;
        }
    }

    private void m20354e(Intent intent) {
        String str;
        String str2;
        boolean equals = intent.getAction().equals("com.urbanairship.push.ACTION_UPDATE_CHANNEL_TAG_GROUPS");
        if (equals) {
            str = "com.urbanairship.push.PENDING_ADD_TAG_GROUPS";
            str2 = "com.urbanairship.push.PENDING_REMOVE_TAG_GROUPS";
        } else {
            str = "com.urbanairship.nameduser.PENDING_ADD_TAG_GROUPS_KEY";
            str2 = "com.urbanairship.nameduser.PENDING_REMOVE_TAG_GROUPS_KEY";
        }
        Map b = m20352b(str);
        Map b2 = m20352b(str2);
        Bundle bundleExtra = intent.getBundleExtra("com.urbanairship.push.EXTRA_ADD_TAG_GROUPS");
        if (bundleExtra != null) {
            m20349a(bundleExtra, b, b2);
            intent.removeExtra("com.urbanairship.push.EXTRA_ADD_TAG_GROUPS");
        }
        bundleExtra = intent.getBundleExtra("com.urbanairship.push.EXTRA_REMOVE_TAG_GROUPS");
        if (bundleExtra != null) {
            m20349a(bundleExtra, b2, b);
            intent.removeExtra("com.urbanairship.push.EXTRA_REMOVE_TAG_GROUPS");
        }
        if (b.isEmpty() && b2.isEmpty()) {
            m19272b().m19816b(str);
            m19272b().m19816b(str2);
            return;
        }
        C3760c b3;
        if (equals) {
            String u = this.f13921a.m20329u();
            if (u == null) {
                C3783j.m19725c("Unable to update tag groups until a channel is created. Saved pending tag groups.");
                m20351a(str, b);
                m20351a(str2, b2);
                return;
            }
            b3 = this.f13923c.m20360b(u, b, b2);
        } else if (this.f13922b.m20134b() == null) {
            C3783j.m19723b("Failed to update named user tags due to null named user ID. Saved pending tag groups.");
            m20351a(str, b);
            m20351a(str2, b2);
            return;
        } else {
            b3 = this.f13923c.m20357a(this.f13922b.m20134b(), b, b2);
        }
        if (b3 == null || C3952g.m20509b(b3.m19659a())) {
            C3783j.m19727d("Failed to update tag groups, will retry. Saved pending tag groups.");
            m20351a(str, b);
            m20351a(str2, b2);
            m19274d(intent);
        } else if (C3952g.m20508a(b3.m19659a())) {
            C3783j.m19727d("Update tag groups succeeded with status: " + b3.m19659a());
            m20350a(b3.m19661b());
            m19272b().m19816b(str);
            m19272b().m19816b(str2);
        } else {
            C3783j.m19727d("Update tag groups failed with status: " + b3.m19659a());
            m20350a(b3.m19661b());
            if (b3.m19659a() == 403 || b3.m19659a() == 400) {
                m19272b().m19816b(str);
                m19272b().m19816b(str2);
                return;
            }
            m20351a(str, b);
            m20351a(str2, b2);
        }
    }

    private void m20353c() {
        m19272b().m19816b("com.urbanairship.nameduser.PENDING_ADD_TAG_GROUPS_KEY");
        m19272b().m19816b("com.urbanairship.nameduser.PENDING_REMOVE_TAG_GROUPS_KEY");
    }

    private void m20349a(Bundle bundle, Map<String, Set<String>> map, Map<String, Set<String>> map2) {
        for (String str : bundle.keySet()) {
            Collection stringArrayList = bundle.getStringArrayList(str);
            if (stringArrayList != null) {
                if (map.containsKey(str)) {
                    ((Set) map.get(str)).addAll(stringArrayList);
                } else {
                    map.put(str, new HashSet(stringArrayList));
                }
                if (map2.containsKey(str)) {
                    ((Set) map2.get(str)).removeAll(stringArrayList);
                }
            }
        }
    }

    private void m20350a(String str) {
        if (str != null) {
            try {
                JsonValue b = JsonValue.m19740b(str);
                if (b.m19764o()) {
                    if (b.m19755f().m19779a("warnings")) {
                        Iterator it = b.m19755f().m19780b("warnings").m19752c().iterator();
                        while (it.hasNext()) {
                            C3783j.m19727d("Tag Groups warnings: " + ((JsonValue) it.next()));
                        }
                    }
                    if (b.m19755f().m19779a("error")) {
                        C3783j.m19727d("Tag Groups error: " + b.m19755f().m19780b("error"));
                    }
                }
            } catch (Throwable e) {
                C3783j.m19726c("Unable to parse tag group response", e);
            }
        }
    }

    private void m20351a(String str, Map<String, Set<String>> map) {
        m19272b().m19813a(str, JsonValue.m19732a((Object) map));
    }

    private Map<String, Set<String>> m20352b(String str) {
        JsonValue jsonValue = null;
        try {
            jsonValue = JsonValue.m19740b(m19272b().m19810a(str, null));
        } catch (Throwable e) {
            C3783j.m19726c("Unable to parse pending tag groups.", e);
            m19272b().m19816b(str);
        }
        return C3926o.m20367a(jsonValue);
    }
}
