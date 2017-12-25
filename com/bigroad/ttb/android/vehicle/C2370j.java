package com.bigroad.ttb.android.vehicle;

import com.bigroad.shared.eobr.turbo.C1015l;
import com.bigroad.shared.eobr.turbo.logs.C1024d;
import com.bigroad.ttb.android.eobr.EobrDevice;
import com.bigroad.ttb.android.vehicle.task.C2379j;
import com.bigroad.ttb.protocol.TTProtocol.RelativeTimestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public class C2370j {
    private static final Set<ProcessingState> f8201a = Collections.unmodifiableSet(EnumSet.of(ProcessingState.BEFORE_CURSOR, ProcessingState.AT_CURSOR, ProcessingState.TEMPORALLY_AT_CURSOR, ProcessingState.INCREMENTING_CURSOR));
    private final C2364g f8202b;
    private List<C2379j> f8203c = new ArrayList();

    private static boolean m11624a(ProcessingState processingState) {
        return f8201a.contains(processingState);
    }

    public C2370j(C2364g c2364g) {
        this.f8202b = c2364g;
    }

    public C2364g m11626a() {
        return this.f8202b;
    }

    public void m11629a(C2379j c2379j) {
        if (C2370j.m11624a(this.f8202b.mo1285a())) {
            this.f8203c.add(c2379j);
        }
    }

    public boolean m11630a(Class<? extends C2379j> cls) {
        for (C2379j c2379j : this.f8203c) {
            if (c2379j.getClass() == cls) {
                return true;
            }
        }
        return false;
    }

    private void m11625b() {
        for (C2379j a : this.f8203c) {
            a.mo1289a();
        }
        this.f8203c.clear();
    }

    public void m11627a(EobrDevice eobrDevice, C1015l c1015l, RelativeTimestamp relativeTimestamp, C2358c c2358c, C2369i c2369i, C1024d c1024d) {
        if (C2370j.m11624a(this.f8202b.mo1285a())) {
            int i = 0;
            while (i < this.f8203c.size()) {
                C2379j c2379j = (C2379j) this.f8203c.get(i);
                if (!c2379j.mo1291a(eobrDevice, c1015l, relativeTimestamp, c2358c, this.f8202b.mo1285a(), c2369i, this, c1024d)) {
                    int i2 = i - 1;
                    this.f8203c.remove(i);
                    c2379j.mo1289a();
                    i = i2;
                }
                i++;
            }
        }
    }

    protected void m11628a(C2358c c2358c) {
        for (C2379j a : this.f8203c) {
            a.mo1290a(c2358c, this.f8202b.mo1285a(), this);
        }
        m11625b();
    }
}
