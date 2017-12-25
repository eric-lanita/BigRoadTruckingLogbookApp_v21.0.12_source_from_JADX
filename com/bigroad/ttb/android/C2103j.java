package com.bigroad.ttb.android;

import com.bigroad.shared.aa;
import com.bigroad.shared.am;
import com.bigroad.shared.duty.C0907o;
import com.bigroad.shared.p022b.C0848a;
import com.bigroad.ttb.android.C2474y.C1182a;
import com.bigroad.ttb.android.C2474y.C1183b;
import com.bigroad.ttb.android.event.EventManager;
import com.bigroad.ttb.android.event.EventManager.C1199e;
import com.bigroad.ttb.android.event.EventManager.ChangeListener;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.p029c.C1736b;
import com.bigroad.ttb.android.p029c.C1736b.C1219a;
import com.bigroad.ttb.android.p034b.C1727a;
import com.bigroad.ttb.android.p035d.C1790a;
import com.bigroad.ttb.protocol.TTProtocol.Correction;
import com.bigroad.ttb.protocol.TTProtocol.CorrectionList;
import com.bigroad.ttb.protocol.TTProtocol.Delta;
import com.google.protobuf.C3642c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class C2103j {
    private static C2103j f7334a;
    private static final Comparator<Correction> f7335m = new C21024();
    private final C2032f f7336b;
    private final C2474y f7337c;
    private final C1790a f7338d;
    private final C1736b f7339e;
    private final EventManager f7340f;
    private final Set<C1337a> f7341g = new HashSet();
    private final ArrayList<Correction> f7342h = new ArrayList();
    private C3642c f7343i;
    private final C1182a f7344j = new C20991(this);
    private final C1219a f7345k = new C21002(this);
    private final ChangeListener f7346l = new C21013(this);

    public interface C1337a {
        void mo956a(C2103j c2103j);
    }

    class C20991 extends C1183b {
        final /* synthetic */ C2103j f7331a;

        C20991(C2103j c2103j) {
            this.f7331a = c2103j;
        }

        public void mo863a(C2474y c2474y) {
            this.f7331a.m10526d();
        }

        public void mo866c(C2474y c2474y) {
            this.f7331a.m10526d();
        }
    }

    class C21002 implements C1219a {
        final /* synthetic */ C2103j f7332a;

        C21002(C2103j c2103j) {
            this.f7332a = c2103j;
        }

        public void mo904a(C1736b c1736b) {
            this.f7332a.m10529g();
        }
    }

    class C21013 extends C1199e {
        final /* synthetic */ C2103j f7333a;

        C21013(C2103j c2103j) {
            this.f7333a = c2103j;
        }

        public void mo884a(EventManager eventManager, boolean z) {
            this.f7333a.m10529g();
        }
    }

    static class C21024 implements Comparator<Correction> {
        C21024() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m10519a((Correction) obj, (Correction) obj2);
        }

        public int m10519a(Correction correction, Correction correction2) {
            int c = aa.m4141c(correction.getSuggestedAt(), correction2.getSuggestedAt());
            Delta a = C0848a.m4260a(correction.getDelta());
            Delta a2 = C0848a.m4260a(correction2.getDelta());
            if (a == null || a2 == null) {
                return c;
            }
            int c2 = aa.m4140c(a.getStartLogDay(), a2.getStartLogDay());
            return c2 != 0 ? c2 : c;
        }
    }

    public static C2103j m10520a(C2032f c2032f) {
        if (f7334a == null) {
            f7334a = new C2103j(c2032f);
        }
        return f7334a;
    }

    private C2103j(C2032f c2032f) {
        this.f7336b = c2032f;
        this.f7337c = this.f7336b.mo1295c();
        this.f7338d = this.f7336b.mo1297e();
        this.f7339e = this.f7336b.mo1302j();
        this.f7340f = this.f7336b.mo1301i();
        this.f7337c.m12184a(this.f7344j);
        this.f7339e.m8474a(this.f7345k);
        this.f7340f.m10012a(this.f7346l);
        m10525c();
    }

    private void m10525c() {
        this.f7342h.clear();
        this.f7342h.addAll(this.f7338d.m8712G());
        Collections.sort(this.f7342h, f7335m);
    }

    private void m10526d() {
        this.f7343i = null;
        this.f7342h.clear();
        this.f7338d.m8713H();
        m10527e();
    }

    public void m10534a(C1337a c1337a) {
        this.f7341g.add(c1337a);
    }

    public void m10539b(C1337a c1337a) {
        this.f7341g.remove(c1337a);
    }

    private void m10527e() {
        for (C1337a a : (C1337a[]) this.f7341g.toArray(new C1337a[this.f7341g.size()])) {
            a.mo956a(this);
        }
    }

    public C3642c m10532a() {
        return this.f7343i;
    }

    public void m10535a(C3642c c3642c, C3642c c3642c2) {
        if (!c3642c.equals(this.f7343i)) {
            try {
                CorrectionList parseFrom = CorrectionList.parseFrom(c3642c2);
                this.f7343i = c3642c;
                this.f7342h.clear();
                this.f7342h.addAll(parseFrom.getCorrectionList());
                this.f7338d.m8802n(this.f7342h);
                Collections.sort(this.f7342h, f7335m);
                m10527e();
            } catch (Throwable e) {
                C2134e.m10681d("TT-CorrectionManager", "Can't parse Correction list", e);
            }
        }
    }

    private Set<Integer> m10528f() {
        Set<Integer> hashSet = new HashSet();
        int b = this.f7339e.m8479b();
        Iterator it = this.f7342h.iterator();
        while (it.hasNext()) {
            Delta a = C0848a.m4260a(((Correction) it.next()).getDelta());
            if (a == null) {
                C2134e.m10682e("TT-CorrectionManager", "Can't parse correction.");
            } else {
                int startLogDay = a.getStartLogDay();
                if (startLogDay >= b) {
                    hashSet.add(Integer.valueOf(startLogDay));
                }
            }
        }
        return hashSet;
    }

    public Correction m10530a(int i) {
        Iterator it = this.f7342h.iterator();
        while (it.hasNext()) {
            Correction correction = (Correction) it.next();
            Delta a = C0848a.m4260a(correction.getDelta());
            if (a == null) {
                C2134e.m10682e("TT-CorrectionManager", "Can't parse correction.");
            } else if (a.getStartLogDay() == i) {
                return correction;
            }
        }
        return null;
    }

    public long m10537b(int i) {
        Correction a = m10530a(i);
        return a != null ? a.getId() : -1;
    }

    public int m10536b() {
        return m10528f().size();
    }

    public boolean m10540c(int i) {
        return m10528f().contains(Integer.valueOf(i));
    }

    public Correction m10531a(long j) {
        Iterator it = this.f7342h.iterator();
        while (it.hasNext()) {
            Correction correction = (Correction) it.next();
            if (correction.getId() == j) {
                return correction;
            }
        }
        return null;
    }

    public void m10538b(long j) {
        Delta a;
        Correction a2 = m10531a(j);
        if (a2 != null) {
            a = C0848a.m4260a(a2.getDelta());
        } else {
            a = null;
        }
        if (a != null) {
            C1736b j2 = this.f7336b.mo1302j();
            EventManager i = this.f7336b.mo1301i();
            C1727a c1727a = new C1727a(this.f7336b, j2.m8492f(), i.m10025b());
            if (c1727a.m8443a(a2, a)) {
                m10521a(j, true, null);
                j2.m8478a(c1727a.m8442a());
                i.m10017a(c1727a.m8444b());
            }
        }
    }

    public void m10533a(long j, String str) {
        if (am.m4188a((CharSequence) str)) {
            C2134e.m10680d("TT-CorrectionManager", "Attempt to reject correction without a provided reason.");
        } else {
            m10521a(j, false, str);
        }
    }

    private void m10521a(long j, boolean z, String str) {
        Correction a = m10531a(j);
        if (a == null) {
            C2134e.m10680d("TT-CorrectionManager", "Given correction to acknowledge is unexpectedly null.");
            return;
        }
        this.f7338d.m8785g(j);
        this.f7342h.remove(a);
        this.f7336b.mo1298f().m6465a(a, z, str);
        m10527e();
    }

    private void m10523a(Correction correction) {
        this.f7338d.m8785g(correction.getId());
        this.f7342h.remove(correction);
        this.f7343i = null;
        m10527e();
    }

    public String m10541d(int i) {
        Correction a = m10530a(i);
        if (a != null) {
            return a.getSuggestorDisplayName();
        }
        return null;
    }

    private void m10529g() {
        Correction a = m10530a(C0907o.m4579a(this.f7337c.m12228r().m4879m()).a_());
        if (a != null && this.f7337c.m12222l() != null) {
            Delta a2 = C0848a.m4260a(a.getDelta());
            if (a2 == null) {
                m10523a(a);
            } else if (!new C1727a(this.f7336b, this.f7339e.m8492f(), this.f7340f.m10025b()).m8443a(a, a2)) {
                m10523a(a);
            }
        }
    }
}
