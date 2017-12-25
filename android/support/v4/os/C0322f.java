package android.support.v4.os;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

class C0322f<T> implements ClassLoaderCreator<T> {
    private final C0321e<T> f913a;

    public C0322f(C0321e<T> c0321e) {
        this.f913a = c0321e;
    }

    public T createFromParcel(Parcel parcel) {
        return this.f913a.mo185a(parcel, null);
    }

    public T createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return this.f913a.mo185a(parcel, classLoader);
    }

    public T[] newArray(int i) {
        return this.f913a.mo186a(i);
    }
}
