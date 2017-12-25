package com.google.android.gms.maps;

import android.graphics.Bitmap;
import android.location.Location;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.maps.LocationSource.OnLocationChangedListener;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.zzp;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.IndoorBuilding;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.internal.IPolylineDelegate;
import com.google.android.gms.maps.model.internal.zzb;
import com.google.android.gms.maps.model.internal.zzc;
import com.google.android.gms.maps.model.internal.zzd;
import com.google.android.gms.maps.model.internal.zzf;
import com.google.android.gms.maps.model.internal.zzg;
import com.google.android.gms.maps.model.internal.zzh;

public final class GoogleMap {
    public static final int MAP_TYPE_HYBRID = 4;
    public static final int MAP_TYPE_NONE = 0;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    public static final int MAP_TYPE_TERRAIN = 3;
    private final IGoogleMapDelegate f11865a;
    private UiSettings f11866b;

    @Deprecated
    public interface OnCameraChangeListener {
        void onCameraChange(CameraPosition cameraPosition);
    }

    public interface CancelableCallback {
        void onCancel();

        void onFinish();
    }

    public interface InfoWindowAdapter {
        View getInfoContents(Marker marker);

        View getInfoWindow(Marker marker);
    }

    public interface OnCameraIdleListener {
        void onCameraIdle();
    }

    public interface OnCameraMoveCanceledListener {
        void onCameraMoveCanceled();
    }

    public interface OnCameraMoveListener {
        void onCameraMove();
    }

    public interface OnCameraMoveStartedListener {
        public static final int REASON_API_ANIMATION = 2;
        public static final int REASON_DEVELOPER_ANIMATION = 3;
        public static final int REASON_GESTURE = 1;

        void onCameraMoveStarted(int i);
    }

    public interface OnCircleClickListener {
        void onCircleClick(Circle circle);
    }

    public interface OnGroundOverlayClickListener {
        void onGroundOverlayClick(GroundOverlay groundOverlay);
    }

    public interface OnIndoorStateChangeListener {
        void onIndoorBuildingFocused();

        void onIndoorLevelActivated(IndoorBuilding indoorBuilding);
    }

    public interface OnInfoWindowClickListener {
        void onInfoWindowClick(Marker marker);
    }

    public interface OnInfoWindowCloseListener {
        void onInfoWindowClose(Marker marker);
    }

    public interface OnInfoWindowLongClickListener {
        void onInfoWindowLongClick(Marker marker);
    }

    public interface OnMapClickListener {
        void onMapClick(LatLng latLng);
    }

