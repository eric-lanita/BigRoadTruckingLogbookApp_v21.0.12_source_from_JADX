package com.urbanairship.push;

import android.content.Intent;
import android.os.Bundle;
import com.urbanairship.C3783j;
import com.urbanairship.C3929q;
import com.urbanairship.util.C3954i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class C3925n {
    protected final Map<String, Set<String>> f13928a = new HashMap();
    protected final Map<String, Set<String>> f13929b = new HashMap();
    private final String f13930c;

    C3925n(String str) {
        this.f13930c = str;
    }

    public C3925n m20362a(String str, String str2) {
        return m20363a(str, new HashSet(Arrays.asList(new String[]{str2})));
    }

    public C3925n m20363a(String str, Set<String> set) {
        if (m20366b(str, set)) {
            m20365a(this.f13928a, this.f13929b, str, set);
        }
        return this;
    }

    public void m20364a() {
        if (this.f13928a.isEmpty() && this.f13929b.isEmpty()) {
            C3783j.m19727d("Skipping tag group update because tags to add and tags to remove are both empty.");
            return;
        }
        C3929q.m20382h().startService(new Intent(C3929q.m20382h(), PushService.class).setAction(this.f13930c).putExtra("com.urbanairship.push.EXTRA_ADD_TAG_GROUPS", m20361a(this.f13928a)).putExtra("com.urbanairship.push.EXTRA_REMOVE_TAG_GROUPS", m20361a(this.f13929b)));
    }

    Bundle m20361a(Map<String, Set<String>> map) {
        Bundle bundle = new Bundle();
        for (Entry entry : map.entrySet()) {
            bundle.putStringArrayList((String) entry.getKey(), new ArrayList((Collection) entry.getValue()));
        }
        return bundle;
    }

    boolean m20366b(String str, Set<String> set) {
        boolean z = true;
        if (C3954i.m20512a(str)) {
            C3783j.m19721a("The tag group ID string cannot be null.");
            z = false;
        }
        if (!C3926o.m20368a((Set) set).isEmpty()) {
            return z;
        }
        C3783j.m19721a("The tags cannot be empty");
        return false;
    }

    void m20365a(Map<String, Set<String>> map, Map<String, Set<String>> map2, String str, Set<String> set) {
        Collection a = C3926o.m20368a((Set) set);
        if (map2.containsKey(str)) {
            ((Set) map2.get(str)).removeAll(a);
            if (((Set) map2.get(str)).size() == 0) {
                map2.remove(str);
            }
        }
        if (map.containsKey(str)) {
            ((Set) map.get(str)).addAll(a);
            if (((Set) map.get(str)).size() == 0) {
                map.remove(str);
                return;
            }
            return;
        }
        map.put(str, new HashSet(a));
    }
}
