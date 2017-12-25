package android.support.constraint.solver;

import android.support.constraint.solver.C0038e.C0034a;
import android.support.constraint.solver.SolverVariable.Type;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.maps.model.GroundOverlayOptions;

public class C0035b implements C0034a {
    SolverVariable f255a = null;
    float f256b = 0.0f;
    boolean f257c = false;
    public final C0033a f258d;
    boolean f259e = false;

    public C0035b(C0036c c0036c) {
        this.f258d = new C0033a(this, c0036c);
    }

    void m156a() {
        this.f258d.m134a(this);
    }

    boolean m165b() {
        return this.f255a != null && (this.f255a.f239f == Type.UNRESTRICTED || this.f256b >= 0.0f);
    }

    public String toString() {
        return m167c();
    }

    String m167c() {
        String str;
        Object obj;
        String str2 = "";
        if (this.f255a == null) {
            str2 = str2 + AppEventsConstants.EVENT_PARAM_VALUE_NO;
        } else {
            str2 = str2 + this.f255a;
        }
        str2 = str2 + " = ";
        if (this.f256b != 0.0f) {
            str = str2 + this.f256b;
            obj = 1;
        } else {
            str = str2;
            obj = null;
        }
        int i = this.f258d.f244a;
        String str3 = str;
        for (int i2 = 0; i2 < i; i2++) {
            SolverVariable a = this.f258d.m128a(i2);
            if (a != null) {
                float f;
                float b = this.f258d.m137b(i2);
                String solverVariable = a.toString();
                if (obj == null) {
                    if (b < 0.0f) {
                        str3 = str3 + "- ";
                        f = b * GroundOverlayOptions.NO_DIMENSION;
                    } else {
                        f = b;
                    }
                } else if (b > 0.0f) {
                    str3 = str3 + " + ";
                    f = b;
                } else {
                    str3 = str3 + " - ";
                    f = b * GroundOverlayOptions.NO_DIMENSION;
                }
                if (f == 1.0f) {
                    str2 = str3 + solverVariable;
                } else {
                    str2 = str3 + f + " " + solverVariable;
                }
                str3 = str2;
                int i3 = 1;
            }
        }
        if (obj == null) {
            return str3 + "0.0";
        }
        return str3;
    }

    public void m169d() {
        this.f255a = null;
        this.f258d.m131a();
        this.f256b = 0.0f;
        this.f259e = false;
    }

    boolean m158a(SolverVariable solverVariable) {
        return this.f258d.m140b(solverVariable);
    }

    C0035b m149a(SolverVariable solverVariable, int i) {
        this.f255a = solverVariable;
        solverVariable.f237d = (float) i;
        this.f256b = (float) i;
        this.f259e = true;
        return this;
    }

    public C0035b m162b(SolverVariable solverVariable, int i) {
        if (i < 0) {
            this.f256b = (float) (i * -1);
            this.f258d.m133a(solverVariable, 1.0f);
        } else {
            this.f256b = (float) i;
            this.f258d.m133a(solverVariable, (float) GroundOverlayOptions.NO_DIMENSION);
        }
        return this;
    }

