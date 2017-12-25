package com.google.android.gms.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.internal.zzai;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class MapView extends FrameLayout {
    private final zzb f11903a;

    static class zza implements MapLifecycleDelegate {
        private final ViewGroup f11895a;
        private final IMapViewDelegate f11896b;
        private View f11897c;

        public zza(ViewGroup viewGroup, IMapViewDelegate iMapViewDelegate) {
            this.f11896b = (IMapViewDelegate) zzab.zzy(iMapViewDelegate);
            this.f11895a = (ViewGroup) zzab.zzy(viewGroup);
        }

        public void getMapAsync(final OnMapReadyCallback onMapReadyCallback) {
            try {
                this.f11896b.getMapAsync(new com.google.android.gms.maps.internal.zzt.zza(this) {
                    final /* synthetic */ zza f11894b;

                    public void zza(IGoogleMapDelegate iGoogleMapDelegate) {
                        onMapReadyCallback.onMapReady(new GoogleMap(iGoogleMapDelegate));
                    }
                });
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onCreate(Bundle bundle) {
            try {
                this.f11896b.onCreate(bundle);
                this.f11897c = (View) zze.zzad(this.f11896b.getView());
                this.f11895a.removeAllViews();
                this.f11895a.addView(this.f11897c);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            throw new UnsupportedOperationException("onCreateView not allowed on MapViewDelegate");
        }

        public void onDestroy() {
            try {
                this.f11896b.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            throw new UnsupportedOperationException("onDestroyView not allowed on MapViewDelegate");
        }

        public void onEnterAmbient(Bundle bundle) {
            try {
                this.f11896b.onEnterAmbient(bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onExitAmbient() {
            try {
                this.f11896b.onExitAmbient();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
            throw new UnsupportedOperationException("onInflate not allowed on MapViewDelegate");
        }

        public void onLowMemory() {
            try {
                this.f11896b.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.f11896b.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.f11896b.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle bundle) {
            try {
                this.f11896b.onSaveInstanceState(bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }
    }

    static class zzb extends com.google.android.gms.dynamic.zza<zza> {
        protected zzf<zza> f11898a;
        private final ViewGroup f11899b;
        private final Context f11900c;
        private final GoogleMapOptions f11901d;
        private final List<OnMapReadyCallback> f11902e = new ArrayList();

        zzb(ViewGroup viewGroup, Context context, GoogleMapOptions googleMapOptions) {
            this.f11899b = viewGroup;
            this.f11900c = context;
            this.f11901d = googleMapOptions;
        }

        protected void mo2038a(zzf<zza> com_google_android_gms_dynamic_zzf_com_google_android_gms_maps_MapView_zza) {
            this.f11898a = com_google_android_gms_dynamic_zzf_com_google_android_gms_maps_MapView_zza;
            zzbow();
        }

        public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
            if (zzbbt() != null) {
                ((zza) zzbbt()).getMapAsync(onMapReadyCallback);
            } else {
                this.f11902e.add(onMapReadyCallback);
            }
        }

        public void onEnterAmbient(Bundle bundle) {
            if (zzbbt() != null) {
                ((zza) zzbbt()).onEnterAmbient(bundle);
            }
        }

        public void onExitAmbient() {
            if (zzbbt() != null) {
                ((zza) zzbbt()).onExitAmbient();
            }
        }

        public void zzbow() {
            if (this.f11898a != null && zzbbt() == null) {
                try {
                    MapsInitializer.initialize(this.f11900c);
                    IMapViewDelegate zza = zzai.zzdk(this.f11900c).zza(zze.zzac(this.f11900c), this.f11901d);
                    if (zza != null) {
                        this.f11898a.zza(new zza(this.f11899b, zza));
                        for (OnMapReadyCallback mapAsync : this.f11902e) {
                            ((zza) zzbbt()).getMapAsync(mapAsync);
                        }
                        this.f11902e.clear();
                    }
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    public MapView(Context context) {
        super(context);
        this.f11903a = new zzb(this, context, null);
        m17632a();
    }

    public MapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11903a = new zzb(this, context, GoogleMapOptions.createFromAttributes(context, attributeSet));
        m17632a();
    }

    public MapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11903a = new zzb(this, context, GoogleMapOptions.createFromAttributes(context, attributeSet));
        m17632a();
    }

    public MapView(Context context, GoogleMapOptions googleMapOptions) {
        super(context);
        this.f11903a = new zzb(this, context, googleMapOptions);
        m17632a();
    }

    private void m17632a() {
        setClickable(true);
    }

    public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
        zzab.zzhi("getMapAsync() must be called on the main thread");
        this.f11903a.getMapAsync(onMapReadyCallback);
    }

    public final void onCreate(Bundle bundle) {
        this.f11903a.onCreate(bundle);
        if (this.f11903a.zzbbt() == null) {
            com.google.android.gms.dynamic.zza.zzb(this);
        }
    }

    public final void onDestroy() {
        this.f11903a.onDestroy();
    }

    public final void onEnterAmbient(Bundle bundle) {
        zzab.zzhi("onEnterAmbient() must be called on the main thread");
        this.f11903a.onEnterAmbient(bundle);
    }

    public final void onExitAmbient() {
        zzab.zzhi("onExitAmbient() must be called on the main thread");
        this.f11903a.onExitAmbient();
    }

    public final void onLowMemory() {
        this.f11903a.onLowMemory();
    }

    public final void onPause() {
        this.f11903a.onPause();
    }

    public final void onResume() {
        this.f11903a.onResume();
    }

    public final void onSaveInstanceState(Bundle bundle) {
        this.f11903a.onSaveInstanceState(bundle);
    }
}
