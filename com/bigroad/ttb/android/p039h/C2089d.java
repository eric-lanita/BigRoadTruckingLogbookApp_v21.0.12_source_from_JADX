package com.bigroad.ttb.android.p039h;

import android.content.Context;
import android.content.res.Resources;
import com.bigroad.shared.validation.C1175o;
import com.bigroad.shared.validation.ValidationError;
import com.bigroad.ttb.android.logging.C2134e;

public abstract class C2089d {
    public static String m10473a(ValidationError validationError, Context context) {
        Resources resources = context.getResources();
        C1175o c = validationError.m5781c();
        int identifier = resources.getIdentifier(c.m5952a().m5786a(), "string", context.getPackageName());
        if (identifier != 0) {
            Object[] b = c.m5953b();
            if (b == null) {
                return resources.getString(identifier);
            }
            return resources.getString(identifier, b);
        }
        C2134e.m10680d("TT-L10n", "Missing resource identifier: " + c.m5952a().m5786a());
        return c.m5952a().m5786a();
    }
}
