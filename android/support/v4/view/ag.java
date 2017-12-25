package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import java.util.WeakHashMap;

public final class ag {
    static final C0389m f1007a;

    interface C0389m {
        int mo259a(int i, int i2, int i3);

        int mo260a(View view);

        be mo261a(View view, be beVar);

        void mo262a(View view, float f);

        void mo263a(View view, int i, int i2);

        void mo264a(View view, int i, Paint paint);

        void mo265a(View view, ColorStateList colorStateList);

        void mo266a(View view, Mode mode);

        void mo267a(View view, C0332a c0332a);

        void mo268a(View view, aa aaVar);

        void mo269a(View view, Runnable runnable);

        void mo270a(View view, Runnable runnable, long j);

        void mo271a(View view, boolean z);

        void mo272a(ViewGroup viewGroup, boolean z);

        boolean mo273a(View view, int i);

        be mo274b(View view, be beVar);

        void mo275b(View view);

        void mo276b(View view, float f);

        void mo277b(View view, boolean z);

        boolean mo278b(View view, int i);

        int mo279c(View view);

        void mo280c(View view, float f);

        void mo281c(View view, int i);

        int mo282d(View view);

        void mo283d(View view, float f);

        void mo284d(View view, int i);

        int mo285e(View view);

        void mo286e(View view, float f);

        void mo287e(View view, int i);

        int mo288f(View view);

        int mo289g(View view);

        boolean mo290h(View view);

        float mo291i(View view);

        float mo292j(View view);

        int mo293k(View view);

        ax mo294l(View view);

        int mo295m(View view);

        void mo296n(View view);

        boolean mo297o(View view);

        void mo298p(View view);

        boolean mo299q(View view);

        ColorStateList mo300r(View view);

        Mode mo301s(View view);

        void mo302t(View view);

        boolean mo303u(View view);

        boolean mo304v(View view);

        boolean mo305w(View view);
    }

    static class C0390a implements C0389m {
        WeakHashMap<View, ax> f1005a = null;

        C0390a() {
        }

        public boolean mo273a(View view, int i) {
            return (view instanceof ac) && m1673a((ac) view, i);
        }

        public boolean mo278b(View view, int i) {
            return (view instanceof ac) && m1674b((ac) view, i);
        }

        public int mo260a(View view) {
            return 2;
        }

        public void mo267a(View view, C0332a c0332a) {
        }

        public void mo275b(View view) {
            view.invalidate();
        }

        public void mo269a(View view, Runnable runnable) {
            view.postDelayed(runnable, mo306a());
        }

        public void mo270a(View view, Runnable runnable, long j) {
            view.postDelayed(runnable, mo306a() + j);
        }

        long mo306a() {
            return 10;
        }

        public int mo279c(View view) {
            return 0;
        }

        public void mo281c(View view, int i) {
        }

        public void mo264a(View view, int i, Paint paint) {
        }

        public int mo282d(View view) {
            return 0;
        }

        public int mo285e(View view) {
            return 0;
        }

        public int mo259a(int i, int i2, int i3) {
            return View.resolveSize(i, i2);
        }

        public int mo288f(View view) {
            return view.getMeasuredWidth();
        }

        public int mo289g(View view) {
            return 0;
        }

        public boolean mo290h(View view) {
            return true;
        }

        public float mo291i(View view) {
            return 0.0f;
        }

        public float mo292j(View view) {
            return 0.0f;
        }

        public int mo293k(View view) {
            return ah.m1831d(view);
        }

        public ax mo294l(View view) {
            return new ax(view);
        }

        public void mo262a(View view, float f) {
        }

        public void mo276b(View view, float f) {
        }

        public void mo280c(View view, float f) {
        }

        public void mo283d(View view, float f) {
        }

        public int mo295m(View view) {
            return 0;
        }

        public void mo296n(View view) {
        }

        public void mo286e(View view, float f) {
        }

        public void mo272a(ViewGroup viewGroup, boolean z) {
        }

        public boolean mo297o(View view) {
            return false;
        }

        public void mo298p(View view) {
        }

        public void mo268a(View view, aa aaVar) {
        }

        public be mo261a(View view, be beVar) {
            return beVar;
        }

        public be mo274b(View view, be beVar) {
            return beVar;
        }

        public void mo271a(View view, boolean z) {
        }

        public void mo277b(View view, boolean z) {
        }

