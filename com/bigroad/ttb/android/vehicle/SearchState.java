package com.bigroad.ttb.android.vehicle;

import android.os.Handler;
import com.bigroad.shared.C1180y;
import com.bigroad.shared.am;
import com.bigroad.shared.eobr.EobrType;
import com.bigroad.ttb.android.C2032f;
import com.bigroad.ttb.android.TruckManager;
import com.bigroad.ttb.android.eobr.EobrDevice;
import com.bigroad.ttb.android.eobr.EobrManager;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class SearchState {
    protected SearchStatus f8003a = SearchStatus.STOPPED;
    protected final Runnable f8004b = new C23172(this);
    private final Handler f8005c = new Handler();
    private final EobrManager f8006d;
    private final TruckManager f8007e;
    private String f8008f = null;
    private boolean f8009g = true;
    private final Set<String> f8010h = new HashSet();
    private ArrayList<EobrDevice> f8011i = new ArrayList();
    private final Runnable f8012j = new C23161(this);

    class C23161 implements Runnable {
        final /* synthetic */ SearchState f7993a;

        C23161(SearchState searchState) {
            this.f7993a = searchState;
        }

        public void run() {
            if (this.f7993a.f8003a == SearchStatus.AWAITING_VIN) {
                C2134e.m10676b("TT-SearchState", "Timeout waiting for VIN");
                this.f7993a.m11319i();
            }
        }
    }

    class C23172 implements Runnable {
        final /* synthetic */ SearchState f7994a;

        C23172(SearchState searchState) {
            this.f7994a = searchState;
        }

        public void run() {
            if (this.f7994a.f8003a == SearchStatus.PAUSING) {
                this.f7994a.m11318h();
            }
        }
    }

    protected enum SearchStatus {
        STOPPED,
        SCANNING,
        CONNECTING,
        AWAITING_VIN,
        PAUSING
    }

    public SearchState(C2032f c2032f) {
        this.f8006d = c2032f.mo1310r();
        this.f8007e = c2032f.mo1300h();
    }

    public EobrDevice m11322a() {
        return this.f8006d.m9113a(this.f8008f);
    }

    private String m11315e() {
        Truck f = this.f8007e.m6578f();
        if (f != null && f.hasGenxSerialNumber()) {
            return f.getGenxSerialNumber();
        }
        return null;
    }

    private String m11316f() {
        Truck f = this.f8007e.m6578f();
        if (f != null && f.getHasAobrd() && f.hasAssociatedDashLink()) {
            return C1180y.m5996c(f.getAssociatedDashLink().m19091d());
        }
        return null;
    }

    private String m11317g() {
        Truck f = this.f8007e.m6578f();
        if (f != null) {
            return f.getVin();
        }
        return null;
    }

    private void m11318h() {
        m11325b();
        this.f8003a = SearchStatus.SCANNING;
        this.f8006d.m9124c();
    }

    private void m11312a(EobrDevice eobrDevice, boolean z) {
        this.f8003a = SearchStatus.CONNECTING;
        this.f8009g = z;
        eobrDevice.m8998j();
    }

    private void m11319i() {
        m11320j();
        CharSequence e = m11315e();
        Iterator it;
        EobrDevice eobrDevice;
        if (am.m4188a(e)) {
            CharSequence f = m11316f();
            if (!(am.m4188a(f) || this.f8010h.contains(f))) {
                C2134e.m10676b("TT-SearchState", "Searching by MAC for " + f);
                it = this.f8011i.iterator();
                while (it.hasNext()) {
                    eobrDevice = (EobrDevice) it.next();
                    if (eobrDevice.m8991c().equals(f)) {
                        this.f8008f = f;
                        m11312a(eobrDevice, false);
                        return;
                    }
                }
            }
            Iterator it2 = this.f8011i.iterator();
            while (it2.hasNext()) {
                eobrDevice = (EobrDevice) it2.next();
                String c = eobrDevice.m8991c();
                if (m11317g() == null || m11317g().length() == 0) {
                    this.f8010h.add(c);
                } else if (eobrDevice.mo1121o() == EobrType.GENX) {
                    this.f8010h.add(c);
                } else if (!this.f8010h.contains(c)) {
                    this.f8008f = c;
                    m11312a(eobrDevice, true);
                    return;
                }
            }
        } else {
            String str = "GENX_" + e;
            C2134e.m10676b("TT-SearchState", "Searching by serial number " + str);
            it = this.f8011i.iterator();
            while (it.hasNext()) {
                eobrDevice = (EobrDevice) it.next();
                if (am.m4189a(eobrDevice.m8993e(), str)) {
                    this.f8008f = eobrDevice.m8991c();
                    m11312a(eobrDevice, false);
                    return;
                }
            }
        }
        this.f8003a = SearchStatus.PAUSING;
        this.f8005c.postDelayed(this.f8004b, 1000);
    }

    private void m11320j() {
        if (this.f8008f != null) {
            this.f8010h.add(this.f8008f);
        }
        m11321k();
    }

    private void m11321k() {
        EobrDevice a = m11322a();
        this.f8008f = null;
        if (a != null) {
            a.m8999k();
        }
    }

    public void m11323a(EobrDevice eobrDevice) {
        SearchStatus searchStatus = this.f8003a;
        if (searchStatus != SearchStatus.STOPPED) {
            this.f8003a = SearchStatus.STOPPED;
            if (searchStatus == SearchStatus.SCANNING) {
                this.f8006d.m9125d();
            }
            if (eobrDevice == null || !am.m4189a(eobrDevice.m8991c(), this.f8008f)) {
                m11321k();
            } else {
                this.f8008f = null;
            }
            this.f8010h.clear();
            this.f8005c.removeCallbacks(this.f8012j);
            this.f8005c.removeCallbacks(this.f8004b);
        }
    }

    public void m11325b() {
        m11323a(null);
    }

    public boolean m11326c() {
        return this.f8003a == SearchStatus.STOPPED;
    }

    public boolean m11327d() {
        return this.f8003a == SearchStatus.AWAITING_VIN;
    }

    public void m11324a(byte[] bArr) {
        boolean z = true;
        SearchStatus searchStatus = this.f8003a;
        String c = C1180y.m5996c(bArr);
        switch (this.f8003a) {
            case STOPPED:
                if (c != null) {
                    EobrDevice b = this.f8006d.m9120b(c);
                    Truck f = this.f8007e.m6578f();
                    if (!(b == null || f == null)) {
                        if ((b.mo1121o() == EobrType.GENX) == f.hasGenxSerialNumber()) {
                            this.f8011i.clear();
                            this.f8011i.add(b);
                            C2134e.m10678c("TT-SearchState", "Connecting to preferred address " + c);
                            this.f8008f = c;
                            if (f.hasAssociatedDashLink() || f.hasGenxSerialNumber()) {
                                z = false;
                            }
                            m11312a(b, z);
                            return;
                        }
                        C2134e.m10678c("TT-SearchState", "Foregoing preferred address " + c + " as its EOBR type does not match that of the current truck.");
                    }
                }
                m11318h();
                return;
            case SCANNING:
                if (!this.f8006d.m9123b()) {
                    this.f8011i = this.f8006d.m9115a();
                    this.f8010h.clear();
                    m11319i();
                    return;
                }
                return;
            case CONNECTING:
            case AWAITING_VIN:
                EobrDevice a = m11322a();
                if (a == null) {
                    C2134e.m10676b("TT-SearchState", "EOBR no longer connected while waiting for VIN");
                    m11319i();
                    return;
                }
                switch (a.m8997i()) {
                    case CONNECTING:
                        return;
                    case CONNECTED:
                        if (this.f8003a != SearchStatus.CONNECTING) {
                            return;
                        }
                        if (this.f8009g) {
                            this.f8003a = SearchStatus.AWAITING_VIN;
                            this.f8005c.postDelayed(this.f8012j, 7000);
                            return;
                        }
                        this.f8003a = SearchStatus.PAUSING;
                        this.f8005c.postDelayed(this.f8004b, 1000);
                        return;
                    case NOT_CONNECTED:
                        C2134e.m10676b("TT-SearchState", "Connection lost");
                        m11319i();
                        return;
                    default:
                        return;
                }
            default:
                return;
        }
    }
}
