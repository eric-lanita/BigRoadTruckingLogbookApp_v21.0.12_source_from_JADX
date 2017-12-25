package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class zzu {
    protected static final Comparator<byte[]> f11764a = new C33471();
    private List<byte[]> f11765b = new LinkedList();
    private List<byte[]> f11766c = new ArrayList(64);
    private int f11767d = 0;
    private final int f11768e;

    class C33471 implements Comparator<byte[]> {
        C33471() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return zza((byte[]) obj, (byte[]) obj2);
        }

        public int zza(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    }

    public zzu(int i) {
        this.f11768e = i;
    }

    private synchronized void m17567a() {
        while (this.f11767d > this.f11768e) {
            byte[] bArr = (byte[]) this.f11765b.remove(0);
            this.f11766c.remove(bArr);
            this.f11767d -= bArr.length;
        }
    }

    public synchronized void zza(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f11768e) {
                this.f11765b.add(bArr);
                int binarySearch = Collections.binarySearch(this.f11766c, bArr, f11764a);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.f11766c.add(binarySearch, bArr);
                this.f11767d += bArr.length;
                m17567a();
            }
        }
    }

    public synchronized byte[] zzb(int i) {
        byte[] bArr;
        for (int i2 = 0; i2 < this.f11766c.size(); i2++) {
            bArr = (byte[]) this.f11766c.get(i2);
            if (bArr.length >= i) {
                this.f11767d -= bArr.length;
                this.f11766c.remove(i2);
                this.f11765b.remove(bArr);
                break;
            }
        }
        bArr = new byte[i];
        return bArr;
    }
}
