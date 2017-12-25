package com.urbanairship.richpush;

import android.content.Context;
import android.content.Intent;
import com.urbanairship.BaseIntentService.C3676a;
import com.urbanairship.C3783j;
import com.urbanairship.C3796l;
import com.urbanairship.C3929q;
import com.urbanairship.json.C3785a;
import com.urbanairship.json.C3788b;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonValue;
import com.urbanairship.p055b.C3757b;
import com.urbanairship.p055b.C3760c;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class C3931a extends C3676a {
    private final C3929q f13959a;
    private final C3944e f13960b;
    private final C3943d f13961c;
    private final String f13962d;
    private final C3757b f13963e;

    public C3931a(Context context, C3796l c3796l) {
        this(context, c3796l, new C3757b(), new C3943d(context), C3929q.m20372a());
    }

    public C3931a(Context context, C3796l c3796l, C3757b c3757b, C3943d c3943d, C3929q c3929q) {
        super(context, c3796l);
        this.f13963e = c3757b;
        this.f13961c = c3943d;
        this.f13959a = c3929q;
        this.f13960b = c3929q.m20391o().m20439b();
        this.f13962d = c3929q.m20388l().f13505e;
    }

    protected void mo2820a(Intent intent) {
        String action = intent.getAction();
        boolean z = true;
        switch (action.hashCode()) {
            case 1699160881:
                if (action.equals("com.urbanairship.richpush.MESSAGES_UPDATE")) {
                    z = false;
                    break;
                }
                break;
            case 2078637888:
                if (action.equals("com.urbanairship.richpush.SYNC_MESSAGE_STATE")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                if (C3944e.m20471a()) {
                    RichPushUpdateService.m20409a(intent, m20413c());
                    m20415e();
                    m20414d();
                    return;
                }
                C3783j.m19725c("InboxServiceDelegate - User has not been created, canceling messages update");
                RichPushUpdateService.m20409a(intent, false);
                return;
            case true:
                m20415e();
                m20414d();
                return;
            default:
                return;
        }
    }

    private boolean m20413c() {
        C3783j.m19727d("Refreshing inbox messages.");
        URL a = RichPushUpdateService.m20408a("api/user/%s/messages/", this.f13960b.m20478b());
        if (a == null) {
            return false;
        }
        C3783j.m19723b("InboxServiceDelegate - Fetching inbox messages.");
        C3760c a2 = this.f13963e.m19648a("GET", a).m19643a(this.f13960b.m20478b(), this.f13960b.m20480c()).m19647c("Accept", "application/vnd.urbanairship+json; version=3;").m19647c("X-UA-Channel-ID", this.f13959a.m20390n().m20329u()).m19642a(m19272b().m19808a("com.urbanairship.user.LAST_MESSAGE_REFRESH_TIME", 0)).m19645a();
        C3783j.m19723b("InboxServiceDelegate - Fetch inbox messages response: " + a2);
        int a3 = a2 == null ? -1 : a2.m19659a();
        if (a3 == 304) {
            C3783j.m19727d("Inbox messages already up-to-date. ");
            return true;
        } else if (a3 == 200) {
            C3785a c3785a = null;
            try {
                C3788b f = JsonValue.m19740b(a2.m19661b()).m19755f();
                if (f != null) {
                    c3785a = f.m19780b("messages").m19752c();
                }
                if (c3785a == null) {
                    C3783j.m19727d("Inbox message list is empty.");
                } else {
                    C3783j.m19727d("Received " + c3785a.m19766a() + " inbox messages.");
                    m20412a(c3785a);
                    m19272b().m19818b("com.urbanairship.user.LAST_MESSAGE_REFRESH_TIME", a2.m19662c());
                }
                return true;
            } catch (JsonException e) {
                C3783j.m19728e("Failed to update inbox. Unable to parse response body: " + a2.m19661b());
                return false;
            }
        } else {
            C3783j.m19727d("Unable to update inbox messages.");
            return false;
        }
    }

    private void m20412a(C3785a c3785a) {
        List arrayList = new ArrayList();
        Collection hashSet = new HashSet();
        Iterator it = c3785a.iterator();
        while (it.hasNext()) {
            JsonValue jsonValue = (JsonValue) it.next();
            if (jsonValue.m19764o()) {
                String a = jsonValue.m19755f().m19782c("message_id").m19747a();
                if (a == null) {
                    C3783j.m19728e("InboxServiceDelegate - Invalid message payload, missing message ID: " + jsonValue);
                } else {
                    hashSet.add(a);
                    if (this.f13961c.m20460a(a, jsonValue) != 1) {
                        arrayList.add(jsonValue);
                    }
                }
            } else {
                C3783j.m19728e("InboxServiceDelegate - Invalid message payload: " + jsonValue);
            }
        }
        if (arrayList.size() > 0) {
            this.f13961c.m20461a(arrayList);
        }
        Set b = this.f13961c.m20465b();
        b.removeAll(hashSet);
        this.f13961c.m20468d(b);
        this.f13959a.m20391o().m20437a(true);
    }

    private void m20414d() {
        Set d = this.f13961c.m20469d();
        if (d.size() != 0) {
            URL a = RichPushUpdateService.m20408a("api/user/%s/messages/delete/", this.f13960b.m20478b());
            if (a != null) {
                C3783j.m19723b("InboxServiceDelegate - Found " + d.size() + " messages to delete.");
                C3788b a2 = m20411a("delete", d);
                if (a2 != null) {
                    C3783j.m19723b("InboxServiceDelegate - Deleting inbox messages with payload: " + a2);
                    C3760c a3 = this.f13963e.m19648a("POST", a).m19643a(this.f13960b.m20478b(), this.f13960b.m20480c()).m19646b(a2.toString(), "application/json").m19647c("X-UA-Channel-ID", this.f13959a.m20390n().m20329u()).m19647c("Accept", "application/vnd.urbanairship+json; version=3;").m19645a();
                    C3783j.m19723b("InboxServiceDelegate - Delete inbox messages response: " + a3);
                    if (a3 != null && a3.m19659a() == 200) {
                        this.f13961c.m20468d(d);
                    }
                }
            }
        }
    }

    private void m20415e() {
        Set c = this.f13961c.m20467c();
        if (c.size() != 0) {
            URL a = RichPushUpdateService.m20408a("api/user/%s/messages/unread/", this.f13960b.m20478b());
            if (a != null) {
                C3783j.m19723b("InboxServiceDelegate - Found " + c.size() + " messages to mark read.");
                C3788b a2 = m20411a("mark_as_read", c);
                if (a2 != null) {
                    C3783j.m19723b("InboxServiceDelegate - Marking inbox messages read request with payload: " + a2);
                    C3760c a3 = this.f13963e.m19648a("POST", a).m19643a(this.f13960b.m20478b(), this.f13960b.m20480c()).m19646b(a2.toString(), "application/json").m19647c("X-UA-Channel-ID", this.f13959a.m20390n().m20329u()).m19647c("Accept", "application/vnd.urbanairship+json; version=3;").m19645a();
                    C3783j.m19723b("InboxServiceDelegate - Mark inbox messages read response: " + a3);
                    if (a3 != null && a3.m19659a() == 200) {
                        this.f13961c.m20466c(c);
                    }
                }
            }
        }
    }

    private C3788b m20411a(String str, Set<String> set) {
        Object arrayList = new ArrayList();
        String b = this.f13960b.m20478b();
        for (String str2 : set) {
            arrayList.add(this.f13962d + String.format("api/user/%s/messages/message/%s/", new Object[]{b, str2}));
        }
        C3788b a = C3788b.m19777a().m19772a(str, JsonValue.m19732a(arrayList)).m19776a();
        C3783j.m19723b(a.toString());
        return a;
    }
}
