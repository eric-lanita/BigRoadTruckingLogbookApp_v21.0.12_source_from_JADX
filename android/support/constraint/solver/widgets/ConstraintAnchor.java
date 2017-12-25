package android.support.constraint.solver.widgets;

import android.support.constraint.solver.C0036c;
import android.support.constraint.solver.C0038e;
import android.support.constraint.solver.SolverVariable;
import java.util.HashSet;

public class ConstraintAnchor {
    final ConstraintWidget f298a;
    final Type f299b;
    ConstraintAnchor f300c;
    public int f301d = 0;
    int f302e = -1;
    SolverVariable f303f;
    public int f304g = 0;
    public int f305h = -1;
    ConstraintAnchor f306i = null;
    private Strength f307j = Strength.NONE;
    private ConnectionType f308k = ConnectionType.RELAXED;
    private int f309l = 0;

    public enum ConnectionType {
        RELAXED,
        STRICT
    }

    public enum Strength {
        NONE,
        STRONG,
        WEAK
    }

    public enum Type {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    void m217a(C0038e c0038e, int i, ConstraintAnchor constraintAnchor) {
        if (this.f303f == null) {
            this.f303f = c0038e.m186a((Object) this);
        }
        this.f304g = 1;
        this.f305h = i;
        this.f306i = constraintAnchor;
    }

    void m216a(C0038e c0038e) {
        this.f303f = c0038e.m186a((Object) this);
        if (this.f306i == null) {
            c0038e.m188a(this.f303f, this.f305h);
            return;
        }
        c0038e.m203c(this.f303f, c0038e.m186a(this.f306i), this.f305h, 6);
    }

    public ConstraintAnchor(ConstraintWidget constraintWidget, Type type) {
        this.f298a = constraintWidget;
        this.f299b = type;
    }

    public SolverVariable m214a() {
        return this.f303f;
    }

    public void m215a(C0036c c0036c) {
        if (this.f303f == null) {
            this.f303f = new SolverVariable(android.support.constraint.solver.SolverVariable.Type.UNRESTRICTED, null);
        } else {
            this.f303f.m124b();
        }
    }

    public ConstraintWidget m221b() {
        return this.f298a;
    }

    public Type m222c() {
        return this.f299b;
    }

    public int m223d() {
        if (this.f298a.m256c() == 8) {
            return 0;
        }
        if (this.f302e <= -1 || this.f300c == null || this.f300c.f298a.m256c() != 8) {
            return this.f301d;
        }
        return this.f302e;
    }

    public Strength m224e() {
        return this.f307j;
    }

    public ConstraintAnchor m225f() {
        return this.f300c;
    }

    public int m226g() {
        return this.f309l;
    }

    public void m227h() {
        this.f300c = null;
        this.f301d = 0;
        this.f302e = -1;
        this.f307j = Strength.STRONG;
        this.f309l = 0;
        this.f308k = ConnectionType.RELAXED;
    }

    public boolean m220a(ConstraintAnchor constraintAnchor, int i, Strength strength, int i2) {
        return m219a(constraintAnchor, i, -1, strength, i2, false);
    }

    public boolean m219a(ConstraintAnchor constraintAnchor, int i, int i2, Strength strength, int i3, boolean z) {
        if (constraintAnchor == null) {
            this.f300c = null;
            this.f301d = 0;
            this.f302e = -1;
            this.f307j = Strength.NONE;
            this.f309l = 2;
            return true;
        } else if (!z && !m218a(constraintAnchor)) {
            return false;
        } else {
            this.f300c = constraintAnchor;
            if (i > 0) {
                this.f301d = i;
            } else {
                this.f301d = 0;
            }
            this.f302e = i2;
            this.f307j = strength;
            this.f309l = i3;
            return true;
        }
    }

    public boolean m228i() {
        return this.f300c != null;
    }

    public boolean m218a(ConstraintAnchor constraintAnchor) {
        boolean z = true;
        if (constraintAnchor == null) {
            return false;
        }
        Type c = constraintAnchor.m222c();
        if (c != this.f299b) {
            boolean z2;
            switch (this.f299b) {
                case CENTER:
                    if (c == Type.BASELINE || c == Type.CENTER_X || c == Type.CENTER_Y) {
                        z = false;
                    }
                    return z;
                case LEFT:
                case RIGHT:
                    if (c == Type.LEFT || c == Type.RIGHT) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (constraintAnchor.m221b() instanceof C0050d) {
                        if (z2 || c == Type.CENTER_X) {
                            return true;
                        }
                        return false;
                    }
                    break;
                case TOP:
                case BOTTOM:
                    if (c == Type.TOP || c == Type.BOTTOM) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (constraintAnchor.m221b() instanceof C0050d) {
                        if (z2 || c == Type.CENTER_Y) {
                            return true;
                        }
                        return false;
                    }
                    break;
                case BASELINE:
                case CENTER_X:
                case CENTER_Y:
                case NONE:
                    return false;
                default:
                    throw new AssertionError(this.f299b.name());
            }
            return z2;
        } else if (this.f299b != Type.BASELINE || (constraintAnchor.m221b().m287q() && m221b().m287q())) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return this.f298a.m260d() + ":" + this.f299b.toString() + (this.f300c != null ? " connected to " + this.f300c.m213a(new HashSet()) : "");
    }

    private String m213a(HashSet<ConstraintAnchor> hashSet) {
        if (!hashSet.add(this)) {
            return "<-";
        }
        return this.f298a.m260d() + ":" + this.f299b.toString() + (this.f300c != null ? " connected to " + this.f300c.m213a((HashSet) hashSet) : "");
    }
}
