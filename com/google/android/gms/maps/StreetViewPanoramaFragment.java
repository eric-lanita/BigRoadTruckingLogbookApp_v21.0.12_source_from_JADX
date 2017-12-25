package com.google.android.gms.maps;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate;
import com.google.android.gms.maps.internal.StreetViewLifecycleDelegate;
import com.google.android.gms.maps.internal.zzah;
import com.google.android.gms.maps.internal.zzai;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

@TargetApi(11)
public class StreetViewPanoramaFragment extends Fragment {
    private final zzb f11923a = new zzb(this);
    private StreetViewPanorama f11924b;

    static class zza implements StreetViewLifecycleDelegate {
        private final Fragment f11917a;
        private final IStreetViewPanoramaFragmentDelegate f11918b;

        public zza(Fragment fragment, IStreetViewPanoramaFragmentDelegate iStreetViewPanoramaFragmentDelegate) {
            this.f11918b = (IStreetViewPanoramaFragmentDelegate) zzab.zzy(iStreetViewPanoramaFragmentDelegate);
            this.f11917a = (Fragment) zzab.zzy(fragment);
        }

        public void getStreetViewPanoramaAsync(final OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
            try {
                this.f11918b.getStreetViewPanoramaAsync(new com.google.android.gms.maps.internal.zzaf.zza(this) {
                    final /* synthetic */ zza f11916b;

                    public void zza(IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate) {
                        onStreetViewPanoramaReadyCallback.onStreetViewPanoramaReady(new StreetViewPanorama(iStreetViewPanoramaDelegate));
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
            Bundle arguments = this.f11917a.getArguments();
            if (arguments != null && arguments.containsKey("StreetViewPanoramaOptions")) {
                zzah.zza(bundle, "StreetViewPanoramaOptions", arguments.getParcelable("StreetViewPanoramaOptions"));
            }
            this.f11918b.onCreate(bundle);
        }

        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            try {
                return (View) zze.zzad(this.f11918b.onCreateView(zze.zzac(layoutInflater), zze.zzac(viewGroup), bundle));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroy() {
            try {
                this.f11918b.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            try {
                this.f11918b.onDestroyView();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
            try {
                this.f11918b.onInflate(zze.zzac(activity), null, bundle2);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onLowMemory() {
            try {
                this.f11918b.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.f11918b.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.f11918b.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle bundle) {
            try {
                this.f11918b.onSaveInstanceState(bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }

        public IStreetViewPanoramaFragmentDelegate zzboz() {
            return this.f11918b;
        }
    }

    static class zzb extends com.google.android.gms.dynamic.zza<zza> {
        protected zzf<zza> f11919a;
        private final Fragment f11920b;
        private Activity f11921c;
        private final List<OnStreetViewPanoramaReadyCallback> f11922d = new ArrayList();

        zzb(Fragment fragment) {
            this.f11920b = fragment;
        }

        private void m17634a(Activity activity) {
            this.f11921c = activity;
            zzbow();
        }

        protected void mo2038a(zzf<zza> com_google_android_gms_dynamic_zzf_com_google_android_gms_maps_StreetViewPanoramaFragment_zza) {
            this.f11919a = com_google_android_gms_dynamic_zzf_com_google_android_gms_maps_StreetViewPanoramaFragment_zza;
            zzbow();
        }

        public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
            if (zzbbt() != null) {
                ((zza) zzbbt()).getStreetViewPanoramaAsync(onStreetViewPanoramaReadyCallback);
            } else {
                this.f11922d.add(onStreetViewPanoramaReadyCallback);
            }
        }

        public void zzbow() {
            if (this.f11921c != null && this.f11919a != null && zzbbt() == null) {
                try {
                    MapsInitializer.initialize(this.f11921c);
                    this.f11919a.zza(new zza(this.f11920b, zzai.zzdk(this.f11921c).zzah(zze.zzac(this.f11921c))));
                    for (OnStreetViewPanoramaReadyCallback streetViewPanoramaAsync : this.f11922d) {
                        ((zza) zzbbt()).getStreetViewPanoramaAsync(streetViewPanoramaAsync);
                    }
                    this.f11922d.clear();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    public static StreetViewPanoramaFragment newInstance() {
        return new StreetViewPanoramaFragment();
    }

    public static StreetViewPanoramaFragment newInstance(StreetViewPanoramaOptions streetViewPanoramaOptions) {
        StreetViewPanoramaFragment streetViewPanoramaFragment = new StreetViewPanoramaFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("StreetViewPanoramaOptions", streetViewPanoramaOptions);
        streetViewPanoramaFragment.setArguments(bundle);
        return streetViewPanoramaFragment;
    }

    protected IStreetViewPanoramaFragmentDelegate m17637a() {
        this.f11923a.zzbow();
        return this.f11923a.zzbbt() == null ? null : ((zza) this.f11923a.zzbbt()).zzboz();
    }

    @Deprecated
    public final StreetViewPanorama getStreetViewPanorama() {
        IStreetViewPanoramaFragmentDelegate a = m17637a();
        if (a == null) {
            return null;
        }
        try {
            IStreetViewPanoramaDelegate streetViewPanorama = a.getStreetViewPanorama();
            if (streetViewPanorama == null) {
                return null;
            }
            if (this.f11924b == null || this.f11924b.m17633a().asBinder() != streetViewPanorama.asBinder()) {
                this.f11924b = new StreetViewPanorama(streetViewPanorama);
            }
            return this.f11924b;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
        zzab.zzhi("getStreetViewPanoramaAsync() must be called on the main thread");
        this.f11923a.getStreetViewPanoramaAsync(onStreetViewPanoramaReadyCallback);
    }

    public void onActivityCreated(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(StreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f11923a.m17634a(activity);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f11923a.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.f11923a.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onDestroy() {
        this.f11923a.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.f11923a.onDestroyView();
        super.onDestroyView();
    }

    @SuppressLint({"NewApi"})
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        this.f11923a.m17634a(activity);
        this.f11923a.onInflate(activity, new Bundle(), bundle);
    }

    public void onLowMemory() {
        this.f11923a.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.f11923a.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.f11923a.onResume();
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(StreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(bundle);
        this.f11923a.onSaveInstanceState(bundle);
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }
}
