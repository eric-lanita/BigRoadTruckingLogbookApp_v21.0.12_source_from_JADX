package com.bigroad.ttb.android.eobr;

import com.google.android.gms.maps.model.GroundOverlayOptions;

public class C1890b {
    public static final C1890b f6521a = new C1890b(0.0f, true);
    public static final C1890b f6522b = new C1890b(GroundOverlayOptions.NO_DIMENSION, false);
    public static final C1890b f6523c = new C1890b(0.0f, false);
    private final boolean f6524d;
    private final float f6525e;
    private final EcmDiagnosticData f6526f;
    private final EcmDiagnosticData f6527g;

    private C1890b(float f, boolean z) {
        this.f6524d = z;
        this.f6525e = f;
        this.f6526f = null;
        this.f6527g = null;
    }

    public C1890b(float f, EcmDiagnosticData ecmDiagnosticData, EcmDiagnosticData ecmDiagnosticData2) {
        this.f6524d = true;
        this.f6525e = f;
        this.f6526f = ecmDiagnosticData;
        this.f6527g = ecmDiagnosticData2;
    }

    public float m9226a() {
        return this.f6525e;
    }

    public EcmDiagnosticData m9228b() {
        return this.f6526f;
    }

    public EcmDiagnosticData m9229c() {
        return this.f6527g;
    }

    public C1890b m9227a(float f) {
        return new C1890b(f, this.f6526f, this.f6527g);
    }
}
