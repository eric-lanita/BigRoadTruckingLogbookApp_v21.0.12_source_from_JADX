package com.bigroad.ttb.android;

import android.app.Activity;
import com.bigroad.ttb.android.C2081g.C1230a;
import com.bigroad.ttb.android.C2081g.C1231b;
import com.bigroad.ttb.android.C2474y.C1182a;
import com.bigroad.ttb.android.C2474y.C1183b;
import com.bigroad.ttb.android.SyncManager.C1237a;
import com.bigroad.ttb.android.SyncManager.C1239c;
import com.bigroad.ttb.android.activity.C1632a;
import com.bigroad.ttb.android.activity.OurActivity;
import com.bigroad.ttb.android.util.C2306y;
import com.bigroad.ttb.protocol.TTProtocol.Fleet;
import com.bigroad.ttb.protocol.TTProtocol.Person;
import com.bigroad.ttb.protocol.TTProtocol.ResponseStatus;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TrialUserMonitor {
    private static TrialUserMonitor f4230a;
    private static C2474y f4231b = OurApplication.m6285g();
    private static SyncManager f4232c = OurApplication.m6289k();
    private static C2081g f4233d = OurApplication.m6284f();
    private Person f4234e;
    private CacheState f4235f;
    private final Set<C1245a> f4236g = new HashSet();
    private C1237a f4237h = new C12411(this);
    private C1239c f4238i = new C12422(this);
    private C1182a f4239j = new C12433(this);
    private C1230a f4240k = new C12444(this);

    class C12411 implements C1237a {
        final /* synthetic */ TrialUserMonitor f4223a;

        C12411(TrialUserMonitor trialUserMonitor) {
            this.f4223a = trialUserMonitor;
        }

        public void mo910a(Person person) {
            TrialUserMonitor.f4232c.m6490b((C1237a) this);
            this.f4223a.f4234e = person;
            this.f4223a.f4235f = CacheState.CACHED;
            if (this.f4223a.f4234e == null) {
                TrialUserMonitor.f4231b.m12197b(true);
                this.f4223a.m6522g();
            }
            this.f4223a.m6523h();
        }
    }

    class C12422 implements C1239c {
        final /* synthetic */ TrialUserMonitor f4224a;

        C12422(TrialUserMonitor trialUserMonitor) {
            this.f4224a = trialUserMonitor;
        }

        public void mo911a(ResponseStatus responseStatus, List<Fleet> list) {
            if (TrialUserMonitor.f4231b.m12227q()) {
                this.f4224a.f4234e = null;
                this.f4224a.m6522g();
                this.f4224a.m6523h();
            }
        }
    }

    class C12433 extends C1183b {
        final /* synthetic */ TrialUserMonitor f4225a;

        C12433(TrialUserMonitor trialUserMonitor) {
            this.f4225a = trialUserMonitor;
        }

        public void mo868e(C2474y c2474y) {
            if (this.f4225a.f4235f == CacheState.CACHED && this.f4225a.f4234e != null) {
                Person l = c2474y.m12222l();
                if (l != null && l.getPersonId() == this.f4225a.f4234e.getPersonId()) {
                    if (C2306y.m11275b(l)) {
                        this.f4225a.f4234e = null;
                        TrialUserMonitor.f4231b.m12197b(true);
                        this.f4225a.m6522g();
                    } else {
                        this.f4225a.f4234e = l;
                    }
                    this.f4225a.m6523h();
                }
            }
        }
    }

    class C12444 extends C1231b {
        final /* synthetic */ TrialUserMonitor f4226a;

        C12444(TrialUserMonitor trialUserMonitor) {
            this.f4226a = trialUserMonitor;
        }

        public void mo907a(boolean z) {
            if (z) {
                boolean X;
                Activity c = TrialUserMonitor.f4233d.m10451c();
                if (c instanceof OurActivity) {
                    X = ((OurActivity) c).m6705X();
                } else {
                    X = false;
                }
                if (X && this.f4226a.f4234e != null && C2306y.m11274a(this.f4226a.f4234e)) {
                    C1632a.m7934a(TrialUserMonitor.f4233d.m10451c(), this.f4226a.f4234e);
                }
            }
        }
    }

    private enum CacheState {
        SEARCHING,
        CACHED
    }

    public interface C1245a {
        void mo1029a(Person person);
    }

    private TrialUserMonitor() {
        f4233d.m10446a(this.f4240k);
        f4232c.m6462a(this.f4238i);
        f4231b.m12184a(this.f4239j);
        this.f4234e = C2306y.m11273a();
        if (f4231b.m12227q()) {
            this.f4235f = CacheState.CACHED;
        } else if (this.f4234e != null) {
            this.f4235f = CacheState.CACHED;
        } else if (OurApplication.m6249F().m6031d()) {
            f4231b.m12197b(true);
            this.f4235f = CacheState.CACHED;
        } else {
            this.f4235f = CacheState.SEARCHING;
            OurApplication.m6289k().m6460a(this.f4237h);
            OurApplication.m6289k().m6506k();
        }
        if (this.f4235f == CacheState.CACHED && this.f4234e == null) {
            m6522g();
        }
    }

    private void m6522g() {
        f4233d.m10449b(this.f4240k);
        f4232c.m6491b(this.f4238i);
        f4232c.m6490b(this.f4237h);
        f4231b.m12194b(this.f4239j);
        this.f4234e = null;
        this.f4235f = CacheState.CACHED;
        m6523h();
    }

    public static TrialUserMonitor m6513a() {
        if (f4230a == null) {
            f4230a = new TrialUserMonitor();
        }
        return f4230a;
    }

    public void m6524a(C1245a c1245a) {
        this.f4236g.add(c1245a);
    }

    public void m6525b(C1245a c1245a) {
        this.f4236g.remove(c1245a);
    }

    private void m6523h() {
        if (!this.f4236g.isEmpty()) {
            for (C1245a a : (C1245a[]) this.f4236g.toArray(new C1245a[this.f4236g.size()])) {
                a.mo1029a(this.f4234e);
            }
        }
    }

    public boolean m6526b() {
        return f4231b.m12227q() || this.f4235f == CacheState.CACHED;
    }

    public Person m6527c() {
        return f4231b.m12227q() ? null : this.f4234e;
    }
}
