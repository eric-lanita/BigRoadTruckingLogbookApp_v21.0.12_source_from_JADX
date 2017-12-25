package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.maps.model.internal.zzi;
import com.google.android.gms.maps.model.internal.zzi.zza;

public final class TileOverlayOptions extends AbstractSafeParcelable {
    public static final zzo CREATOR = new zzo();
    private final int f12097a;
    private zzi f12098b;
    private TileProvider f12099c;
    private boolean f12100d;
    private float f12101e;
    private boolean f12102f;
    private float f12103g;

    class C33731 implements TileProvider {
        final /* synthetic */ TileOverlayOptions f12093a;
        private final zzi f12094b = this.f12093a.f12098b;

        C33731(TileOverlayOptions tileOverlayOptions) {
            this.f12093a = tileOverlayOptions;
        }

        public Tile getTile(int i, int i2, int i3) {
            try {
                return this.f12094b.getTile(i, i2, i3);
            } catch (RemoteException e) {
                return null;
            }
        }
    }

    public TileOverlayOptions() {
        this.f12100d = true;
        this.f12102f = true;
        this.f12103g = 0.0f;
        this.f12097a = 1;
    }

    TileOverlayOptions(int i, IBinder iBinder, boolean z, float f, boolean z2, float f2) {
        this.f12100d = true;
        this.f12102f = true;
        this.f12103g = 0.0f;
        this.f12097a = i;
        this.f12098b = zza.zzje(iBinder);
        this.f12099c = this.f12098b == null ? null : new C33731(this);
        this.f12100d = z;
        this.f12101e = f;
        this.f12102f = z2;
        this.f12103g = f2;
    }

    int m17685a() {
        return this.f12097a;
    }

    IBinder m17686b() {
        return this.f12098b.asBinder();
    }

    public TileOverlayOptions fadeIn(boolean z) {
        this.f12102f = z;
        return this;
    }

    public boolean getFadeIn() {
        return this.f12102f;
    }

    public TileProvider getTileProvider() {
        return this.f12099c;
    }

    public float getTransparency() {
        return this.f12103g;
    }

    public float getZIndex() {
        return this.f12101e;
    }

    public boolean isVisible() {
        return this.f12100d;
    }

    public TileOverlayOptions tileProvider(final TileProvider tileProvider) {
        this.f12099c = tileProvider;
        this.f12098b = this.f12099c == null ? null : new zza(this) {
            final /* synthetic */ TileOverlayOptions f12096b;

            public Tile getTile(int i, int i2, int i3) {
                return tileProvider.getTile(i, i2, i3);
            }
        };
        return this;
    }

    public TileOverlayOptions transparency(float f) {
        boolean z = f >= 0.0f && f <= 1.0f;
        zzab.zzb(z, (Object) "Transparency must be in the range [0..1]");
        this.f12103g = f;
        return this;
    }

    public TileOverlayOptions visible(boolean z) {
        this.f12100d = z;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzo.m17704a(this, parcel, i);
    }

    public TileOverlayOptions zIndex(float f) {
        this.f12101e = f;
        return this;
    }
}
