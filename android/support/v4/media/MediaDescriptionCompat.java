package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.media.C0305b.C0304a;
import android.support.v4.media.C0307c.C0306a;
import android.text.TextUtils;

public final class MediaDescriptionCompat implements Parcelable {
    public static final Creator<MediaDescriptionCompat> CREATOR = new C03011();
    private final String f893a;
    private final CharSequence f894b;
    private final CharSequence f895c;
    private final CharSequence f896d;
    private final Bitmap f897e;
    private final Uri f898f;
    private final Bundle f899g;
    private final Uri f900h;
    private Object f901i;

    static class C03011 implements Creator<MediaDescriptionCompat> {
        C03011() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m1233a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m1234a(i);
        }

        public MediaDescriptionCompat m1233a(Parcel parcel) {
            if (VERSION.SDK_INT < 21) {
                return new MediaDescriptionCompat(parcel);
            }
            return MediaDescriptionCompat.m1244a(C0305b.m1257a(parcel));
        }

        public MediaDescriptionCompat[] m1234a(int i) {
            return new MediaDescriptionCompat[i];
        }
    }

    public static final class C0302a {
        private String f885a;
        private CharSequence f886b;
        private CharSequence f887c;
        private CharSequence f888d;
        private Bitmap f889e;
        private Uri f890f;
        private Bundle f891g;
        private Uri f892h;

        public C0302a m1239a(String str) {
            this.f885a = str;
            return this;
        }

        public C0302a m1238a(CharSequence charSequence) {
            this.f886b = charSequence;
            return this;
        }

        public C0302a m1242b(CharSequence charSequence) {
            this.f887c = charSequence;
            return this;
        }

        public C0302a m1243c(CharSequence charSequence) {
            this.f888d = charSequence;
            return this;
        }

        public C0302a m1235a(Bitmap bitmap) {
            this.f889e = bitmap;
            return this;
        }

        public C0302a m1236a(Uri uri) {
            this.f890f = uri;
            return this;
        }

        public C0302a m1237a(Bundle bundle) {
            this.f891g = bundle;
            return this;
        }

        public C0302a m1241b(Uri uri) {
            this.f892h = uri;
            return this;
        }

        public MediaDescriptionCompat m1240a() {
            return new MediaDescriptionCompat(this.f885a, this.f886b, this.f887c, this.f888d, this.f889e, this.f890f, this.f891g, this.f892h);
        }
    }

    private MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f893a = str;
        this.f894b = charSequence;
        this.f895c = charSequence2;
        this.f896d = charSequence3;
        this.f897e = bitmap;
        this.f898f = uri;
        this.f899g = bundle;
        this.f900h = uri2;
    }

    private MediaDescriptionCompat(Parcel parcel) {
        this.f893a = parcel.readString();
        this.f894b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f895c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f896d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f897e = (Bitmap) parcel.readParcelable(null);
        this.f898f = (Uri) parcel.readParcelable(null);
        this.f899g = parcel.readBundle();
        this.f900h = (Uri) parcel.readParcelable(null);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (VERSION.SDK_INT < 21) {
            parcel.writeString(this.f893a);
            TextUtils.writeToParcel(this.f894b, parcel, i);
            TextUtils.writeToParcel(this.f895c, parcel, i);
            TextUtils.writeToParcel(this.f896d, parcel, i);
            parcel.writeParcelable(this.f897e, i);
            parcel.writeParcelable(this.f898f, i);
            parcel.writeBundle(this.f899g);
            parcel.writeParcelable(this.f900h, i);
            return;
        }
        C0305b.m1259a(m1245a(), parcel, i);
    }

    public String toString() {
        return this.f894b + ", " + this.f895c + ", " + this.f896d;
    }

    public Object m1245a() {
        if (this.f901i != null || VERSION.SDK_INT < 21) {
            return this.f901i;
        }
        Object a = C0304a.m1248a();
        C0304a.m1254a(a, this.f893a);
        C0304a.m1253a(a, this.f894b);
        C0304a.m1255b(a, this.f895c);
        C0304a.m1256c(a, this.f896d);
        C0304a.m1250a(a, this.f897e);
        C0304a.m1251a(a, this.f898f);
        Bundle bundle = this.f899g;
        if (VERSION.SDK_INT < 23 && this.f900h != null) {
            if (bundle == null) {
                bundle = new Bundle();
                bundle.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
            }
            bundle.putParcelable("android.support.v4.media.description.MEDIA_URI", this.f900h);
        }
        C0304a.m1252a(a, bundle);
        if (VERSION.SDK_INT >= 23) {
            C0306a.m1266b(a, this.f900h);
        }
        this.f901i = C0304a.m1249a(a);
        return this.f901i;
    }

    public static MediaDescriptionCompat m1244a(Object obj) {
        if (obj == null || VERSION.SDK_INT < 21) {
            return null;
        }
        Uri uri;
        Bundle bundle;
        MediaDescriptionCompat a;
        C0302a c0302a = new C0302a();
        c0302a.m1239a(C0305b.m1258a(obj));
        c0302a.m1238a(C0305b.m1260b(obj));
        c0302a.m1242b(C0305b.m1261c(obj));
        c0302a.m1243c(C0305b.m1262d(obj));
        c0302a.m1235a(C0305b.m1263e(obj));
        c0302a.m1236a(C0305b.m1264f(obj));
        Bundle g = C0305b.m1265g(obj);
        if (g == null) {
            uri = null;
        } else {
            uri = (Uri) g.getParcelable("android.support.v4.media.description.MEDIA_URI");
        }
        if (uri != null) {
            if (g.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") && g.size() == 2) {
                bundle = null;
                c0302a.m1237a(bundle);
                if (uri != null) {
                    c0302a.m1241b(uri);
                } else if (VERSION.SDK_INT >= 23) {
                    c0302a.m1241b(C0307c.m1267h(obj));
                }
                a = c0302a.m1240a();
                a.f901i = obj;
                return a;
            }
            g.remove("android.support.v4.media.description.MEDIA_URI");
            g.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
        }
        bundle = g;
        c0302a.m1237a(bundle);
        if (uri != null) {
            c0302a.m1241b(uri);
        } else if (VERSION.SDK_INT >= 23) {
            c0302a.m1241b(C0307c.m1267h(obj));
        }
        a = c0302a.m1240a();
        a.f901i = obj;
        return a;
    }
}
