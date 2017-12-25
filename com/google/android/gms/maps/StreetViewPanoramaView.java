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
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate;
import com.google.android.gms.maps.internal.StreetViewLifecycleDelegate;
import com.google.android.gms.maps.internal.zzai;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class StreetViewPanoramaView extends FrameLayout {
    private final zzb f11945a;
    private StreetViewPanorama f11946b;

    static class zza implements StreetViewLifecycleDelegate {
        private final ViewGroup f11937a;
        private final IStreetViewPanoramaViewDelegate f11938b;
        private View f11939c;

        public zza(ViewGroup viewGroup, IStreetViewPanoramaViewDelegate iStreetViewPanoramaViewDelegate) {
            this.f11938b = (IStreetViewPanoramaViewDelegate) zzab.zzy(iStreetViewPanoramaViewDelegate);
            this.f11937a = (ViewGroup) zzab.zzy(viewGroup);
        }

        public void getStreetViewPanoramaAsync(final OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
            try {
                this.f11938b.getStreetViewPanoramaAsync(new com.google.android.gms.maps.internal.zzaf.zza(this) {
                    final /* synthetic */ zza f11936b;

                    public void zza(IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate) {
                        onStreetViewPanoramaReadyCallback.onStreetViewPanoramaReady(new StreetViewPanorama(iStreetViewPanoramaDelegate));
                    }
                });
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onCreate(Bundle bundle) {
            try {
                this.f11938b.onCreate(bundle);
                this.f11939c = (View) zze.zzad(this.f11938b.getView());
                this.f11937a.removeAllViews();
                this.f11937a.addView(this.f11939c);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            throw new UnsupportedOperationException("onCreateView not allowed on StreetViewPanoramaViewDelegate");
        }

        public void onDestroy() {
            try {
                this.f11938b.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            throw new UnsupportedOperationException("onDestroyView not allowed on StreetViewPanoramaViewDelegate");
        }

        public void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
            throw new UnsupportedOperationException("onInflate not allowed on StreetViewPanoramaViewDelegate");
        }

        public void onLowMemory() {
            try {
                this.f11938b.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.f11938b.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.f11938b.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle bundle) {
            try {
                this.f11938b.onSaveInstanceState(bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }

        public IStreetViewPanoramaViewDelegate zzbpd() {
            return this.f11938b;
        }
    }

    static class zzb extends com.google.android.gms.dynamic.zza<zza> {
        protected zzf<zza> f11940a;
        private final ViewGroup f11941b;
        private final Context f11942c;
        private final StreetViewPanoramaOptions f11943d;
        private final List<OnStreetViewPanoramaReadyCallback> f11944e = new ArrayList();

        zzb(ViewGroup viewGroup, Context context, StreetViewPanoramaOptions streetViewPanoramaOptions) {
            this.f11941b = viewGroup;
            this.f11942c = context;
            this.f11943d = streetViewPanoramaOptions;
        }

        protected void mo2038a(zzf<zza> com_google_android_gms_dynamic_zzf_com_google_android_gms_maps_StreetViewPanoramaView_zza) {
            this.f11940a = com_google_android_gms_dynamic_zzf_com_google_android_gms_maps_StreetViewPanoramaView_zza;
            zzbow();
        }

        public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
            if (zzbbt() != null) {
                ((zza) zzbbt()).getStreetViewPanoramaAsync(onStreetViewPanoramaReadyCallback);
            } else {
                this.f11944e.add(onStreetViewPanoramaReadyCallback);
            }
        }

        public void zzbow() {
            if (this.f11940a != null && zzbbt() == null) {
                try {
                    this.f11940a.zza(new zza(this.f11941b, zzai.zzdk(this.f11942c).zza(zze.zzac(this.f11942c), this.f11943d)));
                    for (OnStreetViewPanoramaReadyCallback streetViewPanoramaAsync : this.f11944e) {
                        ((zza) zzbbt()).getStreetViewPanoramaAsync(streetViewPanoramaAsync);
                    }
                    this.f11944e.clear();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    public StreetViewPanoramaView(Context context) {
        super(context);
        this.f11945a = new zzb(this, context, null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11945a = new zzb(this, context, null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11945a = new zzb(this, context, null);
    }

    public StreetViewPanoramaView(Context context, StreetViewPanoramaOptions streetViewPanoramaOptions) {
        super(context);
        this.f11945a = new zzb(this, context, streetViewPanoramaOptions);
    }

    @Deprecated
    public final StreetViewPanorama getStreetViewPanorama() {
        if (this.f11946b != null) {
            return this.f11946b;
        }
        this.f11945a.zzbow();
        if (this.f11945a.zzbbt() == null) {
            return null;
        }
        try {
            this.f11946b = new StreetViewPanorama(((zza) this.f11945a.zzbbt()).zzbpd().getStreetViewPanorama());
            return this.f11946b;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
        zzab.zzhi("getStreetViewPanoramaAsync() must be called on the main thread");
        this.f11945a.getStreetViewPanoramaAsync(onStreetViewPanoramaReadyCallback);
    }

    public final void onCreate(Bundle bundle) {
        this.f11945a.onCreate(bundle);
        if (this.f11945a.zzbbt() == null) {
            com.google.android.gms.dynamic.zza.zzb(this);
        }
    }

    public final void onDestroy() {
        this.f11945a.onDestroy();
    }

    public final void onLowMemory() {
        this.f11945a.onLowMemory();
    }

    public final void onPause() {
        this.f11945a.onPause();
    }

    public final void onResume() {
        this.f11945a.onResume();
    }

    public final void onSaveInstanceState(Bundle bundle) {
        this.f11945a.onSaveInstanceState(bundle);
    }
}
