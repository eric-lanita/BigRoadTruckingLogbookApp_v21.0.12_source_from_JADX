package com.urbanairship.actions.p054a;

import com.urbanairship.C3783j;
import com.urbanairship.actions.C3694b;
import com.urbanairship.actions.C3701e;
import java.util.Collection;
import java.util.Set;

public class C3693c extends C3691b {
    public C3701e mo2770d(C3694b c3694b) {
        Collection e = m19354e(c3694b);
        C3783j.m19727d("RemoveTagsAction - Removing tags: " + e);
        Set j = m19352a().m20318j();
        j.removeAll(e);
        m19352a().m20305a(j);
        return C3701e.m19372a();
    }
}
