package android.support.constraint.solver;

import android.support.constraint.solver.SolverVariable.Type;
import android.support.constraint.solver.widgets.ConstraintAnchor;
import android.support.constraint.solver.widgets.ConstraintWidget;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import java.util.Arrays;
import java.util.HashMap;

public class C0038e {
    private static int f263f = 1000;
    int f264a;
    C0035b[] f265b;
    int f266c;
    int f267d;
    final C0036c f268e;
    private HashMap<String, SolverVariable> f269g;
    private C0034a f270h;
    private int f271i;
    private int f272j;
    private boolean[] f273k;
    private int f274l;
    private SolverVariable[] f275m;
    private int f276n;
    private C0035b[] f277o;

    interface C0034a {
        SolverVariable mo29a(C0038e c0038e, boolean[] zArr);

        void mo30a(C0034a c0034a);

        void mo31d(SolverVariable solverVariable);

        void mo32g();

        SolverVariable mo33h();
    }

    public C0038e() {
        this.f264a = 0;
        this.f269g = null;
        this.f271i = 32;
        this.f272j = this.f271i;
        this.f265b = null;
        this.f273k = new boolean[this.f271i];
        this.f266c = 1;
        this.f267d = 0;
        this.f274l = this.f271i;
        this.f275m = new SolverVariable[f263f];
        this.f276n = 0;
        this.f277o = new C0035b[this.f271i];
        this.f265b = new C0035b[this.f271i];
        m183h();
        this.f268e = new C0036c();
        this.f270h = new C0037d(this.f268e);
    }

    private void m182g() {
        this.f271i *= 2;
        this.f265b = (C0035b[]) Arrays.copyOf(this.f265b, this.f271i);
        this.f268e.f262c = (SolverVariable[]) Arrays.copyOf(this.f268e.f262c, this.f271i);
        this.f273k = new boolean[this.f271i];
        this.f272j = this.f271i;
        this.f274l = this.f271i;
    }

    private void m183h() {
        for (int i = 0; i < this.f265b.length; i++) {
            Object obj = this.f265b[i];
            if (obj != null) {
                this.f268e.f260a.mo36a(obj);
            }
            this.f265b[i] = null;
        }
    }

    public void m187a() {
        int i;
        for (SolverVariable solverVariable : this.f268e.f262c) {
            if (solverVariable != null) {
                solverVariable.m124b();
            }
        }
        this.f268e.f261b.mo35a(this.f275m, this.f276n);
        this.f276n = 0;
        Arrays.fill(this.f268e.f262c, null);
        if (this.f269g != null) {
            this.f269g.clear();
        }
        this.f264a = 0;
        this.f270h.mo32g();
        this.f266c = 1;
        for (i = 0; i < this.f267d; i++) {
            this.f265b[i].f257c = false;
        }
        m183h();
        this.f267d = 0;
    }

    public SolverVariable m186a(Object obj) {
        SolverVariable solverVariable = null;
        if (obj != null) {
            if (this.f266c + 1 >= this.f272j) {
                m182g();
            }
            if (obj instanceof ConstraintAnchor) {
                solverVariable = ((ConstraintAnchor) obj).m214a();
                if (solverVariable == null) {
                    ((ConstraintAnchor) obj).m215a(this.f268e);
                    solverVariable = ((ConstraintAnchor) obj).m214a();
                }
                if (solverVariable.f234a == -1 || solverVariable.f234a > this.f264a || this.f268e.f262c[solverVariable.f234a] == null) {
                    if (solverVariable.f234a != -1) {
                        solverVariable.m124b();
                    }
                    this.f264a++;
                    this.f266c++;
                    solverVariable.f234a = this.f264a;
                    solverVariable.f239f = Type.UNRESTRICTED;
                    this.f268e.f262c[this.f264a] = solverVariable;
                }
            }
        }
        return solverVariable;
    }