    public C0035b m150a(SolverVariable solverVariable, SolverVariable solverVariable2, int i) {
        Object obj = null;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                obj = 1;
            }
            this.f256b = (float) i;
        }
        if (obj == null) {
            this.f258d.m133a(solverVariable, (float) GroundOverlayOptions.NO_DIMENSION);
            this.f258d.m133a(solverVariable2, 1.0f);
        } else {
            this.f258d.m133a(solverVariable, 1.0f);
            this.f258d.m133a(solverVariable2, (float) GroundOverlayOptions.NO_DIMENSION);
        }
        return this;
    }

    C0035b m166c(SolverVariable solverVariable, int i) {
        this.f258d.m133a(solverVariable, (float) i);
        return this;
    }

    public C0035b m153a(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i) {
        Object obj = null;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                obj = 1;
            }
            this.f256b = (float) i;
        }
        if (obj == null) {
            this.f258d.m133a(solverVariable, (float) GroundOverlayOptions.NO_DIMENSION);
            this.f258d.m133a(solverVariable2, 1.0f);
            this.f258d.m133a(solverVariable3, 1.0f);
        } else {
            this.f258d.m133a(solverVariable, 1.0f);
            this.f258d.m133a(solverVariable2, (float) GroundOverlayOptions.NO_DIMENSION);
            this.f258d.m133a(solverVariable3, (float) GroundOverlayOptions.NO_DIMENSION);
        }
        return this;
    }

    public C0035b m163b(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i) {
        Object obj = null;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                obj = 1;
            }
            this.f256b = (float) i;
        }
        if (obj == null) {
            this.f258d.m133a(solverVariable, (float) GroundOverlayOptions.NO_DIMENSION);
            this.f258d.m133a(solverVariable2, 1.0f);
            this.f258d.m133a(solverVariable3, (float) GroundOverlayOptions.NO_DIMENSION);
        } else {
            this.f258d.m133a(solverVariable, 1.0f);
            this.f258d.m133a(solverVariable2, (float) GroundOverlayOptions.NO_DIMENSION);
            this.f258d.m133a(solverVariable3, 1.0f);
        }
        return this;
    }

    public C0035b m148a(float f, float f2, float f3, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4) {
        if (f2 == 0.0f || f == f3) {
            this.f256b = 0.0f;
            this.f258d.m133a(solverVariable, 1.0f);
            this.f258d.m133a(solverVariable2, (float) GroundOverlayOptions.NO_DIMENSION);
            this.f258d.m133a(solverVariable4, 1.0f);
            this.f258d.m133a(solverVariable3, (float) GroundOverlayOptions.NO_DIMENSION);
        } else {
            float f4 = (f / f2) / (f3 / f2);
            this.f256b = 0.0f;
            this.f258d.m133a(solverVariable, 1.0f);
            this.f258d.m133a(solverVariable2, (float) GroundOverlayOptions.NO_DIMENSION);
            this.f258d.m133a(solverVariable4, f4);
            this.f258d.m133a(solverVariable3, -f4);
        }
        return this;
    }

    C0035b m151a(SolverVariable solverVariable, SolverVariable solverVariable2, int i, float f, SolverVariable solverVariable3, SolverVariable solverVariable4, int i2) {
        if (solverVariable2 == solverVariable3) {
            this.f258d.m133a(solverVariable, 1.0f);
            this.f258d.m133a(solverVariable4, 1.0f);
            this.f258d.m133a(solverVariable2, -2.0f);
        } else if (f == 0.5f) {
            this.f258d.m133a(solverVariable, 1.0f);
            this.f258d.m133a(solverVariable2, (float) GroundOverlayOptions.NO_DIMENSION);
            this.f258d.m133a(solverVariable3, (float) GroundOverlayOptions.NO_DIMENSION);
            this.f258d.m133a(solverVariable4, 1.0f);
            if (i > 0 || i2 > 0) {
                this.f256b = (float) ((-i) + i2);
            }
        } else if (f <= 0.0f) {
            this.f258d.m133a(solverVariable, (float) GroundOverlayOptions.NO_DIMENSION);
            this.f258d.m133a(solverVariable2, 1.0f);
            this.f256b = (float) i;
        } else if (f >= 1.0f) {
            this.f258d.m133a(solverVariable3, (float) GroundOverlayOptions.NO_DIMENSION);
            this.f258d.m133a(solverVariable4, 1.0f);
            this.f256b = (float) i2;
        } else {
            this.f258d.m133a(solverVariable, (1.0f - f) * 1.0f);
            this.f258d.m133a(solverVariable2, (1.0f - f) * GroundOverlayOptions.NO_DIMENSION);
            this.f258d.m133a(solverVariable3, GroundOverlayOptions.NO_DIMENSION * f);
            this.f258d.m133a(solverVariable4, 1.0f * f);
            if (i > 0 || i2 > 0) {
                this.f256b = (((float) (-i)) * (1.0f - f)) + (((float) i2) * f);
            }
        }
        return this;
    }

    public C0035b m155a(C0038e c0038e, int i) {
        this.f258d.m133a(c0038e.m185a(i, "ep"), 1.0f);
        this.f258d.m133a(c0038e.m185a(i, "em"), (float) GroundOverlayOptions.NO_DIMENSION);
        return this;
    }

    C0035b m152a(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, float f) {
        this.f258d.m133a(solverVariable, (float) GroundOverlayOptions.NO_DIMENSION);
        this.f258d.m133a(solverVariable2, 1.0f - f);
        this.f258d.m133a(solverVariable3, f);
        return this;
    }

    public C0035b m154a(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f) {
        this.f258d.m133a(solverVariable, (float) GroundOverlayOptions.NO_DIMENSION);
        this.f258d.m133a(solverVariable2, 1.0f);
        this.f258d.m133a(solverVariable3, f);
        this.f258d.m133a(solverVariable4, -f);
        return this;
    }

    public C0035b m164b(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f) {
        this.f258d.m133a(solverVariable3, 0.5f);
        this.f258d.m133a(solverVariable4, 0.5f);
        this.f258d.m133a(solverVariable, -0.5f);
        this.f258d.m133a(solverVariable2, -0.5f);
        this.f256b = -f;
        return this;
    }

    boolean m159a(C0035b c0035b) {
        this.f258d.m135a(this, c0035b);
        return true;
    }

    void m171e() {
        if (this.f256b < 0.0f) {
            this.f256b *= GroundOverlayOptions.NO_DIMENSION;
            this.f258d.m138b();
        }
    }

    boolean m160a(C0038e c0038e) {
        boolean z = false;
        SolverVariable a = this.f258d.m129a(c0038e);
        if (a == null) {
            z = true;
        } else {
            m168c(a);
        }
        if (this.f258d.f244a == 0) {
            this.f259e = true;
        }
        return z;
    }

    SolverVariable m161b(SolverVariable solverVariable) {
        return this.f258d.m130a(null, solverVariable);
    }

    void m168c(SolverVariable solverVariable) {
        if (this.f255a != null) {
            this.f258d.m133a(this.f255a, (float) GroundOverlayOptions.NO_DIMENSION);
            this.f255a = null;
        }
        float a = this.f258d.m127a(solverVariable) * GroundOverlayOptions.NO_DIMENSION;
        this.f255a = solverVariable;
        if (a != 1.0f) {
            this.f256b /= a;
            this.f258d.m132a(a);
        }
    }

    public boolean m172f() {
        return this.f255a == null && this.f256b == 0.0f && this.f258d.f244a == 0;
    }

    public SolverVariable mo29a(C0038e c0038e, boolean[] zArr) {
        return this.f258d.m130a(zArr, null);
    }

    public void mo32g() {
        this.f258d.m131a();
        this.f255a = null;
        this.f256b = 0.0f;
    }

    public void mo30a(C0034a c0034a) {
        if (c0034a instanceof C0035b) {
            C0035b c0035b = (C0035b) c0034a;
            this.f255a = null;
            this.f258d.m131a();
            for (int i = 0; i < c0035b.f258d.f244a; i++) {
                this.f258d.m139b(c0035b.f258d.m128a(i), c0035b.f258d.m137b(i));
            }
        }
    }

    public void mo31d(SolverVariable solverVariable) {
        float f = 1.0f;
        if (solverVariable.f236c != 1) {
            if (solverVariable.f236c == 2) {
                f = 1000.0f;
            } else if (solverVariable.f236c == 3) {
                f = 1000000.0f;
            } else if (solverVariable.f236c == 4) {
                f = 1.0E9f;
            } else if (solverVariable.f236c == 5) {
                f = 1.0E12f;
            }
        }
        this.f258d.m133a(solverVariable, f);
    }

    public SolverVariable mo33h() {
        return this.f255a;
    }
}
