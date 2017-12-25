package com.bigroad.ttb.android.maps;

import android.location.Location;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.logging.C2138i;
import com.bigroad.ttb.android.maps.C2170e.C2169a;
import com.bigroad.ttb.android.p030a.C1257b;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnCameraChangeListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class NativeMapFragment extends SupportMapFragment implements C2158c {
    private GoogleMap f7524a;
    private BitmapDescriptor f7525b;
    private BitmapDescriptor f7526c;
    private Marker f7527d;
    private Circle f7528e;

    class C21561 implements OnMapReadyCallback {
        final /* synthetic */ NativeMapFragment f7518a;

        class C21551 implements OnCameraChangeListener {
            final /* synthetic */ C21561 f7517a;

            C21551(C21561 c21561) {
                this.f7517a = c21561;
            }

            public void onCameraChange(CameraPosition cameraPosition) {
                if (this.f7517a.f7518a.f7527d != null) {
                    boolean contains = this.f7517a.f7518a.f7524a.getProjection().getVisibleRegion().latLngBounds.contains(this.f7517a.f7518a.f7527d.getPosition());
                    C2167b b = this.f7517a.f7518a.m10755d();
                    if (b != null) {
                        b.mo1332a(!contains);
                    }
                    C2134e.m10673a("TT-NativeMapFragment", "Updated map " + C2138i.m10692a(this.f7517a.f7518a) + " target: " + C2138i.m10691a(cameraPosition.target) + ", zoom: " + cameraPosition.zoom);
                }
            }
        }

        C21561(NativeMapFragment nativeMapFragment) {
            this.f7518a = nativeMapFragment;
        }

        public void onMapReady(GoogleMap googleMap) {
            this.f7518a.f7524a = googleMap;
            if (this.f7518a.f7524a != null) {
                C2167b b = this.f7518a.m10755d();
                if (b != null) {
                    b.mo1333b();
                }
                this.f7518a.f7524a.setOnCameraChangeListener(new C21551(this));
            }
        }
    }

    private C2167b m10755d() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof C2167b) {
            return (C2167b) parentFragment;
        }
        return null;
    }

    public GoogleMap m10761c() {
        return this.f7524a;
    }

    public void onResume() {
        super.onResume();
        getMapAsync(new C21561(this));
    }

    public void onDestroyView() {
        if (this.f7527d != null) {
            this.f7527d.remove();
            this.f7527d = null;
        }
        if (this.f7528e != null) {
            this.f7528e.remove();
            this.f7528e = null;
        }
        super.onDestroyView();
    }

    public void mo1251a(Location location, float f) {
        if (this.f7524a != null) {
            LatLngBounds latLngBounds = this.f7524a.getProjection().getVisibleRegion().latLngBounds;
            boolean z = this.f7527d == null || latLngBounds.contains(this.f7527d.getPosition());
            LatLng a = C2170e.m10785a(location);
            if (this.f7525b == null) {
                this.f7525b = BitmapDescriptorFactory.fromResource(R.drawable.current_position_moving);
            }
            if (this.f7526c == null) {
                this.f7526c = BitmapDescriptorFactory.fromResource(R.drawable.current_position);
            }
            if (this.f7527d == null) {
                this.f7527d = this.f7524a.addMarker(new MarkerOptions().flat(true).anchor(0.5f, 0.5f).icon(this.f7526c).rotation(f).position(a));
            }
            if (this.f7528e == null) {
                this.f7528e = this.f7524a.addCircle(new CircleOptions().center(a).radius((double) location.getAccuracy()).fillColor(758888959).strokeColor(-12862977).strokeWidth(1.0f));
            }
            if (location.getSpeed() < 5.0f) {
                this.f7527d.setIcon(this.f7526c);
                this.f7527d.setRotation(0.0f);
            } else {
                this.f7527d.setIcon(this.f7525b);
                this.f7527d.setRotation(f);
            }
            this.f7528e.setCenter(a);
            this.f7527d.setPosition(a);
            if (z && !C2170e.m10788a(a, latLngBounds, 0.7d)) {
                mo1250a(location);
            }
        }
    }

    public void mo1250a(Location location) {
        if (this.f7524a != null && location != null) {
            this.f7524a.animateCamera(CameraUpdateFactory.newLatLng(C2170e.m10785a(location)));
        }
    }

    public void mo1252a(MapType mapType) {
        if (this.f7524a != null) {
            if (mapType == MapType.NIGHT) {
                C2134e.m10682e("TT-NativeMapFragment", "Attempting to use Night mode with native maps. This is not supported.");
                return;
            }
            C2134e.m10676b("TT-NativeMapFragment", "Switching to map type: " + mapType);
            this.f7524a.setMapType(mapType.m10745d());
        }
    }

    public void mo1249a() {
        if (this.f7524a != null) {
            this.f7524a.animateCamera(CameraUpdateFactory.zoomIn());
        }
    }

    public void mo1253b() {
        if (this.f7524a != null) {
            this.f7524a.animateCamera(CameraUpdateFactory.zoomOut());
        }
    }

    public void setViewTarget(final C2169a c2169a) {
        if (this.f7524a != null && c2169a != null && getView() != null) {
            final View view = getView();
            if (view.getWidth() <= 0 || view.getHeight() <= 0) {
                final ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
                        final /* synthetic */ NativeMapFragment f7522d;

                        public void onGlobalLayout() {
                            ViewTreeObserver viewTreeObserver;
                            this.f7522d.f7524a.moveCamera(CameraUpdateFactory.newLatLngZoom(c2169a.m10779a(), c2169a.m10780b()));
                            if (viewTreeObserver.isAlive()) {
                                viewTreeObserver = viewTreeObserver;
                            } else {
                                viewTreeObserver = view.getViewTreeObserver();
                            }
                            C1257b.m6613a(viewTreeObserver, (OnGlobalLayoutListener) this);
                        }
                    });
                    return;
                }
                return;
            }
            this.f7524a.moveCamera(CameraUpdateFactory.newLatLngZoom(c2169a.m10779a(), c2169a.m10780b()));
        }
    }

    public C2169a getViewTarget() {
        if (this.f7524a == null) {
            return null;
        }
        CameraPosition cameraPosition = this.f7524a.getCameraPosition();
        return new C2169a(cameraPosition.target, cameraPosition.zoom);
    }
}
