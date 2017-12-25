package com.urbanairship.push;

import com.urbanairship.C3783j;
import com.urbanairship.json.JsonValue;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class C3926o {
    static Map<String, Set<String>> m20367a(JsonValue jsonValue) {
        Map<String, Set<String>> hashMap = new HashMap();
        if (jsonValue != null && jsonValue.m19764o()) {
            Iterator it = jsonValue.m19755f().iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                Set hashSet = new HashSet();
                Iterator it2 = ((JsonValue) entry.getValue()).m19752c().iterator();
                while (it2.hasNext()) {
                    JsonValue jsonValue2 = (JsonValue) it2.next();
                    if (jsonValue2.m19758i()) {
                        hashSet.add(jsonValue2.m19747a());
                    }
                }
                if (!hashSet.isEmpty()) {
                    hashMap.put(entry.getKey(), hashSet);
                }
            }
        }
        return hashMap;
    }

    static Set<String> m20368a(Set<String> set) {
        Set<String> hashSet = new HashSet();
        for (String str : set) {
            String str2;
            if (str2 == null) {
                C3783j.m19725c("Null tag was removed from set.");
            } else {
                str2 = str2.trim();
                if (str2.length() <= 0 || str2.length() > 127) {
                    C3783j.m19728e("Tag with zero or greater than max length was removed from set: " + str2);
                } else {
                    hashSet.add(str2);
                }
            }
        }
        return hashSet;
    }
}
