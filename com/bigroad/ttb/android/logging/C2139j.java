package com.bigroad.ttb.android.logging;

import java.util.ArrayList;
import java.util.Iterator;

public final class C2139j implements C2127h {
    private final ArrayList<C2127h> f7465a = new ArrayList();

    public synchronized void mo1242a(int i, String str, String str2) {
        Iterator it = this.f7465a.iterator();
        while (it.hasNext()) {
            ((C2127h) it.next()).mo1242a(i, str, str2);
        }
    }

    public synchronized void mo1243a(long j, int i, String str, String str2) {
        Iterator it = this.f7465a.iterator();
        while (it.hasNext()) {
            ((C2127h) it.next()).mo1243a(j, i, str, str2);
        }
    }

    public synchronized void mo1241a() {
        Iterator it = this.f7465a.iterator();
        while (it.hasNext()) {
            ((C2127h) it.next()).mo1241a();
        }
    }

    public synchronized void m10697a(C2127h c2127h) {
        this.f7465a.add(c2127h);
    }
}
