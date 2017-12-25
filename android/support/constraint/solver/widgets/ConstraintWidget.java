package android.support.constraint.solver.widgets;

import android.support.constraint.solver.C0036c;
import android.support.constraint.solver.C0038e;
import android.support.constraint.solver.SolverVariable;
import android.support.constraint.solver.widgets.ConstraintAnchor.Strength;
import android.support.constraint.solver.widgets.ConstraintAnchor.Type;
import java.util.ArrayList;

public class ConstraintWidget {
    public static float f317L = 0.5f;
    int f318A = 0;
    int f319B = 0;
    protected float f320C = 0.0f;
    protected int f321D = -1;
    protected int f322E = 0;
    protected int f323F = 0;
    protected int f324G = 0;
    protected int f325H = 0;
    int f326I = 0;
    protected int f327J;
    protected int f328K;
    float f329M = f317L;
    float f330N = f317L;
    boolean f331O;
    boolean f332P;
    int f333Q = 0;
    int f334R = 0;
    boolean f335S;
    boolean f336T;
    float[] f337U = new float[]{0.0f, 0.0f};
    protected ConstraintWidget[] f338V = new ConstraintWidget[]{null, null};
    protected ConstraintWidget[] f339W = new ConstraintWidget[]{null, null};
    ConstraintWidget f340X = null;
    ConstraintWidget f341Y = null;
    private int[] f342Z = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
    public int f343a = -1;
    private float aa = 0.0f;
    private int ab = 0;
    private int ac = 0;
    private int ad = 0;
    private int ae = 0;
    private int af;
    private int ag;
    private Object ah;
    private int ai = 0;
    private int aj = 0;
    private String ak = null;
    private String al = null;
    public int f344b = -1;
    int f345c = 0;
    int f346d = 0;
    int f347e = 0;
    int f348f = 0;
    float f349g = 1.0f;
    int f350h = 0;
    int f351i = 0;
    float f352j = 1.0f;
    boolean f353k;
    boolean f354l;
    int f355m = -1;
    float f356n = 1.0f;
    ConstraintAnchor f357o = new ConstraintAnchor(this, Type.LEFT);
    ConstraintAnchor f358p = new ConstraintAnchor(this, Type.TOP);
    ConstraintAnchor f359q = new ConstraintAnchor(this, Type.RIGHT);
    ConstraintAnchor f360r = new ConstraintAnchor(this, Type.BOTTOM);
    ConstraintAnchor f361s = new ConstraintAnchor(this, Type.BASELINE);
    ConstraintAnchor f362t = new ConstraintAnchor(this, Type.CENTER_X);
    ConstraintAnchor f363u = new ConstraintAnchor(this, Type.CENTER_Y);
    ConstraintAnchor f364v = new ConstraintAnchor(this, Type.CENTER);
    protected ConstraintAnchor[] f365w = new ConstraintAnchor[]{this.f357o, this.f359q, this.f358p, this.f360r, this.f361s, this.f364v};
    protected ArrayList<ConstraintAnchor> f366x = new ArrayList();
    protected DimensionBehaviour[] f367y = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
    ConstraintWidget f368z = null;

    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public void m249b(int i) {
        this.f342Z[0] = i;
    }

    public void m258c(int i) {
        this.f342Z[1] = i;
    }

