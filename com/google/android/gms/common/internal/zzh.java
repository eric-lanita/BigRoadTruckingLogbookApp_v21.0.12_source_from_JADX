package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.p008d.C0269h;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.C3176R;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.util.zzi;

public final class zzh {
    private static final C0269h<String, String> f10754a = new C0269h();

    private static String m16931a(Context context, String str) {
        synchronized (f10754a) {
            String str2 = (String) f10754a.get(str);
            if (str2 != null) {
                return str2;
            }
            Resources remoteResource = GooglePlayServicesUtil.getRemoteResource(context);
            if (remoteResource == null) {
                return null;
            }
            int identifier = remoteResource.getIdentifier(str, "string", "com.google.android.gms");
            if (identifier == 0) {
                String str3 = "GoogleApiAvailability";
                String str4 = "Missing resource: ";
                str2 = String.valueOf(str);
                Log.w(str3, str2.length() != 0 ? str4.concat(str2) : new String(str4));
                return null;
            }
            Object string = remoteResource.getString(identifier);
            if (TextUtils.isEmpty(string)) {
                str3 = "GoogleApiAvailability";
                str4 = "Got empty resource: ";
                str2 = String.valueOf(str);
                Log.w(str3, str2.length() != 0 ? str4.concat(str2) : new String(str4));
                return null;
            }
            f10754a.put(str, string);
            return string;
        }
    }

    private static String m16932a(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String a = m16931a(context, str);
        if (a == null) {
            a = resources.getString(C3176R.string.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, a, new Object[]{str2});
    }

    public static String zzc(Context context, int i, String str) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                if (zzi.zzb(resources)) {
                    return resources.getString(C3176R.string.common_google_play_services_install_text_tablet, new Object[]{str});
                }
                return resources.getString(C3176R.string.common_google_play_services_install_text_phone, new Object[]{str});
            case 2:
                return resources.getString(C3176R.string.common_google_play_services_update_text, new Object[]{str});
            case 3:
                return resources.getString(C3176R.string.common_google_play_services_enable_text, new Object[]{str});
            case 5:
                return m16932a(context, "common_google_play_services_invalid_account_text", str);
            case 7:
                return m16932a(context, "common_google_play_services_network_error_text", str);
            case 9:
                return resources.getString(C3176R.string.common_google_play_services_unsupported_text, new Object[]{str});
            case 16:
                return m16932a(context, "common_google_play_services_api_unavailable_text", str);
            case 17:
                return m16932a(context, "common_google_play_services_sign_in_failed_text", str);
            case 18:
                return resources.getString(C3176R.string.common_google_play_services_updating_text, new Object[]{str});
            case 20:
                return m16932a(context, "common_google_play_services_restricted_profile_text", str);
            case 42:
                return resources.getString(C3176R.string.common_google_play_services_wear_update_text);
            default:
                return resources.getString(C3176R.string.common_google_play_services_unknown_issue, new Object[]{str});
        }
    }

    public static String zzd(Context context, int i, String str) {
        return i == 6 ? m16932a(context, "common_google_play_services_resolution_required_text", str) : zzc(context, i, str);
    }

    public static String zzf(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(C3176R.string.common_google_play_services_install_title);
            case 2:
            case 42:
                return resources.getString(C3176R.string.common_google_play_services_update_title);
            case 3:
                return resources.getString(C3176R.string.common_google_play_services_enable_title);
            case 4:
            case 6:
                return null;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return m16931a(context, "common_google_play_services_invalid_account_title");
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return m16931a(context, "common_google_play_services_network_error_title");
            case 8:
                Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                return null;
            case 9:
                Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                return resources.getString(C3176R.string.common_google_play_services_unsupported_title);
            case 10:
                Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
                return null;
            case 11:
                Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
                return null;
            case 16:
                Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                return null;
            case 17:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return m16931a(context, "common_google_play_services_sign_in_failed_title");
            case 18:
                return resources.getString(C3176R.string.common_google_play_services_updating_title);
            case 20:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return m16931a(context, "common_google_play_services_restricted_profile_title");
            default:
                Log.e("GoogleApiAvailability", "Unexpected error code " + i);
                return null;
        }
    }

    public static String zzg(Context context, int i) {
        return i == 6 ? m16931a(context, "common_google_play_services_resolution_required_title") : zzf(context, i);
    }

    public static String zzh(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(C3176R.string.common_google_play_services_install_button);
            case 2:
                return resources.getString(C3176R.string.common_google_play_services_update_button);
            case 3:
                return resources.getString(C3176R.string.common_google_play_services_enable_button);
            default:
                return resources.getString(17039370);
        }
    }
}
