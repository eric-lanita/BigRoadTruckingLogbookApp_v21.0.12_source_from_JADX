package android.support.constraint.solver.widgets;

import android.support.constraint.solver.C0035b;
import android.support.constraint.solver.C0038e;
import android.support.constraint.solver.SolverVariable;
import android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour;

class C0046b {
    static void m299a(C0048c c0048c, C0038e c0038e, int i) {
        int i2;
        ConstraintWidget[] constraintWidgetArr;
        int i3;
        int i4 = 0;
        if (i == 0) {
            i2 = c0048c.ae;
            constraintWidgetArr = c0048c.ah;
            i3 = 0;
        } else {
            i3 = 2;
            i2 = c0048c.af;
            constraintWidgetArr = c0048c.ag;
        }
        while (i4 < i2) {
            C0046b.m300a(c0048c, c0038e, i, i3, constraintWidgetArr[i4]);
            i4++;
        }
    }

    static void m300a(C0048c c0048c, C0038e c0038e, int i, int i2, ConstraintWidget constraintWidget) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        ConstraintWidget constraintWidget2;
        float f;
        ConstraintWidget constraintWidget3;
        ConstraintWidget constraintWidget4 = null;
        ConstraintWidget constraintWidget5 = null;
        int i3 = 0;
        ConstraintWidget constraintWidget6 = null;
        ConstraintWidget constraintWidget7 = null;
        Object obj5 = c0048c.y[i] == DimensionBehaviour.WRAP_CONTENT ? 1 : null;
        if (i == 0) {
            Object obj6;
            obj = constraintWidget.f333Q == 0 ? 1 : null;
            Object obj7 = constraintWidget.f333Q == 1 ? 1 : null;
            if (constraintWidget.f333Q == 2) {
                obj6 = 1;
            } else {
                obj6 = null;
            }
            obj2 = obj6;
            obj3 = obj7;
            obj4 = obj;
            constraintWidget2 = constraintWidget;
            obj = null;
            f = 0.0f;
        } else {
            obj2 = constraintWidget.f334R == 2 ? 1 : null;
            obj3 = constraintWidget.f334R == 1 ? 1 : null;
            obj4 = constraintWidget.f334R == 0 ? 1 : null;
            constraintWidget2 = constraintWidget;
            obj = null;
            f = 0.0f;
        }
        while (obj == null) {
            ConstraintWidget constraintWidget8;
            ConstraintWidget constraintWidget9;
            ConstraintWidget constraintWidget10;
            float f2;
            constraintWidget2.f339W[i] = null;
            if (constraintWidget2.m256c() != 8) {
                if (constraintWidget5 != null) {
                    constraintWidget5.f339W[i] = constraintWidget2;
                }
                if (constraintWidget4 == null) {
                    constraintWidget8 = constraintWidget2;
                } else {
                    constraintWidget8 = constraintWidget4;
                }
                constraintWidget9 = constraintWidget2;
                constraintWidget4 = constraintWidget8;
            } else {
                constraintWidget9 = constraintWidget5;
            }
            ConstraintAnchor constraintAnchor = constraintWidget2.f365w[i2];
            int i4 = 1;
            int d = constraintAnchor.m223d();
            if (!(obj2 == null || constraintWidget2 == constraintWidget || constraintWidget2 == r14)) {
                i4 = 6;
            }
            c0038e.m191a(constraintAnchor.f303f, constraintAnchor.f300c.f303f, d, 6);
            c0038e.m203c(constraintAnchor.f303f, constraintAnchor.f300c.f303f, d, i4);
            constraintWidget2.f338V[i] = null;
            if (constraintWidget2.m256c() == 8 || constraintWidget2.f367y[i] != DimensionBehaviour.MATCH_CONSTRAINT) {
                constraintWidget10 = constraintWidget7;
                f2 = f;
                constraintWidget3 = constraintWidget10;
            } else {
                i4 = i3 + 1;
                f += constraintWidget2.f337U[i];
                if (constraintWidget6 == null) {
                    constraintWidget6 = constraintWidget2;
                } else {
                    constraintWidget7.f338V[i] = constraintWidget2;
                }
                if (obj5 != null) {
                    c0038e.m191a(constraintWidget2.f365w[i2 + 1].f303f, constraintWidget2.f365w[i2].f303f, 0, 6);
                }
                f2 = f;
                i3 = i4;
                constraintWidget3 = constraintWidget2;
            }
            if (obj5 != null) {
                c0038e.m191a(constraintWidget2.f365w[i2].f303f, c0048c.w[i2].f303f, 0, 6);
            }
            ConstraintAnchor constraintAnchor2 = constraintWidget2.f365w[i2 + 1].f300c;
            if (constraintAnchor2 != null) {
                constraintWidget8 = constraintAnchor2.f298a;
                if (constraintWidget8.f365w[i2].f300c == null || constraintWidget8.f365w[i2].f300c.f298a != constraintWidget2) {
                    constraintWidget8 = null;
                }
            } else {
                constraintWidget8 = null;
            }
            if (constraintWidget8 == null) {
                obj = 1;
                constraintWidget8 = constraintWidget2;
            }
            constraintWidget5 = constraintWidget9;
            constraintWidget2 = constraintWidget8;
            constraintWidget10 = constraintWidget3;
            f = f2;
            constraintWidget7 = constraintWidget10;
        }
        if (!(constraintWidget5 == null || constraintWidget2.f365w[i2 + 1].f300c == null)) {
            ConstraintAnchor constraintAnchor3 = constraintWidget5.f365w[i2 + 1];
            c0038e.m200b(constraintAnchor3.f303f, constraintWidget2.f365w[i2 + 1].f300c.f303f, -constraintAnchor3.m223d(), 6);
        }
        if (obj5 != null) {
            c0038e.m191a(c0048c.w[i2 + 1].f303f, constraintWidget2.f365w[i2 + 1].f303f, constraintWidget2.f365w[i2 + 1].m223d(), 6);
        }
        if (i3 > 0) {
            constraintWidget7 = constraintWidget6;
            while (constraintWidget7 != null) {
                ConstraintWidget constraintWidget11 = constraintWidget7.f338V[i];
                if (constraintWidget11 != null) {
                    C0035b b = c0038e.m198b();
                    b.m148a(constraintWidget7.f337U[i], f, constraintWidget11.f337U[i], constraintWidget7.f365w[i2].f303f, constraintWidget7.f365w[i2 + 1].f303f, constraintWidget11.f365w[i2].f303f, constraintWidget11.f365w[i2 + 1].f303f);
                    c0038e.m201b(b);
                }
                constraintWidget7 = constraintWidget11;
            }
        }
        SolverVariable solverVariable;
        SolverVariable solverVariable2;
        int d2;
        if (constraintWidget4 == constraintWidget5 || obj2 != null) {
            constraintAnchor3 = constraintWidget.f365w[i2];
            ConstraintAnchor constraintAnchor4 = constraintWidget2.f365w[i2 + 1];
            solverVariable = constraintWidget.f365w[i2].f300c != null ? constraintWidget.f365w[i2].f300c.f303f : null;
            solverVariable2 = constraintWidget2.f365w[i2 + 1].f300c != null ? constraintWidget2.f365w[i2 + 1].f300c.f303f : null;
            if (solverVariable != null && solverVariable2 != null) {
                float f3;
                if (i == 0) {
                    f3 = constraintWidget.f329M;
                } else {
                    f3 = constraintWidget.f330N;
                }
                d2 = constraintAnchor3.m223d();
                if (constraintWidget5 != null) {
                    constraintWidget2 = constraintWidget5;
                }
                c0038e.m190a(constraintAnchor3.f303f, solverVariable, d2, f3, solverVariable2, constraintAnchor4.f303f, constraintWidget2.f365w[i2 + 1].m223d(), 4);
            }
        } else if (obj4 != null && constraintWidget4 != null) {
            r4 = constraintWidget4;
            r16 = constraintWidget4;
            while (r16 != null) {
                r17 = r16.f339W[i];
                if (r17 != null || r16 == constraintWidget5) {
                    r7 = r16.f365w[i2];
                    r5 = r7.f303f;
                    solverVariable = r7.f300c != null ? r7.f300c.f303f : null;
                    if (r4 != r16) {
                        solverVariable = r4.f365w[i2 + 1].f303f;
                    }
                    r4 = null;
                    r7.m223d();
                    if (r17 != null) {
                        r7 = r17.f365w[i2];
                        solverVariable2 = r7.f303f;
                        r4 = r7.f300c != null ? r7.f300c.f303f : null;
                        r7.m223d();
                        r10 = r4;
                    } else {
                        r7 = constraintWidget2.f365w[i2 + 1].f300c;
                        if (r7 != null) {
                            r4 = r7.f303f;
                        }
                        r10 = r16.f365w[i2 + 1].f303f;
                        solverVariable2 = r4;
                    }
                    if (!(r5 == null || solverVariable == null || solverVariable2 == null || r10 == null)) {
                        d2 = 0;
                        if (r16 == constraintWidget4) {
                            d2 = constraintWidget4.f365w[i2].m223d();
                        }
                        int i5 = 0;
                        if (r16 == constraintWidget5) {
                            i5 = constraintWidget5.f365w[i2 + 1].m223d();
                        }
                        c0038e.m190a(r5, solverVariable, d2, 0.5f, solverVariable2, r10, i5, 4);
                    }
                }
                r4 = r16;
                r16 = r17;
            }
        } else if (obj3 != null && constraintWidget4 != null) {
            constraintWidget3 = constraintWidget4;
            r17 = constraintWidget4;
            while (r17 != null) {
                r4 = r17.f339W[i];
                if (r17 == constraintWidget4 || r4 == null) {
                    r16 = r4;
                } else {
                    if (r4 == constraintWidget5) {
                        r16 = null;
                    } else {
                        r16 = r4;
                    }
                    r7 = r17.f365w[i2];
                    r5 = r7.f303f;
                    if (r7.f300c != null) {
                        r4 = r7.f300c.f303f;
                    }
                    solverVariable = constraintWidget3.f365w[i2 + 1].f303f;
                    r4 = null;
                    r7.m223d();
                    if (r16 != null) {
                        r7 = r16.f365w[i2];
                        solverVariable2 = r7.f303f;
                        r4 = r7.f300c != null ? r7.f300c.f303f : null;
                        r7.m223d();
                        r10 = r4;
                    } else {
                        r7 = r17.f365w[i2 + 1].f300c;
                        if (r7 != null) {
                            r4 = r7.f303f;
                        }
                        r10 = r17.f365w[i2 + 1].f303f;
                        solverVariable2 = r4;
                    }
                    if (!(r5 == null || solverVariable == null || solverVariable2 == null || r10 == null)) {
                        c0038e.m190a(r5, solverVariable, 0, 0.5f, solverVariable2, r10, 0, 4);
                    }
                }
                constraintWidget3 = r17;
                r17 = r16;
            }
            constraintAnchor3 = constraintWidget4.f365w[i2];
            ConstraintAnchor constraintAnchor5 = constraintWidget.f365w[i2].f300c;
            ConstraintAnchor constraintAnchor6 = constraintWidget5.f365w[i2 + 1];
            ConstraintAnchor constraintAnchor7 = constraintWidget2.f365w[i2 + 1].f300c;
            if (constraintAnchor5 != null) {
                if (constraintWidget4 != constraintWidget5) {
                    c0038e.m203c(constraintAnchor3.f303f, constraintAnchor5.f303f, constraintAnchor3.m223d(), 6);
                } else if (constraintAnchor7 != null) {
                    c0038e.m190a(constraintAnchor3.f303f, constraintAnchor5.f303f, constraintAnchor3.m223d(), 0.5f, constraintAnchor6.f303f, constraintAnchor7.f303f, constraintAnchor6.m223d(), 6);
                }
            }
            if (constraintAnchor7 != null && constraintWidget4 != constraintWidget5) {
                c0038e.m203c(constraintAnchor6.f303f, constraintAnchor7.f303f, -constraintAnchor6.m223d(), 6);
            }
        }
    }
}
