package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
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

public class SupportMapFragment extends Fragment {
    private final zzb f7523a = new zzb(this);

    static class zza implements MapLifecycleDelegate {
        private final Fragment f11949a;
        private final IMapFragmentDelegate f11950b;

        public zza(Fragment fragment, IMapFragmentDelegate iMapFragmentDelegate) {
            this.f11950b = (IMapFragmentDelegate) zzab.zzy(iMapFragmentDelegate);
            this.f11949a = (Fragment) zzab.zzy(fragment);
        }

        public void getMapAsync(final OnMapReadyCallback onMapReadyCallback) {
            try {
                this.f11950b.getMapAsync(new com.google.android.gms.maps.internal.zzt.zza(this) {
                    final /* synthetic */ zza f11948b;

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
            Bundle arguments = this.f11949a.getArguments();
            if (arguments != null && arguments.containsKey("MapOptions")) {
                zzah.zza(bundle, "MapOptions", arguments.getParcelable("MapOptions"));
            }
            this.f11950b.onCreate(bundle);
        }

        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            try {
                return (View) zze.zzad(this.f11950b.onCreateView(zze.zzac(layoutInflater), zze.zzac(viewGroup), bundle));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroy() {
            try {
                this.f11950b.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            try {
                this.f11950b.onDestroyView();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onEnterAmbient(Bundle bundle) {
            try {
                this.f11950b.onEnterAmbient(bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onExitAmbient() {
            try {
                this.f11950b.onExitAmbient();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
            try {
                this.f11950b.onInflate(zze.zzac(activity), (GoogleMapOptions) bundle.getParcelable("MapOptions"), bundle2);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onLowMemory() {
            try {
                this.f11950b.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.f11950b.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.f11950b.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle bundle) {
            try {
                this.f11950b.onSaveInstanceState(bundle);
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
        protected zzf<zza> f11951a;
        private final Fragment f11952b;
        private Activity f11953c;
        private final List<OnMapReadyCallback> f11954d = new ArrayList();

        zzb(Fragment fragment) {
            this.f11952b = fragment;
        }

        private void m17645a(Activity activity) {
            this.f11953c = activity;
            zzbow();
        }

        protected void mo2038a(zzf<zza> com_google_android_gms_dynamic_zzf_com_google_android_gms_maps_SupportMapFragment_zza) {
            this.f11951a = com_google_android_gms_dynamic_zzf_com_google_android_gms_maps_SupportMapFragment_zza;
            zzbow();
        }

        public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
            if (zzbbt() != null) {
                ((zza) zzbbt()).getMapAsync(onMapReadyCallback);
            } else {
                this.f11954d.add(onMapReadyCallback);
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
            if (this.f11953c != null && this.f11951a != null && zzbbt() == null) {
                try {
                    MapsInitializer.initialize(this.f11953c);
                    IMapFragmentDelegate zzag = zzai.zzdk(this.f11953c).zzag(zze.zzac(this.f11953c));
                    if (zzag != null) {
                        this.f11951a.zza(new zza(this.f11952b, zzag));
                        for (OnMapReadyCallback mapAsync : this.f11954d) {
                            ((zza) zzbbt()).getMapAsync(mapAsync);
                        }
                        this.f11954d.clear();
                    }
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    public static SupportMapFragment newInstance() {
        return new SupportMapFragment();
    }

    public static SupportMapFragment newInstance(GoogleMapOptions googleMapOptions) {
        SupportMapFragment supportMapFragment = new SupportMapFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", googleMapOptions);
        supportMapFragment.setArguments(bundle);
        return supportMapFragment;
    }

    public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
        zzab.zzhi("getMapAsync must be called on the main thread.");
        this.f7523a.getMapAsync(onMapReadyCallback);
    }

    public void onActivityCreated(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(SupportMapFragment.class.getClassLoader());
        }
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f7523a.m17645a(activity);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f7523a.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = this.f7523a.onCreateView(layoutInflater, viewGroup, bundle);
        onCreateView.setClickable(true);
        return onCreateView;
    }

    public void onDestroy() {
        this.f7523a.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.f7523a.onDestroyView();
        super.onDestroyView();
    }

    public final void onEnterAmbient(Bundle bundle) {
        zzab.zzhi("onEnterAmbient must be called on the main thread.");
        this.f7523a.onEnterAmbient(bundle);
    }

    public final void onExitAmbient() {
        zzab.zzhi("onExitAmbient must be called on the main thread.");
        this.f7523a.onExitAmbient();
    }

    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        this.f7523a.m17645a(activity);
        Parcelable createFromAttributes = GoogleMapOptions.createFromAttributes(activity, attributeSet);
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("MapOptions", createFromAttributes);
        this.f7523a.onInflate(activity, bundle2, bundle);
    }

    public void onLowMemory() {
        this.f7523a.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.f7523a.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.f7523a.onResume();
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(SupportMapFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(bundle);
        this.f7523a.onSaveInstanceState(bundle);
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }
}
