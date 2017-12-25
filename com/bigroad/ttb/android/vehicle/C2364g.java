package com.bigroad.ttb.android.vehicle;

import com.android.internal.util.Predicate;
import com.bigroad.shared.eobr.turbo.C1015l;
import com.bigroad.ttb.protocol.TTProtocol.RelativeTimestamp;

public interface C2364g {
    C1015l mo1284a(C1015l c1015l, RelativeTimestamp relativeTimestamp, long j);

    ProcessingState mo1285a();

    void mo1286a(Predicate<C2364g> predicate);
}
