package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;
import java.util.Iterator;

public class EventParams extends AbstractSafeParcelable implements Iterable<String> {
    public static final zzj CREATOR = new zzj();
    private final Bundle f12122a;
    public final int versionCode;

    class C33771 implements Iterator<String> {
        Iterator<String> f12120a = this.f12121b.f12122a.keySet().iterator();
        final /* synthetic */ EventParams f12121b;

        C33771(EventParams eventParams) {
            this.f12121b = eventParams;
        }

        public boolean hasNext() {
            return this.f12120a.hasNext();
        }

        public String next() {
            return (String) this.f12120a.next();
        }

        public void remove() {
            throw new UnsupportedOperationException("Remove not supported");
        }
    }

    EventParams(int i, Bundle bundle) {
        this.versionCode = i;
        this.f12122a = bundle;
    }

    EventParams(Bundle bundle) {
        zzab.zzy(bundle);
        this.f12122a = bundle;
        this.versionCode = 1;
    }

    Object m17712a(String str) {
        return this.f12122a.get(str);
    }

    public Iterator<String> iterator() {
        return new C33771(this);
    }

    public int size() {
        return this.f12122a.size();
    }

    public String toString() {
        return this.f12122a.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzj.m17875a(this, parcel, i);
    }

    public Bundle zzbss() {
        return new Bundle(this.f12122a);
    }
}
