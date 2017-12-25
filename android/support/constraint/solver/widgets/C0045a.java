package android.support.constraint.solver.widgets;

import android.support.constraint.solver.C0038e;
import android.support.constraint.solver.SolverVariable;

public class C0045a extends C0044e {
    private int ab = 0;

    public void m297a(int i) {
        this.ab = i;
    }

    public void mo38a(C0038e c0038e) {
        int i;
        this.w[0] = this.o;
        this.w[2] = this.p;
        this.w[1] = this.q;
        this.w[3] = this.r;
        for (i = 0; i < this.w.length; i++) {
            this.w[i].f303f = c0038e.m186a(this.w[i]);
        }
        if (this.ab >= 0 && this.ab < 4) {
            ConstraintAnchor constraintAnchor = this.w[this.ab];
            for (i = 0; i < this.aa; i++) {
                SolverVariable a = c0038e.m186a(this.Z[i].f365w[this.ab]);
                this.Z[i].f365w[this.ab].f303f = a;
                if (this.ab == 0 || this.ab == 2) {
                    c0038e.m199b(constraintAnchor.f303f, a);
                } else {
                    c0038e.m189a(constraintAnchor.f303f, a);
                }
            }
            if (this.ab == 0) {
                c0038e.m203c(this.q.f303f, this.o.f303f, 0, 6);
            } else if (this.ab == 1) {
                c0038e.m203c(this.o.f303f, this.q.f303f, 0, 6);
            } else if (this.ab == 2) {
                c0038e.m203c(this.r.f303f, this.p.f303f, 0, 6);
            } else if (this.ab == 3) {
                c0038e.m203c(this.p.f303f, this.r.f303f, 0, 6);
            }
        }
    }
}
