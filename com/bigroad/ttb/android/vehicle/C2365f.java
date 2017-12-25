package com.bigroad.ttb.android.vehicle;

import com.android.internal.util.Predicate;
import com.bigroad.shared.eobr.turbo.C1015l;
import com.bigroad.ttb.protocol.TTProtocol.RelativeTimestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class C2365f implements C2364g {
    private ProcessingState f8162a = ProcessingState.NOT_PROCESSING;
    private RelativeTimestamp f8163b = null;
    private C1015l f8164c = null;
    private List<Predicate<C2364g>> f8165d = new ArrayList();

    public void mo1286a(Predicate<C2364g> predicate) {
        this.f8165d.add(predicate);
    }

    public ProcessingState mo1285a() {
        return this.f8162a;
    }

    public void m11558a(ProcessingState processingState) {
        this.f8162a = processingState;
    }

    public void m11559a(RelativeTimestamp relativeTimestamp) {
        this.f8163b = relativeTimestamp;
    }

    public RelativeTimestamp m11560b() {
        return this.f8163b;
    }

    public void m11557a(C1015l c1015l) {
        this.f8164c = c1015l;
    }

    public C1015l m11561c() {
        return this.f8164c;
    }

    public C1015l mo1284a(C1015l c1015l, RelativeTimestamp relativeTimestamp, long j) {
        if (c1015l == null || relativeTimestamp == null) {
            return null;
        }
        if (this.f8164c == null || j >= relativeTimestamp.getAbsoluteTimeMillis()) {
            return c1015l;
        }
        return this.f8164c;
    }

    public boolean m11562d() {
        ListIterator listIterator = this.f8165d.listIterator();
        while (listIterator.hasNext()) {
            if (((Predicate) listIterator.next()).apply(this)) {
                listIterator.remove();
            }
        }
        return this.f8165d.isEmpty();
    }
}
