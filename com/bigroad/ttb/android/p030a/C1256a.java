package com.bigroad.ttb.android.p030a;

import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;

public final class C1256a {
    public final Camera f4287a;
    public final int f4288b;

    public C1256a(Camera camera, int i) {
        this.f4287a = camera;
        this.f4288b = i;
    }

    private static int m6604c() {
        int numberOfCameras = Camera.getNumberOfCameras();
        CameraInfo cameraInfo = new CameraInfo();
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == 0) {
                return i;
            }
        }
        return numberOfCameras - 1;
    }

    public static C1256a m6603a() {
        int c = C1256a.m6604c();
        Camera open = Camera.open(c);
        return open == null ? null : new C1256a(open, c);
    }

    public CameraInfo m6605b() {
        CameraInfo cameraInfo = new CameraInfo();
        Camera.getCameraInfo(this.f4288b, cameraInfo);
        return cameraInfo;
    }
}