    public void mo39a() {
        this.f357o.m227h();
        this.f358p.m227h();
        this.f359q.m227h();
        this.f360r.m227h();
        this.f361s.m227h();
        this.f362t.m227h();
        this.f363u.m227h();
        this.f364v.m227h();
        this.f368z = null;
        this.aa = 0.0f;
        this.f318A = 0;
        this.f319B = 0;
        this.f320C = 0.0f;
        this.f321D = -1;
        this.f322E = 0;
        this.f323F = 0;
        this.ab = 0;
        this.ac = 0;
        this.ad = 0;
        this.ae = 0;
        this.f324G = 0;
        this.f325H = 0;
        this.f326I = 0;
        this.f327J = 0;
        this.f328K = 0;
        this.af = 0;
        this.ag = 0;
        this.f329M = f317L;
        this.f330N = f317L;
        this.f367y[0] = DimensionBehaviour.FIXED;
        this.f367y[1] = DimensionBehaviour.FIXED;
        this.ah = null;
        this.ai = 0;
        this.aj = 0;
        this.ak = null;
        this.al = null;
        this.f331O = false;
        this.f332P = false;
        this.f333Q = 0;
        this.f334R = 0;
        this.f335S = false;
        this.f336T = false;
        this.f337U[0] = 0.0f;
        this.f337U[1] = 0.0f;
        this.f343a = -1;
        this.f344b = -1;
        this.f342Z[0] = Integer.MAX_VALUE;
        this.f342Z[1] = Integer.MAX_VALUE;
        this.f345c = 0;
        this.f346d = 0;
        this.f349g = 1.0f;
        this.f352j = 1.0f;
        this.f348f = Integer.MAX_VALUE;
        this.f351i = Integer.MAX_VALUE;
        this.f347e = 0;
        this.f350h = 0;
        this.f355m = -1;
        this.f356n = 1.0f;
    }

    public ConstraintWidget() {
        mo37y();
    }

    public void mo40a(C0036c c0036c) {
        this.f357o.m215a(c0036c);
        this.f358p.m215a(c0036c);
        this.f359q.m215a(c0036c);
        this.f360r.m215a(c0036c);
        this.f361s.m215a(c0036c);
        this.f364v.m215a(c0036c);
        this.f362t.m215a(c0036c);
        this.f363u.m215a(c0036c);
    }

    private void mo37y() {
        this.f366x.add(this.f357o);
        this.f366x.add(this.f358p);
        this.f366x.add(this.f359q);
        this.f366x.add(this.f360r);
        this.f366x.add(this.f362t);
        this.f366x.add(this.f363u);
        this.f366x.add(this.f364v);
        this.f366x.add(this.f361s);
    }

    public ConstraintWidget m247b() {
        return this.f368z;
    }

    public void m241a(ConstraintWidget constraintWidget) {
        this.f368z = constraintWidget;
    }

    public void m245a(boolean z) {
        this.f353k = z;
    }

    public void m255b(boolean z) {
        this.f354l = z;
    }

    public void m242a(ConstraintWidget constraintWidget, float f, int i) {
        m239a(Type.CENTER, constraintWidget, Type.CENTER, i, 0);
        this.aa = f;
    }

    public void m262d(int i) {
        this.aj = i;
    }

    public int m256c() {
        return this.aj;
    }

    public String m260d() {
        return this.ak;
    }

    public void m244a(String str) {
        this.ak = str;
    }

    public String toString() {
        return (this.al != null ? "type: " + this.al + " " : "") + (this.ak != null ? "id: " + this.ak + " " : "") + "(" + this.f322E + ", " + this.f323F + ") - (" + this.f318A + " x " + this.f319B + ") wrap: (" + this.af + " x " + this.ag + ")";
    }

    public int m264e() {
        return this.f322E;
    }

    public int m266f() {
        return this.f323F;
    }

    public int m268g() {
        if (this.aj == 8) {
            return 0;
        }
        return this.f318A;
    }

    public int m270h() {
        return this.af;
    }

    public int m272i() {
        if (this.aj == 8) {
            return 0;
        }
        return this.f319B;
    }

    public int m274j() {
        return this.ag;
    }

    public int m276k() {
        return this.ab + this.f324G;
    }

    public int m278l() {
        return this.ac + this.f325H;
    }

    protected int m280m() {
        return this.f322E + this.f324G;
    }

    protected int m282n() {
        return this.f323F + this.f325H;
    }

    public int m284o() {
        return m264e() + this.f318A;
    }

    public int m286p() {
        return m266f() + this.f319B;
    }

    public boolean m287q() {
        return this.f326I > 0;
    }

    public int m288r() {
        return this.f326I;
    }

    public Object m289s() {
        return this.ah;
    }

    public ArrayList<ConstraintAnchor> mo46t() {
        return this.f366x;
    }

    public void m265e(int i) {
        this.f322E = i;
    }

    public void m267f(int i) {
        this.f323F = i;
    }

    public void m234a(int i, int i2) {
        this.f322E = i;
        this.f323F = i2;
    }

    public void mo41b(int i, int i2) {
        this.f324G = i;
        this.f325H = i2;
    }

