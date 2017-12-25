package com.google.android.gms.internal;

import com.facebook.internal.NativeProtocol;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class zzapo {
    private final ByteBuffer f11357a;

    public static class zza extends IOException {
        zza(int i, int i2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i + " limit " + i2 + ").");
        }
    }

    private zzapo(ByteBuffer byteBuffer) {
        this.f11357a = byteBuffer;
        this.f11357a.order(ByteOrder.LITTLE_ENDIAN);
    }

    private zzapo(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    private static int m17306a(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) < '') {
            i++;
        }
        int i2 = i;
        i = length;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            if (charAt >= 'ࠀ') {
                i += m17307a(charSequence, i2);
                break;
            }
            i2++;
            i = ((127 - charAt) >>> 31) + i;
        }
        if (i >= length) {
            return i;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i) + 4294967296L));
    }

    private static int m17307a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        int i3 = i;
        while (i3 < length) {
            char charAt = charSequence.charAt(i3);
            if (charAt < 'ࠀ') {
                i2 += (127 - charAt) >>> 31;
            } else {
                i2 += 2;
                if ('?' <= charAt && charAt <= '?') {
                    if (Character.codePointAt(charSequence, i3) < NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) {
                        throw new IllegalArgumentException("Unpaired surrogate at index " + i3);
                    }
                    i3++;
                }
            }
            i3++;
        }
        return i2;
    }

    private static int m17308a(CharSequence charSequence, byte[] bArr, int i, int i2) {
        int length = charSequence.length();
        int i3 = 0;
        int i4 = i + i2;
        while (i3 < length && i3 + i < i4) {
            char charAt = charSequence.charAt(i3);
            if (charAt >= '') {
                break;
            }
            bArr[i + i3] = (byte) charAt;
            i3++;
        }
        if (i3 == length) {
            return i + length;
        }
        int i5 = i + i3;
        while (i3 < length) {
            int i6;
            char charAt2 = charSequence.charAt(i3);
            if (charAt2 < '' && i5 < i4) {
                i6 = i5 + 1;
                bArr[i5] = (byte) charAt2;
            } else if (charAt2 < 'ࠀ' && i5 <= i4 - 2) {
                r6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 >>> 6) | 960);
                i6 = r6 + 1;
                bArr[r6] = (byte) ((charAt2 & 63) | 128);
            } else if ((charAt2 < '?' || '?' < charAt2) && i5 <= i4 - 3) {
                i6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 >>> 12) | 480);
                i5 = i6 + 1;
                bArr[i6] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 & 63) | 128);
            } else if (i5 <= i4 - 4) {
                if (i3 + 1 != charSequence.length()) {
                    i3++;
                    charAt = charSequence.charAt(i3);
                    if (Character.isSurrogatePair(charAt2, charAt)) {
                        int toCodePoint = Character.toCodePoint(charAt2, charAt);
                        i6 = i5 + 1;
                        bArr[i5] = (byte) ((toCodePoint >>> 18) | 240);
                        i5 = i6 + 1;
                        bArr[i6] = (byte) (((toCodePoint >>> 12) & 63) | 128);
                        r6 = i5 + 1;
                        bArr[i5] = (byte) (((toCodePoint >>> 6) & 63) | 128);
                        i6 = r6 + 1;
                        bArr[r6] = (byte) ((toCodePoint & 63) | 128);
                    }
                }
                throw new IllegalArgumentException("Unpaired surrogate at index " + (i3 - 1));
            } else {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i5);
            }
            i3++;
            i5 = i6;
        }
        return i5;
    }

    private static void m17309a(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        } else if (byteBuffer.hasArray()) {
            try {
                byteBuffer.position(m17308a(charSequence, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()) - byteBuffer.arrayOffset());
            } catch (Throwable e) {
                BufferOverflowException bufferOverflowException = new BufferOverflowException();
                bufferOverflowException.initCause(e);
                throw bufferOverflowException;
            }
        } else {
            m17310b(charSequence, byteBuffer);
        }
    }

    private static void m17310b(CharSequence charSequence, ByteBuffer byteBuffer) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < '') {
                byteBuffer.put((byte) charAt);
            } else if (charAt < 'ࠀ') {
                byteBuffer.put((byte) ((charAt >>> 6) | 960));
                byteBuffer.put((byte) ((charAt & 63) | 128));
            } else if (charAt < '?' || '?' < charAt) {
                byteBuffer.put((byte) ((charAt >>> 12) | 480));
                byteBuffer.put((byte) (((charAt >>> 6) & 63) | 128));
                byteBuffer.put((byte) ((charAt & 63) | 128));
            } else {
                if (i + 1 != charSequence.length()) {
                    i++;
                    char charAt2 = charSequence.charAt(i);
                    if (Character.isSurrogatePair(charAt, charAt2)) {
                        int toCodePoint = Character.toCodePoint(charAt, charAt2);
                        byteBuffer.put((byte) ((toCodePoint >>> 18) | 240));
                        byteBuffer.put((byte) (((toCodePoint >>> 12) & 63) | 128));
                        byteBuffer.put((byte) (((toCodePoint >>> 6) & 63) | 128));
                        byteBuffer.put((byte) ((toCodePoint & 63) | 128));
                    }
                }
                throw new IllegalArgumentException("Unpaired surrogate at index " + (i - 1));
            }
            i++;
        }
    }

    public static int zzafx(int i) {
        return i >= 0 ? zzagc(i) : 10;
    }

    public static int zzafy(int i) {
        return zzagc(zzage(i));
    }

    public static int zzag(int i, int i2) {
        return zzaga(i) + zzafx(i2);
    }

    public static int zzaga(int i) {
        return zzagc(zzapy.zzaj(i, 0));
    }

    public static int zzagc(int i) {
        return (i & -128) == 0 ? 1 : (i & -16384) == 0 ? 2 : (-2097152 & i) == 0 ? 3 : (-268435456 & i) == 0 ? 4 : 5;
    }

    public static int zzage(int i) {
        return (i << 1) ^ (i >> 31);
    }

    public static int zzah(int i, int i2) {
        return zzaga(i) + zzafy(i2);
    }

    public static int zzb(int i, double d) {
        return zzaga(i) + zzp(d);
    }

    public static int zzb(int i, zzapv com_google_android_gms_internal_zzapv) {
        return (zzaga(i) * 2) + zzd(com_google_android_gms_internal_zzapv);
    }

    public static int zzb(int i, byte[] bArr) {
        return zzaga(i) + zzbg(bArr);
    }

    public static zzapo zzbe(byte[] bArr) {
        return zzc(bArr, 0, bArr.length);
    }

    public static int zzbg(byte[] bArr) {
        return zzagc(bArr.length) + bArr.length;
    }

    public static int zzc(int i, zzapv com_google_android_gms_internal_zzapv) {
        return zzaga(i) + zze(com_google_android_gms_internal_zzapv);
    }

    public static zzapo zzc(byte[] bArr, int i, int i2) {
        return new zzapo(bArr, i, i2);
    }

    public static int zzcx(long j) {
        return zzdc(j);
    }

    public static int zzcy(long j) {
        return zzdc(j);
    }

    public static int zzcz(long j) {
        return 8;
    }

    public static int zzd(int i, float f) {
        return zzaga(i) + zzl(f);
    }

    public static int zzd(zzapv com_google_android_gms_internal_zzapv) {
        return com_google_android_gms_internal_zzapv.aM();
    }

    public static int zzda(long j) {
        return zzdc(zzde(j));
    }

    public static int zzdc(long j) {
        return (-128 & j) == 0 ? 1 : (-16384 & j) == 0 ? 2 : (-2097152 & j) == 0 ? 3 : (-268435456 & j) == 0 ? 4 : (-34359738368L & j) == 0 ? 5 : (-4398046511104L & j) == 0 ? 6 : (-562949953421312L & j) == 0 ? 7 : (-72057594037927936L & j) == 0 ? 8 : (Long.MIN_VALUE & j) == 0 ? 9 : 10;
    }

    public static long zzde(long j) {
        return (j << 1) ^ (j >> 63);
    }

    public static int zzdg(boolean z) {
        return 1;
    }

    public static int zze(int i, long j) {
        return zzaga(i) + zzcy(j);
    }

    public static int zze(zzapv com_google_android_gms_internal_zzapv) {
        int aM = com_google_android_gms_internal_zzapv.aM();
        return aM + zzagc(aM);
    }

    public static int zzf(int i, long j) {
        return zzaga(i) + zzcz(j);
    }

    public static int zzg(int i, long j) {
        return zzaga(i) + zzda(j);
    }

    public static int zzk(int i, boolean z) {
        return zzaga(i) + zzdg(z);
    }

    public static int zzl(float f) {
        return 4;
    }

    public static int zzp(double d) {
        return 8;
    }

    public static int zzs(int i, String str) {
        return zzaga(i) + zztx(str);
    }

    public static int zztx(String str) {
        int a = m17306a(str);
        return a + zzagc(a);
    }

    public int ay() {
        return this.f11357a.remaining();
    }

    public void az() {
        if (ay() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public void zza(int i, double d) {
        zzai(i, 1);
        zzo(d);
    }

    public void zza(int i, long j) {
        zzai(i, 0);
        zzct(j);
    }

    public void zza(int i, zzapv com_google_android_gms_internal_zzapv) {
        zzai(i, 2);
        zzc(com_google_android_gms_internal_zzapv);
    }

    public void zza(int i, byte[] bArr) {
        zzai(i, 2);
        zzbf(bArr);
    }

    public void zzae(int i, int i2) {
        zzai(i, 0);
        zzafv(i2);
    }

    public void zzaf(int i, int i2) {
        zzai(i, 0);
        zzafw(i2);
    }

    public void zzafv(int i) {
        if (i >= 0) {
            zzagb(i);
        } else {
            zzdb((long) i);
        }
    }

    public void zzafw(int i) {
        zzagb(zzage(i));
    }

    public void zzafz(int i) {
        zzc((byte) i);
    }

    public void zzagb(int i) {
        while ((i & -128) != 0) {
            zzafz((i & 127) | 128);
            i >>>= 7;
        }
        zzafz(i);
    }

    public void zzagd(int i) {
        if (this.f11357a.remaining() < 4) {
            throw new zza(this.f11357a.position(), this.f11357a.limit());
        }
        this.f11357a.putInt(i);
    }

    public void zzai(int i, int i2) {
        zzagb(zzapy.zzaj(i, i2));
    }

    public void zzb(int i, long j) {
        zzai(i, 0);
        zzcu(j);
    }

    public void zzb(zzapv com_google_android_gms_internal_zzapv) {
        com_google_android_gms_internal_zzapv.zza(this);
    }

    public void zzbf(byte[] bArr) {
        zzagb(bArr.length);
        zzbh(bArr);
    }

    public void zzbh(byte[] bArr) {
        zzd(bArr, 0, bArr.length);
    }

    public void zzc(byte b) {
        if (this.f11357a.hasRemaining()) {
            this.f11357a.put(b);
            return;
        }
        throw new zza(this.f11357a.position(), this.f11357a.limit());
    }

    public void zzc(int i, float f) {
        zzai(i, 5);
        zzk(f);
    }

    public void zzc(int i, long j) {
        zzai(i, 1);
        zzcv(j);
    }

    public void zzc(zzapv com_google_android_gms_internal_zzapv) {
        zzagb(com_google_android_gms_internal_zzapv.aL());
        com_google_android_gms_internal_zzapv.zza(this);
    }

    public void zzct(long j) {
        zzdb(j);
    }

    public void zzcu(long j) {
        zzdb(j);
    }

    public void zzcv(long j) {
        zzdd(j);
    }

    public void zzcw(long j) {
        zzdb(zzde(j));
    }

    public void zzd(int i, long j) {
        zzai(i, 0);
        zzcw(j);
    }

    public void zzd(byte[] bArr, int i, int i2) {
        if (this.f11357a.remaining() >= i2) {
            this.f11357a.put(bArr, i, i2);
            return;
        }
        throw new zza(this.f11357a.position(), this.f11357a.limit());
    }

    public void zzdb(long j) {
        while ((-128 & j) != 0) {
            zzafz((((int) j) & 127) | 128);
            j >>>= 7;
        }
        zzafz((int) j);
    }

    public void zzdd(long j) {
        if (this.f11357a.remaining() < 8) {
            throw new zza(this.f11357a.position(), this.f11357a.limit());
        }
        this.f11357a.putLong(j);
    }

    public void zzdf(boolean z) {
        zzafz(z ? 1 : 0);
    }

    public void zzj(int i, boolean z) {
        zzai(i, 0);
        zzdf(z);
    }

    public void zzk(float f) {
        zzagd(Float.floatToIntBits(f));
    }

    public void zzo(double d) {
        zzdd(Double.doubleToLongBits(d));
    }

    public void zzr(int i, String str) {
        zzai(i, 2);
        zztw(str);
    }

    public void zztw(String str) {
        try {
            int zzagc = zzagc(str.length());
            if (zzagc == zzagc(str.length() * 3)) {
                int position = this.f11357a.position();
                if (this.f11357a.remaining() < zzagc) {
                    throw new zza(zzagc + position, this.f11357a.limit());
                }
                this.f11357a.position(position + zzagc);
                m17309a((CharSequence) str, this.f11357a);
                int position2 = this.f11357a.position();
                this.f11357a.position(position);
                zzagb((position2 - position) - zzagc);
                this.f11357a.position(position2);
                return;
            }
            zzagb(m17306a(str));
            m17309a((CharSequence) str, this.f11357a);
        } catch (Throwable e) {
            zza com_google_android_gms_internal_zzapo_zza = new zza(this.f11357a.position(), this.f11357a.limit());
            com_google_android_gms_internal_zzapo_zza.initCause(e);
            throw com_google_android_gms_internal_zzapo_zza;
        }
    }
}
