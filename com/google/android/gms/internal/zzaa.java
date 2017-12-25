package com.google.android.gms.internal;

import java.io.ByteArrayOutputStream;

public class zzaa extends ByteArrayOutputStream {
    private final zzu f11070a;

    public zzaa(zzu com_google_android_gms_internal_zzu, int i) {
        this.f11070a = com_google_android_gms_internal_zzu;
        this.buf = this.f11070a.zzb(Math.max(i, 256));
    }

    private void m17128a(int i) {
        if (this.count + i > this.buf.length) {
            Object zzb = this.f11070a.zzb((this.count + i) * 2);
            System.arraycopy(this.buf, 0, zzb, 0, this.count);
            this.f11070a.zza(this.buf);
            this.buf = zzb;
        }
    }

    public void close() {
        this.f11070a.zza(this.buf);
        this.buf = null;
        super.close();
    }

    public void finalize() {
        this.f11070a.zza(this.buf);
    }

    public synchronized void write(int i) {
        m17128a(1);
        super.write(i);
    }

    public synchronized void write(byte[] bArr, int i, int i2) {
        m17128a(i2);
        super.write(bArr, i, i2);
    }
}
