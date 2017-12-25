package com.bigroad.ttb.android.eobr.genx;

import com.bigroad.shared.am;
import com.bigroad.shared.eobr.genx.C0976j;
import com.bigroad.shared.eobr.genx.C0987k;
import com.bigroad.shared.eobr.turbo.C1015l;
import com.bigroad.ttb.android.eobr.EobrDevice;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.p035d.C1790a;
import com.bigroad.ttb.android.p035d.p036a.C1766e;
import com.bigroad.ttb.android.p035d.p036a.C1776o;
import java.io.IOException;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class C1921e {
    private C1766e f6644a;
    private SortedMap<Long, C1776o> f6645b = new TreeMap();

    public void m9452a(C1790a c1790a, C1015l c1015l) {
        c1790a.m8771d(this.f6645b.values());
        if (c1015l != null) {
            this.f6645b.headMap(Long.valueOf(c1015l.m5228a() - 42)).clear();
        } else {
            this.f6645b.clear();
        }
        if (this.f6644a != null && this.f6644a.m8585g()) {
            C2134e.m10676b("TT-GenxMemoryCache", "Storing Genx sync progress: " + this.f6644a);
            c1790a.m8730a(this.f6644a);
            this.f6644a.m8586h();
        } else if (this.f6644a == null) {
            C2134e.m10676b("TT-GenxMemoryCache", "No Genx sync progress to store");
        } else {
            C2134e.m10676b("TT-GenxMemoryCache", "Genx sync progress is not dirty: " + this.f6644a);
        }
    }

    public void m9448a() {
        this.f6645b.clear();
    }

    public boolean m9456a(long j) {
        return this.f6645b.containsKey(Long.valueOf(j));
    }

    public C0976j m9457b(long j) {
        try {
            C1776o c1776o = (C1776o) this.f6645b.get(Long.valueOf(j));
            if (c1776o == null) {
                return null;
            }
            if (c1776o.m8623f()) {
                return c1776o.m8620b();
            }
            return new C0987k(j);
        } catch (IOException e) {
            C2134e.m10680d("TT-GenxMemoryCache", "Unable to parse entry " + j + ": " + e.getMessage());
        }
    }

    public void m9449a(C0976j c0976j) {
        C1776o a = this.f6644a.m8576a(c0976j);
        this.f6645b.put(Long.valueOf(a.m8622e()), a);
    }

    public void m9451a(C1776o c1776o) {
        this.f6645b.put(Long.valueOf(c1776o.m8622e()), c1776o);
    }

    public void m9455a(List<Long> list) {
        for (Long l : list) {
            if (this.f6645b.containsKey(l)) {
                ((C1776o) this.f6645b.get(l)).m8619a(true);
            }
        }
    }

    public void m9458b() {
        C2134e.m10673a("TT-GenxMemoryCache", "Clearing Genx sync progress");
        this.f6644a = null;
    }

    public void m9453a(C1790a c1790a, EobrDevice eobrDevice) {
        this.f6644a = c1790a.m8790i(eobrDevice.mo1119g());
        C2134e.m10673a("TT-GenxMemoryCache", "Loaded Genx sync progress: " + this.f6644a);
    }

    public String m9460c() {
        return this.f6644a != null ? this.f6644a.m8581b() : null;
    }

    public Long m9461d() {
        return this.f6644a != null ? this.f6644a.m8582d() : null;
    }

    public void m9454a(Long l) {
        if (this.f6644a != null) {
            this.f6644a.m8580a(l);
        }
    }

    public void m9462e() {
        if (this.f6644a != null) {
            this.f6644a.m8579a(null);
        }
    }

    public C1015l m9463f() {
        if (this.f6644a != null) {
            return this.f6644a.m8584f();
        }
        C2134e.m10680d("TT-GenxMemoryCache", "Attempted to get last stored cursor position before initializing sync progress");
        return null;
    }

    public void m9450a(C1015l c1015l) {
        if (this.f6644a == null) {
            C2134e.m10680d("TT-GenxMemoryCache", "Attempted to set last stored cursor position before initializing sync progress");
        } else {
            this.f6644a.m8579a(c1015l);
        }
    }

    public Long m9447a(C1790a c1790a, String str, long j) {
        C1766e i;
        if (this.f6644a == null || !am.m4189a(this.f6644a.m8581b(), str)) {
            i = c1790a.m8790i(str);
        } else {
            i = this.f6644a;
        }
        Long e = i.m8583e();
        if (e == null || j > e.longValue()) {
            i.m8578a(j);
            c1790a.m8730a(i);
        }
        return i.m8583e();
    }

    public Long m9459c(long j) {
        SortedMap tailMap = this.f6645b.tailMap(Long.valueOf(1 + j));
        if (tailMap.isEmpty()) {
            return null;
        }
        return (Long) tailMap.firstKey();
    }
}
