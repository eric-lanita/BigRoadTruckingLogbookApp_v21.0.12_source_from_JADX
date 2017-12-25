package android.support.v4.view.p009a;

import android.graphics.Rect;
import android.os.Build.VERSION;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;

public class C0362b {
    private static final C0353d f990a;
    private final Object f991b;

    interface C0353d {
        int mo220a(Object obj);

        void mo221a(Object obj, int i);

        void mo222a(Object obj, Rect rect);

        void mo223a(Object obj, CharSequence charSequence);

        void mo224a(Object obj, boolean z);

        CharSequence mo225b(Object obj);

        void mo226b(Object obj, Rect rect);

        CharSequence mo227c(Object obj);

        CharSequence mo228d(Object obj);

        CharSequence mo229e(Object obj);

        boolean mo230f(Object obj);

        boolean mo231g(Object obj);

        boolean mo232h(Object obj);

        boolean mo233i(Object obj);

        boolean mo234j(Object obj);

        boolean mo235k(Object obj);

        boolean mo236l(Object obj);

        boolean mo237m(Object obj);

        boolean mo238n(Object obj);

        boolean mo239o(Object obj);

        String mo240p(Object obj);
    }

    static class C0354i implements C0353d {
        C0354i() {
        }

        public void mo221a(Object obj, int i) {
        }

        public int mo220a(Object obj) {
            return 0;
        }

        public void mo222a(Object obj, Rect rect) {
        }

        public void mo226b(Object obj, Rect rect) {
        }

        public CharSequence mo225b(Object obj) {
            return null;
        }

        public CharSequence mo227c(Object obj) {
            return null;
        }

        public CharSequence mo228d(Object obj) {
            return null;
        }

        public CharSequence mo229e(Object obj) {
            return null;
        }

        public boolean mo230f(Object obj) {
            return false;
        }

        public boolean mo231g(Object obj) {
            return false;
        }

        public boolean mo232h(Object obj) {
            return false;
        }

        public boolean mo233i(Object obj) {
            return false;
        }

        public boolean mo234j(Object obj) {
            return false;
        }

        public boolean mo235k(Object obj) {
            return false;
        }

        public boolean mo236l(Object obj) {
            return false;
        }

        public boolean mo237m(Object obj) {
            return false;
        }

        public boolean mo238n(Object obj) {
            return false;
        }

        public boolean mo239o(Object obj) {
            return false;
        }

        public void mo223a(Object obj, CharSequence charSequence) {
        }

        public void mo224a(Object obj, boolean z) {
        }

        public String mo240p(Object obj) {
            return null;
        }
    }

    static class C0355c extends C0354i {
        C0355c() {
        }

        public void mo221a(Object obj, int i) {
            C0363c.m1513a(obj, i);
        }

        public int mo220a(Object obj) {
            return C0363c.m1512a(obj);
        }

        public void mo222a(Object obj, Rect rect) {
            C0363c.m1514a(obj, rect);
        }

        public void mo226b(Object obj, Rect rect) {
            C0363c.m1518b(obj, rect);
        }

        public CharSequence mo225b(Object obj) {
            return C0363c.m1517b(obj);
        }

        public CharSequence mo227c(Object obj) {
            return C0363c.m1519c(obj);
        }

        public CharSequence mo228d(Object obj) {
            return C0363c.m1520d(obj);
        }

        public CharSequence mo229e(Object obj) {
            return C0363c.m1521e(obj);
        }

        public boolean mo230f(Object obj) {
            return C0363c.m1522f(obj);
        }

        public boolean mo231g(Object obj) {
            return C0363c.m1523g(obj);
        }

        public boolean mo232h(Object obj) {
            return C0363c.m1524h(obj);
        }

        public boolean mo233i(Object obj) {
            return C0363c.m1525i(obj);
        }

        public boolean mo234j(Object obj) {
            return C0363c.m1526j(obj);
        }

        public boolean mo235k(Object obj) {
            return C0363c.m1527k(obj);
        }

        public boolean mo236l(Object obj) {
            return C0363c.m1528l(obj);
        }

        public boolean mo237m(Object obj) {
            return C0363c.m1529m(obj);
        }

        public boolean mo238n(Object obj) {
            return C0363c.m1530n(obj);
        }

        public boolean mo239o(Object obj) {
            return C0363c.m1531o(obj);
        }

        public void mo223a(Object obj, CharSequence charSequence) {
            C0363c.m1515a(obj, charSequence);
        }

        public void mo224a(Object obj, boolean z) {
            C0363c.m1516a(obj, z);
        }
    }

    static class C0356e extends C0355c {
        C0356e() {
        }
    }

    static class C0357f extends C0356e {
        C0357f() {
        }
    }

    static class C0358g extends C0357f {
        C0358g() {
        }

