package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.internal.IUiSettingsDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class UiSettings {
    private final IUiSettingsDelegate f11965a;

    UiSettings(IUiSettingsDelegate iUiSettingsDelegate) {
        this.f11965a = iUiSettingsDelegate;
    }

    public boolean isCompassEnabled() {
        try {
            return this.f11965a.isCompassEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isIndoorLevelPickerEnabled() {
        try {
            return this.f11965a.isIndoorLevelPickerEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isMapToolbarEnabled() {
        try {
            return this.f11965a.isMapToolbarEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isMyLocationButtonEnabled() {
        try {
            return this.f11965a.isMyLocationButtonEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isRotateGesturesEnabled() {
        try {
            return this.f11965a.isRotateGesturesEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isScrollGesturesEnabled() {
        try {
            return this.f11965a.isScrollGesturesEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isTiltGesturesEnabled() {
        try {
            return this.f11965a.isTiltGesturesEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isZoomControlsEnabled() {
        try {
            return this.f11965a.isZoomControlsEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isZoomGesturesEnabled() {
        try {
            return this.f11965a.isZoomGesturesEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setAllGesturesEnabled(boolean z) {
        try {
            this.f11965a.setAllGesturesEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setCompassEnabled(boolean z) {
        try {
            this.f11965a.setCompassEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setIndoorLevelPickerEnabled(boolean z) {
        try {
            this.f11965a.setIndoorLevelPickerEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setMapToolbarEnabled(boolean z) {
        try {
            this.f11965a.setMapToolbarEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setMyLocationButtonEnabled(boolean z) {
        try {
            this.f11965a.setMyLocationButtonEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setRotateGesturesEnabled(boolean z) {
        try {
            this.f11965a.setRotateGesturesEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setScrollGesturesEnabled(boolean z) {
        try {
            this.f11965a.setScrollGesturesEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setTiltGesturesEnabled(boolean z) {
        try {
            this.f11965a.setTiltGesturesEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setZoomControlsEnabled(boolean z) {
        try {
            this.f11965a.setZoomControlsEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setZoomGesturesEnabled(boolean z) {
        try {
            this.f11965a.setZoomGesturesEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
