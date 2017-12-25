package com.urbanairship.actions.p054a;

import com.urbanairship.C3929q;
import com.urbanairship.actions.C3690a;
import com.urbanairship.actions.C3694b;
import com.urbanairship.json.JsonValue;
import com.urbanairship.push.C3919j;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public abstract class C3691b extends C3690a {
    protected C3919j m19352a() {
        return C3929q.m20372a().m20390n();
    }

    public boolean mo2769b(C3694b c3694b) {
        return m19354e(c3694b) != null;
    }

    protected Set<String> m19354e(C3694b c3694b) {
        if (c3694b.m19357a().m19319d()) {
            return null;
        }
        if (c3694b.m19357a().m19314a() != null) {
            Set<String> hashSet = new HashSet();
            hashSet.add(String.valueOf(c3694b.m19357a().m19314a()));
            return hashSet;
        } else if (c3694b.m19357a().m19315b() == null) {
            return null;
        } else {
            Set<String> hashSet2 = new HashSet();
            Iterator it = c3694b.m19357a().m19315b().iterator();
            while (it.hasNext()) {
                JsonValue jsonValue = (JsonValue) it.next();
                if (jsonValue.m19747a() != null) {
                    hashSet2.add(jsonValue.m19747a());
                }
            }
            return hashSet2;
        }
    }
}
