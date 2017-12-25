package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class FragmentManagerState implements Parcelable {
    public static final Creator<FragmentManagerState> CREATOR = new C01191();
    FragmentState[] f451a;
    int[] f452b;
    BackStackState[] f453c;

    static class C01191 implements Creator<FragmentManagerState> {
        C01191() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m560a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m561a(i);
        }

        public FragmentManagerState m560a(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        public FragmentManagerState[] m561a(int i) {
            return new FragmentManagerState[i];
        }
    }

    public FragmentManagerState(Parcel parcel) {
        this.f451a = (FragmentState[]) parcel.createTypedArray(FragmentState.CREATOR);
        this.f452b = parcel.createIntArray();
        this.f453c = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.f451a, i);
        parcel.writeIntArray(this.f452b);
        parcel.writeTypedArray(this.f453c, i);
    }
}
