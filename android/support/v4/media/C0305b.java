package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.media.MediaDescription.Builder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;

class C0305b {

    static class C0304a {
        public static Object m1248a() {
            return new Builder();
        }

        public static void m1254a(Object obj, String str) {
            ((Builder) obj).setMediaId(str);
        }

        public static void m1253a(Object obj, CharSequence charSequence) {
            ((Builder) obj).setTitle(charSequence);
        }

        public static void m1255b(Object obj, CharSequence charSequence) {
            ((Builder) obj).setSubtitle(charSequence);
        }

        public static void m1256c(Object obj, CharSequence charSequence) {
            ((Builder) obj).setDescription(charSequence);
        }

        public static void m1250a(Object obj, Bitmap bitmap) {
            ((Builder) obj).setIconBitmap(bitmap);
        }

        public static void m1251a(Object obj, Uri uri) {
            ((Builder) obj).setIconUri(uri);
        }

        public static void m1252a(Object obj, Bundle bundle) {
            ((Builder) obj).setExtras(bundle);
        }

        public static Object m1249a(Object obj) {
            return ((Builder) obj).build();
        }
    }

    public static String m1258a(Object obj) {
        return ((MediaDescription) obj).getMediaId();
    }

    public static CharSequence m1260b(Object obj) {
        return ((MediaDescription) obj).getTitle();
    }

    public static CharSequence m1261c(Object obj) {
        return ((MediaDescription) obj).getSubtitle();
    }

    public static CharSequence m1262d(Object obj) {
        return ((MediaDescription) obj).getDescription();
    }

    public static Bitmap m1263e(Object obj) {
        return ((MediaDescription) obj).getIconBitmap();
    }

    public static Uri m1264f(Object obj) {
        return ((MediaDescription) obj).getIconUri();
    }

    public static Bundle m1265g(Object obj) {
        return ((MediaDescription) obj).getExtras();
    }

    public static void m1259a(Object obj, Parcel parcel, int i) {
        ((MediaDescription) obj).writeToParcel(parcel, i);
    }

    public static Object m1257a(Parcel parcel) {
        return MediaDescription.CREATOR.createFromParcel(parcel);
    }
}
