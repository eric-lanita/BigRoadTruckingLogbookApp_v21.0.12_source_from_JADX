package android.support.v4.os;

import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class C0320d {

    static class C0319a<T> implements Creator<T> {
        final C0321e<T> f912a;

        public C0319a(C0321e<T> c0321e) {
            this.f912a = c0321e;
        }

        public T createFromParcel(Parcel parcel) {
            return this.f912a.mo185a(parcel, null);
        }

        public T[] newArray(int i) {
            return this.f912a.mo186a(i);
        }
    }

    public static <T> Creator<T> m1282a(C0321e<T> c0321e) {
        if (VERSION.SDK_INT >= 13) {
            return C0323g.m1285a(c0321e);
        }
        return new C0319a(c0321e);
    }
}
