package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.internal.zzab;
import com.google.firebase.iid.C3618b;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Locale;

class zzt extends zzaa {
    static final Pair<String, Long> f12344a = new Pair("", Long.valueOf(0));
    public final zzc ajX = new zzc("health_monitor", zzbsf().zzaci());
    public final zzb ajY = new zzb(this, "last_upload", 0);
    public final zzb ajZ = new zzb(this, "last_upload_attempt", 0);
    public final zzb aka = new zzb(this, "backoff", 0);
    public final zzb akb = new zzb(this, "last_delete_stale", 0);
    public final zzb akc = new zzb(this, "midnight_offset", 0);
    public final zzb akh = new zzb(this, "time_before_start", 10000);
    public final zzb aki = new zzb(this, "session_timeout", 1800000);
    public final zza akj = new zza(this, "start_new_session", true);
    public final zzb akk = new zzb(this, "last_pause_time", 0);
    public final zzb akl = new zzb(this, "time_active", 0);
    public boolean akm;
    private SharedPreferences f12345c;
    private String f12346d;
    private boolean f12347e;
    private long f12348f;
    private SecureRandom f12349g;

    public final class zza {
        final /* synthetic */ zzt f12329a;
        private final String f12330b;
        private final boolean f12331c;
        private boolean f12332d;
        private boolean f12333e;

        public zza(zzt com_google_android_gms_measurement_internal_zzt, String str, boolean z) {
            this.f12329a = com_google_android_gms_measurement_internal_zzt;
            zzab.zzhr(str);
            this.f12330b = str;
            this.f12331c = z;
        }

        private void m17913a() {
            if (!this.f12332d) {
                this.f12332d = true;
                this.f12333e = this.f12329a.f12345c.getBoolean(this.f12330b, this.f12331c);
            }
        }

        public boolean get() {
            m17913a();
            return this.f12333e;
        }

        public void set(boolean z) {
            Editor edit = this.f12329a.f12345c.edit();
            edit.putBoolean(this.f12330b, z);
            edit.apply();
            this.f12333e = z;
        }
    }

    public final class zzb {
        final /* synthetic */ zzt f12334a;
        private final String f12335b;
        private final long f12336c;
        private boolean f12337d;
        private long f12338e;

        public zzb(zzt com_google_android_gms_measurement_internal_zzt, String str, long j) {
            this.f12334a = com_google_android_gms_measurement_internal_zzt;
            zzab.zzhr(str);
            this.f12335b = str;
            this.f12336c = j;
        }

        private void m17914a() {
            if (!this.f12337d) {
                this.f12337d = true;
                this.f12338e = this.f12334a.f12345c.getLong(this.f12335b, this.f12336c);
            }
        }

        public long get() {
            m17914a();
            return this.f12338e;
        }

        public void set(long j) {
            Editor edit = this.f12334a.f12345c.edit();
            edit.putLong(this.f12335b, j);
            edit.apply();
            this.f12338e = j;
        }
    }

    public final class zzc {
        final String f12339a;
        final /* synthetic */ zzt f12340b;
        private final String f12341c;
        private final String f12342d;
        private final long f12343e;

        private zzc(zzt com_google_android_gms_measurement_internal_zzt, String str, long j) {
            this.f12340b = com_google_android_gms_measurement_internal_zzt;
            zzab.zzhr(str);
            zzab.zzbo(j > 0);
            this.f12339a = String.valueOf(str).concat(":start");
            this.f12341c = String.valueOf(str).concat(":count");
            this.f12342d = String.valueOf(str).concat(":value");
            this.f12343e = j;
        }

        private void m17915a() {
            this.f12340b.zzwu();
            long currentTimeMillis = this.f12340b.zzyw().currentTimeMillis();
            Editor edit = this.f12340b.f12345c.edit();
            edit.remove(this.f12341c);
            edit.remove(this.f12342d);
            edit.putLong(this.f12339a, currentTimeMillis);
            edit.apply();
        }

        private long m17916b() {
            this.f12340b.zzwu();
            long c = m17917c();
            if (c != 0) {
                return Math.abs(c - this.f12340b.zzyw().currentTimeMillis());
            }
            m17915a();
            return 0;
        }

        private long m17917c() {
            return this.f12340b.m17922m().getLong(this.f12339a, 0);
        }

        public Pair<String, Long> zzadv() {
            this.f12340b.zzwu();
            long b = m17916b();
            if (b < this.f12343e) {
                return null;
            }
            if (b > this.f12343e * 2) {
                m17915a();
                return null;
            }
            String string = this.f12340b.m17922m().getString(this.f12342d, null);
            b = this.f12340b.m17922m().getLong(this.f12341c, 0);
            m17915a();
            return (string == null || b <= 0) ? zzt.f12344a : new Pair(string, Long.valueOf(b));
        }

        public void zzev(String str) {
            zzh(str, 1);
        }

