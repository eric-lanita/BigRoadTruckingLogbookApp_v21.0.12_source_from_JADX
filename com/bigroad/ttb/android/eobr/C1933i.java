package com.bigroad.ttb.android.eobr;

public class C1933i {
    private C1890b f6662a = null;
    private EcmDiagnosticData f6663b = null;
    private EcmDiagnosticData f6664c = null;
    private float f6665d = 0.0f;
    private int f6666e = 0;

    public void m9506a() {
        m9505c();
        this.f6662a = null;
    }

    public void m9507a(float f, EcmDiagnosticData ecmDiagnosticData) {
        if (this.f6663b == null || this.f6664c == null) {
            this.f6663b = ecmDiagnosticData;
            this.f6664c = ecmDiagnosticData;
        } else if (ecmDiagnosticData != null) {
            if (ecmDiagnosticData.m8954a(this.f6663b) < 0) {
                this.f6663b = ecmDiagnosticData;
            }
            if (ecmDiagnosticData.m8954a(this.f6664c) > 0) {
                this.f6664c = ecmDiagnosticData;
            }
        }
        this.f6665d += f;
        this.f6666e++;
    }

    private void m9505c() {
        this.f6665d = 0.0f;
        this.f6666e = 0;
        this.f6663b = null;
        this.f6664c = null;
    }

    public C1890b m9508b() {
        if (this.f6666e > 0) {
            this.f6662a = new C1890b(this.f6665d / ((float) this.f6666e), this.f6663b, this.f6664c);
        }
        m9505c();
        return this.f6662a;
    }
}
