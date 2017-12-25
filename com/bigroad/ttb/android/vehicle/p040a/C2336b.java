package com.bigroad.ttb.android.vehicle.p040a;

import com.bigroad.shared.eobr.turbo.C1015l;
import com.bigroad.ttb.android.vehicle.p041b.C2347j;
import com.bigroad.ttb.protocol.TTProtocol.RelativeTimestamp;
import com.google.common.collect.ImmutableList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class C2336b {
    private final C2337d f8101a;
    private final List<C2333c> f8102b;
    private final Queue<C2347j> f8103c = new LinkedList();
    private C2335a f8104d = null;

    private static class C2335a {
        public final RelativeTimestamp f8099a;
        public final C1015l f8100b;

        public C2335a(RelativeTimestamp relativeTimestamp, C1015l c1015l) {
            this.f8099a = relativeTimestamp;
            this.f8100b = c1015l;
        }
    }

    public C2336b(C2337d c2337d, C2333c... c2333cArr) {
        this.f8101a = c2337d;
        this.f8102b = ImmutableList.m18512a((Object[]) c2333cArr);
    }

    public void m11440a(C2347j c2347j) {
        if (c2347j != null) {
            this.f8103c.add(c2347j);
            this.f8104d = null;
            for (C2333c a : this.f8102b) {
                a.mo1279a(c2347j);
            }
            m11438a();
        }
    }

    public void m11439a(C1015l c1015l, RelativeTimestamp relativeTimestamp) {
        if (relativeTimestamp != null && c1015l != null) {
            this.f8104d = new C2335a(relativeTimestamp, c1015l);
            for (C2333c a : this.f8102b) {
                a.mo1280a(relativeTimestamp);
            }
            m11438a();
        }
    }

    private void m11438a() {
        if (!this.f8103c.isEmpty()) {
            Set hashSet = new HashSet();
            for (C2333c a : this.f8102b) {
                C2347j a2 = a.mo1278a();
                if (a2 != null) {
                    hashSet.add(a2);
                }
            }
            while (!this.f8103c.isEmpty() && !hashSet.contains(this.f8103c.peek())) {
                this.f8101a.mo1283a((C2347j) this.f8103c.remove());
            }
        }
        if (this.f8103c.isEmpty() && this.f8104d != null) {
            this.f8101a.mo1282a(this.f8104d.f8100b, this.f8104d.f8099a);
            this.f8104d = null;
        }
    }
}
