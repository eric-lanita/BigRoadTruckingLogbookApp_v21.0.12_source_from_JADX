package com.google.android.gms.internal;

public final class zzapn {
    private final byte[] f11347a;
    private int f11348b;
    private int f11349c;
    private int f11350d;
    private int f11351e;
    private int f11352f;
    private int f11353g = Integer.MAX_VALUE;
    private int f11354h;
    private int f11355i = 64;
    private int f11356j = 67108864;

    private zzapn(byte[] bArr, int i, int i2) {
        this.f11347a = bArr;
        this.f11348b = i;
        this.f11349c = i + i2;
        this.f11351e = i;
    }

    private void m17305a() {
        this.f11349c += this.f11350d;
        int i = this.f11349c;
        if (i > this.f11353g) {
            this.f11350d = i - this.f11353g;
            this.f11349c -= this.f11350d;
            return;
        }
        this.f11350d = 0;
    }

    public static int zzafq(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    public static zzapn zzb(byte[] bArr, int i, int i2) {
        return new zzapn(bArr, i, i2);
    }

    public static zzapn zzbd(byte[] bArr) {
        return zzb(bArr, 0, bArr.length);
    }

    public static long zzcs(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    public int ah() {
        if (aw()) {
            this.f11352f = 0;
            return 0;
        }
        this.f11352f = aq();
        if (this.f11352f != 0) {
            return this.f11352f;
        }
        throw zzapu.m17339d();
    }

    public void ai() {
        int ah;
        do {
            ah = ah();
            if (ah == 0) {
                return;
            }
        } while (zzafp(ah));
    }

    public long aj() {
        return ar();
    }

    public long ak() {
        return ar();
    }

    public int al() {
        return aq();
    }

    public long am() {
        return at();
    }

    public boolean an() {
        return aq() != 0;
    }

    public int ao() {
        return zzafq(aq());
    }

    public long ap() {
        return zzcs(ar());
    }

    public int aq() {
        byte ax = ax();
        if (ax >= (byte) 0) {
            return ax;
        }
        int i = ax & 127;
        byte ax2 = ax();
        if (ax2 >= (byte) 0) {
            return i | (ax2 << 7);
        }
        i |= (ax2 & 127) << 7;
        ax2 = ax();
        if (ax2 >= (byte) 0) {
            return i | (ax2 << 14);
        }
        i |= (ax2 & 127) << 14;
        ax2 = ax();
        if (ax2 >= (byte) 0) {
            return i | (ax2 << 21);
        }
        i |= (ax2 & 127) << 21;
        ax2 = ax();
        i |= ax2 << 28;
        if (ax2 >= (byte) 0) {
            return i;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (ax() >= (byte) 0) {
                return i;
            }
        }
        throw zzapu.m17338c();
    }

    public long ar() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte ax = ax();
            j |= ((long) (ax & 127)) << i;
            if ((ax & 128) == 0) {
                return j;
            }
        }
        throw zzapu.m17338c();
    }

    public int as() {
        return (((ax() & 255) | ((ax() & 255) << 8)) | ((ax() & 255) << 16)) | ((ax() & 255) << 24);
    }

    public long at() {
        byte ax = ax();
        byte ax2 = ax();
        return ((((((((((long) ax2) & 255) << 8) | (((long) ax) & 255)) | ((((long) ax()) & 255) << 16)) | ((((long) ax()) & 255) << 24)) | ((((long) ax()) & 255) << 32)) | ((((long) ax()) & 255) << 40)) | ((((long) ax()) & 255) << 48)) | ((((long) ax()) & 255) << 56);
    }

    public int av() {
        if (this.f11353g == Integer.MAX_VALUE) {
            return -1;
        }
        return this.f11353g - this.f11351e;
    }

    public boolean aw() {
        return this.f11351e == this.f11349c;
    }

