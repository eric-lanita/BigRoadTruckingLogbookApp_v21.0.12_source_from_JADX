package com.bigroad.shared;

import com.bigroad.shared.eobr.ConnectionError;
import com.bigroad.shared.eobr.ConnectionFlag;
import com.bigroad.shared.eobr.ConnectionSetupFlag;
import java.util.Collection;

public class C1096h {
    public static long m5440a(long j, boolean z, Collection<ConnectionSetupFlag> collection, Collection<ConnectionFlag> collection2, ConnectionError connectionError) {
        long a = C1096h.m5439a(j);
        long j2 = a;
        for (ConnectionSetupFlag a2 : collection) {
            j2 = a2.m4929a() | j2;
        }
        for (ConnectionFlag a3 : collection2) {
            j2 |= a3.m4928a();
        }
        if (connectionError != null) {
            j2 |= (long) (connectionError.ordinal() << 18);
        }
        return (z ? 1024 : 2048) | j2;
    }

    private static long m5439a(long j) {
        if ((j & 8589934592L) == 8589934592L) {
            return j & 4294967295L;
        }
        return j;
    }
}
