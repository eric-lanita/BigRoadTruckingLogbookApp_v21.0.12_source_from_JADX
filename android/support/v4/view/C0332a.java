package android.support.v4.view;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.C0428b.C0340a;
import android.support.v4.view.C0431c.C0345a;
import android.support.v4.view.p009a.C0362b;
import android.support.v4.view.p009a.C0373e;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public class C0332a {
    private static final C0342b f931b;
    private static final Object f932c = f931b.mo201a();
    final Object f933a = f931b.mo202a(this);

    interface C0342b {
        C0373e mo200a(Object obj, View view);

        Object mo201a();

        Object mo202a(C0332a c0332a);

        void mo203a(Object obj, View view, int i);

        void mo204a(Object obj, View view, C0362b c0362b);

        boolean mo205a(Object obj, View view, int i, Bundle bundle);

        boolean mo206a(Object obj, View view, AccessibilityEvent accessibilityEvent);

        boolean mo207a(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent);

        void mo208b(Object obj, View view, AccessibilityEvent accessibilityEvent);

        void mo209c(Object obj, View view, AccessibilityEvent accessibilityEvent);

        void mo210d(Object obj, View view, AccessibilityEvent accessibilityEvent);
    }

    static class C0343d implements C0342b {
        C0343d() {
        }

        public Object mo201a() {
            return null;
        }

        public Object mo202a(C0332a c0332a) {
            return null;
        }

        public boolean mo206a(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            return false;
        }

        public void mo208b(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }

        public void mo204a(Object obj, View view, C0362b c0362b) {
        }

        public void mo209c(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }

        public boolean mo207a(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return true;
        }

        public void mo203a(Object obj, View view, int i) {
        }

        public void mo210d(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }

        public C0373e mo200a(Object obj, View view) {
            return null;
        }

        public boolean mo205a(Object obj, View view, int i, Bundle bundle) {
            return false;
        }
    }

    static class C0344a extends C0343d {
        C0344a() {
        }

        public Object mo201a() {
            return C0428b.m2000a();
        }

        public Object mo202a(final C0332a c0332a) {
            return C0428b.m2001a(new C0340a(this) {
                final /* synthetic */ C0344a f986b;

                public boolean mo195a(View view, AccessibilityEvent accessibilityEvent) {
                    return c0332a.m1300b(view, accessibilityEvent);
                }

                public void mo197b(View view, AccessibilityEvent accessibilityEvent) {
                    c0332a.mo189d(view, accessibilityEvent);
                }

                public void mo194a(View view, Object obj) {
                    c0332a.mo187a(view, new C0362b(obj));
                }

                public void mo198c(View view, AccessibilityEvent accessibilityEvent) {
                    c0332a.m1301c(view, accessibilityEvent);
                }

                public boolean mo196a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                    return c0332a.m1299a(viewGroup, view, accessibilityEvent);
                }

                public void mo193a(View view, int i) {
                    c0332a.m1295a(view, i);
                }

                public void mo199d(View view, AccessibilityEvent accessibilityEvent) {
                    c0332a.m1297a(view, accessibilityEvent);
                }
            });
        }

        public boolean mo206a(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            return C0428b.m2004a(obj, view, accessibilityEvent);
        }

        public void mo208b(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            C0428b.m2006b(obj, view, accessibilityEvent);
        }

        public void mo204a(Object obj, View view, C0362b c0362b) {
            C0428b.m2003a(obj, view, c0362b.m1490a());
        }

        public void mo209c(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            C0428b.m2007c(obj, view, accessibilityEvent);
        }

        public boolean mo207a(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return C0428b.m2005a(obj, viewGroup, view, accessibilityEvent);
        }

        public void mo203a(Object obj, View view, int i) {
            C0428b.m2002a(obj, view, i);
        }

        public void mo210d(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            C0428b.m2008d(obj, view, accessibilityEvent);
        }
    }

    static class C0347c extends C0344a {
        C0347c() {
        }

        public Object mo202a(final C0332a c0332a) {
            return C0431c.m2027a(new C0345a(this) {
                final /* synthetic */ C0347c f988b;

                public boolean mo215a(View view, AccessibilityEvent accessibilityEvent) {
                    return c0332a.m1300b(view, accessibilityEvent);
                }

                public void mo217b(View view, AccessibilityEvent accessibilityEvent) {
                    c0332a.mo189d(view, accessibilityEvent);
                }

                public void mo213a(View view, Object obj) {
                    c0332a.mo187a(view, new C0362b(obj));
                }

                public void mo218c(View view, AccessibilityEvent accessibilityEvent) {
                    c0332a.m1301c(view, accessibilityEvent);
                }

                public boolean mo216a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                    return c0332a.m1299a(viewGroup, view, accessibilityEvent);
                }

                public void mo212a(View view, int i) {
                    c0332a.m1295a(view, i);
                }

                public void mo219d(View view, AccessibilityEvent accessibilityEvent) {
                    c0332a.m1297a(view, accessibilityEvent);
                }

                public Object mo211a(View view) {
                    C0373e a = c0332a.m1293a(view);
                    return a != null ? a.m1552a() : null;
                }

                public boolean mo214a(View view, int i, Bundle bundle) {
                    return c0332a.mo188a(view, i, bundle);
                }
            });
        }

        public C0373e mo200a(Object obj, View view) {
            Object a = C0431c.m2028a(obj, view);
            if (a != null) {
                return new C0373e(a);
            }
            return null;
        }

        public boolean mo205a(Object obj, View view, int i, Bundle bundle) {
            return C0431c.m2029a(obj, view, i, bundle);
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            f931b = new C0347c();
        } else if (VERSION.SDK_INT >= 14) {
            f931b = new C0344a();
        } else {
            f931b = new C0343d();
        }
    }

    Object m1294a() {
        return this.f933a;
    }

    public void m1295a(View view, int i) {
        f931b.mo203a(f932c, view, i);
    }

    public void m1297a(View view, AccessibilityEvent accessibilityEvent) {
        f931b.mo210d(f932c, view, accessibilityEvent);
    }

    public boolean m1300b(View view, AccessibilityEvent accessibilityEvent) {
        return f931b.mo206a(f932c, view, accessibilityEvent);
    }

    public void m1301c(View view, AccessibilityEvent accessibilityEvent) {
        f931b.mo209c(f932c, view, accessibilityEvent);
    }

    public void mo189d(View view, AccessibilityEvent accessibilityEvent) {
        f931b.mo208b(f932c, view, accessibilityEvent);
    }

    public void mo187a(View view, C0362b c0362b) {
        f931b.mo204a(f932c, view, c0362b);
    }

    public boolean m1299a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return f931b.mo207a(f932c, viewGroup, view, accessibilityEvent);
    }

    public C0373e m1293a(View view) {
        return f931b.mo200a(f932c, view);
    }

    public boolean mo188a(View view, int i, Bundle bundle) {
        return f931b.mo205a(f932c, view, i, bundle);
    }
}
