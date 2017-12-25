package com.urbanairship.util;

import android.net.Uri;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C3955j {
    public static Map<String, List<String>> m20515a(Uri uri) {
        Map<String, List<String>> hashMap = new HashMap();
        String encodedQuery = uri.getEncodedQuery();
        if (C3954i.m20512a(encodedQuery)) {
            return hashMap;
        }
        for (String encodedQuery2 : encodedQuery2.split("&")) {
            Object decode;
            String[] split = encodedQuery2.split("=");
            if (split.length >= 1) {
                encodedQuery2 = Uri.decode(split[0]);
            } else {
                encodedQuery2 = null;
            }
            if (split.length >= 2) {
                decode = Uri.decode(split[1]);
            } else {
                decode = null;
            }
            if (!C3954i.m20512a(encodedQuery2)) {
                if (!hashMap.containsKey(encodedQuery2)) {
                    hashMap.put(encodedQuery2, new ArrayList());
                }
                ((List) hashMap.get(encodedQuery2)).add(decode);
            }
        }
        return hashMap;
    }

    public static Uri m20514a(Object obj) {
        if (obj == null || (!(obj instanceof String) && !(obj instanceof Uri) && !(obj instanceof URL))) {
            return null;
        }
        return Uri.parse(String.valueOf(obj));
    }
}
