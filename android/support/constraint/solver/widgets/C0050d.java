package android.support.constraint.solver.widgets;

import android.support.constraint.solver.C0038e;
import android.support.constraint.solver.SolverVariable;
import android.support.constraint.solver.widgets.ConstraintAnchor.Type;
import android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import java.util.ArrayList;

public class C0050d extends ConstraintWidget {
    protected float f372Z = GroundOverlayOptions.NO_DIMENSION;
    protected int aa = -1;
    protected int ab = -1;
    private ConstraintAnchor ac = this.p;
    private int ad = 0;
    private boolean ae = false;
    private int af = 0;
    private C0052g ag = new C0052g();
    private int ah = 8;

    public C0050d() {
        int i = 0;
        this.x.clear();
        this.x.add(this.ac);
        int length = this.w.length;
        while (i < length) {
            this.w[i] = this.ac;
            i++;
        }
    }

    public void m323a(int i) {
        if (this.ad != i) {
            this.ad = i;
            this.x.clear();
            if (this.ad == 1) {
                this.ac = this.o;
            } else {
                this.ac = this.p;
            }
            this.x.add(this.ac);
            int length = this.w.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.w[i2] = this.ac;
            }
        }
    }

    public ConstraintAnchor mo44a(Type type) {
        switch (type) {
            case LEFT:
            case RIGHT:
                if (this.ad == 1) {
                    return this.ac;
                }
                break;
            case TOP:
            case BOTTOM:
                if (this.ad == 0) {
                    return this.ac;
                }
                break;
            case BASELINE:
            case CENTER:
            case CENTER_X:
            case CENTER_Y:
            case NONE:
                return null;
        }
        throw new AssertionError(type.name());
    }

    public ArrayList<ConstraintAnchor> mo46t() {
        return this.x;
    }

    public void m326e(float f) {
        if (f > GroundOverlayOptions.NO_DIMENSION) {
            this.f372Z = f;
            this.aa = -1;
            this.ab = -1;
        }
    }

    public void m327p(int i) {
        if (i > -1) {
            this.f372Z = GroundOverlayOptions.NO_DIMENSION;
            this.aa = i;
            this.ab = -1;
        }
    }

    public void m328q(int i) {
        if (i > -1) {
            this.f372Z = GroundOverlayOptions.NO_DIMENSION;
            this.aa = -1;
            this.ab = i;
        }
    }

    public void mo38a(C0038e c0038e) {
        int i = 1;
        C0048c c0048c = (C0048c) m247b();
        if (c0048c != null) {
            Object a;
            Object obj;
            ConstraintAnchor a2 = c0048c.mo44a(Type.LEFT);
            ConstraintAnchor a3 = c0048c.mo44a(Type.RIGHT);
            int i2 = this.z != null ? this.z.f367y[0] == DimensionBehaviour.WRAP_CONTENT ? 1 : 0 : 0;
            if (this.ad == 0) {
                ConstraintAnchor a4 = c0048c.mo44a(Type.TOP);
                a = c0048c.mo44a(Type.BOTTOM);
                if (this.z == null) {
                    i = 0;
                } else if (this.z.f367y[1] != DimensionBehaviour.WRAP_CONTENT) {
                    i = 0;
                }
                obj = a4;
            } else {
                i = i2;
                ConstraintAnchor constraintAnchor = a3;
                a3 = a2;
            }
            SolverVariable a5;
            if (this.aa != -1) {
                a5 = c0038e.m186a(this.ac);
                c0038e.m203c(a5, c0038e.m186a(obj), this.aa, 6);
                if (i != 0) {
                    c0038e.m191a(c0038e.m186a(a), a5, 0, 5);
                }
            } else if (this.ab != -1) {
                a5 = c0038e.m186a(this.ac);
                SolverVariable a6 = c0038e.m186a(a);
                c0038e.m203c(a5, a6, -this.ab, 6);
                if (i != 0) {
                    c0038e.m191a(a5, c0038e.m186a(obj), 0, 5);
                    c0038e.m191a(a6, a5, 0, 5);
                }
            } else if (this.f372Z != GroundOverlayOptions.NO_DIMENSION) {
                c0038e.m201b(C0038e.m178a(c0038e, c0038e.m186a(this.ac), c0038e.m186a(obj), c0038e.m186a(a), this.f372Z, this.ae));
            }
        }
    }

    public void mo45b(C0038e c0038e) {
        if (m247b() != null) {
            int b = c0038e.m197b(this.ac);
            if (this.ad == 1) {
                m265e(b);
                m267f(0);
                m271h(m247b().m272i());
                m269g(0);
                return;
            }
            m265e(0);
            m267f(b);
            m269g(m247b().m268g());
            m271h(0);
        }
    }
}
