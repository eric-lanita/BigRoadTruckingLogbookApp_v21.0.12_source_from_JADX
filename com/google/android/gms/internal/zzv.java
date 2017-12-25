package com.google.android.gms.internal;

import android.os.SystemClock;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class zzv implements zzb {
    private final Map<String, zza> f11781a;
    private long f11782b;
    private final File f11783c;
    private final int f11784d;

    static class zza {
        public String zza;
        public long zzb;
        public long zzc;
        public long zzca;
        public String zzcb;
        public long zzd;
        public long zze;
        public Map<String, String> zzf;

        private zza() {
        }

        public zza(String str, com.google.android.gms.internal.zzb.zza com_google_android_gms_internal_zzb_zza) {
            this.zzcb = str;
            this.zzca = (long) com_google_android_gms_internal_zzb_zza.data.length;
            this.zza = com_google_android_gms_internal_zzb_zza.zza;
            this.zzb = com_google_android_gms_internal_zzb_zza.zzb;
            this.zzc = com_google_android_gms_internal_zzb_zza.zzc;
            this.zzd = com_google_android_gms_internal_zzb_zza.zzd;
            this.zze = com_google_android_gms_internal_zzb_zza.zze;
            this.zzf = com_google_android_gms_internal_zzb_zza.zzf;
        }

        public static zza zzf(InputStream inputStream) {
            zza com_google_android_gms_internal_zzv_zza = new zza();
            if (zzv.m17585a(inputStream) != 538247942) {
                throw new IOException();
            }
            com_google_android_gms_internal_zzv_zza.zzcb = zzv.m17596c(inputStream);
            com_google_android_gms_internal_zzv_zza.zza = zzv.m17596c(inputStream);
            if (com_google_android_gms_internal_zzv_zza.zza.equals("")) {
                com_google_android_gms_internal_zzv_zza.zza = null;
            }
            com_google_android_gms_internal_zzv_zza.zzb = zzv.m17594b(inputStream);
            com_google_android_gms_internal_zzv_zza.zzc = zzv.m17594b(inputStream);
            com_google_android_gms_internal_zzv_zza.zzd = zzv.m17594b(inputStream);
            com_google_android_gms_internal_zzv_zza.zze = zzv.m17594b(inputStream);
            com_google_android_gms_internal_zzv_zza.zzf = zzv.m17597d(inputStream);
            return com_google_android_gms_internal_zzv_zza;
        }

        public boolean zza(OutputStream outputStream) {
            try {
                zzv.m17588a(outputStream, 538247942);
                zzv.m17590a(outputStream, this.zzcb);
                zzv.m17590a(outputStream, this.zza == null ? "" : this.zza);
                zzv.m17589a(outputStream, this.zzb);
                zzv.m17589a(outputStream, this.zzc);
                zzv.m17589a(outputStream, this.zzd);
                zzv.m17589a(outputStream, this.zze);
                zzv.m17592a(this.zzf, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e) {
                zzs.zzb("%s", e.toString());
                return false;
            }
        }

        public com.google.android.gms.internal.zzb.zza zzb(byte[] bArr) {
            com.google.android.gms.internal.zzb.zza com_google_android_gms_internal_zzb_zza = new com.google.android.gms.internal.zzb.zza();
            com_google_android_gms_internal_zzb_zza.data = bArr;
            com_google_android_gms_internal_zzb_zza.zza = this.zza;
            com_google_android_gms_internal_zzb_zza.zzb = this.zzb;
            com_google_android_gms_internal_zzb_zza.zzc = this.zzc;
            com_google_android_gms_internal_zzb_zza.zzd = this.zzd;
            com_google_android_gms_internal_zzb_zza.zze = this.zze;
            com_google_android_gms_internal_zzb_zza.zzf = this.zzf;
            return com_google_android_gms_internal_zzb_zza;
        }
    }

    private static class zzb extends FilterInputStream {
        private int f11780a;

        private zzb(InputStream inputStream) {
            super(inputStream);
            this.f11780a = 0;
        }

        public int read() {
            int read = super.read();
            if (read != -1) {
                this.f11780a++;
            }
            return read;
        }

        public int read(byte[] bArr, int i, int i2) {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.f11780a += read;
            }
            return read;
        }
    }

    public zzv(File file) {
        this(file, 5242880);
    }

    public zzv(File file, int i) {
        this.f11781a = new LinkedHashMap(16, 0.75f, true);
        this.f11782b = 0;
        this.f11783c = file;
        this.f11784d = i;
    }

    static int m17585a(InputStream inputStream) {
        return ((((m17598e(inputStream) << 0) | 0) | (m17598e(inputStream) << 8)) | (m17598e(inputStream) << 16)) | (m17598e(inputStream) << 24);
    }

    private String m17586a(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(String.valueOf(str.substring(0, length).hashCode()));
        String valueOf2 = String.valueOf(String.valueOf(str.substring(length).hashCode()));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    private void m17587a(int i) {
        if (this.f11782b + ((long) i) >= ((long) this.f11784d)) {
            int i2;
            if (zzs.DEBUG) {
                zzs.zza("Pruning old cache entries.", new Object[0]);
            }
            long j = this.f11782b;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Iterator it = this.f11781a.entrySet().iterator();
            int i3 = 0;
            while (it.hasNext()) {
                zza com_google_android_gms_internal_zzv_zza = (zza) ((Entry) it.next()).getValue();
                if (zzf(com_google_android_gms_internal_zzv_zza.zzcb).delete()) {
                    this.f11782b -= com_google_android_gms_internal_zzv_zza.zzca;
                } else {
                    zzs.zzb("Could not delete cache entry for key=%s, filename=%s", com_google_android_gms_internal_zzv_zza.zzcb, m17586a(com_google_android_gms_internal_zzv_zza.zzcb));
                }
                it.remove();
                i2 = i3 + 1;
                if (((float) (this.f11782b + ((long) i))) < ((float) this.f11784d) * 0.9f) {
                    break;
                }
                i3 = i2;
            }
            i2 = i3;
            if (zzs.DEBUG) {
                zzs.zza("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.f11782b - j), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
        }
    }

    static void m17588a(OutputStream outputStream, int i) {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    static void m17589a(OutputStream outputStream, long j) {
        outputStream.write((byte) ((int) (j >>> null)));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    static void m17590a(OutputStream outputStream, String str) {
        byte[] bytes = str.getBytes("UTF-8");
        m17589a(outputStream, (long) bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    private void m17591a(String str, zza com_google_android_gms_internal_zzv_zza) {
        if (this.f11781a.containsKey(str)) {
            zza com_google_android_gms_internal_zzv_zza2 = (zza) this.f11781a.get(str);
            this.f11782b = (com_google_android_gms_internal_zzv_zza.zzca - com_google_android_gms_internal_zzv_zza2.zzca) + this.f11782b;
        } else {
            this.f11782b += com_google_android_gms_internal_zzv_zza.zzca;
        }
        this.f11781a.put(str, com_google_android_gms_internal_zzv_zza);
    }

    static void m17592a(Map<String, String> map, OutputStream outputStream) {
        if (map != null) {
            m17588a(outputStream, map.size());
            for (Entry entry : map.entrySet()) {
                m17590a(outputStream, (String) entry.getKey());
                m17590a(outputStream, (String) entry.getValue());
            }
            return;
        }
        m17588a(outputStream, 0);
    }

    private static byte[] m17593a(InputStream inputStream, int i) {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                break;
            }
            i2 += read;
        }
        if (i2 == i) {
            return bArr;
        }
        throw new IOException("Expected " + i + " bytes, read " + i2 + " bytes");
    }

    static long m17594b(InputStream inputStream) {
        return (((((((0 | ((((long) m17598e(inputStream)) & 255) << null)) | ((((long) m17598e(inputStream)) & 255) << 8)) | ((((long) m17598e(inputStream)) & 255) << 16)) | ((((long) m17598e(inputStream)) & 255) << 24)) | ((((long) m17598e(inputStream)) & 255) << 32)) | ((((long) m17598e(inputStream)) & 255) << 40)) | ((((long) m17598e(inputStream)) & 255) << 48)) | ((((long) m17598e(inputStream)) & 255) << 56);
    }

    private void m17595b(String str) {
        zza com_google_android_gms_internal_zzv_zza = (zza) this.f11781a.get(str);
        if (com_google_android_gms_internal_zzv_zza != null) {
            this.f11782b -= com_google_android_gms_internal_zzv_zza.zzca;
            this.f11781a.remove(str);
        }
    }

    static String m17596c(InputStream inputStream) {
        return new String(m17593a(inputStream, (int) m17594b(inputStream)), "UTF-8");
    }

    static Map<String, String> m17597d(InputStream inputStream) {
        int a = m17585a(inputStream);
        Map<String, String> emptyMap = a == 0 ? Collections.emptyMap() : new HashMap(a);
        for (int i = 0; i < a; i++) {
            emptyMap.put(m17596c(inputStream).intern(), m17596c(inputStream).intern());
        }
        return emptyMap;
    }

    private static int m17598e(InputStream inputStream) {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    public synchronized void initialize() {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        if (this.f11783c.exists()) {
            File[] listFiles = this.f11783c.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    BufferedInputStream bufferedInputStream2 = null;
                    try {
                        bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                        try {
                            zza zzf = zza.zzf(bufferedInputStream);
                            zzf.zzca = file.length();
                            m17591a(zzf.zzcb, zzf);
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e) {
                                }
                            }
                        } catch (IOException e2) {
                            if (file != null) {
                                try {
                                    file.delete();
                                } catch (Throwable th2) {
                                    Throwable th3 = th2;
                                    bufferedInputStream2 = bufferedInputStream;
                                    th = th3;
                                }
                            }
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e3) {
                                }
                            }
                        }
                    } catch (IOException e4) {
                        bufferedInputStream = null;
                        if (file != null) {
                            file.delete();
                        }
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                    } catch (Throwable th4) {
                        th = th4;
                    }
                }
            }
        } else if (!this.f11783c.mkdirs()) {
            zzs.zzc("Unable to create cache dir %s", this.f11783c.getAbsolutePath());
        }
        return;
        if (bufferedInputStream2 != null) {
            try {
                bufferedInputStream2.close();
            } catch (IOException e5) {
            }
        }
        throw th;
        throw th;
    }

    public synchronized void remove(String str) {
        boolean delete = zzf(str).delete();
        m17595b(str);
        if (!delete) {
            zzs.zzb("Could not delete cache entry for key=%s, filename=%s", str, m17586a(str));
        }
    }

    public synchronized com.google.android.gms.internal.zzb.zza zza(String str) {
        com.google.android.gms.internal.zzb.zza com_google_android_gms_internal_zzb_zza;
        IOException e;
        Throwable th;
        zza com_google_android_gms_internal_zzv_zza = (zza) this.f11781a.get(str);
        if (com_google_android_gms_internal_zzv_zza == null) {
            com_google_android_gms_internal_zzb_zza = null;
        } else {
            File zzf = zzf(str);
            zzb com_google_android_gms_internal_zzv_zzb;
            try {
                com_google_android_gms_internal_zzv_zzb = new zzb(new FileInputStream(zzf));
                try {
                    zza.zzf(com_google_android_gms_internal_zzv_zzb);
                    com_google_android_gms_internal_zzb_zza = com_google_android_gms_internal_zzv_zza.zzb(m17593a((InputStream) com_google_android_gms_internal_zzv_zzb, (int) (zzf.length() - ((long) com_google_android_gms_internal_zzv_zzb.f11780a))));
                    if (com_google_android_gms_internal_zzv_zzb != null) {
                        try {
                            com_google_android_gms_internal_zzv_zzb.close();
                        } catch (IOException e2) {
                            com_google_android_gms_internal_zzb_zza = null;
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    try {
                        zzs.zzb("%s: %s", zzf.getAbsolutePath(), e.toString());
                        remove(str);
                        if (com_google_android_gms_internal_zzv_zzb != null) {
                            try {
                                com_google_android_gms_internal_zzv_zzb.close();
                            } catch (IOException e4) {
                                com_google_android_gms_internal_zzb_zza = null;
                            }
                        }
                        com_google_android_gms_internal_zzb_zza = null;
                        return com_google_android_gms_internal_zzb_zza;
                    } catch (Throwable th2) {
                        th = th2;
                        if (com_google_android_gms_internal_zzv_zzb != null) {
                            try {
                                com_google_android_gms_internal_zzv_zzb.close();
                            } catch (IOException e5) {
                                com_google_android_gms_internal_zzb_zza = null;
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException e6) {
                e = e6;
                com_google_android_gms_internal_zzv_zzb = null;
                zzs.zzb("%s: %s", zzf.getAbsolutePath(), e.toString());
                remove(str);
                if (com_google_android_gms_internal_zzv_zzb != null) {
                    com_google_android_gms_internal_zzv_zzb.close();
                }
                com_google_android_gms_internal_zzb_zza = null;
                return com_google_android_gms_internal_zzb_zza;
            } catch (Throwable th3) {
                th = th3;
                com_google_android_gms_internal_zzv_zzb = null;
                if (com_google_android_gms_internal_zzv_zzb != null) {
                    com_google_android_gms_internal_zzv_zzb.close();
                }
                throw th;
            }
        }
        return com_google_android_gms_internal_zzb_zza;
    }

    public synchronized void zza(String str, com.google.android.gms.internal.zzb.zza com_google_android_gms_internal_zzb_zza) {
        m17587a(com_google_android_gms_internal_zzb_zza.data.length);
        File zzf = zzf(str);
        try {
            OutputStream fileOutputStream = new FileOutputStream(zzf);
            zza com_google_android_gms_internal_zzv_zza = new zza(str, com_google_android_gms_internal_zzb_zza);
            if (com_google_android_gms_internal_zzv_zza.zza(fileOutputStream)) {
                fileOutputStream.write(com_google_android_gms_internal_zzb_zza.data);
                fileOutputStream.close();
                m17591a(str, com_google_android_gms_internal_zzv_zza);
            } else {
                fileOutputStream.close();
                zzs.zzb("Failed to write header for %s", zzf.getAbsolutePath());
                throw new IOException();
            }
        } catch (IOException e) {
            if (!zzf.delete()) {
                zzs.zzb("Could not clean up file %s", zzf.getAbsolutePath());
            }
        }
    }

    public File zzf(String str) {
        return new File(this.f11783c, m17586a(str));
    }
}