        public void zzh(String str, long j) {
            this.f12340b.zzwu();
            if (m17917c() == 0) {
                m17915a();
            }
            if (str == null) {
                str = "";
            }
            long j2 = this.f12340b.f12345c.getLong(this.f12341c, 0);
            if (j2 <= 0) {
                Editor edit = this.f12340b.f12345c.edit();
                edit.putString(this.f12342d, str);
                edit.putLong(this.f12341c, j);
                edit.apply();
                return;
            }
            Object obj = (this.f12340b.m17921l().nextLong() & Long.MAX_VALUE) < (Long.MAX_VALUE / (j2 + j)) * j ? 1 : null;
            Editor edit2 = this.f12340b.f12345c.edit();
            if (obj != null) {
                edit2.putString(this.f12342d, str);
            }
            edit2.putLong(this.f12341c, j2 + j);
            edit2.apply();
        }
    }

    zzt(zzx com_google_android_gms_measurement_internal_zzx) {
        super(com_google_android_gms_measurement_internal_zzx);
    }

    private SecureRandom m17921l() {
        zzwu();
        if (this.f12349g == null) {
            this.f12349g = new SecureRandom();
        }
        return this.f12349g;
    }

    private SharedPreferences m17922m() {
        zzwu();
        m17715c();
        return this.f12345c;
    }

    Pair<String, Boolean> m17923a(String str) {
        zzwu();
        long elapsedRealtime = zzyw().elapsedRealtime();
        if (this.f12346d != null && elapsedRealtime < this.f12348f) {
            return new Pair(this.f12346d, Boolean.valueOf(this.f12347e));
        }
        this.f12348f = elapsedRealtime + zzbsf().m17829a(str);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(getContext());
            this.f12346d = advertisingIdInfo.getId();
            if (this.f12346d == null) {
                this.f12346d = "";
            }
            this.f12347e = advertisingIdInfo.isLimitAdTrackingEnabled();
        } catch (Throwable th) {
            zzbsd().zzbtb().zzj("Unable to get advertising id", th);
            this.f12346d = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair(this.f12346d, Boolean.valueOf(this.f12347e));
    }

    void m17924a(boolean z) {
        zzwu();
        zzbsd().zzbtc().zzj("Setting useService", Boolean.valueOf(z));
        Editor edit = m17922m().edit();
        edit.putBoolean("use_service", z);
        edit.apply();
    }

    String m17925b(String str) {
        String str2 = (String) m17923a(str).first;
        if (zzal.m17811c("MD5") == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, zzal.m17811c("MD5").digest(str2.getBytes()))});
    }

    void m17926b(boolean z) {
        zzwu();
        zzbsd().zzbtc().zzj("Setting measurementEnabled", Boolean.valueOf(z));
        Editor edit = m17922m().edit();
        edit.putBoolean("measurement_enabled", z);
        edit.apply();
    }

    void m17927c(String str) {
        zzwu();
        Editor edit = m17922m().edit();
        edit.putString("gmp_app_id", str);
        edit.apply();
    }

    boolean m17928c(boolean z) {
        zzwu();
        return m17922m().getBoolean("measurement_enabled", z);
    }

    protected void mo2375d() {
        this.f12345c = getContext().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.akm = this.f12345c.getBoolean("has_been_opened", false);
        if (!this.akm) {
            Editor edit = this.f12345c.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
    }

    String m17930e() {
        m17921l().nextBytes(new byte[16]);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, r0)});
    }

    String m17931f() {
        zzwu();
        return C3618b.m18904a().m18905b();
    }

    long m17932g() {
        m17715c();
        zzwu();
        long j = this.akc.get();
        if (j != 0) {
            return j;
        }
        j = (long) (m17921l().nextInt(86400000) + 1);
        this.akc.set(j);
        return j;
    }

    String m17933h() {
        zzwu();
        return m17922m().getString("gmp_app_id", null);
    }

    Boolean m17934i() {
        zzwu();
        return !m17922m().contains("use_service") ? null : Boolean.valueOf(m17922m().getBoolean("use_service", false));
    }

    void m17935j() {
        boolean z = true;
        zzwu();
        zzbsd().zzbtc().log("Clearing collection preferences.");
        boolean contains = m17922m().contains("measurement_enabled");
        if (contains) {
            z = m17928c(true);
        }
        Editor edit = m17922m().edit();
        edit.clear();
        edit.apply();
        if (contains) {
            m17926b(z);
        }
    }

    protected String m17936k() {
        zzwu();
        String string = m17922m().getString("previous_os_version", null);
        String zzbso = zzbrw().zzbso();
        if (!(TextUtils.isEmpty(zzbso) || zzbso.equals(string))) {
            Editor edit = m17922m().edit();
            edit.putString("previous_os_version", zzbso);
            edit.apply();
        }
        return string;
    }
}
