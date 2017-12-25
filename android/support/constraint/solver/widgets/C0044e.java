package android.support.constraint.solver.widgets;

import java.util.Arrays;

public class C0044e extends ConstraintWidget {
    protected ConstraintWidget[] f369Z = new ConstraintWidget[4];
    protected int aa = 0;

    public void m295b(ConstraintWidget constraintWidget) {
        if (this.aa + 1 > this.f369Z.length) {
            this.f369Z = (ConstraintWidget[]) Arrays.copyOf(this.f369Z, this.f369Z.length * 2);
        }
        this.f369Z[this.aa] = constraintWidget;
        this.aa++;
    }

    public void mo37y() {
        this.aa = 0;
    }
}
