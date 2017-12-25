package com.google.android.gms.analytics.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Locale;

public class zza extends zzd {
    public static boolean zzcwb;
    private Info f10218a;
    private final zzal f10219b;
    private String f10220c;
    private boolean f10221d = false;
    private Object f10222e = new Object();

    zza(zzf com_google_android_gms_analytics_internal_zzf) {
        super(com_google_android_gms_analytics_internal_zzf);
        this.f10219b = new zzal(com_google_android_gms_analytics_internal_zzf.zzyw());
    }

    private static String m16581a(String str) {
        if (zzao.zzfa("MD5") == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, zzao.zzfa("MD5").digest(str.getBytes()))});
    }

    private boolean m16582a(Info info, Info info2) {
        Object obj = null;
        CharSequence id = info2 == null ? null : info2.getId();
        if (TextUtils.isEmpty(id)) {
            return true;
        }
        String zzaav = m16548o().zzaav();
        synchronized (this.f10222e) {
            String valueOf;
            String valueOf2;
            if (!this.f10221d) {
                this.f10220c = m16587c();
                this.f10221d = true;
            } else if (TextUtils.isEmpty(this.f10220c)) {
                if (info != null) {
                    obj = info.getId();
                }
                if (obj == null) {
                    valueOf = String.valueOf(id);
                    String valueOf3 = String.valueOf(zzaav);
                    boolean b = m16583b(valueOf3.length() != 0 ? valueOf.concat(valueOf3) : new String(valueOf));
                    return b;
                }
                valueOf2 = String.valueOf(obj);
                valueOf = String.valueOf(zzaav);
                this.f10220c = m16581a(valueOf.length() != 0 ? valueOf2.concat(valueOf) : new String(valueOf2));
            }
            valueOf2 = String.valueOf(id);
            valueOf = String.valueOf(zzaav);
            obj = m16581a(valueOf.length() != 0 ? valueOf2.concat(valueOf) : new String(valueOf2));
            if (TextUtils.isEmpty(obj)) {
                return false;
            } else if (obj.equals(this.f10220c)) {
                return true;
            } else {
                if (TextUtils.isEmpty(this.f10220c)) {
                    valueOf = zzaav;
                } else {
                    zzeh("Resetting the client id because Advertising Id changed.");
                    obj = m16548o().m16717b();
                    zza("New client Id", obj);
                }
                String valueOf4 = String.valueOf(id);
                valueOf3 = String.valueOf(obj);
                b = m16583b(valueOf3.length() != 0 ? valueOf4.concat(valueOf3) : new String(valueOf4));
                return b;
            }
        }
    }

    private boolean m16583b(String str) {
        try {
            String a = m16581a(str);
            zzeh("Storing hashed adid.");
            FileOutputStream openFileOutput = m16540g().openFileOutput("gaClientIdData", 0);
            openFileOutput.write(a.getBytes());
            openFileOutput.close();
            this.f10220c = a;
            return true;
        } catch (IOException e) {
            zze("Error creating hash file", e);
            return false;
        }
    }

    private synchronized Info m16584t() {
        if (this.f10219b.zzx(1000)) {
            this.f10219b.start();
            Info b = m16586b();
            if (m16582a(this.f10218a, b)) {
                this.f10218a = b;
            } else {
                zzel("Failed to reset client id on adid change. Not using adid");
                this.f10218a = new Info("", false);
            }
        }
        return this.f10218a;
    }

    protected void mo1605a() {
    }

    protected Info m16586b() {
        Info info = null;
        try {
            info = AdvertisingIdClient.getAdvertisingIdInfo(m16540g());
        } catch (IllegalStateException e) {
            zzek("IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added '<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />' to your application manifest file. See http://goo.gl/naFqQk for details.");
        } catch (Throwable th) {
            if (!zzcwb) {
                zzcwb = true;
                zzd("Error getting advertiser id", th);
            }
        }
        return info;
    }

    protected String m16587c() {
        Object obj;
        String str = null;
        try {
            FileInputStream openFileInput = m16540g().openFileInput("gaClientIdData");
            byte[] bArr = new byte[128];
            int read = openFileInput.read(bArr, 0, 128);
            if (openFileInput.available() > 0) {
                zzek("Hash file seems corrupted, deleting it.");
                openFileInput.close();
                m16540g().deleteFile("gaClientIdData");
                return null;
            } else if (read <= 0) {
                zzeh("Hash file is empty.");
                openFileInput.close();
                return null;
            } else {
                String str2 = new String(bArr, 0, read);
                try {
                    openFileInput.close();
                    return str2;
                } catch (FileNotFoundException e) {
                    return str2;
                } catch (IOException e2) {
                    IOException iOException = e2;
                    str = str2;
                    IOException iOException2 = iOException;
                    zzd("Error reading Hash file, deleting it", obj);
                    m16540g().deleteFile("gaClientIdData");
                    return str;
                }
            }
        } catch (FileNotFoundException e3) {
            return null;
        } catch (IOException e4) {
            obj = e4;
            zzd("Error reading Hash file, deleting it", obj);
            m16540g().deleteFile("gaClientIdData");
            return str;
        }
    }

    public boolean zzxz() {
        m16553s();
        Info t = m16584t();
        return (t == null || t.isLimitAdTrackingEnabled()) ? false : true;
    }

    public String zzyk() {
        m16553s();
        Info t = m16584t();
        CharSequence id = t != null ? t.getId() : null;
        return TextUtils.isEmpty(id) ? null : id;
    }
}
