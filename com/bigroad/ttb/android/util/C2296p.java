package com.bigroad.ttb.android.util;

import android.content.Context;
import android.content.res.Resources;
import com.bigroad.shared.Password.NewPasswordStatus;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.logging.C2134e;

public abstract class C2296p {
    public static String m11244a(NewPasswordStatus newPasswordStatus, Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier(newPasswordStatus.m4090a(), "string", context.getPackageName());
        if (identifier != 0) {
            return resources.getString(identifier);
        }
        C2134e.m10680d("TT-PasswordValidationUtils", "Missing resource identifier: " + newPasswordStatus.m4090a());
        return resources.getString(R.string.common.password.validation.invalid.title);
    }
}
