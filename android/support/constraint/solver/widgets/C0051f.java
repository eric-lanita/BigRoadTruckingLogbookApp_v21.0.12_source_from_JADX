package android.support.constraint.solver.widgets;

import android.support.constraint.solver.C0038e;
import android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour;

public class C0051f {
    static boolean[] f373a = new boolean[3];

    static void m330a(C0048c c0048c, C0038e c0038e, ConstraintWidget constraintWidget) {
        if (c0048c.y[0] != DimensionBehaviour.WRAP_CONTENT && constraintWidget.f367y[0] == DimensionBehaviour.MATCH_PARENT) {
            constraintWidget.f357o.f303f = c0038e.m186a(constraintWidget.f357o);
            constraintWidget.f359q.f303f = c0038e.m186a(constraintWidget.f359q);
            int i = constraintWidget.f357o.f301d;
            int g = c0048c.m268g() - constraintWidget.f359q.f301d;
            c0038e.m188a(constraintWidget.f357o.f303f, i);
            c0038e.m188a(constraintWidget.f359q.f303f, g);
            constraintWidget.m259c(i, g);
            constraintWidget.f343a = 2;
        }
        if (c0048c.y[1] != DimensionBehaviour.WRAP_CONTENT && constraintWidget.f367y[1] == DimensionBehaviour.MATCH_PARENT) {
            constraintWidget.f358p.f303f = c0038e.m186a(constraintWidget.f358p);
            constraintWidget.f360r.f303f = c0038e.m186a(constraintWidget.f360r);
            i = constraintWidget.f358p.f301d;
            g = c0048c.m272i() - constraintWidget.f360r.f301d;
            c0038e.m188a(constraintWidget.f358p.f303f, i);
            c0038e.m188a(constraintWidget.f360r.f303f, g);
            if (constraintWidget.f326I > 0 || constraintWidget.m256c() == 8) {
                constraintWidget.f361s.f303f = c0038e.m186a(constraintWidget.f361s);
                c0038e.m188a(constraintWidget.f361s.f303f, constraintWidget.f326I + i);
            }
            constraintWidget.m263d(i, g);
            constraintWidget.f344b = 2;
        }
    }

