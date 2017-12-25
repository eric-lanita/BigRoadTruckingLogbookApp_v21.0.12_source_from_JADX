package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class MediaBrowserCompat {

    public static class MediaItem implements Parcelable {
        public static final Creator<MediaItem> CREATOR = new C02831();
        private final int f833a;
        private final MediaDescriptionCompat f834b;

        static class C02831 implements Creator<MediaItem> {
            C02831() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m1189a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m1190a(i);
            }

            public MediaItem m1189a(Parcel parcel) {
                return new MediaItem(parcel);
            }

            public MediaItem[] m1190a(int i) {
                return new MediaItem[i];
            }
        }

        private MediaItem(Parcel parcel) {
            this.f833a = parcel.readInt();
            this.f834b = (MediaDescriptionCompat) MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f833a);
            this.f834b.writeToParcel(parcel, i);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("MediaItem{");
            stringBuilder.append("mFlags=").append(this.f833a);
            stringBuilder.append(", mDescription=").append(this.f834b);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }
}
