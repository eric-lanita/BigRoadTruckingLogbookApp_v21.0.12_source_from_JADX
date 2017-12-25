package com.google.android.gms.internal;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class zzaod extends zzaoo {
    private static final Writer f11294a = new C32921();
    private static final zzanb f11295b = new zzanb("closed");
    private final List<zzamv> f11296c = new ArrayList();
    private String f11297d;
    private zzamv f11298e = zzamx.bei;

    static class C32921 extends Writer {
        C32921() {
        }

        public void close() {
            throw new AssertionError();
        }

        public void flush() {
            throw new AssertionError();
        }

        public void write(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }
    }

    public zzaod() {
        super(f11294a);
    }

    private zzamv m17279a() {
        return (zzamv) this.f11296c.get(this.f11296c.size() - 1);
    }

    private void m17280a(zzamv com_google_android_gms_internal_zzamv) {
        if (this.f11297d != null) {
            if (!com_google_android_gms_internal_zzamv.zzczj() || m17278y()) {
                ((zzamy) m17279a()).zza(this.f11297d, com_google_android_gms_internal_zzamv);
            }
            this.f11297d = null;
        } else if (this.f11296c.isEmpty()) {
            this.f11298e = com_google_android_gms_internal_zzamv;
        } else {
            zzamv a = m17279a();
            if (a instanceof zzams) {
                ((zzams) a).zzc(com_google_android_gms_internal_zzamv);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public void close() {
        if (this.f11296c.isEmpty()) {
            this.f11296c.add(f11295b);
            return;
        }
        throw new IOException("Incomplete document");
    }

    public zzamv m17281f() {
        if (this.f11296c.isEmpty()) {
            return this.f11298e;
        }
        String valueOf = String.valueOf(this.f11296c);
        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 34).append("Expected one JSON element but was ").append(valueOf).toString());
    }

    public void flush() {
    }

    public zzaoo mo1854h() {
        zzamv com_google_android_gms_internal_zzams = new zzams();
        m17280a(com_google_android_gms_internal_zzams);
        this.f11296c.add(com_google_android_gms_internal_zzams);
        return this;
    }

    public zzaoo mo1855i() {
        if (this.f11296c.isEmpty() || this.f11297d != null) {
            throw new IllegalStateException();
        } else if (m17279a() instanceof zzams) {
            this.f11296c.remove(this.f11296c.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public zzaoo mo1856j() {
        zzamv com_google_android_gms_internal_zzamy = new zzamy();
        m17280a(com_google_android_gms_internal_zzamy);
        this.f11296c.add(com_google_android_gms_internal_zzamy);
        return this;
    }

    public zzaoo mo1857k() {
        if (this.f11296c.isEmpty() || this.f11297d != null) {
            throw new IllegalStateException();
        } else if (m17279a() instanceof zzamy) {
            this.f11296c.remove(this.f11296c.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public zzaoo mo1858l() {
        m17280a(zzamx.bei);
        return this;
    }

    public zzaoo zza(Number number) {
        if (number == null) {
            return mo1858l();
        }
        if (!isLenient()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                String valueOf = String.valueOf(number);
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 33).append("JSON forbids NaN and infinities: ").append(valueOf).toString());
            }
        }
        m17280a(new zzanb(number));
        return this;
    }

    public zzaoo zzcr(long j) {
        m17280a(new zzanb(Long.valueOf(j)));
        return this;
    }

    public zzaoo zzda(boolean z) {
        m17280a(new zzanb(Boolean.valueOf(z)));
        return this;
    }

    public zzaoo zztr(String str) {
        if (this.f11296c.isEmpty() || this.f11297d != null) {
            throw new IllegalStateException();
        } else if (m17279a() instanceof zzamy) {
            this.f11297d = str;
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public zzaoo zzts(String str) {
        if (str == null) {
            return mo1858l();
        }
        m17280a(new zzanb(str));
        return this;
    }
}
