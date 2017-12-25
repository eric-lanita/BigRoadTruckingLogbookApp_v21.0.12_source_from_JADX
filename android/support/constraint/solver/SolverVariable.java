package android.support.constraint.solver;

import java.util.Arrays;

public class SolverVariable {
    private static int f229j = 1;
    private static int f230k = 1;
    private static int f231l = 1;
    private static int f232m = 1;
    private static int f233n = 1;
    public int f234a = -1;
    int f235b = -1;
    public int f236c = 0;
    public float f237d;
    float[] f238e = new float[7];
    Type f239f;
    C0035b[] f240g = new C0035b[8];
    int f241h = 0;
    public int f242i = 0;
    private String f243o;

    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    static void m121a() {
        f230k++;
    }

    public SolverVariable(Type type, String str) {
        this.f239f = type;
    }

    void m123a(C0035b c0035b) {
        int i = 0;
        while (i < this.f241h) {
            if (this.f240g[i] != c0035b) {
                i++;
            } else {
                return;
            }
        }
        if (this.f241h >= this.f240g.length) {
            this.f240g = (C0035b[]) Arrays.copyOf(this.f240g, this.f240g.length * 2);
        }
        this.f240g[this.f241h] = c0035b;
        this.f241h++;
    }

    void m125b(C0035b c0035b) {
        int i = 0;
        for (int i2 = 0; i2 < this.f241h; i2++) {
            if (this.f240g[i2] == c0035b) {
                while (i < (this.f241h - i2) - 1) {
                    this.f240g[i2 + i] = this.f240g[(i2 + i) + 1];
                    i++;
                }
                this.f241h--;
                return;
            }
        }
    }

    public void m124b() {
        this.f243o = null;
        this.f239f = Type.UNKNOWN;
        this.f236c = 0;
        this.f234a = -1;
        this.f235b = -1;
        this.f237d = 0.0f;
        this.f241h = 0;
        this.f242i = 0;
    }

    public void m122a(Type type, String str) {
        this.f239f = type;
    }

    public String toString() {
        return "" + this.f243o;
    }
}