    public byte ax() {
        if (this.f11351e == this.f11349c) {
            throw zzapu.m17336a();
        }
        byte[] bArr = this.f11347a;
        int i = this.f11351e;
        this.f11351e = i + 1;
        return bArr[i];
    }

    public int getPosition() {
        return this.f11351e - this.f11348b;
    }

    public byte[] readBytes() {
        int aq = aq();
        if (aq < 0) {
            throw zzapu.m17337b();
        } else if (aq == 0) {
            return zzapy.bjO;
        } else {
            if (aq > this.f11349c - this.f11351e) {
                throw zzapu.m17336a();
            }
            Object obj = new byte[aq];
            System.arraycopy(this.f11347a, this.f11351e, obj, 0, aq);
            this.f11351e = aq + this.f11351e;
            return obj;
        }
    }

    public double readDouble() {
        return Double.longBitsToDouble(at());
    }

    public float readFloat() {
        return Float.intBitsToFloat(as());
    }

    public String readString() {
        int aq = aq();
        if (aq < 0) {
            throw zzapu.m17337b();
        } else if (aq > this.f11349c - this.f11351e) {
            throw zzapu.m17336a();
        } else {
            String str = new String(this.f11347a, this.f11351e, aq, zzapt.f11369a);
            this.f11351e = aq + this.f11351e;
            return str;
        }
    }

    public void zza(zzapv com_google_android_gms_internal_zzapv) {
        int aq = aq();
        if (this.f11354h >= this.f11355i) {
            throw zzapu.m17342g();
        }
        aq = zzafr(aq);
        this.f11354h++;
        com_google_android_gms_internal_zzapv.zzb(this);
        zzafo(0);
        this.f11354h--;
        zzafs(aq);
    }

    public void zza(zzapv com_google_android_gms_internal_zzapv, int i) {
        if (this.f11354h >= this.f11355i) {
            throw zzapu.m17342g();
        }
        this.f11354h++;
        com_google_android_gms_internal_zzapv.zzb(this);
        zzafo(zzapy.zzaj(i, 4));
        this.f11354h--;
    }

    public byte[] zzad(int i, int i2) {
        if (i2 == 0) {
            return zzapy.bjO;
        }
        Object obj = new byte[i2];
        System.arraycopy(this.f11347a, this.f11348b + i, obj, 0, i2);
        return obj;
    }

    public void zzafo(int i) {
        if (this.f11352f != i) {
            throw zzapu.m17340e();
        }
    }

    public boolean zzafp(int i) {
        switch (zzapy.m17350a(i)) {
            case 0:
                al();
                return true;
            case 1:
                at();
                return true;
            case 2:
                zzafu(aq());
                return true;
            case 3:
                ai();
                zzafo(zzapy.zzaj(zzapy.zzagj(i), 4));
                return true;
            case 4:
                return false;
            case 5:
                as();
                return true;
            default:
                throw zzapu.m17341f();
        }
    }

    public int zzafr(int i) {
        if (i < 0) {
            throw zzapu.m17337b();
        }
        int i2 = this.f11351e + i;
        int i3 = this.f11353g;
        if (i2 > i3) {
            throw zzapu.m17336a();
        }
        this.f11353g = i2;
        m17305a();
        return i3;
    }

    public void zzafs(int i) {
        this.f11353g = i;
        m17305a();
    }

    public void zzaft(int i) {
        if (i > this.f11351e - this.f11348b) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.f11351e - this.f11348b));
        } else if (i < 0) {
            throw new IllegalArgumentException("Bad position " + i);
        } else {
            this.f11351e = this.f11348b + i;
        }
    }

    public void zzafu(int i) {
        if (i < 0) {
            throw zzapu.m17337b();
        } else if (this.f11351e + i > this.f11353g) {
            zzafu(this.f11353g - this.f11351e);
            throw zzapu.m17336a();
        } else if (i <= this.f11349c - this.f11351e) {
            this.f11351e += i;
        } else {
            throw zzapu.m17336a();
        }
    }
}
