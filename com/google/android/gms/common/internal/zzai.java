package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.C3176R;

public class zzai {
    private final Resources f10723a;
    private final String f10724b = this.f10723a.getResourcePackageName(C3176R.string.common_google_play_services_unknown_issue);

    public zzai(Context context) {
        zzab.zzy(context);
        this.f10723a = context.getResources();
    }

    public String getString(String str) {
        int identifier = this.f10723a.getIdentifier(str, "string", this.f10724b);
        return identifier == 0 ? null : this.f10723a.getString(identifier);
    }
}