        public boolean mo299q(View view) {
            if (view instanceof C0478w) {
                return ((C0478w) view).isNestedScrollingEnabled();
            }
            return false;
        }

        public ColorStateList mo300r(View view) {
            return ah.m1824a(view);
        }

        public void mo265a(View view, ColorStateList colorStateList) {
            ah.m1826a(view, colorStateList);
        }

        public void mo266a(View view, Mode mode) {
            ah.m1827a(view, mode);
        }

        public Mode mo301s(View view) {
            return ah.m1828b(view);
        }

        private boolean m1673a(ac acVar, int i) {
            int computeHorizontalScrollOffset = acVar.computeHorizontalScrollOffset();
            int computeHorizontalScrollRange = acVar.computeHorizontalScrollRange() - acVar.computeHorizontalScrollExtent();
            if (computeHorizontalScrollRange == 0) {
                return false;
            }
            if (i < 0) {
                if (computeHorizontalScrollOffset <= 0) {
                    return false;
                }
                return true;
            } else if (computeHorizontalScrollOffset >= computeHorizontalScrollRange - 1) {
                return false;
            } else {
                return true;
            }
        }

        private boolean m1674b(ac acVar, int i) {
            int computeVerticalScrollOffset = acVar.computeVerticalScrollOffset();
            int computeVerticalScrollRange = acVar.computeVerticalScrollRange() - acVar.computeVerticalScrollExtent();
            if (computeVerticalScrollRange == 0) {
                return false;
            }
            if (i < 0) {
                if (computeVerticalScrollOffset <= 0) {
                    return false;
                }
                return true;
            } else if (computeVerticalScrollOffset >= computeVerticalScrollRange - 1) {
                return false;
            } else {
                return true;
            }
        }

        public void mo302t(View view) {
            if (view instanceof C0478w) {
                ((C0478w) view).stopNestedScroll();
            }
        }

        public boolean mo303u(View view) {
            return ah.m1830c(view);
        }

        public boolean mo304v(View view) {
            return ah.m1832e(view);
        }

        public boolean mo305w(View view) {
            return false;
        }

        public void mo263a(View view, int i, int i2) {
        }

        public void mo284d(View view, int i) {
            ah.m1829b(view, i);
        }

        public void mo287e(View view, int i) {
            ah.m1825a(view, i);
        }
    }

    static class C0391b extends C0390a {
        C0391b() {
        }

        public void mo272a(ViewGroup viewGroup, boolean z) {
            ai.m1833a(viewGroup, z);
        }
    }

    static class C0392c extends C0391b {
        C0392c() {
        }

        public int mo260a(View view) {
            return aj.m1834a(view);
        }
    }

    static class C0393d extends C0392c {
        C0393d() {
        }

        long mo306a() {
            return ak.m1837a();
        }

        public void mo264a(View view, int i, Paint paint) {
            ak.m1840a(view, i, paint);
        }

        public int mo282d(View view) {
            return ak.m1836a(view);
        }

        public int mo259a(int i, int i2, int i3) {
            return ak.m1835a(i, i2, i3);
        }

        public int mo288f(View view) {
            return ak.m1842b(view);
        }

        public int mo289g(View view) {
            return ak.m1846c(view);
        }

        public float mo291i(View view) {
            return ak.m1848d(view);
        }

        public void mo262a(View view, float f) {
            ak.m1838a(view, f);
        }

        public void mo276b(View view, float f) {
            ak.m1843b(view, f);
        }

        public void mo280c(View view, float f) {
            ak.m1847c(view, f);
        }

        public void mo283d(View view, float f) {
            ak.m1849d(view, f);
        }

        public float mo292j(View view) {
            return ak.m1850e(view);
        }

        public void mo298p(View view) {
            ak.m1851f(view);
        }

        public void mo271a(View view, boolean z) {
            ak.m1841a(view, z);
        }

        public void mo277b(View view, boolean z) {
            ak.m1845b(view, z);
        }

        public void mo284d(View view, int i) {
            ak.m1844b(view, i);
        }

        public void mo287e(View view, int i) {
            ak.m1839a(view, i);
        }
    }

    static class C0394f extends C0393d {
        static boolean f1006b = false;

        C0394f() {
        }

        public boolean mo273a(View view, int i) {
            return al.m1854a(view, i);
        }