    public C0035b m198b() {
        C0035b c0035b = (C0035b) this.f268e.f260a.mo34a();
        if (c0035b == null) {
            c0035b = new C0035b(this.f268e);
        } else {
            c0035b.m169d();
        }
        SolverVariable.m121a();
        return c0035b;
    }

    public SolverVariable m202c() {
        if (this.f266c + 1 >= this.f272j) {
            m182g();
        }
        SolverVariable a = m177a(Type.SLACK, null);
        this.f264a++;
        this.f266c++;
        a.f234a = this.f264a;
        this.f268e.f262c[this.f264a] = a;
        return a;
    }

    public SolverVariable m204d() {
        if (this.f266c + 1 >= this.f272j) {
            m182g();
        }
        SolverVariable a = m177a(Type.SLACK, null);
        this.f264a++;
        this.f266c++;
        a.f234a = this.f264a;
        this.f268e.f262c[this.f264a] = a;
        return a;
    }

    private void m180c(C0035b c0035b) {
        c0035b.m155a(this, 0);
    }

    void m194a(C0035b c0035b, int i, int i2) {
        c0035b.m166c(m185a(i2, null), i);
    }

    public SolverVariable m185a(int i, String str) {
        if (this.f266c + 1 >= this.f272j) {
            m182g();
        }
        SolverVariable a = m177a(Type.ERROR, str);
        this.f264a++;
        this.f266c++;
        a.f234a = this.f264a;
        a.f236c = i;
        this.f268e.f262c[this.f264a] = a;
        this.f270h.mo31d(a);
        return a;
    }

    private SolverVariable m177a(Type type, String str) {
        SolverVariable solverVariable;
        SolverVariable solverVariable2 = (SolverVariable) this.f268e.f261b.mo34a();
        if (solverVariable2 == null) {
            solverVariable2 = new SolverVariable(type, str);
            solverVariable2.m122a(type, str);
            solverVariable = solverVariable2;
        } else {
            solverVariable2.m124b();
            solverVariable2.m122a(type, str);
            solverVariable = solverVariable2;
        }
        if (this.f276n >= f263f) {
            f263f *= 2;
            this.f275m = (SolverVariable[]) Arrays.copyOf(this.f275m, f263f);
        }
        SolverVariable[] solverVariableArr = this.f275m;
        int i = this.f276n;
        this.f276n = i + 1;
        solverVariableArr[i] = solverVariable;
        return solverVariable;
    }

    public int m197b(Object obj) {
        SolverVariable a = ((ConstraintAnchor) obj).m214a();
        if (a != null) {
            return (int) (a.f237d + 0.5f);
        }
        return 0;
    }

    public void m205e() {
        m195a(this.f270h);
    }

    void m195a(C0034a c0034a) {
        m193a((C0035b) c0034a);
        m179b(c0034a);
        m176a(c0034a, false);
        m184i();
    }

    void m193a(C0035b c0035b) {
        if (this.f267d > 0) {
            c0035b.f258d.m136a(c0035b, this.f265b);
            if (c0035b.f258d.f244a == 0) {
                c0035b.f259e = true;
            }
        }
    }

