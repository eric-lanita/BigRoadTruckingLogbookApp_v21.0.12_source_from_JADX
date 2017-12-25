package android.support.v4.view.p009a;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.p009a.C0375f.C0366a;
import android.support.v4.view.p009a.C0377g.C0370a;
import java.util.ArrayList;
import java.util.List;

public class C0373e {
    private static final C0365a f996a;
    private final Object f997b;

    interface C0365a {
        Object mo244a(C0373e c0373e);
    }

    static class C0368d implements C0365a {
        C0368d() {
        }

        public Object mo244a(C0373e c0373e) {
            return null;
        }
    }

    static class C0369b extends C0368d {
        C0369b() {
        }

        public Object mo244a(final C0373e c0373e) {
            return C0375f.m1556a(new C0366a(this) {
                final /* synthetic */ C0369b f993b;

                public boolean mo243a(int i, int i2, Bundle bundle) {
                    return c0373e.m1554a(i, i2, bundle);
                }

                public List<Object> mo242a(String str, int i) {
                    List a = c0373e.m1553a(str, i);
                    List<Object> arrayList = new ArrayList();
                    int size = a.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        arrayList.add(((C0362b) a.get(i2)).m1490a());
                    }
                    return arrayList;
                }

                public Object mo241a(int i) {
                    C0362b a = c0373e.m1551a(i);
                    if (a == null) {
                        return null;
                    }
                    return a.m1490a();
                }
            });
        }
    }

    static class C0372c extends C0368d {
        C0372c() {
        }

        public Object mo244a(final C0373e c0373e) {
            return C0377g.m1557a(new C0370a(this) {
                final /* synthetic */ C0372c f995b;

                public boolean mo247a(int i, int i2, Bundle bundle) {
                    return c0373e.m1554a(i, i2, bundle);
                }

                public List<Object> mo246a(String str, int i) {
                    List a = c0373e.m1553a(str, i);
                    List<Object> arrayList = new ArrayList();
                    int size = a.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        arrayList.add(((C0362b) a.get(i2)).m1490a());
                    }
                    return arrayList;
                }

                public Object mo245a(int i) {
                    C0362b a = c0373e.m1551a(i);
                    if (a == null) {
                        return null;
                    }
                    return a.m1490a();
                }

                public Object mo248b(int i) {
                    C0362b b = c0373e.m1555b(i);
                    if (b == null) {
                        return null;
                    }
                    return b.m1490a();
                }
            });
        }
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            f996a = new C0372c();
        } else if (VERSION.SDK_INT >= 16) {
            f996a = new C0369b();
        } else {
            f996a = new C0368d();
        }
    }

    public C0373e() {
        this.f997b = f996a.mo244a(this);
    }

    public C0373e(Object obj) {
        this.f997b = obj;
    }

    public Object m1552a() {
        return this.f997b;
    }

    public C0362b m1551a(int i) {
        return null;
    }

    public boolean m1554a(int i, int i2, Bundle bundle) {
        return false;
    }

    public List<C0362b> m1553a(String str, int i) {
        return null;
    }

    public C0362b m1555b(int i) {
        return null;
    }
}