    public interface OnMapLoadedCallback {
        void onMapLoaded();
    }

    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng latLng);
    }

    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    public interface OnMarkerDragListener {
        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);

        void onMarkerDragStart(Marker marker);
    }

    public interface OnMyLocationButtonClickListener {
        boolean onMyLocationButtonClick();
    }

    @Deprecated
    public interface OnMyLocationChangeListener {
        void onMyLocationChange(Location location);
    }

    public interface OnPolygonClickListener {
        void onPolygonClick(Polygon polygon);
    }

    public interface OnPolylineClickListener {
        void onPolylineClick(Polyline polyline);
    }

    public interface SnapshotReadyCallback {
        void onSnapshotReady(Bitmap bitmap);
    }

    private static final class zza extends com.google.android.gms.maps.internal.zzb.zza {
        private final CancelableCallback f11864a;

        zza(CancelableCallback cancelableCallback) {
            this.f11864a = cancelableCallback;
        }

        public void onCancel() {
            this.f11864a.onCancel();
        }

        public void onFinish() {
            this.f11864a.onFinish();
        }
    }

    protected GoogleMap(IGoogleMapDelegate iGoogleMapDelegate) {
        this.f11865a = (IGoogleMapDelegate) zzab.zzy(iGoogleMapDelegate);
    }

    public final Circle addCircle(CircleOptions circleOptions) {
        try {
            return new Circle(this.f11865a.addCircle(circleOptions));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) {
        try {
            zzc addGroundOverlay = this.f11865a.addGroundOverlay(groundOverlayOptions);
            return addGroundOverlay != null ? new GroundOverlay(addGroundOverlay) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Marker addMarker(MarkerOptions markerOptions) {
        try {
            zzf addMarker = this.f11865a.addMarker(markerOptions);
            return addMarker != null ? new Marker(addMarker) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polygon addPolygon(PolygonOptions polygonOptions) {
        try {
            return new Polygon(this.f11865a.addPolygon(polygonOptions));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polyline addPolyline(PolylineOptions polylineOptions) {
        try {
            return new Polyline(this.f11865a.addPolyline(polylineOptions));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions) {
        try {
            zzh addTileOverlay = this.f11865a.addTileOverlay(tileOverlayOptions);
            return addTileOverlay != null ? new TileOverlay(addTileOverlay) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate cameraUpdate) {
        try {
            this.f11865a.animateCamera(cameraUpdate.zzboj());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate cameraUpdate, int i, CancelableCallback cancelableCallback) {
        try {
            this.f11865a.animateCameraWithDurationAndCallback(cameraUpdate.zzboj(), i, cancelableCallback == null ? null : new zza(cancelableCallback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate cameraUpdate, CancelableCallback cancelableCallback) {
        try {
            this.f11865a.animateCameraWithCallback(cameraUpdate.zzboj(), cancelableCallback == null ? null : new zza(cancelableCallback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void clear() {
        try {
            this.f11865a.clear();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final CameraPosition getCameraPosition() {
        try {
            return this.f11865a.getCameraPosition();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public IndoorBuilding getFocusedBuilding() {
        try {
            zzd focusedBuilding = this.f11865a.getFocusedBuilding();
            return focusedBuilding != null ? new IndoorBuilding(focusedBuilding) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int getMapType() {
        try {
            return this.f11865a.getMapType();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMaxZoomLevel() {
        try {
            return this.f11865a.getMaxZoomLevel();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMinZoomLevel() {
        try {
            return this.f11865a.getMinZoomLevel();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Deprecated
    public final Location getMyLocation() {
        try {
            return this.f11865a.getMyLocation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Projection getProjection() {
        try {
            return new Projection(this.f11865a.getProjection());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final UiSettings getUiSettings() {
        try {
            if (this.f11866b == null) {
                this.f11866b = new UiSettings(this.f11865a.getUiSettings());
            }
            return this.f11866b;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isBuildingsEnabled() {
        try {
            return this.f11865a.isBuildingsEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isIndoorEnabled() {
        try {
            return this.f11865a.isIndoorEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isMyLocationEnabled() {
        try {
            return this.f11865a.isMyLocationEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isTrafficEnabled() {
        try {
            return this.f11865a.isTrafficEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void moveCamera(CameraUpdate cameraUpdate) {
        try {
            this.f11865a.moveCamera(cameraUpdate.zzboj());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void resetMinMaxZoomPreference() {
        try {
            this.f11865a.resetMinMaxZoomPreference();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setBuildingsEnabled(boolean z) {
        try {
            this.f11865a.setBuildingsEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setContentDescription(String str) {
        try {
            this.f11865a.setContentDescription(str);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean setIndoorEnabled(boolean z) {
        try {
            return this.f11865a.setIndoorEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setInfoWindowAdapter(final InfoWindowAdapter infoWindowAdapter) {
        if (infoWindowAdapter == null) {
            try {
                this.f11865a.setInfoWindowAdapter(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f11865a.setInfoWindowAdapter(new com.google.android.gms.maps.internal.zzd.zza(this) {
            final /* synthetic */ GoogleMap f11859b;

            public com.google.android.gms.dynamic.zzd zzh(zzf com_google_android_gms_maps_model_internal_zzf) {
                return zze.zzac(infoWindowAdapter.getInfoWindow(new Marker(com_google_android_gms_maps_model_internal_zzf)));
            }

            public com.google.android.gms.dynamic.zzd zzi(zzf com_google_android_gms_maps_model_internal_zzf) {
                return zze.zzac(infoWindowAdapter.getInfoContents(new Marker(com_google_android_gms_maps_model_internal_zzf)));
            }
        });
    }

    public void setLatLngBoundsForCameraTarget(LatLngBounds latLngBounds) {
        try {
            this.f11865a.setLatLngBoundsForCameraTarget(latLngBounds);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setLocationSource(final LocationSource locationSource) {
        if (locationSource == null) {
            try {
                this.f11865a.setLocationSource(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f11865a.setLocationSource(new com.google.android.gms.maps.internal.ILocationSourceDelegate.zza(this) {
            final /* synthetic */ GoogleMap f11823b;

            public void activate(final zzp com_google_android_gms_maps_internal_zzp) {
                locationSource.activate(new OnLocationChangedListener(this) {
                    final /* synthetic */ AnonymousClass12 f11821b;

                    public void onLocationChanged(Location location) {
                        try {
                            com_google_android_gms_maps_internal_zzp.zzd(location);
                        } catch (RemoteException e) {
                            throw new RuntimeRemoteException(e);
                        }
                    }
                });
            }

            public void deactivate() {
                locationSource.deactivate();
            }
        });
    }

    public final void setMapType(int i) {
        try {
            this.f11865a.setMapType(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setMaxZoomPreference(float f) {
        try {
            this.f11865a.setMaxZoomPreference(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setMinZoomPreference(float f) {
        try {
            this.f11865a.setMinZoomPreference(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setMyLocationEnabled(boolean z) {
        try {
            this.f11865a.setMyLocationEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Deprecated
    public final void setOnCameraChangeListener(final OnCameraChangeListener onCameraChangeListener) {
        if (onCameraChangeListener == null) {
            try {
                this.f11865a.setOnCameraChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f11865a.setOnCameraChangeListener(new com.google.android.gms.maps.internal.zze.zza(this) {
            final /* synthetic */ GoogleMap f11833b;

            public void onCameraChange(CameraPosition cameraPosition) {
                onCameraChangeListener.onCameraChange(cameraPosition);
            }
        });
    }

    public final void setOnCameraIdleListener(final OnCameraIdleListener onCameraIdleListener) {
        if (onCameraIdleListener == null) {
            try {
                this.f11865a.setOnCameraIdleListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f11865a.setOnCameraIdleListener(new com.google.android.gms.maps.internal.zzf.zza(this) {
            final /* synthetic */ GoogleMap f11843b;

            public void onCameraIdle() {
                onCameraIdleListener.onCameraIdle();
            }
        });
    }

    public final void setOnCameraMoveCanceledListener(final OnCameraMoveCanceledListener onCameraMoveCanceledListener) {
        if (onCameraMoveCanceledListener == null) {
            try {
                this.f11865a.setOnCameraMoveCanceledListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f11865a.setOnCameraMoveCanceledListener(new com.google.android.gms.maps.internal.zzg.zza(this) {
            final /* synthetic */ GoogleMap f11841b;

            public void onCameraMoveCanceled() {
                onCameraMoveCanceledListener.onCameraMoveCanceled();
            }
        });
    }

    public final void setOnCameraMoveListener(final OnCameraMoveListener onCameraMoveListener) {
        if (onCameraMoveListener == null) {
            try {
                this.f11865a.setOnCameraMoveListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f11865a.setOnCameraMoveListener(new com.google.android.gms.maps.internal.zzh.zza(this) {
            final /* synthetic */ GoogleMap f11837b;

            public void onCameraMove() {
                onCameraMoveListener.onCameraMove();
            }
        });
    }

    public final void setOnCameraMoveStartedListener(final OnCameraMoveStartedListener onCameraMoveStartedListener) {
        if (onCameraMoveStartedListener == null) {
            try {
                this.f11865a.setOnCameraMoveStartedListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f11865a.setOnCameraMoveStartedListener(new com.google.android.gms.maps.internal.zzi.zza(this) {
            final /* synthetic */ GoogleMap f11835b;

            public void onCameraMoveStarted(int i) {
                onCameraMoveStartedListener.onCameraMoveStarted(i);
            }
        });
    }

    public final void setOnCircleClickListener(final OnCircleClickListener onCircleClickListener) {
        if (onCircleClickListener == null) {
            try {
                this.f11865a.setOnCircleClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f11865a.setOnCircleClickListener(new com.google.android.gms.maps.internal.zzj.zza(this) {
            final /* synthetic */ GoogleMap f11825b;

            public void zza(zzb com_google_android_gms_maps_model_internal_zzb) {
                onCircleClickListener.onCircleClick(new Circle(com_google_android_gms_maps_model_internal_zzb));
            }
        });
    }

    public final void setOnGroundOverlayClickListener(final OnGroundOverlayClickListener onGroundOverlayClickListener) {
        if (onGroundOverlayClickListener == null) {
            try {
                this.f11865a.setOnGroundOverlayClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f11865a.setOnGroundOverlayClickListener(new com.google.android.gms.maps.internal.zzk.zza(this) {
            final /* synthetic */ GoogleMap f11819b;

            public void zza(zzc com_google_android_gms_maps_model_internal_zzc) {
                onGroundOverlayClickListener.onGroundOverlayClick(new GroundOverlay(com_google_android_gms_maps_model_internal_zzc));
            }
        });
    }

    public final void setOnIndoorStateChangeListener(final OnIndoorStateChangeListener onIndoorStateChangeListener) {
        if (onIndoorStateChangeListener == null) {
            try {
                this.f11865a.setOnIndoorStateChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f11865a.setOnIndoorStateChangeListener(new com.google.android.gms.maps.internal.zzl.zza(this) {
            final /* synthetic */ GoogleMap f11839b;

            public void onIndoorBuildingFocused() {
                onIndoorStateChangeListener.onIndoorBuildingFocused();
            }

            public void zza(zzd com_google_android_gms_maps_model_internal_zzd) {
                onIndoorStateChangeListener.onIndoorLevelActivated(new IndoorBuilding(com_google_android_gms_maps_model_internal_zzd));
            }
        });
    }

    public final void setOnInfoWindowClickListener(final OnInfoWindowClickListener onInfoWindowClickListener) {
        if (onInfoWindowClickListener == null) {
            try {
                this.f11865a.setOnInfoWindowClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f11865a.setOnInfoWindowClickListener(new com.google.android.gms.maps.internal.zzm.zza(this) {
            final /* synthetic */ GoogleMap f11853b;

            public void zze(zzf com_google_android_gms_maps_model_internal_zzf) {
                onInfoWindowClickListener.onInfoWindowClick(new Marker(com_google_android_gms_maps_model_internal_zzf));
            }
        });
    }

    public final void setOnInfoWindowCloseListener(final OnInfoWindowCloseListener onInfoWindowCloseListener) {
        if (onInfoWindowCloseListener == null) {
            try {
                this.f11865a.setOnInfoWindowCloseListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f11865a.setOnInfoWindowCloseListener(new com.google.android.gms.maps.internal.zzn.zza(this) {
            final /* synthetic */ GoogleMap f11857b;

            public void zzg(zzf com_google_android_gms_maps_model_internal_zzf) {
                onInfoWindowCloseListener.onInfoWindowClose(new Marker(com_google_android_gms_maps_model_internal_zzf));
            }
        });
    }

    public final void setOnInfoWindowLongClickListener(final OnInfoWindowLongClickListener onInfoWindowLongClickListener) {
        if (onInfoWindowLongClickListener == null) {
            try {
                this.f11865a.setOnInfoWindowLongClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f11865a.setOnInfoWindowLongClickListener(new com.google.android.gms.maps.internal.zzo.zza(this) {
            final /* synthetic */ GoogleMap f11855b;

            public void zzf(zzf com_google_android_gms_maps_model_internal_zzf) {
                onInfoWindowLongClickListener.onInfoWindowLongClick(new Marker(com_google_android_gms_maps_model_internal_zzf));
            }
        });
    }

    public final void setOnMapClickListener(final OnMapClickListener onMapClickListener) {
        if (onMapClickListener == null) {
            try {
                this.f11865a.setOnMapClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f11865a.setOnMapClickListener(new com.google.android.gms.maps.internal.zzq.zza(this) {
            final /* synthetic */ GoogleMap f11845b;

            public void onMapClick(LatLng latLng) {
                onMapClickListener.onMapClick(latLng);
            }
        });
    }

    public void setOnMapLoadedCallback(final OnMapLoadedCallback onMapLoadedCallback) {
        if (onMapLoadedCallback == null) {
            try {
                this.f11865a.setOnMapLoadedCallback(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f11865a.setOnMapLoadedCallback(new com.google.android.gms.maps.internal.zzr.zza(this) {
            final /* synthetic */ GoogleMap f11817b;

            public void onMapLoaded() {
                onMapLoadedCallback.onMapLoaded();
            }
        });
    }

    public final void setOnMapLongClickListener(final OnMapLongClickListener onMapLongClickListener) {
        if (onMapLongClickListener == null) {
            try {
                this.f11865a.setOnMapLongClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f11865a.setOnMapLongClickListener(new com.google.android.gms.maps.internal.zzs.zza(this) {
            final /* synthetic */ GoogleMap f11847b;

            public void onMapLongClick(LatLng latLng) {
                onMapLongClickListener.onMapLongClick(latLng);
            }
        });
    }

    public final void setOnMarkerClickListener(final OnMarkerClickListener onMarkerClickListener) {
        if (onMarkerClickListener == null) {
            try {
                this.f11865a.setOnMarkerClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f11865a.setOnMarkerClickListener(new com.google.android.gms.maps.internal.zzu.zza(this) {
            final /* synthetic */ GoogleMap f11849b;

            public boolean zza(zzf com_google_android_gms_maps_model_internal_zzf) {
                return onMarkerClickListener.onMarkerClick(new Marker(com_google_android_gms_maps_model_internal_zzf));
            }
        });
    }

    public final void setOnMarkerDragListener(final OnMarkerDragListener onMarkerDragListener) {
        if (onMarkerDragListener == null) {
            try {
                this.f11865a.setOnMarkerDragListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f11865a.setOnMarkerDragListener(new com.google.android.gms.maps.internal.zzv.zza(this) {
            final /* synthetic */ GoogleMap f11851b;

            public void zzb(zzf com_google_android_gms_maps_model_internal_zzf) {
                onMarkerDragListener.onMarkerDragStart(new Marker(com_google_android_gms_maps_model_internal_zzf));
            }

            public void zzc(zzf com_google_android_gms_maps_model_internal_zzf) {
                onMarkerDragListener.onMarkerDragEnd(new Marker(com_google_android_gms_maps_model_internal_zzf));
            }

            public void zzd(zzf com_google_android_gms_maps_model_internal_zzf) {
                onMarkerDragListener.onMarkerDrag(new Marker(com_google_android_gms_maps_model_internal_zzf));
            }
        });
    }

    public final void setOnMyLocationButtonClickListener(final OnMyLocationButtonClickListener onMyLocationButtonClickListener) {
        if (onMyLocationButtonClickListener == null) {
            try {
                this.f11865a.setOnMyLocationButtonClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f11865a.setOnMyLocationButtonClickListener(new com.google.android.gms.maps.internal.zzw.zza(this) {
            final /* synthetic */ GoogleMap f11863b;

            public boolean onMyLocationButtonClick() {
                return onMyLocationButtonClickListener.onMyLocationButtonClick();
            }
        });
    }

    @Deprecated
    public final void setOnMyLocationChangeListener(final OnMyLocationChangeListener onMyLocationChangeListener) {
        if (onMyLocationChangeListener == null) {
            try {
                this.f11865a.setOnMyLocationChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f11865a.setOnMyLocationChangeListener(new com.google.android.gms.maps.internal.zzx.zza(this) {
            final /* synthetic */ GoogleMap f11861b;

            public void zzae(com.google.android.gms.dynamic.zzd com_google_android_gms_dynamic_zzd) {
                onMyLocationChangeListener.onMyLocationChange((Location) zze.zzad(com_google_android_gms_dynamic_zzd));
            }
        });
    }

    public final void setOnPolygonClickListener(final OnPolygonClickListener onPolygonClickListener) {
        if (onPolygonClickListener == null) {
            try {
                this.f11865a.setOnPolygonClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f11865a.setOnPolygonClickListener(new com.google.android.gms.maps.internal.zzz.zza(this) {
            final /* synthetic */ GoogleMap f11827b;

            public void zza(zzg com_google_android_gms_maps_model_internal_zzg) {
                onPolygonClickListener.onPolygonClick(new Polygon(com_google_android_gms_maps_model_internal_zzg));
            }
        });
    }

    public final void setOnPolylineClickListener(final OnPolylineClickListener onPolylineClickListener) {
        if (onPolylineClickListener == null) {
            try {
                this.f11865a.setOnPolylineClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f11865a.setOnPolylineClickListener(new com.google.android.gms.maps.internal.zzaa.zza(this) {
            final /* synthetic */ GoogleMap f11829b;

            public void zza(IPolylineDelegate iPolylineDelegate) {
                onPolylineClickListener.onPolylineClick(new Polyline(iPolylineDelegate));
            }
        });
    }

    public final void setPadding(int i, int i2, int i3, int i4) {
        try {
            this.f11865a.setPadding(i, i2, i3, i4);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setTrafficEnabled(boolean z) {
        try {
            this.f11865a.setTrafficEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void snapshot(SnapshotReadyCallback snapshotReadyCallback) {
        snapshot(snapshotReadyCallback, null);
    }

    public final void snapshot(final SnapshotReadyCallback snapshotReadyCallback, Bitmap bitmap) {
        try {
            this.f11865a.snapshot(new com.google.android.gms.maps.internal.zzag.zza(this) {
                final /* synthetic */ GoogleMap f11831b;

                public void onSnapshotReady(Bitmap bitmap) {
                    snapshotReadyCallback.onSnapshotReady(bitmap);
                }

                public void zzaf(com.google.android.gms.dynamic.zzd com_google_android_gms_dynamic_zzd) {
                    snapshotReadyCallback.onSnapshotReady((Bitmap) zze.zzad(com_google_android_gms_dynamic_zzd));
                }
            }, (zze) (bitmap != null ? zze.zzac(bitmap) : null));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void stopAnimation() {
        try {
            this.f11865a.stopAnimation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
