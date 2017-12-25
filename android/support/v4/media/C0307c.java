package android.support.v4.media;

import android.media.MediaDescription;
import android.media.MediaDescription.Builder;
import android.net.Uri;
import android.support.v4.media.C0305b.C0304a;

class C0307c extends C0305b {

    static class C0306a extends C0304a {
        public static void m1266b(Object obj, Uri uri) {
            ((Builder) obj).setMediaUri(uri);
        }
    }

    public static Uri m1267h(Object obj) {
        return ((MediaDescription) obj).getMediaUri();
    }
}
