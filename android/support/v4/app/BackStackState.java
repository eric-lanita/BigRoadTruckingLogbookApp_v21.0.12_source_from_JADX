package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.C0196h.C0193a;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

final class BackStackState implements Parcelable {
    public static final Creator<BackStackState> CREATOR = new C01061();
    final int[] f423a;
    final int f424b;
    final int f425c;
    final String f426d;
    final int f427e;
    final int f428f;
    final CharSequence f429g;
    final int f430h;
    final CharSequence f431i;
    final ArrayList<String> f432j;
    final ArrayList<String> f433k;

    static class C01061 implements Creator<BackStackState> {
        C01061() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m509a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m510a(i);
        }

        public BackStackState m509a(Parcel parcel) {
            return new BackStackState(parcel);
        }

        public BackStackState[] m510a(int i) {
            return new BackStackState[i];
        }
    }

    public BackStackState(C0196h c0196h) {
        int i = 0;
        for (C0193a c0193a = c0196h.f637c; c0193a != null; c0193a = c0193a.f621a) {
            if (c0193a.f629i != null) {
                i += c0193a.f629i.size();
            }
        }
        this.f423a = new int[(i + (c0196h.f639e * 7))];
        if (c0196h.f646l) {
            i = 0;
            for (C0193a c0193a2 = c0196h.f637c; c0193a2 != null; c0193a2 = c0193a2.f621a) {
                int i2 = i + 1;
                this.f423a[i] = c0193a2.f623c;
                int i3 = i2 + 1;
                this.f423a[i2] = c0193a2.f624d != null ? c0193a2.f624d.mIndex : -1;
                int i4 = i3 + 1;
                this.f423a[i3] = c0193a2.f625e;
                i2 = i4 + 1;
                this.f423a[i4] = c0193a2.f626f;
                i4 = i2 + 1;
                this.f423a[i2] = c0193a2.f627g;
                i2 = i4 + 1;
                this.f423a[i4] = c0193a2.f628h;
                if (c0193a2.f629i != null) {
                    int size = c0193a2.f629i.size();
                    i4 = i2 + 1;
                    this.f423a[i2] = size;
                    i2 = 0;
                    while (i2 < size) {
                        i3 = i4 + 1;
                        this.f423a[i4] = ((Fragment) c0193a2.f629i.get(i2)).mIndex;
                        i2++;
                        i4 = i3;
                    }
                    i = i4;
                } else {
                    i = i2 + 1;
                    this.f423a[i2] = 0;
                }
            }
            this.f424b = c0196h.f644j;
            this.f425c = c0196h.f645k;
            this.f426d = c0196h.f648n;
            this.f427e = c0196h.f650p;
            this.f428f = c0196h.f651q;
            this.f429g = c0196h.f652r;
            this.f430h = c0196h.f653s;
            this.f431i = c0196h.f654t;
            this.f432j = c0196h.f655u;
            this.f433k = c0196h.f656v;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public BackStackState(Parcel parcel) {
        this.f423a = parcel.createIntArray();
        this.f424b = parcel.readInt();
        this.f425c = parcel.readInt();
        this.f426d = parcel.readString();
        this.f427e = parcel.readInt();
        this.f428f = parcel.readInt();
        this.f429g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f430h = parcel.readInt();
        this.f431i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f432j = parcel.createStringArrayList();
        this.f433k = parcel.createStringArrayList();
    }

    public C0196h m511a(C0211s c0211s) {
        C0196h c0196h = new C0196h(c0211s);
        int i = 0;
        int i2 = 0;
        while (i2 < this.f423a.length) {
            C0193a c0193a = new C0193a();
            int i3 = i2 + 1;
            c0193a.f623c = this.f423a[i2];
            if (C0211s.f676a) {
                Log.v("FragmentManager", "Instantiate " + c0196h + " op #" + i + " base fragment #" + this.f423a[i3]);
            }
            int i4 = i3 + 1;
            i2 = this.f423a[i3];
            if (i2 >= 0) {
                c0193a.f624d = (Fragment) c0211s.f682f.get(i2);
            } else {
                c0193a.f624d = null;
            }
            i3 = i4 + 1;
            c0193a.f625e = this.f423a[i4];
            i4 = i3 + 1;
            c0193a.f626f = this.f423a[i3];
            i3 = i4 + 1;
            c0193a.f627g = this.f423a[i4];
            int i5 = i3 + 1;
            c0193a.f628h = this.f423a[i3];
            i4 = i5 + 1;
            int i6 = this.f423a[i5];
            if (i6 > 0) {
                c0193a.f629i = new ArrayList(i6);
                i3 = 0;
                while (i3 < i6) {
                    if (C0211s.f676a) {
                        Log.v("FragmentManager", "Instantiate " + c0196h + " set remove fragment #" + this.f423a[i4]);
                    }
                    i5 = i4 + 1;
                    c0193a.f629i.add((Fragment) c0211s.f682f.get(this.f423a[i4]));
                    i3++;
                    i4 = i5;
                }
            }
            c0196h.f640f = c0193a.f625e;
            c0196h.f641g = c0193a.f626f;
            c0196h.f642h = c0193a.f627g;
            c0196h.f643i = c0193a.f628h;
            c0196h.m853a(c0193a);
            i++;
            i2 = i4;
        }
        c0196h.f644j = this.f424b;
        c0196h.f645k = this.f425c;
        c0196h.f648n = this.f426d;
        c0196h.f650p = this.f427e;
        c0196h.f646l = true;
        c0196h.f651q = this.f428f;
        c0196h.f652r = this.f429g;
        c0196h.f653s = this.f430h;
        c0196h.f654t = this.f431i;
        c0196h.f655u = this.f432j;
        c0196h.f656v = this.f433k;
        c0196h.m852a(1);
        return c0196h;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f423a);
        parcel.writeInt(this.f424b);
        parcel.writeInt(this.f425c);
        parcel.writeString(this.f426d);
        parcel.writeInt(this.f427e);
        parcel.writeInt(this.f428f);
        TextUtils.writeToParcel(this.f429g, parcel, 0);
        parcel.writeInt(this.f430h);
        TextUtils.writeToParcel(this.f431i, parcel, 0);
        parcel.writeStringList(this.f432j);
        parcel.writeStringList(this.f433k);
    }
}
