package com.bigroad.ttb.android;

import android.content.Context;
import com.bigroad.shared.C1180y;
import com.bigroad.shared.p023c.C0854a;
import com.bigroad.ttb.android.C2474y.C1182a;
import com.bigroad.ttb.android.C2474y.C1183b;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.p035d.C1790a;
import com.bigroad.ttb.protocol.TTProtocol.Dvir;
import com.bigroad.ttb.protocol.TTProtocol.Dvir.C2630a;
import com.bigroad.ttb.protocol.TTProtocol.DvirInspection;
import com.bigroad.ttb.protocol.TTProtocol.DvirList;
import com.google.protobuf.C3642c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class C2226q {
    private static C2226q f7711a;
    private final C2474y f7712b = OurApplication.m6285g();
    private final C1790a f7713c = OurApplication.m6287i();
    private final Set<C1221a> f7714d = new HashSet();
    private final ArrayList<Dvir> f7715e = new ArrayList();
    private C3642c f7716f;
    private final C1182a f7717g = new C22251(this);

    public interface C1221a {
        void mo905a(C2226q c2226q);
    }

    class C22251 extends C1183b {
        final /* synthetic */ C2226q f7710a;

        C22251(C2226q c2226q) {
            this.f7710a = c2226q;
        }

        public void mo863a(C2474y c2474y) {
            this.f7710a.m10968f();
        }
    }

    public static C2226q m10963a(Context context) {
        if (f7711a == null) {
            f7711a = new C2226q();
        }
        return f7711a;
    }

    private C2226q() {
        this.f7712b.m12184a(this.f7717g);
        m10967e();
    }

    private SyncManager m10966d() {
        return OurApplication.m6289k();
    }

    private void m10967e() {
        this.f7715e.clear();
        this.f7715e.addAll(this.f7713c.m8809u());
        Collections.sort(this.f7715e, C0854a.f2650a);
    }

    private void m10968f() {
        this.f7716f = null;
        this.f7715e.clear();
        this.f7713c.m8810v();
        m10969g();
    }

    public void m10974a(C1221a c1221a) {
        this.f7714d.add(c1221a);
    }

    public void m10982b(C1221a c1221a) {
        this.f7714d.remove(c1221a);
    }

    private void m10969g() {
        for (C1221a a : (C1221a[]) this.f7714d.toArray(new C1221a[this.f7714d.size()])) {
            a.mo905a(this);
        }
    }

    public C3642c m10972a() {
        return this.f7716f;
    }

    public void m10977a(C3642c c3642c, C3642c c3642c2) {
        if (!c3642c.equals(this.f7716f)) {
            try {
                DvirList parseFrom = DvirList.parseFrom(c3642c2);
                this.f7716f = c3642c;
                this.f7715e.clear();
                this.f7715e.addAll(parseFrom.getDvirList());
                this.f7713c.m8789h(this.f7715e);
                Collections.sort(this.f7715e, C0854a.f2650a);
                m10969g();
            } catch (Throwable e) {
                C2134e.m10681d("TT-DvirManager", "Can't parse DVIR list", e);
            }
        }
    }

    public int m10980b() {
        if (this.f7715e.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        return ((Dvir) this.f7715e.get(0)).getLogDay();
    }

    public List<Dvir> m10973a(int i) {
        List<Dvir> arrayList = new ArrayList();
        Iterator it = this.f7715e.iterator();
        while (it.hasNext()) {
            Dvir dvir = (Dvir) it.next();
            if (dvir.getLogDay() == i) {
                arrayList.add(dvir);
            }
        }
        return arrayList;
    }

    public List<Dvir> m10981b(int i) {
        int size = this.f7715e.size();
        int i2 = 0;
        while (i2 < size && ((Dvir) this.f7715e.get(i2)).getLogDay() < i) {
            i2++;
        }
        if (i2 == 0) {
            return Collections.emptyList();
        }
        return m10973a(((Dvir) this.f7715e.get(i2 - 1)).getLogDay());
    }

    public List<Dvir> m10988c(int i) {
        int size = this.f7715e.size();
        int i2 = size - 1;
        while (i2 >= 0 && ((Dvir) this.f7715e.get(i2)).getLogDay() > i) {
            i2--;
        }
        if (i2 == size - 1) {
            return Collections.emptyList();
        }
        return m10973a(((Dvir) this.f7715e.get(i2 + 1)).getLogDay());
    }

    public Long m10989d(int i) {
        Long l = null;
        for (Dvir inspectionList : m10973a(i)) {
            for (DvirInspection dvirInspection : inspectionList.getInspectionList()) {
                Long valueOf;
                if (l == null || (dvirInspection.hasOccurredAt() && dvirInspection.getOccurredAt() > l.longValue())) {
                    valueOf = Long.valueOf(dvirInspection.getOccurredAt());
                } else {
                    valueOf = l;
                }
                l = valueOf;
            }
        }
        return l;
    }

    public Dvir m10971a(C3642c c3642c) {
        if (c3642c == null) {
            return null;
        }
        Iterator it = this.f7715e.iterator();
        while (it.hasNext()) {
            Dvir dvir = (Dvir) it.next();
            if (c3642c.equals(dvir.getId())) {
                return dvir;
            }
        }
        return null;
    }

    public Dvir m10970a(DvirInspection dvirInspection) {
        if (dvirInspection == null) {
            return null;
        }
        Iterator it = this.f7715e.iterator();
        while (it.hasNext()) {
            Dvir dvir = (Dvir) it.next();
            for (DvirInspection id : dvir.getInspectionList()) {
                if (id.getId().equals(dvirInspection.getId())) {
                    return dvir;
                }
            }
        }
        return null;
    }

    public boolean m10979a(byte[] bArr) {
        return m10971a(C3642c.m19078a(bArr)) != null;
    }

    private int m10962a(List<Dvir> list) {
        int i = -1;
        for (Dvir dvir : list) {
            int sequenceNum;
            if (dvir.hasSequenceNum()) {
                sequenceNum = dvir.getSequenceNum();
                if (sequenceNum > i) {
                    i = sequenceNum;
                }
            }
            sequenceNum = i;
            i = sequenceNum;
        }
        return i;
    }

    public void m10975a(Dvir dvir) {
        Dvir dvir2;
        int sequenceNum;
        C2630a b;
        SyncManager d;
        int i = 0;
        C3642c id = dvir.getId();
        for (int i2 = 0; i2 < this.f7715e.size(); i2++) {
            dvir2 = (Dvir) this.f7715e.get(i2);
            if (id.equals(dvir2.getId())) {
                if (dvir2.hasSequenceNum()) {
                    sequenceNum = dvir2.getSequenceNum();
                } else {
                    sequenceNum = -1;
                }
                this.f7715e.remove(i2);
                if (sequenceNum < 0) {
                    sequenceNum = m10962a(this.f7715e) + 1;
                }
                b = Dvir.newBuilder(dvir).m13632b(sequenceNum);
                while (i < dvir.getInspectionCount()) {
                    b.m13622a(i, DvirInspection.newBuilder(dvir.getInspection(i)).m13674c(i));
                    i++;
                }
                dvir2 = b.m13638c();
                this.f7715e.add(dvir2);
                Collections.sort(this.f7715e, C0854a.f2650a);
                this.f7716f = null;
                this.f7713c.m8734a(dvir2);
                d = m10966d();
                d.m6468a(dvir2);
                for (DvirInspection a : dvir2.getInspectionList()) {
                    d.m6478a(id, a);
                }
                m10969g();
            }
        }
        sequenceNum = -1;
        if (sequenceNum < 0) {
            sequenceNum = m10962a(this.f7715e) + 1;
        }
        b = Dvir.newBuilder(dvir).m13632b(sequenceNum);
        while (i < dvir.getInspectionCount()) {
            b.m13622a(i, DvirInspection.newBuilder(dvir.getInspection(i)).m13674c(i));
            i++;
        }
        dvir2 = b.m13638c();
        this.f7715e.add(dvir2);
        Collections.sort(this.f7715e, C0854a.f2650a);
        this.f7716f = null;
        this.f7713c.m8734a(dvir2);
        d = m10966d();
        d.m6468a(dvir2);
        while (r2.hasNext()) {
            d.m6478a(id, a);
        }
        m10969g();
    }

    public void m10985b(C3642c c3642c) {
        for (int i = 0; i < this.f7715e.size(); i++) {
            if (c3642c.equals(((Dvir) this.f7715e.get(i)).getId())) {
                this.f7713c.m8738a(c3642c);
                this.f7715e.remove(i);
                this.f7716f = null;
                m10966d().m6493b(c3642c);
                m10969g();
                return;
            }
        }
        C2134e.m10680d("TT-DvirManager", "Unable to delete DVIR id=" + C1180y.m5989a(c3642c) + ": not found");
    }

    public void m10983b(Dvir dvir) {
        C3642c id = dvir.getId();
        for (int i = 0; i < this.f7715e.size(); i++) {
            Dvir dvir2 = (Dvir) this.f7715e.get(i);
            if (id.equals(dvir2.getId())) {
                dvir2 = Dvir.newBuilder(dvir).m13654p().mo1377a(dvir2.getInspectionList()).m13638c();
                this.f7713c.m8734a(dvir2);
                this.f7715e.set(i, dvir2);
                Collections.sort(this.f7715e, C0854a.f2650a);
                this.f7716f = null;
                m10966d().m6468a(dvir2);
                m10969g();
                return;
            }
        }
        C2134e.m10680d("TT-DvirManager", "Unable to update DVIR id=" + C1180y.m5989a(id) + ": not found");
    }

    public DvirInspection m10986c(C3642c c3642c) {
        if (c3642c == null) {
            return null;
        }
        Iterator it = this.f7715e.iterator();
        while (it.hasNext()) {
            for (DvirInspection dvirInspection : ((Dvir) it.next()).getInspectionList()) {
                if (c3642c.equals(dvirInspection.getId())) {
                    return dvirInspection;
                }
            }
        }
        return null;
    }

    public void m10976a(C3642c c3642c, DvirInspection dvirInspection) {
        m10978a(c3642c, Collections.singletonList(dvirInspection));
    }

    private int m10965b(List<DvirInspection> list) {
        int i = -1;
        for (DvirInspection dvirInspection : list) {
            int sequenceNum;
            if (dvirInspection.hasSequenceNum()) {
                sequenceNum = dvirInspection.getSequenceNum();
                if (sequenceNum > i) {
                    i = sequenceNum;
                }
            }
            sequenceNum = i;
            i = sequenceNum;
        }
        return i;
    }

    public void m10978a(C3642c c3642c, List<DvirInspection> list) {
        for (int i = 0; i < this.f7715e.size(); i++) {
            Dvir dvir = (Dvir) this.f7715e.get(i);
            if (c3642c.equals(dvir.getId())) {
                int b = m10965b(dvir.getInspectionList()) + 1;
                C2630a newBuilder = Dvir.newBuilder(dvir);
                int i2 = b;
                for (DvirInspection newBuilder2 : list) {
                    b = i2 + 1;
                    newBuilder.m13625a(DvirInspection.newBuilder(newBuilder2).m13674c(i2));
                    i2 = b;
                }
                Dvir c = newBuilder.m13638c();
                this.f7713c.m8734a(c);
                this.f7715e.set(i, c);
                this.f7716f = null;
                for (int inspectionCount = dvir.getInspectionCount(); inspectionCount < c.getInspectionCount(); inspectionCount++) {
                    m10966d().m6478a(c3642c, c.getInspection(inspectionCount));
                }
                m10969g();
                return;
            }
        }
        C2134e.m10680d("TT-DvirManager", "Unable to add inspection to DVIR id=" + C1180y.m5989a(c3642c) + ": not found");
    }

    public void m10990d(C3642c c3642c) {
        for (int i = 0; i < this.f7715e.size(); i++) {
            Dvir dvir = (Dvir) this.f7715e.get(i);
            for (int i2 = 0; i2 < dvir.getInspectionCount(); i2++) {
                if (c3642c.equals(dvir.getInspection(i2).getId())) {
                    C2630a newBuilder = Dvir.newBuilder(dvir);
                    newBuilder.m13641d(i2);
                    if (newBuilder.m13653o() == 0) {
                        this.f7713c.m8738a(dvir.getId());
                        this.f7715e.remove(i);
                    } else {
                        dvir = newBuilder.m13638c();
                        this.f7713c.m8734a(dvir);
                        this.f7715e.set(i, dvir);
                    }
                    this.f7716f = null;
                    m10966d().m6497c(c3642c);
                    m10969g();
                    return;
                }
            }
        }
        C2134e.m10680d("TT-DvirManager", "Unable to delete DVIR inspectionId=" + C1180y.m5989a(c3642c) + ": not found");
    }

    public void m10984b(DvirInspection dvirInspection) {
        C3642c id = dvirInspection.getId();
        for (int i = 0; i < this.f7715e.size(); i++) {
            Dvir dvir = (Dvir) this.f7715e.get(i);
            for (int i2 = 0; i2 < dvir.getInspectionCount(); i2++) {
                if (id.equals(dvir.getInspection(i2).getId())) {
                    Iterable arrayList = new ArrayList(dvir.getInspectionList());
                    arrayList.set(i2, dvirInspection);
                    Collections.sort(arrayList, C0854a.f2651b);
                    dvir = Dvir.newBuilder(dvir).m13654p().mo1377a(arrayList).m13638c();
                    this.f7713c.m8734a(dvir);
                    this.f7715e.set(i, dvir);
                    this.f7716f = null;
                    m10966d().m6478a(dvir.getId(), dvirInspection);
                    m10969g();
                    return;
                }
            }
        }
        C2134e.m10680d("TT-DvirManager", "Unable to update DVIR inspectionId=" + C1180y.m5989a(id) + ": not found");
    }

    public List<Dvir> m10987c() {
        return Collections.unmodifiableList(this.f7715e);
    }
}
