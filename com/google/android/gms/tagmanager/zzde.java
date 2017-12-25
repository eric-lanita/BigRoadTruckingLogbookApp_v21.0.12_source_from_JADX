package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Locale;

class zzde implements zzac {
    private final String f12717a;
    private final Context f12718b;
    private final zzb f12719c;
    private final zza f12720d;

    public interface zza {
        void zza(zzar com_google_android_gms_tagmanager_zzar);

        void zzb(zzar com_google_android_gms_tagmanager_zzar);

        void zzc(zzar com_google_android_gms_tagmanager_zzar);
    }

    interface zzb {
        HttpURLConnection zzd(URL url);
    }

    class C34451 implements zzb {
        C34451() {
        }

        public HttpURLConnection zzd(URL url) {
            return (HttpURLConnection) url.openConnection();
        }
    }

    zzde(Context context, zza com_google_android_gms_tagmanager_zzde_zza) {
        this(new C34451(), context, com_google_android_gms_tagmanager_zzde_zza);
    }

    zzde(zzb com_google_android_gms_tagmanager_zzde_zzb, Context context, zza com_google_android_gms_tagmanager_zzde_zza) {
        this.f12719c = com_google_android_gms_tagmanager_zzde_zzb;
        this.f12718b = context.getApplicationContext();
        this.f12720d = com_google_android_gms_tagmanager_zzde_zza;
        this.f12717a = m18189a("GoogleTagManager", "4.00", VERSION.RELEASE, m18188a(Locale.getDefault()), Build.MODEL, Build.ID);
    }

    static String m18188a(Locale locale) {
        if (locale == null || locale.getLanguage() == null || locale.getLanguage().length() == 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(locale.getLanguage().toLowerCase());
        if (!(locale.getCountry() == null || locale.getCountry().length() == 0)) {
            stringBuilder.append("-").append(locale.getCountry().toLowerCase());
        }
        return stringBuilder.toString();
    }

    String m18189a(String str, String str2, String str3, String str4, String str5, String str6) {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{str, str2, str3, str4, str5, str6});
    }

    URL m18190a(zzar com_google_android_gms_tagmanager_zzar) {
        try {
            return new URL(com_google_android_gms_tagmanager_zzar.m18090c());
        } catch (MalformedURLException e) {
            zzbn.m18105e("Error trying to parse the GTM url.");
            return null;
        }
    }

    public void zzai(List<zzar> list) {
        Throwable th;
        InputStream inputStream;
        Object obj;
        Throwable th2;
        Object obj2;
        IOException iOException;
        int min = Math.min(list.size(), 40);
        Object obj3 = 1;
        int i = 0;
        while (i < min) {
            Object obj4;
            zzar com_google_android_gms_tagmanager_zzar = (zzar) list.get(i);
            URL a = m18190a(com_google_android_gms_tagmanager_zzar);
            if (a == null) {
                zzbn.zzcx("No destination: discarding hit.");
                this.f12720d.zzb(com_google_android_gms_tagmanager_zzar);
                obj4 = obj3;
            } else {
                try {
                    HttpURLConnection zzd = this.f12719c.zzd(a);
                    if (obj3 != null) {
                        try {
                            zzbs.zzee(this.f12718b);
                            obj3 = null;
                        } catch (Throwable th3) {
                            th = th3;
                            inputStream = null;
                            obj = obj3;
                            th2 = th;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e) {
                                    obj2 = obj;
                                    iOException = e;
                                }
                            }
                            zzd.disconnect();
                            throw th2;
                        }
                    }
                    zzd.setRequestProperty("User-Agent", this.f12717a);
                    int responseCode = zzd.getResponseCode();
                    InputStream inputStream2 = zzd.getInputStream();
                    if (responseCode != 200) {
                        try {
                            zzbn.zzcx("Bad response: " + responseCode);
                            this.f12720d.zzc(com_google_android_gms_tagmanager_zzar);
                        } catch (Throwable th32) {
                            th = th32;
                            inputStream = inputStream2;
                            obj = obj3;
                            th2 = th;
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            zzd.disconnect();
                            throw th2;
                        }
                    }
                    this.f12720d.zza(com_google_android_gms_tagmanager_zzar);
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                    zzd.disconnect();
                    obj4 = obj3;
                } catch (IOException e2) {
                    iOException = e2;
                    obj2 = obj3;
                    String str = "Exception sending hit: ";
                    String valueOf = String.valueOf(iOException.getClass().getSimpleName());
                    zzbn.zzcx(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                    zzbn.zzcx(iOException.getMessage());
                    this.f12720d.zzc(com_google_android_gms_tagmanager_zzar);
                    obj4 = obj2;
                    i++;
                    obj3 = obj4;
                }
            }
            i++;
            obj3 = obj4;
        }
    }

    public boolean zzcbg() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f12718b.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        zzbn.m18106v("...no network connectivity");
        return false;
    }
}
