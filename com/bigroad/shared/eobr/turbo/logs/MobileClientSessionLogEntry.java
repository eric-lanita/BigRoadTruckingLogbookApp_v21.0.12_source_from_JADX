package com.bigroad.shared.eobr.turbo.logs;

import com.bigroad.shared.eobr.C0971c;
import com.bigroad.shared.eobr.EobrSessionLogEntry;
import com.bigroad.shared.eobr.EobrSessionLogEntry.SessionState;
import com.bigroad.shared.eobr.turbo.C1000c;
import com.bigroad.shared.eobr.turbo.C1015l;

public class MobileClientSessionLogEntry extends C1017o implements EobrSessionLogEntry, C0971c {
    public final byte[] f3215a;
    public final long f3216b;
    public final long f3217c;
    public final int f3218d;
    public final int f3219e;
    public final MobileClientSessionState f3220f;

    public enum MobileClientSessionState implements C1000c {
        MOBILE_CLIENT_SESSION_STATE_END(0, SessionState.END),
        MOBILE_CLIENT_SESSION_STATE_START(1, SessionState.START),
        MOBILE_CLIENT_SESSION_STATE_UNKNOWN(2, SessionState.UNKNOWN),
        MOBILE_CLIENT_SESSION_STATE_STATUS(3, SessionState.STATUS);
        
        private final SessionState m_eobrState;
        private final int m_id;

        private MobileClientSessionState(int i, SessionState sessionState) {
            this.m_id = i;
            this.m_eobrState = sessionState;
        }

        public int mo760a() {
            return this.m_id;
        }

        public boolean mo761b() {
            return this == MOBILE_CLIENT_SESSION_STATE_UNKNOWN;
        }

        public SessionState m5247c() {
            return this.m_eobrState;
        }
    }

    public MobileClientSessionLogEntry(int i, byte[] bArr, long j, long j2, int i2, int i3, MobileClientSessionState mobileClientSessionState) {
        super(i);
        this.f3215a = bArr;
        this.f3216b = j;
        this.f3217c = j2;
        this.f3218d = i2;
        this.f3219e = i3;
        this.f3220f = mobileClientSessionState;
    }

    public byte[] mo751e() {
        return this.f3215a;
    }

    public long mo752f() {
        return this.f3216b;
    }

    public long mo753g() {
        return this.f3217c;
    }

    public int mo754h() {
        return this.f3218d;
    }

    public int mo755i() {
        return this.f3219e;
    }

    public SessionState mo756j() {
        return this.f3220f.m5247c();
    }

    public int mo748b() {
        return this.f3193g;
    }

    public C1015l mo747c() {
        return null;
    }

    public long mo749d() {
        return 0;
    }
}
