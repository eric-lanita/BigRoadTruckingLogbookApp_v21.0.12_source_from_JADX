package android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;

final class FragmentState implements Parcelable {
    public static final Creator<FragmentState> CREATOR = new C01201();
    final String f454a;
    final int f455b;
    final boolean f456c;
    final int f457d;
    final int f458e;
    final String f459f;
    final boolean f460g;
    final boolean f461h;
    final Bundle f462i;
    Bundle f463j;
    Fragment f464k;

    static class C01201 implements Creator<FragmentState> {
        C01201() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m562a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m563a(i);
        }

        public FragmentState m562a(Parcel parcel) {
            return new FragmentState(parcel);
        }

        public FragmentState[] m563a(int i) {
            return new FragmentState[i];
        }
    }

    public FragmentState(Fragment fragment) {
        this.f454a = fragment.getClass().getName();
        this.f455b = fragment.mIndex;
        this.f456c = fragment.mFromLayout;
        this.f457d = fragment.mFragmentId;
        this.f458e = fragment.mContainerId;
        this.f459f = fragment.mTag;
        this.f460g = fragment.mRetainInstance;
        this.f461h = fragment.mDetached;
        this.f462i = fragment.mArguments;
    }

    public FragmentState(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.f454a = parcel.readString();
        this.f455b = parcel.readInt();
        this.f456c = parcel.readInt() != 0;
        this.f457d = parcel.readInt();
        this.f458e = parcel.readInt();
        this.f459f = parcel.readString();
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f460g = z;
        if (parcel.readInt() == 0) {
            z2 = false;
        }
        this.f461h = z2;
        this.f462i = parcel.readBundle();
        this.f463j = parcel.readBundle();
    }

    public Fragment m564a(C0111q c0111q, Fragment fragment) {
        if (this.f464k != null) {
            return this.f464k;
        }
        Context i = c0111q.m537i();
        if (this.f462i != null) {
            this.f462i.setClassLoader(i.getClassLoader());
        }
        this.f464k = Fragment.instantiate(i, this.f454a, this.f462i);
        if (this.f463j != null) {
            this.f463j.setClassLoader(i.getClassLoader());
            this.f464k.mSavedFragmentState = this.f463j;
        }
        this.f464k.setIndex(this.f455b, fragment);
        this.f464k.mFromLayout = this.f456c;
        this.f464k.mRestored = true;
        this.f464k.mFragmentId = this.f457d;
        this.f464k.mContainerId = this.f458e;
        this.f464k.mTag = this.f459f;
        this.f464k.mRetainInstance = this.f460g;
        this.f464k.mDetached = this.f461h;
        this.f464k.mFragmentManager = c0111q.f440d;
        if (C0211s.f676a) {
            Log.v("FragmentManager", "Instantiated fragment " + this.f464k);
        }
        return this.f464k;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.f454a);
        parcel.writeInt(this.f455b);
        parcel.writeInt(this.f456c ? 1 : 0);
        parcel.writeInt(this.f457d);
        parcel.writeInt(this.f458e);
        parcel.writeString(this.f459f);
        if (this.f460g) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.f461h) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeBundle(this.f462i);
        parcel.writeBundle(this.f463j);
    }
}
