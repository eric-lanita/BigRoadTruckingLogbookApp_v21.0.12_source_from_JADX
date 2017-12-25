package android.support.constraint.solver.widgets;

import android.support.constraint.solver.widgets.ConstraintAnchor.Strength;
import java.util.ArrayList;

public class C0054h {
    private int f379a;
    private int f380b;
    private int f381c;
    private int f382d;
    private ArrayList<C0053a> f383e = new ArrayList();

    static class C0053a {
        private ConstraintAnchor f374a;
        private ConstraintAnchor f375b;
        private int f376c;
        private Strength f377d;
        private int f378e;

        public C0053a(ConstraintAnchor constraintAnchor) {
            this.f374a = constraintAnchor;
            this.f375b = constraintAnchor.m225f();
            this.f376c = constraintAnchor.m223d();
            this.f377d = constraintAnchor.m224e();
            this.f378e = constraintAnchor.m226g();
        }

        public void m332a(ConstraintWidget constraintWidget) {
            this.f374a = constraintWidget.mo44a(this.f374a.m222c());
            if (this.f374a != null) {
                this.f375b = this.f374a.m225f();
                this.f376c = this.f374a.m223d();
                this.f377d = this.f374a.m224e();
                this.f378e = this.f374a.m226g();
                return;
            }
            this.f375b = null;
            this.f376c = 0;
            this.f377d = Strength.STRONG;
            this.f378e = 0;
        }

        public void m333b(ConstraintWidget constraintWidget) {
            constraintWidget.mo44a(this.f374a.m222c()).m220a(this.f375b, this.f376c, this.f377d, this.f378e);
        }
    }

    public C0054h(ConstraintWidget constraintWidget) {
        this.f379a = constraintWidget.m264e();
        this.f380b = constraintWidget.m266f();
        this.f381c = constraintWidget.m268g();
        this.f382d = constraintWidget.m272i();
        ArrayList t = constraintWidget.mo46t();
        int size = t.size();
        for (int i = 0; i < size; i++) {
            this.f383e.add(new C0053a((ConstraintAnchor) t.get(i)));
        }
    }

    public void m334a(ConstraintWidget constraintWidget) {
        this.f379a = constraintWidget.m264e();
        this.f380b = constraintWidget.m266f();
        this.f381c = constraintWidget.m268g();
        this.f382d = constraintWidget.m272i();
        int size = this.f383e.size();
        for (int i = 0; i < size; i++) {
            ((C0053a) this.f383e.get(i)).m332a(constraintWidget);
        }
    }

    public void m335b(ConstraintWidget constraintWidget) {
        constraintWidget.m265e(this.f379a);
        constraintWidget.m267f(this.f380b);
        constraintWidget.m269g(this.f381c);
        constraintWidget.m271h(this.f382d);
        int size = this.f383e.size();
        for (int i = 0; i < size; i++) {
            ((C0053a) this.f383e.get(i)).m333b(constraintWidget);
        }
    }
}
