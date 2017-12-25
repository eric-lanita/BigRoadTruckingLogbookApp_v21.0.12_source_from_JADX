package com.google.android.gms.analytics.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.zzab;
import java.util.UUID;

public class zzai extends zzd {
    private SharedPreferences f10258a;
    private long f10259b;
    private long f10260c = -1;
    private final zza f10261d = new zza("monitoring", m16542i().zzaci());

    public final class zza {
        final /* synthetic */ zzai f10255a;
        private final String f10256b;
        private final long f10257c;

        private zza(zzai com_google_android_gms_analytics_internal_zzai, String str, long j) {
            this.f10255a = com_google_android_gms_analytics_internal_zzai;
            zzab.zzhr(str);
            zzab.zzbo(j > 0);
            this.f10256b = str;
            this.f10257c = j;
        }

        private void m16621b() {
            long currentTimeMillis = this.f10255a.m16539f().currentTimeMillis();
            Editor edit = this.f10255a.f10258a.edit();
            edit.remove(m16625f());
            edit.remove(m16626a());
            edit.putLong(m16624e(), currentTimeMillis);
            edit.commit();
        }

        private long m16622c() {
            long d = m16623d();
            return d == 0 ? 0 : Math.abs(d - this.f10255a.m16539f().currentTimeMillis());
        }

        private long m16623d() {
            return this.f10255a.f10258a.getLong(m16624e(), 0);
        }

        private String m16624e() {
            return String.valueOf(this.f10256b).concat(":start");
        }

        private String m16625f() {
            return String.valueOf(this.f10256b).concat(":count");
        }

        protected String m16626a() {
            return String.valueOf(this.f10256b).concat(":value");
        }

        public Pair<String, Long> zzadv() {
            long c = m16622c();
            if (c < this.f10257c) {
                return null;
            }
            if (c > this.f10257c * 2) {
                m16621b();
                return null;
            }
            String string = this.f10255a.f10258a.getString(m16626a(), null);
            c = this.f10255a.f10258a.getLong(m16625f(), 0);
            m16621b();
            return (string == null || c <= 0) ? null : new Pair(string, Long.valueOf(c));
        }

        public void zzev(String str) {
            if (m16623d() == 0) {
                m16621b();
            }
            if (str == null) {
                str = "";
            }
            synchronized (this) {
                long j = this.f10255a.f10258a.getLong(m16625f(), 0);
                if (j <= 0) {
                    Editor edit = this.f10255a.f10258a.edit();
                    edit.putString(m16626a(), str);
                    edit.putLong(m16625f(), 1);
                    edit.apply();
                    return;
                }
                Object obj = (UUID.randomUUID().getLeastSignificantBits() & Long.MAX_VALUE) < Long.MAX_VALUE / (j + 1) ? 1 : null;
                Editor edit2 = this.f10255a.f10258a.edit();
                if (obj != null) {
                    edit2.putString(m16626a(), str);
                }
                edit2.putLong(m16625f(), j + 1);
                edit2.apply();
            }
        }
    }

    protected zzai(zzf com_google_android_gms_analytics_internal_zzf) {
        super(com_google_android_gms_analytics_internal_zzf);
    }

    protected void mo1605a() {
        this.f10258a = m16540g().getSharedPreferences("com.google.android.gms.analytics.prefs", 0);
    }

    public long zzadn() {
        m16538e();
        m16553s();
        if (this.f10259b == 0) {
            long j = this.f10258a.getLong("first_run", 0);
            if (j != 0) {
                this.f10259b = j;
            } else {
                j = m16539f().currentTimeMillis();
                Editor edit = this.f10258a.edit();
                edit.putLong("first_run", j);
                if (!edit.commit()) {
                    zzek("Failed to commit first run time");
                }
                this.f10259b = j;
            }
        }
        return this.f10259b;
    }

    public zzal zzado() {
        return new zzal(m16539f(), zzadn());
    }

    public long zzadp() {
        m16538e();
        m16553s();
        if (this.f10260c == -1) {
            this.f10260c = this.f10258a.getLong("last_dispatch", 0);
        }
        return this.f10260c;
    }

    public void zzadq() {
        m16538e();
        m16553s();
        long currentTimeMillis = m16539f().currentTimeMillis();
        Editor edit = this.f10258a.edit();
        edit.putLong("last_dispatch", currentTimeMillis);
        edit.apply();
        this.f10260c = currentTimeMillis;
    }

    public String zzadr() {
        m16538e();
        m16553s();
        CharSequence string = this.f10258a.getString("installation_campaign", null);
        return TextUtils.isEmpty(string) ? null : string;
    }

    public zza zzads() {
        return this.f10261d;
    }

    public void zzeu(String str) {
        m16538e();
        m16553s();
        Editor edit = this.f10258a.edit();
        if (TextUtils.isEmpty(str)) {
            edit.remove("installation_campaign");
        } else {
            edit.putString("installation_campaign", str);
        }
        if (!edit.commit()) {
            zzek("Failed to commit campaign data");
        }
    }
}
