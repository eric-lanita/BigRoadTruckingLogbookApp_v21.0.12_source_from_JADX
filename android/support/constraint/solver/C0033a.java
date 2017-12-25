package android.support.constraint.solver;

import android.support.constraint.solver.SolverVariable.Type;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import java.util.Arrays;

public class C0033a {
    int f244a = 0;
    private final C0035b f245b;
    private final C0036c f246c;
    private int f247d = 8;
    private SolverVariable f248e = null;
    private int[] f249f = new int[this.f247d];
    private int[] f250g = new int[this.f247d];
    private float[] f251h = new float[this.f247d];
    private int f252i = -1;
    private int f253j = -1;
    private boolean f254k = false;

    C0033a(C0035b c0035b, C0036c c0036c) {
        this.f245b = c0035b;
        this.f246c = c0036c;
    }

    public final void m133a(SolverVariable solverVariable, float f) {
        if (f == 0.0f) {
            m127a(solverVariable);
        } else if (this.f252i == -1) {
            this.f252i = 0;
            this.f251h[this.f252i] = f;
            this.f249f[this.f252i] = solverVariable.f234a;
            this.f250g[this.f252i] = -1;
            solverVariable.f242i++;
            this.f244a++;
            if (!this.f254k) {
                this.f253j++;
                if (this.f253j >= this.f249f.length) {
                    this.f254k = true;
                    this.f253j = this.f249f.length - 1;
                }
            }
        } else {
            int i = this.f252i;
            int i2 = 0;
            int i3 = -1;
            while (i != -1 && i2 < this.f244a) {
                if (this.f249f[i] == solverVariable.f234a) {
                    this.f251h[i] = f;
                    return;
                }
                if (this.f249f[i] < solverVariable.f234a) {
                    i3 = i;
                }
                i2++;
                i = this.f250g[i];
            }
            i = this.f253j + 1;
            if (this.f254k) {
                if (this.f249f[this.f253j] == -1) {
                    i = this.f253j;
                } else {
                    i = this.f249f.length;
                }
            }
            if (i >= this.f249f.length && this.f244a < this.f249f.length) {
                for (i2 = 0; i2 < this.f249f.length; i2++) {
                    if (this.f249f[i2] == -1) {
                        i = i2;
                        break;
                    }
                }
            }
            if (i >= this.f249f.length) {
                i = this.f249f.length;
                this.f247d *= 2;
                this.f254k = false;
                this.f253j = i - 1;
                this.f251h = Arrays.copyOf(this.f251h, this.f247d);
                this.f249f = Arrays.copyOf(this.f249f, this.f247d);
                this.f250g = Arrays.copyOf(this.f250g, this.f247d);
            }
            this.f249f[i] = solverVariable.f234a;
            this.f251h[i] = f;
            if (i3 != -1) {
                this.f250g[i] = this.f250g[i3];
                this.f250g[i3] = i;
            } else {
                this.f250g[i] = this.f252i;
                this.f252i = i;
            }
            solverVariable.f242i++;
            this.f244a++;
            if (!this.f254k) {
                this.f253j++;
            }
            if (this.f244a >= this.f249f.length) {
                this.f254k = true;
            }
            if (this.f253j >= this.f249f.length) {
                this.f254k = true;
                this.f253j = this.f249f.length - 1;
            }
        }
    }

    public final void m139b(SolverVariable solverVariable, float f) {
        if (f != 0.0f) {
            if (this.f252i == -1) {
                this.f252i = 0;
                this.f251h[this.f252i] = f;
                this.f249f[this.f252i] = solverVariable.f234a;
                this.f250g[this.f252i] = -1;
                solverVariable.f242i++;
                this.f244a++;
                if (!this.f254k) {
                    this.f253j++;
                    if (this.f253j >= this.f249f.length) {
                        this.f254k = true;
                        this.f253j = this.f249f.length - 1;
                        return;
                    }
                    return;
                }
                return;
            }
            int i = this.f252i;
            int i2 = 0;
            int i3 = -1;
            while (i != -1 && i2 < this.f244a) {
                int i4 = this.f249f[i];
                if (i4 == solverVariable.f234a) {
                    float[] fArr = this.f251h;
                    fArr[i] = fArr[i] + f;
                    if (this.f251h[i] == 0.0f) {
                        if (i == this.f252i) {
                            this.f252i = this.f250g[i];
                        } else {
                            this.f250g[i3] = this.f250g[i];
                        }
                        this.f246c.f262c[i4].m125b(this.f245b);
                        if (this.f254k) {
                            this.f253j = i;
                        }
                        solverVariable.f242i--;
                        this.f244a--;
                        return;
                    }
                    return;
                }
                if (this.f249f[i] < solverVariable.f234a) {
                    i3 = i;
                }
                i2++;
                i = this.f250g[i];
            }
            i = this.f253j + 1;
            if (this.f254k) {
                if (this.f249f[this.f253j] == -1) {
                    i = this.f253j;
                } else {
                    i = this.f249f.length;
                }
            }
            if (i >= this.f249f.length && this.f244a < this.f249f.length) {
                for (i2 = 0; i2 < this.f249f.length; i2++) {
                    if (this.f249f[i2] == -1) {
                        i = i2;
                        break;
                    }
                }
            }
            if (i >= this.f249f.length) {
                i = this.f249f.length;
                this.f247d *= 2;
                this.f254k = false;
                this.f253j = i - 1;
                this.f251h = Arrays.copyOf(this.f251h, this.f247d);
                this.f249f = Arrays.copyOf(this.f249f, this.f247d);
                this.f250g = Arrays.copyOf(this.f250g, this.f247d);
            }
            this.f249f[i] = solverVariable.f234a;
            this.f251h[i] = f;
            if (i3 != -1) {
                this.f250g[i] = this.f250g[i3];
                this.f250g[i3] = i;
            } else {
                this.f250g[i] = this.f252i;
                this.f252i = i;
            }
            solverVariable.f242i++;
            this.f244a++;
            if (!this.f254k) {
                this.f253j++;
            }
            if (this.f253j >= this.f249f.length) {
                this.f254k = true;
                this.f253j = this.f249f.length - 1;
            }
        }
    }

