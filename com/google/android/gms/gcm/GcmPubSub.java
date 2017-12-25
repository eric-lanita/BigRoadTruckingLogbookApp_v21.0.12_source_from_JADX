package com.google.android.gms.gcm;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.iid.InstanceID;
import java.util.regex.Pattern;

public class GcmPubSub {
    private static GcmPubSub f10978a;
    private static final Pattern f10979c = Pattern.compile("/topics/[a-zA-Z0-9-_.~%]{1,900}");
    private InstanceID f10980b;

    private GcmPubSub(Context context) {
        this.f10980b = InstanceID.getInstance(context);
    }

    public static synchronized GcmPubSub getInstance(Context context) {
        GcmPubSub gcmPubSub;
        synchronized (GcmPubSub.class) {
            if (f10978a == null) {
                f10978a = new GcmPubSub(context);
            }
            gcmPubSub = f10978a;
        }
        return gcmPubSub;
    }

    public void subscribe(String str, String str2, Bundle bundle) {
        String str3;
        String valueOf;
        if (str == null || str.isEmpty()) {
            str3 = "Invalid appInstanceToken: ";
            valueOf = String.valueOf(str);
            throw new IllegalArgumentException(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
        } else if (str2 == null || !f10979c.matcher(str2).matches()) {
            str3 = "Invalid topic name: ";
            valueOf = String.valueOf(str2);
            throw new IllegalArgumentException(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
        } else {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString("gcm.topic", str2);
            this.f10980b.getToken(str, str2, bundle);
        }
    }

    public void unsubscribe(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", str2);
        this.f10980b.zzb(str, str2, bundle);
    }
}