    static boolean m331a(C0038e c0038e, C0048c c0048c) {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        int size = c0048c.aj.size();
        if (c0048c.y[0] == DimensionBehaviour.WRAP_CONTENT) {
            i = 1;
        } else {
            i = 0;
        }
        if (c0048c.y[1] == DimensionBehaviour.WRAP_CONTENT) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        for (i3 = 0; i3 < size; i3++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) c0048c.aj.get(i3);
            if (i != 0) {
                constraintWidget.f357o.f304g = 2;
                constraintWidget.f359q.f304g = 2;
            } else {
                constraintWidget.f357o.f304g = 0;
                constraintWidget.f359q.f304g = 0;
            }
            if (i2 != 0) {
                constraintWidget.f358p.f304g = 2;
                constraintWidget.f360r.f304g = 2;
                constraintWidget.f361s.f304g = 2;
            } else {
                constraintWidget.f358p.f304g = 0;
                constraintWidget.f360r.f304g = 0;
                constraintWidget.f361s.f304g = 0;
            }
        }
        for (i3 = 0; i3 < size; i3++) {
            constraintWidget = (ConstraintWidget) c0048c.aj.get(i3);
            ConstraintAnchor constraintAnchor = constraintWidget.f365w[0];
            ConstraintAnchor constraintAnchor2 = constraintWidget.f365w[1];
            if (constraintAnchor.f304g == 0 && constraintAnchor2.f304g == 0) {
                if (constraintAnchor.f300c == null || constraintAnchor2.f300c == null) {
                    if (constraintAnchor.f300c != null && constraintAnchor.f300c == c0048c.o) {
                        constraintAnchor.m217a(c0038e, constraintAnchor.m223d(), null);
                    } else if (constraintAnchor2.f300c != null && constraintAnchor2.f300c == c0048c.q) {
                        constraintAnchor2.m217a(c0038e, c0048c.A - constraintAnchor2.m223d(), null);
                    }
                } else if (i == 0 && constraintAnchor.f300c == c0048c.o && constraintAnchor2.f300c == c0048c.q && constraintWidget.f367y[0] == DimensionBehaviour.FIXED) {
                    int d = ((int) ((((float) (((c0048c.A - constraintWidget.f318A) - constraintAnchor.m223d()) - constraintAnchor2.m223d())) * constraintWidget.f329M) + 0.5f)) + constraintAnchor.m223d();
                    constraintAnchor.m217a(c0038e, d, null);
                    constraintAnchor2.m217a(c0038e, constraintWidget.f318A + d, null);
                }
            }
            constraintAnchor = constraintWidget.f365w[2];
            constraintAnchor2 = constraintWidget.f365w[3];
            if (constraintAnchor.f304g == 0 && constraintAnchor2.f304g == 0) {
                if (constraintAnchor.f300c == null || constraintAnchor2.f300c == null) {
                    if (constraintAnchor.f300c != null && constraintAnchor.f300c == c0048c.p) {
                        constraintAnchor.m217a(c0038e, constraintAnchor.m223d(), null);
                    } else if (constraintAnchor2.f300c != null && constraintAnchor2.f300c == c0048c.r) {
                        constraintAnchor2.m217a(c0038e, c0048c.B - constraintAnchor2.m223d(), null);
                    }
                } else if (i2 == 0 && constraintAnchor.f300c == c0048c.p && constraintAnchor2.f300c == c0048c.r && constraintWidget.f367y[1] == DimensionBehaviour.FIXED) {
                    d = ((int) ((((float) (((c0048c.B - constraintWidget.f319B) - constraintAnchor.m223d()) - constraintAnchor2.m223d())) * constraintWidget.f330N) + 0.5f)) + constraintAnchor.m223d();
                    constraintAnchor.m217a(c0038e, d, null);
                    constraintAnchor2.m217a(c0038e, constraintWidget.f319B + d, null);
                }
            }
        }
        for (i2 = 0; i2 < size; i2++) {
            ConstraintAnchor constraintAnchor3;
            ConstraintAnchor constraintAnchor4;
            constraintWidget = (ConstraintWidget) c0048c.aj.get(i2);
            if (constraintWidget.f367y[0] == DimensionBehaviour.FIXED || constraintWidget.f367y[0] == DimensionBehaviour.WRAP_CONTENT) {
                i = 1;
            } else {
                i = 0;
            }
            if (i != 0) {
                constraintAnchor3 = constraintWidget.f365w[0];
                constraintAnchor4 = constraintWidget.f365w[1];
                if (constraintAnchor3.f304g == 1 && constraintAnchor4.f304g == 0) {
                    if (constraintAnchor3.f306i == null) {
                        constraintAnchor4.m217a(c0038e, constraintAnchor3.f305h + constraintWidget.m268g(), null);
                    } else {
                        constraintAnchor4.m217a(c0038e, constraintWidget.m268g(), constraintAnchor3);
                    }
                } else if (constraintAnchor3.f304g == 0 && constraintAnchor4.f304g == 1) {
                    if (constraintAnchor4.f306i == null) {
                        constraintAnchor3.m217a(c0038e, constraintAnchor4.f305h - constraintWidget.m268g(), null);
                    } else {
                        constraintAnchor3.m217a(c0038e, -constraintWidget.m268g(), constraintAnchor4);
                    }
                }
            }
            if (constraintWidget.f367y[1] == DimensionBehaviour.FIXED || constraintWidget.f367y[1] == DimensionBehaviour.WRAP_CONTENT) {
                i = 1;
            } else {
                i = 0;
            }
            if (i != 0) {
                constraintAnchor3 = constraintWidget.f358p;
                constraintAnchor4 = constraintWidget.f360r;
                if (constraintAnchor3.f304g == 1 && constraintAnchor4.f304g == 0) {
                    if (constraintAnchor3.f306i == null) {
                        constraintAnchor4.m217a(c0038e, constraintWidget.m272i() + constraintAnchor3.f305h, null);
                    } else {
                        constraintAnchor4.m217a(c0038e, constraintWidget.m272i(), constraintAnchor3);
                    }
                } else if (constraintAnchor3.f304g == 0 && constraintAnchor4.f304g == 1) {
                    if (constraintAnchor4.f306i == null) {
                        constraintAnchor3.m217a(c0038e, constraintAnchor4.f305h - constraintWidget.m272i(), null);
                    } else {
                        constraintAnchor3.m217a(c0038e, -constraintWidget.m272i(), constraintAnchor4);
                    }
                }
            }
        }
        for (i = 0; i < size; i++) {
            constraintWidget = (ConstraintWidget) c0048c.aj.get(i);
            if (constraintWidget.f357o.f304g != 1 || constraintWidget.f359q.f304g != 1 || constraintWidget.f358p.f304g != 1 || constraintWidget.f360r.f304g != 1) {
                return false;
            }
        }
        while (i4 < size) {
            constraintWidget = (ConstraintWidget) c0048c.aj.get(i4);
            constraintWidget.m236a(constraintWidget.f357o.f305h, constraintWidget.f358p.f305h, constraintWidget.f359q.f305h, constraintWidget.f360r.f305h);
            i4++;
        }
        return true;
    }
}