    public final float m127a(SolverVariable solverVariable) {
        if (this.f248e == solverVariable) {
            this.f248e = null;
        }
        if (this.f252i == -1) {
            return 0.0f;
        }
        int i = this.f252i;
        int i2 = 0;
        int i3 = -1;
        while (i != -1 && i2 < this.f244a) {
            int i4 = this.f249f[i];
            if (i4 == solverVariable.f234a) {
                if (i == this.f252i) {
                    this.f252i = this.f250g[i];
                } else {
                    this.f250g[i3] = this.f250g[i];
                }
                this.f246c.f262c[i4].m125b(this.f245b);
                solverVariable.f242i--;
                this.f244a--;
                this.f249f[i] = -1;
                if (this.f254k) {
                    this.f253j = i;
                }
                return this.f251h[i];
            }
            i2++;
            int i5 = i;
            i = this.f250g[i];
            i3 = i5;
        }
        return 0.0f;
    }

    public final void m131a() {
        this.f252i = -1;
        this.f253j = -1;
        this.f254k = false;
        this.f244a = 0;
    }

    final boolean m140b(SolverVariable solverVariable) {
        if (this.f252i == -1) {
            return false;
        }
        int i = this.f252i;
        int i2 = 0;
        while (i != -1 && i2 < this.f244a) {
            if (this.f249f[i] == solverVariable.f234a) {
                return true;
            }
            i = this.f250g[i];
            i2++;
        }
        return false;
    }

    void m138b() {
        int i = this.f252i;
        int i2 = 0;
        while (i != -1 && i2 < this.f244a) {
            float[] fArr = this.f251h;
            fArr[i] = fArr[i] * GroundOverlayOptions.NO_DIMENSION;
            i = this.f250g[i];
            i2++;
        }
    }

    void m132a(float f) {
        int i = this.f252i;
        int i2 = 0;
        while (i != -1 && i2 < this.f244a) {
            float[] fArr = this.f251h;
            fArr[i] = fArr[i] / f;
            i = this.f250g[i];
            i2++;
        }
    }

    void m134a(C0035b c0035b) {
        int i = this.f252i;
        int i2 = 0;
        while (i != -1 && i2 < this.f244a) {
            this.f246c.f262c[this.f249f[i]].m123a(c0035b);
            i = this.f250g[i];
            i2++;
        }
    }

    private boolean m126a(SolverVariable solverVariable, C0038e c0038e) {
        return solverVariable.f242i <= 1;
    }

    SolverVariable m129a(C0038e c0038e) {
        SolverVariable solverVariable = null;
        boolean z = false;
        int i = 0;
        int i2 = this.f252i;
        float f = 0.0f;
        float f2 = 0.0f;
        SolverVariable solverVariable2 = null;
        boolean z2 = false;
        while (i2 != -1 && i < this.f244a) {
            SolverVariable solverVariable3;
            float f3 = this.f251h[i2];
            if (f3 < 0.0f) {
                if (f3 > (-981668463)) {
                    this.f251h[i2] = 0.0f;
                    f3 = 0.0f;
                }
            } else if (f3 < 0.001f) {
                this.f251h[i2] = 0.0f;
                f3 = 0.0f;
            }
            SolverVariable solverVariable4 = this.f246c.f262c[this.f249f[i2]];
            if (solverVariable4.f239f != Type.UNRESTRICTED) {
                if (solverVariable == null && f3 < 0.0f) {
                    if (solverVariable2 == null) {
                        z = m126a(solverVariable4, c0038e);
                        f = f3;
                        f3 = f2;
                        solverVariable3 = solverVariable;
                    } else if (f > f3) {
                        z = m126a(solverVariable4, c0038e);
                        f = f3;
                        f3 = f2;
                        solverVariable3 = solverVariable;
                    } else if (!z && m126a(solverVariable4, c0038e)) {
                        z = true;
                        f = f3;
                        f3 = f2;
                        solverVariable3 = solverVariable;
                    }
                }
                f3 = f2;
                solverVariable4 = solverVariable2;
                solverVariable3 = solverVariable;
            } else if (solverVariable == null) {
                z2 = m126a(solverVariable4, c0038e);
                solverVariable3 = solverVariable4;
                solverVariable4 = solverVariable2;
            } else if (f2 > f3) {
                z2 = m126a(solverVariable4, c0038e);
                solverVariable3 = solverVariable4;
                solverVariable4 = solverVariable2;
            } else {
                if (!z2 && m126a(solverVariable4, c0038e)) {
                    z2 = true;
                    solverVariable3 = solverVariable4;
                    solverVariable4 = solverVariable2;
                }
                f3 = f2;
                solverVariable4 = solverVariable2;
                solverVariable3 = solverVariable;
            }
            i++;
            i2 = this.f250g[i2];
            solverVariable = solverVariable3;
            solverVariable2 = solverVariable4;
            f2 = f3;
        }
        return solverVariable != null ? solverVariable : solverVariable2;
    }

