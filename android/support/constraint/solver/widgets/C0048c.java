package android.support.constraint.solver.widgets;

import android.support.constraint.solver.C0038e;
import android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour;
import java.util.Arrays;

public class C0048c extends C0047i {
    protected C0038e f370Z = new C0038e();
    int aa;
    int ab;
    int ac;
    int ad;
    int ae = 0;
    int af = 0;
    ConstraintWidget[] ag = new ConstraintWidget[4];
    ConstraintWidget[] ah = new ConstraintWidget[4];
    int ai = 0;
    private C0054h ak;
    private int al = 2;
    private boolean am = false;
    private boolean an = false;

    public void m316a(int i) {
        this.al = i;
    }

    public void mo39a() {
        this.f370Z.m187a();
        this.aa = 0;
        this.ac = 0;
        this.ab = 0;
        this.ad = 0;
        super.mo39a();
    }

    public boolean mo37y() {
        return this.am;
    }

    public boolean m321z() {
        return this.an;
    }

    public boolean m319c(C0038e c0038e) {
        mo38a(c0038e);
        int size = this.aj.size();
        if ((this.al == 2 || this.al == 4) && C0051f.m331a(c0038e, this)) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.aj.get(i);
            if (constraintWidget instanceof C0048c) {
                DimensionBehaviour dimensionBehaviour = constraintWidget.f367y[0];
                DimensionBehaviour dimensionBehaviour2 = constraintWidget.f367y[1];
                if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.m240a(DimensionBehaviour.FIXED);
                }
                if (dimensionBehaviour2 == DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.m253b(DimensionBehaviour.FIXED);
                }
                constraintWidget.mo38a(c0038e);
                if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.m240a(dimensionBehaviour);
                }
                if (dimensionBehaviour2 == DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.m253b(dimensionBehaviour2);
                }
            } else {
                C0051f.m330a(this, c0038e, constraintWidget);
                constraintWidget.mo38a(c0038e);
            }
        }
        if (this.ae > 0) {
            C0046b.m299a(this, c0038e, 0);
        }
        if (this.af > 0) {
            C0046b.m299a(this, c0038e, 1);
        }
        return true;
    }

    public void m317a(C0038e c0038e, boolean[] zArr) {
        zArr[2] = false;
        mo45b(c0038e);
        int size = this.aj.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.aj.get(i);
            constraintWidget.mo45b(c0038e);
            if (constraintWidget.f367y[0] == DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.m268g() < constraintWidget.m270h()) {
                zArr[2] = true;
            }
            if (constraintWidget.f367y[1] == DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.m272i() < constraintWidget.m274j()) {
                zArr[2] = true;
            }
        }
    }

    public void mo43A() {
        int i;
        int i2 = this.E;
        int i3 = this.F;
        int max = Math.max(0, m268g());
        int max2 = Math.max(0, m272i());
        this.am = false;
        this.an = false;
        if (this.z != null) {
            if (this.ak == null) {
                this.ak = new C0054h(this);
            }
            this.ak.m334a(this);
            m265e(this.aa);
            m267f(this.ab);
            m292v();
            mo40a(this.f370Z.m206f());
        } else {
            this.E = 0;
            this.F = 0;
        }
        Object obj = null;
        DimensionBehaviour dimensionBehaviour = this.y[1];
        DimensionBehaviour dimensionBehaviour2 = this.y[0];
        m310E();
        int size = this.aj.size();
        for (i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.aj.get(i);
            if (constraintWidget instanceof C0047i) {
                ((C0047i) constraintWidget).mo43A();
            }
        }
        boolean z = true;
        int i4 = 0;
        while (z) {
            boolean z2;
            Object obj2;
            int i5 = i4 + 1;
            try {
                this.f370Z.m187a();
                z = m319c(this.f370Z);
                if (z) {
                    this.f370Z.m205e();
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("EXCEPTION : " + e);
            }
            if (!z) {
                mo45b(this.f370Z);
                i = 0;
                while (i < size) {
                    constraintWidget = (ConstraintWidget) this.aj.get(i);
                    if (constraintWidget.f367y[0] != DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.m268g() >= constraintWidget.m270h()) {
                        if (constraintWidget.f367y[1] == DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.m272i() < constraintWidget.m274j()) {
                            C0051f.f373a[2] = true;
                            break;
                        }
                        i++;
                    } else {
                        C0051f.f373a[2] = true;
                        break;
                    }
                }
            }
            m317a(this.f370Z, C0051f.f373a);
            if (i5 >= 8 || !C0051f.f373a[2]) {
                z2 = false;
                obj2 = obj;
            } else {
                int i6;
                int i7 = 0;
                int i8 = 0;
                for (i6 = 0; i6 < size; i6++) {
                    constraintWidget = (ConstraintWidget) this.aj.get(i6);
                    i7 = Math.max(i7, constraintWidget.f322E + constraintWidget.m268g());
                    i8 = Math.max(i8, constraintWidget.m272i() + constraintWidget.f323F);
                }
                i4 = Math.max(this.J, i7);
                i6 = Math.max(this.K, i8);
                if (dimensionBehaviour2 != DimensionBehaviour.WRAP_CONTENT || m268g() >= i4) {
                    z2 = false;
                    obj2 = obj;
                } else {
                    m269g(i4);
                    this.y[0] = DimensionBehaviour.WRAP_CONTENT;
                    obj2 = 1;
                    z2 = true;
                }
                if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT && m272i() < i6) {
                    m271h(i6);
                    this.y[1] = DimensionBehaviour.WRAP_CONTENT;
                    obj2 = 1;
                    z2 = true;
                }
            }
            int max3 = Math.max(this.J, m268g());
            if (max3 > m268g()) {
                m269g(max3);
                this.y[0] = DimensionBehaviour.FIXED;
                obj2 = 1;
                z2 = true;
            }
            max3 = Math.max(this.K, m272i());
            if (max3 > m272i()) {
                m271h(max3);
                this.y[1] = DimensionBehaviour.FIXED;
                obj2 = 1;
                z2 = true;
            }
            if (obj2 == null) {
                if (this.y[0] == DimensionBehaviour.WRAP_CONTENT && max > 0 && m268g() > max) {
                    this.am = true;
                    obj2 = 1;
                    this.y[0] = DimensionBehaviour.FIXED;
                    m269g(max);
                    z2 = true;
                }
                if (this.y[1] == DimensionBehaviour.WRAP_CONTENT && max2 > 0 && m272i() > max2) {
                    this.an = true;
                    obj2 = 1;
                    this.y[1] = DimensionBehaviour.FIXED;
                    m271h(max2);
                    z2 = true;
                }
            }
            obj = obj2;
            z = z2;
            i4 = i5;
        }
        if (this.z != null) {
            i4 = Math.max(this.J, m268g());
            i = Math.max(this.K, m272i());
            this.ak.m335b(this);
            m269g((i4 + this.aa) + this.ac);
            m271h((this.ab + i) + this.ad);
        } else {
            this.E = i2;
            this.F = i3;
        }
        if (obj != null) {
            this.y[0] = dimensionBehaviour2;
            this.y[1] = dimensionBehaviour;
        }
        mo40a(this.f370Z.m206f());
        if (this == m302C()) {
            mo42u();
        }
    }

    public boolean m314B() {
        return false;
    }

    private void m310E() {
        this.ae = 0;
        this.af = 0;
    }

    void m318a(ConstraintWidget constraintWidget, int i) {
        if (i == 0) {
            while (constraintWidget.f357o.f300c != null && constraintWidget.f357o.f300c.f298a.f359q.f300c != null && constraintWidget.f357o.f300c.f298a.f359q.f300c == constraintWidget.f357o && constraintWidget.f357o.f300c.f298a != constraintWidget) {
                constraintWidget = constraintWidget.f357o.f300c.f298a;
            }
            m311d(constraintWidget);
        } else if (i == 1) {
            while (constraintWidget.f358p.f300c != null && constraintWidget.f358p.f300c.f298a.f360r.f300c != null && constraintWidget.f358p.f300c.f298a.f360r.f300c == constraintWidget.f358p && constraintWidget.f358p.f300c.f298a != constraintWidget) {
                constraintWidget = constraintWidget.f358p.f300c.f298a;
            }
            m312e(constraintWidget);
        }
    }

    private void m311d(ConstraintWidget constraintWidget) {
        int i = 0;
        while (i < this.ae) {
            if (this.ah[i] != constraintWidget) {
                i++;
            } else {
                return;
            }
        }
        if (this.ae + 1 >= this.ah.length) {
            this.ah = (ConstraintWidget[]) Arrays.copyOf(this.ah, this.ah.length * 2);
        }
        this.ah[this.ae] = constraintWidget;
        this.ae++;
    }

    private void m312e(ConstraintWidget constraintWidget) {
        int i = 0;
        while (i < this.af) {
            if (this.ag[i] != constraintWidget) {
                i++;
            } else {
                return;
            }
        }
        if (this.af + 1 >= this.ag.length) {
            this.ag = (ConstraintWidget[]) Arrays.copyOf(this.ag, this.ag.length * 2);
        }
        this.ag[this.af] = constraintWidget;
        this.af++;
    }
}
