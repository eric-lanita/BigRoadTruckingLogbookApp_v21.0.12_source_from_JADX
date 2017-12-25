package com.bigroad.shared.validation;

import com.bigroad.shared.al;
import com.bigroad.shared.ao;
import com.bigroad.shared.model.CanonicalMalfunctionType;
import com.bigroad.shared.validation.ValidationError.Category;
import com.bigroad.shared.validation.ValidationError.ErrorCode;
import com.bigroad.shared.validation.ValidationError.Severity;
import java.util.Comparator;

public class C1168m extends ValidationError {
    public static final Comparator<? super C1168m> f3954a = new C11741();
    protected final ao f3955b;
    private final CanonicalMalfunctionType f3956d;

    static class C11741 implements Comparator<C1168m> {
        C11741() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m5951a((C1168m) obj, (C1168m) obj2);
        }

        public int m5951a(C1168m c1168m, C1168m c1168m2) {
            return Long.signum(c1168m.m5940a().mo697f() - c1168m2.m5940a().mo697f());
        }
    }

    public C1168m(ao aoVar, ErrorCode errorCode, C1175o c1175o, Severity severity, Category category, CanonicalMalfunctionType canonicalMalfunctionType) {
        super(errorCode, c1175o, severity, category);
        this.f3955b = aoVar;
        this.f3956d = canonicalMalfunctionType;
    }

    public C1168m(long j, long j2, ErrorCode errorCode, C1175o c1175o) {
        this(new al(j, j2), errorCode, c1175o);
    }

    public C1168m(ao aoVar, ErrorCode errorCode, C1175o c1175o) {
        this(aoVar, errorCode, c1175o, Severity.ERROR, Category.DRIVE_TIME, null);
    }

    public ao m5940a() {
        return this.f3955b;
    }

    public C1168m m5941a(ao aoVar) {
        if (this.f3955b.mo693b(aoVar)) {
            return new C1168m(this.f3955b.mo696e(aoVar), m5780b(), m5781c());
        }
        return null;
    }
}
