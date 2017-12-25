package android.support.v4.app;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.aq.C0174a;
import com.facebook.applinks.AppLinkData;

class ar {
    static Bundle m770a(C0174a c0174a) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", c0174a.mo130a());
        bundle.putCharSequence("label", c0174a.mo131b());
        bundle.putCharSequenceArray("choices", c0174a.mo132c());
        bundle.putBoolean("allowFreeFormInput", c0174a.mo133d());
        bundle.putBundle(AppLinkData.ARGUMENTS_EXTRAS_KEY, c0174a.mo134e());
        return bundle;
    }

    static Bundle[] m771a(C0174a[] c0174aArr) {
        if (c0174aArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[c0174aArr.length];
        for (int i = 0; i < c0174aArr.length; i++) {
            bundleArr[i] = m770a(c0174aArr[i]);
        }
        return bundleArr;
    }

    static Bundle m769a(Intent intent) {
        ClipData clipData = intent.getClipData();
        if (clipData == null) {
            return null;
        }
        ClipDescription description = clipData.getDescription();
        if (description.hasMimeType("text/vnd.android.intent") && description.getLabel().equals("android.remoteinput.results")) {
            return (Bundle) clipData.getItemAt(0).getIntent().getExtras().getParcelable("android.remoteinput.resultsData");
        }
        return null;
    }
}