    public void mo42u() {
        int i = this.f322E;
        int i2 = this.f323F;
        int i3 = this.f322E + this.f318A;
        int i4 = this.f323F + this.f319B;
        this.ab = i;
        this.ac = i2;
        this.ad = i3 - i;
        this.ae = i4 - i2;
    }

    public void m269g(int i) {
        this.f318A = i;
        if (this.f318A < this.f327J) {
            this.f318A = this.f327J;
        }
    }

    public void m271h(int i) {
        this.f319B = i;
        if (this.f319B < this.f328K) {
            this.f319B = this.f328K;
        }
    }

    public void m235a(int i, int i2, int i3, float f) {
        this.f345c = i;
        this.f347e = i2;
        this.f348f = i3;
        this.f349g = f;
        if (f < 1.0f && this.f345c == 0) {
            this.f345c = 2;
        }
    }

    public void m251b(int i, int i2, int i3, float f) {
        this.f346d = i;
        this.f350h = i2;
        this.f351i = i3;
        this.f352j = f;
        if (f < 1.0f && this.f346d == 0) {
            this.f346d = 2;
        }
    }

    public void m254b(String str) {
        int i = 0;
        if (str == null || str.length() == 0) {
            this.f320C = 0.0f;
            return;
        }
        float parseFloat;
        int i2 = -1;
        int length = str.length();
        int indexOf = str.indexOf(44);
        if (indexOf > 0 && indexOf < length - 1) {
            String substring = str.substring(0, indexOf);
            if (!substring.equalsIgnoreCase("W")) {
                if (substring.equalsIgnoreCase("H")) {
                    i = 1;
                } else {
                    i = -1;
                }
            }
            i2 = i;
            i = indexOf + 1;
        }
        indexOf = str.indexOf(58);
        String substring2;
        if (indexOf < 0 || indexOf >= length - 1) {
            substring2 = str.substring(i);
            if (substring2.length() > 0) {
                try {
                    parseFloat = Float.parseFloat(substring2);
                } catch (NumberFormatException e) {
                    parseFloat = 0.0f;
                }
            }
            parseFloat = 0.0f;
        } else {
            substring2 = str.substring(i, indexOf);
            String substring3 = str.substring(indexOf + 1);
            if (substring2.length() > 0 && substring3.length() > 0) {
                try {
                    parseFloat = Float.parseFloat(substring2);
                    float parseFloat2 = Float.parseFloat(substring3);
                    if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                        parseFloat = i2 == 1 ? Math.abs(parseFloat2 / parseFloat) : Math.abs(parseFloat / parseFloat2);
                    }
                } catch (NumberFormatException e2) {
                    parseFloat = 0.0f;
                }
            }
            parseFloat = 0.0f;
        }
        if (parseFloat > 0.0f) {
            this.f320C = parseFloat;
            this.f321D = i2;
        }
    }

    public void m233a(float f) {
        this.f329M = f;
    }

    public void m248b(float f) {
        this.f330N = f;
    }

    public void m273i(int i) {
        if (i < 0) {
            this.f327J = 0;
        } else {
            this.f327J = i;
        }
    }

    public void m275j(int i) {
        if (i < 0) {
            this.f328K = 0;
        } else {
            this.f328K = i;
        }
    }

    public void m277k(int i) {
        this.af = i;
    }

    public void m279l(int i) {
        this.ag = i;
    }

    public void m236a(int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        this.f322E = i;
        this.f323F = i2;
        if (this.aj == 8) {
            this.f318A = 0;
            this.f319B = 0;
            return;
        }
        if (this.f367y[0] == DimensionBehaviour.FIXED && i5 < this.f318A) {
            i5 = this.f318A;
        }
        if (this.f367y[1] == DimensionBehaviour.FIXED && i6 < this.f319B) {
            i6 = this.f319B;
        }
        this.f318A = i5;
        this.f319B = i6;
        if (this.f319B < this.f328K) {
            this.f319B = this.f328K;
        }
        if (this.f318A < this.f327J) {
            this.f318A = this.f327J;
        }
    }

    public void m259c(int i, int i2) {
        this.f322E = i;
        this.f318A = i2 - i;
        if (this.f318A < this.f327J) {
            this.f318A = this.f327J;
        }
    }

    public void m263d(int i, int i2) {
        this.f323F = i;
        this.f319B = i2 - i;
        if (this.f319B < this.f328K) {
            this.f319B = this.f328K;
        }
    }

    public void m281m(int i) {
        this.f326I = i;
    }

    public void m243a(Object obj) {
        this.ah = obj;
    }

    public void m257c(float f) {
        this.f337U[0] = f;
    }

    public void m261d(float f) {
        this.f337U[1] = f;
    }

    public void m283n(int i) {
        this.f333Q = i;
    }

    public void m285o(int i) {
        this.f334R = i;
    }

    public void m239a(Type type, ConstraintWidget constraintWidget, Type type2, int i, int i2) {
        mo44a(type).m219a(constraintWidget.mo44a(type2), i, i2, Strength.STRONG, 0, true);
    }

    public void m292v() {
        ConstraintWidget b = m247b();
        if (b == null || !(b instanceof C0048c) || !((C0048c) m247b()).m314B()) {
            int size = this.f366x.size();
            for (int i = 0; i < size; i++) {
                ((ConstraintAnchor) this.f366x.get(i)).m227h();
            }
        }
    }

    public ConstraintAnchor mo44a(Type type) {
        switch (type) {
            case LEFT:
                return this.f357o;
            case TOP:
                return this.f358p;
            case RIGHT:
                return this.f359q;
            case BOTTOM:
                return this.f360r;
            case BASELINE:
                return this.f361s;
            case CENTER:
                return this.f364v;
            case CENTER_X:
                return this.f362t;
            case CENTER_Y:
                return this.f363u;
            case NONE:
                return null;
            default:
                throw new AssertionError(type.name());
        }
    }

    public DimensionBehaviour m293w() {
        return this.f367y[0];
    }

    public DimensionBehaviour m294x() {
        return this.f367y[1];
    }

    public void m240a(DimensionBehaviour dimensionBehaviour) {
        this.f367y[0] = dimensionBehaviour;
        if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
            m269g(this.af);
        }
    }

    public void m253b(DimensionBehaviour dimensionBehaviour) {
        this.f367y[1] = dimensionBehaviour;
        if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
            m271h(this.ag);
        }
    }

    public void mo38a(C0038e c0038e) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Object obj;
        int i;
        int i2;
        boolean z5;
        boolean z6;
        boolean z7;
        SolverVariable a = c0038e.m186a(this.f357o);
        SolverVariable a2 = c0038e.m186a(this.f359q);
        SolverVariable a3 = c0038e.m186a(this.f358p);
        SolverVariable a4 = c0038e.m186a(this.f360r);
        SolverVariable a5 = c0038e.m186a(this.f361s);
        boolean z8 = false;
        if (this.f368z != null) {
            boolean z9;
            boolean z10 = this.f368z != null ? this.f368z.f367y[0] == DimensionBehaviour.WRAP_CONTENT : false;
            z = this.f368z != null ? this.f368z.f367y[1] == DimensionBehaviour.WRAP_CONTENT : false;
            if ((this.f357o.f300c != null && this.f357o.f300c.f300c == this.f357o) || (this.f359q.f300c != null && this.f359q.f300c.f300c == this.f359q)) {
                ((C0048c) this.f368z).m318a(this, 0);
                z8 = true;
            }
            if ((this.f358p.f300c == null || this.f358p.f300c.f300c != this.f358p) && (this.f360r.f300c == null || this.f360r.f300c.f300c != this.f360r)) {
                z9 = false;
            } else {
                ((C0048c) this.f368z).m318a(this, 1);
                z9 = true;
            }
            if (z10 && this.aj != 8 && this.f357o.f300c == null && this.f359q.f300c == null) {
                c0038e.m191a(c0038e.m186a(this.f368z.f359q), a2, 0, 1);
            }
            if (z && this.aj != 8 && this.f358p.f300c == null && this.f360r.f300c == null && this.f361s == null) {
                c0038e.m191a(c0038e.m186a(this.f368z.f360r), a4, 0, 1);
            }
            z2 = z;
            z3 = z9;
            z4 = z8;
            z = z10;
        } else {
            z2 = false;
            z3 = false;
            z4 = false;
            z = false;
        }
        int i3 = this.f318A;
        if (i3 < this.f327J) {
            i3 = this.f327J;
        }
        int i4 = this.f319B;
        if (i4 < this.f328K) {
            i4 = this.f328K;
        }
        z8 = this.f367y[0] != DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z11 = this.f367y[1] != DimensionBehaviour.MATCH_CONSTRAINT;
        Object obj2 = null;
        this.f355m = this.f321D;
        this.f356n = this.f320C;
        if (this.f320C > 0.0f && this.aj != 8) {
            obj2 = 1;
            if (this.f367y[0] == DimensionBehaviour.MATCH_CONSTRAINT && this.f367y[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
                m246a(z, z2, z8, z11);
                obj = 1;
                i = i4;
                i2 = i3;
                if (obj == null) {
                }
                if (this.f367y[0] != DimensionBehaviour.WRAP_CONTENT) {
                }
                if (this.f343a != 2) {
                    if (this.f368z != null) {
                    }
                    if (this.f368z != null) {
                    }
                    m229a(c0038e, z, this.f368z != null ? c0038e.m186a(this.f368z.f357o) : null, this.f368z != null ? c0038e.m186a(this.f368z.f359q) : null, this.f367y[0], z6, this.f357o, this.f359q, this.f322E, i2, this.f327J, this.f342Z[0], this.f329M, z5, z4, this.f345c, this.f347e, this.f348f, this.f349g, true);
                }
                if (this.f344b == 2) {
                    if (this.f367y[1] != DimensionBehaviour.WRAP_CONTENT) {
                    }
                    if (obj == null) {
                    }
                    z7 = true;
                    if (this.f326I > 0) {
                        c0038e.m203c(a5, a3, m288r(), 6);
                        if (this.f361s.f300c != null) {
                            c0038e.m203c(a5, c0038e.m186a(this.f361s.f300c), 0, 6);
                            z7 = false;
                        }
                    }
                    if (this.f368z != null) {
                    }
                    if (this.f368z != null) {
                    }
                    m229a(c0038e, z2, this.f368z != null ? c0038e.m186a(this.f368z.f358p) : null, this.f368z != null ? c0038e.m186a(this.f368z.f360r) : null, this.f367y[1], z6, this.f358p, this.f360r, this.f323F, i, this.f328K, this.f342Z[1], this.f330N, z5, z3, this.f346d, this.f350h, this.f351i, this.f352j, z7);
                    if (obj != null) {
                        if (this.f355m == 1) {
                            c0038e.m192a(a2, a, a4, a3, this.f356n, 6);
                        } else {
                            c0038e.m192a(a4, a3, a2, a, this.f356n, 6);
                        }
                    }
                    if (!this.f364v.m228i()) {
                        c0038e.m196a(this, this.f364v.m225f().m221b(), (float) Math.toRadians((double) (this.aa + 90.0f)), this.f364v.m223d());
                    }
                }
            }
            int i5;
            if (this.f367y[0] == DimensionBehaviour.MATCH_CONSTRAINT) {
                this.f355m = 0;
                i5 = 1;
                i = i4;
                i2 = (int) (this.f356n * ((float) this.f319B));
            } else if (this.f367y[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
                this.f355m = 1;
                if (this.f321D == -1) {
                    this.f356n = 1.0f / this.f356n;
                }
                i5 = 1;
                i = (int) (this.f356n * ((float) this.f318A));
                i2 = i3;
            }
            z5 = obj == null && (this.f355m == 0 || this.f355m == -1);
            z6 = this.f367y[0] != DimensionBehaviour.WRAP_CONTENT && (this instanceof C0048c);
            if (this.f343a != 2) {
                m229a(c0038e, z, this.f368z != null ? c0038e.m186a(this.f368z.f357o) : null, this.f368z != null ? c0038e.m186a(this.f368z.f359q) : null, this.f367y[0], z6, this.f357o, this.f359q, this.f322E, i2, this.f327J, this.f342Z[0], this.f329M, z5, z4, this.f345c, this.f347e, this.f348f, this.f349g, true);
            }
            if (this.f344b == 2) {
                z6 = this.f367y[1] != DimensionBehaviour.WRAP_CONTENT && (this instanceof C0048c);
                z5 = obj == null && (this.f355m == 1 || this.f355m == -1);
                z7 = true;
                if (this.f326I > 0) {
                    c0038e.m203c(a5, a3, m288r(), 6);
                    if (this.f361s.f300c != null) {
                        c0038e.m203c(a5, c0038e.m186a(this.f361s.f300c), 0, 6);
                        z7 = false;
                    }
                }
                m229a(c0038e, z2, this.f368z != null ? c0038e.m186a(this.f368z.f358p) : null, this.f368z != null ? c0038e.m186a(this.f368z.f360r) : null, this.f367y[1], z6, this.f358p, this.f360r, this.f323F, i, this.f328K, this.f342Z[1], this.f330N, z5, z3, this.f346d, this.f350h, this.f351i, this.f352j, z7);
                if (obj != null) {
                    if (this.f355m == 1) {
                        c0038e.m192a(a4, a3, a2, a, this.f356n, 6);
                    } else {
                        c0038e.m192a(a2, a, a4, a3, this.f356n, 6);
                    }
                }
                if (!this.f364v.m228i()) {
                    c0038e.m196a(this, this.f364v.m225f().m221b(), (float) Math.toRadians((double) (this.aa + 90.0f)), this.f364v.m223d());
                }
            }
        }
        obj = obj2;
        i = i4;
        i2 = i3;
        if (obj == null) {
        }
        if (this.f367y[0] != DimensionBehaviour.WRAP_CONTENT) {
        }
        if (this.f343a != 2) {
            if (this.f368z != null) {
            }
            if (this.f368z != null) {
            }
            m229a(c0038e, z, this.f368z != null ? c0038e.m186a(this.f368z.f357o) : null, this.f368z != null ? c0038e.m186a(this.f368z.f359q) : null, this.f367y[0], z6, this.f357o, this.f359q, this.f322E, i2, this.f327J, this.f342Z[0], this.f329M, z5, z4, this.f345c, this.f347e, this.f348f, this.f349g, true);
        }
        if (this.f344b == 2) {
            if (this.f367y[1] != DimensionBehaviour.WRAP_CONTENT) {
            }
            if (obj == null) {
            }
            z7 = true;
            if (this.f326I > 0) {
                c0038e.m203c(a5, a3, m288r(), 6);
                if (this.f361s.f300c != null) {
                    c0038e.m203c(a5, c0038e.m186a(this.f361s.f300c), 0, 6);
                    z7 = false;
                }
            }
            if (this.f368z != null) {
            }
            if (this.f368z != null) {
            }
            m229a(c0038e, z2, this.f368z != null ? c0038e.m186a(this.f368z.f358p) : null, this.f368z != null ? c0038e.m186a(this.f368z.f360r) : null, this.f367y[1], z6, this.f358p, this.f360r, this.f323F, i, this.f328K, this.f342Z[1], this.f330N, z5, z3, this.f346d, this.f350h, this.f351i, this.f352j, z7);
            if (obj != null) {
                if (this.f355m == 1) {
                    c0038e.m192a(a4, a3, a2, a, this.f356n, 6);
                } else {
                    c0038e.m192a(a2, a, a4, a3, this.f356n, 6);
                }
            }
            if (!this.f364v.m228i()) {
                c0038e.m196a(this, this.f364v.m225f().m221b(), (float) Math.toRadians((double) (this.aa + 90.0f)), this.f364v.m223d());
            }
        }
    }

    public void m246a(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.f345c == 0) {
            this.f345c = 3;
        }
        if (this.f346d == 0) {
            this.f346d = 3;
        }
        if (this.f355m == -1) {
            if (z3 && !z4) {
                this.f355m = 0;
            } else if (!z3 && z4) {
                this.f355m = 1;
                if (this.f321D == -1) {
                    this.f356n = 1.0f / this.f356n;
                }
            }
        }
        if (this.f355m == 0 && (!this.f358p.m228i() || !this.f360r.m228i())) {
            this.f355m = 1;
        } else if (this.f355m == 1 && !(this.f357o.m228i() && this.f359q.m228i())) {
            this.f355m = 0;
        }
        if (this.f355m == -1 && !(this.f358p.m228i() && this.f360r.m228i() && this.f357o.m228i() && this.f359q.m228i())) {
            if (this.f358p.m228i() && this.f360r.m228i()) {
                this.f355m = 0;
            } else if (this.f357o.m228i() && this.f359q.m228i()) {
                this.f356n = 1.0f / this.f356n;
                this.f355m = 1;
            }
        }
        if (this.f355m == -1) {
            if (z && !z2) {
                this.f355m = 0;
            } else if (!z && z2) {
                this.f356n = 1.0f / this.f356n;
                this.f355m = 1;
            }
        }
        if (this.f355m != -1) {
            return;
        }
        if (this.f347e > 0 && this.f350h == 0) {
            this.f355m = 0;
        } else if (this.f347e != 0 || this.f350h <= 0) {
            this.f356n = 1.0f / this.f356n;
            this.f355m = 1;
        } else {
            this.f356n = 1.0f / this.f356n;
            this.f355m = 1;
        }
    }

    private void m229a(C0038e c0038e, boolean z, SolverVariable solverVariable, SolverVariable solverVariable2, DimensionBehaviour dimensionBehaviour, boolean z2, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i, int i2, int i3, int i4, float f, boolean z3, boolean z4, int i5, int i6, int i7, float f2, boolean z5) {
        if (constraintAnchor.f304g == 1 && constraintAnchor2.f304g == 1) {
            constraintAnchor.m216a(c0038e);
            constraintAnchor2.m216a(c0038e);
            return;
        }
        int i8;
        int i9;
        int i10;
        Object obj;
        int max;
        SolverVariable a = c0038e.m186a((Object) constraintAnchor);
        SolverVariable a2 = c0038e.m186a((Object) constraintAnchor2);
        SolverVariable a3 = c0038e.m186a(constraintAnchor.m225f());
        SolverVariable a4 = c0038e.m186a(constraintAnchor2.m225f());
        boolean i11 = constraintAnchor.m228i();
        boolean i12 = constraintAnchor2.m228i();
        boolean i13 = this.f364v.m228i();
        Object obj2 = null;
        if (z3) {
            i5 = 3;
        }
        switch (dimensionBehaviour) {
            case FIXED:
                obj2 = null;
                break;
            case WRAP_CONTENT:
                obj2 = null;
                break;
            case MATCH_PARENT:
                obj2 = null;
                break;
            case MATCH_CONSTRAINT:
                obj2 = 1;
                break;
        }
        if (this.aj == 8) {
            i8 = 0;
            obj2 = null;
        } else {
            i8 = i2;
        }
        if (obj2 != null) {
            int max2;
            if (i6 == -2) {
                i6 = i8;
            }
            if (i7 == -2) {
                i7 = i8;
            }
            if (i6 > 0) {
                if (z) {
                    c0038e.m191a(a2, a, i6, 6);
                } else {
                    c0038e.m191a(a2, a, i6, 6);
                }
                max2 = Math.max(i8, i6);
            } else {
                max2 = i8;
            }
            if (i7 > 0) {
                if (z) {
                    c0038e.m200b(a2, a, i7, 1);
                } else {
                    c0038e.m200b(a2, a, i7, 6);
                }
                max2 = Math.min(max2, i7);
            }
            if (i5 == 1) {
                if (z || z4) {
                    c0038e.m203c(a2, a, max2, 3);
                    i9 = max2;
                } else {
                    c0038e.m203c(a2, a, max2, 1);
                    i9 = max2;
                }
            } else if (i5 == 2) {
                SolverVariable a5;
                SolverVariable a6;
                if (constraintAnchor.m222c() == Type.TOP || constraintAnchor.m222c() == Type.BOTTOM) {
                    a5 = c0038e.m186a(this.f368z.mo44a(Type.TOP));
                    a6 = c0038e.m186a(this.f368z.mo44a(Type.BOTTOM));
                } else {
                    a5 = c0038e.m186a(this.f368z.mo44a(Type.LEFT));
                    a6 = c0038e.m186a(this.f368z.mo44a(Type.RIGHT));
                }
                c0038e.m201b(c0038e.m198b().m154a(a2, a, a6, a5, f2));
                obj2 = null;
                i9 = max2;
            } else {
                i9 = max2;
            }
        } else if (z2) {
            c0038e.m203c(a2, a, 0, 3);
            if (i3 > 0) {
                c0038e.m191a(a2, a, i3, 6);
            }
            if (i4 < Integer.MAX_VALUE) {
                c0038e.m200b(a2, a, i4, 6);
                i9 = i8;
            } else {
                i9 = i8;
            }
        } else {
            c0038e.m203c(a2, a, i8, 6);
            i9 = i8;
        }
        i8 = 0;
        if (i11) {
            i8 = 1;
        }
        if (i12) {
            i8++;
        }
        if (i13) {
            i10 = i8 + 1;
        } else {
            i10 = i8;
        }
        if (obj2 == null || i10 == 2 || z3) {
            obj = obj2;
        } else {
            obj = null;
            max = Math.max(i6, i9);
            if (i7 > 0) {
                max = Math.min(i7, max);
            }
            c0038e.m203c(a2, a, max, 6);
        }
        if (z5 && !z4) {
            if (!i11 && !i12 && !i13) {
                c0038e.m188a(a, i);
                if (z) {
                    c0038e.m191a(solverVariable2, a2, 0, 5);
                }
            } else if (i11 && !i12) {
                c0038e.m203c(a, a3, constraintAnchor.m223d(), 6);
                if (z) {
                    c0038e.m191a(solverVariable2, a2, 0, 5);
                }
            } else if (!i11 && i12) {
                c0038e.m203c(a2, a4, -constraintAnchor2.m223d(), 6);
                if (z) {
                    c0038e.m191a(a, solverVariable, 0, 5);
                }
            } else if (i11 && i12 && !z4) {
                if (obj != null) {
                    if (z && i3 == 0) {
                        c0038e.m191a(a2, a, 0, 6);
                    }
                    c0038e.m191a(a, a3, constraintAnchor.m223d(), 6);
                    c0038e.m200b(a2, a4, -constraintAnchor2.m223d(), 6);
                    if (i5 == 0) {
                        c0038e.m203c(a, a3, constraintAnchor.m223d(), 4);
                        c0038e.m203c(a2, a4, -constraintAnchor2.m223d(), 4);
                    } else if (i5 == 3) {
                        max = 3;
                        if (!z3) {
                            max = 5;
                        }
                        c0038e.m203c(a, a3, constraintAnchor.m223d(), max);
                        c0038e.m203c(a2, a4, -constraintAnchor2.m223d(), max);
                    }
                }
                if (obj == null || !(i5 == 0 || i5 == 1)) {
                    if (obj != null && i5 == 3) {
                        c0038e.m190a(a, a3, constraintAnchor.m223d(), f, a4, a2, constraintAnchor2.m223d(), 5);
                    } else if (z) {
                        c0038e.m191a(a, a3, constraintAnchor.m223d(), 5);
                        c0038e.m200b(a2, a4, -constraintAnchor2.m223d(), 5);
                        c0038e.m190a(a, a3, constraintAnchor.m223d(), f, a4, a2, constraintAnchor2.m223d(), 5);
                    } else {
                        c0038e.m190a(a, a3, constraintAnchor.m223d(), f, a4, a2, constraintAnchor2.m223d(), 5);
                    }
                } else if (i5 == 1) {
                    c0038e.m190a(a, a3, constraintAnchor.m223d(), f, a4, a2, constraintAnchor2.m223d(), 6);
                } else if (i5 == 0 && (i7 > 0 || i6 > 0)) {
                    c0038e.m190a(a, a3, constraintAnchor.m223d(), f, a4, a2, constraintAnchor2.m223d(), 5);
                }
            }
            if (z) {
                c0038e.m191a(solverVariable2, a2, 0, 6);
            }
        } else if (i10 < 2 && z) {
            c0038e.m191a(solverVariable2, a2, 0, 6);
        }
    }

    public void mo45b(C0038e c0038e) {
        m236a(c0038e.m197b(this.f357o), c0038e.m197b(this.f358p), c0038e.m197b(this.f359q), c0038e.m197b(this.f360r));
    }
}
