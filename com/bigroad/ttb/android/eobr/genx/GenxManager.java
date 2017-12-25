package com.bigroad.ttb.android.eobr.genx;

import com.bigroad.shared.am;
import com.bigroad.shared.eobr.C0969b;
import com.bigroad.shared.eobr.C0971c;
import com.bigroad.shared.eobr.C0972e;
import com.bigroad.shared.eobr.C0973f;
import com.bigroad.shared.eobr.ConnectionSetupFlag;
import com.bigroad.shared.eobr.EobrSessionLogEntry;
import com.bigroad.shared.eobr.EobrType;
import com.bigroad.shared.eobr.genx.C0976j;
import com.bigroad.shared.eobr.genx.C0984g;
import com.bigroad.shared.eobr.genx.C0985h;
import com.bigroad.shared.eobr.genx.C0986i;
import com.bigroad.shared.eobr.genx.C0987k;
import com.bigroad.shared.eobr.genx.GenxEntryReasonCode;
import com.bigroad.shared.eobr.genx.GenxEntryResponse;
import com.bigroad.shared.eobr.turbo.C1015l;
import com.bigroad.shared.eobr.turbo.logs.C1024d;
import com.bigroad.ttb.android.C2032f;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.eobr.C1902e.C1206c;
import com.bigroad.ttb.android.eobr.EobrDevice;
import com.bigroad.ttb.android.eobr.EobrEntryManager;
import com.bigroad.ttb.android.eobr.EobrEntryManager.State;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.p035d.p036a.C1776o;
import com.bigroad.ttb.android.util.C2295o;
import com.bigroad.ttb.android.vehicle.C2338a;
import com.bigroad.ttb.android.vehicle.C2363e;
import com.bigroad.ttb.protocol.TTProtocol.CursorResetReason;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.RelativeTimestamp;
import com.bigroad.ttb.protocol.TTProtocol.RelativeTimestamp.C2730a;
import com.google.common.base.Predicate;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GenxManager extends EobrEntryManager {
    private static final Predicate<C0976j> f6609G = new C19094();
    private static final Predicate<C0976j> f6610H = new C19105();
    private static final Predicate<C0971c> f6611I = new C19116();
    private static final Predicate<C0976j> f6612K = new C19138();
    private static C2032f f6613v;
    private static GenxManager f6614w;
    private C1921e f6615A = new C1921e();
    private final LinkedList<C2295o<C0986i, C1206c>> f6616B = new LinkedList();
    private final Runnable f6617C = new C19051(this);
    private final C1206c f6618D = new C19062(this);
    private final C1206c f6619E = new C1907a(this, this, "current position") {
        final /* synthetic */ GenxManager f6602b;

        void mo1089a(C0986i c0986i, C0985h c0985h) {
            if (this.f6602b.f == State.GET_CURRENT_VAR_POSITION) {
                C1015l a;
                C1776o g = this.f6602b.b.m8783g(this.f6602b.f6615A.m9460c());
                if (g != null && g.m8622e() > c0985h.m5062j()) {
                    C2134e.m10682e("TT-GenxMgr", "Entry count mismatch; deleting cached entries");
                    this.f6602b.b.m8788h(this.f6602b.f6615A.m9460c());
                    this.f6602b.f6615A.m9448a();
                }
                if (c0985h.m5057b()) {
                    a = C0976j.m4991a(0);
                } else {
                    a = C0976j.m4991a(c0985h.m5062j());
                }
                this.f6602b.p = (long) c0985h.m5059d();
                C2134e.m10678c("TT-GenxMgr", "Current VAR position: " + a + " Timestamp: " + this.f6602b.p);
                this.f6602b.i.m11530a(a);
                this.f6602b.f6620F = -1;
                this.f6602b.m9047a(State.FIND_LAST_EOBR_EVENT);
                this.f6602b.m9342a(c0985h);
            }
        }

        void mo1090b(C0986i c0986i, C0985h c0985h) {
        }
    };
    private long f6620F = -1;
    private final C1206c f6621J = new C1907a(this, this, "last EOBR event") {
        final /* synthetic */ GenxManager f6603b;

        void mo1089a(C0986i c0986i, C0985h c0985h) {
            if (this.f6603b.f == State.FIND_LAST_EOBR_EVENT) {
                this.f6603b.m9342a(c0985h);
            }
        }

        void mo1090b(C0986i c0986i, C0985h c0985h) {
            this.f6603b.m9350a("Out of valid pages");
        }
    };
    private final C1206c f6622L = new C1907a(this, this, "find app start") {
        final /* synthetic */ GenxManager f6604b;

        void mo1089a(C0986i c0986i, C0985h c0985h) {
            if (this.f6604b.f == State.FIND_APP_START_ENTRY) {
                this.f6604b.m9353b(c0985h);
            }
        }

        void mo1090b(C0986i c0986i, C0985h c0985h) {
            this.f6604b.m9357b("Out of valid pages");
        }
    };
    private final C1206c f6623M = new C1915a(this, this, "genx page fetch");
    private long f6624x = -1;
    private long f6625y = 0;
    private long f6626z = 0;

    class C19051 implements Runnable {
        final /* synthetic */ GenxManager f6597a;

        C19051(GenxManager genxManager) {
            this.f6597a = genxManager;
        }

        public void run() {
            this.f6597a.m9344a(this.f6597a.f6623M, "Newest GENX entry timer");
            this.f6597a.mo1106k();
        }
    }

    class C19062 implements C1206c {
        final /* synthetic */ GenxManager f6598a;

        C19062(GenxManager genxManager) {
            this.f6598a = genxManager;
        }

        public void mo897a(C0972e c0972e, C0973f c0973f) {
            this.f6598a.mo1116x();
        }
    }

    static class C19094 implements Predicate<C0976j> {
        C19094() {
        }

        public /* synthetic */ boolean apply(Object obj) {
            return m9326a((C0976j) obj);
        }

        public boolean m9326a(C0976j c0976j) {
            if (c0976j instanceof C0984g) {
                return ((C0984g) c0976j).m5048j();
            }
            return false;
        }
    }

    static class C19105 implements Predicate<C0976j> {
        C19105() {
        }

        public /* synthetic */ boolean apply(Object obj) {
            return m9327a((C0976j) obj);
        }

        public boolean m9327a(C0976j c0976j) {
            if (!(c0976j instanceof C0984g)) {
                return false;
            }
            C1024d l = ((C0984g) c0976j).m5050l();
            if (l == null || !l.m5266f()) {
                return false;
            }
            return true;
        }
    }

    static class C19116 implements Predicate<C0971c> {
        C19116() {
        }

        public /* synthetic */ boolean apply(Object obj) {
            return m9328a((C0971c) obj);
        }

        public boolean m9328a(C0971c c0971c) {
            if (c0971c instanceof GenxEntryResponse) {
                return ((GenxEntryResponse) c0971c).mo746a();
            }
            if (c0971c instanceof C0984g) {
                return ((C0984g) c0971c).m5049k();
            }
            return false;
        }
    }

    static class C19138 implements Predicate<C0976j> {
        C19138() {
        }

        public /* synthetic */ boolean apply(Object obj) {
            return m9331a((C0976j) obj);
        }

        public boolean m9331a(C0976j c0976j) {
            if (!(c0976j instanceof GenxEntryResponse)) {
                return false;
            }
            GenxEntryResponse genxEntryResponse = (GenxEntryResponse) c0976j;
            if (GenxEntryReasonCode.m4983a(genxEntryResponse.m5004j()) || GenxEntryReasonCode.m4984b(genxEntryResponse.m5004j())) {
                return true;
            }
            return false;
        }
    }

    public enum FetchDirection {
        LOOKING_FORWARD,
        LOOKING_BACKWARD
    }

    private class C1915a extends C1907a {
        final /* synthetic */ GenxManager f6608b;

        C1915a(GenxManager genxManager, GenxManager genxManager2, String str) {
            this.f6608b = genxManager;
            super(genxManager2, str);
        }

        void mo1089a(C0986i c0986i, C0985h c0985h) {
            this.f6608b.f6626z = c0985h.m5061i();
            if (!c0986i.m5069e()) {
                this.f6608b.f6615A.m9452a(this.f6608b.b, this.f6608b.g);
            } else if (this.f6608b.f == State.POLL_FOR_NEW_ENTRIES) {
                long k = c0985h.m5063k();
                if (this.f6608b.f6624x >= 0 && k > this.f6608b.f6624x + 1) {
                    this.f6608b.m9340a(this.f6608b.f6624x + 1, k - 1, this.f6608b.f6623M);
                }
                if (this.f6608b.g != null && c0985h.m5065m() && ((long) this.f6608b.g.m5230b()) >= c0985h.m5060h() && this.f6608b.i.m11545h()) {
                    C2730a newBuilder = RelativeTimestamp.newBuilder();
                    newBuilder.m14805b(c0985h.m5058c());
                    newBuilder.m14801a((long) c0985h.m5059d());
                    this.f6608b.i.m11531a(this.f6608b.g, newBuilder.m14807c());
                }
            }
        }

        void mo1090b(C0986i c0986i, C0985h c0985h) {
        }
    }

    public static GenxManager m9339a(C2032f c2032f) {
        if (f6614w == null) {
            f6613v = c2032f;
            f6614w = new GenxManager();
        }
        return f6614w;
    }

    protected boolean mo1096a(C2363e c2363e, C2338a c2338a) {
        return mo1095a(c2363e.m11541d()) && this.f == State.NOT_FETCHING_PAGES && !c2338a.m11451a(ConnectionSetupFlag.FIRMWARE_DETECTING) && !c2338a.m11451a(ConnectionSetupFlag.FIRMWARE_INCOMPATIBLE);
    }

    protected boolean mo1095a(EobrDevice eobrDevice) {
        return eobrDevice != null && eobrDevice.mo1121o() == EobrType.GENX;
    }

    protected Runnable mo1091a() {
        return this.f6617C;
    }

    private GenxManager() {
        super(f6613v);
    }

    public C2032f mo1115w() {
        return f6613v;
    }

    protected long mo1102f() {
        return 3000;
    }

    protected boolean mo1101e() {
        return false;
    }

    protected void mo1107l() {
    }

    protected void mo1108m() {
        if (this.g != null) {
            long b = (long) (this.g.m5230b() + 1);
            long j = b;
            while (j < b + 5) {
                C0976j a = m9337a(j, FetchDirection.LOOKING_FORWARD);
                if (a != null) {
                    this.h.add(a);
                    j++;
                } else if (j < this.f6624x) {
                    Long c = this.f6615A.m9459c(j - 1);
                    if (c != null) {
                        m9340a(j, c.longValue() - 1, this.f6623M);
                        return;
                    }
                    C2134e.m10680d("TT-GenxMgr", "addTimestampedEntries got confused as to what to fetch next");
                    m9340a(j, j + 5, this.f6623M);
                    return;
                } else {
                    return;
                }
            }
        }
    }

    protected void mo1109n() {
    }

    protected void mo1092a(C2363e c2363e, boolean z) {
        this.f6625y = 0;
        if (this.f6626z > this.f6625y) {
            this.f6625y = this.f6626z;
        }
    }

    protected void mo1116x() {
        C2134e.m10676b("TT-GenxMgr", "Resetting state to restart processing");
        this.f6615A.m9452a(this.b, this.g);
        mo1111r();
        mo1112s();
        C1015l f = this.i.m11543f();
        C0976j a = f != null ? m9337a((long) f.m5230b(), FetchDirection.LOOKING_BACKWARD) : null;
        m9072q();
        if (a == null) {
            mo1110p();
            return;
        }
        m9047a(State.FIND_LAST_EOBR_EVENT);
        m9344a(this.f6621J, "Search for EOBR event following restart");
        mo1106k();
    }

    protected void mo1110p() {
        m9047a(State.GET_CURRENT_VAR_POSITION);
        m9344a(this.f6619E, "Kick off current position search");
        mo1106k();
    }

    protected boolean mo1100d() {
        if (this.f != State.RESTARTING) {
            return false;
        }
        C2134e.m10676b("TT-GenxMgr", "Writing restart cursor event");
        this.d.m11401a(this.n, this.f6618D);
        return true;
    }

    protected void mo1111r() {
        super.mo1111r();
        this.f6616B.clear();
    }

    protected void mo1112s() {
        super.mo1112s();
        this.f6624x = -1;
        this.f6620F = -1;
    }

    protected void mo1093a(boolean z) {
        super.mo1093a(z);
        this.f6625y = 0;
        this.f6626z = 0;
    }

    protected void mo1097b() {
        C2134e.m10680d("TT-GenxMgr", "Startup cutoff timer engaged");
        m9050a(CursorResetReason.TIMEOUT);
    }

    public void mo1098b(long j) {
        this.f6624x = j;
    }

    public void m9376a(C0986i c0986i, C0985h c0985h) {
        if (c0985h != null) {
            this.f6626z = c0985h.m5061i();
            C2134e.m10678c("TT-GenxMgr", "Oldest available ID is: " + this.f6626z);
            this.f6625y = 0;
            if (this.f6626z > this.f6625y) {
                this.f6625y = this.f6626z;
            }
        }
    }

    public void m9377a(C0976j c0976j) {
        if (!this.f6615A.m9456a(c0976j.m4995t())) {
            this.f6615A.m9449a(c0976j);
        }
    }

    void m9378a(EobrDevice eobrDevice, C0985h c0985h) {
        if (m9055a(eobrDevice.m8992d())) {
            Long d = this.f6615A.m9461d();
            List a = c0985h.m5055a();
            if (a.isEmpty() || (c0985h.m5063k() <= ((C0976j) a.get(0)).m4995t() && c0985h.m5064l() >= ((C0976j) a.get(a.size() - 1)).m4995t())) {
                C0976j c0976j;
                Iterator it = a.iterator();
                if (it.hasNext()) {
                    c0976j = (C0976j) it.next();
                } else {
                    c0976j = null;
                }
                long k = c0985h.m5063k();
                Long l = null;
                while (k <= c0985h.m5064l()) {
                    C0976j c0976j2;
                    Long valueOf;
                    if (c0976j == null || c0976j.m4995t() != k) {
                        m9377a(new C0987k(k));
                        c0976j2 = c0976j;
                    } else {
                        m9377a(c0976j);
                        if (it.hasNext()) {
                            c0976j = (C0976j) it.next();
                        } else {
                            c0976j = null;
                        }
                        c0976j2 = c0976j;
                    }
                    if (d == null || k > d.longValue()) {
                        valueOf = Long.valueOf(k);
                    } else {
                        valueOf = l;
                    }
                    k = 1 + k;
                    l = valueOf;
                    c0976j = c0976j2;
                }
                if (l != null) {
                    this.f6615A.m9454a(l);
                    return;
                }
                return;
            }
            C2134e.m10682e("TT-GenxMgr", "Bad response metadata: " + c0985h.toString());
            return;
        }
        C2134e.m10680d("TT-GenxMgr", "Attempt to update VAR database with non-matching page");
    }

    private C0976j m9337a(long j, FetchDirection fetchDirection) {
        if (this.f6615A.m9456a(j)) {
            return this.f6615A.m9457b(j);
        }
        long min = Math.min(0, fetchDirection == FetchDirection.LOOKING_FORWARD ? j : j - 20);
        long j2;
        if (fetchDirection == FetchDirection.LOOKING_FORWARD) {
            j2 = 20 + j;
        } else {
            j2 = j;
        }
        String c = this.f6615A.m9460c();
        if (!am.m4188a((CharSequence) c)) {
            for (C1776o c1776o : this.b.m8721a(c, min, r4)) {
                if (!this.f6615A.m9456a(c1776o.m8622e())) {
                    this.f6615A.m9451a(c1776o);
                }
            }
            if (this.f6615A.m9456a(j)) {
                return this.f6615A.m9457b(j);
            }
        }
        return null;
    }

    private void m9342a(C0985h c0985h) {
        if (this.f6620F < 0) {
            if (c0985h != null) {
                this.f6620F = c0985h.m5064l();
            } else {
                C2134e.m10680d("TT-GenxMgr", "EOBR search not started from response callback");
                m9344a(this.f6621J, "EOBR search not started from response callback");
            }
        }
        if (c0985h == null || c0985h.m5056a(this.f6620F)) {
            while (this.f6620F >= this.f6626z) {
                C0976j a = m9337a(this.f6620F, FetchDirection.LOOKING_BACKWARD);
                if (a == null) {
                    m9341a(this.f6620F, this.f6621J, "Search for EOBR event");
                    return;
                }
                if (!a.mo750h()) {
                    m9354b(a);
                    if (this.m == null) {
                        this.m = a;
                    }
                    CursorResetReason e = m9365e(a);
                    if (e != null) {
                        m9050a(e);
                        return;
                    }
                    C1015l c1015l = null;
                    if (f6609G.apply(a)) {
                        c1015l = m9359c(a);
                    } else if (f6610H.apply(a)) {
                        c1015l = m9362d(a);
                    }
                    if (c1015l != null) {
                        m9343a(c1015l);
                        return;
                    }
                }
                this.f6620F--;
            }
            m9050a(CursorResetReason.END_OF_STREAM);
            return;
        }
        C2134e.m10680d("TT-GenxMgr", "EOBR search response doesn't contain search position: " + this.f6620F);
        m9050a(CursorResetReason.END_OF_STREAM);
    }

    private void m9354b(C0976j c0976j) {
        if (c0976j != null && !c0976j.mo750h() && f6611I.apply(c0976j)) {
            if (c0976j instanceof C0984g) {
                try {
                    this.o.m11514a(((C0984g) c0976j).m5052n(), c0976j.mo747c());
                    return;
                } catch (IOException e) {
                    C2134e.m10676b("TT-GenxMgr", "Problem reading EobrSessionLogEntry from GenxDataEntryResponse #" + ((C0984g) c0976j).m4995t());
                    return;
                }
            }
            this.o.m11514a((C0969b) c0976j, c0976j.mo747c());
        }
    }

    protected boolean mo1094a(EobrSessionLogEntry eobrSessionLogEntry, C1015l c1015l) {
        if (!(eobrSessionLogEntry instanceof C0971c)) {
            return false;
        }
        if (this.p - ((long) ((C0971c) eobrSessionLogEntry).mo748b()) <= 60) {
            return true;
        }
        return false;
    }

    private C1015l m9359c(C0976j c0976j) {
        C1015l c1015l;
        if (c0976j instanceof C0984g) {
            C0984g c0984g = (C0984g) c0976j;
            C2134e.m10678c("TT-GenxMgr", "Found EOBR event: " + c0984g.mo747c().toString());
            try {
                Event m = c0984g.m5051m();
                if (m == null || !m.hasVarPosition()) {
                    C2134e.m10680d("TT-GenxMgr", "Couldn't parse EOBR event metadata");
                    c1015l = null;
                } else {
                    c1015l = C1015l.m5227a(m.getVarPosition());
                }
            } catch (Throwable e) {
                C2134e.m10679c("TT-GenxMgr", "IOException parsing EOBR event metadata", e);
            }
        } else {
            C2134e.m10680d("TT-GenxMgr", "logEntry not an instance of GenxDataEntryResponse");
            c1015l = null;
        }
        if (c1015l == null) {
            return null;
        }
        C1015l f = this.f6615A.m9463f();
        if (f != null) {
            if (f == c1015l) {
                C2134e.m10678c("TT-GenxMgr", "Resuming processing at cursor position: " + f.toString());
            } else {
                C2134e.m10678c("TT-GenxMgr", "EOBR events written to this GENX not by this client instance; " + f.toString() + " > " + c1015l.toString());
            }
        }
        return c1015l;
    }

    private C1015l m9362d(C0976j c0976j) {
        C1024d l = ((C0984g) c0976j).m5050l();
        if (l != null) {
            C2134e.m10678c("TT-GenxMgr", "Found Cursor Reset: " + l.m5267g().getReason().toString() + " at " + c0976j.mo747c().toString());
            return c0976j.mo747c();
        }
        C2134e.m10680d("TT-GenxMgr", "lastCursorResetPosition not set to a Cursor Reset");
        return null;
    }

    private void m9343a(C1015l c1015l) {
        m9075t();
        m9047a(State.FIND_APP_START_ENTRY);
        C2134e.m10678c("TT-GenxMgr", "New last stored cursor position: " + c1015l.toString());
        this.f6615A.m9450a(c1015l);
        this.i.m11537b(c1015l);
        this.f6620F = (long) c1015l.m5230b();
        m9353b(null);
    }

    private CursorResetReason m9365e(C0976j c0976j) {
        if (this.m.mo749d() - c0976j.mo749d() > 691200000) {
            return CursorResetReason.SEARCH_UNREACHABLE;
        }
        return null;
    }

    private void m9350a(String str) {
        C2134e.m10680d("TT-GenxMgr", "Unable to find EOBR event; " + str);
        m9075t();
        m9047a(State.FIND_APP_START_ENTRY);
        this.f6615A.m9462e();
        if (this.f6624x >= 0) {
            this.f6620F = this.f6624x;
            m9353b(null);
            return;
        }
        m9357b("EOBR entry");
    }

    private void m9353b(C0985h c0985h) {
        if (c0985h == null || c0985h.m5056a(this.f6620F)) {
            while (this.f6620F >= this.f6626z) {
                C0976j a = m9337a(this.f6620F, FetchDirection.LOOKING_BACKWARD);
                if (a == null) {
                    m9341a(this.f6620F, this.f6622L, "Search for app start");
                    return;
                }
                if (!a.mo750h()) {
                    m9354b(a);
                    if (f6612K.apply(a)) {
                        C2134e.m10678c("TT-GenxMgr", "Found app start event: " + a.toString());
                        this.g = C0976j.m4991a(this.f6620F);
                        this.k = this.g;
                        m9047a(State.FIND_VEHICLE_STATE_START_ENTRY);
                        m9361c(null);
                        return;
                    }
                }
                this.f6620F--;
            }
            m9357b("app start event");
            return;
        }
        C2134e.m10680d("TT-GenxMgr", "App start search response doesn't contain search position: " + this.f6620F);
        m9357b("app start event");
    }

    private void m9357b(String str) {
        C2134e.m10680d("TT-GenxMgr", "Could not find " + str);
        C1015l f = this.f6615A.m9463f();
        if (f != null) {
            this.g = f.m5235f();
        } else {
            this.g = C0976j.m4991a(this.f6624x);
        }
        this.i.m11533a(this.o);
        m9047a(State.PROCESS_ENTRIES);
        this.a.removeCallbacks(this.u);
        this.f6620F = -1;
        m9062g();
    }

    private void m9361c(C0985h c0985h) {
        C2134e.m10678c("TT-GenxMgr", "Found vehicle state start event: " + this.g);
        this.l = this.g;
        this.g = this.g.m5235f();
        m9047a(State.PROCESS_ENTRIES);
        this.a.removeCallbacks(this.u);
        this.f6620F = -1;
        this.i.m11533a(this.o);
        m9062g();
    }

    protected boolean mo1105j() {
        return !this.f6616B.isEmpty();
    }

    protected void mo1106k() {
        m9406y();
    }

    protected boolean mo1103h() {
        return false;
    }

    protected void mo1104i() {
    }

    void m9406y() {
        if (this.f6616B.isEmpty()) {
            C2134e.m10680d("TT-GenxMgr", "fetchQueueEntries called with empty queue");
            return;
        }
        EobrDevice j = this.d.m11412j();
        if (j != null) {
            C2295o c2295o = (C2295o) this.f6616B.remove();
            j.m8984a((C0986i) c2295o.f7935a, (C1206c) c2295o.f7936b);
            m9046a(1);
        }
    }

    private void m9344a(C1206c c1206c, String str) {
        C2295o c2295o = new C2295o(new C0986i(null, null, Long.valueOf(5)), c1206c);
        if (!this.f6616B.contains(c2295o)) {
            this.f6616B.addLast(c2295o);
        }
    }

    private void m9341a(long j, C1206c c1206c, String str) {
        C2295o c2295o = new C2295o(new C0986i(null, Long.valueOf(j), Long.valueOf(5)), c1206c);
        if (!this.f6616B.contains(c2295o)) {
            this.f6616B.addLast(c2295o);
        }
    }

    private void m9340a(long j, long j2, C1206c c1206c) {
        long j3 = ((j2 / 5) + 1) * 5;
        for (long j4 = (j / 5) * 5; j4 < j3; j4 += 5) {
            C2295o c2295o = new C2295o(new C0986i(Long.valueOf(j4), Long.valueOf((5 + j4) - 1), null), c1206c);
            if (!this.f6616B.contains(c2295o)) {
                this.f6616B.addLast(c2295o);
            }
        }
    }

    public void m9381a(String str, List<Long> list) {
        if (this.d.m11409g() && am.m4189a(this.d.m11412j().mo1119g(), str)) {
            this.f6615A.m9455a((List) list);
        }
        this.b.m8742a(str, (List) list);
    }

    public void m9407z() {
        if (this.d.m11409g() && this.d.m11412j().mo1121o() == EobrType.GENX) {
            String g = this.d.m11412j().mo1119g();
            List<C1776o> f = this.b.m8779f(g);
            if (!f.isEmpty()) {
                List arrayList = new ArrayList();
                for (C1776o i : f) {
                    arrayList.add(i.m8626i());
                }
                OurApplication.m6289k().m6486a(g, arrayList, this.f6626z);
            }
        }
    }

    protected void mo1113u() {
        this.f6615A.m9452a(this.b, this.g);
    }

    protected void mo1099b(EobrDevice eobrDevice) {
        this.f6615A.m9453a(this.b, eobrDevice);
    }

    protected void mo1114v() {
        this.f6615A.m9448a();
        this.f6615A.m9458b();
    }

    public void m9380a(String str, long j) {
        this.f6615A.m9447a(this.b, str, j);
    }
}