    void m135a(C0035b c0035b, C0035b c0035b2) {
        int i = this.f252i;
        int i2 = 0;
        while (i != -1 && i2 < this.f244a) {
            if (this.f249f[i] == c0035b2.f255a.f234a) {
                float f = this.f251h[i];
                m127a(c0035b2.f255a);
                C0033a c0033a = c0035b2.f258d;
                i = c0033a.f252i;
                i2 = 0;
                while (i != -1 && i2 < c0033a.f244a) {
                    m139b(this.f246c.f262c[c0033a.f249f[i]], c0033a.f251h[i] * f);
                    i = c0033a.f250g[i];
                    i2++;
                }
                c0035b.f256b += c0035b2.f256b * f;
                c0035b2.f255a.m125b(c0035b);
                i = this.f252i;
                i2 = 0;
            } else {
                i = this.f250g[i];
                i2++;
            }
        }
    }

    void m136a(C0035b c0035b, C0035b[] c0035bArr) {
        int i = this.f252i;
        int i2 = 0;
        while (i != -1 && i2 < this.f244a) {
            SolverVariable solverVariable = this.f246c.f262c[this.f249f[i]];
            if (solverVariable.f235b != -1) {
                float f = this.f251h[i];
                m127a(solverVariable);
                C0035b c0035b2 = c0035bArr[solverVariable.f235b];
                if (!c0035b2.f259e) {
                    C0033a c0033a = c0035b2.f258d;
                    i = c0033a.f252i;
                    i2 = 0;
                    while (i != -1 && i2 < c0033a.f244a) {
                        m139b(this.f246c.f262c[c0033a.f249f[i]], c0033a.f251h[i] * f);
                        i = c0033a.f250g[i];
                        i2++;
                    }
                }
                c0035b.f256b += c0035b2.f256b * f;
                c0035b2.f255a.m125b(c0035b);
                i = this.f252i;
                i2 = 0;
            } else {
                i = this.f250g[i];
                i2++;
            }
        }
    }

    SolverVariable m130a(boolean[] zArr, SolverVariable solverVariable) {
        SolverVariable solverVariable2 = null;
        int i = 0;
        int i2 = this.f252i;
        float f = 0.0f;
        while (i2 != -1 && i < this.f244a) {
            SolverVariable solverVariable3;
            if (this.f251h[i2] < 0.0f) {
                SolverVariable solverVariable4 = this.f246c.f262c[this.f249f[i2]];
                if ((zArr == null || !zArr[solverVariable4.f234a]) && solverVariable4 != solverVariable && (solverVariable4.f239f == Type.SLACK || solverVariable4.f239f == Type.ERROR)) {
                    float f2 = this.f251h[i2];
                    if (f2 < f) {
                        f = f2;
                        solverVariable3 = solverVariable4;
                        i++;
                        i2 = this.f250g[i2];
                        solverVariable2 = solverVariable3;
                    }
                }
            }
            solverVariable3 = solverVariable2;
            i++;
            i2 = this.f250g[i2];
            solverVariable2 = solverVariable3;
        }
        return solverVariable2;
    }

    final SolverVariable m128a(int i) {
        int i2 = this.f252i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f244a) {
            if (i3 == i) {
                return this.f246c.f262c[this.f249f[i2]];
            }
            i2 = this.f250g[i2];
            i3++;
        }
        return null;
    }

    final float m137b(int i) {
        int i2 = this.f252i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f244a) {
            if (i3 == i) {
                return this.f251h[i2];
            }
            i2 = this.f250g[i2];
            i3++;
        }
        return 0.0f;
    }

    public final float m141c(SolverVariable solverVariable) {
        int i = this.f252i;
        int i2 = 0;
        while (i != -1 && i2 < this.f244a) {
            if (this.f249f[i] == solverVariable.f234a) {
                return this.f251h[i];
            }
            i = this.f250g[i];
            i2++;
        }
        return 0.0f;
    }

    public String toString() {
        String str = "";
        int i = this.f252i;
        int i2 = 0;
        while (i != -1 && i2 < this.f244a) {
            str = ((str + " -> ") + this.f251h[i] + " : ") + this.f246c.f262c[this.f249f[i]];
            i = this.f250g[i];
            i2++;
        }
        return str;
    }
}