    public void m201b(C0035b c0035b) {
        int i = 0;
        if (c0035b != null) {
            if (this.f267d + 1 >= this.f274l || this.f266c + 1 >= this.f272j) {
                m182g();
            }
            if (!c0035b.f259e) {
                m193a(c0035b);
                if (!c0035b.m172f()) {
                    c0035b.m171e();
                    if (c0035b.m160a(this)) {
                        SolverVariable d = m204d();
                        c0035b.f255a = d;
                        m181d(c0035b);
                        C0034a c0035b2 = new C0035b(this.f268e);
                        c0035b2.mo30a(c0035b);
                        m176a(c0035b2, true);
                        if (d.f235b == -1) {
                            int i2;
                            if (c0035b.f255a == d) {
                                SolverVariable b = c0035b.m161b(d);
                                if (b != null) {
                                    c0035b.m168c(b);
                                    c0035b.m156a();
                                }
                            }
                            for (i2 = 0; i2 < this.f267d; i2++) {
                                this.f265b[i2].f258d.m127a(d);
                            }
                            for (i2 = 0; i2 < this.f267d; i2++) {
                                C0035b c0035b3 = this.f265b[i2];
                                if (c0035b3 != c0035b) {
                                    c0035b3.m159a(c0035b);
                                }
                            }
                            if (!c0035b.f259e) {
                                c0035b.m156a();
                                int i3 = c0035b.f255a.f241h;
                                if (i3 > 0) {
                                    while (this.f277o.length < i3) {
                                        this.f277o = new C0035b[(this.f277o.length * 2)];
                                    }
                                    C0035b[] c0035bArr = this.f277o;
                                    for (i2 = 0; i2 < i3; i2++) {
                                        c0035bArr[i2] = c0035b.f255a.f240g[i2];
                                    }
                                    while (i < i3) {
                                        C0035b c0035b4 = c0035bArr[i];
                                        if (c0035b4 != c0035b) {
                                            c0035b4.f258d.m135a(c0035b4, c0035b);
                                            c0035b4.m156a();
                                        }
                                        i++;
                                    }
                                }
                            }
                        }
                        i = 1;
                    }
                    if (!c0035b.m165b()) {
                        return;
                    }
                }
                return;
            }
            if (i == 0) {
                m181d(c0035b);
            }
        }
    }

    private void m181d(C0035b c0035b) {
        int i = 0;
        if (this.f265b[this.f267d] != null) {
            this.f268e.f260a.mo36a(this.f265b[this.f267d]);
        }
        if (!c0035b.f259e) {
            c0035b.m156a();
        }
        this.f265b[this.f267d] = c0035b;
        c0035b.f255a.f235b = this.f267d;
        this.f267d++;
        int i2 = c0035b.f255a.f241h;
        if (i2 > 0) {
            while (this.f277o.length < i2) {
                this.f277o = new C0035b[(this.f277o.length * 2)];
            }
            C0035b[] c0035bArr = this.f277o;
            for (int i3 = 0; i3 < i2; i3++) {
                c0035bArr[i3] = c0035b.f255a.f240g[i3];
            }
            while (i < i2) {
                C0035b c0035b2 = c0035bArr[i];
                if (c0035b2 != c0035b) {
                    c0035b2.f258d.m135a(c0035b2, c0035b);
                    c0035b2.m156a();
                }
                i++;
            }
        }
        m193a((C0037d) this.f270h);
    }

    private int m176a(C0034a c0034a, boolean z) {
        int i;
        for (i = 0; i < this.f266c; i++) {
            this.f273k[i] = false;
        }
        i = 0;
        boolean z2 = false;
        while (!z2) {
            int i2 = i + 1;
            if (i2 >= this.f266c * 2) {
                return i2;
            }
            boolean z3;
            if (c0034a.mo33h() != null) {
                this.f273k[c0034a.mo33h().f234a] = true;
            }
            SolverVariable a = c0034a.mo29a(this, this.f273k);
            if (a != null) {
                if (this.f273k[a.f234a]) {
                    return i2;
                }
                this.f273k[a.f234a] = true;
            }
            if (a != null) {
                int i3 = -1;
                float f = Float.MAX_VALUE;
                for (i = 0; i < this.f267d; i++) {
                    C0035b c0035b = this.f265b[i];
                    if (c0035b.f255a.f239f != Type.UNRESTRICTED && c0035b.m158a(a)) {
                        float c = c0035b.f258d.m141c(a);
                        if (c < 0.0f) {
                            float f2 = (-c0035b.f256b) / c;
                            if (f2 < f) {
                                i3 = i;
                                f = f2;
                            }
                        }
                    }
                }
                if (i3 > -1) {
                    C0035b c0035b2 = this.f265b[i3];
                    c0035b2.f255a.f235b = -1;
                    c0035b2.m168c(a);
                    c0035b2.m156a();
                    c0035b2.f255a.f235b = i3;
                    for (i = 0; i < this.f267d; i++) {
                        this.f265b[i].m159a(c0035b2);
                    }
                    m193a((C0035b) c0034a);
                    z3 = z2;
                } else {
                    System.out.println("we couldn't find an equation to pivot upon");
                    z3 = true;
                }
            } else {
                z3 = true;
            }
            z2 = z3;
            i = i2;
        }
        return i;
    }

