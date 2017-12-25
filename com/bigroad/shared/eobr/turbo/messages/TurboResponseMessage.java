package com.bigroad.shared.eobr.turbo.messages;

import com.bigroad.shared.eobr.C0973f;
import com.bigroad.shared.eobr.turbo.C1000c;

public class TurboResponseMessage extends ak implements C0973f {
    public final int f3352d;
    public final TurboResponse f3353e;

    public enum TurboResponse implements C1000c {
        TURBO_RESPONSE_OK(0),
        TURBO_RESPONSE_TIMEOUT(1),
        TURBO_RESPONSE_OUT_OF_RESOURCES(2),
        TURBO_RESPONSE_INVALID_BUS(3),
        TURBO_RESPONSE_INVALID_PARAMETER(4),
        TURBO_RESPONSE_INVALID_SIGNATURE(5),
        TURBO_RESPONSE_ERROR_STATE(6),
        TURBO_RESPONSE_UNSUPPORTED_OPERATION(7),
        TURBO_RESPONSE_UNKNOWN(8);
        
        private final int m_id;

        private TurboResponse(int i) {
            this.m_id = i;
        }

        public int mo760a() {
            return this.m_id;
        }

        public boolean mo761b() {
            return this == TURBO_RESPONSE_UNKNOWN;
        }
    }

    public TurboResponseMessage(int i, TurboResponse turboResponse) {
        this.f3352d = i;
        this.f3353e = turboResponse;
    }

    public int mo743e() {
        return this.f3352d;
    }

    public boolean mo744f() {
        return this.f3353e == TurboResponse.TURBO_RESPONSE_OK;
    }

    public String mo745g() {
        return this.f3353e.toString();
    }
}
