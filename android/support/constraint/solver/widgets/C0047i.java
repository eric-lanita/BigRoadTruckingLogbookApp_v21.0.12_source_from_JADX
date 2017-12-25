package android.support.constraint.solver.widgets;

import android.support.constraint.solver.C0036c;
import java.util.ArrayList;

public class C0047i extends ConstraintWidget {
    protected ArrayList<ConstraintWidget> aj = new ArrayList();

    public void mo39a() {
        this.aj.clear();
        super.mo39a();
    }

    public void m307b(ConstraintWidget constraintWidget) {
        this.aj.add(constraintWidget);
        if (constraintWidget.m247b() != null) {
            ((C0047i) constraintWidget.m247b()).m308c(constraintWidget);
        }
        constraintWidget.m241a((ConstraintWidget) this);
    }

    public void m308c(ConstraintWidget constraintWidget) {
        this.aj.remove(constraintWidget);
        constraintWidget.m241a(null);
    }

    public C0048c m302C() {
        C0048c c0048c;
        ConstraintWidget constraintWidget;
        ConstraintWidget b = m247b();
        if (this instanceof C0048c) {
            c0048c = (C0048c) this;
            constraintWidget = b;
        } else {
            c0048c = null;
            constraintWidget = b;
        }
        while (constraintWidget != null) {
            b = constraintWidget.m247b();
            if (constraintWidget instanceof C0048c) {
                c0048c = (C0048c) constraintWidget;
                constraintWidget = b;
            } else {
                constraintWidget = b;
            }
        }
        return c0048c;
    }

    public void mo41b(int i, int i2) {
        super.mo41b(i, i2);
        int size = this.aj.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((ConstraintWidget) this.aj.get(i3)).mo41b(m280m(), m282n());
        }
    }

    public void mo42u() {
        super.mo42u();
        if (this.aj != null) {
            int size = this.aj.size();
            for (int i = 0; i < size; i++) {
                ConstraintWidget constraintWidget = (ConstraintWidget) this.aj.get(i);
                constraintWidget.mo41b(m276k(), m278l());
                if (!(constraintWidget instanceof C0048c)) {
                    constraintWidget.mo42u();
                }
            }
        }
    }

    public void mo43A() {
        mo42u();
        if (this.aj != null) {
            int size = this.aj.size();
            for (int i = 0; i < size; i++) {
                ConstraintWidget constraintWidget = (ConstraintWidget) this.aj.get(i);
                if (constraintWidget instanceof C0047i) {
                    ((C0047i) constraintWidget).mo43A();
                }
            }
        }
    }

    public void mo40a(C0036c c0036c) {
        super.mo40a(c0036c);
        int size = this.aj.size();
        for (int i = 0; i < size; i++) {
            ((ConstraintWidget) this.aj.get(i)).mo40a(c0036c);
        }
    }

    public void m303D() {
        this.aj.clear();
    }
}