    private int m179b(C0034a c0034a) {
        Object obj;
        int i;
        int i2 = 0;
        while (i2 < this.f267d) {
            if (this.f265b[i2].f255a.f239f != Type.UNRESTRICTED && this.f265b[i2].f256b < 0.0f) {
                obj = 1;
                break;
            }
            i2++;
        }
        obj = null;
        if (obj != null) {
            Object obj2 = null;
            i2 = 0;
            while (obj2 == null) {
                int i3 = i2 + 1;
                float f = Float.MAX_VALUE;
                int i4 = 0;
                int i5 = -1;
                i = -1;
                for (i2 = 0; i2 < this.f267d; i2++) {
                    C0035b c0035b = this.f265b[i2];
                    if (c0035b.f255a.f239f != Type.UNRESTRICTED && c0035b.f256b < 0.0f) {
                        float f2 = f;
                        int i6 = i4;
                        i4 = i5;
                        i5 = i;
                        for (i = 1; i < this.f266c; i++) {
                            SolverVariable solverVariable = this.f268e.f262c[i];
                            float c = c0035b.f258d.m141c(solverVariable);
                            if (c > 0.0f) {
                                float f3 = f2;
                                int i7 = 0;
                                while (i7 < 7) {
                                    float f4 = solverVariable.f238e[i7] / c;
                                    if ((f4 >= f3 || i7 != r4) && i7 <= r4) {
                                        f4 = f3;
                                    } else {
                                        i5 = i;
                                        i4 = i2;
                                        i6 = i7;
                                    }
                                    i7++;
                                    f3 = f4;
                                }
                                f2 = f3;
                            }
                        }
                        i = i5;
                        i5 = i4;
                        i4 = i6;
                        f = f2;
                    }
                }
                if (i5 != -1) {
                    C0035b c0035b2 = this.f265b[i5];
                    c0035b2.f255a.f235b = -1;
                    c0035b2.m168c(this.f268e.f262c[i]);
                    c0035b2.m156a();
                    c0035b2.f255a.f235b = i5;
                    for (i2 = 0; i2 < this.f267d; i2++) {
                        this.f265b[i2].m159a(c0035b2);
                    }
                    m193a((C0035b) c0034a);
                    obj = obj2;
                } else {
                    obj = 1;
                }
                obj2 = obj;
                i2 = i3;
            }
        } else {
            i2 = 0;
        }
        i = 0;
        while (i < this.f267d && (this.f265b[i].f255a.f239f == Type.UNRESTRICTED || this.f265b[i].f256b >= 0.0f)) {
            i++;
        }
        return i2;
    }

    private void m184i() {
        for (int i = 0; i < this.f267d; i++) {
            C0035b c0035b = this.f265b[i];
            c0035b.f255a.f237d = c0035b.f256b;
        }
    }

    public C0036c m206f() {
        return this.f268e;
    }

    public void m191a(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        C0035b b = m198b();
        SolverVariable c = m202c();
        c.f236c = 0;
        b.m153a(solverVariable, solverVariable2, c, i);
        if (i2 != 6) {
            m194a(b, (int) (b.f258d.m141c(c) * GroundOverlayOptions.NO_DIMENSION), i2);
        }
        m201b(b);
    }

    public void m189a(SolverVariable solverVariable, SolverVariable solverVariable2) {
        C0035b b = m198b();
        SolverVariable c = m202c();
        c.f236c = 0;
        b.m153a(solverVariable, solverVariable2, c, 0);
        m194a(b, (int) (b.f258d.m141c(c) * GroundOverlayOptions.NO_DIMENSION), 5);
        m201b(b);
    }