        public String mo240p(Object obj) {
            return C0364d.m1532a(obj);
        }
    }

    static class C0359h extends C0358g {
        C0359h() {
        }
    }

    static class C0360a extends C0359h {
        C0360a() {
        }
    }

    static class C0361b extends C0360a {
        C0361b() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 22) {
            f990a = new C0361b();
        } else if (VERSION.SDK_INT >= 21) {
            f990a = new C0360a();
        } else if (VERSION.SDK_INT >= 19) {
            f990a = new C0359h();
        } else if (VERSION.SDK_INT >= 18) {
            f990a = new C0358g();
        } else if (VERSION.SDK_INT >= 17) {
            f990a = new C0357f();
        } else if (VERSION.SDK_INT >= 16) {
            f990a = new C0356e();
        } else if (VERSION.SDK_INT >= 14) {
            f990a = new C0355c();
        } else {
            f990a = new C0354i();
        }
    }

    public C0362b(Object obj) {
        this.f991b = obj;
    }

    public Object m1490a() {
        return this.f991b;
    }

    public int m1495b() {
        return f990a.mo220a(this.f991b);
    }

    public void m1491a(int i) {
        f990a.mo221a(this.f991b, i);
    }

    public void m1492a(Rect rect) {
        f990a.mo222a(this.f991b, rect);
    }

    public void m1496b(Rect rect) {
        f990a.mo226b(this.f991b, rect);
    }

    public boolean m1497c() {
        return f990a.mo230f(this.f991b);
    }

    public boolean m1498d() {
        return f990a.mo231g(this.f991b);
    }

    public boolean m1499e() {
        return f990a.mo234j(this.f991b);
    }

    public boolean m1500f() {
        return f990a.mo235k(this.f991b);
    }

    public boolean m1501g() {
        return f990a.mo239o(this.f991b);
    }

    public boolean m1502h() {
        return f990a.mo232h(this.f991b);
    }

    public boolean m1503i() {
        return f990a.mo236l(this.f991b);
    }

    public boolean m1504j() {
        return f990a.mo233i(this.f991b);
    }

    public boolean m1505k() {
        return f990a.mo237m(this.f991b);
    }

    public boolean m1506l() {
        return f990a.mo238n(this.f991b);
    }

    public void m1494a(boolean z) {
        f990a.mo224a(this.f991b, z);
    }

    public CharSequence m1507m() {
        return f990a.mo228d(this.f991b);
    }

    public CharSequence m1508n() {
        return f990a.mo225b(this.f991b);
    }

    public void m1493a(CharSequence charSequence) {
        f990a.mo223a(this.f991b, charSequence);
    }

    public CharSequence m1509o() {
        return f990a.mo229e(this.f991b);
    }

    public CharSequence m1510p() {
        return f990a.mo227c(this.f991b);
    }

    public String m1511q() {
        return f990a.mo240p(this.f991b);
    }

    public int hashCode() {
        return this.f991b == null ? 0 : this.f991b.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        C0362b c0362b = (C0362b) obj;
        if (this.f991b == null) {
            if (c0362b.f991b != null) {
                return false;
            }
            return true;
        } else if (this.f991b.equals(c0362b.f991b)) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        Rect rect = new Rect();
        m1492a(rect);
        stringBuilder.append("; boundsInParent: " + rect);
        m1496b(rect);
        stringBuilder.append("; boundsInScreen: " + rect);
        stringBuilder.append("; packageName: ").append(m1507m());
        stringBuilder.append("; className: ").append(m1508n());
        stringBuilder.append("; text: ").append(m1509o());
        stringBuilder.append("; contentDescription: ").append(m1510p());
        stringBuilder.append("; viewId: ").append(m1511q());
        stringBuilder.append("; checkable: ").append(m1497c());
        stringBuilder.append("; checked: ").append(m1498d());
        stringBuilder.append("; focusable: ").append(m1499e());
        stringBuilder.append("; focused: ").append(m1500f());
        stringBuilder.append("; selected: ").append(m1501g());
        stringBuilder.append("; clickable: ").append(m1502h());
        stringBuilder.append("; longClickable: ").append(m1503i());
        stringBuilder.append("; enabled: ").append(m1504j());
        stringBuilder.append("; password: ").append(m1505k());
        stringBuilder.append("; scrollable: " + m1506l());
        stringBuilder.append("; [");
        int b = m1495b();
        while (b != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(b);
            b &= numberOfTrailingZeros ^ -1;
            stringBuilder.append(C0362b.m1489b(numberOfTrailingZeros));
            if (b != 0) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private static String m1489b(int i) {
        switch (i) {
            case 1:
                return "ACTION_FOCUS";
            case 2:
                return "ACTION_CLEAR_FOCUS";
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case Utility.DEFAULT_STREAM_BUFFER_SIZE /*8192*/:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST /*65536*/:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }
}
