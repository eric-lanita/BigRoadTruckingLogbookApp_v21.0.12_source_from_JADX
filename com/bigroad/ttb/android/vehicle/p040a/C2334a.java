package com.bigroad.ttb.android.vehicle.p040a;

import com.bigroad.shared.eobr.turbo.C1015l;
import com.bigroad.shared.eobr.turbo.logs.C1016p;
import com.bigroad.shared.eobr.turbo.logs.C1031k;
import com.bigroad.shared.eobr.turbo.logs.MobileClientSessionLogEntry;
import com.bigroad.ttb.android.vehicle.C2358c;
import com.bigroad.ttb.android.vehicle.p041b.C2347j;
import com.bigroad.ttb.android.vehicle.p041b.C2348f;
import com.bigroad.ttb.protocol.TTProtocol.RelativeTimestamp;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class C2334a implements C2333c {
    private final int f8088a = 120;
    private RelativeTimestamp f8089b = null;
    private RelativeTimestamp f8090c = null;
    private long f8091d = 0;
    private long f8092e = -1;
    private Integer f8093f = null;
    private byte[] f8094g;
    private long f8095h = -1;
    private long f8096i = -1;
    private C2347j f8097j = null;
    private Map<Integer, C1015l> f8098k = new HashMap();

    public void mo1279a(C2347j c2347j) {
        C2348f c2348f;
        mo1280a(c2347j.mo1281l());
        if (c2347j instanceof C2348f) {
            C2348f c2348f2 = (C2348f) c2347j;
            C2348f c2348f3 = c2348f2;
            C1016p a = c2348f2.m11466a();
            c2348f = c2348f3;
        } else {
            c2348f = null;
            Object obj = null;
        }
        if (c2348f != null && a != null) {
            if (a instanceof C1031k) {
                C1031k c1031k = (C1031k) a;
                this.f8092e = c2347j.mo1281l().getRelativeTimeSec();
                if (this.f8097j == null) {
                    this.f8097j = c2347j;
                }
                if (c1031k.f3275f == 64) {
                    m11433c();
                }
            } else if (a instanceof MobileClientSessionLogEntry) {
                MobileClientSessionLogEntry mobileClientSessionLogEntry = (MobileClientSessionLogEntry) a;
                switch (mobileClientSessionLogEntry.f3220f) {
                    case MOBILE_CLIENT_SESSION_STATE_END:
                        this.f8093f = null;
                        this.f8094g = null;
                        this.f8096i = -1;
                        this.f8095h = -1;
                        return;
                    case MOBILE_CLIENT_SESSION_STATE_STATUS:
                    case MOBILE_CLIENT_SESSION_STATE_START:
                        if (m11432b() && this.f8093f != null && Arrays.equals(this.f8094g, mobileClientSessionLogEntry.f3215a) && this.f8096i == mobileClientSessionLogEntry.f3217c && this.f8095h == mobileClientSessionLogEntry.f3216b) {
                            this.f8098k.put(this.f8093f, c2348f.m11468c());
                        }
                        this.f8093f = Integer.valueOf(mobileClientSessionLogEntry.f3218d);
                        this.f8094g = mobileClientSessionLogEntry.f3215a;
                        this.f8096i = mobileClientSessionLogEntry.f3217c;
                        this.f8095h = mobileClientSessionLogEntry.f3216b;
                        m11433c();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void mo1280a(RelativeTimestamp relativeTimestamp) {
        if (relativeTimestamp.hasAbsoluteTimeMillis()) {
            this.f8090c = relativeTimestamp;
            if (this.f8089b == null) {
                this.f8089b = this.f8090c;
            }
        }
        if (relativeTimestamp.hasRelativeTimeSec()) {
            if (this.f8092e >= 0 && this.f8092e < relativeTimestamp.getRelativeTimeSec()) {
                this.f8091d += relativeTimestamp.getRelativeTimeSec() - this.f8092e;
            }
            this.f8092e = relativeTimestamp.getRelativeTimeSec();
        }
        if (this.f8097j == null) {
            m11433c();
            return;
        }
        long j = this.f8091d;
        if (relativeTimestamp.hasAbsoluteTimeMillis() && this.f8089b != null) {
            j = Math.max(j, (relativeTimestamp.getAbsoluteTimeMillis() - this.f8089b.getAbsoluteTimeMillis()) / 1000);
        }
        if (j >= 120) {
            m11433c();
        }
    }

    public C2347j mo1278a() {
        return this.f8097j;
    }

    public boolean m11437a(C2358c c2358c, C1015l c1015l) {
        if (c2358c == null || c2358c.m11508f() == null || c1015l == null) {
            return false;
        }
        C1015l c1015l2 = (C1015l) this.f8098k.get(c2358c.m11508f());
        if (c1015l2 == null) {
            return false;
        }
        return c1015l2.m5231b(c1015l) > 0;
    }

    private boolean m11432b() {
        return this.f8097j != null;
    }

    private void m11433c() {
        this.f8089b = this.f8090c;
        this.f8097j = null;
        this.f8091d = 0;
    }
}