    public void m200b(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        C0035b b = m198b();
        SolverVariable c = m202c();
        c.f236c = 0;
        b.m163b(solverVariable, solverVariable2, c, i);
        if (i2 != 6) {
            m194a(b, (int) (b.f258d.m141c(c) * GroundOverlayOptions.NO_DIMENSION), i2);
        }
        m201b(b);
    }

    public void m199b(SolverVariable solverVariable, SolverVariable solverVariable2) {
        C0035b b = m198b();
        SolverVariable c = m202c();
        c.f236c = 0;
        b.m163b(solverVariable, solverVariable2, c, 0);
        m194a(b, (int) (b.f258d.m141c(c) * GroundOverlayOptions.NO_DIMENSION), 5);
        m201b(b);
    }

    public void m190a(SolverVariable solverVariable, SolverVariable solverVariable2, int i, float f, SolverVariable solverVariable3, SolverVariable solverVariable4, int i2, int i3) {
        C0035b b = m198b();
        b.m151a(solverVariable, solverVariable2, i, f, solverVariable3, solverVariable4, i2);
        if (i3 != 6) {
            b.m155a(this, i3);
        }
        m201b(b);
    }

    public void m192a(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f, int i) {
        C0035b b = m198b();
        b.m154a(solverVariable, solverVariable2, solverVariable3, solverVariable4, f);
        if (i != 6) {
            b.m155a(this, i);
        }
        m201b(b);
    }

    public C0035b m203c(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        C0035b b = m198b();
        b.m150a(solverVariable, solverVariable2, i);
        if (i2 != 6) {
            b.m155a(this, i2);
        }
        m201b(b);
        return b;
    }

    public void m188a(SolverVariable solverVariable, int i) {
        int i2 = solverVariable.f235b;
        C0035b c0035b;
        if (solverVariable.f235b != -1) {
            c0035b = this.f265b[i2];
            if (c0035b.f259e) {
                c0035b.f256b = (float) i;
                return;
            } else if (c0035b.f258d.f244a == 0) {
                c0035b.f259e = true;
                c0035b.f256b = (float) i;
                return;
            } else {
                c0035b = m198b();
                c0035b.m162b(solverVariable, i);
                m201b(c0035b);
                return;
            }
        }
        c0035b = m198b();
        c0035b.m149a(solverVariable, i);
        m201b(c0035b);
    }

    public static C0035b m178a(C0038e c0038e, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, float f, boolean z) {
        C0035b b = c0038e.m198b();
        if (z) {
            c0038e.m180c(b);
        }
        return b.m152a(solverVariable, solverVariable2, solverVariable3, f);
    }

    public void m196a(ConstraintWidget constraintWidget, ConstraintWidget constraintWidget2, float f, int i) {
        SolverVariable a = m186a(constraintWidget.mo44a(ConstraintAnchor.Type.LEFT));
        SolverVariable a2 = m186a(constraintWidget.mo44a(ConstraintAnchor.Type.TOP));
        SolverVariable a3 = m186a(constraintWidget.mo44a(ConstraintAnchor.Type.RIGHT));
        SolverVariable a4 = m186a(constraintWidget.mo44a(ConstraintAnchor.Type.BOTTOM));
        SolverVariable a5 = m186a(constraintWidget2.mo44a(ConstraintAnchor.Type.LEFT));
        SolverVariable a6 = m186a(constraintWidget2.mo44a(ConstraintAnchor.Type.TOP));
        SolverVariable a7 = m186a(constraintWidget2.mo44a(ConstraintAnchor.Type.RIGHT));
        SolverVariable a8 = m186a(constraintWidget2.mo44a(ConstraintAnchor.Type.BOTTOM));
        C0035b b = m198b();
        b.m164b(a2, a4, a6, a8, (float) (Math.sin((double) f) * ((double) i)));
        m201b(b);
        b = m198b();
        b.m164b(a, a3, a5, a7, (float) (Math.cos((double) f) * ((double) i)));
        m201b(b);
    }
}
