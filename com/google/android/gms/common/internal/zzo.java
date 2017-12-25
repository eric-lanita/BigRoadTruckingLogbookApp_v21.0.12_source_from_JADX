package com.google.android.gms.common.internal;

import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;

public class zzo {
    private static final Uri f10794a = Uri.parse("http://plus.google.com/");
    private static final Uri f10795b = f10794a.buildUpon().appendPath("circles").appendPath("find").build();

    private static Uri m16944a(String str, String str2) {
        Builder appendQueryParameter = Uri.parse("market://details").buildUpon().appendQueryParameter(ShareConstants.WEB_DIALOG_PARAM_ID, str);
        if (!TextUtils.isEmpty(str2)) {
            appendQueryParameter.appendQueryParameter("pcampaignid", str2);
        }
        return appendQueryParameter.build();
    }

    public static Intent zzad(String str, String str2) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(m16944a(str, str2));
        intent.setPackage("com.android.vending");
        intent.addFlags(524288);
        return intent;
    }

    public static Intent zzata() {
        Intent intent = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
        intent.setPackage("com.google.android.wearable.app");
        return intent;
    }

    public static Intent zzho(String str) {
        Uri fromParts = Uri.fromParts("package", str, null);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(fromParts);
        return intent;
    }
}
