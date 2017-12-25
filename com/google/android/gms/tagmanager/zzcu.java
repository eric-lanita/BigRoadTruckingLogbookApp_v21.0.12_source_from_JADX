package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import com.google.android.gms.internal.zzadu.zza;
import com.google.android.gms.internal.zzadw;
import com.google.android.gms.internal.zzadw.zzc;
import com.google.android.gms.internal.zzadw.zzg;
import com.google.android.gms.internal.zzah.zzf;
import com.google.android.gms.internal.zzapu;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

class zzcu implements zzf {
    private final Context f12651a;
    private final String f12652b;
    private final ExecutorService f12653c = Executors.newSingleThreadExecutor();
    private zzbm<zza> f12654d;

    class C34351 implements Runnable {
        final /* synthetic */ zzcu f12648a;

        C34351(zzcu com_google_android_gms_tagmanager_zzcu) {
            this.f12648a = com_google_android_gms_tagmanager_zzcu;
        }

        public void run() {
            this.f12648a.m18150a();
        }
    }

    zzcu(Context context, String str) {
        this.f12651a = context;
        this.f12652b = str;
    }

    private zzc m18147a(ByteArrayOutputStream byteArrayOutputStream) {
        zzc com_google_android_gms_internal_zzadw_zzc = null;
        try {
            com_google_android_gms_internal_zzadw_zzc = zzbg.zzox(byteArrayOutputStream.toString("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            zzbn.zzcv("Failed to convert binary resource to string for JSON parsing; the file format is not UTF-8 format.");
        } catch (JSONException e2) {
            zzbn.zzcx("Failed to extract the container from the resource file. Resource is a UTF-8 encoded string but doesn't contain a JSON container");
        }
        return com_google_android_gms_internal_zzadw_zzc;
    }

    private zzc m18148a(byte[] bArr) {
        try {
            zzc zzb = zzadw.zzb(zzf.zze(bArr));
            if (zzb == null) {
                return zzb;
            }
            zzbn.m18106v("The container was successfully loaded from the resource (using binary file)");
            return zzb;
        } catch (zzapu e) {
            zzbn.m18105e("The resource file is corrupted. The container cannot be extracted from the binary file");
            return null;
        } catch (zzg e2) {
            zzbn.zzcx("The resource file is invalid. The container from the binary file is invalid");
            return null;
        }
    }

    private void m18149b(zza com_google_android_gms_internal_zzadu_zza) {
        if (com_google_android_gms_internal_zzadu_zza.zzwr == null && com_google_android_gms_internal_zzadu_zza.aCW == null) {
            throw new IllegalArgumentException("Resource and SupplementedResource are NULL.");
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m18150a() {
        /*
        r3 = this;
        r0 = r3.f12654d;
        if (r0 != 0) goto L_0x000c;
    L_0x0004:
        r0 = new java.lang.IllegalStateException;
        r1 = "Callback must be set before execute";
        r0.<init>(r1);
        throw r0;
    L_0x000c:
        r0 = r3.f12654d;
        r0.zzcau();
        r0 = "Attempting to load resource from disk";
        com.google.android.gms.tagmanager.zzbn.m18106v(r0);
        r0 = com.google.android.gms.tagmanager.zzci.m18128a();
        r0 = r0.m18132b();
        r1 = com.google.android.gms.tagmanager.zzci.zza.CONTAINER;
        if (r0 == r1) goto L_0x002e;
    L_0x0022:
        r0 = com.google.android.gms.tagmanager.zzci.m18128a();
        r0 = r0.m18132b();
        r1 = com.google.android.gms.tagmanager.zzci.zza.CONTAINER_DEBUG;
        if (r0 != r1) goto L_0x0046;
    L_0x002e:
        r0 = r3.f12652b;
        r1 = com.google.android.gms.tagmanager.zzci.m18128a();
        r1 = r1.m18134d();
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0046;
    L_0x003e:
        r0 = r3.f12654d;
        r1 = com.google.android.gms.tagmanager.zzbm.zza.NOT_AVAILABLE;
        r0.zza(r1);
    L_0x0045:
        return;
    L_0x0046:
        r1 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x0070 }
        r0 = r3.m18152b();	 Catch:{ FileNotFoundException -> 0x0070 }
        r1.<init>(r0);	 Catch:{ FileNotFoundException -> 0x0070 }
        r0 = new java.io.ByteArrayOutputStream;	 Catch:{ IOException -> 0x0085, IllegalArgumentException -> 0x009d }
        r0.<init>();	 Catch:{ IOException -> 0x0085, IllegalArgumentException -> 0x009d }
        com.google.android.gms.internal.zzadw.zzc(r1, r0);	 Catch:{ IOException -> 0x0085, IllegalArgumentException -> 0x009d }
        r0 = r0.toByteArray();	 Catch:{ IOException -> 0x0085, IllegalArgumentException -> 0x009d }
        r0 = com.google.android.gms.internal.zzadu.zza.zzao(r0);	 Catch:{ IOException -> 0x0085, IllegalArgumentException -> 0x009d }
        r3.m18149b(r0);	 Catch:{ IOException -> 0x0085, IllegalArgumentException -> 0x009d }
        r2 = r3.f12654d;	 Catch:{ IOException -> 0x0085, IllegalArgumentException -> 0x009d }
        r2.onSuccess(r0);	 Catch:{ IOException -> 0x0085, IllegalArgumentException -> 0x009d }
        r1.close();	 Catch:{ IOException -> 0x007e }
    L_0x006a:
        r0 = "The Disk resource was successfully read.";
        com.google.android.gms.tagmanager.zzbn.m18106v(r0);
        goto L_0x0045;
    L_0x0070:
        r0 = move-exception;
        r0 = "Failed to find the resource in the disk";
        com.google.android.gms.tagmanager.zzbn.zzcv(r0);
        r0 = r3.f12654d;
        r1 = com.google.android.gms.tagmanager.zzbm.zza.NOT_AVAILABLE;
        r0.zza(r1);
        goto L_0x0045;
    L_0x007e:
        r0 = move-exception;
        r0 = "Error closing stream for reading resource from disk";
        com.google.android.gms.tagmanager.zzbn.zzcx(r0);
        goto L_0x006a;
    L_0x0085:
        r0 = move-exception;
        r0 = r3.f12654d;	 Catch:{ all -> 0x00b5 }
        r2 = com.google.android.gms.tagmanager.zzbm.zza.IO_ERROR;	 Catch:{ all -> 0x00b5 }
        r0.zza(r2);	 Catch:{ all -> 0x00b5 }
        r0 = "Failed to read the resource from disk";
        com.google.android.gms.tagmanager.zzbn.zzcx(r0);	 Catch:{ all -> 0x00b5 }
        r1.close();	 Catch:{ IOException -> 0x0096 }
        goto L_0x006a;
    L_0x0096:
        r0 = move-exception;
        r0 = "Error closing stream for reading resource from disk";
        com.google.android.gms.tagmanager.zzbn.zzcx(r0);
        goto L_0x006a;
    L_0x009d:
        r0 = move-exception;
        r0 = r3.f12654d;	 Catch:{ all -> 0x00b5 }
        r2 = com.google.android.gms.tagmanager.zzbm.zza.IO_ERROR;	 Catch:{ all -> 0x00b5 }
        r0.zza(r2);	 Catch:{ all -> 0x00b5 }
        r0 = "Failed to read the resource from disk. The resource is inconsistent";
        com.google.android.gms.tagmanager.zzbn.zzcx(r0);	 Catch:{ all -> 0x00b5 }
        r1.close();	 Catch:{ IOException -> 0x00ae }
        goto L_0x006a;
    L_0x00ae:
        r0 = move-exception;
        r0 = "Error closing stream for reading resource from disk";
        com.google.android.gms.tagmanager.zzbn.zzcx(r0);
        goto L_0x006a;
    L_0x00b5:
        r0 = move-exception;
        r1.close();	 Catch:{ IOException -> 0x00ba }
    L_0x00b9:
        throw r0;
    L_0x00ba:
        r1 = move-exception;
        r1 = "Error closing stream for reading resource from disk";
        com.google.android.gms.tagmanager.zzbn.zzcx(r1);
        goto L_0x00b9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzcu.a():void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    boolean m18151a(com.google.android.gms.internal.zzadu.zza r5) {
        /*
        r4 = this;
        r0 = 0;
        r1 = r4.m18152b();
        r2 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x0016 }
        r2.<init>(r1);	 Catch:{ FileNotFoundException -> 0x0016 }
        r3 = com.google.android.gms.internal.zzapv.zzf(r5);	 Catch:{ IOException -> 0x0024 }
        r2.write(r3);	 Catch:{ IOException -> 0x0024 }
        r2.close();	 Catch:{ IOException -> 0x001d }
    L_0x0014:
        r0 = 1;
    L_0x0015:
        return r0;
    L_0x0016:
        r1 = move-exception;
        r1 = "Error opening resource file for writing";
        com.google.android.gms.tagmanager.zzbn.m18105e(r1);
        goto L_0x0015;
    L_0x001d:
        r0 = move-exception;
        r0 = "error closing stream for writing resource to disk";
        com.google.android.gms.tagmanager.zzbn.zzcx(r0);
        goto L_0x0014;
    L_0x0024:
        r3 = move-exception;
        r3 = "Error writing resource to disk. Removing resource from disk.";
        com.google.android.gms.tagmanager.zzbn.zzcx(r3);	 Catch:{ all -> 0x0038 }
        r1.delete();	 Catch:{ all -> 0x0038 }
        r2.close();	 Catch:{ IOException -> 0x0031 }
        goto L_0x0015;
    L_0x0031:
        r1 = move-exception;
        r1 = "error closing stream for writing resource to disk";
        com.google.android.gms.tagmanager.zzbn.zzcx(r1);
        goto L_0x0015;
    L_0x0038:
        r0 = move-exception;
        r2.close();	 Catch:{ IOException -> 0x003d }
    L_0x003c:
        throw r0;
    L_0x003d:
        r1 = move-exception;
        r1 = "error closing stream for writing resource to disk";
        com.google.android.gms.tagmanager.zzbn.zzcx(r1);
        goto L_0x003c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzcu.a(com.google.android.gms.internal.zzadu$zza):boolean");
    }

    File m18152b() {
        String valueOf = String.valueOf("resource_");
        String valueOf2 = String.valueOf(this.f12652b);
        return new File(this.f12651a.getDir("google_tagmanager", 0), valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
    }

    public synchronized void release() {
        this.f12653c.shutdown();
    }

    public void zza(zzbm<zza> com_google_android_gms_tagmanager_zzbm_com_google_android_gms_internal_zzadu_zza) {
        this.f12654d = com_google_android_gms_tagmanager_zzbm_com_google_android_gms_internal_zzadu_zza;
    }

    public void zzb(final zza com_google_android_gms_internal_zzadu_zza) {
        this.f12653c.execute(new Runnable(this) {
            final /* synthetic */ zzcu f12650b;

            public void run() {
                this.f12650b.m18151a(com_google_android_gms_internal_zzadu_zza);
            }
        });
    }

    public void zzcav() {
        this.f12653c.execute(new C34351(this));
    }

    public zzc zzze(int i) {
        try {
            InputStream openRawResource = this.f12651a.getResources().openRawResource(i);
            String valueOf = String.valueOf(this.f12651a.getResources().getResourceName(i));
            zzbn.m18106v(new StringBuilder(String.valueOf(valueOf).length() + 66).append("Attempting to load a container from the resource ID ").append(i).append(" (").append(valueOf).append(")").toString());
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                zzadw.zzc(openRawResource, byteArrayOutputStream);
                zzc a = m18147a(byteArrayOutputStream);
                if (a == null) {
                    return m18148a(byteArrayOutputStream.toByteArray());
                }
                zzbn.m18106v("The container was successfully loaded from the resource (using JSON file format)");
                return a;
            } catch (IOException e) {
                String valueOf2 = String.valueOf(this.f12651a.getResources().getResourceName(i));
                zzbn.zzcx(new StringBuilder(String.valueOf(valueOf2).length() + 67).append("Error reading the default container with resource ID ").append(i).append(" (").append(valueOf2).append(")").toString());
                return null;
            }
        } catch (NotFoundException e2) {
            zzbn.zzcx("Failed to load the container. No default container resource found with the resource ID " + i);
            return null;
        }
    }
}
