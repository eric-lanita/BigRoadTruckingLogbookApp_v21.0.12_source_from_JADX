package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
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
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate;
import com.google.android.gms.maps.internal.StreetViewLifecycleDelegate;
import com.google.android.gms.maps.internal.zzah;
import com.google.android.gms.maps.internal.zzai;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class SupportStreetViewPanoramaFragment extends Fragment {
    private final zzb f11963a = new zzb(this);
    private StreetViewPanorama f11964b;

    static class zza implements StreetViewLifecycleDelegate {
        private final Fragment f11957a;
        private final IStreetViewPanoramaFragmentDelegate f11958b;

        public zza(Fragment fragment, IStreetViewPanoramaFragmentDelegate iStreetViewPanoramaFragmentDelegate) {
            this.f11958b = (IStreetViewPanoramaFragmentDelegate) zzab.zzy(iStreetViewPanoramaFragmentDelegate);
            this.f11957a = (Fragment) zzab.zzy(fragment);
        }

        public void getStreetViewPanoramaAsync(final OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
            try {
                this.f11958b.getStreetViewPanoramaAsync(new com.google.android.gms.maps.internal.zzaf.zza(this) {
                    final /* synthetic */ zza f11956b;

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
            Bundle arguments = this.f11957a.getArguments();
            if (arguments != null && arguments.containsKey("StreetViewPanoramaOptions")) {
                zzah.zza(bundle, "StreetViewPanoramaOptions", arguments.getParcelable("StreetViewPanoramaOptions"));
            }
            this.f11958b.onCreate(bundle);
        }

        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            try {
                return (View) zze.zzad(this.f11958b.onCreateView(zze.zzac(layoutInflater), zze.zzac(viewGroup), bundle));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroy() {
            try {
                this.f11958b.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            try {
                this.f11958b.onDestroyView();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
            try {
                this.f11958b.onInflate(zze.zzac(activity), null, bundle2);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onLowMemory() {
            try {
                this.f11958b.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.f11958b.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.f11958b.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle bundle) {
            try {
                this.f11958b.onSaveInstanceState(bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }

        public IStreetViewPanoramaFragmentDelegate zzboz() {
            return this.f11958b;
        }
    }

    static class zzb extends com.google.android.gms.dynamic.zza<zza> {
        protected zzf<zza> f11959a;
        private final Fragment f11960b;
        private Activity f11961c;
        private final List<OnStreetViewPanoramaReadyCallback> f11962d = new ArrayList();

        zzb(Fragment fragment) {
            this.f11960b = fragment;
        }

        private void m17648a(Activity activity) {
            this.f11961c = activity;
            zzbow();
        }

        protected void mo2038a(zzf<zza> com_google_android_gms_dynamic_zzf_com_google_android_gms_maps_SupportStreetViewPanoramaFragment_zza) {
            this.f11959a = com_google_android_gms_dynamic_zzf_com_google_android_gms_maps_SupportStreetViewPanoramaFragment_zza;
            zzbow();
        }

        public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
            if (zzbbt() != null) {
                ((zza) zzbbt()).getStreetViewPanoramaAsync(onStreetViewPanoramaReadyCallback);
            } else {
                this.f11962d.add(onStreetViewPanoramaReadyCallback);
            }
        }

        public void zzbow() {
            if (this.f11961c != null && this.f11959a != null && zzbbt() == null) {
                try {
                    MapsInitializer.initialize(this.f11961c);
                    this.f11959a.zza(new zza(this.f11960b, zzai.zzdk(this.f11961c).zzah(zze.zzac(this.f11961c))));
                    for (OnStreetViewPanoramaReadyCallback streetViewPanoramaAsync : this.f11962d) {
                        ((zza) zzbbt()).getStreetViewPanoramaAsync(streetViewPanoramaAsync);
                    }
                    this.f11962d.clear();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    public static SupportStreetViewPanoramaFragment newInstance() {
        return new SupportStreetViewPanoramaFragment();
    }

    public static SupportStreetViewPanoramaFragment newInstance(StreetViewPanoramaOptions streetViewPanoramaOptions) {
        SupportStreetViewPanoramaFragment supportStreetViewPanoramaFragment = new SupportStreetViewPanoramaFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("StreetViewPanoramaOptions", streetViewPanoramaOptions);
        supportStreetViewPanoramaFragment.setArguments(bundle);
        return supportStreetViewPanoramaFragment;
    }

    protected IStreetViewPanoramaFragmentDelegate m17651a() {
        this.f11963a.zzbow();
        return this.f11963a.zzbbt() == null ? null : ((zza) this.f11963a.zzbbt()).zzboz();
    }

    @Deprecated
    public final StreetViewPanorama getStreetViewPanorama() {
        IStreetViewPanoramaFragmentDelegate a = m17651a();
        if (a == null) {
            return null;
        }
        try {
            IStreetViewPanoramaDelegate streetViewPanorama = a.getStreetViewPanorama();
            if (streetViewPanorama == null) {
                return null;
            }
            if (this.f11964b == null || this.f11964b.m17633a().asBinder() != streetViewPanorama.asBinder()) {
                this.f11964b = new StreetViewPanorama(streetViewPanorama);
            }
            return this.f11964b;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
        zzab.zzhi("getStreetViewPanoramaAsync() must be called on the main thread");
        this.f11963a.getStreetViewPanoramaAsync(onStreetViewPanoramaReadyCallback);
    }

    public void onActivityCreated(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(SupportStreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f11963a.m17648a(activity);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f11963a.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.f11963a.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onDestroy() {
        this.f11963a.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.f11963a.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        this.f11963a.m17648a(activity);
        this.f11963a.onInflate(activity, new Bundle(), bundle);
    }

    public void onLowMemory() {
        this.f11963a.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.f11963a.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.f11963a.onResume();
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(SupportStreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(bundle);
        this.f11963a.onSaveInstanceState(bundle);
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }
}
