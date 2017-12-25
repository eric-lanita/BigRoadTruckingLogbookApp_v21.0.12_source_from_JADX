package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MediaSessionCompat {

    public static final class Token implements Parcelable {
        public static final Creator<Token> CREATOR = new C03081();
        private final Object f902a;

        static class C03081 implements Creator<Token> {
            C03081() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m1268a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m1269a(i);
            }

            public Token m1268a(Parcel parcel) {
                Object readParcelable;
                if (VERSION.SDK_INT >= 21) {
                    readParcelable = parcel.readParcelable(null);
                } else {
                    readParcelable = parcel.readStrongBinder();
                }
                return new Token(readParcelable);
            }

            public Token[] m1269a(int i) {
                return new Token[i];
            }
        }

        Token(Object obj) {
            this.f902a = obj;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            if (VERSION.SDK_INT >= 21) {
                parcel.writeParcelable((Parcelable) this.f902a, i);
            } else {
                parcel.writeStrongBinder((IBinder) this.f902a);
            }
        }
    }
}