        public boolean mo278b(View view, int i) {
            return al.m1855b(view, i);
        }

        public void mo267a(View view, C0332a c0332a) {
            al.m1853a(view, c0332a == null ? null : c0332a.m1294a());
        }

        public ax mo294l(View view) {
            if (this.a == null) {
                this.a = new WeakHashMap();
            }
            ax axVar = (ax) this.a.get(view);
            if (axVar != null) {
                return axVar;
            }
            axVar = new ax(view);
            this.a.put(view, axVar);
            return axVar;
        }
    }

    static class C0395e extends C0394f {
        C0395e() {
        }

        public boolean mo305w(View view) {
            return am.m1856a(view);
        }
    }

    static class C0396g extends C0395e {
        C0396g() {
        }

        public void mo275b(View view) {
            an.m1857a(view);
        }

        public void mo269a(View view, Runnable runnable) {
            an.m1859a(view, runnable);
        }

        public void mo270a(View view, Runnable runnable, long j) {
            an.m1860a(view, runnable, j);
        }

        public int mo279c(View view) {
            return an.m1861b(view);
        }

        public void mo281c(View view, int i) {
            if (i == 4) {
                i = 2;
            }
            an.m1858a(view, i);
        }

        public int mo293k(View view) {
            return an.m1862c(view);
        }

        public void mo296n(View view) {
            an.m1863d(view);
        }

        public boolean mo297o(View view) {
            return an.m1864e(view);
        }

        public boolean mo290h(View view) {
            return an.m1865f(view);
        }
    }

    static class C0397h extends C0396g {
        C0397h() {
        }

        public int mo285e(View view) {
            return ao.m1866a(view);
        }

        public int mo295m(View view) {
            return ao.m1867b(view);
        }
    }

    static class C0398i extends C0397h {
        C0398i() {
        }
    }

    static class C0399j extends C0398i {
        C0399j() {
        }

        public void mo281c(View view, int i) {
            an.m1858a(view, i);
        }

        public boolean mo303u(View view) {
            return ap.m1868a(view);
        }

        public boolean mo304v(View view) {
            return ap.m1869b(view);
        }
    }

    static class C0400k extends C0399j {
        C0400k() {
        }

        public void mo296n(View view) {
            aq.m1872a(view);
        }

        public void mo286e(View view, float f) {
            aq.m1873a(view, f);
        }

        public void mo268a(View view, aa aaVar) {
            aq.m1877a(view, aaVar);
        }

        public boolean mo299q(View view) {
            return aq.m1882d(view);
        }

        public void mo302t(View view) {
            aq.m1883e(view);
        }

        public ColorStateList mo300r(View view) {
            return aq.m1878b(view);
        }

        public void mo265a(View view, ColorStateList colorStateList) {
            aq.m1875a(view, colorStateList);
        }

        public void mo266a(View view, Mode mode) {
            aq.m1876a(view, mode);
        }

        public Mode mo301s(View view) {
            return aq.m1881c(view);
        }

        public be mo261a(View view, be beVar) {
            return aq.m1871a(view, beVar);
        }

        public be mo274b(View view, be beVar) {
            return aq.m1879b(view, beVar);
        }

        public void mo284d(View view, int i) {
            aq.m1880b(view, i);
        }

        public void mo287e(View view, int i) {
            aq.m1874a(view, i);
        }
    }

    static class C0401l extends C0400k {
        C0401l() {
        }

        public void mo263a(View view, int i, int i2) {
            ar.m1885a(view, i, i2);
        }

        public void mo284d(View view, int i) {
            ar.m1886b(view, i);
        }

        public void mo287e(View view, int i) {
            ar.m1884a(view, i);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            f1007a = new C0401l();
        } else if (i >= 21) {
            f1007a = new C0400k();
        } else if (i >= 19) {
            f1007a = new C0399j();
        } else if (i >= 17) {
            f1007a = new C0397h();
        } else if (i >= 16) {
            f1007a = new C0396g();
        } else if (i >= 15) {
            f1007a = new C0395e();
        } else if (i >= 14) {
            f1007a = new C0394f();
        } else if (i >= 11) {
            f1007a = new C0393d();
        } else if (i >= 9) {
            f1007a = new C0392c();
        } else if (i >= 7) {
            f1007a = new C0391b();
        } else {
            f1007a = new C0390a();
        }
    }

