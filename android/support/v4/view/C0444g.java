package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.KeyEvent;

public final class C0444g {
    static final C0440d f1043a;

    interface C0440d {
        boolean mo337a(int i, int i2);

        boolean mo338b(int i);
    }

    static class C0441a implements C0440d {
        C0441a() {
        }

        private static int m2050a(int i, int i2, int i3, int i4, int i5) {
            Object obj = 1;
            Object obj2 = (i2 & i3) != 0 ? 1 : null;
            int i6 = i4 | i5;
            if ((i2 & i6) == 0) {
                obj = null;
            }
            if (obj2 != null) {
                if (obj == null) {
                    return i & (i6 ^ -1);
                }
                throw new IllegalArgumentException("bad arguments");
            } else if (obj != null) {
                return i & (i3 ^ -1);
            } else {
                return i;
            }
        }

        public int mo339a(int i) {
            int i2;
            if ((i & 192) != 0) {
                i2 = i | 1;
            } else {
                i2 = i;
            }
            if ((i2 & 48) != 0) {
                i2 |= 2;
            }
            return i2 & 247;
        }

        public boolean mo337a(int i, int i2) {
            if (C0441a.m2050a(C0441a.m2050a(mo339a(i) & 247, i2, 1, 64, 128), i2, 2, 16, 32) == i2) {
                return true;
            }
            return false;
        }

        public boolean mo338b(int i) {
            return (mo339a(i) & 247) == 0;
        }
    }

    static class C0442b extends C0441a {
        C0442b() {
        }
    }

    static class C0443c extends C0442b {
        C0443c() {
        }

        public int mo339a(int i) {
            return C0445h.m2059a(i);
        }

        public boolean mo337a(int i, int i2) {
            return C0445h.m2060a(i, i2);
        }

        public boolean mo338b(int i) {
            return C0445h.m2061b(i);
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            f1043a = new C0443c();
        } else {
            f1043a = new C0441a();
        }
    }

    public static boolean m2058a(KeyEvent keyEvent, int i) {
        return f1043a.mo337a(keyEvent.getMetaState(), i);
    }

    public static boolean m2057a(KeyEvent keyEvent) {
        return f1043a.mo338b(keyEvent.getMetaState());
    }
}
