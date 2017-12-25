package com.google.android.gms.common;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzs;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.common.util.zzm;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzsb;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class zzd {
    private static zzv f10921a;
    private static Context f10922b;
    private static Set<zzs> f10923c;
    private static Set<zzs> f10924d;

    static abstract class zza extends com.google.android.gms.common.internal.zzs.zza {
        private int f10916a;

        protected zza(byte[] bArr) {
            boolean z = false;
            if (bArr.length != 25) {
                int length = bArr.length;
                String valueOf = String.valueOf(zzm.zza(bArr, 0, bArr.length, false));
                Log.wtf("GoogleCertificates", new StringBuilder(String.valueOf(valueOf).length() + 51).append("Cert hash data has incorrect length (").append(length).append("):\n").append(valueOf).toString(), new Exception());
                bArr = Arrays.copyOfRange(bArr, 0, 25);
                if (bArr.length == 25) {
                    z = true;
                }
                zzab.zzb(z, "cert hash data has incorrect length. length=" + bArr.length);
            }
            this.f10916a = Arrays.hashCode(bArr);
        }

        protected static byte[] m17016a(String str) {
            try {
                return str.getBytes("ISO-8859-1");
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }

        abstract byte[] mo1761a();

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof zzs)) {
                return false;
            }
            try {
                zzs com_google_android_gms_common_internal_zzs = (zzs) obj;
                if (com_google_android_gms_common_internal_zzs.zzanl() != hashCode()) {
                    return false;
                }
                com.google.android.gms.dynamic.zzd zzank = com_google_android_gms_common_internal_zzs.zzank();
                if (zzank == null) {
                    return false;
                }
                return Arrays.equals(mo1761a(), (byte[]) zze.zzad(zzank));
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "iCertData failed to retrive data from remote");
                return false;
            }
        }

        public int hashCode() {
            return this.f10916a;
        }

        public com.google.android.gms.dynamic.zzd zzank() {
            return zze.zzac(mo1761a());
        }

        public int zzanl() {
            return hashCode();
        }
    }

    static class zzb extends zza {
        private final byte[] f10917a;

        zzb(byte[] bArr) {
            super(Arrays.copyOfRange(bArr, 0, 25));
            this.f10917a = bArr;
        }

        byte[] mo1761a() {
            return this.f10917a;
        }
    }

    static abstract class zzc extends zza {
        private static final WeakReference<byte[]> f10918b = new WeakReference(null);
        private WeakReference<byte[]> f10919a = f10918b;

        zzc(byte[] bArr) {
            super(bArr);
        }

        byte[] mo1761a() {
            byte[] bArr;
            synchronized (this) {
                bArr = (byte[]) this.f10919a.get();
                if (bArr == null) {
                    bArr = mo1762b();
                    this.f10919a = new WeakReference(bArr);
                }
            }
            return bArr;
        }

        protected abstract byte[] mo1762b();
    }

    static final class zzd {
        static final zza[] f10920a = new zza[]{new C32291(zza.m17016a("0\u0004C0\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000ÂàFdJ00")), new C32302(zza.m17016a("0\u0004¨0\u0003 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ¸l}ÓNõ0"))};

        class C32291 extends zzc {
            C32291(byte[] bArr) {
                super(bArr);
            }

            protected byte[] mo1762b() {
                return zza.m17016a("0\u0004C0\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000ÂàFdJ00\r\u0006\t*H÷\r\u0001\u0001\u0004\u0005\u00000t1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Android0\u001e\u0017\r080821231334Z\u0017\r360107231334Z0t1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Android0\u0001 0\r\u0006\t*H÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u0001\r\u00000\u0001\b\u0002\u0001\u0001\u0000«V.\u0000Ø;¢\b®\no\u0012N)Ú\u0011ò«VÐXâÌ©\u0013\u0003é·TÓrö@§\u001b\u001dË\u0013\tgbNFV§wj\u0019=²å¿·$©\u001ew\u0018\u000ejG¤;3Ù`w\u00181EÌß{.XftÉáV[\u001fLjYU¿òQ¦=«ùÅ\\'\"\"Rèuäø\u0015Jd_qhÀ±¿Æ\u0012ê¿xWi»4ªyÜ~.¢vL®\u0007ØÁqT×î_d¥\u001aD¦\u0002ÂI\u0005AWÜ\u0002Í_\\\u000eUûï\u0019ûã'ð±Q\u0016Å o\u0019ÑõÄÛÂÖ¹?hÌ)yÇ\u000e\u0018«k;ÕÛU*\u000e;LßXûíÁº5à\u0003Á´±\rÒD¨î$ÿý38r«R!^Ú°ü\r\u000b\u0014[j¡y\u0002\u0001\u0003£Ù0Ö0\u001d\u0006\u0003U\u001d\u000e\u0004\u0016\u0004\u0014Ç}Â!\u0017V%Óßkãä×¥0¦\u0006\u0003U\u001d#\u00040\u0014Ç}Â!\u0017V%Óßkãä×¥¡x¤v0t1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Android\t\u0000ÂàFdJ00\f\u0006\u0003U\u001d\u0013\u0004\u00050\u0003\u0001\u0001ÿ0\r\u0006\t*H÷\r\u0001\u0001\u0004\u0005\u0000\u0003\u0001\u0001\u0000mÒRÎï0,6\nªÎÏòÌ©\u0004»]z\u0016aø®F²B\u0004ÐÿJhÇí\u001aS\u001eÄYZb<æ\u0007c±g)zzãW\u0012Ä\u0007ò\bðË\u0010)\u0012M{\u0010b\u0019ÀÊ>³ù­_¸qï&âñmDÈÙ l²ð\u0005»?âËD~s\u0010v­E³?`\tê\u0019Áaæ&Aª'\u001dýR(ÅÅ]ÛE'XÖaöÌ\fÌ·5.BLÄ6\\R52÷2Q7Y<JãAôÛAíÚ\r\u000b\u0010q§Ä@ðþ \u001c¶'ÊgCiÐ½/Ù\u0011ÿ\u0006Í¿,ú\u0010Ü\u000f:ãWbHÇïÆLqD\u0017B÷\u0005ÉÞW:õ[9\r×ý¹A1]_u0\u0011&ÿb\u0014\u0010Ài0");
            }
        }

        class C32302 extends zzc {
            C32302(byte[] bArr) {
                super(bArr);
            }

            protected byte[] mo1762b() {
                return zza.m17016a("0\u0004¨0\u0003 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ¸l}ÓNõ0\r\u0006\t*H÷\r\u0001\u0001\u0004\u0005\u000001\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00100\u000e\u0006\u0003U\u0004\n\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Android1\"0 \u0006\t*H÷\r\u0001\t\u0001\u0016\u0013android@android.com0\u001e\u0017\r080415233656Z\u0017\r350901233656Z01\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00100\u000e\u0006\u0003U\u0004\n\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Android1\"0 \u0006\t*H÷\r\u0001\t\u0001\u0016\u0013android@android.com0\u0001 0\r\u0006\t*H÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u0001\r\u00000\u0001\b\u0002\u0001\u0001\u0000ÖÎ.\b\n¿â1MÑ³ÏÓ\u0018\\´=3ú\ftá½¶ÑÛ\u0013ö,\\9ßVøF=e¾ÀóÊBk\u0007Å¨íZ9ÁgçkÉ¹'K\u000b\"\u0000\u0019©)\u0015årÅm*0\u001b£oÅü\u0011:ÖËt5¡m#«}úîáeäß\u001f\n½§\nQlN\u0005\u0011Ê|\fU\u0017[ÃuùHÅj®\b¤O¦¤Ý}¿,\n5\"­\u0006¸Ì\u0018^±Uyîøm\b\u000b\u001daÀù¯±ÂëÑ\u0007êE«Ûh£Ç^TÇlSÔ\u000b\u0012\u001dç»Ó\u000eb\f\u0018áªaÛ¼Ý<d_/UóÔÃuì@p©?qQØ6pÁj\u001a¾^òÑ\u0018á¸®ó)ðf¿láD¬èm\u001c\u001b\u000f\u0002\u0001\u0003£ü0ù0\u001d\u0006\u0003U\u001d\u000e\u0004\u0016\u0004\u0014\u001cÅ¾LC<a:\u0015°L¼\u0003òOà²0É\u0006\u0003U\u001d#\u0004Á0¾\u0014\u001cÅ¾LC<a:\u0015°L¼\u0003òOà²¡¤01\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00100\u000e\u0006\u0003U\u0004\n\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Android1\"0 \u0006\t*H÷\r\u0001\t\u0001\u0016\u0013android@android.com\t\u0000Õ¸l}ÓNõ0\f\u0006\u0003U\u001d\u0013\u0004\u00050\u0003\u0001\u0001ÿ0\r\u0006\t*H÷\r\u0001\u0001\u0004\u0005\u0000\u0003\u0001\u0001\u0000\u0019Ó\fñ\u0005ûx?L\r}Ò##=@zÏÎ\u0000\b\u001d[×ÆéÖí k\u000e\u0011 \u0006Al¢D\u0013ÒkJ àõ$ÊÒ»\\nL¡\u0001j\u0015n¡ì]ÉZ^:\u0001\u00006ôHÕ\u0010¿.\u001eag:;åm¯\u000bw±Â)ãÂUãèL]#ïº\tËñ; +NZ\"É2cHJ#Òü)ú\u00199u3¯Øª\u0016\u000fBÂÐ\u0016>fCéÁ/ Á33[Àÿk\"ÞÑ­DB)¥9©Nï­«ÐeÎÒK>QåÝ{fx{ï\u0012þû¤Ä#ûOøÌIL\u0002ðõ\u0005\u0016\u0012ÿe)9>FêÅ»!òwÁQª_*¦'Ñè§\n¶\u00035iÞ;¿ÿ|©Ú>\u0012Cö\u000b");
            }
        }
    }

    static synchronized Set<zzs> m17023a() {
        Set<zzs> set;
        synchronized (zzd.class) {
            if (f10923c != null) {
                set = f10923c;
            } else if (f10921a != null || m17027c()) {
                try {
                    com.google.android.gms.dynamic.zzd zzatc = f10921a.zzatc();
                    if (zzatc == null) {
                        Log.e("GoogleCertificates", "Failed to get google certificates from remote");
                        set = Collections.EMPTY_SET;
                    } else {
                        f10923c = m17024a((IBinder[]) zze.zzad(zzatc));
                        for (Object add : zzd.f10920a) {
                            f10923c.add(add);
                        }
                        f10923c = Collections.unmodifiableSet(f10923c);
                        set = f10923c;
                    }
                } catch (RemoteException e) {
                    Log.e("GoogleCertificates", "Failed to retrieve google certificates");
                }
            } else {
                set = Collections.EMPTY_SET;
            }
        }
        return set;
    }

    private static Set<zzs> m17024a(IBinder[] iBinderArr) {
        Set<zzs> hashSet = new HashSet(r1);
        for (IBinder zzdr : iBinderArr) {
            zzs zzdr2 = com.google.android.gms.common.internal.zzs.zza.zzdr(zzdr);
            if (zzdr2 == null) {
                Log.e("GoogleCertificates", "iCertData is null, skipping");
            } else {
                hashSet.add(zzdr2);
            }
        }
        return hashSet;
    }

    static synchronized void m17025a(Context context) {
        synchronized (zzd.class) {
            if (f10922b != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                f10922b = context.getApplicationContext();
            }
        }
    }

    static synchronized Set<zzs> m17026b() {
        Set<zzs> set;
        synchronized (zzd.class) {
            if (f10924d != null) {
                set = f10924d;
            } else if (f10921a != null || m17027c()) {
                try {
                    com.google.android.gms.dynamic.zzd zzatd = f10921a.zzatd();
                    if (zzatd == null) {
                        Log.d("GoogleCertificates", "Failed to get google release certificates from remote");
                        set = Collections.EMPTY_SET;
                    } else {
                        f10924d = m17024a((IBinder[]) zze.zzad(zzatd));
                        f10924d.add(zzd.f10920a[0]);
                        f10924d = Collections.unmodifiableSet(f10924d);
                        set = f10924d;
                    }
                } catch (RemoteException e) {
                    Log.e("GoogleCertificates", "Failed to retrieve google release certificates");
                }
            } else {
                set = Collections.EMPTY_SET;
            }
        }
        return set;
    }

    private static boolean m17027c() {
        zzab.zzy(f10922b);
        if (f10921a == null) {
            try {
                zzsb zza = zzsb.zza(f10922b, zzsb.KM, "com.google.android.gms.googlecertificates");
                Log.d("GoogleCertificates", "com.google.android.gms.googlecertificates module is loaded");
                f10921a = com.google.android.gms.common.internal.zzv.zza.zzdu(zza.zziu("com.google.android.gms.common.GoogleCertificatesImpl"));
            } catch (com.google.android.gms.internal.zzsb.zza e) {
                String str = "GoogleCertificates";
                String valueOf = String.valueOf("Failed to load com.google.android.gms.googlecertificates: ");
                String valueOf2 = String.valueOf(e.getMessage());
                Log.e(str, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
                return false;
            }
        }
        return true;
    }
}
