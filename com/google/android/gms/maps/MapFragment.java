package com.google.android.gms.maps;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.internal.zzah;
import com.google.android.gms.maps.internal.zzai;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

@TargetApi(11)
public class MapFragment extends Fragment {
    private final zzb f11892a = new zzb(this);

    static class zza implements MapLifecycleDelegate {
        private final Fragment f11886a;
        private final IMapFragmentDelegate f11887b;

        public zza(Fragment fragment, IMapFragmentDelegate iMapFragmentDelegate) {
            this.f11887b = (IMapFragmentDelegate) zzab.zzy(iMapFragmentDelegate);
            this.f11886a = (Fragment) zzab.zzy(fragment);
        }

        public void getMapAsync(final OnMapReadyCallback onMapReadyCallback) {
            try {
                this.f11887b.getMapAsync(new com.google.android.gms.maps.internal.zzt.zza(this) {
                    final /* synthetic */ zza f11885b;

                    public void zza(IGoogleMapDelegate iGoogleMapDelegate) {
                        onMapReadyCallback.onMapReady(new GoogleMap(iGoogleMapDelegate));
                    }
                });
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onCreate(Bundle bundle) {
            if (bundle == null) {
                try {
                    bundle = new Bundle();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
            Bundle arguments = this.f11886a.getArguments();
            if (arguments != null && arguments.containsKey("MapOptions")) {
                zzah.zza(bundle, "MapOptions", arguments.getParcelable("MapOptions"));
            }
            this.f11887b.onCreate(bundle);
        }

        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            try {
                return (View) zze.zzad(this.f11887b.onCreateView(zze.zzac(layoutInflater), zze.zzac(viewGroup), bundle));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroy() {
            try {
                this.f11887b.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            try {
                this.f11887b.onDestroyView();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onEnterAmbient(Bundle bundle) {
            try {
                this.f11887b.onEnterAmbient(bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onExitAmbient() {
            try {
                this.f11887b.onExitAmbient();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
            try {
                this.f11887b.onInflate(zze.zzac(activity), (GoogleMapOptions) bundle.getParcelable("MapOptions"), bundle2);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onLowMemory() {
            try {
                this.f11887b.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.f11887b.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.f11887b.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle bundle) {
            try {
                this.f11887b.onSaveInstanceState(bundle);
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
        protected zzf<zza> f11888a;
        private final Fragment f11889b;
        private Activity f11890c;
        private final List<OnMapReadyCallback> f11891d = new ArrayList();

        zzb(Fragment fragment) {
            this.f11889b = fragment;
        }

        private void m17628a(Activity activity) {
            this.f11890c = activity;
            zzbow();
        }

        protected void mo2038a(zzf<zza> com_google_android_gms_dynamic_zzf_com_google_android_gms_maps_MapFragment_zza) {
            this.f11888a = com_google_android_gms_dynamic_zzf_com_google_android_gms_maps_MapFragment_zza;
            zzbow();
        }

        public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
            if (zzbbt() != null) {
                ((zza) zzbbt()).getMapAsync(onMapReadyCallback);
            } else {
                this.f11891d.add(onMapReadyCallback);
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
            if (this.f11890c != null && this.f11888a != null && zzbbt() == null) {
                try {
                    MapsInitializer.initialize(this.f11890c);
                    IMapFragmentDelegate zzag = zzai.zzdk(this.f11890c).zzag(zze.zzac(this.f11890c));
                    if (zzag != null) {
                        this.f11888a.zza(new zza(this.f11889b, zzag));
                        for (OnMapReadyCallback mapAsync : this.f11891d) {
                            ((zza) zzbbt()).getMapAsync(mapAsync);
                        }
                        this.f11891d.clear();
                    }
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    public static MapFragment newInstance() {
        return new MapFragment();
    }

    public static MapFragment newInstance(GoogleMapOptions googleMapOptions) {
        MapFragment mapFragment = new MapFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", googleMapOptions);
        mapFragment.setArguments(bundle);
        return mapFragment;
    }

    public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
        zzab.zzhi("getMapAsync must be called on the main thread.");
        this.f11892a.getMapAsync(onMapReadyCallback);
    }

    public void onActivityCreated(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MapFragment.class.getClassLoader());
        }
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f11892a.m17628a(activity);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f11892a.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = this.f11892a.onCreateView(layoutInflater, viewGroup, bundle);
        onCreateView.setClickable(true);
        return onCreateView;
    }

    public void onDestroy() {
        this.f11892a.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.f11892a.onDestroyView();
        super.onDestroyView();
    }

    public final void onEnterAmbient(Bundle bundle) {
        zzab.zzhi("onEnterAmbient must be called on the main thread.");
        this.f11892a.onEnterAmbient(bundle);
    }

    public final void onExitAmbient() {
        zzab.zzhi("onExitAmbient must be called on the main thread.");
        this.f11892a.onExitAmbient();
    }

    @SuppressLint({"NewApi"})
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        this.f11892a.m17628a(activity);
        Parcelable createFromAttributes = GoogleMapOptions.createFromAttributes(activity, attributeSet);
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("MapOptions", createFromAttributes);
        this.f11892a.onInflate(activity, bundle2, bundle);
    }

    public void onLowMemory() {
        this.f11892a.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.f11892a.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.f11892a.onResume();
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MapFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(bundle);
        this.f11892a.onSaveInstanceState(bundle);
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }
}