    public static boolean m1791a(View view, int i) {
        return f1007a.mo273a(view, i);
    }

    public static boolean m1796b(View view, int i) {
        return f1007a.mo278b(view, i);
    }

    public static int m1778a(View view) {
        return f1007a.mo260a(view);
    }

    public static void m1785a(View view, C0332a c0332a) {
        f1007a.mo267a(view, c0332a);
    }

    public static void m1793b(View view) {
        f1007a.mo275b(view);
    }

    public static void m1787a(View view, Runnable runnable) {
        f1007a.mo269a(view, runnable);
    }

    public static void m1788a(View view, Runnable runnable, long j) {
        f1007a.mo270a(view, runnable, j);
    }

    public static int m1797c(View view) {
        return f1007a.mo279c(view);
    }

    public static void m1799c(View view, int i) {
        f1007a.mo281c(view, i);
    }

    public static void m1782a(View view, int i, Paint paint) {
        f1007a.mo264a(view, i, paint);
    }

    public static int m1800d(View view) {
        return f1007a.mo282d(view);
    }

    public static int m1803e(View view) {
        return f1007a.mo285e(view);
    }

    public static int m1777a(int i, int i2, int i3) {
        return f1007a.mo259a(i, i2, i3);
    }

    public static int m1806f(View view) {
        return f1007a.mo288f(view);
    }

    public static int m1807g(View view) {
        return f1007a.mo289g(view);
    }

    public static float m1808h(View view) {
        return f1007a.mo291i(view);
    }

    public static int m1809i(View view) {
        return f1007a.mo293k(view);
    }

    public static ax m1810j(View view) {
        return f1007a.mo294l(view);
    }

    public static void m1780a(View view, float f) {
        f1007a.mo262a(view, f);
    }

    public static void m1794b(View view, float f) {
        f1007a.mo276b(view, f);
    }

    public static void m1798c(View view, float f) {
        f1007a.mo280c(view, f);
    }

    public static void m1801d(View view, float f) {
        f1007a.mo283d(view, f);
    }

    public static float m1811k(View view) {
        return f1007a.mo292j(view);
    }

    public static void m1804e(View view, float f) {
        f1007a.mo286e(view, f);
    }

    public static int m1812l(View view) {
        return f1007a.mo295m(view);
    }

    public static void m1813m(View view) {
        f1007a.mo296n(view);
    }

    public static void m1790a(ViewGroup viewGroup, boolean z) {
        f1007a.mo272a(viewGroup, z);
    }

    public static boolean m1814n(View view) {
        return f1007a.mo297o(view);
    }

    public static void m1815o(View view) {
        f1007a.mo298p(view);
    }

    public static void m1786a(View view, aa aaVar) {
        f1007a.mo268a(view, aaVar);
    }

    public static be m1779a(View view, be beVar) {
        return f1007a.mo261a(view, beVar);
    }

    public static be m1792b(View view, be beVar) {
        return f1007a.mo274b(view, beVar);
    }

    public static void m1789a(View view, boolean z) {
        f1007a.mo271a(view, z);
    }

    public static void m1795b(View view, boolean z) {
        f1007a.mo277b(view, z);
    }

    public static boolean m1816p(View view) {
        return f1007a.mo290h(view);
    }

    public static ColorStateList m1817q(View view) {
        return f1007a.mo300r(view);
    }

    public static void m1783a(View view, ColorStateList colorStateList) {
        f1007a.mo265a(view, colorStateList);
    }

    public static Mode m1818r(View view) {
        return f1007a.mo301s(view);
    }

    public static void m1784a(View view, Mode mode) {
        f1007a.mo266a(view, mode);
    }

    public static boolean m1819s(View view) {
        return f1007a.mo299q(view);
    }

    public static void m1820t(View view) {
        f1007a.mo302t(view);
    }

    public static boolean m1821u(View view) {
        return f1007a.mo303u(view);
    }

    public static void m1802d(View view, int i) {
        f1007a.mo287e(view, i);
    }

    public static void m1805e(View view, int i) {
        f1007a.mo284d(view, i);
    }

    public static boolean m1822v(View view) {
        return f1007a.mo304v(view);
    }

    public static boolean m1823w(View view) {
        return f1007a.mo305w(view);
    }

    public static void m1781a(View view, int i, int i2) {
        f1007a.mo263a(view, i, i2);
    }
}
